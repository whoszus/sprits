package cc.top.model.ATC.entity;

import java.util.Date;

/**
 * Created by Zus on 4/9/16.
 */
public class Vote {
    private int id;
    private String  mechine;
    private int count;
    private Date date;
    private Double rate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMechine() {
        return mechine;
    }

    public void setMechine(String mechine) {
        this.mechine = mechine;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
