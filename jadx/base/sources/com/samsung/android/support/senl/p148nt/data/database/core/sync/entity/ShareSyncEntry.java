package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import android.text.TextUtils;
import androidx.room.ColumnInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareSyncEntry extends DocSyncEntry {

    @ColumnInfo(name = "createdAt")
    private long createdAt = 0;

    @ColumnInfo(name = "mdeSpaceId")
    private String spaceId = "";

    @ColumnInfo(name = "mdeItemId")
    private String itemId = "";

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getFileName() {
        String filePath = getFilePath();
        if (TextUtils.isEmpty(filePath) || !filePath.contains("/")) {
            return null;
        }
        return filePath.substring(filePath.lastIndexOf(47) + 1);
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }
}
