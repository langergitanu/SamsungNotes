package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class CommentReply extends GenericJson {

    @Key
    private User author;

    @Key
    private String content;

    @Key
    private DateTime createdDate;

    @Key
    private Boolean deleted;

    @Key
    private String htmlContent;

    @Key
    private String kind;

    @Key
    private DateTime modifiedDate;

    @Key
    private String replyId;

    @Key
    private String verb;

    public User getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public DateTime getCreatedDate() {
        return this.createdDate;
    }

    public Boolean getDeleted() {
        return this.deleted;
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

    public String getReplyId() {
        return this.replyId;
    }

    public String getVerb() {
        return this.verb;
    }

    public CommentReply setAuthor(User user) {
        this.author = user;
        return this;
    }

    public CommentReply setContent(String str) {
        this.content = str;
        return this;
    }

    public CommentReply setCreatedDate(DateTime dateTime) {
        this.createdDate = dateTime;
        return this;
    }

    public CommentReply setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public CommentReply setHtmlContent(String str) {
        this.htmlContent = str;
        return this;
    }

    public CommentReply setKind(String str) {
        this.kind = str;
        return this;
    }

    public CommentReply setModifiedDate(DateTime dateTime) {
        this.modifiedDate = dateTime;
        return this;
    }

    public CommentReply setReplyId(String str) {
        this.replyId = str;
        return this;
    }

    public CommentReply setVerb(String str) {
        this.verb = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CommentReply set(String str, Object obj) {
        return (CommentReply) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CommentReply clone() {
        return (CommentReply) super.clone();
    }
}
