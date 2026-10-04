package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"sdocUUID"}, entity = NotesDocumentEntity.class, onDelete = 5, onUpdate = 5, parentColumns = {"UUID"})}, tableName = DBSchema.TextSearch.TABLE_NAME)
public class NotesDocumentTextSearchEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "sdocUUID")
    private String docUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "strippedContent", typeAffinity = 5)
    private String strippedContent = "";

    @NonNull
    @ColumnInfo(name = "filePath")
    private String filePath = "";

    @NonNull
    public String getDocUuid() {
        return this.docUuid;
    }

    @NonNull
    public String getFilePath() {
        return this.filePath;
    }

    @NonNull
    public String getStrippedContent() {
        return this.strippedContent;
    }

    public void setDocUuid(@NonNull String str) {
        this.docUuid = str;
    }

    public void setFilePath(@NonNull String str) {
        this.filePath = str;
    }

    public void setStrippedContent(@NonNull String str) {
        this.strippedContent = str;
    }
}
