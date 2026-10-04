package com.samsung.android.support.senl.p148nt.app.lock.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/utils/LockStateUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isForeground", "", "context", "Landroid/content/Context;", "callingUid", "", "callingPid", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockStateUtils {

    @NotNull
    public static final LockStateUtils INSTANCE = new LockStateUtils();

    @NotNull
    private static final String TAG = LockLogger.createTag("LockStateUtils");

    private LockStateUtils() {
    }

    @JvmStatic
    public static final boolean isForeground(@NotNull Context context, int callingUid, int callingPid) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = false;
        try {
            Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        } catch (RemoteException e) {
            e = e;
        }
        if (runningAppProcesses == null) {
            Logger.m8697d(TAG, "isForeground, no running app processes found");
            return false;
        }
        int size = runningAppProcesses.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            try {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                if (runningAppProcessInfo.pid == callingPid && runningAppProcessInfo.uid == callingUid && runningAppProcessInfo.importance <= 125) {
                    z2 = true;
                }
            } catch (RemoteException e2) {
                e = e2;
                z = z2;
                AbstractC4539a.m3188B("isForeground ", e.getMessage(), TAG);
                z2 = z;
                Logger.m8697d(TAG, "isForeground " + z2);
                return z2;
            }
        }
        Logger.m8697d(TAG, "isForeground " + z2);
        return z2;
    }
}
