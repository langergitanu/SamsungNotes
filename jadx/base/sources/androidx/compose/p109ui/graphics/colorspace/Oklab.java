package androidx.compose.p109ui.graphics.colorspace;

import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.util.MathHelpersKt;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0019J=\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m13886d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", VPathDataCmd.RCurveTo, "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", AuthenticationConstants.Broker.BROKER_PROTOCOL_VERSION, "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOklab.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Oklab.kt\nandroidx/compose/ui/graphics/colorspace/Oklab\n+ 2 MathHelpers.kt\nandroidx/compose/ui/util/MathHelpersKt\n+ 3 ColorSpace.kt\nandroidx/compose/ui/graphics/colorspace/ColorSpaceKt\n+ 4 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,171:1\n71#2,16:172\n71#2,16:188\n71#2,16:204\n71#2,16:220\n71#2,16:236\n71#2,16:252\n71#2,16:276\n71#2,16:292\n71#2,16:308\n716#3:268\n735#3:269\n754#3:270\n716#3:271\n735#3:272\n716#3:324\n735#3:325\n754#3:326\n754#3:327\n716#3:328\n735#3:329\n754#3:330\n716#3:331\n735#3:332\n754#3:333\n63#4,3:273\n*S KotlinDebug\n*F\n+ 1 Oklab.kt\nandroidx/compose/ui/graphics/colorspace/Oklab\n*L\n48#1:172,16\n49#1:188,16\n50#1:204,16\n62#1:220,16\n63#1:236,16\n64#1:252,16\n81#1:276,16\n82#1:292,16\n83#1:308,16\n66#1:268\n67#1:269\n68#1:270\n74#1:271\n75#1:272\n85#1:324\n86#1:325\n87#1:326\n93#1:327\n105#1:328\n106#1:329\n107#1:330\n113#1:331\n114#1:332\n115#1:333\n77#1:273,3\n*E\n"})
public final class Oklab extends ColorSpace {

    @NotNull
    private static final float[] InverseM1;

    @NotNull
    private static final float[] InverseM2;

    /* JADX INFO: renamed from: M1 */
    @NotNull
    private static final float[] f1083M1;

    /* JADX INFO: renamed from: M2 */
    @NotNull
    private static final float[] f1084M2;

    static {
        float[] transform = Adaptation.INSTANCE.getBradford().getTransform();
        Illuminant illuminant = Illuminant.INSTANCE;
        float[] fArrMul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(transform, illuminant.getD50().toXyz$ui_graphics_release(), illuminant.getD65().toXyz$ui_graphics_release()));
        f1083M1 = fArrMul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f1084M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(fArrMul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }

    public Oklab(@NotNull String str, int i) {
        super(str, ColorModel.INSTANCE.m18938getLabxdoWZVw(), i, null);
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] v) {
        ColorSpaceKt.mul3x3Float3(f1083M1, v);
        v[0] = MathHelpersKt.fastCbrt(v[0]);
        v[1] = MathHelpersKt.fastCbrt(v[1]);
        v[2] = MathHelpersKt.fastCbrt(v[2]);
        ColorSpaceKt.mul3x3Float3(f1084M2, v);
        return v;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 1.0f) {
            v02 = 1.0f;
        }
        if (v12 < -0.5f) {
            v12 = -0.5f;
        }
        if (v12 > 0.5f) {
            v12 = 0.5f;
        }
        if (v22 < -0.5f) {
            v22 = -0.5f;
        }
        float f = v22 <= 0.5f ? v22 : 0.5f;
        float[] fArr = InverseM2;
        float f4 = (fArr[6] * f) + (fArr[3] * v12) + (fArr[0] * v02);
        float f5 = (fArr[7] * f) + (fArr[4] * v12) + (fArr[1] * v02);
        float f6 = (fArr[8] * f) + (fArr[5] * v12) + (fArr[2] * v02);
        float f7 = f4 * f4 * f4;
        float f8 = f5 * f5 * f5;
        float f9 = f6 * f6 * f6;
        float[] fArr2 = InverseM1;
        return (((long) Float.floatToRawIntBits((fArr2[7] * f9) + (fArr2[4] * f8) + (fArr2[1] * f7))) & 4294967295L) | (((long) Float.floatToRawIntBits((fArr2[6] * f9) + ((fArr2[3] * f8) + (fArr2[0] * f7)))) << 32);
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] v) {
        float f = v[0];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        v[0] = f;
        float f4 = v[1];
        if (f4 < -0.5f) {
            f4 = -0.5f;
        }
        if (f4 > 0.5f) {
            f4 = 0.5f;
        }
        v[1] = f4;
        float f5 = v[2];
        float f6 = f5 >= -0.5f ? f5 : -0.5f;
        v[2] = f6 <= 0.5f ? f6 : 0.5f;
        ColorSpaceKt.mul3x3Float3(InverseM2, v);
        float f7 = v[0];
        v[0] = f7 * f7 * f7;
        float f8 = v[1];
        v[1] = f8 * f8 * f8;
        float f9 = v[2];
        v[2] = f9 * f9 * f9;
        ColorSpaceKt.mul3x3Float3(InverseM1, v);
        return v;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 1.0f) {
            v02 = 1.0f;
        }
        if (v12 < -0.5f) {
            v12 = -0.5f;
        }
        if (v12 > 0.5f) {
            v12 = 0.5f;
        }
        if (v22 < -0.5f) {
            v22 = -0.5f;
        }
        float f = v22 <= 0.5f ? v22 : 0.5f;
        float[] fArr = InverseM2;
        float f4 = (fArr[6] * f) + (fArr[3] * v12) + (fArr[0] * v02);
        float f5 = (fArr[7] * f) + (fArr[4] * v12) + (fArr[1] * v02);
        float f6 = (fArr[8] * f) + (fArr[5] * v12) + (fArr[2] * v02);
        float f7 = f4 * f4 * f4;
        float f8 = f5 * f5 * f5;
        float f9 = f6 * f6 * f6;
        float[] fArr2 = InverseM1;
        return (fArr2[8] * f9) + (fArr2[5] * f8) + (fArr2[2] * f7);
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo18942xyzaToColorJlNiLsg$ui_graphics_release(float x, float y2, float z, float a, @NotNull ColorSpace colorSpace) {
        float[] fArr = f1083M1;
        float f = (fArr[6] * z) + (fArr[3] * y2) + (fArr[0] * x);
        float f4 = (fArr[7] * z) + (fArr[4] * y2) + (fArr[1] * x);
        float f5 = (fArr[8] * z) + (fArr[5] * y2) + (fArr[2] * x);
        float fFastCbrt = MathHelpersKt.fastCbrt(f);
        float fFastCbrt2 = MathHelpersKt.fastCbrt(f4);
        float fFastCbrt3 = MathHelpersKt.fastCbrt(f5);
        float[] fArr2 = f1084M2;
        return ColorKt.Color((fArr2[6] * fFastCbrt3) + (fArr2[3] * fFastCbrt2) + (fArr2[0] * fFastCbrt), (fArr2[7] * fFastCbrt3) + (fArr2[4] * fFastCbrt2) + (fArr2[1] * fFastCbrt), (fArr2[8] * fFastCbrt3) + (fArr2[5] * fFastCbrt2) + (fArr2[2] * fFastCbrt), a, colorSpace);
    }
}
