package com.samsung.android.support.senl.p148nt.base.common;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.glance.AbstractC2821a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.method.CloseableActivity;
import com.samsung.android.support.senl.p145cm.base.framework.view.DisplayCutoutCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\bZ[\\]^_`aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001aJ\u0018\u0010+\u001a\u0004\u0018\u00010%2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001dJ\u0006\u0010.\u001a\u00020\rJ\u0010\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0015J\u0010\u00101\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0015J\u0010\u00102\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0017J\u0010\u00103\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0017J\b\u00104\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\rH\u0002J\b\u00107\u001a\u00020\rH\u0002J\b\u00108\u001a\u00020\rH\u0002J\u0010\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0002J\u0010\u0010;\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0002J\u0010\u0010<\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0002J\u0010\u0010=\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0002J\u001a\u0010>\u001a\u00020\r2\u0006\u0010:\u001a\u00020%2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010A\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0016J\u0010\u0010B\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0016J\u0010\u0010C\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0016J\u0010\u0010D\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0016J\u0010\u0010E\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0016J\u0018\u0010F\u001a\u00020\r2\u0006\u0010:\u001a\u00020%2\u0006\u0010G\u001a\u00020@H\u0016J\u0010\u0010H\u001a\u00020\r2\u0006\u0010:\u001a\u00020%H\u0016J\u000e\u0010I\u001a\u00020\r2\u0006\u0010:\u001a\u00020%J\u000e\u0010J\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001aJ\u000e\u0010K\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001aJ\u000e\u0010L\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001aJ\u000e\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u001dJ\u000e\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020%J\u0012\u0010Q\u001a\u00020\r2\n\u0010R\u001a\u0006\u0012\u0002\b\u00030SJ(\u0010T\u001a\u00020\r2\u0006\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\b\u00100\u001a\u0004\u0018\u00010YR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b(\u0010'¨\u0006b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "mLifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onStateEvent", "", "owner", "event", "Landroidx/lifecycle/Lifecycle$Event;", "mApplicationInForeground", "", "mApplicationLifecycleCallbacks", "", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ApplicationLifecycleCallback;", "mActivityLifeCycleCallback", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ActivityLifeCycleCallback;", "mActivityInfoMap", "", "", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ActivityInfo;", "activityCount", "", "getActivityCount", "()I", "taskInfo", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$TaskInfo;", "getTaskInfo", "()Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$TaskInfo;", "except", "Landroid/app/Activity;", "isApplicationInForeground", "()Z", "isApplicationInIdle", "findTaskIdWithActivityName", "activityClassSimpleName", "findActivityWithActivityNamePrefixAndTaskId", "activityClassSimpleNamePrefix", "taskId", "clear", "addOnApplicationLifecycleCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "removeOnApplicationLifecycleCallback", "addOnActivityLifeCycleCallback", "removeOnActivityLifeCycleCallback", "notifyOnApplicationInIdle", "notifyOnApplicationInBackgroundCallbacks", "notifyOnApplicationOnCreatedCallbacks", "notifyOnApplicationInForegroundCallbacks", "notifyOnApplicationRunningCriticalCallbacks", "notifyOnActivityResumed", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "notifyOnActivityPostResumed", "notifyOnActivityPaused", "notifyOnActivityDestroyed", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPostResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "onActivityNewIntent", "isActivityRunning", "isActivityFinishing", "isActivityOnResumed", "onTrimMemory", "level", "closeAllInSameTask", "currentActivity", "closeAllInSameClass", "clazz", "Ljava/lang/Class;", "requestCloseActionToActivity", "requestActivity", "classSimpleName", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Lcom/samsung/android/support/senl/cm/base/common/method/CloseableActivity$Callback;", "ApplicationLifecycleCallback", "ActivityLifeCycleCallback", "TaskInfo", "ActivityInfo", "ComposerEditable", "NoteEditable", "NoteListSupportOtherApps", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ActivityLifecycleTracker implements Application.ActivityLifecycleCallbacks, LifecycleOwner, LifecycleObserver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "MemoApplication$ActivityLifecycleTracker";
    private boolean mApplicationInForeground;

    @NotNull
    private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    @NotNull
    private final List<ApplicationLifecycleCallback> mApplicationLifecycleCallbacks = new CopyOnWriteArrayList();

    @NotNull
    private final List<ActivityLifeCycleCallback> mActivityLifeCycleCallback = new CopyOnWriteArrayList();

    @NotNull
    private final Map<String, ActivityInfo> mActivityInfoMap = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00030\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ActivityInfo;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "taskId", "", "<init>", "(Landroid/app/Activity;I)V", "getTaskId", "()I", "mActivity", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "isForeground", "", "()Z", "setForeground", "(Z)V", "creationTime", "", "getCreationTime", "()J", "mLastStoppedTime", "lastLaunchTime", "getLastLaunchTime", "setLastLaunchTime", "(J)V", "toString", "", "getActivity", "()Landroid/app/Activity;", "setLastStoppedTime", "", "updateLastLaunchTime", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ActivityInfo {
        private final long creationTime;
        private boolean isForeground;
        private long lastLaunchTime;

        @NotNull
        private final WeakReference<Activity> mActivity;
        private long mLastStoppedTime;
        private final int taskId;

        public ActivityInfo(@NotNull Activity activity, int i) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.taskId = i;
            this.mActivity = new WeakReference<>(activity);
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.creationTime = jCurrentTimeMillis;
            this.lastLaunchTime = jCurrentTimeMillis;
        }

        @Nullable
        public final Activity getActivity() {
            return this.mActivity.get();
        }

        public final long getCreationTime() {
            return this.creationTime;
        }

        public final long getLastLaunchTime() {
            return this.lastLaunchTime;
        }

        public final int getTaskId() {
            return this.taskId;
        }

        /* JADX INFO: renamed from: isForeground, reason: from getter */
        public final boolean getIsForeground() {
            return this.isForeground;
        }

        public final void setForeground(boolean z) {
            this.isForeground = z;
        }

        public final void setLastLaunchTime(long j) {
            this.lastLaunchTime = j;
        }

        public final void setLastStoppedTime() {
            this.mLastStoppedTime = System.currentTimeMillis();
        }

        @NotNull
        public String toString() {
            return "activity: " + this.mActivity.get() + ", taskId: " + this.taskId;
        }

        public final void updateLastLaunchTime() {
            this.lastLaunchTime = System.currentTimeMillis();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ActivityLifeCycleCallback;", "", "onActivityResumed", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "onActivityPostResumed", "onActivityPaused", "onActivityDestroyed", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ActivityLifeCycleCallback {
        void onActivityDestroyed(@Nullable Activity activity);

        void onActivityPaused(@Nullable Activity activity);

        void onActivityPostResumed(@Nullable Activity activity);

        void onActivityResumed(@Nullable Activity activity);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ApplicationLifecycleCallback;", "", "onApplicationCreated", "", "onApplicationForeground", "onApplicationBackground", "onApplicationIdle", "onApplicationRunningCritical", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ApplicationLifecycleCallback {
        void onApplicationBackground();

        void onApplicationCreated();

        void onApplicationForeground();

        void onApplicationIdle();

        void onApplicationRunningCritical();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "makeKey", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String makeKey(Activity activity) {
            return AbstractC2821a.m2218i(activity.hashCode(), activity.getClass().getSimpleName(), "$");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ComposerEditable;", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ComposerEditable {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$NoteEditable;", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface NoteEditable {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$NoteListSupportOtherApps;", "", "closeOtherAppsFromNoteList", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface NoteListSupportOtherApps {
        void closeOtherAppsFromNoteList();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$TaskInfo;", "", "<init>", "()V", "taskCount", "", "getTaskCount", "()I", "setTaskCount", "(I)V", "hasFullWindow", "", "fullWindowTaskId", "multiTaskInfos", "", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$TaskInfo$MultiTaskInfo;", "MultiTaskInfo", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TaskInfo {

        @JvmField
        public int fullWindowTaskId;

        @JvmField
        public boolean hasFullWindow;

        @JvmField
        @NotNull
        public Map<Integer, MultiTaskInfo> multiTaskInfos = new HashMap();
        private int taskCount;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$TaskInfo$MultiTaskInfo;", "", "<init>", "()V", "taskId", "", "isForeground", "", "launchTime", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class MultiTaskInfo {

            @JvmField
            public boolean isForeground;

            @JvmField
            public long launchTime;

            @JvmField
            public int taskId;
        }

        public final int getTaskCount() {
            return this.taskCount;
        }

        public final void setTaskCount(int i) {
            this.taskCount = i;
        }
    }

    private final boolean isApplicationInForeground() {
        boolean z;
        Iterator<ActivityInfo> it = this.mActivityInfoMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ActivityInfo next = it.next();
            if (next != null && next.getActivity() != null && next.getIsForeground()) {
                z = true;
                break;
            }
        }
        Logger.m8702i(TAG, "isOnApplicationForeground, isInForeground : " + z);
        return z;
    }

    private final void notifyOnActivityDestroyed(Activity activity) {
        Logger.m8697d(TAG, "notifyOnActivityDestroyed");
        for (ActivityLifeCycleCallback activityLifeCycleCallback : this.mActivityLifeCycleCallback) {
            if (activityLifeCycleCallback != null) {
                activityLifeCycleCallback.onActivityDestroyed(activity);
            }
        }
    }

    private final void notifyOnActivityPaused(Activity activity) {
        Logger.m8697d(TAG, "notifyOnActivityPaused");
        for (ActivityLifeCycleCallback activityLifeCycleCallback : this.mActivityLifeCycleCallback) {
            if (activityLifeCycleCallback != null) {
                activityLifeCycleCallback.onActivityPaused(activity);
            }
        }
    }

    private final void notifyOnActivityPostResumed(Activity activity) {
        Logger.m8697d(TAG, "notifyOnActivityPostResumed");
        for (ActivityLifeCycleCallback activityLifeCycleCallback : this.mActivityLifeCycleCallback) {
            if (activityLifeCycleCallback != null) {
                activityLifeCycleCallback.onActivityPostResumed(activity);
            }
        }
    }

    private final void notifyOnActivityResumed(Activity activity) {
        Logger.m8697d(TAG, "notifyOnActivityResumed");
        for (ActivityLifeCycleCallback activityLifeCycleCallback : this.mActivityLifeCycleCallback) {
            if (activityLifeCycleCallback != null) {
                activityLifeCycleCallback.onActivityResumed(activity);
            }
        }
    }

    private final void notifyOnApplicationInBackgroundCallbacks() {
        Logger.m8697d(TAG, "notifyOnApplicationInBackgroundCallbacks");
        for (ApplicationLifecycleCallback applicationLifecycleCallback : this.mApplicationLifecycleCallbacks) {
            if (applicationLifecycleCallback != null) {
                applicationLifecycleCallback.onApplicationBackground();
            }
        }
        onStateEvent(this, Lifecycle.Event.ON_STOP);
    }

    private final void notifyOnApplicationInForegroundCallbacks() {
        Logger.m8697d(TAG, "notifyOnApplicationInForegroundCallbacks");
        for (ApplicationLifecycleCallback applicationLifecycleCallback : this.mApplicationLifecycleCallbacks) {
            if (applicationLifecycleCallback != null) {
                applicationLifecycleCallback.onApplicationForeground();
            }
        }
        onStateEvent(this, Lifecycle.Event.ON_START);
    }

    private final void notifyOnApplicationInIdle() {
        Logger.m8697d(TAG, "notifyOnApplicationInIdle");
        for (ApplicationLifecycleCallback applicationLifecycleCallback : this.mApplicationLifecycleCallbacks) {
            if (applicationLifecycleCallback != null) {
                applicationLifecycleCallback.onApplicationIdle();
            }
        }
        onStateEvent(this, Lifecycle.Event.ON_DESTROY);
    }

    private final void notifyOnApplicationOnCreatedCallbacks() {
        Logger.m8697d(TAG, "notifyOnApplicationOnCreatedCallbacks");
        for (ApplicationLifecycleCallback applicationLifecycleCallback : this.mApplicationLifecycleCallbacks) {
            if (applicationLifecycleCallback != null) {
                applicationLifecycleCallback.onApplicationCreated();
            }
        }
        onStateEvent(this, Lifecycle.Event.ON_CREATE);
    }

    private final void notifyOnApplicationRunningCriticalCallbacks() {
        Logger.m8697d(TAG, "notifyOnApplicationInForegroundCallbacks");
        for (ApplicationLifecycleCallback applicationLifecycleCallback : this.mApplicationLifecycleCallbacks) {
            if (applicationLifecycleCallback != null) {
                applicationLifecycleCallback.onApplicationRunningCritical();
            }
        }
    }

    public final void addOnActivityLifeCycleCallback(@Nullable ActivityLifeCycleCallback callback) {
        Logger.m8697d(TAG, "addOnActivityLifeCycleCallback, callback : " + (callback == null ? "null" : callback));
        if (callback == null || this.mActivityLifeCycleCallback.contains(callback)) {
            return;
        }
        this.mActivityLifeCycleCallback.add(callback);
    }

    public final void addOnApplicationLifecycleCallback(@Nullable ApplicationLifecycleCallback callback) {
        Logger.m8697d(TAG, "addOnApplicationLifecycleCallback, callback : " + (callback == null ? "null" : callback));
        if (callback == null || this.mApplicationLifecycleCallbacks.contains(callback)) {
            return;
        }
        this.mApplicationLifecycleCallbacks.add(callback);
    }

    public final void clear() {
        this.mActivityInfoMap.clear();
    }

    public final void closeAllInSameClass(@NotNull Class<?> clazz) {
        Activity activity;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        for (ActivityInfo activityInfo : this.mActivityInfoMap.values()) {
            if (activityInfo != null && (activity = activityInfo.getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing() && clazz.isInstance(activity)) {
                activity.finish();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void closeAllInSameTask(@NotNull Activity currentActivity) {
        Activity activity;
        Intrinsics.checkNotNullParameter(currentActivity, "currentActivity");
        int taskId = currentActivity.getTaskId();
        for (ActivityInfo activityInfo : this.mActivityInfoMap.values()) {
            if (activityInfo != null && (activity = activityInfo.getActivity()) != 0 && activity.getTaskId() == taskId && !Intrinsics.areEqual(activity, currentActivity) && !activity.isDestroyed() && !activity.isFinishing()) {
                if (activity instanceof ComposerEditable) {
                    ComposerManager.INSTANCE.getInstance().closeComposer(activity);
                } else if (activity instanceof NoteListSupportOtherApps) {
                    ((NoteListSupportOtherApps) activity).closeOtherAppsFromNoteList();
                    activity.finish();
                } else {
                    activity.finish();
                }
            }
        }
    }

    @Nullable
    public final Activity findActivityWithActivityNamePrefixAndTaskId(@NotNull String activityClassSimpleNamePrefix, int taskId) {
        Intrinsics.checkNotNullParameter(activityClassSimpleNamePrefix, "activityClassSimpleNamePrefix");
        Iterator<ActivityInfo> it = this.mActivityInfoMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            ActivityInfo next = it.next();
            if (next != null) {
                Activity activity = next.getActivity();
                if ((activity != null ? activity.getIntent() : null) == null) {
                    continue;
                } else {
                    String simpleName = activity.getClass().getSimpleName();
                    Intrinsics.checkNotNull(simpleName);
                    if (StringsKt.m14145S(simpleName, activityClassSimpleNamePrefix) && next.getTaskId() == taskId) {
                        Logger.m8697d(TAG, "findActivityWithActivityNamePrefixAndTaskId activity : " + activity.getClass().getSimpleName() + ", taskId : " + taskId);
                        return activity;
                    }
                }
            }
        }
    }

    public final int findTaskIdWithActivityName(@NotNull String activityClassSimpleName) {
        Intrinsics.checkNotNullParameter(activityClassSimpleName, "activityClassSimpleName");
        for (ActivityInfo activityInfo : this.mActivityInfoMap.values()) {
            if (activityInfo != null) {
                Activity activity = activityInfo.getActivity();
                if ((activity != null ? activity.getIntent() : null) != null && Intrinsics.areEqual(activityClassSimpleName, activity.getClass().getSimpleName())) {
                    Logger.m8697d(TAG, "findTaskIdWithActivityName activity : ".concat(activity.getClass().getSimpleName()));
                    return activity.getTaskId();
                }
            }
        }
        return -1;
    }

    public final int getActivityCount() {
        Activity activity;
        int i = 0;
        if (!this.mActivityInfoMap.isEmpty()) {
            for (ActivityInfo activityInfo : this.mActivityInfoMap.values()) {
                if (activityInfo != null && (activity = activityInfo.getActivity()) != null) {
                    String simpleName = activity.getClass().getSimpleName();
                    int iHashCode = activity.hashCode();
                    boolean isForeground = activityInfo.getIsForeground();
                    String hexString = Integer.toHexString(activity.getTaskId());
                    StringBuilder sbM780v = AbstractC0541b.m780v("[", iHashCode, simpleName, " hash(", ") ");
                    sbM780v.append(isForeground);
                    sbM780v.append(" on ");
                    sbM780v.append(hexString);
                    sbM780v.append("]");
                    Logger.m8702i(TAG, sbM780v.toString());
                    i++;
                }
            }
            AbstractC4539a.m3212v(i, "getActivityCount: ", TAG);
        }
        return i;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NotNull
    public final TaskInfo getTaskInfo() {
        return getTaskInfo(null);
    }

    public final boolean isActivityFinishing(@NotNull String activityClassSimpleName) {
        Activity activity;
        Intrinsics.checkNotNullParameter(activityClassSimpleName, "activityClassSimpleName");
        AbstractC4539a.m3188B("isActivityFinishing - ", Logger.getEncode(activityClassSimpleName), TAG);
        Iterator<Map.Entry<String, ActivityInfo>> it = this.mActivityInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            ActivityInfo value = it.next().getValue();
            if (value != null && (activity = value.getActivity()) != null && Intrinsics.areEqual(activityClassSimpleName, activity.getClass().getSimpleName()) && activity.isFinishing()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isActivityOnResumed(@NotNull String activityClassSimpleName) {
        Intrinsics.checkNotNullParameter(activityClassSimpleName, "activityClassSimpleName");
        AbstractC4539a.m3188B("isActivityOnResumed - ", Logger.getEncode(activityClassSimpleName), TAG);
        for (Map.Entry<String, ActivityInfo> entry : this.mActivityInfoMap.entrySet()) {
            String key = entry.getKey();
            ActivityInfo value = entry.getValue();
            if (value != null) {
                Activity activity = value.getActivity();
                if (activity == null) {
                    this.mActivityInfoMap.remove(key);
                } else if (!activity.isDestroyed() && Intrinsics.areEqual(activityClassSimpleName, activity.getClass().getSimpleName())) {
                    try {
                        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                        for (Fragment fragment : supportFragmentManager.getFragments()) {
                            if (fragment.getLifecycle().getState() == Lifecycle.State.RESUMED) {
                                Logger.m8697d(TAG, "isActivityOnResumed " + fragment.getTag() + " isResumed");
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        AbstractC4539a.m3188B("isActivityOnResumed, exception : ", e.getMessage(), TAG);
                    }
                }
            }
        }
        return false;
    }

    public final boolean isActivityRunning(@NotNull String activityClassSimpleName) {
        Intrinsics.checkNotNullParameter(activityClassSimpleName, "activityClassSimpleName");
        if (TextUtils.isEmpty(activityClassSimpleName)) {
            Logger.m8703w(TAG, "isActivityRunning, false, activityClassSimpleName is invalid");
            return false;
        }
        AbstractC4539a.m3188B("isActivityRunning - ", Logger.getEncode(activityClassSimpleName), TAG);
        for (Map.Entry<String, ActivityInfo> entry : this.mActivityInfoMap.entrySet()) {
            String key = entry.getKey();
            ActivityInfo value = entry.getValue();
            if (value != null) {
                Activity activity = value.getActivity();
                if (activity == null) {
                    this.mActivityInfoMap.remove(key);
                } else if (!activity.isDestroyed() && Intrinsics.areEqual(activityClassSimpleName, activity.getClass().getSimpleName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isApplicationInIdle() {
        return getActivityCount() <= 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isApplicationInIdle()) {
            notifyOnApplicationOnCreatedCallbacks();
        }
        if (Build.VERSION.SDK_INT < 35) {
            DisplayCutoutCompat.INSTANCE.getInstance().setDisplayCutoutMode(activity, 1);
        } else {
            DisplayCutoutCompat.INSTANCE.getInstance().setDisplayCutoutMode(activity, 0);
        }
        this.mActivityInfoMap.put(INSTANCE.makeKey(activity), new ActivityInfo(activity, activity.getTaskId()));
        ServiceManager.INSTANCE.getInstance().onActivityCreated(activity, savedInstanceState);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mActivityInfoMap.remove(INSTANCE.makeKey(activity));
        if (isApplicationInIdle()) {
            notifyOnApplicationInIdle();
        }
        notifyOnActivityDestroyed(activity);
        ServiceManager.INSTANCE.getInstance().onActivityDestroyed(activity);
    }

    public final void onActivityNewIntent(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityInfo activityInfo = this.mActivityInfoMap.get(INSTANCE.makeKey(activity));
        if (activityInfo == null) {
            return;
        }
        activityInfo.updateLastLaunchTime();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ServiceManager.INSTANCE.getInstance().onActivityPaused(activity);
        notifyOnActivityPaused(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        notifyOnActivityPostResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ServiceManager.INSTANCE.getInstance().onActivityResumed(activity);
        notifyOnActivityResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        ServiceManager.INSTANCE.getInstance().onActivitySaveInstanceState(activity, outState);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityInfo activityInfo = this.mActivityInfoMap.get(INSTANCE.makeKey(activity));
        if (activityInfo != null) {
            activityInfo.setForeground(true);
        }
        if (!this.mApplicationInForeground) {
            this.mApplicationInForeground = true;
            notifyOnApplicationInForegroundCallbacks();
        }
        ServiceManager.INSTANCE.getInstance().onActivityStarted(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityInfo activityInfo = this.mActivityInfoMap.get(INSTANCE.makeKey(activity));
        if (activityInfo != null) {
            activityInfo.setForeground(false);
            activityInfo.setLastStoppedTime();
        }
        if (this.mApplicationInForeground && !isApplicationInForeground()) {
            this.mApplicationInForeground = false;
            notifyOnApplicationInBackgroundCallbacks();
        }
        ServiceManager.INSTANCE.getInstance().onActivityStopped(activity);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public final void onStateEvent(@Nullable LifecycleOwner owner, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.mLifecycleRegistry.handleLifecycleEvent(event);
        Logger.m8703w(TAG, "onStateEvent, event : " + event);
    }

    public final void onTrimMemory(int level) {
        AbstractC4539a.m3203m(level, "onTrimMemory, level : ", TAG);
        if (level == 20 && this.mApplicationInForeground) {
            this.mApplicationInForeground = false;
            notifyOnApplicationInBackgroundCallbacks();
        } else if (level == 15) {
            notifyOnApplicationRunningCriticalCallbacks();
        }
    }

    public final void removeOnActivityLifeCycleCallback(@Nullable ActivityLifeCycleCallback callback) {
        Logger.m8697d(TAG, "removeOnActivityLifeCycleCallback, callback : " + (callback == null ? "null" : callback));
        if (callback != null) {
            this.mActivityLifeCycleCallback.remove(callback);
        }
    }

    public final void removeOnApplicationLifecycleCallback(@Nullable ApplicationLifecycleCallback callback) {
        Logger.m8697d(TAG, "removeOnApplicationLifecycleCallback, callback : " + (callback == null ? "null" : callback));
        if (callback != null) {
            this.mApplicationLifecycleCallbacks.remove(callback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void requestCloseActionToActivity(@NotNull Activity requestActivity, @NotNull String classSimpleName, @NotNull Intent intent, @Nullable CloseableActivity.Callback callback) {
        Activity activity;
        Intrinsics.checkNotNullParameter(requestActivity, "requestActivity");
        Intrinsics.checkNotNullParameter(classSimpleName, "classSimpleName");
        Intrinsics.checkNotNullParameter(intent, "intent");
        for (ActivityInfo activityInfo : this.mActivityInfoMap.values()) {
            if (activityInfo != null && (activity = activityInfo.getActivity()) != 0 && !activity.isDestroyed() && !activity.isFinishing() && requestActivity.getTaskId() == activity.getTaskId() && Intrinsics.areEqual(classSimpleName, activity.getClass().getSimpleName()) && (activity instanceof CloseableActivity)) {
                ((CloseableActivity) activity).close(intent, activityInfo.getIsForeground() ? null : callback);
            }
        }
    }

    @NotNull
    public final TaskInfo getTaskInfo(@Nullable Activity except) {
        Activity activity;
        TaskInfo taskInfo = new TaskInfo();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        if (this.mActivityInfoMap.isEmpty()) {
            taskInfo.multiTaskInfos = map;
            return taskInfo;
        }
        for (ActivityInfo activityInfo : this.mActivityInfoMap.values()) {
            if (activityInfo != null && (activity = activityInfo.getActivity()) != null && !Intrinsics.areEqual(activity, except) && (except == null || !Intrinsics.areEqual(activity.getClass().getName(), except.getClass().getName()))) {
                int taskId = activity.getTaskId();
                if (WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(activity) == 0 && arrayList3.contains(Integer.valueOf(taskId))) {
                    map.remove(Integer.valueOf(taskId));
                    arrayList3.add(Integer.valueOf(taskId));
                } else {
                    TaskInfo.MultiTaskInfo multiTaskInfo = (TaskInfo.MultiTaskInfo) map.get(Integer.valueOf(taskId));
                    if (multiTaskInfo == null) {
                        multiTaskInfo = new TaskInfo.MultiTaskInfo();
                        multiTaskInfo.taskId = taskId;
                        multiTaskInfo.isForeground = activityInfo.getIsForeground();
                        map.put(Integer.valueOf(taskId), multiTaskInfo);
                        arrayList2.add(Integer.valueOf(taskId));
                    }
                    multiTaskInfo.isForeground |= activityInfo.getIsForeground();
                }
                if (!arrayList.contains(Integer.valueOf(taskId))) {
                    arrayList.add(Integer.valueOf(taskId));
                }
                TaskInfo.MultiTaskInfo multiTaskInfo2 = (TaskInfo.MultiTaskInfo) map.get(Integer.valueOf(taskId));
                if (multiTaskInfo2 != null && activity.isTaskRoot()) {
                    multiTaskInfo2.launchTime = activityInfo.getLastLaunchTime();
                }
            }
        }
        taskInfo.setTaskCount(arrayList.size());
        taskInfo.multiTaskInfos = map;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.remove(Integer.valueOf(((Number) it.next()).intValue()));
        }
        int size = arrayList.size();
        if (size > 0) {
            AbstractC4539a.m3212v(size, "has full window : ", TAG);
            taskInfo.hasFullWindow = true;
            taskInfo.fullWindowTaskId = ((Number) arrayList.get(0)).intValue();
        }
        Logger.m8702i(TAG, "getTaskInfo: total = " + taskInfo.getTaskCount() + ", multi = " + taskInfo.multiTaskInfos.size());
        return taskInfo;
    }
}
