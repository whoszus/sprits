package cc.top.model.ATC.entity;

/**
 * Created by Lr on 2016/4/16/016.
 */
public class Result {
    private int id;
    private int mechineId;
    private int count;
    private int voteId;
    private int excellentCount;
    private int goodCount;
    private int sosoCount;
    private int unsatisfiedCount;


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

    public int getExcellentCount() {
        return excellentCount;
    }

    public void setExcellentCount(int excellentCount) {
        this.excellentCount = excellentCount;
    }

    public int getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public int getSosoCount() {
        return sosoCount;
    }

    public void setSosoCount(int sosoCount) {
        this.sosoCount = sosoCount;
    }

    public int getUnsatisfiedCount() {
        return unsatisfiedCount;
    }

    public void setUnsatisfiedCount(int unsatisfiedCount) {
        this.unsatisfiedCount = unsatisfiedCount;
    }
}
