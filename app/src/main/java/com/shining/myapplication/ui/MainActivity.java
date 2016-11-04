package com.shining.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.shining.myapplication.R;
import com.shining.myapplication.adapter.EndLessOnScrollListener;
import com.shining.myapplication.adapter.ItemClickSupport;
import com.shining.myapplication.adapter.zlAdapter;
import com.shining.myapplication.api.Constants;
import com.shining.myapplication.api.DataAPI;
import com.shining.myapplication.api.Services;
import com.shining.myapplication.model.zhuanlan;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView zl_recyclerView;
    private List<zhuanlan> zl_Data;
    private zlAdapter zl_Adapter;
    private LinearLayoutManager layoutManager;
    private SwipeRefreshLayout zl_refreshLayout;
    private int lastVisibleItem;
    private Services service;
    private final static Integer count = 8;
    private final static Integer maxCount = 40;
    private final static Integer defaultSeed = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        service = new DataAPI().getService();
        initRecycleView();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initRecycleView() {
        zl_recyclerView = (RecyclerView) findViewById(R.id.zl_recycleView);
        zl_refreshLayout = (SwipeRefreshLayout) findViewById(R.id.zl_swipe_refresh);
        layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        zl_recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        zl_Data = new ArrayList<zhuanlan>();
        zl_Adapter= new zlAdapter(MainActivity.this,zl_Data);
        //设置Adapter
        zl_recyclerView.setAdapter(zl_Adapter);
        //设置增加或删除条目的动画
        zl_recyclerView.setItemAnimator(new DefaultItemAnimator());
        //初始化数据
        init_zl_Data(count, 0, defaultSeed);

        zl_refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(zl_Data.size()!=0) {
                    zl_Data.clear();
                    init_zl_Data(count, 0, defaultSeed);
                }
                Log.d(Constants.TAG,"正在加载数据");
            }
        });
        zl_recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int adapterCount = zl_Data.size();
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING ) {
                    if (adapterCount <= (maxCount-count) && lastVisibleItem >= adapterCount-1) {
                        init_zl_Data(count, adapterCount, 20);
                        Log.d(Constants.TAG, "加载数据,item的数量为" + adapterCount);
                    }
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (adapterCount == maxCount && lastVisibleItem == adapterCount-1) {
                        Toast.makeText(MainActivity.this, R.string.no_nore_zhuanlan, Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem =layoutManager.findLastVisibleItemPosition();
                //Log.d(Constants.TAG, "onScrolled" + " "+ lastVisibleItem);

            }
        });

        OnClick_Jump_To_Zhuanlan_Activity();

    }

    private void init_zl_Data(Integer limit, Integer offset, Integer seed) {
        service.getReZhuanlanList(limit,offset,seed)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<zhuanlan>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        zl_refreshLayout.setRefreshing(false);
                        Toast.makeText(MainActivity.this,R.string.loadData_fail,Toast.LENGTH_SHORT).show();
                        Log.d(Constants.TAG,"数据加载失败"+e.toString());
                    }

                    @Override
                    public void onNext(List<zhuanlan> zhuanlanList) {
                        zl_refreshLayout.setRefreshing(false);
                        zl_Data.addAll(zhuanlanList);
                        zl_Adapter.notifyDataSetChanged();
                        //zl_Adapter.notifyItemRangeInserted(offset,limit);
                    }
                });
    }

    private void OnClick_Jump_To_Zhuanlan_Activity(){
        ItemClickSupport.addTo(zl_recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // do it
                zhuanlan object = zl_Data.get(position);
                TextView textView = (TextView) v.findViewById(R.id.zhuanlan_slug);
                Log.d(Constants.TAG,"专题slug为"+ textView.getText());
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,zhuanlanActivity.class);
                intent.putExtra("zhuanlanInfo",object);
                startActivity(intent);

            }
        });
    }
}
