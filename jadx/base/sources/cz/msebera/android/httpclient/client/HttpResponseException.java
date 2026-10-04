package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.util.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final String reasonPhrase;
    private final int statusCode;

    public HttpResponseException(int i, String str) {
        super(String.format("status code: %d".concat(TextUtils.isBlank(str) ? "" : ", reason phrase: %s"), Integer.valueOf(i), str));
        this.statusCode = i;
        this.reasonPhrase = str;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
