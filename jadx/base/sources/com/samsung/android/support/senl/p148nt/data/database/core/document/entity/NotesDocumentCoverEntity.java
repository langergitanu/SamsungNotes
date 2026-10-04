package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"documentUUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"}), @ForeignKey(childColumns = {DBSchema.DocumentCover.TEMPLATE_UUID}, entity = CoverTemplateEntity.class, onDelete = 4, parentColumns = {"UUID"}), @ForeignKey(childColumns = {"categoryUUID"}, entity = CoverStickerEntity.class, onDelete = 4, parentColumns = {"UUID"})}, tableName = "document_cover")
public class NotesDocumentCoverEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "documentUUID")
    private String docUuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "DEFAULT:///", name = DBSchema.DocumentCover.TEMPLATE_UUID)
    private String templateUuid = "DEFAULT:///";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "title")
    private String title = "";

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentCover.TITLE_ALIGNMENT)
    private int titleAlignment = 0;

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.DocumentCover.SUMMARY)
    private String summary = "";

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentCover.SUMMARY_ALIGNMENT)
    private int summaryAlignment = 0;

    @NonNull
    @ColumnInfo(defaultValue = CoverStickerConstants.Category.NONE.UUID, name = "categoryUUID")
    private String categoryUuid = CoverStickerConstants.Category.NONE.UUID;

    @NonNull
    @ColumnInfo(defaultValue = "DEFAULT:///", name = "backgroundColor")
    private String backgroundColor = "DEFAULT:///";

    @ColumnInfo(defaultValue = "0", name = "createdAt")
    private long createdAt = 0;

    @ColumnInfo(defaultValue = "0", name = "lastModifiedAt")
    private long lastModifiedAt = 0;

    @ColumnInfo(defaultValue = "1", name = "isEnabled")
    private int isEnabled = 1;

    @NonNull
    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    @NonNull
    public String getCategoryUuid() {
        return this.categoryUuid;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    @NonNull
    public String getDocUuid() {
        return this.docUuid;
    }

    public int getIsEnabled() {
        return this.isEnabled;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @NonNull
    public String getSummary() {
        return this.summary;
    }

    public int getSummaryAlignment() {
        return this.summaryAlignment;
    }

    @NonNull
    public String getTemplateUuid() {
        return this.templateUuid;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    public int getTitleAlignment() {
        return this.titleAlignment;
    }

    public boolean isEnabled() {
        return getIsEnabled() == 1;
    }

    public void setBackgroundColor(@NonNull @CoverConstants.Color String str) {
        this.backgroundColor = str;
    }

    public void setCategoryUuid(@NonNull @CoverStickerConstants.Category String str) {
        this.categoryUuid = str;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDocUuid(@NonNull String str) {
        this.docUuid = str;
    }

    public void setEnabled(boolean z) {
        setIsEnabled(z ? 1 : 0);
    }

    public void setIsEnabled(int i) {
        this.isEnabled = i;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setSummary(@NonNull String str) {
        this.summary = str;
    }

    public void setSummaryAlignment(int i) {
        this.summaryAlignment = i;
    }

    public void setTemplateUuid(@NonNull @CoverConstants.Template String str) {
        this.templateUuid = str;
    }

    public void setTitle(@NonNull String str) {
        this.title = str;
    }

    public void setTitleAlignment(int i) {
        this.titleAlignment = i;
    }

    @NonNull
    public String toString() {
        return "docUuid: " + this.docUuid + ", title: " + this.title + " [" + this.titleAlignment + "], summary: " + this.summary + " [" + this.summaryAlignment + "], category: " + this.categoryUuid + ", template: " + this.templateUuid + ", enabled: " + this.isEnabled;
    }
}
