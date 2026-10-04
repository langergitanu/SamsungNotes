package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m13886d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,108:1\n119#2,4:109\n*E\n"})
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Object[] $elements$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", m14021f = "Builders.kt", m14022i = {0, 0}, m14023l = {110}, m14024m = "collect", m14025n = {"this", "$this$flowOf_u24lambda_u248"}, m14026s = {"L$0", "L$1"})
    public static final class C133511 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C133511(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] objArr) {
        this.$elements$inlined = objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005d -> B:19:0x0060). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C133511 c133511;
        int i;
        ?? r8;
        int length;
        FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
        if (continuation instanceof C133511) {
            c133511 = (C133511) continuation;
            int i2 = c133511.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c133511.label = i2 - Integer.MIN_VALUE;
            } else {
                c133511 = new C133511(continuation);
            }
        }
        Object obj = c133511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c133511.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            r8 = flowCollector;
            length = this.$elements$inlined.length;
            flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 = this;
            if (i < length) {
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = c133511.I$1;
            i = c133511.I$0;
            FlowCollector flowCollector2 = (FlowCollector) c133511.L$1;
            flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 = (FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1) c133511.L$0;
            ResultKt.throwOnFailure(obj);
            ?? r82 = flowCollector2;
            i++;
            r8 = r82;
            if (i < length) {
                Object obj2 = flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.$elements$inlined[i];
                c133511.L$0 = flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
                c133511.L$1 = r8;
                c133511.I$0 = i;
                c133511.I$1 = length;
                c133511.label = 1;
                Object objEmit = r8.emit(obj2, c133511);
                r82 = r8;
                if (objEmit == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i++;
                r8 = r82;
                if (i < length) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
