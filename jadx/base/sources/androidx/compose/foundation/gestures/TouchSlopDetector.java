package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J#\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u000e*\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u000e*\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "totalPositionChange", "Landroidx/compose/ui/geometry/Offset;", "J", "addPointerInputChange", "dragEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "touchSlop", "", "addPointerInputChange-GcwITfU", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "reset", "", "crossAxis", "crossAxis-k-4lQ0M", "(J)F", "mainAxis", "mainAxis-k-4lQ0M", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class TouchSlopDetector {

    @Nullable
    private final Orientation orientation;
    private long totalPositionChange;

    /* JADX WARN: Multi-variable type inference failed */
    public TouchSlopDetector() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m15676calculatePostSlopOffsettuRUvjQ(float touchSlop) {
        if (this.orientation == null) {
            long j = this.totalPositionChange;
            return Offset.m18288minusMKHz9U(this.totalPositionChange, Offset.m18291timestuRUvjQ(Offset.m18279divtuRUvjQ(j, Offset.m18282getDistanceimpl(j)), touchSlop));
        }
        float fM15679mainAxisk4lQ0M = m15679mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m15679mainAxisk4lQ0M(this.totalPositionChange)) * touchSlop);
        float fM15678crossAxisk4lQ0M = m15678crossAxisk4lQ0M(this.totalPositionChange);
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(fM15679mainAxisk4lQ0M, fM15678crossAxisk4lQ0M) : OffsetKt.Offset(fM15678crossAxisk4lQ0M, fM15679mainAxisk4lQ0M);
    }

    @Nullable
    /* JADX INFO: renamed from: addPointerInputChange-GcwITfU, reason: not valid java name */
    public final Offset m15677addPointerInputChangeGcwITfU(@NotNull PointerInputChange dragEvent, float touchSlop) {
        long jM18289plusMKHz9U = Offset.m18289plusMKHz9U(this.totalPositionChange, Offset.m18288minusMKHz9U(dragEvent.getPosition(), dragEvent.getPreviousPosition()));
        this.totalPositionChange = jM18289plusMKHz9U;
        if ((this.orientation == null ? Offset.m18282getDistanceimpl(jM18289plusMKHz9U) : Math.abs(m15679mainAxisk4lQ0M(jM18289plusMKHz9U))) >= touchSlop) {
            return Offset.m18273boximpl(m15676calculatePostSlopOffsettuRUvjQ(touchSlop));
        }
        return null;
    }

    /* JADX INFO: renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m15678crossAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m18285getYimpl(j) : Offset.m18284getXimpl(j);
    }

    @Nullable
    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m15679mainAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m18284getXimpl(j) : Offset.m18285getYimpl(j);
    }

    public final void reset() {
        this.totalPositionChange = Offset.INSTANCE.m18300getZeroF1C5BW0();
    }

    public TouchSlopDetector(@Nullable Orientation orientation) {
        this.orientation = orientation;
        this.totalPositionChange = Offset.INSTANCE.m18300getZeroF1C5BW0();
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : orientation);
    }
}
