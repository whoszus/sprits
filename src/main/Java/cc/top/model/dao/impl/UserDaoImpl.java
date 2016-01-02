package cc.top.model.dao.impl;

import cc.top.model.dao.IUserDao;
import cc.top.model.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by linyanying on 2015/12/30.
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao{

    public User getUser(User user) {
//        return getSqlSession().selectOne("UserMapper.Select",user);
        return null;
    }
}
