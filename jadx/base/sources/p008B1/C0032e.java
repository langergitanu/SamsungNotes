package p008B1;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p026F1.C0097a;
import p079T.AbstractC0299q;
import p234q1.C14434c;

/* JADX INFO: renamed from: B1.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0032e extends AbstractC0033f {

    /* JADX INFO: renamed from: d */
    public final String f162d;

    /* JADX INFO: renamed from: e */
    public final long f163e;

    public C0032e(C6903f c6903f, Context context, C0097a c0097a, String str, long j) {
        super(c6903f, context, c0097a);
        this.f162d = str;
        this.f163e = j;
    }

    /* JADX INFO: renamed from: b */
    public final void m61b() {
        Context context = (Context) this.f165b;
        Debugger.m8607d("SyncNote/SDocxDeleteNote", "start");
        StringBuilder sb = new StringBuilder();
        C0097a c0097a = (C0097a) this.f166c;
        if (c0097a.f318a == 3) {
            sb.append("/samsungnotes/v3");
        } else {
            sb.append("/samsungnotes/v1");
        }
        String str = this.f162d;
        String strM15044b = C14434c.m15043a().m15044b(AbstractC0622a.m1170p("/notes/", str, sb));
        C6861l c6861l = new C6861l((C6903f) this.f164a, context, c0097a);
        c6861l.f4309j = "deleteNote";
        c6861l.f4304e = strM15044b;
        c6861l.f4301b.put("syncModifiedTime", Long.toString(this.f163e));
        c6861l.f4305f = "DELETE";
        C6865p c6865pM5040b = c6861l.m5033c().m5040b();
        int i = c6865pM5040b.f4344a;
        if (i != 200) {
            if (i == 404) {
                AbstractC4539a.m3190D("resource note found, serverResourceId = ", str, "SyncNote/SDocxDeleteNote");
            } else if (i == 409) {
                Debugger.m8609e("SyncNote/SDocxDeleteNote", "Latest resource note exist, serverResourceId = " + str);
            } else {
                AbstractC0299q.m600J(context, c6865pM5040b);
            }
        }
        Debugger.m8607d("SyncNote/SDocxDeleteNote", "finish");
    }
}
