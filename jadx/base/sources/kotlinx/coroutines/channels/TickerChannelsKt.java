package kotlinx.coroutines.channels;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a,\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r\u001a,\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, m13886d2 = {"ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "delayMillis", "", "initialDelayMillis", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "fixedPeriodTicker", NetworkConfig.CLIENTS_CHANNEL, "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedDelayTicker", "kotlinx-coroutines-core"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTickerChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickerChannels.kt\nkotlinx/coroutines/channels/TickerChannelsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
public final class TickerChannelsKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.channels.TickerChannelsKt", m14021f = "TickerChannels.kt", m14022i = {0, 0, 1, 1, 2, 2}, m14023l = {102, 104, 105}, m14024m = "fixedDelayTicker", m14025n = {NetworkConfig.CLIENTS_CHANNEL, "delayMillis", NetworkConfig.CLIENTS_CHANNEL, "delayMillis", NetworkConfig.CLIENTS_CHANNEL, "delayMillis"}, m14026s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    public static final class C133251 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C133251(Continuation<? super C133251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TickerChannelsKt.fixedDelayTicker(0L, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.channels.TickerChannelsKt", m14021f = "TickerChannels.kt", m14022i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, m14023l = {80, 84, 90, 92}, m14024m = "fixedPeriodTicker", m14025n = {NetworkConfig.CLIENTS_CHANNEL, "delayMillis", "deadline", NetworkConfig.CLIENTS_CHANNEL, "deadline", "delayNs", NetworkConfig.CLIENTS_CHANNEL, "deadline", "delayNs", NetworkConfig.CLIENTS_CHANNEL, "deadline", "delayNs"}, m14026s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
    public static final class C133261 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C133261(Continuation<? super C133261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TickerChannelsKt.fixedPeriodTicker(0L, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", m14021f = "TickerChannels.kt", m14022i = {}, m14023l = {68, 69}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C133273 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        final /* synthetic */ TickerMode $mode;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TickerMode.values().length];
                try {
                    iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C133273(TickerMode tickerMode, long j, long j2, Continuation<? super C133273> continuation) {
            super(2, continuation);
            this.$mode = tickerMode;
            this.$delayMillis = j;
            this.$initialDelayMillis = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C133273 c133273 = new C133273(this.$mode, this.$delayMillis, this.$initialDelayMillis, continuation);
            c133273.L$0 = obj;
            return c133273;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            if (kotlinx.coroutines.channels.TickerChannelsKt.fixedDelayTicker(r4, r6, r8, r10) == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
        
            if (kotlinx.coroutines.channels.TickerChannelsKt.fixedPeriodTicker(r1, r3, r11, r10) == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()];
                if (i2 == 1) {
                    long j = this.$delayMillis;
                    long j2 = this.$initialDelayMillis;
                    SendChannel channel = producerScope.getChannel();
                    this.label = 1;
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    long j3 = this.$delayMillis;
                    long j5 = this.$initialDelayMillis;
                    SendChannel channel2 = producerScope.getChannel();
                    this.label = 2;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
            return ((C133273) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) != r1) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:14:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        C133251 c133251;
        SendChannel<? super Unit> sendChannel2;
        if (continuation instanceof C133251) {
            c133251 = (C133251) continuation;
            int i = c133251.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c133251.label = i - Integer.MIN_VALUE;
            } else {
                c133251 = new C133251(continuation);
            }
        }
        Object obj = c133251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c133251.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c133251.L$0 = sendChannel;
            c133251.J$0 = j;
            c133251.label = 1;
            if (DelayKt.delay(j2, c133251) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            j = c133251.J$0;
            sendChannel = (SendChannel) c133251.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            j = c133251.J$0;
            sendChannel2 = (SendChannel) c133251.L$0;
            ResultKt.throwOnFailure(obj);
            c133251.L$0 = sendChannel2;
            c133251.J$0 = j;
            c133251.label = 3;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c133251.J$0;
            sendChannel2 = (SendChannel) c133251.L$0;
            ResultKt.throwOnFailure(obj);
            sendChannel = sendChannel2;
        }
        Unit unit = Unit.INSTANCE;
        c133251.L$0 = sendChannel;
        c133251.J$0 = j;
        c133251.label = 2;
        if (sendChannel.send(unit, c133251) != coroutine_suspended) {
            sendChannel2 = sendChannel;
            c133251.L$0 = sendChannel2;
            c133251.J$0 = j;
            c133251.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fa, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) == r2) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0113, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r1) != r2) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00fd -> B:31:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0113 -> B:15:0x003d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedPeriodTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        C133261 c133261;
        SendChannel sendChannel2;
        long j3;
        long j5;
        long jDelayToNanos;
        long j6;
        long j7;
        SendChannel sendChannel3;
        char c;
        long j8;
        long jCoerceAtLeast;
        char c2;
        char c4;
        Unit unit;
        if (continuation instanceof C133261) {
            c133261 = (C133261) continuation;
            int i = c133261.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c133261.label = i - Integer.MIN_VALUE;
            } else {
                c133261 = new C133261(continuation);
            }
        }
        Object obj = c133261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c133261.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
            long jNanoTime = (abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime()) + EventLoop_commonKt.delayToNanos(j2);
            sendChannel2 = sendChannel;
            c133261.L$0 = sendChannel2;
            j3 = j;
            c133261.J$0 = j3;
            c133261.J$1 = jNanoTime;
            c133261.label = 1;
            if (DelayKt.delay(j2, c133261) != coroutine_suspended) {
                j5 = jNanoTime;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                j7 = c133261.J$1;
                j8 = c133261.J$0;
                sendChannel3 = (SendChannel) c133261.L$0;
                ResultKt.throwOnFailure(obj);
                AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.timeSource;
                if (abstractTimeSource2 == null) {
                }
                jCoerceAtLeast = RangesKt.coerceAtLeast(j8 - jNanoTime, 0L);
                if (jCoerceAtLeast == 0) {
                    c2 = 3;
                    long jDelayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                    c133261.L$0 = sendChannel3;
                    c133261.J$0 = j8;
                    c133261.J$1 = j7;
                    c4 = 4;
                    c133261.label = 4;
                }
                long j9 = j5 + jDelayToNanos;
                unit = Unit.INSTANCE;
                c133261.L$0 = sendChannel2;
                c133261.J$0 = j9;
                c133261.J$1 = jDelayToNanos;
                c133261.label = 2;
                if (sendChannel2.send(unit, c133261) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 3) {
                j7 = c133261.J$1;
                j6 = c133261.J$0;
                sendChannel3 = (SendChannel) c133261.L$0;
                ResultKt.throwOnFailure(obj);
                c = 3;
                long j10 = j6;
                jDelayToNanos = j7;
                j5 = j10;
                sendChannel2 = sendChannel3;
                long j92 = j5 + jDelayToNanos;
                unit = Unit.INSTANCE;
                c133261.L$0 = sendChannel2;
                c133261.J$0 = j92;
                c133261.J$1 = jDelayToNanos;
                c133261.label = 2;
                if (sendChannel2.send(unit, c133261) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j7 = c133261.J$1;
            j8 = c133261.J$0;
            sendChannel3 = (SendChannel) c133261.L$0;
            ResultKt.throwOnFailure(obj);
            c4 = 4;
            c2 = 3;
            long j11 = j8;
            jDelayToNanos = j7;
            j5 = j11;
            sendChannel2 = sendChannel3;
            long j922 = j5 + jDelayToNanos;
            unit = Unit.INSTANCE;
            c133261.L$0 = sendChannel2;
            c133261.J$0 = j922;
            c133261.J$1 = jDelayToNanos;
            c133261.label = 2;
            if (sendChannel2.send(unit, c133261) != coroutine_suspended) {
                long j12 = jDelayToNanos;
                j8 = j922;
                j7 = j12;
                sendChannel3 = sendChannel2;
                AbstractTimeSource abstractTimeSource22 = AbstractTimeSourceKt.timeSource;
                long jNanoTime2 = abstractTimeSource22 == null ? abstractTimeSource22.nanoTime() : System.nanoTime();
                jCoerceAtLeast = RangesKt.coerceAtLeast(j8 - jNanoTime2, 0L);
                if (jCoerceAtLeast == 0 || j7 == 0) {
                    c2 = 3;
                    long jDelayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                    c133261.L$0 = sendChannel3;
                    c133261.J$0 = j8;
                    c133261.J$1 = j7;
                    c4 = 4;
                    c133261.label = 4;
                } else {
                    long j13 = j7 - ((jNanoTime2 - j8) % j7);
                    j6 = jNanoTime2 + j13;
                    long jDelayNanosToMillis3 = EventLoop_commonKt.delayNanosToMillis(j13);
                    c133261.L$0 = sendChannel3;
                    c133261.J$0 = j6;
                    c133261.J$1 = j7;
                    c = 3;
                    c133261.label = 3;
                }
            }
            return coroutine_suspended;
        }
        j5 = c133261.J$1;
        long j14 = c133261.J$0;
        SendChannel sendChannel4 = (SendChannel) c133261.L$0;
        ResultKt.throwOnFailure(obj);
        sendChannel2 = sendChannel4;
        j3 = j14;
        jDelayToNanos = EventLoop_commonKt.delayToNanos(j3);
        long j9222 = j5 + jDelayToNanos;
        unit = Unit.INSTANCE;
        c133261.L$0 = sendChannel2;
        c133261.J$0 = j9222;
        c133261.J$1 = jDelayToNanos;
        c133261.label = 2;
        if (sendChannel2.send(unit, c133261) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final ReceiveChannel<Unit> ticker(long j, long j2, @NotNull CoroutineContext coroutineContext, @NotNull TickerMode tickerMode) {
        if (j < 0) {
            throw new IllegalArgumentException(AbstractC1974b.m1317j(j, "Expected non-negative delay, but has ", " ms").toString());
        }
        if (j2 >= 0) {
            return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new C133273(tickerMode, j, j2, null));
        }
        throw new IllegalArgumentException(AbstractC1974b.m1317j(j2, "Expected non-negative initial delay, but has ", " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }
}
