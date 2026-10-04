package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"UUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"})}, tableName = DBSchema.DocumentExtra.TABLE_NAME)
public class DocumentExtraEntity {

    @ColumnInfo(defaultValue = "0", name = "hasImage")
    private int hasImage;

    @ColumnInfo(defaultValue = "0", name = "hasPdf")
    private int hasPdf;

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentExtra.HAS_STICKY)
    private int hasSticky;

    @ColumnInfo(defaultValue = "0", name = "hasStroke")
    private int hasStroke;

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentExtra.UNKNOWN_MIN_VERSION)
    private int unknownMinVersion;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentExtra.FORMAT_VERSION)
    private int formatVersion = 0;

    public int getFormatVersion() {
        return this.formatVersion;
    }

    public int getHasImage() {
        return this.hasImage;
    }

    public int getHasPdf() {
        return this.hasPdf;
    }

    public int getHasSticky() {
        return this.hasSticky;
    }

    public int getHasStroke() {
        return this.hasStroke;
    }

    public int getUnknownMinVersion() {
        return this.unknownMinVersion;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setFormatVersion(int i) {
        this.formatVersion = i;
    }

    public void setHasImage(int i) {
        this.hasImage = i;
    }

    public void setHasPdf(int i) {
        this.hasPdf = i;
    }

    public void setHasSticky(int i) {
        this.hasSticky = i;
    }

    public void setHasStroke(int i) {
        this.hasStroke = i;
    }

    public void setUnknownMinVersion(int i) {
        this.unknownMinVersion = i;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
