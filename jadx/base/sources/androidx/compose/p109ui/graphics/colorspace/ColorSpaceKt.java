package androidx.compose.p109ui.graphics.colorspace;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.p109ui.graphics.colorspace.ColorModel;
import androidx.compose.p109ui.graphics.colorspace.Connector;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a8\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0000\u001a*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0000\u001a\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0000\u001a\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0000\u001a\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0000\u001a)\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0080\b\u001a)\u0010'\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0080\b\u001a)\u0010(\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0080\b\u001a8\u0010)\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001aH\u0010)\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a8\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001aH\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010-\u001a\u00020\u0015*\u00020\u00152\u0006\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u000200H\u0007\u001a(\u00101\u001a\u00020\u0013*\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\b2\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, m13886d2 = {"absRcpResponse", "", "x", "a", "b", "c", "d", "g", "absResponse", "chromaticAdaptation", "", "matrix", "srcWhitePoint", "dstWhitePoint", "compare", "", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "createConnector", "Landroidx/compose/ui/graphics/colorspace/Connector;", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", RtspHeaders.Values.DESTINATION, MarketingConstants.LINK_TYPE_INTENT, "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "createConnector-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)Landroidx/compose/ui/graphics/colorspace/Connector;", "inverse3x3", "m", "mul3x3", "lhs", "rhs", "mul3x3Diag", "mul3x3Float3", "mul3x3Float3_0", "", "r0", "r1", "r2", "mul3x3Float3_1", "mul3x3Float3_2", "rcpResponse", "e", "f", "response", "adapt", "whitePoint", "adaptation", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "connect", "connect-YBCOT_4", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nColorSpace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorSpace.kt\nandroidx/compose/ui/graphics/colorspace/ColorSpaceKt\n+ 2 Connector.kt\nandroidx/compose/ui/graphics/colorspace/ConnectorKt\n+ 3 IntObjectMap.kt\nandroidx/collection/MutableIntObjectMap\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,802:1\n347#2:803\n728#3:804\n1#4:805\n*S KotlinDebug\n*F\n+ 1 ColorSpace.kt\nandroidx/compose/ui/graphics/colorspace/ColorSpaceKt\n*L\n460#1:803\n460#1:804\n460#1:805\n*E\n"})
public final class ColorSpaceKt {
    public static final double absRcpResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.copySign(rcpResponse(d < 0.0d ? -d : d, d2, d3, d4, d5, d6), d);
    }

    public static final double absResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.copySign(response(d < 0.0d ? -d : d, d2, d3, d4, d5, d6), d);
    }

    @JvmOverloads
    @NotNull
    public static final ColorSpace adapt(@NotNull ColorSpace colorSpace, @NotNull WhitePoint whitePoint) {
        return adapt$default(colorSpace, whitePoint, null, 2, null);
    }

    public static /* synthetic */ ColorSpace adapt$default(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation, int i, Object obj) {
        if ((i & 2) != 0) {
            adaptation = Adaptation.INSTANCE.getBradford();
        }
        return adapt(colorSpace, whitePoint, adaptation);
    }

    @NotNull
    public static final float[] chromaticAdaptation(@NotNull float[] fArr, @NotNull float[] fArr2, @NotNull float[] fArr3) {
        float[] fArrMul3x3Float3 = mul3x3Float3(fArr, fArr2);
        float[] fArrMul3x3Float32 = mul3x3Float3(fArr, fArr3);
        return mul3x3(inverse3x3(fArr), mul3x3Diag(new float[]{fArrMul3x3Float32[0] / fArrMul3x3Float3[0], fArrMul3x3Float32[1] / fArrMul3x3Float3[1], fArrMul3x3Float32[2] / fArrMul3x3Float3[2]}, fArr));
    }

    public static final boolean compare(@NotNull TransferParameters transferParameters, @Nullable TransferParameters transferParameters2) {
        return transferParameters2 != null && Math.abs(transferParameters.getA() - transferParameters2.getA()) < 0.001d && Math.abs(transferParameters.getB() - transferParameters2.getB()) < 0.001d && Math.abs(transferParameters.getC() - transferParameters2.getC()) < 0.001d && Math.abs(transferParameters.getD() - transferParameters2.getD()) < 0.002d && Math.abs(transferParameters.getE() - transferParameters2.getE()) < 0.001d && Math.abs(transferParameters.getF() - transferParameters2.getF()) < 0.001d && Math.abs(transferParameters.getGamma() - transferParameters2.getGamma()) < 0.001d;
    }

    @NotNull
    /* JADX INFO: renamed from: connect-YBCOT_4, reason: not valid java name */
    public static final Connector m18943connectYBCOT_4(@NotNull ColorSpace colorSpace, @NotNull ColorSpace colorSpace2, int i) {
        int id$ui_graphics_release = colorSpace.getId();
        int id$ui_graphics_release2 = colorSpace2.getId();
        if ((id$ui_graphics_release | id$ui_graphics_release2) < 0) {
            return m18945createConnectorYBCOT_4(colorSpace, colorSpace2, i);
        }
        MutableIntObjectMap<Connector> connectors = ConnectorKt.getConnectors();
        int i2 = id$ui_graphics_release | (id$ui_graphics_release2 << 6) | (i << 12);
        Connector connectorM18945createConnectorYBCOT_4 = connectors.get(i2);
        if (connectorM18945createConnectorYBCOT_4 == null) {
            connectorM18945createConnectorYBCOT_4 = m18945createConnectorYBCOT_4(colorSpace, colorSpace2, i);
            connectors.set(i2, connectorM18945createConnectorYBCOT_4);
        }
        return connectorM18945createConnectorYBCOT_4;
    }

    /* JADX INFO: renamed from: connect-YBCOT_4$default, reason: not valid java name */
    public static /* synthetic */ Connector m18944connectYBCOT_4$default(ColorSpace colorSpace, ColorSpace colorSpace2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            colorSpace2 = ColorSpaces.INSTANCE.getSrgb();
        }
        if ((i2 & 2) != 0) {
            i = RenderIntent.INSTANCE.m18960getPerceptualuksYyKA();
        }
        return m18943connectYBCOT_4(colorSpace, colorSpace2, i);
    }

    /* JADX INFO: renamed from: createConnector-YBCOT_4, reason: not valid java name */
    private static final Connector m18945createConnectorYBCOT_4(ColorSpace colorSpace, ColorSpace colorSpace2, int i) {
        if (colorSpace == colorSpace2) {
            return Connector.INSTANCE.identity$ui_graphics_release(colorSpace);
        }
        long jM18941getModelxdoWZVw = colorSpace.getModel();
        ColorModel.Companion companion = ColorModel.INSTANCE;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (!ColorModel.m18932equalsimpl0(jM18941getModelxdoWZVw, companion.m18939getRgbxdoWZVw()) || !ColorModel.m18932equalsimpl0(colorSpace2.getModel(), companion.m18939getRgbxdoWZVw())) {
            return new Connector(colorSpace, colorSpace2, i, defaultConstructorMarker);
        }
        Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Intrinsics.checkNotNull(colorSpace2, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        return new Connector.RgbConnector((Rgb) colorSpace, (Rgb) colorSpace2, i, defaultConstructorMarker);
    }

    @NotNull
    public static final float[] inverse3x3(@NotNull float[] fArr) {
        float f = fArr[0];
        float f4 = fArr[3];
        float f5 = fArr[6];
        float f6 = fArr[1];
        float f7 = fArr[4];
        float f8 = fArr[7];
        float f9 = fArr[2];
        float f10 = fArr[5];
        float f11 = fArr[8];
        float f12 = (f7 * f11) - (f8 * f10);
        float f13 = (f8 * f9) - (f6 * f11);
        float f14 = (f6 * f10) - (f7 * f9);
        float f15 = (f5 * f14) + (f4 * f13) + (f * f12);
        float[] fArr2 = new float[fArr.length];
        fArr2[0] = f12 / f15;
        fArr2[1] = f13 / f15;
        fArr2[2] = f14 / f15;
        fArr2[3] = AbstractC0000a.m6c(f4, f11, f5 * f10, f15);
        fArr2[4] = AbstractC0000a.m6c(f5, f9, f11 * f, f15);
        fArr2[5] = AbstractC0000a.m6c(f, f10, f9 * f4, f15);
        fArr2[6] = AbstractC0000a.m6c(f5, f7, f4 * f8, f15);
        fArr2[7] = AbstractC0000a.m6c(f, f8, f5 * f6, f15);
        fArr2[8] = AbstractC0000a.m6c(f4, f6, f * f7, f15);
        return fArr2;
    }

    @NotNull
    public static final float[] mul3x3(@NotNull float[] fArr, @NotNull float[] fArr2) {
        float f = fArr[0];
        float f4 = fArr2[0];
        float f5 = fArr[3];
        float f6 = fArr2[1];
        float f7 = fArr[6];
        float f8 = fArr2[2];
        float f9 = (f7 * f8) + (f5 * f6) + (f * f4);
        float f10 = fArr[1];
        float f11 = fArr[4];
        float f12 = fArr[7];
        float f13 = (f12 * f8) + (f11 * f6) + (f10 * f4);
        float f14 = fArr[2];
        float f15 = fArr[5];
        float f16 = fArr[8];
        float f17 = (f8 * f16) + (f6 * f15) + (f4 * f14);
        float f18 = fArr2[3];
        float f19 = fArr2[4];
        float f20 = fArr2[5];
        float f21 = (f7 * f20) + (f5 * f19) + (f * f18);
        float f22 = (f12 * f20) + (f11 * f19) + (f10 * f18);
        float f23 = (f20 * f16) + (f19 * f15) + (f18 * f14);
        float f24 = fArr2[6];
        float f25 = fArr2[7];
        float f26 = (f5 * f25) + (f * f24);
        float f27 = fArr2[8];
        return new float[]{f9, f13, f17, f21, f22, f23, (f7 * f27) + f26, (f12 * f27) + (f11 * f25) + (f10 * f24), (f16 * f27) + (f15 * f25) + (f14 * f24)};
    }

    @NotNull
    public static final float[] mul3x3Diag(@NotNull float[] fArr, @NotNull float[] fArr2) {
        float f = fArr[0];
        float f4 = fArr2[0] * f;
        float f5 = fArr[1];
        float f6 = fArr2[1] * f5;
        float f7 = fArr[2];
        return new float[]{f4, f6, fArr2[2] * f7, fArr2[3] * f, fArr2[4] * f5, fArr2[5] * f7, f * fArr2[6], f5 * fArr2[7], f7 * fArr2[8]};
    }

    @NotNull
    public static final float[] mul3x3Float3(@NotNull float[] fArr, @NotNull float[] fArr2) {
        float f = fArr2[0];
        float f4 = fArr2[1];
        float f5 = fArr2[2];
        fArr2[0] = (fArr[6] * f5) + (fArr[3] * f4) + (fArr[0] * f);
        fArr2[1] = (fArr[7] * f5) + (fArr[4] * f4) + (fArr[1] * f);
        fArr2[2] = (fArr[8] * f5) + (fArr[5] * f4) + (fArr[2] * f);
        return fArr2;
    }

    public static final float mul3x3Float3_0(@NotNull float[] fArr, float f, float f4, float f5) {
        return (fArr[6] * f5) + (fArr[3] * f4) + (fArr[0] * f);
    }

    public static final float mul3x3Float3_1(@NotNull float[] fArr, float f, float f4, float f5) {
        return (fArr[7] * f5) + (fArr[4] * f4) + (fArr[1] * f);
    }

    public static final float mul3x3Float3_2(@NotNull float[] fArr, float f, float f4, float f5) {
        return (fArr[8] * f5) + (fArr[5] * f4) + (fArr[2] * f);
    }

    public static final double rcpResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= d5 * d4 ? (Math.pow(d, 1.0d / d6) - d3) / d2 : d / d4;
    }

    public static final double response(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= d5 ? Math.pow((d2 * d) + d3, d6) : d4 * d;
    }

    @JvmOverloads
    @NotNull
    public static final ColorSpace adapt(@NotNull ColorSpace colorSpace, @NotNull WhitePoint whitePoint, @NotNull Adaptation adaptation) {
        if (ColorModel.m18932equalsimpl0(colorSpace.getModel(), ColorModel.INSTANCE.m18939getRgbxdoWZVw())) {
            Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) colorSpace;
            if (!compare(rgb.getWhitePoint(), whitePoint)) {
                return new Rgb(rgb, mul3x3(chromaticAdaptation(adaptation.getTransform(), rgb.getWhitePoint().toXyz$ui_graphics_release(), whitePoint.toXyz$ui_graphics_release()), rgb.getTransform()), whitePoint);
            }
        }
        return colorSpace;
    }

    public static final double rcpResponse(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= d5 * d4 ? (Math.pow(d - d6, 1.0d / d8) - d3) / d2 : (d - d7) / d4;
    }

    public static final double response(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= d5 ? Math.pow((d2 * d) + d3, d8) + d6 : (d4 * d) + d7;
    }

    public static final boolean compare(@NotNull WhitePoint whitePoint, @NotNull WhitePoint whitePoint2) {
        if (whitePoint == whitePoint2) {
            return true;
        }
        return Math.abs(whitePoint.getX() - whitePoint2.getX()) < 0.001f && Math.abs(whitePoint.getY() - whitePoint2.getY()) < 0.001f;
    }

    public static final boolean compare(@NotNull float[] fArr, @NotNull float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (Float.compare(fArr[i], fArr2[i]) != 0 && Math.abs(fArr[i] - fArr2[i]) > 0.001f) {
                return false;
            }
        }
        return true;
    }
}
