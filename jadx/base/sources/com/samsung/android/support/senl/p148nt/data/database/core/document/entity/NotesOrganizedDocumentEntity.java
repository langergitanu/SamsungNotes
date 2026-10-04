package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"documentUUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"})}, tableName = DBSchema.OrganizedDocument.TABLE_NAME)
public class NotesOrganizedDocumentEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "documentUUID")
    private String uuid;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "contents")
    private String contents = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.OrganizedDocument.RECOGNIZED_LANGUAGE)
    private String recognizedLanguage = "";

    @NonNull
    @ColumnInfo(defaultValue = "0", name = "recognizerDBVersion")
    private String recognizerDBVersion = "0";

    @NonNull
    @ColumnInfo(name = "modified_time")
    private Long modifiedTime = 0L;

    @NonNull
    public String getContents() {
        return this.contents;
    }

    @NonNull
    public Long getModifiedTime() {
        return this.modifiedTime;
    }

    @NonNull
    public String getRecognizedLanguage() {
        return this.recognizedLanguage;
    }

    public String getRecognizerDBVersion() {
        return this.recognizerDBVersion;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setContents(@NonNull String str) {
        this.contents = str;
    }

    public void setModifiedTime(@NonNull Long l) {
        this.modifiedTime = l;
    }

    public void setRecognizedLanguage(@NonNull String str) {
        this.recognizedLanguage = str;
    }

    public void setRecognizerDBVersion(String str) {
        this.recognizerDBVersion = str;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
