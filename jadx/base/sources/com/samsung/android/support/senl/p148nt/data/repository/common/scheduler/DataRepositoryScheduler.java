package com.samsung.android.support.senl.p148nt.data.repository.common.scheduler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import p014C3.RunnableC0054a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DataRepositoryScheduler {
    public static <T> RequestBuilder<T> callable(Callable<? extends T> callable) {
        return RequestBuilder.build(callable);
    }

    public static <T> RequestBuilder<T> runnable(Runnable runnable) {
        return RequestBuilder.build(runnable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RequestBuilder<T> implements Runnable {
        private static final String TAG = DataLogger.createTag("RequestBuilder");
        private Executor mDelegate;
        private Executor mObserverDelegate;
        private OnCompletionListener<T> mOnCompletionListener;
        private final Runnable mRunnable;
        private final Callable<? extends T> mSupplier;

        public RequestBuilder(@NonNull Callable<? extends T> callable) {
            Objects.requireNonNull(callable, "supplier is null!");
            this.mSupplier = callable;
            this.mRunnable = null;
        }

        public static <T> RequestBuilder<T> build(@NonNull Callable<? extends T> callable) {
            DataLogger.m12307i(TAG, "request, supplier : " + callable);
            return new RequestBuilder<>(callable);
        }

        private void executeCallable() {
            if (this.mSupplier == null) {
                return;
            }
            DataLogger.m12302d(TAG, "executeCallable");
            success(this.mSupplier.call());
        }

        private void executeRunnable() {
            Runnable runnable = this.mRunnable;
            if (runnable == null) {
                return;
            }
            runnable.run();
            success(null);
        }

        private void fail(@NonNull Exception exc) {
            AbstractC11014a.m12333r(exc, new StringBuilder("fail, e : "), TAG);
            Executor executor = this.mObserverDelegate;
            if (executor != null) {
                executor.execute(new RunnableC0054a(this, exc, 9));
            } else {
                lambda$fail$1(exc);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: notifyFailListener, reason: merged with bridge method [inline-methods] */
        public void lambda$fail$1(@NonNull Exception exc) {
            OnCompletionListener<T> onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null) {
                onCompletionListener.onFail(exc);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: notifySuccessListener, reason: merged with bridge method [inline-methods] */
        public void lambda$success$0(@Nullable T t) {
            OnCompletionListener<T> onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null) {
                onCompletionListener.onComplete(t);
            }
        }

        private void setDefaultExecutor() {
            if (this.mDelegate == null) {
                executeOn(NotesDataTaskExecutor.getIOThreadExecutor());
            }
        }

        private void success(@Nullable T t) {
            DataLogger.m12302d(TAG, "success");
            Executor executor = this.mObserverDelegate;
            if (executor != null) {
                executor.execute(new RunnableC0054a(this, t, 8));
            } else {
                lambda$success$0(t);
            }
        }

        public void execute() {
            setDefaultExecutor();
            this.mDelegate.execute(this);
        }

        public RequestBuilder<T> executeOn(Executor executor) {
            this.mDelegate = executor;
            return this;
        }

        public RequestBuilder<T> observe(OnCompletionListener<T> onCompletionListener) {
            DataLogger.m12307i(TAG, "observe, listener : " + onCompletionListener);
            this.mOnCompletionListener = onCompletionListener;
            return this;
        }

        public RequestBuilder<T> observeOn(Executor executor) {
            DataLogger.m12307i(TAG, "observeOn, executor : " + executor);
            this.mObserverDelegate = executor;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            DataLogger.m12302d(TAG, "run - start");
            try {
                executeRunnable();
                executeCallable();
            } catch (Exception e) {
                fail(e);
            }
            DataLogger.m12302d(TAG, "run - end");
        }

        public static <T> RequestBuilder<T> build(@NonNull Runnable runnable) {
            DataLogger.m12307i(TAG, "request, runnable : " + runnable);
            return new RequestBuilder<>(runnable);
        }

        public RequestBuilder(@NonNull Runnable runnable) {
            Objects.requireNonNull(runnable, "runnable is null!");
            this.mSupplier = null;
            this.mRunnable = runnable;
        }
    }
}
