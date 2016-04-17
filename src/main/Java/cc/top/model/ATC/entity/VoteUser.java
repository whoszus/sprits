package cc.top.model.ATC.entity;

/**
 * Created by Lr on 2016/4/16/016.
 */
public class VoteUser {
    private int id;
    private String account;
    private String password;
    private String clsnum;
    private String tel;
    private int role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClsnum() {
        return clsnum;
    }

    public void setClsnum(String clsnum) {
        this.clsnum = clsnum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
