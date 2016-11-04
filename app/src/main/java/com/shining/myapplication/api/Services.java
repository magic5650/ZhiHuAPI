package com.shining.myapplication.api;

import com.android.annotations.Nullable;
import com.shining.myapplication.model.article;
import com.shining.myapplication.model.ids;
import com.shining.myapplication.model.postArticle;
import com.shining.myapplication.model.zhuanlan;
import com.shining.myapplication.model.zhuanlan_more;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016-10-31.
 */

public interface Services {
    /*
     * 获取推荐专栏列表,offset初始为零,seed=20或者98或者100,可有可无
     *
     */
    @GET("api/recommendations/columns")
    Observable<List<zhuanlan>> getReZhuanlanList(
            @Query("limit") Integer limit,
            @Query("offset") Integer offset,
            @Query("seed") Integer seed
    );

    /*
     * 获取推荐文章列表,offset初始为零,seed=20,可有可无
     */
    @GET("api/recommendations/posts")
    Observable<List<postArticle>> getRePostList(
            @Query("limit") Integer limit,
            @Query("offset") Integer offset,
            @Query("seed") Integer seed
    );

    /*
     * 获取某个专栏文章列表,offset初始为零,topic是标签
     */
    @GET("api/columns/{zhuanlanId}/posts")
    Observable<List<article>> getArticleList(
            @Path("zhuanlanId") String zhuanlanId,
            @Query("limit") Integer limit,
            @Query("topic") Integer topic,
            @Query("offset") Integer offset
    );

    /*
     * 获取某个专栏的详细信息
     */
    @GET("api/columns/{zhuanlanId}")
    Observable<zhuanlan_more> getZhuanlanInfo(
            @Path("zhuanlanId") String zhuanlanId
    );

    /*
     * 获取某个专栏的详细信息,refer可有可无
     */
    @GET("api/posts/{articleId}")
    Observable<article> getArticleInfo(
            @Path("articleId") String articleId,
            @Query("refer") String refer
    );

    /*
     * 获取某个专栏ID数据
     */
    @GET("blog/zhuanlanlist.json")
    Observable<ids> getData(
    );
}
