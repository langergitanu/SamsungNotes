package com.samsung.android.app.notes.sync.synchronization.managers;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.credentials.playservices.C2517b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C4512a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.migration.common.Type$Flow;
import com.samsung.android.app.notes.sync.migration.common.Type$Interface;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.push.base.ActivateSCloudTask;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocCategoryResolverContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocResolverContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang3.C13883h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p002A0.C0002b;
import p003A1.C0012a;
import p003A1.C0013b;
import p007B0.C0019b;
import p007B0.C0023f;
import p020E.C0073a;
import p022E1.AbstractC0078d;
import p022E1.C0077c;
import p025F0.AbstractC0089d;
import p025F0.C0094i;
import p026F1.C0097a;
import p033H0.C0111a;
import p033H0.C0112b;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p084U0.C0312d;
import p086V.C0322h;
import p173d0.C11971a;
import p182g0.AbstractC11999i;
import p182g0.C11991a;
import p182g0.C11992b;
import p182g0.C12011u;
import p185h0.InterfaceC12018c;
import p191j0.AbstractC12916b;
import p195k1.C12969a;
import p202m1.C13526a;
import p202m1.C13527b;
import p207n1.C13541h;
import p212o1.C13573a;
import p234q1.C14433b;
import p253w1.InterfaceC14510a;
import p259y0.AbstractC14517a;
import p261z1.C14520a;
import p261z1.C14521b;
import p261z1.C14522c;
import p261z1.C14523d;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6903f implements InterfaceC0122a, OnCompletionListener, IAuthorizationListener {

    /* JADX INFO: renamed from: e */
    public static C6903f f4472e;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4473a;

    /* JADX INFO: renamed from: b */
    public Object f4474b;

    /* JADX INFO: renamed from: c */
    public Object f4475c;

    /* JADX INFO: renamed from: d */
    public Object f4476d;

    public /* synthetic */ C6903f(int i, boolean z) {
        this.f4473a = i;
    }

    /* JADX INFO: renamed from: a */
    public static void m5117a(C6903f c6903f, CompletableFuture completableFuture, String str) {
        MSLogger.m8636w("CreateNote", str.concat(", future complete"));
        completableFuture.complete(0);
    }

    /* JADX INFO: renamed from: b */
    public static HashMap m5118b(C11971a c11971a) {
        HashMap map = new HashMap();
        for (C12011u c12011u : c11971a.f8524h) {
            map.put(c12011u.f8744e, c12011u);
            for (C11992b c11992b : c12011u.f8761v) {
                map.put(c11992b.f8628g, c11992b);
                for (AbstractC12916b abstractC12916b : c11992b.f8631j) {
                    map.put(abstractC12916b.mo13811k(), abstractC12916b);
                }
            }
        }
        for (AbstractC12916b abstractC12916b2 : c11971a.f8522f.f8692l0) {
            map.put(abstractC12916b2.mo13811k(), abstractC12916b2);
        }
        return map;
    }

    /* JADX INFO: renamed from: c */
    public static synchronized C6903f m5119c() {
        try {
            if (f4472e == null) {
                f4472e = new C6903f(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4472e;
    }

    /* JADX INFO: renamed from: e */
    public static C6903f m5120e(String str) {
        C6903f c6903f = new C6903f(10);
        try {
            c6903f.f4476d = new HashMap();
            for (String str2 : str.split(";")) {
                if (str2.contains(MarketingConstants.REFERRER_DELIMITER_U003D)) {
                    ((Map) c6903f.f4476d).put(str2.substring(0, str2.indexOf(61)).trim(), str2.substring(str2.indexOf(61) + 1).trim().replace("\"", ""));
                } else {
                    c6903f.f4475c = str2.trim();
                }
            }
            return c6903f;
        } catch (Exception unused) {
            Debugger.m8609e("SyncHttpResponse", "failed to parseLine " + str);
            return c6903f;
        }
    }

    /* JADX INFO: renamed from: n */
    public static void m5121n(CompletableFuture completableFuture, String str) throws ExecutionException, InterruptedException, TimeoutException {
        MSLogger.m8636w("CreateNote", str.concat(", future get"));
        completableFuture.get(600000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: d */
    public void m5122d(long j) throws SyncException {
        C0012a c0012a = (C0012a) this.f4474b;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            List categoryUUIDListByDeleted = C0322h.m670a().f829o.getCategoryUUIDListByDeleted(c0012a.f262e, false);
            if (categoryUUIDListByDeleted == null) {
                Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "Failed to getCategoryUUIDListByDeleted");
                throw new SyncException(314, "Failed to getCategoryUUIDListByDeleted");
            }
            int size = categoryUUIDListByDeleted.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject2 = new JSONObject();
                String str = (String) categoryUUIDListByDeleted.get(i);
                int categoryOrder = C0322h.m670a().f829o.getCategoryOrder(c0012a.f262e, str);
                jSONObject2.put("uuid", str);
                jSONObject2.put("order", categoryOrder);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("file_info", jSONArray);
            jSONObject.put("order_time", j);
            String str2 = ((String) this.f4476d) + "category_order.cot";
            String str3 = str2 + ".json";
            File file = new File(str3);
            if (file.exists() && !file.delete()) {
                Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "failed to delete makeOrderJSON");
            }
            if (!file.createNewFile()) {
                Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "Failed to create makeOrderJSON");
                throw new SyncException(312, "Failed to create makeOrderJSON");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                fileOutputStream.close();
                C0322h.m670a().f816b.zip(str3, str2);
                if (file.delete()) {
                    return;
                }
                Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "failed to delete makeOrderJSON");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            String str4 = "Failed to makeFileInfoJSON() - " + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str4);
            throw new SyncException(312, str4);
        } catch (JSONException e2) {
            String str5 = "Failed to makeFileInfoJSON() - " + e2.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str5);
            throw new SyncException(304, str5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:251:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02c2  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int m5123f() throws Throwable {
        int i;
        long j;
        C0013b c0013b;
        InterfaceC14510a interfaceC14510a;
        File file;
        File file2;
        long j2;
        Throwable th;
        ?? r10;
        Object obj;
        long j3;
        long j5;
        List uUIDListByCategoryDirty;
        int i2;
        boolean zM323h;
        boolean z;
        Iterator it;
        boolean z2;
        Debugger.m8615i("SyncOldNote", "Start syncOldNote : SyncMsgType = " + ((C0012a) this.f4474b).f264g.f322a);
        String strM14294h = C13541h.m14287e().m14294h();
        if (TextUtils.isEmpty(strM14294h)) {
            Debugger.m8609e("SyncOldNote", "accountGuidHash is null");
            return -1;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C0012a c0012a = (C0012a) this.f4474b;
        ((C0013b) this.f4475c).getClass();
        c0012a.f263f = AbstractC0078d.m215b();
        ((C0013b) this.f4475c).getClass();
        if (Long.parseLong(C0145c.m331p("CategoryLastSyncTime", "CategoryLastSyncTimeKey", "1464416139847")) < 0) {
            Debugger.m8615i("SyncOldNote$SyncOperationSDoc", "LastSyncTimeForCategory is minus");
            C0145c.m310R("CategoryLastSyncTime", "CategoryLastSyncTimeKey", Long.toString(Long.parseLong("1464416139847")));
        }
        if (Long.parseLong(C0145c.m331p("TagLastSyncTime", "TagLastSyncTimeKey", "1464416139847")) < 0) {
            Debugger.m8615i("SyncOldNote$SyncOperationSDoc", "LastSyncTimeForTag is minus");
            C0145c.m310R("TagLastSyncTime", "TagLastSyncTimeKey", Long.toString(Long.parseLong("1464416139847")));
        }
        if (AbstractC0299q.m593C() < 0) {
            Debugger.m8615i("SyncOldNote$SyncOperationSDoc", "LastSyncTimeForSDoc is minus");
            AbstractC0299q.m616Z(Long.parseLong("1464416139847"));
        }
        C0013b c0013b2 = (C0013b) this.f4475c;
        c0013b2.getClass();
        String strM331p = C0145c.m331p("AccountGuid", "AccountGuidKey", null);
        if (!TextUtils.isEmpty(strM331p) && strM331p.length() != 64) {
            strM331p = HashUtils.generateSha256(strM331p);
        }
        if (!strM14294h.equals(strM331p)) {
            Debugger.m8614f("SyncOldNote$SyncOperationSDoc", "Account changed!");
            c0013b2.m42d();
            C0145c.m310R("AccountGuid", "AccountGuidKey", strM14294h);
        }
        ((C0013b) this.f4475c).getClass();
        AbstractC0078d.m214a();
        C0013b c0013b3 = (C0013b) this.f4475c;
        c0013b3.getClass();
        Debugger.m8607d("SyncOldNote$SyncOperationSDoc", "checkLockedNotes()");
        C0012a c0012a2 = c0013b3.f85b;
        boolean z3 = false;
        boolean z4 = true;
        if (new SDocLocker(c0012a2.f262e).is64bitCodeAvailable()) {
            i = -1;
            if (!C0145c.m323h("CheckLockedNotes", "CheckLockedNotesFinishedKey", false)) {
                j = 1;
                try {
                    List uUIDListByLocked = C0322h.m670a().f831q.getUUIDListByLocked(c0012a2.f262e, true);
                    Debugger.m8615i("SyncOldNote$SyncOperationSDoc", "checkLockedNotes() : uuidList = " + uUIDListByLocked.size());
                    if (!uUIDListByLocked.isEmpty()) {
                        Iterator it2 = uUIDListByLocked.iterator();
                        while (it2.hasNext()) {
                            String str = (String) it2.next();
                            if (C0145c.m323h("CheckLockedNotes", str, z3)) {
                                it = it2;
                            } else {
                                C6748q c6748q = str != null ? new C6748q(c0012a2.f262e, str) : null;
                                NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
                                String filePath = notesDocumentEntity != null ? notesDocumentEntity.getFilePath() : null;
                                if (SpenSDocFile.convertTo32bitEncryption(filePath, new SDocLocker(c0012a2.f262e).getUserCode())) {
                                    C0322h.m670a().f831q.convertTo32bitEncrypt(c0012a2.f262e, str);
                                    it = it2;
                                    z2 = z4;
                                } else {
                                    long modifiedTime = SpenSDocFile.getModifiedTime(filePath, z3);
                                    if (SpenSDocFile.updateModifiedTime(filePath, new SDocLocker(c0012a2.f262e).getUserCode())) {
                                        long modifiedTime2 = SpenSDocFile.getModifiedTime(filePath, z3);
                                        NotesDocumentEntity notesDocumentEntity2 = c6748q.f4128a;
                                        long jLongValue = notesDocumentEntity2 != null ? notesDocumentEntity2.getServerTimestamp().longValue() : 0L;
                                        StringBuilder sb = new StringBuilder();
                                        it = it2;
                                        sb.append("time gap = ");
                                        sb.append(modifiedTime2 - modifiedTime);
                                        sb.append(" , timeFromDb = ");
                                        sb.append(jLongValue);
                                        Debugger.m8615i("SyncOldNote$SyncOperationSDoc", sb.toString());
                                        C0322h.m670a().f831q.setNoteServerTimeAndDirty(c0012a2.f262e, str, jLongValue + 1, C0322h.m670a().f831q.getSdocContractYes());
                                        str = str;
                                    } else {
                                        it = it2;
                                    }
                                    z2 = true;
                                }
                                C0145c.m304L("CheckLockedNotes", str, z2);
                            }
                            it2 = it;
                            z3 = false;
                            z4 = true;
                        }
                    }
                    Debugger.m8615i("SyncOldNote$SyncOperationSDoc", "Succeed to Check the locked notes");
                    C0145c.m304L("CheckLockedNotes", "CheckLockedNotesFinishedKey", true);
                } catch (Exception unused) {
                    Debugger.m8609e("SyncOldNote$SyncOperationSDoc", "Failed to Check the locked notes");
                }
            }
            AbstractC0153k.m375d("Password");
            C0012a c0012a3 = (C0012a) this.f4474b;
            c0013b = (C0013b) this.f4475c;
            interfaceC14510a = (InterfaceC14510a) this.f4476d;
            C0023f c0023f = new C0023f();
            c0023f.f127c = c0012a3;
            c0012a3.getClass();
            c0023f.f125a = C0012a.m39b();
            c0023f.f126b = false;
            StringBuilder sb2 = new StringBuilder();
            String str2 = c0023f.f125a;
            String strM1170p = AbstractC0622a.m1170p(str2, SettingsConstants.LOCK_SETTINGS_BACKUP_FILE_NAME, sb2);
            file = new File(strM1170p);
            if (file.exists() && !file.delete()) {
                Debugger.m8609e("SyncOldNote$SyncServerPassword", "Failed to delete1");
            }
            String strM756B = AbstractC0541b.m756B(str2, "content.sync");
            file2 = new File(strM756B);
            if (file2.exists() && !file2.delete()) {
                Debugger.m8609e("SyncOldNote$SyncServerPassword", "Failed to delete2");
            }
            if (c0013b.m43e(SettingsConstants.LOCK_SETTINGS_BACKUP_FILE_NAME)) {
                j2 = jElapsedRealtime;
                Debugger.m8615i("SyncOldNote$SyncServerPassword", "There is no p!");
                c0023f.f126b = true;
            } else {
                Debugger.m8615i("SyncOldNote$SyncServerPassword", "There is p!");
                j2 = jElapsedRealtime;
                AbstractC6848m.m5009b(c0012a3.f69j, "server_password", str2);
            }
            if (interfaceC14510a.isCancelled()) {
                try {
                    if (file2.exists()) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(strM756B);
                            try {
                                JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                                if (jSONObjectM394i == null) {
                                    Debugger.m8609e("SyncOldNote$SyncServerPassword", "json obj is null");
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        Debugger.m8609e("SyncOldNote$SyncServerPassword", "InputStream close - Exception = " + e);
                                    }
                                } else {
                                    obj = SettingsConstants.LOCK_SETTINGS_BACKUP_FILE_NAME;
                                    long jM328m = C0145c.m328m(0L, "serverPassword", "serverPasswordKey");
                                    long j6 = jSONObjectM394i.getLong("ModifiedTime");
                                    if (c0013b.m216c() || j6 > jM328m) {
                                        c0023f.m46a(strM1170p, j6);
                                    } else if (j6 < jM328m) {
                                        c0023f.f126b = true;
                                    }
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        Debugger.m8609e("SyncOldNote$SyncServerPassword", "InputStream close - Exception = " + e2);
                                    }
                                }
                            } catch (FileNotFoundException e3) {
                                e = e3;
                                String str3 = "Failed to getJSONObject - " + e.getMessage();
                                Debugger.m8609e("SyncOldNote$SyncServerPassword", str3);
                                throw new SyncException(319, str3);
                            } catch (IOException e5) {
                                e = e5;
                                String str4 = "Failed to getJSONObject - " + e.getMessage();
                                Debugger.m8609e("SyncOldNote$SyncServerPassword", str4);
                                throw new SyncException(312, str4);
                            } catch (JSONException e6) {
                                e = e6;
                                String str5 = "Failed to getJSONObject - " + e.getMessage();
                                Debugger.m8609e("SyncOldNote$SyncServerPassword", str5);
                                throw new SyncException(304, str5);
                            } catch (Throwable th2) {
                                th = th2;
                                r10 = fileInputStream;
                                if (r10 == 0) {
                                    throw th;
                                }
                                try {
                                    r10.close();
                                    throw th;
                                } catch (IOException e7) {
                                    Debugger.m8609e("SyncOldNote$SyncServerPassword", "InputStream close - Exception = " + e7);
                                    throw th;
                                }
                            }
                        } catch (FileNotFoundException e8) {
                            e = e8;
                        } catch (IOException e9) {
                            e = e9;
                        } catch (JSONException e10) {
                            e = e10;
                        } catch (Throwable th3) {
                            th = th3;
                            r10 = 0;
                        }
                    } else {
                        obj = SettingsConstants.LOCK_SETTINGS_BACKUP_FILE_NAME;
                    }
                    if (c0023f.f126b && !c0013b.m216c()) {
                        C0158a.m407a().getClass();
                        if (!C0158a.m410f() && C0322h.m670a().f826l.isSetPassword(c0012a3.f262e)) {
                            String strBackupSettings = C0322h.m670a().f826l.backupSettings(c0012a3.f262e);
                            if (strBackupSettings == null) {
                                Debugger.m8609e("SyncOldNote$SyncServerPassword", "Failed to bs");
                                throw new SyncException(312, "Failed to bs");
                            }
                            if (AbstractC2322a.m1607A(strBackupSettings)) {
                                Debugger.m8615i("SyncOldNote$SyncServerPassword", "Need to uploadServer");
                                try {
                                    long jM328m2 = C0145c.m328m(0L, "serverPassword", "serverPasswordKey");
                                    if (jM328m2 != 0) {
                                        C0322h.m670a().f831q.getSdocContractNo();
                                        JSONObject jSONObject = new JSONObject();
                                        Object obj2 = obj;
                                        jSONObject.put("syncname", obj2);
                                        jSONObject.put("syncpath", obj2);
                                        jSONObject.put("ModifiedTime", jM328m2);
                                        jSONObject.put("IsFolder", "0");
                                        jSONObject.put("category", "category");
                                        if (interfaceC14510a.isCancelled()) {
                                            Debugger.m8607d("SyncOldNote$SyncServerPassword", "Cancelled uploadServerPasswordInfo");
                                        } else {
                                            AbstractC6848m.m5014g(c0012a3.f69j, strBackupSettings, "server_password", Long.toString(jM328m2), jSONObject, new C11253j(c0023f, 26));
                                        }
                                    }
                                } catch (SyncException e11) {
                                    Debugger.m8609e("SyncOldNote$SyncServerPassword", "Failed to upload p file");
                                    throw e11;
                                } catch (JSONException unused2) {
                                    Debugger.m8609e("SyncOldNote$SyncServerPassword", "Failed to make json");
                                    throw new SyncException(304, "Failed to upload category");
                                }
                            }
                        }
                    }
                    C0012a c0012a4 = (C0012a) this.f4474b;
                    int i4 = c0012a4.f264g.f322a;
                    if ((i4 & 8192) == 8192 || i4 == 64 || i4 == 32) {
                        zM323h = true;
                        i2 = 0;
                    } else {
                        if ((i4 & 4) == 4) {
                            C0145c.m304L("SDocServerPush", "SDocServerPushKey", true);
                        } else {
                            Context context = c0012a4.f262e;
                            if (context == null) {
                                Debugger.m8609e("SyncSettingsUtil", "getLastOldSyncErrorTime() : context is null!");
                                j5 = j;
                                j3 = 0;
                            } else {
                                j3 = 0;
                                j5 = context.getSharedPreferences("Settings", 0).getLong(SettingsConstants.SETTINGS_LAST_OLD_SYNC_ERROR_TIME, 0L);
                                Debugger.m8607d("SyncSettingsUtil", "SETTINGS_LAST_SYNC_ERROR_TIME is " + j5);
                            }
                            if (j5 != j3) {
                                long currentTime = (TimeManager.getCurrentTime(c0012a4.f262e) - j5) / 1000;
                                if (currentTime <= 600 && currentTime >= j3) {
                                    Debugger.m8615i("SyncOldNote", "isOldNoteSyncNeeded() : false due to timeDifferenceSec = " + currentTime);
                                    zM323h = false;
                                }
                                i2 = 0;
                            } else {
                                SDocResolverContractImpl sDocResolverContractImpl = C0322h.m670a().f831q;
                                Context context2 = c0012a4.f262e;
                                List uUIDListByDirty = sDocResolverContractImpl.getUUIDListByDirty(context2, C0322h.m670a().f831q.getSdocContractYes());
                                c0012a4.f81v = uUIDListByDirty;
                                if (uUIDListByDirty == null || uUIDListByDirty.isEmpty()) {
                                    List tagUUIDListByDirty = C0322h.m670a().f830p.getTagUUIDListByDirty(C0322h.m670a().f831q.getSdocContractYes());
                                    c0012a4.f82w = tagUUIDListByDirty;
                                    if ((tagUUIDListByDirty == null || tagUUIDListByDirty.isEmpty()) && !C0145c.m323h("CategoryOrderTime", "CategoryOrderDirtyKey", false)) {
                                        List categoryUUIDListByDirty = C0322h.m670a().f829o.getCategoryUUIDListByDirty(context2, C0322h.m670a().f831q.getSdocContractYes());
                                        c0012a4.f83x = categoryUUIDListByDirty;
                                        if ((categoryUUIDListByDirty == null || categoryUUIDListByDirty.isEmpty()) && ((uUIDListByCategoryDirty = C0322h.m670a().f831q.getUUIDListByCategoryDirty(context2, C0322h.m670a().f831q.getSdocContractYes())) == null || uUIDListByCategoryDirty.isEmpty())) {
                                            List uUIDListByDirtyForExtraInfo = C0322h.m670a().f831q.getUUIDListByDirtyForExtraInfo(context2, C0322h.m670a().f831q.getSdocContractYes());
                                            c0012a4.f84y = uUIDListByDirtyForExtraInfo;
                                            if (uUIDListByDirtyForExtraInfo == null || uUIDListByDirtyForExtraInfo.isEmpty()) {
                                                long currentTime2 = (TimeManager.getCurrentTime(c0012a4.f262e) - AbstractC0299q.m593C()) / 1000;
                                                if (currentTime2 > 3600 || currentTime2 < 0) {
                                                    i2 = 0;
                                                    zM323h = true;
                                                } else {
                                                    i2 = 0;
                                                    zM323h = C0145c.m323h("SDocServerPush", "SDocServerPushKey", false);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        zM323h = true;
                        i2 = 0;
                    }
                    if (!zM323h) {
                        Debugger.m8615i("SyncOldNote", "Don't need SyncOldNote!");
                        return i2;
                    }
                    C0013b c0013b4 = (C0013b) this.f4475c;
                    while (true) {
                        try {
                            ((C0012a) this.f4474b).f80u = c0013b4.m44f();
                            C0012a c0012a5 = (C0012a) this.f4474b;
                            c0012a5.f83x = null;
                            c0012a5.f82w = null;
                            c0012a5.f81v = null;
                            if (!c0012a5.f80u.isEmpty() || Long.parseLong(C0145c.m331p("CategoryLastSyncTime", "CategoryLastSyncTimeKey", "1464416139847")) > AbstractC0299q.m593C() || C0145c.m323h("CategoryOrderTime", "CategoryOrderDirtyKey", false)) {
                                z = true;
                            } else {
                                List categoryUUIDListByDirty2 = C0322h.m670a().f829o.getCategoryUUIDListByDirty(c0012a5.f262e, C0322h.m670a().f831q.getSdocContractYes());
                                c0012a5.f83x = categoryUUIDListByDirty2;
                                if (categoryUUIDListByDirty2 != null && categoryUUIDListByDirty2.isEmpty()) {
                                    List tagUUIDListByDirty2 = C0322h.m670a().f830p.getTagUUIDListByDirty(C0322h.m670a().f831q.getSdocContractYes());
                                    c0012a5.f82w = tagUUIDListByDirty2;
                                    if (tagUUIDListByDirty2 != null && tagUUIDListByDirty2.isEmpty()) {
                                        List uUIDListByDirty2 = C0322h.m670a().f831q.getUUIDListByDirty(c0012a5.f262e, C0322h.m670a().f831q.getSdocContractYes());
                                        c0012a5.f81v = uUIDListByDirty2;
                                        if (uUIDListByDirty2 != null && uUIDListByDirty2.isEmpty()) {
                                            List uUIDListByDirtyForExtraInfo2 = C0322h.m670a().f831q.getUUIDListByDirtyForExtraInfo(c0012a5.f262e, C0322h.m670a().f831q.getSdocContractYes());
                                            c0012a5.f84y = uUIDListByDirtyForExtraInfo2;
                                            if (uUIDListByDirtyForExtraInfo2 != null && uUIDListByDirtyForExtraInfo2.isEmpty()) {
                                                z = false;
                                            }
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                Debugger.m8615i("SyncOldNote", "Don't need old sync!");
                                AbstractC0299q.m616Z(((C0012a) this.f4474b).f263f - 600000);
                                return 1;
                            }
                            if (!m5126j()) {
                                return i;
                            }
                            Debugger.m8615i("SyncOldNote", "Finish syncOldNote : et = " + (SystemClock.elapsedRealtime() - j2));
                            return 1;
                        } catch (SyncException e12) {
                            if (e12.getExceptionCode() != 325) {
                                throw e12;
                            }
                            Debugger.m8609e("SyncOldNote", "call enableFullSynchronization() due to the too old timestamp error");
                            c0013b4.m42d();
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    r10 = str2;
                }
            } else {
                Debugger.m8607d("SyncOldNote$SyncServerPassword", "Cancelled SyncServerPassword");
            }
            Debugger.m8609e("SyncOldNote", "SyncServerPassword failed!");
            return i;
        }
        i = -1;
        j = 1;
        AbstractC0153k.m375d("Password");
        C0012a c0012a32 = (C0012a) this.f4474b;
        c0013b = (C0013b) this.f4475c;
        interfaceC14510a = (InterfaceC14510a) this.f4476d;
        C0023f c0023f2 = new C0023f();
        c0023f2.f127c = c0012a32;
        c0012a32.getClass();
        c0023f2.f125a = C0012a.m39b();
        c0023f2.f126b = false;
        StringBuilder sb22 = new StringBuilder();
        String str22 = c0023f2.f125a;
        String strM1170p2 = AbstractC0622a.m1170p(str22, SettingsConstants.LOCK_SETTINGS_BACKUP_FILE_NAME, sb22);
        file = new File(strM1170p2);
        if (file.exists()) {
            Debugger.m8609e("SyncOldNote$SyncServerPassword", "Failed to delete1");
        }
        String strM756B2 = AbstractC0541b.m756B(str22, "content.sync");
        file2 = new File(strM756B2);
        if (file2.exists()) {
            Debugger.m8609e("SyncOldNote$SyncServerPassword", "Failed to delete2");
        }
        if (c0013b.m43e(SettingsConstants.LOCK_SETTINGS_BACKUP_FILE_NAME)) {
        }
        if (interfaceC14510a.isCancelled()) {
        }
        Debugger.m8609e("SyncOldNote", "SyncServerPassword failed!");
        return i;
    }

    @Override // p037I0.InterfaceC0122a
    /* JADX INFO: renamed from: g */
    public void mo252g(C0124c c0124c) {
        C6742k c6742k;
        CompletableFuture completableFuture;
        switch (this.f4473a) {
            case 3:
                StringBuilder sb = new StringBuilder("result add attachment. path : ");
                String str = (String) this.f4474b;
                sb.append(FileUtils.logPath(str));
                sb.append(", onResult : ");
                sb.append(c0124c);
                MSLogger.m8632d("CreateNote", sb.toString());
                FileUtils.deleteFile(str);
                m5117a((C6903f) this.f4476d, (CompletableFuture) this.f4475c, "finished add attachment.");
                return;
            case 4:
            default:
                String str2 = (String) this.f4474b;
                if (DeviceInfo.isEngMode()) {
                    MSLogger.m8632d("UpdateNote", "result add attachment. path : " + FileUtils.logPath(str2) + ", onResult : " + c0124c);
                }
                FileUtils.deleteFile(str2);
                C6742k.m4840c((C6742k) this.f4476d, (CompletableFuture) this.f4475c, "finished add attachment.");
                return;
            case 5:
                synchronized (((C6742k) this.f4476d)) {
                    try {
                        if (c0124c != null) {
                            try {
                                try {
                                    if (c0124c.f387b == 404 && c0124c.f386a != null && "ErrorItemNotFound".equals(new JSONObject(c0124c.f386a).getJSONObject("error").getString("code"))) {
                                        ((boolean[]) this.f4474b)[0] = true;
                                    }
                                    c6742k = (C6742k) this.f4476d;
                                    completableFuture = (CompletableFuture) this.f4475c;
                                } catch (Exception e) {
                                    MSLogger.m8633e("UpdateNote", "getNotes error : " + c0124c.f387b + " msg : " + e.getMessage());
                                    c6742k = (C6742k) this.f4476d;
                                    completableFuture = (CompletableFuture) this.f4475c;
                                }
                            } catch (Throwable th) {
                                C6742k.m4840c((C6742k) this.f4476d, (CompletableFuture) this.f4475c, "finished check deleted note");
                                throw th;
                            }
                        } else {
                            c6742k = (C6742k) this.f4476d;
                            completableFuture = (CompletableFuture) this.f4475c;
                        }
                        C6742k.m4840c(c6742k, completableFuture, "finished check deleted note");
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                return;
        }
    }

    /* JADX INFO: renamed from: h */
    public void m5124h() throws ExecutionException, InterruptedException, TimeoutException {
        C0124c c0124c;
        boolean z;
        boolean z2;
        MSLogger.m8632d("CreateNote", "perform. ");
        C13573a c13573a = (C13573a) this.f4476d;
        C0094i c0094i = (C0094i) this.f4474b;
        String str = c0094i.f306c;
        c13573a.f9635b = null;
        C0111a.m256c().getClass();
        MSLogger.m8632d("ConnectedNotesHelper", "getListAllNotesSync");
        try {
            c0124c = AbstractC0299q.m614X("https://graph.microsoft.com/beta/me/notes?$filter=extensions/any(f:f/id eq 'Com.Samsung.Note')&$expand=extensions($filter=id eq 'Com.Samsung.Note')&nonIpmNote=1", "GET", (String) C0112b.m261h().f363b, "application/json", null);
        } catch (Exception e) {
            MSLogger.m8633e("ConnectedNotesHelper", "getListAllNotes Failed, " + e.getMessage());
            c0124c = new C0124c(null, -1);
        }
        MSLogger.m8632d("ExistNoteChecker", "result getNextNote, onResult : " + c0124c);
        if (c0124c != null) {
            try {
                JSONObject jSONObject = new JSONObject(c0124c.f386a);
                if (((JSONArray) c13573a.f9635b) == null) {
                    c13573a.f9635b = jSONObject.getJSONArray("value");
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("value");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ((JSONArray) c13573a.f9635b).put(jSONArray.get(i));
                    }
                }
            } catch (Exception e2) {
                AbstractC6670b.m4753n(e2, new StringBuilder("Failed. "), "ExistNoteChecker");
            }
        }
        JSONArray jSONArray2 = (JSONArray) c13573a.f9635b;
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            z = true;
            z2 = false;
        } else {
            for (int i2 = 0; i2 < ((JSONArray) c13573a.f9635b).length(); i2++) {
                try {
                    JSONObject jSONObject2 = ((JSONArray) c13573a.f9635b).getJSONObject(i2);
                    String string = jSONObject2.getString("id");
                    if (!TextUtils.isEmpty(string)) {
                        String string2 = "";
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("extensions");
                        int i4 = 0;
                        while (true) {
                            if (i4 >= jSONArray3.length()) {
                                z = true;
                                break;
                            }
                            try {
                                JSONObject jSONObject3 = jSONArray3.getJSONObject(i4);
                                if (jSONObject3 != null) {
                                    z = true;
                                    try {
                                        String string3 = jSONObject3.getString("extensionName");
                                        if (!TextUtils.isEmpty(string3) && string3.equals("Com.Samsung.Note")) {
                                            string2 = jSONObject3.getString("uuid");
                                            MSLogger.m8632d("ExistNoteChecker", "extensions uuid :" + string2 + ", connectedNotesId : " + string);
                                            break;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        MSLogger.m8633e("ExistNoteChecker", "Failed. " + e.getMessage());
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                            }
                            i4++;
                        }
                        try {
                            if (string2.equals(str)) {
                                MSLogger.m8632d("ExistNoteChecker", "matched with current uuid : " + str);
                                c0094i.f305b = string;
                                z2 = z;
                                break;
                            }
                            continue;
                        } catch (Exception e6) {
                            e = e6;
                            AbstractC6670b.m4753n(e, new StringBuilder("Failed. "), "ExistNoteChecker");
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                }
            }
            z = true;
            z2 = false;
        }
        MSLogger.m8632d("ExistNoteChecker", "isExist, ret : " + z2);
        if (z2) {
            StringBuilder sbM15l = AbstractC0000a.m15l("Update Note. uuid : ", str, ", connectedNotesId : ");
            sbM15l.append(c0094i.f305b);
            MSLogger.m8632d("CreateNote", sbM15l.toString());
            new C6742k(c0094i).m4861s();
            return;
        }
        c0094i.f305b = null;
        this.f4475c = null;
        CompletableFuture completableFuture = new CompletableFuture();
        C0111a c0111aM256c = C0111a.m256c();
        C6906i c6906i = new C6906i(this, completableFuture, 2);
        c0111aM256c.getClass();
        C0111a.m255b(c0094i, c6906i);
        m5121n(completableFuture, "wait create note");
        if (TextUtils.isEmpty(c0094i.f305b)) {
            return;
        }
        int i5 = 0;
        for (String str2 : c0094i.f308e) {
            MSLogger.m8632d("CreateNote", "request add attachment. path : " + FileUtils.logPath(str2));
            CompletableFuture completableFuture2 = new CompletableFuture();
            C0111a c0111aM256c2 = C0111a.m256c();
            String str3 = c0094i.f305b;
            i5++;
            C6903f c6903f = new C6903f(this, 3, str2, completableFuture2);
            c0111aM256c2.getClass();
            C0111a.m254a(str3, str2, i5, c6903f);
            m5121n(completableFuture2, "Wait for add attachment.");
        }
        long jM15142b = AbstractC14517a.m15142b((String) this.f4475c);
        C6785g c6785g = AbstractC6784f.f4180a;
        String str4 = c0094i.f305b;
        c6785g.getClass();
        C6785g.m4941o(z ? 1 : 0, str, str4);
        AbstractC0089d.m231c(jM15142b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m5125i() throws Throwable {
        InterfaceC14510a interfaceC14510a;
        boolean z;
        String str;
        String str2;
        String str3;
        Throwable th;
        InputStream inputStream;
        String str4;
        String str5;
        String unzippedFileName;
        FileInputStream fileInputStream;
        InterfaceC14510a interfaceC14510a2 = (InterfaceC14510a) this.f4475c;
        String str6 = "Failed to getFileInfoJSON() - ";
        C0012a c0012a = (C0012a) this.f4474b;
        boolean zM323h = C0145c.m323h("CategoryOrderTime", "CategoryOrderDirtyKey", false);
        StringBuilder sb = new StringBuilder();
        String str7 = (String) this.f4476d;
        String strM1170p = AbstractC0622a.m1170p(str7, "category_order.cot", sb);
        File file = new File(strM1170p);
        if (!file.exists() || file.delete()) {
            interfaceC14510a = interfaceC14510a2;
        } else {
            interfaceC14510a = interfaceC14510a2;
            Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "failed to delete SyncCategoryOrder");
        }
        try {
            AbstractC6848m.m5009b(c0012a.f69j, ImportItem.CATEGORY_ORDER, str7);
            z = zM323h;
        } catch (SyncException e) {
            z = zM323h;
            AbstractC6670b.m4752m(e, new StringBuilder("first order sync "), "SyncOldNote$SyncCategoryOrder");
        }
        if (interfaceC14510a.isCancelled()) {
            Debugger.m8607d("SyncOldNote$SyncCategoryOrder", "Cancelled CategoryOrder");
            return false;
        }
        if (file.exists()) {
            HashMap map = new HashMap();
            Debugger.m8607d("SyncOldNote$SyncCategoryOrder", "Get the server list");
            try {
                try {
                    try {
                        try {
                            str = "Cancelled CategoryOrder";
                            str3 = "category_order.cot";
                            C0322h.m670a().f816b.unzip(new File(strM1170p), new File(str7), true, true);
                            str5 = strM1170p + ".json";
                            unzippedFileName = C0322h.m670a().f816b.getUnzippedFileName();
                        } catch (FileNotFoundException e2) {
                            e = e2;
                        } catch (IOException e3) {
                            e = e3;
                            String str8 = str6 + e.getMessage();
                            Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str8);
                            throw new SyncException(312, str8);
                        }
                    } catch (Throwable th2) {
                        inputStream = "Get the server list";
                        th = th2;
                    }
                } catch (JSONException e5) {
                    e = e5;
                    str4 = "Failed to getFileInfoJSON() - ";
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = 0;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
            }
            if (!"category_order.cot.json".equals(unzippedFileName)) {
                Debugger.m8615i("SyncOldNote$SyncCategoryOrder", "unzipped file is not category_order.json : " + unzippedFileName);
                str5 = str7 + unzippedFileName;
                if (!FileUtils.exists(str5)) {
                    String str9 = "Failed to read category order of server : " + unzippedFileName;
                    Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str9);
                    throw new SyncException(304, str9);
                }
                String str10 = str6 + e.getMessage();
                Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str10);
                throw new SyncException(319, str10);
            }
            FileInputStream fileInputStream2 = new FileInputStream(str5);
            try {
                JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream2);
                if (jSONObjectM394i == null) {
                    try {
                        Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "json obj is null");
                        try {
                            fileInputStream2.close();
                        } catch (IOException e8) {
                            Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "InputStream close - Exception = " + e8);
                        }
                        return false;
                    } catch (FileNotFoundException e9) {
                        e = e9;
                    } catch (IOException e10) {
                        e = e10;
                        String str82 = str6 + e.getMessage();
                        Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str82);
                        throw new SyncException(312, str82);
                    } catch (JSONException e11) {
                        e = e11;
                        str4 = "Failed to getFileInfoJSON() - ";
                        String str11 = str4 + e.getMessage();
                        Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str11);
                        throw new SyncException(304, str11);
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = fileInputStream2;
                        if (inputStream != 0) {
                        }
                    }
                } else {
                    long j = jSONObjectM394i.getLong("order_time");
                    fileInputStream = fileInputStream2;
                    str4 = "Failed to getFileInfoJSON() - ";
                    str2 = str7;
                    try {
                        long jM328m = C0145c.m328m(0L, "CategoryOrderTime", "CategoryOrderTimeKey");
                        if (j > jM328m) {
                            Debugger.m8607d("SyncOldNote$SyncCategoryOrder", "serverTime : " + j + " , localTime : " + jM328m);
                            JSONArray jSONArray = jSONObjectM394i.getJSONArray("file_info");
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                map.put(jSONObject.getString("uuid"), Integer.valueOf(jSONObject.getInt("order")));
                            }
                            if (z) {
                                Debugger.m8607d("SyncOldNote$SyncCategoryOrder", "local category order is changed ");
                                SDocCategoryResolverContractImpl sDocCategoryResolverContractImpl = C0322h.m670a().f829o;
                                Context context = c0012a.f262e;
                                sDocCategoryResolverContractImpl.setCategoryOrder(context, map, TimeManager.getCurrentTime(context));
                            } else {
                                Debugger.m8607d("SyncOldNote$SyncCategoryOrder", "local category order is not changed ");
                                C0322h.m670a().f829o.setCategoryOrder(c0012a.f262e, map, j);
                            }
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e12) {
                            Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "InputStream close - Exception = " + e12);
                        }
                    } catch (FileNotFoundException e13) {
                        e = e13;
                        str6 = str4;
                    } catch (IOException e14) {
                        e = e14;
                        str6 = str4;
                        String str822 = str6 + e.getMessage();
                        Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str822);
                        throw new SyncException(312, str822);
                    } catch (JSONException e15) {
                        e = e15;
                        String str112 = str4 + e.getMessage();
                        Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str112);
                        throw new SyncException(304, str112);
                    } catch (Throwable th5) {
                        th = th5;
                        th = th;
                        inputStream = fileInputStream;
                        if (inputStream != 0) {
                            throw th;
                        }
                        try {
                            inputStream.close();
                            throw th;
                        } catch (IOException e16) {
                            Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "InputStream close - Exception = " + e16);
                            throw th;
                        }
                    }
                }
            } catch (FileNotFoundException e17) {
                e = e17;
            } catch (IOException e18) {
                e = e18;
            } catch (JSONException e19) {
                e = e19;
                fileInputStream = fileInputStream2;
                str4 = "Failed to getFileInfoJSON() - ";
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
            }
            String str102 = str6 + e.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategoryOrder", str102);
            throw new SyncException(319, str102);
        }
        str = "Cancelled CategoryOrder";
        str2 = str7;
        str3 = "category_order.cot";
        if (z) {
            C0158a.m407a().getClass();
            if (!C0158a.m410f()) {
                Debugger.m8607d("SyncOldNote$SyncCategoryOrder", "Need to update Server");
                try {
                    C0322h.m670a().f831q.getSdocContractNo();
                    long j2 = c0012a.f263f;
                    JSONObject jSONObject2 = new JSONObject();
                    String str12 = str3;
                    jSONObject2.put("syncname", str12);
                    jSONObject2.put("syncpath", str12);
                    jSONObject2.put("ModifiedTime", j2);
                    jSONObject2.put("IsFolder", "0");
                    jSONObject2.put("category", "category");
                    long jM328m2 = C0145c.m328m(0L, "CategoryOrderTime", "CategoryOrderTimeKey");
                    try {
                        m5122d(jM328m2);
                        if (interfaceC14510a.isCancelled()) {
                            Debugger.m8607d("SyncOldNote$SyncCategoryOrder", str);
                            return false;
                        }
                        String str13 = str2 + str12;
                        AbstractC6848m.m5014g(c0012a.f69j, str13, ImportItem.CATEGORY_ORDER, Long.toString(c0012a.f263f), jSONObject2, new C4512a(this, jM328m2, str13));
                        return true;
                    } catch (SyncException e20) {
                        e = e20;
                        Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "Failed to upload Category order");
                        throw e;
                    } catch (JSONException unused) {
                        Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "Failed to make json");
                        throw new SyncException(304, "Failed to upload category order");
                    }
                } catch (SyncException e21) {
                    e = e21;
                } catch (JSONException unused2) {
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:224:0x0776, code lost:
    
        throw new com.samsung.android.app.notes.sync.error.SyncException(323, "disk space is full. can not add category.");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v63 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v80 */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m5126j() throws SyncException {
        boolean z;
        long j;
        Iterator it;
        int i;
        String string;
        AbstractC0153k.m375d("Category");
        C14520a c14520a = new C14520a((C0012a) this.f4474b, (InterfaceC14510a) this.f4476d, 0);
        long j2 = 600000;
        long j3 = c14520a.f10356e.f263f - 600000;
        Debugger.m8607d("SyncOldNote$SyncCategory", "nextSyncTime: " + j3);
        Debugger.m8607d("SyncOldNote$SyncCategory", "Start to get local category");
        ArrayList arrayList = new ArrayList();
        C0012a c0012a = c14520a.f10356e;
        List arrayList2 = c0012a.f83x;
        if (arrayList2 == null) {
            arrayList2 = C0322h.m670a().f829o.getCategoryUUIDListByDirty(c0012a.f262e, C0322h.m670a().f831q.getSdocContractYes());
        }
        if (arrayList2 == null) {
            Debugger.m8607d("SyncOldNote$SyncCategory", "Failed to GetLocalCategoryArray");
            arrayList2 = new ArrayList();
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            z = false;
            if (!it2.hasNext()) {
                break;
            }
            String str = (String) it2.next();
            String strM756B = AbstractC0541b.m756B(str, ".category");
            Context context = c0012a.f262e;
            long j5 = j2;
            NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(str);
            if (str == null || str.equals("1")) {
                string = context.getResources().getString(C7943R.string.uncategorised);
            } else if (str.equals("2")) {
                string = context.getResources().getString(C7943R.string.string_screen_off_memo);
            } else {
                string = "";
                if (categoryEntity != null) {
                    string = categoryEntity.getDisplayName();
                }
            }
            if (TextUtils.isEmpty(string)) {
                string = context.getResources().getString(C7943R.string.uncategorised);
            }
            arrayList.add(new C0002b(categoryEntity != null ? categoryEntity.getDisplayNameColor() : 0, str, strM756B, categoryEntity != null ? categoryEntity.getServerTimeStamp().longValue() : 0L, string, (categoryEntity != null ? categoryEntity.getIsDeleted() : 0) != C0322h.m670a().f831q.getSdocContractNo()));
            j2 = j5;
        }
        long j6 = j2;
        Debugger.m8607d("SyncOldNote$SyncCategory", "Finish to get local category " + arrayList.size());
        c14520a.f10359h = arrayList;
        C0012a c0012a2 = c14520a.f10356e;
        Debugger.m8607d("SyncOldNote$SyncCategory", "GetServerCategoryArray start");
        ArrayList<C0002b> arrayList3 = new ArrayList();
        try {
            Iterator it3 = c0012a2.f80u.iterator();
            while (it3.hasNext()) {
                JSONArray jSONArray = ((JSONObject) it3.next()).getJSONArray("snote_list");
                int length = jSONArray.length();
                int i2 = 0;
                while (i2 < length) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject.has("filepath")) {
                        String string2 = jSONObject.getString("filepath");
                        if (!string2.endsWith(".category") || "1.category".equals(string2) || "UUID_UNCATEGORIZED.category".equals(string2)) {
                            i = i2;
                        } else {
                            C0002b c0002b = new C0002b();
                            c0002b.f7a = jSONObject.getString("datakey");
                            c0002b.f8b = jSONObject.getString("filepath");
                            i = i2;
                            c0002b.f12f = jSONObject.getLong("clientTimestamp");
                            c0002b.f9c = jSONObject.getBoolean("deleted");
                            arrayList3.add(c0002b);
                        }
                    } else {
                        i = i2;
                        Debugger.m8609e("SyncOldNote$SyncCategory", "GetServerCategoryArray : no filepath!");
                    }
                    i2 = i + 1;
                }
            }
            Debugger.m8607d("SyncOldNote$SyncCategory", "GetServerCategoryArray finish : " + arrayList3.size());
            for (C0002b c0002b2 : arrayList3) {
                c14520a.f10360i.put(c0002b2.f7a, c0002b2);
            }
            if (c14520a.f10357f.isCancelled()) {
                Debugger.m8607d("SyncOldNote$SyncCategory", "Cancelled Category");
                return false;
            }
            C0012a c0012a3 = c14520a.f10356e;
            ArrayList arrayList4 = c14520a.f10352a;
            ArrayList arrayList5 = c14520a.f10355d;
            HashMap map = c14520a.f10360i;
            ArrayList arrayList6 = c14520a.f10353b;
            ArrayList arrayList7 = c14520a.f10354c;
            Debugger.m8615i("SyncOldNote$SyncCategory", "Start to compare");
            Iterator it4 = c14520a.f10359h.iterator();
            while (it4.hasNext()) {
                C0002b c0002b3 = (C0002b) it4.next();
                String str2 = c0002b3.f7a;
                boolean z2 = z;
                boolean z3 = c0002b3.f9c;
                C0002b c0002b4 = (C0002b) map.get(str2);
                if (c0002b4 != null) {
                    it = it4;
                    boolean z4 = c0002b4.f9c;
                    map.remove(c0002b4.f7a);
                    j = j3;
                    long j7 = c0002b3.f12f;
                    long j8 = c0002b4.f12f;
                    if (j8 > j7) {
                        if (z4) {
                            arrayList7.add(c0002b4);
                        } else {
                            arrayList6.add(c0002b4);
                        }
                    } else if (j8 >= j7) {
                        C0322h.m670a().f829o.setCategoryDirty(c0012a3.f262e, c0002b3.f7a, C0322h.m670a().f831q.getSdocContractNo());
                    } else if (!z3) {
                        arrayList4.add(c0002b3);
                    } else if (z4) {
                        arrayList7.add(c0002b3);
                    } else {
                        arrayList5.add(c0002b3);
                    }
                } else {
                    j = j3;
                    it = it4;
                    if (z3) {
                        arrayList5.add(c0002b3);
                    } else {
                        arrayList4.add(c0002b3);
                    }
                }
                z = z2;
                it4 = it;
                j3 = j;
            }
            long j9 = j3;
            boolean z5 = z;
            Debugger.m8615i("SyncOldNote$SyncCategory", "toUploadList: " + arrayList4.size() + " ,toDownloadList: " + arrayList6.size());
            Debugger.m8607d("SyncOldNote$SyncCategory", "toDeleteLocalList: " + arrayList7.size() + " ,toDeleteServerList : " + arrayList5.size() + " ->");
            Debugger.m8607d("SyncOldNote$SyncCategory", "Start to compare more");
            Iterator it5 = map.entrySet().iterator();
            while (it5.hasNext()) {
                C0002b c0002b5 = (C0002b) ((Map.Entry) it5.next()).getValue();
                if (C0322h.m670a().f829o.getCategoryServerTimestamp(c0012a3.f262e, c0002b5.f7a) != c0002b5.f12f) {
                    if (!c0002b5.f9c) {
                        arrayList6.add(c0002b5);
                    } else if (C0322h.m670a().f829o.isExistCategory(c0012a3.f262e, c0002b5.f7a)) {
                        arrayList7.add(c0002b5);
                    }
                }
            }
            Debugger.m8615i("SyncOldNote$SyncCategory", "toDeleteLocalList: " + arrayList7.size() + " ,toDownloadList : " + arrayList6.size());
            if (c14520a.f10355d.size() + c14520a.f10354c.size() + c14520a.f10353b.size() + c14520a.f10352a.size() > 0) {
                if (!c14520a.f10354c.isEmpty()) {
                    Debugger.m8607d("SyncOldNote$SyncCategory", "Start to delete Local : " + c14520a.f10354c.size());
                    for (C0002b c0002b6 : c14520a.f10354c) {
                        String str3 = c0002b6.f7a;
                        Debugger.m8616s("SyncOldNote$SyncCategory", "Category : deleteSDoc - " + str3);
                        synchronized (C0322h.m670a().f829o.synchronizeCategory()) {
                            try {
                                Context context2 = c14520a.f10356e.f262e;
                                NotesCategoryTreeEntity categoryEntity2 = FolderManager.getInstance().getCategoryEntity(str3);
                                if ((categoryEntity2 != null ? categoryEntity2.getServerTimeStamp().longValue() : 0L) <= c0002b6.f12f) {
                                    if ((categoryEntity2 != null ? categoryEntity2.getIsDeleted() : z5) == C0322h.m670a().f831q.getSdocContractNo()) {
                                        C0322h.m670a().f829o.deleteCategory(c14520a.f10356e.f262e, str3, c0002b6.f12f, C0322h.m670a().f831q.getSdocContractNo(), true);
                                    }
                                    C0322h.m670a().f829o.deleteCategorySync(c14520a.f10356e.f262e, str3);
                                }
                            } finally {
                            }
                        }
                        Thread.yield();
                    }
                    Debugger.m8607d("SyncOldNote$SyncCategory", "Finished to delete Local");
                }
                if (!c14520a.f10355d.isEmpty()) {
                    C0158a.m407a().getClass();
                    if (!C0158a.m410f()) {
                        StringBuilder sb = new StringBuilder("Start to delete Server : ");
                        ArrayList arrayList8 = c14520a.f10355d;
                        sb.append(arrayList8.size());
                        Debugger.m8607d("SyncOldNote$SyncCategory", sb.toString());
                        Iterator it6 = arrayList8.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                Debugger.m8607d("SyncOldNote$SyncCategory", "Finished to delete server");
                                break;
                            }
                            C0002b c0002b7 = (C0002b) it6.next();
                            if (c14520a.f10357f.isCancelled()) {
                                Debugger.m8607d("SyncOldNote$SyncCategory", "Cancelled Category");
                                if (c14520a.f10357f.isCancelled()) {
                                    Debugger.m8607d("SyncOldNote$SyncCategory", "Cancelled before uploading category!");
                                    return z5;
                                }
                            } else {
                                String str4 = c0002b7.f7a;
                                Debugger.m8616s("SyncOldNote$SyncCategory", "Delete Server Files - " + str4);
                                try {
                                    AbstractC6848m.m5008a(c14520a.f10356e.f69j, str4, String.valueOf(c0002b7.f12f), new C13883h(c14520a, str4, 7));
                                } catch (SyncException e) {
                                    AbstractC6670b.m4752m(e, new StringBuilder("Category : Failed to deleteFile - "), "SyncOldNote$SyncCategory");
                                    throw e;
                                }
                            }
                        }
                    }
                }
                if (!c14520a.f10352a.isEmpty()) {
                    C0158a.m407a().getClass();
                    if (!C0158a.m410f()) {
                        C0012a c0012a4 = c14520a.f10356e;
                        StringBuilder sb2 = new StringBuilder("Start to upload : ");
                        ArrayList arrayList9 = c14520a.f10352a;
                        sb2.append(arrayList9.size());
                        Debugger.m8607d("SyncOldNote$SyncCategory", sb2.toString());
                        Iterator it7 = arrayList9.iterator();
                        while (true) {
                            if (!it7.hasNext()) {
                                Debugger.m8607d("SyncOldNote$SyncCategory", "Finished upload");
                                break;
                            }
                            C0002b c0002b8 = (C0002b) it7.next();
                            String str5 = c0002b8.f7a;
                            String str6 = c0002b8.f8b;
                            Debugger.m8616s("SyncOldNote$SyncCategory", "Upload Files - " + str5);
                            if (c14520a.f10357f.isCancelled()) {
                                Debugger.m8607d("SyncOldNote$SyncCategory", "Cancelled to upload category!");
                                if (c14520a.f10357f.isCancelled()) {
                                    Debugger.m8607d("SyncOldNote$SyncCategory", "Cancelled before downloading category!");
                                    return z5;
                                }
                            } else {
                                try {
                                    JSONObject jSONObjectM30a = c0002b8.m30a();
                                    String str7 = c14520a.f10358g + str6;
                                    C14520a.m15167c(c0002b8, str7);
                                    c0002b8.f12f = C0322h.m670a().f829o.getCategoryServerTimestamp(c0012a4.f262e, str5);
                                    Debugger.m8616s("SyncOldNote$SyncCategory", "uploadFile - uuid:  " + str5 + " , name: " + str6);
                                    AbstractC6848m.m5014g(c0012a4.f69j, str7, str5, String.valueOf(c0002b8.f12f), jSONObjectM30a, new C2517b(5, c14520a, str5, c0002b8, str7));
                                } catch (SyncException e2) {
                                    Debugger.m8609e("SyncOldNote$SyncCategory", "Failed to uploadFile - " + e2.getMessage());
                                    if (e2.getExceptionCode() == 312) {
                                        boolean z6 = z5;
                                        c0012a4.f67h = z6;
                                        c0012a4.f261d = z6;
                                    } else {
                                        boolean z7 = z5;
                                        if (e2.getExceptionCode() != 501) {
                                            throw e2;
                                        }
                                        c0012a4.f67h = z7;
                                        c0012a4.f261d = z7;
                                        Debugger.m8609e("SyncOldNote$SyncCategory", "Recover the previous history for category");
                                        C0145c.m310R("CategoryLastSyncTime", "CategoryLastSyncTimeKey", Long.toString(Long.parseLong("1464416139847")));
                                        C0145c.m309Q(c0012a4.f262e, Boolean.TRUE);
                                    }
                                } catch (JSONException e3) {
                                    String str8 = "Failed to uploadFile -" + e3.getMessage();
                                    Debugger.m8609e("SyncOldNote$SyncCategory", str8);
                                    throw new SyncException(304, str8);
                                }
                                z5 = false;
                            }
                        }
                    }
                }
                if (!c14520a.f10353b.isEmpty()) {
                    Debugger.m8607d("SyncOldNote$SyncCategory", "Start to download : " + c14520a.f10353b.size());
                    Iterator it8 = c14520a.f10353b.iterator();
                    while (true) {
                        if (!it8.hasNext()) {
                            Debugger.m8607d("SyncOldNote$SyncCategory", "Finished to download");
                            break;
                        }
                        C0002b c0002b9 = (C0002b) it8.next();
                        String str9 = c0002b9.f7a;
                        if (c14520a.f10357f.isCancelled()) {
                            Debugger.m8607d("SyncOldNote$SyncCategory", "Cancelled Category");
                            if (c14520a.f10357f.isCancelled()) {
                                Debugger.m8607d("SyncOldNote$SyncCategory", "Cancelled before finishing downloading category!");
                            }
                        } else if (C0322h.m670a().f829o.getCategoryServerTimestamp(c14520a.f10356e.f262e, str9) <= c0002b9.f12f) {
                            Debugger.m8616s("SyncOldNote$SyncCategory", "Download Files - " + str9);
                            try {
                                String strM397l = AbstractC0155m.m397l(c14520a.f10358g);
                                AbstractC6848m.m5009b(c14520a.f10356e.f69j, str9, strM397l);
                                String str10 = strM397l + c0002b9.f8b;
                                File file = new File(str10);
                                if (!file.exists()) {
                                    throw new SyncException(307, "There is no the completeFile.");
                                }
                                synchronized (C0322h.m670a().f829o.synchronizeCategory()) {
                                    try {
                                        if (C0322h.m670a().f829o.getCategoryServerTimestamp(c14520a.f10356e.f262e, str9) <= c0002b9.f12f) {
                                            C0002b c0002bM15169a = c14520a.m15169a(str10);
                                            if (C0322h.m670a().f829o.isExistCategory(c14520a.f10356e.f262e, str9)) {
                                                C0322h.m670a().f829o.updateCategoryNameAndColor(c14520a.f10356e.f262e, str9, c0002bM15169a.f10d, c0002bM15169a.f11e);
                                            } else if (C0322h.m670a().f829o.addCategory(c14520a.f10356e.f262e, str9, c0002bM15169a.f10d, c0002bM15169a.f11e, true) == null) {
                                                break;
                                            }
                                            if (C0322h.m670a().f829o.getCategoryDeleted(str9) == C0322h.m670a().f831q.getSdocContractYes()) {
                                                C0322h.m670a().f829o.recoveryCategory(c14520a.f10356e.f262e, str9, c0002bM15169a.f12f, C0322h.m670a().f831q.getSdocContractNo());
                                            } else {
                                                C0322h.m670a().f829o.setTimestampAndDirty(c14520a.f10356e.f262e, str9, c0002bM15169a.f12f, C0322h.m670a().f831q.getSdocContractNo());
                                            }
                                            if (!file.delete()) {
                                                Debugger.m8609e("SyncOldNote$SyncCategory", "failed to delete completeFile");
                                            }
                                        } else if (!file.delete()) {
                                            Debugger.m8609e("SyncOldNote$SyncCategory", "failed to delete category completeFile");
                                        }
                                    } finally {
                                    }
                                }
                            } catch (SyncException e5) {
                                AbstractC6670b.m4752m(e5, new StringBuilder("Failed to downloadFile -"), "SyncOldNote$SyncCategory");
                                throw e5;
                            }
                        }
                    }
                }
                return false;
            }
            Debugger.m8615i("SyncOldNote$SyncCategory", "There is no category to sync");
            c14520a.f10356e.getClass();
            if (c14520a.f10356e.f67h) {
                C0145c.m310R("CategoryLastSyncTime", "CategoryLastSyncTimeKey", Long.toString(j9));
                Debugger.m8607d("SyncOldNote$SyncCategory", "Update last syncTimeForCategory : " + j9);
            }
            AbstractC0153k.m375d(FolderConstants.Tag.DISPLAY_NAME);
            if (new C14520a((C0012a) this.f4474b, (InterfaceC14510a) this.f4476d, 1).m15171e()) {
                AbstractC0153k.m375d("ExtraList (DownSync)");
                C14521b c14521b = new C14521b((C0012a) this.f4474b, (C0013b) this.f4475c, (InterfaceC14510a) this.f4476d);
                if (c14521b.m15173b()) {
                    AbstractC0153k.m375d("ExtraList (UpSync)");
                    if (c14521b.m15174c()) {
                        AbstractC0153k.m375d("MergeCategory");
                        C0012a c0012a5 = (C0012a) this.f4474b;
                        C14433b c14433b = new C14433b(14, false);
                        c14433b.f10228b = c0012a5;
                        if (c14433b.m15041s()) {
                            AbstractC0153k.m375d("CategoryOrder");
                            if (new C6903f((C0012a) this.f4474b, (InterfaceC14510a) this.f4476d).m5125i()) {
                                AbstractC0153k.m375d("ExtraListTag (DownSync)");
                                C14522c c14522c = new C14522c((C0012a) this.f4474b, (C0013b) this.f4475c, (InterfaceC14510a) this.f4476d, 1);
                                if (c14522c.m15177b()) {
                                    AbstractC0153k.m375d("ExtraListTag (UpSync)");
                                    if (c14522c.m15178d()) {
                                        AbstractC0153k.m375d("MergeTag");
                                        C0012a c0012a6 = (C0012a) this.f4474b;
                                        C0073a c0073a = new C0073a(13);
                                        c0073a.f254b = c0012a6;
                                        if (c0073a.m206l()) {
                                            AbstractC0153k.m375d("ExtraInfoList (DownSync)");
                                            C14522c c14522c2 = new C14522c((C0012a) this.f4474b, (C0013b) this.f4475c, (InterfaceC14510a) this.f4476d, 0);
                                            if (c14522c2.m15177b()) {
                                                AbstractC0153k.m375d("ExtraInfoList (UpSync)");
                                                if (c14522c2.m15178d()) {
                                                    AbstractC0153k.m375d("Old Note");
                                                    long currentTime = TimeManager.getCurrentTime(((C0012a) this.f4474b).f262e);
                                                    ((C0012a) this.f4474b).getClass();
                                                    long j10 = currentTime - j6;
                                                    if (new C14523d((C0012a) this.f4474b, (C0013b) this.f4475c, (InterfaceC14510a) this.f4476d).m15183e()) {
                                                        AbstractC0153k.m375d("ExtraList (UpSync)");
                                                        if (c14521b.m15174c()) {
                                                            AbstractC0153k.m375d("ExtraListTag (UpSync)");
                                                            if (c14522c.m15178d()) {
                                                                AbstractC0153k.m375d("ExtraInfoList (DownSync)");
                                                                C14522c c14522c3 = new C14522c((C0012a) this.f4474b, (C0013b) this.f4475c, (InterfaceC14510a) this.f4476d, 0);
                                                                if (c14522c3.m15177b()) {
                                                                    AbstractC0153k.m375d("ExtraInfoList (UpSync)");
                                                                    if (c14522c3.m15178d()) {
                                                                        C0012a c0012a7 = (C0012a) this.f4474b;
                                                                        if (c0012a7.f258a && c0012a7.f259b) {
                                                                            AbstractC0299q.m616Z(j10);
                                                                            Debugger.m8607d("SyncOldNote", "Update last syncTimeForSDoc : " + j10);
                                                                        }
                                                                        return true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        } catch (JSONException e6) {
            String str11 = "GetServerCategoryArray - downloadList - " + e6.getMessage();
            Debugger.m8609e("SyncOldNote$SyncCategory", str11);
            throw new SyncException(304, str11);
        }
    }

    /* JADX INFO: renamed from: k */
    public ArrayList m5127k(List list) throws SyncException {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC11999i abstractC11999i = (AbstractC11999i) it.next();
            InterfaceC12018c interfaceC12018c = (InterfaceC12018c) ((HashMap) this.f4474b).get(abstractC11999i.f8707a);
            InterfaceC12018c interfaceC12018c2 = (InterfaceC12018c) ((HashMap) this.f4476d).get(abstractC11999i.f8707a);
            if (interfaceC12018c != null) {
                if (interfaceC12018c2 == null) {
                    arrayList.add(interfaceC12018c);
                } else if (interfaceC12018c2.mo13589b(interfaceC12018c, this)) {
                    arrayList.add(interfaceC12018c2);
                } else {
                    arrayList.add(interfaceC12018c);
                }
            } else {
                if (interfaceC12018c2 == null) {
                    throw new SyncException(327, AbstractC0622a.m1170p(abstractC11999i.f8707a, "] but there is no data in main tree", new StringBuilder("Server sent wrong info or client did not parse item correctly, server sent nodeId[")));
                }
                arrayList.add(interfaceC12018c2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: l */
    public List m5128l(String str) throws SyncException {
        HashMap map = (HashMap) this.f4475c;
        if (map.get(str) != null) {
            return m5127k(((AbstractC11999i) map.get(str)).mo13601a());
        }
        throw new SyncException(327, AbstractC0541b.m773o("Server sent wrong info or client did not parse item correctly, server sent nodeId[", str, "] but there is no data in main tree!"));
    }

    /* JADX INFO: renamed from: m */
    public void m5129m() throws SyncException {
        switch (this.f4473a) {
            case 1:
                C11991a c11991a = (C11991a) this.f4474b;
                C12969a c12969a = (C12969a) this.f4475c;
                c11991a.f8617j = c12969a.m13873a(c11991a.f8618k);
                C13541h c13541h = (C13541h) this.f4476d;
                String strM13873a = c12969a.m13873a(c11991a.f8618k);
                String str = c11991a.f8610c;
                StringBuilder sbM15l = AbstractC0000a.m15l("downloadFile() url = ", strM13873a, ", filePath = ");
                sbM15l.append(FileUtils.logPath(str));
                Debugger.m8607d("SyncNote/SyncFiles", sbM15l.toString());
                InterfaceC6855f interfaceC6855f = (InterfaceC6855f) c13541h.f9592e;
                if (interfaceC6855f != null) {
                    interfaceC6855f.mo142h();
                }
                if (strM13873a == null || str == null) {
                    Debugger.m8609e("SyncNote/SyncFiles", "url or file path is null!");
                    throw new SyncException(0, "SyncNote/SyncFilesurl or file path is null");
                }
                File file = new File(str);
                if (file.exists() && !file.delete()) {
                    Debugger.m8609e("SyncNote/SyncFiles", "downloadFile() - fail to delete file.");
                }
                C0077c c0077c = (C0077c) c13541h.f9589b;
                C6903f c6903f = c0077c.f265h;
                Context context = c0077c.f262e;
                C6861l c6861l = new C6861l(c6903f, context, (C0097a) c13541h.f9590c);
                c6861l.f4304e = strM13873a;
                c6861l.f4308i = str;
                c6861l.f4309j = "downloadFile";
                c6861l.f4312m = interfaceC6855f;
                AbstractC0299q.m600J(context, c6861l.m5034d());
                c11991a.f8621n = false;
                return;
            default:
                if (!AbstractC0155m.m386a(((C0019b) this.f4474b).f103e)) {
                    throw new SyncException(334, "Failed to uploadFile due to 1G limit!");
                }
                C13541h c13541h2 = (C13541h) this.f4476d;
                C0077c c0077c2 = (C0077c) c13541h2.f9589b;
                C6903f c6903f2 = c0077c2.f265h;
                Context context2 = c0077c2.f262e;
                C0097a c0097a = (C0097a) c13541h2.f9590c;
                C0019b c0019b = (C0019b) this.f4474b;
                String str2 = c0019b.f104f;
                String str3 = c0019b.f103e;
                String str4 = c0019b.f100b;
                InterfaceC6855f interfaceC6855f2 = (InterfaceC6855f) c13541h2.f9592e;
                C6861l c6861l2 = new C6861l(c6903f2, context2, c0097a);
                c6861l2.f4304e = str2;
                c6861l2.f4307h = str3;
                c6861l2.f4309j = "uploadFile";
                c6861l2.f4300a.put("Content-Type", str4);
                c6861l2.f4312m = interfaceC6855f2;
                c6861l2.f4305f = "PUT";
                C6865p c6865pM5040b = c6861l2.m5033c().m5040b();
                int i = c6865pM5040b.f4344a;
                if (i == 200) {
                    Debugger.m8607d("NT$WDocServiceHelper", "uploadFile() : succeed to uploadFile()");
                } else if (i == 204) {
                    Debugger.m8607d("NT$WDocServiceHelper", "uploadFile() : already file uploaded");
                } else {
                    AbstractC0299q.m600J(context2, c6865pM5040b);
                }
                Debugger.m8607d("NT$WDocServiceHelper", "uploadFile() finish");
                ((C0019b) this.f4474b).f109k = true;
                Debugger.m8607d("SyncNote/SyncFiles", "fileUploaded file = " + ((C0019b) this.f4474b));
                synchronized (((StringBuilder) this.f4475c)) {
                    StringBuilder sb = (StringBuilder) this.f4475c;
                    sb.append(((C0019b) this.f4474b).toString());
                    sb.append('\n');
                    break;
                }
                return;
        }
    }

    /* JADX INFO: renamed from: o */
    public void m5130o(int i) {
        String str = (i & 1) == 1 ? "BA" : (i & 2) == 2 ? "BP" : ((i & 8) == 8 || (i & 32) == 32 || ((i & 64) != 64 && (i & 128) != 128 && (i & 256) != 256 && (i & 512) != 512 && (i & 1024) != 1024)) ? "BB" : "BU";
        if (str.isEmpty()) {
            return;
        }
        this.f4476d = str + '-' + C0145c.m320e();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
    public /* bridge */ /* synthetic */ void onComplete(Object obj) {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
    public void onError(String str, String str2) {
        Debugger.m8610e("RegisterSmpUsingPam", AbstractC0541b.m774p("[PUSH] activatePush() : fail to get authorization, errCode = ", str, " errMsg = ", str2), null);
        ((C13527b) ((C13526a) this.f4476d).f9527c).f9528a.m204j(-1);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
    public void onFail(Exception exc) {
        ((C0312d) this.f4476d).onFail((String) this.f4474b, (String) this.f4475c, 0, exc.getMessage());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
    public void onReceived(String str) {
        C6907j c6907j = new C6907j();
        C13526a c13526a = (C13526a) this.f4476d;
        new ActivateSCloudTask((Context) c13526a.f9526b, c6907j, ((C13527b) c13526a.f9527c).f9528a).execute((String) this.f4474b, (String) this.f4475c);
    }

    /* JADX INFO: renamed from: p */
    public void m5131p(String str) {
        this.f4475c = str + '-' + C0145c.m320e();
    }

    public /* synthetic */ C6903f(Object obj, int i, Object obj2, Object obj3) {
        this.f4473a = i;
        this.f4476d = obj;
        this.f4474b = obj2;
        this.f4475c = obj3;
    }

    public C6903f(int i) {
        this.f4473a = i;
        switch (i) {
            case 10:
                this.f4474b = "";
                this.f4475c = "";
                break;
            default:
                this.f4474b = SyncProgressManager$SyncProgressStep.NONE;
                this.f4476d = new HashMap();
                break;
        }
    }

    public C6903f(Type$Interface type$Interface, Type$Process type$Process, Type$Flow type$Flow) {
        this.f4473a = 7;
        this.f4474b = type$Interface;
        this.f4475c = type$Process;
        this.f4476d = type$Flow;
    }

    public C6903f(C0094i c0094i) {
        this.f4473a = 4;
        this.f4474b = c0094i;
        this.f4476d = new C13573a(3, false);
    }

    public C6903f(C0012a c0012a, InterfaceC14510a interfaceC14510a) {
        this.f4473a = 14;
        this.f4474b = c0012a;
        this.f4475c = interfaceC14510a;
        c0012a.getClass();
        this.f4476d = C0012a.m39b();
    }

    public C6903f(String str) {
        this.f4473a = 9;
        this.f4474b = str;
    }
}
