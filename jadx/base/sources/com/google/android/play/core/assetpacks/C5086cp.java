package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5224h;
import com.google.android.play.core.internal.InterfaceC5215cj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.cp */
/* JADX INFO: loaded from: classes5.dex */
final class C5086cp {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2744a = new C5157af("ExtractorSessionStoreView");

    /* JADX INFO: renamed from: b */
    private final C5045bb f2745b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5215cj<InterfaceC5141w> f2746c;

    /* JADX INFO: renamed from: d */
    private final C5069bz f2747d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC5215cj<Executor> f2748e;

    /* JADX INFO: renamed from: f */
    private final Map<Integer, C5083cm> f2749f = new HashMap();

    /* JADX INFO: renamed from: g */
    private final ReentrantLock f2750g = new ReentrantLock();

    public C5086cp(C5045bb c5045bb, InterfaceC5215cj<InterfaceC5141w> interfaceC5215cj, C5069bz c5069bz, InterfaceC5215cj<Executor> interfaceC5215cj2) {
        this.f2745b = c5045bb;
        this.f2746c = interfaceC5215cj;
        this.f2747d = c5069bz;
        this.f2748e = interfaceC5215cj2;
    }

    /* JADX INFO: renamed from: a */
    private final <T> T m3746a(InterfaceC5085co<T> interfaceC5085co) {
        try {
            m3752a();
            return interfaceC5085co.mo3745a();
        } finally {
            m3757b();
        }
    }

    /* JADX INFO: renamed from: e */
    private final C5083cm m3748e(int i) {
        Map<Integer, C5083cm> map = this.f2749f;
        Integer numValueOf = Integer.valueOf(i);
        C5083cm c5083cm = map.get(numValueOf);
        if (c5083cm != null) {
            return c5083cm;
        }
        throw new C5065bv(String.format("Could not find session %d while trying to get it", numValueOf), i);
    }

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Map m3756b(List list) {
        int i;
        Map<String, C5083cm> mapM3747d = m3747d((List<String>) list);
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            final C5083cm c5083cm = mapM3747d.get(str);
            if (c5083cm == null) {
                i = 8;
            } else {
                if (C5099db.m3784a(c5083cm.f2737c.f2732c)) {
                    try {
                        c5083cm.f2737c.f2732c = 6;
                        this.f2748e.m3979a().execute(new Runnable(this, c5083cm) { // from class: com.google.android.play.core.assetpacks.cj

                            /* JADX INFO: renamed from: a */
                            private final C5086cp f2727a;

                            /* JADX INFO: renamed from: b */
                            private final C5083cm f2728b;

                            {
                                this.f2727a = this;
                                this.f2728b = c5083cm;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f2727a.m3753a(this.f2728b.f2735a);
                            }
                        });
                        this.f2747d.m3741a(str);
                    } catch (C5065bv unused) {
                        f2744a.m3878c("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(c5083cm.f2735a), str);
                    }
                }
                i = c5083cm.f2737c.f2732c;
            }
            map.put(str, Integer.valueOf(i));
        }
        return map;
    }

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Boolean m3761c(Bundle bundle) {
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return Boolean.TRUE;
        }
        Map<Integer, C5083cm> map = this.f2749f;
        Integer numValueOf = Integer.valueOf(i);
        if (!map.containsKey(numValueOf)) {
            return Boolean.TRUE;
        }
        if (this.f2749f.get(numValueOf).f2737c.f2732c == 6) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(!C5099db.m3785a(r0.f2737c.f2732c, bundle.getInt(C5224h.m3993a("status", m3749e(bundle)))));
    }

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Boolean m3765d(Bundle bundle) {
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return Boolean.FALSE;
        }
        Map<Integer, C5083cm> map = this.f2749f;
        Integer numValueOf = Integer.valueOf(i);
        if (map.containsKey(numValueOf)) {
            C5083cm c5083cmM3748e = m3748e(i);
            int i2 = bundle.getInt(C5224h.m3993a("status", c5083cmM3748e.f2737c.f2730a));
            if (C5099db.m3785a(c5083cmM3748e.f2737c.f2732c, i2)) {
                f2744a.m3875a("Found stale update for session %s with status %d.", numValueOf, Integer.valueOf(c5083cmM3748e.f2737c.f2732c));
                C5082cl c5082cl = c5083cmM3748e.f2737c;
                String str = c5082cl.f2730a;
                int i4 = c5082cl.f2732c;
                if (i4 == 4) {
                    this.f2746c.m3979a().mo3669a(i, str);
                } else if (i4 == 5) {
                    this.f2746c.m3979a().mo3668a(i);
                } else if (i4 == 6) {
                    this.f2746c.m3979a().mo3672a(Arrays.asList(str));
                }
            } else {
                c5083cmM3748e.f2737c.f2732c = i2;
                if (C5099db.m3787b(i2)) {
                    m3753a(i);
                    this.f2747d.m3741a(c5083cmM3748e.f2737c.f2730a);
                } else {
                    List<C5084cn> list = c5083cmM3748e.f2737c.f2734e;
                    int size = list.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        C5084cn c5084cn = list.get(i5);
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(C5224h.m3994a("chunk_intents", c5083cmM3748e.f2737c.f2730a, c5084cn.f2738a));
                        if (parcelableArrayList != null) {
                            for (int i6 = 0; i6 < parcelableArrayList.size(); i6++) {
                                if (parcelableArrayList.get(i6) != null && ((Intent) parcelableArrayList.get(i6)).getData() != null) {
                                    c5084cn.f2741d.get(i6).f2729a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String strM3749e = m3749e(bundle);
            long j = bundle.getLong(C5224h.m3993a("pack_version", strM3749e));
            int i7 = bundle.getInt(C5224h.m3993a("status", strM3749e));
            long j2 = bundle.getLong(C5224h.m3993a("total_bytes_to_download", strM3749e));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(C5224h.m3993a("slice_ids", strM3749e));
            ArrayList arrayList = new ArrayList();
            Iterator it = m3750e(stringArrayList).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(C5224h.m3994a("chunk_intents", strM3749e, str2));
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = m3750e(parcelableArrayList2).iterator();
                while (it2.hasNext()) {
                    Iterator it3 = it;
                    arrayList2.add(new C5081ck(((Intent) it2.next()) != null));
                    it = it3;
                }
                Iterator it4 = it;
                String string = bundle.getString(C5224h.m3994a("uncompressed_hash_sha256", strM3749e, str2));
                long j3 = bundle.getLong(C5224h.m3994a("uncompressed_size", strM3749e, str2));
                int i8 = bundle.getInt(C5224h.m3994a("patch_format", strM3749e, str2), 0);
                arrayList.add(i8 != 0 ? new C5084cn(str2, string, j3, arrayList2, 0, i8) : new C5084cn(str2, string, j3, arrayList2, bundle.getInt(C5224h.m3994a("compression_format", strM3749e, str2), 0), 0));
                it = it4;
            }
            this.f2749f.put(Integer.valueOf(i), new C5083cm(i, bundle.getInt("app_version_code"), new C5082cl(strM3749e, j, i7, j2, arrayList)));
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: renamed from: d */
    private final Map<String, C5083cm> m3747d(final List<String> list) {
        return (Map) m3746a(new InterfaceC5085co(this, list) { // from class: com.google.android.play.core.assetpacks.cf

            /* JADX INFO: renamed from: a */
            private final C5086cp f2719a;

            /* JADX INFO: renamed from: b */
            private final List f2720b;

            {
                this.f2719a = this;
                this.f2720b = list;
            }

            @Override // com.google.android.play.core.assetpacks.InterfaceC5085co
            /* JADX INFO: renamed from: a */
            public final Object mo3745a() {
                return this.f2719a.m3763c(this.f2720b);
            }
        });
    }

    /* JADX INFO: renamed from: e */
    private static String m3749e(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            throw new C5065bv("Session without pack received.");
        }
        return stringArrayList.get(0);
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, Integer> m3751a(final List<String> list) {
        return (Map) m3746a(new InterfaceC5085co(this, list) { // from class: com.google.android.play.core.assetpacks.ci

            /* JADX INFO: renamed from: a */
            private final C5086cp f2725a;

            /* JADX INFO: renamed from: b */
            private final List f2726b;

            {
                this.f2725a = this;
                this.f2726b = list;
            }

            @Override // com.google.android.play.core.assetpacks.InterfaceC5085co
            /* JADX INFO: renamed from: a */
            public final Object mo3745a() {
                return this.f2725a.m3756b(this.f2726b);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public final void m3757b() {
        this.f2750g.unlock();
    }

    /* JADX INFO: renamed from: c */
    public final Map<Integer, C5083cm> m3762c() {
        return this.f2749f;
    }

    /* JADX INFO: renamed from: e */
    private static <T> List<T> m3750e(List<T> list) {
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX INFO: renamed from: a */
    public final void m3752a() {
        this.f2750g.lock();
    }

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ void m3758b(int i) {
        m3748e(i).f2737c.f2732c = 5;
    }

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Map m3763c(List list) {
        HashMap map = new HashMap();
        for (C5083cm c5083cm : this.f2749f.values()) {
            String str = c5083cm.f2737c.f2730a;
            if (list.contains(str)) {
                C5083cm c5083cm2 = (C5083cm) map.get(str);
                if ((c5083cm2 == null ? -1 : c5083cm2.f2735a) < c5083cm.f2735a) {
                    map.put(str, c5083cm);
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: d */
    public final void m3766d(final int i) {
        m3746a(new InterfaceC5085co(this, i) { // from class: com.google.android.play.core.assetpacks.cg

            /* JADX INFO: renamed from: a */
            private final C5086cp f2721a;

            /* JADX INFO: renamed from: b */
            private final int f2722b;

            {
                this.f2721a = this;
                this.f2722b = i;
            }

            @Override // com.google.android.play.core.assetpacks.InterfaceC5085co
            /* JADX INFO: renamed from: a */
            public final Object mo3745a() {
                this.f2721a.m3758b(this.f2722b);
                return null;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m3753a(final int i) {
        m3746a(new InterfaceC5085co(this, i) { // from class: com.google.android.play.core.assetpacks.ch

            /* JADX INFO: renamed from: a */
            private final C5086cp f2723a;

            /* JADX INFO: renamed from: b */
            private final int f2724b;

            {
                this.f2723a = this;
                this.f2724b = i;
            }

            @Override // com.google.android.play.core.assetpacks.InterfaceC5085co
            /* JADX INFO: renamed from: a */
            public final Object mo3745a() {
                this.f2723a.m3764c(this.f2724b);
                return null;
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ void m3759b(String str, int i, long j) {
        C5083cm c5083cm = m3747d(Arrays.asList(str)).get(str);
        if (c5083cm == null || C5099db.m3787b(c5083cm.f2737c.f2732c)) {
            f2744a.m3877b(AbstractC0541b.m773o("Could not find pack ", str, " while trying to complete it"), new Object[0]);
        }
        this.f2745b.m3718f(str, i, j);
        c5083cm.f2737c.f2732c = 4;
    }

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ void m3764c(int i) {
        C5083cm c5083cmM3748e = m3748e(i);
        if (!C5099db.m3787b(c5083cmM3748e.f2737c.f2732c)) {
            throw new C5065bv(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i)), i);
        }
        C5045bb c5045bb = this.f2745b;
        C5082cl c5082cl = c5083cmM3748e.f2737c;
        c5045bb.m3718f(c5082cl.f2730a, c5083cmM3748e.f2736b, c5082cl.f2731b);
        C5082cl c5082cl2 = c5083cmM3748e.f2737c;
        int i2 = c5082cl2.f2732c;
        if (i2 == 5 || i2 == 6) {
            this.f2745b.m3710d(c5082cl2.f2730a);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3754a(final String str, final int i, final long j) {
        m3746a(new InterfaceC5085co(this, str, i, j) { // from class: com.google.android.play.core.assetpacks.ce

            /* JADX INFO: renamed from: a */
            private final C5086cp f2715a;

            /* JADX INFO: renamed from: b */
            private final String f2716b;

            /* JADX INFO: renamed from: c */
            private final int f2717c;

            /* JADX INFO: renamed from: d */
            private final long f2718d;

            {
                this.f2715a = this;
                this.f2716b = str;
                this.f2717c = i;
                this.f2718d = j;
            }

            @Override // com.google.android.play.core.assetpacks.InterfaceC5085co
            /* JADX INFO: renamed from: a */
            public final Object mo3745a() {
                this.f2715a.m3759b(this.f2716b, this.f2717c, this.f2718d);
                return null;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3755a(final Bundle bundle) {
        return ((Boolean) m3746a(new InterfaceC5085co(this, bundle) { // from class: com.google.android.play.core.assetpacks.cc

            /* JADX INFO: renamed from: a */
            private final C5086cp f2711a;

            /* JADX INFO: renamed from: b */
            private final Bundle f2712b;

            {
                this.f2711a = this;
                this.f2712b = bundle;
            }

            @Override // com.google.android.play.core.assetpacks.InterfaceC5085co
            /* JADX INFO: renamed from: a */
            public final Object mo3745a() {
                return this.f2711a.m3765d(this.f2712b);
            }
        })).booleanValue();
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3760b(final Bundle bundle) {
        return ((Boolean) m3746a(new InterfaceC5085co(this, bundle) { // from class: com.google.android.play.core.assetpacks.cd

            /* JADX INFO: renamed from: a */
            private final C5086cp f2713a;

            /* JADX INFO: renamed from: b */
            private final Bundle f2714b;

            {
                this.f2713a = this;
                this.f2714b = bundle;
            }

            @Override // com.google.android.play.core.assetpacks.InterfaceC5085co
            /* JADX INFO: renamed from: a */
            public final Object mo3745a() {
                return this.f2713a.m3761c(this.f2714b);
            }
        })).booleanValue();
    }
}
