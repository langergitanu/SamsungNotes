package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = SyncDBSchema.SyncDelayInfo.TABLE_NAME)
public class SyncDelayInfoEntity {

    @ColumnInfo(defaultValue = "0", name = "reason")
    private int reason;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncDelayInfo.RETRY_COUNT)
    private int retryCount;

    @ColumnInfo(defaultValue = "0", name = SyncDBSchema.SyncDelayInfo.UP_SYNC)
    private int upSync;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "UUID")
    private String uuid = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "serverId")
    private String serverId = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = "appVersion")
    private String appVersion = "";

    @ColumnInfo(defaultValue = "1464416139847", name = "serverTimestamp")
    private long serverTimestamp = 1464416139847L;

    @NonNull
    @ColumnInfo(defaultValue = "", name = "extra")
    private String extra = "";

    @NonNull
    public String getAppVersion() {
        return this.appVersion;
    }

    @NonNull
    public String getExtra() {
        return this.extra;
    }

    public int getReason() {
        return this.reason;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    @NonNull
    public String getServerId() {
        return this.serverId;
    }

    public long getServerTimestamp() {
        return this.serverTimestamp;
    }

    public int getUpSync() {
        return this.upSync;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public void setAppVersion(@NonNull String str) {
        this.appVersion = str;
    }

    public void setExtra(@NonNull String str) {
        this.extra = str;
    }

    public void setReason(int i) {
        this.reason = i;
    }

    public void setRetryCount(int i) {
        this.retryCount = i;
    }

    public void setServerId(@NonNull String str) {
        this.serverId = str;
    }

    public void setServerTimestamp(long j) {
        this.serverTimestamp = j;
    }

    public void setUpSync(int i) {
        this.upSync = i;
    }

    public void setUuid(@NonNull String str) {
        this.uuid = str;
    }
}
