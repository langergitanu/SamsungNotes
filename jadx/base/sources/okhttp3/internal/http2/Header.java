package okhttp3.internal.http2;

import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Header {
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    public static final ByteString PSEUDO_PREFIX = ByteString.encodeUtf8(":");
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(RESPONSE_STATUS_UTF8);
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(TARGET_METHOD_UTF8);
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_PATH = ByteString.encodeUtf8(TARGET_PATH_UTF8);
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(TARGET_SCHEME_UTF8);
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_AUTHORITY = ByteString.encodeUtf8(TARGET_AUTHORITY_UTF8);

    public Header(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            if (this.name.equals(header.name) && this.value.equals(header.value)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() + ((this.name.hashCode() + 527) * 31);
    }

    public String toString() {
        return Util.format("%s: %s", this.name.utf8(), this.value.utf8());
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString2.size() + byteString.size() + 32;
    }
}
