package p002A0;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: A0.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0009i {

    /* JADX INFO: renamed from: a */
    public String f38a;

    /* JADX INFO: renamed from: b */
    public String f39b;

    /* JADX INFO: renamed from: c */
    public long f40c;

    /* JADX INFO: renamed from: d */
    public long f41d;

    /* JADX INFO: renamed from: e */
    public int f42e;

    /* JADX INFO: renamed from: f */
    public String f43f;

    /* JADX INFO: renamed from: g */
    public boolean f44g;

    /* JADX INFO: renamed from: h */
    public String f45h;

    /* JADX INFO: renamed from: i */
    public long f46i;

    /* JADX INFO: renamed from: j */
    public String f47j;

    /* JADX INFO: renamed from: k */
    public long f48k;

    /* JADX INFO: renamed from: l */
    public long f49l;

    /* JADX INFO: renamed from: m */
    public String f50m;

    /* JADX INFO: renamed from: n */
    public long f51n;

    /* JADX INFO: renamed from: o */
    public int f52o;

    /* JADX INFO: renamed from: p */
    public String f53p;

    /* JADX INFO: renamed from: q */
    public String f54q;

    /* JADX INFO: renamed from: r */
    public long f55r;

    /* JADX INFO: renamed from: s */
    public int f56s;

    public C0009i(int i, long j, String str, String str2) {
        this.f38a = str;
        this.f39b = str2;
        this.f42e = i;
        this.f40c = j;
    }

    /* JADX INFO: renamed from: a */
    public final JSONObject m37a() throws JSONException {
        String str = this.f39b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("syncname", str);
        jSONObject.put("syncpath", str);
        jSONObject.put("ModifiedTime", this.f40c);
        jSONObject.put("IsFolder", "0");
        jSONObject.put("category", "category");
        return jSONObject;
    }

    public final String toString() {
        return "SyncItem - localId : " + this.f39b + ", syncKey : " + this.f38a + ", timeStamp : " + this.f40c + ", deleted : " + this.f42e;
    }
}
