package mrsj.news.serv.service;

import mrsj.news.serv.model.NewsKeyword;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 10:47
 * @github https://github.com/Seymour1996
 */
public interface NewsKeywordService {
    List<NewsKeyword> findByNewsId(Long newsId);
}
