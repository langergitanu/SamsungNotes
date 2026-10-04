package org.apache.http.client.methods;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.utils.CloneUtilsHC4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public abstract class HttpEntityEnclosingRequestBaseHC4 extends HttpRequestBaseHC4 implements HttpEntityEnclosingRequest {
    private HttpEntity entity;

    @Override // org.apache.http.client.methods.AbstractExecutionAwareRequest
    public Object clone() {
        HttpEntityEnclosingRequestBaseHC4 httpEntityEnclosingRequestBaseHC4 = (HttpEntityEnclosingRequestBaseHC4) super.clone();
        HttpEntity httpEntity = this.entity;
        if (httpEntity != null) {
            httpEntityEnclosingRequestBaseHC4.entity = (HttpEntity) CloneUtilsHC4.cloneObject(httpEntity);
        }
        return httpEntityEnclosingRequestBaseHC4;
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
    }
}
