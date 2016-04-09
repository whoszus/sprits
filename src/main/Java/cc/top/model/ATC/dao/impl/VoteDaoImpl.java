package cc.top.model.ATC.dao.impl;

import cc.top.fundation.BASEDAO.BaseDaoImpl;
import cc.top.model.ATC.dao.VoteDao;
import cc.top.model.ATC.entity.Vote;
import org.springframework.stereotype.Repository;

/**
 * Created by Zus on 4/9/16.
 */
@Repository
public class VoteDaoImpl extends BaseDaoImpl<Vote> implements VoteDao {
    public Vote getMechine(Vote vote) {
        return getSqlSession().selectOne("vote.getMechine",vote);
    }

    public void updateVote(Vote vote) {
         getSqlSession().selectOne("vote.updateVote",vote);
    }
}
