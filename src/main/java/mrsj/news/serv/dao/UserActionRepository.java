package mrsj.news.serv.dao;

import mrsj.news.serv.model.News;
import mrsj.news.serv.model.UserAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/22 13:54
 * @github https://github.com/Seymour1996
 */
public interface UserActionRepository extends JpaRepository<UserAction,Long> {
    UserAction findByUserIdAndNewsIdAndType(Long userId,Long newsId,int type);

    void delete(UserAction userAction);

    List<UserAction> findByUserId(Long userId);
}
