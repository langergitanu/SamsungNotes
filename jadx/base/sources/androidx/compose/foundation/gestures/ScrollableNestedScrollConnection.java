package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p109ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Z)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    private boolean enabled;

    @NotNull
    private final ScrollingLogic scrollingLogic;

    public ScrollableNestedScrollConnection(@NotNull ScrollingLogic scrollingLogic, boolean z) {
        this.scrollingLogic = scrollingLogic;
        this.enabled = z;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final ScrollingLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo15655onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        long jM21216getZero9UxMQ8M;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            int i = scrollableNestedScrollConnection$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
            }
        }
        Object objM15666doFlingAnimationQWom1Mo = scrollableNestedScrollConnection$onPostFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = scrollableNestedScrollConnection$onPostFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM15666doFlingAnimationQWom1Mo);
            if (!this.enabled) {
                jM21216getZero9UxMQ8M = Velocity.INSTANCE.m21216getZero9UxMQ8M();
                return Velocity.m21196boximpl(jM21216getZero9UxMQ8M);
            }
            ScrollingLogic scrollingLogic = this.scrollingLogic;
            scrollableNestedScrollConnection$onPostFling$1.J$0 = j2;
            scrollableNestedScrollConnection$onPostFling$1.label = 1;
            objM15666doFlingAnimationQWom1Mo = scrollingLogic.m15666doFlingAnimationQWom1Mo(j2, scrollableNestedScrollConnection$onPostFling$1);
            if (objM15666doFlingAnimationQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = scrollableNestedScrollConnection$onPostFling$1.J$0;
            ResultKt.throwOnFailure(objM15666doFlingAnimationQWom1Mo);
        }
        jM21216getZero9UxMQ8M = Velocity.m21208minusAH228Gc(j2, ((Velocity) objM15666doFlingAnimationQWom1Mo).getPackedValue());
        return Velocity.m21196boximpl(jM21216getZero9UxMQ8M);
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo15656onPostScrollDzOQY0M(long consumed, long available, int source) {
        return this.enabled ? this.scrollingLogic.m15668performRawScrollMKHz9U(available) : Offset.INSTANCE.m18300getZeroF1C5BW0();
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }
}
