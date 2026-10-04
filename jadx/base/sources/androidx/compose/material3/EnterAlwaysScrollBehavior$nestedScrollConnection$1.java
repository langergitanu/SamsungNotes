package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
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
@Metadata(m13885d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, m13886d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ EnterAlwaysScrollBehavior this$0;

    public EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior enterAlwaysScrollBehavior) {
        this.this$0 = enterAlwaysScrollBehavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo15655onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        EnterAlwaysScrollBehavior$nestedScrollConnection$1 enterAlwaysScrollBehavior$nestedScrollConnection$1;
        long j3;
        long j5;
        if (continuation instanceof EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) continuation;
            int i = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
            }
        }
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        Object objMo15655onPostFlingRZ2iAVY = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo15655onPostFlingRZ2iAVY);
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.L$0 = this;
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0 = j2;
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label = 1;
            objMo15655onPostFlingRZ2iAVY = super.mo15655onPostFlingRZ2iAVY(j, j2, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12);
            if (objMo15655onPostFlingRZ2iAVY != coroutine_suspended) {
                enterAlwaysScrollBehavior$nestedScrollConnection$1 = this;
                j3 = j2;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j5 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0;
            ResultKt.throwOnFailure(objMo15655onPostFlingRZ2iAVY);
            return Velocity.m21196boximpl(Velocity.m21209plusAH228Gc(j5, ((Velocity) objMo15655onPostFlingRZ2iAVY).getPackedValue()));
        }
        j3 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0;
        enterAlwaysScrollBehavior$nestedScrollConnection$1 = (EnterAlwaysScrollBehavior$nestedScrollConnection$1) enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.L$0;
        ResultKt.throwOnFailure(objMo15655onPostFlingRZ2iAVY);
        long packedValue = ((Velocity) objMo15655onPostFlingRZ2iAVY).getPackedValue();
        TopAppBarState state = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getState();
        float fM21206getYimpl = Velocity.m21206getYimpl(j3);
        DecayAnimationSpec<Float> flingAnimationSpec = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec = enterAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.L$0 = null;
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0 = packedValue;
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label = 2;
        objMo15655onPostFlingRZ2iAVY = AppBarKt.settleAppBar(state, fM21206getYimpl, flingAnimationSpec, snapAnimationSpec, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12);
        if (objMo15655onPostFlingRZ2iAVY != coroutine_suspended) {
            j5 = packedValue;
            return Velocity.m21196boximpl(Velocity.m21209plusAH228Gc(j5, ((Velocity) objMo15655onPostFlingRZ2iAVY).getPackedValue()));
        }
        return coroutine_suspended;
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo15656onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m18300getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        state.setContentOffset(Offset.m18285getYimpl(consumed) + state.getContentOffset());
        if ((this.this$0.getState().getHeightOffset() == 0.0f || this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit()) && Offset.m18285getYimpl(consumed) == 0.0f && Offset.m18285getYimpl(available) > 0.0f) {
            this.this$0.getState().setContentOffset(0.0f);
        }
        this.this$0.getState().setHeightOffset(Offset.m18285getYimpl(consumed) + this.this$0.getState().getHeightOffset());
        return Offset.INSTANCE.m18300getZeroF1C5BW0();
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo15930onPreScrollOzD1aCk(long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m18300getZeroF1C5BW0();
        }
        float heightOffset = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(Offset.m18285getYimpl(available) + this.this$0.getState().getHeightOffset());
        return heightOffset == this.this$0.getState().getHeightOffset() ? Offset.INSTANCE.m18300getZeroF1C5BW0() : Offset.m18278copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
    }
}
