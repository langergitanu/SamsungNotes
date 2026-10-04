package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* JADX INFO: renamed from: com.google.firebase.components.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5945c implements Provider {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3462a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ComponentRegistrar f3463b;

    public /* synthetic */ C5945c(ComponentRegistrar componentRegistrar, int i) {
        this.f3462a = i;
        this.f3463b = componentRegistrar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f3462a) {
            case 0:
                return ComponentRuntime.lambda$toProviders$1(this.f3463b);
            default:
                return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(this.f3463b);
        }
    }
}
