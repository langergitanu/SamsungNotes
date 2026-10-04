package p069Q0;

import android.content.Context;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentPageEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentPageRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p002A0.C0001a;
import p079T.AbstractC0299q;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: Q0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0206a extends AbstractC14517a {

    /* JADX INFO: renamed from: d */
    public static final String f637d = "SS$".concat("BookmarkCreator");

    /* JADX INFO: renamed from: Z */
    public final void m488Z(Context context, C6903f c6903f, String str, List list) {
        Throwable th;
        IOException iOException;
        StringBuilder sb;
        String str2 = f637d;
        AbstractC0299q.m643n(str2, "create start");
        NotesDocumentPageRepository notesDocumentPageRepositoryCreateNotesDocumentPageRepository = NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) list).iterator();
        while (it.hasNext()) {
            for (NotesDocumentPageEntity notesDocumentPageEntity : notesDocumentPageRepositoryCreateNotesDocumentPageRepository.getFavoriteList((String) it.next())) {
                C0001a c0001a = new C0001a();
                c0001a.f0a = notesDocumentPageEntity.getId();
                c0001a.f1b = notesDocumentPageEntity.getDocumentUuid();
                c0001a.f2c = notesDocumentPageEntity.getPageUuid();
                c0001a.f3d = notesDocumentPageEntity.getIndex();
                c0001a.f4e = notesDocumentPageEntity.getFavorite();
                c0001a.f5f = notesDocumentPageEntity.getIsDeleted();
                c0001a.f6g = notesDocumentPageEntity.getIsDirty();
                arrayList.add(c0001a);
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    C0001a c0001a2 = (C0001a) arrayList.get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("bookmark_id", c0001a2.f0a);
                    jSONObject2.put("bookmark_doc_uuid", c0001a2.f1b);
                    jSONObject2.put("bookmark_page_uuid", c0001a2.f2c);
                    jSONObject2.put("bookmark_index", c0001a2.f3d);
                    jSONObject2.put("bookmark_favorite", c0001a2.f4e);
                    jSONObject2.put("bookmark_is_deleted", c0001a2.f5f);
                    jSONObject2.put("bookmark_is_dirty", c0001a2.f6g);
                    jSONArray.put(jSONObject2);
                    if (i % 50 == 0) {
                        AbstractC14517a.m15136U(c6903f, 11);
                    }
                }
                jSONObject.put("bookmark_info", jSONArray);
                File file = new File(str, "bookMark.list");
                if (file.exists() && !file.delete()) {
                    AbstractC0299q.m646q(str2, "create failed to delete bookMark.list file");
                }
                if (file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        AbstractC0299q.m646q(str2, "create failed to backupBookmark " + e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                iOException = e2;
                                sb = new StringBuilder("create exception while closing stream ");
                                AbstractC0000a.m1B(iOException, sb, str2);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e3) {
                            AbstractC0000a.m1B(e3, new StringBuilder("create exception while closing stream "), str2);
                            throw th;
                        }
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        iOException = e5;
                        sb = new StringBuilder("create exception while closing stream ");
                        AbstractC0000a.m1B(iOException, sb, str2);
                    }
                }
            } catch (Exception e6) {
                e = e6;
            }
            AbstractC14517a.m15136U(c6903f, 12);
            AbstractC0299q.m643n(str2, "create finish");
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
