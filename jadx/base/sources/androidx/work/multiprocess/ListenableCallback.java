package androidx.work.multiprocess;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ListenableCallback<I> {
    final IWorkManagerImplCallback mCallback;
    final Executor mExecutor;
    final ListenableFuture<I> mFuture;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class ListenableCallbackRunnable<I> implements Runnable {
        private static final String TAG = Logger.tagWithPrefix("ListenableCallbackRbl");
        private final ListenableCallback<I> mCallback;

        public ListenableCallbackRunnable(@NonNull ListenableCallback<I> listenableCallback) {
            this.mCallback = listenableCallback;
        }

        public static void reportFailure(@NonNull IWorkManagerImplCallback iWorkManagerImplCallback, @NonNull Throwable th) {
            try {
                iWorkManagerImplCallback.onFailure(th.getMessage());
            } catch (RemoteException e) {
                Logger.get().error(TAG, "Unable to notify failures in operation", e);
            }
        }

        public static void reportSuccess(@NonNull IWorkManagerImplCallback iWorkManagerImplCallback, @NonNull byte[] bArr) {
            try {
                iWorkManagerImplCallback.onSuccess(bArr);
            } catch (RemoteException e) {
                Logger.get().error(TAG, "Unable to notify successful operation", e);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                I i = this.mCallback.mFuture.get();
                ListenableCallback<I> listenableCallback = this.mCallback;
                reportSuccess(listenableCallback.mCallback, listenableCallback.toByteArray(i));
            } catch (Throwable th) {
                reportFailure(this.mCallback.mCallback, th);
            }
        }
    }

    public ListenableCallback(@NonNull Executor executor, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback, @NonNull ListenableFuture<I> listenableFuture) {
        this.mExecutor = executor;
        this.mCallback = iWorkManagerImplCallback;
        this.mFuture = listenableFuture;
    }

    public void dispatchCallbackSafely() {
        this.mFuture.addListener(new ListenableCallbackRunnable(this), this.mExecutor);
    }

    @NonNull
    public abstract byte[] toByteArray(@NonNull I i);
}
