package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index({"sdocUUID"})}, tableName = DBSchema.PageSearchInfo.TABLE_NAME)
public class NotesPageSearchInfoEntity {

    @SearchConstants.Source
    @ColumnInfo(defaultValue = "0", name = DBSchema.PageSearchInfo.PAGE_CONTENT_SOURCE)
    private int contentSource;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long f7393id;

    @ColumnInfo(defaultValue = "0", name = DBSchema.PageSearchInfo.LAST_CONTENT_MODIFIED_AT)
    private long lastContentModifiedAt;

    @ColumnInfo(defaultValue = "0", name = DBSchema.PageSearchInfo.LAST_SEARCH_MODIFIED_AT)
    private long lastSearchModifiedAt;

    @SearchConstants.Source
    @ColumnInfo(defaultValue = "0", name = DBSchema.PageSearchInfo.SEARCH_SOURCE)
    private int searchSource;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "sdocUUID")
    private String documentUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "pageUuid")
    private String pageUuid = "";

    @ColumnInfo(defaultValue = "0", name = "isDirty")
    private int isDirty = 0;

    @SearchConstants.Source
    public int getContentSource() {
        return this.contentSource;
    }

    @NonNull
    public String getDocumentUuid() {
        return this.documentUuid;
    }

    public long getId() {
        return this.f7393id;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    public long getLastContentModifiedAt() {
        return this.lastContentModifiedAt;
    }

    public long getLastSearchModifiedAt() {
        return this.lastSearchModifiedAt;
    }

    @NonNull
    public String getPageUuid() {
        return this.pageUuid;
    }

    @SearchConstants.Source
    public int getSearchSource() {
        return this.searchSource;
    }

    public void setContentSource(@SearchConstants.Source int i) {
        this.contentSource = i;
    }

    public void setDocumentUuid(@NonNull String str) {
        this.documentUuid = str;
    }

    public void setId(long j) {
        this.f7393id = j;
    }

    public void setIsDirty(int i) {
        this.isDirty = i;
    }

    public void setLastContentModifiedAt(long j) {
        this.lastContentModifiedAt = j;
    }

    public void setLastSearchModifiedAt(long j) {
        this.lastSearchModifiedAt = j;
    }

    public void setPageUuid(@NonNull String str) {
        this.pageUuid = str;
    }

    public void setSearchSource(@SearchConstants.Source int i) {
        this.searchSource = i;
    }

    @NonNull
    public String toString() {
        return "docUuid: " + this.documentUuid + ", pageUuid: " + this.pageUuid + ", contentSrc: " + this.contentSource + ", searchSrc: " + this.searchSource + ", lastModifiedAt content/search: " + this.lastContentModifiedAt + "/" + this.lastSearchModifiedAt + ", isDirty: " + this.isDirty;
    }
}
