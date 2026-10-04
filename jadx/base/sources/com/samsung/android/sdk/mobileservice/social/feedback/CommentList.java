package com.samsung.android.sdk.mobileservice.social.feedback;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CommentList {
    private List<Comment> mComments;
    private String mNextCommentId;

    public CommentList(String str, List<Comment> list) {
        this.mNextCommentId = str;
        this.mComments = list;
    }

    public List<Comment> getComments() {
        return this.mComments;
    }

    public String getNextCommentId() {
        return this.mNextCommentId;
    }
}
