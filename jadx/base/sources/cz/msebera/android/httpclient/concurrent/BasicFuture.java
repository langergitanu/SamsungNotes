package cz.msebera.android.httpclient.concurrent;

import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;

    /* JADX INFO: renamed from: ex */
    private volatile Exception f8484ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    private T getResult() throws ExecutionException {
        if (this.f8484ex != null) {
            throw new ExecutionException(this.f8484ex);
        }
        if (this.cancelled) {
            throw new CancellationException();
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.cancelled = true;
                notifyAll();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.cancelled();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean completed(T t) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.result = t;
                notifyAll();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.completed(t);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean failed(Exception exc) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.f8484ex = exc;
                notifyAll();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.failed(exc);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() {
        while (!this.completed) {
            try {
                wait();
            } catch (Throwable th) {
                throw th;
            }
        }
        return getResult();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        long jCurrentTimeMillis = millis <= 0 ? 0L : System.currentTimeMillis();
        if (this.completed) {
            return getResult();
        }
        if (millis > 0) {
            long jCurrentTimeMillis2 = millis;
            do {
                wait(jCurrentTimeMillis2);
                if (this.completed) {
                    return getResult();
                }
                jCurrentTimeMillis2 = millis - (System.currentTimeMillis() - jCurrentTimeMillis);
            } while (jCurrentTimeMillis2 > 0);
            throw new TimeoutException();
        }
        throw new TimeoutException();
    }

    @Override // cz.msebera.android.httpclient.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
