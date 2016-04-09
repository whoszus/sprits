package cc.top.model.ATC.service;

import cc.top.model.ATC.entity.Vote;

/**
 * Created by Zus on 4/9/16.
 */
public interface VoteService {
    public Vote getMechine(Vote vote);
    public void updateVote(Vote vote);


}
