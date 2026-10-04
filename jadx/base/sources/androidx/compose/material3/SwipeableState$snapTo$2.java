package androidx.compose.material3;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "anchors", "", ""}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SwipeableState$snapTo$2<T> implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    public SwipeableState$snapTo$2(T t, SwipeableState<T> swipeableState) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Map) obj, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull Continuation<? super Unit> continuation) {
        SwipeableState$snapTo$2$emit$1 swipeableState$snapTo$2$emit$1;
        SwipeableState$snapTo$2<T> swipeableState$snapTo$2;
        if (continuation instanceof SwipeableState$snapTo$2$emit$1) {
            swipeableState$snapTo$2$emit$1 = (SwipeableState$snapTo$2$emit$1) continuation;
            int i = swipeableState$snapTo$2$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                swipeableState$snapTo$2$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                swipeableState$snapTo$2$emit$1 = new SwipeableState$snapTo$2$emit$1(this, continuation);
            }
        }
        Object obj = swipeableState$snapTo$2$emit$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = swipeableState$snapTo$2$emit$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Float offset = SwipeableKt.getOffset(map, this.$targetValue);
            if (offset == null) {
                throw new IllegalArgumentException("The target value must have an associated anchor.");
            }
            SwipeableState<T> swipeableState = this.this$0;
            float fFloatValue = offset.floatValue();
            swipeableState$snapTo$2$emit$1.L$0 = this;
            swipeableState$snapTo$2$emit$1.label = 1;
            if (swipeableState.snapInternalToOffset(fFloatValue, swipeableState$snapTo$2$emit$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            swipeableState$snapTo$2 = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            swipeableState$snapTo$2 = (SwipeableState$snapTo$2) swipeableState$snapTo$2$emit$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        swipeableState$snapTo$2.this$0.setCurrentValue(swipeableState$snapTo$2.$targetValue);
        return Unit.INSTANCE;
    }
}
