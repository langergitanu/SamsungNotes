package io.grpc.okhttp.internal.proxy;

import io.grpc.okhttp.internal.Headers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Request {
    private final Headers headers;
    private final HttpUrl url;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private Headers.Builder headers = new Headers.Builder();
        private HttpUrl url;

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.url = httpUrl;
            return this;
        }
    }

    public Headers headers() {
        return this.headers;
    }

    public HttpUrl httpUrl() {
        return this.url;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public String toString() {
        return "Request{url=" + this.url + '}';
    }

    private Request(Builder builder) {
        this.url = builder.url;
        this.headers = builder.headers.build();
    }
}
