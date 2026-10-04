package androidx.compose.p109ui.platform;

import androidx.compose.p109ui.geometry.CornerRadius;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.RoundRect;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a4\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a4\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002\u001a:\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001bH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m13886d2 = {"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInPath", "path", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect roundRect) {
        if (CornerRadius.m18259getXimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) > roundRect.getWidth()) {
            return false;
        }
        if (CornerRadius.m18259getXimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) + CornerRadius.m18259getXimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()) > roundRect.getWidth()) {
            return false;
        }
        if (CornerRadius.m18260getYimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m18260getYimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) <= roundRect.getHeight()) {
            return CornerRadius.m18260getYimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs()) + CornerRadius.m18260getYimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) <= roundRect.getHeight();
        }
        return false;
    }

    public static final boolean isInOutline(@NotNull Outline outline, float f, float f4, @Nullable Path path, @Nullable Path path2) {
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f, f4);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f, f4, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f, f4, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f, float f4, Path path, Path path2, int i, Object obj) {
        if ((i & 8) != 0) {
            path = null;
        }
        if ((i & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f, f4, path, path2);
    }

    private static final boolean isInPath(Path path, float f, float f4, Path path2, Path path3) {
        Rect rect = new Rect(f - 0.005f, f4 - 0.005f, f + 0.005f, f4 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        Path.addRect$default(path2, rect, null, 2, null);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.mo18417opN5in7k0(path, path2, PathOperation.INSTANCE.m18818getIntersectb3I0S0c());
        boolean zIsEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !zIsEmpty;
    }

    private static final boolean isInRectangle(Rect rect, float f, float f4) {
        return rect.getLeft() <= f && f < rect.getRight() && rect.getTop() <= f4 && f4 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f, float f4, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f < roundRect.getLeft() || f >= roundRect.getRight() || f4 < roundRect.getTop() || f4 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect$default(Path, roundRect, null, 2, null);
            return isInPath(Path, f, f4, path, path2);
        }
        float fM18259getXimpl = CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float fM18260getYimpl = CornerRadius.m18260getYimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m18259getXimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs());
        float fM18260getYimpl2 = CornerRadius.m18260getYimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.m18259getXimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.m18260getYimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.m18260getYimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs());
        float fM18259getXimpl2 = CornerRadius.m18259getXimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        if (f < fM18259getXimpl && f4 < fM18260getYimpl) {
            return m20242isWithinEllipseVE1yxkc(f, f4, roundRect.m18334getTopLeftCornerRadiuskKHJgLs(), fM18259getXimpl, fM18260getYimpl);
        }
        if (f < fM18259getXimpl2 && f4 > bottom2) {
            return m20242isWithinEllipseVE1yxkc(f, f4, roundRect.m18332getBottomLeftCornerRadiuskKHJgLs(), fM18259getXimpl2, bottom2);
        }
        if (f > right && f4 < fM18260getYimpl2) {
            return m20242isWithinEllipseVE1yxkc(f, f4, roundRect.m18335getTopRightCornerRadiuskKHJgLs(), right, fM18260getYimpl2);
        }
        if (f <= right2 || f4 <= bottom) {
            return true;
        }
        return m20242isWithinEllipseVE1yxkc(f, f4, roundRect.m18333getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
    }

    /* JADX INFO: renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m20242isWithinEllipseVE1yxkc(float f, float f4, long j, float f5, float f6) {
        float f7 = f - f5;
        float f8 = f4 - f6;
        float fM18259getXimpl = CornerRadius.m18259getXimpl(j);
        float fM18260getYimpl = CornerRadius.m18260getYimpl(j);
        return ((f8 * f8) / (fM18260getYimpl * fM18260getYimpl)) + ((f7 * f7) / (fM18259getXimpl * fM18259getXimpl)) <= 1.0f;
    }
}
