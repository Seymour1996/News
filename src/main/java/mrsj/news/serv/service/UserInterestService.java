package mrsj.news.serv.service;

import mrsj.news.serv.model.UserInterest;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 9:35
 * @github https://github.com/Seymour1996
 */
public interface UserInterestService {
    List<UserInterest> findByUserId(Long userId);
}
