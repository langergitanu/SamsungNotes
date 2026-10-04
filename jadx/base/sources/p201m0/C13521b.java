package p201m0;

import java.util.Comparator;
import p185h0.InterfaceC12016a;

/* JADX INFO: renamed from: m0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13521b implements Comparator {

    /* JADX INFO: renamed from: a */
    public final int f9512a;

    public C13521b(int i) {
        this.f9512a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int iEnd;
        int iEnd2;
        InterfaceC12016a interfaceC12016a = (InterfaceC12016a) obj;
        InterfaceC12016a interfaceC12016a2 = (InterfaceC12016a) obj2;
        if (this.f9512a == 0) {
            iEnd = interfaceC12016a.start();
            iEnd2 = interfaceC12016a2.start();
        } else {
            iEnd = interfaceC12016a.end();
            iEnd2 = interfaceC12016a2.end();
        }
        return iEnd - iEnd2;
    }
}
