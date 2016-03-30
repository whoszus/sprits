package cc.top.model.TestModel.dao.impl;

import cc.top.fundation.BASEDAO.BaseDaoImpl;
import cc.top.model.TestModel.dao.UserDao;
import cc.top.model.TestModel.entity.User;
import org.springframework.stereotype.Repository;


/**
 * Created by linyanying on 2015/12/30.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public User getUser(User user) {
//        return getSqlSession().selectOne("UserMapper.Select",user);
        User user1 = getSqlSession().selectOne("user.selectById",user);
        return getSqlSession().selectOne("user.selectById",user);

    }

    public User getUserbyId(String id) {
        return getSqlSession().selectOne("user.selectById",id);
    }

}
