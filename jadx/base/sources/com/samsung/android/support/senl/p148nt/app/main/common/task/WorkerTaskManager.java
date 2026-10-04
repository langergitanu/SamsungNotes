package com.samsung.android.support.senl.p148nt.app.main.common.task;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0006J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0007J\u001e\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006J\u0014\u0010\u0019\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\bH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00050\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTaskManager;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Callback;", "<init>", "()V", "tasks", "", "", "", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "taskListeners", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTaskManager$Listener;", "addTask", "", "task", "removeTask", "taskResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "cancelRunningTask", "tag", "hashCode", "getRunningTask", "registerListener", "key", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterListener", "onStart", "onEnd", "result", "Listener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWorkerTaskManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerTaskManager.kt\ncom/samsung/android/support/senl/nt/app/main/common/task/WorkerTaskManager\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,91:1\n384#2,7:92\n216#3,2:99\n*S KotlinDebug\n*F\n+ 1 WorkerTaskManager.kt\ncom/samsung/android/support/senl/nt/app/main/common/task/WorkerTaskManager\n*L\n15#1:92,7\n38#1:99,2\n*E\n"})
public final class WorkerTaskManager implements WorkerTask.Callback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "WorkerTaskManager";

    @Nullable
    private static WorkerTaskManager sInstance;

    @NotNull
    private Map<Integer, Map<String, WorkerTask<?>>> tasks = new HashMap();

    @NotNull
    private Map<Integer, Listener> taskListeners = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTaskManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTaskManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTaskManager;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized WorkerTaskManager getInstance() {
            WorkerTaskManager workerTaskManager;
            try {
                if (WorkerTaskManager.sInstance == null) {
                    WorkerTaskManager.sInstance = new WorkerTaskManager();
                }
                workerTaskManager = WorkerTaskManager.sInstance;
                Intrinsics.checkNotNull(workerTaskManager);
            } catch (Throwable th) {
                throw th;
            }
            return workerTaskManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTaskManager$Listener;", "", "onStart", "", "task", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "onEnd", "result", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Listener {
        void onEnd(@NotNull WorkerTask.Result result);

        void onStart(@NotNull WorkerTask<?> task);
    }

    public static /* synthetic */ void cancelRunningTask$default(WorkerTaskManager workerTaskManager, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        workerTaskManager.cancelRunningTask(str, i);
    }

    @NotNull
    public static final synchronized WorkerTaskManager getInstance() {
        return INSTANCE.getInstance();
    }

    public static /* synthetic */ WorkerTask getRunningTask$default(WorkerTaskManager workerTaskManager, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return workerTaskManager.getRunningTask(str, i);
    }

    public final void addTask(@NotNull WorkerTask<?> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String tag = task.getTag();
        int hashCode = task.getHashCode();
        MainLogger.m7254d(TAG, "addTask, " + tag + SQLKeyword.COMMA + hashCode);
        task.setCallback(this);
        Map<Integer, Map<String, WorkerTask<?>>> map = this.tasks;
        Integer numValueOf = Integer.valueOf(hashCode);
        Map<String, WorkerTask<?>> linkedHashMap = map.get(numValueOf);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            map.put(numValueOf, linkedHashMap);
        }
        linkedHashMap.put(tag, task);
    }

    public final void cancelRunningTask(@NotNull String tag, int hashCode) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        WorkerTask<?> runningTask = getRunningTask(tag, hashCode);
        if (runningTask != null) {
            runningTask.cancel();
        }
    }

    @Nullable
    public final WorkerTask<?> getRunningTask(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return getRunningTask(tag, -1);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
    public void onEnd(@NotNull WorkerTask.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        removeTask(result);
        Iterator<Listener> it = this.taskListeners.values().iterator();
        while (it.hasNext()) {
            it.next().onEnd(result);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
    public void onStart(@NotNull WorkerTask<?> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Iterator<Listener> it = this.taskListeners.values().iterator();
        while (it.hasNext()) {
            it.next().onStart(task);
        }
    }

    public final void registerListener(int key, @NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.taskListeners.put(Integer.valueOf(key), listener);
    }

    public final void removeTask(@NotNull WorkerTask.Result taskResult) {
        Intrinsics.checkNotNullParameter(taskResult, "taskResult");
        String tag = taskResult.getTag();
        int hashCode = taskResult.getHashCode();
        MainLogger.m7254d(TAG, "removeTask, " + tag + SQLKeyword.COMMA + hashCode);
        Map<String, WorkerTask<?>> map = this.tasks.get(Integer.valueOf(hashCode));
        WorkerTask<?> workerTaskRemove = map != null ? map.remove(tag) : null;
        if (workerTaskRemove != null) {
            workerTaskRemove.setCallback(null);
        }
    }

    public final void unregisterListener(int key) {
        this.taskListeners.remove(Integer.valueOf(key));
    }

    @Nullable
    public final WorkerTask<?> getRunningTask(@NotNull String tag, int hashCode) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (hashCode != -1) {
            Map<String, WorkerTask<?>> map = this.tasks.get(Integer.valueOf(hashCode));
            if (map != null) {
                return map.get(tag);
            }
            return null;
        }
        Iterator<Map.Entry<Integer, Map<String, WorkerTask<?>>>> it = this.tasks.entrySet().iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, WorkerTask<?>> entry : it.next().getValue().entrySet()) {
                if (Intrinsics.areEqual(entry.getValue().getTag(), tag)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }
}
