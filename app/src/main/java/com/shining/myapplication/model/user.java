package com.shining.myapplication.model;

import java.util.List;

/**
 * Created by Administrator on 2016-11-09.
 */

public class user {
    /**
     * followersCount : 10
     * creator : {"profileUrl":"https://www.zhihu.com/people/feng-tong-44","bio":"IQ catch chichen","hash":"8b0a51376541c2737a4f76b08dbbd0ff","uid":28298247667712,"isOrg":false,"description":"关注：信用卡、理财、薅羊毛、旅行、酒店、航空\n微信公众号：小玩家米斯特冯（minplayer）","slug":"feng-tong-44","avatar":{"id":"f4df10d9c5c32040f4d02071a17c0da3","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"name":"冯通"}
     * topics : [{"url":"https://www.zhihu.com/topic/19552521","id":"19552521","name":"JavaScript"},{"url":"https://www.zhihu.com/topic/19574050","id":"19574050","name":"Nginx"},{"url":"https://www.zhihu.com/topic/19554298","id":"19554298","name":"编程"}]
     * activateState : activated
     * href : /api/columns/littlegirl
     * acceptSubmission : true
     * firstTime : false
     * postTopics : [{"postsCount":2,"id":707,"name":"程序员"},{"postsCount":2,"id":1354,"name":"编程"},{"postsCount":1,"id":1355,"name":"Linux"},{"postsCount":1,"id":3246,"name":"数据统计"},{"postsCount":1,"id":3541,"name":"运维"},{"postsCount":1,"id":5921,"name":"Microsoft Excel"},{"postsCount":2,"id":7946,"name":"Nginx"},{"postsCount":1,"id":14763,"name":"压缩"},{"postsCount":1,"id":106042,"name":"base64"},{"postsCount":1,"id":112015,"name":"数据压缩"},{"postsCount":1,"id":129937,"name":"Excel 技巧"},{"postsCount":1,"id":162692,"name":"OpenResty"}]
     * pendingName :
     * avatar : {"id":"d1d1cf0fba08e781135ac5819e3441ec","template":"https://pic1.zhimg.com/{id}_{size}.jpeg"}
     * canManage : false
     * description : 专注 编程、数据分析、运维、设计等工作技能
     * pendingTopics : []
     * nameCanEditUntil : 0
     * reason :
     * banUntil : 0
     * slug : littlegirl
     * name : 小猿无知又可爱
     * url : /littlegirl
     * intro : 公众号：小猿无知又可爱（naivemonkey）
     * topicsCanEditUntil : 0
     * activateAuthorRequested : none
     * commentPermission : anyone
     * following : false
     * postsCount : 5
     * canPost : false
     */

    private int followersCount;
    /**
     * profileUrl : https://www.zhihu.com/people/feng-tong-44
     * bio : IQ catch chichen
     * hash : 8b0a51376541c2737a4f76b08dbbd0ff
     * uid : 28298247667712
     * isOrg : false
     * description : 关注：信用卡、理财、薅羊毛、旅行、酒店、航空
     微信公众号：小玩家米斯特冯（minplayer）
     * slug : feng-tong-44
     * avatar : {"id":"f4df10d9c5c32040f4d02071a17c0da3","template":"https://pic4.zhimg.com/{id}_{size}.jpg"}
     * name : 冯通
     */

    private CreatorBean creator;
    private String activateState;
    private String href;
    private boolean acceptSubmission;
    private boolean firstTime;
    private String pendingName;
    /**
     * id : d1d1cf0fba08e781135ac5819e3441ec
     * template : https://pic1.zhimg.com/{id}_{size}.jpeg
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
     * url : https://www.zhihu.com/topic/19552521
     * id : 19552521
     * name : JavaScript
     */

    private List<TopicsBean> topics;
    /**
     * postsCount : 2
     * id : 707
     * name : 程序员
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
         * id : f4df10d9c5c32040f4d02071a17c0da3
         * template : https://pic4.zhimg.com/{id}_{size}.jpg
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
