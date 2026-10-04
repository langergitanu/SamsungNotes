package androidx.compose.foundation.shape;

import androidx.compose.p109ui.geometry.CornerRadiusKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.RoundRectKt;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016JB\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/foundation/shape/RoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public RoundedCornerShape(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo16120createOutlineLjSzlW0(long size, float topStart, float topEnd, float bottomEnd, float bottomStart, @NotNull LayoutDirection layoutDirection) {
        if (topStart + topEnd + bottomEnd + bottomStart == 0.0f) {
            return new Outline.Rectangle(SizeKt.m18374toRectuvyYCjk(size));
        }
        Rect rectM18374toRectuvyYCjk = SizeKt.m18374toRectuvyYCjk(size);
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        return new Outline.Rounded(RoundRectKt.m18336RoundRectZAM2FJo(rectM18374toRectuvyYCjk, CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? topStart : topEnd, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? topEnd : topStart, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? bottomEnd : bottomStart, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? bottomStart : bottomEnd, 0.0f, 2, null)));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoundedCornerShape)) {
            return false;
        }
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) other;
        return Intrinsics.areEqual(getTopStart(), roundedCornerShape.getTopStart()) && Intrinsics.areEqual(getTopEnd(), roundedCornerShape.getTopEnd()) && Intrinsics.areEqual(getBottomEnd(), roundedCornerShape.getBottomEnd()) && Intrinsics.areEqual(getBottomStart(), roundedCornerShape.getBottomStart());
    }

    public int hashCode() {
        return getBottomStart().hashCode() + ((getBottomEnd().hashCode() + ((getTopEnd().hashCode() + (getTopStart().hashCode() * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "RoundedCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    public RoundedCornerShape copy(@NotNull CornerSize topStart, @NotNull CornerSize topEnd, @NotNull CornerSize bottomEnd, @NotNull CornerSize bottomStart) {
        return new RoundedCornerShape(topStart, topEnd, bottomEnd, bottomStart);
    }
}
