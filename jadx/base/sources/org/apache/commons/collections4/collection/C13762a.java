package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.set.CompositeSet;

/* JADX INFO: renamed from: org.apache.commons.collections4.collection.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13762a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9748a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ IteratorChain f9749b;

    public /* synthetic */ C13762a(IteratorChain iteratorChain, int i) {
        this.f9748a = i;
        this.f9749b = iteratorChain;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f9748a) {
            case 0:
                CompositeCollection.lambda$iterator$0(this.f9749b, (Collection) obj);
                break;
            default:
                CompositeSet.lambda$iterator$0(this.f9749b, (Set) obj);
                break;
        }
    }
}
