package cc.top.model.ATC.dao.impl;

import cc.top.fundation.BASEDAO.BaseDaoImpl;
import cc.top.model.ATC.dao.IMechineDao;
import cc.top.model.ATC.entity.Mechine;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lr on 2016/4/20/020.
 */
@Repository
public class MechineDaoImpl  extends BaseDaoImpl<Mechine> implements IMechineDao {


    public List<Mechine> getAll() {
        return getSqlSession().selectList("mechine.getAll");
    }
}
