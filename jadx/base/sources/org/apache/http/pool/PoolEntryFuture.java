package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@ThreadSafe
abstract class PoolEntryFuture<T> implements Future<T> {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private final Condition condition;
    private final Lock lock;
    private T result;

    public PoolEntryFuture(Lock lock, FutureCallback<T> futureCallback) {
        this.lock = lock;
        this.condition = lock.newCondition();
        this.callback = futureCallback;
    }

    public boolean await(Date date) {
        boolean zAwaitUntil;
        this.lock.lock();
        try {
            if (this.cancelled) {
                throw new InterruptedException("Operation interrupted");
            }
            if (date != null) {
                zAwaitUntil = this.condition.awaitUntil(date);
            } else {
                this.condition.await();
                zAwaitUntil = true;
            }
            if (this.cancelled) {
                throw new InterruptedException("Operation interrupted");
            }
            this.lock.unlock();
            return zAwaitUntil;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.lock.lock();
        try {
            if (this.completed) {
                this.lock.unlock();
                return false;
            }
            this.completed = true;
            this.cancelled = true;
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.cancelled();
            }
            this.condition.signalAll();
            this.lock.unlock();
            return true;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException {
        try {
            return get(0L, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            throw new ExecutionException(e);
        }
    }

    public abstract T getPoolEntry(long j, TimeUnit timeUnit);

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    public void wakeup() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        T t;
        Args.notNull(timeUnit, "Time unit");
        this.lock.lock();
        try {
            try {
                if (this.completed) {
                    t = this.result;
                } else {
                    this.result = getPoolEntry(j, timeUnit);
                    this.completed = true;
                    FutureCallback<T> futureCallback = this.callback;
                    if (futureCallback != null) {
                        futureCallback.completed(this.result);
                    }
                    t = this.result;
                }
                return t;
            } catch (IOException e) {
                this.completed = true;
                this.result = null;
                FutureCallback<T> futureCallback2 = this.callback;
                if (futureCallback2 != null) {
                    futureCallback2.failed(e);
                }
                throw new ExecutionException(e);
            }
        } finally {
            this.lock.unlock();
        }
    }
}
