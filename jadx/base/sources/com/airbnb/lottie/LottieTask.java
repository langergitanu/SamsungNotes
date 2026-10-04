package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.ExecutorC0579a;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LottieTask<T> {
    static final String DIRECT_EXECUTOR_PROPERTY_NAME = "lottie.testing.directExecutor";
    public static Executor EXECUTOR;
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;

    @Nullable
    private volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LottieFutureTask<T> extends FutureTask<LottieResult<T>> {
        private LottieTask<T> lottieTask;

        public LottieFutureTask(LottieTask<T> lottieTask, Callable<LottieResult<T>> callable) {
            super(callable);
            this.lottieTask = lottieTask;
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                if (isCancelled()) {
                    return;
                }
                try {
                    this.lottieTask.setResult(get());
                } catch (InterruptedException | ExecutionException e) {
                    this.lottieTask.setResult(new LottieResult(e));
                }
            } finally {
                this.lottieTask = null;
            }
        }
    }

    static {
        if ("true".equals(System.getProperty(DIRECT_EXECUTOR_PROPERTY_NAME))) {
            EXECUTOR = new ExecutorC0579a(2);
        } else {
            EXECUTOR = Executors.newCachedThreadPool(new LottieThreadFactory());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    private synchronized void notifyFailureListeners(Throwable th) {
        ArrayList arrayList = new ArrayList(this.failureListeners);
        if (arrayList.isEmpty()) {
            Logger.warning("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(th);
        }
    }

    private void notifyListeners() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            notifyListenersInternal();
        } else {
            this.handler.post(new RunnableC4326e(this, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenersInternal() {
        LottieResult<T> lottieResult = this.result;
        if (lottieResult == null) {
            return;
        }
        if (lottieResult.getValue() != null) {
            notifySuccessListeners(lottieResult.getValue());
        } else {
            notifyFailureListeners(lottieResult.getException());
        }
    }

    private synchronized void notifySuccessListeners(T t) {
        Iterator it = new ArrayList(this.successListeners).iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(@Nullable LottieResult<T> lottieResult) {
        if (this.result != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.result = lottieResult;
        notifyListeners();
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        try {
            LottieResult<T> lottieResult = this.result;
            if (lottieResult != null && lottieResult.getException() != null) {
                lottieListener.onResult(lottieResult.getException());
            }
            this.failureListeners.add(lottieListener);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        try {
            LottieResult<T> lottieResult = this.result;
            if (lottieResult != null && lottieResult.getValue() != null) {
                lottieListener.onResult(lottieResult.getValue());
            }
            this.successListeners.add(lottieListener);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Nullable
    public LottieResult<T> getResult() {
        return this.result;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListeners.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.successListeners.remove(lottieListener);
        return this;
    }

    public LottieTask(T t) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        setResult(new LottieResult<>(t));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new LottieResult<>(th));
                return;
            }
        }
        EXECUTOR.execute(new LottieFutureTask(this, callable));
    }
}
