package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1", m14021f = "TestBuilders.kt", m14022i = {0, 1}, m14023l = {331, 334}, m14024m = "invokeSuspend", m14025n = {"$this$launch", "$this$launch"}, m14026s = {"L$0", "L$0"})
public final class TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestScope $this_runTest;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1(TestScope testScope, Continuation<? super TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1> continuation) {
        super(2, continuation);
        this.$this_runTest = testScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(CoroutineScope coroutineScope) {
        return !CoroutineScopeKt.isActive(coroutineScope);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1 testBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1 = new TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1(this.$this_runTest, continuation);
        testBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1.L$0 = obj;
        return testBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (true) {
            if (this.$this_runTest.getTestScheduler().tryRunNextTaskUnless$kotlinx_coroutines_test(new C13488e(coroutineScope, 0))) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (YieldKt.yield(this) == coroutine_suspended) {
                    break;
                }
            } else {
                TestCoroutineScheduler testScheduler = this.$this_runTest.getTestScheduler();
                this.L$0 = coroutineScope;
                this.label = 2;
                if (testScheduler.receiveDispatchEvent$kotlinx_coroutines_test(this) == coroutine_suspended) {
                    break;
                }
            }
        }
        return coroutine_suspended;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
