package mrsj.news.serv.service.impl;

import mrsj.news.serv.dao.NewsRepository;
import mrsj.news.serv.model.News;
import mrsj.news.serv.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/30 10:16
 * @github https://github.com/Seymour1996
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Override
    public List<News> findNews(String category,int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC,"time"); //创建时间降序排序
        Pageable pageable = new PageRequest(page,size,sort);
        List<News> news =newsRepository.findByCategory(category,pageable);
        return news;
    }
    @Override
    public News findById(Long id){
        return newsRepository.findById(id).get();
    }
}
