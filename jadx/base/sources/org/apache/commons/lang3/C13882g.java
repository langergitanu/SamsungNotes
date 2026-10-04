package org.apache.commons.lang3;

import java.util.Comparator;

/* JADX INFO: renamed from: org.apache.commons.lang3.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13882g implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9902a;

    public /* synthetic */ C13882g(int i) {
        this.f9902a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9902a) {
            case 0:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            default:
                return ClassUtils.lambda$static$0((Class) obj, (Class) obj2);
        }
    }
}
