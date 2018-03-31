package mrsj.news.serv.service.impl;

import mrsj.news.serv.dao.UserActionRepository;
import mrsj.news.serv.model.UserAction;
import mrsj.news.serv.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Seymour
 * @version 1.0.0
 * @create 2018/3/31 8:12
 * @github https://github.com/Seymour1996
 */
@Service
public class UserActionServiceImpl implements UserActionService{
    @Autowired
    private UserActionRepository userActionRepository;

    @Override
    public UserAction findByUserIdAndNewsIdAndType(Long userId, Long newsId, Integer type)
    {
        UserAction userAction=userActionRepository.findByUserIdAndNewsIdAndType(userId,newsId,type);
        return userAction;
    }
    @Override
    public Boolean delete(UserAction userAction){
        try{
            userActionRepository.delete(userAction);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public UserAction save(UserAction userAction){
        UserAction userAction1=userActionRepository.save(userAction);
        return userAction1;
    }

    @Override
    public List<UserAction> findByUserId(Long userId){
        List<UserAction> userActions = userActionRepository.findByUserId(userId);
        return userActions;
    }

}
