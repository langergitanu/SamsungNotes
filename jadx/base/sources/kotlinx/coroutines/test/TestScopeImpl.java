package kotlinx.coroutines.test;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImplKt;
import kotlinx.coroutines.test.internal.ExceptionCollector;
import kotlinx.coroutines.test.internal.ReportingSupervisorJob;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0018\u001a\u00020\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001aJ\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0011J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, m13886d2 = {"Lkotlinx/coroutines/test/TestScopeImpl;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/test/TestScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "testScheduler", "Lkotlinx/coroutines/test/TestCoroutineScheduler;", "getTestScheduler", "()Lkotlinx/coroutines/test/TestCoroutineScheduler;", "entered", "", "finished", "uncaughtExceptions", "", "", "lock", "", "backgroundScope", "Lkotlinx/coroutines/CoroutineScope;", "getBackgroundScope", "()Lkotlinx/coroutines/CoroutineScope;", "enter", "leave", "", "legacyLeave", "reportException", "throwable", "tryGetCompletionCause", "toString", "", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestScope.kt\nkotlinx/coroutines/test/TestScopeImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,331:1\n27#2:332\n27#2:335\n27#2:337\n27#2:339\n16#3:333\n16#3:336\n16#3:338\n16#3:340\n1#4:334\n159#5:341\n*S KotlinDebug\n*F\n+ 1 TestScope.kt\nkotlinx/coroutines/test/TestScopeImpl\n*L\n219#1:332\n246#1:335\n256#1:337\n282#1:339\n219#1:333\n246#1:336\n256#1:338\n282#1:340\n289#1:341\n*E\n"})
public final class TestScopeImpl extends AbstractCoroutine<Unit> implements TestScope {

    @NotNull
    private final CoroutineScope backgroundScope;
    private boolean entered;
    private boolean finished;

    @NotNull
    private final Object lock;

    @NotNull
    private final List<Throwable> uncaughtExceptions;

    /* JADX WARN: Multi-variable type inference failed */
    public TestScopeImpl(@NotNull CoroutineContext coroutineContext) {
        super(coroutineContext, true, true);
        this.uncaughtExceptions = new ArrayList();
        this.lock = new Object();
        Job job = null;
        this.backgroundScope = CoroutineScopeKt.CoroutineScope(getCoroutineContext().plus(BackgroundWork.INSTANCE).plus(new ReportingSupervisorJob(job, new Function1() { // from class: kotlinx.coroutines.test.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestScopeImpl.backgroundScope$lambda$0(this.f9459a, (Throwable) obj);
            }
        }, 1, 0 == true ? 1 : 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit backgroundScope$lambda$0(TestScopeImpl testScopeImpl, Throwable th) {
        if (!(th instanceof CancellationException)) {
            testScopeImpl.reportException(th);
        }
        return Unit.INSTANCE;
    }

    public final void enter() {
        ExceptionCollector exceptionCollector;
        List<Throwable> list;
        synchronized (this.lock) {
            try {
                if (this.entered) {
                    throw new IllegalStateException("Only a single call to `runTest` can be performed during one test.");
                }
                this.entered = true;
                if (this.finished) {
                    throw new IllegalStateException("Check failed.");
                }
                exceptionCollector = ExceptionCollector.INSTANCE;
                CoroutineExceptionHandlerImplKt.ensurePlatformExceptionHandlerLoaded(exceptionCollector);
                if (TestScopeKt.getCatchNonTestRelatedExceptions()) {
                    exceptionCollector.addOnExceptionCallback(this.lock, new TestScopeImpl$enter$exceptions$1$2(this));
                }
                list = this.uncaughtExceptions;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (list.isEmpty()) {
            return;
        }
        exceptionCollector.removeOnExceptionCallback(this.lock);
        UncaughtExceptionsBeforeTest uncaughtExceptionsBeforeTest = new UncaughtExceptionsBeforeTest();
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(uncaughtExceptionsBeforeTest, it.next());
        }
        throw uncaughtExceptionsBeforeTest;
    }

    @Override // kotlinx.coroutines.test.TestScope
    @NotNull
    public CoroutineScope getBackgroundScope() {
        return this.backgroundScope;
    }

    @Override // kotlinx.coroutines.test.TestScope
    @NotNull
    public TestCoroutineScheduler getTestScheduler() {
        CoroutineContext.Element element = getContext().get(TestCoroutineScheduler.INSTANCE);
        Intrinsics.checkNotNull(element);
        return (TestCoroutineScheduler) element;
    }

    @NotNull
    public final List<Throwable> leave() {
        List<Throwable> list;
        synchronized (this.lock) {
            if (!this.entered || this.finished) {
                throw new IllegalStateException("Check failed.");
            }
            ExceptionCollector.INSTANCE.removeOnExceptionCallback(this.lock);
            this.finished = true;
            list = this.uncaughtExceptions;
        }
        return list;
    }

    @NotNull
    public final List<Throwable> legacyLeave() {
        List<Throwable> list;
        synchronized (this.lock) {
            if (!this.entered || this.finished) {
                throw new IllegalStateException("Check failed.");
            }
            ExceptionCollector.INSTANCE.removeOnExceptionCallback(this.lock);
            this.finished = true;
            list = this.uncaughtExceptions;
        }
        List list2 = SequencesKt.toList(SequencesKt.filter(getChildren(), new C13484a(5)));
        if (list.isEmpty()) {
            if (!list2.isEmpty()) {
                throw new UncompletedCoroutinesError("Active jobs found during the tear-down. Ensure that all coroutines are completed or cancelled by your test. The active jobs: " + list2);
            }
            if (!TestCoroutineScheduler.isIdle$kotlinx_coroutines_test$default(getTestScheduler(), false, 1, null)) {
                throw new UncompletedCoroutinesError("Unfinished coroutines found during the tear-down. Ensure that all coroutines are completed or cancelled by your test.");
            }
        }
        return list;
    }

    public final void reportException(@NotNull Throwable throwable) {
        synchronized (this.lock) {
            if (this.finished) {
                throw throwable;
            }
            Iterator<Throwable> it = this.uncaughtExceptions.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(throwable, it.next())) {
                    return;
                }
            }
            this.uncaughtExceptions.add(throwable);
            if (this.entered) {
                Unit unit = Unit.INSTANCE;
            } else {
                UncaughtExceptionsBeforeTest uncaughtExceptionsBeforeTest = new UncaughtExceptionsBeforeTest();
                ExceptionsKt.addSuppressed(uncaughtExceptionsBeforeTest, throwable);
                throw uncaughtExceptionsBeforeTest;
            }
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    @NotNull
    public String toString() {
        return AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, this.finished ? "test ended" : this.entered ? "test started" : "test not started", new StringBuilder("TestScope["));
    }

    @Nullable
    public final Throwable tryGetCompletionCause() {
        return getCompletionCause();
    }
}
