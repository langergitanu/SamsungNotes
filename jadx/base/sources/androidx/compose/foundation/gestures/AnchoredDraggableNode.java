package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.unit.Velocity;
import androidx.compose.p109ui.unit.VelocityKt;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJM\u0010\u0013\u001a\u00020\u00142=\u0010\u0015\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00140\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0016H\u0096@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010#J\b\u0010\u000e\u001a\u00020\bH\u0016JO\u0010(\u001a\u00020\u00142\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\u0016\u0010)\u001a\u00020!*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0016\u0010)\u001a\u00020&*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010+J\u0016\u0010-\u001a\u00020.*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0016\u0010-\u001a\u00020.*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00100J\u0019\u00102\u001a\u00020!*\u00020.H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020&*\u00020.H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00104R\u0014\u0010\u0010\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, m13886d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "T", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Z)V", "isReverseDirection", "()Z", "Ljava/lang/Boolean;", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", Constants.ARG_UPDATE, "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "toFloat", "", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class AnchoredDraggableNode<T> extends DragGestureNode {

    @NotNull
    private Orientation orientation;

    @Nullable
    private OverscrollEffect overscrollEffect;

    @Nullable
    private Boolean reverseDirection;
    private boolean startDragImmediately;

    @NotNull
    private AnchoredDraggableState<T> state;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", m14021f = "AnchoredDraggable.kt", m14022i = {}, m14023l = {251}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C08542 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08542(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super C08542> continuation) {
            super(3, continuation);
            this.$forEachDelta = function2;
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull AnchoredDragScope anchoredDragScope, @NotNull DraggableAnchors<T> draggableAnchors, @Nullable Continuation<? super Unit> continuation) {
            C08542 c08542 = new C08542(this.$forEachDelta, this.this$0, continuation);
            c08542.L$0 = anchoredDragScope;
            return c08542.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
                final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                Function1<DragEvent.DragDelta, Unit> function1 = new Function1<DragEvent.DragDelta, Unit>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode.drag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DragEvent.DragDelta dragDelta) {
                        invoke2(dragDelta);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull DragEvent.DragDelta dragDelta) {
                        if (((AnchoredDraggableNode) anchoredDraggableNode).overscrollEffect == null) {
                            AnchoredDragScope anchoredDragScope2 = anchoredDragScope;
                            AnchoredDraggableState anchoredDraggableState = ((AnchoredDraggableNode) anchoredDraggableNode).state;
                            AnchoredDraggableNode<T> anchoredDraggableNode2 = anchoredDraggableNode;
                            AnchoredDragScope.dragTo$default(anchoredDragScope2, anchoredDraggableState.newOffsetForDelta$foundation_release(anchoredDraggableNode2.m15560toFloatk4lQ0M(anchoredDraggableNode2.m15558reverseIfNeededMKHz9U(dragDelta.getDelta()))), 0.0f, 2, null);
                            return;
                        }
                        OverscrollEffect overscrollEffect = ((AnchoredDraggableNode) anchoredDraggableNode).overscrollEffect;
                        Intrinsics.checkNotNull(overscrollEffect);
                        long jM15558reverseIfNeededMKHz9U = anchoredDraggableNode.m15558reverseIfNeededMKHz9U(dragDelta.getDelta());
                        int iM19621getUserInputWNlRxjI = NestedScrollSource.INSTANCE.m19621getUserInputWNlRxjI();
                        final AnchoredDraggableNode<T> anchoredDraggableNode3 = anchoredDraggableNode;
                        final AnchoredDragScope anchoredDragScope3 = anchoredDragScope;
                        overscrollEffect.mo15391applyToScrollRhakbz0(jM15558reverseIfNeededMKHz9U, iM19621getUserInputWNlRxjI, new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode.drag.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
                                return Offset.m18273boximpl(m15565invokeMKHz9U(offset.getPackedValue()));
                            }

                            /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
                            public final long m15565invokeMKHz9U(long j) {
                                float fNewOffsetForDelta$foundation_release = ((AnchoredDraggableNode) anchoredDraggableNode3).state.newOffsetForDelta$foundation_release(anchoredDraggableNode3.m15560toFloatk4lQ0M(j));
                                AnchoredDraggableNode<T> anchoredDraggableNode4 = anchoredDraggableNode3;
                                long jM15561toOffsettuRUvjQ = anchoredDraggableNode4.m15561toOffsettuRUvjQ(fNewOffsetForDelta$foundation_release - ((AnchoredDraggableNode) anchoredDraggableNode4).state.requireOffset());
                                AnchoredDragScope.dragTo$default(anchoredDragScope3, fNewOffsetForDelta$foundation_release, 0.0f, 2, null);
                                return jM15561toOffsettuRUvjQ;
                            }
                        });
                    }
                };
                this.label = 1;
                if (function2.invoke(function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public AnchoredDraggableNode(@NotNull AnchoredDraggableState<T> anchoredDraggableState, @NotNull Orientation orientation, boolean z, @Nullable Boolean bool, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable OverscrollEffect overscrollEffect, boolean z2) {
        super(AnchoredDraggableKt.AlwaysDrag, z, mutableInteractionSource, orientation);
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.reverseDirection = bool;
        this.overscrollEffect = overscrollEffect;
        this.startDragImmediately = z2;
    }

    private final boolean isReverseDirection() {
        Boolean bool = this.reverseDirection;
        if (bool == null) {
            return DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal;
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    public final long m15557reverseIfNeededAH228Gc(long j) {
        return Velocity.m21211timesadjELrA(j, isReverseDirection() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m15558reverseIfNeededMKHz9U(long j) {
        return Offset.m18291timestuRUvjQ(j, isReverseDirection() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m15559toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Vertical ? Velocity.m21206getYimpl(j) : Velocity.m21205getXimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m15560toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Vertical ? Offset.m18285getYimpl(j) : Offset.m18284getXimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m15561toOffsettuRUvjQ(float f) {
        Orientation orientation = this.orientation;
        float f4 = orientation == Orientation.Horizontal ? f : 0.0f;
        if (orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return OffsetKt.Offset(f4, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m15562toVelocityadjELrA(float f) {
        Orientation orientation = this.orientation;
        float f4 = orientation == Orientation.Horizontal ? f : 0.0f;
        if (orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return VelocityKt.Velocity(f4, f);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    @Nullable
    public Object drag(@NotNull Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(this.state, null, new C08542(function2, this, null), continuation, 1, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-TH1AsA0, reason: not valid java name */
    public void mo15564onDragStoppedTH1AsA0(long velocity) {
        if (getIsAttached()) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnchoredDraggableNode$onDragStopped$1(this, velocity, null), 3, null);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: startDragImmediately, reason: from getter */
    public boolean getStartDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(@NotNull AnchoredDraggableState<T> state, @NotNull Orientation orientation, boolean enabled, @Nullable Boolean reverseDirection, @Nullable MutableInteractionSource interactionSource, @Nullable OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        boolean z;
        boolean z2 = true;
        if (Intrinsics.areEqual(this.state, state)) {
            z = false;
        } else {
            this.state = state;
            z = true;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z = true;
        }
        if (Intrinsics.areEqual(this.reverseDirection, reverseDirection)) {
            z2 = z;
        } else {
            this.reverseDirection = reverseDirection;
        }
        this.startDragImmediately = startDragImmediately;
        this.overscrollEffect = overscrollEffect;
        DragGestureNode.update$default(this, null, enabled, interactionSource, orientation, z2, 1, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public void mo15563onDragStartedk4lQ0M(long startedPosition) {
    }
}
