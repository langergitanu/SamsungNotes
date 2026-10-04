package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: renamed from: androidx.lifecycle.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C3594d implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1633a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1634b;

    public /* synthetic */ C3594d(Object obj, int i) {
        this.f1633a = i;
        this.f1634b = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f1633a) {
            case 0:
                ((ProducerScope) this.f1634b).mo23705trySendJP2dKIU(event);
                break;
            default:
                Lifecycle._get_currentStateFlow_$lambda$0((MutableStateFlow) this.f1634b, lifecycleOwner, event);
                break;
        }
    }
}
