package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index({DBSchema.TagList.NORMALIZE_NAME})}, tableName = "tag_list")
public class NotesTagEntity implements Cloneable {

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7396id;

    @NonNull
    @ColumnInfo(name = DBSchema.TagList.NORMALIZE_NAME)
    private String normalizeName = "";

    @NonNull
    @ColumnInfo(name = "docUUID")
    private String docUuid = "";

    @NonNull
    @ColumnInfo(name = "displayName")
    private String displayName = "";

    @NonNull
    public String getDisplayName() {
        return this.displayName;
    }

    @NonNull
    public String getDocUuid() {
        return this.docUuid;
    }

    public Long getId() {
        return this.f7396id;
    }

    @NonNull
    public String getNormalizeName() {
        return this.normalizeName;
    }

    public void setDisplayName(@NonNull String str) {
        this.displayName = str;
    }

    public void setDocUuid(@NonNull String str) {
        this.docUuid = str;
    }

    public void setId(Long l) {
        this.f7396id = l;
    }

    public void setNormalizeName(@NonNull String str) {
        this.normalizeName = str;
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public NotesTagEntity m22194clone() {
        return (NotesTagEntity) super.clone();
    }
}
