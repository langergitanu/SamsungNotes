package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Worker extends ListenableWorker {
    SettableFuture<ListenableWorker.Result> mFuture;

    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    @WorkerThread
    public abstract ListenableWorker.Result doWork();

    @NonNull
    @WorkerThread
    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        final SettableFuture settableFutureCreate = SettableFuture.create();
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.Worker.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    settableFutureCreate.set(Worker.this.getForegroundInfo());
                } catch (Throwable th) {
                    settableFutureCreate.setException(th);
                }
            }
        });
        return settableFutureCreate;
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.mFuture = SettableFuture.create();
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.Worker.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Worker.this.mFuture.set(Worker.this.doWork());
                } catch (Throwable th) {
                    Worker.this.mFuture.setException(th);
                }
            }
        });
        return this.mFuture;
    }
}
