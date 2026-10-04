package androidx.compose.foundation.text;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerEventType;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0080@¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"detectMoves", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "pointerEventPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onMove", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PointerMoveDetectorKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", m14021f = "PointerMoveDetector.kt", m14022i = {}, m14023l = {41}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nPointerMoveDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointerMoveDetector.kt\nandroidx/compose/foundation/text/PointerMoveDetectorKt$detectMoves$2\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,57:1\n329#2:58\n*S KotlinDebug\n*F\n+ 1 PointerMoveDetector.kt\nandroidx/compose/foundation/text/PointerMoveDetectorKt$detectMoves$2\n*L\n40#1:58\n*E\n"})
    public static final class C12632 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onMove;
        final /* synthetic */ PointerEventPass $pointerEventPass;
        final /* synthetic */ PointerInputScope $this_detectMoves;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", m14021f = "PointerMoveDetector.kt", m14022i = {0, 0}, m14023l = {44}, m14024m = "invokeSuspend", m14025n = {"$this$awaitPointerEventScope", "previousPosition"}, m14026s = {"L$0", "L$1"})
        @SourceDebugExtension({"SMAP\nPointerMoveDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointerMoveDetector.kt\nandroidx/compose/foundation/text/PointerMoveDetectorKt$detectMoves$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineContext $currentContext;
            final /* synthetic */ Function1<Offset, Unit> $onMove;
            final /* synthetic */ PointerEventPass $pointerEventPass;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineContext coroutineContext, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$currentContext = coroutineContext;
                this.$pointerEventPass = pointerEventPass;
                this.$onMove = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentContext, this.$pointerEventPass, this.$onMove, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
            /* JADX WARN: Type inference failed for: r8v15, types: [T, androidx.compose.ui.geometry.Offset] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0040 -> B:14:0x0043). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) {
                Ref.ObjectRef objectRef;
                AwaitPointerEventScope awaitPointerEventScope;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    objectRef = new Ref.ObjectRef();
                    awaitPointerEventScope = awaitPointerEventScope2;
                    if (JobKt.isActive(this.$currentContext)) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) this.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    int type = pointerEvent.getType();
                    PointerEventType.Companion companion = PointerEventType.INSTANCE;
                    if (!(!PointerEventType.m19675equalsimpl0(type, companion.m19681getMove7fucELk()) ? true : PointerEventType.m19675equalsimpl0(type, companion.m19679getEnter7fucELk())) ? true : PointerEventType.m19675equalsimpl0(type, companion.m19680getExit7fucELk())) {
                        Offset offsetM18273boximpl = Offset.m18273boximpl(((PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges())).getPosition());
                        if (Offset.m18280equalsimpl(offsetM18273boximpl.getPackedValue(), objectRef.element)) {
                            offsetM18273boximpl = null;
                        }
                        if (offsetM18273boximpl != null) {
                            Function1<Offset, Unit> function1 = this.$onMove;
                            long packedValue = offsetM18273boximpl.getPackedValue();
                            objectRef.element = Offset.m18273boximpl(packedValue);
                            function1.invoke(Offset.m18273boximpl(packedValue));
                        }
                    }
                    if (JobKt.isActive(this.$currentContext)) {
                        PointerEventPass pointerEventPass = this.$pointerEventPass;
                        this.L$0 = awaitPointerEventScope;
                        this.L$1 = objectRef;
                        this.label = 1;
                        obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        int type2 = pointerEvent2.getType();
                        PointerEventType.Companion companion2 = PointerEventType.INSTANCE;
                        if (!(!PointerEventType.m19675equalsimpl0(type2, companion2.m19681getMove7fucELk()) ? true : PointerEventType.m19675equalsimpl0(type2, companion2.m19679getEnter7fucELk())) ? true : PointerEventType.m19675equalsimpl0(type2, companion2.m19680getExit7fucELk())) {
                        }
                        if (JobKt.isActive(this.$currentContext)) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12632(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super C12632> continuation) {
            super(2, continuation);
            this.$this_detectMoves = pointerInputScope;
            this.$pointerEventPass = pointerEventPass;
            this.$onMove = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C12632(this.$this_detectMoves, this.$pointerEventPass, this.$onMove, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = get$context();
                PointerInputScope pointerInputScope = this.$this_detectMoves;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineContext, this.$pointerEventPass, this.$onMove, null);
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == coroutine_suspended) {
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
            return ((C12632) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Nullable
    public static final Object detectMoves(@NotNull PointerInputScope pointerInputScope, @NotNull PointerEventPass pointerEventPass, @NotNull Function1<? super Offset, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C12632(pointerInputScope, pointerEventPass, function1, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectMoves$default(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Initial;
        }
        return detectMoves(pointerInputScope, pointerEventPass, function1, continuation);
    }
}
