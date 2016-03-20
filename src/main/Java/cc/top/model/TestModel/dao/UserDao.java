package cc.top.model.TestModel.dao;

import cc.top.model.TestModel.entity.User;

/**
 * Created by linyanying on 2015/12/30.
 */
public interface UserDao {
    public User getUser(User user);
    public User getUserbyId(String id);

}
