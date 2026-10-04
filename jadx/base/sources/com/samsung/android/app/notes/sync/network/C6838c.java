package com.samsung.android.app.notes.sync.network;

import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6853d;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6838c implements InterfaceC6853d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int[] f4256a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String[] f4257b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ JSONObject[] f4258c;

    public C6838c(int[] iArr, String[] strArr, JSONObject[] jSONObjectArr) {
        this.f4256a = iArr;
        this.f4257b = strArr;
        this.f4258c = jSONObjectArr;
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6853d
    /* JADX INFO: renamed from: b */
    public final void mo5000b(int i, String str) throws SyncException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("rcode");
            Debugger.m8615i("SCloudResponseHandler", "RCODE = " + iOptInt);
            if (iOptInt == 19008) {
                Debugger.m8609e("SCloudResponseHandler", "access token is invalid!");
                throw new SyncException(315, "status error : " + i + ", response =" + str);
            }
            if (iOptInt == 20003 || iOptInt == 39111) {
                throw new SyncException(311, str);
            }
            if (iOptInt == 31002 || iOptInt == 32006) {
                throw new SyncException(319, str);
            }
            if (iOptInt == 20000) {
                throw new SyncException(501, str);
            }
            if (iOptInt != 0) {
                throw new SyncException(315, str);
            }
            m5002c(iOptInt, jSONObject);
        } catch (JSONException e) {
            Debugger.m8617s("SCloudResponseHandler", "handleSCloudResponse err : " + str, e);
            throw new SyncException(304, e);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m5002c(int i, JSONObject jSONObject) throws JSONException {
        this.f4256a[0] = i;
        String[] strArr = this.f4257b;
        boolean zIsEmpty = strArr[0].isEmpty();
        JSONObject[] jSONObjectArr = this.f4258c;
        if (zIsEmpty) {
            jSONObjectArr[0] = jSONObject;
        } else {
            JSONArray jSONArray = jSONObject.getJSONArray("children");
            JSONArray jSONArray2 = jSONObjectArr[0].getJSONArray("children");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                jSONArray2.put(jSONArray.get(i2));
            }
        }
        if (jSONObject.has("next")) {
            strArr[0] = jSONObject.getString("next");
        } else {
            strArr[0] = "";
        }
    }
}
