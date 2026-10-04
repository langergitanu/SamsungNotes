package org.apache.http.impl.p224io;

import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class DefaultHttpRequestWriter extends AbstractMessageWriterHC4<HttpRequest> {
    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    @Override // org.apache.http.impl.p224io.AbstractMessageWriterHC4
    public void writeHeadLine(HttpMessage httpMessage) throws IOException {
        this.lineFormatter.formatRequestLine(this.lineBuf, ((HttpRequest) httpMessage).getRequestLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer) {
        this(sessionOutputBuffer, null);
    }
}
