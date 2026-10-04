package com.samsung.android.support.senl.p148nt.base.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ?2\u00020\u0001:\u0005;<=>?B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J.\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u001e\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u0011H\u0002J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0010\u0010'\u001a\u0004\u0018\u00010\n2\u0006\u0010(\u001a\u00020)J\u0018\u0010'\u001a\u0004\u0018\u00010\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u001cH\u0002J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010-\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010.\u001a\u00020\u0005H\u0002J.\u0010/\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J.\u00101\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u00103\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u001cH\u0002J\u0016\u00104\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001cJ\u001e\u00104\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001c2\u0006\u00105\u001a\u000206J\u0016\u00107\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001cJ\u000e\u00108\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u00109\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001cJ \u0010:\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager;", "", "<init>", "()V", "mTaskSize", "", "mTaskControl", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper;", "mActivityMap", "", "", "", "mDefaultActivityClass", "Ljava/lang/Class;", "mLastCallTime", "", "mPrevLaunchedTaskIds", "", "mPrevLaunchedActivityNames", "mIsPairWindowMode", "initialize", "", "defaultActivityClass", "launchActivity", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "launchNoneActivatedTask", "newIntent", "Landroid/content/Intent;", "info", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$TaskInfo;", "tasks", "", "Landroid/app/ActivityManager$AppTask;", "removeTaskNotMemolistAsRoot", "taskInfo", "appTasks", "checkLaunchInterval", "launchMultiWindowMode", "getAvailableClassName", "context", "Landroid/content/Context;", "updateNewTaskIntent", MarketingConstants.LINK_TYPE_INTENT, "isExtendedMultiWindowMode", "moveTaskToFront", "id", "launchBackgroundTask", "getEffectiveTasks", "launchTaskRoot", "targetTaskId", "updateBackgroundTaskIntent", "startActivity", "options", "Landroid/os/Bundle;", "startActivityOfSameTask", "relaunchedActivity", "updateActivityClass", "getOldestActivityClass", "ITaskInfoHelper", "TaskInfoHelperAPI32Impl", "TaskInfoHelperAPI29Impl", "TaskInfoHelperLegacyImpl", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMultiTaskManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiTaskManager.kt\ncom/samsung/android/support/senl/nt/base/common/MultiTaskManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,468:1\n1#2:469\n*E\n"})
public final class MultiTaskManager {
    private static final int APP_MULTIPLE_LAUNCH_DETECT_DURATION_MS = 2000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String INTENT_EXTRA_KEY_RELAUNCH = "intent_extra_task_relaunch";
    private static final int MAX_TASK_COUNT = 5;
    private static final int MID_TASK_COUNT = 3;
    private static final int MIN_TASK_COUNT = 2;

    @NotNull
    private static final String TAG = "MultiTaskManager";

    @Nullable
    private static MultiTaskManager sInstance;

    @NotNull
    private final Map<String, Boolean> mActivityMap;

    @Nullable
    private Class<?> mDefaultActivityClass;
    private boolean mIsPairWindowMode;
    private long mLastCallTime;

    @NotNull
    private final List<String> mPrevLaunchedActivityNames;

    @NotNull
    private final List<Integer> mPrevLaunchedTaskIds;

    @Nullable
    private ITaskInfoHelper mTaskControl;
    private int mTaskSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "INTENT_EXTRA_KEY_RELAUNCH", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager;", "MAX_TASK_COUNT", "", "MID_TASK_COUNT", "MIN_TASK_COUNT", "APP_MULTIPLE_LAUNCH_DETECT_DURATION_MS", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final MultiTaskManager getInstance() {
            if (MultiTaskManager.sInstance == null) {
                MultiTaskManager.sInstance = new MultiTaskManager(null);
            }
            MultiTaskManager multiTaskManager = MultiTaskManager.sInstance;
            Intrinsics.checkNotNull(multiTaskManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.MultiTaskManager");
            return multiTaskManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper;", "", "getTaskId", "", "task", "Landroid/app/ActivityManager$AppTask;", "isRunning", "", "isVisible", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper$VisibleState;", "VisibleState", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ITaskInfoHelper {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper$VisibleState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "INVISIBLE", "VISIBLE", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class VisibleState {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ VisibleState[] $VALUES;
            public static final VisibleState UNKNOWN = new VisibleState("UNKNOWN", 0);
            public static final VisibleState INVISIBLE = new VisibleState("INVISIBLE", 1);
            public static final VisibleState VISIBLE = new VisibleState("VISIBLE", 2);

            private static final /* synthetic */ VisibleState[] $values() {
                return new VisibleState[]{UNKNOWN, INVISIBLE, VISIBLE};
            }

            static {
                VisibleState[] visibleStateArr$values = $values();
                $VALUES = visibleStateArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(visibleStateArr$values);
            }

            private VisibleState(String str, int i) {
            }

            @NotNull
            public static EnumEntries<VisibleState> getEntries() {
                return $ENTRIES;
            }

            public static VisibleState valueOf(String str) {
                return (VisibleState) Enum.valueOf(VisibleState.class, str);
            }

            public static VisibleState[] values() {
                return (VisibleState[]) $VALUES.clone();
            }
        }

        int getTaskId(@NotNull ActivityManager.AppTask task);

        boolean isRunning(@NotNull ActivityManager.AppTask task);

        @NotNull
        VisibleState isVisible(@NotNull ActivityManager.AppTask task);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$TaskInfoHelperAPI29Impl;", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper;", "<init>", "()V", "getTaskId", "", "task", "Landroid/app/ActivityManager$AppTask;", "isRunning", "", "isVisible", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper$VisibleState;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SuppressLint({WarningType.NewApi})
    public static class TaskInfoHelperAPI29Impl implements ITaskInfoHelper {
        @Override // com.samsung.android.support.senl.nt.base.common.MultiTaskManager.ITaskInfoHelper
        public int getTaskId(@NotNull ActivityManager.AppTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return task.getTaskInfo().taskId;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.MultiTaskManager.ITaskInfoHelper
        public boolean isRunning(@NotNull ActivityManager.AppTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return task.getTaskInfo().isRunning;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.MultiTaskManager.ITaskInfoHelper
        @NotNull
        public ITaskInfoHelper.VisibleState isVisible(@NotNull ActivityManager.AppTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return ITaskInfoHelper.VisibleState.UNKNOWN;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$TaskInfoHelperAPI32Impl;", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$TaskInfoHelperAPI29Impl;", "<init>", "()V", "isVisible", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper$VisibleState;", "task", "Landroid/app/ActivityManager$AppTask;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TaskInfoHelperAPI32Impl extends TaskInfoHelperAPI29Impl {
        @Override // com.samsung.android.support.senl.nt.base.common.MultiTaskManager.TaskInfoHelperAPI29Impl, com.samsung.android.support.senl.nt.base.common.MultiTaskManager.ITaskInfoHelper
        @SuppressLint({WarningType.NewApi})
        @NotNull
        public ITaskInfoHelper.VisibleState isVisible(@NotNull ActivityManager.AppTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return task.getTaskInfo().isVisible() ? ITaskInfoHelper.VisibleState.VISIBLE : ITaskInfoHelper.VisibleState.INVISIBLE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$TaskInfoHelperLegacyImpl;", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper;", "<init>", "()V", "getTaskId", "", "task", "Landroid/app/ActivityManager$AppTask;", "isRunning", "", "isVisible", "Lcom/samsung/android/support/senl/nt/base/common/MultiTaskManager$ITaskInfoHelper$VisibleState;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TaskInfoHelperLegacyImpl implements ITaskInfoHelper {
        @Override // com.samsung.android.support.senl.nt.base.common.MultiTaskManager.ITaskInfoHelper
        public int getTaskId(@NotNull ActivityManager.AppTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return task.getTaskInfo().id;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.MultiTaskManager.ITaskInfoHelper
        public boolean isRunning(@NotNull ActivityManager.AppTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return task.getTaskInfo().id != -1;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.MultiTaskManager.ITaskInfoHelper
        @NotNull
        public ITaskInfoHelper.VisibleState isVisible(@NotNull ActivityManager.AppTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return ITaskInfoHelper.VisibleState.UNKNOWN;
        }
    }

    public /* synthetic */ MultiTaskManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void checkLaunchInterval(boolean launchMultiWindowMode) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.mLastCallTime;
        this.mLastCallTime = jCurrentTimeMillis;
        if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() < 5000) {
            launchMultiWindowMode = this.mIsPairWindowMode;
        }
        if (!launchMultiWindowMode || j > 2000) {
            this.mPrevLaunchedTaskIds.clear();
            this.mPrevLaunchedActivityNames.clear();
        }
    }

    private final List<ActivityManager.AppTask> getEffectiveTasks(List<? extends ActivityManager.AppTask> tasks) {
        ArrayList arrayList = new ArrayList();
        for (ActivityManager.AppTask appTask : tasks) {
            ITaskInfoHelper iTaskInfoHelper = this.mTaskControl;
            if ((iTaskInfoHelper != null ? iTaskInfoHelper.isVisible(appTask) : null) != ITaskInfoHelper.VisibleState.VISIBLE) {
                List<Integer> list = this.mPrevLaunchedTaskIds;
                ITaskInfoHelper iTaskInfoHelper2 = this.mTaskControl;
                if (!CollectionsKt.contains(list, iTaskInfoHelper2 != null ? Integer.valueOf(iTaskInfoHelper2.getTaskId(appTask)) : null)) {
                    arrayList.add(appTask);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public static final MultiTaskManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final String getOldestActivityClass(ActivityLifecycleTracker.TaskInfo info, List<? extends ActivityManager.AppTask> appTasks) {
        long j = Long.MAX_VALUE;
        int i = 0;
        for (ActivityLifecycleTracker.TaskInfo.MultiTaskInfo multiTaskInfo : info.multiTaskInfos.values()) {
            long j2 = multiTaskInfo.launchTime;
            if (j > j2) {
                i = multiTaskInfo.taskId;
                j = j2;
            }
        }
        if (i == 0) {
            LoggerBase.INSTANCE.m7138w(TAG, "get oldest Activity : not found id");
            Class<?> cls = this.mDefaultActivityClass;
            if (cls != null) {
                return cls.getName();
            }
            return null;
        }
        for (ActivityManager.AppTask appTask : appTasks) {
            ITaskInfoHelper iTaskInfoHelper = this.mTaskControl;
            if (iTaskInfoHelper != null && iTaskInfoHelper.getTaskId(appTask) == i) {
                ComponentName componentName = appTask.getTaskInfo().baseActivity;
                String className = componentName != null ? componentName.getClassName() : null;
                LoggerBase.INSTANCE.m7132d(TAG, "get oldest Activity : " + className);
                return className;
            }
        }
        LoggerBase.INSTANCE.m7138w(TAG, "get oldest Activity : not found task matched id - " + i);
        Class<?> cls2 = this.mDefaultActivityClass;
        if (cls2 != null) {
            return cls2.getName();
        }
        return null;
    }

    private final boolean isExtendedMultiWindowMode(Activity activity) {
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        boolean zIsMultiWindowMode = companion.getInstance().isMultiWindowMode(activity);
        int pairWindowMode = companion.getInstance().getPairWindowMode(activity);
        LoggerBase.INSTANCE.m7137i(TAG, "is multi-window mode ? " + zIsMultiWindowMode + " or " + pairWindowMode);
        boolean z = pairWindowMode != 0;
        this.mIsPairWindowMode = z;
        return zIsMultiWindowMode || z;
    }

    private final boolean launchBackgroundTask(Activity activity, Intent newIntent, ActivityLifecycleTracker.TaskInfo info, List<? extends ActivityManager.AppTask> tasks) {
        List<ActivityManager.AppTask> effectiveTasks = getEffectiveTasks(tasks);
        for (ActivityLifecycleTracker.TaskInfo.MultiTaskInfo multiTaskInfo : info.multiTaskInfos.values()) {
            if (!multiTaskInfo.isForeground && launchTaskRoot(activity, newIntent, effectiveTasks, multiTaskInfo.taskId)) {
                return true;
            }
        }
        return false;
    }

    private final boolean launchNoneActivatedTask(Activity activity, Intent newIntent, ActivityLifecycleTracker.TaskInfo info, List<? extends ActivityManager.AppTask> tasks) {
        for (ActivityManager.AppTask appTask : tasks) {
            ComponentName componentName = appTask.getTaskInfo().baseActivity;
            ITaskInfoHelper iTaskInfoHelper = this.mTaskControl;
            Integer numValueOf = iTaskInfoHelper != null ? Integer.valueOf(iTaskInfoHelper.getTaskId(appTask)) : null;
            if (componentName != null) {
                String className = componentName.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
                if (this.mActivityMap.containsKey(className) && !info.multiTaskInfos.containsKey(numValueOf) && (!CollectionsKt.contains(this.mPrevLaunchedTaskIds, numValueOf) || !this.mPrevLaunchedActivityNames.contains(className))) {
                    LoggerBase.INSTANCE.m7137i(TAG, AbstractC0541b.m774p("found none activated task : ", numValueOf != null ? Integer.toHexString(numValueOf.intValue()) : null, SQLKeyword.COMMA, className));
                    newIntent.setComponent(componentName);
                    updateBackgroundTaskIntent(newIntent);
                    if (numValueOf != null) {
                        this.mPrevLaunchedTaskIds.add(numValueOf);
                    }
                    this.mPrevLaunchedActivityNames.add(className);
                    activity.startActivity(newIntent);
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean launchTaskRoot(Activity activity, Intent newIntent, List<? extends ActivityManager.AppTask> tasks, int targetTaskId) {
        for (ActivityManager.AppTask appTask : tasks) {
            ITaskInfoHelper iTaskInfoHelper = this.mTaskControl;
            Integer numValueOf = iTaskInfoHelper != null ? Integer.valueOf(iTaskInfoHelper.getTaskId(appTask)) : null;
            int taskId = activity.getTaskId();
            if (numValueOf == null || numValueOf.intValue() != taskId) {
                if (numValueOf != null && numValueOf.intValue() == targetTaskId) {
                    ComponentName componentName = appTask.getTaskInfo().baseActivity;
                    if (componentName == null) {
                        return false;
                    }
                    LoggerBase.INSTANCE.m7137i(TAG, AbstractC0541b.m774p("find background task : ", Integer.toHexString(numValueOf.intValue()), SQLKeyword.COMMA, componentName.getClassName()));
                    newIntent.setComponent(componentName);
                    updateBackgroundTaskIntent(newIntent);
                    this.mPrevLaunchedTaskIds.add(numValueOf);
                    List<String> list = this.mPrevLaunchedActivityNames;
                    String className = componentName.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
                    list.add(className);
                    activity.startActivity(newIntent);
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean moveTaskToFront(List<? extends ActivityManager.AppTask> tasks, int id) {
        Iterator<? extends ActivityManager.AppTask> it = tasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.AppTask next = it.next();
            ITaskInfoHelper iTaskInfoHelper = this.mTaskControl;
            if (iTaskInfoHelper != null && iTaskInfoHelper.getTaskId(next) == id) {
                ITaskInfoHelper iTaskInfoHelper2 = this.mTaskControl;
                if (iTaskInfoHelper2 != null && iTaskInfoHelper2.isRunning(next)) {
                    next.moveToFront();
                    return true;
                }
            }
        }
        return false;
    }

    private final int removeTaskNotMemolistAsRoot(ActivityLifecycleTracker.TaskInfo taskInfo, List<ActivityManager.AppTask> appTasks) {
        ArrayList arrayList = new ArrayList();
        Set<String> setKeySet = this.mActivityMap.keySet();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (ActivityManager.AppTask appTask : appTasks) {
            ITaskInfoHelper iTaskInfoHelper = this.mTaskControl;
            Integer numValueOf = iTaskInfoHelper != null ? Integer.valueOf(iTaskInfoHelper.getTaskId(appTask)) : null;
            ComponentName componentName = appTask.getTaskInfo().baseActivity;
            if (componentName != null) {
                String className = componentName.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
                if (Intrinsics.areEqual(className, MultiTaskManager.class.getName())) {
                    i++;
                }
                if (setKeySet.contains(className)) {
                }
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            arrayList2.add(appTask);
            sb.append(numValueOf != null ? Integer.toHexString(numValueOf.intValue()) : null);
            sb.append(" ");
        }
        appTasks.removeAll(arrayList2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            taskInfo.multiTaskInfos.remove(Integer.valueOf(((Number) it.next()).intValue()));
        }
        int size = taskInfo.multiTaskInfos.size() + i;
        LoggerBase.INSTANCE.m7137i(TAG, "Remove tasks not MemoList as root :" + ((Object) sb) + ", total " + size);
        return size;
    }

    private final void updateBackgroundTaskIntent(Intent intent) {
        intent.setFlags(intent.getFlags() & (-136318977));
    }

    private final void updateNewTaskIntent(Intent intent) {
        intent.setFlags(intent.getFlags() & (-4097));
        intent.addFlags(403177472);
    }

    @Nullable
    public final String getAvailableClassName(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
        Intrinsics.checkNotNullExpressionValue(appTasks, "getAppTasks(...)");
        return getAvailableClassName(appTasks);
    }

    public final void initialize(@Nullable Class<?> defaultActivityClass) {
        if (this.mDefaultActivityClass != null) {
            return;
        }
        this.mDefaultActivityClass = defaultActivityClass;
        String name = defaultActivityClass != null ? defaultActivityClass.getName() : null;
        this.mActivityMap.put(String.valueOf(name), Boolean.FALSE);
        int i = this.mTaskSize;
        for (int i2 = 1; i2 < i; i2++) {
            this.mActivityMap.put(name + i2, Boolean.FALSE);
        }
    }

    public final void launchActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean zIsExtendedMultiWindowMode = isExtendedMultiWindowMode(activity);
        ActivityLifecycleTracker.TaskInfo taskInfo = ApplicationManager.INSTANCE.getInstance().getActivityTracker().getTaskInfo(activity);
        Object systemService = activity.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
        Intrinsics.checkNotNull(appTasks);
        int iRemoveTaskNotMemolistAsRoot = removeTaskNotMemolistAsRoot(taskInfo, appTasks);
        checkLaunchInterval(zIsExtendedMultiWindowMode);
        boolean z = taskInfo.hasFullWindow;
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        int size = appTasks.size();
        int i = this.mTaskSize;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iRemoveTaskNotMemolistAsRoot, size, "TOS #task = ", "(", ") /");
        sbM1173s.append(i);
        sbM1173s.append(", with full : ");
        sbM1173s.append(z);
        sbM1173s.append(", multiMode :");
        sbM1173s.append(zIsExtendedMultiWindowMode);
        companion.m7137i(TAG, sbM1173s.toString());
        Intent intent = activity.getIntent();
        Class<?> cls = this.mDefaultActivityClass;
        if (cls != null) {
            intent.setClass(activity, cls);
        }
        if (!DesktopModeCompat.INSTANCE.getInstance().isDexMode(activity)) {
            Intrinsics.checkNotNull(intent);
            if (launchBackgroundTask(activity, intent, taskInfo, appTasks)) {
                return;
            }
            if (z && !zIsExtendedMultiWindowMode) {
                companion.m7137i(TAG, "with full-window");
                if (moveTaskToFront(appTasks, taskInfo.fullWindowTaskId)) {
                    return;
                }
            }
        }
        String availableClassName = getAvailableClassName(appTasks);
        if (availableClassName != null) {
            companion.m7137i(TAG, "create new : ".concat(availableClassName));
            intent.setClassName(activity, availableClassName);
            Intrinsics.checkNotNull(intent);
            updateNewTaskIntent(intent);
            activity.startActivity(intent);
            return;
        }
        if (iRemoveTaskNotMemolistAsRoot < this.mTaskSize) {
            Intrinsics.checkNotNull(intent);
            if (launchNoneActivatedTask(activity, intent, taskInfo, appTasks)) {
                return;
            }
            companion.m7138w(TAG, "nothing to do");
            return;
        }
        companion.m7138w(TAG, "cannot launched");
        Resources resources = activity.getResources();
        int i2 = C8875R.plurals.max_app_window;
        int i4 = this.mTaskSize;
        String quantityString = resources.getQuantityString(i2, i4, Integer.valueOf(i4));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        ToastHandler.show(activity, quantityString, 1);
    }

    public final void relaunchedActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ApplicationManager.INSTANCE.getInstance().getActivityTracker().onActivityNewIntent(activity);
    }

    public final void startActivity(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        updateActivityClass(context, intent);
        context.startActivity(intent);
    }

    public final void startActivityOfSameTask(@NotNull Activity activity, @NotNull Intent intent) {
        ComponentName componentName;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ActivityManager.AppTask appTask = AppTaskCompat.INSTANCE.getInstance().getAppTask(activity, activity.getTaskId());
        if (appTask != null && (componentName = appTask.getTaskInfo().baseActivity) != null) {
            String className = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            if (this.mActivityMap.containsKey(className)) {
                intent.setClassName(activity, className);
                activity.startActivity(intent);
                LoggerBase.INSTANCE.m7137i(TAG, "start activity from - ".concat(activity.getClass().getSimpleName()));
                return;
            }
        }
        startActivity(activity, intent);
    }

    public final void updateActivityClass(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ActivityLifecycleTracker.TaskInfo taskInfo = ApplicationManager.INSTANCE.getInstance().getActivityTracker().getTaskInfo();
        Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
        Intrinsics.checkNotNull(taskInfo);
        Intrinsics.checkNotNull(appTasks);
        removeTaskNotMemolistAsRoot(taskInfo, appTasks);
        String availableClassName = getAvailableClassName(appTasks);
        if (availableClassName == null) {
            availableClassName = getOldestActivityClass(taskInfo, appTasks);
            intent.setFlags((intent.getFlags() & (-134217729)) | 69206016);
        }
        if (availableClassName != null) {
            intent.setClassName(context, availableClassName);
        }
        intent.putExtra(INTENT_EXTRA_KEY_RELAUNCH, true);
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        if (availableClassName == null) {
            availableClassName = "null";
        }
        companion.m7137i(TAG, "update activity class - ".concat(availableClassName));
    }

    private MultiTaskManager() {
        int i;
        this.mActivityMap = new HashMap();
        this.mPrevLaunchedTaskIds = new ArrayList();
        this.mPrevLaunchedActivityNames = new ArrayList();
        int deviceMemoryLevel = DeviceUtils.getDeviceMemoryLevel();
        if (deviceMemoryLevel != 1) {
            i = 2;
            if (deviceMemoryLevel == 2) {
                i = 5;
            }
        } else {
            i = 3;
        }
        this.mTaskSize = i;
        int i2 = Build.VERSION.SDK_INT;
        this.mTaskControl = i2 >= 32 ? new TaskInfoHelperAPI32Impl() : i2 >= 29 ? new TaskInfoHelperAPI29Impl() : new TaskInfoHelperLegacyImpl();
    }

    private final String getAvailableClassName(List<? extends ActivityManager.AppTask> tasks) {
        ArrayList arrayList = new ArrayList(this.mActivityMap.keySet());
        LoggerBase.INSTANCE.m7137i(TAG, AbstractC1038a.m1214o(arrayList.size(), this.mPrevLaunchedActivityNames.size(), "getAvailableClassName, available/prevLaunched size: ", " / "));
        Iterator<? extends ActivityManager.AppTask> it = tasks.iterator();
        while (it.hasNext()) {
            ComponentName componentName = it.next().getTaskInfo().baseActivity;
            if (componentName != null) {
                String className = componentName.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
                arrayList.remove(className);
            }
        }
        arrayList.removeAll(this.mPrevLaunchedActivityNames);
        if (arrayList.isEmpty()) {
            return null;
        }
        Class<?> cls = this.mDefaultActivityClass;
        String name = cls != null ? cls.getName() : null;
        if (CollectionsKt.contains(arrayList, name)) {
            return name;
        }
        String str = (String) arrayList.get(0);
        LoggerBase.INSTANCE.m7137i(TAG, "getAvailableClassName, availableActivities[0]: " + str);
        return str;
    }

    public final void startActivity(@NotNull Context context, @NotNull Intent intent, @NotNull Bundle options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(options, "options");
        updateActivityClass(context, intent);
        context.startActivity(intent, options);
    }
}
