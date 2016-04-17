package cc.top.model.iot.dao.impl;

import cc.top.fundation.BASEDAO.BaseDaoImpl;
import cc.top.model.iot.dao.IotDao;
import cc.top.model.iot.entity.Iot;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zus on 4/5/16.
 */

@Repository
public class IotDaoImpl extends BaseDaoImpl  implements IotDao{
    public void insertIot(Iot iot) {
        getSqlSession().selectOne("iot.insertiot",iot);
    }

    public List<Iot> getAll() {
        return getSqlSession().selectList("iot.getAll");
    }
}
