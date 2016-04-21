package cc.top.model.ATC.dao;

import cc.top.model.ATC.entity.Vote;

/**
 * Created by Zus on 4/9/16.
 */
public interface IVoteDao {

    public void addVote(Vote v);
    public Vote selectByUIdAndVId(Vote v);

    public void updateVote(Vote v);
}
