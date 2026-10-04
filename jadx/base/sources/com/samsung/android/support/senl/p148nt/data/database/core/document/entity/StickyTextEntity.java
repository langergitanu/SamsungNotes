package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"objectId"}, entity = StickyNoteEntity.class, onDelete = 5, parentColumns = {"objectId"})}, tableName = DBSchema.StickyText.TABLE_NAME)
public class StickyTextEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "objectId")
    private String objectId = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "text")
    private String text = "";

    @NonNull
    public String getObjectId() {
        return this.objectId;
    }

    @NonNull
    public String getText() {
        return this.text;
    }

    public void setObjectId(@NonNull String str) {
        this.objectId = str;
    }

    public void setText(@NonNull String str) {
        this.text = str;
    }
}
