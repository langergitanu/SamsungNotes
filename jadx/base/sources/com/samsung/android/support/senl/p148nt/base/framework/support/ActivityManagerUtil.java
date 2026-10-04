package com.samsung.android.support.senl.p148nt.base.framework.support;

import android.app.ActivityManager;
import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0007J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/framework/support/ActivityManagerUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isAppInBackground", "", "context", "Landroid/content/Context;", "isServiceRunning", "serviceClass", "Ljava/lang/Class;", "isAppLocked", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ActivityManagerUtil {

    @NotNull
    public static final ActivityManagerUtil INSTANCE = new ActivityManagerUtil();

    @NotNull
    private static final String TAG = "ActivityManagerUtil";

    private ActivityManagerUtil() {
    }

    @JvmStatic
    public static final boolean isAppInBackground(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            Logger.m8702i(TAG, "isAppInBackground() runningProcesses is null.");
            return true;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100) {
                Iterator it = ArrayIteratorKt.iterator(runningAppProcessInfo.pkgList);
                while (it.hasNext()) {
                    if (Intrinsics.areEqual((String) it.next(), context.getPackageName())) {
                        Logger.m8702i(TAG, "isAppInBackground() false");
                        return false;
                    }
                }
            }
        }
        Logger.m8702i(TAG, "isAppInBackground() true");
        return true;
    }

    @JvmStatic
    public static final boolean isAppLocked(@NotNull Context context) {
        boolean zBooleanValue;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            Method declaredMethod = ActivityManager.class.getDeclaredMethod("isAppLockedPackage", String.class);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
            Object objInvoke = declaredMethod.invoke(activityManager, "com.samsung.android.app.notes");
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            zBooleanValue = ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            AbstractC4539a.m3214x("isAppLocked, e: ", e.getMessage(), TAG);
            zBooleanValue = false;
        }
        Logger.m8697d(TAG, "isAppLocked: " + zBooleanValue);
        return zBooleanValue;
    }

    @JvmStatic
    public static final boolean isServiceRunning(@NotNull Context context, @NotNull Class<?> serviceClass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return false;
        }
        Iterator<ActivityManager.RunningServiceInfo> it = activityManager.getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(serviceClass.getName(), it.next().service.getClassName())) {
                Logger.m8697d(TAG, "isServiceRunning true");
                return true;
            }
        }
        return false;
    }
}
