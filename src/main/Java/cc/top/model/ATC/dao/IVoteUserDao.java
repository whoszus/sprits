package cc.top.model.ATC.dao;

import cc.top.model.ATC.entity.VoteUser;

/**
 * Created by Lr on 2016/4/16/016.
 */
public interface IVoteUserDao {
    public VoteUser login(VoteUser user);
    public void regist(VoteUser user);
    public VoteUser selectbyAP(VoteUser user);

}
