package com.samsung.android.app.notes.sync.quota;

import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6853d;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import org.json.JSONException;
import org.json.JSONObject;
import p002A0.C0008h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.quota.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6873f implements InterfaceC6853d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0008h[] f4370a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QuotaServiceTask f4371b;

    public C6873f(QuotaServiceTask quotaServiceTask, C0008h[] c0008hArr) {
        this.f4371b = quotaServiceTask;
        this.f4370a = c0008hArr;
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6853d
    /* JADX INFO: renamed from: b */
    public final void mo5000b(int i, String str) {
        Debugger.m8615i("QT/QuotaServiceTask", "handleResponse()");
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = this.f4371b.mApp;
            C0008h[] c0008hArr = this.f4370a;
            if (i2 == 0) {
                c0008hArr[0] = C0008h.m34a(jSONObject);
                return;
            }
            if (i2 == 1) {
                c0008hArr[0] = C0008h.m35b(jSONObject);
            } else if (i2 != 2) {
                Debugger.m8609e("QT/QuotaServiceTask", "invalid appId!");
            } else {
                c0008hArr[0] = C0008h.m36c(jSONObject);
            }
        } catch (JSONException e) {
            Debugger.m8609e("QT/QuotaServiceTask", e.getMessage());
        }
    }
}
