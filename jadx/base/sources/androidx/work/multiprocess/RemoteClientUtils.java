package androidx.work.multiprocess;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class RemoteClientUtils {
    public static final Function<byte[], Void> sVoidMapper = new Function<byte[], Void>() { // from class: androidx.work.multiprocess.RemoteClientUtils.1
        @Override // androidx.arch.core.util.Function
        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Void mo22196apply(byte[] bArr) {
            return null;
        }
    };

    private RemoteClientUtils() {
    }

    @NonNull
    public static <I, O> ListenableFuture<O> map(@NonNull final ListenableFuture<I> listenableFuture, @NonNull final Function<I, O> function, @NonNull Executor executor) {
        final SettableFuture settableFutureCreate = SettableFuture.create();
        listenableFuture.addListener(new Runnable() { // from class: androidx.work.multiprocess.RemoteClientUtils.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    settableFutureCreate.set(function.mo22196apply(listenableFuture.get()));
                } catch (Throwable th) {
                    th = th;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    settableFutureCreate.setException(th);
                }
            }
        }, executor);
        return settableFutureCreate;
    }
}
