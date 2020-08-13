package cn.white.ymc.wanandroidmaster.data.bean;

import java.io.Serializable;

/**
 * Author : ymc
 * Date   : 2020/8/13  17:16
 * Class  : IntegralBean
 */
public class IntegralBean implements Serializable {

    /**
     * coinCount : 451
     * rank : 7
     * userId : 2
     * username : x**oyang
     */

    private int coinCount;
    private int rank;
    private int userId;
    private String username;

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
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
