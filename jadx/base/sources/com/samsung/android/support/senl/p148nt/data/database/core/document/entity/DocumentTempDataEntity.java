package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"UUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"})}, tableName = DBSchema.DocumentTempData.TABLE_NAME)
public class DocumentTempDataEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.DocumentTempData.TEMP_DATA)
    private String tempData = "";

    @NonNull
    public String getTempData() {
        return this.tempData;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setTempData(@NonNull String str) {
        this.tempData = str;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
