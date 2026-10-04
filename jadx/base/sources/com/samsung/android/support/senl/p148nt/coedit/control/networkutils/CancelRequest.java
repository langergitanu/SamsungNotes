package com.samsung.android.support.senl.p148nt.coedit.control.networkutils;

import android.annotation.SuppressLint;
import com.microsoft.identity.common.java.WarningType;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CancelRequest {

    @SuppressLint({WarningType.NewApi})
    private CompletableFuture<Object> mCompletableFuture;
    private boolean mIsCanceled;

    public void cancel() {
        synchronized (this) {
            try {
                this.mIsCanceled = true;
                CompletableFuture<Object> completableFuture = this.mCompletableFuture;
                if (completableFuture != null) {
                    completableFuture.cancel(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object get(long j, TimeUnit timeUnit) {
        CompletableFuture<Object> completableFuture = this.mCompletableFuture;
        if (completableFuture == null || this.mIsCanceled) {
            return null;
        }
        return completableFuture.get(j, timeUnit);
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    public void setFuture(CompletableFuture<Object> completableFuture) {
        this.mCompletableFuture = completableFuture;
    }
}
