package p069Q0;

import android.content.Context;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p079T.AbstractC0299q;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: Q0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0208c extends AbstractC14517a {

    /* JADX INFO: renamed from: d */
    public static final String f639d = "SS$".concat("CoverCreator");

    /* JADX INFO: renamed from: Z */
    public final void m489Z(Context context, C6903f c6903f, String str, List list) {
        String str2 = f639d;
        AbstractC0299q.m643n(str2, "create start " + str);
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayList = (ArrayList) list;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    DocumentCoverStateTuple coverStateTuple = new NotesDocumentCoverRepository().getCoverStateTuple((String) arrayList.get(i));
                    if (coverStateTuple != null) {
                        AbstractC0299q.m603M(str2, "create, coverStateTuple: " + coverStateTuple);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("documentUUID", coverStateTuple.getDocUuid());
                        jSONObject2.put(DBSchema.DocumentCover.TEMPLATE_UUID, coverStateTuple.getTemplateUuid());
                        jSONObject2.put("title", coverStateTuple.getTitle());
                        jSONObject2.put(DBSchema.DocumentCover.TITLE_ALIGNMENT, coverStateTuple.getTitleAlignment());
                        jSONObject2.put(DBSchema.DocumentCover.SUMMARY, coverStateTuple.getSummary());
                        jSONObject2.put(DBSchema.DocumentCover.SUMMARY_ALIGNMENT, coverStateTuple.getSummaryAlignment());
                        jSONObject2.put("categoryUUID", coverStateTuple.getCategoryUuid());
                        jSONObject2.put("backgroundColor", coverStateTuple.getBackgroundColor());
                        jSONObject2.put("createdAt", coverStateTuple.getCreatedAt());
                        jSONObject2.put("lastModifiedAt", coverStateTuple.getLastModifiedAt());
                        jSONObject2.put("isEnabled", coverStateTuple.getIsEnabled());
                        jSONArray.put(jSONObject2);
                        if (i % 50 == 0) {
                            AbstractC14517a.m15136U(c6903f, 15);
                        }
                    }
                }
                jSONObject.put("cover_version", CoverConstants.VERSION);
                jSONObject.put("cover_info", jSONArray);
                File file = new File(str, "cover.list");
                if (file.exists() && !file.delete()) {
                    AbstractC0299q.m646q(str2, "create failed to delete cover.list file");
                }
                if (file.createNewFile()) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (IOException unused) {
                        AbstractC0299q.m646q(str2, "create failed to write cover file");
                    }
                }
            } catch (IOException e) {
                e = e;
                AbstractC6670b.m4762w(e, new StringBuilder("create failed to cover "), str2);
                AbstractC14517a.m15136U(c6903f, 16);
                AbstractC0299q.m643n(str2, "create finish");
            }
        } catch (JSONException e2) {
            e = e2;
            AbstractC6670b.m4762w(e, new StringBuilder("create failed to cover "), str2);
            AbstractC14517a.m15136U(c6903f, 16);
            AbstractC0299q.m643n(str2, "create finish");
        }
        AbstractC14517a.m15136U(c6903f, 16);
        AbstractC0299q.m643n(str2, "create finish");
    }
}
