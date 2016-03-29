package cc.top.model.webchat.dao.impl;

import cc.top.fundation.impl.BaseDaoImpl;
import cc.top.model.webchat.dao.IWebchatDao;
import cc.top.model.webchat.entity.WebChat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zus on 3/28/16.
 */
@Repository
public class WebchatDaoImpl extends BaseDaoImpl<WebChat> implements IWebchatDao{
    public void add(WebChat webChat) {
        getSqlSession().selectOne("webchat.add",webChat);

    }

    public List<WebChat> getAll() {
        return getSqlSession().selectList("webchat.getall");
    }

    public WebChat selectbyopen(String openid) {
        return getSqlSession().selectOne("webchat.selectbyopen",openid);
    }
}
