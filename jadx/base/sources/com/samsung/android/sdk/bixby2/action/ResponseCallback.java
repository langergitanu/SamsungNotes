package com.samsung.android.sdk.bixby2.action;

import android.app.PendingIntent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ResponseCallback {
    void onComplete(String str);

    void onComplete(String str, PendingIntent pendingIntent);
}
