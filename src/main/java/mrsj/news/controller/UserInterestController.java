package mrsj.news.controller;

import mrsj.news.serv.model.UserInterest;
import mrsj.news.serv.service.UserInterestService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 9:43
 * @github https://github.com/Seymour1996
 */
@Controller
public class UserInterestController {
    @Autowired
    private UserInterestService userInterestService;

    @GetMapping("/findInterests")
    @ResponseBody
    public List<UserInterest> findInterest(Long userId){
        return userInterestService.findByUserId(userId);
    }
}
