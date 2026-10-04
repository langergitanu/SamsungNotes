package io.netty.handler.codec.http;

import com.sun.imageio.plugins.jpeg.JPEG;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class QueryStringEncoder {
    private static final char[] CHAR_MAP = BinTools.hex.toCharArray();
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private final Charset charset;
    private boolean hasParams;
    private final StringBuilder uriBuilder;

    public QueryStringEncoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    private void appendEncoded(int i) {
        StringBuilder sb = this.uriBuilder;
        sb.append('%');
        sb.append(forDigit(i >> 4));
        sb.append(forDigit(i));
    }

    private static boolean dontNeedEncoding(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c < 'A' || c > 'Z') {
            return (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.' || c == '*' || c == '~';
        }
        return true;
    }

    private void encodeComponent(CharSequence charSequence) {
        if (this.charset == null) {
            encodeUtf8Component(charSequence);
        } else {
            encodeNonUtf8Component(charSequence);
        }
    }

    private void encodeNonUtf8Component(CharSequence charSequence) {
        int length = charSequence.length();
        char[] cArr = null;
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (dontNeedEncoding(cCharAt)) {
                this.uriBuilder.append(cCharAt);
                i++;
            } else {
                if (cArr == null) {
                    cArr = new char[charSequence.length() - i];
                }
                int i2 = 0;
                do {
                    cArr[i2] = cCharAt;
                    i2++;
                    i++;
                    if (i >= charSequence.length()) {
                        break;
                    } else {
                        cCharAt = charSequence.charAt(i);
                    }
                } while (!dontNeedEncoding(cCharAt));
                for (byte b : new String(cArr, 0, i2).getBytes(this.charset)) {
                    appendEncoded(b);
                }
            }
        }
    }

    private void encodeUtf8Component(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!dontNeedEncoding(charSequence.charAt(i))) {
                encodeUtf8Component(charSequence, i, length);
                return;
            }
        }
        this.uriBuilder.append(charSequence);
    }

    private void encodeUtf8ComponentSlow(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 128) {
                if (dontNeedEncoding(cCharAt)) {
                    this.uriBuilder.append(cCharAt);
                } else {
                    appendEncoded(cCharAt);
                }
            } else if (cCharAt < 2048) {
                appendEncoded((cCharAt >> 6) | 192);
                appendEncoded((cCharAt & '?') | 128);
            } else if (!StringUtil.isSurrogate(cCharAt)) {
                appendEncoded((cCharAt >> '\f') | JPEG.APP0);
                appendEncoded(((cCharAt >> 6) & 63) | 128);
                appendEncoded((cCharAt & '?') | 128);
            } else if (Character.isHighSurrogate(cCharAt)) {
                i++;
                if (i == charSequence.length()) {
                    appendEncoded(63);
                    return;
                }
                writeUtf8Surrogate(cCharAt, charSequence.charAt(i));
            } else {
                appendEncoded(63);
            }
            i++;
        }
    }

    private static char forDigit(int i) {
        return CHAR_MAP[i & 15];
    }

    private void writeUtf8Surrogate(char c, char c2) {
        if (!Character.isLowSurrogate(c2)) {
            appendEncoded(63);
            if (Character.isHighSurrogate(c2)) {
                c2 = '?';
            }
            appendEncoded(c2);
            return;
        }
        int codePoint = Character.toCodePoint(c, c2);
        appendEncoded((codePoint >> 18) | 240);
        appendEncoded(((codePoint >> 12) & 63) | 128);
        appendEncoded(((codePoint >> 6) & 63) | 128);
        appendEncoded((codePoint & 63) | 128);
    }

    public void addParam(String str, String str2) {
        ObjectUtil.checkNotNull(str, "name");
        if (this.hasParams) {
            this.uriBuilder.append(Typography.amp);
        } else {
            this.uriBuilder.append('?');
            this.hasParams = true;
        }
        encodeComponent(str);
        if (str2 != null) {
            this.uriBuilder.append('=');
            encodeComponent(str2);
        }
    }

    public String toString() {
        return this.uriBuilder.toString();
    }

    public URI toUri() {
        return new URI(toString());
    }

    public QueryStringEncoder(String str, Charset charset) {
        ObjectUtil.checkNotNull(charset, "charset");
        this.uriBuilder = new StringBuilder(str);
        this.charset = CharsetUtil.UTF_8.equals(charset) ? null : charset;
    }

    private void encodeUtf8Component(CharSequence charSequence, int i, int i2) {
        if (i > 0) {
            this.uriBuilder.append(charSequence, 0, i);
        }
        encodeUtf8ComponentSlow(charSequence, i, i2);
    }
}
