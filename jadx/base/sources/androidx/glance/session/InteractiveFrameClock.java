package androidx.glance.session;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.GlanceLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bJ\r\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0011J7\u0010\u001c\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001d0\u001fH\u0096@¢\u0006\u0002\u0010#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Landroidx/glance/session/InteractiveFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "baselineHz", "", "interactiveHz", "interactiveTimeoutMs", "", "nanoTime", "Lkotlin/Function0;", "(Lkotlinx/coroutines/CoroutineScope;IIJLkotlin/jvm/functions/Function0;)V", "currentHz", "frameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "interactiveCoroutine", "Lkotlinx/coroutines/CancellableContinuation;", "", "lastFrame", "lock", "", "currentHz$glance_release", "onNewAwaiters", "sendFrame", "now", "startInteractive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopInteractive", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nInteractiveFrameClock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InteractiveFrameClock.kt\nandroidx/glance/session/InteractiveFrameClock\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n1#2:140\n*E\n"})
public final class InteractiveFrameClock implements MonotonicFrameClock {
    private static final boolean DEBUG = true;
    private static final long NANOSECONDS_PER_MILLISECOND = 1000000;
    private static final long NANOSECONDS_PER_SECOND = 1000000000;

    @NotNull
    private static final String TAG = "GWT:InteractiveFrameClock";
    private final int baselineHz;
    private int currentHz;

    @NotNull
    private final BroadcastFrameClock frameClock;

    @Nullable
    private CancellableContinuation<? super Unit> interactiveCoroutine;
    private final int interactiveHz;
    private final long interactiveTimeoutMs;
    private long lastFrame;

    @NotNull
    private final Object lock;

    @NotNull
    private final Function0<Long> nanoTime;

    @NotNull
    private final CoroutineScope scope;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.glance.session.InteractiveFrameClock$onNewAwaiters$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.InteractiveFrameClock$onNewAwaiters$2", m14021f = "InteractiveFrameClock.kt", m14022i = {}, m14023l = {119, 122}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C35052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.LongRef $minPeriod;
        final /* synthetic */ long $now;
        final /* synthetic */ Ref.LongRef $period;
        int label;
        final /* synthetic */ InteractiveFrameClock this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C35052(Ref.LongRef longRef, Ref.LongRef longRef2, InteractiveFrameClock interactiveFrameClock, long j, Continuation<? super C35052> continuation) {
            super(2, continuation);
            this.$period = longRef;
            this.$minPeriod = longRef2;
            this.this$0 = interactiveFrameClock;
            this.$now = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C35052(this.$period, this.$minPeriod, this.this$0, this.$now, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        
            if (kotlinx.coroutines.YieldKt.yield(r8) == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay((r6 - r4) / 1000000, r8) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$period.element;
                long j2 = this.$minPeriod.element;
                if (j >= j2) {
                    this.label = 1;
                } else {
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                this.this$0.sendFrame(this.$now);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                InteractiveFrameClock interactiveFrameClock = this.this$0;
                interactiveFrameClock.sendFrame(((Number) interactiveFrameClock.nanoTime.invoke()).longValue());
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C35052) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.InteractiveFrameClock$startInteractive$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.session.InteractiveFrameClock$startInteractive$2", m14021f = "InteractiveFrameClock.kt", m14022i = {}, m14023l = {140}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nInteractiveFrameClock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InteractiveFrameClock.kt\nandroidx/glance/session/InteractiveFrameClock$startInteractive$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,139:1\n314#2,11:140\n*S KotlinDebug\n*F\n+ 1 InteractiveFrameClock.kt\nandroidx/glance/session/InteractiveFrameClock$startInteractive$2\n*L\n68#1:140,11\n*E\n"})
    public static final class C35062 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public C35062(Continuation<? super C35062> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return InteractiveFrameClock.this.new C35062(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InteractiveFrameClock.this.stopInteractive();
                final InteractiveFrameClock interactiveFrameClock = InteractiveFrameClock.this;
                this.L$0 = interactiveFrameClock;
                this.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                GlanceLog.INSTANCE.m2297d(InteractiveFrameClock.TAG, "Starting interactive mode at " + interactiveFrameClock.interactiveHz + "hz");
                synchronized (interactiveFrameClock.lock) {
                    interactiveFrameClock.currentHz = interactiveFrameClock.interactiveHz;
                    interactiveFrameClock.interactiveCoroutine = cancellableContinuationImpl;
                    Unit unit = Unit.INSTANCE;
                }
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.glance.session.InteractiveFrameClock$startInteractive$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th) {
                        GlanceLog.INSTANCE.m2297d("GWT:InteractiveFrameClock", "Resetting frame rate to baseline at " + interactiveFrameClock.baselineHz + "hz");
                        Object obj2 = interactiveFrameClock.lock;
                        InteractiveFrameClock interactiveFrameClock2 = interactiveFrameClock;
                        synchronized (obj2) {
                            interactiveFrameClock2.currentHz = interactiveFrameClock2.baselineHz;
                            interactiveFrameClock2.interactiveCoroutine = null;
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
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
            return ((C35062) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public InteractiveFrameClock(@NotNull CoroutineScope scope, int i, int i2, long j, @NotNull Function0<Long> nanoTime) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(nanoTime, "nanoTime");
        this.scope = scope;
        this.baselineHz = i;
        this.interactiveHz = i2;
        this.interactiveTimeoutMs = j;
        this.nanoTime = nanoTime;
        this.frameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.glance.session.InteractiveFrameClock$frameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.onNewAwaiters();
            }
        });
        this.lock = new Object();
        this.currentHz = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNewAwaiters() {
        long jLongValue = this.nanoTime.invoke().longValue();
        Ref.LongRef longRef = new Ref.LongRef();
        Ref.LongRef longRef2 = new Ref.LongRef();
        synchronized (this.lock) {
            longRef.element = jLongValue - this.lastFrame;
            longRef2.element = NANOSECONDS_PER_SECOND / ((long) this.currentHz);
            Unit unit = Unit.INSTANCE;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C35052(longRef, longRef2, this, jLongValue, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendFrame(long now) {
        GlanceLog.INSTANCE.m2297d(TAG, "Sending next frame");
        this.frameClock.sendFrame(now);
        synchronized (this.lock) {
            this.lastFrame = now;
            Unit unit = Unit.INSTANCE;
        }
    }

    @VisibleForTesting
    public final int currentHz$glance_release() {
        int i;
        synchronized (this.lock) {
            i = this.currentHz;
        }
        return i;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.plus(this, coroutineContext);
    }

    @Nullable
    public final Object startInteractive(@NotNull Continuation<? super Unit> continuation) {
        return TimeoutKt.withTimeoutOrNull(this.interactiveTimeoutMs, new C35062(null), continuation);
    }

    public final void stopInteractive() {
        synchronized (this.lock) {
            CancellableContinuation<? super Unit> cancellableContinuation = this.interactiveCoroutine;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
        }
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    @Nullable
    public <R> Object withFrameNanos(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        GlanceLog.INSTANCE.m2297d(TAG, "received frame to run");
        return this.frameClock.withFrameNanos(function1, continuation);
    }

    public /* synthetic */ InteractiveFrameClock(CoroutineScope coroutineScope, int i, int i2, long j, Function0 function0, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i4 & 2) != 0 ? 5 : i, (i4 & 4) != 0 ? 20 : i2, (i4 & 8) != 0 ? 5000L : j, (i4 & 16) != 0 ? new Function0<Long>() { // from class: androidx.glance.session.InteractiveFrameClock.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(System.nanoTime());
            }
        } : function0);
    }
}
