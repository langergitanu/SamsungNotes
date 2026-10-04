package p069Q0;

import android.content.Context;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002A0.C0011k;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: Q0.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0210e extends AbstractC14517a {

    /* JADX INFO: renamed from: d */
    public static final String f641d = "SS$".concat("HashTagCreator");

    /* JADX WARN: Removed duplicated region for block: B:51:0x0163 A[Catch: JSONException -> 0x01d8, IOException -> 0x01da, TryCatch #1 {IOException -> 0x01da, blocks: (B:48:0x014b, B:49:0x015d, B:51:0x0163, B:52:0x0174, B:54:0x017a, B:56:0x01d2, B:62:0x01de, B:63:0x01e6, B:65:0x01f8, B:67:0x01fe, B:68:0x0203, B:81:0x022a), top: B:88:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f8 A[Catch: JSONException -> 0x01d8, IOException -> 0x01da, TryCatch #1 {IOException -> 0x01da, blocks: (B:48:0x014b, B:49:0x015d, B:51:0x0163, B:52:0x0174, B:54:0x017a, B:56:0x01d2, B:62:0x01de, B:63:0x01e6, B:65:0x01f8, B:67:0x01fe, B:68:0x0203, B:81:0x022a), top: B:88:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0209 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m490Z(Context context, C6903f c6903f, String str, List list) {
        File file;
        FileOutputStream fileOutputStream;
        char c;
        String str2 = "tag_uuid";
        String str3 = f641d;
        AbstractC0299q.m643n(str3, "create start");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        List<NotesHashtagEntity> all = NotesDatabaseManager.getInstance().getHashtagDao().getAll();
        if (all != null) {
            int i = 0;
            for (NotesHashtagEntity notesHashtagEntity : all) {
                String uuid = notesHashtagEntity.getUuid();
                String name = notesHashtagEntity.getName();
                boolean z = notesHashtagEntity.getIsDeleted() != 0;
                long jLongValue = notesHashtagEntity.getServerTimestamp().longValue();
                int i2 = i;
                long lastModifiedAt = notesHashtagEntity.getLastModifiedAt();
                C0011k c0011k = new C0011k(uuid, null, name, z, jLongValue, notesHashtagEntity.getExtraInfo());
                c0011k.f65f = lastModifiedAt;
                arrayList.add(c0011k);
                i = i2 + 1;
                if (i2 % 50 == 0) {
                    AbstractC14517a.m15136U(c6903f, 9);
                }
                sb.append(Logger.getEncode(name));
                sb.append(SQLKeyword.COMMA);
            }
            AbstractC0299q.m643n(str3, "createHashTagInfo start");
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    int size = arrayList.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("tag_uuid", ((C0011k) arrayList.get(i4)).f60a);
                        jSONObject2.put("name", ((C0011k) arrayList.get(i4)).f63d);
                        jSONObject2.put("timestamp", ((C0011k) arrayList.get(i4)).f64e);
                        jSONObject2.put("deleted", ((C0011k) arrayList.get(i4)).f62c);
                        jSONObject2.put("extra_info", ((C0011k) arrayList.get(i4)).f66g);
                        jSONArray.put(jSONObject2);
                        if (i4 % 50 == 0) {
                            AbstractC14517a.m15136U(c6903f, 9);
                        }
                    }
                    jSONObject.put("hashtag_info", jSONArray);
                    File file2 = new File(str, "hashtag.list");
                    if (file2.exists() && !file2.delete()) {
                        AbstractC0299q.m646q(str3, "createHashTagInfo failed to delete tag.list file");
                    }
                    if (file2.createNewFile()) {
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                                fileOutputStream.close();
                            } finally {
                            }
                        } catch (IOException unused) {
                            AbstractC0299q.m646q(str3, "create failed to hash tag file");
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    AbstractC6670b.m4762w(e, new StringBuilder("createHashTagInfo failed to backupHashTagInfo "), str3);
                    AbstractC0299q.m643n(str3, "createHashTagInfo finish");
                    AbstractC0299q.m643n(str3, "createHashTagContent start");
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        JSONArray jSONArray2 = new JSONArray();
                        while (r9.hasNext()) {
                        }
                        jSONObject3.put("hashtag_content", jSONArray2);
                        file = new File(str, "hashtagContent.list");
                        if (file.exists()) {
                            AbstractC0299q.m646q(str3, "createHashTagContent failed to delete hashtagContent.list file");
                        }
                        if (file.createNewFile()) {
                        }
                    } catch (IOException e2) {
                        e = e2;
                        AbstractC6670b.m4762w(e, new StringBuilder("createHashTagContent failed to backupHashTagContent "), str3);
                        AbstractC0299q.m643n(str3, "createHashTagContent finish");
                        AbstractC14517a.m15136U(c6903f, 10);
                        AbstractC0299q.m643n(str3, "create finish" + ((Object) sb));
                    }
                    AbstractC0299q.m643n(str3, "createHashTagContent finish");
                    AbstractC14517a.m15136U(c6903f, 10);
                    AbstractC0299q.m643n(str3, "create finish" + ((Object) sb));
                }
            } catch (JSONException e3) {
                e = e3;
                AbstractC6670b.m4762w(e, new StringBuilder("createHashTagInfo failed to backupHashTagInfo "), str3);
                AbstractC0299q.m643n(str3, "createHashTagInfo finish");
                AbstractC0299q.m643n(str3, "createHashTagContent start");
                JSONObject jSONObject32 = new JSONObject();
                JSONArray jSONArray22 = new JSONArray();
                while (r9.hasNext()) {
                }
                jSONObject32.put("hashtag_content", jSONArray22);
                file = new File(str, "hashtagContent.list");
                if (file.exists()) {
                }
                if (file.createNewFile()) {
                }
                AbstractC0299q.m643n(str3, "createHashTagContent finish");
                AbstractC14517a.m15136U(c6903f, 10);
                AbstractC0299q.m643n(str3, "create finish" + ((Object) sb));
            }
            AbstractC0299q.m643n(str3, "createHashTagInfo finish");
            AbstractC0299q.m643n(str3, "createHashTagContent start");
            try {
                JSONObject jSONObject322 = new JSONObject();
                JSONArray jSONArray222 = new JSONArray();
                for (String str4 : (ArrayList) list) {
                    List noteTagUUIDList = C0322h.m670a().f830p.getNoteTagUUIDList(str4);
                    int i5 = 0;
                    while (i5 < noteTagUUIDList.size()) {
                        JSONObject jSONObject4 = new JSONObject();
                        String str5 = (String) noteTagUUIDList.get(i5);
                        jSONObject4.put("uuid", str4);
                        jSONObject4.put(str2, str5);
                        String str6 = str2;
                        jSONObject4.put("tag_extra_info", C0322h.m670a().f830p.getNoteTagExtraInfo(str4, str5));
                        jSONObject4.put("deleted", C0322h.m670a().f830p.getNoteTagDeleted(str4, str5));
                        List list2 = noteTagUUIDList;
                        jSONObject4.put("timestamp", C0322h.m670a().f830p.getNoteTagModifiedTime(str4, str5));
                        jSONObject4.put("extra_timestamp", C0322h.m670a().f830p.getNoteTagServerTimestamp(str4, str5));
                        jSONArray222.put(jSONObject4);
                        if (i5 % 50 == 0) {
                            c = '\t';
                            AbstractC14517a.m15136U(c6903f, 9);
                        } else {
                            c = '\t';
                        }
                        i5++;
                        noteTagUUIDList = list2;
                        str2 = str6;
                    }
                }
                jSONObject322.put("hashtag_content", jSONArray222);
                file = new File(str, "hashtagContent.list");
                if (file.exists() && !file.delete()) {
                    AbstractC0299q.m646q(str3, "createHashTagContent failed to delete hashtagContent.list file");
                }
                if (file.createNewFile()) {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(jSONObject322.toString().getBytes(StandardCharsets.UTF_8));
                            fileOutputStream.close();
                        } finally {
                        }
                    } catch (IOException unused2) {
                        AbstractC0299q.m646q(str3, "create failed to hash tag content file");
                    }
                }
            } catch (JSONException e5) {
                e = e5;
                AbstractC6670b.m4762w(e, new StringBuilder("createHashTagContent failed to backupHashTagContent "), str3);
                AbstractC0299q.m643n(str3, "createHashTagContent finish");
                AbstractC14517a.m15136U(c6903f, 10);
                AbstractC0299q.m643n(str3, "create finish" + ((Object) sb));
            }
            AbstractC0299q.m643n(str3, "createHashTagContent finish");
        }
        AbstractC14517a.m15136U(c6903f, 10);
        AbstractC0299q.m643n(str3, "create finish" + ((Object) sb));
    }
}
