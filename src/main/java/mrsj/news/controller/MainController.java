package mrsj.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/4/1 18:35
 * @github https://github.com/Seymour1996
 */
@Controller
public class MainController {
    @PostMapping("/login")
    public void login(String username,String password,HttpServletResponse response)throws IOException {
        if(username.equals("Mrs.J")&&password.equals("123456")){
            response.sendRedirect("/index.html");
        }
        else
        {
            response.sendRedirect("/relogin.html");
        }
    }
}
