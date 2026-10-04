package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.params.HttpParams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface HttpMessage {
    void addHeader(Header header);

    void addHeader(String str, String str2);

    boolean containsHeader(String str);

    Header[] getAllHeaders();

    Header getFirstHeader(String str);

    Header[] getHeaders(String str);

    Header getLastHeader(String str);

    @Deprecated
    HttpParams getParams();

    ProtocolVersion getProtocolVersion();

    HeaderIterator headerIterator();

    HeaderIterator headerIterator(String str);

    void removeHeader(Header header);

    void removeHeaders(String str);

    void setHeader(Header header);

    void setHeader(String str, String str2);

    void setHeaders(Header[] headerArr);

    @Deprecated
    void setParams(HttpParams httpParams);
}
