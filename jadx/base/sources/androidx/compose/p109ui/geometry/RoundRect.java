package androidx.compose.p109ui.geometry;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.Immutable;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0016\u0010!\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0011J\u0016\u0010#\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0011J\u0016\u0010%\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011J\u0016\u0010'\u001a\u00020\bHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\u0011J\u001b\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.Jc\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J(\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0002J\b\u0010;\u001a\u00020\u0000H\u0002J\b\u0010<\u001a\u00020=H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\n\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0019\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, m13886d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_scaledRadiiRect", "getBottom", "()F", "getBottomLeftCornerRadius-kKHJgLs", "()J", "J", "getBottomRightCornerRadius-kKHJgLs", "height", "getHeight", "getLeft", "getRight", "getTop", "getTopLeftCornerRadius-kKHJgLs", "getTopRightCornerRadius-kKHJgLs", "width", "getWidth", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "minRadius", VElementFormulasCmd.FMIN, "radius1", "radius2", "limit", "scaledRadiiRect", "toString", "", "Companion", "ui-geometry_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class RoundRect {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final RoundRect Zero = RoundRectKt.m18338RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.INSTANCE.m18269getZerokKHJgLs());

    @Nullable
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RoundRect getZero() {
            return RoundRect.Zero;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }
    }

    public /* synthetic */ RoundRect(float f, float f4, float f5, float f6, long j, long j2, long j3, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, j, j2, j3, j5);
    }

    /* JADX INFO: renamed from: copy-MDFrsts$default, reason: not valid java name */
    public static /* synthetic */ RoundRect m18325copyMDFrsts$default(RoundRect roundRect, float f, float f4, float f5, float f6, long j, long j2, long j3, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            f = roundRect.left;
        }
        if ((i & 2) != 0) {
            f4 = roundRect.top;
        }
        if ((i & 4) != 0) {
            f5 = roundRect.right;
        }
        if ((i & 8) != 0) {
            f6 = roundRect.bottom;
        }
        if ((i & 16) != 0) {
            j = roundRect.topLeftCornerRadius;
        }
        if ((i & 32) != 0) {
            j2 = roundRect.topRightCornerRadius;
        }
        if ((i & 64) != 0) {
            j3 = roundRect.bottomRightCornerRadius;
        }
        if ((i & 128) != 0) {
            j5 = roundRect.bottomLeftCornerRadius;
        }
        long j6 = j5;
        long j7 = j3;
        long j8 = j2;
        long j9 = j;
        return roundRect.m18331copyMDFrsts(f, f4, f5, f6, j9, j8, j7, j6);
    }

    @NotNull
    public static final RoundRect getZero() {
        return INSTANCE.getZero();
    }

    private final float minRadius(float min, float radius1, float radius2, float limit) {
        float f = radius1 + radius2;
        return (f <= limit || f == 0.0f) ? min : Math.min(min, limit / f);
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        float fMinRadius = minRadius(minRadius(minRadius(minRadius(1.0f, CornerRadius.m18260getYimpl(this.bottomLeftCornerRadius), CornerRadius.m18260getYimpl(this.topLeftCornerRadius), getHeight()), CornerRadius.m18259getXimpl(this.topLeftCornerRadius), CornerRadius.m18259getXimpl(this.topRightCornerRadius), getWidth()), CornerRadius.m18260getYimpl(this.topRightCornerRadius), CornerRadius.m18260getYimpl(this.bottomRightCornerRadius), getHeight()), CornerRadius.m18259getXimpl(this.bottomRightCornerRadius), CornerRadius.m18259getXimpl(this.bottomLeftCornerRadius), getWidth());
        RoundRect roundRect2 = new RoundRect(this.left * fMinRadius, this.top * fMinRadius, this.right * fMinRadius, this.bottom * fMinRadius, CornerRadiusKt.CornerRadius(CornerRadius.m18259getXimpl(this.topLeftCornerRadius) * fMinRadius, CornerRadius.m18260getYimpl(this.topLeftCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m18259getXimpl(this.topRightCornerRadius) * fMinRadius, CornerRadius.m18260getYimpl(this.topRightCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m18259getXimpl(this.bottomRightCornerRadius) * fMinRadius, CornerRadius.m18260getYimpl(this.bottomRightCornerRadius) * fMinRadius), CornerRadiusKt.CornerRadius(CornerRadius.m18259getXimpl(this.bottomLeftCornerRadius) * fMinRadius, CornerRadius.m18260getYimpl(this.bottomLeftCornerRadius) * fMinRadius), null);
        this._scaledRadiiRect = roundRect2;
        return roundRect2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: component5-kKHJgLs, reason: not valid java name and from getter */
    public final long getTopLeftCornerRadius() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: component6-kKHJgLs, reason: not valid java name and from getter */
    public final long getTopRightCornerRadius() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: component7-kKHJgLs, reason: not valid java name and from getter */
    public final long getBottomRightCornerRadius() {
        return this.bottomRightCornerRadius;
    }

    /* JADX INFO: renamed from: component8-kKHJgLs, reason: not valid java name and from getter */
    public final long getBottomLeftCornerRadius() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c8  */
    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m18330containsk4lQ0M(long point) {
        float fM18284getXimpl;
        float fM18285getYimpl;
        float fM18259getXimpl;
        float fM18260getYimpl;
        if (Offset.m18284getXimpl(point) < this.left || Offset.m18284getXimpl(point) >= this.right || Offset.m18285getYimpl(point) < this.top || Offset.m18285getYimpl(point) >= this.bottom) {
            return false;
        }
        RoundRect roundRectScaledRadiiRect = scaledRadiiRect();
        if (Offset.m18284getXimpl(point) < CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius) + this.left) {
            if (Offset.m18285getYimpl(point) < CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius) + this.top) {
                fM18284getXimpl = (Offset.m18284getXimpl(point) - this.left) - CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
                fM18285getYimpl = (Offset.m18285getYimpl(point) - this.top) - CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
                fM18259getXimpl = CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
                fM18260getYimpl = CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.topLeftCornerRadius);
            } else if (Offset.m18284getXimpl(point) > this.right - CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.topRightCornerRadius)) {
                if (Offset.m18285getYimpl(point) < CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.topRightCornerRadius) + this.top) {
                    fM18284getXimpl = (Offset.m18284getXimpl(point) - this.right) + CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.topRightCornerRadius);
                    fM18285getYimpl = (Offset.m18285getYimpl(point) - this.top) - CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.topRightCornerRadius);
                    fM18259getXimpl = CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.topRightCornerRadius);
                    fM18260getYimpl = CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.topRightCornerRadius);
                } else if (Offset.m18284getXimpl(point) <= this.right - CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius) || Offset.m18285getYimpl(point) <= this.bottom - CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius)) {
                    if (Offset.m18284getXimpl(point) >= CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius) + this.left || Offset.m18285getYimpl(point) <= this.bottom - CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius)) {
                        return true;
                    }
                    fM18284getXimpl = (Offset.m18284getXimpl(point) - this.left) - CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
                    fM18285getYimpl = (Offset.m18285getYimpl(point) - this.bottom) + CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
                    fM18259getXimpl = CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
                    fM18260getYimpl = CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.bottomLeftCornerRadius);
                } else {
                    fM18284getXimpl = (Offset.m18284getXimpl(point) - this.right) + CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
                    fM18285getYimpl = (Offset.m18285getYimpl(point) - this.bottom) + CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
                    fM18259getXimpl = CornerRadius.m18259getXimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
                    fM18260getYimpl = CornerRadius.m18260getYimpl(roundRectScaledRadiiRect.bottomRightCornerRadius);
                }
            }
        }
        float f = fM18284getXimpl / fM18259getXimpl;
        float f4 = fM18285getYimpl / fM18260getYimpl;
        return (f4 * f4) + (f * f) <= 1.0f;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m18331copyMDFrsts(float left, float top, float right, float bottom, long topLeftCornerRadius, long topRightCornerRadius, long bottomRightCornerRadius, long bottomLeftCornerRadius) {
        return new RoundRect(left, top, right, bottom, topLeftCornerRadius, topRightCornerRadius, bottomRightCornerRadius, bottomLeftCornerRadius, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) other;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m18258equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m18258equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m18258equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m18258equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m18332getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m18333getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m18334getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m18335getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return CornerRadius.m18261hashCodeimpl(this.bottomLeftCornerRadius) + ((CornerRadius.m18261hashCodeimpl(this.bottomRightCornerRadius) + ((CornerRadius.m18261hashCodeimpl(this.topRightCornerRadius) + ((CornerRadius.m18261hashCodeimpl(this.topLeftCornerRadius) + AbstractC0622a.m1156b(this.bottom, AbstractC0622a.m1156b(this.right, AbstractC0622a.m1156b(this.top, Float.hashCode(this.left) * 31, 31), 31), 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        long j3 = this.bottomRightCornerRadius;
        long j5 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + SQLKeyword.COMMA + GeometryUtilsKt.toStringAsFixed(this.top, 1) + SQLKeyword.COMMA + GeometryUtilsKt.toStringAsFixed(this.right, 1) + SQLKeyword.COMMA + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m18258equalsimpl0(j, j2) || !CornerRadius.m18258equalsimpl0(j2, j3) || !CornerRadius.m18258equalsimpl0(j3, j5)) {
            StringBuilder sbM15l = AbstractC0000a.m15l("RoundRect(rect=", str, ", topLeft=");
            sbM15l.append((Object) CornerRadius.m18265toStringimpl(j));
            sbM15l.append(", topRight=");
            sbM15l.append((Object) CornerRadius.m18265toStringimpl(j2));
            sbM15l.append(", bottomRight=");
            sbM15l.append((Object) CornerRadius.m18265toStringimpl(j3));
            sbM15l.append(", bottomLeft=");
            sbM15l.append((Object) CornerRadius.m18265toStringimpl(j5));
            sbM15l.append(PropertyUtils.MAPPED_DELIM2);
            return sbM15l.toString();
        }
        if (CornerRadius.m18259getXimpl(j) == CornerRadius.m18260getYimpl(j)) {
            StringBuilder sbM15l2 = AbstractC0000a.m15l("RoundRect(rect=", str, ", radius=");
            sbM15l2.append(GeometryUtilsKt.toStringAsFixed(CornerRadius.m18259getXimpl(j), 1));
            sbM15l2.append(PropertyUtils.MAPPED_DELIM2);
            return sbM15l2.toString();
        }
        StringBuilder sbM15l3 = AbstractC0000a.m15l("RoundRect(rect=", str, ", x=");
        sbM15l3.append(GeometryUtilsKt.toStringAsFixed(CornerRadius.m18259getXimpl(j), 1));
        sbM15l3.append(", y=");
        sbM15l3.append(GeometryUtilsKt.toStringAsFixed(CornerRadius.m18260getYimpl(j), 1));
        sbM15l3.append(PropertyUtils.MAPPED_DELIM2);
        return sbM15l3.toString();
    }

    private RoundRect(float f, float f4, float f5, float f6, long j, long j2, long j3, long j5) {
        this.left = f;
        this.top = f4;
        this.right = f5;
        this.bottom = f6;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j5;
    }

    public /* synthetic */ RoundRect(float f, float f4, float f5, float f6, long j, long j2, long j3, long j5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, (i & 16) != 0 ? CornerRadius.INSTANCE.m18269getZerokKHJgLs() : j, (i & 32) != 0 ? CornerRadius.INSTANCE.m18269getZerokKHJgLs() : j2, (i & 64) != 0 ? CornerRadius.INSTANCE.m18269getZerokKHJgLs() : j3, (i & 128) != 0 ? CornerRadius.INSTANCE.m18269getZerokKHJgLs() : j5, null);
    }
}
