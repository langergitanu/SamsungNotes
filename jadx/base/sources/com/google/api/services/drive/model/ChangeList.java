package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ChangeList extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Change> items;

    @Key
    private String kind;

    @JsonString
    @Key
    private Long largestChangeId;

    @Key
    private String newStartPageToken;

    @Key
    private String nextLink;

    @Key
    private String nextPageToken;

    @Key
    private String selfLink;

    static {
        Data.nullOf(Change.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public List<Change> getItems() {
        return this.items;
    }

    public String getKind() {
        return this.kind;
    }

    public Long getLargestChangeId() {
        return this.largestChangeId;
    }

    public String getNewStartPageToken() {
        return this.newStartPageToken;
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

    public ChangeList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public ChangeList setItems(List<Change> list) {
        this.items = list;
        return this;
    }

    public ChangeList setKind(String str) {
        this.kind = str;
        return this;
    }

    public ChangeList setLargestChangeId(Long l) {
        this.largestChangeId = l;
        return this;
    }

    public ChangeList setNewStartPageToken(String str) {
        this.newStartPageToken = str;
        return this;
    }

    public ChangeList setNextLink(String str) {
        this.nextLink = str;
        return this;
    }

    public ChangeList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public ChangeList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ChangeList set(String str, Object obj) {
        return (ChangeList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ChangeList clone() {
        return (ChangeList) super.clone();
    }
}
