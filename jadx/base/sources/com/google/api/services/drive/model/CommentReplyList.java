package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class CommentReplyList extends GenericJson {

    @Key
    private List<CommentReply> items;

    @Key
    private String kind;

    @Key
    private String nextLink;

    @Key
    private String nextPageToken;

    @Key
    private String selfLink;

    static {
        Data.nullOf(CommentReply.class);
    }

    public List<CommentReply> getItems() {
        return this.items;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextLink() {
        return this.nextLink;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public CommentReplyList setItems(List<CommentReply> list) {
        this.items = list;
        return this;
    }

    public CommentReplyList setKind(String str) {
        this.kind = str;
        return this;
    }

    public CommentReplyList setNextLink(String str) {
        this.nextLink = str;
        return this;
    }

    public CommentReplyList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public CommentReplyList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CommentReplyList set(String str, Object obj) {
        return (CommentReplyList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CommentReplyList clone() {
        return (CommentReplyList) super.clone();
    }
}
