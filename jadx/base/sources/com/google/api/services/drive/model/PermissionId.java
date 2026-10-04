package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class PermissionId extends GenericJson {

    /* JADX INFO: renamed from: id */
    @Key
    private String f3263id;

    @Key
    private String kind;

    public String getId() {
        return this.f3263id;
    }

    public String getKind() {
        return this.kind;
    }

    public PermissionId setId(String str) {
        this.f3263id = str;
        return this;
    }

    public PermissionId setKind(String str) {
        this.kind = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PermissionId set(String str, Object obj) {
        return (PermissionId) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PermissionId clone() {
        return (PermissionId) super.clone();
    }
}
