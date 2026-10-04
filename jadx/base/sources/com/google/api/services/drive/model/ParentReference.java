package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ParentReference extends GenericJson {

    /* JADX INFO: renamed from: id */
    @Key
    private String f3261id;

    @Key
    private Boolean isRoot;

    @Key
    private String kind;

    @Key
    private String parentLink;

    @Key
    private String selfLink;

    public String getId() {
        return this.f3261id;
    }

    public Boolean getIsRoot() {
        return this.isRoot;
    }

    public String getKind() {
        return this.kind;
    }

    public String getParentLink() {
        return this.parentLink;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public ParentReference setId(String str) {
        this.f3261id = str;
        return this;
    }

    public ParentReference setIsRoot(Boolean bool) {
        this.isRoot = bool;
        return this;
    }

    public ParentReference setKind(String str) {
        this.kind = str;
        return this;
    }

    public ParentReference setParentLink(String str) {
        this.parentLink = str;
        return this;
    }

    public ParentReference setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ParentReference set(String str, Object obj) {
        return (ParentReference) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ParentReference clone() {
        return (ParentReference) super.clone();
    }
}
