package kotlinx.coroutines.test;

import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: kotlinx.coroutines.test.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13485b implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9444a;

    public /* synthetic */ C13485b(int i) {
        this.f9444a = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean zM14246x90d3b2d6;
        switch (this.f9444a) {
            case 0:
                zM14246x90d3b2d6 = TestBuildersKt__TestBuildersDeprecatedKt.m14246x90d3b2d6();
                break;
            case 1:
                zM14246x90d3b2d6 = TestBuildersKt__TestBuildersKt$runTest$2$1.invokeSuspend$lambda$0();
                break;
            default:
                zM14246x90d3b2d6 = TestBuildersKt__TestBuildersKt$runTest$3$1.invokeSuspend$lambda$1$lambda$0();
                break;
        }
        return Boolean.valueOf(zM14246x90d3b2d6);
    }
}
