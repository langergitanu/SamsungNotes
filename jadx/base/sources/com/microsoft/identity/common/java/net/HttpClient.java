package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.util.StringUtil;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface HttpClient {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum HttpMethod {
        GET,
        HEAD,
        PUT,
        POST,
        OPTIONS,
        PATCH,
        DELETE,
        TRACE;

        private static final Map<String, HttpMethod> validMethods = new LinkedHashMap(values().length);

        static {
            for (HttpMethod httpMethod : values()) {
                validMethods.put(httpMethod.name(), httpMethod);
            }
        }

        public static HttpMethod validateAndNormalizeMethod(@NonNull String str) {
            if (str == null) {
                throw new NullPointerException("httpMethod is marked non-null but is null");
            }
            if (StringUtil.isNullOrEmpty(str)) {
                throw new IllegalArgumentException("HTTP method cannot be null or blank");
            }
            HttpMethod httpMethod = validMethods.get(str);
            if (httpMethod != null) {
                return httpMethod;
            }
            throw new IllegalArgumentException("Unknown or unsupported HTTP method: ".concat(str));
        }
    }

    HttpResponse delete(@NonNull URL url, @NonNull Map<String, String> map, byte[] bArr);

    HttpResponse get(@NonNull URL url, @NonNull Map<String, String> map);

    HttpResponse head(@NonNull URL url, @NonNull Map<String, String> map);

    HttpResponse method(@NonNull HttpMethod httpMethod, @NonNull URL url, @NonNull Map<String, String> map, byte[] bArr);

    HttpResponse method(@NonNull String str, @NonNull URL url, @NonNull Map<String, String> map, byte[] bArr);

    HttpResponse options(@NonNull URL url, @NonNull Map<String, String> map);

    HttpResponse patch(@NonNull URL url, @NonNull Map<String, String> map, byte[] bArr);

    HttpResponse post(@NonNull URL url, @NonNull Map<String, String> map, byte[] bArr);

    HttpResponse put(@NonNull URL url, @NonNull Map<String, String> map, byte[] bArr);

    HttpResponse trace(@NonNull URL url, @NonNull Map<String, String> map);
}
