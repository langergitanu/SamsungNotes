package com.samsung.android.support.senl.p148nt.app.lock;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p145cm.base.common.method.ScreenLockable;
import com.samsung.android.support.senl.p145cm.base.common.util.ScreenLockUtil;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.CompareViewerActivity;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0003\"#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/ScreenLockManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "mHandler", "Landroid/os/Handler;", "mScreenOffBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "mLockedActivityStateMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/nt/app/lock/ScreenLockManager$State;", "Lkotlin/collections/HashMap;", "BUNDLE_KEY_STOPPED_TIME", "", "onActivityCreated", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "getLockType", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "isGoToBackground", "", "context", "Landroid/content/Context;", "printMap", "ScreenOffBroadcastReceiver", "State", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScreenLockManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenLockManager.kt\ncom/samsung/android/support/senl/nt/app/lock/ScreenLockManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,330:1\n1#2:331\n*E\n"})
public final class ScreenLockManager implements Application.ActivityLifecycleCallbacks {
    private static final int DELAY = 300;

    @NotNull
    private static final String KNOX_PACAKGENAME = "com.samsung.android.knox.containercore";
    private static final long MAX_ALLOWED_DURATION_TO_RECREATION = 3000;

    @Nullable
    private Handler mHandler;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = LockLogger.createTag("ScreenLockManager");

    @NotNull
    private final BroadcastReceiver mScreenOffBroadcastReceiver = new ScreenOffBroadcastReceiver();

    @SuppressLint({"UseSparseArrays"})
    @NotNull
    private final HashMap<Integer, State> mLockedActivityStateMap = new HashMap<>();

    @NotNull
    private final String BUNDLE_KEY_STOPPED_TIME = "bundle_key_stopped_time";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/ScreenLockManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "KNOX_PACAKGENAME", "DELAY", "", "MAX_ALLOWED_DURATION_TO_RECREATION", "", "setSecureWindowFlag", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "enable", "", "isConnectedSideSync", "context", "Landroid/content/Context;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isConnectedSideSync(Context context) {
            try {
                if (Settings.System.getInt(context.getContentResolver(), "sidesync_sink_connect", 0) != 1 && Settings.System.getInt(context.getContentResolver(), "sidesync_dashboard_sink_connect", 0) != 1) {
                    if (Settings.System.getInt(context.getContentResolver(), "sidesync_source_connect", 0) == 0) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                AbstractC4539a.m3214x("checkSideSync", e.getMessage(), ScreenLockManager.TAG);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setSecureWindowFlag(Activity activity, boolean enable) {
            if (!enable) {
                activity.getWindow().clearFlags(8192);
                return;
            }
            if (isConnectedSideSync(activity)) {
                return;
            }
            DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
            if (companion.getInstance().isConnectedDoP(activity) && companion.getInstance().isDexDualModeOnScreen(activity)) {
                return;
            }
            activity.getWindow().setFlags(8192, 8192);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/ScreenLockManager$ScreenOffBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/lock/ScreenLockManager;)V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ScreenOffBroadcastReceiver extends BroadcastReceiver {
        public ScreenOffBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Logger.m8697d(ScreenLockManager.TAG, "onReceive# " + context.hashCode() + " " + intent.getAction());
            if (ScreenLockManager.this.mLockedActivityStateMap.isEmpty() || !(context instanceof Activity)) {
                return;
            }
            Activity activity = (Activity) context;
            State state = (State) ScreenLockManager.this.mLockedActivityStateMap.get(Integer.valueOf(activity.getTaskId()));
            if (state == null || state.getIsResumed() || state.getBackground()) {
                return;
            }
            int taskId = activity.getTaskId();
            AppTaskCompat companion = AppTaskCompat.INSTANCE.getInstance();
            String name = LockActivity.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (companion.isEqualTopActivity(context, taskId, name)) {
                return;
            }
            Logger.m8697d(ScreenLockManager.TAG, "goToBackground ");
            state.setBackground(true);
            ScreenLockUtil.coverWindow(activity);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/ScreenLockManager$State;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "activityHash", "", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "isResumed", "setResumed", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "release", "", "toString", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class State {
        private int activityHash;
        private boolean background;
        private boolean isResumed;
        private long lastUpdateTime;

        public State(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activityHash = activity.hashCode();
            this.lastUpdateTime = SystemClock.elapsedRealtime() - 3000;
        }

        public final boolean getBackground() {
            return this.background;
        }

        public final long getLastUpdateTime() {
            return this.lastUpdateTime;
        }

        /* JADX INFO: renamed from: isResumed, reason: from getter */
        public final boolean getIsResumed() {
            return this.isResumed;
        }

        public final void release() {
            this.activityHash = 0;
        }

        public final void setBackground(boolean z) {
            this.background = z;
        }

        public final void setLastUpdateTime(long j) {
            this.lastUpdateTime = j;
        }

        public final void setResumed(boolean z) {
            this.isResumed = z;
        }

        @NotNull
        public String toString() {
            return this.activityHash + "# " + this.background;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LockType
    private final int getLockType(Activity activity) {
        String openUUID;
        if (!(activity instanceof ScreenLockable) || (openUUID = ((ScreenLockable) activity).getOpenUUID()) == null || openUUID.length() == 0) {
            return 0;
        }
        return NotesDataRepositoryFactory.newInstance(activity).createNotesLockDocumentRepository().getLockType(openUUID);
    }

    private final boolean isGoToBackground(Context context) {
        boolean z;
        boolean z2;
        AbstractC4539a.m3188B("IsGoToBackground hash:", Integer.toHexString(hashCode()), TAG);
        try {
            Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager activityManager = (ActivityManager) systemService;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (Intrinsics.areEqual(runningAppProcessInfo.processName, context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                        z = true;
                        break;
                    }
                }
                z = false;
            } else {
                z = false;
            }
            Iterator<ActivityManager.AppTask> it = activityManager.getAppTasks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
                if (taskInfo.baseActivity != null && taskInfo.topActivity != null) {
                    ComponentName componentName = taskInfo.baseActivity;
                    Intrinsics.checkNotNull(componentName);
                    if (Intrinsics.areEqual(componentName.getPackageName(), context.getPackageName())) {
                        ComponentName componentName2 = taskInfo.topActivity;
                        Intrinsics.checkNotNull(componentName2);
                        if (!Intrinsics.areEqual(componentName2.getPackageName(), context.getPackageName())) {
                            ComponentName componentName3 = taskInfo.topActivity;
                            Intrinsics.checkNotNull(componentName3);
                            z2 = Intrinsics.areEqual(componentName3.getPackageName(), KNOX_PACAKGENAME) ? false : true;
                        }
                    }
                }
            }
            Logger.m8697d(TAG, "IsGoToBackground, isNotesOnForeground : " + z + ", isForegroundProcessRunByNotes : " + z2 + " ,isGoToBackground : " + ((z || z2) ? false : true));
            return (z || z2) ? false : true;
        } catch (Exception e) {
            AbstractC4539a.m3188B("IsGoToBackground, Exception : ", e.getMessage(), TAG);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityStopped$lambda$2(ScreenLockManager screenLockManager, Activity activity, Context context) {
        State state = screenLockManager.mLockedActivityStateMap.get(Integer.valueOf(activity.getTaskId()));
        if (state == null || state.getBackground()) {
            return;
        }
        Intrinsics.checkNotNull(context);
        if (screenLockManager.isGoToBackground(context)) {
            state.setBackground(true);
            Logger.m8697d(TAG, "onActivityStopped, activity went to background");
            ScreenLockUtil.coverWindow(activity);
            if (activity instanceof CompareViewerActivity) {
                CompareViewerActivity compareViewerActivity = (CompareViewerActivity) activity;
                if (compareViewerActivity.getMIsLockNote()) {
                    compareViewerActivity.finishWithResult(10);
                }
            }
        }
    }

    private final void printMap() {
        String str = "";
        for (State state : this.mLockedActivityStateMap.values()) {
            Intrinsics.checkNotNullExpressionValue(state, "next(...)");
            str = state + " ";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.m8697d(TAG, str);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof ScreenLockable) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            int lockType = getLockType(activity);
            if (lockType == 5 || LockUtils.isLockedSdocType(lockType)) {
                INSTANCE.setSecureWindowFlag(activity, true);
                String str = TAG;
                AbstractC4539a.m3203m(activity.hashCode(), "onActivityCreated, locked ", str);
                State state = this.mLockedActivityStateMap.get(Integer.valueOf(activity.getTaskId()));
                if (state == null) {
                    state = new State(activity);
                    this.mLockedActivityStateMap.put(Integer.valueOf(activity.getTaskId()), state);
                    Logger.m8697d(str, "onActivityCreated, create new state");
                }
                activity.registerReceiver(this.mScreenOffBroadcastReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"));
                if (savedInstanceState != null && savedInstanceState.containsKey(this.BUNDLE_KEY_STOPPED_TIME)) {
                    long j = savedInstanceState.getLong(this.BUNDLE_KEY_STOPPED_TIME);
                    long lastUpdateTime = state.getLastUpdateTime();
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - 3000;
                    if (lastUpdateTime < jElapsedRealtime && j < jElapsedRealtime) {
                        Logger.m8697d(str, "onActivityCreated, try lock : " + (jElapsedRealtime - j));
                        state.setBackground(true);
                        this.mLockedActivityStateMap.put(Integer.valueOf(activity.getTaskId()), state);
                    }
                }
                printMap();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof ScreenLockable) {
            if (!activity.isFinishing()) {
                State state = this.mLockedActivityStateMap.get(Integer.valueOf(activity.getTaskId()));
                if (state != null) {
                    state.setLastUpdateTime(SystemClock.elapsedRealtime());
                }
                AbstractC4539a.m3203m(activity.hashCode(), "onActivityDestroyed to recreated. hash:", TAG);
                return;
            }
            AbstractC4539a.m3203m(activity.hashCode(), "onActivityDestroyed hash:", TAG);
            State stateRemove = this.mLockedActivityStateMap.remove(Integer.valueOf(activity.hashCode()));
            if (stateRemove != null) {
                stateRemove.release();
                activity.unregisterReceiver(this.mScreenOffBroadcastReceiver);
                printMap();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof ScreenLockable) {
            AbstractC4539a.m3203m(activity.hashCode(), "onActivityPaused hash:", TAG);
            ((ScreenLockable) activity).resetLockVerified();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        boolean background;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof ScreenLockable) {
            String str = TAG;
            AbstractC4539a.m3203m(activity.hashCode(), "onActivityResumed hash:", str);
            int lockType = getLockType(activity);
            boolean z = lockType == 5 || LockUtils.isLockedSdocType(lockType);
            PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            boolean zIsInteractive = companion.getInstance(applicationContext).isInteractive();
            ScreenLockable screenLockable = (ScreenLockable) activity;
            boolean zIsLockVerified = screenLockable.isLockVerified();
            State state = this.mLockedActivityStateMap.get(Integer.valueOf(activity.getTaskId()));
            if (state != null) {
                state.setResumed(true);
                background = state.getBackground();
            } else {
                background = false;
            }
            StringBuilder sbM2230u = AbstractC2821a.m2230u("onActivityResumed locked:", ", background:", ", isInteractive:", z, background);
            sbM2230u.append(zIsInteractive);
            sbM2230u.append(", isLockVerified=");
            sbM2230u.append(zIsLockVerified);
            Logger.m8697d(str, sbM2230u.toString());
            if (!z || !background || !zIsInteractive || zIsLockVerified) {
                if (state != null) {
                    ScreenLockUtil.uncoverWindow(activity);
                }
            } else {
                Logger.m8697d(str, "start lockActivity");
                ScreenLockUtil.coverWindow(activity);
                screenLockable.verifyScreenLock();
                if (state != null) {
                    state.setBackground(false);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        if (activity instanceof ScreenLockable) {
            outState.putLong(this.BUNDLE_KEY_STOPPED_TIME, SystemClock.elapsedRealtime());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Handler handler;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof ScreenLockable) {
            Logger.m8697d(TAG, "onActivityStopped hash:" + activity.hashCode());
            Context baseContext = activity.getBaseContext();
            int lockType = getLockType(activity);
            boolean z = lockType == 5 || LockUtils.isLockedSdocType(lockType);
            State state = this.mLockedActivityStateMap.get(Integer.valueOf(activity.getTaskId()));
            if (state != null) {
                state.setResumed(false);
            }
            if (z && (handler = this.mHandler) != null) {
                handler.postDelayed(new RunnableC0201c(this, 23, activity, baseContext), 300L);
            }
        }
    }
}
