package androidx.compose.p109ui.graphics;

import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\r\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0080\b\u001a\u0011\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0017H\u0080\b\u001a\"\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\"\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001f\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0017H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u0010\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m13886d2 = {"Fp16Combined", "", "Fp16ExponentBias", "Fp16ExponentMask", "Fp16ExponentMax", "Fp16ExponentShift", "Fp16SignMask", "Fp16SignShift", "Fp16SignificandMask", "Fp32DenormalFloat", "", "Fp32DenormalMagic", "Fp32ExponentBias", "Fp32ExponentMask", "Fp32ExponentShift", "Fp32QNaNMask", "Fp32SignShift", "Fp32SignificandMask", "NegativeOne", "Landroidx/compose/ui/graphics/Float16;", "S", "One", "floatToHalf", "", "f", "halfToFloat", "h", VElementFormulasCmd.FMAX, "x", "y", "max-AoSsdG0", "(SS)S", VElementFormulasCmd.FMIN, "min-AoSsdG0", "toCompareValue", "value", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloat16.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Float16.kt\nandroidx/compose/ui/graphics/Float16Kt\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,717:1\n22#2:718\n22#2:719\n22#2:720\n*S KotlinDebug\n*F\n+ 1 Float16.kt\nandroidx/compose/ui/graphics/Float16Kt\n*L\n661#1:718\n678#1:719\n588#1:720\n*E\n"})
public final class Float16Kt {
    private static final int Fp16Combined = 32767;
    private static final int Fp16ExponentBias = 15;
    private static final int Fp16ExponentMask = 31;
    private static final int Fp16ExponentMax = 31744;
    private static final int Fp16ExponentShift = 10;
    private static final int Fp16SignMask = 32768;
    private static final int Fp16SignShift = 15;
    private static final int Fp16SignificandMask = 1023;
    private static final int Fp32ExponentBias = 127;
    private static final int Fp32ExponentMask = 255;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 4194304;
    private static final int Fp32SignShift = 31;
    private static final int Fp32SignificandMask = 8388607;
    private static final short One = Float16.m18633constructorimpl(1.0f);
    private static final short NegativeOne = Float16.m18633constructorimpl(-1.0f);
    private static final int Fp32DenormalMagic = 1056964608;
    private static final float Fp32DenormalFloat = Float.intBitsToFloat(Fp32DenormalMagic);

    public static final short floatToHalf(float f) {
        int i;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i2 = iFloatToRawIntBits >>> 31;
        int i4 = (iFloatToRawIntBits >>> 23) & 255;
        int i5 = 8388607 & iFloatToRawIntBits;
        int i6 = 31;
        int i7 = 0;
        if (i4 != 255) {
            int i8 = i4 + LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY;
            if (i8 >= 31) {
                i6 = 49;
            } else if (i8 > 0) {
                i7 = i5 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i = (((i8 << 10) | i7) + 1) | (i2 << 15);
                    return (short) i;
                }
                i6 = i8;
            } else if (i8 >= -10) {
                int i9 = (8388608 | i5) >> (1 - i8);
                if ((i9 & 4096) != 0) {
                    i9 += 8192;
                }
                i6 = 0;
                i7 = i9 >> 13;
            } else {
                i6 = 0;
            }
        } else if (i5 != 0) {
            i7 = 512;
        }
        i = (i2 << 15) | (i6 << 10) | i7;
        return (short) i;
    }

    public static final float halfToFloat(short s) {
        int i;
        int i2;
        int i4;
        int i5 = Short.MIN_VALUE & s;
        int i6 = ((65535 & s) >>> 10) & 31;
        int i7 = s & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i = 255;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i = i6 + 112;
            }
            int i9 = i;
            i2 = i8;
            i4 = i9;
        } else {
            if (i7 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i7 + Fp32DenormalMagic) - Fp32DenormalFloat;
                return i5 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i4 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i4 << 23) | (i5 << 16) | i2);
    }

    /* JADX INFO: renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m18671maxAoSsdG0(short s, short s2) {
        return (Float16.m18644isNaNimpl(s) || Float16.m18644isNaNimpl(s2)) ? Float16.Companion.m18666getNaNslo4al4() : Float16.m18631compareTo41bOqos(s, s2) >= 0 ? s : s2;
    }

    /* JADX INFO: renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m18672minAoSsdG0(short s, short s2) {
        return (Float16.m18644isNaNimpl(s) || Float16.m18644isNaNimpl(s2)) ? Float16.Companion.m18666getNaNslo4al4() : Float16.m18631compareTo41bOqos(s, s2) <= 0 ? s : s2;
    }

    private static final int toCompareValue(short s) {
        return (s & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s & UShort.MAX_VALUE) : s & UShort.MAX_VALUE;
    }
}
