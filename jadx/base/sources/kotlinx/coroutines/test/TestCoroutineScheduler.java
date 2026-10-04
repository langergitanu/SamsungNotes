package kotlinx.coroutines.test;

import com.samsung.android.sdk.mobileservice.profile.Privacy;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.AbstractLongTimeSource;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import kotlinx.coroutines.selects.SelectClause1;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004JM\u0010\u0016\u001a\u00020\u0017\"\b\b\u0000\u0010\u0018*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u0002H\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020!0 H\u0000¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0&H\u0000¢\u0006\u0002\b'J\u0006\u0010(\u001a\u00020\u0014J\u001b\u0010)\u001a\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0&H\u0000¢\u0006\u0002\b*J\u0006\u0010+\u001a\u00020\u0014J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\rH\u0007J\u0015\u0010,\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020!2\b\b\u0002\u00103\u001a\u00020!H\u0000¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b6J\u0010\u00107\u001a\u00020\u0014H\u0080@¢\u0006\u0004\b8\u00109R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\n\u001a\u00020\u000bX\u0082\u0004R&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140;8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140;8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b?\u0010=R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C¨\u0006E"}, m13886d2 = {"Lkotlinx/coroutines/test/TestCoroutineScheduler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "<init>", "()V", Privacy.KEY_EVENTS, "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/test/TestDispatchEvent;", "", "lock", "count", "Lkotlinx/atomicfu/AtomicLong;", "value", "", "currentTime", "getCurrentTime$annotations", "getCurrentTime", "()J", "dispatchEventsForeground", "Lkotlinx/coroutines/channels/Channel;", "", "dispatchEvents", "registerEvent", "Lkotlinx/coroutines/DisposableHandle;", "T", "dispatcher", "Lkotlinx/coroutines/test/TestDispatcher;", "timeDeltaMillis", "marker", "context", "Lkotlin/coroutines/CoroutineContext;", "isCancelled", "Lkotlin/Function1;", "", "registerEvent$kotlinx_coroutines_test", "(Lkotlinx/coroutines/test/TestDispatcher;JLjava/lang/Object;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "tryRunNextTaskUnless", "condition", "Lkotlin/Function0;", "tryRunNextTaskUnless$kotlinx_coroutines_test", "advanceUntilIdle", "advanceUntilIdleOr", "advanceUntilIdleOr$kotlinx_coroutines_test", "runCurrent", "advanceTimeBy", "delayTimeMillis", "delayTime", "Lkotlin/time/Duration;", "advanceTimeBy-LRDsOJo", "(J)V", "isIdle", "strict", "isIdle$kotlinx_coroutines_test", "sendDispatchEvent", "sendDispatchEvent$kotlinx_coroutines_test", "receiveDispatchEvent", "receiveDispatchEvent$kotlinx_coroutines_test", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDispatchEvent", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnDispatchEvent$kotlinx_coroutines_test", "()Lkotlinx/coroutines/selects/SelectClause1;", "onDispatchEventForeground", "getOnDispatchEventForeground$kotlinx_coroutines_test", "timeSource", "Lkotlin/time/TimeSource$WithComparableMarks;", "getTimeSource", "()Lkotlin/time/TimeSource$WithComparableMarks;", "Key", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestCoroutineScheduler.kt\nkotlinx/coroutines/test/TestCoroutineScheduler\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,277:1\n27#2:278\n27#2:281\n27#2:283\n27#2:285\n27#2:287\n27#2:290\n27#2:299\n27#2:302\n27#2:311\n27#2:313\n16#3:279\n16#3:282\n16#3:284\n16#3:286\n16#3:288\n16#3:291\n16#3:300\n16#3:303\n16#3:312\n16#3:314\n1#4:280\n51#5:289\n52#5,7:292\n51#5:301\n52#5,7:304\n*S KotlinDebug\n*F\n+ 1 TestCoroutineScheduler.kt\nkotlinx/coroutines/test/TestCoroutineScheduler\n*L\n45#1:278\n71#1:281\n91#1:283\n127#1:285\n129#1:287\n130#1:290\n166#1:299\n168#1:302\n189#1:311\n79#1:313\n45#1:279\n71#1:282\n91#1:284\n127#1:286\n129#1:288\n130#1:291\n166#1:300\n168#1:303\n189#1:312\n79#1:314\n130#1:289\n130#1:292,7\n168#1:301\n168#1:304,7\n*E\n"})
public final class TestCoroutineScheduler extends AbstractCoroutineContextElement implements CoroutineContext.Element {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final /* synthetic */ AtomicLongFieldUpdater count$volatile$FU = AtomicLongFieldUpdater.newUpdater(TestCoroutineScheduler.class, "count$volatile");
    private volatile /* synthetic */ long count$volatile;
    private long currentTime;

    @NotNull
    private final Channel<Unit> dispatchEvents;

    @NotNull
    private final Channel<Unit> dispatchEventsForeground;

    @NotNull
    private final ThreadSafeHeap<TestDispatchEvent<Object>> events;

    @NotNull
    private final Object lock;

    @NotNull
    private final TimeSource.WithComparableMarks timeSource;

    /* JADX INFO: renamed from: kotlinx.coroutines.test.TestCoroutineScheduler$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"Lkotlinx/coroutines/test/TestCoroutineScheduler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "<init>", "()V", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion implements CoroutineContext.Key<TestCoroutineScheduler> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public TestCoroutineScheduler() {
        super(INSTANCE);
        this.events = new ThreadSafeHeap<>();
        this.lock = new Object();
        this.dispatchEventsForeground = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.dispatchEvents = ChannelKt.Channel$default(-1, null, null, 6, null);
        final DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        this.timeSource = new AbstractLongTimeSource(durationUnit) { // from class: kotlinx.coroutines.test.TestCoroutineScheduler$timeSource$1
            @Override // kotlin.time.AbstractLongTimeSource
            public long read() {
                return this.this$0.getCurrentTime();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean advanceUntilIdle$lambda$7(TestCoroutineScheduler testCoroutineScheduler) {
        return TestCoroutineSchedulerKt.none(testCoroutineScheduler.events, new PropertyReference1Impl() { // from class: kotlinx.coroutines.test.TestCoroutineScheduler$advanceUntilIdle$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((TestDispatchEvent) obj).isForeground);
            }
        });
    }

    private final /* synthetic */ long getCount$volatile() {
        return this.count$volatile;
    }

    public static /* synthetic */ boolean isIdle$kotlinx_coroutines_test$default(TestCoroutineScheduler testCoroutineScheduler, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return testCoroutineScheduler.isIdle$kotlinx_coroutines_test(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isIdle$lambda$15$lambda$14(TestDispatchEvent testDispatchEvent) {
        return !testDispatchEvent.isCancelled.invoke().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerEvent$lambda$5$lambda$2(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerEvent$lambda$5$lambda$4(TestCoroutineScheduler testCoroutineScheduler, TestDispatchEvent testDispatchEvent) {
        synchronized (testCoroutineScheduler.lock) {
            testCoroutineScheduler.events.remove(testDispatchEvent);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final /* synthetic */ void setCount$volatile(long j) {
        this.count$volatile = j;
    }

    @ExperimentalCoroutinesApi
    public final void advanceTimeBy(long delayTimeMillis) {
        Duration.Companion companion = Duration.INSTANCE;
        m23789advanceTimeByLRDsOJo(DurationKt.toDuration(delayTimeMillis, DurationUnit.MILLISECONDS));
    }

    /* JADX INFO: renamed from: advanceTimeBy-LRDsOJo, reason: not valid java name */
    public final void m23789advanceTimeByLRDsOJo(long delayTime) {
        ThreadSafeHeapNode threadSafeHeapNodeRemoveAtImpl;
        TestDispatchEvent testDispatchEvent;
        if (Duration.m23580isNegativeimpl(delayTime)) {
            throw new IllegalArgumentException(("Can not advance time by a negative delay: " + ((Object) Duration.m23594toStringimpl(delayTime))).toString());
        }
        long jAddClamping = TestCoroutineSchedulerKt.addClamping(getCurrentTime(), Duration.m23565getInWholeMillisecondsimpl(delayTime));
        while (true) {
            synchronized (this.lock) {
                long currentTime = getCurrentTime();
                ThreadSafeHeap<TestDispatchEvent<Object>> threadSafeHeap = this.events;
                synchronized (threadSafeHeap) {
                    ThreadSafeHeapNode threadSafeHeapNodeFirstImpl = threadSafeHeap.firstImpl();
                    threadSafeHeapNodeRemoveAtImpl = (threadSafeHeapNodeFirstImpl != null && jAddClamping > ((TestDispatchEvent) threadSafeHeapNodeFirstImpl).time) ? threadSafeHeap.removeAtImpl(0) : null;
                }
                testDispatchEvent = (TestDispatchEvent) threadSafeHeapNodeRemoveAtImpl;
                if (testDispatchEvent == null) {
                    this.currentTime = jAddClamping;
                    return;
                }
                long j = testDispatchEvent.time;
                if (currentTime > j) {
                    TestCoroutineSchedulerKt.currentTimeAheadOfEvents();
                    throw new KotlinNothingValueException();
                }
                this.currentTime = j;
            }
            testDispatchEvent.dispatcher.processEvent$kotlinx_coroutines_test(testDispatchEvent.marker);
        }
    }

    public final void advanceUntilIdle() {
        advanceUntilIdleOr$kotlinx_coroutines_test(new C13486c(1, this));
    }

    public final void advanceUntilIdleOr$kotlinx_coroutines_test(@NotNull Function0<Boolean> condition) {
        while (tryRunNextTaskUnless$kotlinx_coroutines_test(condition)) {
        }
    }

    public final long getCurrentTime() {
        long j;
        synchronized (this.lock) {
            j = this.currentTime;
        }
        return j;
    }

    @NotNull
    public final SelectClause1<Unit> getOnDispatchEvent$kotlinx_coroutines_test() {
        return this.dispatchEvents.getOnReceive();
    }

    @NotNull
    public final SelectClause1<Unit> getOnDispatchEventForeground$kotlinx_coroutines_test() {
        return this.dispatchEventsForeground.getOnReceive();
    }

    @NotNull
    public final TimeSource.WithComparableMarks getTimeSource() {
        return this.timeSource;
    }

    public final boolean isIdle$kotlinx_coroutines_test(boolean strict) {
        boolean zIsEmpty;
        synchronized (this.lock) {
            try {
                zIsEmpty = strict ? this.events.isEmpty() : TestCoroutineSchedulerKt.none(this.events, new C13484a(1));
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsEmpty;
    }

    @Nullable
    public final Object receiveDispatchEvent$kotlinx_coroutines_test(@NotNull Continuation<? super Unit> continuation) {
        Object objReceive = this.dispatchEvents.receive(continuation);
        return objReceive == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objReceive : Unit.INSTANCE;
    }

    @NotNull
    public final <T> DisposableHandle registerEvent$kotlinx_coroutines_test(@NotNull TestDispatcher dispatcher, long timeDeltaMillis, @NotNull T marker, @NotNull CoroutineContext context, @NotNull Function1<? super T, Boolean> isCancelled) {
        DisposableHandle disposableHandle;
        if (timeDeltaMillis < 0) {
            throw new IllegalArgumentException(("Attempted scheduling an event earlier in time (with the time delta " + timeDeltaMillis + PropertyUtils.MAPPED_DELIM2).toString());
        }
        TestCoroutineSchedulerKt.checkSchedulerInContext(this, context);
        long andIncrement = count$volatile$FU.getAndIncrement(this);
        boolean z = context.get(BackgroundWork.INSTANCE) == null;
        synchronized (this.lock) {
            long jAddClamping = TestCoroutineSchedulerKt.addClamping(getCurrentTime(), timeDeltaMillis);
            Intrinsics.checkNotNull(marker, "null cannot be cast to non-null type kotlin.Any");
            final TestDispatchEvent testDispatchEvent = new TestDispatchEvent(dispatcher, andIncrement, jAddClamping, marker, z, new C13489f(isCancelled, marker, 1));
            this.events.addLast(testDispatchEvent);
            sendDispatchEvent$kotlinx_coroutines_test(context);
            disposableHandle = new DisposableHandle() { // from class: kotlinx.coroutines.test.g
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    TestCoroutineScheduler.registerEvent$lambda$5$lambda$4(this.f9457a, testDispatchEvent);
                }
            };
        }
        return disposableHandle;
    }

    public final void runCurrent() {
        long currentTime;
        ThreadSafeHeapNode threadSafeHeapNodeRemoveAtImpl;
        TestDispatchEvent testDispatchEvent;
        synchronized (this.lock) {
            currentTime = getCurrentTime();
        }
        while (true) {
            synchronized (this.lock) {
                ThreadSafeHeap<TestDispatchEvent<Object>> threadSafeHeap = this.events;
                synchronized (threadSafeHeap) {
                    ThreadSafeHeapNode threadSafeHeapNodeFirstImpl = threadSafeHeap.firstImpl();
                    threadSafeHeapNodeRemoveAtImpl = (threadSafeHeapNodeFirstImpl != null && ((TestDispatchEvent) threadSafeHeapNodeFirstImpl).time <= currentTime) ? threadSafeHeap.removeAtImpl(0) : null;
                }
                testDispatchEvent = (TestDispatchEvent) threadSafeHeapNodeRemoveAtImpl;
                if (testDispatchEvent == null) {
                    return;
                }
            }
            testDispatchEvent.dispatcher.processEvent$kotlinx_coroutines_test(testDispatchEvent.marker);
        }
    }

    public final void sendDispatchEvent$kotlinx_coroutines_test(@NotNull CoroutineContext context) {
        Channel<Unit> channel = this.dispatchEvents;
        Unit unit = Unit.INSTANCE;
        channel.mo23705trySendJP2dKIU(unit);
        BackgroundWork backgroundWork = BackgroundWork.INSTANCE;
        if (context.get(backgroundWork) != backgroundWork) {
            this.dispatchEventsForeground.mo23705trySendJP2dKIU(unit);
        }
    }

    public final boolean tryRunNextTaskUnless$kotlinx_coroutines_test(@NotNull Function0<Boolean> condition) {
        synchronized (this.lock) {
            if (condition.invoke().booleanValue()) {
                return false;
            }
            TestDispatchEvent testDispatchEvent = (TestDispatchEvent) this.events.removeFirstOrNull();
            if (testDispatchEvent == null) {
                return false;
            }
            long currentTime = getCurrentTime();
            long j = testDispatchEvent.time;
            if (currentTime > j) {
                TestCoroutineSchedulerKt.currentTimeAheadOfEvents();
                throw new KotlinNothingValueException();
            }
            this.currentTime = j;
            testDispatchEvent.dispatcher.processEvent$kotlinx_coroutines_test(testDispatchEvent.marker);
            return true;
        }
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void getCurrentTime$annotations() {
    }
}
