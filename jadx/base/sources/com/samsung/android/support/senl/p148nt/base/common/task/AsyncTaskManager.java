package com.samsung.android.support.senl.p148nt.base.common.task;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u0003123B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010 \u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006J\"\u0010\"\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000eJ\u0016\u0010)\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000eJ\u001c\u0010*\u001a\u00020\u00142\u0014\u0010!\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006J,\u0010-\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0012\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010#\u001a\u00020$H\u0002J$\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u00072\u0006\u0010&\u001a\u00020'H\u0002J(\u0010.\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010&\u001a\u00020'2\n\u0010/\u001a\u0006\u0012\u0002\b\u000300J \u0010.\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\u0010/\u001a\u0006\u0012\u0002\b\u000300RB\u0010\u0004\u001a*\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0005j\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR0\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u0005j\b\u0012\u0004\u0012\u00020\u000e`\u00070\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0005j\b\u0012\u0004\u0012\u00020\u000e`\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\t¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "mTaskList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskWithActivity;", "Lkotlin/collections/ArrayList;", "getMTaskList", "()Ljava/util/ArrayList;", "setMTaskList", "(Ljava/util/ArrayList;)V", "mTaskListener", "Landroid/util/SparseArray;", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskStatusListener;", "getMTaskListener", "()Landroid/util/SparseArray;", "setMTaskListener", "(Landroid/util/SparseArray;)V", "onActivityCreated", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "addTask", "task", "removeTask", "result", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;", "registerTaskStatusListener", "activityHashCode", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterTaskStatusListener", "onStart", "taskStatusListeners", "getTaskStatusListeners", "onEnd", "getRunningTask", "clazz", "Ljava/lang/Class;", "TaskResult", "TaskStatusListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AsyncTaskManager implements Application.ActivityLifecycleCallbacks {

    @NotNull
    private static final String KEY_ACTIVITY_HASHCODE = "activity_hashcode";

    @NotNull
    private ArrayList<AsyncTaskWithActivity<?, ?, ?>> mTaskList = new ArrayList<>();

    @NotNull
    private SparseArray<ArrayList<TaskStatusListener>> mTaskListener = new SparseArray<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;", "", "type", "", "getType", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TaskResult {
        @NotNull
        String getType();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005H&J(\u0010\u0006\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskStatusListener;", "", "onStart", "", "task", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskWithActivity;", "onEnd", "taskResult", "Lcom/samsung/android/support/senl/nt/base/common/task/AsyncTaskManager$TaskResult;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TaskStatusListener {
        void onEnd(@Nullable AsyncTaskWithActivity<?, ?, ?> task, @Nullable TaskResult taskResult);

        void onStart(@Nullable AsyncTaskWithActivity<?, ?, ?> task);
    }

    private final ArrayList<TaskStatusListener> getTaskStatusListeners() {
        ArrayList<TaskStatusListener> arrayList = new ArrayList<>();
        int size = this.mTaskListener.size();
        for (int i = 0; i < size; i++) {
            ArrayList<TaskStatusListener> arrayListValueAt = this.mTaskListener.valueAt(i);
            if (!arrayListValueAt.isEmpty()) {
                arrayList.addAll(arrayListValueAt);
            }
        }
        return arrayList;
    }

    private final void onEnd(int activityHashCode, AsyncTaskWithActivity<?, ?, ?> task, TaskResult result) {
        ArrayList<TaskStatusListener> taskStatusListeners = getTaskStatusListeners(activityHashCode);
        if (taskStatusListeners == null) {
            return;
        }
        int size = taskStatusListeners.size();
        for (int i = 0; i < size; i++) {
            taskStatusListeners.get(i).onEnd(task, result);
        }
    }

    public final void addTask(@NotNull AsyncTaskWithActivity<?, ?, ?> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.mTaskList.add(task);
    }

    @NotNull
    public final ArrayList<AsyncTaskWithActivity<?, ?, ?>> getMTaskList() {
        return this.mTaskList;
    }

    @NotNull
    public final SparseArray<ArrayList<TaskStatusListener>> getMTaskListener() {
        return this.mTaskListener;
    }

    @Nullable
    public final AsyncTaskWithActivity<?, ?, ?> getRunningTask(int activityHashCode, @NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ArrayList<AsyncTaskWithActivity<?, ?, ?>> arrayList = this.mTaskList;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(arrayList.get(i).getClass(), clazz) && arrayList.get(i).getActivityHashCode() == activityHashCode) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (savedInstanceState == null) {
            return;
        }
        int i = savedInstanceState.getInt(KEY_ACTIVITY_HASHCODE, 0);
        if (i == 0) {
            return;
        }
        int size = this.mTaskList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mTaskList.get(i2).getActivityHashCode() == i) {
                this.mTaskList.get(i2).onActivityCreated(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int size = this.mTaskList.size();
        for (int i = 0; i < size; i++) {
            if (this.mTaskList.get(i).getActivityHashCode() == activity.hashCode()) {
                this.mTaskList.get(i).onActivityDestroyed();
            }
        }
        this.mTaskListener.remove(activity.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(KEY_ACTIVITY_HASHCODE, activity.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void onStart(@Nullable AsyncTaskWithActivity<?, ?, ?> task) {
        ArrayList<TaskStatusListener> taskStatusListeners = getTaskStatusListeners();
        int size = taskStatusListeners.size();
        for (int i = 0; i < size; i++) {
            taskStatusListeners.get(i).onStart(task);
        }
    }

    public final void registerTaskStatusListener(int activityHashCode, @NotNull TaskStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<TaskStatusListener> taskStatusListeners = getTaskStatusListeners(activityHashCode);
        if (taskStatusListeners == null) {
            taskStatusListeners = new ArrayList<>();
            this.mTaskListener.put(activityHashCode, taskStatusListeners);
        }
        taskStatusListeners.add(listener);
    }

    public final void removeTask(@NotNull AsyncTaskWithActivity<?, ?, ?> task, @NotNull TaskResult result) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(result, "result");
        this.mTaskList.remove(task);
        onEnd(task.getActivityHashCode(), task, result);
    }

    public final void setMTaskList(@NotNull ArrayList<AsyncTaskWithActivity<?, ?, ?>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mTaskList = arrayList;
    }

    public final void setMTaskListener(@NotNull SparseArray<ArrayList<TaskStatusListener>> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<set-?>");
        this.mTaskListener = sparseArray;
    }

    public final void unregisterTaskStatusListener(int activityHashCode, @NotNull TaskStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<TaskStatusListener> taskStatusListeners = getTaskStatusListeners(activityHashCode);
        if (taskStatusListeners == null) {
            return;
        }
        taskStatusListeners.remove(listener);
    }

    @Nullable
    public final AsyncTaskWithActivity<?, ?, ?> getRunningTask(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ArrayList<AsyncTaskWithActivity<?, ?, ?>> arrayList = this.mTaskList;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(arrayList.get(i).getClass(), clazz)) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    private final ArrayList<TaskStatusListener> getTaskStatusListeners(int activityHashCode) {
        return this.mTaskListener.get(activityHashCode);
    }
}
