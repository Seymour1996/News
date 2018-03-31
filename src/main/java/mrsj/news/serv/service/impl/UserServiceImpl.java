package mrsj.news.serv.service.impl;

import mrsj.news.serv.dao.UserRepository;
import mrsj.news.serv.model.User;
import mrsj.news.serv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 9:21
 * @github https://github.com/Seymour1996
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(User user){
        if(userRepository.findByUsername(user.getUsername())!=null) return "用户名已存在";
        User user1 =userRepository.save(user);
        if(user1==null) return "error";
        else return "success";
    }
    @Override
    public User findByUserId(Long userId){
        User user=userRepository.findById(userId).get();
        return user;
    }
}
