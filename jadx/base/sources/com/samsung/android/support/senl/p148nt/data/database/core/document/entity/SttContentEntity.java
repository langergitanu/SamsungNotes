package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"documentUUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"})}, indices = {@Index({"documentUUID", "filePath", "type"})}, tableName = DBSchema.SttContent.TABLE_NAME)
public class SttContentEntity {

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long f7399id;

    @ColumnInfo(defaultValue = "0", name = "index")
    private int index;

    @ColumnInfo(defaultValue = "0", name = "lastModifiedAt")
    private long lastModifiedAt;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "documentUUID")
    private String documentUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "filePath")
    private String filePath = "";

    @ColumnInfo(defaultValue = "0", name = "type")
    private int type = 0;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "content")
    private String content = "";

    @NonNull
    public String getContent() {
        return this.content;
    }

    @NonNull
    public String getDocumentUuid() {
        return this.documentUuid;
    }

    @NonNull
    public String getFilePath() {
        return this.filePath;
    }

    public long getId() {
        return this.f7399id;
    }

    public int getIndex() {
        return this.index;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @DataConstants.STT_CONTENT_TYPE
    public int getType() {
        return this.type;
    }

    public void setContent(@NonNull String str) {
        this.content = str;
    }

    public void setDocumentUuid(@NonNull String str) {
        this.documentUuid = str;
    }

    public void setFilePath(@NonNull String str) {
        this.filePath = str;
    }

    public void setId(long j) {
        this.f7399id = j;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setType(@DataConstants.STT_CONTENT_TYPE int i) {
        this.type = i;
    }
}
