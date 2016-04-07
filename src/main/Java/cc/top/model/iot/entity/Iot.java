package cc.top.model.iot.entity;

/**
 * Created by Zus on 4/5/16.
 */
public class Iot {
    private int id;
    private String name;
    private String cls;
    private String tel;
    private String clsnum;
    private String email;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getClsnum() {
        return clsnum;
    }

    public void setClsnum(String clsnum) {
        this.clsnum = clsnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
