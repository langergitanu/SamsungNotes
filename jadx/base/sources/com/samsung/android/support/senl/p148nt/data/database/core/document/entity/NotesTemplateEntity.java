package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {"UUID"})}, tableName = DBSchema.DocumentTemplate.TABLE_NAME)
public class NotesTemplateEntity {

    @ColumnInfo(defaultValue = "0", name = "createdAt")
    private long createdAt;

    @ColumnInfo(name = "_data")
    private String data;

    @ColumnInfo(defaultValue = "", name = "_display_name")
    private String displayName;

    @ColumnInfo(defaultValue = "0", name = "height")
    private int height;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7397id;

    @ColumnInfo(defaultValue = "0", name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(name = "mime_type")
    private String mimeType;

    @ColumnInfo(defaultValue = "0", name = "_size")
    private int size;

    @ColumnInfo(defaultValue = "", name = "title")
    private String title;

    @ColumnInfo(defaultValue = "3", name = "type")
    private int type = 3;

    @ColumnInfo(name = "UUID")
    private String uuid;

    @ColumnInfo(defaultValue = "0", name = "width")
    private int width;

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getData() {
        return this.data;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getHeight() {
        return this.height;
    }

    public Long getId() {
        return this.f7397id;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getSize() {
        return this.size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWidth() {
        return this.width;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setId(Long l) {
        this.f7397id = l;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
