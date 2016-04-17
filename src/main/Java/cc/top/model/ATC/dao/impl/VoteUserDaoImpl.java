package cc.top.model.ATC.dao.impl;

import cc.top.fundation.BASEDAO.BaseDaoImpl;
import cc.top.model.ATC.dao.IVoteUserDao;
import cc.top.model.ATC.entity.VoteUser;
import org.springframework.stereotype.Repository;

/**
 * Created by Lr on 2016/4/16/016.
 */
@Repository
public class VoteUserDaoImpl extends BaseDaoImpl<VoteUser> implements IVoteUserDao {

    public VoteUser login(VoteUser user) {
        return getSqlSession().selectOne("voteUser.login",user);
    }

    public void regist(VoteUser user) {
         getSqlSession().insert("voteUser.regist",user);
    }

    public VoteUser selectbyAP(VoteUser user) {
        return getSqlSession().selectOne("voteUser.selectbyAP",user);
    }
}

