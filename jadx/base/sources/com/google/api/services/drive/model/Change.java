package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Change extends GenericJson {

    @Key
    private Boolean deleted;

    @Key
    private File file;

    @Key
    private String fileId;

    /* JADX INFO: renamed from: id */
    @JsonString
    @Key
    private Long f3257id;

    @Key
    private String kind;

    @Key
    private DateTime modificationDate;

    @Key
    private String selfLink;

    @Key
    private TeamDrive teamDrive;

    @Key
    private String teamDriveId;

    @Key
    private String type;

    public Boolean getDeleted() {
        return this.deleted;
    }

    public File getFile() {
        return this.file;
    }

    public String getFileId() {
        return this.fileId;
    }

    public Long getId() {
        return this.f3257id;
    }

    public String getKind() {
        return this.kind;
    }

    public DateTime getModificationDate() {
        return this.modificationDate;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public TeamDrive getTeamDrive() {
        return this.teamDrive;
    }

    public String getTeamDriveId() {
        return this.teamDriveId;
    }

    public String getType() {
        return this.type;
    }

    public Change setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Change setFile(File file) {
        this.file = file;
        return this;
    }

    public Change setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public Change setId(Long l) {
        this.f3257id = l;
        return this;
    }

    public Change setKind(String str) {
        this.kind = str;
        return this;
    }

    public Change setModificationDate(DateTime dateTime) {
        this.modificationDate = dateTime;
        return this;
    }

    public Change setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public Change setTeamDrive(TeamDrive teamDrive) {
        this.teamDrive = teamDrive;
        return this;
    }

    public Change setTeamDriveId(String str) {
        this.teamDriveId = str;
        return this;
    }

    public Change setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Change set(String str, Object obj) {
        return (Change) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Change clone() {
        return (Change) super.clone();
    }
}
