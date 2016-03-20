package cc.top.model.TestModel.service.impl;

import cc.top.model.TestModel.dao.UserDao;
import cc.top.model.TestModel.entity.User;
import cc.top.model.TestModel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by linyanying on 2015/12/30.
 */
@Service("userService")
public class IUserServiceImpl implements IUserService{
    @Autowired private UserDao userDao;

    public User getUser(User user) {
        return userDao.getUser(user);
    }

    public User getUserbyId(String id) {
        return userDao.getUserbyId(id);
    }
}
