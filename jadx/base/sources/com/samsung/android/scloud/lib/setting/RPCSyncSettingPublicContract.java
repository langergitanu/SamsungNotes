package com.samsung.android.scloud.lib.setting;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
interface RPCSyncSettingPublicContract extends RPCSyncSettingContract {
    public static final String AUTHORITY = "com.samsung.android.scloud.sync.rpc.public";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Method {
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.scloud.sync.rpc.public");
    }
}
