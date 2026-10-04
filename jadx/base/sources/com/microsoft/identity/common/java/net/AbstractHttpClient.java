package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.net.HttpClient;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.net.URL;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractHttpClient implements HttpClient {
    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse delete(@NonNull URL url, @NonNull Map<String, String> map, @Nullable byte[] bArr) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.DELETE, url, map, bArr);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse get(@NonNull URL url, @NonNull Map<String, String> map) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.GET, url, map, (byte[]) null);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse head(@NonNull URL url, @NonNull Map<String, String> map) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.HEAD, url, map, (byte[]) null);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public abstract HttpResponse method(@NonNull HttpClient.HttpMethod httpMethod, @NonNull URL url, @NonNull Map<String, String> map, @Nullable byte[] bArr);

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse method(@NonNull String str, @NonNull URL url, @NonNull Map<String, String> map, @Nullable byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("httpMethod is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.validateAndNormalizeMethod(str), url, map, bArr);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse options(@NonNull URL url, @NonNull Map<String, String> map) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.OPTIONS, url, map, (byte[]) null);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse patch(@NonNull URL url, @NonNull Map<String, String> map, @Nullable byte[] bArr) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.PATCH, url, map, bArr);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse post(@NonNull URL url, @NonNull Map<String, String> map, @Nullable byte[] bArr) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.POST, url, map, bArr);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse put(@NonNull URL url, @NonNull Map<String, String> map, @Nullable byte[] bArr) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.PUT, url, map, bArr);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse trace(@NonNull URL url, @NonNull Map<String, String> map) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map != null) {
            return method(HttpClient.HttpMethod.TRACE, url, map, (byte[]) null);
        }
        throw new NullPointerException("requestHeaders is marked non-null but is null");
    }
}
