package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class FileList extends GenericJson {

    @Key
    private String etag;

    @Key
    private Boolean incompleteSearch;

    @Key
    private List<File> items;

    @Key
    private String kind;

    @Key
    private String nextLink;

    @Key
    private String nextPageToken;

    @Key
    private String selfLink;

    static {
        Data.nullOf(File.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public Boolean getIncompleteSearch() {
        return this.incompleteSearch;
    }

    public List<File> getItems() {
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

    public FileList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public FileList setIncompleteSearch(Boolean bool) {
        this.incompleteSearch = bool;
        return this;
    }

    public FileList setItems(List<File> list) {
        this.items = list;
        return this;
    }

    public FileList setKind(String str) {
        this.kind = str;
        return this;
    }

    public FileList setNextLink(String str) {
        this.nextLink = str;
        return this;
    }

    public FileList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public FileList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public FileList set(String str, Object obj) {
        return (FileList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public FileList clone() {
        return (FileList) super.clone();
    }
}
