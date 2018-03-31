package mrsj.news.serv.service;

import mrsj.news.serv.dao.NewsRepository;
import mrsj.news.serv.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/30 10:15
 * @github https://github.com/Seymour1996
 */
public interface NewsService {
    List<News> findNews(String category,int page,int size);

    News findById(Long id);

    News save(News news);
}
