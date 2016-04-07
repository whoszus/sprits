package cc.top.model.iot.service.impl;

import cc.top.model.iot.dao.impl.IotDaoImpl;
import cc.top.model.iot.entity.Iot;
import cc.top.model.iot.service.IotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zus on 4/5/16.
 */
@Service
public class IotServiceImpl implements IotService {
    @Autowired private IotDaoImpl iotDao;

    public void insertIot(Iot iot) {
        iotDao.insertIot(iot);
    }
}
