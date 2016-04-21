package cc.top.model.ATC.dto;

/**
 * Created by Lr on 2016/4/20/020.
 */
public class voteResult {

    private String mechineName;//机器名
    private int count;//总人数
    private int excellentCount;//非常满意人数
    private int goodCount;//满意人数
    private int sosoCount;//一般人数
    private int unsatisfiedCount;//不满意人数
    private float satisDegree;

    public float getSatisDegree() {
        return satisDegree;
    }

    public void setSatisDegree() {
        if(count!=0){
            satisDegree = (float)(excellentCount+goodCount)/count;
        }
    }

    public String getMechineName() {
        return mechineName;
    }

    public void setMechineName(String mechineName) {
        this.mechineName = mechineName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
