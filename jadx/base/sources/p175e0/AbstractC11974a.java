package p175e0;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentTempDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentCoverUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.HashMap;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: e0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC11974a {
    /* JADX INFO: renamed from: a */
    public static String m13539a(DocumentCoverStateTuple documentCoverStateTuple) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DocumentTempDataConstants.KEY_COVER_VERSION, CoverConstants.VERSION);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(DBSchema.DocumentCover.TEMPLATE_UUID, documentCoverStateTuple.getTemplateUuid());
            jSONObject2.put("categoryUUID", documentCoverStateTuple.getCategoryUuid());
            jSONObject2.put("title", documentCoverStateTuple.getTitle());
            jSONObject2.put(DBSchema.DocumentCover.TITLE_ALIGNMENT, documentCoverStateTuple.getTitleAlignment());
            jSONObject2.put(DBSchema.DocumentCover.SUMMARY, documentCoverStateTuple.getSummary());
            jSONObject2.put(DBSchema.DocumentCover.SUMMARY_ALIGNMENT, documentCoverStateTuple.getSummaryAlignment());
            jSONObject2.put("backgroundColor", documentCoverStateTuple.getBackgroundColor());
            jSONObject2.put("createdAt", documentCoverStateTuple.getCreatedAt());
            jSONObject2.put("lastModifiedAt", documentCoverStateTuple.getLastModifiedAt());
            jSONObject2.put("isEnabled", documentCoverStateTuple.getIsEnabled());
            jSONObject.put("document_cover", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("state", documentCoverStateTuple.state);
            jSONObject.put("suggested_cover", jSONObject3);
            return jSONObject.toString();
        } catch (Exception e) {
            AbstractC0000a.m22s("getAiCoverJsonString() : ", e, "WDocAiCover");
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static DocumentCoverStateTuple m13540b(int i, String str, JSONObject jSONObject, HashMap map) {
        try {
            DocumentCoverStateTuple documentCoverStateTuple = new DocumentCoverStateTuple();
            documentCoverStateTuple.setDocUuid(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("document_cover");
            if (i == 0 || !NotesDocumentCoverUtils.isHigherCoverVersion(jSONObject2.getString(DBSchema.DocumentCover.TEMPLATE_UUID))) {
                documentCoverStateTuple.setTemplateUuid(jSONObject2.getString(DBSchema.DocumentCover.TEMPLATE_UUID));
                map.put(DBSchema.DocumentCover.TEMPLATE_UUID, Boolean.TRUE);
            } else {
                map.put(DBSchema.DocumentCover.TEMPLATE_UUID, Boolean.FALSE);
            }
            if (i == 0 || !NotesDocumentCoverUtils.isHigherCoverVersion(jSONObject2.getString("categoryUUID"))) {
                documentCoverStateTuple.setCategoryUuid(jSONObject2.getString("categoryUUID"));
                map.put("categoryUUID", Boolean.TRUE);
            } else {
                map.put("categoryUUID", Boolean.FALSE);
            }
            documentCoverStateTuple.setTitle(jSONObject2.getString("title"));
            documentCoverStateTuple.setTitleAlignment(jSONObject2.getInt(DBSchema.DocumentCover.TITLE_ALIGNMENT));
            documentCoverStateTuple.setSummary(jSONObject2.getString(DBSchema.DocumentCover.SUMMARY));
            documentCoverStateTuple.setSummaryAlignment(jSONObject2.getInt(DBSchema.DocumentCover.SUMMARY_ALIGNMENT));
            if (i == 0 || !NotesDocumentCoverUtils.isHigherCoverVersion(jSONObject2.getString("backgroundColor"))) {
                documentCoverStateTuple.setBackgroundColor(jSONObject2.getString("backgroundColor"));
                map.put("backgroundColor", Boolean.TRUE);
            } else {
                map.put("backgroundColor", Boolean.FALSE);
            }
            documentCoverStateTuple.setCreatedAt(jSONObject2.getLong("createdAt"));
            documentCoverStateTuple.setLastModifiedAt(jSONObject2.getLong("lastModifiedAt"));
            documentCoverStateTuple.setIsEnabled(jSONObject2.getInt("isEnabled"));
            documentCoverStateTuple.state = jSONObject.getJSONObject("suggested_cover").getInt("state");
            return documentCoverStateTuple;
        } catch (Exception e) {
            AbstractC0000a.m22s("[AiCover] getCoverStateTuple() : ", e, "WDocAiCover");
            return null;
        }
    }
}
