package org.apache.http.impl.entity;

import androidx.appcompat.widget.AbstractC0541b;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class StrictContentLengthStrategyHC4 implements ContentLengthStrategy {
    public static final StrictContentLengthStrategyHC4 INSTANCE = new StrictContentLengthStrategyHC4();
    private final int implicitLen;

    public StrictContentLengthStrategyHC4(int i) {
        this.implicitLen = i;
    }

    @Override // org.apache.http.entity.ContentLengthStrategy
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

    public StrictContentLengthStrategyHC4() {
        this(-1);
    }
}
