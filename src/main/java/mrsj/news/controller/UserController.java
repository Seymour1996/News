package mrsj.news.controller;

import com.alibaba.fastjson.JSONArray;
import mrsj.news.serv.model.User;
import mrsj.news.serv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String register(String username,String password,String email,String nickname,String phone){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPhone(phone);
        return userService.save(user);
    }
    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers(@RequestParam int page,@RequestParam int size){
        List<User> users=userService.findUser(page,size);
        return users;
    }
    @RequestMapping("/table")
    public String getTable(){
        return "tables";
    }
    @PostMapping("/user/delete")
    @ResponseBody
    public boolean delete(Long id){
        boolean result = userService.delete(id);
        return result;
    }

    @GetMapping("/user")
    @ResponseBody
    public User getUser(Long id){
        return userService.findByUserId(id);
    }

    @PostMapping("/user/update")
    @ResponseBody
    public String update(Long id,String nickname,String password,String email,String phone){
        try {
            User user = userService.findByUserId(id);
            user.setPhone(phone);
            user.setNickname(nickname);
            user.setEmail(email);
            user.setPassword(password);
            userService.update(user);
            return "success";
        }catch(Exception e){
            return "error";
        }
    }

}
