package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {"documentUUID", "UUID"})}, tableName = DBSchema.DocumentPage.TABLE_NAME)
public class NotesDocumentPageEntity {

    @ColumnInfo(name = DBSchema.DocumentPage.FAVORITE)
    private int favorite;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long f7389id;

    @ColumnInfo(name = "index")
    private int index;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "UUID")
    private String pageUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "documentUUID")
    private String documentUuid = "";

    @ColumnInfo(defaultValue = "0", name = "isDeleted")
    private int isDeleted = 0;

    @ColumnInfo(defaultValue = "1", name = "isDirty")
    private int isDirty = 1;

    @NonNull
    public String getDocumentUuid() {
        return this.documentUuid;
    }

    public int getFavorite() {
        return this.favorite;
    }

    public long getId() {
        return this.f7389id;
    }

    public int getIndex() {
        return this.index;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    @NonNull
    public String getPageUuid() {
        return this.pageUuid;
    }

    public void setDocumentUuid(@NonNull String str) {
        this.documentUuid = str;
    }

    public void setFavorite(int i) {
        this.favorite = i;
    }

    public void setId(long j) {
        this.f7389id = j;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setIsDirty(int i) {
        this.isDirty = i;
    }

    public void setPageUuid(@NonNull String str) {
        this.pageUuid = str;
    }
}
