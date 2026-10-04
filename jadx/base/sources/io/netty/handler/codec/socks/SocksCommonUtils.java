package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class SocksCommonUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SocksRequest UNKNOWN_SOCKS_REQUEST = new UnknownSocksRequest();
    public static final SocksResponse UNKNOWN_SOCKS_RESPONSE = new UnknownSocksResponse();
    private static final char ipv6hextetSeparator = ':';

    private SocksCommonUtils() {
    }

    private static void appendHextet(StringBuilder sb, byte[] bArr, int i) throws Throwable {
        StringUtil.toHexString(sb, bArr, i << 1, 2);
    }

    public static String ipv6toStr(byte[] bArr) throws Throwable {
        StringBuilder sb = new StringBuilder(39);
        ipv6toStr(sb, bArr, 0, 8);
        return sb.toString();
    }

    public static String readUsAscii(ByteBuf byteBuf, int i) {
        String string = byteBuf.toString(byteBuf.readerIndex(), i, CharsetUtil.US_ASCII);
        byteBuf.skipBytes(i);
        return string;
    }

    private static void ipv6toStr(StringBuilder sb, byte[] bArr, int i, int i2) throws Throwable {
        int i4 = i2 - 1;
        while (i < i4) {
            appendHextet(sb, bArr, i);
            sb.append(ipv6hextetSeparator);
            i++;
        }
        appendHextet(sb, bArr, i);
    }
}
