package p017D1;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.synchronization.managers.C6901d;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import p022E1.C0077c;
import p042J1.AbstractC0153k;
import p042J1.C0152j;

/* JADX INFO: renamed from: D1.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0065f extends AbstractC0060a {
    /* JADX INFO: renamed from: a */
    public final void m153a(String str, long j) {
        StringBuilder sb = new StringBuilder("perform() : ");
        String str2 = this.f241e;
        Debugger.m8615i("SyncNote/SyncSDocxDeleteLocalNote", AbstractC0541b.m776r(sb, str2, " by ", str, " at 0"));
        C0152j c0152jM378g = AbstractC0153k.m378g();
        c0152jM378g.f454c = "SyncSDocxDeleteLocalNote";
        c0152jM378g.f455d = str2;
        C0077c c0077c = this.f237a;
        Context context = c0077c.f262e;
        Context context2 = c0077c.f262e;
        c0152jM378g.m371b(context);
        try {
            BaseUtils.getApplicationContext();
            C6901d.m5113d(new C6748q(context2, str2));
            c0077c.f266i.m4886b(3, str2, str);
            SyncState.removeDontSyncNewNote(str2);
            C6742k.m4841o().m4855l(str2);
        } finally {
            AbstractC0153k.m379h(context2, "deleteLocalNote_res");
        }
    }
}
