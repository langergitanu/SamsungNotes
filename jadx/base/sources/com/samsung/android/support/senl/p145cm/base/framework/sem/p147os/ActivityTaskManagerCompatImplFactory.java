package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.app.ActivityManager;
import android.app.SemActivityTaskManager;
import android.app.SemTaskChangeCallback;
import android.content.ComponentName;
import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsActivityTaskManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/ActivityTaskManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$SemActivityTaskManagerDelegateImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "Sos", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ActivityTaskManagerCompatImplFactory extends AbsActivityTaskManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "ActivityTaskManagerCompatImplFactory";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/ActivityTaskManagerCompatImplFactory$Sos;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$SemActivityTaskManagerDelegateImpl;", "<init>", "()V", "mCallbackMap", "", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$TaskChangeCallback;", "Landroid/app/SemTaskChangeCallback;", "getMCallbackMap", "()Ljava/util/Map;", "setMCallbackMap", "(Ljava/util/Map;)V", "registerTaskChangeCallback", "", "taskChangeCallback", "unregisterTaskChangeCallback", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Sos implements AbsActivityTaskManagerCompatImplFactory.SemActivityTaskManagerDelegateImpl {

        @NotNull
        private Map<AbsActivityTaskManagerCompatImplFactory.TaskChangeCallback, SemTaskChangeCallback> mCallbackMap = new HashMap();

        @NotNull
        public final Map<AbsActivityTaskManagerCompatImplFactory.TaskChangeCallback, SemTaskChangeCallback> getMCallbackMap() {
            return this.mCallbackMap;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsActivityTaskManagerCompatImplFactory.SemActivityTaskManagerDelegateImpl
        public void registerTaskChangeCallback(@Nullable final AbsActivityTaskManagerCompatImplFactory.TaskChangeCallback taskChangeCallback) {
            if (this.mCallbackMap.get(taskChangeCallback) != null) {
                return;
            }
            SemTaskChangeCallback semTaskChangeCallback = new SemTaskChangeCallback() { // from class: com.samsung.android.support.senl.cm.base.framework.sem.os.ActivityTaskManagerCompatImplFactory$Sos$registerTaskChangeCallback$1
                public void onTaskMovedToBack(ActivityManager.RunningTaskInfo runningTaskInfo) {
                    Intrinsics.checkNotNullParameter(runningTaskInfo, "runningTaskInfo");
                    AbsActivityTaskManagerCompatImplFactory.TaskChangeCallback taskChangeCallback2 = taskChangeCallback;
                    if (taskChangeCallback2 != null) {
                        taskChangeCallback2.onTaskMovedToBack(runningTaskInfo);
                    }
                }

                public void onTaskMovedToFront(ActivityManager.RunningTaskInfo runningTaskInfo) {
                    Intrinsics.checkNotNullParameter(runningTaskInfo, "runningTaskInfo");
                }

                public void onTaskRemoved(int taskId) {
                }

                public void onActivityRequestedOrientationChanged(int taskId, int requestedOrientation) {
                }

                public void onTaskCreated(int taskId, ComponentName componentName) {
                }

                public void onTaskDisplayChanged(int taskId, int newDisplayId) {
                }
            };
            this.mCallbackMap.put(taskChangeCallback, semTaskChangeCallback);
            SemActivityTaskManager.getInstance().registerTaskChangeCallback(semTaskChangeCallback);
        }

        public final void setMCallbackMap(@NotNull Map<AbsActivityTaskManagerCompatImplFactory.TaskChangeCallback, SemTaskChangeCallback> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.mCallbackMap = map;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsActivityTaskManagerCompatImplFactory.SemActivityTaskManagerDelegateImpl
        public void unregisterTaskChangeCallback(@Nullable AbsActivityTaskManagerCompatImplFactory.TaskChangeCallback taskChangeCallback) {
            try {
                SemTaskChangeCallback semTaskChangeCallback = this.mCallbackMap.get(taskChangeCallback);
                if (semTaskChangeCallback == null) {
                    return;
                }
                this.mCallbackMap.remove(taskChangeCallback);
                SemActivityTaskManager.getInstance().unregisterTaskChangeCallback(semTaskChangeCallback);
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("unregisterTaskChangeCallback, e: ", e.getMessage(), LoggerBase.INSTANCE, ActivityTaskManagerCompatImplFactory.TAG);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsActivityTaskManagerCompatImplFactory
    @NotNull
    public AbsActivityTaskManagerCompatImplFactory.SemActivityTaskManagerDelegateImpl create(int deviceType) {
        return (deviceType != 2 || Build.VERSION.SDK_INT < 31) ? super.create(deviceType) : new Sos();
    }
}
