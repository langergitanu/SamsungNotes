package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ChildReference extends GenericJson {

    @Key
    private String childLink;

    /* JADX INFO: renamed from: id */
    @Key
    private String f3259id;

    @Key
    private String kind;

    @Key
    private String selfLink;

    public String getChildLink() {
        return this.childLink;
    }

    public String getId() {
        return this.f3259id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public ChildReference setChildLink(String str) {
        this.childLink = str;
        return this;
    }

    public ChildReference setId(String str) {
        this.f3259id = str;
        return this;
    }

    public ChildReference setKind(String str) {
        this.kind = str;
        return this;
    }

    public ChildReference setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ChildReference set(String str, Object obj) {
        return (ChildReference) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ChildReference clone() {
        return (ChildReference) super.clone();
    }
}
