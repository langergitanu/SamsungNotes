package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001aB\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m13886d2 = {"count", "", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m13887k = 5, m13888mv = {2, 0, 0}, m13890xi = 48, m13891xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__CountKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.flow.FlowKt__CountKt", m14021f = "Count.kt", m14022i = {0}, m14023l = {13}, m14024m = "count", m14025n = {"i"}, m14026s = {"L$0"})
    public static final class C133571<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C133571(Continuation<? super C133571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.count(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.flow.FlowKt__CountKt", m14021f = "Count.kt", m14022i = {0}, m14023l = {25}, m14024m = "count", m14025n = {"i"}, m14026s = {"L$0"})
    public static final class C133593<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C133593(Continuation<? super C133593> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.count(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class C133604<T> implements FlowCollector {

        /* JADX INFO: renamed from: $i */
        final /* synthetic */ Ref.IntRef f9424$i;
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

        /* JADX WARN: Multi-variable type inference failed */
        public C133604(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Ref.IntRef intRef) {
            this.$predicate = function2;
            this.f9424$i = intRef;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$1;
            C133604<T> c133604;
            if (continuation instanceof FlowKt__CountKt$count$4$emit$1) {
                flowKt__CountKt$count$4$emit$1 = (FlowKt__CountKt$count$4$emit$1) continuation;
                int i = flowKt__CountKt$count$4$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CountKt$count$4$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, continuation);
                }
            }
            Object objInvoke = flowKt__CountKt$count$4$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__CountKt$count$4$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                flowKt__CountKt$count$4$emit$1.L$0 = this;
                flowKt__CountKt$count$4$emit$1.label = 1;
                objInvoke = function2.invoke(t, flowKt__CountKt$count$4$emit$1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c133604 = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c133604 = (C133604) flowKt__CountKt$count$4$emit$1.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            if (((Boolean) objInvoke).booleanValue()) {
                c133604.f9424$i.element++;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        C133571 c133571;
        Ref.IntRef intRef;
        if (continuation instanceof C133571) {
            c133571 = (C133571) continuation;
            int i = c133571.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c133571.label = i - Integer.MIN_VALUE;
            } else {
                c133571 = new C133571(continuation);
            }
        }
        Object obj = c133571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c133571.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.IntRef intRef2 = new Ref.IntRef();
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt.count.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, Continuation<? super Unit> continuation2) {
                    intRef2.element++;
                    return Unit.INSTANCE;
                }
            };
            c133571.L$0 = intRef2;
            c133571.label = 1;
            if (flow.collect(flowCollector, c133571) == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (Ref.IntRef) c133571.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        C133593 c133593;
        Ref.IntRef intRef;
        if (continuation instanceof C133593) {
            c133593 = (C133593) continuation;
            int i = c133593.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c133593.label = i - Integer.MIN_VALUE;
            } else {
                c133593 = new C133593(continuation);
            }
        }
        Object obj = c133593.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c133593.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.IntRef intRef2 = new Ref.IntRef();
            FlowCollector<? super Object> c133604 = new C133604<>(function2, intRef2);
            c133593.L$0 = intRef2;
            c133593.label = 1;
            if (flow.collect(c133604, c133593) == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (Ref.IntRef) c133593.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(intRef.element);
    }
}
