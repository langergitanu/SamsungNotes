package org.apache.http.impl.client;

import java.util.concurrent.FutureTask;
import org.apache.http.client.methods.HttpUriRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HttpRequestFutureTask<V> extends FutureTask<V> {
    private final HttpRequestTaskCallable<V> callable;
    private final HttpUriRequest request;

    public HttpRequestFutureTask(HttpUriRequest httpUriRequest, HttpRequestTaskCallable<V> httpRequestTaskCallable) {
        super(httpRequestTaskCallable);
        this.request = httpUriRequest;
        this.callable = httpRequestTaskCallable;
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.callable.cancel();
        if (z) {
            this.request.abort();
        }
        return super.cancel(z);
    }

    public long endedTime() {
        if (isDone()) {
            return this.callable.getEnded();
        }
        throw new IllegalStateException("Task is not done yet");
    }

    public long requestDuration() {
        if (isDone()) {
            return endedTime() - startedTime();
        }
        throw new IllegalStateException("Task is not done yet");
    }

    public long scheduledTime() {
        return this.callable.getScheduled();
    }

    public long startedTime() {
        return this.callable.getStarted();
    }

    public long taskDuration() {
        if (isDone()) {
            return endedTime() - scheduledTime();
        }
        throw new IllegalStateException("Task is not done yet");
    }

    @Override // java.util.concurrent.FutureTask
    public String toString() {
        return this.request.getRequestLine().getUri();
    }
}
