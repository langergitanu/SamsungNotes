package io.grpc.okhttp.internal.framed;

import androidx.appcompat.widget.AbstractC0541b;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Header {
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(okhttp3.internal.http2.Header.RESPONSE_STATUS_UTF8);
    public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(okhttp3.internal.http2.Header.TARGET_METHOD_UTF8);
    public static final ByteString TARGET_PATH = ByteString.encodeUtf8(okhttp3.internal.http2.Header.TARGET_PATH_UTF8);
    public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(okhttp3.internal.http2.Header.TARGET_SCHEME_UTF8);
    public static final ByteString TARGET_AUTHORITY = ByteString.encodeUtf8(okhttp3.internal.http2.Header.TARGET_AUTHORITY_UTF8);
    public static final ByteString TARGET_HOST = ByteString.encodeUtf8(":host");
    public static final ByteString VERSION = ByteString.encodeUtf8(":version");

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
        return AbstractC0541b.m757C(this.name.utf8(), ": ", this.value.utf8());
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
