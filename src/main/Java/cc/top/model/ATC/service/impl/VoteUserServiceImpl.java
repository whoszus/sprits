package cc.top.model.ATC.service.impl;

import cc.top.model.ATC.dao.impl.VoteUserDaoImpl;
import cc.top.model.ATC.entity.VoteUser;
import cc.top.model.ATC.service.IVoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lr on 2016/4/16/016.
 */
@Service("vUserService")
public class VoteUserServiceImpl implements IVoteUserService {
    @Autowired
    private VoteUserDaoImpl userDao;

    public VoteUser login(VoteUser user) {
        return userDao.login(user);
    }

    public void addUser(VoteUser user) {
        userDao.regist(user);
    }

    public VoteUser selectbyAP(VoteUser user) {
        return userDao.selectbyAP(user);
    }


}
