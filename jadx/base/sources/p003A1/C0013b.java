package p003A1;

import android.content.Context;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002A0.C0009i;
import p022E1.AbstractC0078d;
import p042J1.C0145c;
import p079T.AbstractC0299q;
import p086V.C0322h;

/* JADX INFO: renamed from: A1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0013b extends AbstractC0078d {

    /* JADX INFO: renamed from: b */
    public final C0012a f85b;

    public C0013b(C0012a c0012a) {
        super(c0012a);
        this.f85b = c0012a;
    }

    /* JADX INFO: renamed from: g */
    public static ArrayList m41g(ArrayList arrayList) throws JSONException {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            JSONArray jSONArray = ((JSONObject) it.next()).getJSONArray("snote_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.has("filepath")) {
                    Debugger.m8609e("SyncOldNote$SyncOperationSDoc", "getServerSDocArray : no filepath!");
                } else if (jSONObject.getString("filepath").endsWith(".sdoc")) {
                    C0009i c0009i = new C0009i();
                    c0009i.f38a = jSONObject.getString("datakey");
                    c0009i.f39b = jSONObject.getString("filepath");
                    c0009i.f42e = jSONObject.getBoolean("deleted") ? 1 : 0;
                    c0009i.f40c = jSONObject.getLong("clientTimestamp");
                    arrayList2.add(c0009i);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: d */
    public final void m42d() {
        Context context = this.f85b.f262e;
        long j = Long.parseLong("1464416139847");
        AbstractC0299q.m616Z(j);
        C0145c.m310R("CategoryLastSyncTime", "CategoryLastSyncTimeKey", Long.toString(j));
        C0145c.m310R("TagLastSyncTime", "TagLastSyncTimeKey", Long.toString(j));
        C0145c.m304L("CategoryOrderTime", "CategoryOrderDirtyKey", true);
        List<String> uUIDList = C0322h.m670a().f831q.getUUIDList(context);
        if (uUIDList != null && !uUIDList.isEmpty()) {
            for (String str : uUIDList) {
                C0322h.m670a().f831q.setNoteDirty(context, str, C0322h.m670a().f831q.getSdocContractYes());
                C0322h.m670a().f829o.setNoteCategoryDirty(context, str, C0322h.m670a().f831q.getSdocContractYes());
            }
        }
        List categoryUUIDList = C0322h.m670a().f829o.getCategoryUUIDList(context);
        if (categoryUUIDList != null && !categoryUUIDList.isEmpty()) {
            Iterator it = categoryUUIDList.iterator();
            while (it.hasNext()) {
                C0322h.m670a().f829o.setCategoryDirty(context, (String) it.next(), C0322h.m670a().f831q.getSdocContractYes());
            }
        }
        List tagUUIDList = C0322h.m670a().f830p.getTagUUIDList();
        if (tagUUIDList != null && !tagUUIDList.isEmpty()) {
            Iterator it2 = tagUUIDList.iterator();
            while (it2.hasNext()) {
                C0322h.m670a().f830p.setTagDirty((String) it2.next(), C0322h.m670a().f831q.getSdocContractYes());
            }
        }
        C0145c.m308P(0L, "SyncSuccessTime", "SyncSuccessTimeKey");
    }

    /* JADX INFO: renamed from: e */
    public final boolean m43e(String str) throws SyncException {
        Debugger.m8607d("SyncOldNote$SyncOperationSDoc", "existsMetaFileInServer() start");
        try {
            Iterator it = AbstractC6848m.m5010c(this.f85b.f69j, null, true).iterator();
            while (true) {
                if (!it.hasNext()) {
                    Debugger.m8607d("SyncOldNote$SyncOperationSDoc", "existsMetaFileInServer() finish");
                    return false;
                }
                JSONArray jSONArray = ((JSONObject) it.next()).getJSONArray("snote_list");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (!jSONObject.has("filepath")) {
                        Debugger.m8609e("SyncOldNote$SyncOperationSDoc", "existsMetaFileInServer : no filepath!");
                    } else if (jSONObject.getString("filepath").startsWith(str)) {
                        if (!jSONObject.has("deleted")) {
                            Debugger.m8607d("SyncOldNote$SyncOperationSDoc", "existsMetaFileInServer : bingo!!");
                            return true;
                        }
                        if (!jSONObject.getBoolean("deleted")) {
                            Debugger.m8607d("SyncOldNote$SyncOperationSDoc", "existsMetaFileInServer : bingo!");
                            return true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            String str2 = "existsMetaFileInServer - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncOperationSDoc", str2);
            throw new SyncException(303, str2);
        } catch (JSONException e2) {
            String str3 = "existsMetaFileInServer - " + e2.getMessage();
            Debugger.m8609e("SyncOldNote$SyncOperationSDoc", str3);
            throw new SyncException(304, str3);
        }
    }

    /* JADX INFO: renamed from: f */
    public final ArrayList m44f() throws SyncException {
        long jMin = Math.min(Long.parseLong(C0145c.m331p("CategoryLastSyncTime", "CategoryLastSyncTimeKey", "1464416139847")), AbstractC0299q.m593C());
        long j = Long.parseLong(C0145c.m331p("TagLastSyncTime", "TagLastSyncTimeKey", "1464416139847"));
        if (j < jMin) {
            jMin = j;
        }
        try {
            return AbstractC6848m.m5010c(this.f85b.f69j, Long.toString(jMin), false);
        } catch (IOException e) {
            String str = "getServerListArray - downloadList - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncOperationSDoc", str);
            throw new SyncException(303, str);
        }
    }
}
