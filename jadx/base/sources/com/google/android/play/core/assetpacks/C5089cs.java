package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C5157af;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.cs */
/* JADX INFO: loaded from: classes5.dex */
final class C5089cs {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2757a = new C5157af("ExtractorTaskFinder");

    /* JADX INFO: renamed from: b */
    private final C5086cp f2758b;

    /* JADX INFO: renamed from: c */
    private final C5045bb f2759c;

    /* JADX INFO: renamed from: d */
    private final C5054bk f2760d;

    public C5089cs(C5086cp c5086cp, C5045bb c5045bb, C5054bk c5054bk) {
        this.f2758b = c5086cp;
        this.f2759c = c5045bb;
        this.f2760d = c5054bk;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x01f1, code lost:
    
        com.google.android.play.core.assetpacks.C5089cs.f2757a.m3875a("Found extraction task for patch for session %s, pack %s, slice %s.", java.lang.Integer.valueOf(r6.f2735a), r6.f2737c.f2730a, r8.f2738a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0208, code lost:
    
        r9 = r26.f2759c;
        r4 = r6.f2737c;
        r0 = new java.io.FileInputStream(r9.m3713e(r4.f2730a, r6.f2736b, r4.f2731b, r8.f2738a));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x021d, code lost:
    
        r10 = r6.f2735a;
        r4 = r6.f2737c;
        r9 = new com.google.android.play.core.assetpacks.C5062bs(r10, r4.f2730a, r6.f2736b, r4.f2731b, r8.f2738a, 0, 0, 1, r4.f2733d, r4.f2732c, r0);
        r25 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0242, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0273, code lost:
    
        throw new com.google.android.play.core.assetpacks.C5065bv("Error finding patch, session " + r6.f2735a + " packName " + r6.f2737c.f2730a + " sliceId " + r8.f2738a, r0, r6.f2735a);
     */
    @Nullable
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C5088cr m3769a() {
        C5105dh c5105dh;
        C5088cr c5118du;
        C5111dn c5111dn;
        C5062bs c5062bs;
        C5111dn c5111dn2;
        int iM3820c;
        try {
            this.f2758b.m3752a();
            ArrayList arrayList = new ArrayList();
            for (C5083cm c5083cm : this.f2758b.m3762c().values()) {
                if (C5099db.m3789c(c5083cm.f2737c.f2732c)) {
                    arrayList.add(c5083cm);
                }
            }
            if (arrayList.isEmpty()) {
                this.f2758b.m3757b();
                return null;
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c5105dh = null;
                    break;
                }
                C5083cm c5083cm2 = (C5083cm) it.next();
                try {
                    C5045bb c5045bb = this.f2759c;
                    C5082cl c5082cl = c5083cm2.f2737c;
                    if (c5045bb.m3707d(c5082cl.f2730a, c5083cm2.f2736b, c5082cl.f2731b) == c5083cm2.f2737c.f2734e.size()) {
                        f2757a.m3875a("Found final move task for session %s with pack %s.", Integer.valueOf(c5083cm2.f2735a), c5083cm2.f2737c.f2730a);
                        int i = c5083cm2.f2735a;
                        C5082cl c5082cl2 = c5083cm2.f2737c;
                        c5105dh = new C5105dh(i, c5082cl2.f2730a, c5083cm2.f2736b, c5082cl2.f2731b);
                        break;
                    }
                } catch (IOException e) {
                    throw new C5065bv("Failed to check number of completed merges for session " + c5083cm2.f2735a + ", pack " + c5083cm2.f2737c.f2730a, e, c5083cm2.f2735a);
                }
            }
            if (c5105dh != null) {
                this.f2758b.m3757b();
                return c5105dh;
            }
            Iterator it2 = arrayList.iterator();
            loop2: while (true) {
                if (!it2.hasNext()) {
                    c5118du = null;
                    break;
                }
                C5083cm c5083cm3 = (C5083cm) it2.next();
                if (C5099db.m3789c(c5083cm3.f2737c.f2732c)) {
                    for (C5084cn c5084cn : c5083cm3.f2737c.f2734e) {
                        C5045bb c5045bb2 = this.f2759c;
                        C5082cl c5082cl3 = c5083cm3.f2737c;
                        if (c5045bb2.m3701b(c5082cl3.f2730a, c5083cm3.f2736b, c5082cl3.f2731b, c5084cn.f2738a).exists()) {
                            f2757a.m3875a("Found merge task for session %s with pack %s and slice %s.", Integer.valueOf(c5083cm3.f2735a), c5083cm3.f2737c.f2730a, c5084cn.f2738a);
                            int i2 = c5083cm3.f2735a;
                            C5082cl c5082cl4 = c5083cm3.f2737c;
                            c5118du = new C5102de(i2, c5082cl4.f2730a, c5083cm3.f2736b, c5082cl4.f2731b, c5084cn.f2738a);
                            break loop2;
                        }
                    }
                }
            }
            if (c5118du == null) {
                Iterator it3 = arrayList.iterator();
                loop4: while (true) {
                    if (!it3.hasNext()) {
                        c5118du = null;
                        break;
                    }
                    C5083cm c5083cm4 = (C5083cm) it3.next();
                    if (C5099db.m3789c(c5083cm4.f2737c.f2732c)) {
                        for (C5084cn c5084cn2 : c5083cm4.f2737c.f2734e) {
                            C5045bb c5045bb3 = this.f2759c;
                            C5082cl c5082cl5 = c5083cm4.f2737c;
                            if (new C5115dr(c5045bb3, c5082cl5.f2730a, c5083cm4.f2736b, c5082cl5.f2731b, c5084cn2.f2738a).m3821d()) {
                                C5045bb c5045bb4 = this.f2759c;
                                C5082cl c5082cl6 = c5083cm4.f2737c;
                                if (c5045bb4.m3694a(c5082cl6.f2730a, c5083cm4.f2736b, c5082cl6.f2731b, c5084cn2.f2738a).exists()) {
                                    f2757a.m3875a("Found verify task for session %s with pack %s and slice %s.", Integer.valueOf(c5083cm4.f2735a), c5083cm4.f2737c.f2730a, c5084cn2.f2738a);
                                    int i4 = c5083cm4.f2735a;
                                    C5082cl c5082cl7 = c5083cm4.f2737c;
                                    c5118du = new C5118du(i4, c5082cl7.f2730a, c5083cm4.f2736b, c5082cl7.f2731b, c5084cn2.f2738a, c5084cn2.f2739b);
                                    break loop4;
                                }
                            }
                        }
                    }
                }
                if (c5118du == null) {
                    Iterator it4 = arrayList.iterator();
                    loop6: while (true) {
                        if (!it4.hasNext()) {
                            c5111dn = null;
                            c5062bs = null;
                            break;
                        }
                        C5083cm c5083cm5 = (C5083cm) it4.next();
                        if (C5099db.m3789c(c5083cm5.f2737c.f2732c)) {
                            Iterator<C5084cn> it5 = c5083cm5.f2737c.f2734e.iterator();
                            while (it5.hasNext()) {
                                C5084cn next = it5.next();
                                if (m3768a(next)) {
                                    if (m3767a(c5083cm5, next)) {
                                        break loop6;
                                    }
                                } else {
                                    C5045bb c5045bb5 = this.f2759c;
                                    C5082cl c5082cl8 = c5083cm5.f2737c;
                                    try {
                                        iM3820c = new C5115dr(c5045bb5, c5082cl8.f2730a, c5083cm5.f2736b, c5082cl8.f2731b, next.f2738a).m3820c();
                                    } catch (IOException e2) {
                                        f2757a.m3877b("Slice checkpoint corrupt, restarting extraction. %s", e2);
                                        iM3820c = 0;
                                    }
                                    if (iM3820c != -1 && next.f2741d.get(iM3820c).f2729a) {
                                        f2757a.m3875a("Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s.", Integer.valueOf(next.f2742e), Integer.valueOf(c5083cm5.f2735a), c5083cm5.f2737c.f2730a, next.f2738a, Integer.valueOf(iM3820c));
                                        InputStream inputStreamM3722a = this.f2760d.m3722a(c5083cm5.f2735a, c5083cm5.f2737c.f2730a, next.f2738a, iM3820c);
                                        int i5 = c5083cm5.f2735a;
                                        C5082cl c5082cl9 = c5083cm5.f2737c;
                                        String str = c5082cl9.f2730a;
                                        int i6 = c5083cm5.f2736b;
                                        long j = c5082cl9.f2731b;
                                        String str2 = next.f2738a;
                                        int i7 = next.f2742e;
                                        int size = next.f2741d.size();
                                        C5082cl c5082cl10 = c5083cm5.f2737c;
                                        c5111dn = null;
                                        c5062bs = new C5062bs(i5, str, i6, j, str2, i7, iM3820c, size, c5082cl10.f2733d, c5082cl10.f2732c, inputStreamM3722a);
                                        break loop6;
                                    }
                                }
                            }
                        }
                    }
                    if (c5062bs != null) {
                        this.f2758b.m3757b();
                        return c5062bs;
                    }
                    Iterator it6 = arrayList.iterator();
                    loop8: while (true) {
                        if (!it6.hasNext()) {
                            c5111dn2 = c5111dn;
                            break;
                        }
                        C5083cm c5083cm6 = (C5083cm) it6.next();
                        if (C5099db.m3789c(c5083cm6.f2737c.f2732c)) {
                            for (C5084cn c5084cn3 : c5083cm6.f2737c.f2734e) {
                                if (m3768a(c5084cn3) && c5084cn3.f2741d.get(0).f2729a && !m3767a(c5083cm6, c5084cn3)) {
                                    f2757a.m3875a("Found patch slice task using patch format %s for session %s, pack %s, slice %s.", Integer.valueOf(c5084cn3.f2743f), Integer.valueOf(c5083cm6.f2735a), c5083cm6.f2737c.f2730a, c5084cn3.f2738a);
                                    InputStream inputStreamM3722a2 = this.f2760d.m3722a(c5083cm6.f2735a, c5083cm6.f2737c.f2730a, c5084cn3.f2738a, 0);
                                    int i8 = c5083cm6.f2735a;
                                    String str3 = c5083cm6.f2737c.f2730a;
                                    c5111dn2 = new C5111dn(i8, str3, this.f2759c.m3711e(str3), this.f2759c.m3715f(c5083cm6.f2737c.f2730a), c5083cm6.f2736b, c5083cm6.f2737c.f2731b, c5084cn3.f2743f, c5084cn3.f2738a, c5084cn3.f2740c, inputStreamM3722a2);
                                    break loop8;
                                }
                            }
                        }
                    }
                    this.f2758b.m3757b();
                    return c5111dn2 != null ? c5111dn2 : c5111dn;
                }
            }
            this.f2758b.m3757b();
            return c5118du;
        } catch (Throwable th) {
            this.f2758b.m3757b();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m3767a(C5083cm c5083cm, C5084cn c5084cn) {
        C5045bb c5045bb = this.f2759c;
        C5082cl c5082cl = c5083cm.f2737c;
        return c5045bb.m3713e(c5082cl.f2730a, c5083cm.f2736b, c5082cl.f2731b, c5084cn.f2738a).exists();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3768a(C5084cn c5084cn) {
        int i = c5084cn.f2743f;
        return i == 1 || i == 2;
    }
}
