package cc.top.model.service.impl;

import cc.top.fundation.base.BaseDao;
import cc.top.model.dao.IUserDao;
import cc.top.model.mapper.UserMapper;
import cc.top.model.entity.User;
import cc.top.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by linyanying on 2015/12/30.
 */
@Service("userService")
public class IUserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    public User getUser(User user) {
        return userDao.getUser(user);
    }
}
