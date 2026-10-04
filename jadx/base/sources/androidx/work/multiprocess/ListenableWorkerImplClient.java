package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.IListenableWorkerImpl;
import androidx.work.multiprocess.ListenableCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ListenableWorkerImplClient {
    static final String TAG = Logger.tagWithPrefix("ListenableWorkerImplClient");
    private Connection mConnection;
    final Context mContext;
    final Executor mExecutor;
    private final Object mLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class Connection implements ServiceConnection {
        private static final String TAG = Logger.tagWithPrefix("ListenableWorkerImplSession");
        final SettableFuture<IListenableWorkerImpl> mFuture = SettableFuture.create();

        @Override // android.content.ServiceConnection
        public void onBindingDied(@NonNull ComponentName componentName) {
            Logger.get().warning(TAG, "Binding died");
            this.mFuture.setException(new RuntimeException("Binding died"));
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(@NonNull ComponentName componentName) {
            Logger.get().error(TAG, "Unable to bind to service");
            this.mFuture.setException(new RuntimeException("Cannot bind to service " + componentName));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
            Logger.get().debug(TAG, "Service connected");
            this.mFuture.set(IListenableWorkerImpl.Stub.asInterface(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NonNull ComponentName componentName) {
            Logger.get().warning(TAG, "Service disconnected");
            this.mFuture.setException(new RuntimeException("Service disconnected"));
        }
    }

    public ListenableWorkerImplClient(@NonNull Context context, @NonNull Executor executor) {
        this.mContext = context;
        this.mExecutor = executor;
    }

    private static void unableToBind(@NonNull Connection connection, @NonNull Throwable th) {
        Logger.get().error(TAG, "Unable to bind to service", th);
        connection.mFuture.setException(th);
    }

    @NonNull
    public ListenableFuture<byte[]> execute(@NonNull ComponentName componentName, @NonNull RemoteDispatcher<IListenableWorkerImpl> remoteDispatcher) {
        return execute(getListenableWorkerImpl(componentName), remoteDispatcher, new RemoteCallback());
    }

    @Nullable
    @VisibleForTesting
    public Connection getConnection() {
        return this.mConnection;
    }

    @NonNull
    public ListenableFuture<IListenableWorkerImpl> getListenableWorkerImpl(@NonNull ComponentName componentName) {
        SettableFuture<IListenableWorkerImpl> settableFuture;
        synchronized (this.mLock) {
            try {
                if (this.mConnection == null) {
                    Logger.get().debug(TAG, "Binding to " + componentName.getPackageName() + SQLKeyword.COMMA + componentName.getClassName());
                    this.mConnection = new Connection();
                    try {
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        if (!this.mContext.bindService(intent, this.mConnection, 1)) {
                            unableToBind(this.mConnection, new RuntimeException("Unable to bind to service"));
                        }
                    } catch (Throwable th) {
                        unableToBind(this.mConnection, th);
                    }
                }
                settableFuture = this.mConnection.mFuture;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return settableFuture;
    }

    public void unbindService() {
        synchronized (this.mLock) {
            try {
                Connection connection = this.mConnection;
                if (connection != null) {
                    this.mContext.unbindService(connection);
                    this.mConnection = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @SuppressLint({"LambdaLast"})
    public ListenableFuture<byte[]> execute(@NonNull final ListenableFuture<IListenableWorkerImpl> listenableFuture, @NonNull final RemoteDispatcher<IListenableWorkerImpl> remoteDispatcher, @NonNull final RemoteCallback remoteCallback) {
        listenableFuture.addListener(new Runnable() { // from class: androidx.work.multiprocess.ListenableWorkerImplClient.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final IListenableWorkerImpl iListenableWorkerImpl = (IListenableWorkerImpl) listenableFuture.get();
                    remoteCallback.setBinder(iListenableWorkerImpl.asBinder());
                    ListenableWorkerImplClient.this.mExecutor.execute(new Runnable() { // from class: androidx.work.multiprocess.ListenableWorkerImplClient.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RunnableC41201 runnableC41201 = RunnableC41201.this;
                                remoteDispatcher.execute(iListenableWorkerImpl, remoteCallback);
                            } catch (Throwable th) {
                                Logger.get().error(ListenableWorkerImplClient.TAG, "Unable to execute", th);
                                ListenableCallback.ListenableCallbackRunnable.reportFailure(remoteCallback, th);
                            }
                        }
                    });
                } catch (InterruptedException | ExecutionException e) {
                    Logger.get().error(ListenableWorkerImplClient.TAG, "Unable to bind to service", e);
                    ListenableCallback.ListenableCallbackRunnable.reportFailure(remoteCallback, e);
                }
            }
        }, this.mExecutor);
        return remoteCallback.getFuture();
    }
}
