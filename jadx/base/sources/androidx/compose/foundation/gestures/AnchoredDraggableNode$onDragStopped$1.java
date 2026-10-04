package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.p109ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", m14021f = "AnchoredDraggable.kt", m14022i = {}, m14023l = {275, 277}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $velocity;
    Object L$0;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "T", "availableVelocity"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", m14021f = "AnchoredDraggable.kt", m14022i = {0}, m14023l = {280}, m14024m = "invokeSuspend", m14025n = {"availableVelocity"}, m14026s = {"J$0"})
    public static final class C08551 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
        /* synthetic */ long J$0;
        Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C08551(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super C08551> continuation) {
            super(2, continuation);
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C08551 c08551 = new C08551(this.this$0, continuation);
            c08551.J$0 = ((Velocity) obj).getPackedValue();
            return c08551;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
            return m15566invokesFctU(velocity.getPackedValue(), continuation);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
        public final Object m15566invokesFctU(long j, @Nullable Continuation<? super Velocity> continuation) {
            return ((C08551) create(Velocity.m21196boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            AnchoredDraggableNode anchoredDraggableNode;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j2 = this.J$0;
                AnchoredDraggableNode anchoredDraggableNode2 = this.this$0;
                AnchoredDraggableState anchoredDraggableState = anchoredDraggableNode2.state;
                float fM15559toFloatTH1AsA0 = this.this$0.m15559toFloatTH1AsA0(j2);
                this.L$0 = anchoredDraggableNode2;
                this.J$0 = j2;
                this.label = 1;
                Object obj2 = anchoredDraggableState.settle(fM15559toFloatTH1AsA0, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anchoredDraggableNode = anchoredDraggableNode2;
                obj = obj2;
                j = j2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                anchoredDraggableNode = (AnchoredDraggableNode) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            long jM15562toVelocityadjELrA = anchoredDraggableNode.m15562toVelocityadjELrA(((Number) obj).floatValue());
            float fRequireOffset = ((AnchoredDraggableNode) this.this$0).state.requireOffset();
            float fMinAnchor = ((AnchoredDraggableNode) this.this$0).state.getAnchors().minAnchor();
            if (fRequireOffset >= ((AnchoredDraggableNode) this.this$0).state.getAnchors().maxAnchor() || fRequireOffset <= fMinAnchor) {
                j = jM15562toVelocityadjELrA;
            }
            return Velocity.m21196boximpl(j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode<T> anchoredDraggableNode, long j, Continuation<? super AnchoredDraggableNode$onDragStopped$1> continuation) {
        super(2, continuation);
        this.this$0 = anchoredDraggableNode;
        this.$velocity = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AnchoredDraggableNode$onDragStopped$1(this.this$0, this.$velocity, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
    
        if (r8.mo15390applyToFlingBMRW4eQ(r3, r1, r7) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        AnchoredDraggableNode anchoredDraggableNode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (((AnchoredDraggableNode) this.this$0).overscrollEffect == null) {
                AnchoredDraggableNode anchoredDraggableNode2 = this.this$0;
                AnchoredDraggableState anchoredDraggableState = anchoredDraggableNode2.state;
                AnchoredDraggableNode<T> anchoredDraggableNode3 = this.this$0;
                float fM15559toFloatTH1AsA0 = anchoredDraggableNode3.m15559toFloatTH1AsA0(anchoredDraggableNode3.m15557reverseIfNeededAH228Gc(this.$velocity));
                this.L$0 = anchoredDraggableNode2;
                this.label = 1;
                Object obj2 = anchoredDraggableState.settle(fM15559toFloatTH1AsA0, this);
                if (obj2 != coroutine_suspended) {
                    anchoredDraggableNode = anchoredDraggableNode2;
                    obj = obj2;
                    anchoredDraggableNode.m15562toVelocityadjELrA(((Number) obj).floatValue());
                }
            } else {
                OverscrollEffect overscrollEffect = ((AnchoredDraggableNode) this.this$0).overscrollEffect;
                Intrinsics.checkNotNull(overscrollEffect);
                long jM15557reverseIfNeededAH228Gc = this.this$0.m15557reverseIfNeededAH228Gc(this.$velocity);
                C08551 c08551 = new C08551(this.this$0, null);
                this.label = 2;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            anchoredDraggableNode = (AnchoredDraggableNode) this.L$0;
            ResultKt.throwOnFailure(obj);
            anchoredDraggableNode.m15562toVelocityadjELrA(((Number) obj).floatValue());
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableNode$onDragStopped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
