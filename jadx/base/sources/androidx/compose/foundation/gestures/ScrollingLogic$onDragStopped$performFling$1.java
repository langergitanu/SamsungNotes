package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p109ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", m14021f = "Scrollable.kt", m14022i = {0, 1, 1, 2, 2}, m14023l = {745, 748, 751}, m14024m = "invokeSuspend", m14025n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, m14026s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
public final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).getPackedValue();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m15673invokesFctU(velocity.getPackedValue(), continuation);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m15673invokesFctU(long j, @Nullable Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m21196boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
    
        if (r0 != r6) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM19604dispatchPreFlingQWom1Mo;
        long j;
        Object objM15666doFlingAnimationQWom1Mo;
        long j2;
        long j3;
        long j5;
        Object objM19602dispatchPostFlingRZ2iAVY;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j6 = this.J$0;
            NestedScrollDispatcher nestedScrollDispatcher = this.this$0.nestedScrollDispatcher;
            this.J$0 = j6;
            this.label = 1;
            objM19604dispatchPreFlingQWom1Mo = nestedScrollDispatcher.m19604dispatchPreFlingQWom1Mo(j6, this);
            if (objM19604dispatchPreFlingQWom1Mo != coroutine_suspended) {
                j = j6;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            objM19604dispatchPreFlingQWom1Mo = obj;
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j7 = this.J$1;
                long j8 = this.J$0;
                ResultKt.throwOnFailure(obj);
                j2 = j8;
                j5 = j7;
                objM19602dispatchPostFlingRZ2iAVY = obj;
                return Velocity.m21196boximpl(Velocity.m21208minusAH228Gc(j2, Velocity.m21208minusAH228Gc(j5, ((Velocity) objM19602dispatchPostFlingRZ2iAVY).getPackedValue())));
            }
            j3 = this.J$1;
            j2 = this.J$0;
            ResultKt.throwOnFailure(obj);
            objM15666doFlingAnimationQWom1Mo = obj;
            long packedValue = ((Velocity) objM15666doFlingAnimationQWom1Mo).getPackedValue();
            NestedScrollDispatcher nestedScrollDispatcher2 = this.this$0.nestedScrollDispatcher;
            long jM21208minusAH228Gc = Velocity.m21208minusAH228Gc(j3, packedValue);
            this.J$0 = j2;
            this.J$1 = packedValue;
            this.label = 3;
            j5 = packedValue;
            objM19602dispatchPostFlingRZ2iAVY = nestedScrollDispatcher2.m19602dispatchPostFlingRZ2iAVY(jM21208minusAH228Gc, j5, this);
        }
        long jM21208minusAH228Gc2 = Velocity.m21208minusAH228Gc(j, ((Velocity) objM19604dispatchPreFlingQWom1Mo).getPackedValue());
        ScrollingLogic scrollingLogic = this.this$0;
        this.J$0 = j;
        this.J$1 = jM21208minusAH228Gc2;
        this.label = 2;
        objM15666doFlingAnimationQWom1Mo = scrollingLogic.m15666doFlingAnimationQWom1Mo(jM21208minusAH228Gc2, this);
        if (objM15666doFlingAnimationQWom1Mo != coroutine_suspended) {
            j2 = j;
            j3 = jM21208minusAH228Gc2;
            long packedValue2 = ((Velocity) objM15666doFlingAnimationQWom1Mo).getPackedValue();
            NestedScrollDispatcher nestedScrollDispatcher22 = this.this$0.nestedScrollDispatcher;
            long jM21208minusAH228Gc3 = Velocity.m21208minusAH228Gc(j3, packedValue2);
            this.J$0 = j2;
            this.J$1 = packedValue2;
            this.label = 3;
            j5 = packedValue2;
            objM19602dispatchPostFlingRZ2iAVY = nestedScrollDispatcher22.m19602dispatchPostFlingRZ2iAVY(jM21208minusAH228Gc3, j5, this);
        }
        return coroutine_suspended;
    }
}
