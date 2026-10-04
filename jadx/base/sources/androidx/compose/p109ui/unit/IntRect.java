package androidx.compose.p109ui.unit;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0001PB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u0018\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b>\u0010?J1\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0010\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0003H\u0007J\u0013\u0010C\u001a\u00020\u001e2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\u0010\u0010F\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0003H\u0007J\u0010\u0010G\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0000H\u0007J\u000e\u0010H\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u0000J\b\u0010I\u001a\u00020JH\u0016J\u001a\u0010K\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u0018\u0010K\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u0003H\u0007R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\u001d\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010 R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\t\u001a\u0004\b\"\u0010\u000bR\u0011\u0010#\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\u000bR\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\t\u001a\u0004\b(\u0010\u000bR \u0010)\u001a\u00020*8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\t\u001a\u0004\b.\u0010\u000bR\u0017\u0010/\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b0\u0010\u000fR\u0017\u00101\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b2\u0010\u000fR\u0017\u00103\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b4\u0010\u000fR\u001a\u00105\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010\t\u001a\u0004\b7\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, m13886d2 = {"Landroidx/compose/ui/unit/IntRect;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom$annotations", "()V", "getBottom", "()I", "bottomCenter", "Landroidx/compose/ui/unit/IntOffset;", "getBottomCenter-nOcc-ac", "()J", "bottomLeft", "getBottomLeft-nOcc-ac", "bottomRight", "getBottomRight-nOcc-ac", "center", "getCenter-nOcc-ac", "centerLeft", "getCenterLeft-nOcc-ac", "centerRight", "getCenterRight-nOcc-ac", "height", "getHeight$annotations", "getHeight", "isEmpty", "", "isEmpty$annotations", "()Z", "getLeft$annotations", "getLeft", "maxDimension", "getMaxDimension", "minDimension", "getMinDimension", "getRight$annotations", "getRight", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$annotations", "getSize-YbymL2g", "getTop$annotations", "getTop", "topCenter", "getTopCenter-nOcc-ac", "topLeft", "getTopLeft-nOcc-ac", "topRight", "getTopRight-nOcc-ac", "width", "getWidth$annotations", "getWidth", "component1", "component2", "component3", "component4", "contains", TypedValues.Cycle.S_WAVE_OFFSET, "contains--gyyYBs", "(J)Z", "copy", "deflate", "delta", "equals", "other", "hashCode", "inflate", "intersect", "overlaps", "toString", "", "translate", "translate--gyyYBs", "(J)Landroidx/compose/ui/unit/IntRect;", "translateX", "translateY", "Companion", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class IntRect {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final IntRect Zero = new IntRect(0, 0, 0, 0);
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/unit/IntRect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/unit/IntRect;", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntRect getZero() {
            return IntRect.Zero;
        }

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getZero$annotations() {
        }
    }

    public IntRect(int i, int i2, int i4, int i5) {
        this.left = i;
        this.top = i2;
        this.right = i4;
        this.bottom = i5;
    }

    public static /* synthetic */ IntRect copy$default(IntRect intRect, int i, int i2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = intRect.left;
        }
        if ((i6 & 2) != 0) {
            i2 = intRect.top;
        }
        if ((i6 & 4) != 0) {
            i4 = intRect.right;
        }
        if ((i6 & 8) != 0) {
            i5 = intRect.bottom;
        }
        return intRect.copy(i, i2, i4, i5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: contains--gyyYBs, reason: not valid java name */
    public final boolean m21115containsgyyYBs(long offset) {
        return IntOffset.m21096getXimpl(offset) >= this.left && IntOffset.m21096getXimpl(offset) < this.right && IntOffset.m21097getYimpl(offset) >= this.top && IntOffset.m21097getYimpl(offset) < this.bottom;
    }

    @NotNull
    public final IntRect copy(int left, int top, int right, int bottom) {
        return new IntRect(left, top, right, bottom);
    }

    @Stable
    @NotNull
    public final IntRect deflate(int delta) {
        return inflate(-delta);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntRect)) {
            return false;
        }
        IntRect intRect = (IntRect) other;
        return this.left == intRect.left && this.top == intRect.top && this.right == intRect.right && this.bottom == intRect.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getBottomCenter-nOcc-ac, reason: not valid java name */
    public final long m21116getBottomCenternOccac() {
        return IntOffsetKt.IntOffset((getWidth() / 2) + this.left, this.bottom);
    }

    /* JADX INFO: renamed from: getBottomLeft-nOcc-ac, reason: not valid java name */
    public final long m21117getBottomLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.bottom);
    }

    /* JADX INFO: renamed from: getBottomRight-nOcc-ac, reason: not valid java name */
    public final long m21118getBottomRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, this.bottom);
    }

    /* JADX INFO: renamed from: getCenter-nOcc-ac, reason: not valid java name */
    public final long m21119getCenternOccac() {
        return IntOffsetKt.IntOffset((getWidth() / 2) + this.left, (getHeight() / 2) + this.top);
    }

    /* JADX INFO: renamed from: getCenterLeft-nOcc-ac, reason: not valid java name */
    public final long m21120getCenterLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, (getHeight() / 2) + this.top);
    }

    /* JADX INFO: renamed from: getCenterRight-nOcc-ac, reason: not valid java name */
    public final long m21121getCenterRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, (getHeight() / 2) + this.top);
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getMaxDimension() {
        return Math.max(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getMinDimension() {
        return Math.min(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m21122getSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    public final int getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: getTopCenter-nOcc-ac, reason: not valid java name */
    public final long m21123getTopCenternOccac() {
        return IntOffsetKt.IntOffset((getWidth() / 2) + this.left, this.top);
    }

    /* JADX INFO: renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m21124getTopLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.top);
    }

    /* JADX INFO: renamed from: getTopRight-nOcc-ac, reason: not valid java name */
    public final long m21125getTopRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, this.top);
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return Integer.hashCode(this.bottom) + AbstractC0622a.m1157c(this.right, AbstractC0622a.m1157c(this.top, Integer.hashCode(this.left) * 31, 31), 31);
    }

    @Stable
    @NotNull
    public final IntRect inflate(int delta) {
        return new IntRect(this.left - delta, this.top - delta, this.right + delta, this.bottom + delta);
    }

    @Stable
    @NotNull
    public final IntRect intersect(@NotNull IntRect other) {
        return new IntRect(Math.max(this.left, other.left), Math.max(this.top, other.top), Math.min(this.right, other.right), Math.min(this.bottom, other.bottom));
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final boolean overlaps(@NotNull IntRect other) {
        return this.right > other.left && other.right > this.left && this.bottom > other.top && other.bottom > this.top;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("IntRect.fromLTRB(");
        sb.append(this.left);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.top);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.right);
        sb.append(SQLKeyword.COMMA);
        return AbstractC0000a.m13j(sb, this.bottom, PropertyUtils.MAPPED_DELIM2);
    }

    @Stable
    @NotNull
    public final IntRect translate(int translateX, int translateY) {
        return new IntRect(this.left + translateX, this.top + translateY, this.right + translateX, this.bottom + translateY);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: translate--gyyYBs, reason: not valid java name */
    public final IntRect m21126translategyyYBs(long offset) {
        return new IntRect(IntOffset.m21096getXimpl(offset) + this.left, IntOffset.m21097getYimpl(offset) + this.top, IntOffset.m21096getXimpl(offset) + this.right, IntOffset.m21097getYimpl(offset) + this.bottom);
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getRight$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getSize-YbymL2g$annotations, reason: not valid java name */
    public static /* synthetic */ void m21114getSizeYbymL2g$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    @Stable
    public static /* synthetic */ void isEmpty$annotations() {
    }
}
