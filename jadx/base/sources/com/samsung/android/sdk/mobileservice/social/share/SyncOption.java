package com.samsung.android.sdk.mobileservice.social.share;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SyncOption {
    private boolean isPermissionUINeeded;
    private boolean isSyncWithQuota;
    private SyncType syncType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SyncType {
        SYNC_WITH_LAST_THUMBNAIL("SYNC_WITH_LAST_THUMBNAIL"),
        FULL_SYNC("FULL_SYNC");

        private final String syncType;

        SyncType(String str) {
            this.syncType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.syncType;
        }
    }

    public SyncOption(SyncType syncType, boolean z, boolean z2) {
        this.syncType = syncType;
        this.isPermissionUINeeded = z;
        this.isSyncWithQuota = z2;
    }

    public SyncType getSyncType() {
        return this.syncType;
    }

    public boolean isPermissionUINeeded() {
        return this.isPermissionUINeeded;
    }

    public boolean isSyncWithQuota() {
        return this.isSyncWithQuota;
    }
}
