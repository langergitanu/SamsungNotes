package com.samsung.android.app.notes.sync.contentsharing.sessession;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6709i implements SeMobileServiceSession.ConnectionResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC6714n f4029a;

    public C6709i(AbstractC6714n abstractC6714n) {
        this.f4029a = abstractC6714n;
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession.ConnectionResultCallback
    public final void onFailure(int i) {
        AbstractC6714n abstractC6714n = this.f4029a;
        Debugger.m8609e(abstractC6714n.mo4794a(), "[CS0-2] onFailure() : " + i);
        if (abstractC6714n.f4048j instanceof C6707g) {
            abstractC6714n.m4807p(abstractC6714n.f4045g);
        } else {
            abstractC6714n.m4807p(abstractC6714n.f4044f);
        }
        abstractC6714n.m4803l(i);
    }

    @Override // com.samsung.android.sdk.mobileservice.SeMobileServiceSession.ConnectionResultCallback
    public final void onSuccess(HashMap map, boolean z) {
        AbstractC6714n abstractC6714n = this.f4029a;
        if (z) {
            Debugger.m8615i(abstractC6714n.mo4794a(), "[CS0-1] onSessionSuccess() : allServiceConnected!");
            for (Map.Entry entry : map.entrySet()) {
                String string = entry.getKey().toString();
                int iIntValue = ((Integer) entry.getValue()).intValue();
                String strMo4794a = abstractC6714n.mo4794a();
                StringBuilder sbM781w = AbstractC0541b.m781w(string, " : ");
                sbM781w.append(iIntValue != 0 ? iIntValue != 1 ? iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? "" : "SERVICE_STATUS_BLOCKED_BY_POLICY" : "SERVICE_STATUS_NOT_SUPPORT_SDK_VERSION" : "SERVICE_STATUS_FORCE_UPDATE_REQUIRED" : "SERVICE_STATUS_NOT_SUPPORTED" : "SERVICE_STATUS_OK");
                Debugger.m8607d(strMo4794a, sbM781w.toString());
            }
            abstractC6714n.m4807p(abstractC6714n.f4041c);
            abstractC6714n.m4802k();
            return;
        }
        Debugger.m8609e(abstractC6714n.mo4794a(), "[CS0-2] onSessionSuccess() : allServiceConnected is false!");
        Integer num = (Integer) map.get("SocialService");
        Integer num2 = (Integer) map.get("AuthService");
        if (num != null) {
            Debugger.m8609e(abstractC6714n.mo4794a(), "[CS0-1] SocialService is not connected : " + num);
        }
        if (num2 != null) {
            Debugger.m8609e(abstractC6714n.mo4794a(), "[CS0-1] AuthService is not connected : " + num2);
        }
        abstractC6714n.m4807p(abstractC6714n.f4046h);
        abstractC6714n.m4803l(SeMobileServiceSession.ConnectionResultCallback.CAUSE_AGENT_NOT_AVAILABLE);
    }
}
