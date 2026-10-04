package cz.msebera.android.httpclient.impl.p171io;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.p172io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class HttpResponseWriter extends AbstractMessageWriter<HttpResponse> {
    public HttpResponseWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter, HttpParams httpParams) {
        super(sessionOutputBuffer, lineFormatter, httpParams);
    }

    @Override // cz.msebera.android.httpclient.impl.p171io.AbstractMessageWriter
    public void writeHeadLine(HttpResponse httpResponse) {
        this.lineFormatter.formatStatusLine(this.lineBuf, httpResponse.getStatusLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
