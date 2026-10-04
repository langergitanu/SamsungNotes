package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n¨\u0006\r"}, m13886d2 = {"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComplexDouble.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComplexDouble.kt\nandroidx/compose/animation/core/ComplexDoubleKt\n+ 2 ComplexDouble.kt\nandroidx/compose/animation/core/ComplexDouble\n*L\n1#1,113:1\n103#1:114\n107#1:120\n103#1:124\n103#1:135\n35#2,2:115\n54#2,3:117\n66#2,3:121\n35#2,2:125\n54#2,3:127\n35#2,2:130\n66#2,3:132\n35#2,2:136\n54#2,3:138\n*S KotlinDebug\n*F\n+ 1 ComplexDouble.kt\nandroidx/compose/animation/core/ComplexDoubleKt\n*L\n88#1:114\n89#1:120\n89#1:124\n107#1:135\n88#1:115,2\n88#1:117,3\n89#1:121,3\n89#1:125,2\n89#1:127,3\n103#1:130,2\n107#1:132,3\n107#1:136,2\n111#1:138,3\n*E\n"})
public final class ComplexDoubleKt {
    @NotNull
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d, double d2, double d3) {
        double d4 = (d2 * d2) - ((4.0d * d) * d3);
        double d5 = 1.0d / (d * 2.0d);
        double d6 = -d2;
        ComplexDouble complexDoubleComplexSqrt = complexSqrt(d4);
        complexDoubleComplexSqrt._real += d6;
        complexDoubleComplexSqrt._real *= d5;
        complexDoubleComplexSqrt._imaginary *= d5;
        ComplexDouble complexDoubleComplexSqrt2 = complexSqrt(d4);
        double d7 = -1;
        complexDoubleComplexSqrt2._real *= d7;
        complexDoubleComplexSqrt2._imaginary *= d7;
        complexDoubleComplexSqrt2._real += d6;
        complexDoubleComplexSqrt2._real *= d5;
        complexDoubleComplexSqrt2._imaginary *= d5;
        return TuplesKt.m13893to(complexDoubleComplexSqrt, complexDoubleComplexSqrt2);
    }

    @NotNull
    public static final ComplexDouble complexSqrt(double d) {
        return d < 0.0d ? new ComplexDouble(0.0d, Math.sqrt(Math.abs(d))) : new ComplexDouble(Math.sqrt(d), 0.0d);
    }

    @NotNull
    public static final ComplexDouble minus(double d, @NotNull ComplexDouble complexDouble) {
        double d2 = -1;
        complexDouble._real *= d2;
        complexDouble._imaginary *= d2;
        complexDouble._real += d;
        return complexDouble;
    }

    @NotNull
    public static final ComplexDouble plus(double d, @NotNull ComplexDouble complexDouble) {
        complexDouble._real += d;
        return complexDouble;
    }

    @NotNull
    public static final ComplexDouble times(double d, @NotNull ComplexDouble complexDouble) {
        complexDouble._real *= d;
        complexDouble._imaginary *= d;
        return complexDouble;
    }
}
