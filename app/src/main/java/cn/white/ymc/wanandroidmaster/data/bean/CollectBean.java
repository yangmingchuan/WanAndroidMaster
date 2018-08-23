package cn.white.ymc.wanandroidmaster.data.bean;

import java.util.List;

/**
 * @author ymc 2018年8月23日 13:30:18
 */

public class CollectBean {

    /**
     * curPage : 1
     * datas : [{"author":"mylhyl","chapterId":358,"chapterName":"项目基础功能","courseId":13,"desc":"可配置扫描框、线样式 ，生成二维码（文字、联系人）","envelopePic":"http://www.wanandroid.com/blogimgs/6d3b8a9e-42d2-4d1f-a6e1-1f8d90128446.png","id":15000,"link":"http://www.wanandroid.com/blog/show/2174","niceDate":"刚刚","origin":"","originId":3055,"publishTime":1529914227000,"title":"Android-Zxing 开源二维码项目","userId":6853,"visible":0,"zan":0},{"author":"xfhy","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"1. 我的毕业设计APP端,目前含有的主要功能如下:用户模块,知乎日报,小视频,新闻,天气,笑话,干货集中营.APP端是纯kotlin和组件化的.\r\n2. 我的毕业设计的服务器端: https://github.com/xfhy/LifeHelperServer  采用Spring Boot来进行的快速开发,数据库是mysql,目前有如下功能:收藏,评论,用户:增加,更新头像,签到等,产品,兴趣","envelopePic":"http://www.wanandroid.com/blogimgs/3d414bfe-7296-4695-98e3-ed0692bfc063.png","id":14985,"link":"http://www.wanandroid.com/blog/show/2173","niceDate":"33分钟前","origin":"","originId":3054,"publishTime":1529912201000,"title":"毕业设计(100%纯kotlin组件化开发)-LifeHelper","userId":6853,"visible":0,"zan":0},{"author":"Peter潘的博客","chapterId":245,"chapterName":"集合相关","courseId":13,"desc":"","envelopePic":"","id":14951,"link":"https://www.jianshu.com/p/cc2281b1a6bc","niceDate":"47分钟前","origin":"","originId":3001,"publishTime":1529911393000,"title":"【Java并发编程】&mdash;&ndash;&ldquo;J.U.C&rdquo;：LinkedBlockingQueue","userId":6853,"visible":0,"zan":0}]
     * offset : 0
     * over : true
     * pageCount : 1
     * size : 20
     * total : 3
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * author : mylhyl
         * chapterId : 358
         * chapterName : 项目基础功能
         * courseId : 13
         * desc : 可配置扫描框、线样式 ，生成二维码（文字、联系人）
         * envelopePic : http://www.wanandroid.com/blogimgs/6d3b8a9e-42d2-4d1f-a6e1-1f8d90128446.png
         * id : 15000
         * link : http://www.wanandroid.com/blog/show/2174
         * niceDate : 刚刚
         * origin :
         * originId : 3055
         * publishTime : 1529914227000
         * title : Android-Zxing 开源二维码项目
         * userId : 6853
         * visible : 0
         * zan : 0
         */

        private String author;
        private int chapterId;
        private String chapterName;
        private int courseId;
        private String desc;
        private String envelopePic;
        private int id;
        private String link;
        private String niceDate;
        private String origin;
        private int originId;
        private long publishTime;
        private String title;
        private int userId;
        private int visible;
        private int zan;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

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

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getOriginId() {
            return originId;
        }

        public void setOriginId(int originId) {
            this.originId = originId;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }
    }
}
