package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.menu;

import android.os.SystemClock;
import android.view.ViewConfiguration;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TEButtonChecker {
    private static final String TAG = CTLogger.createTag("TEButtonChecker");
    private static final long CLICK_DELAY = ViewConfiguration.getJumpTapTimeout();
    private static long mButtonClickedTime = 0;

    public static synchronized boolean isExecutable() {
        if (SystemClock.uptimeMillis() - mButtonClickedTime < CLICK_DELAY) {
            Logger.m10999d(TAG, "isExecutable(), cannot proceed");
            return false;
        }
        mButtonClickedTime = SystemClock.uptimeMillis();
        return true;
    }
}
