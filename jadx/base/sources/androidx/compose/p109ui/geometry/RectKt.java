package androidx.compose.p109ui.geometry;

import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\rH\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, m13886d2 = {"Rect", "Landroidx/compose/ui/geometry/Rect;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "bottomRight", "Rect-0a9Yr6o", "(JJ)Landroidx/compose/ui/geometry/Rect;", TypedValues.Cycle.S_WAVE_OFFSET, "size", "Landroidx/compose/ui/geometry/Size;", "Rect-tz77jQw", "center", "radius", "", "Rect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/Rect;", "lerp", "start", "stop", "fraction", "ui-geometry_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RectKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m18322Rect0a9Yr6o(long j, long j2) {
        return new Rect(Offset.m18284getXimpl(j), Offset.m18285getYimpl(j), Offset.m18284getXimpl(j2), Offset.m18285getYimpl(j2));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m18323Rect3MmeM6k(long j, float f) {
        return new Rect(Offset.m18284getXimpl(j) - f, Offset.m18285getYimpl(j) - f, Offset.m18284getXimpl(j) + f, Offset.m18285getYimpl(j) + f);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m18324Recttz77jQw(long j, long j2) {
        return new Rect(Offset.m18284getXimpl(j), Offset.m18285getYimpl(j), Size.m18353getWidthimpl(j2) + Offset.m18284getXimpl(j), Size.m18350getHeightimpl(j2) + Offset.m18285getYimpl(j));
    }

    @Stable
    @NotNull
    public static final Rect lerp(@NotNull Rect rect, @NotNull Rect rect2, float f) {
        return new Rect(MathHelpersKt.lerp(rect.getLeft(), rect2.getLeft(), f), MathHelpersKt.lerp(rect.getTop(), rect2.getTop(), f), MathHelpersKt.lerp(rect.getRight(), rect2.getRight(), f), MathHelpersKt.lerp(rect.getBottom(), rect2.getBottom(), f));
    }
}
