package org.apache.http.client.methods;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class HttpOptionsHC4 extends HttpRequestBaseHC4 {
    public static final String METHOD_NAME = "OPTIONS";

    public HttpOptionsHC4() {
    }

    public Set<String> getAllowedMethods(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        HeaderIterator headerIterator = httpResponse.headerIterator("Allow");
        HashSet hashSet = new HashSet();
        while (headerIterator.hasNext()) {
            for (HeaderElement headerElement : headerIterator.nextHeader().getElements()) {
                hashSet.add(headerElement.getName());
            }
        }
        return hashSet;
    }

    @Override // org.apache.http.client.methods.HttpRequestBaseHC4, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return "OPTIONS";
    }

    public HttpOptionsHC4(URI uri) {
        setURI(uri);
    }

    public HttpOptionsHC4(String str) {
        setURI(URI.create(str));
    }
}
