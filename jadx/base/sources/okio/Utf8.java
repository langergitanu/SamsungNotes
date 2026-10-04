package okio;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13884bv = {1, 0, 3}, m13885d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, m13886d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", TextConst.KEY_END_INDEX, "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, m13887k = 2, m13888mv = {1, 4, 1})
@JvmName(name = "Utf8")
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        if (i < 0 || 31 < i) {
            return 127 <= i && 159 >= i;
        }
        return true;
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] process2Utf8Bytes, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        Intrinsics.checkNotNullParameter(process2Utf8Bytes, "$this$process2Utf8Bytes");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i4 = i + 1;
        if (i2 <= i4) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b = process2Utf8Bytes[i];
        byte b5 = process2Utf8Bytes[i4];
        if ((b5 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        int i5 = (b5 ^ 3968) ^ (b << 6);
        if (i5 < 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        yield.invoke(Integer.valueOf(i5));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] process3Utf8Bytes, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        Intrinsics.checkNotNullParameter(process3Utf8Bytes, "$this$process3Utf8Bytes");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i4 = i + 2;
        if (i2 <= i4) {
            yield.invoke(numValueOf);
            int i5 = i + 1;
            return (i2 <= i5 || (process3Utf8Bytes[i5] & 192) != 128) ? 1 : 2;
        }
        byte b = process3Utf8Bytes[i];
        byte b5 = process3Utf8Bytes[i + 1];
        if ((b5 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b6 = process3Utf8Bytes[i4];
        if ((b6 & 192) != 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        int i6 = ((b6 ^ (-123008)) ^ (b5 << 6)) ^ (b << 12);
        if (i6 < 2048) {
            yield.invoke(numValueOf);
            return 3;
        }
        if (55296 <= i6 && 57343 >= i6) {
            yield.invoke(numValueOf);
            return 3;
        }
        yield.invoke(Integer.valueOf(i6));
        return 3;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] process4Utf8Bytes, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        Intrinsics.checkNotNullParameter(process4Utf8Bytes, "$this$process4Utf8Bytes");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i4 = i + 3;
        if (i2 <= i4) {
            yield.invoke(numValueOf);
            int i5 = i + 1;
            if (i2 <= i5 || (process4Utf8Bytes[i5] & 192) != 128) {
                return 1;
            }
            int i6 = i + 2;
            return (i2 <= i6 || (process4Utf8Bytes[i6] & 192) != 128) ? 2 : 3;
        }
        byte b = process4Utf8Bytes[i];
        byte b5 = process4Utf8Bytes[i + 1];
        if ((b5 & 192) != 128) {
            yield.invoke(numValueOf);
            return 1;
        }
        byte b6 = process4Utf8Bytes[i + 2];
        if ((b6 & 192) != 128) {
            yield.invoke(numValueOf);
            return 2;
        }
        byte b7 = process4Utf8Bytes[i4];
        if ((b7 & 192) != 128) {
            yield.invoke(numValueOf);
            return 3;
        }
        int i7 = (((b7 ^ 3678080) ^ (b6 << 6)) ^ (b5 << 12)) ^ (b << 18);
        if (i7 > 1114111) {
            yield.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i7 && 57343 >= i7) {
            yield.invoke(numValueOf);
            return 4;
        }
        if (i7 < 65536) {
            yield.invoke(numValueOf);
            return 4;
        }
        yield.invoke(Integer.valueOf(i7));
        return 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf16Chars(@NotNull byte[] processUtf16Chars, int i, int i2, @NotNull Function1<? super Character, Unit> yield) {
        Intrinsics.checkNotNullParameter(processUtf16Chars, "$this$processUtf16Chars");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            byte b = processUtf16Chars[i];
            if (b >= 0) {
                yield.invoke(Character.valueOf((char) b));
                i++;
                while (i < i2) {
                    byte b5 = processUtf16Chars[i];
                    if (b5 >= 0) {
                        i++;
                        yield.invoke(Character.valueOf((char) b5));
                    }
                }
            } else {
                int i4 = 2;
                if ((b >> 5) == -2) {
                    int i5 = i + 1;
                    if (i2 > i5) {
                        byte b6 = processUtf16Chars[i5];
                        if ((b6 & 192) == 128) {
                            int i6 = (b << 6) ^ (b6 ^ 3968);
                            yield.invoke(Character.valueOf(i6 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i6));
                            Unit unit = Unit.INSTANCE;
                            i += i4;
                        }
                    }
                    yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    Unit unit2 = Unit.INSTANCE;
                    i4 = 1;
                    i += i4;
                } else if ((b >> 4) == -2) {
                    int i7 = i + 2;
                    if (i2 <= i7) {
                        yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        Unit unit3 = Unit.INSTANCE;
                        int i8 = i + 1;
                        if (i2 <= i8 || (processUtf16Chars[i8] & 192) != 128) {
                            i4 = 1;
                        }
                        i += i4;
                    } else {
                        byte b7 = processUtf16Chars[i + 1];
                        if ((b7 & 192) == 128) {
                            byte b8 = processUtf16Chars[i7];
                            if ((b8 & 192) == 128) {
                                int i9 = (b << 12) ^ ((b8 ^ (-123008)) ^ (b7 << 6));
                                yield.invoke(Character.valueOf((i9 >= 2048 && (55296 > i9 || 57343 < i9)) ? (char) i9 : (char) REPLACEMENT_CODE_POINT));
                                Unit unit4 = Unit.INSTANCE;
                                i4 = 3;
                                i += i4;
                            } else {
                                yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                Unit unit5 = Unit.INSTANCE;
                                i += i4;
                            }
                        } else {
                            yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            Unit unit6 = Unit.INSTANCE;
                            i4 = 1;
                            i += i4;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i10 = i + 3;
                    if (i2 <= i10) {
                        yield.invoke((char) 65533);
                        Unit unit7 = Unit.INSTANCE;
                        int i11 = i + 1;
                        if (i2 > i11 && (processUtf16Chars[i11] & 192) == 128) {
                            int i12 = i + 2;
                            if (i2 > i12 && (processUtf16Chars[i12] & 192) == 128) {
                                i4 = 3;
                            }
                        }
                        i += i4;
                    } else {
                        byte b9 = processUtf16Chars[i + 1];
                        if ((b9 & 192) == 128) {
                            byte b10 = processUtf16Chars[i + 2];
                            if ((b10 & 192) == 128) {
                                byte b11 = processUtf16Chars[i10];
                                if ((b11 & 192) == 128) {
                                    int i13 = (b << 18) ^ (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12));
                                    if (i13 <= 1114111 && ((55296 > i13 || 57343 < i13) && i13 >= 65536 && i13 != 65533)) {
                                        yield.invoke(Character.valueOf((char) ((i13 >>> 10) + HIGH_SURROGATE_HEADER)));
                                        yield.invoke(Character.valueOf((char) ((i13 & 1023) + LOG_SURROGATE_HEADER)));
                                    } else {
                                        yield.invoke((char) 65533);
                                    }
                                    Unit unit8 = Unit.INSTANCE;
                                    i4 = 4;
                                } else {
                                    yield.invoke((char) 65533);
                                    Unit unit9 = Unit.INSTANCE;
                                    i4 = 3;
                                }
                            } else {
                                yield.invoke((char) 65533);
                                Unit unit10 = Unit.INSTANCE;
                            }
                            i += i4;
                        } else {
                            yield.invoke((char) 65533);
                            Unit unit11 = Unit.INSTANCE;
                            i4 = 1;
                            i += i4;
                        }
                    }
                } else {
                    yield.invoke((char) 65533);
                    i++;
                }
            }
        }
    }

    public static final void processUtf8Bytes(@NotNull String processUtf8Bytes, int i, int i2, @NotNull Function1<? super Byte, Unit> yield) {
        int i4;
        char cCharAt;
        Intrinsics.checkNotNullParameter(processUtf8Bytes, "$this$processUtf8Bytes");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            char cCharAt2 = processUtf8Bytes.charAt(i);
            if (Intrinsics.compare((int) cCharAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) cCharAt2));
                i++;
                while (i < i2 && Intrinsics.compare((int) processUtf8Bytes.charAt(i), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) processUtf8Bytes.charAt(i)));
                    i++;
                }
            } else {
                if (Intrinsics.compare((int) cCharAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | 192)));
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || 57343 < cCharAt2) {
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | JPEG.APP0)));
                    yield.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (Intrinsics.compare((int) cCharAt2, 56319) > 0 || i2 <= (i4 = i + 1) || 56320 > (cCharAt = processUtf8Bytes.charAt(i4)) || 57343 < cCharAt) {
                    yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = (processUtf8Bytes.charAt(i4) + (cCharAt2 << '\n')) - 56613888;
                    yield.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    yield.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i += 2;
                }
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf8CodePoints(@NotNull byte[] processUtf8CodePoints, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        Intrinsics.checkNotNullParameter(processUtf8CodePoints, "$this$processUtf8CodePoints");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            byte b = processUtf8CodePoints[i];
            if (b >= 0) {
                yield.invoke(Integer.valueOf(b));
                i++;
                while (i < i2) {
                    byte b5 = processUtf8CodePoints[i];
                    if (b5 >= 0) {
                        i++;
                        yield.invoke(Integer.valueOf(b5));
                    }
                }
            } else {
                int i4 = 2;
                if ((b >> 5) == -2) {
                    int i5 = i + 1;
                    if (i2 > i5) {
                        byte b6 = processUtf8CodePoints[i5];
                        if ((b6 & 192) == 128) {
                            int i6 = (b << 6) ^ (b6 ^ 3968);
                            if (i6 < 128) {
                                yield.invoke(numValueOf);
                            } else {
                                yield.invoke(Integer.valueOf(i6));
                            }
                            Unit unit = Unit.INSTANCE;
                            i += i4;
                        }
                    }
                    yield.invoke(numValueOf);
                    Unit unit2 = Unit.INSTANCE;
                    i4 = 1;
                    i += i4;
                } else if ((b >> 4) == -2) {
                    int i7 = i + 2;
                    if (i2 <= i7) {
                        yield.invoke(numValueOf);
                        Unit unit3 = Unit.INSTANCE;
                        int i8 = i + 1;
                        if (i2 <= i8 || (processUtf8CodePoints[i8] & 192) != 128) {
                            i4 = 1;
                        }
                        i += i4;
                    } else {
                        byte b7 = processUtf8CodePoints[i + 1];
                        if ((b7 & 192) == 128) {
                            byte b8 = processUtf8CodePoints[i7];
                            if ((b8 & 192) == 128) {
                                int i9 = (b << 12) ^ ((b8 ^ (-123008)) ^ (b7 << 6));
                                if (i9 >= 2048 && (55296 > i9 || 57343 < i9)) {
                                    yield.invoke(Integer.valueOf(i9));
                                } else {
                                    yield.invoke(numValueOf);
                                }
                                Unit unit4 = Unit.INSTANCE;
                                i4 = 3;
                                i += i4;
                            } else {
                                yield.invoke(numValueOf);
                                Unit unit5 = Unit.INSTANCE;
                                i += i4;
                            }
                        } else {
                            yield.invoke(numValueOf);
                            Unit unit6 = Unit.INSTANCE;
                            i4 = 1;
                            i += i4;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i10 = i + 3;
                    if (i2 <= i10) {
                        yield.invoke(numValueOf);
                        Unit unit7 = Unit.INSTANCE;
                        int i11 = i + 1;
                        if (i2 > i11 && (processUtf8CodePoints[i11] & 192) == 128) {
                            int i12 = i + 2;
                            if (i2 > i12 && (processUtf8CodePoints[i12] & 192) == 128) {
                                i4 = 3;
                            }
                        }
                        i += i4;
                    } else {
                        byte b9 = processUtf8CodePoints[i + 1];
                        if ((b9 & 192) == 128) {
                            byte b10 = processUtf8CodePoints[i + 2];
                            if ((b10 & 192) == 128) {
                                byte b11 = processUtf8CodePoints[i10];
                                if ((b11 & 192) == 128) {
                                    int i13 = (b << 18) ^ (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << 12));
                                    if (i13 <= 1114111 && ((55296 > i13 || 57343 < i13) && i13 >= 65536)) {
                                        yield.invoke(Integer.valueOf(i13));
                                    } else {
                                        yield.invoke(numValueOf);
                                    }
                                    Unit unit8 = Unit.INSTANCE;
                                    i4 = 4;
                                } else {
                                    yield.invoke(numValueOf);
                                    Unit unit9 = Unit.INSTANCE;
                                    i4 = 3;
                                }
                            } else {
                                yield.invoke(numValueOf);
                                Unit unit10 = Unit.INSTANCE;
                            }
                            i += i4;
                        } else {
                            yield.invoke(numValueOf);
                            Unit unit11 = Unit.INSTANCE;
                            i4 = 1;
                            i += i4;
                        }
                    }
                } else {
                    yield.invoke(numValueOf);
                    i++;
                }
            }
        }
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String utf8Size, int i, int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(utf8Size, "$this$utf8Size");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "beginIndex < 0: ").toString());
        }
        if (i2 >= i) {
            if (!(i2 <= utf8Size.length())) {
                StringBuilder sbM778t = AbstractC0541b.m778t(i2, "endIndex > string.length: ", " > ");
                sbM778t.append(utf8Size.length());
                throw new IllegalArgumentException(sbM778t.toString().toString());
            }
            long j = 0;
            while (i < i2) {
                char cCharAt = utf8Size.charAt(i);
                if (cCharAt < 128) {
                    j++;
                } else {
                    if (cCharAt < 2048) {
                        i4 = 2;
                    } else if (cCharAt < 55296 || cCharAt > 57343) {
                        i4 = 3;
                    } else {
                        int i5 = i + 1;
                        char cCharAt2 = i5 < i2 ? utf8Size.charAt(i5) : (char) 0;
                        if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                            j++;
                            i = i5;
                        } else {
                            j += (long) 4;
                            i += 2;
                        }
                    }
                    j += (long) i4;
                }
                i++;
            }
            return j;
        }
        throw new IllegalArgumentException(AbstractC1038a.m1214o(i2, i, "endIndex < beginIndex: ", " < ").toString());
    }
}
