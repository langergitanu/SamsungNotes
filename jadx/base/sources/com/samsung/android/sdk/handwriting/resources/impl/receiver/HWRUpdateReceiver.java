package com.samsung.android.sdk.handwriting.resources.impl.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import com.samsung.android.sdk.handwriting.resources.impl.HWRLanguagePackManager;
import com.samsung.android.sdk.handwriting.resources.impl.api.HWRResourceManagerIntent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRUpdateReceiver extends BroadcastReceiver {
    private static final String TAG = "HWRUpdateReceiver";
    private final HWRLanguagePackManager mLangPackManager;

    public HWRUpdateReceiver(HWRLanguagePackManager hWRLanguagePackManager) {
        this.mLangPackManager = hWRLanguagePackManager;
    }

    private void processUpdateFailure(String str, int i) {
        if (i == -4) {
            this.mLangPackManager.updateResult(str, 2);
            return;
        }
        if (i == -3) {
            this.mLangPackManager.updateResult(str, 4);
        } else if (i == -2) {
            this.mLangPackManager.updateResult(str, 3);
        } else {
            if (i != -1) {
                return;
            }
            this.mLangPackManager.updateResult(str, 1);
        }
    }

    private void processUpdateSuccess(String str) {
        this.mLangPackManager.updateResult(str, 0);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "[HWRUpdateReceiver::onReceive]");
        if (intent.getExtras() == null) {
            Log.e(TAG, "[HWRUpdateReceiver::onReceive] data is null!");
            return;
        }
        String string = intent.getExtras().getString(HWRResourceManagerIntent.EXTRA_LANG_KEY);
        int i = intent.getExtras().getInt(HWRResourceManagerIntent.EXTRA_UPDATE_RESULT);
        Log.i(TAG, "[HWRUpdateReceiver::onReceive] lang = " + HwrLanguageID.getID(string) + ", result = " + i);
        if (i == 0) {
            processUpdateSuccess(string);
        } else if (i == -1 || i == -2 || i == -4) {
            processUpdateFailure(string, i);
        } else {
            AbstractC0541b.m758D(i, "Unknown update result code ", TAG);
        }
    }
}
