package androidx.compose.foundation.shape;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J0\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018JB\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getBottomEnd", "()Landroidx/compose/foundation/shape/CornerSize;", "getBottomStart", "getTopEnd", "getTopStart", "copy", "all", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class CornerBasedShape implements Shape {
    public static final int $stable = 0;

    @NotNull
    private final CornerSize bottomEnd;

    @NotNull
    private final CornerSize bottomStart;

    @NotNull
    private final CornerSize topEnd;

    @NotNull
    private final CornerSize topStart;

    public CornerBasedShape(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        this.topStart = cornerSize;
        this.topEnd = cornerSize2;
        this.bottomEnd = cornerSize3;
        this.bottomStart = cornerSize4;
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            cornerSize = cornerBasedShape.topStart;
        }
        if ((i & 2) != 0) {
            cornerSize2 = cornerBasedShape.topEnd;
        }
        if ((i & 4) != 0) {
            cornerSize3 = cornerBasedShape.bottomEnd;
        }
        if ((i & 8) != 0) {
            cornerSize4 = cornerBasedShape.bottomStart;
        }
        return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    @NotNull
    public final CornerBasedShape copy(@NotNull CornerSize all) {
        return copy(all, all, all, all);
    }

    @NotNull
    public abstract CornerBasedShape copy(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart);

    @NotNull
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo16120createOutlineLjSzlW0(long size, float topStart, float topEnd, float bottomEnd, float bottomStart, @NotNull LayoutDirection layoutDirection);

    @Override // androidx.compose.p109ui.graphics.Shape
    @NotNull
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final Outline mo15457createOutlinePq9zytI(long size, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        float fMo16128toPxTmRCtEA = this.topStart.mo16128toPxTmRCtEA(size, density);
        float fMo16128toPxTmRCtEA2 = this.topEnd.mo16128toPxTmRCtEA(size, density);
        float fMo16128toPxTmRCtEA3 = this.bottomEnd.mo16128toPxTmRCtEA(size, density);
        float fMo16128toPxTmRCtEA4 = this.bottomStart.mo16128toPxTmRCtEA(size, density);
        float fM18352getMinDimensionimpl = Size.m18352getMinDimensionimpl(size);
        float f = fMo16128toPxTmRCtEA + fMo16128toPxTmRCtEA4;
        if (f > fM18352getMinDimensionimpl) {
            float f4 = fM18352getMinDimensionimpl / f;
            fMo16128toPxTmRCtEA *= f4;
            fMo16128toPxTmRCtEA4 *= f4;
        }
        float f5 = fMo16128toPxTmRCtEA2 + fMo16128toPxTmRCtEA3;
        if (f5 > fM18352getMinDimensionimpl) {
            float f6 = fM18352getMinDimensionimpl / f5;
            fMo16128toPxTmRCtEA2 *= f6;
            fMo16128toPxTmRCtEA3 *= f6;
        }
        if (fMo16128toPxTmRCtEA < 0.0f || fMo16128toPxTmRCtEA2 < 0.0f || fMo16128toPxTmRCtEA3 < 0.0f || fMo16128toPxTmRCtEA4 < 0.0f) {
            throw new IllegalArgumentException(AbstractC1038a.m1216q(AbstractC0622a.m1176v("Corner size in Px can't be negative(topStart = ", fMo16128toPxTmRCtEA, ", topEnd = ", fMo16128toPxTmRCtEA2, ", bottomEnd = "), fMo16128toPxTmRCtEA3, ", bottomStart = ", fMo16128toPxTmRCtEA4, ")!").toString());
        }
        return mo16120createOutlineLjSzlW0(size, fMo16128toPxTmRCtEA, fMo16128toPxTmRCtEA2, fMo16128toPxTmRCtEA3, fMo16128toPxTmRCtEA4, layoutDirection);
    }

    @NotNull
    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    @NotNull
    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    @NotNull
    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    @NotNull
    public final CornerSize getTopStart() {
        return this.topStart;
    }
}
