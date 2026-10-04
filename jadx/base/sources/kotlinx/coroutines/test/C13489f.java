package kotlinx.coroutines.test;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: kotlinx.coroutines.test.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13489f implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9454a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9455b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f9456c;

    public /* synthetic */ C13489f(Object obj, Object obj2, int i) {
        this.f9454a = i;
        this.f9455b = obj;
        this.f9456c = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f9454a) {
            case 0:
                return TestBuildersKt__TestBuildersKt$runTest$3$1.invokeSuspend$lambda$1((TestScope) this.f9455b, (TestScopeImpl) this.f9456c);
            default:
                return Boolean.valueOf(TestCoroutineScheduler.registerEvent$lambda$5$lambda$2((Function1) this.f9455b, this.f9456c));
        }
    }
}
