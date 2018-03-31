package mrsj.news.serv.service;

import mrsj.news.serv.model.UserAction;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 8:12
 * @github https://github.com/Seymour1996
 */
public interface UserActionService {
    UserAction findByUserIdAndNewsIdAndType(Long userId,Long newsId,Integer type);

    Boolean delete(UserAction userAction);

    UserAction save(UserAction userAction);

    List<UserAction> findByUserId(Long userId);
}
