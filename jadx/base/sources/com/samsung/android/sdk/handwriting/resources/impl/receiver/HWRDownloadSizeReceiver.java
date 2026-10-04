package com.samsung.android.sdk.handwriting.resources.impl.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import com.samsung.android.sdk.handwriting.resources.impl.HWRLanguagePackManager;
import com.samsung.android.sdk.handwriting.resources.impl.api.HWRResourceManagerIntent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRDownloadSizeReceiver extends BroadcastReceiver {
    private static final String TAG = "HWRDownloadSizeReceiver";
    private final HWRLanguagePackManager mLangPackManager;

    public HWRDownloadSizeReceiver(HWRLanguagePackManager hWRLanguagePackManager) {
        this.mLangPackManager = hWRLanguagePackManager;
    }

    private void processDownloadResultFailure(String str) {
        this.mLangPackManager.downloadSizeResult(str, -1L);
    }

    private void processDownloadResultSuccess(String str, long j) {
        this.mLangPackManager.downloadSizeResult(str, j);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "[HWRDownloadSizeReceiver::onReceive]");
        if (intent.getExtras() == null) {
            Log.e(TAG, "[HWRDownloadSizeReceiver::onReceive] data is null!");
            return;
        }
        String string = intent.getExtras().getString(HWRResourceManagerIntent.EXTRA_LANG_KEY);
        long j = intent.getExtras().getLong(HWRResourceManagerIntent.EXTRA_DOWNLOAD_SIZE_RESULT);
        Log.i(TAG, "[HWRDownloadSizeReceiver::onReceive] lang = " + HwrLanguageID.getID(string) + ", result = " + j);
        if (j < 0) {
            processDownloadResultFailure(string);
        } else {
            processDownloadResultSuccess(string, j);
        }
    }
}
