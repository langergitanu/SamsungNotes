package com.samsung.android.app.notes.sync.quota;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.scsp.pam.kps.lite.KpsApiContract;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p026F1.C0097a;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p186h1.C12020a;
import p207n1.C13541h;
import p211o0.C13571e;
import p211o0.C13572f;
import p234q1.C14434c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.quota.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6871d {

    /* JADX INFO: renamed from: e */
    public static C6871d f4365e;

    /* JADX INFO: renamed from: a */
    public Context f4366a;

    /* JADX INFO: renamed from: b */
    public Object f4367b;

    /* JADX INFO: renamed from: c */
    public Object f4368c;

    /* JADX INFO: renamed from: d */
    public Object f4369d;

    /* JADX INFO: renamed from: b */
    public static synchronized C6871d m5056b() {
        try {
            if (f4365e == null) {
                C6871d c6871d = new C6871d();
                c6871d.f4366a = null;
                c6871d.f4367b = new ArrayList();
                c6871d.f4368c = null;
                c6871d.f4369d = new C6868a(c6871d);
                c6871d.f4366a = C0322h.m670a().f815a.getAppContext();
                f4365e = c6871d;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4365e;
    }

    /* JADX INFO: renamed from: a */
    public void m5057a(InterfaceC6872e interfaceC6872e) {
        Debugger.m8607d("QT/QuotaHelper", "addQuotaListener() : ".concat(interfaceC6872e == null ? "null" : ""));
        synchronized (InterfaceC6872e.class) {
            try {
                Iterator it = ((ArrayList) this.f4367b).iterator();
                while (it.hasNext()) {
                    if (((InterfaceC6872e) it.next()).equals(interfaceC6872e)) {
                        return;
                    }
                }
                ((ArrayList) this.f4367b).add(interfaceC6872e);
                Debugger.m8607d("QT/QuotaHelper", "Added Quota listener - size : " + ((ArrayList) this.f4367b).size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5058c(int i) {
        Debugger.m8615i("QT/QuotaHelper", "start getQuota()");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (C0158a.m407a().m414e()) {
            C13541h.m14287e().m14295i(new C6870c(this, i));
            Debugger.m8607d("QT/QuotaHelper", "finish getQuota() elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            return;
        }
        synchronized (((C6868a) this.f4369d)) {
            ((C6868a) this.f4369d).mo5055a(101, 0L, 0L);
        }
        Debugger.m8615i("QT/QuotaHelper", "getQuota() : network not connected!");
    }

    /* JADX INFO: renamed from: d */
    public void m5059d(Context context) {
        if (CommonUtils.hasCloudSetting(context)) {
            Debugger.m8607d("QT/QuotaHelper", "initQuotaUi() : hasCloudSetting");
            return;
        }
        if (DeviceUtils.isSupportedSync(C0158a.m407a().f492a)) {
            Debugger.m8607d("QT/QuotaHelper", "isQuotaUiChecked() : " + C0145c.m323h("QUOTA_PREFERENCE", "quota_ui_checked", false));
            if (C0145c.m323h("QUOTA_PREFERENCE", "quota_ui_checked", false)) {
                Debugger.m8615i("QT/QuotaHelper", "initQuotaUi() : quota status checked!");
            } else if (C0158a.m407a().m414e()) {
                C13541h.m14287e().m14295i(new C6869b(this, context));
            } else {
                Debugger.m8615i("QT/QuotaHelper", "The data network is not available!");
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public void m5060e(C12020a c12020a) {
        Context context = this.f4366a;
        Debugger.m8615i("EdpGroupApi", "[EDP] requestEdpState()");
        this.f4367b = c12020a;
        if (!C0158a.m407a().m414e()) {
            throw new SyncException(602, "fail to get the edp state! <- Network");
        }
        String strM15044b = C14434c.m15043a().m15044b("/samsungnotes/v3/e2ee/groups");
        C6861l c6861l = new C6861l((C6903f) this.f4368c, context, (C0097a) this.f4369d);
        c6861l.f4309j = "groups";
        c6861l.f4304e = strM15044b;
        c6861l.m5035e();
        C6865p c6865pM5034d = c6861l.m5034d();
        if (c6865pM5034d.f4344a == 200) {
            String str = c6865pM5034d.f4346c;
            C13572f c13572f = new C13572f();
            c13572f.f9628a = "None";
            c13572f.f9629b = "None";
            if (TextUtils.isEmpty(str)) {
                Debugger.m8609e("ResultEdpState", "[EDP] fail to parse()");
            } else {
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("e2eeGroups");
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        c13572f.f9628a = jSONObject.getString(KpsApiContract.Parameter.E2EE_GROUP_ID);
                        c13572f.f9629b = jSONObject.getString("state");
                    }
                    Debugger.m8615i("ResultEdpState", "[EDP] fromJsonString() : e2eeGroupId = " + c13572f.f9628a + ", state = " + c13572f.f9629b);
                    C12020a c12020a2 = (C12020a) this.f4367b;
                    if (c12020a2 != null) {
                        C13571e c13571e = (C13571e) c12020a2.f8772b;
                        c13571e.f9627d = c13572f;
                        c13571e.f9625b.countDown();
                    }
                    this.f4367b = null;
                    return;
                } catch (JSONException e) {
                    Debugger.m8609e("ResultEdpState", "[EDP] parse() : " + e);
                }
            }
        } else {
            AbstractC0299q.m600J(context, c6865pM5034d);
        }
        throw new SyncException(605, "fail to get the edp state!");
    }
}
