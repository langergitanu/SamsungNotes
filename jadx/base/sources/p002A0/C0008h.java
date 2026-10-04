package p002A0;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: A0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0008h {

    /* JADX INFO: renamed from: a */
    public long f36a = -1;

    /* JADX INFO: renamed from: b */
    public long f37b = -1;

    /* JADX INFO: renamed from: a */
    public static C0008h m34a(JSONObject jSONObject) throws JSONException {
        C0008h c0008h = new C0008h();
        c0008h.f36a = -1L;
        c0008h.f37b = -1L;
        JSONArray jSONArray = jSONObject.getJSONArray("usage_info");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("cid");
            if (string.equalsIgnoreCase("w8wcqZo4Uk")) {
                c0008h.f37b = jSONObject2.getLong("size");
                StringBuilder sbM15l = AbstractC0000a.m15l("QuotaItem : cid = ", string, " , size = ");
                sbM15l.append(c0008h.f37b);
                Debugger.m8607d("QT/QuotaItem", sbM15l.toString());
                return c0008h;
            }
        }
        return c0008h;
    }

    /* JADX INFO: renamed from: b */
    public static C0008h m35b(JSONObject jSONObject) throws JSONException {
        C0008h c0008h = new C0008h();
        c0008h.f36a = -1L;
        c0008h.f37b = -1L;
        c0008h.f36a = jSONObject.getJSONObject("quota_info").getLong("size");
        JSONArray jSONArray = jSONObject.getJSONArray("usage_info");
        int length = jSONArray.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2.has("size") && jSONObject2.has("quota_check") && jSONObject2.getBoolean("quota_check")) {
                j = jSONObject2.getLong("size") + j;
            }
        }
        c0008h.f37b = j;
        return c0008h;
    }

    /* JADX INFO: renamed from: c */
    public static C0008h m36c(JSONObject jSONObject) throws JSONException {
        C0008h c0008h = new C0008h();
        c0008h.f36a = -1L;
        c0008h.f37b = -1L;
        JSONArray jSONArray = jSONObject.getJSONArray("usage_info");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("cid");
            if (string.equalsIgnoreCase("gr3k9outd1")) {
                c0008h.f37b = jSONObject2.getLong("size");
                StringBuilder sbM15l = AbstractC0000a.m15l("QuotaItem : cid = ", string, " , size = ");
                sbM15l.append(c0008h.f37b);
                Debugger.m8607d("QT/QuotaItem", sbM15l.toString());
                return c0008h;
            }
        }
        return c0008h;
    }
}
