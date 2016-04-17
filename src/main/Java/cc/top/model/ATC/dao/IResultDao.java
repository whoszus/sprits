package cc.top.model.ATC.dao;

import cc.top.model.ATC.entity.Result;

import java.util.List;

/**
 * Created by Lr on 2016/4/16/016.
 */
public interface IResultDao {
    public void addResult(Result r);
    public void updateReslut(Result r);
    public Result selectByVIdAndMId(Result r);
    public List<Result> getResult(int voteId);
}
