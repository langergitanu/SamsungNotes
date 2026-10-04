package androidx.compose.p109ui.graphics;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Size;
import androidx.collection.ScatterMapKt;
import androidx.compose.p109ui.graphics.colorspace.ColorModel;
import androidx.compose.p109ui.graphics.colorspace.ColorSpace;
import androidx.compose.p109ui.graphics.colorspace.ColorSpaces;
import androidx.compose.p109ui.graphics.colorspace.DoubleFunction;
import androidx.compose.p109ui.graphics.colorspace.Rgb;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.pen.base.SpenObjectFindType;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0017\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a5\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00192\b\b\u0001\u0010\u0012\u001a\u00020\u00192\b\b\u0001\u0010\u0013\u001a\u00020\u00192\b\b\u0003\u0010\u0014\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a9\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\u0010\u0017\u001a1\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0082\b\u001a,\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0001\u0010(\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u001e\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0016\u0010/\u001a\u000200*\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u0016\u00103\u001a\u00020\u0011*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a%\u00106\u001a\u00020\u0007*\u00020\u00072\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000708H\u0086\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0016\u0010;\u001a\u00020\u0019*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001f\u0010\u0005\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001f\u0010\f\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006>"}, m13886d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "UncheckedColor", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nColor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Color.kt\nandroidx/compose/ui/graphics/ColorKt\n+ 2 MathHelpers.kt\nandroidx/compose/ui/util/MathHelpersKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/graphics/InlineClassHelperKt\n+ 4 Float16.kt\nandroidx/compose/ui/graphics/Float16Kt\n*L\n1#1,723:1\n641#1:1110\n641#1:1111\n641#1:1112\n696#1:1136\n71#2,16:724\n71#2,16:740\n71#2,16:756\n71#2,16:772\n71#2,16:802\n71#2,16:856\n71#2,16:910\n71#2,16:964\n71#2,16:1094\n71#2,16:1120\n33#3,7:788\n33#3,7:795\n33#3,7:1113\n605#4,38:818\n605#4,38:872\n605#4,38:926\n605#4,38:980\n605#4,38:1018\n605#4,38:1056\n*S KotlinDebug\n*F\n+ 1 Color.kt\nandroidx/compose/ui/graphics/ColorKt\n*L\n621#1:1110\n622#1:1111\n623#1:1112\n708#1:1136\n432#1:724,16\n433#1:740,16\n434#1:756,16\n435#1:772,16\n449#1:802,16\n450#1:856,16\n451#1:910,16\n452#1:964,16\n591#1:1094,16\n676#1:1120,16\n440#1:788,7\n445#1:795,7\n666#1:1113,7\n449#1:818,38\n450#1:872,38\n451#1:926,38\n489#1:980,38\n490#1:1018,38\n491#1:1056,38\n*E\n"})
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    /* JADX WARN: Removed duplicated region for block: B:110:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0129  */
    @Stable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long Color(float f, float f4, float f5, float f6, @NotNull ColorSpace colorSpace) {
        int i;
        int i2;
        int i4;
        float minValue;
        float maxValue;
        int i5;
        int i6;
        int i7;
        int i8;
        float minValue2;
        float maxValue2;
        int i9;
        int i10;
        int i11;
        if (colorSpace.getIsSrgb()) {
            float f7 = f6 < 0.0f ? 0.0f : f6;
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            int i12 = ((int) ((f7 * 255.0f) + 0.5f)) << 24;
            float f8 = f < 0.0f ? 0.0f : f;
            if (f8 > 1.0f) {
                f8 = 1.0f;
            }
            int i13 = i12 | (((int) ((f8 * 255.0f) + 0.5f)) << 16);
            float f9 = f4 < 0.0f ? 0.0f : f4;
            if (f9 > 1.0f) {
                f9 = 1.0f;
            }
            int i14 = i13 | (((int) ((f9 * 255.0f) + 0.5f)) << 8);
            return Color.m18521constructorimpl(ULong.m22389constructorimpl(ULong.m22389constructorimpl(i14 | ((int) ((((f5 >= 0.0f ? f5 : 0.0f) <= 1.0f ? r5 : 1.0f) * 255.0f) + 0.5f))) << 32));
        }
        if (!(colorSpace.getComponentCount() == 3)) {
            InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
        }
        int id$ui_graphics_release = colorSpace.getId();
        if (!(id$ui_graphics_release != -1)) {
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }
        float minValue3 = colorSpace.getMinValue(0);
        float maxValue3 = colorSpace.getMaxValue(0);
        if (f >= minValue3) {
            minValue3 = f;
        }
        if (minValue3 <= maxValue3) {
            maxValue3 = minValue3;
        }
        int iFloatToRawIntBits = Float.floatToRawIntBits(maxValue3);
        int i15 = iFloatToRawIntBits >>> 31;
        int i16 = (iFloatToRawIntBits >>> 23) & 255;
        int i17 = iFloatToRawIntBits & SpenObjectFindType.ALL;
        if (i16 == 255) {
            i2 = i17 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i16 + LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY;
            if (i >= 31) {
                i2 = 0;
                i = 49;
            } else if (i > 0) {
                int i18 = i17 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i4 = (((i << 10) | i18) + 1) | (i15 << 15);
                    short s = (short) i4;
                    minValue = colorSpace.getMinValue(1);
                    maxValue = colorSpace.getMaxValue(1);
                    if (f4 >= minValue) {
                        minValue = f4;
                    }
                    if (minValue <= maxValue) {
                        maxValue = minValue;
                    }
                    int iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue);
                    int i19 = iFloatToRawIntBits2 >>> 31;
                    i5 = (iFloatToRawIntBits2 >>> 23) & 255;
                    int i20 = iFloatToRawIntBits2 & SpenObjectFindType.ALL;
                    if (i5 != 255) {
                        i7 = i20 != 0 ? 512 : 0;
                        i6 = 31;
                    } else {
                        i6 = i5 + LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY;
                        if (i6 >= 31) {
                            i7 = 0;
                            i6 = 49;
                        } else if (i6 > 0) {
                            int i21 = i20 >> 13;
                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                i8 = (((i6 << 10) | i21) + 1) | (i19 << 15);
                                short s2 = (short) i8;
                                minValue2 = colorSpace.getMinValue(2);
                                maxValue2 = colorSpace.getMaxValue(2);
                                if (f5 >= minValue2) {
                                    minValue2 = f5;
                                }
                                if (minValue2 <= maxValue2) {
                                    maxValue2 = minValue2;
                                }
                                int iFloatToRawIntBits3 = Float.floatToRawIntBits(maxValue2);
                                int i22 = iFloatToRawIntBits3 >>> 31;
                                i9 = (iFloatToRawIntBits3 >>> 23) & 255;
                                int i23 = 8388607 & iFloatToRawIntBits3;
                                if (i9 == 255) {
                                    i10 = i23 != 0 ? 512 : 0;
                                    i = 31;
                                } else {
                                    int i24 = i9 + LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY;
                                    if (i24 >= 31) {
                                        i10 = 0;
                                        i = 49;
                                    } else if (i24 > 0) {
                                        int i25 = i23 >> 13;
                                        if ((iFloatToRawIntBits3 & 4096) != 0) {
                                            i11 = (((i24 << 10) | i25) + 1) | (i22 << 15);
                                            short s3 = (short) i11;
                                            float f10 = f6 >= 0.0f ? f6 : 0.0f;
                                            return Color.m18521constructorimpl(ULong.m22389constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & 65535) << 48) | ((((long) s2) & 65535) << 32) | ((65535 & ((long) s3)) << 16) | ((((long) ((int) (((f10 <= 1.0f ? f10 : 1.0f) * 1023.0f) + 0.5f))) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED) << 6)));
                                        }
                                        i10 = i25;
                                        i = i24;
                                    } else if (i24 >= -10) {
                                        int i26 = (i23 | 8388608) >> (1 - i24);
                                        if ((i26 & 4096) != 0) {
                                            i26 += 8192;
                                        }
                                        i10 = i26 >> 13;
                                    } else {
                                        i10 = 0;
                                    }
                                }
                                i11 = i10 | (i22 << 15) | (i << 10);
                                short s32 = (short) i11;
                                if (f6 >= 0.0f) {
                                }
                                return Color.m18521constructorimpl(ULong.m22389constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & 65535) << 48) | ((((long) s2) & 65535) << 32) | ((65535 & ((long) s32)) << 16) | ((((long) ((int) (((f10 <= 1.0f ? f10 : 1.0f) * 1023.0f) + 0.5f))) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED) << 6)));
                            }
                            i7 = i21;
                        } else if (i6 >= -10) {
                            int i27 = (i20 | 8388608) >> (1 - i6);
                            if ((i27 & 4096) != 0) {
                                i27 += 8192;
                            }
                            i7 = i27 >> 13;
                            i6 = 0;
                        } else {
                            i7 = 0;
                            i6 = 0;
                        }
                    }
                    i8 = i7 | (i19 << 15) | (i6 << 10);
                    short s22 = (short) i8;
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f5 >= minValue2) {
                    }
                    if (minValue2 <= maxValue2) {
                    }
                    int iFloatToRawIntBits32 = Float.floatToRawIntBits(maxValue2);
                    int i222 = iFloatToRawIntBits32 >>> 31;
                    i9 = (iFloatToRawIntBits32 >>> 23) & 255;
                    int i232 = 8388607 & iFloatToRawIntBits32;
                    if (i9 == 255) {
                    }
                    i11 = i10 | (i222 << 15) | (i << 10);
                    short s322 = (short) i11;
                    if (f6 >= 0.0f) {
                    }
                    return Color.m18521constructorimpl(ULong.m22389constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & 65535) << 48) | ((((long) s22) & 65535) << 32) | ((65535 & ((long) s322)) << 16) | ((((long) ((int) (((f10 <= 1.0f ? f10 : 1.0f) * 1023.0f) + 0.5f))) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED) << 6)));
                }
                i2 = i18;
            } else if (i >= -10) {
                int i28 = (i17 | 8388608) >> (1 - i);
                if ((i28 & 4096) != 0) {
                    i28 += 8192;
                }
                i2 = i28 >> 13;
                i = 0;
            } else {
                i2 = 0;
                i = 0;
            }
        }
        i4 = i2 | (i15 << 15) | (i << 10);
        short s4 = (short) i4;
        minValue = colorSpace.getMinValue(1);
        maxValue = colorSpace.getMaxValue(1);
        if (f4 >= minValue) {
        }
        if (minValue <= maxValue) {
        }
        int iFloatToRawIntBits22 = Float.floatToRawIntBits(maxValue);
        int i192 = iFloatToRawIntBits22 >>> 31;
        i5 = (iFloatToRawIntBits22 >>> 23) & 255;
        int i202 = iFloatToRawIntBits22 & SpenObjectFindType.ALL;
        if (i5 != 255) {
        }
        i8 = i7 | (i192 << 15) | (i6 << 10);
        short s222 = (short) i8;
        minValue2 = colorSpace.getMinValue(2);
        maxValue2 = colorSpace.getMaxValue(2);
        if (f5 >= minValue2) {
        }
        if (minValue2 <= maxValue2) {
        }
        int iFloatToRawIntBits322 = Float.floatToRawIntBits(maxValue2);
        int i2222 = iFloatToRawIntBits322 >>> 31;
        i9 = (iFloatToRawIntBits322 >>> 23) & 255;
        int i2322 = 8388607 & iFloatToRawIntBits322;
        if (i9 == 255) {
        }
        i11 = i10 | (i2222 << 15) | (i << 10);
        short s3222 = (short) i11;
        if (f6 >= 0.0f) {
        }
        return Color.m18521constructorimpl(ULong.m22389constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s4) & 65535) << 48) | ((((long) s222) & 65535) << 32) | ((65535 & ((long) s3222)) << 16) | ((((long) ((int) (((f10 <= 1.0f ? f10 : 1.0f) * 1023.0f) + 0.5f))) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED) << 6)));
    }

    public static /* synthetic */ long Color$default(float f, float f4, float f5, float f6, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f6 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f4, f5, f6, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f0  */
    @Stable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long UncheckedColor(float f, float f4, float f5, float f6, @NotNull ColorSpace colorSpace) {
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (colorSpace.getIsSrgb()) {
            return Color.m18521constructorimpl(ULong.m22389constructorimpl(ULong.m22389constructorimpl((((((int) ((f6 * 255.0f) + 0.5f)) << 24) | (((int) ((f * 255.0f) + 0.5f)) << 16)) | (((int) ((f4 * 255.0f) + 0.5f)) << 8)) | ((int) ((255.0f * f5) + 0.5f))) << 32));
        }
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i11 = iFloatToRawIntBits >>> 31;
        int i12 = (iFloatToRawIntBits >>> 23) & 255;
        int i13 = iFloatToRawIntBits & SpenObjectFindType.ALL;
        int i14 = 49;
        int i15 = 0;
        if (i12 == 255) {
            i2 = i13 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i12 + LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY;
            if (i >= 31) {
                i = 49;
                i2 = 0;
            } else if (i > 0) {
                int i16 = i13 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i4 = (((i << 10) | i16) + 1) | (i11 << 15);
                    short s = (short) i4;
                    int iFloatToRawIntBits2 = Float.floatToRawIntBits(f4);
                    int i17 = iFloatToRawIntBits2 >>> 31;
                    i5 = (iFloatToRawIntBits2 >>> 23) & 255;
                    int i18 = iFloatToRawIntBits2 & SpenObjectFindType.ALL;
                    if (i5 != 255) {
                        i7 = i18 != 0 ? 512 : 0;
                        i6 = 31;
                    } else {
                        i6 = i5 + LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY;
                        if (i6 >= 31) {
                            i6 = 49;
                            i7 = 0;
                        } else if (i6 > 0) {
                            int i19 = i18 >> 13;
                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                i8 = (((i6 << 10) | i19) + 1) | (i17 << 15);
                                short s2 = (short) i8;
                                int iFloatToRawIntBits3 = Float.floatToRawIntBits(f5);
                                int i20 = iFloatToRawIntBits3 >>> 31;
                                i9 = (iFloatToRawIntBits3 >>> 23) & 255;
                                int i21 = 8388607 & iFloatToRawIntBits3;
                                if (i9 != 255) {
                                    int i22 = i9 + LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY;
                                    if (i22 < 31) {
                                        if (i22 > 0) {
                                            i15 = i21 >> 13;
                                            if ((iFloatToRawIntBits3 & 4096) != 0) {
                                                i10 = (((i22 << 10) | i15) + 1) | (i20 << 15);
                                            } else {
                                                i14 = i22;
                                            }
                                        } else if (i22 >= -10) {
                                            int i23 = (i21 | 8388608) >> (1 - i22);
                                            if ((i23 & 4096) != 0) {
                                                i23 += 8192;
                                            }
                                            i14 = 0;
                                            i15 = i23 >> 13;
                                        } else {
                                            i14 = 0;
                                        }
                                    }
                                    return Color.m18521constructorimpl(ULong.m22389constructorimpl(((((long) ((short) i10)) & 65535) << 16) | ((((long) s) & 65535) << 48) | ((((long) s2) & 65535) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f6, 1.0f)) * 1023.0f) + 0.5f))) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED) << 6) | (((long) colorSpace.getId()) & 63)));
                                }
                                i15 = i21 == 0 ? 0 : 512;
                                i14 = 31;
                                i10 = (i20 << 15) | (i14 << 10) | i15;
                                return Color.m18521constructorimpl(ULong.m22389constructorimpl(((((long) ((short) i10)) & 65535) << 16) | ((((long) s) & 65535) << 48) | ((((long) s2) & 65535) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f6, 1.0f)) * 1023.0f) + 0.5f))) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED) << 6) | (((long) colorSpace.getId()) & 63)));
                            }
                            i7 = i19;
                        } else if (i6 >= -10) {
                            int i24 = (i18 | 8388608) >> (1 - i6);
                            if ((i24 & 4096) != 0) {
                                i24 += 8192;
                            }
                            i7 = i24 >> 13;
                            i6 = 0;
                        } else {
                            i7 = 0;
                            i6 = 0;
                        }
                    }
                    i8 = i7 | (i17 << 15) | (i6 << 10);
                    short s22 = (short) i8;
                    int iFloatToRawIntBits32 = Float.floatToRawIntBits(f5);
                    int i202 = iFloatToRawIntBits32 >>> 31;
                    i9 = (iFloatToRawIntBits32 >>> 23) & 255;
                    int i212 = 8388607 & iFloatToRawIntBits32;
                    if (i9 != 255) {
                    }
                    i10 = (i202 << 15) | (i14 << 10) | i15;
                    return Color.m18521constructorimpl(ULong.m22389constructorimpl(((((long) ((short) i10)) & 65535) << 16) | ((((long) s) & 65535) << 48) | ((((long) s22) & 65535) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f6, 1.0f)) * 1023.0f) + 0.5f))) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED) << 6) | (((long) colorSpace.getId()) & 63)));
                }
                i2 = i16;
            } else if (i >= -10) {
                int i25 = (i13 | 8388608) >> (1 - i);
                if ((i25 & 4096) != 0) {
                    i25 += 8192;
                }
                i2 = i25 >> 13;
                i = 0;
            } else {
                i2 = 0;
                i = 0;
            }
        }
        i4 = i2 | (i11 << 15) | (i << 10);
        short s3 = (short) i4;
        int iFloatToRawIntBits22 = Float.floatToRawIntBits(f4);
        int i172 = iFloatToRawIntBits22 >>> 31;
        i5 = (iFloatToRawIntBits22 >>> 23) & 255;
        int i182 = iFloatToRawIntBits22 & SpenObjectFindType.ALL;
        if (i5 != 255) {
        }
        i8 = i7 | (i172 << 15) | (i6 << 10);
        short s222 = (short) i8;
        int iFloatToRawIntBits322 = Float.floatToRawIntBits(f5);
        int i2022 = iFloatToRawIntBits322 >>> 31;
        i9 = (iFloatToRawIntBits322 >>> 23) & 255;
        int i2122 = 8388607 & iFloatToRawIntBits322;
        if (i9 != 255) {
        }
        i10 = (i2022 << 15) | (i14 << 10) | i15;
        return Color.m18521constructorimpl(ULong.m22389constructorimpl(((((long) ((short) i10)) & 65535) << 16) | ((((long) s3) & 65535) << 48) | ((((long) s222) & 65535) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f6, 1.0f)) * 1023.0f) + 0.5f))) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED) << 6) | (((long) colorSpace.getId()) & 63)));
    }

    public static /* synthetic */ long UncheckedColor$default(float f, float f4, float f5, float f6, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f6 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f, f4, f5, f6, colorSpace);
    }

    private static final float compositeComponent(float f, float f4, float f5, float f6, float f7) {
        if (f7 == 0.0f) {
            return 0.0f;
        }
        return (((1.0f - f5) * (f4 * f6)) + (f * f5)) / f7;
    }

    @Stable
    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m18570compositeOverOWjLjI(long j, long j2) {
        float f;
        float f4;
        long jM18522convertvNxB06k = Color.m18522convertvNxB06k(j, Color.m18529getColorSpaceimpl(j2));
        float fM18527getAlphaimpl = Color.m18527getAlphaimpl(j2);
        float fM18527getAlphaimpl2 = Color.m18527getAlphaimpl(jM18522convertvNxB06k);
        float f5 = 1.0f - fM18527getAlphaimpl2;
        float f6 = (fM18527getAlphaimpl * f5) + fM18527getAlphaimpl2;
        float fM18531getRedimpl = Color.m18531getRedimpl(jM18522convertvNxB06k);
        float fM18531getRedimpl2 = Color.m18531getRedimpl(j2);
        float f7 = 0.0f;
        if (f6 == 0.0f) {
            f = 0.0f;
        } else {
            f = (((fM18531getRedimpl2 * fM18527getAlphaimpl) * f5) + (fM18531getRedimpl * fM18527getAlphaimpl2)) / f6;
        }
        float fM18530getGreenimpl = Color.m18530getGreenimpl(jM18522convertvNxB06k);
        float fM18530getGreenimpl2 = Color.m18530getGreenimpl(j2);
        if (f6 == 0.0f) {
            f4 = 0.0f;
        } else {
            f4 = (((fM18530getGreenimpl2 * fM18527getAlphaimpl) * f5) + (fM18530getGreenimpl * fM18527getAlphaimpl2)) / f6;
        }
        float fM18528getBlueimpl = Color.m18528getBlueimpl(jM18522convertvNxB06k);
        float fM18528getBlueimpl2 = Color.m18528getBlueimpl(j2);
        if (f6 != 0.0f) {
            f7 = (((fM18528getBlueimpl2 * fM18527getAlphaimpl) * f5) + (fM18528getBlueimpl * fM18527getAlphaimpl2)) / f6;
        }
        return UncheckedColor(f, f4, f7, f6, Color.m18529getColorSpaceimpl(j2));
    }

    @Size(4)
    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m18571getComponents8_81llA(long j) {
        return new float[]{Color.m18531getRedimpl(j), Color.m18530getGreenimpl(j), Color.m18528getBlueimpl(j), Color.m18527getAlphaimpl(j)};
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m18572isSpecified8_81llA(long j) {
        return j != 16;
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m18574isUnspecified8_81llA(long j) {
        return j == 16;
    }

    @Stable
    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m18576lerpjxsXWHM(long j, long j2, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM18522convertvNxB06k = Color.m18522convertvNxB06k(j, oklab);
        long jM18522convertvNxB06k2 = Color.m18522convertvNxB06k(j2, oklab);
        float fM18527getAlphaimpl = Color.m18527getAlphaimpl(jM18522convertvNxB06k);
        float fM18531getRedimpl = Color.m18531getRedimpl(jM18522convertvNxB06k);
        float fM18530getGreenimpl = Color.m18530getGreenimpl(jM18522convertvNxB06k);
        float fM18528getBlueimpl = Color.m18528getBlueimpl(jM18522convertvNxB06k);
        float fM18527getAlphaimpl2 = Color.m18527getAlphaimpl(jM18522convertvNxB06k2);
        float fM18531getRedimpl2 = Color.m18531getRedimpl(jM18522convertvNxB06k2);
        float fM18530getGreenimpl2 = Color.m18530getGreenimpl(jM18522convertvNxB06k2);
        float fM18528getBlueimpl2 = Color.m18528getBlueimpl(jM18522convertvNxB06k2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m18522convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(fM18531getRedimpl, fM18531getRedimpl2, f), MathHelpersKt.lerp(fM18530getGreenimpl, fM18530getGreenimpl2, f), MathHelpersKt.lerp(fM18528getBlueimpl, fM18528getBlueimpl2, f), MathHelpersKt.lerp(fM18527getAlphaimpl, fM18527getAlphaimpl2, f), oklab), Color.m18529getColorSpaceimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m18577luminance8_81llA(long j) {
        ColorSpace colorSpaceM18529getColorSpaceimpl = Color.m18529getColorSpaceimpl(j);
        if (!ColorModel.m18932equalsimpl0(colorSpaceM18529getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m18939getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m18935toStringimpl(colorSpaceM18529getColorSpaceimpl.getModel())));
        }
        Intrinsics.checkNotNull(colorSpaceM18529getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc = ((Rgb) colorSpaceM18529getColorSpaceimpl).getEotfFunc();
        double dInvoke = eotfFunc.invoke(Color.m18531getRedimpl(j));
        float fInvoke = (float) ((eotfFunc.invoke(Color.m18528getBlueimpl(j)) * 0.0722d) + (eotfFunc.invoke(Color.m18530getGreenimpl(j)) * 0.7152d) + (dInvoke * 0.2126d));
        if (fInvoke < 0.0f) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m18578takeOrElseDxMtmZc(long j, @NotNull Function0<Color> function0) {
        return j != 16 ? j : function0.invoke().m18535unboximpl();
    }

    @Stable
    @ColorInt
    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m18579toArgb8_81llA(long j) {
        return (int) ULong.m22389constructorimpl(Color.m18522convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            i5 = 255;
        }
        return Color(i, i2, i4, i5);
    }

    @PublishedApi
    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    @Stable
    public static final long Color(@ColorInt int i) {
        return Color.m18521constructorimpl(ULong.m22389constructorimpl(ULong.m22389constructorimpl(i) << 32));
    }

    @Stable
    public static final long Color(long j) {
        return Color.m18521constructorimpl(ULong.m22389constructorimpl(j << 32));
    }

    @Stable
    public static final long Color(@IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i2, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i4, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i5) {
        return Color(((i & 255) << 16) | ((i5 & 255) << 24) | ((i2 & 255) << 8) | (i4 & 255));
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m18573isSpecified8_81llA$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m18575isUnspecified8_81llA$annotations(long j) {
    }
}
