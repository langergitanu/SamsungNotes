package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.TimeSource;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0007\u001a\f\u0010\t\u001a\u00020\b*\u00020\u0002H\u0007\u001a\u0014\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0007\u001a\u001b\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0010\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u001a\f\u0010\u0018\u001a\u00020\u0017*\u00020\u0017H\u0000\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0002H\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0011*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014\"$\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, m13886d2 = {"currentTime", "", "Lkotlinx/coroutines/test/TestScope;", "getCurrentTime$annotations", "(Lkotlinx/coroutines/test/TestScope;)V", "getCurrentTime", "(Lkotlinx/coroutines/test/TestScope;)J", "advanceUntilIdle", "", "runCurrent", "advanceTimeBy", "delayTimeMillis", "delayTime", "Lkotlin/time/Duration;", "advanceTimeBy-HG0u8IE", "(Lkotlinx/coroutines/test/TestScope;J)V", "testTimeSource", "Lkotlin/time/TimeSource$WithComparableMarks;", "getTestTimeSource$annotations", "getTestTimeSource", "(Lkotlinx/coroutines/test/TestScope;)Lkotlin/time/TimeSource$WithComparableMarks;", "TestScope", "context", "Lkotlin/coroutines/CoroutineContext;", "withDelaySkipping", "asSpecificImplementation", "Lkotlinx/coroutines/test/TestScopeImpl;", "catchNonTestRelatedExceptions", "", "getCatchNonTestRelatedExceptions$annotations", "()V", "getCatchNonTestRelatedExceptions", "()Z", "setCatchNonTestRelatedExceptions", "(Z)V", "kotlinx-coroutines-test"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestScope.kt\nkotlinx/coroutines/test/TestScopeKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,331:1\n46#2,4:332\n1#3:336\n*S KotlinDebug\n*F\n+ 1 TestScope.kt\nkotlinx/coroutines/test/TestScopeKt\n*L\n166#1:332,4\n*E\n"})
public final class TestScopeKt {
    private static boolean catchNonTestRelatedExceptions = true;

    /* JADX WARN: Type inference failed for: r1v1, types: [T, kotlinx.coroutines.test.TestScope, kotlinx.coroutines.test.TestScopeImpl] */
    @NotNull
    public static final TestScope TestScope(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextWithDelaySkipping = withDelaySkipping(coroutineContext);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        CoroutineExceptionHandler.Companion companion = CoroutineExceptionHandler.INSTANCE;
        if (((CoroutineExceptionHandler) coroutineContextWithDelaySkipping.get(companion)) != null) {
            throw new IllegalArgumentException("A CoroutineExceptionHandler was passed to TestScope. Please pass it as an argument to a `launch` or `async` block on an already-created scope if uncaught exceptions require special treatment.");
        }
        ?? testScopeImpl = new TestScopeImpl(coroutineContextWithDelaySkipping.plus(new TestScopeKt$TestScope$$inlined$CoroutineExceptionHandler$1(companion, objectRef)));
        objectRef.element = testScopeImpl;
        return testScopeImpl;
    }

    public static /* synthetic */ TestScope TestScope$default(CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return TestScope(coroutineContext);
    }

    @ExperimentalCoroutinesApi
    public static final void advanceTimeBy(@NotNull TestScope testScope, long j) {
        testScope.getTestScheduler().advanceTimeBy(j);
    }

    @ExperimentalCoroutinesApi
    /* JADX INFO: renamed from: advanceTimeBy-HG0u8IE, reason: not valid java name */
    public static final void m23790advanceTimeByHG0u8IE(@NotNull TestScope testScope, long j) {
        testScope.getTestScheduler().m23789advanceTimeByLRDsOJo(j);
    }

    @ExperimentalCoroutinesApi
    public static final void advanceUntilIdle(@NotNull TestScope testScope) {
        testScope.getTestScheduler().advanceUntilIdle();
    }

    @NotNull
    public static final TestScopeImpl asSpecificImplementation(@NotNull TestScope testScope) {
        if (testScope instanceof TestScopeImpl) {
            return (TestScopeImpl) testScope;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean getCatchNonTestRelatedExceptions() {
        return catchNonTestRelatedExceptions;
    }

    public static final long getCurrentTime(@NotNull TestScope testScope) {
        return testScope.getTestScheduler().getCurrentTime();
    }

    @NotNull
    public static final TimeSource.WithComparableMarks getTestTimeSource(@NotNull TestScope testScope) {
        return testScope.getTestScheduler().getTimeSource();
    }

    @ExperimentalCoroutinesApi
    public static final void runCurrent(@NotNull TestScope testScope) {
        testScope.getTestScheduler().runCurrent();
    }

    public static final void setCatchNonTestRelatedExceptions(boolean z) {
        catchNonTestRelatedExceptions = z;
    }

    @NotNull
    public static final CoroutineContext withDelaySkipping(@NotNull CoroutineContext coroutineContext) {
        TestDispatcher testDispatcherStandardTestDispatcher$default;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.INSTANCE);
        if (continuationInterceptor instanceof TestDispatcher) {
            TestCoroutineScheduler testCoroutineScheduler = (TestCoroutineScheduler) coroutineContext.get(TestCoroutineScheduler.INSTANCE);
            if (testCoroutineScheduler != null && ((TestDispatcher) continuationInterceptor).getScheduler() != testCoroutineScheduler) {
                throw new IllegalArgumentException(("Both a TestCoroutineScheduler " + testCoroutineScheduler + " and TestDispatcher " + continuationInterceptor + " linked to another scheduler were passed.").toString());
            }
            testDispatcherStandardTestDispatcher$default = (TestDispatcher) continuationInterceptor;
        } else {
            if (continuationInterceptor != null) {
                throw new IllegalArgumentException("Dispatcher must implement TestDispatcher: " + continuationInterceptor);
            }
            testDispatcherStandardTestDispatcher$default = TestCoroutineDispatchersKt.StandardTestDispatcher$default((TestCoroutineScheduler) coroutineContext.get(TestCoroutineScheduler.INSTANCE), null, 2, null);
        }
        return coroutineContext.plus(testDispatcherStandardTestDispatcher$default).plus(testDispatcherStandardTestDispatcher$default.getScheduler());
    }

    @PublishedApi
    public static /* synthetic */ void getCatchNonTestRelatedExceptions$annotations() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void getCurrentTime$annotations(TestScope testScope) {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void getTestTimeSource$annotations(TestScope testScope) {
    }
}
