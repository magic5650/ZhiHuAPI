package com.shining.myapplication.adapter;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-11-03.
 */
public class articleAdapterTest {
    @Test
    public void getImageUrl() throws Exception {
        String Url = "https://pic2.zhimg.com/59dc09baf765b20f6faa5974ae4aaf51_r.jpg";
        //String result = adapter.getImageUrl(Url);
        //Log.d(TAG,"图片路径为"+result);
    }

    private articleAdapter adapter;
    private static String TAG="zhuanlan";

    @Before
    public void setUp() throws Exception {
        adapter = new articleAdapter();
    }

    @Test
    public void getPublishedTime() throws Exception {
        String publishedTime = "2016-04-06T11:56:11+08:00";
        //String result = adapter.getPublishedTime(publishedTime);
        //Log.d(TAG,"时间为"+result);
    }

}