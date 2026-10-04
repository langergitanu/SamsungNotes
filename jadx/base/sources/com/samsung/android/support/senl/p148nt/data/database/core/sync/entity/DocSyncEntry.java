package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import androidx.room.ColumnInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocSyncEntry {

    @ColumnInfo(name = DBSchema.Document.LOCK_ACCOUNT_GUID)
    private String lockAccountGuid;

    @ColumnInfo(name = "filePath")
    private String filePath = "";

    @ColumnInfo(name = "serverTimestamp")
    private Long serverTimestamp = 1464416139847L;

    @ColumnInfo(name = DBSchema.Document.CATEGORY_SERVER_TIMESTAMP)
    private Long categoryServerTimeStamp = 1464416139847L;

    @ColumnInfo(name = "title")
    private String title = "";

    @ColumnInfo(name = "isFavorite")
    private int isFavorite = 0;

    @ColumnInfo(name = "categoryUUID")
    private String categoryUuid = "uncategorized:///";

    @ColumnInfo(name = "isDeleted")
    private int isDeleted = 0;

    @ColumnInfo(name = DBSchema.Document.LAST_MAPPED_AT)
    private long lastMappedAt = 0;

    @ColumnInfo(name = "lastModifiedAt")
    private long lastModifiedAt = 0;

    @ColumnInfo(name = "isLock")
    private int isLock = 0;

    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @ColumnInfo(name = DBSchema.Document.CATEGORY_IS_DIRTY)
    private int categoryIsDirty = 1;

    @ColumnInfo(name = "isDirty")
    private int isDirty = 1;

    public int getCategoryIsDirty() {
        return this.categoryIsDirty;
    }

    public Long getCategoryServerTimeStamp() {
        return this.categoryServerTimeStamp;
    }

    public String getCategoryUuid() {
        return this.categoryUuid;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    public int getIsFavorite() {
        return this.isFavorite;
    }

    public int getIsLock() {
        return this.isLock;
    }

    public long getLastMappedAt() {
        return this.lastMappedAt;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public String getLockAccountGuid() {
        return this.lockAccountGuid;
    }

    public Long getServerTimestamp() {
        return this.serverTimestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setCategoryIsDirty(int i) {
        this.categoryIsDirty = i;
    }

    public void setCategoryServerTimeStamp(Long l) {
        this.categoryServerTimeStamp = l;
    }

    public void setCategoryUuid(String str) {
        this.categoryUuid = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setIsDirty(int i) {
        this.isDirty = i;
    }

    public void setIsFavorite(int i) {
        this.isFavorite = i;
    }

    public void setIsLock(int i) {
        this.isLock = i;
    }

    public void setLastMappedAt(long j) {
        this.lastMappedAt = j;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setLockAccountGuid(String str) {
        this.lockAccountGuid = str;
    }

    public void setServerTimestamp(Long l) {
        this.serverTimestamp = l;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}
