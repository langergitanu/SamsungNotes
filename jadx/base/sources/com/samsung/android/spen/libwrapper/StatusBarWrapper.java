package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.StatusBarInterface;
import com.samsung.android.spen.libsdl.SdlStatusBar;
import com.samsung.android.spen.libse.SeStatusBar;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class StatusBarWrapper {
    public static final int DISABLE_NONE = 0;
    public static final int DISABLE_NOTIFICATION_ALERTS = 262144;
    private static StatusBarInterface mStatusBar;

    private StatusBarWrapper() {
    }

    public static StatusBarInterface getStatusBar(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            mStatusBar = SeStatusBar.getInstance();
        } else {
            mStatusBar = SdlStatusBar.getInstance();
        }
        return mStatusBar;
    }
}
