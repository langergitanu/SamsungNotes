package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: renamed from: kotlinx.coroutines.test.TestCoroutineScopeKt$createTestCoroutineScope$ownExceptionHandler$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m13886d2 = {"kotlinx/coroutines/test/TestCoroutineScopeKt$createTestCoroutineScope$ownExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/test/TestCoroutineScopeExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-test"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class C13481x5c477f01 extends AbstractCoroutineContextElement implements TestCoroutineScopeExceptionHandler {
    final /* synthetic */ Ref.ObjectRef<TestCoroutineScopeImpl> $scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13481x5c477f01(Ref.ObjectRef<TestCoroutineScopeImpl> objectRef, CoroutineExceptionHandler.Companion companion) {
        super(companion);
        this.$scope = objectRef;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) throws Throwable {
        TestCoroutineScopeImpl testCoroutineScopeImpl = this.$scope.element;
        Intrinsics.checkNotNull(testCoroutineScopeImpl);
        if (!testCoroutineScopeImpl.reportException(exception)) {
            throw exception;
        }
    }
}
