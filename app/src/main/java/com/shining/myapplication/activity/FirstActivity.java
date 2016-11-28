package com.shining.myapplication.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shining.myapplication.R;
import com.shining.myapplication.adapter.NavigationPagerAdapter;
import com.shining.myapplication.api.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;
    @BindView(R.id.tab_main)
    RadioButton tabMain;
    @BindView(R.id.tab_love)
    RadioButton tabLove;
    @BindView(R.id.tab_recommend)
    RadioButton tabRecommend;
    @BindView(R.id.tab_personal)
    RadioButton tabPersonal;
    @BindView(R.id.rg_tab_bar)
    RadioGroup rgTabBar;
    @BindView(R.id.activity_first)
    LinearLayout activityFirst;

    private NavigationPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        Log.d(Constants.TAG,"FirstActivity onCreate");
        bindViews();
        //tabMain.setChecked(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constants.TAG,"FirstActivity onResume");

    }
    private void bindViews() {

        rgTabBar.setOnCheckedChangeListener(this);
        mAdapter = new NavigationPagerAdapter(getSupportFragmentManager());
        mainViewpager.setAdapter(mAdapter);

        Log.d(Constants.TAG,"mainViewpager setAdapter");
        mainViewpager.setCurrentItem(0);
        mainViewpager.addOnPageChangeListener(this);
        tabMain.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tab_main:
                mainViewpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.tab_love:
                mainViewpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.tab_recommend:
                mainViewpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.tab_personal:
                mainViewpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (mainViewpager.getCurrentItem()) {
                case PAGE_ONE:
                    tabMain.setChecked(true);
                    break;
                case PAGE_TWO:
                    tabLove.setChecked(true);
                    break;
                case PAGE_THREE:
                    tabRecommend.setChecked(true);
                    break;
                case PAGE_FOUR:
                    tabPersonal.setChecked(true);
                    break;
            }
        }
    }
}
