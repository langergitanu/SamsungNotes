package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/material3/ResistanceConfig;", "", "basis", "", "factorAtMin", "factorAtMax", "(FFF)V", "getBasis", "()F", "getFactorAtMax", "getFactorAtMin", "computeResistance", "overflow", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResistanceConfig {
    private final float basis;
    private final float factorAtMax;
    private final float factorAtMin;

    public ResistanceConfig(float f, float f4, float f5) {
        this.basis = f;
        this.factorAtMin = f4;
        this.factorAtMax = f5;
    }

    public final float computeResistance(float overflow) {
        float f = overflow < 0.0f ? this.factorAtMin : this.factorAtMax;
        if (f == 0.0f) {
            return 0.0f;
        }
        return (this.basis / f) * ((float) Math.sin((RangesKt.coerceIn(overflow / this.basis, -1.0f, 1.0f) * 3.1415927f) / 2));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResistanceConfig)) {
            return false;
        }
        ResistanceConfig resistanceConfig = (ResistanceConfig) other;
        return this.basis == resistanceConfig.basis && this.factorAtMin == resistanceConfig.factorAtMin && this.factorAtMax == resistanceConfig.factorAtMax;
    }

    public final float getBasis() {
        return this.basis;
    }

    public final float getFactorAtMax() {
        return this.factorAtMax;
    }

    public final float getFactorAtMin() {
        return this.factorAtMin;
    }

    public int hashCode() {
        return Float.hashCode(this.factorAtMax) + AbstractC0622a.m1156b(this.factorAtMin, Float.hashCode(this.basis) * 31, 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ResistanceConfig(basis=");
        sb.append(this.basis);
        sb.append(", factorAtMin=");
        sb.append(this.factorAtMin);
        sb.append(", factorAtMax=");
        return AbstractC0622a.m1171q(sb, this.factorAtMax, PropertyUtils.MAPPED_DELIM2);
    }

    public /* synthetic */ ResistanceConfig(float f, float f4, float f5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? 10.0f : f4, (i & 4) != 0 ? 10.0f : f5);
    }
}
