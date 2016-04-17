package cc.top.model.ATC.dao.impl;

import cc.top.fundation.BASEDAO.BaseDaoImpl;
import cc.top.model.ATC.dao.IVoteListDao;
import cc.top.model.ATC.entity.VoteList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lr on 2016/4/16/016.
 */
@Repository
public class VoteListDaoImpl extends BaseDaoImpl<VoteList> implements IVoteListDao {

    public List<VoteList> getAll() {
        return getSqlSession().selectList("voteList.getAll");
    }

    public VoteList selectById(int id) {
        return getSqlSession().selectOne("voteList.selectById",id);
    }

    public void addVoteList(VoteList voteList) {
        getSqlSession().insert("voteList.creatVote",voteList);
    }
}
