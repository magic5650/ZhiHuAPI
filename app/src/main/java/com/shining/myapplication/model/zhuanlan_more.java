package com.shining.myapplication.model;

import java.util.List;

/**
 * Created by Administrator on 2016-11-02.
 */

public class zhuanlan_more {
    /**
     * followersCount : 8008
     * creator : {"profileUrl":"https://www.zhihu.com/people/zou-johnny","bio":"cnspoon.com 财经媒体","hash":"a547a6125dc1f0c01da60178c80b4559","uid":40978794676224,"isOrg":false,"description":"欢迎关注专栏\u201c金与火之歌\u201d和cnspoon.com，同ID值乎https://www.zhihu.com/zhi/people/723438717636722688","slug":"zou-johnny","avatar":{"id":"ba7cb20f5","template":"https://pic2.zhimg.com/{id}_{size}.jpg"},"name":"zou johnny"}
     * topics : [{"url":"https://www.zhihu.com/topic/19628686","id":"19628686","name":"经济史"},{"url":"https://www.zhihu.com/topic/19609455","id":"19609455","name":"金融"},{"url":"https://www.zhihu.com/topic/19552981","id":"19552981","name":"经济"}]
     * activateState : activated
     * href : /api/columns/financialhistory
     * acceptSubmission : true
     * firstTime : false
     * postTopics : [{"postsCount":1,"id":281,"name":"财经"},{"postsCount":1,"id":472,"name":"美国"},{"postsCount":2,"id":922,"name":"经济"},{"postsCount":1,"id":1573,"name":"公益"},{"postsCount":1,"id":3858,"name":"人民币"},{"postsCount":1,"id":4550,"name":"汇率"},{"postsCount":1,"id":6004,"name":"改革"},{"postsCount":1,"id":6204,"name":"金融危机"},{"postsCount":1,"id":9177,"name":"欧洲历史"},{"postsCount":1,"id":16597,"name":"美国历史"},{"postsCount":1,"id":19800,"name":"金融"},{"postsCount":1,"id":24713,"name":"近代"},{"postsCount":4,"id":26237,"name":"经济史"},{"postsCount":1,"id":30640,"name":"货币政策"},{"postsCount":1,"id":36458,"name":"鸦片战争"},{"postsCount":1,"id":41169,"name":"欧洲经济"},{"postsCount":1,"id":167374,"name":"值乎"},{"postsCount":1,"id":168696,"name":"知乎 Live"}]
     * pendingName :
     * avatar : {"id":"e0feca25f196baa4352bbc2c725c6a52","template":"https://pic3.zhimg.com/{id}_{size}.jpg"}
     * canManage : false
     * description : 金融与历史交织的奏鸣曲
     * pendingTopics : []
     * nameCanEditUntil : 0
     * reason :
     * banUntil : 0
     * slug : financialhistory
     * name : 金与火之歌
     * url : /financialhistory
     * intro : 金融与历史交织的奏鸣曲
     * topicsCanEditUntil : 0
     * activateAuthorRequested : none
     * commentPermission : anyone
     * following : false
     * postsCount : 26
     * canPost : false
     */

    private int followersCount;
    /**
     * profileUrl : https://www.zhihu.com/people/zou-johnny
     * bio : cnspoon.com 财经媒体
     * hash : a547a6125dc1f0c01da60178c80b4559
     * uid : 40978794676224
     * isOrg : false
     * description : 欢迎关注专栏“金与火之歌”和cnspoon.com，同ID值乎https://www.zhihu.com/zhi/people/723438717636722688
     * slug : zou-johnny
     * avatar : {"id":"ba7cb20f5","template":"https://pic2.zhimg.com/{id}_{size}.jpg"}
     * name : zou johnny
     */

    private CreatorBean creator;
    private String activateState;
    private String href;
    private boolean acceptSubmission;
    private boolean firstTime;
    private String pendingName;
    /**
     * id : e0feca25f196baa4352bbc2c725c6a52
     * template : https://pic3.zhimg.com/{id}_{size}.jpg
     */

    private AvatarBean avatar;
    private boolean canManage;
    private String description;
    private int nameCanEditUntil;
    private String reason;
    private int banUntil;
    private String slug;
    private String name;
    private String url;
    private String intro;
    private int topicsCanEditUntil;
    private String activateAuthorRequested;
    private String commentPermission;
    private boolean following;
    private int postsCount;
    private boolean canPost;
    /**
     * url : https://www.zhihu.com/topic/19628686
     * id : 19628686
     * name : 经济史
     */

    private List<TopicsBean> topics;
    /**
     * postsCount : 1
     * id : 281
     * name : 财经
     */

    private List<PostTopicsBean> postTopics;
    private List<?> pendingTopics;

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public String getActivateState() {
        return activateState;
    }

    public void setActivateState(String activateState) {
        this.activateState = activateState;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isAcceptSubmission() {
        return acceptSubmission;
    }

    public void setAcceptSubmission(boolean acceptSubmission) {
        this.acceptSubmission = acceptSubmission;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    public String getPendingName() {
        return pendingName;
    }

    public void setPendingName(String pendingName) {
        this.pendingName = pendingName;
    }

    public AvatarBean getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarBean avatar) {
        this.avatar = avatar;
    }

    public boolean isCanManage() {
        return canManage;
    }

    public void setCanManage(boolean canManage) {
        this.canManage = canManage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNameCanEditUntil() {
        return nameCanEditUntil;
    }

    public void setNameCanEditUntil(int nameCanEditUntil) {
        this.nameCanEditUntil = nameCanEditUntil;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getBanUntil() {
        return banUntil;
    }

    public void setBanUntil(int banUntil) {
        this.banUntil = banUntil;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getTopicsCanEditUntil() {
        return topicsCanEditUntil;
    }

    public void setTopicsCanEditUntil(int topicsCanEditUntil) {
        this.topicsCanEditUntil = topicsCanEditUntil;
    }

    public String getActivateAuthorRequested() {
        return activateAuthorRequested;
    }

    public void setActivateAuthorRequested(String activateAuthorRequested) {
        this.activateAuthorRequested = activateAuthorRequested;
    }

    public String getCommentPermission() {
        return commentPermission;
    }

    public void setCommentPermission(String commentPermission) {
        this.commentPermission = commentPermission;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public boolean isCanPost() {
        return canPost;
    }

    public void setCanPost(boolean canPost) {
        this.canPost = canPost;
    }

    public List<TopicsBean> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicsBean> topics) {
        this.topics = topics;
    }

    public List<PostTopicsBean> getPostTopics() {
        return postTopics;
    }

    public void setPostTopics(List<PostTopicsBean> postTopics) {
        this.postTopics = postTopics;
    }

    public List<?> getPendingTopics() {
        return pendingTopics;
    }

    public void setPendingTopics(List<?> pendingTopics) {
        this.pendingTopics = pendingTopics;
    }

    public static class CreatorBean {
        private String profileUrl;
        private String bio;
        private String hash;
        private long uid;
        private boolean isOrg;
        private String description;
        private String slug;
        /**
         * id : ba7cb20f5
         * template : https://pic2.zhimg.com/{id}_{size}.jpg
         */

        private AvatarBean avatar;
        private String name;

        public String getProfileUrl() {
            return profileUrl;
        }

        public void setProfileUrl(String profileUrl) {
            this.profileUrl = profileUrl;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public boolean isIsOrg() {
            return isOrg;
        }

        public void setIsOrg(boolean isOrg) {
            this.isOrg = isOrg;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class AvatarBean {
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
        }
    }

    public static class AvatarBean {
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
    }

    public static class TopicsBean {
        private String url;
        private String id;
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class PostTopicsBean {
        private int postsCount;
        private int id;
        private String name;

        public int getPostsCount() {
            return postsCount;
        }

        public void setPostsCount(int postsCount) {
            this.postsCount = postsCount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
