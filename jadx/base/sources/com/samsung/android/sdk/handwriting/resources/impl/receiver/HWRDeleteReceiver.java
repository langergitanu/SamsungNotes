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
public class HWRDeleteReceiver extends BroadcastReceiver {
    private static final String TAG = "HWRDeleteReceiver";
    private final HWRLanguagePackManager mLangPackManager;

    public HWRDeleteReceiver(HWRLanguagePackManager hWRLanguagePackManager) {
        this.mLangPackManager = hWRLanguagePackManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "[HWRDeleteReceiver::onReceive]");
        if (intent.getAction().equals(HWRResourceManagerIntent.ACTION_DELETE_LANG_RESULT)) {
            if (intent.getExtras() == null) {
                Log.e(TAG, "[HWRDeleteReceiver::onReceive] data is null!");
                return;
            }
            int i = intent.getExtras().getInt(HWRResourceManagerIntent.EXTRA_DELETE_RESULT);
            String string = intent.getExtras().getString(HWRResourceManagerIntent.EXTRA_LANG_KEY);
            Log.i(TAG, "[HWRDeleteReceiver::onReceive] lang = " + HwrLanguageID.getID(string) + ", delete = " + i);
            this.mLangPackManager.deleteResult(string, i == 0);
        }
    }
}
