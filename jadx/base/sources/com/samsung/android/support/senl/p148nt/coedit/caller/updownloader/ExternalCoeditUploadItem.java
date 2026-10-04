package com.samsung.android.support.senl.p148nt.coedit.caller.updownloader;

import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalCoeditUploadItem {
    private final ShareSyncEntry mEntry;
    private String mGroupId;

    public ExternalCoeditUploadItem(ShareSyncEntry shareSyncEntry) {
        this.mEntry = shareSyncEntry;
    }

    public ShareSyncEntry getEntry() {
        return this.mEntry;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }
}
