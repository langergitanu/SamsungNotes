package p036I;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p002A0.C0004d;

/* JADX INFO: renamed from: I.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0120c {

    /* JADX INFO: renamed from: d */
    public final C0118a f383d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC0121d f384e;

    /* JADX INFO: renamed from: a */
    public final ArrayList f380a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public final ArrayList f381b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final ArrayList f382c = new ArrayList();

    /* JADX INFO: renamed from: f */
    public final HashMap f385f = new HashMap();

    public C0120c(C0118a c0118a, InterfaceC0121d interfaceC0121d) {
        this.f383d = c0118a;
        this.f384e = interfaceC0121d;
    }

    /* JADX INFO: renamed from: a */
    public static C0004d m278a(String str, List list) {
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
