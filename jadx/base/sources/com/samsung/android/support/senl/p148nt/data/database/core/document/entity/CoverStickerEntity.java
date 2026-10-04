package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = DBSchema.CoverSticker.TABLE_NAME)
public class CoverStickerEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "name")
    private String name = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.CoverSticker.ICON_PATH)
    private String path = "";

    @ColumnInfo(defaultValue = "0", name = "createdAt")
    private long createdAt = 0;

    @ColumnInfo(defaultValue = "0", name = "lastModifiedAt")
    private long lastModifiedAt = 0;

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @NonNull
    public String getPath() {
        return this.path;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setName(@NonNull String str) {
        this.name = str;
    }

    public void setPath(@NonNull String str) {
        this.path = str;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
