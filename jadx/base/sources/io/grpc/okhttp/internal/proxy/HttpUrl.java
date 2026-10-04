package io.grpc.okhttp.internal.proxy;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import io.grpc.internal.GrpcUtil;
import java.io.EOFException;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import okio.Buffer;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Marker;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HttpUrl {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String host;
    private final int port;
    private final String scheme;
    private final String url;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        String host;
        int port = -1;
        String scheme;

        private static String canonicalizeHost(String str, int i, int i2) {
            String strPercentDecode = HttpUrl.percentDecode(str, i, i2, false);
            if (!strPercentDecode.startsWith("[") || !strPercentDecode.endsWith("]")) {
                return domainToAscii(strPercentDecode);
            }
            InetAddress inetAddressDecodeIpv6 = decodeIpv6(strPercentDecode, 1, strPercentDecode.length() - 1);
            if (inetAddressDecodeIpv6 == null) {
                return null;
            }
            byte[] address = inetAddressDecodeIpv6.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            throw new AssertionError();
        }

        private static boolean containsInvalidHostnameAsciiCodes(String str) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i4) {
            int i5 = i4;
            while (i < i2) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i4) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i6 = i;
                int i7 = 0;
                while (i6 < i2) {
                    char cCharAt = str.charAt(i6);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i7 == 0 && i != i6) || (i7 = ((i7 * 10) + cCharAt) - 48) > 255) {
                        return false;
                    }
                    i6++;
                }
                if (i6 - i == 0) {
                    return false;
                }
                bArr[i5] = (byte) i7;
                i5++;
                i = i6;
            }
            return i5 == i4 + 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
        
            if (r4 == 16) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
        
            if (r5 != (-1)) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
        
            r12 = r4 - r5;
            java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
            java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
        
            return java.net.InetAddress.getByAddress(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
        
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static InetAddress decodeIpv6(String str, int i, int i2) {
            int i4;
            byte[] bArr = new byte[16];
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i < i2) {
                    if (i5 != 16) {
                        int i8 = i + 2;
                        if (i8 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                            if (i6 == -1) {
                                i5 += 2;
                                i6 = i5;
                                if (i8 != i2) {
                                    i7 = i8;
                                    int i9 = 0;
                                    i = i7;
                                    while (i < i2) {
                                    }
                                    i4 = i - i7;
                                    if (i4 == 0) {
                                        break;
                                    }
                                    break;
                                    break;
                                }
                                break;
                            }
                            return null;
                        }
                        if (i5 != 0) {
                            if (str.regionMatches(i, ":", 0, 1)) {
                                i++;
                            } else {
                                if (!str.regionMatches(i, Extension.DOT, 0, 1) || !decodeIpv4Suffix(str, i7, i2, bArr, i5 - 2)) {
                                    return null;
                                }
                                i5 += 2;
                            }
                        }
                        i7 = i;
                        int i92 = 0;
                        i = i7;
                        while (i < i2) {
                            int iDecodeHexDigit = HttpUrl.decodeHexDigit(str.charAt(i));
                            if (iDecodeHexDigit == -1) {
                                break;
                            }
                            i92 = (i92 << 4) + iDecodeHexDigit;
                            i++;
                        }
                        i4 = i - i7;
                        if (i4 == 0 || i4 > 4) {
                            break;
                        }
                        int i10 = i5 + 1;
                        bArr[i5] = (byte) ((i92 >>> 8) & 255);
                        i5 += 2;
                        bArr[i10] = (byte) (i92 & 255);
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            return null;
        }

        private static String domainToAscii(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private static String inet6AddressToAscii(byte[] bArr) {
            int i = -1;
            int i2 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i4 < bArr.length) {
                int i6 = i4;
                while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                    i6 += 2;
                }
                int i7 = i6 - i4;
                if (i7 > i5) {
                    i = i4;
                    i5 = i7;
                }
                i4 = i6 + 2;
            }
            Buffer buffer = new Buffer();
            while (i2 < bArr.length) {
                if (i2 == i) {
                    buffer.writeByte(58);
                    i2 += i5;
                    if (i2 == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i2 > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                    i2 += 2;
                }
            }
            return buffer.readUtf8();
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.host != null) {
                return new HttpUrl(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int effectivePort() {
            int i = this.port;
            return i != -1 ? i : HttpUrl.defaultPort(this.scheme);
        }

        public Builder host(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String strCanonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (strCanonicalizeHost == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.host = strCanonicalizeHost;
            return this;
        }

        public Builder port(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "unexpected port: "));
            }
            this.port = i;
            return this;
        }

        public Builder scheme(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.scheme = "http";
                return this;
            }
            if (!str.equalsIgnoreCase(AuthenticationConstants.HTTPS_PROTOCOL_STRING)) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            this.scheme = AuthenticationConstants.HTTPS_PROTOCOL_STRING;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme);
            sb.append("://");
            if (this.host.indexOf(58) != -1) {
                sb.append(PropertyUtils.INDEXED_DELIM);
                sb.append(this.host);
                sb.append(PropertyUtils.INDEXED_DELIM2);
            } else {
                sb.append(this.host);
            }
            int iEffectivePort = effectivePort();
            if (iEffectivePort != HttpUrl.defaultPort(this.scheme)) {
                sb.append(':');
                sb.append(iEffectivePort);
            }
            return sb.toString();
        }
    }

    public static void canonicalize(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3) {
        Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z2) {
                    buffer.writeUtf8(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z3) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && !z))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(iCodePointAt);
                    while (!buffer2.exhausted()) {
                        try {
                            fakeEofExceptionMethod();
                            byte b = buffer2.readByte();
                            buffer.writeByte(37);
                            char[] cArr = HEX_DIGITS;
                            buffer.writeByte((int) cArr[((b & 255) >> 4) & 15]);
                            buffer.writeByte((int) cArr[b & 15]);
                        } catch (EOFException e) {
                            throw new IndexOutOfBoundsException(e.getMessage());
                        }
                    }
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return c - '7';
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals(AuthenticationConstants.HTTPS_PROTOCOL_STRING)) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        return -1;
    }

    public static String percentDecode(String str, int i, int i2, boolean z) {
        for (int i4 = i; i4 < i2; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i4);
                percentDecode(buffer, str, i4, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals(AuthenticationConstants.HTTPS_PROTOCOL_STRING);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        String str = this.scheme;
        builder.scheme = str;
        builder.host = this.host;
        builder.port = this.port != defaultPort(str) ? this.port : -1;
        return builder;
    }

    public int port() {
        return this.port;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    private HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.url = builder.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void percentDecode(Buffer buffer, String str, int i, int i2, boolean z) {
        int i4;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i4 = i + 2) < i2) {
                int iDecodeHexDigit = decodeHexDigit(str.charAt(i + 1));
                int iDecodeHexDigit2 = decodeHexDigit(str.charAt(i4));
                if (iDecodeHexDigit != -1 && iDecodeHexDigit2 != -1) {
                    buffer.writeByte((iDecodeHexDigit << 4) + iDecodeHexDigit2);
                    i = i4;
                }
            } else if (iCodePointAt == 43 && z) {
                buffer.writeByte(32);
            } else {
                buffer.writeUtf8CodePoint(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    private static void fakeEofExceptionMethod() {
    }
}
