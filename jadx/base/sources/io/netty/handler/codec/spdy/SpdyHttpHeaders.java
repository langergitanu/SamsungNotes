package io.netty.handler.codec.spdy;

import io.netty.util.AsciiString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SpdyHttpHeaders {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Names {
        public static final AsciiString STREAM_ID = AsciiString.cached("x-spdy-stream-id");
        public static final AsciiString ASSOCIATED_TO_STREAM_ID = AsciiString.cached("x-spdy-associated-to-stream-id");
        public static final AsciiString PRIORITY = AsciiString.cached("x-spdy-priority");
        public static final AsciiString SCHEME = AsciiString.cached("x-spdy-scheme");

        private Names() {
        }
    }

    private SpdyHttpHeaders() {
    }
}
