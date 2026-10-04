package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2HeadersEncoder {
    public static final SensitivityDetector NEVER_SENSITIVE = new SensitivityDetector() { // from class: io.netty.handler.codec.http2.Http2HeadersEncoder.1
        @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.SensitivityDetector
        public boolean isSensitive(CharSequence charSequence, CharSequence charSequence2) {
            return false;
        }
    };
    public static final SensitivityDetector ALWAYS_SENSITIVE = new SensitivityDetector() { // from class: io.netty.handler.codec.http2.Http2HeadersEncoder.2
        @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.SensitivityDetector
        public boolean isSensitive(CharSequence charSequence, CharSequence charSequence2) {
            return true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Configuration {
        long maxHeaderListSize();

        void maxHeaderListSize(long j);

        long maxHeaderTableSize();

        void maxHeaderTableSize(long j);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SensitivityDetector {
        boolean isSensitive(CharSequence charSequence, CharSequence charSequence2);
    }

    Configuration configuration();

    void encodeHeaders(int i, Http2Headers http2Headers, ByteBuf byteBuf);
}
