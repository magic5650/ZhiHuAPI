package com.shining.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016-10-31.
 */

public class zhuanlan implements Parcelable {

    /**
     * followersCount : 16086
     * name : 太空堡垒
     * url : /Battlestar
     * postsCount : 57
     * description : 看过的电影，走过的路
     * slug : Battlestar
     * avatar : {"id":"8ad0cbbb0","template":"https://pic1.zhimg.com/{id}_{size}.jpg"}
     */

    private int followersCount;
    private String name;
    private String url;
    private int postsCount;
    private String description;
    private String slug;
    /**
     * id : 8ad0cbbb0
     * template : https://pic1.zhimg.com/{id}_{size}.jpg
     */

    private AvatarBean avatar;

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public AvatarBean getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarBean avatar) {
        this.avatar = avatar;
    }

    public static class AvatarBean implements Parcelable {
        private String id;
        private String template;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.template);
        }

        public AvatarBean() {
        }

        protected AvatarBean(Parcel in) {
            this.id = in.readString();
            this.template = in.readString();
        }

        public static final Parcelable.Creator<AvatarBean> CREATOR = new Parcelable.Creator<AvatarBean>() {
            @Override
            public AvatarBean createFromParcel(Parcel source) {
                return new AvatarBean(source);
            }

            @Override
            public AvatarBean[] newArray(int size) {
                return new AvatarBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.followersCount);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeInt(this.postsCount);
        dest.writeString(this.description);
        dest.writeString(this.slug);
        dest.writeParcelable(this.avatar, flags);
    }

    public zhuanlan() {
    }

    protected zhuanlan(Parcel in) {
        this.followersCount = in.readInt();
        this.name = in.readString();
        this.url = in.readString();
        this.postsCount = in.readInt();
        this.description = in.readString();
        this.slug = in.readString();
        this.avatar = in.readParcelable(AvatarBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<zhuanlan> CREATOR = new Parcelable.Creator<zhuanlan>() {
        @Override
        public zhuanlan createFromParcel(Parcel source) {
            return new zhuanlan(source);
        }

        @Override
        public zhuanlan[] newArray(int size) {
            return new zhuanlan[size];
        }
    };
}
