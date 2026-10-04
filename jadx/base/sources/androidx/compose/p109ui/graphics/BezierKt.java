package androidx.compose.p109ui.graphics;

import androidx.annotation.RestrictTo;
import androidx.collection.FloatFloatPair;
import androidx.compose.p109ui.graphics.PathSegment;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\t\u001a\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0082\b\u001a?\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001e\u001a'\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0010\u001e\u001aH\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0000\u001a \u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0002\u001a0\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0000\u001a \u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0007\u001a0\u00103\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a \u00109\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a(\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010;\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010<\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0003H\u0007\u001a\u0018\u0010=\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\u0018H\u0002\u001a(\u0010?\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a(\u0010B\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007\u001a\u0019\u0010C\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0082\b\u001a \u0010D\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002\u001a\u0018\u0010E\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0003H\u0007\u001a+\u0010G\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0082\b\u001a2\u0010H\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002\u001a \u0010I\u001a\u00020A2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002\u001a \u0010J\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0000\u001a(\u0010K\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002\u001a0\u0010M\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0018H\u0002\u001a\u0018\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0002\u001a0\u0010P\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0000\u001a0\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010U\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u0003H\u0002\u001a \u0010W\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010X\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002\u001a \u0010Y\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0015\u0010Z\u001a\u00020A*\u00020\u00012\u0006\u0010[\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010Z\u001a\u00020A*\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0005\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0019\u0010\u000b\u001a\u00020\u0003*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b\"\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\\"}, m13886d2 = {"Epsilon", "", "FloatEpsilon", "", "Tau", "endX", "Landroidx/compose/ui/graphics/PathSegment;", "getEndX", "(Landroidx/compose/ui/graphics/PathSegment;)F", "endY", "getEndY", "startX", "getStartX", "startY", "getStartY", "clampValidRootInUnitRange", "r", "computeCubicVerticalBounds", "Landroidx/collection/FloatFloatPair;", "p0y", "p1y", "p2y", "p3y", "roots", "", "index", "", "(FFFF[FI)J", "computeHorizontalBounds", "segment", "(Landroidx/compose/ui/graphics/PathSegment;[FI)J", "computeVerticalBounds", "cubicArea", "x0", "y0", "x1", "y1", "x2", "y2", "x3", "y3", "cubicToMonotonicCubics", "cubic", "dst", "tmpRoot", "cubicWinding", "points", "x", "y", "tmpCubics", "tmpRoots", "evaluateCubic", "p1", "p2", "t", "p0", "p3", "evaluateLine", "evaluateQuadratic", "evaluateX", "evaluateY", "findCubicExtremaY", "dstRoots", "findDerivativeRoots", "horizontal", "", "findFirstCubicRoot", "findFirstLineRoot", "findFirstQuadraticRoot", "findFirstRoot", "fraction", "findLineRoot", "findQuadraticRoots", "isQuadraticMonotonic", "lineWinding", "monotonicCubicWinding", TypedValues.Cycle.S_WAVE_OFFSET, "monotonicQuadraticWinding", "quadraticToMonotonicQuadratics", "quadratic", "quadraticWinding", "tmpQuadratics", "splitCubicAt", "", "src", "srcOffset", "dstOffset", "splitQuadraticAt", "unitDivide", "writeValidRootInUnitRange", "closeTo", "b", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBezier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Bezier.kt\nandroidx/compose/ui/graphics/BezierKt\n+ 2 MathHelpers.kt\nandroidx/compose/ui/util/MathHelpersKt\n*L\n1#1,1120:1\n230#1:1121\n571#1,7:1122\n571#1,7:1129\n571#1,7:1136\n571#1,7:1143\n571#1,7:1150\n560#1:1157\n560#1:1158\n560#1:1159\n571#1,7:1160\n571#1,7:1167\n571#1,7:1174\n571#1,7:1197\n571#1,7:1204\n571#1,7:1211\n571#1,7:1218\n571#1,7:1225\n571#1,7:1232\n359#1:1239\n359#1:1240\n1094#1:1241\n1094#1:1242\n1108#1:1243\n1108#1:1244\n359#1:1245\n571#1,7:1246\n563#1:1253\n563#1:1256\n97#2,16:1181\n49#2:1254\n60#2:1255\n71#2,16:1257\n*S KotlinDebug\n*F\n+ 1 Bezier.kt\nandroidx/compose/ui/graphics/BezierKt\n*L\n201#1:1121\n201#1:1122,7\n230#1:1129,7\n254#1:1136,7\n257#1:1143,7\n259#1:1150,7\n293#1:1157\n295#1:1158\n297#1:1159\n300#1:1160,7\n305#1:1167,7\n308#1:1174,7\n329#1:1197,7\n332#1:1204,7\n335#1:1211,7\n339#1:1218,7\n342#1:1225,7\n349#1:1232,7\n442#1:1239\n461#1:1240\n484#1:1241\n485#1:1242\n511#1:1243\n512#1:1244\n544#1:1245\n586#1:1246,7\n726#1:1253\n910#1:1256\n325#1:1181,16\n889#1:1254\n892#1:1255\n950#1:1257,16\n*E\n"})
public final class BezierKt {
    private static final double Epsilon = 1.0E-7d;
    private static final float FloatEpsilon = 8.34465E-7f;
    private static final double Tau = 6.283185307179586d;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final float clampValidRootInUnitRange(float f) {
        return f < 0.0f ? f >= -8.34465E-7f ? 0.0f : Float.NaN : f > 1.0f ? f <= 1.0000008f ? 1.0f : Float.NaN : f;
    }

    public static final boolean closeTo(double d, double d2) {
        return Math.abs(d - d2) < Epsilon;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final long computeCubicVerticalBounds(float f, float f4, float f5, float f6, @NotNull float[] fArr, int i) {
        float f7 = (f4 - f) * 3.0f;
        float f8 = (f5 - f4) * 3.0f;
        float f9 = (f6 - f5) * 3.0f;
        int iFindQuadraticRoots = findQuadraticRoots(f7, f8, f9, fArr, i);
        float f10 = (f8 - f7) * 2.0f;
        int iWriteValidRootInUnitRange = writeValidRootInUnitRange((-f10) / (((f9 - f8) * 2.0f) - f10), fArr, i + iFindQuadraticRoots) + iFindQuadraticRoots;
        float fMin = Math.min(f, f6);
        float fMax = Math.max(f, f6);
        for (int i2 = 0; i2 < iWriteValidRootInUnitRange; i2++) {
            float fEvaluateCubic = evaluateCubic(f, f4, f5, f6, fArr[i2]);
            fMin = Math.min(fMin, fEvaluateCubic);
            fMax = Math.max(fMax, fEvaluateCubic);
        }
        return FloatFloatPair.m15188constructorimpl(fMin, fMax);
    }

    public static /* synthetic */ long computeCubicVerticalBounds$default(float f, float f4, float f5, float f6, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            i = 0;
        }
        return computeCubicVerticalBounds(f, f4, f5, f6, fArr, i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final long computeHorizontalBounds(@NotNull PathSegment pathSegment, @NotNull float[] fArr, int i) {
        int iFindDerivativeRoots = findDerivativeRoots(pathSegment, true, fArr, i);
        float fMin = Math.min(pathSegment.getPoints()[0], getEndX(pathSegment));
        float fMax = Math.max(pathSegment.getPoints()[0], getEndX(pathSegment));
        for (int i2 = 0; i2 < iFindDerivativeRoots; i2++) {
            float fEvaluateX = evaluateX(pathSegment, fArr[i2]);
            fMin = Math.min(fMin, fEvaluateX);
            fMax = Math.max(fMax, fEvaluateX);
        }
        return FloatFloatPair.m15188constructorimpl(fMin, fMax);
    }

    public static /* synthetic */ long computeHorizontalBounds$default(PathSegment pathSegment, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return computeHorizontalBounds(pathSegment, fArr, i);
    }

    public static final long computeVerticalBounds(@NotNull PathSegment pathSegment, @NotNull float[] fArr, int i) {
        int iFindDerivativeRoots = findDerivativeRoots(pathSegment, false, fArr, i);
        float fMin = Math.min(pathSegment.getPoints()[1], getEndY(pathSegment));
        float fMax = Math.max(pathSegment.getPoints()[1], getEndY(pathSegment));
        for (int i2 = 0; i2 < iFindDerivativeRoots; i2++) {
            float fEvaluateY = evaluateY(pathSegment, fArr[i2]);
            fMin = Math.min(fMin, fEvaluateY);
            fMax = Math.max(fMax, fEvaluateY);
        }
        return FloatFloatPair.m15188constructorimpl(fMin, fMax);
    }

    public static /* synthetic */ long computeVerticalBounds$default(PathSegment pathSegment, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return computeVerticalBounds(pathSegment, fArr, i);
    }

    public static final float cubicArea(float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        return ((((((f / 3.0f) + f7) * f10) + (AbstractC0000a.m29z(f, f7, f6, ((f5 + f7) * (f10 - f4)) - ((f6 + f8) * (f9 - f))) - ((f4 - f8) * f5))) - (((f4 / 3.0f) + f8) * f9)) * 3.0f) / 20.0f;
    }

    private static final int cubicToMonotonicCubics(float[] fArr, float[] fArr2, float[] fArr3) {
        int iFindCubicExtremaY = findCubicExtremaY(fArr, fArr3);
        int i = 0;
        if (iFindCubicExtremaY == 0) {
            ArraysKt___ArraysJvmKt.copyInto(fArr, fArr2, 0, 0, 8);
            return iFindCubicExtremaY;
        }
        int i2 = 0;
        float f = 0.0f;
        while (i < iFindCubicExtremaY) {
            float f4 = (fArr3[i] - f) / (1.0f - f);
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            f = f4 > 1.0f ? 1.0f : f4;
            splitCubicAt(fArr, i2, fArr2, i2, f);
            i2 += 6;
            i++;
            fArr = fArr2;
        }
        return iFindCubicExtremaY;
    }

    public static final int cubicWinding(@NotNull float[] fArr, float f, float f4, @NotNull float[] fArr2, @NotNull float[] fArr3) {
        int iCubicToMonotonicCubics = cubicToMonotonicCubics(fArr, fArr2, fArr3);
        int iMonotonicCubicWinding = 0;
        if (iCubicToMonotonicCubics >= 0) {
            int i = 0;
            while (true) {
                iMonotonicCubicWinding += monotonicCubicWinding(fArr2, i * 6, f, f4);
                if (i == iCubicToMonotonicCubics) {
                    break;
                }
                i++;
            }
        }
        return iMonotonicCubicWinding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final float evaluateCubic(float f, float f4, float f5) {
        return ((((((f - f4) + 0.33333334f) * f5) + (f4 - (2.0f * f))) * f5) + f) * 3.0f * f5;
    }

    private static final float evaluateLine(float f, float f4, float f5) {
        return AbstractC0000a.m29z(f4, f, f5, f);
    }

    private static final float evaluateQuadratic(float f, float f4, float f5, float f6) {
        return (((((f5 - (f4 * 2.0f)) + f) * f6) + ((f4 - f) * 2.0f)) * f6) + f;
    }

    private static final float evaluateX(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
                return points[0];
            case 2:
                return evaluateLine(points[0], points[2], f);
            case 3:
                return evaluateQuadratic(points[0], points[2], points[4], f);
            case 4:
                return Float.NaN;
            case 5:
                return evaluateCubic(points[0], points[2], points[4], points[6], f);
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final float evaluateY(@NotNull PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
                return points[1];
            case 2:
                return evaluateLine(points[1], points[3], f);
            case 3:
                return evaluateQuadratic(points[1], points[3], points[5], f);
            case 4:
                return Float.NaN;
            case 5:
                return evaluateCubic(points[1], points[3], points[5], points[7], f);
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final int findCubicExtremaY(float[] fArr, float[] fArr2) {
        float f = fArr[1];
        float f4 = fArr[3];
        float f5 = fArr[5];
        return findQuadraticRoots(AbstractC0000a.m29z(f4, f5, 3.0f, fArr[7] - f), (((f - f4) - f4) - f5) * 2.0f, f4 - f, fArr2, 0);
    }

    private static final int findDerivativeRoots(PathSegment pathSegment, boolean z, float[] fArr, int i) {
        int i2 = !z ? 1 : 0;
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
            case 2:
                return 0;
            case 3:
                float f = 2;
                float f4 = points[i2 + 2];
                float f5 = (f4 - points[i2]) * f;
                return writeValidRootInUnitRange((-f5) / (((points[i2 + 4] - f4) * f) - f5), fArr, i);
            case 4:
                return 0;
            case 5:
                float f6 = points[i2 + 2];
                float f7 = (f6 - points[i2]) * 3.0f;
                float f8 = points[i2 + 4];
                float f9 = (f8 - f6) * 3.0f;
                float f10 = (points[i2 + 6] - f8) * 3.0f;
                int iFindQuadraticRoots = findQuadraticRoots(f7, f9, f10, fArr, i);
                float f11 = (f9 - f7) * 2.0f;
                return writeValidRootInUnitRange((-f11) / (((f10 - f9) * 2.0f) - f11), fArr, i + iFindQuadraticRoots) + iFindQuadraticRoots;
            case 6:
            case 7:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144  */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float findFirstCubicRoot(float f, float f4, float f5, float f6) {
        double d = f;
        double d2 = ((d - (((double) f4) * 2.0d)) + ((double) f5)) * 3.0d;
        double d3 = ((double) (f4 - f)) * 3.0d;
        double d4 = (((double) (f4 - f5)) * 3.0d) + ((double) (-f)) + ((double) f6);
        if (Math.abs(d4 - 0.0d) < Epsilon) {
            if (Math.abs(d2 - 0.0d) < Epsilon) {
                if (Math.abs(d3 - 0.0d) < Epsilon) {
                    return Float.NaN;
                }
                float f7 = (float) ((-d) / d3);
                return f7 < 0.0f ? f7 >= -8.34465E-7f ? 0.0f : Float.NaN : f7 > 1.0f ? f7 <= 1.0000008f ? 1.0f : Float.NaN : f7;
            }
            double dSqrt = Math.sqrt((d3 * d3) - ((4.0d * d2) * d));
            double d5 = d2 * 2.0d;
            float f8 = (float) ((dSqrt - d3) / d5);
            if (f8 < 0.0f) {
                f8 = f8 >= -8.34465E-7f ? 0.0f : Float.NaN;
            } else if (f8 > 1.0f) {
                if (f8 <= 1.0000008f) {
                    f8 = 1.0f;
                }
            }
            if (!Float.isNaN(f8)) {
                return f8;
            }
            float f9 = (float) (((-d3) - dSqrt) / d5);
            return f9 < 0.0f ? f9 >= -8.34465E-7f ? 0.0f : Float.NaN : f9 > 1.0f ? f9 <= 1.0000008f ? 1.0f : Float.NaN : f9;
        }
        double d6 = d2 / d4;
        double d7 = d3 / d4;
        double d8 = d / d4;
        double dM1333z = AbstractC1974b.m1333z(d6, d6, d7 * 3.0d, 9.0d);
        double dM1308a = AbstractC1974b.m1308a(d8, 27.0d, (((d6 * 2.0d) * d6) * d6) - ((d6 * 9.0d) * d7), 54.0d);
        double d9 = dM1333z * dM1333z * dM1333z;
        double d10 = (dM1308a * dM1308a) + d9;
        double d11 = d6 / 3.0d;
        if (d10 >= 0.0d) {
            if (d10 != 0.0d) {
                double dSqrt2 = Math.sqrt(d10);
                float fFastCbrt = (float) (((double) (MathHelpersKt.fastCbrt((float) ((-dM1308a) + dSqrt2)) - MathHelpersKt.fastCbrt((float) (dM1308a + dSqrt2)))) - d11);
                return fFastCbrt < 0.0f ? fFastCbrt >= -8.34465E-7f ? 0.0f : Float.NaN : fFastCbrt > 1.0f ? fFastCbrt <= 1.0000008f ? 1.0f : Float.NaN : fFastCbrt;
            }
            float f10 = -MathHelpersKt.fastCbrt((float) dM1308a);
            float f11 = (float) d11;
            float f12 = (2.0f * f10) - f11;
            if (f12 < 0.0f) {
                f12 = f12 >= -8.34465E-7f ? 0.0f : Float.NaN;
            } else if (f12 > 1.0f) {
                if (f12 <= 1.0000008f) {
                    f12 = 1.0f;
                }
            }
            if (!Float.isNaN(f12)) {
                return f12;
            }
            float f13 = (-f10) - f11;
            return f13 < 0.0f ? f13 >= -8.34465E-7f ? 0.0f : Float.NaN : f13 > 1.0f ? f13 <= 1.0000008f ? 1.0f : Float.NaN : f13;
        }
        double dSqrt3 = Math.sqrt(-d9);
        double d12 = (-dM1308a) / dSqrt3;
        if (d12 < -1.0d) {
            d12 = -1.0d;
        }
        if (d12 > 1.0d) {
            d12 = 1.0d;
        }
        double dAcos = Math.acos(d12);
        double dFastCbrt = MathHelpersKt.fastCbrt((float) dSqrt3) * 2.0f;
        float fCos = (float) ((Math.cos(dAcos / 3.0d) * dFastCbrt) - d11);
        if (fCos < 0.0f) {
            fCos = fCos >= -8.34465E-7f ? 0.0f : Float.NaN;
        } else if (fCos > 1.0f) {
            if (fCos <= 1.0000008f) {
                fCos = 1.0f;
            }
        }
        if (!Float.isNaN(fCos)) {
            return fCos;
        }
        float fCos2 = (float) ((Math.cos((Tau + dAcos) / 3.0d) * dFastCbrt) - d11);
        if (fCos2 < 0.0f) {
            fCos2 = fCos2 >= -8.34465E-7f ? 0.0f : Float.NaN;
        } else if (fCos2 > 1.0f) {
            if (fCos2 <= 1.0000008f) {
                fCos2 = 1.0f;
            }
        }
        if (!Float.isNaN(fCos2)) {
            return fCos2;
        }
        float fCos3 = (float) ((Math.cos((dAcos + 12.566370614359172d) / 3.0d) * dFastCbrt) - d11);
        return fCos3 < 0.0f ? fCos3 >= -8.34465E-7f ? 0.0f : Float.NaN : fCos3 > 1.0f ? fCos3 <= 1.0000008f ? 1.0f : Float.NaN : fCos3;
    }

    private static final float findFirstLineRoot(float f, float f4) {
        float f5 = (-f) / (f4 - f);
        return f5 < 0.0f ? f5 >= -8.34465E-7f ? 0.0f : Float.NaN : f5 > 1.0f ? f5 <= 1.0000008f ? 1.0f : Float.NaN : f5;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final float findFirstQuadraticRoot(float f, float f4, float f5) {
        double d = f;
        double d2 = f4;
        double d3 = f5;
        double d4 = d2 * 2.0d;
        double d5 = (d - d4) + d3;
        if (d5 == 0.0d) {
            if (d2 == d3) {
                return Float.NaN;
            }
            float f6 = (float) ((d4 - d3) / (d4 - (d3 * 2.0d)));
            return f6 < 0.0f ? f6 >= -8.34465E-7f ? 0.0f : Float.NaN : f6 > 1.0f ? f6 <= 1.0000008f ? 1.0f : Float.NaN : f6;
        }
        double d6 = -Math.sqrt((d2 * d2) - (d3 * d));
        double d7 = (-d) + d2;
        float f7 = (float) ((-(d6 + d7)) / d5);
        if (f7 < 0.0f) {
            f7 = f7 >= -8.34465E-7f ? 0.0f : Float.NaN;
        } else if (f7 > 1.0f) {
            if (f7 <= 1.0000008f) {
                f7 = 1.0f;
            }
        }
        if (!Float.isNaN(f7)) {
            return f7;
        }
        float f8 = (float) ((d6 - d7) / d5);
        return f8 < 0.0f ? f8 >= -8.34465E-7f ? 0.0f : Float.NaN : f8 > 1.0f ? f8 <= 1.0000008f ? 1.0f : Float.NaN : f8;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final float findFirstRoot(@NotNull PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
                return Float.NaN;
            case 2:
                float f4 = points[0] - f;
                float f5 = (-f4) / ((points[2] - f) - f4);
                return f5 < 0.0f ? f5 >= -8.34465E-7f ? 0.0f : Float.NaN : f5 > 1.0f ? f5 <= 1.0000008f ? 1.0f : Float.NaN : f5;
            case 3:
                return findFirstQuadraticRoot(points[0] - f, points[2] - f, points[4] - f);
            case 4:
                return Float.NaN;
            case 5:
                return findFirstCubicRoot(points[0] - f, points[2] - f, points[4] - f, points[6] - f);
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final int findLineRoot(float f, float f4, float[] fArr, int i) {
        return writeValidRootInUnitRange((-f) / (f4 - f), fArr, i);
    }

    public static /* synthetic */ int findLineRoot$default(float f, float f4, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return writeValidRootInUnitRange((-f) / (f4 - f), fArr, i);
    }

    private static final int findQuadraticRoots(float f, float f4, float f5, float[] fArr, int i) {
        double d = f;
        double d2 = f4;
        double d3 = f5;
        double d4 = d2 * 2.0d;
        double d5 = (d - d4) + d3;
        if (d5 == 0.0d) {
            if (d2 == d3) {
                return 0;
            }
            return writeValidRootInUnitRange((float) ((d4 - d3) / (d4 - (d3 * 2.0d))), fArr, i);
        }
        double d6 = -Math.sqrt((d2 * d2) - (d3 * d));
        double d7 = (-d) + d2;
        int iWriteValidRootInUnitRange = writeValidRootInUnitRange((float) ((-(d6 + d7)) / d5), fArr, i);
        int iWriteValidRootInUnitRange2 = iWriteValidRootInUnitRange + writeValidRootInUnitRange((float) ((d6 - d7) / d5), fArr, i + iWriteValidRootInUnitRange);
        if (iWriteValidRootInUnitRange2 <= 1) {
            return iWriteValidRootInUnitRange2;
        }
        float f6 = fArr[i];
        int i2 = i + 1;
        float f7 = fArr[i2];
        if (f6 <= f7) {
            return f6 == f7 ? iWriteValidRootInUnitRange2 - 1 : iWriteValidRootInUnitRange2;
        }
        fArr[i] = f7;
        fArr[i2] = f6;
        return iWriteValidRootInUnitRange2;
    }

    public static /* synthetic */ int findQuadraticRoots$default(float f, float f4, float f5, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            i = 0;
        }
        return findQuadraticRoots(f, f4, f5, fArr, i);
    }

    private static final float getEndX(PathSegment pathSegment) {
        float[] points = pathSegment.getPoints();
        char c = 4;
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
            case 6:
            case 7:
                c = 0;
                break;
            case 2:
                c = 2;
                break;
            case 3:
            case 4:
                break;
            case 5:
                c = 6;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return points[c];
    }

    private static final float getEndY(PathSegment pathSegment) {
        float[] points = pathSegment.getPoints();
        char c = 5;
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
            case 6:
            case 7:
                c = 0;
                break;
            case 2:
                c = 3;
                break;
            case 3:
            case 4:
                break;
            case 5:
                c = 7;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return points[c];
    }

    private static final float getStartX(PathSegment pathSegment) {
        return pathSegment.getPoints()[0];
    }

    private static final float getStartY(PathSegment pathSegment) {
        return pathSegment.getPoints()[1];
    }

    private static final boolean isQuadraticMonotonic(float f, float f4, float f5) {
        return !(Math.signum(f4 - f5) + Math.signum(f - f4) == 0.0f);
    }

    public static final int lineWinding(@NotNull float[] fArr, float f, float f4) {
        int i;
        float f5;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        float f9 = fArr[3];
        float f10 = f9 - f7;
        if (f7 > f9) {
            i = -1;
            f5 = f7;
        } else {
            i = 1;
            f5 = f9;
            f9 = f7;
        }
        if (f4 < f9 || f4 >= f5) {
            return 0;
        }
        float f11 = ((f4 - f7) * (f8 - f6)) - ((f - f6) * f10);
        if (f11 == 0.0f || ((int) Math.signum(f11)) == i) {
            return 0;
        }
        return i;
    }

    private static final int monotonicCubicWinding(float[] fArr, int i, float f, float f4) {
        int i2;
        int i4 = i + 1;
        float f5 = fArr[i4];
        int i5 = i + 7;
        float f6 = fArr[i5];
        if (f5 > f6) {
            i2 = -1;
            f6 = f5;
            f5 = f6;
        } else {
            i2 = 1;
        }
        if (f4 >= f5 && f4 < f6) {
            float f7 = fArr[i];
            float f8 = fArr[i + 2];
            float f9 = fArr[i + 4];
            float f10 = fArr[i + 6];
            if (f < Math.min(f7, Math.min(f8, Math.min(f9, f10)))) {
                return 0;
            }
            if (f <= Math.max(f7, Math.max(f8, Math.max(f9, f10)))) {
                float f11 = fArr[i4];
                float f12 = fArr[i + 3];
                float f13 = fArr[i + 5];
                float f14 = fArr[i5];
                float fFindFirstCubicRoot = findFirstCubicRoot(f11 - f4, f12 - f4, f13 - f4, f14 - f4);
                if (Float.isNaN(fFindFirstCubicRoot)) {
                    return 0;
                }
                float fEvaluateCubic = evaluateCubic(f7, f8, f9, f10, fFindFirstCubicRoot);
                if ((Math.abs(fEvaluateCubic - f) >= FloatEpsilon || (f == f10 && f4 == f14)) && fEvaluateCubic < f) {
                }
            }
            return i2;
        }
        return 0;
    }

    private static final int monotonicQuadraticWinding(float[] fArr, int i, float f, float f4, float[] fArr2) {
        int i2;
        float f5;
        float f6;
        float f7 = fArr[i + 1];
        float f8 = fArr[i + 5];
        if (f7 > f8) {
            i2 = -1;
            f6 = f7;
            f5 = f8;
        } else {
            i2 = 1;
            f5 = f7;
            f6 = f8;
        }
        if (f4 >= f5 && f4 < f6) {
            float f9 = fArr[i + 3];
            float fEvaluateQuadratic = findQuadraticRoots$default((f7 - (f9 * 2.0f)) + f8, (f9 - f7) * 2.0f, f7 - f4, fArr2, 0, 16, null) == 0 ? fArr[(1 - i2) * 2] : evaluateQuadratic(fArr[0], fArr[2], fArr[4], fArr2[0]);
            if ((Math.abs(fEvaluateQuadratic - f) >= FloatEpsilon || (f == fArr[4] && f4 == f8)) && fEvaluateQuadratic < f) {
                return i2;
            }
        }
        return 0;
    }

    private static final int quadraticToMonotonicQuadratics(float[] fArr, float[] fArr2) {
        float f = fArr[1];
        float f4 = fArr[3];
        float f5 = fArr[5];
        if (!isQuadraticMonotonic(f, f4, f5)) {
            float f6 = f - f4;
            float fUnitDivide = unitDivide(f6, (f6 - f4) + f5);
            if (!Float.isNaN(fUnitDivide)) {
                splitQuadraticAt(fArr, fArr2, fUnitDivide);
                return 1;
            }
            if (Math.abs(f6) >= Math.abs(f4 - f5)) {
                f = f5;
            }
            f4 = f;
        }
        ArraysKt___ArraysJvmKt.copyInto(fArr, fArr2, 0, 0, 6);
        fArr2[3] = f4;
        return 0;
    }

    public static final int quadraticWinding(@NotNull float[] fArr, float f, float f4, @NotNull float[] fArr2, @NotNull float[] fArr3) {
        if (isQuadraticMonotonic(fArr[1], fArr[3], fArr[5])) {
            return monotonicQuadraticWinding(fArr, 0, f, f4, fArr3);
        }
        int iQuadraticToMonotonicQuadratics = quadraticToMonotonicQuadratics(fArr, fArr2);
        int iMonotonicQuadraticWinding = monotonicQuadraticWinding(fArr2, 0, f, f4, fArr3);
        return iQuadraticToMonotonicQuadratics > 0 ? iMonotonicQuadraticWinding + monotonicQuadraticWinding(fArr2, 4, f, f4, fArr3) : iMonotonicQuadraticWinding;
    }

    private static final void splitCubicAt(float[] fArr, int i, float[] fArr2, int i2, float f) {
        if (f >= 1.0f) {
            ArraysKt___ArraysJvmKt.copyInto(fArr, fArr2, i2, i, 8);
            float f4 = fArr[i + 6];
            float f5 = fArr[i + 7];
            fArr2[i2 + 8] = f4;
            fArr2[i2 + 9] = f5;
            fArr2[i2 + 10] = f4;
            fArr2[i2 + 11] = f5;
            fArr2[i2 + 12] = f4;
            fArr2[i2 + 13] = f5;
            return;
        }
        float f6 = fArr[i];
        float f7 = fArr[i + 1];
        fArr2[i2] = f6;
        fArr2[i2 + 1] = f7;
        float f8 = fArr[i + 2];
        float f9 = fArr[i + 3];
        float fLerp = MathHelpersKt.lerp(f6, f8, f);
        float fLerp2 = MathHelpersKt.lerp(f7, f9, f);
        fArr2[i2 + 2] = fLerp;
        fArr2[i2 + 3] = fLerp2;
        float f10 = fArr[i + 4];
        float f11 = fArr[i + 5];
        float fLerp3 = MathHelpersKt.lerp(f8, f10, f);
        float fLerp4 = MathHelpersKt.lerp(f9, f11, f);
        float fLerp5 = MathHelpersKt.lerp(fLerp, fLerp3, f);
        float fLerp6 = MathHelpersKt.lerp(fLerp2, fLerp4, f);
        fArr2[i2 + 4] = fLerp5;
        fArr2[i2 + 5] = fLerp6;
        float f12 = fArr[i + 6];
        float f13 = fArr[i + 7];
        float fLerp7 = MathHelpersKt.lerp(f10, f12, f);
        float fLerp8 = MathHelpersKt.lerp(f11, f13, f);
        float fLerp9 = MathHelpersKt.lerp(fLerp3, fLerp7, f);
        float fLerp10 = MathHelpersKt.lerp(fLerp4, fLerp8, f);
        float fLerp11 = MathHelpersKt.lerp(fLerp5, fLerp9, f);
        float fLerp12 = MathHelpersKt.lerp(fLerp6, fLerp10, f);
        fArr2[i2 + 6] = fLerp11;
        fArr2[i2 + 7] = fLerp12;
        fArr2[i2 + 8] = fLerp9;
        fArr2[i2 + 9] = fLerp10;
        fArr2[i2 + 10] = fLerp7;
        fArr2[i2 + 11] = fLerp8;
        fArr2[i2 + 12] = f12;
        fArr2[i2 + 13] = f13;
    }

    private static final void splitQuadraticAt(float[] fArr, float[] fArr2, float f) {
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[2];
        float f7 = fArr[3];
        float f8 = fArr[4];
        float f9 = fArr[5];
        float fLerp = MathHelpersKt.lerp(f4, f6, f);
        float fLerp2 = MathHelpersKt.lerp(f5, f7, f);
        fArr2[0] = f4;
        fArr2[1] = f5;
        fArr2[2] = fLerp;
        fArr2[3] = fLerp2;
        float fLerp3 = MathHelpersKt.lerp(f6, f8, f);
        float fLerp4 = MathHelpersKt.lerp(f7, f9, f);
        float fLerp5 = MathHelpersKt.lerp(fLerp, fLerp3, f);
        float fLerp6 = MathHelpersKt.lerp(fLerp2, fLerp4, f);
        fArr2[4] = fLerp5;
        fArr2[5] = fLerp6;
        fArr2[6] = fLerp3;
        fArr2[7] = fLerp4;
        fArr2[8] = f8;
        fArr2[9] = f9;
    }

    private static final float unitDivide(float f, float f4) {
        if (f < 0.0f) {
            f = -f;
            f4 = -f4;
        }
        if (f4 == 0.0f || f == 0.0f || f >= f4) {
            return Float.NaN;
        }
        float f5 = f / f4;
        if (f5 == 0.0f) {
            return Float.NaN;
        }
        return f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[PHI: r0
      0x000d: PHI (r0v2 float) = (r0v1 float), (r0v0 float) binds: [B:11:0x001c, B:5:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int writeValidRootInUnitRange(float f, float[] fArr, int i) {
        float f4 = 0.0f;
        if (f < 0.0f) {
            f = f >= -8.34465E-7f ? f4 : Float.NaN;
        } else {
            f4 = 1.0f;
            if (f > 1.0f) {
                if (f <= 1.0000008f) {
                }
            }
        }
        fArr[i] = f;
        return !Float.isNaN(f) ? 1 : 0;
    }

    public static final boolean closeTo(float f, float f4) {
        return Math.abs(f - f4) < FloatEpsilon;
    }

    private static final float evaluateCubic(float f, float f4, float f5, float f6, float f7) {
        float f8 = (((f4 - f5) * 3.0f) + f6) - f;
        return (((((f8 * f7) + (((f5 - (2.0f * f4)) + f) * 3.0f)) * f7) + ((f4 - f) * 3.0f)) * f7) + f;
    }
}
