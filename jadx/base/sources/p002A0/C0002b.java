package p002A0;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: A0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0002b {

    /* JADX INFO: renamed from: a */
    public String f7a;

    /* JADX INFO: renamed from: b */
    public String f8b;

    /* JADX INFO: renamed from: c */
    public boolean f9c;

    /* JADX INFO: renamed from: d */
    public final String f10d;

    /* JADX INFO: renamed from: e */
    public final int f11e;

    /* JADX INFO: renamed from: f */
    public long f12f;

    public C0002b(int i, String str, String str2, long j, String str3, boolean z) {
        this.f7a = str;
        this.f8b = str2;
        this.f10d = str3;
        this.f9c = z;
        this.f12f = j;
        this.f11e = i;
    }

    /* JADX INFO: renamed from: a */
    public final JSONObject m30a() throws JSONException {
        String str = this.f8b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("syncname", str);
        jSONObject.put("syncpath", str);
        jSONObject.put("ModifiedTime", this.f12f);
        jSONObject.put("IsFolder", "0");
        jSONObject.put("category", "category");
        return jSONObject;
    }

    public final String toString() {
        return "SyncItem - localId : " + this.f8b + ", syncKey : " + this.f7a + ", categoryTimeStamp : " + this.f12f + ", deleted : " + this.f9c;
    }
}
