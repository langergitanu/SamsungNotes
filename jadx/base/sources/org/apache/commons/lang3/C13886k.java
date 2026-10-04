package org.apache.commons.lang3;

import java.util.List;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: org.apache.commons.lang3.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13886k implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9907a;

    public /* synthetic */ C13886k(int i) {
        this.f9907a = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f9907a) {
            case 0:
                ClassUtils.lambda$static$1((Class) obj, (Class) obj2);
                break;
            default:
                ((List) obj).add(obj2);
                break;
        }
    }
}
