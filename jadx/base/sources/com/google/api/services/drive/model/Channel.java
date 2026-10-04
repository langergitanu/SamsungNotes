package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Channel extends GenericJson {

    @Key
    private String address;

    @JsonString
    @Key
    private Long expiration;

    /* JADX INFO: renamed from: id */
    @Key
    private String f3258id;

    @Key
    private String kind;

    @Key
    private Map<String, String> params;

    @Key
    private Boolean payload;

    @Key
    private String resourceId;

    @Key
    private String resourceUri;

    @Key
    private String token;

    @Key
    private String type;

    public String getAddress() {
        return this.address;
    }

    public Long getExpiration() {
        return this.expiration;
    }

    public String getId() {
        return this.f3258id;
    }

    public String getKind() {
        return this.kind;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public Boolean getPayload() {
        return this.payload;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getResourceUri() {
        return this.resourceUri;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public Channel setAddress(String str) {
        this.address = str;
        return this;
    }

    public Channel setExpiration(Long l) {
        this.expiration = l;
        return this;
    }

    public Channel setId(String str) {
        this.f3258id = str;
        return this;
    }

    public Channel setKind(String str) {
        this.kind = str;
        return this;
    }

    public Channel setParams(Map<String, String> map) {
        this.params = map;
        return this;
    }

    public Channel setPayload(Boolean bool) {
        this.payload = bool;
        return this;
    }

    public Channel setResourceId(String str) {
        this.resourceId = str;
        return this;
    }

    public Channel setResourceUri(String str) {
        this.resourceUri = str;
        return this;
    }

    public Channel setToken(String str) {
        this.token = str;
        return this;
    }

    public Channel setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Channel set(String str, Object obj) {
        return (Channel) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Channel clone() {
        return (Channel) super.clone();
    }
}
