package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {"UUID"}), @Index({"sdocUUID"})}, tableName = "content")
public class NotesContentEntity {

    @ColumnInfo(defaultValue = "", name = "accountName")
    private String accountName;

    @ColumnInfo(name = "accountType")
    private String accountType;

    @ColumnInfo(defaultValue = "0", name = "contentSecureVersion")
    private int contentSecureVersion;

    @ColumnInfo(name = "data", typeAffinity = 5)
    private byte[] data;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7388id;

    @ColumnInfo(defaultValue = "0", name = "isDeleted")
    private int isDeleted;

    @ColumnInfo(defaultValue = "1", name = "isDirty")
    private int isDirty;

    @ColumnInfo(defaultValue = "", name = "_data")
    private String mediaData;

    @ColumnInfo(name = "srcID")
    private int srcId;

    @NonNull
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(name = "sdocUUID")
    private String sdocUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "application/octet-stream", name = "mime_type")
    private String mimeType = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "displayName")
    private String displayName = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "filePath")
    private String filePath = "";

    @ColumnInfo(defaultValue = "0", name = "createdAt")
    private long createdAt = 0;

    @ColumnInfo(defaultValue = "0", name = "size")
    private long size = 0;

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public int getContentSecureVersion() {
        return this.contentSecureVersion;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public byte[] getData() {
        return this.data;
    }

    @NonNull
    public String getDisplayName() {
        return this.displayName;
    }

    @NonNull
    public String getFilePath() {
        return this.filePath;
    }

    public Long getId() {
        return this.f7388id;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    public String getMediaData() {
        return this.mediaData;
    }

    @NonNull
    @DataConstants.MIME_TYPE
    public String getMimeType() {
        return this.mimeType;
    }

    @NonNull
    public String getSdocUuid() {
        return this.sdocUuid;
    }

    public long getSize() {
        return this.size;
    }

    public int getSrcId() {
        return this.srcId;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setContentSecureVersion(int i) {
        this.contentSecureVersion = i;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDisplayName(@NonNull String str) {
        this.displayName = str;
    }

    public void setFilePath(@NonNull String str) {
        this.filePath = str;
    }

    public void setId(Long l) {
        this.f7388id = l;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setIsDirty(int i) {
        this.isDirty = i;
    }

    public void setMediaData(String str) {
        this.mediaData = str;
    }

    public void setMimeType(@DataConstants.MIME_TYPE String str) {
        this.mimeType = str;
    }

    public void setSdocUuid(@NonNull String str) {
        this.sdocUuid = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setSrcId(int i) {
        this.srcId = i;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
