package cc.top.model.ATC.dao.impl;

import cc.top.fundation.BASEDAO.BaseDaoImpl;
import cc.top.model.ATC.dao.IVoteDao;
import cc.top.model.ATC.entity.Vote;
import org.springframework.stereotype.Repository;

/**
 * Created by Zus on 4/9/16.
 */
@Repository
public class VoteDaoImpl extends BaseDaoImpl<Vote> implements IVoteDao{

    public void addVote(Vote v) {
        getSqlSession().insert("vote.addVote",v);
    }

    public Vote selectByUIdAndVId(Vote v) {
        return getSqlSession().selectOne("vote.selectByUIdAndVId",v);
    }
}
