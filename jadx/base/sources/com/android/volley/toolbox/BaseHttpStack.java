package com.android.volley.toolbox;

import com.android.volley.Header;
import com.android.volley.Request;
import cz.msebera.android.httpclient.HttpVersion;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseHttpStack implements HttpStack {
    public abstract HttpResponse executeRequest(Request<?> request, Map<String, String> map);

    @Override // com.android.volley.toolbox.HttpStack
    @Deprecated
    public final org.apache.http.HttpResponse performRequest(Request<?> request, Map<String, String> map) {
        HttpResponse httpResponseExecuteRequest = executeRequest(request, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion(HttpVersion.HTTP, 1, 1), httpResponseExecuteRequest.getStatusCode(), ""));
        ArrayList arrayList = new ArrayList();
        for (Header header : httpResponseExecuteRequest.getHeaders()) {
            arrayList.add(new BasicHeader(header.getName(), header.getValue()));
        }
        basicHttpResponse.setHeaders((org.apache.http.Header[]) arrayList.toArray(new org.apache.http.Header[0]));
        InputStream content = httpResponseExecuteRequest.getContent();
        if (content != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(content);
            basicHttpEntity.setContentLength(httpResponseExecuteRequest.getContentLength());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
