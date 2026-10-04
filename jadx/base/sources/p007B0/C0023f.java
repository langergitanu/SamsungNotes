package p007B0;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import p003A1.C0012a;
import p042J1.C0145c;
import p086V.C0322h;
import p207n1.C13541h;

/* JADX INFO: renamed from: B0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0023f {

    /* JADX INFO: renamed from: a */
    public String f125a;

    /* JADX INFO: renamed from: b */
    public boolean f126b;

    /* JADX INFO: renamed from: c */
    public Object f127c;

    /* JADX INFO: renamed from: a */
    public void m46a(String str, long j) throws SyncException {
        C0012a c0012a = (C0012a) this.f127c;
        this.f126b = false;
        if (AbstractC2322a.m1607A(str)) {
            Debugger.m8607d("SyncOldNote$SyncServerPassword", "Server is latest.");
            if (!C0322h.m670a().f826l.updateUserAuthInfo(c0012a.f262e, str, true)) {
                Debugger.m8609e("SyncOldNote$SyncServerPassword", "Failed to updateUserAuthInfo()");
                throw new SyncException(312, "Failed to updateUserAuthInfo()");
            }
            LockPrefUtils.setLocalPasswordOwnerGuid(c0012a.f262e, C13541h.m14287e().m14294h());
            C0145c.m308P(j, "serverPassword", "serverPasswordKey");
        }
    }
}
