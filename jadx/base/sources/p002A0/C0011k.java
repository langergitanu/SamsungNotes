package p002A0;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: A0.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0011k {

    /* JADX INFO: renamed from: a */
    public String f60a;

    /* JADX INFO: renamed from: b */
    public String f61b;

    /* JADX INFO: renamed from: c */
    public boolean f62c;

    /* JADX INFO: renamed from: d */
    public final String f63d;

    /* JADX INFO: renamed from: e */
    public long f64e;

    /* JADX INFO: renamed from: f */
    public long f65f = 0;

    /* JADX INFO: renamed from: g */
    public final String f66g;

    public C0011k(String str, String str2, String str3, boolean z, long j, String str4) {
        this.f60a = str;
        this.f61b = str2;
        this.f63d = str3;
        this.f62c = z;
        this.f64e = j;
        this.f66g = str4;
    }

    /* JADX INFO: renamed from: a */
    public final JSONObject m38a() throws JSONException {
        String str = this.f61b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("syncname", str);
        jSONObject.put("syncpath", str);
        jSONObject.put("ModifiedTime", this.f64e);
        jSONObject.put("IsFolder", "0");
        jSONObject.put("tag", "tag");
        return jSONObject;
    }

    public final String toString() {
        return "SyncItem - localId : " + this.f61b + ", syncKey : " + this.f60a + ", tagServerTimeStamp : " + this.f64e + ", deleted : " + this.f62c;
    }
}
