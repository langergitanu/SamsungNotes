package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat$AppTaskCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat$AppTaskCompatImpl;)V", "moveToFront", "", "context", "Landroid/content/Context;", "taskId", "", "moveTaskToFront", "getAppTask", "Landroid/app/ActivityManager$AppTask;", "isEqualTopActivity", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "", "AppTaskCompatImpl", "AppAppTaskCompatQosImpl", "AppAppTaskCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppTaskCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "AppTaskCompat";

    @Nullable
    private static AppTaskCompat sInstance;

    @NotNull
    private final AppTaskCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat$AppAppTaskCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat$AppTaskCompatImpl;", "<init>", "()V", "getTaskId", "", "info", "Landroid/app/ActivityManager$RecentTaskInfo;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AppAppTaskCompatPureImpl implements AppTaskCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.os.AppTaskCompat.AppTaskCompatImpl
        public int getTaskId(@NotNull ActivityManager.RecentTaskInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return info.persistentId;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat$AppAppTaskCompatQosImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat$AppTaskCompatImpl;", "<init>", "()V", "getTaskId", "", "info", "Landroid/app/ActivityManager$RecentTaskInfo;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AppAppTaskCompatQosImpl implements AppTaskCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.os.AppTaskCompat.AppTaskCompatImpl
        public int getTaskId(@NotNull ActivityManager.RecentTaskInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return info.taskId;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat$AppTaskCompatImpl;", "", "getTaskId", "", "info", "Landroid/app/ActivityManager$RecentTaskInfo;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AppTaskCompatImpl {
        int getTaskId(@NotNull ActivityManager.RecentTaskInfo info);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/os/AppTaskCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized AppTaskCompat getInstance() {
            AppTaskCompat appTaskCompat;
            try {
                if (AppTaskCompat.sInstance == null) {
                    AppTaskCompat.sInstance = new AppTaskCompat(Build.VERSION.SDK_INT >= 29 ? new AppAppTaskCompatQosImpl() : new AppAppTaskCompatPureImpl(), null);
                }
                appTaskCompat = AppTaskCompat.sInstance;
                Intrinsics.checkNotNull(appTaskCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.os.AppTaskCompat");
            } catch (Throwable th) {
                throw th;
            }
            return appTaskCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ AppTaskCompat(AppTaskCompatImpl appTaskCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(appTaskCompatImpl);
    }

    @NotNull
    public static final synchronized AppTaskCompat getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final ActivityManager.AppTask getAppTask(@Nullable Context context, int taskId) {
        LoggerBase.INSTANCE.m7132d(TAG, "getAppTask, taskId : " + taskId);
        if (taskId != -1 && context != null) {
            Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager != null) {
                try {
                } catch (Exception unused) {
                    LoggerBase.INSTANCE.m7132d(TAG, "getAppTask, taskId : " + taskId);
                }
                for (ActivityManager.AppTask appTask : activityManager.getAppTasks()) {
                    ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                    if ((taskInfo != null ? taskInfo.topActivity : null) != null && taskInfo.baseActivity != null && this.mImpl.getTaskId(taskInfo) == taskId) {
                        LoggerBase.Companion companion = LoggerBase.INSTANCE;
                        ComponentName componentName = taskInfo.topActivity;
                        String shortClassName = componentName != null ? componentName.getShortClassName() : null;
                        ComponentName componentName2 = taskInfo.baseActivity;
                        companion.m7132d(TAG, "getAppTask, " + shortClassName + " : " + (componentName2 != null ? componentName2.getShortClassName() : null));
                        return appTask;
                    }
                    LoggerBase.INSTANCE.m7132d(TAG, "getAppTask, false");
                }
                LoggerBase.INSTANCE.m7132d(TAG, "getAppTask, false");
            }
        }
        return null;
    }

    public final boolean isEqualTopActivity(@Nullable Context context, int taskId, @NotNull String activityName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        LoggerBase.INSTANCE.m7132d(TAG, "isEqualTopActivity, taskId : " + taskId);
        if (taskId != -1 && context != null) {
            Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager != null) {
                try {
                    Iterator<ActivityManager.AppTask> it = activityManager.getAppTasks().iterator();
                    while (it.hasNext()) {
                        ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
                        if ((taskInfo != null ? taskInfo.topActivity : null) != null && taskInfo.baseActivity != null && this.mImpl.getTaskId(taskInfo) == taskId) {
                            ComponentName componentName = taskInfo.topActivity;
                            return Intrinsics.areEqual(componentName != null ? componentName.getClassName() : null, activityName);
                        }
                    }
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7133e(TAG, "isEqualTopActivity : " + e);
                }
            }
        }
        return false;
    }

    public final boolean moveTaskToFront(@NotNull Context context, int taskId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return false;
        }
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "moveTaskToFront, taskId : " + taskId);
        if (getAppTask(context, taskId) != null) {
            activityManager.moveTaskToFront(taskId, 0);
            return true;
        }
        companion.m7132d(TAG, "moveTaskToFront, false");
        return false;
    }

    public final boolean moveToFront(@Nullable Context context, int taskId) {
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "moveToFront, taskId : " + taskId);
        ActivityManager.AppTask appTask = getAppTask(context, taskId);
        if (appTask != null) {
            appTask.moveToFront();
            return true;
        }
        companion.m7132d(TAG, "moveToFront, false");
        return false;
    }

    private AppTaskCompat(AppTaskCompatImpl appTaskCompatImpl) {
        this.mImpl = appTaskCompatImpl;
    }
}
