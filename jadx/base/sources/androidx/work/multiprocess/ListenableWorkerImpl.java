package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.multiprocess.IListenableWorkerImpl;
import androidx.work.multiprocess.ListenableCallback;
import androidx.work.multiprocess.parcelable.ParcelConverters;
import androidx.work.multiprocess.parcelable.ParcelableInterruptRequest;
import androidx.work.multiprocess.parcelable.ParcelableRemoteWorkRequest;
import androidx.work.multiprocess.parcelable.ParcelableResult;
import com.google.common.util.concurrent.ListenableFuture;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import p027F3.RunnableC0101a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ListenableWorkerImpl extends IListenableWorkerImpl.Stub {
    static final String TAG = Logger.tagWithPrefix("WM-RemoteWorker ListenableWorkerImpl");
    static byte[] sEMPTY = new byte[0];
    static final Object sLock = new Object();
    final Configuration mConfiguration;
    final Context mContext;
    final ForegroundUpdater mForegroundUpdater;
    final ProgressUpdater mProgressUpdater;
    final Map<String, RemoteWorkerWrapper> mRemoteWorkerWrapperMap;
    final TaskExecutor mTaskExecutor;

    public ListenableWorkerImpl(@NonNull Context context) {
        this.mContext = context.getApplicationContext();
        RemoteWorkManagerInfo remoteWorkManagerInfo = RemoteWorkManagerInfo.getInstance(context);
        this.mConfiguration = remoteWorkManagerInfo.getConfiguration();
        this.mTaskExecutor = remoteWorkManagerInfo.getTaskExecutor();
        this.mProgressUpdater = remoteWorkManagerInfo.getProgressUpdater();
        this.mForegroundUpdater = remoteWorkManagerInfo.getForegroundUpdater();
        this.mRemoteWorkerWrapperMap = new HashMap();
    }

    @NonNull
    private ListenableFuture<ListenableWorker.Result> executeWorkRequest(@NonNull String str, @NonNull String str2, @NonNull WorkerParameters workerParameters) {
        RemoteWorkerWrapper remoteWorkerWrapperCreate = RemoteWorkerWrapperKt.create(this.mContext, this.mConfiguration, str2, workerParameters, this.mTaskExecutor);
        synchronized (sLock) {
            this.mRemoteWorkerWrapperMap.put(str, remoteWorkerWrapperCreate);
        }
        return remoteWorkerWrapperCreate.getFuture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$interrupt$0(RemoteWorkerWrapper remoteWorkerWrapper, int i, IWorkManagerImplCallback iWorkManagerImplCallback) {
        remoteWorkerWrapper.interrupt(i);
        ListenableCallback.ListenableCallbackRunnable.reportSuccess(iWorkManagerImplCallback, sEMPTY);
    }

    @Override // androidx.work.multiprocess.IListenableWorkerImpl
    public void interrupt(@NonNull byte[] bArr, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
        RemoteWorkerWrapper remoteWorkerWrapperRemove;
        try {
            ParcelableInterruptRequest parcelableInterruptRequest = (ParcelableInterruptRequest) ParcelConverters.unmarshall(bArr, ParcelableInterruptRequest.CREATOR);
            String id = parcelableInterruptRequest.getId();
            int stopReason = parcelableInterruptRequest.getStopReason();
            Logger.get().debug(TAG, "Interrupting work with id (" + id + ")");
            synchronized (sLock) {
                remoteWorkerWrapperRemove = this.mRemoteWorkerWrapperMap.remove(id);
            }
            if (remoteWorkerWrapperRemove != null) {
                this.mTaskExecutor.getSerialTaskExecutor().execute(new RunnableC0101a(remoteWorkerWrapperRemove, stopReason, iWorkManagerImplCallback, 3));
            } else {
                ListenableCallback.ListenableCallbackRunnable.reportSuccess(iWorkManagerImplCallback, sEMPTY);
            }
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }

    @Override // androidx.work.multiprocess.IListenableWorkerImpl
    public void startWork(@NonNull byte[] bArr, @NonNull final IWorkManagerImplCallback iWorkManagerImplCallback) {
        try {
            ParcelableRemoteWorkRequest parcelableRemoteWorkRequest = (ParcelableRemoteWorkRequest) ParcelConverters.unmarshall(bArr, ParcelableRemoteWorkRequest.CREATOR);
            WorkerParameters workerParameters = parcelableRemoteWorkRequest.getParcelableWorkerParameters().toWorkerParameters(this.mConfiguration, this.mTaskExecutor, this.mProgressUpdater, this.mForegroundUpdater);
            final String string = workerParameters.getId().toString();
            String workerClassName = parcelableRemoteWorkRequest.getWorkerClassName();
            Logger.get().debug(TAG, "Executing work request (" + string + SQLKeyword.COMMA + workerClassName + ")");
            final ListenableFuture<ListenableWorker.Result> listenableFutureExecuteWorkRequest = executeWorkRequest(string, workerClassName, workerParameters);
            listenableFutureExecuteWorkRequest.addListener(new Runnable() { // from class: androidx.work.multiprocess.ListenableWorkerImpl.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:48:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    try {
                        try {
                            ListenableCallback.ListenableCallbackRunnable.reportSuccess(iWorkManagerImplCallback, ParcelConverters.marshall(new ParcelableResult((ListenableWorker.Result) listenableFutureExecuteWorkRequest.get())));
                            synchronized (ListenableWorkerImpl.sLock) {
                                ListenableWorkerImpl.this.mRemoteWorkerWrapperMap.remove(string);
                            }
                        } catch (InterruptedException e) {
                            e = e;
                            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, e);
                            synchronized (ListenableWorkerImpl.sLock) {
                                ListenableWorkerImpl.this.mRemoteWorkerWrapperMap.remove(string);
                            }
                        } catch (CancellationException e2) {
                            Logger.get().debug(ListenableWorkerImpl.TAG, "Worker (" + string + ") was cancelled");
                            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, e2);
                            synchronized (ListenableWorkerImpl.sLock) {
                                ListenableWorkerImpl.this.mRemoteWorkerWrapperMap.remove(string);
                            }
                        } catch (ExecutionException e3) {
                            e = e3;
                            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, e);
                            synchronized (ListenableWorkerImpl.sLock) {
                            }
                        }
                    } catch (Throwable th) {
                        synchronized (ListenableWorkerImpl.sLock) {
                            ListenableWorkerImpl.this.mRemoteWorkerWrapperMap.remove(string);
                            throw th;
                        }
                    }
                }
            }, this.mTaskExecutor.getSerialTaskExecutor());
        } catch (Throwable th) {
            ListenableCallback.ListenableCallbackRunnable.reportFailure(iWorkManagerImplCallback, th);
        }
    }
}
