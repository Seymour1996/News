package mrsj.news.serv.service.impl;

import mrsj.news.serv.dao.UserRepository;
import mrsj.news.serv.model.User;
import mrsj.news.serv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void update(User user){
        User user1 =userRepository.save(user);
    }
    @Override
    public User findByUserId(Long userId){
        User user=userRepository.findById(userId).get();
        return user;
    }
    @Override
    public List<User> findUser(int page, int size){
        Sort sort = new Sort(Sort.Direction.ASC,"id"); //创建时间降序排序
        Pageable pageable = new PageRequest(page,size,sort);
        List<User> users=userRepository.findAll(pageable).getContent();
        return users;
    }
    @Override
    public boolean delete(Long id){
        try {
            userRepository.delete(userRepository.getOne(id));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
