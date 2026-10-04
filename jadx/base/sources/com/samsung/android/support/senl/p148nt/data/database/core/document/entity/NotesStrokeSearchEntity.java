package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index({"sdocUUID", "type"})}, tableName = "stroke")
public class NotesStrokeSearchEntity {
    public static final int TYPE_ACTIONLINK = 2;
    public static final int TYPE_AUDIO = 5;
    public static final int TYPE_CODE_BLOCK = 7;
    public static final int TYPE_PDF_TEXT = 3;
    public static final int TYPE_STROKE = 1;
    public static final int TYPE_TABLE_TEXT = 6;
    public static final int TYPE_TEXT_BOX = 0;
    public static final int TYPE_VOICE_RECORDING = 4;

    @ColumnInfo(defaultValue = "", name = "actionLinkData")
    private String actionLinkData;

    @ColumnInfo(defaultValue = "0", name = "bottom")
    private Integer bottom;

    @ColumnInfo(defaultValue = "0", name = DBSchema.StrokeSearch.HAS_VISUALCUE)
    private Integer hasVisualCue;

    /* JADX INFO: renamed from: id */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long f7395id;

    @ColumnInfo(defaultValue = "0", name = "left")
    private Integer left;

    @ColumnInfo(defaultValue = "0", name = "pageWidth")
    private Integer pageWidth;

    @ColumnInfo(defaultValue = "0", name = "right")
    private Integer right;

    @ColumnInfo(defaultValue = "", name = "text")
    private String text;

    @ColumnInfo(defaultValue = "0", name = "top")
    private Integer top;

    @ColumnInfo(defaultValue = "0", name = "type")
    private int type;

    @NonNull
    @ColumnInfo(name = "filePath")
    private String filePath = "";

    @NonNull
    @ColumnInfo(name = "sdocUUID")
    private String docUuid = "";

    @ColumnInfo(defaultValue = "", name = "pageUuid")
    private String pageUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "0", name = "recognizerDBVersion")
    private String recognizerDBVersion = "0";

    public String getActionLinkData() {
        return this.actionLinkData;
    }

    public Integer getBottom() {
        return this.bottom;
    }

    @NonNull
    public String getDocUuid() {
        return this.docUuid;
    }

    @NonNull
    public String getFilePath() {
        return this.filePath;
    }

    public Integer getHasVisualCue() {
        return this.hasVisualCue;
    }

    public Long getId() {
        return this.f7395id;
    }

    public Integer getLeft() {
        return this.left;
    }

    public String getPageUuid() {
        return this.pageUuid;
    }

    public Integer getPageWidth() {
        return this.pageWidth;
    }

    public String getRecognizerDBVersion() {
        return this.recognizerDBVersion;
    }

    public Integer getRight() {
        return this.right;
    }

    public String getText() {
        return this.text;
    }

    public Integer getTop() {
        return this.top;
    }

    public int getType() {
        return this.type;
    }

    public void setActionLinkData(String str) {
        this.actionLinkData = str;
    }

    public void setBottom(Integer num) {
        this.bottom = num;
    }

    public void setDocUuid(@NonNull String str) {
        this.docUuid = str;
    }

    public void setFilePath(@NonNull String str) {
        this.filePath = str;
    }

    public void setHasVisualCue(Integer num) {
        this.hasVisualCue = num;
    }

    public void setId(Long l) {
        this.f7395id = l;
    }

    public void setLeft(Integer num) {
        this.left = num;
    }

    public void setPageUuid(String str) {
        this.pageUuid = str;
    }

    public void setPageWidth(Integer num) {
        this.pageWidth = num;
    }

    public void setRecognizerDBVersion(String str) {
        this.recognizerDBVersion = str;
    }

    public void setRight(Integer num) {
        this.right = num;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTop(Integer num) {
        this.top = num;
    }

    public void setType(int i) {
        this.type = i;
    }
}
