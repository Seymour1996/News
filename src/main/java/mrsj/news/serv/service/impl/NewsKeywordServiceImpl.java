package mrsj.news.serv.service.impl;

import mrsj.news.serv.dao.NewsKeywordRepository;
import mrsj.news.serv.model.NewsKeyword;
import mrsj.news.serv.service.NewsKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<NewsKeyword> findByNewsId(Long newsId){
        return newsKeywordRepository.findByNewsId(newsId);
    }
}
