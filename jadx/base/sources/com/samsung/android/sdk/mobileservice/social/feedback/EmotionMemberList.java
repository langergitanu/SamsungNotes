package com.samsung.android.sdk.mobileservice.social.feedback;

import com.samsung.android.sdk.mobileservice.social.feedback.ContentId;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class EmotionMemberList<T extends ContentId> {
    private String mCommentId;
    private T mContentId;
    private List<EmotionMember> mEmotionMemberList;
    private String mNextMemberGuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EmotionMember {
        private int mEmotionType;
        private long mUpdateTime;
        private UserProfile mUserProfile;

        public EmotionMember(UserProfile userProfile, long j, int i) {
            this.mUserProfile = userProfile;
            this.mUpdateTime = j;
            this.mEmotionType = i;
        }

        public int getEmotionType() {
            return this.mEmotionType;
        }

        public long getUpdateTime() {
            return this.mUpdateTime;
        }

        public UserProfile getUserProfile() {
            return this.mUserProfile;
        }
    }

    public EmotionMemberList(T t, String str, String str2, List<EmotionMember> list) {
        this.mContentId = t;
        this.mCommentId = str;
        this.mNextMemberGuid = str2;
        this.mEmotionMemberList = list;
    }

    public String getCommentId() {
        return this.mCommentId;
    }

    public T getContentId() {
        return this.mContentId;
    }

    public List<EmotionMember> getEmotionMemberList() {
        return this.mEmotionMemberList;
    }

    public String getNextMemberGuid() {
        return this.mNextMemberGuid;
    }
}
