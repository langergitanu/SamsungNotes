package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.IWorkManagerImplCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RemoteCallback extends IWorkManagerImplCallback.Stub {
    private IBinder mBinder = null;
    private final SettableFuture<byte[]> mFuture = SettableFuture.create();
    private final IBinder.DeathRecipient mRecipient = new DeathRecipient(this);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeathRecipient implements IBinder.DeathRecipient {
        private final RemoteCallback mCallback;

        public DeathRecipient(@NonNull RemoteCallback remoteCallback) {
            this.mCallback = remoteCallback;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mCallback.onFailure("Binder died");
        }
    }

    private void unlinkToDeath() {
        IBinder iBinder = this.mBinder;
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this.mRecipient, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @NonNull
    public ListenableFuture<byte[]> getFuture() {
        return this.mFuture;
    }

    @Override // androidx.work.multiprocess.IWorkManagerImplCallback
    public void onFailure(@NonNull String str) {
        onFailure(new RuntimeException(str));
    }

    @Override // androidx.work.multiprocess.IWorkManagerImplCallback
    public void onSuccess(@NonNull byte[] bArr) {
        this.mFuture.set(bArr);
        unlinkToDeath();
        onRequestCompleted();
    }

    public void setBinder(@NonNull IBinder iBinder) {
        this.mBinder = iBinder;
        try {
            iBinder.linkToDeath(this.mRecipient, 0);
        } catch (RemoteException e) {
            onFailure(e);
        }
    }

    private void onFailure(@NonNull Throwable th) {
        this.mFuture.setException(th);
        unlinkToDeath();
        onRequestCompleted();
    }

    public void onRequestCompleted() {
    }
}
