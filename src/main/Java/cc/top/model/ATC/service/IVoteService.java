package cc.top.model.ATC.service;

import cc.top.model.ATC.dto.voteResult;
import cc.top.model.ATC.entity.Mechine;
import cc.top.model.ATC.entity.Result;
import cc.top.model.ATC.entity.Vote;
import cc.top.model.ATC.entity.VoteList;

import java.util.List;

/**
 * Created by Lr on 2016/4/16/016.
 */
public interface IVoteService {
    /**
     * 获取所有的VoteList
     * @return
     */
    public List<VoteList> getAll();

    /**
     * 添加一次投票
     * @param v
     */
    public void addVote(Vote v);

    /**
     * 添加投票结果
     * @param r
     */
    public void addResult(Result r);

    /**
     * 更新投票结果
     * @param r
     */
    public void updateReslut(Result r);

    /**
     * 通过投票的id和设备的id查找某次投票结果
     * @param r
     * @return
     */
    public Result selectByVIdAndMId(Result r);

    /**
     * 保存用户的投票结果
     * @param v
     */
    public void saveResultByUserVote(Vote v);

    /**
     * 通过用户id和投票列表id查找某次用户投票
     * @param v
     * @return
     */
    public Vote selectByUIdAndVId(Vote v);

    /**
     * 增加一个投票列表
     * @param voteList
     */
    public void addVoteList(VoteList voteList);

    /**
     * 更新某个用户的投票
     * @param model
     * @param v
     */
    public void updateVote(Vote model, Vote v);

    /**
     * 显示所有的设备
     * @return
     */
    public List<Mechine> getMechines();

    /**
     * 得到最终的=投票结果信息
     * @param voteId
     * @return
     */
    public List<voteResult> getResultInfo(int voteId);

    /**
     * 通过VoteList中的VoteId 查找某个投票列表
     * @param voteId
     * @return
     */
    public VoteList findByVoteId(int voteId);

    /**
     * 判断某个投票列表是否存在通过类表名称
     * @param name
     * @return
     */
    public boolean IsFindVoteListByName(String name);

}
