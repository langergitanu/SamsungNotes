package com.samsung.android.support.senl.p148nt.data.database.core.document.entry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDocumentCountEntry implements FolderSortData {

    @ColumnInfo(name = "UUID")
    private String categoryUuid;

    @ColumnInfo(name = "createdAt")
    private long createdAt;

    @ColumnInfo(name = "displayName")
    private String displayName;

    @ColumnInfo(defaultValue = "-1", name = "displayNameColor")
    private int displayNameColor;

    @ColumnInfo(name = DBSchema.CategoryTreeClosure.DOCUMENT_COUNT)
    private int documentCount;

    @ColumnInfo(name = "isDeleted")
    private int isDeleted;

    @ColumnInfo(name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(name = DBSchema.CategoryTree.PARENT_UUID)
    private String parentUuid;

    @ColumnInfo(name = "orderBy")
    private Integer reorder;

    @ColumnInfo(defaultValue = "0", name = "recycle_bin_time_moved")
    private long recycleBinTimeMoved = 0;

    @Ignore
    private final List<FolderSortData> mChildren = new ArrayList();

    public String getCategoryUuid() {
        return this.categoryUuid;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    @NonNull
    public List<FolderSortData> getChildren() {
        return this.mChildren;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public long getCreatedAt() {
        return this.createdAt;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public int getDisplayNameColor() {
        return this.displayNameColor;
    }

    public int getDocumentCount() {
        return this.documentCount;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    @Nullable
    public String getParentUuid() {
        return this.parentUuid;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public long getRecycleBinTimeMoved() {
        return this.recycleBinTimeMoved;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    @NonNull
    public Integer getReorder() {
        Integer num = this.reorder;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public String getUuid() {
        return getCategoryUuid();
    }

    public void setCategoryUuid(String str) {
        this.categoryUuid = str;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setDisplayNameColor(int i) {
        this.displayNameColor = i;
    }

    public void setDocumentCount(int i) {
        this.documentCount = i;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setParentUuid(@Nullable String str) {
        this.parentUuid = str;
    }

    public void setRecycleBinTimeMoved(long j) {
        this.recycleBinTimeMoved = j;
    }

    public void setReorder(Integer num) {
        this.reorder = num;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("uuid: ");
        sb.append(this.categoryUuid);
        sb.append(", parent: ");
        sb.append(this.parentUuid);
        sb.append(", name: ");
        AbstractC11014a.m12336u(this.displayName, sb, ", reorder: ");
        sb.append(this.reorder);
        sb.append(", created: ");
        sb.append(this.createdAt);
        sb.append(", modified: ");
        sb.append(this.lastModifiedAt);
        sb.append(", toTrash: ");
        sb.append(this.recycleBinTimeMoved);
        return sb.toString();
    }
}
