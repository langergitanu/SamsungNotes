package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = OldDBSchema.HashTagContent.TABLE_NAME)
public class NotesHashtagContentEntity {

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7390id;

    @ColumnInfo(defaultValue = "0", name = "isDeleted")
    private int isDeleted;

    @ColumnInfo(defaultValue = "1", name = "isDirty")
    private int isDirty;

    @ColumnInfo(defaultValue = "0", name = "isSyncFailed")
    private Integer isSyncFailed;

    @ColumnInfo(name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(defaultValue = "1464416139847", name = "serverTimestamp")
    private Long serverTimestamp;

    @NonNull
    @ColumnInfo(name = "sdocUUID")
    private String sdocUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "extraInfo")
    private String extraInfo = "";

    @NonNull
    @ColumnInfo(name = OldDBSchema.HashTagContent.HASHTAG_UUID)
    private String hashtagUuid = "";

    @NonNull
    public String getExtraInfo() {
        return this.extraInfo;
    }

    @NonNull
    public String getHashtagUuid() {
        return this.hashtagUuid;
    }

    public Long getId() {
        return this.f7390id;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    public Integer getIsSyncFailed() {
        return this.isSyncFailed;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @NonNull
    public String getSdocUuid() {
        return this.sdocUuid;
    }

    public Long getServerTimestamp() {
        return this.serverTimestamp;
    }

    public void setExtraInfo(@NonNull String str) {
        this.extraInfo = str;
    }

    public void setHashtagUuid(@NonNull String str) {
        this.hashtagUuid = str;
    }

    public void setId(Long l) {
        this.f7390id = l;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setIsDirty(int i) {
        this.isDirty = i;
    }

    public void setIsSyncFailed(Integer num) {
        this.isSyncFailed = num;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setSdocUuid(@NonNull String str) {
        this.sdocUuid = str;
    }

    public void setServerTimestamp(Long l) {
        this.serverTimestamp = l;
    }
}
