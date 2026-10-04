package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class PermissionList extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Permission> items;

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    @Key
    private String selfLink;

    static {
        Data.nullOf(Permission.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public List<Permission> getItems() {
        return this.items;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public PermissionList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public PermissionList setItems(List<Permission> list) {
        this.items = list;
        return this;
    }

    public PermissionList setKind(String str) {
        this.kind = str;
        return this;
    }

    public PermissionList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public PermissionList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PermissionList set(String str, Object obj) {
        return (PermissionList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PermissionList clone() {
        return (PermissionList) super.clone();
    }
}
