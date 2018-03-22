package mrsj.news.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mrsj.news.NewsApplication;
import mrsj.news.serv.dao.NewsKeywordRepository;
import mrsj.news.serv.dao.NewsRepository;
import mrsj.news.serv.model.News;
import mrsj.news.serv.model.NewsKeyword;
import mrsj.news.tools.JsoupUtils;
import mrsj.news.tools.TimeUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/21 12:47
 * @github https://github.com/Seymour1996
 */
@Component
@Log4j2
@AllArgsConstructor
public class NewsCrawler {
    private final static String LIST_API="http://www.textvalve.com/htdatasub/subscribe/articles/toPublish/v2?userId=82&size=100&rnd0.456121920803368&page=";
    private final static String DETAIL_API="http://www.textvalve.com/htdatasub/subscribe/articles/v2/article-";
    public static String type = null;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    NewsKeywordRepository newsKeywordRepository;
    @Autowired
    NewsRepository newsRepository;

    @Scheduled(fixedRate = 60*20*1000)
    public void start() {
        try {
            for (int count = 1; count <= 9; count++) {
                JSONObject newsList = JsoupUtils.getJSON(LIST_API + "" + count);
                JSONArray list = newsList.getJSONObject("data").getJSONArray("list");
                for (Object object : list) {
                    JSONObject jsonObject = JSONObject.parseObject(object.toString());
                    News news = new News();
                    news.setDescription(jsonObject.get("description").toString());
                    news.setId(Long.parseLong(jsonObject.get("id").toString()));
                    news.setImageList(jsonObject.get("image_list").toString());
                    news.setSourceSite(jsonObject.get("source_site").toString());
                    news.setSourceUrl(jsonObject.get("source_url").toString());
                    news.setTitle(jsonObject.get("title").toString());
                    news.setTime(TimeUtils.DatestampToDate(jsonObject.get("crawl_time").toString()));
                    JSONObject detail = JsoupUtils.getJSON(DETAIL_API + "" + news.getId());
                    String content = detail.getJSONObject("data").get("content").toString();
                    news.setContent(content);
                    //cnn分类
                    stringRedisTemplate.convertAndSend("content", news.getContent());
                    while (type == null) {
                        sleep(100);
                    }
                    JSONObject data = JSON.parseObject(type);
                    news.setCategory(data.getString("type"));
                    JSONArray keywords = data.getJSONArray("keywords");
                    for (Object o : keywords){
                        NewsKeyword newsKeyword =new NewsKeyword();
                        String key[] = o.toString().split(",");
                        String key1 = key[0].substring(2,key[0].length()-1);
                        double weight = Double.parseDouble(key[1].substring(0,key[1].length()-1));
                        newsKeyword.setKeyword(key1);
                        newsKeyword.setNewsId(news.getId());
                        newsKeyword.setWeight(weight);
                        newsKeywordRepository.save(newsKeyword);
                    }
                    System.out.println("id:" +news.getId()+" "+type);
                    type = null;
                    newsRepository.save(news);
                }
                System.out.println("page:" + count + " crawled");
            }
            System.out.println("finish");
        }catch (Exception e){}
    }

}
