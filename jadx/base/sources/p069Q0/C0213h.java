package p069Q0;

import android.content.Context;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p002A0.C0007g;
import p079T.AbstractC0299q;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: Q0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0213h extends AbstractC14517a {

    /* JADX INFO: renamed from: d */
    public static final String f644d = "SS$".concat("PageTemplateCreator");

    /* JADX INFO: renamed from: a0 */
    public static ArrayList m493a0() {
        AbstractC0299q.m643n(f644d, "createPageTemplateItems start");
        ArrayList arrayList = new ArrayList();
        for (NotesTemplateEntity notesTemplateEntity : NotesDatabaseManager.getInstance().getNotesTemplateDao().getAll()) {
            C0007g c0007g = new C0007g();
            c0007g.f25a = notesTemplateEntity.getUuid();
            c0007g.f26b = notesTemplateEntity.getData();
            c0007g.f27c = notesTemplateEntity.getSize();
            c0007g.f28d = notesTemplateEntity.getDisplayName();
            c0007g.f29e = notesTemplateEntity.getTitle();
            c0007g.f30f = notesTemplateEntity.getCreatedAt();
            c0007g.f31g = notesTemplateEntity.getLastModifiedAt();
            c0007g.f32h = notesTemplateEntity.getMimeType();
            c0007g.f33i = notesTemplateEntity.getWidth();
            c0007g.f34j = notesTemplateEntity.getHeight();
            c0007g.f35k = notesTemplateEntity.getType();
            arrayList.add(c0007g);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m494Z(Context context, C6903f c6903f, String str) {
        IOException e;
        StringBuilder sb;
        String str2 = f644d;
        AbstractC0299q.m643n(str2, "create start");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                for (C0007g c0007g : m493a0()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("page_template_uuid", c0007g.f25a);
                    jSONObject2.put("page_template_data", c0007g.f26b);
                    jSONObject2.put("page_template_size", c0007g.f27c);
                    jSONObject2.put("page_template_display_name", c0007g.f28d);
                    jSONObject2.put("page_template_title", c0007g.f29e);
                    jSONObject2.put("page_template_created_at", c0007g.f30f);
                    jSONObject2.put("page_template_last_modified_at", c0007g.f31g);
                    jSONObject2.put("page_template_mime_type", c0007g.f32h);
                    jSONObject2.put("page_template_width", c0007g.f33i);
                    jSONObject2.put("page_template_height", c0007g.f34j);
                    jSONObject2.put("page_template_type", c0007g.f35k);
                    jSONArray.put(jSONObject2);
                    int i2 = i + 1;
                    if (i % 50 == 0) {
                        AbstractC14517a.m15136U(c6903f, 13);
                    }
                    i = i2;
                }
                jSONObject.put("pageTemplate_info", jSONArray);
                File file = new File(str, "pageTemplate.list");
                if (file.exists() && !file.delete()) {
                    AbstractC0299q.m646q(str2, "create failed to delete pageTemplate.list file");
                }
                if (file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                        fileOutputStream = fileOutputStream2;
                    } catch (IOException e2) {
                        e = e2;
                        Throwable th = e;
                        fileOutputStream = fileOutputStream2;
                        e = th;
                        AbstractC0299q.m646q(str2, "create failed to backupPageTemplate " + e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e = e3;
                                sb = new StringBuilder("create exception while closing stream ");
                                AbstractC0000a.m1B(e, sb, str2);
                            }
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        Throwable th2 = e;
                        fileOutputStream = fileOutputStream2;
                        e = th2;
                        AbstractC0299q.m646q(str2, "create failed to backupPageTemplate " + e.getMessage());
                        if (fileOutputStream != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                AbstractC0000a.m1B(e6, new StringBuilder("create exception while closing stream "), str2);
                            }
                        }
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        e = e7;
                        sb = new StringBuilder("create exception while closing stream ");
                        AbstractC0000a.m1B(e, sb, str2);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e8) {
            e = e8;
        } catch (JSONException e9) {
            e = e9;
        }
        AbstractC14517a.m15136U(c6903f, 14);
        AbstractC0299q.m643n(str2, "create finish");
    }
}
