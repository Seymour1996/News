package mrsj.news.controller;

import mrsj.news.serv.model.*;
import mrsj.news.serv.service.*;
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
    @Autowired
    private UserService userService;
    @Autowired
    private NewsKeywordService newsKeywordService;
    @Autowired
    private UserInterestService userInterestService;
    @PostMapping("/addAction")
    @ResponseBody
    public String addUserAction(Long userId,Long newsId,Integer type){
        UserAction userAction=new UserAction();
        News news=newsService.findById(newsId);
        User user=userService.findByUserId(userId);
        List<NewsKeyword> newsKeywords=newsKeywordService.findByNewsId(newsId);
        if(type ==1||type==0) {
            switch (news.getCategory()) {
                case "教育":
                    user.setEducation(user.getEducation() + 1);
                    break;
                case "娱乐":
                    user.setEntertainment(user.getEntertainment() + 1);
                    break;
                case "时尚":
                    user.setFashion(user.getFashion() + 1);
                    break;
                case "金融":
                    user.setFinance(user.getFinance() + 1);
                    break;
                case "游戏":
                    user.setGame(user.getGame() + 1);
                    break;
                case "家居":
                    user.setHome(user.getHome() + 1);
                    break;
                case "房产":
                    user.setHouse(user.getHouse() + 1);
                    break;
                case "政治":
                    user.setPolitics(user.getPolitics());
                    break;
                case "科技":
                    user.setTechnology(user.getTechnology() + 1);
                    break;
                case "体育":
                    user.setSports(user.getSports() + 1);
            }
            for(NewsKeyword newsKeyword:newsKeywords){
                UserInterest userInterest=new UserInterest();
                userInterest.setUserId(user.getId());
                userInterest.setKeyword(newsKeyword.getKeyword());
                userInterest.setWeight(newsKeyword.getWeight());
                userInterestService.save(userInterest);
            }
        }
        else
            switch(news.getCategory()){
                case "教育":user.setEducation(user.getEducation()-1);break;
                case "娱乐":user.setEntertainment(user.getEntertainment()-1);break;
                case "时尚":user.setFashion(user.getFashion()-1);break;
                case "金融":user.setFinance(user.getFinance()-1);break;
                case "游戏":user.setGame(user.getGame()-1);break;
                case "家居":user.setHome(user.getHome()-1);break;
                case "房产":user.setHouse(user.getHouse()-1);break;
                case "政治":user.setPolitics(user.getPolitics()-1);break;
                case "科技":user.setTechnology(user.getTechnology()-1);break;
                case "体育":user.setSports(user.getSports()-1);
            }
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
