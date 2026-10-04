package androidx.compose.p109ui.platform;

import android.view.View;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p109ui.unit.Velocity;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "consumedScrollCache", "", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "interruptOngoingScrolls", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    public static final int $stable = 8;

    @NotNull
    private final int[] consumedScrollCache;

    @NotNull
    private final NestedScrollingChildHelper nestedScrollChildHelper;

    @NotNull
    private final View view;

    public NestedScrollInteropConnection(@NotNull View view) {
        this.view = view;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo15655onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m21205getXimpl(j2)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m21206getYimpl(j2)), true)) {
            j2 = Velocity.INSTANCE.m21216getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m21196boximpl(j2);
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo15656onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m20235getScrollAxesk4lQ0M(available), NestedScrollInteropConnectionKt.m20237toViewTypeGyEprt8(source))) {
            return Offset.INSTANCE.m18300getZeroF1C5BW0();
        }
        ArraysKt___ArraysJvmKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m18284getXimpl(consumed)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m18285getYimpl(consumed)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m18284getXimpl(available)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m18285getYimpl(available)), null, NestedScrollInteropConnectionKt.m20237toViewTypeGyEprt8(source), this.consumedScrollCache);
        return NestedScrollInteropConnectionKt.m20236toOffsetUv8p0NA(this.consumedScrollCache, available);
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo15929onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m21205getXimpl(j)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m21206getYimpl(j)))) {
            j = Velocity.INSTANCE.m21216getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m21196boximpl(j);
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo15930onPreScrollOzD1aCk(long available, int source) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m20235getScrollAxesk4lQ0M(available), NestedScrollInteropConnectionKt.m20237toViewTypeGyEprt8(source))) {
            return Offset.INSTANCE.m18300getZeroF1C5BW0();
        }
        ArraysKt___ArraysJvmKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m18284getXimpl(available)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m18285getYimpl(available)), this.consumedScrollCache, null, NestedScrollInteropConnectionKt.m20237toViewTypeGyEprt8(source));
        return NestedScrollInteropConnectionKt.m20236toOffsetUv8p0NA(this.consumedScrollCache, available);
    }
}
