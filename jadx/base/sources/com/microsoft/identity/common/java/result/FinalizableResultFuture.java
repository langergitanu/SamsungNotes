package com.microsoft.identity.common.java.result;

import com.microsoft.identity.common.java.util.ResultFuture;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FinalizableResultFuture<T> extends ResultFuture<T> {
    private final CountDownLatch mFinalized = new CountDownLatch(1);

    public boolean isCleanedUp() {
        try {
            this.mFinalized.await();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return true;
        }
    }

    public void setCleanedUp() {
        this.mFinalized.countDown();
    }
}
