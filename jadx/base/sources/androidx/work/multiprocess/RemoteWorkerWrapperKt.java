package androidx.work.multiprocess;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p012C1.RunnableC0048d;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\f¨\u0006\r"}, m13886d2 = {"RemoteWorkerWrapper", "Landroidx/work/multiprocess/RemoteWorkerWrapper;", "context", "Landroid/content/Context;", "configuration", "Landroidx/work/Configuration;", "workerClassName", "", "workerParameters", "Landroidx/work/WorkerParameters;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "create", "work-multiprocess_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RemoteWorkerWrapperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void RemoteWorkerWrapper$lambda$1(SettableFuture settableFuture, Configuration configuration, Context context, String workerClassName, WorkerParameters workerParameters, TaskExecutor taskExecutor, RemoteWorkerWrapper wrapper) {
        Intrinsics.checkNotNullParameter(configuration, "$configuration");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(workerClassName, "$workerClassName");
        Intrinsics.checkNotNullParameter(workerParameters, "$workerParameters");
        Intrinsics.checkNotNullParameter(taskExecutor, "$taskExecutor");
        Intrinsics.checkNotNullParameter(wrapper, "$wrapper");
        try {
            if (settableFuture.isCancelled()) {
                return;
            }
            ListenableWorker listenableWorkerCreateWorkerWithDefaultFallback = configuration.getWorkerFactory().createWorkerWithDefaultFallback(context, workerClassName, workerParameters);
            if (listenableWorkerCreateWorkerWithDefaultFallback == null) {
                String str = "Unable to create an instance of " + workerClassName;
                Logger.get().error(ListenableWorkerImpl.TAG, str);
                settableFuture.setException(new IllegalStateException(str));
                return;
            }
            if (listenableWorkerCreateWorkerWithDefaultFallback instanceof RemoteListenableWorker) {
                settableFuture.addListener(new RunnableC0201c(settableFuture, 11, listenableWorkerCreateWorkerWithDefaultFallback, wrapper), taskExecutor.getSerialTaskExecutor());
                settableFuture.setFuture(((RemoteListenableWorker) listenableWorkerCreateWorkerWithDefaultFallback).startRemoteWork());
                return;
            }
            String str2 = workerClassName + " does not extend " + RemoteListenableWorker.class.getName();
            Logger.get().error(ListenableWorkerImpl.TAG, str2);
            settableFuture.setException(new IllegalStateException(str2));
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RemoteWorkerWrapper$lambda$1$lambda$0(SettableFuture settableFuture, ListenableWorker listenableWorker, RemoteWorkerWrapper wrapper) {
        Intrinsics.checkNotNullParameter(wrapper, "$wrapper");
        try {
            settableFuture.get();
        } catch (CancellationException unused) {
            ((RemoteListenableWorker) listenableWorker).stop(wrapper.getStopReason().get());
        } catch (Throwable unused2) {
        }
    }

    @JvmName(name = "create")
    @NotNull
    public static final RemoteWorkerWrapper create(@NotNull Context context, @NotNull Configuration configuration, @NotNull String workerClassName, @NotNull WorkerParameters workerParameters, @NotNull TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        SettableFuture future = SettableFuture.create();
        Intrinsics.checkNotNullExpressionValue(future, "future");
        RemoteWorkerWrapper remoteWorkerWrapper = new RemoteWorkerWrapper(future);
        taskExecutor.getMainThreadExecutor().execute(new RunnableC0048d(future, configuration, context, workerClassName, workerParameters, taskExecutor, remoteWorkerWrapper));
        return remoteWorkerWrapper;
    }
}
