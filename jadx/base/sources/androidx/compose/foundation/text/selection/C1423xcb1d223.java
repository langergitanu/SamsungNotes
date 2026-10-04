package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/compose/foundation/text/selection/DownResolution;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1", m14021f = "SelectionGestures.kt", m14022i = {0}, m14023l = {277}, m14024m = "invokeSuspend", m14025n = {"$this$withTimeoutOrNull"}, m14026s = {"L$0"})
public final class C1423xcb1d223 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super DownResolution>, Object> {
    final /* synthetic */ Ref.LongRef $overSlop;
    final /* synthetic */ long $pointerId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1423xcb1d223(long j, Ref.LongRef longRef, Continuation<? super C1423xcb1d223> continuation) {
        super(2, continuation);
        this.$pointerId = j;
        this.$overSlop = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C1423xcb1d223 c1423xcb1d223 = new C1423xcb1d223(this.$pointerId, this.$overSlop, continuation);
        c1423xcb1d223.L$0 = obj;
        return c1423xcb1d223;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super DownResolution> continuation) {
        return ((C1423xcb1d223) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            long j = this.$pointerId;
            final Ref.LongRef longRef = this.$overSlop;
            Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1$firstDragPastSlop$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                    m16506invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m16506invokeUv8p0NA(@NotNull PointerInputChange pointerInputChange, long j2) {
                    pointerInputChange.consume();
                    longRef.element = j2;
                }
            };
            this.L$0 = awaitPointerEventScope2;
            this.label = 1;
            Object objM15589awaitTouchSlopOrCancellationjO51t88 = DragGestureDetectorKt.m15589awaitTouchSlopOrCancellationjO51t88(awaitPointerEventScope2, j, function2, this);
            if (objM15589awaitTouchSlopOrCancellationjO51t88 == coroutine_suspended) {
                return coroutine_suspended;
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            obj = objM15589awaitTouchSlopOrCancellationjO51t88;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((PointerInputChange) obj) != null && OffsetKt.m18303isSpecifiedk4lQ0M(this.$overSlop.element)) {
            return DownResolution.Drag;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first((List) awaitPointerEventScope.getCurrentEvent().getChanges());
        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            return DownResolution.Cancel;
        }
        pointerInputChange.consume();
        return DownResolution.Up;
    }
}
