package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class TeamDriveList extends GenericJson {

    @Key
    private List<TeamDrive> items;

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    static {
        Data.nullOf(TeamDrive.class);
    }

    public List<TeamDrive> getItems() {
        return this.items;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public TeamDriveList setItems(List<TeamDrive> list) {
        this.items = list;
        return this;
    }

    public TeamDriveList setKind(String str) {
        this.kind = str;
        return this;
    }

    public TeamDriveList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public TeamDriveList set(String str, Object obj) {
        return (TeamDriveList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public TeamDriveList clone() {
        return (TeamDriveList) super.clone();
    }
}
