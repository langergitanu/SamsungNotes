package okio.internal;

import androidx.glance.AbstractC2821a;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, m13886d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", TextConst.KEY_END_INDEX, "okio"}, m13887k = 2, m13888mv = {1, 4, 1})
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String commonAsUtf8ToByteArray) {
        int i;
        char cCharAt;
        Intrinsics.checkNotNullParameter(commonAsUtf8ToByteArray, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[commonAsUtf8ToByteArray.length() * 4];
        int length = commonAsUtf8ToByteArray.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = commonAsUtf8ToByteArray.charAt(i2);
            if (Intrinsics.compare((int) cCharAt2, 128) >= 0) {
                int length2 = commonAsUtf8ToByteArray.length();
                int i4 = i2;
                while (i2 < length2) {
                    char cCharAt3 = commonAsUtf8ToByteArray.charAt(i2);
                    if (Intrinsics.compare((int) cCharAt3, 128) < 0) {
                        int i5 = i4 + 1;
                        bArr[i4] = (byte) cCharAt3;
                        i2++;
                        while (i2 < length2 && Intrinsics.compare((int) commonAsUtf8ToByteArray.charAt(i2), 128) < 0) {
                            bArr[i5] = (byte) commonAsUtf8ToByteArray.charAt(i2);
                            i2++;
                            i5++;
                        }
                        i4 = i5;
                    } else {
                        if (Intrinsics.compare((int) cCharAt3, 2048) < 0) {
                            bArr[i4] = (byte) ((cCharAt3 >> 6) | 192);
                            i4 += 2;
                            bArr[i4 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            bArr[i4] = (byte) ((cCharAt3 >> '\f') | JPEG.APP0);
                            bArr[i4 + 1] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            i4 += 3;
                            bArr[i4 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (Intrinsics.compare((int) cCharAt3, 56319) > 0 || length2 <= (i = i2 + 1) || 56320 > (cCharAt = commonAsUtf8ToByteArray.charAt(i)) || 57343 < cCharAt) {
                            bArr[i4] = Utf8.REPLACEMENT_BYTE;
                            i2++;
                            i4++;
                        } else {
                            int iCharAt = (commonAsUtf8ToByteArray.charAt(i) + (cCharAt3 << '\n')) - 56613888;
                            bArr[i4] = (byte) ((iCharAt >> 18) | 240);
                            bArr[i4 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i4 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i4 += 4;
                            bArr[i4 + 3] = (byte) ((iCharAt & 63) | 128);
                            i2 += 2;
                        }
                        i2++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i4);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i2] = (byte) cCharAt2;
            i2++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, commonAsUtf8ToByteArray.length());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] commonToUtf8String, int i, int i2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        Intrinsics.checkNotNullParameter(commonToUtf8String, "$this$commonToUtf8String");
        if (i9 < 0 || i2 > commonToUtf8String.length || i9 > i2) {
            StringBuilder sb = new StringBuilder("size=");
            AbstractC2821a.m2235z(sb, commonToUtf8String.length, i9, " beginIndex=", " endIndex=");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        char[] cArr = new char[i2 - i9];
        int i10 = 0;
        while (i9 < i2) {
            byte b = commonToUtf8String[i9];
            if (b >= 0) {
                i4 = i10 + 1;
                cArr[i10] = (char) b;
                i9++;
                while (i9 < i2) {
                    byte b5 = commonToUtf8String[i9];
                    if (b5 < 0) {
                        break;
                    }
                    i9++;
                    cArr[i4] = (char) b5;
                    i4++;
                }
            } else {
                if ((b >> 5) == -2) {
                    int i11 = i9 + 1;
                    if (i2 <= i11) {
                        i4 = i10 + 1;
                        cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    } else {
                        byte b6 = commonToUtf8String[i11];
                        if ((b6 & 192) == 128) {
                            int i12 = (b << 6) ^ (b6 ^ 3968);
                            if (i12 < 128) {
                                i4 = i10 + 1;
                                cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else {
                                i4 = i10 + 1;
                                cArr[i10] = (char) i12;
                            }
                            Unit unit = Unit.INSTANCE;
                        } else {
                            i4 = i10 + 1;
                            cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                } else if ((b >> 4) == -2) {
                    int i13 = i9 + 2;
                    if (i2 <= i13) {
                        i4 = i10 + 1;
                        cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        Unit unit3 = Unit.INSTANCE;
                        int i14 = i9 + 1;
                        i5 = (i2 <= i14 || (commonToUtf8String[i14] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b7 = commonToUtf8String[i9 + 1];
                        if ((b7 & 192) == 128) {
                            byte b8 = commonToUtf8String[i13];
                            if ((b8 & 192) == 128) {
                                int i15 = (b << 12) ^ ((b8 ^ (-123008)) ^ (b7 << 6));
                                if (i15 < 2048) {
                                    i4 = i10 + 1;
                                    cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                } else if (55296 <= i15 && 57343 >= i15) {
                                    i4 = i10 + 1;
                                    cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                } else {
                                    i4 = i10 + 1;
                                    cArr[i10] = (char) i15;
                                }
                                Unit unit4 = Unit.INSTANCE;
                                i5 = 3;
                            } else {
                                i4 = i10 + 1;
                                cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                Unit unit5 = Unit.INSTANCE;
                            }
                        } else {
                            i4 = i10 + 1;
                            cArr[i10] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            Unit unit6 = Unit.INSTANCE;
                        }
                    }
                } else {
                    if ((b >> 3) == -2) {
                        int i16 = i9 + 3;
                        if (i2 <= i16) {
                            i6 = i10 + 1;
                            cArr[i10] = 65533;
                            Unit unit7 = Unit.INSTANCE;
                            int i17 = i9 + 1;
                            if (i2 > i17 && (commonToUtf8String[i17] & 192) == 128) {
                                int i18 = i9 + 2;
                                i8 = (i2 <= i18 || (commonToUtf8String[i18] & 192) != 128) ? 2 : 3;
                            }
                            i8 = 1;
                        } else {
                            byte b9 = commonToUtf8String[i9 + 1];
                            if ((b9 & 192) == 128) {
                                byte b10 = commonToUtf8String[i9 + 2];
                                if ((b10 & 192) == 128) {
                                    byte b11 = commonToUtf8String[i16];
                                    if ((b11 & 192) == 128) {
                                        int i19 = (b << 18) ^ (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12));
                                        if (i19 > 1114111) {
                                            i6 = i10 + 1;
                                            cArr[i10] = 65533;
                                        } else if ((55296 <= i19 && 57343 >= i19) || i19 < 65536) {
                                            i6 = i10 + 1;
                                            cArr[i10] = 65533;
                                        } else {
                                            if (i19 != 65533) {
                                                cArr[i10] = (char) ((i19 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                i7 = i10 + 2;
                                                cArr[i10 + 1] = (char) ((i19 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                            } else {
                                                cArr[i10] = 65533;
                                                i7 = i10 + 1;
                                            }
                                            Unit unit8 = Unit.INSTANCE;
                                            i6 = i7;
                                            i8 = 4;
                                        }
                                        Unit unit9 = Unit.INSTANCE;
                                        i8 = 4;
                                    } else {
                                        i6 = i10 + 1;
                                        cArr[i10] = 65533;
                                        Unit unit10 = Unit.INSTANCE;
                                    }
                                } else {
                                    i6 = i10 + 1;
                                    cArr[i10] = 65533;
                                    Unit unit11 = Unit.INSTANCE;
                                }
                            } else {
                                i6 = i10 + 1;
                                cArr[i10] = 65533;
                                Unit unit12 = Unit.INSTANCE;
                                i8 = 1;
                            }
                        }
                        i9 += i8;
                    } else {
                        i6 = i10 + 1;
                        cArr[i10] = 65533;
                        i9++;
                    }
                    i10 = i6;
                }
                i9 += i5;
            }
            i10 = i4;
        }
        return new String(cArr, 0, i10);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
