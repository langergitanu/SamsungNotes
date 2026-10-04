package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {DBSchema.MappedDocument.MAPPED_UUID})}, tableName = DBSchema.MappedDocument.TABLE_NAME)
public class NotesMappedDocumentEntity {

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long f7392id;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.MappedDocument.MAPPED_UUID)
    private String mappedUuid = "";

    @ColumnInfo(defaultValue = "1", name = "converted")
    private int isConverted = 1;

    @ColumnInfo(defaultValue = "0", name = DBSchema.MappedDocument.MAPPED_AT)
    private long mappedAt = 0;

    public long getId() {
        return this.f7392id;
    }

    public int getIsConverted() {
        return this.isConverted;
    }

    public long getMappedAt() {
        return this.mappedAt;
    }

    @NonNull
    public String getMappedUuid() {
        return this.mappedUuid;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setId(long j) {
        this.f7392id = j;
    }

    public void setIsConverted(int i) {
        this.isConverted = i;
    }

    public void setMappedAt(long j) {
        this.mappedAt = j;
    }

    public void setMappedUuid(@NonNull String str) {
        this.mappedUuid = str;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("NotesMappedDocumentEntity{id=");
        sb.append(this.f7392id);
        sb.append(", uuid='");
        sb.append(this.uuid);
        sb.append("', mappedUuid='");
        sb.append(this.mappedUuid);
        sb.append("', isConverted=");
        sb.append(this.isConverted);
        sb.append(", mappedAt=");
        return AbstractC2821a.m2224o(sb, "}", this.mappedAt);
    }
}
