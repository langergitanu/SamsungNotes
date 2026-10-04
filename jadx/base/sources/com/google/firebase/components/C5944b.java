package com.google.firebase.components;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;

/* JADX INFO: renamed from: com.google.firebase.components.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5944b implements Provider {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3460a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3461b;

    public /* synthetic */ C5944b(Object obj, int i) {
        this.f3460a = i;
        this.f3461b = obj;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f3460a) {
            case 0:
                return ComponentDiscovery.instantiate((String) this.f3461b);
            default:
                return FirebaseInstallations.lambda$new$0((FirebaseApp) this.f3461b);
        }
    }
}
