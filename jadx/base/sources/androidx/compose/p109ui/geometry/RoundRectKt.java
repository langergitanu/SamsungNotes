package androidx.compose.p109ui.geometry;

import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a@\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a8\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001c\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, m13886d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", TypedValues.Cycle.S_WAVE_OFFSET, "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RoundRectKt {
    @NotNull
    public static final RoundRect RoundRect(float f, float f4, float f5, float f6, float f7, float f8) {
        long jCornerRadius = CornerRadiusKt.CornerRadius(f7, f8);
        return new RoundRect(f, f4, f5, f6, jCornerRadius, jCornerRadius, jCornerRadius, jCornerRadius, null);
    }

    @NotNull
    /* JADX INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m18336RoundRectZAM2FJo(@NotNull Rect rect, long j, long j2, long j3, long j5) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j5, null);
    }

    @NotNull
    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m18338RoundRectgG7oq9Y(float f, float f4, float f5, float f6, long j) {
        return RoundRect(f, f4, f5, f6, CornerRadius.m18259getXimpl(j), CornerRadius.m18260getYimpl(j));
    }

    @NotNull
    /* JADX INFO: renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m18339RoundRectsniSvfs(@NotNull Rect rect, long j) {
        return RoundRect(rect, CornerRadius.m18259getXimpl(j), CornerRadius.m18260getYimpl(j));
    }

    @NotNull
    public static final Rect getBoundingRect(@NotNull RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final long getCenter(@NotNull RoundRect roundRect) {
        return OffsetKt.Offset((roundRect.getWidth() / 2.0f) + roundRect.getLeft(), (roundRect.getHeight() / 2.0f) + roundRect.getTop());
    }

    public static final float getMaxDimension(@NotNull RoundRect roundRect) {
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMinDimension(@NotNull RoundRect roundRect) {
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    @NotNull
    public static final Rect getSafeInnerRect(@NotNull RoundRect roundRect) {
        float fMax = Math.max(CornerRadius.m18259getXimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()));
        float fMax2 = Math.max(CornerRadius.m18260getYimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m18260getYimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()));
        return new Rect((fMax * 0.29289323f) + roundRect.getLeft(), (fMax2 * 0.29289323f) + roundRect.getTop(), roundRect.getRight() - (Math.max(CornerRadius.m18259getXimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()), CornerRadius.m18259getXimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m18260getYimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m18260getYimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isCircle(@NotNull RoundRect roundRect) {
        return roundRect.getWidth() == roundRect.getHeight() && isEllipse(roundRect);
    }

    public static final boolean isEllipse(@NotNull RoundRect roundRect) {
        return CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18259getXimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m18260getYimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18260getYimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m18259getXimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m18259getXimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m18260getYimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m18260getYimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m18259getXimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m18259getXimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m18260getYimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m18260getYimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()) && ((double) roundRect.getWidth()) <= ((double) CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs())) * 2.0d && ((double) roundRect.getHeight()) <= ((double) CornerRadius.m18260getYimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs())) * 2.0d;
    }

    public static final boolean isEmpty(@NotNull RoundRect roundRect) {
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(@NotNull RoundRect roundRect) {
        float left = roundRect.getLeft();
        if (Float.isInfinite(left) || Float.isNaN(left)) {
            return false;
        }
        float top = roundRect.getTop();
        if (Float.isInfinite(top) || Float.isNaN(top)) {
            return false;
        }
        float right = roundRect.getRight();
        if (Float.isInfinite(right) || Float.isNaN(right)) {
            return false;
        }
        float bottom = roundRect.getBottom();
        return (Float.isInfinite(bottom) || Float.isNaN(bottom)) ? false : true;
    }

    public static final boolean isRect(@NotNull RoundRect roundRect) {
        if (CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) != 0.0f && CornerRadius.m18260getYimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) != 0.0f) {
            return false;
        }
        if (CornerRadius.m18259getXimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) != 0.0f && CornerRadius.m18260getYimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) != 0.0f) {
            return false;
        }
        if (CornerRadius.m18259getXimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m18260getYimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
            return CornerRadius.m18259getXimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) == 0.0f || CornerRadius.m18260getYimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) == 0.0f;
        }
        return false;
    }

    public static final boolean isSimple(@NotNull RoundRect roundRect) {
        return CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18260getYimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) && CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18259getXimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18260getYimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18259getXimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18260getYimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18259getXimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m18260getYimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs());
    }

    @NotNull
    public static final RoundRect lerp(@NotNull RoundRect roundRect, @NotNull RoundRect roundRect2, float f) {
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m18270lerp3Ry4LBc(roundRect.m18334getTopLeftCornerRadiuskKHJgLs(), roundRect2.m18334getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m18270lerp3Ry4LBc(roundRect.m18335getTopRightCornerRadiuskKHJgLs(), roundRect2.m18335getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m18270lerp3Ry4LBc(roundRect.m18333getBottomRightCornerRadiuskKHJgLs(), roundRect2.m18333getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m18270lerp3Ry4LBc(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m18332getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    @NotNull
    /* JADX INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m18340translateUv8p0NA(@NotNull RoundRect roundRect, long j) {
        return new RoundRect(roundRect.getLeft() + Offset.m18284getXimpl(j), roundRect.getTop() + Offset.m18285getYimpl(j), roundRect.getRight() + Offset.m18284getXimpl(j), roundRect.getBottom() + Offset.m18285getYimpl(j), roundRect.m18334getTopLeftCornerRadiuskKHJgLs(), roundRect.m18335getTopRightCornerRadiuskKHJgLs(), roundRect.m18333getBottomRightCornerRadiuskKHJgLs(), roundRect.m18332getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    @NotNull
    public static final RoundRect RoundRect(@NotNull Rect rect, float f, float f4) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f4);
    }
}
