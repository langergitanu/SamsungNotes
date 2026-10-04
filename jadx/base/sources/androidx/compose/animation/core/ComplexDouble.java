package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0011\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0011\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0000H\u0086\nR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/animation/core/ComplexDouble;", "", "_real", "", "_imaginary", "(DD)V", "imaginary", "getImaginary", "()D", "real", "getReal", "component1", "component2", "copy", "div", "other", "equals", "", "hashCode", "", "minus", "plus", "times", "toString", "", "unaryMinus", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComplexDouble.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComplexDouble.kt\nandroidx/compose/animation/core/ComplexDouble\n*L\n1#1,113:1\n35#1,2:114\n66#1,3:116\n40#1,3:119\n*S KotlinDebug\n*F\n+ 1 ComplexDouble.kt\nandroidx/compose/animation/core/ComplexDouble\n*L\n46#1:114,2\n50#1:116,3\n50#1:119,3\n*E\n"})
public final /* data */ class ComplexDouble {
    public static final int $stable = 8;
    private double _imaginary;
    private double _real;

    public ComplexDouble(double d, double d2) {
        this._real = d;
        this._imaginary = d2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final double get_real() {
        return this._real;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final double get_imaginary() {
        return this._imaginary;
    }

    public static /* synthetic */ ComplexDouble copy$default(ComplexDouble complexDouble, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = complexDouble._real;
        }
        if ((i & 2) != 0) {
            d2 = complexDouble._imaginary;
        }
        return complexDouble.copy(d, d2);
    }

    @NotNull
    public final ComplexDouble copy(double _real, double _imaginary) {
        return new ComplexDouble(_real, _imaginary);
    }

    @NotNull
    public final ComplexDouble div(double other) {
        this._real /= other;
        this._imaginary /= other;
        return this;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComplexDouble)) {
            return false;
        }
        ComplexDouble complexDouble = (ComplexDouble) other;
        return Double.compare(this._real, complexDouble._real) == 0 && Double.compare(this._imaginary, complexDouble._imaginary) == 0;
    }

    public final double getImaginary() {
        return this._imaginary;
    }

    public final double getReal() {
        return this._real;
    }

    public int hashCode() {
        return Double.hashCode(this._imaginary) + (Double.hashCode(this._real) * 31);
    }

    @NotNull
    public final ComplexDouble minus(double other) {
        this._real += -other;
        return this;
    }

    @NotNull
    public final ComplexDouble plus(double other) {
        this._real += other;
        return this;
    }

    @NotNull
    public final ComplexDouble times(double other) {
        this._real *= other;
        this._imaginary *= other;
        return this;
    }

    @NotNull
    public String toString() {
        return "ComplexDouble(_real=" + this._real + ", _imaginary=" + this._imaginary + PropertyUtils.MAPPED_DELIM2;
    }

    @NotNull
    public final ComplexDouble unaryMinus() {
        double d = -1;
        this._real *= d;
        this._imaginary *= d;
        return this;
    }

    @NotNull
    public final ComplexDouble minus(@NotNull ComplexDouble other) {
        double d = -1;
        other._real *= d;
        other._imaginary *= d;
        this._real = other.getReal() + this._real;
        this._imaginary = other.getImaginary() + this._imaginary;
        return this;
    }

    @NotNull
    public final ComplexDouble plus(@NotNull ComplexDouble other) {
        this._real = other.getReal() + this._real;
        this._imaginary = other.getImaginary() + this._imaginary;
        return this;
    }

    @NotNull
    public final ComplexDouble times(@NotNull ComplexDouble other) {
        this._real = (other.getReal() * getReal()) - (other.getImaginary() * getImaginary());
        this._imaginary = (getImaginary() * other.getReal()) + (other.getImaginary() * getReal());
        return this;
    }
}
