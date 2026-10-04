package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"objectId"}, entity = StickyNoteEntity.class, onDelete = 5, parentColumns = {"objectId"})}, indices = {@Index({"objectId"})}, tableName = DBSchema.StickyStroke.TABLE_NAME)
public class StickyStrokeSearchEntity {
    public static final int TYPE_ACTIONLINK = 2;
    public static final int TYPE_STROKE = 1;

    @ColumnInfo(defaultValue = "0", name = "bottom")
    private int bottom;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long f7398id;

    @ColumnInfo(defaultValue = "0", name = "left")
    private int left;

    @ColumnInfo(defaultValue = "0", name = "pageWidth")
    private int pageWidth;

    @ColumnInfo(defaultValue = "0", name = "right")
    private int right;

    @ColumnInfo(defaultValue = "0", name = "top")
    private int top;

    @ColumnInfo(defaultValue = "0", name = "type")
    private int type;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "objectId")
    private String objectId = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "text")
    private String text = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "actionLinkData")
    private String actionLinkData = "";

    @NonNull
    public String getActionLinkData() {
        return this.actionLinkData;
    }

    public int getBottom() {
        return this.bottom;
    }

    public long getId() {
        return this.f7398id;
    }

    public int getLeft() {
        return this.left;
    }

    @NonNull
    public String getObjectId() {
        return this.objectId;
    }

    public int getPageWidth() {
        return this.pageWidth;
    }

    public int getRight() {
        return this.right;
    }

    @NonNull
    public String getText() {
        return this.text;
    }

    public int getTop() {
        return this.top;
    }

    public int getType() {
        return this.type;
    }

    public void setActionLinkData(@NonNull String str) {
        this.actionLinkData = str;
    }

    public void setBottom(int i) {
        this.bottom = i;
    }

    public void setId(long j) {
        this.f7398id = j;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public void setObjectId(@NonNull String str) {
        this.objectId = str;
    }

    public void setPageWidth(int i) {
        this.pageWidth = i;
    }

    public void setRight(int i) {
        this.right = i;
    }

    public void setText(@NonNull String str) {
        this.text = str;
    }

    public void setTop(int i) {
        this.top = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
