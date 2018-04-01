package mrsj.news.serv.service;

import mrsj.news.serv.model.User;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 9:19
 * @github https://github.com/Seymour1996
 */
public interface UserService {
    String save(User user);
    User findByUserId(Long userId);
    List<User> findUser(int page, int size);
    boolean delete(Long id);
    void update(User user);
}
