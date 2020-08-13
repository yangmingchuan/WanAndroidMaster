package cn.white.ymc.wanandroidmaster.data.bean;

import java.io.Serializable;

/**
 * Author : ymc
 * Date   : 2020/8/13  17:16
 * Class  : IntegralBean
 */
public class IntegralBean implements Serializable {


    /**
     * coinCount : 1209
     * level : 13
     * rank : 742
     * userId : 8822
     * username : 7**612618
     */

    private int coinCount;
    private int level;
    private String rank;
    private int userId;
    private String username;

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
