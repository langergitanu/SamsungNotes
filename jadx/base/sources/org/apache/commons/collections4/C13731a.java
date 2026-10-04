package org.apache.commons.collections4;

import java.util.function.Function;

/* JADX INFO: renamed from: org.apache.commons.collections4.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13731a implements Transformer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9713a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9714b;

    public /* synthetic */ C13731a(Object obj, int i) {
        this.f9713a = i;
        this.f9714b = obj;
    }

    @Override // org.apache.commons.collections4.Transformer
    public final Object transform(Object obj) {
        switch (this.f9713a) {
            case 0:
                return CollectionUtils.lambda$retainAll$2((Equator) this.f9714b, obj);
            case 1:
                return CollectionUtils.lambda$removeAll$1((Equator) this.f9714b, obj);
            case 2:
                return CollectionUtils.lambda$isEqualCollection$0((Equator) this.f9714b, obj);
            default:
                return ((Function) this.f9714b).apply(obj);
        }
    }
}
