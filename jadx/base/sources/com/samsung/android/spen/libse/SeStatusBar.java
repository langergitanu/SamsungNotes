package com.samsung.android.spen.libse;

import android.app.SemStatusBarManager;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.spen.libinterface.StatusBarInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeStatusBar implements StatusBarInterface {
    public static final int DISABLE_NONE = 0;
    public static final int DISABLE_NOTIFICATION_ALERTS = 262144;
    private static SeStatusBar mStatusBar;

    private SeStatusBar() {
    }

    public static SeStatusBar getInstance() {
        if (mStatusBar == null) {
            mStatusBar = new SeStatusBar();
        }
        return mStatusBar;
    }

    @Override // com.samsung.android.spen.libinterface.StatusBarInterface
    public void collapsePanels(Context context) {
        context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    @Override // com.samsung.android.spen.libinterface.StatusBarInterface
    public void disable(Context context, int i) {
        SemStatusBarManager semStatusBarManager = (SemStatusBarManager) context.getSystemService("sem_statusbar");
        if (semStatusBarManager != null) {
            semStatusBarManager.disable(i);
        }
    }
}
