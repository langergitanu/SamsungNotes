package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class GeneratedIds extends GenericJson {

    @Key
    private List<String> ids;

    @Key
    private String kind;

    @Key
    private String space;

    public List<String> getIds() {
        return this.ids;
    }

    public String getKind() {
        return this.kind;
    }

    public String getSpace() {
        return this.space;
    }

    public GeneratedIds setIds(List<String> list) {
        this.ids = list;
        return this;
    }

    public GeneratedIds setKind(String str) {
        this.kind = str;
        return this;
    }

    public GeneratedIds setSpace(String str) {
        this.space = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public GeneratedIds set(String str, Object obj) {
        return (GeneratedIds) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public GeneratedIds clone() {
        return (GeneratedIds) super.clone();
    }
}
