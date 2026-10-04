package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectDecoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public abstract class RtspObjectDecoder extends HttpObjectDecoder {
    public RtspObjectDecoder() {
        this(4096, 8192, 8192);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        boolean zIsContentAlwaysEmpty = super.isContentAlwaysEmpty(httpMessage);
        if (!zIsContentAlwaysEmpty && httpMessage.headers().contains(RtspHeaderNames.CONTENT_LENGTH)) {
            return zIsContentAlwaysEmpty;
        }
        return true;
    }

    public RtspObjectDecoder(int i, int i2, int i4) {
        super(i, i2, i4 * 2, false);
    }

    public RtspObjectDecoder(int i, int i2, int i4, boolean z) {
        super(i, i2, i4 * 2, false, z);
    }
}
