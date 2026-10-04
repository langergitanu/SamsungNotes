package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = OldDBSchema.HashTag.TABLE_NAME)
public class NotesHashtagEntity {

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7391id;

    @ColumnInfo(defaultValue = "0", name = "isDeleted")
    private int isDeleted;

    @ColumnInfo(defaultValue = "1", name = "isDirty")
    private int isDirty;

    @ColumnInfo(name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(defaultValue = "1464416139847", name = "serverTimestamp")
    private Long serverTimestamp;

    @NonNull
    @ColumnInfo(name = "name")
    private String name = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "extraInfo")
    private String extraInfo = "";

    @NonNull
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @NonNull
    public String getExtraInfo() {
        return this.extraInfo;
    }

    public Long getId() {
        return this.f7391id;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public Long getServerTimestamp() {
        return this.serverTimestamp;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setExtraInfo(@NonNull String str) {
        this.extraInfo = str;
    }

    public void setId(Long l) {
        this.f7391id = l;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setIsDirty(int i) {
        this.isDirty = i;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setName(@NonNull String str) {
        this.name = str;
    }

    public void setServerTimestamp(Long l) {
        this.serverTimestamp = l;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
