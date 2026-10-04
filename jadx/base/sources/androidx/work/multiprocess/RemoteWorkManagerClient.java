package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.core.os.HandlerCompat;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.IWorkManagerImpl;
import androidx.work.multiprocess.ListenableCallback;
import androidx.work.multiprocess.parcelable.ParcelConverters;
import androidx.work.multiprocess.parcelable.ParcelableForegroundRequestInfo;
import androidx.work.multiprocess.parcelable.ParcelableUpdateRequest;
import androidx.work.multiprocess.parcelable.ParcelableWorkContinuationImpl;
import androidx.work.multiprocess.parcelable.ParcelableWorkInfos;
import androidx.work.multiprocess.parcelable.ParcelableWorkQuery;
import androidx.work.multiprocess.parcelable.ParcelableWorkRequest;
import androidx.work.multiprocess.parcelable.ParcelableWorkRequests;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanKeepAnnotation"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RemoteWorkManagerClient extends RemoteWorkManager {
    private static final long SESSION_TIMEOUT_MILLIS = 60000;
    static final String TAG = Logger.tagWithPrefix("RemoteWorkManagerClient");

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f1750a = 0;
    final Context mContext;
    final Executor mExecutor;
    private final Handler mHandler;
    final Object mLock;
    Session mSession;
    private volatile long mSessionIndex;
    private final long mSessionTimeout;
    private final SessionTracker mSessionTracker;
    final WorkManagerImpl mWorkManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class Session implements ServiceConnection {
        private static final String TAG = Logger.tagWithPrefix("RemoteWMgr.Connection");
        final RemoteWorkManagerClient mClient;
        final SettableFuture<IWorkManagerImpl> mFuture = SettableFuture.create();

        public Session(@NonNull RemoteWorkManagerClient remoteWorkManagerClient) {
            this.mClient = remoteWorkManagerClient;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(@NonNull ComponentName componentName) {
            onBindingDied();
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(@NonNull ComponentName componentName) {
            Logger.get().error(TAG, "Unable to bind to service");
            this.mFuture.setException(new RuntimeException("Cannot bind to service " + componentName));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
            Logger.get().debug(TAG, "Service connected");
            this.mFuture.set(IWorkManagerImpl.Stub.asInterface(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NonNull ComponentName componentName) {
            Logger.get().debug(TAG, "Service disconnected");
            this.mFuture.setException(new RuntimeException("Service disconnected"));
            this.mClient.cleanUp();
        }

        public void onBindingDied() {
            Logger.get().debug(TAG, "Binding died");
            this.mFuture.setException(new RuntimeException("Binding died"));
            this.mClient.cleanUp();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SessionRemoteCallback extends RemoteCallback {
        private final RemoteWorkManagerClient mClient;

        public SessionRemoteCallback(@NonNull RemoteWorkManagerClient remoteWorkManagerClient) {
            this.mClient = remoteWorkManagerClient;
        }

        @Override // androidx.work.multiprocess.RemoteCallback
        public void onRequestCompleted() {
            super.onRequestCompleted();
            this.mClient.getSessionHandler().postDelayed(this.mClient.getSessionTracker(), this.mClient.getSessionTimeout());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SessionTracker implements Runnable {
        private static final String TAG = Logger.tagWithPrefix("SessionHandler");
        private final RemoteWorkManagerClient mClient;

        public SessionTracker(@NonNull RemoteWorkManagerClient remoteWorkManagerClient) {
            this.mClient = remoteWorkManagerClient;
        }

        @Override // java.lang.Runnable
        public void run() {
            long sessionIndex = this.mClient.getSessionIndex();
            synchronized (this.mClient.getSessionLock()) {
                try {
                    long sessionIndex2 = this.mClient.getSessionIndex();
                    Session currentSession = this.mClient.getCurrentSession();
                    if (currentSession != null) {
                        if (sessionIndex == sessionIndex2) {
                            Logger.get().debug(TAG, "Unbinding service");
                            this.mClient.getContext().unbindService(currentSession);
                            currentSession.onBindingDied();
                        } else {
                            Logger.get().debug(TAG, "Ignoring request to unbind.");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public RemoteWorkManagerClient(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$enqueueUniquePeriodicWork$0(PeriodicWorkRequest periodicWorkRequest, String str, IWorkManagerImpl iWorkManagerImpl, IWorkManagerImplCallback iWorkManagerImplCallback) {
        iWorkManagerImpl.updateUniquePeriodicWorkRequest(str, ParcelConverters.marshall(new ParcelableWorkRequest(periodicWorkRequest)), iWorkManagerImplCallback);
    }

    private static Intent newIntent(@NonNull Context context) {
        return new Intent(context, (Class<?>) RemoteWorkManagerService.class);
    }

    private void unableToBind(@NonNull Session session, @NonNull Throwable th) {
        Logger.get().error(TAG, "Unable to bind to service", th);
        session.mFuture.setException(th);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public RemoteWorkContinuation beginUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list) {
        return new RemoteWorkContinuationImpl(this, this.mWorkManager.beginUniqueWork(str, existingWorkPolicy, list));
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public RemoteWorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> list) {
        return new RemoteWorkContinuationImpl(this, this.mWorkManager.beginWith(list));
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> cancelAllWork() {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.6
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.cancelAllWork(iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> cancelAllWorkByTag(@NonNull final String str) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.4
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.cancelAllWorkByTag(str, iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> cancelUniqueWork(@NonNull final String str) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.5
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.cancelUniqueWork(str, iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> cancelWorkById(@NonNull final UUID uuid) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.3
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.cancelWorkById(uuid.toString(), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    public void cleanUp() {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Cleaning up.");
            this.mSession = null;
        }
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueue(@NonNull WorkRequest workRequest) {
        return enqueue(Collections.singletonList(workRequest));
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueueUniquePeriodicWork(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull PeriodicWorkRequest periodicWorkRequest) {
        return existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE ? RemoteClientUtils.map(execute(new C0287e(periodicWorkRequest, str, 2)), RemoteClientUtils.sVoidMapper, this.mExecutor) : enqueue(this.mWorkManager.createWorkContinuationForUniquePeriodicWork(str, existingPeriodicWorkPolicy, periodicWorkRequest));
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueueUniqueWork(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<OneTimeWorkRequest> list) {
        return beginUniqueWork(str, existingWorkPolicy, list).enqueue();
    }

    @NonNull
    public ListenableFuture<byte[]> execute(@NonNull RemoteDispatcher<IWorkManagerImpl> remoteDispatcher) {
        return execute(getSession(), remoteDispatcher, new SessionRemoteCallback(this));
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public Session getCurrentSession() {
        return this.mSession;
    }

    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @NonNull
    public ListenableFuture<IWorkManagerImpl> getSession() {
        return getSession(newIntent(this.mContext));
    }

    @NonNull
    public Handler getSessionHandler() {
        return this.mHandler;
    }

    public long getSessionIndex() {
        return this.mSessionIndex;
    }

    @NonNull
    public Object getSessionLock() {
        return this.mLock;
    }

    public long getSessionTimeout() {
        return this.mSessionTimeout;
    }

    @NonNull
    public SessionTracker getSessionTracker() {
        return this.mSessionTracker;
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<List<WorkInfo>> getWorkInfos(@NonNull final WorkQuery workQuery) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.7
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.queryWorkInfo(ParcelConverters.marshall(new ParcelableWorkQuery(workQuery)), iWorkManagerImplCallback);
            }
        }), new Function<byte[], List<WorkInfo>>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.8
            @Override // androidx.arch.core.util.Function
            /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public List<WorkInfo> mo22196apply(byte[] bArr) {
                return ((ParcelableWorkInfos) ParcelConverters.unmarshall(bArr, ParcelableWorkInfos.CREATOR)).getWorkInfos();
            }
        }, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> setForegroundAsync(@NonNull final String str, @NonNull final ForegroundInfo foregroundInfo) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.10
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.setForegroundAsync(ParcelConverters.marshall(new ParcelableForegroundRequestInfo(str, foregroundInfo)), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> setProgress(@NonNull final UUID uuid, @NonNull final Data data) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.9
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.setProgress(ParcelConverters.marshall(new ParcelableUpdateRequest(uuid, data)), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    public RemoteWorkManagerClient(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, long j) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
        this.mExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        this.mLock = new Object();
        this.mSession = null;
        this.mSessionTracker = new SessionTracker(this);
        this.mSessionTimeout = j;
        this.mHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueue(@NonNull final List<WorkRequest> list) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.1
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.enqueueWorkRequests(ParcelConverters.marshall(new ParcelableWorkRequests((List<WorkRequest>) list)), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }

    @NonNull
    @VisibleForTesting
    public ListenableFuture<byte[]> execute(@NonNull final ListenableFuture<IWorkManagerImpl> listenableFuture, @NonNull final RemoteDispatcher<IWorkManagerImpl> remoteDispatcher, @NonNull final RemoteCallback remoteCallback) {
        listenableFuture.addListener(new Runnable() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final IWorkManagerImpl iWorkManagerImpl = (IWorkManagerImpl) listenableFuture.get();
                    remoteCallback.setBinder(iWorkManagerImpl.asBinder());
                    RemoteWorkManagerClient.this.mExecutor.execute(new Runnable() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RunnableC412911 runnableC412911 = RunnableC412911.this;
                                remoteDispatcher.execute(iWorkManagerImpl, remoteCallback);
                            } catch (Throwable th) {
                                Logger.get().error(RemoteWorkManagerClient.TAG, "Unable to execute", th);
                                ListenableCallback.ListenableCallbackRunnable.reportFailure(remoteCallback, th);
                            }
                        }
                    });
                } catch (InterruptedException | ExecutionException unused) {
                    Logger.get().error(RemoteWorkManagerClient.TAG, "Unable to bind to service");
                    ListenableCallback.ListenableCallbackRunnable.reportFailure(remoteCallback, new RuntimeException("Unable to bind to service"));
                    RemoteWorkManagerClient.this.cleanUp();
                }
            }
        }, this.mExecutor);
        return remoteCallback.getFuture();
    }

    @NonNull
    @VisibleForTesting
    public ListenableFuture<IWorkManagerImpl> getSession(@NonNull Intent intent) {
        SettableFuture<IWorkManagerImpl> settableFuture;
        synchronized (this.mLock) {
            try {
                this.mSessionIndex++;
                if (this.mSession == null) {
                    Logger.get().debug(TAG, "Creating a new session");
                    Session session = new Session(this);
                    this.mSession = session;
                    try {
                        if (!this.mContext.bindService(intent, session, 1)) {
                            unableToBind(this.mSession, new RuntimeException("Unable to bind to service"));
                        }
                    } catch (Throwable th) {
                        unableToBind(this.mSession, th);
                    }
                }
                this.mHandler.removeCallbacks(this.mSessionTracker);
                settableFuture = this.mSession.mFuture;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return settableFuture;
    }

    @Override // androidx.work.multiprocess.RemoteWorkManager
    @NonNull
    public ListenableFuture<Void> enqueue(@NonNull final WorkContinuation workContinuation) {
        return RemoteClientUtils.map(execute(new RemoteDispatcher<IWorkManagerImpl>() { // from class: androidx.work.multiprocess.RemoteWorkManagerClient.2
            @Override // androidx.work.multiprocess.RemoteDispatcher
            public void execute(@NonNull IWorkManagerImpl iWorkManagerImpl, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback) {
                iWorkManagerImpl.enqueueContinuation(ParcelConverters.marshall(new ParcelableWorkContinuationImpl((WorkContinuationImpl) workContinuation)), iWorkManagerImplCallback);
            }
        }), RemoteClientUtils.sVoidMapper, this.mExecutor);
    }
}
