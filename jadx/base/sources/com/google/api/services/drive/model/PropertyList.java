package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class PropertyList extends GenericJson {

    @Key
    private String etag;

    @Key
    private List<Property> items;

    @Key
    private String kind;

    @Key
    private String selfLink;

    static {
        Data.nullOf(Property.class);
    }

    public String getEtag() {
        return this.etag;
    }

    public List<Property> getItems() {
        return this.items;
    }

    public String getKind() {
        return this.kind;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public PropertyList setEtag(String str) {
        this.etag = str;
        return this;
    }

    public PropertyList setItems(List<Property> list) {
        this.items = list;
        return this;
    }

    public PropertyList setKind(String str) {
        this.kind = str;
        return this;
    }

    public PropertyList setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PropertyList set(String str, Object obj) {
        return (PropertyList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PropertyList clone() {
        return (PropertyList) super.clone();
    }
}
