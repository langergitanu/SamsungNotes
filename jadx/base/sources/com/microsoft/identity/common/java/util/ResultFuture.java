package com.microsoft.identity.common.java.util;

import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings(justification = "get() invokes await and is a blocking call. making it synchronized will create a deadlock.", value = {"IS2_INCONSISTENT_SYNC"})
public class ResultFuture<T> implements Future<T> {
    private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private T mResult = null;
    private Throwable mException = null;
    private final List<BiConsumer<T, Throwable>> mConsumers = new ArrayList();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        this.mCountDownLatch.await();
        if (this.mException == null) {
            return this.mResult;
        }
        throw new ExecutionException(this.mException);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mCountDownLatch.getCount() == 0;
    }

    public synchronized void setException(@NonNull Throwable th) {
        if (th == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        this.mException = th;
        this.mCountDownLatch.countDown();
        Iterator<BiConsumer<T, Throwable>> it = this.mConsumers.iterator();
        while (it.hasNext()) {
            it.next().accept(this.mResult, th);
        }
    }

    public synchronized void setResult(@Nullable T t) {
        try {
            this.mResult = t;
            this.mCountDownLatch.countDown();
            Iterator<BiConsumer<T, Throwable>> it = this.mConsumers.iterator();
            while (it.hasNext()) {
                it.next().accept(t, this.mException);
            }
            this.mConsumers.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void whenComplete(@NonNull BiConsumer<T, Throwable> biConsumer) {
        if (biConsumer == null) {
            throw new NullPointerException("consumerToAdd is marked non-null but is null");
        }
        if (isDone()) {
            biConsumer.accept(this.mResult, this.mException);
        } else {
            this.mConsumers.add(biConsumer);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, @NonNull TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (timeUnit != null) {
            if (this.mCountDownLatch.await(j, timeUnit)) {
                if (this.mException == null) {
                    return this.mResult;
                }
                throw new ExecutionException(this.mException);
            }
            throw new TimeoutException("Timed out waiting for: " + j + timeUnit.name());
        }
        throw new NullPointerException("timeUnit is marked non-null but is null");
    }
}
