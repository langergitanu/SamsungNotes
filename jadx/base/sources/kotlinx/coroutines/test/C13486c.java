package kotlinx.coroutines.test;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.test.TestBuildersKt__TestBuildersDeprecatedKt;

/* JADX INFO: renamed from: kotlinx.coroutines.test.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13486c implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9445a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CoroutineContext.Element f9446b;

    public /* synthetic */ C13486c(int i, CoroutineContext.Element element) {
        this.f9445a = i;
        this.f9446b = element;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f9445a) {
            case 0:
                return TestBuildersKt__TestBuildersDeprecatedKt.C134761.invokeSuspend$lambda$0((TestBodyCoroutine) this.f9446b);
            default:
                return Boolean.valueOf(TestCoroutineScheduler.advanceUntilIdle$lambda$7((TestCoroutineScheduler) this.f9446b));
        }
    }
}
