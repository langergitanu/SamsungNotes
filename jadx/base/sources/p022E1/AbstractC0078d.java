package p022E1;

import android.text.TextUtils;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import p042J1.C0145c;
import p079T.AbstractC0299q;
import p186h1.C12028i;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: renamed from: E1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0078d {

    /* JADX INFO: renamed from: a */
    public final AbstractC0076b f273a;

    public AbstractC0078d(AbstractC0076b abstractC0076b) {
        this.f273a = abstractC0076b;
    }

    /* JADX INFO: renamed from: a */
    public static void m214a() {
        if (!C0145c.m323h("lastConfirmState", "lastConfirmStateKey", true) || C0145c.m323h("checkPassword", "checkpasswordkey", true)) {
            return;
        }
        AbstractC0299q.m616Z(Long.parseLong("1464416139847"));
        C0145c.m304L("lastConfirmState", "lastConfirmStateKey", false);
    }

    /* JADX INFO: renamed from: b */
    public static long m215b() throws SyncException {
        Debugger.m8615i("SyncProcessTask$SyncOperation", "[Time] downloadTimestamp()");
        long jM13707a = C12028i.m13707a();
        if (jM13707a != 0) {
            return jM13707a;
        }
        throw new SyncException(303, "[Time] Failed to downloadTimestamp() - syncTime : 0");
    }

    /* JADX INFO: renamed from: c */
    public final boolean m216c() {
        String strM14294h = C13541h.m14287e().m14294h();
        AbstractC0076b abstractC0076b = this.f273a;
        String localPasswordOwnerGuid = LockPrefUtils.getLocalPasswordOwnerGuid(abstractC0076b.mo40a());
        String str = ((C13540g) C13541h.m14287e().f9588a).f9582d;
        String localUserID = LockPrefUtils.getLocalUserID(abstractC0076b.mo40a());
        if (!TextUtils.isEmpty(localPasswordOwnerGuid)) {
            return !localPasswordOwnerGuid.equals(strM14294h);
        }
        if (!str.equals(localUserID)) {
            return true;
        }
        if (TextUtils.isEmpty(strM14294h)) {
            Debugger.m8609e("SyncProcessTask$SyncOperation", "isPasswordAccountChanged : currentAccountGuidHash is empty!");
            return false;
        }
        LockPrefUtils.setLocalPasswordOwnerGuid(abstractC0076b.mo40a(), strM14294h);
        return false;
    }
}
