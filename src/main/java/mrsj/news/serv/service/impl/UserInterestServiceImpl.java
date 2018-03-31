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
public class UserInterestServiceImpl implements UserInterestService {
    @Autowired
    private UserInterestRepository userInterestRepository;

    @Override
    public List<UserInterest> findByUserId(Long userId) {
        List<UserInterest> userInterests = userInterestRepository.findByUserId(userId);
        return userInterests;
    }

    @Override
    public UserInterest save(UserInterest userInterest) {
        UserInterest userInterest1 = userInterestRepository.findByUserIdAndKeyword(userInterest.getUserId(), userInterest.getKeyword());
        if (userInterest1 == null) {
            userInterest.setKeyword(userInterest.getKeyword());
            userInterest.setUserId(userInterest.getUserId());
            userInterest.setWeight(userInterest.getWeight());
            userInterestRepository.save(userInterest);
            return userInterest;
        } else {
            userInterest1.setWeight(userInterest1.getWeight() + userInterest.getWeight());
            userInterestRepository.save(userInterest1);
            return userInterest1;
        }
    }
}

