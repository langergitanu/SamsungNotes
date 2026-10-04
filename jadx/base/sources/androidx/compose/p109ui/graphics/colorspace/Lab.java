package androidx.compose.p109ui.graphics.colorspace;

import androidx.compose.p109ui.graphics.ColorKt;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0019J=\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m13886d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", VPathDataCmd.RCurveTo, "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", AuthenticationConstants.Broker.BROKER_PROTOCOL_VERSION, "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLab.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Lab.kt\nandroidx/compose/ui/graphics/colorspace/Lab\n+ 2 MathHelpers.kt\nandroidx/compose/ui/util/MathHelpersKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,142:1\n71#2,16:143\n71#2,16:159\n71#2,16:175\n71#2,16:191\n71#2,16:207\n71#2,16:226\n71#2,16:242\n71#2,16:258\n71#2,16:274\n71#2,16:290\n71#2,16:306\n71#2,16:322\n71#2,16:338\n63#3,3:223\n*S KotlinDebug\n*F\n+ 1 Lab.kt\nandroidx/compose/ui/graphics/colorspace/Lab\n*L\n48#1:143,16\n49#1:159,16\n50#1:175,16\n67#1:191,16\n68#1:207,16\n79#1:226,16\n80#1:242,16\n107#1:258,16\n108#1:274,16\n109#1:290,16\n128#1:306,16\n129#1:322,16\n130#1:338,16\n75#1:223,3\n*E\n"})
public final class Lab extends ColorSpace {

    /* JADX INFO: renamed from: A */
    private static final float f1079A = 0.008856452f;

    /* JADX INFO: renamed from: B */
    private static final float f1080B = 7.787037f;

    /* JADX INFO: renamed from: C */
    private static final float f1081C = 0.13793103f;

    /* JADX INFO: renamed from: D */
    private static final float f1082D = 0.20689656f;

    public Lab(@NotNull String str, int i) {
        super(str, ColorModel.INSTANCE.m18938getLabxdoWZVw(), i, null);
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] v) {
        float f = v[0];
        Illuminant illuminant = Illuminant.INSTANCE;
        float f4 = f / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f5 = v[1] / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f6 = v[2] / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fCbrt = f4 > f1079A ? (float) Math.cbrt(f4) : (f4 * f1080B) + f1081C;
        float fCbrt2 = f5 > f1079A ? (float) Math.cbrt(f5) : (f5 * f1080B) + f1081C;
        float fCbrt3 = f6 > f1079A ? (float) Math.cbrt(f6) : (f6 * f1080B) + f1081C;
        float f7 = (116.0f * fCbrt2) - 16.0f;
        float f8 = (fCbrt - fCbrt2) * 500.0f;
        float f9 = (fCbrt2 - fCbrt3) * 200.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f7 > 100.0f) {
            f7 = 100.0f;
        }
        v[0] = f7;
        if (f8 < -128.0f) {
            f8 = -128.0f;
        }
        if (f8 > 128.0f) {
            f8 = 128.0f;
        }
        v[1] = f8;
        if (f9 < -128.0f) {
            f9 = -128.0f;
        }
        v[2] = f9 <= 128.0f ? f9 : 128.0f;
        return v;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
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
        if (v02 > 100.0f) {
            v02 = 100.0f;
        }
        if (v12 < -128.0f) {
            v12 = -128.0f;
        }
        if (v12 > 128.0f) {
            v12 = 128.0f;
        }
        float f = (v02 + 16.0f) / 116.0f;
        float f4 = (v12 * 0.002f) + f;
        float f5 = f4 > f1082D ? f4 * f4 * f4 : (f4 - f1081C) * 0.12841855f;
        float f6 = f > f1082D ? f * f * f : (f - f1081C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        return (((long) Float.floatToRawIntBits(f6 * illuminant.getD50Xyz$ui_graphics_release()[1])) & 4294967295L) | (((long) Float.floatToRawIntBits(f5 * illuminant.getD50Xyz$ui_graphics_release()[0])) << 32);
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] v) {
        float f = v[0];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        v[0] = f;
        float f4 = v[1];
        if (f4 < -128.0f) {
            f4 = -128.0f;
        }
        if (f4 > 128.0f) {
            f4 = 128.0f;
        }
        v[1] = f4;
        float f5 = v[2];
        float f6 = f5 >= -128.0f ? f5 : -128.0f;
        float f7 = f6 <= 128.0f ? f6 : 128.0f;
        v[2] = f7;
        float f8 = (f + 16.0f) / 116.0f;
        float f9 = (f4 * 0.002f) + f8;
        float f10 = f8 - (f7 * 0.005f);
        float f11 = f9 > f1082D ? f9 * f9 * f9 : (f9 - f1081C) * 0.12841855f;
        float f12 = f8 > f1082D ? f8 * f8 * f8 : (f8 - f1081C) * 0.12841855f;
        float f13 = f10 > f1082D ? f10 * f10 * f10 : (f10 - f1081C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        v[0] = f11 * illuminant.getD50Xyz$ui_graphics_release()[0];
        v[1] = f12 * illuminant.getD50Xyz$ui_graphics_release()[1];
        v[2] = f13 * illuminant.getD50Xyz$ui_graphics_release()[2];
        return v;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 100.0f) {
            v02 = 100.0f;
        }
        if (v22 < -128.0f) {
            v22 = -128.0f;
        }
        if (v22 > 128.0f) {
            v22 = 128.0f;
        }
        float f = ((v02 + 16.0f) / 116.0f) - (v22 * 0.005f);
        return (f > f1082D ? f * f * f : 0.12841855f * (f - f1081C)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo18942xyzaToColorJlNiLsg$ui_graphics_release(float x, float y2, float z, float a, @NotNull ColorSpace colorSpace) {
        Illuminant illuminant = Illuminant.INSTANCE;
        float f = x / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f4 = y2 / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f5 = z / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fCbrt = f > f1079A ? (float) Math.cbrt(f) : (f * f1080B) + f1081C;
        float fCbrt2 = f4 > f1079A ? (float) Math.cbrt(f4) : (f4 * f1080B) + f1081C;
        float f6 = (116.0f * fCbrt2) - 16.0f;
        float f7 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f5 > f1079A ? (float) Math.cbrt(f5) : (f5 * f1080B) + f1081C)) * 200.0f;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 100.0f) {
            f6 = 100.0f;
        }
        if (f7 < -128.0f) {
            f7 = -128.0f;
        }
        if (f7 > 128.0f) {
            f7 = 128.0f;
        }
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        return ColorKt.Color(f6, f7, fCbrt3 <= 128.0f ? fCbrt3 : 128.0f, a, colorSpace);
    }
}
