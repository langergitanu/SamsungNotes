package com.samsung.android.app.notes.sync.network;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.AbstractC6854e;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import org.json.JSONObject;
import p042J1.AbstractC0146d;
import p079T.AbstractC0299q;
import p234q1.C14434c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6840e {

    /* JADX INFO: renamed from: a */
    public final String f4260a;

    /* JADX INFO: renamed from: b */
    public final String f4261b;

    public C6840e(String str, String str2) {
        this.f4260a = str;
        this.f4261b = str2;
    }

    /* JADX INFO: renamed from: a */
    public final void m5003a(String str, String str2) throws SyncException {
        C6839d c6839d = new C6839d(str2);
        Debugger.m8607d("NT$MemoServiceHelper", "downloadFile [" + Thread.currentThread().getId() + "]");
        StringBuilder sb = new StringBuilder("/ors/v2/");
        sb.append("download");
        sb.append(str);
        sb.append("?cid=");
        String str3 = this.f4261b;
        sb.append(str3);
        try {
            AbstractC0299q.m627f(sb, "ctid", "", false);
            AbstractC6854e.m5026f(str3, C14434c.m15043a().m15044b(sb.toString()), AbstractC0146d.m342a(this.f4260a), c6839d);
            Debugger.m8607d("NT$MemoServiceHelper", "downloadFile finish [" + Thread.currentThread().getId() + "]");
        } catch (SyncException e) {
            Debugger.m8609e("NT$MemoServiceHelper", e.getMessage());
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    public final JSONObject m5004b(String str) throws SyncException {
        String str2;
        JSONObject[] jSONObjectArr = new JSONObject[1];
        int[] iArr = new int[1];
        String[] strArr = {""};
        do {
            String strM756B = AbstractC0541b.m756B(str, "/");
            String str3 = strArr[0];
            C6838c c6838c = new C6838c(iArr, strArr, jSONObjectArr);
            Debugger.m8615i("NT$MemoServiceHelper", "listDirectory [" + Thread.currentThread().getId() + "]");
            StringBuilder sb = new StringBuilder("/ors/v2/");
            sb.append("ls");
            sb.append(strM756B);
            sb.append("?cid=");
            String str4 = this.f4261b;
            sb.append(str4);
            sb.append("&coldStartable=true&count=1000");
            if (str3 != null) {
                try {
                    if (!str3.isEmpty()) {
                        AbstractC0299q.m627f(sb, "start", str3, false);
                    }
                } catch (SyncException e) {
                    Debugger.m8609e("NT$MemoServiceHelper", e.getMessage());
                    throw e;
                }
            }
            AbstractC0299q.m627f(sb, "ctid", "", false);
            AbstractC6854e.m5026f(str4, C14434c.m15043a().m15044b(sb.toString()), AbstractC0146d.m342a(this.f4260a), c6838c);
            Debugger.m8615i("NT$MemoServiceHelper", "listDirectory finish [" + Thread.currentThread().getId() + "]");
            str2 = strArr[0];
            if (str2 == null) {
                break;
            }
        } while (!str2.isEmpty());
        return jSONObjectArr[0];
    }
}
