package cc.top.model.webchat.entity;

import java.io.Serializable;

/**
 * Created by Zus on 3/28/16.
 */
public class WebChat implements Serializable{
    private Integer webchatid;
    private String appid;
    private String secret;
    private static final long serialVersionUID = 1L;

    public Integer getWebchatid() {
        return webchatid;
    }

    public void setWebchatid(Integer webchatid) {
        this.webchatid = webchatid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
