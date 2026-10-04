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

/* JADX INFO: renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTest$deferred$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt$runBlockingTest$deferred$1", m14021f = "TestBuildersDeprecated.kt", m14022i = {}, m14023l = {64}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class C13474x1153aca9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestCoroutineScope $scope;
    final /* synthetic */ Function2<TestCoroutineScope, Continuation<? super Unit>, Object> $testBody;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C13474x1153aca9(Function2<? super TestCoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, TestCoroutineScope testCoroutineScope, Continuation<? super C13474x1153aca9> continuation) {
        super(2, continuation);
        this.$testBody = function2;
        this.$scope = testCoroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C13474x1153aca9(this.$testBody, this.$scope, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<TestCoroutineScope, Continuation<? super Unit>, Object> function2 = this.$testBody;
            TestCoroutineScope testCoroutineScope = this.$scope;
            this.label = 1;
            if (function2.invoke(testCoroutineScope, this) == coroutine_suspended) {
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
        return ((C13474x1153aca9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
