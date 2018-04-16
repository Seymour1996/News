package mrsj.news.controller;

import mrsj.news.serv.model.News;
import mrsj.news.serv.service.NewsKeywordService;
import mrsj.news.serv.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/30 10:54
 * @github https://github.com/Seymour1996
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsKeywordService newsKeywordService;

    @GetMapping("/news")
    @ResponseBody
    public List<News> getNews(@RequestParam String keyword,@RequestParam int page,@RequestParam int size){
        List<News> news= newsKeywordService.findNewsByKeyword(keyword,page,size);
        return news;
    }

    @GetMapping("/news/detail")
    @ResponseBody
    public News getANews(@RequestParam Long id){
        News news= newsService.findById(id);
        return news;
    }
}
