package androidx.lifecycle.compose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: androidx.lifecycle.compose.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C3593b implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1629a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Ref.ObjectRef f1630b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Function1 f1631c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ LifecycleOwner f1632d;

    public /* synthetic */ C3593b(LifecycleOwner lifecycleOwner, Ref.ObjectRef objectRef, Function1 function1, int i) {
        this.f1629a = i;
        this.f1632d = lifecycleOwner;
        this.f1630b = objectRef;
        this.f1631c = function1;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f1629a) {
            case 0:
                LifecycleEffectKt$LifecycleResumeEffectImpl$1$1.invoke$lambda$1((LifecycleResumePauseEffectScope) this.f1632d, this.f1630b, this.f1631c, lifecycleOwner, event);
                break;
            default:
                LifecycleEffectKt$LifecycleStartEffectImpl$1$1.invoke$lambda$1((LifecycleStartStopEffectScope) this.f1632d, this.f1630b, this.f1631c, lifecycleOwner, event);
                break;
        }
    }
}
