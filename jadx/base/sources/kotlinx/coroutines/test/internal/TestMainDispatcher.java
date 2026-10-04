package kotlinx.coroutines.test.internal;

import androidx.collection.AbstractC0622a;
import com.samsung.scsp.common.Header;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.test.TestCoroutineScheduler;
import kotlinx.coroutines.test.TestDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0015j\u0002`\u0014H\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0015j\u0002`\u0014H\u0016¢\u0006\u0002\u0010\u0016J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0010J\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!H\u0016J)\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0013\u001a\u00060\u0015j\u0002`\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010$R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006'"}, m13886d2 = {"Lkotlinx/coroutines/test/internal/TestMainDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "mainDispatcher", "Lkotlinx/coroutines/test/internal/TestMainDispatcher$NonConcurrentlyModifiable;", "delay", "getDelay", "()Lkotlinx/coroutines/Delay;", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "isDispatchNeeded", "", "dispatchYield", "setDispatcher", "dispatcher", "resetDispatcher", "scheduleResumeAfterDelay", "timeMillis", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "Companion", "NonConcurrentlyModifiable", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestMainDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestMainDispatcher.kt\nkotlinx/coroutines/test/internal/TestMainDispatcher\n+ 2 TestMainDispatcher.kt\nkotlinx/coroutines/test/internal/TestMainDispatcherKt\n*L\n1#1,96:1\n92#2:97\n*S KotlinDebug\n*F\n+ 1 TestMainDispatcher.kt\nkotlinx/coroutines/test/internal/TestMainDispatcher\n*L\n20#1:97\n*E\n"})
public final class TestMainDispatcher extends MainCoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private NonConcurrentlyModifiable<CoroutineDispatcher> delegate;

    @NotNull
    private final CoroutineDispatcher mainDispatcher;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lkotlinx/coroutines/test/internal/TestMainDispatcher$Companion;", "", "<init>", "()V", "currentTestDispatcher", "Lkotlinx/coroutines/test/TestDispatcher;", "getCurrentTestDispatcher$kotlinx_coroutines_test", "()Lkotlinx/coroutines/test/TestDispatcher;", "currentTestScheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "getCurrentTestScheduler$kotlinx_coroutines_test", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final TestDispatcher getCurrentTestDispatcher$kotlinx_coroutines_test() {
            NonConcurrentlyModifiable nonConcurrentlyModifiable;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            TestMainDispatcher testMainDispatcher = main instanceof TestMainDispatcher ? (TestMainDispatcher) main : null;
            CoroutineDispatcher coroutineDispatcher = (testMainDispatcher == null || (nonConcurrentlyModifiable = testMainDispatcher.delegate) == null) ? null : (CoroutineDispatcher) nonConcurrentlyModifiable.getValue();
            if (coroutineDispatcher instanceof TestDispatcher) {
                return (TestDispatcher) coroutineDispatcher;
            }
            return null;
        }

        @Nullable
        public final TestCoroutineScheduler getCurrentTestScheduler$kotlinx_coroutines_test() {
            TestDispatcher currentTestDispatcher$kotlinx_coroutines_test = getCurrentTestDispatcher$kotlinx_coroutines_test();
            if (currentTestDispatcher$kotlinx_coroutines_test != null) {
                return currentTestDispatcher$kotlinx_coroutines_test.getScheduler();
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004R\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004R\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004R$\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Lkotlinx/coroutines/test/internal/TestMainDispatcher$NonConcurrentlyModifiable;", "T", "", "initialValue", "name", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "reader", "Lkotlinx/atomicfu/AtomicRef;", "", "readers", "Lkotlinx/atomicfu/AtomicInt;", "writer", "exceptionWhenReading", "_value", "concurrentWW", "Ljava/lang/IllegalStateException;", Header.LOCATION, "concurrentRW", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTestMainDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestMainDispatcher.kt\nkotlinx/coroutines/test/internal/TestMainDispatcher$NonConcurrentlyModifiable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
    public static final class NonConcurrentlyModifiable<T> {
        private volatile /* synthetic */ Object _value$volatile;
        private volatile /* synthetic */ Object exceptionWhenReading$volatile;

        @NotNull
        private final String name;
        private volatile /* synthetic */ Object reader$volatile;
        private volatile /* synthetic */ int readers$volatile;
        private volatile /* synthetic */ Object writer$volatile;
        private static final /* synthetic */ AtomicReferenceFieldUpdater reader$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "reader$volatile");
        private static final /* synthetic */ AtomicIntegerFieldUpdater readers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, "readers$volatile");
        private static final /* synthetic */ AtomicReferenceFieldUpdater writer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "writer$volatile");
        private static final /* synthetic */ AtomicReferenceFieldUpdater exceptionWhenReading$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "exceptionWhenReading$volatile");
        private static final /* synthetic */ AtomicReferenceFieldUpdater _value$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(NonConcurrentlyModifiable.class, Object.class, "_value$volatile");

        public NonConcurrentlyModifiable(T t, @NotNull String str) {
            this.name = str;
            this._value$volatile = t;
        }

        private final IllegalStateException concurrentRW(Throwable location) {
            return new IllegalStateException(AbstractC0622a.m1170p(this.name, " is used concurrently with setting it", new StringBuilder()), location);
        }

        private final IllegalStateException concurrentWW(Throwable location) {
            return new IllegalStateException(AbstractC0622a.m1170p(this.name, " is modified concurrently", new StringBuilder()), location);
        }

        private final /* synthetic */ Object getExceptionWhenReading$volatile() {
            return this.exceptionWhenReading$volatile;
        }

        private final /* synthetic */ Object getReader$volatile() {
            return this.reader$volatile;
        }

        private final /* synthetic */ int getReaders$volatile() {
            return this.readers$volatile;
        }

        private final /* synthetic */ Object getWriter$volatile() {
            return this.writer$volatile;
        }

        private final /* synthetic */ Object get_value$volatile() {
            return this._value$volatile;
        }

        private final /* synthetic */ void setExceptionWhenReading$volatile(Object obj) {
            this.exceptionWhenReading$volatile = obj;
        }

        private final /* synthetic */ void setReader$volatile(Object obj) {
            this.reader$volatile = obj;
        }

        private final /* synthetic */ void setReaders$volatile(int i) {
            this.readers$volatile = i;
        }

        private final /* synthetic */ void setWriter$volatile(Object obj) {
            this.writer$volatile = obj;
        }

        private final /* synthetic */ void set_value$volatile(Object obj) {
            this._value$volatile = obj;
        }

        public final T getValue() {
            reader$volatile$FU.set(this, new Throwable("reader location"));
            readers$volatile$FU.incrementAndGet(this);
            Throwable th = (Throwable) writer$volatile$FU.get(this);
            if (th != null) {
                exceptionWhenReading$volatile$FU.set(this, concurrentRW(th));
            }
            T t = (T) _value$volatile$FU.get(this);
            readers$volatile$FU.decrementAndGet(this);
            return t;
        }

        public final void setValue(T t) throws Throwable {
            Throwable th;
            Throwable th2;
            Throwable th3 = (Throwable) exceptionWhenReading$volatile$FU.getAndSet(this, null);
            if (th3 != null) {
                throw th3;
            }
            if (readers$volatile$FU.get(this) != 0 && (th2 = (Throwable) reader$volatile$FU.get(this)) != null) {
                throw concurrentRW(th2);
            }
            Throwable th4 = new Throwable("other writer location");
            Throwable th5 = (Throwable) writer$volatile$FU.getAndSet(this, th4);
            if (th5 != null) {
                throw concurrentWW(th5);
            }
            _value$volatile$FU.set(this, t);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = writer$volatile$FU;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, th4, null) && atomicReferenceFieldUpdater.get(this) == th4) {
            }
            if (readers$volatile$FU.get(this) != 0 && (th = (Throwable) reader$volatile$FU.get(this)) != null) {
                throw concurrentRW(th);
            }
        }
    }

    public TestMainDispatcher(@NotNull CoroutineDispatcher coroutineDispatcher) {
        this.mainDispatcher = coroutineDispatcher;
        this.delegate = new NonConcurrentlyModifiable<>(coroutineDispatcher, "Dispatchers.Main");
    }

    private final Delay getDelay() {
        CoroutineContext.Element value = this.delegate.getValue();
        Delay delay = value instanceof Delay ? (Delay) value : null;
        return delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
    }

    @Override // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo23763dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        this.delegate.getValue().mo23763dispatch(context, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        this.delegate.getValue().dispatchYield(context, block);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    @NotNull
    public MainCoroutineDispatcher getImmediate() {
        MainCoroutineDispatcher immediate;
        CoroutineDispatcher value = this.delegate.getValue();
        MainCoroutineDispatcher mainCoroutineDispatcher = value instanceof MainCoroutineDispatcher ? (MainCoroutineDispatcher) value : null;
        return (mainCoroutineDispatcher == null || (immediate = mainCoroutineDispatcher.getImmediate()) == null) ? this : immediate;
    }

    @Override // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return getDelay().invokeOnTimeout(timeMillis, block, context);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext context) {
        return this.delegate.getValue().isDispatchNeeded(context);
    }

    public final void resetDispatcher() throws Throwable {
        this.delegate.setValue(this.mainDispatcher);
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo23764scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        getDelay().mo23764scheduleResumeAfterDelay(timeMillis, continuation);
    }

    public final void setDispatcher(@NotNull CoroutineDispatcher dispatcher) throws Throwable {
        this.delegate.setValue(dispatcher);
    }
}
