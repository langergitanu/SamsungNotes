package p186h1;

import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: h1.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12029j {

    /* JADX INFO: renamed from: a */
    public static final String f8794a = "SS$".concat("RestoreJsonUtils");

    /* JADX INFO: renamed from: a */
    public static void m13710a(String str, ArrayList arrayList) {
        JSONArray jSONArray;
        int length;
        String str2 = f8794a;
        if (TextUtils.isEmpty(str) || arrayList.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                if (jSONObjectM394i != null) {
                    jSONArray = jSONObjectM394i.getJSONArray("file_info");
                    length = jSONArray.length();
                } else {
                    jSONArray = null;
                    length = 0;
                }
                if (length < 1) {
                    AbstractC0299q.m646q(str2, "Size Error.");
                } else {
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        map.put(jSONObject.getString("uuid"), Integer.valueOf(jSONObject.getInt("order")));
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        NotesFolder notesFolder = (NotesFolder) it.next();
                        if (map.containsKey(notesFolder.getUuid())) {
                            notesFolder.setReorder((Integer) map.get(notesFolder.getUuid()));
                            AbstractC0299q.m643n(str2, "restore category order : " + notesFolder.getReorder() + ", uuid : " + notesFolder.getUuid());
                        }
                    }
                }
                fileInputStream.close();
            } finally {
            }
        } catch (Exception e) {
            AbstractC6670b.m4762w(e, new StringBuilder("Failed to restoreCategoryOrder() - "), str2);
        }
    }
}
