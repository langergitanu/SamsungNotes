package io.netty.handler.codec.spdy;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.yubico.yubikit.core.fido.CtapException;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class SpdyCodecUtil {
    static final byte SPDY_DATA_FLAG_FIN = 1;
    static final int SPDY_DATA_FRAME = 0;
    static final byte[] SPDY_DICT = {0, 0, 0, 7, 111, SprAttributeBase.TYPE_SHADOW, 116, 105, 111, 110, 115, 0, 0, 0, 4, 104, 101, SprAttributeBase.TYPE_ANIMATOR_SET, 100, 0, 0, 0, 4, SprAttributeBase.TYPE_SHADOW, 111, 115, 116, 0, 0, 0, 3, SprAttributeBase.TYPE_SHADOW, 117, 116, 0, 0, 0, 6, 100, 101, 108, 101, 116, 101, 0, 0, 0, 5, 116, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 99, 101, 0, 0, 0, 6, SprAttributeBase.TYPE_ANIMATOR_SET, 99, 99, 101, SprAttributeBase.TYPE_SHADOW, 116, 0, 0, 0, 14, SprAttributeBase.TYPE_ANIMATOR_SET, 99, 99, 101, SprAttributeBase.TYPE_SHADOW, 116, 45, 99, 104, SprAttributeBase.TYPE_ANIMATOR_SET, 114, 115, 101, 116, 0, 0, 0, 15, SprAttributeBase.TYPE_ANIMATOR_SET, 99, 99, 101, SprAttributeBase.TYPE_SHADOW, 116, 45, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 15, SprAttributeBase.TYPE_ANIMATOR_SET, 99, 99, 101, SprAttributeBase.TYPE_SHADOW, 116, 45, 108, SprAttributeBase.TYPE_ANIMATOR_SET, 110, 103, 117, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 101, 0, 0, 0, 13, SprAttributeBase.TYPE_ANIMATOR_SET, 99, 99, 101, SprAttributeBase.TYPE_SHADOW, 116, 45, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 110, 103, 101, 115, 0, 0, 0, 3, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 101, 0, 0, 0, 5, SprAttributeBase.TYPE_ANIMATOR_SET, 108, 108, 111, 119, 0, 0, 0, 13, SprAttributeBase.TYPE_ANIMATOR_SET, 117, 116, 104, 111, 114, 105, 122, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 105, 111, 110, 0, 0, 0, 13, 99, SprAttributeBase.TYPE_ANIMATOR_SET, 99, 104, 101, 45, 99, 111, 110, 116, 114, 111, 108, 0, 0, 0, 10, 99, 111, 110, 110, 101, 99, 116, 105, 111, 110, 0, 0, 0, 12, 99, 111, 110, 116, 101, 110, 116, 45, 98, SprAttributeBase.TYPE_ANIMATOR_SET, 115, 101, 0, 0, 0, 16, 99, 111, 110, 116, 101, 110, 116, 45, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 16, 99, 111, 110, 116, 101, 110, 116, 45, 108, SprAttributeBase.TYPE_ANIMATOR_SET, 110, 103, 117, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 101, 0, 0, 0, 14, 99, 111, 110, 116, 101, 110, 116, 45, 108, 101, 110, 103, 116, 104, 0, 0, 0, 16, 99, 111, 110, 116, 101, 110, 116, 45, 108, 111, 99, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 105, 111, 110, 0, 0, 0, 11, 99, 111, 110, 116, 101, 110, 116, 45, 109, 100, CtapException.ERR_PIN_NOT_SET, 0, 0, 0, 13, 99, 111, 110, 116, 101, 110, 116, 45, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 110, 103, 101, 0, 0, 0, 12, 99, 111, 110, 116, 101, 110, 116, 45, 116, 121, SprAttributeBase.TYPE_SHADOW, 101, 0, 0, 0, 4, 100, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 101, 0, 0, 0, 4, 101, 116, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 0, 0, 0, 6, 101, 120, SprAttributeBase.TYPE_SHADOW, 101, 99, 116, 0, 0, 0, 7, 101, 120, SprAttributeBase.TYPE_SHADOW, 105, 114, 101, 115, 0, 0, 0, 4, 102, 114, 111, 109, 0, 0, 0, 4, 104, 111, 115, 116, 0, 0, 0, 8, 105, 102, 45, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 99, 104, 0, 0, 0, 17, 105, 102, 45, 109, 111, 100, 105, 102, 105, 101, 100, 45, 115, 105, 110, 99, 101, 0, 0, 0, 13, 105, 102, 45, 110, 111, 110, 101, 45, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 99, 104, 0, 0, 0, 8, 105, 102, 45, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 110, 103, 101, 0, 0, 0, 19, 105, 102, 45, 117, 110, 109, 111, 100, 105, 102, 105, 101, 100, 45, 115, 105, 110, 99, 101, 0, 0, 0, 13, 108, SprAttributeBase.TYPE_ANIMATOR_SET, 115, 116, 45, 109, 111, 100, 105, 102, 105, 101, 100, 0, 0, 0, 8, 108, 111, 99, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 105, 111, 110, 0, 0, 0, 12, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 120, 45, 102, 111, 114, 119, SprAttributeBase.TYPE_ANIMATOR_SET, 114, 100, 115, 0, 0, 0, 6, SprAttributeBase.TYPE_SHADOW, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 0, 0, 0, 18, SprAttributeBase.TYPE_SHADOW, 114, 111, 120, 121, 45, SprAttributeBase.TYPE_ANIMATOR_SET, 117, 116, 104, 101, 110, 116, 105, 99, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 101, 0, 0, 0, 19, SprAttributeBase.TYPE_SHADOW, 114, 111, 120, 121, 45, SprAttributeBase.TYPE_ANIMATOR_SET, 117, 116, 104, 111, 114, 105, 122, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 105, 111, 110, 0, 0, 0, 5, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 110, 103, 101, 0, 0, 0, 7, 114, 101, 102, 101, 114, 101, 114, 0, 0, 0, 11, 114, 101, 116, 114, 121, 45, SprAttributeBase.TYPE_ANIMATOR_SET, 102, 116, 101, 114, 0, 0, 0, 6, 115, 101, 114, 118, 101, 114, 0, 0, 0, 2, 116, 101, 0, 0, 0, 7, 116, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 105, 108, 101, 114, 0, 0, 0, 17, 116, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 110, 115, 102, 101, 114, 45, 101, 110, 99, 111, 100, 105, 110, 103, 0, 0, 0, 7, 117, SprAttributeBase.TYPE_SHADOW, 103, 114, SprAttributeBase.TYPE_ANIMATOR_SET, 100, 101, 0, 0, 0, 10, 117, 115, 101, 114, 45, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 101, 110, 116, 0, 0, 0, 4, 118, SprAttributeBase.TYPE_ANIMATOR_SET, 114, 121, 0, 0, 0, 3, 118, 105, SprAttributeBase.TYPE_ANIMATOR_SET, 0, 0, 0, 7, 119, SprAttributeBase.TYPE_ANIMATOR_SET, 114, 110, 105, 110, 103, 0, 0, 0, 16, 119, 119, 119, 45, SprAttributeBase.TYPE_ANIMATOR_SET, 117, 116, 104, 101, 110, 116, 105, 99, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 101, 0, 0, 0, 6, 109, 101, 116, 104, 111, 100, 0, 0, 0, 3, 103, 101, 116, 0, 0, 0, 6, 115, 116, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 117, 115, 0, 0, 0, 6, CtapException.ERR_PIN_BLOCKED, 48, 48, 32, 79, 75, 0, 0, 0, 7, 118, 101, 114, 115, 105, 111, 110, 0, 0, 0, 8, 72, 84, 84, 80, 47, 49, 46, 49, 0, 0, 0, 3, 117, 114, 108, 0, 0, 0, 6, SprAttributeBase.TYPE_SHADOW, 117, 98, 108, 105, 99, 0, 0, 0, 10, 115, 101, 116, 45, 99, 111, 111, 107, 105, 101, 0, 0, 0, 10, 107, 101, 101, SprAttributeBase.TYPE_SHADOW, 45, SprAttributeBase.TYPE_ANIMATOR_SET, 108, 105, 118, 101, 0, 0, 0, 6, 111, 114, 105, 103, 105, 110, 49, 48, 48, 49, 48, 49, CtapException.ERR_PIN_BLOCKED, 48, 49, CtapException.ERR_PIN_BLOCKED, 48, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_BLOCKED, 48, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_BLOCKED, 48, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_AUTH_INVALID, 48, 48, CtapException.ERR_PIN_AUTH_INVALID, 48, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, 48, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_INVALID, 48, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, 48, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_AUTH_INVALID, 48, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_AUTH_INVALID, 48, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_AUTH_BLOCKED, 48, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_BLOCKED, 48, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_AUTH_BLOCKED, 48, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_AUTH_BLOCKED, 48, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_AUTH_BLOCKED, 48, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_PIN_AUTH_BLOCKED, 48, CtapException.ERR_REQUEST_TOO_LARGE, CtapException.ERR_PIN_AUTH_BLOCKED, 49, 48, CtapException.ERR_PIN_AUTH_BLOCKED, 49, 49, CtapException.ERR_PIN_AUTH_BLOCKED, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_BLOCKED, 49, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, 49, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_AUTH_BLOCKED, 49, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_AUTH_BLOCKED, 49, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_AUTH_BLOCKED, 49, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_NOT_SET, 48, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_NOT_SET, 48, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, 48, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_BLOCKED, 48, CtapException.ERR_PIN_AUTH_INVALID, 32, 78, 111, 110, 45, 65, 117, 116, 104, 111, 114, 105, 116, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 105, 118, 101, 32, 73, 110, 102, 111, 114, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 105, 111, 110, CtapException.ERR_PIN_BLOCKED, 48, CtapException.ERR_PIN_AUTH_BLOCKED, 32, 78, 111, 32, 67, 111, 110, 116, 101, 110, 116, CtapException.ERR_PIN_AUTH_INVALID, 48, 49, 32, 77, 111, 118, 101, 100, 32, 80, 101, 114, 109, 
    SprAttributeBase.TYPE_ANIMATOR_SET, 110, 101, 110, 116, 108, 121, CtapException.ERR_PIN_AUTH_BLOCKED, 48, 48, 32, 66, SprAttributeBase.TYPE_ANIMATOR_SET, 100, 32, 82, 101, 113, 117, 101, 115, 116, CtapException.ERR_PIN_AUTH_BLOCKED, 48, 49, 32, 85, 110, SprAttributeBase.TYPE_ANIMATOR_SET, 117, 116, 104, 111, 114, 105, 122, 101, 100, CtapException.ERR_PIN_AUTH_BLOCKED, 48, CtapException.ERR_PIN_AUTH_INVALID, 32, 70, 111, 114, 98, 105, 100, 100, 101, 110, CtapException.ERR_PIN_AUTH_BLOCKED, 48, CtapException.ERR_PIN_AUTH_BLOCKED, 32, 78, 111, 116, 32, 70, 111, 117, 110, 100, CtapException.ERR_PIN_NOT_SET, 48, 48, 32, 73, 110, 116, 101, 114, 110, SprAttributeBase.TYPE_ANIMATOR_SET, 108, 32, 83, 101, 114, 118, 101, 114, 32, 69, 114, 114, 111, 114, CtapException.ERR_PIN_NOT_SET, 48, 49, 32, 78, 111, 116, 32, 73, 109, SprAttributeBase.TYPE_SHADOW, 108, 101, 109, 101, 110, 116, 101, 100, CtapException.ERR_PIN_NOT_SET, 48, CtapException.ERR_PIN_AUTH_INVALID, 32, 83, 101, 114, 118, 105, 99, 101, 32, 85, 110, SprAttributeBase.TYPE_ANIMATOR_SET, 118, SprAttributeBase.TYPE_ANIMATOR_SET, 105, 108, SprAttributeBase.TYPE_ANIMATOR_SET, 98, 108, 101, 74, SprAttributeBase.TYPE_ANIMATOR_SET, 110, 32, 70, 101, 98, 32, 77, SprAttributeBase.TYPE_ANIMATOR_SET, 114, 32, 65, SprAttributeBase.TYPE_SHADOW, 114, 32, 77, SprAttributeBase.TYPE_ANIMATOR_SET, 121, 32, 74, 117, 110, 32, 74, 117, 108, 32, 65, 117, 103, 32, 83, 101, SprAttributeBase.TYPE_SHADOW, 116, 32, 79, 99, 116, 32, 78, 111, 118, 32, 68, 101, 99, 32, 48, 48, 58, 48, 48, 58, 48, 48, 32, 77, 111, 110, 44, 32, 84, 117, 101, 44, 32, 87, 101, 100, 44, 32, 84, 104, 117, 44, 32, 70, 114, 105, 44, 32, 83, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 44, 32, 83, 117, 110, 44, 32, 71, 77, 84, 99, 104, 117, 110, 107, 101, 100, 44, 116, 101, 120, 116, 47, 104, 116, 109, 108, 44, 105, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 101, 47, SprAttributeBase.TYPE_SHADOW, 110, 103, 44, 105, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 101, 47, 106, SprAttributeBase.TYPE_SHADOW, 103, 44, 105, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 101, 47, 103, 105, 102, 44, SprAttributeBase.TYPE_ANIMATOR_SET, SprAttributeBase.TYPE_SHADOW, SprAttributeBase.TYPE_SHADOW, 108, 105, 99, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 105, 111, 110, 47, 120, 109, 108, 44, SprAttributeBase.TYPE_ANIMATOR_SET, SprAttributeBase.TYPE_SHADOW, SprAttributeBase.TYPE_SHADOW, 108, 105, 99, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 105, 111, 110, 47, 120, 104, 116, 109, 108, 43, 120, 109, 108, 44, 116, 101, 120, 116, 47, SprAttributeBase.TYPE_SHADOW, 108, SprAttributeBase.TYPE_ANIMATOR_SET, 105, 110, 44, 116, 101, 120, 116, 47, 106, SprAttributeBase.TYPE_ANIMATOR_SET, 118, SprAttributeBase.TYPE_ANIMATOR_SET, 115, 99, 114, 105, SprAttributeBase.TYPE_SHADOW, 116, 44, SprAttributeBase.TYPE_SHADOW, 117, 98, 108, 105, 99, SprAttributeBase.TYPE_SHADOW, 114, 105, 118, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 101, 109, SprAttributeBase.TYPE_ANIMATOR_SET, 120, 45, SprAttributeBase.TYPE_ANIMATOR_SET, 103, 101, 61, 103, 122, 105, SprAttributeBase.TYPE_SHADOW, 44, 100, 101, 102, 108, SprAttributeBase.TYPE_ANIMATOR_SET, 116, 101, 44, 115, 100, 99, 104, 99, 104, SprAttributeBase.TYPE_ANIMATOR_SET, 114, 115, 101, 116, 61, 117, 116, 102, 45, CtapException.ERR_PIN_TOKEN_EXPIRED, 99, 104, SprAttributeBase.TYPE_ANIMATOR_SET, 114, 115, 101, 116, 61, 105, 115, 111, 45, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_REQUEST_TOO_LARGE, 45, 49, 44, 117, 116, 102, 45, 44, 42, 44, 101, 110, 113, 61, 48, 46};
    static final byte SPDY_FLAG_FIN = 1;
    static final byte SPDY_FLAG_UNIDIRECTIONAL = 2;
    static final int SPDY_GOAWAY_FRAME = 7;
    static final int SPDY_HEADERS_FRAME = 8;
    static final int SPDY_HEADER_FLAGS_OFFSET = 4;
    static final int SPDY_HEADER_LENGTH_OFFSET = 5;
    static final int SPDY_HEADER_SIZE = 8;
    static final int SPDY_HEADER_TYPE_OFFSET = 2;
    static final int SPDY_MAX_LENGTH = 16777215;
    static final int SPDY_MAX_NV_LENGTH = 65535;
    static final int SPDY_PING_FRAME = 6;
    static final int SPDY_PUSH_PROMISE_FRAME = 5;
    static final int SPDY_RST_STREAM_FRAME = 3;
    static final int SPDY_SESSION_STREAM_ID = 0;
    static final byte SPDY_SETTINGS_CLEAR = 1;
    static final int SPDY_SETTINGS_FRAME = 4;
    static final int SPDY_SETTINGS_MAX_ID = 16777215;
    static final byte SPDY_SETTINGS_PERSISTED = 2;
    static final byte SPDY_SETTINGS_PERSIST_VALUE = 1;
    static final int SPDY_SYN_REPLY_FRAME = 2;
    static final int SPDY_SYN_STREAM_FRAME = 1;
    static final int SPDY_WINDOW_UPDATE_FRAME = 9;

    private SpdyCodecUtil() {
    }

    public static int getSignedInt(ByteBuf byteBuf, int i) {
        return (byteBuf.getByte(i + 3) & 255) | ((byteBuf.getByte(i) & 255) << 24) | ((byteBuf.getByte(i + 1) & 255) << 16) | ((byteBuf.getByte(i + 2) & 255) << 8);
    }

    public static int getUnsignedInt(ByteBuf byteBuf, int i) {
        return (byteBuf.getByte(i + 3) & 255) | ((byteBuf.getByte(i) & 127) << 24) | ((byteBuf.getByte(i + 1) & 255) << 16) | ((byteBuf.getByte(i + 2) & 255) << 8);
    }

    public static int getUnsignedMedium(ByteBuf byteBuf, int i) {
        return (byteBuf.getByte(i + 2) & 255) | ((byteBuf.getByte(i) & 255) << 16) | ((byteBuf.getByte(i + 1) & 255) << 8);
    }

    public static int getUnsignedShort(ByteBuf byteBuf, int i) {
        return (byteBuf.getByte(i + 1) & 255) | ((byteBuf.getByte(i) & 255) << 8);
    }

    public static boolean isServerId(int i) {
        return i % 2 == 0;
    }

    public static void validateHeaderName(CharSequence charSequence) {
        ObjectUtil.checkNonEmpty(charSequence, "name");
        if (charSequence.length() > 65535) {
            throw new IllegalArgumentException("name exceeds allowable length: " + ((Object) charSequence));
        }
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 0) {
                throw new IllegalArgumentException("name contains null character: " + ((Object) charSequence));
            }
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                throw new IllegalArgumentException("name must be all lower case.");
            }
            if (cCharAt > 127) {
                throw new IllegalArgumentException("name contains non-ascii character: " + ((Object) charSequence));
            }
        }
    }

    public static void validateHeaderValue(CharSequence charSequence) {
        ObjectUtil.checkNotNull(charSequence, "value");
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == 0) {
                throw new IllegalArgumentException("value contains null character");
            }
        }
    }
}
