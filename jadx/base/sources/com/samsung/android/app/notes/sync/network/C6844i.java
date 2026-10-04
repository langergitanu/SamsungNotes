package com.samsung.android.app.notes.sync.network;

import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6853d;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import org.json.JSONException;
import org.json.JSONObject;
import p207n1.C13541h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6844i implements InterfaceC6853d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4266a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InterfaceC6846k f4267b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int[] f4268c;

    public /* synthetic */ C6844i(InterfaceC6846k interfaceC6846k, int[] iArr, int i) {
        this.f4266a = i;
        this.f4267b = interfaceC6846k;
        this.f4268c = iArr;
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6853d
    /* JADX INFO: renamed from: b */
    public final void mo5000b(int i, String str) throws SyncException {
        switch (this.f4266a) {
            case 0:
                int[] iArr = this.f4268c;
                if (i >= 300) {
                    Debugger.m8607d("NT$NoteServiceHelper", "deleteFile response " + i + " " + str);
                }
                InterfaceC6846k interfaceC6846k = this.f4267b;
                if (i != 200) {
                    Debugger.m8609e("NT$NoteServiceHelper", "onResponse(-1)");
                    if (interfaceC6846k != null) {
                        interfaceC6846k.mo264a(-1);
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (interfaceC6846k != null) {
                        interfaceC6846k.mo264a(((Integer) jSONObject.get("rcode")).intValue());
                    }
                    iArr[0] = ((Integer) jSONObject.get("rcode")).intValue();
                    return;
                } catch (JSONException e) {
                    Debugger.m8609e("NT$NoteServiceHelper", e.getMessage());
                    return;
                }
            default:
                Debugger.m8615i("NT$NoteServiceHelper", "uploadFile response " + i + " " + str);
                if (i == 200) {
                    InterfaceC6846k interfaceC6846k2 = this.f4267b;
                    if (interfaceC6846k2 != null) {
                        Debugger.m8607d("NT$NoteServiceHelper", "uploadFile succeeded");
                        interfaceC6846k2.mo264a(0);
                    }
                    this.f4268c[0] = 0;
                    return;
                }
                try {
                    int iOptInt = new JSONObject(str).optInt("rcode");
                    if (iOptInt == 19008 || iOptInt == 19018) {
                        C13541h.m14287e().m14296j();
                        SCloudPamHelper.handleExpiredSAToken();
                        Debugger.m8609e("NT$NoteServiceHelper", "access token is expired");
                        throw new SyncException(303, str);
                    }
                    if (iOptInt == 20003 || iOptInt == 39111) {
                        throw new SyncException(311, str);
                    }
                    if (iOptInt == 20000) {
                        throw new SyncException(501, str);
                    }
                    if (iOptInt != 79902) {
                        throw new SyncException(315, "Upload Fail");
                    }
                    throw new SyncException(503, str);
                } catch (JSONException e2) {
                    Debugger.m8617s("NT$NoteServiceHelper", "handleResponse err : " + str, e2);
                    Debugger.m8609e("NT$NoteServiceHelper", "handleResponse err : " + e2);
                    throw new SyncException(304, e2);
                }
        }
    }
}
