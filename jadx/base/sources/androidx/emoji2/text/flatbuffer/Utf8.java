package androidx.emoji2.text.flatbuffer;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DecodeUtil {
        public static void handleFourBytes(byte b, byte b5, byte b6, byte b7, char[] cArr, int i) {
            if (!isNotTrailingByte(b5)) {
                if ((((b5 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0 && !isNotTrailingByte(b6) && !isNotTrailingByte(b7)) {
                    int iTrailingByteValue = ((b & 7) << 18) | (trailingByteValue(b5) << 12) | (trailingByteValue(b6) << 6) | trailingByteValue(b7);
                    cArr[i] = highSurrogate(iTrailingByteValue);
                    cArr[i + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleOneByte(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        public static void handleThreeBytes(byte b, byte b5, byte b6, char[] cArr, int i) {
            if (isNotTrailingByte(b5) || ((b == -32 && b5 < -96) || ((b == -19 && b5 >= -96) || isNotTrailingByte(b6)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i] = (char) (((b & 15) << 12) | (trailingByteValue(b5) << 6) | trailingByteValue(b6));
        }

        public static void handleTwoBytes(byte b, byte b5, char[] cArr, int i) {
            if (b < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (isNotTrailingByte(b5)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i] = (char) (((b & 31) << 6) | trailingByteValue(b5));
        }

        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int trailingByteValue(byte b) {
            return b & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i2) {
            super(AbstractC1038a.m1214o(i, i2, "Unpaired surrogate at index ", " of "));
        }
    }

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i, int i2);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
