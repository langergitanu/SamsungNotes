package p042J1;

import java.io.File;
import java.util.Comparator;
import p007B0.C0027j;

/* JADX INFO: renamed from: J1.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0151i implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0027j f451a;

    public C0151i(C0027j c0027j) {
        this.f451a = c0027j;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String name = ((File) obj2).getName();
        C0027j c0027j = this.f451a;
        long jM55f = c0027j.m55f(name) - c0027j.m55f(((File) obj).getName());
        return (jM55f != 0 && jM55f < 0) ? -1 : 0;
    }
}
