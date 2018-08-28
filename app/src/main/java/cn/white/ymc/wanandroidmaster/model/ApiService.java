package cn.white.ymc.wanandroidmaster.model;

import java.util.List;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.BenarBean;
import cn.white.ymc.wanandroidmaster.data.bean.CollectBean;
import cn.white.ymc.wanandroidmaster.data.bean.DemoDetailListBean;
import cn.white.ymc.wanandroidmaster.data.bean.DemoTitleBean;
import cn.white.ymc.wanandroidmaster.data.bean.HotKeyBean;
import cn.white.ymc.wanandroidmaster.data.bean.HomePageArticleBean;
import cn.white.ymc.wanandroidmaster.data.bean.HotBean;
import cn.white.ymc.wanandroidmaster.data.bean.SystemBean;
import cn.white.ymc.wanandroidmaster.data.bean.SystemDetailListBean;
import cn.white.ymc.wanandroidmaster.data.bean.UserInfo;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * retrofit api 接口类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.model.api
 * @fileName: ApiServer
 * @date: 2018/7/24  10:45
 * @author: ymc
 * @QQ:745612618
 */

public interface ApiService {
    /**
     * 主页
     */
    @GET("article/list/{page}/json")
    Observable<BaseResp<HomePageArticleBean>> getArticleList(@Path("page") int num);

    /**
     * 登录
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResp<UserInfo>> login(@Field("username") String username, @Field("password") String password);

    /**
     * 注册
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResp<UserInfo>> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * banner
     */
    @GET("banner/json")
    Observable<BaseResp<List<BenarBean>>>getBannerList();

    /**
     * 收藏文章
     * @param id
     */
    @POST("lg/collect/{id}/json")
    Observable<BaseResp> collectArticle(@Path("id") int id);

    /**
     *  取消收藏文章
     * @param id id
     */
    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseResp> cancelCollectArticle(@Path("id") int id);

    /**
     *  体系数据
     */
    @GET("tree/json")
    Observable<BaseResp<List<SystemBean>>>getSystemList();

    /**
     * 单个知识体系列表
     */
    @GET("article/list/{page}/json")
    Observable<BaseResp<SystemDetailListBean>> getSystemDetailList(@Path("page") int page, @Query("cid") int id);

    /**
     * 获取项目 列表
     */
    @GET("project/tree/json")
    Observable<BaseResp<List<DemoTitleBean>>> getDemoTitleList();

    /**
     * 获取 项目详细信息列表数据
     */
    @GET("project/list/{page}/json")
    Observable<BaseResp<DemoDetailListBean>> getDemoDetailList(@Path("page") int page ,@Query("cid")int id);

    /**
     * 获取 我的收藏列表
     */
    @GET("lg/collect/list/{page}/json")
    Observable<BaseResp<CollectBean>> getCollectionList(@Path("page") int page);

    /**
     * 获取 热门词
     */
    @GET("/friend/json")
    Observable<BaseResp<List<HotBean>>> getHotList();

    /**
     * 获取 搜索热词
     * @return
     */
    @GET("/hotkey/json")
    Observable<BaseResp<List<HotKeyBean>>> getHitKeyBean();


    @POST("/article/query/{page}/json")
    Observable<BaseResp<HomePageArticleBean>> getSearechResult(@Path("page") int page ,@Query("k")String key);

}
