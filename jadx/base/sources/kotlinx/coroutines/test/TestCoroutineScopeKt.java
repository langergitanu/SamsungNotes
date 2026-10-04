package kotlinx.coroutines.test;

import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007\u001a\u0012\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0005H\u0007\u001a\f\u0010\u0014\u001a\u00020\u0013*\u00020\u0005H\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00038Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001e\u0010\f\u001a\u00020\r*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, m13886d2 = {"activeJobs", "", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext;", "TestCoroutineScope", "Lkotlinx/coroutines/test/TestCoroutineScope;", "context", "createTestCoroutineScope", "delayController", "Lkotlinx/coroutines/test/TestCoroutineDispatcher;", "getDelayController", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/test/TestCoroutineDispatcher;", "currentTime", "", "getCurrentTime$annotations", "(Lkotlinx/coroutines/test/TestCoroutineScope;)V", "getCurrentTime", "(Lkotlinx/coroutines/test/TestCoroutineScope;)J", "advanceUntilIdle", "", "runCurrent", "kotlinx-coroutines-test"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTestCoroutineScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestCoroutineScope.kt\nkotlinx/coroutines/test/TestCoroutineScopeKt\n*L\n1#1,200:1\n168#1,2:201\n168#1,2:203\n168#1,2:205\n*S KotlinDebug\n*F\n+ 1 TestCoroutineScope.kt\nkotlinx/coroutines/test/TestCoroutineScopeKt\n*L\n179#1:201,2\n187#1:203,2\n198#1:205,2\n*E\n"})
public final class TestCoroutineScopeKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "This constructs a `TestCoroutineScope` with a deprecated `CoroutineDispatcher` by default. Please use `createTestCoroutineScope` instead.", replaceWith = @ReplaceWith(expression = "createTestCoroutineScope(TestCoroutineDispatcher() + TestCoroutineExceptionHandler() + context)", imports = {"kotlin.coroutines.EmptyCoroutineContext"}))
    @NotNull
    public static final TestCoroutineScope TestCoroutineScope(@NotNull CoroutineContext coroutineContext) {
        TestCoroutineScheduler testCoroutineScheduler = (TestCoroutineScheduler) coroutineContext.get(TestCoroutineScheduler.INSTANCE);
        if (testCoroutineScheduler == null) {
            testCoroutineScheduler = new TestCoroutineScheduler();
        }
        return createTestCoroutineScope(new TestCoroutineDispatcher(testCoroutineScheduler).plus(new TestCoroutineExceptionHandler()).plus(coroutineContext));
    }

    public static /* synthetic */ TestCoroutineScope TestCoroutineScope$default(CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return TestCoroutineScope(coroutineContext);
    }

    @NotNull
    public static final Set<Job> activeJobs(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(Job.INSTANCE);
        if (element != null) {
            return SequencesKt.toSet(SequencesKt.filter(((Job) element).getChildren(), new C13484a(3)));
        }
        throw new IllegalStateException("Required value was null.");
    }

    @ExperimentalCoroutinesApi
    public static final void advanceUntilIdle(@NotNull TestCoroutineScope testCoroutineScope) {
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) testCoroutineScope.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
        TestCoroutineDispatcher testCoroutineDispatcher = continuationInterceptor instanceof TestCoroutineDispatcher ? (TestCoroutineDispatcher) continuationInterceptor : null;
        if (testCoroutineDispatcher != null) {
            testCoroutineDispatcher.advanceUntilIdle();
        } else {
            testCoroutineScope.getTestScheduler().advanceUntilIdle();
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlinx.coroutines.test.TestCoroutineScope, kotlinx.coroutines.test.TestCoroutineScopeImpl] */
    @Deprecated(level = DeprecationLevel.ERROR, message = "This function was introduced in order to help migrate from TestCoroutineScope to TestScope. Please use TestScope() construction instead, or just runTest(), without creating a scope.")
    @ExperimentalCoroutinesApi
    @NotNull
    public static final TestCoroutineScope createTestCoroutineScope(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextWithDelaySkipping = TestScopeKt.withDelaySkipping(coroutineContext);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        CoroutineExceptionHandler.Companion companion = CoroutineExceptionHandler.INSTANCE;
        CoroutineExceptionHandler c13481x5c477f01 = new C13481x5c477f01(objectRef, companion);
        CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContextWithDelaySkipping.get(companion);
        if (coroutineExceptionHandler instanceof TestCoroutineExceptionHandler) {
            c13481x5c477f01 = coroutineExceptionHandler;
        } else if (coroutineExceptionHandler != null && !(coroutineExceptionHandler instanceof TestCoroutineScopeExceptionHandler)) {
            throw new IllegalArgumentException("A CoroutineExceptionHandler was passed to TestCoroutineScope. Please pass it as an argument to a `launch` or `async` block on an already-created scope if uncaught exceptions require special treatment.");
        }
        CoroutineContext coroutineContextJob$default = (Job) coroutineContextWithDelaySkipping.get(Job.INSTANCE);
        if (coroutineContextJob$default == null) {
            coroutineContextJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        }
        ?? testCoroutineScopeImpl = new TestCoroutineScopeImpl(coroutineContextWithDelaySkipping.plus(c13481x5c477f01).plus(coroutineContextJob$default));
        objectRef.element = testCoroutineScopeImpl;
        return testCoroutineScopeImpl;
    }

    public static /* synthetic */ TestCoroutineScope createTestCoroutineScope$default(CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return createTestCoroutineScope(coroutineContext);
    }

    public static final long getCurrentTime(@NotNull TestCoroutineScope testCoroutineScope) {
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) testCoroutineScope.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
        TestCoroutineDispatcher testCoroutineDispatcher = continuationInterceptor instanceof TestCoroutineDispatcher ? (TestCoroutineDispatcher) continuationInterceptor : null;
        return testCoroutineDispatcher != null ? testCoroutineDispatcher.getCurrentTime() : testCoroutineScope.getTestScheduler().getCurrentTime();
    }

    private static final TestCoroutineDispatcher getDelayController(CoroutineContext coroutineContext) {
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.INSTANCE);
        if (continuationInterceptor instanceof TestCoroutineDispatcher) {
            return (TestCoroutineDispatcher) continuationInterceptor;
        }
        return null;
    }

    @ExperimentalCoroutinesApi
    public static final void runCurrent(@NotNull TestCoroutineScope testCoroutineScope) {
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) testCoroutineScope.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
        TestCoroutineDispatcher testCoroutineDispatcher = continuationInterceptor instanceof TestCoroutineDispatcher ? (TestCoroutineDispatcher) continuationInterceptor : null;
        if (testCoroutineDispatcher != null) {
            testCoroutineDispatcher.runCurrent();
        } else {
            testCoroutineScope.getTestScheduler().runCurrent();
        }
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void getCurrentTime$annotations(TestCoroutineScope testCoroutineScope) {
    }
}
