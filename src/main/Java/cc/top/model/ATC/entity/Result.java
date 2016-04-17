package cc.top.model.ATC.entity;

/**
 * Created by Lr on 2016/4/16/016.
 */
public class Result {
    private int id;
    private int mechineId;
    private float rate;
    private int count;
    private int voteId;
    private String voteName;

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMechineId() {
        return mechineId;
    }

    public void setMechineId(int mechineId) {
        this.mechineId = mechineId;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }
}
