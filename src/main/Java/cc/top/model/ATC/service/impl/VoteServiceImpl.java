package cc.top.model.ATC.service.impl;

import cc.top.model.ATC.dao.impl.ResultDaoImpl;
import cc.top.model.ATC.dao.impl.VoteDaoImpl;
import cc.top.model.ATC.dao.impl.VoteListDaoImpl;
import cc.top.model.ATC.entity.Result;
import cc.top.model.ATC.entity.Vote;
import cc.top.model.ATC.entity.VoteList;
import cc.top.model.ATC.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lr on 2016/4/16/016.
 */
@Service("voteListService")
public class VoteServiceImpl implements IVoteService {
    @Autowired
    private VoteListDaoImpl voteListDao;
    @Autowired
    private ResultDaoImpl resultDao;
    @Autowired
    private VoteDaoImpl voteDao;

    public List<VoteList> getAll(){
        return voteListDao.getAll();
    }

    public void addVote(Vote v) {
        voteDao.addVote(v);
    }

    public void addResult(Result r) {
      resultDao.addResult(r);
    }

    public void updateReslut(Result r) {
        resultDao.updateReslut(r);
    }
    public Result selectByVIdAndMId(Result r){
        return resultDao.selectByVIdAndMId(r);
    }

    /**
     * 分析用户的投票，并分别存到数据库中
     * @param v
     *
     */
    public void saveResultByUserVote(Vote v) {

       Result temp = new Result();

        int voteId = v.getVoteId();
        temp.setVoteId(voteId);

        String resultStr=v.getResult();
        VoteList voteList = voteListDao.selectById(voteId);

        for(int i=1;i<=resultStr.length();i++){
            System.out.println(i);

            temp.setMechineId(i);
            Result r = resultDao.selectByVIdAndMId(temp);

            if(r == null){//等于空说明是第一个投票，应该插入数据库

                Result r1 = new Result();
                int rate = Integer.parseInt(String.valueOf(resultStr.charAt(i-1)));

                if(rate == 0){
                    continue;
                }
                r1.setRate(rate);
                r1.setVoteId(voteId);

                r1.setMechineId(i);//机器id
                r1.setVoteName(voteList.getVoteName());//投票名



                r1.setCount(1); //人数变为1
                resultDao.addResult(r1);
            }
            else{//说明不是第一次投票，只需要更新相应的记录

                //得到用户的投票
                int t = Integer.parseInt(String.valueOf(resultStr.charAt(i-1)));

                if(t==0){
                    continue;
                }

                float rate = r.getRate();

                r.setRate(t+rate);

                int count = r.getCount();//数量
                r.setCount(++count);
                resultDao.updateReslut(r);
            }

        }

    }

    public Vote selectByUIdAndVId(Vote v) {
        return voteDao.selectByUIdAndVId(v);
    }

    public List<Result> getResult(int voteId) {
        List<Result> resultList =resultDao.getResult(voteId);
        for(int i=0;i<resultList.size();i++){
            if(resultList.get(i).getCount()==0){
                continue;
            }
            float rate = resultList.get(i).getRate()/resultList.get(i).getCount();
            resultList.get(i).setRate(rate);
        }
        return resultList;
    }

    public void addVoteList(VoteList voteList) {
        voteListDao.addVoteList(voteList);
    }

}
