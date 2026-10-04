package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class AppList extends GenericJson {

    @Key
    private List<String> defaultAppIds;

    @Key
    private String etag;

    @Key
    private List<App> items;

    @Key
    private String kind;

    @Key
    private String selfLink;

    static {
        Data.nullOf(App.class);
    }

    public List<String> getDefaultAppIds() {
        return this.defaultAppIds;
    }

    public String getEtag() {
        return this.etag;
    }

    public List<App> getItems() {
        return this.items;
    }

    public String getKind() {
        return this.kind;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public AppList setDefaultAppIds(List<String> list) {
        this.defaultAppIds = list;
        return this;
    }

    public AppList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public AppList setItems(List<App> list) {
        this.items = list;
        return this;
    }

    public AppList setKind(String str) {
        this.kind = str;
        return this;
    }

    public AppList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public AppList set(String str, Object obj) {
        return (AppList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AppList clone() {
        return (AppList) super.clone();
    }
}
