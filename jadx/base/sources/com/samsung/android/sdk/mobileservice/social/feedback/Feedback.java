package com.samsung.android.sdk.mobileservice.social.feedback;

import com.samsung.android.sdk.mobileservice.social.feedback.ContentId;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Feedback<T extends ContentId> {
    private CommentList mCommentList;
    private T mContentId;
    private EmotionList mEmotionList;
    private int mTotalCommentCount;

    public Feedback(T t, EmotionList emotionList, int i, CommentList commentList) {
        this.mContentId = t;
        this.mEmotionList = emotionList;
        this.mTotalCommentCount = i;
        this.mCommentList = commentList;
    }

    public CommentList getCommentList() {
        return this.mCommentList;
    }

    public T getContentId() {
        return this.mContentId;
    }

    public EmotionList getEmotionList() {
        return this.mEmotionList;
    }

    public int getTotalCommentCount() {
        return this.mTotalCommentCount;
    }
}
