package com.samsung.android.app.notes.sync.network;

import com.samsung.android.app.notes.sync.network.networkutils.AbstractC6854e;
import java.util.ArrayList;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p042J1.AbstractC0146d;
import p234q1.C14434c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6849n {

    /* JADX INFO: renamed from: a */
    public final String f4274a;

    public C6849n(String str) {
        this.f4274a = str;
    }

    /* JADX INFO: renamed from: a */
    public final ArrayList m5015a() throws JSONException {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        String string = "";
        String[] strArr = {""};
        do {
            String strM15044b = C14434c.m15043a().m15044b("/kvs/keys/?cid=gr3k9outd1&count=50&coldStartable=true&start=".concat(string));
            String str = this.f4274a;
            AbstractC6854e.m5026f(str, strM15044b, AbstractC0146d.m342a(str), new C6836a(strArr, 1));
            JSONObject jSONObject = new JSONObject(strArr[0]);
            JSONArray jSONArray = jSONObject.getJSONArray(XmlErrorCodes.LIST);
            int length = jSONArray.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (!jSONObject2.getBoolean("deleted")) {
                        arrayList2.add(jSONObject2.getString("key"));
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                StringBuilder sb = new StringBuilder("/kvs/item/?cid=gr3k9outd1");
                for (String str2 : arrayList2) {
                    sb.append("&key=");
                    sb.append(str2);
                }
                AbstractC6854e.m5026f(str, C14434c.m15043a().m15044b(sb.toString()), AbstractC0146d.m342a(str), new C6836a(strArr, 2));
                JSONArray jSONArray2 = new JSONObject(strArr[0]).getJSONArray(XmlErrorCodes.LIST);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    arrayList.add(jSONArray2.getJSONObject(i2));
                }
                arrayList2.clear();
            }
            string = jSONObject.getString("nextKey");
            if (string == null) {
                break;
            }
        } while (string.length() > 0);
        return arrayList;
    }
}
