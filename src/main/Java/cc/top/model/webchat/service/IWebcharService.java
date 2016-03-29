package cc.top.model.webchat.service;

import cc.top.model.webchat.entity.WebChat;
import cc.top.model.webchat.entity.WebchatClient;

import java.util.List;

/**
 * Created by Zus on 3/28/16.
 */
public interface IWebcharService {

    public void add(WebChat webChat);
    public List<WebChat> getAll();
    public WebChat selectbyopen(String openid);

    //Client

    public void addClient(WebchatClient webchatClient);
    public List<WebchatClient> getAllClient();


}
