package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: renamed from: kotlinx.coroutines.sync.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13471a implements Function3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9438a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MutexImpl f9439b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f9440c;

    public /* synthetic */ C13471a(MutexImpl mutexImpl, Object obj, int i) {
        this.f9438a = i;
        this.f9439b = mutexImpl;
        this.f9440c = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f9438a) {
            case 0:
                return MutexImpl.CancellableContinuationWithOwner.tryResume$lambda$3(this.f9439b, (MutexImpl.CancellableContinuationWithOwner) this.f9440c, (Throwable) obj, (Unit) obj2, (CoroutineContext) obj3);
            default:
                return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1$lambda$0(this.f9439b, this.f9440c, (Throwable) obj, obj2, (CoroutineContext) obj3);
        }
    }
}
