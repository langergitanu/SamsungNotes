package org.apache.commons.text.similarity;

import java.util.HashMap;
import java.util.function.Consumer;
import org.apache.commons.text.similarity.IntersectionSimilarity;

/* JADX INFO: renamed from: org.apache.commons.text.similarity.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13965b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10002a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f10003b;

    public /* synthetic */ C13965b(Object obj, int i) {
        this.f10002a = i;
        this.f10003b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f10002a) {
            case 0:
                Counter.lambda$of$1((HashMap) this.f10003b, (CharSequence) obj);
                break;
            default:
                IntersectionSimilarity.TinyBag.access$700((IntersectionSimilarity.TinyBag) this.f10003b, obj);
                break;
        }
    }
}
