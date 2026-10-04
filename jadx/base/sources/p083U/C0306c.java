package p083U;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p002A0.C0004d;

/* JADX INFO: renamed from: U.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0306c {

    /* JADX INFO: renamed from: d */
    public final C0304a f786d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC0307d f787e;

    /* JADX INFO: renamed from: a */
    public final ArrayList f783a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public final ArrayList f784b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final ArrayList f785c = new ArrayList();

    /* JADX INFO: renamed from: f */
    public final HashMap f788f = new HashMap();

    public C0306c(C0304a c0304a, InterfaceC0307d interfaceC0307d) {
        this.f786d = c0304a;
        this.f787e = interfaceC0307d;
    }

    /* JADX INFO: renamed from: a */
    public static C0004d m657a(String str, List list) {
        if (str == null || list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0004d c0004d = (C0004d) it.next();
            if (str.equals(c0004d.m32b())) {
                return c0004d;
            }
        }
        return null;
    }
}
