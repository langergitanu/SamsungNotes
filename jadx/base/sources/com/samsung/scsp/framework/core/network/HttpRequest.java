package com.samsung.scsp.framework.core.network;

import com.samsung.scsp.framework.core.api.SCHashMap;
import com.samsung.scsp.framework.core.listeners.NetworkStatusListener;
import com.samsung.scsp.framework.core.listeners.ProgressListener;
import com.samsung.scsp.framework.core.listeners.ResponseListener;
import com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface HttpRequest {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Method {
        POST,
        PUT,
        GET,
        DELETE,
        PATCH,
        HEAD
    }

    default void begin() {
    }

    default void end() {
    }

    default void error(int i) {
    }

    String getAnonymizedUrl();

    String getBoundary();

    String getCharset();

    Object getContent(int i);

    String getContentType(int i);

    int getHeaderCount();

    String getHeaderKey(int i);

    String getHeaderValue(int i);

    long getLength();

    Method getMethod();

    String getName();

    NetworkStatusListener getNetworkStatusListener();

    SCHashMap getParameters();

    int getPartCount();

    Map<String, String> getPartHeaders(int i);

    PayloadWriterVisitor.PayloadWriter getPayloadWriter(int i);

    ProgressListener getProgressListener();

    long getRange();

    ResponseListener getResponseListener();

    boolean getSupportChunkedStreaming();

    int getTimeOut();

    String getUrl();

    boolean isAccountRequiredFeature();

    boolean isMultipart();

    boolean isSilent();

    default HttpRequest journal(String str, String str2) {
        return this;
    }

    void setUrl(String str);
}
