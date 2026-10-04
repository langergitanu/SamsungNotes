package p002A0;

import java.util.HashMap;

/* JADX INFO: renamed from: A0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0004d {

    /* JADX INFO: renamed from: a */
    public String f16a;

    /* JADX INFO: renamed from: b */
    public final HashMap f17b;

    /* JADX INFO: renamed from: c */
    public final String f18c;

    /* JADX INFO: renamed from: d */
    public final String f19d;

    /* JADX INFO: renamed from: e */
    public boolean f20e;

    public C0004d(String str, String str2, String str3, long j, long j2, long j3) {
        HashMap map = new HashMap();
        this.f17b = map;
        map.put("uuid", str2);
        map.put("lastModifiedAt", Long.valueOf(j));
        map.put("createdAt", Long.valueOf(j2));
        map.put("DoclastModifiedAt", Long.valueOf(j3));
        this.f18c = str;
        this.f19d = str3;
    }

    /* JADX INFO: renamed from: a */
    public final long m31a() {
        HashMap map = this.f17b;
        if (map.containsKey("lastModifiedAt")) {
            return ((Long) map.get("lastModifiedAt")).longValue();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: b */
    public final String m32b() {
        HashMap map = this.f17b;
        if (map.containsKey("uuid")) {
            return map.get("uuid").toString();
        }
        return null;
    }
}
