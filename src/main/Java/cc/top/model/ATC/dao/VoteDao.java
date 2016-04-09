package cc.top.model.ATC.dao;

import cc.top.model.ATC.entity.Vote;

/**
 * Created by Zus on 4/9/16.
 */
public interface VoteDao {

    public Vote getMechine(Vote vote);
    public void updateVote(Vote vote);
}
