package p201m0;

import java.util.ArrayList;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: m0.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13524e {

    /* JADX INFO: renamed from: a */
    public String f9520a;

    /* JADX INFO: renamed from: b */
    public ArrayList f9521b;

    /* JADX INFO: renamed from: c */
    public ArrayList f9522c;

    /* JADX INFO: renamed from: d */
    public ArrayList f9523d;

    /* JADX INFO: renamed from: e */
    public ArrayList f9524e;

    public final boolean equals(Object obj) {
        if (!(obj instanceof C13524e)) {
            return false;
        }
        C13524e c13524e = (C13524e) obj;
        if (!c13524e.f9520a.contentEquals(this.f9520a)) {
            return false;
        }
        ArrayList arrayList = c13524e.f9521b;
        ArrayList arrayList2 = this.f9521b;
        if (arrayList != null || arrayList2 != null) {
            if (arrayList != null && arrayList2 != null && arrayList.size() == arrayList2.size()) {
                ArrayList arrayList3 = new ArrayList(arrayList);
                ArrayList arrayList4 = new ArrayList(arrayList2);
                for (int i = 0; i < arrayList3.size(); i++) {
                    Object obj2 = arrayList3.get(i);
                    Object obj3 = arrayList4.get(i);
                    if ((obj2 instanceof InterfaceC12017b) && (obj3 instanceof InterfaceC12017b) && ((InterfaceC12017b) obj2).isSame(obj3)) {
                    }
                }
            }
            return false;
        }
        if (AbstractC0299q.m631h(c13524e.f9522c, this.f9522c) && AbstractC0299q.m631h(c13524e.f9523d, this.f9523d)) {
            return AbstractC0299q.m631h(c13524e.f9524e, this.f9524e);
        }
        return false;
    }
}
