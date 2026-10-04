package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p109ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\f*\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"Landroidx/compose/foundation/pager/DefaultPagerNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/foundation/pager/PagerState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "consumeOnOrientation", "consumeOnOrientation-QWom1Mo", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {

    @NotNull
    private final Orientation orientation;

    @NotNull
    private final PagerState state;

    public DefaultPagerNestedScrollConnection(@NotNull PagerState pagerState, @NotNull Orientation orientation) {
        this.state = pagerState;
        this.orientation = orientation;
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    private final float m16085mainAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m18284getXimpl(j) : Offset.m18285getYimpl(j);
    }

    /* JADX INFO: renamed from: consumeOnOrientation-QWom1Mo, reason: not valid java name */
    public final long m16086consumeOnOrientationQWom1Mo(long j, @NotNull Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m21201copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null) : Velocity.m21201copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null);
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final PagerState getState() {
        return this.state;
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo15655onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        return Velocity.m21196boximpl(m16086consumeOnOrientationQWom1Mo(j2, this.orientation));
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo15656onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!NestedScrollSource.m19609equalsimpl0(source, NestedScrollSource.INSTANCE.m19620getSideEffectWNlRxjI()) || m16085mainAxisk4lQ0M(available) == 0.0f) {
            return Offset.INSTANCE.m18300getZeroF1C5BW0();
        }
        throw new CancellationException("Scroll cancelled");
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo15930onPreScrollOzD1aCk(long available, int source) {
        if (!NestedScrollSource.m19609equalsimpl0(source, NestedScrollSource.INSTANCE.m19621getUserInputWNlRxjI()) || Math.abs(this.state.getCurrentPageOffsetFraction()) <= 1.0E-6d) {
            return Offset.INSTANCE.m18300getZeroF1C5BW0();
        }
        float currentPageOffsetFraction = this.state.getCurrentPageOffsetFraction() * this.state.getPageSize$foundation_release();
        float pageSpacing = ((this.state.getLayoutInfo().getPageSpacing() + this.state.getLayoutInfo().getPageSize()) * (-Math.signum(this.state.getCurrentPageOffsetFraction()))) + currentPageOffsetFraction;
        if (this.state.getCurrentPageOffsetFraction() > 0.0f) {
            pageSpacing = currentPageOffsetFraction;
            currentPageOffsetFraction = pageSpacing;
        }
        Orientation orientation = this.orientation;
        Orientation orientation2 = Orientation.Horizontal;
        float fM18285getYimpl = -this.state.dispatchRawDelta(-RangesKt.coerceIn(orientation == orientation2 ? Offset.m18284getXimpl(available) : Offset.m18285getYimpl(available), currentPageOffsetFraction, pageSpacing));
        float fM18284getXimpl = this.orientation == orientation2 ? fM18285getYimpl : Offset.m18284getXimpl(available);
        if (this.orientation != Orientation.Vertical) {
            fM18285getYimpl = Offset.m18285getYimpl(available);
        }
        return Offset.m18277copydBAh8RU(available, fM18284getXimpl, fM18285getYimpl);
    }
}
