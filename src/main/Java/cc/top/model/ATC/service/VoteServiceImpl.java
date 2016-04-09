package cc.top.model.ATC.service;

import cc.top.model.ATC.dao.impl.VoteDaoImpl;
import cc.top.model.ATC.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zus on 4/9/16.
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired private VoteDaoImpl voteDao;

    public Vote getMechine(Vote vote) {
        return voteDao.getMechine(vote);
    }

    public void updateVote(Vote vote) {
        voteDao.updateVote(vote);
    }
}
