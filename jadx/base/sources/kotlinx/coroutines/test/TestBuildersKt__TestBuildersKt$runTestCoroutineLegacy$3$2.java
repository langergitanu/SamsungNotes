package kotlinx.coroutines.test;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$2", m14021f = "TestBuilders.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    int label;

    public TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$2(Continuation<? super TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
