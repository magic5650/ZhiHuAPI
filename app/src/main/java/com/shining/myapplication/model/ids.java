package com.shining.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016-10-31.
 */

public class ids {

    public static class idsBean {
        private String zhuanlanId;

        public String getZhuanlanId() {
            return zhuanlanId;
        }

        public void setZhuanlanId(String zhuanlanId) {
            this.zhuanlanId = zhuanlanId;
        }
    }

    @SerializedName("default")
    private List<idsBean> defaultX;

    private List<idsBean> movie;

    public List<idsBean> getDefaultX() {
        return defaultX;
    }

    public void setDefaultX(List<idsBean> defaultX) {
        this.defaultX = defaultX;
    }

    public List<idsBean> getMovie() {
        return movie;
    }

    public void setMovie(List<idsBean> movie) {
        this.movie = movie;
    }
}
