package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.p109ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015¢\u0006\u0002\b\u0018H\u0096@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/foundation/gestures/DefaultDraggable2DState;", "Landroidx/compose/foundation/gestures/Draggable2DState;", "onDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "(Lkotlin/jvm/functions/Function1;)V", "drag2DMutex", "Landroidx/compose/foundation/MutatorMutex;", "drag2DScope", "Landroidx/compose/foundation/gestures/Drag2DScope;", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "dispatchRawDelta", "delta", "dispatchRawDelta-k-4lQ0M", "(J)V", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class DefaultDraggable2DState implements Draggable2DState {

    @NotNull
    private final Function1<Offset, Unit> onDelta;

    @NotNull
    private final Drag2DScope drag2DScope = new Drag2DScope() { // from class: androidx.compose.foundation.gestures.DefaultDraggable2DState$drag2DScope$1
        @Override // androidx.compose.foundation.gestures.Drag2DScope
        /* JADX INFO: renamed from: dragBy-k-4lQ0M, reason: not valid java name */
        public void mo15576dragByk4lQ0M(long pixels) {
            this.this$0.getOnDelta().invoke(Offset.m18273boximpl(pixels));
        }
    };

    @NotNull
    private final MutatorMutex drag2DMutex = new MutatorMutex();

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultDraggable2DState$drag$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.DefaultDraggable2DState$drag$2", m14021f = "Draggable2D.kt", m14022i = {}, m14023l = {497}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C08642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Drag2DScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MutatePriority $dragPriority;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08642(MutatePriority mutatePriority, Function2<? super Drag2DScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C08642> continuation) {
            super(2, continuation);
            this.$dragPriority = mutatePriority;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DefaultDraggable2DState.this.new C08642(this.$dragPriority, this.$block, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutatorMutex mutatorMutex = DefaultDraggable2DState.this.drag2DMutex;
                Drag2DScope drag2DScope = DefaultDraggable2DState.this.drag2DScope;
                MutatePriority mutatePriority = this.$dragPriority;
                Function2<Drag2DScope, Continuation<? super Unit>, Object> function2 = this.$block;
                this.label = 1;
                if (mutatorMutex.mutateWith(drag2DScope, mutatePriority, function2, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultDraggable2DState(@NotNull Function1<? super Offset, Unit> function1) {
        this.onDelta = function1;
    }

    @Override // androidx.compose.foundation.gestures.Draggable2DState
    /* JADX INFO: renamed from: dispatchRawDelta-k-4lQ0M, reason: not valid java name */
    public void mo15575dispatchRawDeltak4lQ0M(long delta) {
        this.onDelta.invoke(Offset.m18273boximpl(delta));
    }

    @Override // androidx.compose.foundation.gestures.Draggable2DState
    @Nullable
    public Object drag(@NotNull MutatePriority mutatePriority, @NotNull Function2<? super Drag2DScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C08642(mutatePriority, function2, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    @NotNull
    public final Function1<Offset, Unit> getOnDelta() {
        return this.onDelta;
    }
}
