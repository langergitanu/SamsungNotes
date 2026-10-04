package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0007*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\n"}, m13886d2 = {"BASE64", "", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, m13887k = 2, m13888mv = {1, 4, 1})
@JvmName(name = "-Base64")
public final class Base64 {

    @NotNull
    private static final byte[] BASE64;

    @NotNull
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String decodeBase64ToArray) {
        int i;
        char cCharAt;
        Intrinsics.checkNotNullParameter(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((cCharAt = decodeBase64ToArray.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i2 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i2];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt2 = decodeBase64ToArray.charAt(i7);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i5 = (i5 << 6) | i;
            i4++;
            if (i4 % 4 == 0) {
                bArr[i6] = (byte) (i5 >> 16);
                int i8 = i6 + 2;
                bArr[i6 + 1] = (byte) (i5 >> 8);
                i6 += 3;
                bArr[i8] = (byte) i5;
            }
        }
        int i9 = i4 % 4;
        if (i9 == 1) {
            return null;
        }
        if (i9 == 2) {
            bArr[i6] = (byte) ((i5 << 12) >> 16);
            i6++;
        } else if (i9 == 3) {
            int i10 = i5 << 6;
            int i11 = i6 + 1;
            bArr[i6] = (byte) (i10 >> 16);
            i6 += 2;
            bArr[i11] = (byte) (i10 >> 8);
        }
        if (i6 == i2) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i6);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] encodeBase64, @NotNull byte[] map) {
        Intrinsics.checkNotNullParameter(encodeBase64, "$this$encodeBase64");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = encodeBase64[i];
            int i4 = i + 2;
            byte b5 = encodeBase64[i + 1];
            i += 3;
            byte b6 = encodeBase64[i4];
            bArr[i2] = map[(b & 255) >> 2];
            bArr[i2 + 1] = map[((b & 3) << 4) | ((b5 & 255) >> 4)];
            int i5 = i2 + 3;
            bArr[i2 + 2] = map[((b5 & 15) << 2) | ((b6 & 255) >> 6)];
            i2 += 4;
            bArr[i5] = map[b6 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b7 = encodeBase64[i];
            bArr[i2] = map[(b7 & 255) >> 2];
            bArr[i2 + 1] = map[(b7 & 3) << 4];
            byte b8 = (byte) 61;
            bArr[i2 + 2] = b8;
            bArr[i2 + 3] = b8;
        } else if (length2 == 2) {
            int i6 = i + 1;
            byte b9 = encodeBase64[i];
            byte b10 = encodeBase64[i6];
            bArr[i2] = map[(b9 & 255) >> 2];
            bArr[i2 + 1] = map[((b9 & 3) << 4) | ((b10 & 255) >> 4)];
            bArr[i2 + 2] = map[(b10 & 15) << 2];
            bArr[i2 + 3] = (byte) 61;
        }
        return Platform.toUtf8String(bArr);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
