package kotlinx.coroutines.test;

import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a@\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00062'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u000e\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u000f\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00102'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0011\u001aJ\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0015\u001aH\u0010\u0016\u001a\u00060\u0001j\u0002`\u0017*\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"runBlockingTest", "", "context", "Lkotlin/coroutines/CoroutineContext;", "testBody", "Lkotlin/Function2;", "Lkotlinx/coroutines/test/TestCoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "runBlockingTestOnTestScope", "Lkotlinx/coroutines/test/TestScope;", "block", "(Lkotlinx/coroutines/test/TestCoroutineScope;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/test/TestScope;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/test/TestCoroutineDispatcher;", "(Lkotlinx/coroutines/test/TestCoroutineDispatcher;Lkotlin/jvm/functions/Function2;)V", "runTestWithLegacyScope", "dispatchTimeoutMs", "", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "runTest", "Lkotlinx/coroutines/test/TestResult;", "(Lkotlinx/coroutines/test/TestCoroutineScope;JLkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-test"}, m13887k = 5, m13888mv = {2, 0, 0}, m13890xi = 48, m13891xs = "kotlinx/coroutines/test/TestBuildersKt")
final /* synthetic */ class TestBuildersKt__TestBuildersDeprecatedKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTestOnTestScope$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/test/TestScopeImpl;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTestOnTestScope$1", m14021f = "TestBuildersDeprecated.kt", m14022i = {}, m14023l = {87}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C134751 extends SuspendLambda implements Function2<TestScopeImpl, Continuation<? super Unit>, Object> {
        final /* synthetic */ TestScopeImpl $scope;
        final /* synthetic */ Function2<TestScope, Continuation<? super Unit>, Object> $testBody;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C134751(Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2, TestScopeImpl testScopeImpl, Continuation<? super C134751> continuation) {
            super(2, continuation);
            this.$testBody = function2;
            this.$scope = testScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C134751(this.$testBody, this.$scope, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2<TestScope, Continuation<? super Unit>, Object> function2 = this.$testBody;
                TestScopeImpl testScopeImpl = this.$scope;
                this.label = 1;
                if (function2.invoke(testScopeImpl, this) == coroutine_suspended) {
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
        public final Object invoke(TestScopeImpl testScopeImpl, Continuation<? super Unit> continuation) {
            return ((C134751) create(testScopeImpl, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1", m14021f = "TestBuildersDeprecated.kt", m14022i = {}, m14023l = {171}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C134761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $dispatchTimeoutMs;
        final /* synthetic */ Function2<TestCoroutineScope, Continuation<? super Unit>, Object> $testBody;
        final /* synthetic */ TestBodyCoroutine $testScope;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runTestWithLegacyScope$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<TestBodyCoroutine, Throwable> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1, TestBodyCoroutine.class, "tryGetCompletionCause", "tryGetCompletionCause()Ljava/lang/Throwable;", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(TestBodyCoroutine testBodyCoroutine) {
                return testBodyCoroutine.tryGetCompletionCause();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C134761(TestBodyCoroutine testBodyCoroutine, long j, Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C134761> continuation) {
            super(2, continuation);
            this.$testScope = testBodyCoroutine;
            this.$dispatchTimeoutMs = j;
            this.$testBody = function2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List invokeSuspend$lambda$0(TestBodyCoroutine testBodyCoroutine) {
            try {
                testBodyCoroutine.cleanup();
                return CollectionsKt.emptyList();
            } catch (UncompletedCoroutinesError e) {
                throw e;
            } catch (Throwable th) {
                return CollectionsKt.listOf(th);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C134761 c134761 = new C134761(this.$testScope, this.$dispatchTimeoutMs, this.$testBody, continuation);
            c134761.L$0 = obj;
            return c134761;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                TestBodyCoroutine testBodyCoroutine = this.$testScope;
                Duration.Companion companion = Duration.INSTANCE;
                long duration = DurationKt.toDuration(this.$dispatchTimeoutMs, DurationUnit.MILLISECONDS);
                AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
                Function2<TestCoroutineScope, Continuation<? super Unit>, Object> function2 = this.$testBody;
                C13486c c13486c = new C13486c(0, this.$testScope);
                this.label = 1;
                if (TestBuildersKt.m23781runTestCoroutineLegacySYHnMyU(coroutineScope, testBodyCoroutine, duration, anonymousClass1, function2, c13486c, this) == coroutine_suspended) {
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
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C134761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers. Please see the migration guide for details: https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-test/MIGRATION.md")
    public static final void runBlockingTest(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) throws Throwable {
        TestCoroutineScope testCoroutineScopeCreateTestCoroutineScope = TestCoroutineScopeKt.createTestCoroutineScope(new TestCoroutineDispatcher(null, 1, 0 == true ? 1 : 0).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(coroutineContext));
        TestCoroutineScheduler testScheduler = testCoroutineScopeCreateTestCoroutineScope.getTestScheduler();
        Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(testCoroutineScopeCreateTestCoroutineScope, null, null, new C13474x1153aca9(function2, testCoroutineScopeCreateTestCoroutineScope, null), 3, null);
        testScheduler.advanceUntilIdle();
        Throwable completionExceptionOrNull = deferredAsync$default.getCompletionExceptionOrNull();
        if (completionExceptionOrNull != null) {
            throw completionExceptionOrNull;
        }
        testCoroutineScopeCreateTestCoroutineScope.mo23776cleanupTestCoroutines();
    }

    public static /* synthetic */ void runBlockingTest$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        TestBuildersKt.runBlockingTest(coroutineContext, (Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers.")
    public static final void runBlockingTestOnTestScope(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Throwable completionExceptionOrNull;
        List<Throwable> listEmptyList;
        CoroutineContext coroutineContextPlus = new TestCoroutineDispatcher(null, 1, 0 == true ? 1 : 0).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(coroutineContext);
        Set<Job> setActiveJobs = TestCoroutineScopeKt.activeJobs(coroutineContextPlus);
        TestScopeImpl testScopeImplAsSpecificImplementation = TestScopeKt.asSpecificImplementation(TestScopeKt.TestScope(coroutineContextPlus));
        testScopeImplAsSpecificImplementation.enter();
        testScopeImplAsSpecificImplementation.start(CoroutineStart.UNDISPATCHED, testScopeImplAsSpecificImplementation, new C134751(function2, testScopeImplAsSpecificImplementation, null));
        testScopeImplAsSpecificImplementation.getTestScheduler().advanceUntilIdle();
        try {
            completionExceptionOrNull = testScopeImplAsSpecificImplementation.getCompletionExceptionOrNull();
        } catch (IllegalStateException unused) {
            completionExceptionOrNull = null;
        }
        CoroutineScopeKt.cancel$default(testScopeImplAsSpecificImplementation.getBackgroundScope(), null, 1, null);
        testScopeImplAsSpecificImplementation.getTestScheduler().advanceUntilIdleOr$kotlinx_coroutines_test(new C13485b(0));
        if (completionExceptionOrNull != null) {
            try {
                listEmptyList = testScopeImplAsSpecificImplementation.legacyLeave();
            } catch (UncompletedCoroutinesError unused2) {
                listEmptyList = CollectionsKt.emptyList();
            }
            TestBuildersKt.throwAll(completionExceptionOrNull, listEmptyList);
        } else {
            TestBuildersKt.throwAll(null, testScopeImplAsSpecificImplementation.legacyLeave());
            Set setMinus = SetsKt.minus((Set) TestCoroutineScopeKt.activeJobs(coroutineContextPlus), (Iterable) setActiveJobs);
            if (setMinus.isEmpty()) {
                return;
            }
            throw new UncompletedCoroutinesError("Some jobs were not completed at the end of the test: " + setMinus);
        }
    }

    public static /* synthetic */ void runBlockingTestOnTestScope$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        TestBuildersKt.runBlockingTestOnTestScope(coroutineContext, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runBlockingTestOnTestScope$lambda$1$TestBuildersKt__TestBuildersDeprecatedKt */
    public static final boolean m14246x90d3b2d6() {
        return false;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `TestScope.runTest` instead.")
    @ExperimentalCoroutinesApi
    public static final void runTest(@NotNull TestCoroutineScope testCoroutineScope, long j, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt.runTestWithLegacyScope(testCoroutineScope.getCoroutineContext(), j, function2);
    }

    public static /* synthetic */ void runTest$default(TestCoroutineScope testCoroutineScope, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 60000;
        }
        TestBuildersKt.runTest(testCoroutineScope, j, (Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead.")
    @ExperimentalCoroutinesApi
    public static final void runTestWithLegacyScope(@NotNull CoroutineContext coroutineContext, long j, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        RunningInRunTest runningInRunTest = RunningInRunTest.INSTANCE;
        if (coroutineContext.get(runningInRunTest) != null) {
            throw new IllegalStateException("Calls to `runTest` can't be nested. Please read the docs on `TestResult` for details.");
        }
        TestBuildersJvmKt.createTestResult(new C134761(new TestBodyCoroutine(TestCoroutineScopeKt.createTestCoroutineScope(coroutineContext.plus(runningInRunTest))), j, function2, null));
    }

    public static /* synthetic */ void runTestWithLegacyScope$default(CoroutineContext coroutineContext, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j = 60000;
        }
        TestBuildersKt.runTestWithLegacyScope(coroutineContext, j, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers. Please see the migration guide for details: https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-test/MIGRATION.md")
    public static final void runBlockingTest(@NotNull TestCoroutineScope testCoroutineScope, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt.runBlockingTest(testCoroutineScope.getCoroutineContext(), function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers.")
    public static final void runBlockingTest(@NotNull TestScope testScope, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt.runBlockingTestOnTestScope(testScope.getCoroutineContext(), function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `runTest` instead to support completing from other dispatchers. Please see the migration guide for details: https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-test/MIGRATION.md")
    public static final void runBlockingTest(@NotNull TestCoroutineDispatcher testCoroutineDispatcher, @NotNull Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestBuildersKt.runBlockingTest((CoroutineContext) testCoroutineDispatcher, function2);
    }
}
