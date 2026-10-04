package com.samsung.scsp.framework.core.network;

import com.samsung.scsp.common.Journal;
import com.samsung.scsp.common.JournalFactory;
import com.samsung.scsp.framework.core.api.SCHashMap;
import com.samsung.scsp.framework.core.listeners.NetworkStatusListener;
import com.samsung.scsp.framework.core.listeners.ProgressListener;
import com.samsung.scsp.framework.core.listeners.ResponseListener;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractHttpRequest implements HttpRequest {
    private static final String BOUNDARY = "NO_BOUNDARY";
    private static final String CHARSET = "UTF-8";
    protected String[] anonymizationWords;
    private String from;
    protected final List<String> headerKeyList = new ArrayList();
    protected final List<String> headerValueList = new ArrayList();
    protected boolean isAccountRequiredFeature;
    private Journal journal;
    protected HttpRequest.Method method;
    protected String name;
    protected NetworkStatusListener networkStatusListener;
    protected SCHashMap parameters;
    protected ProgressListener progressListener;
    protected ResponseListener responseListener;
    protected boolean silent;
    protected boolean supportChunkedStreaming;
    protected int timeout;
    protected String url;

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public void begin() {
        Journal journal = this.journal;
        if (journal != null) {
            journal.begin(this.from, this.name);
        }
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public void end() {
        Journal journal = this.journal;
        if (journal != null) {
            journal.end(this.from, this.name);
        }
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public void error(int i) {
        Journal journal = this.journal;
        if (journal != null) {
            journal.error(this.from, this.name, i);
        }
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public String getAnonymizedUrl() {
        String[] strArr;
        String strReplaceAll = this.url;
        if (!StringUtil.isEmpty(strReplaceAll) && (strArr = this.anonymizationWords) != null) {
            for (String str : strArr) {
                strReplaceAll = strReplaceAll.replaceAll(str, "******");
            }
        }
        return strReplaceAll;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public String getBoundary() {
        return BOUNDARY;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public String getCharset() {
        return "UTF-8";
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public int getHeaderCount() {
        return this.headerKeyList.size();
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public String getHeaderKey(int i) {
        return this.headerKeyList.get(i);
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public String getHeaderValue(int i) {
        return this.headerValueList.get(i);
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public HttpRequest.Method getMethod() {
        return this.method;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public String getName() {
        return this.name;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public NetworkStatusListener getNetworkStatusListener() {
        return this.networkStatusListener;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public SCHashMap getParameters() {
        return this.parameters;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public Map<String, String> getPartHeaders(int i) {
        return null;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public ProgressListener getProgressListener() {
        return this.progressListener;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public ResponseListener getResponseListener() {
        return this.responseListener;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public int getTimeOut() {
        return this.timeout;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public String getUrl() {
        return this.url;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public boolean isSilent() {
        return this.silent;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public HttpRequest journal(String str, String str2) {
        this.journal = JournalFactory.get(str);
        this.from = str2;
        return this;
    }

    @Override // com.samsung.scsp.framework.core.network.HttpRequest
    public void setUrl(String str) {
        this.url = str;
    }
}
