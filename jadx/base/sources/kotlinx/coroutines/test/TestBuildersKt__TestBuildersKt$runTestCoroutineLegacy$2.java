package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0003*\u0002H\u0002H\n"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/AbstractCoroutine;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2", m14021f = "TestBuilders.kt", m14022i = {}, m14023l = {459}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $testBody;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2> continuation) {
        super(2, continuation);
        this.$testBody = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2 testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2 = new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2(this.$testBody, continuation);
        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2.L$0 = obj;
        return testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((AbstractCoroutine) obj, (Continuation) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AbstractCoroutine abstractCoroutine = (AbstractCoroutine) this.L$0;
            Function2<T, Continuation<? super Unit>, Object> function2 = this.$testBody;
            this.label = 1;
            if (function2.invoke(abstractCoroutine, this) == coroutine_suspended) {
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

    /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/coroutines/Continuation<-Lkotlin/Unit;>;)Ljava/lang/Object; */
    public final Object invoke(AbstractCoroutine abstractCoroutine, Continuation continuation) {
        return ((TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2) create(abstractCoroutine, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
