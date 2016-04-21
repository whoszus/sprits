package cc.top.model.ATC.service.impl;

import cc.top.model.ATC.dao.impl.MechineDaoImpl;
import cc.top.model.ATC.dao.impl.ResultDaoImpl;
import cc.top.model.ATC.dao.impl.VoteDaoImpl;
import cc.top.model.ATC.dao.impl.VoteListDaoImpl;
import cc.top.model.ATC.dto.voteResult;
import cc.top.model.ATC.entity.Mechine;
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
    @Autowired
    private MechineDaoImpl mechineDao;

    public List<VoteList> getAll() {
        return voteListDao.getAll();
    }

    public void addVote(Vote v) {
        voteDao.addVote(v);
    }

    public void addResult(Result r) {
        resultDao.addResult(r);
    }

    public void updateReslut(Result r) {
        System.out.println(".........................");
        resultDao.updateReslut(r);
    }

    public Result selectByVIdAndMId(Result r) {
        return resultDao.selectByVIdAndMId(r);
    }

    public Result judge(int satisDegree, Result r) {

        switch (satisDegree) {
            case 1: {
                int t = r.getUnsatisfiedCount() + 1;
                r.setUnsatisfiedCount(t);
                System.out.println(r.getUnsatisfiedCount());
                break;
            }
            case 2: {
                r.setSosoCount(r.getSosoCount() + 1);
                System.out.println(r.getSosoCount());
                break;
            }
            case 3: {
                r.setGoodCount(r.getGoodCount() + 1);
                System.out.println(r.getGoodCount());
                break;
            }
            case 4: {
                r.setExcellentCount(r.getExcellentCount() + 1);
                break;
            }

        }
        return r;
    }

    /**
     * 分析用户的投票，并分别存到数据库中
     *
     * @param v
     */
    public void saveResultByUserVote(Vote v) {

        Result temp = new Result();

        int voteId = v.getVoteId();
        temp.setVoteId(voteId);

        String resultStr = v.getResult();


        for (int i = 1; i <= resultStr.length(); i++) {

            temp.setMechineId(i);

            Result r = resultDao.selectByVIdAndMId(temp);

            if (r == null) {//等于空说明是第一个投票，应该插入数据库
                int satisDegree = Integer.parseInt(String.valueOf(resultStr.charAt(i - 1)));

                if (satisDegree == 0) {
                    continue;
                }

                Result r1 = new Result();
                r1 = judge(satisDegree, r1);
                r1.setVoteId(voteId);
                r1.setMechineId(i);//机器id

                r1.setCount(1); //人数变为1

                resultDao.addResult(r1);
            } else {//说明不是第一次投票，只需要更新相应的记录

                //得到用户的投票
                int satisDegree = Integer.parseInt(String.valueOf(resultStr.charAt(i - 1)));

                if (satisDegree == 0) {
                    continue;
                }


                r = judge(satisDegree, r);
                r.setCount(r.getCount() + 1);
                resultDao.updateReslut(r);
            }

        }

    }

    public Vote selectByUIdAndVId(Vote v) {
        return voteDao.selectByUIdAndVId(v);
    }


    public void addVoteList(VoteList voteList) {
        voteListDao.addVoteList(voteList);
    }

    public void updateVote(Vote model, Vote v) {
        model = voteDao.selectByUIdAndVId(v);
        String result = model.getResult();
        StringBuilder temp = new StringBuilder();
        String vResult = v.getResult();
        for (int i = 1; i <= vResult.length(); i++) {

            int t1 = Integer.parseInt(String.valueOf(vResult.charAt(i - 1)));//前台传进来的用户投票结果

            int t2 = Integer.parseInt(String.valueOf(result.charAt(i - 1)));//数据库已存的用户投票结果

            if (t2 != 0) {//用户已经投过该设备了
                temp.append(result.charAt(i - 1));

            } else { //用户没有投过该设备

                temp.append(vResult.charAt(i - 1));

                //更新result表
                Result t = new Result();
                t.setVoteId(v.getVoteId());
                t.setMechineId(i);

                Result r = resultDao.selectByVIdAndMId(t);

                if (r == null) {//等于空说明是第一个投票，应该插入数据库
                    int satisDegree = Integer.parseInt(String.valueOf(vResult.charAt(i - 1)));

                    if (satisDegree == 0) {
                        continue;
                    }

                    Result r1 = new Result();

                    r1 = judge(satisDegree, r1);
                    r1.setVoteId(v.getVoteId());

                    r1.setMechineId(i);//机器id
                    r1.setCount(1); //人数变为1

                    resultDao.addResult(r1);
                } else {//说明不是第一次投票，只需要更新相应的记录
                    //得到用户的投票
                    int satisDegree = Integer.parseInt(String.valueOf(vResult.charAt(i - 1)));

                    if (satisDegree == 0) {
                        continue;
                    }

                    r.setCount(r.getCount() + 1);

                    System.out.println(r.getCount());
                    r = judge(satisDegree, r);
                    resultDao.updateReslut(r);
                }
            }
        }
        v.setResult(temp.toString());
        voteDao.updateVote(v);

    }

    public List<Mechine> getMechines() {
        return mechineDao.getAll();
    }

    public List<voteResult> getResultInfo(int voteId) {
        List<voteResult> voteResults =  resultDao.getResultInfo(voteId);
        for(int i=0;i<voteResults.size();i++){
            voteResults.get(i).setSatisDegree();
        }
        return voteResults;
    }

    public VoteList findByVoteId(int voteId) {
        return voteListDao.selectById(voteId);
    }

}
