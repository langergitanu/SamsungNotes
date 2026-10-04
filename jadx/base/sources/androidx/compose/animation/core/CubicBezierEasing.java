package androidx.compose.animation.core;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.BezierKt;
import androidx.compose.runtime.Immutable;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", "a", "", "b", "c", "d", "(FFFF)V", VElementFormulasCmd.FMAX, VElementFormulasCmd.FMIN, "equals", "", "other", "", "hashCode", "", "throwNoSolution", "", "fraction", "toString", "", "transform", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEasing.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Easing.kt\nandroidx/compose/animation/core/CubicBezierEasing\n+ 2 Preconditions.kt\nandroidx/compose/animation/core/PreconditionsKt\n+ 3 FloatFloatPair.kt\nandroidx/collection/FloatFloatPair\n+ 4 PackingHelpers.jvm.kt\nandroidx/collection/internal/PackingHelpers_jvmKt\n+ 5 MathHelpers.kt\nandroidx/compose/ui/util/MathHelpersKt\n*L\n1#1,172:1\n33#2,7:173\n48#3:180\n54#3:182\n22#4:181\n22#4:183\n71#5,16:184\n*S KotlinDebug\n*F\n+ 1 Easing.kt\nandroidx/compose/animation/core/CubicBezierEasing\n*L\n115#1:173,7\n120#1:180\n121#1:182\n120#1:181\n121#1:183\n149#1:184,16\n*E\n"})
public final class CubicBezierEasing implements Easing {
    public static final int $stable = 0;
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float max;
    private final float min;

    public CubicBezierEasing(float f, float f4, float f5, float f6) {
        this.a = f;
        this.b = f4;
        this.c = f5;
        this.d = f6;
        if (!((Float.isNaN(f) || Float.isNaN(f4) || Float.isNaN(f5) || Float.isNaN(f6)) ? false : true)) {
            StringBuilder sbM1176v = AbstractC0622a.m1176v("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: ", f, SQLKeyword.COMMA, f4, SQLKeyword.COMMA);
            sbM1176v.append(f5);
            sbM1176v.append(SQLKeyword.COMMA);
            sbM1176v.append(f6);
            sbM1176v.append('.');
            PreconditionsKt.throwIllegalArgumentException(sbM1176v.toString());
        }
        long jComputeCubicVerticalBounds = BezierKt.computeCubicVerticalBounds(0.0f, f4, f6, 1.0f, new float[5], 0);
        this.min = Float.intBitsToFloat((int) (jComputeCubicVerticalBounds >> 32));
        this.max = Float.intBitsToFloat((int) (jComputeCubicVerticalBounds & 4294967295L));
    }

    private final void throwNoSolution(float fraction) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.a + SQLKeyword.COMMA + this.b + SQLKeyword.COMMA + this.c + SQLKeyword.COMMA + this.d + ") has no solution at " + fraction);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CubicBezierEasing)) {
            return false;
        }
        CubicBezierEasing cubicBezierEasing = (CubicBezierEasing) other;
        return this.a == cubicBezierEasing.a && this.b == cubicBezierEasing.b && this.c == cubicBezierEasing.c && this.d == cubicBezierEasing.d;
    }

    public int hashCode() {
        return Float.hashCode(this.d) + AbstractC0622a.m1156b(this.c, AbstractC0622a.m1156b(this.b, Float.hashCode(this.a) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("CubicBezierEasing(a=");
        sb.append(this.a);
        sb.append(", b=");
        sb.append(this.b);
        sb.append(", c=");
        sb.append(this.c);
        sb.append(", d=");
        return AbstractC0622a.m1171q(sb, this.d, PropertyUtils.MAPPED_DELIM2);
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float fraction) {
        if (fraction > 0.0f && fraction < 1.0f) {
            float fFindFirstCubicRoot = BezierKt.findFirstCubicRoot(0.0f - fraction, this.a - fraction, this.c - fraction, 1.0f - fraction);
            if (Float.isNaN(fFindFirstCubicRoot)) {
                throwNoSolution(fraction);
            }
            fraction = BezierKt.evaluateCubic(this.b, this.d, fFindFirstCubicRoot);
            float f = this.min;
            float f4 = this.max;
            if (fraction < f) {
                fraction = f;
            }
            if (fraction > f4) {
                return f4;
            }
        }
        return fraction;
    }
}
