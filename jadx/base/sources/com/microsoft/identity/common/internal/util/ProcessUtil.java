package com.microsoft.identity.common.internal.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ProcessUtil {
    private ProcessUtil() {
    }

    @NonNull
    public static Handler getPreferredHandler() {
        return Looper.myLooper() != null ? new Handler(Looper.myLooper()) : new Handler(Looper.getMainLooper());
    }

    @Nullable
    private static String getProcessName(@NonNull Context context) {
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getApplicationContext().getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean isBrokerProcess(@NonNull Context context) {
        String processName = getProcessName(context);
        Iterator<BrokerData> it = BrokerData.getKnownBrokerApps().iterator();
        while (it.hasNext()) {
            if ((it.next().getPackageName() + ":auth").equalsIgnoreCase(processName)) {
                return true;
            }
        }
        return false;
    }
}
