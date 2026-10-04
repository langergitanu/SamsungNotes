package androidx.compose.foundation.shape;

import androidx.annotation.FloatRange;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.platform.InspectableValue;
import androidx.compose.p109ui.unit.Density;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/foundation/shape/PercentCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "percent", "", "(F)V", "valueOverride", "", "getValueOverride", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toPx", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class PercentCornerSize implements CornerSize, InspectableValue {
    private final float percent;

    public PercentCornerSize(@FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2) float f) {
        this.percent = f;
        if (f < 0.0f || f > 100.0f) {
            throw new IllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final float getPercent() {
        return this.percent;
    }

    public static /* synthetic */ PercentCornerSize copy$default(PercentCornerSize percentCornerSize, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = percentCornerSize.percent;
        }
        return percentCornerSize.copy(f);
    }

    @NotNull
    public final PercentCornerSize copy(@FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2) float percent) {
        return new PercentCornerSize(percent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PercentCornerSize) && Float.compare(this.percent, ((PercentCornerSize) other).percent) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.percent);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo16128toPxTmRCtEA(long shapeSize, @NotNull Density density) {
        return (this.percent / 100.0f) * Size.m18352getMinDimensionimpl(shapeSize);
    }

    @NotNull
    public String toString() {
        return AbstractC1038a.m1217r(new StringBuilder("CornerSize(size = "), "%)", this.percent);
    }

    @Override // androidx.compose.p109ui.platform.InspectableValue
    @NotNull
    public String getValueOverride() {
        return AbstractC0622a.m1171q(new StringBuilder(), this.percent, '%');
    }
}
