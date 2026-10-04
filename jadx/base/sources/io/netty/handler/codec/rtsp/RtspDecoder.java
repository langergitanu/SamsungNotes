package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectDecoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class RtspDecoder extends HttpObjectDecoder {
    public static final int DEFAULT_MAX_CONTENT_LENGTH = 8192;
    private static final HttpResponseStatus UNKNOWN_STATUS = new HttpResponseStatus(999, "Unknown");
    private static final Pattern versionPattern = Pattern.compile("RTSP/\\d\\.\\d");
    private boolean isDecodingRequest;

    public RtspDecoder() {
        this(4096, 8192, 8192);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createInvalidMessage() {
        return this.isDecodingRequest ? new DefaultFullHttpRequest(RtspVersions.RTSP_1_0, RtspMethods.OPTIONS, "/bad-request", this.validateHeaders) : new DefaultFullHttpResponse(RtspVersions.RTSP_1_0, UNKNOWN_STATUS, this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createMessage(String[] strArr) {
        if (versionPattern.matcher(strArr[0]).matches()) {
            this.isDecodingRequest = false;
            return new DefaultHttpResponse(RtspVersions.valueOf(strArr[0]), new HttpResponseStatus(Integer.parseInt(strArr[1]), strArr[2]), this.validateHeaders);
        }
        this.isDecodingRequest = true;
        return new DefaultHttpRequest(RtspVersions.valueOf(strArr[2]), RtspMethods.valueOf(strArr[0]), strArr[1], this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        return super.isContentAlwaysEmpty(httpMessage) || !httpMessage.headers().contains(RtspHeaderNames.CONTENT_LENGTH);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isDecodingRequest() {
        return this.isDecodingRequest;
    }

    public RtspDecoder(int i, int i2, int i4) {
        super(i, i2, i4 * 2, false);
    }

    public RtspDecoder(int i, int i2, int i4, boolean z) {
        super(i, i2, i4 * 2, false, z);
    }
}
