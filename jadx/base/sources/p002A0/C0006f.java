package p002A0;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: A0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0006f {

    /* JADX INFO: renamed from: a */
    public String f23a = "";

    /* JADX INFO: renamed from: b */
    public final ArrayList f24b = new ArrayList();

    /* JADX INFO: renamed from: a */
    public final void m33a(JSONObject jSONObject) {
        try {
            this.f23a = jSONObject.getString("path");
            if (jSONObject.getBoolean("deleted")) {
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("children");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (!jSONObject2.getString("type").equals("folder")) {
                    C0005e c0005e = new C0005e();
                    c0005e.f21a = false;
                    c0005e.f22b = "";
                    c0005e.f21a = jSONObject2.getBoolean("deleted");
                    c0005e.f22b = jSONObject2.getString("path");
                    if (!c0005e.f21a) {
                        this.f24b.add(c0005e);
                    }
                }
            }
        } catch (JSONException e) {
            Debugger.m8611e("OrsPathItem", e);
        }
    }
}
