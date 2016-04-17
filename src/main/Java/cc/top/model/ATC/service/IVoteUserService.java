package cc.top.model.ATC.service;

import cc.top.model.ATC.entity.Result;
import cc.top.model.ATC.entity.VoteUser;

/**
 * Created by Lr on 2016/4/16/016.
 */
public interface IVoteUserService {
    public VoteUser login(VoteUser user);
    public void addUser(VoteUser user);
    public VoteUser selectbyAP(VoteUser user);

}
