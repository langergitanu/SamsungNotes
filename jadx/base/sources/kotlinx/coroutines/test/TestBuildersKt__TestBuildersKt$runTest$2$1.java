package kotlinx.coroutines.test;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1", m14021f = "TestBuilders.kt", m14022i = {0, 0, 0, 1, 1, 1, 2}, m14023l = {339, 363, 368}, m14024m = "invokeSuspend", m14025n = {"timeoutError", "cancellationException", "workRunner", "timeoutError", "cancellationException", "workRunner", "timeoutError"}, m14026s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0"})
public final class TestBuildersKt__TestBuildersKt$runTest$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestScopeImpl $scope;
    final /* synthetic */ Function2<TestScope, Continuation<? super Unit>, Object> $testBody;
    final /* synthetic */ TestScope $this_runTest;
    final /* synthetic */ long $timeout;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/test/TestScopeImpl;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$1", m14021f = "TestBuilders.kt", m14022i = {0}, m14023l = {TypedValues.Attributes.TYPE_PATH_ROTATE, TypedValues.Attributes.TYPE_PIVOT_TARGET}, m14024m = "invokeSuspend", m14025n = {"$this$start"}, m14026s = {"L$0"})
    public static final class C134771 extends SuspendLambda implements Function2<TestScopeImpl, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<TestScope, Continuation<? super Unit>, Object> $testBody;
        final /* synthetic */ AtomicBoolean $testBodyFinished;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C134771(Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2, AtomicBoolean atomicBoolean, Continuation<? super C134771> continuation) {
            super(2, continuation);
            this.$testBody = function2;
            this.$testBodyFinished = atomicBoolean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C134771 c134771 = new C134771(this.$testBody, this.$testBodyFinished, continuation);
            c134771.L$0 = obj;
            return c134771;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        
            if (r6.invoke(r1, r5) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TestScopeImpl testScopeImpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    testScopeImpl = (TestScopeImpl) this.L$0;
                    this.L$0 = testScopeImpl;
                    this.label = 1;
                    if (YieldKt.yield(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$testBodyFinished.setValue(true);
                    return Unit.INSTANCE;
                }
                testScopeImpl = (TestScopeImpl) this.L$0;
                ResultKt.throwOnFailure(obj);
                Function2<TestScope, Continuation<? super Unit>, Object> function2 = this.$testBody;
                this.L$0 = null;
                this.label = 2;
            } catch (Throwable th) {
                this.$testBodyFinished.setValue(true);
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TestScopeImpl testScopeImpl, Continuation<? super Unit> continuation) {
            return ((C134771) create(testScopeImpl, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$2", m14021f = "TestBuilders.kt", m14022i = {}, m14023l = {359, PopOverActivityWrapper.DEFAULT_WIDTH}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C134782 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<CancellationException> $cancellationException;
        final /* synthetic */ TestScopeImpl $scope;
        final /* synthetic */ AtomicBoolean $testBodyFinished;
        final /* synthetic */ long $timeout;
        final /* synthetic */ Ref.ObjectRef<Throwable> $timeoutError;
        final /* synthetic */ Job $workRunner;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C134782(TestScopeImpl testScopeImpl, Job job, long j, AtomicBoolean atomicBoolean, Ref.ObjectRef<Throwable> objectRef, Ref.ObjectRef<CancellationException> objectRef2, Continuation<? super C134782> continuation) {
            super(2, continuation);
            this.$scope = testScopeImpl;
            this.$workRunner = job;
            this.$timeout = j;
            this.$testBodyFinished = atomicBoolean;
            this.$timeoutError = objectRef;
            this.$cancellationException = objectRef2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v9, types: [T, java.util.concurrent.CancellationException] */
        /* JADX WARN: Type inference failed for: r4v0, types: [T, kotlinx.coroutines.test.UncompletedCoroutinesError] */
        public static final Unit invokeSuspend$lambda$0(TestScopeImpl testScopeImpl, long j, AtomicBoolean atomicBoolean, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Throwable th) {
            String str;
            if (th instanceof TimeoutCancellationException) {
                TestBuildersJvmKt.dumpCoroutines();
                List list = SequencesKt.toList(SequencesKt.filter(testScopeImpl.getChildren(), new PropertyReference1Impl() { // from class: kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$2$1$activeChildren$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return Boolean.valueOf(((Job) obj).isActive());
                    }
                }));
                StringBuilder sb = new StringBuilder("After waiting for ");
                sb.append((Object) Duration.m23594toStringimpl(j));
                sb.append(SQLKeyword.COMMA);
                if (!atomicBoolean.getValue() || list.isEmpty()) {
                    str = atomicBoolean.getValue() ? "the test completed, but only after the timeout" : "the test body did not run to completion";
                } else {
                    str = "there were active child jobs: " + list + ". Use `TestScope.backgroundScope` to launch the coroutines that need to be cancelled when the test body finishes";
                }
                sb.append(str);
                objectRef.element = new UncompletedCoroutinesError(sb.toString());
                objectRef2.element = new CancellationException("The test timed out");
                Intrinsics.checkNotNull(testScopeImpl, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                T t = objectRef2.element;
                Intrinsics.checkNotNull(t);
                testScopeImpl.cancel((CancellationException) t);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C134782 c134782 = new C134782(this.$scope, this.$workRunner, this.$timeout, this.$testBodyFinished, this.$timeoutError, this.$cancellationException, continuation);
            c134782.L$0 = obj;
            return c134782;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        
            if (kotlinx.coroutines.JobKt.cancelAndJoin(r13, r12) == r0) goto L15;
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
                Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                final TestScopeImpl testScopeImpl = this.$scope;
                final long j = this.$timeout;
                final AtomicBoolean atomicBoolean = this.$testBodyFinished;
                final Ref.ObjectRef<Throwable> objectRef = this.$timeoutError;
                final Ref.ObjectRef<CancellationException> objectRef2 = this.$cancellationException;
                Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new Function1() { // from class: kotlinx.coroutines.test.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TestBuildersKt__TestBuildersKt$runTest$2$1.C134782.invokeSuspend$lambda$0(testScopeImpl, j, atomicBoolean, objectRef, objectRef2, (Throwable) obj2);
                    }
                }, 2, null);
                TestScopeImpl testScopeImpl2 = this.$scope;
                this.label = 1;
                if (testScopeImpl2.join(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            Job job2 = this.$workRunner;
            this.label = 2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C134782) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TestBuildersKt__TestBuildersKt$runTest$2$1(TestScopeImpl testScopeImpl, long j, TestScope testScope, Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super TestBuildersKt__TestBuildersKt$runTest$2$1> continuation) {
        super(2, continuation);
        this.$scope = testScopeImpl;
        this.$timeout = j;
        this.$this_runTest = testScope;
        this.$testBody = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0() {
        return false;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TestBuildersKt__TestBuildersKt$runTest$2$1 testBuildersKt__TestBuildersKt$runTest$2$1 = new TestBuildersKt__TestBuildersKt$runTest$2$1(this.$scope, this.$timeout, this.$this_runTest, this.$testBody, continuation);
        testBuildersKt__TestBuildersKt$runTest$2$1.L$0 = obj;
        return testBuildersKt__TestBuildersKt$runTest$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0115, code lost:
    
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r10, r17) != r0) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3 A[PHI: r0
      0x00d3: PHI (r0v10 java.util.List<java.lang.Throwable>) = (r0v9 java.util.List<java.lang.Throwable>), (r0v18 java.util.List<java.lang.Throwable>) binds: [B:31:0x00d1, B:50:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v32 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        Job jobLaunch$default;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        TestScopeImpl testScopeImpl;
        Ref.ObjectRef objectRef4;
        List<Throwable> listLeave;
        Throwable completionExceptionOrNull;
        Throwable completionExceptionOrNull2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Ref.ObjectRef objectRef5 = this.label;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (objectRef5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            TestScopeImpl testScopeImpl2 = this.$scope;
            testScopeImpl2.start(CoroutineStart.UNDISPATCHED, testScopeImpl2, new C134771(this.$testBody, atomicBoolean, null));
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            objectRef = new Ref.ObjectRef();
            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, new CoroutineName("kotlinx.coroutines.test runner"), null, new TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1(this.$this_runTest, null), 2, null);
            try {
                long j = this.$timeout;
                C134782 c134782 = new C134782(this.$scope, jobLaunch$default, j, atomicBoolean, objectRef6, objectRef, null);
                this.L$0 = objectRef6;
                this.L$1 = objectRef;
                this.L$2 = jobLaunch$default;
                this.label = 1;
                if (TimeoutKt.m23703withTimeoutKLykuaI(j, c134782, this) != coroutine_suspended) {
                    objectRef3 = objectRef6;
                    CoroutineScopeKt.cancel$default(this.$this_runTest.getBackgroundScope(), null, 1, null);
                    this.$this_runTest.getTestScheduler().advanceUntilIdleOr$kotlinx_coroutines_test(new C13485b(1));
                    listLeave = this.$scope.leave();
                    completionExceptionOrNull = (Throwable) objectRef3.element;
                    if (completionExceptionOrNull == null) {
                    }
                }
            } catch (TimeoutCancellationException unused) {
                objectRef2 = objectRef6;
                testScopeImpl = this.$scope;
                this.L$0 = objectRef2;
                this.L$1 = objectRef;
                this.L$2 = jobLaunch$default;
                this.label = 2;
                if (testScopeImpl.join(this) == coroutine_suspended) {
                    objectRef4 = objectRef;
                    completionExceptionOrNull2 = this.$scope.getCompletionExceptionOrNull();
                    if (completionExceptionOrNull2 != null) {
                        T t = objectRef2.element;
                        Intrinsics.checkNotNull(t);
                        ExceptionsKt.addSuppressed((Throwable) t, completionExceptionOrNull2);
                    }
                    this.L$0 = objectRef2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                }
            } catch (Throwable th2) {
                th = th2;
                objectRef5 = objectRef6;
            }
            return coroutine_suspended;
        }
        if (objectRef5 == 1) {
            Job job = (Job) this.L$2;
            Ref.ObjectRef objectRef7 = (Ref.ObjectRef) this.L$1;
            objectRef3 = (Ref.ObjectRef) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                CoroutineScopeKt.cancel$default(this.$this_runTest.getBackgroundScope(), null, 1, null);
                this.$this_runTest.getTestScheduler().advanceUntilIdleOr$kotlinx_coroutines_test(new C13485b(1));
                listLeave = this.$scope.leave();
                completionExceptionOrNull = (Throwable) objectRef3.element;
                if (completionExceptionOrNull == null) {
                }
            } catch (TimeoutCancellationException unused2) {
                jobLaunch$default = job;
                objectRef = objectRef7;
                objectRef2 = objectRef3;
                testScopeImpl = this.$scope;
                this.L$0 = objectRef2;
                this.L$1 = objectRef;
                this.L$2 = jobLaunch$default;
                this.label = 2;
                if (testScopeImpl.join(this) == coroutine_suspended) {
                }
            } catch (Throwable th3) {
                th = th3;
                objectRef5 = objectRef3;
            }
        } else if (objectRef5 == 2) {
            Job job2 = (Job) this.L$2;
            objectRef4 = (Ref.ObjectRef) this.L$1;
            Ref.ObjectRef objectRef8 = (Ref.ObjectRef) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                jobLaunch$default = job2;
                objectRef2 = objectRef8;
                completionExceptionOrNull2 = this.$scope.getCompletionExceptionOrNull();
                if (completionExceptionOrNull2 != null && completionExceptionOrNull2 != objectRef4.element) {
                    T t2 = objectRef2.element;
                    Intrinsics.checkNotNull(t2);
                    ExceptionsKt.addSuppressed((Throwable) t2, completionExceptionOrNull2);
                }
                this.L$0 = objectRef2;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 3;
            } catch (Throwable th4) {
                th = th4;
                objectRef5 = objectRef8;
            }
        } else {
            if (objectRef5 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            CoroutineScopeKt.cancel$default(this.$this_runTest.getBackgroundScope(), null, 1, null);
            this.$this_runTest.getTestScheduler().advanceUntilIdleOr$kotlinx_coroutines_test(new C13485b(1));
            listLeave = this.$scope.leave();
            completionExceptionOrNull = (Throwable) objectRef2.element;
            if (completionExceptionOrNull == null) {
                completionExceptionOrNull = this.$scope.getCompletionExceptionOrNull();
            }
        }
        CoroutineScopeKt.cancel$default(this.$this_runTest.getBackgroundScope(), null, 1, null);
        this.$this_runTest.getTestScheduler().advanceUntilIdleOr$kotlinx_coroutines_test(new C13485b(1));
        List<Throwable> listLeave2 = this.$scope.leave();
        Throwable completionExceptionOrNull3 = (Throwable) objectRef5.element;
        if (completionExceptionOrNull3 == null) {
            completionExceptionOrNull3 = this.$scope.getCompletionExceptionOrNull();
        }
        TestBuildersKt.throwAll(completionExceptionOrNull3, listLeave2);
        throw th;
        TestBuildersKt.throwAll(completionExceptionOrNull, listLeave);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TestBuildersKt__TestBuildersKt$runTest$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
