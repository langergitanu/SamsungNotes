package cz.msebera.android.httpclient.impl.entity;

import androidx.appcompat.widget.AbstractC0541b;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
    private final int implicitLen;

    public StrictContentLengthStrategy(int i) {
        this.implicitLen = i;
    }

    @Override // cz.msebera.android.httpclient.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws ProtocolException {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (!"chunked".equalsIgnoreCase(value)) {
                if ("identity".equalsIgnoreCase(value)) {
                    return -1L;
                }
                throw new ProtocolException(AbstractC0541b.m772n("Unsupported transfer encoding: ", value));
            }
            if (!httpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                return -2L;
            }
            throw new ProtocolException("Chunked transfer encoding not allowed for " + httpMessage.getProtocolVersion());
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Length");
        if (firstHeader2 == null) {
            return this.implicitLen;
        }
        String value2 = firstHeader2.getValue();
        try {
            long j = Long.parseLong(value2);
            if (j >= 0) {
                return j;
            }
            throw new ProtocolException("Negative content length: " + value2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException(AbstractC0541b.m772n("Invalid content length: ", value2));
        }
    }

    public StrictContentLengthStrategy() {
        this(-1);
    }
}
