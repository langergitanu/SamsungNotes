package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class StartPageToken extends GenericJson {

    @Key
    private String kind;

    @Key
    private String startPageToken;

    public String getKind() {
        return this.kind;
    }

    public String getStartPageToken() {
        return this.startPageToken;
    }

    public StartPageToken setKind(String str) {
        this.kind = str;
        return this;
    }

    public StartPageToken setStartPageToken(String str) {
        this.startPageToken = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public StartPageToken set(String str, Object obj) {
        return (StartPageToken) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public StartPageToken clone() {
        return (StartPageToken) super.clone();
    }
}
