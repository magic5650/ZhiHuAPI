package com.shining.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.shining.myapplication.R;
import com.shining.myapplication.adapter.CircleTransform;
import com.shining.myapplication.adapter.ItemClickSupport;
import com.shining.myapplication.adapter.articleAdapter;
import com.shining.myapplication.adapter.zlAdapter;
import com.shining.myapplication.api.Constants;
import com.shining.myapplication.api.DataAPI;
import com.shining.myapplication.api.Services;
import com.shining.myapplication.model.article;
import com.shining.myapplication.model.zhuanlan;
import com.shining.myapplication.model.zhuanlan_more;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class zhuanlanActivity extends AppCompatActivity {

    @BindView(R.id.zl_avatar_image)
    ImageView zlAvatarImage;
    @BindView(R.id.zl_zhuanlan_name)
    TextView zlZhuanlanName;
    @BindView(R.id.zl_zhuanlan_intro)
    TextView zlZhuanlanIntro;
    @BindView(R.id.zl_follow_bt)
    Button zlFollowBt;
    @BindView(R.id.zl_follow_counts)
    TextView zlFollowCounts;
/*    @BindView(R.id.zl_topics_view)
    GridView zlTopicsView;*/
    @BindView(R.id.zl_topic_name)
    TextView zlTopicName;
    @BindView(R.id.zl_articles_view)
    RecyclerView zlArticlesView;
    @BindView(R.id.activity_zhuanlan)
    ScrollView activityZhuanlan;

    private Services service;
    private Context mContext;


    private RecyclerView article_recyclerView;
    private List<article> article_Data;
    private articleAdapter article_Adapter;
    private LinearLayoutManager layoutManager;
    private String slug;
    private final static Integer defaultNum = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuanlan);
        ButterKnife.bind(this);
        service = new DataAPI().getService();
        mContext = zhuanlanActivity.this;

        Intent intent = getIntent();
        zhuanlan zhuanlanInfo = intent.getParcelableExtra("zhuanlanInfo");
        if (zhuanlanInfo != null) {
            show_zhuanlan(zhuanlanInfo);
            slug = zhuanlanInfo.getSlug();
            init_topics(slug);
        }

        article_recyclerView = (RecyclerView) findViewById(R.id.zl_articles_view);
        layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        article_recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        article_Data = new ArrayList<article>();
        article_Adapter= new articleAdapter(zhuanlanActivity.this,article_Data);
        //设置Adapter
        article_recyclerView.setAdapter(article_Adapter);
        //设置增加或删除条目的动画
        article_recyclerView.setItemAnimator(new DefaultItemAnimator());

        if (slug != null) {
            show_articles(slug,defaultNum,null,null);
            OnClick_Jump_To_Article_Activity();
        }
    }

    private void init_topics(String slug) {
        service.getZhuanlanInfo(slug)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<zhuanlan_more>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(Constants.TAG, "数据加载失败" + e.toString());
                    }

                    @Override
                    public void onNext(zhuanlan_more zhuanlanInfo) {
                        show_topics(zhuanlanInfo.getPostTopics());
                    }
                });
    }

    private void show_zhuanlan(zhuanlan_more zhuanlanInfo) {
        String avatarUrl = getAvatarUrl(zhuanlanInfo.getAvatar().getId(),
                zhuanlanInfo.getAvatar().getTemplate(),Constants.IMAGE_SIZE);
        Picasso.with(mContext).load(avatarUrl).placeholder(R.drawable.zhuanlan_default_pic)
                .transform(new CircleTransform()).into(zlAvatarImage);
        zlZhuanlanName.setText(zhuanlanInfo.getName());
        zlZhuanlanIntro.setText(zhuanlanInfo.getIntro());
        String followersCount_text = mContext.getResources().getString(R.string.followersCount_text);
        zlFollowCounts.setText(zhuanlanInfo.getFollowersCount() + "" + followersCount_text);
    }

    private void show_zhuanlan(zhuanlan zhuanlanInfo) {
        String avatarUrl = getAvatarUrl(zhuanlanInfo.getAvatar().getId(),
                zhuanlanInfo.getAvatar().getTemplate(),Constants.IMAGE_SIZE);
        Picasso.with(mContext).load(avatarUrl).placeholder(R.drawable.zhuanlan_default_pic)
                .transform(new CircleTransform()).into(zlAvatarImage);
        zlZhuanlanName.setText(zhuanlanInfo.getName());
        zlZhuanlanIntro.setText(zhuanlanInfo.getDescription());
        String followersCount_text = mContext.getResources().getString(R.string.followersCount_text);
        zlFollowCounts.setText(zhuanlanInfo.getFollowersCount() + "" + followersCount_text);
    }

    private void show_topics(List<zhuanlan_more.PostTopicsBean> postTopicsBeanList) {

    }

    private void show_articles(String slug, Integer limit, Integer topic ,Integer offset) {
        service.getArticleList(slug,limit,topic,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<article>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<article> articleList) {
                        Log.d(Constants.TAG,"请求专栏数据成功");
                        article_Data.addAll(articleList);
                        article_Adapter.notifyDataSetChanged();
                    }
                });
    }

    private String getAvatarUrl(String id,String template,String size) {
        String[] base_url = template.split("\\{");
        String imageUrl = base_url[0] + id + "_" + size + ".jpg";
        //Log.d(Constants.TAG,"图片网址为"+imageUrl);
        return imageUrl;
    }

    @OnClick(R.id.zl_follow_bt)
    public void onClick() {

    }

    private void OnClick_Jump_To_Article_Activity() {
        ItemClickSupport.addTo(article_recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // do it
                article object = article_Data.get(position);
                Intent intent = new Intent();
                Log.d(Constants.TAG,object.getSlug()+"");
                intent.setClass(zhuanlanActivity.this,articleActivity.class);
                intent.putExtra("articleSlug",object.getSlug()+"");
                startActivity(intent);
            }
        });
    }
}
