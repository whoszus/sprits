package cc.top.model.ATC.dao;

import cc.top.model.ATC.entity.Vote;
import cc.top.model.ATC.entity.VoteList;

import java.util.List;

/**
 * Created by Lr on 2016/4/16/016.
 */
public interface IVoteListDao {
    public List<VoteList> getAll();
    public VoteList selectById(int id);
    public void addVoteList(VoteList voteList);

    public VoteList findByName(String name);
}
