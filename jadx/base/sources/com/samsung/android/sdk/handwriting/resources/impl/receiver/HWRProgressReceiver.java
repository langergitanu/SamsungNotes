package com.samsung.android.sdk.handwriting.resources.impl.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import com.samsung.android.sdk.handwriting.resources.impl.HWRLanguagePackManager;
import com.samsung.android.sdk.handwriting.resources.impl.api.HWRResourceManagerIntent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRProgressReceiver extends BroadcastReceiver {
    private static final String TAG = "HWRProgressReceiver";
    private final HWRLanguagePackManager mLangPackManager;

    public HWRProgressReceiver(HWRLanguagePackManager hWRLanguagePackManager) {
        this.mLangPackManager = hWRLanguagePackManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e(TAG, "[HWRProgressReceiver::onReceive] data is null!");
            return;
        }
        String string = extras.getString(HWRResourceManagerIntent.EXTRA_LANG_KEY);
        int i = extras.getInt(HWRResourceManagerIntent.EXTRA_PROGRESS, 0);
        Log.i(TAG, "[HWRProgressReceiver::onReceive] language = " + HwrLanguageID.getID(string) + ", progress = " + i);
        this.mLangPackManager.setProgressLanguage(string, i);
    }
}
