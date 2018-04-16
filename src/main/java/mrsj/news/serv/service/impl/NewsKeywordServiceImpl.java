package mrsj.news.serv.service.impl;

import mrsj.news.serv.dao.NewsKeywordRepository;
import mrsj.news.serv.dao.NewsRepository;
import mrsj.news.serv.model.News;
import mrsj.news.serv.model.NewsKeyword;
import mrsj.news.serv.service.NewsKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 10:47
 * @github https://github.com/Seymour1996
 */
@Service
public class NewsKeywordServiceImpl implements NewsKeywordService {
    @Autowired
    private NewsKeywordRepository newsKeywordRepository;
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<NewsKeyword> findByNewsId(Long newsId){
        return newsKeywordRepository.findByNewsId(newsId);
    }

    @Override
    public List<News> findNewsByKeyword(String keyword, int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC,"weight"); //创建权重降序排序
        Pageable pageable = new PageRequest(page,size,sort);
        List<NewsKeyword> newsKeywords=newsKeywordRepository.findByKeyword(keyword,pageable);
        System.out.println(newsKeywords);
        List<News> news=new ArrayList<>();
        for(NewsKeyword newsKeyword:newsKeywords){
            News news1=newsRepository.findById(newsKeyword.getNewsId()).get();
            news.add(news1);
            System.out.println(news1);
        }
        return news;
    }
}
