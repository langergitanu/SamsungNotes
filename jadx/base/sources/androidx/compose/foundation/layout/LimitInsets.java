package androidx.compose.foundation.layout;

import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, m13886d2 = {"Landroidx/compose/foundation/layout/LimitInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "(Landroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getSides-JoeWqyM", "()I", "I", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class LimitInsets implements WindowInsets {

    @NotNull
    private final WindowInsets insets;
    private final int sides;

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) other;
        return Intrinsics.areEqual(this.insets, limitInsets.insets) && WindowInsetsSides.m15934equalsimpl0(this.sides, limitInsets.sides);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        if (WindowInsetsSides.m15935hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.INSTANCE.m15945getBottomJoeWqyM())) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    @NotNull
    public final WindowInsets getInsets() {
        return this.insets;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        if (WindowInsetsSides.m15935hasAnybkgdKaI$foundation_layout_release(this.sides, layoutDirection == LayoutDirection.Ltr ? WindowInsetsSides.INSTANCE.m15941getAllowLeftInLtrJoeWqyM$foundation_layout_release() : WindowInsetsSides.INSTANCE.m15942getAllowLeftInRtlJoeWqyM$foundation_layout_release())) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        if (WindowInsetsSides.m15935hasAnybkgdKaI$foundation_layout_release(this.sides, layoutDirection == LayoutDirection.Ltr ? WindowInsetsSides.INSTANCE.m15943getAllowRightInLtrJoeWqyM$foundation_layout_release() : WindowInsetsSides.INSTANCE.m15944getAllowRightInRtlJoeWqyM$foundation_layout_release())) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    /* JADX INFO: renamed from: getSides-JoeWqyM, reason: not valid java name and from getter */
    public final int getSides() {
        return this.sides;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        if (WindowInsetsSides.m15935hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.INSTANCE.m15951getTopJoeWqyM())) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    public int hashCode() {
        return WindowInsetsSides.m15936hashCodeimpl(this.sides) + (this.insets.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "(" + this.insets + " only " + ((Object) WindowInsetsSides.m15938toStringimpl(this.sides)) + PropertyUtils.MAPPED_DELIM2;
    }

    private LimitInsets(WindowInsets windowInsets, int i) {
        this.insets = windowInsets;
        this.sides = i;
    }
}
