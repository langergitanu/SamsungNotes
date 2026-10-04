package kotlinx.coroutines.test;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$3$1", m14021f = "TestBuilders.kt", m14022i = {}, m14023l = {401}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class TestBuildersKt__TestBuildersKt$runTest$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $dispatchTimeoutMs;
    final /* synthetic */ TestScopeImpl $it;
    final /* synthetic */ Function2<TestScope, Continuation<? super Unit>, Object> $testBody;
    final /* synthetic */ TestScope $this_runTest;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$3$1$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class C134791 extends FunctionReferenceImpl implements Function1<TestScopeImpl, Throwable> {
        public static final C134791 INSTANCE = new C134791();

        public C134791() {
            super(1, TestScopeImpl.class, "tryGetCompletionCause", "tryGetCompletionCause()Ljava/lang/Throwable;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Throwable invoke(TestScopeImpl testScopeImpl) {
            return testScopeImpl.tryGetCompletionCause();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TestBuildersKt__TestBuildersKt$runTest$3$1(TestScopeImpl testScopeImpl, long j, Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2, TestScope testScope, Continuation<? super TestBuildersKt__TestBuildersKt$runTest$3$1> continuation) {
        super(2, continuation);
        this.$it = testScopeImpl;
        this.$dispatchTimeoutMs = j;
        this.$testBody = function2;
        this.$this_runTest = testScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$1(TestScope testScope, TestScopeImpl testScopeImpl) {
        CoroutineScopeKt.cancel$default(testScope.getBackgroundScope(), null, 1, null);
        testScope.getTestScheduler().advanceUntilIdleOr$kotlinx_coroutines_test(new C13485b(2));
        return testScopeImpl.legacyLeave();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$1$lambda$0() {
        return false;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TestBuildersKt__TestBuildersKt$runTest$3$1 testBuildersKt__TestBuildersKt$runTest$3$1 = new TestBuildersKt__TestBuildersKt$runTest$3$1(this.$it, this.$dispatchTimeoutMs, this.$testBody, this.$this_runTest, continuation);
        testBuildersKt__TestBuildersKt$runTest$3$1.L$0 = obj;
        return testBuildersKt__TestBuildersKt$runTest$3$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TestScopeImpl testScopeImpl = this.$it;
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(this.$dispatchTimeoutMs, DurationUnit.MILLISECONDS);
            C134791 c134791 = C134791.INSTANCE;
            Function2<TestScope, Continuation<? super Unit>, Object> function2 = this.$testBody;
            C13489f c13489f = new C13489f(this.$this_runTest, this.$it, 0);
            this.label = 1;
            if (TestBuildersKt.m23781runTestCoroutineLegacySYHnMyU(coroutineScope, testScopeImpl, duration, c134791, function2, c13489f, this) == coroutine_suspended) {
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
        return ((TestBuildersKt__TestBuildersKt$runTest$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
