package okio.internal;

import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.yubico.yubikit.core.fido.CtapException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0080\b\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\u0015\u0010\u0012\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0080\b\u001a\u000f\u0010\u0014\u001a\u0004\u0018\u00010\n*\u00020\u0010H\u0080\b\u001a\r\u0010\u0015\u001a\u00020\n*\u00020\u0010H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\n*\u00020\u0010H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0080\b\u001a\u0017\u0010\u001a\u001a\u00020\u0018*\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0005*\u00020\nH\u0080\b\u001a\r\u0010 \u001a\u00020\u0005*\u00020\nH\u0080\b\u001a\r\u0010!\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\u001d\u0010\"\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a\r\u0010$\u001a\u00020\u0007*\u00020\nH\u0080\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0080\b\u001a\u001d\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0080\b\u001a\r\u0010/\u001a\u00020\n*\u00020\nH\u0080\b\u001a\r\u00100\u001a\u00020\n*\u00020\nH\u0080\b\u001a\r\u00101\u001a\u00020\u0007*\u00020\nH\u0080\b\u001a\u001d\u00102\u001a\u00020\n*\u00020\u00072\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a\r\u00103\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a$\u00105\u001a\u000206*\u00020\n2\u0006\u00107\u001a\u0002082\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u00069"}, m13886d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", TypedValues.Cycle.S_WAVE_OFFSET, "otherOffset", "byteCount", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", TextConst.KEY_END_INDEX, "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "", "buffer", "Lokio/Buffer;", "okio"}, m13887k = 2, m13888mv = {1, 4, 1})
public final class ByteStringKt {

    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x010d, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x01ae, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005d, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x009d, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int codePointIndexToCharIndex(byte[] bArr, int i) {
        byte b;
        int i2;
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            if (i4 >= length) {
                break;
            }
            byte b5 = bArr[i4];
            if (b5 >= 0) {
                int i7 = i6 + 1;
                if (i6 != i) {
                    if ((b5 != 10 && b5 != 13 && ((b5 >= 0 && 31 >= b5) || (127 <= b5 && 159 >= b5))) || b5 == 65533) {
                        break;
                    }
                    i5 += b5 < 65536 ? 1 : 2;
                    i4++;
                    while (true) {
                        i6 = i7;
                        if (i4 < length && (b = bArr[i4]) >= 0) {
                            i4++;
                            i7 = i6 + 1;
                            if (i6 != i) {
                                if ((b != 10 && b != 13 && ((b >= 0 && 31 >= b) || (127 <= b && 159 >= b))) || b == 65533) {
                                    break loop0;
                                }
                                i5 += b < 65536 ? 1 : 2;
                            } else {
                                return i5;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            } else if ((b5 >> 5) == -2) {
                int i8 = i4 + 1;
                if (length <= i8) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                byte b6 = bArr[i8];
                if ((b6 & 192) != 128) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                int i9 = (b5 << 6) ^ (b6 ^ 3968);
                if (i9 >= 128) {
                    int i10 = i6 + 1;
                    if (i6 != i) {
                        if ((i9 != 10 && i9 != 13 && ((i9 >= 0 && 31 >= i9) || (127 <= i9 && 159 >= i9))) || i9 == 65533) {
                            break;
                        }
                        i5 += i9 < 65536 ? 1 : 2;
                        Unit unit = Unit.INSTANCE;
                        i4 += 2;
                        i6 = i10;
                    } else {
                        break;
                    }
                } else {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
            } else if ((b5 >> 4) == -2) {
                int i11 = i4 + 2;
                if (length <= i11) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                byte b7 = bArr[i4 + 1];
                if ((b7 & 192) != 128) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                byte b8 = bArr[i11];
                if ((b8 & 192) != 128) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                int i12 = (b5 << 12) ^ ((b8 ^ (-123008)) ^ (b7 << 6));
                if (i12 >= 2048) {
                    if (55296 > i12 || 57343 < i12) {
                        i2 = i6 + 1;
                        if (i6 != i) {
                            if ((i12 != 10 && i12 != 13 && ((i12 >= 0 && 31 >= i12) || (127 <= i12 && 159 >= i12))) || i12 == 65533) {
                                break;
                            }
                            i5 += i12 < 65536 ? 1 : 2;
                            Unit unit2 = Unit.INSTANCE;
                            i4 += 3;
                            i6 = i2;
                        } else {
                            break;
                        }
                    } else {
                        if (i6 == i) {
                            break;
                        }
                        return -1;
                    }
                } else {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
            } else {
                if ((b5 >> 3) != -2) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                int i13 = i4 + 3;
                if (length <= i13) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                byte b9 = bArr[i4 + 1];
                if ((b9 & 192) != 128) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                byte b10 = bArr[i4 + 2];
                if ((b10 & 192) != 128) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                byte b11 = bArr[i13];
                if ((b11 & 192) != 128) {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
                int i14 = (b5 << 18) ^ (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12));
                if (i14 <= 1114111) {
                    if (55296 > i14 || 57343 < i14) {
                        if (i14 >= 65536) {
                            i2 = i6 + 1;
                            if (i6 != i) {
                                if ((i14 != 10 && i14 != 13 && ((i14 >= 0 && 31 >= i14) || (127 <= i14 && 159 >= i14))) || i14 == 65533) {
                                    break;
                                }
                                i5 += i14 < 65536 ? 1 : 2;
                                Unit unit3 = Unit.INSTANCE;
                                i4 += 4;
                                i6 = i2;
                            } else {
                                break;
                            }
                        } else {
                            if (i6 == i) {
                                break;
                            }
                            return -1;
                        }
                    } else {
                        if (i6 == i) {
                            break;
                        }
                        return -1;
                    }
                } else {
                    if (i6 == i) {
                        break;
                    }
                    return -1;
                }
            }
        }
        return -1;
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString commonBase64) {
        Intrinsics.checkNotNullParameter(commonBase64, "$this$commonBase64");
        return Base64.encodeBase64$default(commonBase64.getData(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString commonBase64Url) {
        Intrinsics.checkNotNullParameter(commonBase64Url, "$this$commonBase64Url");
        return Base64.encodeBase64(commonBase64Url.getData(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString commonCompareTo, @NotNull ByteString other) {
        Intrinsics.checkNotNullParameter(commonCompareTo, "$this$commonCompareTo");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = commonCompareTo.size();
        int size2 = other.size();
        int iMin = Math.min(size, size2);
        for (int i = 0; i < iMin; i++) {
            int i2 = commonCompareTo.getByte(i) & 255;
            int i4 = other.getByte(i) & 255;
            if (i2 != i4) {
                return i2 < i4 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String commonDecodeBase64) {
        Intrinsics.checkNotNullParameter(commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(commonDecodeBase64);
        if (bArrDecodeBase64ToArray != null) {
            return new ByteString(bArrDecodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String commonDecodeHex) {
        Intrinsics.checkNotNullParameter(commonDecodeHex, "$this$commonDecodeHex");
        if (!(commonDecodeHex.length() % 2 == 0)) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(commonDecodeHex).toString());
        }
        int length = commonDecodeHex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (decodeHexDigit(commonDecodeHex.charAt(i2 + 1)) + (decodeHexDigit(commonDecodeHex.charAt(i2)) << 4));
        }
        return new ByteString(bArr);
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String commonEncodeUtf8) {
        Intrinsics.checkNotNullParameter(commonEncodeUtf8, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(commonEncodeUtf8));
        byteString.setUtf8$okio(commonEncodeUtf8);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString commonEndsWith, @NotNull ByteString suffix) {
        Intrinsics.checkNotNullParameter(commonEndsWith, "$this$commonEndsWith");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@NotNull ByteString commonEquals, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.getData().length && byteString.rangeEquals(0, commonEquals.getData(), 0, commonEquals.getData().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString commonGetByte, int i) {
        Intrinsics.checkNotNullParameter(commonGetByte, "$this$commonGetByte");
        return commonGetByte.getData()[i];
    }

    public static final int commonGetSize(@NotNull ByteString commonGetSize) {
        Intrinsics.checkNotNullParameter(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getData().length;
    }

    public static final int commonHashCode(@NotNull ByteString commonHashCode) {
        Intrinsics.checkNotNullParameter(commonHashCode, "$this$commonHashCode");
        int hashCode = commonHashCode.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(commonHashCode.getData());
        commonHashCode.setHashCode$okio(iHashCode);
        return iHashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString commonHex) {
        Intrinsics.checkNotNullParameter(commonHex, "$this$commonHex");
        char[] cArr = new char[commonHex.getData().length * 2];
        int i = 0;
        for (byte b : commonHex.getData()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@NotNull ByteString commonIndexOf, @NotNull byte[] other, int i) {
        Intrinsics.checkNotNullParameter(commonIndexOf, "$this$commonIndexOf");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = commonIndexOf.getData().length - other.length;
        int iMax = Math.max(i, 0);
        if (iMax > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(commonIndexOf.getData(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString commonInternalArray) {
        Intrinsics.checkNotNullParameter(commonInternalArray, "$this$commonInternalArray");
        return commonInternalArray.getData();
    }

    public static final int commonLastIndexOf(@NotNull ByteString commonLastIndexOf, @NotNull ByteString other, int i) {
        Intrinsics.checkNotNullParameter(commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.checkNotNullParameter(other, "other");
        return commonLastIndexOf.lastIndexOf(other.internalArray$okio(), i);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(bArrCopyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString commonRangeEquals, int i, @NotNull ByteString other, int i2, int i4) {
        Intrinsics.checkNotNullParameter(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(i2, commonRangeEquals.getData(), i, i4);
    }

    public static final boolean commonStartsWith(@NotNull ByteString commonStartsWith, @NotNull ByteString prefix) {
        Intrinsics.checkNotNullParameter(commonStartsWith, "$this$commonStartsWith");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString commonSubstring, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonSubstring, "$this$commonSubstring");
        if (!(i >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (!(i2 <= commonSubstring.getData().length)) {
            throw new IllegalArgumentException(AbstractC0000a.m13j(new StringBuilder("endIndex > length("), commonSubstring.getData().length, PropertyUtils.MAPPED_DELIM2).toString());
        }
        if (i2 - i >= 0) {
            return (i == 0 && i2 == commonSubstring.getData().length) ? commonSubstring : new ByteString(ArraysKt.copyOfRange(commonSubstring.getData(), i, i2));
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString commonToAsciiLowercase) {
        byte b;
        Intrinsics.checkNotNullParameter(commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        for (int i = 0; i < commonToAsciiLowercase.getData().length; i++) {
            byte b5 = commonToAsciiLowercase.getData()[i];
            byte b6 = (byte) 65;
            if (b5 >= b6 && b5 <= (b = (byte) 90)) {
                byte[] data = commonToAsciiLowercase.getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b5 + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b7 = bArrCopyOf[i2];
                    if (b7 >= b6 && b7 <= b) {
                        bArrCopyOf[i2] = (byte) (b7 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return commonToAsciiLowercase;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString commonToAsciiUppercase) {
        byte b;
        Intrinsics.checkNotNullParameter(commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        for (int i = 0; i < commonToAsciiUppercase.getData().length; i++) {
            byte b5 = commonToAsciiUppercase.getData()[i];
            byte b6 = (byte) 97;
            if (b5 >= b6 && b5 <= (b = (byte) 122)) {
                byte[] data = commonToAsciiUppercase.getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b5 + CtapException.ERR_EXTENSION_FIRST);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b7 = bArrCopyOf[i2];
                    if (b7 >= b6 && b7 <= b) {
                        bArrCopyOf[i2] = (byte) (b7 + CtapException.ERR_EXTENSION_FIRST);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return commonToAsciiUppercase;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString commonToByteArray) {
        Intrinsics.checkNotNullParameter(commonToByteArray, "$this$commonToByteArray");
        byte[] data = commonToByteArray.getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] commonToByteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonToByteString, "$this$commonToByteString");
        Util.checkOffsetAndCount(commonToByteString.length, i, i2);
        return new ByteString(ArraysKt.copyOfRange(commonToByteString, i, i2 + i));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString commonToString) {
        Intrinsics.checkNotNullParameter(commonToString, "$this$commonToString");
        if (commonToString.getData().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = codePointIndexToCharIndex(commonToString.getData(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strUtf8 = commonToString.utf8();
            if (strUtf8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String strM14139M = StringsKt.m14139M(StringsKt.m14139M(StringsKt.m14139M(strSubstring, "\\", "\\\\"), "\n", "\\n"), StringUtils.f9761CR, "\\r");
            if (iCodePointIndexToCharIndex >= strUtf8.length()) {
                return AbstractC1974b.m1315h(PropertyUtils.INDEXED_DELIM2, "[text=", strM14139M);
            }
            return "[size=" + commonToString.getData().length + " text=" + strM14139M + "…]";
        }
        if (commonToString.getData().length <= 64) {
            return "[hex=" + commonToString.hex() + PropertyUtils.INDEXED_DELIM2;
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(commonToString.getData().length);
        sb.append(" hex=");
        if (64 > commonToString.getData().length) {
            throw new IllegalArgumentException(AbstractC0000a.m13j(new StringBuilder("endIndex > length("), commonToString.getData().length, PropertyUtils.MAPPED_DELIM2).toString());
        }
        if (64 != commonToString.getData().length) {
            commonToString = new ByteString(ArraysKt.copyOfRange(commonToString.getData(), 0, 64));
        }
        sb.append(commonToString.hex());
        sb.append("…]");
        return sb.toString();
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString commonUtf8) {
        Intrinsics.checkNotNullParameter(commonUtf8, "$this$commonUtf8");
        String utf8 = commonUtf8.getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = Platform.toUtf8String(commonUtf8.internalArray$okio());
        commonUtf8.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@NotNull ByteString commonWrite, @NotNull Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(commonWrite, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(commonWrite.getData(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int decodeHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return c - 'W';
        }
        if ('A' <= c && 'F' >= c) {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@NotNull ByteString commonEndsWith, @NotNull byte[] suffix) {
        Intrinsics.checkNotNullParameter(commonEndsWith, "$this$commonEndsWith");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString commonLastIndexOf, @NotNull byte[] other, int i) {
        Intrinsics.checkNotNullParameter(commonLastIndexOf, "$this$commonLastIndexOf");
        Intrinsics.checkNotNullParameter(other, "other");
        for (int iMin = Math.min(i, commonLastIndexOf.getData().length - other.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(commonLastIndexOf.getData(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull ByteString commonRangeEquals, int i, @NotNull byte[] other, int i2, int i4) {
        Intrinsics.checkNotNullParameter(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(other, "other");
        return i >= 0 && i <= commonRangeEquals.getData().length - i4 && i2 >= 0 && i2 <= other.length - i4 && Util.arrayRangeEquals(commonRangeEquals.getData(), i, other, i2, i4);
    }

    public static final boolean commonStartsWith(@NotNull ByteString commonStartsWith, @NotNull byte[] prefix) {
        Intrinsics.checkNotNullParameter(commonStartsWith, "$this$commonStartsWith");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }
}
