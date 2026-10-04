package com.samsung.android.support.senl.p148nt.data.database.core.document.entry;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesTagDocCountEntry {

    @ColumnInfo(name = DBSchema.TagList.DOC_COUNT)
    private int docCount;

    /* JADX INFO: renamed from: id */
    @ColumnInfo(name = "_id")
    private Long f7400id;

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

    public int getDocCount() {
        return this.docCount;
    }

    @NonNull
    public String getDocUuid() {
        return this.docUuid;
    }

    public Long getId() {
        return this.f7400id;
    }

    @NonNull
    public String getNormalizeName() {
        return this.normalizeName;
    }

    public void setDisplayName(@NonNull String str) {
        this.displayName = str;
    }

    public void setDocCount(int i) {
        this.docCount = i;
    }

    public void setDocUuid(@NonNull String str) {
        this.docUuid = str;
    }

    public void setId(Long l) {
        this.f7400id = l;
    }

    public void setNormalizeName(@NonNull String str) {
        this.normalizeName = str;
    }
}
