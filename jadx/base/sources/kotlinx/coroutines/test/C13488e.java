package kotlinx.coroutines.test;

import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: kotlinx.coroutines.test.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13488e implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9452a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CoroutineScope f9453b;

    public /* synthetic */ C13488e(CoroutineScope coroutineScope, int i) {
        this.f9452a = i;
        this.f9453b = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean zInvokeSuspend$lambda$0;
        switch (this.f9452a) {
            case 0:
                zInvokeSuspend$lambda$0 = TestBuildersKt__TestBuildersKt$runTest$2$1$workRunner$1.invokeSuspend$lambda$0(this.f9453b);
                break;
            default:
                zInvokeSuspend$lambda$0 = C13480xa7274f7e.invokeSuspend$lambda$0(this.f9453b);
                break;
        }
        return Boolean.valueOf(zInvokeSuspend$lambda$0);
    }
}
