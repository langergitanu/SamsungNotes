package io.netty.handler.codec.spdy;

import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SpdyHeaders extends Headers<CharSequence, CharSequence, SpdyHeaders> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HttpNames {
        public static final AsciiString HOST = AsciiString.cached(":host");
        public static final AsciiString METHOD = AsciiString.cached(Header.TARGET_METHOD_UTF8);
        public static final AsciiString PATH = AsciiString.cached(Header.TARGET_PATH_UTF8);
        public static final AsciiString SCHEME = AsciiString.cached(Header.TARGET_SCHEME_UTF8);
        public static final AsciiString STATUS = AsciiString.cached(Header.RESPONSE_STATUS_UTF8);
        public static final AsciiString VERSION = AsciiString.cached(":version");

        private HttpNames() {
        }
    }

    boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z);

    List<String> getAllAsString(CharSequence charSequence);

    String getAsString(CharSequence charSequence);

    Iterator<Map.Entry<String, String>> iteratorAsString();
}
