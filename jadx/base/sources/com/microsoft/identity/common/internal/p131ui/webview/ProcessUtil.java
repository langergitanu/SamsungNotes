package com.microsoft.identity.common.internal.p131ui.webview;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ProcessUtil {
    public static final String AuthServiceProcess = "auth";

    public static boolean isRunningOnAuthService(Context context) {
        String str = context.getPackageName() + ":auth";
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        if (activityManager == null || activityManager.getRunningAppProcesses() == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid && runningAppProcessInfo.processName.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
