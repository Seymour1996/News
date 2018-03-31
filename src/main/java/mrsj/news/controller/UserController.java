package mrsj.news.controller;

import mrsj.news.serv.model.User;
import mrsj.news.serv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 9:27
 * @github https://github.com/Seymour1996
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public String register(String username,String password,String email){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userService.save(user);
    }
}
