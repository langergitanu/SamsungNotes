package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m13886d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n1#1,108:1\n129#2,15:109\n*E\n"})
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", m14021f = "Errors.kt", m14022i = {0, 0, 0, 0, 1, 1, 1, 1}, m14023l = {113, 115}, m14024m = "collect", m14025n = {"this", "$this$retryWhen_u24lambda_u242", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u242", "cause", "attempt"}, m14026s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
    public static final class C133751 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C133751(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0076 -> B:30:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0097 -> B:27:0x009a). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        C133751 c133751;
        long j;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        int i;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
        FlowCollector<? super T> flowCollector2;
        Throwable th;
        Object objCatchImpl;
        if (continuation instanceof C133751) {
            c133751 = (C133751) continuation;
            int i2 = c133751.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c133751.label = i2 - Integer.MIN_VALUE;
            } else {
                c133751 = new C133751(continuation);
            }
        }
        Object obj = c133751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c133751.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            j = 0;
            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = this;
            Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$this_retryWhen$inlined;
            c133751.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
            c133751.L$1 = flowCollector;
            c133751.L$2 = null;
            c133751.J$0 = j;
            c133751.I$0 = 0;
            c133751.label = 1;
            objCatchImpl = FlowKt.catchImpl(flow, flowCollector, c133751);
            if (objCatchImpl != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            i = c133751.I$0;
            j = c133751.J$0;
            flowCollector2 = (FlowCollector) c133751.L$1;
            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) c133751.L$0;
            ResultKt.throwOnFailure(obj);
            th = (Throwable) obj;
            if (th != null) {
            }
            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
            if (i == 0) {
            }
        } else {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c133751.J$0;
            Throwable th2 = (Throwable) c133751.L$2;
            flowCollector2 = (FlowCollector) c133751.L$1;
            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) c133751.L$0;
            ResultKt.throwOnFailure(obj);
            if (!((Boolean) obj).booleanValue()) {
                j++;
                i = 1;
                flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                if (i == 0) {
                    return Unit.INSTANCE;
                }
                flowCollector = flowCollector2;
                Flow flow2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$this_retryWhen$inlined;
                c133751.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                c133751.L$1 = flowCollector;
                c133751.L$2 = null;
                c133751.J$0 = j;
                c133751.I$0 = 0;
                c133751.label = 1;
                objCatchImpl = FlowKt.catchImpl(flow2, flowCollector, c133751);
                if (objCatchImpl != coroutine_suspended) {
                    flowCollector2 = flowCollector;
                    i = 0;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                    obj = objCatchImpl;
                    th = (Throwable) obj;
                    if (th != null) {
                        Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$predicate$inlined;
                        Long lBoxLong = Boxing.boxLong(j);
                        c133751.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        c133751.L$1 = flowCollector2;
                        c133751.L$2 = th;
                        c133751.J$0 = j;
                        c133751.label = 2;
                        InlineMarker.mark(6);
                        Object objInvoke = function4.invoke(flowCollector2, th, lBoxLong, c133751);
                        InlineMarker.mark(7);
                        if (objInvoke != coroutine_suspended) {
                            obj = objInvoke;
                            th2 = th;
                            if (!((Boolean) obj).booleanValue()) {
                                throw th2;
                            }
                        }
                    }
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                    if (i == 0) {
                    }
                }
                return coroutine_suspended;
            }
        }
    }
}
