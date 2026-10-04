package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = DBSchema.CategoryTree.TABLE_NAME)
public class NotesCategoryTreeEntity implements FolderSortData {

    @Ignore
    private String absolutePath;

    @ColumnInfo(name = "createdAt")
    private long createdAt;

    @NonNull
    @ColumnInfo(name = "displayName")
    private String displayName;

    @ColumnInfo(defaultValue = "-1", name = "displayNameColor")
    private int displayNameColor;

    @ColumnInfo(defaultValue = "0", name = "isDeleted")
    private int isDeleted;

    @ColumnInfo(defaultValue = "1", name = "isDirty")
    private int isDirty;

    @ColumnInfo(defaultValue = "0", name = DBSchema.CategoryTree.IS_SYNC_WITH_MS)
    private int isSyncWithMS;

    @ColumnInfo(name = "lastModifiedAt")
    private long lastModifiedAt;

    @ColumnInfo(name = DBSchema.CategoryTree.PARENT_UUID)
    private String parentUuid;

    @ColumnInfo(defaultValue = "0", name = "recycle_bin_time_moved")
    private long recycleBinTimeMoved;

    @ColumnInfo(name = "orderBy")
    private Integer reorder;

    @ColumnInfo(name = "path")
    private String restorePath;

    @ColumnInfo(defaultValue = "1464416139847", name = "serverTimestamp")
    private Long serverTimeStamp;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "UUID")
    private String uuid;

    public NotesCategoryTreeEntity(@NonNull String str, String str2, @NonNull String str3, @Nullable String str4) {
        this.isDeleted = 0;
        this.isDirty = 1;
        this.serverTimeStamp = 1464416139847L;
        this.recycleBinTimeMoved = 0L;
        this.displayNameColor = -1;
        this.isSyncWithMS = 0;
        this.uuid = str;
        this.displayName = str3;
        this.restorePath = str4;
        setParentUuid(str2);
    }

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    @NonNull
    public List<? extends FolderSortData> getChildren() {
        return new ArrayList();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public long getCreatedAt() {
        return this.createdAt;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    @NonNull
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public int getDisplayNameColor() {
        return this.displayNameColor;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

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
        return Integer.valueOf(num != null ? num.intValue() : CategoryConstants.DEFAULT_REORDER);
    }

    public String getRestorePath() {
        return this.restorePath;
    }

    @NonNull
    public Long getServerTimeStamp() {
        Long l = this.serverTimeStamp;
        return Long.valueOf(l != null ? l.longValue() : 1464416139847L);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData
    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public boolean isRootCategory() {
        return TextUtils.isEmpty(getParentUuid());
    }

    public int isSyncWithMS() {
        return this.isSyncWithMS;
    }

    public void setAbsolutePath(String str) {
        this.absolutePath = str;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDisplayName(@NonNull String str) {
        this.displayName = str;
    }

    public void setDisplayNameColor(int i) {
        this.displayNameColor = i;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setIsDirty(int i) {
        this.isDirty = i;
    }

    public void setIsSyncWithMS(int i) {
        this.isSyncWithMS = i;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setParentUuid(String str) {
        if (PredefinedCategory.isRootFolder(getUuid())) {
            this.parentUuid = null;
        } else if (Objects.equals(getUuid(), str)) {
            this.parentUuid = PredefinedCategory.UNCATEGORIZED.getUuid();
        } else {
            this.parentUuid = str;
        }
    }

    public void setRecycleBinTimeMoved(long j) {
        this.recycleBinTimeMoved = j;
    }

    public void setReorder(Integer num) {
        this.reorder = num;
    }

    public void setRestorePath(String str) {
        this.restorePath = str;
    }

    public void setServerTimeStamp(Long l) {
        this.serverTimeStamp = l;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("NotesCategoryTreeEntity{uuid='");
        sb.append(this.uuid);
        sb.append("', parentUuid='");
        sb.append(this.parentUuid);
        sb.append("', isDeleted=");
        sb.append(this.isDeleted);
        sb.append(", isDirty=");
        sb.append(this.isDirty);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", lastModifiedAt=");
        sb.append(this.lastModifiedAt);
        sb.append(", serverTimeStamp=");
        sb.append(this.serverTimeStamp);
        sb.append(", recycleBinTimeMoved=");
        sb.append(this.recycleBinTimeMoved);
        sb.append(", displayName='");
        AbstractC11014a.m12336u(this.displayName, sb, "', restorePath='");
        AbstractC11014a.m12336u(this.restorePath, sb, "', absolutePath='");
        AbstractC11014a.m12336u(this.absolutePath, sb, "', reorder=");
        sb.append(this.reorder);
        sb.append(", displayNameColor=");
        sb.append(this.displayNameColor);
        sb.append(", isSyncWithMS=");
        return AbstractC0000a.m13j(sb, this.isSyncWithMS, '}');
    }

    @Ignore
    public NotesCategoryTreeEntity(@NonNull String str, String str2, @NonNull String str3, int i, @Nullable String str4) {
        this(str, str2, str3, str4);
        this.displayNameColor = i;
    }

    public NotesCategoryTreeEntity(@NonNull String str, String str2, @NonNull String str3, @Nullable String str4, int i) {
        this(str, str2, str3, str4);
        this.isDirty = i;
    }

    public NotesCategoryTreeEntity(@NonNull String str, String str2, @NonNull String str3, @Nullable String str4, Integer num, int i) {
        this(str, str2, str3, str4, i);
        this.reorder = num;
    }

    public NotesCategoryTreeEntity(@NonNull String str, String str2, @NonNull String str3, long j, long j2, @Nullable String str4) {
        this(str, str2, str3, str4);
        this.createdAt = j;
        this.lastModifiedAt = j2;
    }
}
