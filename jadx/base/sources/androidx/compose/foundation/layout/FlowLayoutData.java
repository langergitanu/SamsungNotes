package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/foundation/layout/FlowLayoutData;", "", "fillCrossAxisFraction", "", "(F)V", "getFillCrossAxisFraction", "()F", "setFillCrossAxisFraction", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class FlowLayoutData {
    public static final int $stable = 8;
    private float fillCrossAxisFraction;

    public FlowLayoutData(float f) {
        this.fillCrossAxisFraction = f;
    }

    public static /* synthetic */ FlowLayoutData copy$default(FlowLayoutData flowLayoutData, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = flowLayoutData.fillCrossAxisFraction;
        }
        return flowLayoutData.copy(f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getFillCrossAxisFraction() {
        return this.fillCrossAxisFraction;
    }

    @NotNull
    public final FlowLayoutData copy(float fillCrossAxisFraction) {
        return new FlowLayoutData(fillCrossAxisFraction);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FlowLayoutData) && Float.compare(this.fillCrossAxisFraction, ((FlowLayoutData) other).fillCrossAxisFraction) == 0;
    }

    public final float getFillCrossAxisFraction() {
        return this.fillCrossAxisFraction;
    }

    public int hashCode() {
        return Float.hashCode(this.fillCrossAxisFraction);
    }

    public final void setFillCrossAxisFraction(float f) {
        this.fillCrossAxisFraction = f;
    }

    @NotNull
    public String toString() {
        return AbstractC0622a.m1171q(new StringBuilder("FlowLayoutData(fillCrossAxisFraction="), this.fillCrossAxisFraction, PropertyUtils.MAPPED_DELIM2);
    }
}
