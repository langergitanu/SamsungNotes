package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class HttpHeadHC4 extends HttpRequestBaseHC4 {
    public static final String METHOD_NAME = "HEAD";

    public HttpHeadHC4() {
    }

    @Override // org.apache.http.client.methods.HttpRequestBaseHC4, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return "HEAD";
    }

    public HttpHeadHC4(URI uri) {
        setURI(uri);
    }

    public HttpHeadHC4(String str) {
        setURI(URI.create(str));
    }
}
