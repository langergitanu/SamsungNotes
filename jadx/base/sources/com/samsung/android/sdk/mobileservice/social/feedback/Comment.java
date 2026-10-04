package com.samsung.android.sdk.mobileservice.social.feedback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Comment {
    private String mComment;
    private String mCommentId;
    private long mCreatedTime;
    private EmotionList mEmotionList;
    private UserProfile mOwnerProfile;

    public Comment(String str, String str2, UserProfile userProfile, long j, EmotionList emotionList) {
        this.mCommentId = str;
        this.mComment = str2;
        this.mOwnerProfile = userProfile;
        this.mCreatedTime = j;
        this.mEmotionList = emotionList;
    }

    public String getComment() {
        return this.mComment;
    }

    public String getCommentId() {
        return this.mCommentId;
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public EmotionList getEmotionList() {
        return this.mEmotionList;
    }

    public UserProfile getOwnerProfile() {
        return this.mOwnerProfile;
    }
}
