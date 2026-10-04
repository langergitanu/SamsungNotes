package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FlowKt__EmittersKt$onEmpty$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.BooleanRef $isEmpty;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$onEmpty$1$1(Ref.BooleanRef booleanRef, FlowCollector<? super T> flowCollector) {
        this.$isEmpty = booleanRef;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__EmittersKt$onEmpty$1$1$emit$1 flowKt__EmittersKt$onEmpty$1$1$emit$1;
        if (continuation instanceof FlowKt__EmittersKt$onEmpty$1$1$emit$1) {
            flowKt__EmittersKt$onEmpty$1$1$emit$1 = (FlowKt__EmittersKt$onEmpty$1$1$emit$1) continuation;
            int i = flowKt__EmittersKt$onEmpty$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$onEmpty$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__EmittersKt$onEmpty$1$1$emit$1 = new FlowKt__EmittersKt$onEmpty$1$1$emit$1(this, continuation);
            }
        }
        Object obj = flowKt__EmittersKt$onEmpty$1$1$emit$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__EmittersKt$onEmpty$1$1$emit$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.$isEmpty.element = false;
            FlowCollector<T> flowCollector = this.$this_unsafeFlow;
            flowKt__EmittersKt$onEmpty$1$1$emit$1.label = 1;
            if (flowCollector.emit(t, flowKt__EmittersKt$onEmpty$1$1$emit$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
