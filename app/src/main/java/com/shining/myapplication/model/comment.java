package com.shining.myapplication.model;

/**
 * Created by Administrator on 2016-11-09.
 */

public class comment {
    /**
     * content : 手赞
     * liked : false
     * href : /api/posts/22991825/comments/174694712
     * inReplyToCommentId : 0
     * reviewing : false
     * author : {"profileUrl":"https://www.zhihu.com/people/liu-nathan-58","bio":"人艰不拆","hash":"0198a721cb0678fea6213c5312287d5b","uid":59446415851520,"isOrg":false,"description":"","slug":"liu-nathan-58","avatar":{"id":"6fdb20d31c84bd9e2c175fac453fc3ab","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"name":"Liu Nathan"}
     * createdTime : 2016-10-16T21:53:41+08:00
     * featured : false
     * id : 174694712
     * likesCount : 0
     */

    private String content;
    private boolean liked;
    private String href;
    private int inReplyToCommentId;
    private boolean reviewing;
    /**
     * profileUrl : https://www.zhihu.com/people/liu-nathan-58
     * bio : 人艰不拆
     * hash : 0198a721cb0678fea6213c5312287d5b
     * uid : 59446415851520
     * isOrg : false
     * description :
     * slug : liu-nathan-58
     * avatar : {"id":"6fdb20d31c84bd9e2c175fac453fc3ab","template":"https://pic4.zhimg.com/{id}_{size}.jpg"}
     * name : Liu Nathan
     */

    private AuthorBean author;
    private String createdTime;
    private boolean featured;
    private int id;
    private int likesCount;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getInReplyToCommentId() {
        return inReplyToCommentId;
    }

    public void setInReplyToCommentId(int inReplyToCommentId) {
        this.inReplyToCommentId = inReplyToCommentId;
    }

    public boolean isReviewing() {
        return reviewing;
    }

    public void setReviewing(boolean reviewing) {
        this.reviewing = reviewing;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public static class AuthorBean {
        private String profileUrl;
        private String bio;
        private String hash;
        private long uid;
        private boolean isOrg;
        private String description;
        private String slug;
        /**
         * id : 6fdb20d31c84bd9e2c175fac453fc3ab
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
}
