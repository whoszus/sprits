package cc.top.model.ATC.dao.impl;

import cc.top.fundation.BASEDAO.BaseDaoImpl;
import cc.top.model.ATC.dao.IResultDao;
import cc.top.model.ATC.dto.voteResult;
import cc.top.model.ATC.entity.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lr on 2016/4/16/016.
 */
@Repository
public class ResultDaoImpl  extends BaseDaoImpl<Result> implements IResultDao{

    public void addResult(Result r) {
        getSqlSession().insert("result.saveResult",r);
    }
    public void updateReslut(Result r){
       getSqlSession().update("result.updateReslut",r);
    }

    public Result selectByVIdAndMId(Result r) {
        return getSqlSession().selectOne("result.selectByVIdAndMId",r);
    }

    public List<Result> getResult(int voteId) {
        return getSqlSession().selectList("result.getResult",voteId);
    }

    public List<voteResult> getResultInfo(int voteId) {
        return getSqlSession().selectList("result.getResultInfo",voteId);
    }
}

