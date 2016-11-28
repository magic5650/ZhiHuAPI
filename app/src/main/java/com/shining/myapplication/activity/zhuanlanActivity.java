package com.shining.myapplication.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shining.myapplication.R;
import com.shining.myapplication.adapter.CircleTransform;
import com.shining.myapplication.adapter.ItemClickSupport;
import com.shining.myapplication.adapter.articleAdapter;
import com.shining.myapplication.api.Constants;
import com.shining.myapplication.api.DataAPI;
import com.shining.myapplication.api.Services;
import com.shining.myapplication.model.article;
import com.shining.myapplication.model.zhuanlan;
import com.shining.myapplication.model.zhuanlan_more;
import com.shining.myapplication.widget.MyLinearLayoutManager;
import com.squareup.picasso.Picasso;
import com.thefinestartist.finestwebview.FinestWebView;

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
    @BindView(R.id.zl_toolbar)
    Toolbar toolbar;

/*    @BindView(R.id.activity_zhuanlan)
    ScrollView activityZhuanlan;*/

    private Services service;
    private Context mContext;


    private RecyclerView article_recyclerView;
    private List<article> article_Data;
    private articleAdapter article_Adapter;
    private MyLinearLayoutManager layoutManager;
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
            initToolbar(zhuanlanInfo.getName());
            init_topics(slug);
        }

        article_recyclerView = (RecyclerView) findViewById(R.id.zl_articles_view);
        layoutManager = new MyLinearLayoutManager(this);
        //设置布局管理器
        article_recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        article_Data = new ArrayList<article>();
        article_Adapter= new articleAdapter(this,article_Data);
        //设置Adapter
        article_recyclerView.setAdapter(article_Adapter);
        //设置增加或删除条目的动画
        article_recyclerView.setItemAnimator(new DefaultItemAnimator());

        if (slug != null) {
            show_articles(slug,defaultNum,null,null);
            OnClick_Jump_To_Article_Activity();
        }

        article_recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItem = ((LinearLayoutManager) article_recyclerView.getLayoutManager())
                        .findFirstVisibleItemPosition();
                Log.d(Constants.TAG,"article_recyclerView onScrolled");
                if(firstVisibleItem !=0 && dy <-25) {
                    hideToolbar();
                }

            }
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d(Constants.TAG,"article_recyclerView onScrollStateChanged");
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(Constants.TAG,"zhuanlanActivity onResume");
        Log.d(Constants.TAG,"toolbar Height is "+toolbar.getHeight());
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(Constants.TAG,"zhuanlanActivity onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(Constants.TAG,"zhuanlanActivity onDestroy");
    }

    private void initToolbar (String name) {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setTitle("专栏-"+name);
        setSupportActionBar(toolbar);
/*        if(getSupportActionBar() != null){
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* NavUtils.navigateUpFromSameTask(zhuanlanActivity.this);*/
                //finish();
                onBackPressed();
            }
        });
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
        if ( !zhuanlanInfo.getDescription().equals("") ) {
            zlZhuanlanIntro.setText(zhuanlanInfo.getDescription());
        }
        else{
            String defaultIntro_text = mContext.getResources().getString(R.string.defaultIntro_text);
            zlZhuanlanIntro.setText(defaultIntro_text);
        }

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

    private void showToolbar(){
        ObjectAnimator animator =ObjectAnimator.ofFloat(toolbar,View.TRANSLATION_Y,-toolbar.getHeight(),0);
        animator.setDuration(500);
        animator.start();
    }

    private void hideToolbar(){
        ObjectAnimator animator =ObjectAnimator.ofFloat(toolbar,View.TRANSLATION_Y,0,-toolbar.getHeight());
        animator.setDuration(500);
        animator.start();
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
/*                Intent intent = new Intent();
                Log.d(Constants.TAG,object.getSlug()+"");
                intent.setClass(zhuanlanActivity.this,articleActivity.class);
                intent.putExtra("articleSlug",object.getSlug()+"");
                startActivity(intent);*/
                String url="https://zhuanlan.zhihu.com/p/" + object.getSlug();
                //编写 javaScript方法
                //tring javascript = "javascript: var x=document.getElementById(\"header\");x.remove(x.selectedIndex);";
                String javascript = "javascript: document.getElementsByTagName(\"div\")[0].remove();";
                Log.d(Constants.TAG,object.getSlug()+"");
                new FinestWebView.Builder(zhuanlanActivity.this)
                        .iconDefaultColor(ContextCompat.getColor(mContext, R.color.white))
                        .showIconBack(true)
                        .showIconForward(true)
                        .showUrl(false)
                        .titleDefault(getString(R.string.webview_default_title))
                        .titleColor(ContextCompat.getColor(mContext, R.color.white))
                        .titleSize(zlZhuanlanIntro.getTextSize())
                        .updateTitleFromHtml(true)
                        .webViewJavaScriptEnabled (true)
                        .injectJavaScript(javascript)
                        .backPressToClose(true)
                        .show(url);
            }
        });
    }

}
