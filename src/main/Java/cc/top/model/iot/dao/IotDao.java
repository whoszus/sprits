package cc.top.model.iot.dao;

import cc.top.model.iot.entity.Iot;

import java.util.List;

/**
 * Created by Zus on 4/5/16.
 */
public interface IotDao {
    public void insertIot(Iot iot);
    public List<Iot> getAll();
}
