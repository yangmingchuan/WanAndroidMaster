package cn.white.ymc.wanandroidmaster.model;

import java.util.List;

import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.BenarBean;
import cn.white.ymc.wanandroidmaster.data.bean.HomePageArticleBean;
import cn.white.ymc.wanandroidmaster.data.bean.UserInfo;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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
}
