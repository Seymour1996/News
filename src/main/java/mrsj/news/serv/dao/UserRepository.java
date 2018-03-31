package mrsj.news.serv.dao;

import mrsj.news.serv.model.News;
import mrsj.news.serv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/22 13:54
 * @github https://github.com/Seymour1996
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
