package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Comment extends GenericJson {

    @Key
    private String anchor;

    @Key
    private User author;

    @Key
    private String commentId;

    @Key
    private String content;

    @Key
    private Context context;

    @Key
    private DateTime createdDate;

    @Key
    private Boolean deleted;

    @Key
    private String fileId;

    @Key
    private String fileTitle;

    @Key
    private String htmlContent;

    @Key
    private String kind;

    @Key
    private DateTime modifiedDate;

    @Key
    private List<CommentReply> replies;

    @Key
    private String selfLink;

    @Key
    private String status;

    public String getAnchor() {
        return this.anchor;
    }

    public User getAuthor() {
        return this.author;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getContent() {
        return this.content;
    }

    public Context getContext() {
        return this.context;
    }

    public DateTime getCreatedDate() {
        return this.createdDate;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileTitle() {
        return this.fileTitle;
    }

    public String getHtmlContent() {
        return this.htmlContent;
    }

    public String getKind() {
        return this.kind;
    }

    public DateTime getModifiedDate() {
        return this.modifiedDate;
    }

    public List<CommentReply> getReplies() {
        return this.replies;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public String getStatus() {
        return this.status;
    }

    public Comment setAnchor(String str) {
        this.anchor = str;
        return this;
    }

    public Comment setAuthor(User user) {
        this.author = user;
        return this;
    }

    public Comment setCommentId(String str) {
        this.commentId = str;
        return this;
    }

    public Comment setContent(String str) {
        this.content = str;
        return this;
    }

    public Comment setContext(Context context) {
        this.context = context;
        return this;
    }

    public Comment setCreatedDate(DateTime dateTime) {
        this.createdDate = dateTime;
        return this;
    }

    public Comment setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Comment setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public Comment setFileTitle(String str) {
        this.fileTitle = str;
        return this;
    }

    public Comment setHtmlContent(String str) {
        this.htmlContent = str;
        return this;
    }

    public Comment setKind(String str) {
        this.kind = str;
        return this;
    }

    public Comment setModifiedDate(DateTime dateTime) {
        this.modifiedDate = dateTime;
        return this;
    }

    public Comment setReplies(List<CommentReply> list) {
        this.replies = list;
        return this;
    }

    public Comment setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public Comment setStatus(String str) {
        this.status = str;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Context extends GenericJson {

        @Key
        private String type;

        @Key
        private String value;

        public String getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }

        public Context setType(String str) {
            this.type = str;
            return this;
        }

        public Context setValue(String str) {
            this.value = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Context set(String str, Object obj) {
            return (Context) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Context clone() {
            return (Context) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Comment set(String str, Object obj) {
        return (Comment) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Comment clone() {
        return (Comment) super.clone();
    }
}
