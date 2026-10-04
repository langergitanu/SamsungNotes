package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ChildList extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<ChildReference> items;

    @Key
    private String kind;

    @Key
    private String nextLink;

    @Key
    private String nextPageToken;

    @Key
    private String selfLink;

    public String getEtag() {
        return this.etag;
    }

    public List<ChildReference> getItems() {
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

    public ChildList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public ChildList setItems(List<ChildReference> list) {
        this.items = list;
        return this;
    }

    public ChildList setKind(String str) {
        this.kind = str;
        return this;
    }

    public ChildList setNextLink(String str) {
        this.nextLink = str;
        return this;
    }

    public ChildList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public ChildList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ChildList set(String str, Object obj) {
        return (ChildList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ChildList clone() {
        return (ChildList) super.clone();
    }
}
