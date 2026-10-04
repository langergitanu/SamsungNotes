package com.samsung.android.spen.libsdl;

import android.app.StatusBarManager;
import android.content.Context;
import com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.AbstractC7894a;
import com.samsung.android.spen.libinterface.StatusBarInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlStatusBar implements StatusBarInterface {
    public static final int DISABLE_NONE = 0;
    public static final int DISABLE_NOTIFICATION_ALERTS = 262144;
    private static SdlStatusBar mStatusBar;

    private SdlStatusBar() {
    }

    public static SdlStatusBar getInstance() {
        if (mStatusBar == null) {
            mStatusBar = new SdlStatusBar();
        }
        return mStatusBar;
    }

    @Override // com.samsung.android.spen.libinterface.StatusBarInterface
    public void collapsePanels(Context context) {
        StatusBarManager statusBarManagerM6804e = AbstractC7894a.m6804e(context.getSystemService("statusbar"));
        if (statusBarManagerM6804e != null) {
            statusBarManagerM6804e.collapsePanels();
        }
    }

    @Override // com.samsung.android.spen.libinterface.StatusBarInterface
    public void disable(Context context, int i) {
        StatusBarManager statusBarManagerM6804e = AbstractC7894a.m6804e(context.getSystemService("statusbar"));
        if (statusBarManagerM6804e != null) {
            statusBarManagerM6804e.disable(i);
        }
    }
}
