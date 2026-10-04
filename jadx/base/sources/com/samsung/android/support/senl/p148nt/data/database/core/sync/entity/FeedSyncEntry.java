package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import androidx.room.ColumnInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FeedSyncEntry extends DocSyncEntry {

    @ColumnInfo(name = DBSchema.Document.MS_LAST_SYNC_TIME)
    private long msLastSyncTime = 0;

    @ColumnInfo(name = DBSchema.Document.MS_SYNC_ACCOUNT_ID)
    private String msSyncAccountId = "";

    @ColumnInfo(name = DBSchema.Document.MS_SYNC_DOCUMENT_UUID)
    private String msSyncDocumentUuid = "";

    @ColumnInfo(name = "createdAt")
    private long createdAt = 0;

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getMsLastSyncTime() {
        return this.msLastSyncTime;
    }

    public String getMsSyncAccountId() {
        return this.msSyncAccountId;
    }

    public String getMsSyncDocumentUuid() {
        return this.msSyncDocumentUuid;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setMsLastSyncTime(long j) {
        this.msLastSyncTime = j;
    }

    public void setMsSyncAccountId(String str) {
        this.msSyncAccountId = str;
    }

    public void setMsSyncDocumentUuid(String str) {
        this.msSyncDocumentUuid = str;
    }
}
