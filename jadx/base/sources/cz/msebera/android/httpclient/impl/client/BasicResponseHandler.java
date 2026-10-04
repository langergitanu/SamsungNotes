package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.EntityUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicResponseHandler extends AbstractResponseHandler<String> {
    @Override // cz.msebera.android.httpclient.impl.client.AbstractResponseHandler
    public String handleEntity(HttpEntity httpEntity) {
        return EntityUtils.toString(httpEntity);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractResponseHandler, cz.msebera.android.httpclient.client.ResponseHandler
    public String handleResponse(HttpResponse httpResponse) {
        return (String) super.handleResponse(httpResponse);
    }
}
