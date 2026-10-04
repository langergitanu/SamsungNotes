package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = DBSchema.CoverTemplate.TABLE_NAME)
public class CoverTemplateEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "path")
    private String path = "";

    @ColumnInfo(defaultValue = "0", name = "createdAt")
    private long createdAt = 0;

    @ColumnInfo(defaultValue = "0", name = "lastModifiedAt")
    private long lastModifiedAt = 0;

    @ColumnInfo(defaultValue = "0", name = "type")
    private int type = 0;

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @NonNull
    public String getPath() {
        return this.path;
    }

    @CoverConstants.Type
    public int getType() {
        return this.type;
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

    public void setPath(@NonNull String str) {
        this.path = str;
    }

    public void setType(@CoverConstants.Type int i) {
        this.type = i;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
