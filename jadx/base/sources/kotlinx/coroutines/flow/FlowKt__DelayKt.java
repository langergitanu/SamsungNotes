package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectImplementation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u0005H\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\b\n\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u0005H\u0002¢\u0006\u0002\b\r\u001a&\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0007\u001a\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0000\u001a-\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0016\u0010\t\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0017\u0010\t\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\t¨\u0006\u001a"}, m13886d2 = {"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", "", "Lkotlin/Function1;", "timeout", "Lkotlin/time/Duration;", "debounce-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounceDuration", "debounceInternal", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "sample", "periodMillis", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", TypedValues.Cycle.S_WAVE_PERIOD, "sample-HG0u8IE", "timeout-HG0u8IE", "timeoutInternal", "timeoutInternal-HG0u8IE$FlowKt__DelayKt", "kotlinx-coroutines-core"}, m13887k = 5, m13888mv = {2, 0, 0}, m13890xi = 48, m13891xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n1#2:408\n*E\n"})
final /* synthetic */ class FlowKt__DelayKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$1", m14021f = "Delay.kt", m14022i = {0, 1, 2}, m14023l = {307, 309, 310}, m14024m = "invokeSuspend", m14025n = {"$this$produce", "$this$produce", "$this$produce"}, m14026s = {"L$0", "L$0", "L$0"})
    public static final class C133621 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C133621(long j, Continuation<? super C133621> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C133621 c133621 = new C133621(this.$delayMillis, continuation);
            c133621.L$0 = obj;
            return c133621;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[PHI: r1
          0x0050: PHI (r1v4 kotlinx.coroutines.channels.ProducerScope) = (r1v3 kotlinx.coroutines.channels.ProducerScope), (r1v8 kotlinx.coroutines.channels.ProducerScope) binds: [B:16:0x004d, B:10:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:15:0x003f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.L$0;
                long j2 = this.$delayMillis;
                this.L$0 = producerScope;
                this.label = 1;
                if (DelayKt.delay(j2, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    producerScope = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    j = this.$delayMillis;
                    this.L$0 = producerScope;
                    this.label = 3;
                    if (DelayKt.delay(j, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            SendChannel channel = producerScope.getChannel();
            Unit unit = Unit.INSTANCE;
            this.L$0 = producerScope;
            this.label = 2;
            if (channel.send(unit, this) != coroutine_suspended) {
                j = this.$delayMillis;
                this.L$0 = producerScope;
                this.label = 3;
                if (DelayKt.delay(j, this) != coroutine_suspended) {
                    SendChannel channel2 = producerScope.getChannel();
                    Unit unit2 = Unit.INSTANCE;
                    this.L$0 = producerScope;
                    this.label = 2;
                    if (channel2.send(unit2, this) != coroutine_suspended) {
                    }
                }
            }
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
            return ((C133621) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", m14021f = "Delay.kt", m14022i = {0, 0, 0, 0}, m14023l = {412}, m14024m = "invokeSuspend", m14025n = {"downstream", "values", "lastValue", "ticker"}, m14026s = {"L$0", "L$1", "L$2", "L$3"})
    @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n54#2,5:408\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n278#1:408,5\n*E\n"})
    public static final class C133632<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ Flow<T> $this_sample;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C133632(long j, Flow<? extends T> flow, Continuation<? super C133632> continuation) {
            super(3, continuation);
            this.$periodMillis = j;
            this.$this_sample = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ReceiveChannel receiveChannel;
            ReceiveChannel<Unit> receiveChannelFixedPeriodTicker;
            Ref.ObjectRef objectRef;
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                FlowCollector flowCollector2 = (FlowCollector) this.L$1;
                ReceiveChannel receiveChannelProduce$default = ProduceKt.produce$default(coroutineScope, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                receiveChannel = receiveChannelProduce$default;
                receiveChannelFixedPeriodTicker = FlowKt.fixedPeriodTicker(coroutineScope, this.$periodMillis);
                objectRef = objectRef2;
                flowCollector = flowCollector2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannelFixedPeriodTicker = (ReceiveChannel) this.L$3;
                objectRef = (Ref.ObjectRef) this.L$2;
                receiveChannel = (ReceiveChannel) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (objectRef.element != NullSurrogateKt.DONE) {
                SelectImplementation selectImplementation = new SelectImplementation(get$context());
                selectImplementation.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannelFixedPeriodTicker, null));
                selectImplementation.invoke(receiveChannelFixedPeriodTicker.getOnReceive(), new FlowKt__DelayKt$sample$2$1$2(objectRef, flowCollector, null));
                this.L$0 = flowCollector;
                this.L$1 = receiveChannel;
                this.L$2 = objectRef;
                this.L$3 = receiveChannelFixedPeriodTicker;
                this.label = 1;
                if (selectImplementation.doSelect(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            C133632 c133632 = new C133632(this.$periodMillis, this.$this_sample, continuation);
            c133632.L$0 = coroutineScope;
            c133632.L$1 = flowCollector;
            return c133632.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, final long j) {
        if (j >= 0) {
            return j == 0 ? flow : debounceInternal$FlowKt__DelayKt(flow, new Function1() { // from class: kotlinx.coroutines.flow.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Long.valueOf(FlowKt__DelayKt.debounce$lambda$1$FlowKt__DelayKt(j, obj));
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long debounce$lambda$2$FlowKt__DelayKt(Function1 function1, Object obj) {
        return DelayKt.m23695toDelayMillisLRDsOJo(((Duration) function1.invoke(obj)).getRawValue());
    }

    @FlowPreview
    @NotNull
    /* JADX INFO: renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m23741debounceHG0u8IE(@NotNull Flow<? extends T> flow, long j) {
        return FlowKt.debounce(flow, DelayKt.m23695toDelayMillisLRDsOJo(j));
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T> Flow<T> debounceDuration(@NotNull Flow<? extends T> flow, @NotNull final Function1<? super T, Duration> function1) {
        return debounceInternal$FlowKt__DelayKt(flow, new Function1() { // from class: kotlinx.coroutines.flow.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(FlowKt__DelayKt.debounce$lambda$2$FlowKt__DelayKt(function1, obj));
            }
        });
    }

    private static final <T> Flow<T> debounceInternal$FlowKt__DelayKt(Flow<? extends T> flow, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounceInternal$1(function1, flow, null));
    }

    @NotNull
    public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope coroutineScope, long j) {
        return ProduceKt.produce$default(coroutineScope, null, 0, new C133621(j, null), 1, null);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> flow, long j) {
        if (j > 0) {
            return FlowCoroutineKt.scopedFlow(new C133632(j, flow, null));
        }
        throw new IllegalArgumentException("Sample period should be positive");
    }

    @FlowPreview
    @NotNull
    /* JADX INFO: renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m23742sampleHG0u8IE(@NotNull Flow<? extends T> flow, long j) {
        return FlowKt.sample(flow, DelayKt.m23695toDelayMillisLRDsOJo(j));
    }

    @FlowPreview
    @NotNull
    /* JADX INFO: renamed from: timeout-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m23743timeoutHG0u8IE(@NotNull Flow<? extends T> flow, long j) {
        return m23744timeoutInternalHG0u8IE$FlowKt__DelayKt(flow, j);
    }

    /* JADX INFO: renamed from: timeoutInternal-HG0u8IE$FlowKt__DelayKt, reason: not valid java name */
    private static final <T> Flow<T> m23744timeoutInternalHG0u8IE$FlowKt__DelayKt(Flow<? extends T> flow, long j) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$timeoutInternal$1(j, flow, null));
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Long> function1) {
        return debounceInternal$FlowKt__DelayKt(flow, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long debounce$lambda$1$FlowKt__DelayKt(long j, Object obj) {
        return j;
    }
}
