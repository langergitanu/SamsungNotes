package kotlinx.coroutines.test;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: kotlinx.coroutines.test.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13484a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9443a;

    public /* synthetic */ C13484a(int i) {
        this.f9443a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zDispatch$lambda$0;
        switch (this.f9443a) {
            case 0:
                zDispatch$lambda$0 = StandardTestDispatcherImpl.dispatch$lambda$0((Runnable) obj);
                break;
            case 1:
                zDispatch$lambda$0 = TestCoroutineScheduler.isIdle$lambda$15$lambda$14((TestDispatchEvent) obj);
                break;
            case 2:
                zDispatch$lambda$0 = TestCoroutineDispatcher.post$lambda$0((Runnable) obj);
                break;
            case 3:
                zDispatch$lambda$0 = ((Job) obj).isActive();
                break;
            case 4:
                zDispatch$lambda$0 = TestDispatcher.invokeOnTimeout$lambda$0((Runnable) obj);
                break;
            default:
                zDispatch$lambda$0 = ((Job) obj).isActive();
                break;
        }
        return Boolean.valueOf(zDispatch$lambda$0);
    }
}
