package com.samsung.scsp.error;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Response<T> extends Result {
    public final T obj;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Holder<T> {
        public Response<T> response = new Response<>(null);
    }

    public Response(T t) {
        this.obj = t;
    }

    public Response(T t, Result result) {
        super(result.rcode, result.rmsg);
        this.obj = t;
    }
}
