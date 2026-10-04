package io.netty.handler.codec.http;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HttpVersion implements Comparable<HttpVersion> {
    static final String HTTP_1_0_STRING = "HTTP/1.0";
    static final String HTTP_1_1_STRING = "HTTP/1.1";
    private final byte[] bytes;
    private final boolean keepAliveDefault;
    private final int majorVersion;
    private final int minorVersion;
    private final String protocolName;
    private final String text;
    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\S+)/(\\d+)\\.(\\d+)");
    public static final HttpVersion HTTP_1_0 = new HttpVersion(cz.msebera.android.httpclient.HttpVersion.HTTP, 1, 0, false, true);
    public static final HttpVersion HTTP_1_1 = new HttpVersion(cz.msebera.android.httpclient.HttpVersion.HTTP, 1, 1, true, true);

    public HttpVersion(String str, boolean z) {
        String upperCase = ObjectUtil.checkNonEmptyAfterTrim(str, "text").toUpperCase();
        Matcher matcher = VERSION_PATTERN.matcher(upperCase);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("invalid version format: ", upperCase));
        }
        String strGroup = matcher.group(1);
        this.protocolName = strGroup;
        int i = Integer.parseInt(matcher.group(2));
        this.majorVersion = i;
        int i2 = Integer.parseInt(matcher.group(3));
        this.minorVersion = i2;
        this.text = strGroup + '/' + i + '.' + i2;
        this.keepAliveDefault = z;
        this.bytes = null;
    }

    public static HttpVersion valueOf(String str) {
        ObjectUtil.checkNotNull(str, "text");
        if (str == HTTP_1_1_STRING) {
            return HTTP_1_1;
        }
        if (str == HTTP_1_0_STRING) {
            return HTTP_1_0;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            throw new IllegalArgumentException("text is empty (possibly HTTP/0.9)");
        }
        HttpVersion httpVersionVersion0 = version0(strTrim);
        return httpVersionVersion0 == null ? new HttpVersion(strTrim, true) : httpVersionVersion0;
    }

    private static HttpVersion version0(String str) {
        if (HTTP_1_1_STRING.equals(str)) {
            return HTTP_1_1;
        }
        if (HTTP_1_0_STRING.equals(str)) {
            return HTTP_1_0;
        }
        return null;
    }

    public void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            byteBuf.writeCharSequence(this.text, CharsetUtil.US_ASCII);
        } else {
            byteBuf.writeBytes(bArr);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpVersion)) {
            return false;
        }
        HttpVersion httpVersion = (HttpVersion) obj;
        return minorVersion() == httpVersion.minorVersion() && majorVersion() == httpVersion.majorVersion() && protocolName().equals(httpVersion.protocolName());
    }

    public int hashCode() {
        return minorVersion() + ((majorVersion() + (protocolName().hashCode() * 31)) * 31);
    }

    public boolean isKeepAliveDefault() {
        return this.keepAliveDefault;
    }

    public int majorVersion() {
        return this.majorVersion;
    }

    public int minorVersion() {
        return this.minorVersion;
    }

    public String protocolName() {
        return this.protocolName;
    }

    public String text() {
        return this.text;
    }

    public String toString() {
        return text();
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpVersion httpVersion) {
        int iCompareTo = protocolName().compareTo(httpVersion.protocolName());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iMajorVersion = majorVersion() - httpVersion.majorVersion();
        return iMajorVersion != 0 ? iMajorVersion : minorVersion() - httpVersion.minorVersion();
    }

    public HttpVersion(String str, int i, int i2, boolean z) {
        this(str, i, i2, z, false);
    }

    private HttpVersion(String str, int i, int i2, boolean z, boolean z2) {
        String upperCase = ObjectUtil.checkNonEmptyAfterTrim(str, "protocolName").toUpperCase();
        for (int i4 = 0; i4 < upperCase.length(); i4++) {
            if (Character.isISOControl(upperCase.charAt(i4)) || Character.isWhitespace(upperCase.charAt(i4))) {
                throw new IllegalArgumentException("invalid character in protocolName");
            }
        }
        ObjectUtil.checkPositiveOrZero(i, "majorVersion");
        ObjectUtil.checkPositiveOrZero(i2, "minorVersion");
        this.protocolName = upperCase;
        this.majorVersion = i;
        this.minorVersion = i2;
        String str2 = upperCase + '/' + i + '.' + i2;
        this.text = str2;
        this.keepAliveDefault = z;
        if (z2) {
            this.bytes = str2.getBytes(CharsetUtil.US_ASCII);
        } else {
            this.bytes = null;
        }
    }
}
