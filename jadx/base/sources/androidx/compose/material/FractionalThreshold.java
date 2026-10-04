package androidx.compose.material;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u001c\u0010\u000f\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/material/FractionalThreshold;", "Landroidx/compose/material/ThresholdConfig;", "fraction", "", "(F)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "computeThreshold", "Landroidx/compose/ui/unit/Density;", "fromValue", "toValue", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@ExperimentalMaterialApi
public final /* data */ class FractionalThreshold implements ThresholdConfig {
    private final float fraction;

    public FractionalThreshold(float f) {
        this.fraction = f;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final float getFraction() {
        return this.fraction;
    }

    public static /* synthetic */ FractionalThreshold copy$default(FractionalThreshold fractionalThreshold, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = fractionalThreshold.fraction;
        }
        return fractionalThreshold.copy(f);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public float computeThreshold(@NotNull Density density, float f, float f4) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return MathHelpersKt.lerp(f, f4, this.fraction);
    }

    @NotNull
    public final FractionalThreshold copy(float fraction) {
        return new FractionalThreshold(fraction);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FractionalThreshold) && Intrinsics.areEqual((Object) Float.valueOf(this.fraction), (Object) Float.valueOf(((FractionalThreshold) other).fraction));
    }

    public int hashCode() {
        return Float.hashCode(this.fraction);
    }

    @NotNull
    public String toString() {
        return AbstractC0622a.m1171q(new StringBuilder("FractionalThreshold(fraction="), this.fraction, PropertyUtils.MAPPED_DELIM2);
    }
}
