package com.samsung.android.scloud.rpc;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface SamsungCloudRPCCallback {
    void onComplete(String str, Bundle bundle);

    void onProgress(String str, int i);

    void onStart(String str);
}
