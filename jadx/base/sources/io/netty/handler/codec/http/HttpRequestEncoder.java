package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.CharsetUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HttpRequestEncoder extends HttpObjectEncoder<HttpRequest> {
    private static final char QUESTION_MARK = '?';
    private static final char SLASH = '/';
    private static final int SLASH_AND_SPACE_SHORT = 12064;
    private static final int SPACE_SLASH_AND_SPACE_MEDIUM = 2109216;

    @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) {
        return super.acceptOutboundMessage(obj) && !(obj instanceof HttpResponse);
    }

    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void encodeInitialLine(ByteBuf byteBuf, HttpRequest httpRequest) {
        ByteBufUtil.copy(httpRequest.method().asciiName(), byteBuf);
        String strUri = httpRequest.uri();
        if (strUri.isEmpty()) {
            ByteBufUtil.writeMediumBE(byteBuf, SPACE_SLASH_AND_SPACE_MEDIUM);
        } else {
            int iIndexOf = strUri.indexOf("://");
            boolean z = false;
            CharSequence charSequenceInsert = strUri;
            if (iIndexOf != -1) {
                char cCharAt = strUri.charAt(0);
                charSequenceInsert = strUri;
                if (cCharAt != '/') {
                    int i = iIndexOf + 3;
                    int iIndexOf2 = strUri.indexOf(63, i);
                    if (iIndexOf2 == -1) {
                        int iLastIndexOf = strUri.lastIndexOf(47);
                        charSequenceInsert = strUri;
                        if (iLastIndexOf < i) {
                            z = true;
                            charSequenceInsert = strUri;
                        }
                    } else {
                        int iLastIndexOf2 = strUri.lastIndexOf(47, iIndexOf2);
                        charSequenceInsert = strUri;
                        if (iLastIndexOf2 < i) {
                            charSequenceInsert = new StringBuilder(strUri).insert(iIndexOf2, SLASH);
                        }
                    }
                }
            }
            byteBuf.writeByte(32).writeCharSequence(charSequenceInsert, CharsetUtil.UTF_8);
            if (z) {
                ByteBufUtil.writeShortBE(byteBuf, SLASH_AND_SPACE_SHORT);
            } else {
                byteBuf.writeByte(32);
            }
        }
        httpRequest.protocolVersion().encode(byteBuf);
        ByteBufUtil.writeShortBE(byteBuf, 3338);
    }
}
