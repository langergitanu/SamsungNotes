package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m13886d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n153#2,12:109\n165#2:122\n1#3:121\n*E\n"})
public final class FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1<T> implements Flow<List<? extends T>> {
    final /* synthetic */ int $size$inlined;
    final /* synthetic */ Flow $this_chunked$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1$1 */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.flow.FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1", m14021f = "Transform.kt", m14022i = {0, 0}, m14023l = {110, 120}, m14024m = "collect", m14025n = {"$this$chunked_u24lambda_u2413", "result"}, m14026s = {"L$0", "L$1"})
    public static final class C134091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C134091(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1(Flow flow, int i) {
        this.$this_chunked$inlined = flow;
        this.$size$inlined = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        if (r2.emit(r8, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super List<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
        C134091 c134091;
        FlowCollector flowCollector2;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C134091) {
            c134091 = (C134091) continuation;
            int i = c134091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c134091.label = i - Integer.MIN_VALUE;
            } else {
                c134091 = new C134091(continuation);
            }
        }
        Object obj = c134091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c134091.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Flow flow = this.$this_chunked$inlined;
            FlowKt__TransformKt$chunked$2$1 flowKt__TransformKt$chunked$2$1 = new FlowKt__TransformKt$chunked$2$1(objectRef2, this.$size$inlined, flowCollector);
            c134091.L$0 = flowCollector;
            c134091.L$1 = objectRef2;
            c134091.label = 1;
            if (flow.collect(flowKt__TransformKt$chunked$2$1, c134091) != coroutine_suspended) {
                flowCollector2 = flowCollector;
                objectRef = objectRef2;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        objectRef = (Ref.ObjectRef) c134091.L$1;
        flowCollector2 = (FlowCollector) c134091.L$0;
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = (ArrayList) objectRef.element;
        if (arrayList != null) {
            c134091.L$0 = null;
            c134091.L$1 = null;
            c134091.label = 2;
        }
        return Unit.INSTANCE;
    }
}
