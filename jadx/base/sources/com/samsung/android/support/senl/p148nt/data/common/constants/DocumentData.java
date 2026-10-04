package com.samsung.android.support.senl.p148nt.data.common.constants;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentData {

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7349id;

    @NonNull
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "uncategorized:///", name = "categoryUUID")
    private String categoryUuid = "uncategorized:///";

    @NonNull
    @ColumnInfo(name = "filePath")
    private String filePath = "";

    @ColumnInfo(defaultValue = "", name = DBSchema.Document.CONTENT_UUID)
    private String contentUuid = "";

    @ColumnInfo(defaultValue = "", name = "strokeUUID")
    private String strokeUuid = "";

    @NonNull
    public String getCategoryUuid() {
        return this.categoryUuid;
    }

    public String getContentUuid() {
        return this.contentUuid;
    }

    @NonNull
    public String getFilePath() {
        return this.filePath;
    }

    public Long getId() {
        return this.f7349id;
    }

    public String getStrokeUuid() {
        return this.strokeUuid;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setCategoryUuid(@NonNull String str) {
        this.categoryUuid = str;
    }

    public void setContentUuid(String str) {
        this.contentUuid = str;
    }

    public void setFilePath(@NonNull String str) {
        this.filePath = str;
    }

    public void setId(Long l) {
        this.f7349id = l;
    }

    public void setStrokeUuid(String str) {
        this.strokeUuid = str;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
