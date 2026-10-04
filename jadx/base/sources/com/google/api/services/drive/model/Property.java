package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Property extends GenericJson {

    @Key
    private String etag;

    @Key
    private String key;

    @Key
    private String kind;

    @Key
    private String selfLink;

    @Key
    private String value;

    @Key
    private String visibility;

    public String getEtag() {
        return this.etag;
    }

    public String getKey() {
        return this.key;
    }

    public String getKind() {
        return this.kind;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public String getValue() {
        return this.value;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public Property setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Property setKey(String str) {
        this.key = str;
        return this;
    }

    public Property setKind(String str) {
        this.kind = str;
        return this;
    }

    public Property setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public Property setValue(String str) {
        this.value = str;
        return this;
    }

    public Property setVisibility(String str) {
        this.visibility = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Property set(String str, Object obj) {
        return (Property) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Property clone() {
        return (Property) super.clone();
    }
}
