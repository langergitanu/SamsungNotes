package org.apache.commons.collections4.multiset;

import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: renamed from: org.apache.commons.collections4.multiset.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13777a implements Transformer {
    @Override // org.apache.commons.collections4.Transformer
    public final Object transform(Object obj) {
        return ((MultiSet.Entry) obj).getElement();
    }
}
