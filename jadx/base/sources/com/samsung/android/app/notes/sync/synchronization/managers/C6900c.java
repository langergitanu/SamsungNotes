package com.samsung.android.app.notes.sync.synchronization.managers;

import android.content.Context;
import com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a;
import com.samsung.android.app.notes.sync.contentsharing.service.ShareOldService;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.scloud.lib.setting.RPCSettingStatusContract;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p012C1.RunnableC0045a;
import p064P0.C0194a;
import p069Q0.C0206a;
import p069Q0.C0207b;
import p069Q0.C0208c;
import p069Q0.C0209d;
import p069Q0.C0210e;
import p069Q0.C0212g;
import p069Q0.C0213h;
import p069Q0.C0214i;
import p069Q0.C0216k;
import p069Q0.C0217l;
import p079T.AbstractC0299q;
import p090W0.C0330a;
import p183g1.C12013b;
import p186h1.AbstractC12023d;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6900c implements InterfaceC6683a, OnCompletionListener {

    /* JADX INFO: renamed from: a */
    public static C6900c f4468a;

    /* JADX INFO: renamed from: c */
    public static synchronized C6900c m5110c() {
        try {
            if (f4468a == null) {
                f4468a = new C6900c();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4468a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|(11:119|3|(4:6|(2:8|133)(2:9|132)|10|4)|131|17|(1:21)|22|(1:24)|25|(3:27|124|28)(1:36)|(2:117|38))|49|(1:51)|52|(2:55|53)|126|56|(3:58|(2:60|136)(1:135)|65)|134|66|(1:70)|71|(4:73|128|74|75)(1:80)|(2:109|82)|93|94|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x02e3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02e4, code lost:
    
        r1 = r0;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02e8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x02e9, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0330 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x025a A[LOOP:1: B:53:0x0254->B:55:0x025a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x029b A[Catch: all -> 0x02e3, Exception -> 0x02e8, TryCatch #16 {Exception -> 0x02e8, all -> 0x02e3, blocks: (B:56:0x028a, B:58:0x029b, B:60:0x02dd, B:65:0x02eb, B:66:0x02ee, B:68:0x0300, B:70:0x0306, B:71:0x030b, B:73:0x0311), top: B:126:0x028a }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0300 A[Catch: all -> 0x02e3, Exception -> 0x02e8, TryCatch #16 {Exception -> 0x02e8, all -> 0x02e3, blocks: (B:56:0x028a, B:58:0x029b, B:60:0x02dd, B:65:0x02eb, B:66:0x02ee, B:68:0x0300, B:70:0x0306, B:71:0x030b, B:73:0x0311), top: B:126:0x028a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0311 A[Catch: all -> 0x02e3, Exception -> 0x02e8, TRY_LEAVE, TryCatch #16 {Exception -> 0x02e8, all -> 0x02e3, blocks: (B:56:0x028a, B:58:0x029b, B:60:0x02dd, B:65:0x02eb, B:66:0x02ee, B:68:0x0300, B:70:0x0306, B:71:0x030b, B:73:0x0311), top: B:126:0x028a }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x032d  */
    /* JADX WARN: Type inference failed for: r0v44, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m5111a(C0194a param) throws Throwable {
        Throwable th;
        ?? r10;
        FileOutputStream fileOutputStream;
        StringBuilder sb;
        String str;
        Throwable th2;
        FileOutputStream fileOutputStream2;
        StringBuilder sb2;
        int size;
        int i;
        File file;
        FileOutputStream fileOutputStream3;
        Intrinsics.checkNotNullParameter(param, "param");
        ArrayList arrayList = new ArrayList();
        Context context = param.f603a;
        C6903f c6903f = param.f604b;
        String str2 = param.f605c;
        String str3 = C0209d.f640d;
        AbstractC0299q.m643n(str3, "create start");
        AbstractC14517a.m15136U(c6903f, 2);
        StringBuilder sb3 = new StringBuilder();
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        try {
            try {
                JSONArray jSONArray = new JSONArray();
                for (NotesDocumentEntity notesDocumentEntity : notesDocumentRepositoryCreateDocumentDataRepository.getNotesForBackupExceptGenAi()) {
                    JSONObject jSONObject = new JSONObject();
                    String uuid = notesDocumentEntity.getUuid();
                    arrayList.add(uuid);
                    jSONObject.put("uuid", uuid);
                    String filePath = notesDocumentEntity.getFilePath();
                    String strSubstring = filePath.substring(filePath.lastIndexOf(47) + 1);
                    sb3.append(Logger.getEncode(strSubstring));
                    sb3.append(SQLKeyword.COMMA);
                    jSONObject.put(UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, strSubstring);
                    jSONObject.put("timestamp", notesDocumentEntity.getServerTimestamp());
                    jSONObject.put("savedtime", notesDocumentEntity.getLastModifiedAt());
                    jSONObject.put(DBSchema.DocumentPage.FAVORITE, notesDocumentEntity.getIsFavorite() != 0);
                    jSONObject.put("category_uuid", notesDocumentEntity.getCategoryUuid());
                    jSONObject.put("extra_timestamp", notesDocumentEntity.getCategoryServerTimeStamp());
                    jSONObject.put("lockstate", notesDocumentEntity.getIsLock());
                    jSONObject.put("createTime", notesDocumentEntity.getCreatedAt());
                    jSONObject.put("filepath", notesDocumentEntity.getFilePath());
                    jSONObject.put("deleted", notesDocumentEntity.getIsDeleted());
                    jSONObject.put("restorePath", notesDocumentEntity.getAbsolutePath());
                    jSONObject.put(DBSchema.Document.MS_SYNC_ACCOUNT_ID, notesDocumentEntity.getMsSyncAccountId());
                    jSONObject.put("msSyncDocumentId", notesDocumentEntity.getMsSyncDocumentUuid());
                    jSONObject.put(DBSchema.Document.MS_LAST_SYNC_TIME, notesDocumentEntity.getMsLastSyncTime());
                    jSONObject.put("recycle_bin_time_moved", notesDocumentEntity.getRecycleBinTimeMoved());
                    jSONObject.put(DBSchema.Document.MATH_MODE, notesDocumentEntity.getMathMode());
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                AbstractC0299q.m643n(str3, "create JSON FILE INFO size " + jSONArray.length());
                jSONObject2.put("file_info", jSONArray);
                File file2 = new File(str2, "sdoc.list");
                if (file2.exists() && !file2.delete()) {
                    AbstractC0299q.m646q(str3, "create failed to delete sdoc.list file");
                }
                File file3 = new File(str2);
                if (!file3.exists()) {
                    AbstractC0299q.m603M(str3, "create failed to mkdirs directory " + file3.mkdirs());
                }
                if (file2.createNewFile()) {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        fileOutputStream.write(jSONObject2.toString().getBytes(StandardCharsets.UTF_8));
                    } catch (IOException e) {
                        e = e;
                        AbstractC0299q.m646q(str3, "create failed to backupDocInfo " + e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e = e2;
                                sb = new StringBuilder("create exception while closing stream ");
                                AbstractC0000a.m1B(e, sb, str3);
                            }
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        AbstractC0299q.m646q(str3, "create failed to backupDocInfo " + e.getMessage());
                        if (fileOutputStream != null) {
                        }
                    }
                } else {
                    fileOutputStream = null;
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e = e5;
                        sb = new StringBuilder("create exception while closing stream ");
                        AbstractC0000a.m1B(e, sb, str3);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                r10 = str2;
                if (r10 != 0) {
                    throw th;
                }
                try {
                    r10.close();
                    throw th;
                } catch (IOException e6) {
                    AbstractC0000a.m1B(e6, new StringBuilder("create exception while closing stream "), str3);
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            fileOutputStream = null;
            AbstractC0299q.m646q(str3, "create failed to backupDocInfo " + e.getMessage());
            if (fileOutputStream != null) {
            }
            AbstractC14517a.m15136U(c6903f, 4);
            AbstractC0299q.m643n(str3, "create finish");
            if (((Type$Process) c6903f.f4475c) == Type$Process.INSTANT) {
            }
            new C0217l().m496Z(param.f603a, param.f604b, param.f606d);
            FolderManager.getInstance().executeOperation(new RunnableC0045a(new C0207b(), param.f604b, param.f605c));
            new C0210e().m490Z(param.f603a, param.f604b, param.f605c, arrayList);
            Context context2 = param.f603a;
            C6903f c6903f2 = param.f604b;
            String str4 = param.f605c;
            str = C0212g.f643d;
            AbstractC0299q.m643n(str, "create start");
            List<NotesTagEntity> all = NotesDataRepositoryFactory.newInstance(context2).createDocumentTagRepository().getAll();
            AbstractC0299q.m643n(str, "create size " + all.size());
            ArrayList arrayList2 = new ArrayList();
            while (r0.hasNext()) {
            }
            ?? jSONObject3 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            size = arrayList2.size();
            while (i < size) {
            }
            jSONObject3.put("hashtag_info", jSONArray2);
            file = new File(str4, "hashtagNote4.list");
            if (file.exists()) {
                AbstractC0299q.m646q(str, "create failed to delete tag.list file");
            }
            if (file.createNewFile()) {
            }
            if (fileOutputStream3 != null) {
            }
            AbstractC14517a.m15136U(c6903f2, 10);
            AbstractC0299q.m643n(str, "create finish");
            new C0206a().m488Z(param.f603a, param.f604b, param.f605c, arrayList);
            new C0213h().m494Z(param.f603a, param.f604b, param.f605c);
            new C0208c().m489Z(param.f603a, param.f604b, param.f605c, arrayList);
            new C0216k().m495Z(param.f603a, param.f604b, param.f605c);
            String str5 = param.f605c;
            String str6 = C0214i.f645d;
            AbstractC0299q.m643n(str6, "create start");
            AbstractC12023d.m13678a(str5);
            AbstractC0299q.m643n(str6, "create finish");
        } catch (JSONException e8) {
            e = e8;
            fileOutputStream = null;
            AbstractC0299q.m646q(str3, "create failed to backupDocInfo " + e.getMessage());
            if (fileOutputStream != null) {
            }
            AbstractC14517a.m15136U(c6903f, 4);
            AbstractC0299q.m643n(str3, "create finish");
            if (((Type$Process) c6903f.f4475c) == Type$Process.INSTANT) {
            }
            new C0217l().m496Z(param.f603a, param.f604b, param.f606d);
            FolderManager.getInstance().executeOperation(new RunnableC0045a(new C0207b(), param.f604b, param.f605c));
            new C0210e().m490Z(param.f603a, param.f604b, param.f605c, arrayList);
            Context context22 = param.f603a;
            C6903f c6903f22 = param.f604b;
            String str42 = param.f605c;
            str = C0212g.f643d;
            AbstractC0299q.m643n(str, "create start");
            List<NotesTagEntity> all2 = NotesDataRepositoryFactory.newInstance(context22).createDocumentTagRepository().getAll();
            AbstractC0299q.m643n(str, "create size " + all2.size());
            ArrayList arrayList22 = new ArrayList();
            while (r0.hasNext()) {
            }
            ?? jSONObject32 = new JSONObject();
            JSONArray jSONArray22 = new JSONArray();
            size = arrayList22.size();
            while (i < size) {
            }
            jSONObject32.put("hashtag_info", jSONArray22);
            file = new File(str42, "hashtagNote4.list");
            if (file.exists()) {
            }
            if (file.createNewFile()) {
            }
            if (fileOutputStream3 != null) {
            }
            AbstractC14517a.m15136U(c6903f22, 10);
            AbstractC0299q.m643n(str, "create finish");
            new C0206a().m488Z(param.f603a, param.f604b, param.f605c, arrayList);
            new C0213h().m494Z(param.f603a, param.f604b, param.f605c);
            new C0208c().m489Z(param.f603a, param.f604b, param.f605c, arrayList);
            new C0216k().m495Z(param.f603a, param.f604b, param.f605c);
            String str52 = param.f605c;
            String str62 = C0214i.f645d;
            AbstractC0299q.m643n(str62, "create start");
            AbstractC12023d.m13678a(str52);
            AbstractC0299q.m643n(str62, "create finish");
        } catch (Throwable th4) {
            th = th4;
            r10 = 0;
            if (r10 != 0) {
            }
        }
        AbstractC14517a.m15136U(c6903f, 4);
        AbstractC0299q.m643n(str3, "create finish");
        if (((Type$Process) c6903f.f4475c) == Type$Process.INSTANT) {
            AbstractC0299q.m643n(str3, sb3.toString());
        }
        new C0217l().m496Z(param.f603a, param.f604b, param.f606d);
        FolderManager.getInstance().executeOperation(new RunnableC0045a(new C0207b(), param.f604b, param.f605c));
        new C0210e().m490Z(param.f603a, param.f604b, param.f605c, arrayList);
        Context context222 = param.f603a;
        C6903f c6903f222 = param.f604b;
        String str422 = param.f605c;
        str = C0212g.f643d;
        AbstractC0299q.m643n(str, "create start");
        List<NotesTagEntity> all22 = NotesDataRepositoryFactory.newInstance(context222).createDocumentTagRepository().getAll();
        AbstractC0299q.m643n(str, "create size " + all22.size());
        ArrayList arrayList222 = new ArrayList();
        for (NotesTagEntity notesTagEntity : all22) {
            Long id = notesTagEntity.getId();
            String docUuid = notesTagEntity.getDocUuid();
            String displayName = notesTagEntity.getDisplayName();
            arrayList222.add(new C0330a(id, docUuid, displayName, notesTagEntity.getNormalizeName()));
            AbstractC0299q.m643n(str, "create display name " + displayName);
        }
        ?? jSONObject322 = new JSONObject();
        JSONArray jSONArray222 = new JSONArray();
        size = arrayList222.size();
        for (i = 0; i < size; i++) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(RPCSettingStatusContract.Parameter.TAG_ID, ((C0330a) arrayList222.get(i)).f847a);
            jSONObject4.put("doc_uuid", ((C0330a) arrayList222.get(i)).f848b);
            jSONObject4.put("display_name", ((C0330a) arrayList222.get(i)).f849c);
            jSONObject4.put("nomalize_name", ((C0330a) arrayList222.get(i)).f850d);
            jSONArray222.put(jSONObject4);
            if (i % 50 == 0) {
                AbstractC14517a.m15136U(c6903f222, 9);
            }
        }
        jSONObject322.put("hashtag_info", jSONArray222);
        file = new File(str422, "hashtagNote4.list");
        if (file.exists() && !file.delete()) {
            AbstractC0299q.m646q(str, "create failed to delete tag.list file");
        }
        if (file.createNewFile()) {
            FileOutputStream fileOutputStream4 = new FileOutputStream(file);
            try {
                fileOutputStream4.write(jSONObject322.toString().getBytes(StandardCharsets.UTF_8));
                fileOutputStream3 = fileOutputStream4;
            } catch (Exception e9) {
                e = e9;
                fileOutputStream2 = fileOutputStream4;
                try {
                    AbstractC0299q.m646q(str, "create failed to backupHashTagInfo " + e.getMessage());
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e10) {
                            e = e10;
                            sb2 = new StringBuilder("create exception while closing stream ");
                            AbstractC0000a.m1B(e, sb2, str);
                        }
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    if (fileOutputStream2 != null) {
                        throw th2;
                    }
                    try {
                        fileOutputStream2.close();
                        throw th2;
                    } catch (IOException e11) {
                        AbstractC0000a.m1B(e11, new StringBuilder("create exception while closing stream "), str);
                        throw th2;
                    }
                }
            } catch (Throwable th6) {
                th2 = th6;
                fileOutputStream2 = fileOutputStream4;
                if (fileOutputStream2 != null) {
                }
            }
        } else {
            fileOutputStream3 = null;
        }
        if (fileOutputStream3 != null) {
            try {
                fileOutputStream3.close();
            } catch (IOException e12) {
                e = e12;
                sb2 = new StringBuilder("create exception while closing stream ");
                AbstractC0000a.m1B(e, sb2, str);
            }
        }
        AbstractC14517a.m15136U(c6903f222, 10);
        AbstractC0299q.m643n(str, "create finish");
        new C0206a().m488Z(param.f603a, param.f604b, param.f605c, arrayList);
        new C0213h().m494Z(param.f603a, param.f604b, param.f605c);
        new C0208c().m489Z(param.f603a, param.f604b, param.f605c, arrayList);
        new C0216k().m495Z(param.f603a, param.f604b, param.f605c);
        String str522 = param.f605c;
        String str622 = C0214i.f645d;
        AbstractC0299q.m643n(str622, "create start");
        AbstractC12023d.m13678a(str522);
        AbstractC0299q.m643n(str622, "create finish");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a
    /* JADX INFO: renamed from: b */
    public void mo251b(ShareOldService shareOldService) {
        Debugger.m8607d("ShareOldServiceController", "onReady() for stop deleting");
        shareOldService.stopDelete();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
    public void onComplete(Object obj) {
        AbstractC0299q.m643n(C12013b.f8766v, "restoreDoc DataRepositoryScheduler, onComplete");
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
    public void onFail(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        AbstractC0299q.m643n(C12013b.f8766v, "restoreDoc DataRepositoryScheduler, onFail");
    }
}
