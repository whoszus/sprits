package cc.top.model.webchat.service.impl;

import cc.top.model.webchat.dao.IWebchatDao;
import cc.top.model.webchat.entity.WebChat;
import cc.top.model.webchat.entity.WebchatClient;
import cc.top.model.webchat.service.IWebcharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zus on 3/28/16.
 */
@Service
public class WebchatService implements IWebcharService {


    @Autowired private IWebchatDao webchatDao;


    public void add(WebChat webChat) {
        webchatDao.add(webChat);
    }

    public List<WebChat> getAll() {
        return webchatDao.getAll();
    }

    public WebChat selectbyopen(String openid) {
        return webchatDao.selectbyopen(openid);
    }

    public void addClient(WebchatClient webchatClient) {

    }

    public List<WebchatClient> getAllClient() {
        return null;
    }
}
