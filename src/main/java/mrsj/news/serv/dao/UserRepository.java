package mrsj.news.serv.dao;

import mrsj.news.serv.model.News;
import mrsj.news.serv.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/22 13:54
 * @github https://github.com/Seymour1996
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

    Page<User> findAll(Pageable pageable);
}
