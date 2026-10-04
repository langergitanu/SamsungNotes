package io.netty.handler.codec.http;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HttpResponseDecoder extends HttpObjectDecoder {
    private static final HttpResponseStatus UNKNOWN_STATUS = new HttpResponseStatus(999, "Unknown");

    public HttpResponseDecoder() {
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createInvalidMessage() {
        return new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, UNKNOWN_STATUS, this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createMessage(String[] strArr) {
        return new DefaultHttpResponse(HttpVersion.valueOf(strArr[0]), HttpResponseStatus.valueOf(Integer.parseInt(strArr[1]), strArr[2]), this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isDecodingRequest() {
        return false;
    }

    public HttpResponseDecoder(int i, int i2, int i4) {
        super(i, i2, i4, true);
    }

    public HttpResponseDecoder(int i, int i2, int i4, boolean z) {
        super(i, i2, i4, true, z);
    }

    public HttpResponseDecoder(int i, int i2, int i4, boolean z, int i5) {
        super(i, i2, i4, true, z, i5);
    }

    public HttpResponseDecoder(int i, int i2, int i4, boolean z, int i5, boolean z2) {
        super(i, i2, i4, true, z, i5, z2);
    }

    public HttpResponseDecoder(int i, int i2, int i4, boolean z, int i5, boolean z2, boolean z3) {
        super(i, i2, i4, true, z, i5, z2, z3);
    }
}
