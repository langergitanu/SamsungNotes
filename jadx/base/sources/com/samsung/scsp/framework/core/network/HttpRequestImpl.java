package com.samsung.scsp.framework.core.network;

import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.api.SCHashMap;
import com.samsung.scsp.framework.core.listeners.NetworkStatusListener;
import com.samsung.scsp.framework.core.listeners.ProgressListener;
import com.samsung.scsp.framework.core.listeners.ResponseListener;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.visitor.FileInputStreamPayloadWriter;
import com.samsung.scsp.framework.core.network.visitor.FilePayloadWriter;
import com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor;
import com.samsung.scsp.framework.core.network.visitor.StringPayloadWriter;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class HttpRequestImpl extends AbstractHttpRequest {
    private final Object content;
    private final String contentType;
    private long length;
    private PayloadWriterVisitor.PayloadWriter payloadWriter;
    private long range;

    public /* synthetic */ HttpRequestImpl(HttpRequestBuilder httpRequestBuilder, int i) {
        this(httpRequestBuilder);
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public Object getContent(int i) {
        return this.content;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public String getContentType(int i) {
        return this.contentType;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public long getLength() {
        return this.length;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public int getPartCount() {
        return 1;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public PayloadWriterVisitor.PayloadWriter getPayloadWriter(int i) {
        return this.payloadWriter;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public long getRange() {
        return this.range;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public boolean getSupportChunkedStreaming() {
        return this.supportChunkedStreaming;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public boolean isAccountRequiredFeature() {
        return this.isAccountRequiredFeature;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public boolean isMultipart() {
        return false;
    }

    private HttpRequestImpl(HttpRequestBuilder httpRequestBuilder) {
        this.range = 0L;
        this.length = 0L;
        this.payloadWriter = null;
        this.url = httpRequestBuilder.url;
        this.timeout = httpRequestBuilder.timeout;
        this.isAccountRequiredFeature = httpRequestBuilder.isAccountRequiredFeature;
        this.contentType = httpRequestBuilder.contentType;
        this.content = httpRequestBuilder.content;
        this.payloadWriter = httpRequestBuilder.payloadWriter;
        Set<String> setKeySet = httpRequestBuilder.headerMap.keySet();
        this.headerKeyList.clear();
        this.headerValueList.clear();
        for (String str : setKeySet) {
            this.headerKeyList.add(str);
            this.headerValueList.add((String) httpRequestBuilder.headerMap.get(str));
        }
        this.method = httpRequestBuilder.method;
        this.range = httpRequestBuilder.range;
        this.length = httpRequestBuilder.length;
        this.responseListener = httpRequestBuilder.responseListener;
        this.progressListener = httpRequestBuilder.progressListener;
        this.networkStatusListener = httpRequestBuilder.networkStatusListener;
        this.name = httpRequestBuilder.name;
        this.supportChunkedStreaming = httpRequestBuilder.supportChunkedStreaming;
        this.silent = httpRequestBuilder.silent;
        this.parameters = httpRequestBuilder.parameters;
        this.anonymizationWords = httpRequestBuilder.anonymizationWords;
        httpRequestBuilder.headerMap.clear();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HttpRequestBuilder {
        private String[] anonymizationWords;
        private Object content;
        private String contentType;
        private final Map<String, String> headerMap;
        private final boolean isAccountRequiredFeature;
        private HttpRequest.Method method;
        private String name;
        private NetworkStatusListener networkStatusListener;
        private SCHashMap parameters;
        private ProgressListener progressListener;
        private ResponseListener responseListener;
        private int timeout;
        private final String url;
        private long range = 0;
        private long length = 0;
        private PayloadWriterVisitor.PayloadWriter payloadWriter = null;
        private boolean supportChunkedStreaming = true;
        private boolean silent = false;

        public HttpRequestBuilder(SContextHolder sContextHolder, HttpRequest.Method method, String str) {
            HashMap map = new HashMap();
            this.headerMap = map;
            this.url = str;
            this.timeout = sContextHolder.requestTimeOut;
            this.isAccountRequiredFeature = sContextHolder.isAccountRequiredFeature;
            this.method = method;
            map.putAll(HeaderSetup.commonHeader(sContextHolder));
            putNetworkHeader(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$putNetworkHeader$0(String str) {
            if (new URL(str).getHost().contains("samsungcloud")) {
                this.headerMap.putAll(HeaderSetup.networkHeader());
            }
        }

        private void putNetworkHeader(String str) {
            FaultBarrier.run(new C11669a(2, this, str));
        }

        public HttpRequestBuilder addHeader(String str, String str2) {
            this.headerMap.put(str, str2);
            return this;
        }

        public HttpRequestBuilder addHeaderMap(Map<String, String> map) {
            this.headerMap.putAll(map);
            return this;
        }

        public HttpRequestBuilder addLength(long j) {
            addHeader("Content-Length", String.valueOf(j));
            this.length = j;
            return this;
        }

        public HttpRequestBuilder addRange(long j) {
            addHeader("Range", "bytes=0-");
            if (j > 0) {
                j++;
                addHeader("Range", AbstractC1974b.m1317j(j, "bytes=", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR));
            }
            this.range = j;
            return this;
        }

        public HttpRequestBuilder anonymizeLogging(String... strArr) {
            this.anonymizationWords = strArr;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequestImpl(this, 0);
        }

        public HttpRequestBuilder clearHeader() {
            this.headerMap.clear();
            return this;
        }

        public HttpRequestBuilder clearUserInfoFromHeader() {
            removeHeader("Authorization");
            return this;
        }

        public HttpRequestBuilder name(String str) {
            this.name = str;
            return this;
        }

        public HttpRequestBuilder networkStatusListener(NetworkStatusListener networkStatusListener) {
            this.networkStatusListener = networkStatusListener;
            return this;
        }

        public HttpRequestBuilder parameters(SCHashMap sCHashMap) {
            this.parameters = sCHashMap;
            return this;
        }

        public HttpRequestBuilder payload(String str, String str2) {
            addHeader("Content-Type", str);
            this.contentType = str;
            this.content = str2;
            this.payloadWriter = new StringPayloadWriter();
            return this;
        }

        public HttpRequestBuilder progressListener(ProgressListener progressListener) {
            this.progressListener = progressListener;
            return this;
        }

        public HttpRequestBuilder removeHeader(String str) {
            this.headerMap.remove(str);
            return this;
        }

        public HttpRequestBuilder requestTimeOut(int i) {
            this.timeout = i;
            return this;
        }

        public HttpRequestBuilder responseListener(ResponseListener responseListener) {
            this.responseListener = responseListener;
            return this;
        }

        public HttpRequestBuilder silent() {
            this.silent = true;
            return this;
        }

        public HttpRequestBuilder supportChunkedStreaming(boolean z) {
            this.supportChunkedStreaming = z;
            return this;
        }

        public HttpRequestBuilder payload(String str, File file) {
            addHeader("Content-Type", str);
            this.contentType = str;
            this.content = file;
            this.payloadWriter = new FilePayloadWriter();
            return this;
        }

        public HttpRequestBuilder payload(String str, FileInputStream fileInputStream) {
            addHeader("Content-Type", str);
            this.contentType = str;
            this.content = fileInputStream;
            this.payloadWriter = new FileInputStreamPayloadWriter();
            return this;
        }

        public HttpRequestBuilder addRange(long j, long j2, long j3) {
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "bytes ", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            sbM1323p.append(j2);
            sbM1323p.append("/");
            sbM1323p.append(j3);
            addHeader("Content-Range", sbM1323p.toString());
            this.range = j;
            return this;
        }

        public HttpRequestBuilder(Map<String, String> map, String str, int i, boolean z) {
            HashMap map2 = new HashMap();
            this.headerMap = map2;
            this.url = str;
            this.timeout = i;
            this.isAccountRequiredFeature = z;
            map2.putAll(map);
            putNetworkHeader(str);
        }

        public HttpRequestBuilder(Map<String, String> map, String str, int i) {
            HashMap map2 = new HashMap();
            this.headerMap = map2;
            this.url = str;
            this.timeout = i;
            this.isAccountRequiredFeature = false;
            map2.putAll(map);
            putNetworkHeader(str);
        }
    }
}
