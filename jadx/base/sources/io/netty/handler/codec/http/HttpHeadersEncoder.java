package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class HttpHeadersEncoder {
    private static final int COLON_AND_SPACE_SHORT = 14880;

    private HttpHeadersEncoder() {
    }

    public static void encoderHeader(CharSequence charSequence, CharSequence charSequence2, ByteBuf byteBuf) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        byteBuf.ensureWritable(length + length2 + 4);
        int iWriterIndex = byteBuf.writerIndex();
        writeAscii(byteBuf, iWriterIndex, charSequence);
        int i = iWriterIndex + length;
        ByteBufUtil.setShortBE(byteBuf, i, COLON_AND_SPACE_SHORT);
        int i2 = i + 2;
        writeAscii(byteBuf, i2, charSequence2);
        int i4 = i2 + length2;
        ByteBufUtil.setShortBE(byteBuf, i4, 3338);
        byteBuf.writerIndex(i4 + 2);
    }

    private static void writeAscii(ByteBuf byteBuf, int i, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i, charSequence.length());
        } else {
            byteBuf.setCharSequence(i, charSequence, CharsetUtil.US_ASCII);
        }
    }
}
