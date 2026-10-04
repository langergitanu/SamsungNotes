package com.samsung.android.sdk.scs.base.connection;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.feature.FeatureStatusCache;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class ServiceExecutor extends ThreadPoolExecutor implements InternalServiceConnectionListener, Application.ActivityLifecycleCallbacks, AutoCloseable {
    private static final boolean CONNECTION_TIMER_ON = false;
    private static final String TAG = "ScsApi@ServiceExecutor";
    private final Condition mConnectionCondition;
    private final InternalServiceConnectionListener mConnectionListener;
    private final ReentrantLock mConnectionLock;
    private TimerTask mConnectionManagementTask;
    protected ConnectionManager mConnectionManager;
    protected final Context mContext;
    private boolean mIsConnected;
    private final AtomicInteger mTaskCount;

    public ServiceExecutor(Context context, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mConnectionLock = reentrantLock;
        this.mConnectionCondition = reentrantLock.newCondition();
        this.mIsConnected = false;
        this.mConnectionListener = new InternalServiceConnectionListener() { // from class: com.samsung.android.sdk.scs.base.connection.ServiceExecutor.1
            @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
            public void onConnected(ComponentName componentName, IBinder iBinder) {
                Log.m6485d(ServiceExecutor.TAG, "onConnected");
                ServiceExecutor.this.onConnected(componentName, iBinder);
                ServiceExecutor.this.unlockConnection(true, "connected, signal all");
            }

            @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
            public void onDisconnected(ComponentName componentName) {
                Log.m6485d(ServiceExecutor.TAG, "onDisconnected");
                ServiceExecutor.this.onDisconnected(componentName);
                ServiceExecutor.this.unlockConnection(false, "disconnected, signal all");
            }

            @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
            public void onError() {
                Log.m6485d(ServiceExecutor.TAG, "onError");
                ServiceExecutor.this.onError();
                ServiceExecutor.this.unlockConnection(false, "onError, signal all");
            }
        };
        allowCoreThreadTimeOut(true);
        Log.m6485d(TAG, "use application context");
        this.mContext = context.getApplicationContext();
        this.mTaskCount = new AtomicInteger(0);
        this.mConnectionManager = new ConnectionManager();
        Log.m6485d(TAG, "ServiceExecutor. ctor()");
    }

    private boolean connect(Context context, Intent intent, InternalServiceConnectionListener internalServiceConnectionListener) {
        Log.m6485d(TAG, "connect");
        if (this.mConnectionManager.isServiceConnected()) {
            return true;
        }
        return this.mConnectionManager.connect(context, intent, internalServiceConnectionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlockConnection(boolean z, String str) {
        this.mConnectionLock.lock();
        try {
            this.mIsConnected = z;
            Log.m6485d(TAG, str);
            this.mConnectionCondition.signalAll();
        } finally {
            this.mConnectionLock.unlock();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        this.mTaskCount.getAndDecrement();
        Log.m6485d(TAG, "afterExecute(). mTaskCount: " + this.mTaskCount);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        Log.objectInfo(TAG, "task", this, runnable);
        if (runnable instanceof TaskRunnable) {
            String featureName = ((TaskRunnable) runnable).getFeatureName();
            if (FeatureStatusCache.getStatus(featureName) == -1000) {
                Log.m6485d(TAG, "beforeExecute(). First check for " + featureName + ". status: " + Feature.checkFeature(this.mContext, featureName));
            }
        } else {
            Log.m6487e(TAG, "Unexpected runnable!!!!");
        }
        this.mConnectionLock.lock();
        try {
            try {
                if (!this.mIsConnected) {
                    Log.m6485d(TAG, "beforeExecute() : not connected, try to connect");
                    if (connect(this.mContext, getServiceIntent(), this.mConnectionListener)) {
                        Log.m6485d(TAG, "beforeExecute() : before wait");
                        if (!this.mIsConnected) {
                            this.mConnectionCondition.await();
                        }
                        Log.m6485d(TAG, "beforeExecute() : after wait");
                        if (!this.mIsConnected) {
                            thread.interrupt();
                        }
                    } else {
                        Log.m6487e(TAG, "beforeExecute() : failed to bind service");
                        thread.interrupt();
                    }
                }
            } catch (Throwable th) {
                this.mConnectionLock.unlock();
                throw th;
            }
        } catch (InterruptedException e) {
            e = e;
            e.printStackTrace();
            thread.interrupt();
        } catch (SecurityException e2) {
            e = e2;
            e.printStackTrace();
            thread.interrupt();
        }
        this.mConnectionLock.unlock();
        this.mTaskCount.getAndIncrement();
        Log.m6485d(TAG, "beforeExecute(). mTaskCount: " + this.mTaskCount);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public void deInit() {
        Log.m6485d(TAG, "deInit");
        ConnectionManager connectionManager = this.mConnectionManager;
        if (connectionManager != null) {
            connectionManager.disconnect();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void finalize() {
        super.finalize();
        Log.m6485d(TAG, "finalize");
        ConnectionManager connectionManager = this.mConnectionManager;
        if (connectionManager != null) {
            connectionManager.disconnect();
        }
    }

    public abstract Intent getServiceIntent();

    public boolean isConnected() {
        return this.mConnectionManager.isServiceConnected();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        Log.m6485d(TAG, "onActivityDestroyed");
        deInit();
    }

    public ServiceExecutor(Activity activity, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mConnectionLock = reentrantLock;
        this.mConnectionCondition = reentrantLock.newCondition();
        this.mIsConnected = false;
        this.mConnectionListener = new InternalServiceConnectionListener() { // from class: com.samsung.android.sdk.scs.base.connection.ServiceExecutor.1
            @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
            public void onConnected(ComponentName componentName, IBinder iBinder) {
                Log.m6485d(ServiceExecutor.TAG, "onConnected");
                ServiceExecutor.this.onConnected(componentName, iBinder);
                ServiceExecutor.this.unlockConnection(true, "connected, signal all");
            }

            @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
            public void onDisconnected(ComponentName componentName) {
                Log.m6485d(ServiceExecutor.TAG, "onDisconnected");
                ServiceExecutor.this.onDisconnected(componentName);
                ServiceExecutor.this.unlockConnection(false, "disconnected, signal all");
            }

            @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
            public void onError() {
                Log.m6485d(ServiceExecutor.TAG, "onError");
                ServiceExecutor.this.onError();
                ServiceExecutor.this.unlockConnection(false, "onError, signal all");
            }
        };
        allowCoreThreadTimeOut(true);
        Log.m6485d(TAG, "use activity context");
        this.mContext = activity;
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(this);
        }
        this.mTaskCount = new AtomicInteger(0);
        this.mConnectionManager = new ConnectionManager();
        Log.m6485d(TAG, "ServiceExecutor. ctor()");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
