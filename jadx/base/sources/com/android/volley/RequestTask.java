package com.android.volley;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class RequestTask<T> implements Runnable {
    final Request<T> mRequest;

    public RequestTask(Request<T> request) {
        this.mRequest = request;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public int compareTo(RequestTask<?> requestTask) {
        return this.mRequest.compareTo((Request) requestTask.mRequest);
    }
}
