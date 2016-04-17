package cc.top.model.ATC.service;

import cc.top.model.ATC.entity.Result;
import cc.top.model.ATC.entity.Vote;
import cc.top.model.ATC.entity.VoteList;

import java.util.List;

/**
 * Created by Lr on 2016/4/16/016.
 */
public interface IVoteService {
    public List<VoteList> getAll();
    public void addVote(Vote v);
    public void addResult(Result r);
    public void updateReslut(Result r);
    public Result selectByVIdAndMId(Result r);
    public void saveResultByUserVote(Vote v);
    public Vote selectByUIdAndVId(Vote v);
    public List<Result> getResult(int voteId);
    public void addVoteList(VoteList voteList);
}
