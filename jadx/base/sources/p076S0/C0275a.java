package p076S0;

import android.content.Context;
import com.samsung.android.app.notes.sync.migration.common.Type$Flow;
import com.samsung.android.app.notes.sync.migration.provider.BnRDocumentProvider;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p069Q0.C0209d;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: S0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0275a {

    /* JADX INFO: renamed from: c */
    public static final String f722c = "SS$".concat("SnapShotCreator");

    /* JADX INFO: renamed from: d */
    public static String f723d;

    /* JADX INFO: renamed from: a */
    public JSONObject f724a;

    /* JADX INFO: renamed from: b */
    public JSONArray f725b;

    /* JADX INFO: renamed from: a */
    public final void m559a(Context context, C6903f c6903f, String str, String str2, File file, List list) throws Exception {
        String str3 = f722c;
        AbstractC0299q.m643n(str3, "create start");
        this.f724a = new JSONObject();
        this.f725b = new JSONArray();
        f723d = str;
        C0276b c0276b = (C0276b) list.get(0);
        AbstractC0299q.m643n(str3, "createSnapShotFilesData dataPath " + Logger.getEncode(c0276b.f726a));
        String str4 = c0276b.f726a;
        List<File> listExploredFolder = FileUtils.exploredFolder(new File(str4), null, null, false);
        Type$Flow type$Flow = (Type$Flow) c6903f.f4476d;
        if (type$Flow == Type$Flow.BACKUP && listExploredFolder.isEmpty()) {
            throw new Exception("createSnapShotFilesData failed to get exploredFolder");
        }
        for (File file2 : listExploredFolder) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", BnRDocumentProvider.getGrantedSingleDocumentUri(context, file2, f723d).toString());
            jSONObject.put("rPath", file2.getAbsolutePath().replace(str4 + "/", ""));
            jSONObject.put("size", file2.length());
            jSONObject.put("modifiedAt", file2.lastModified());
            this.f725b.put(jSONObject);
        }
        this.f724a.put("files", this.f725b);
        Type$Flow type$Flow2 = Type$Flow.BACKUP;
        if (type$Flow == type$Flow2) {
            String str5 = ((C0276b) list.get(1)).f726a;
            List<File> listExploredFolder2 = FileUtils.exploredFolder(new File(str5), null, null, false);
            if (type$Flow == type$Flow2 && listExploredFolder2.isEmpty()) {
                throw new Exception("createSnapShotNotesData failed to get exploredFolder");
            }
            HashSet hashSet = new HashSet();
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
            String str6 = C0209d.f640d;
            Iterator<NotesDocumentEntity> it = notesDocumentRepositoryCreateDocumentDataRepository.getNotesForBackupExceptGenAi().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getFilePath());
            }
            AbstractC0299q.m643n(str3, "createSnapShotNotesData dataPath/size " + Logger.getEncode(str5) + "/" + hashSet.size());
            for (File file3 : listExploredFolder2) {
                String absolutePath = file3.getAbsolutePath();
                Iterator it2 = hashSet.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        HashSet hashSet2 = hashSet;
                        if (absolutePath.contains((String) it2.next())) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("path", BnRDocumentProvider.getGrantedSingleDocumentUri(context, file3, f723d).toString());
                            jSONObject2.put("rPath", file3.getAbsolutePath().replace(str5 + "/", ""));
                            jSONObject2.put("size", file3.length());
                            jSONObject2.put("modifiedAt", file3.lastModified());
                            this.f725b.put(jSONObject2);
                            hashSet = hashSet2;
                            break;
                        }
                        hashSet = hashSet2;
                    }
                }
            }
            this.f724a.put("files", this.f725b);
        }
        AbstractC0299q.m643n(str3, "createSnapShotRootUri rootUri " + Logger.getEncode(str2));
        this.f724a.put("root", BnRDocumentProvider.getGrantedSingleDocumentUri(context, new File(str2), f723d).toString());
        AbstractC0299q.m643n(str3, "createSnapShotOutput " + Logger.getEncode(file.getAbsolutePath()));
        if (!FileUtils.mkFile(file, this.f724a.toString())) {
            throw new Exception("createSnapShotOutput failed to make snapshot file");
        }
        AbstractC0299q.m643n(str3, "create finish, - " + f723d);
    }
}
