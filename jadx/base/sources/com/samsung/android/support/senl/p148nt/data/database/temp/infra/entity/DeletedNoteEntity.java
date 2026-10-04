package com.samsung.android.support.senl.p148nt.data.database.temp.infra.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.ExtraDbSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index({"filePath"})}, tableName = ExtraDbSchema.DeletedNote.TABLE_NAME)
public class DeletedNoteEntity {

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long f7423id;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "filePath")
    private String filePath = "";

    @ColumnInfo(defaultValue = "0", name = "deletedBy")
    @DataBaseConstants.DeletedBy
    private int deletedBy = 0;

    @DataBaseConstants.DeletedBy
    public int getDeletedBy() {
        return this.deletedBy;
    }

    @NonNull
    public String getFilePath() {
        return this.filePath;
    }

    public long getId() {
        return this.f7423id;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setDeletedBy(@DataBaseConstants.DeletedBy int i) {
        this.deletedBy = i;
    }

    public void setFilePath(@NonNull String str) {
        this.filePath = str;
    }

    public void setId(long j) {
        this.f7423id = j;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
