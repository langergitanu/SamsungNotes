package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"documentUUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"})}, tableName = DBSchema.Sticky.TABLE_NAME)
public class StickyNoteEntity {

    @ColumnInfo(defaultValue = "0", name = "height")
    private int height;

    @ColumnInfo(defaultValue = "0", name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(defaultValue = "0", name = "width")
    private int width;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "objectId")
    private String objectId = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "documentUUID")
    private String documentUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "pageUuid")
    private String pageUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "filePath")
    private String filePath = "";

    @NonNull
    public String getDocumentUuid() {
        return this.documentUuid;
    }

    @NonNull
    public String getFilePath() {
        return this.filePath;
    }

    public int getHeight() {
        return this.height;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @NonNull
    public String getObjectId() {
        return this.objectId;
    }

    @NonNull
    public String getPageUuid() {
        return this.pageUuid;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDocumentUuid(@NonNull String str) {
        this.documentUuid = str;
    }

    public void setFilePath(@NonNull String str) {
        this.filePath = str;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setObjectId(@NonNull String str) {
        this.objectId = str;
    }

    public void setPageUuid(@NonNull String str) {
        this.pageUuid = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
