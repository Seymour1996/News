package mrsj.news.serv.service.impl;

import mrsj.news.serv.dao.UserInterestRepository;
import mrsj.news.serv.model.UserInterest;
import mrsj.news.serv.service.UserInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 9:36
 * @github https://github.com/Seymour1996
 */
@Service
public class UserInterestServiceImpl implements UserInterestService{
    @Autowired
    private UserInterestRepository userInterestRepository;

    @Override
    public List<UserInterest> findByUserId(Long userId){
        List<UserInterest> userInterests=userInterestRepository.findByUserId(userId);
        return userInterests;
    }

}
