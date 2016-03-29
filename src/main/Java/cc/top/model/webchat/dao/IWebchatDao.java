package cc.top.model.webchat.dao;

import cc.top.model.webchat.entity.WebChat;

import java.util.List;

/**
 * Created by Zus on 3/28/16.
 */
public interface IWebchatDao {

    public void add(WebChat webChat);

    public List<WebChat> getAll();

    public WebChat selectbyopen(String openid);

}
