package mrsj.news.controller;

import mrsj.news.serv.model.News;
import mrsj.news.serv.model.UserAction;
import mrsj.news.serv.service.NewsService;
import mrsj.news.serv.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 8:12
 * @github https://github.com/Seymour1996
 */
@Controller
public class UserActionController {
    @Autowired
    private UserActionService userActionService;
    @Autowired
    private NewsService newsService;
    @PostMapping("/addAction")
    @ResponseBody
    public String addUserAction(Long userId,Long newsId,Integer type){
        UserAction userAction=new UserAction();
        News news=newsService.findById(newsId);
        switch(type){
            case 0:news.setReadNum(news.getReadNum()+1);break;
            case 1:news.setLikeNum(news.getLikeNum()+1);break;
            case 2:news.setDislikeNum(news.getDislikeNum()+1);
        }
        userAction.setUserId(userId);
        userAction.setNewsId(newsId);
        userAction.setType(type);
        userAction.setTime(new Date());
        UserAction userAction1 = userActionService.save(userAction);
        News news1 =newsService.save(news);
        if(userAction1 !=null&&news1!=null) return "success";
        else return "error";
    }

    @PostMapping("findAction")
    @ResponseBody
    public String findUserAction(Long userId,Long newsId,Integer type){
        UserAction userAction = userActionService.findByUserIdAndNewsIdAndType(userId,newsId,type);
        if(userAction !=null) return "true";
        else return "false";
    }

    @PostMapping("findActions")
    @ResponseBody
    public List<UserAction> findUserActions(Long userId){
        List<UserAction> userActions = userActionService.findByUserId(userId);
        return userActions;
    }
}
