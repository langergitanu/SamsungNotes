package androidx.compose.p109ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.p109ui.geometry.CornerRadius;
import androidx.compose.p109ui.geometry.CornerRadiusKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.RoundRect;
import androidx.compose.p109ui.geometry.RoundRectKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.AndroidPath;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b,\u0010-J:\u0010.\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010/\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u000eH\u0002J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020#H\u0002J0\u0010<\u001a\u00020\b*\u0004\u0018\u00010#2\u0006\u0010=\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u00020\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u001dX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, m13886d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "()V", "androidOutline", "Landroid/graphics/Outline;", "getAndroidOutline", "()Landroid/graphics/Outline;", "<set-?>", "", "cacheIsDirty", "getCacheIsDirty$ui_release", "()Z", "cachedOutline", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "outline", "Landroidx/compose/ui/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "outlineNeeded", "outlinePath", "rectSize", "Landroidx/compose/ui/geometry/Size;", "J", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "roundedCornerRadius", "", "tmpOpPath", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "tmpTouchPointPath", "usePathForClip", "clipToOutline", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", Constants.ARG_UPDATE, "alpha", "elevation", "size", "update-S_szKao", "(Landroidx/compose/ui/graphics/Outline;FZFJ)Z", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "isSameBounds", TypedValues.Cycle.S_WAVE_OFFSET, "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOutlineResolver.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OutlineResolver.android.kt\nandroidx/compose/ui/platform/OutlineResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 4 AndroidPath.android.kt\nandroidx/compose/ui/graphics/AndroidPath_androidKt\n*L\n1#1,325:1\n1#2:326\n26#3:327\n26#3:328\n26#3:329\n26#3:330\n26#3:331\n26#3:332\n26#3:333\n26#3:334\n38#4,5:335\n*S KotlinDebug\n*F\n+ 1 OutlineResolver.android.kt\nandroidx/compose/ui/platform/OutlineResolver\n*L\n267#1:327\n268#1:328\n269#1:329\n270#1:330\n280#1:331\n281#1:332\n282#1:333\n283#1:334\n299#1:335,5\n*E\n"})
public final class OutlineResolver {
    public static final int $stable = 8;
    private boolean cacheIsDirty;

    @NotNull
    private final Outline cachedOutline;

    @Nullable
    private Path cachedRrectPath;
    private boolean isSupportedOutline = true;

    @Nullable
    private androidx.compose.p109ui.graphics.Outline outline;
    private boolean outlineNeeded;

    @Nullable
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;

    @Nullable
    private Path tmpOpPath;

    @Nullable
    private Path tmpPath;

    @Nullable
    private RoundRect tmpRoundRect;

    @Nullable
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver() {
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        this.rectTopLeft = Offset.INSTANCE.m18300getZeroF1C5BW0();
        this.rectSize = Size.INSTANCE.m18362getZeroNHjbRc();
    }

    /* JADX INFO: renamed from: isSameBounds-4L21HEs, reason: not valid java name */
    private final boolean m20238isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        if (roundRect != null && RoundRectKt.isSimple(roundRect) && roundRect.getLeft() == Offset.m18284getXimpl(j) && roundRect.getTop() == Offset.m18285getYimpl(j)) {
            if (roundRect.getRight() == Size.m18353getWidthimpl(j2) + Offset.m18284getXimpl(j)) {
                if (roundRect.getBottom() == Size.m18350getHeightimpl(j2) + Offset.m18285getYimpl(j) && CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs()) == f) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.INSTANCE.m18300getZeroF1C5BW0();
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            androidx.compose.p109ui.graphics.Outline outline = this.outline;
            if (outline == null || !this.outlineNeeded || Size.m18353getWidthimpl(this.rectSize) <= 0.0f || Size.m18350getHeightimpl(this.rectSize) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            if (outline instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) outline).getRect());
            } else if (outline instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) outline).getRoundRect());
            } else if (outline instanceof Outline.Generic) {
                updateCacheWithPath(((Outline.Generic) outline).getPath());
            }
        }
    }

    private final void updateCacheWithPath(Path composePath) {
        if (Build.VERSION.SDK_INT > 28 || composePath.isConvex()) {
            android.graphics.Outline outline = this.cachedOutline;
            if (!(composePath instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            outline.setConvexPath(((AndroidPath) composePath).getInternalPath());
            this.usePathForClip = !this.cachedOutline.canClip();
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = composePath;
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float fM18259getXimpl = CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(Math.round(roundRect.getLeft()), Math.round(roundRect.getTop()), Math.round(roundRect.getRight()), Math.round(roundRect.getBottom()), fM18259getXimpl);
            this.roundedCornerRadius = fM18259getXimpl;
            return;
        }
        Path Path = this.cachedRrectPath;
        if (Path == null) {
            Path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = Path;
        }
        Path.reset();
        Path.addRoundRect$default(Path, roundRect, null, 2, null);
        updateCacheWithPath(Path);
    }

    public final void clipToOutline(@NotNull Canvas canvas) {
        OutlineResolver outlineResolver;
        Path clipPath = getClipPath();
        if (clipPath != null) {
            Canvas.m18496clipPathmtrdDE$default(canvas, clipPath, 0, 2, null);
            return;
        }
        float f = this.roundedCornerRadius;
        if (f <= 0.0f) {
            Canvas.m18497clipRectN_I0leg$default(canvas, Offset.m18284getXimpl(this.rectTopLeft), Offset.m18285getYimpl(this.rectTopLeft), Size.m18353getWidthimpl(this.rectSize) + Offset.m18284getXimpl(this.rectTopLeft), Size.m18350getHeightimpl(this.rectSize) + Offset.m18285getYimpl(this.rectTopLeft), 0, 16, null);
            return;
        }
        Path Path = this.tmpPath;
        RoundRect roundRect = this.tmpRoundRect;
        if (Path != null) {
            outlineResolver = this;
            if (!m20238isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, f)) {
            }
            Canvas.m18496clipPathmtrdDE$default(canvas, Path, 0, 2, null);
        }
        outlineResolver = this;
        RoundRect roundRectM18338RoundRectgG7oq9Y = RoundRectKt.m18338RoundRectgG7oq9Y(Offset.m18284getXimpl(outlineResolver.rectTopLeft), Offset.m18285getYimpl(outlineResolver.rectTopLeft), Size.m18353getWidthimpl(outlineResolver.rectSize) + Offset.m18284getXimpl(outlineResolver.rectTopLeft), Size.m18350getHeightimpl(outlineResolver.rectSize) + Offset.m18285getYimpl(outlineResolver.rectTopLeft), CornerRadiusKt.CornerRadius$default(outlineResolver.roundedCornerRadius, 0.0f, 2, null));
        if (Path == null) {
            Path = AndroidPath_androidKt.Path();
        } else {
            Path.reset();
        }
        Path.addRoundRect$default(Path, roundRectM18338RoundRectgG7oq9Y, null, 2, null);
        outlineResolver.tmpRoundRect = roundRectM18338RoundRectgG7oq9Y;
        outlineResolver.tmpPath = Path;
        Canvas.m18496clipPathmtrdDE$default(canvas, Path, 0, 2, null);
    }

    @Nullable
    public final android.graphics.Outline getAndroidOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    /* JADX INFO: renamed from: getCacheIsDirty$ui_release, reason: from getter */
    public final boolean getCacheIsDirty() {
        return this.cacheIsDirty;
    }

    @Nullable
    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    /* JADX INFO: renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    public final boolean m20239isInOutlinek4lQ0M(long position) {
        androidx.compose.p109ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.outline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m18284getXimpl(position), Offset.m18285getYimpl(position), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    /* JADX INFO: renamed from: update-S_szKao, reason: not valid java name */
    public final boolean m20240updateS_szKao(@Nullable androidx.compose.p109ui.graphics.Outline outline, float alpha, boolean clipToOutline, float elevation, long size) {
        this.cachedOutline.setAlpha(alpha);
        boolean zAreEqual = Intrinsics.areEqual(this.outline, outline);
        boolean z = !zAreEqual;
        if (!zAreEqual) {
            this.outline = outline;
            this.cacheIsDirty = true;
        }
        this.rectSize = size;
        boolean z2 = outline != null && (clipToOutline || elevation > 0.0f);
        if (this.outlineNeeded != z2) {
            this.outlineNeeded = z2;
            this.cacheIsDirty = true;
        }
        return z;
    }
}
