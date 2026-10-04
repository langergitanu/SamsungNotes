package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SyncCategoryTreeInfo {
    private String UUID;
    private int displayNameColor;
    private int isDeleted;
    private int isDirty;
    private long lastModifiedAt;
    private Integer orderBy;
    private String path;
    private long recycle_bin_time_moved;
    private long serverTimestamp;

    public int getDisplayNameColor() {
        return this.displayNameColor;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDirty() {
        return this.isDirty;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public int getOrderBy() {
        Integer num = this.orderBy;
        return num != null ? num.intValue() : CategoryConstants.DEFAULT_REORDER;
    }

    public String getPath() {
        return this.path;
    }

    public long getRecycle_bin_time_moved() {
        return this.recycle_bin_time_moved;
    }

    public long getServerTimestamp() {
        return this.serverTimestamp;
    }

    public String getUUID() {
        return this.UUID;
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

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }

    public void setOrderBy(Integer num) {
        this.orderBy = num;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setRecycle_bin_time_moved(long j) {
        this.recycle_bin_time_moved = j;
    }

    public void setServerTimestamp(long j) {
        this.serverTimestamp = j;
    }

    public void setUUID(String str) {
        this.UUID = str;
    }
}
