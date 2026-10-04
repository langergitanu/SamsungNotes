package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* JADX INFO: renamed from: com.google.firebase.components.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5949g implements Provider {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3469a;

    public /* synthetic */ C5949g(int i) {
        this.f3469a = i;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f3469a) {
            case 0:
                return OptionalProvider.lambda$static$1();
            default:
                return Collections.EMPTY_SET;
        }
    }
}
