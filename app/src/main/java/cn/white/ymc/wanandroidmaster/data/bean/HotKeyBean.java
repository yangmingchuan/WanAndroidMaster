package cn.white.ymc.wanandroidmaster.data.bean;

import java.util.List;

/**
 * 历史
 *
 * @packageName: cn.white.ymc.wanandroidmaster.data.bean
 * @fileName: HotKeyBean
 * @date: 2018/8/27  14:07
 * @author: ymc
 * @QQ:745612618
 */

public class HotKeyBean {

    /**
     * id : 6
     * link :
     * name : 面试
     * order : 1
     * visible : 1
     */

    private int id;
    private String link;
    private String name;
    private int order;
    private int visible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
