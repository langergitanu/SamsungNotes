package p022E1;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.microsoft.graph.GraphItem$RequestType;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6747p;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.app.notes.sync.synchronization.managers.C6901d;
import com.samsung.android.support.senl.document.exception.InsufficientStorageException;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncProvider;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncDocumentState;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentTempDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentCoverUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p002A0.C0001a;
import p025F0.AbstractC0089d;
import p026F1.C0097a;
import p034H1.C0113a;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p079T.AbstractC0299q;
import p173d0.C11971a;
import p175e0.AbstractC11974a;
import p182g0.C11998h;
import p207n1.C13541h;
import p235r0.C14444j;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: E1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0075a {

    /* JADX INFO: renamed from: a */
    public final C6747p f255a;

    /* JADX INFO: renamed from: b */
    public final C0077c f256b;

    /* JADX INFO: renamed from: c */
    public final C0082h f257c;

    public C0075a(C0077c c0077c, C0082h c0082h) {
        this.f256b = c0077c;
        this.f257c = c0082h;
        this.f255a = new C6747p(c0077c.f262e);
    }

    /* JADX INFO: renamed from: f */
    public static void m208f(String str, C11971a c11971a, String str2) throws SyncException {
        try {
            c11971a.m13537l(str2);
        } catch (SyncException e) {
            new C14444j(str, Log.getStackTraceString(e)).m62a();
            AbstractC0299q.m613W();
            AbstractC0299q.m619b(str, "5040");
            Debugger.m8609e("DocumentOperation", "saveTargetTempFile() : SyncException = " + e.toString());
            throw e;
        } catch (InsufficientStorageException e2) {
            Debugger.m8609e("DocumentOperation", "saveTargetTempFile() : device storage is full = " + str);
            throw new SyncException(323, "device storage is full!", e2);
        } catch (Exception e3) {
            Debugger.m8609e("DocumentOperation", "saveTargetTempFile() : Exception = " + e3.toString());
            new C14444j(str, Log.getStackTraceString(e3)).m62a();
            AbstractC0299q.m613W();
            AbstractC0299q.m619b(str, "5040");
            throw new SyncException(312, e3.toString(), e3);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:304|169|(6:174|159|160|151|(0)(0)|211)|176|314|177|160|151|(0)(0)|211) */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0588, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : fail to get lastModifiedAt");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06c3 A[LOOP:0: B:225:0x06bd->B:227:0x06c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06f3 A[Catch: JSONException -> 0x0709, TRY_LEAVE, TryCatch #10 {JSONException -> 0x0709, blocks: (B:229:0x06e7, B:231:0x06f3), top: B:316:0x06e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0730 A[LOOP:2: B:236:0x072a->B:238:0x0730, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0819  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x089d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02d2  */
    /* JADX WARN: Type inference failed for: r11v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m209a(String str, String str2, String str3, C11971a c11971a, C0097a c0097a, boolean z) throws Throwable {
        boolean z2;
        boolean z3;
        NotesDocumentEntity notesDocumentEntity;
        boolean z4;
        Context context;
        C6749r c6749r;
        long j;
        Context context2;
        boolean z5;
        C6749r c6749r2;
        C6748q c6748q;
        boolean z6;
        int i;
        C0097a c0097a2;
        JSONObject jSONObject;
        int version;
        int version2;
        DocumentCoverStateTuple documentCoverStateTupleM13540b;
        DocumentCoverStateTuple documentCoverStateTupleM13540b2;
        DocumentCoverStateTuple documentCoverStateTupleM13540b3;
        long j2;
        long lastModifiedAt;
        int i2;
        int isEnabled;
        boolean z7;
        boolean z8;
        NotesDocumentEntity notesDocumentEntity2;
        ?? r11;
        ArrayList arrayList;
        List<NotesTagEntity> tagListByDocUuid;
        Iterator<NotesTagEntity> it;
        int length;
        int i4;
        Iterator it2;
        String str4;
        Context context3;
        C6748q c6748q2;
        String string;
        String str5 = str3;
        StringBuilder sb = new StringBuilder();
        C0077c c0077c = this.f256b;
        Context context4 = c0077c.f262e;
        C6749r c6749r3 = c0077c.f266i;
        sb.append(AbstractC0155m.m398m(context4));
        String strM1626p = AbstractC2322a.m1626p(sb, File.separator, str5, DiskFileUpload.postfix);
        Debugger.printMemory("DocumentOperation", "[CurrentMemoryState] Before saveTargetTempFile");
        m208f(str5, c11971a, strM1626p);
        Debugger.printMemory("DocumentOperation", "[CurrentMemoryState] After saveTargetTempFile");
        Context context5 = c0077c.f262e;
        C6748q c6748q3 = new C6748q(context5, str5);
        C0113a c0113a = new C0113a(str5);
        if (!z) {
            z2 = false;
            if (c6748q3.m4883k() > c11971a.f8533q && ((!c6748q3.m4884l() || c6748q3.m4874b() != 1) && (!c6748q3.m4884l() || c6748q3.m4874b() != 2))) {
                c0113a.m271b(c11971a.f8535s, "The local note is updated right before saving!");
                return false;
            }
            if (m211c(str5)) {
                throw new SyncException(CoeditBaseConstants.COEDIT_IMPORT_MAX_STROKE_OBJECT, "Composer is busy!");
            }
            if (m210b(c6748q3.m4874b(), str5)) {
                return false;
            }
        } else {
            if (m211c(str5)) {
                Debugger.m8609e("DocumentOperation", "handleSavingDoc() : composer is busy during recovery-> can't save " + str5);
                throw new SyncException(CoeditBaseConstants.COEDIT_IMPORT_MAX_STROKE_OBJECT, "Composer is busy");
            }
            if (m210b(c6748q3.m4874b(), str5)) {
                Debugger.m8609e("DocumentOperation", "handleSavingDoc() : composer is being edited during recovery-> can't save " + str5);
                return false;
            }
            z2 = false;
        }
        long j3 = c11971a.f8533q;
        C11998h c11998h = c11971a.f8522f;
        long j5 = c11998h.f8663U;
        long j6 = c11998h.f8664V;
        boolean z9 = c11998h.f8657O;
        boolean z10 = c11971a.f8518b;
        int i5 = c11998h.f8688j0;
        String strM14294h = C13541h.m14287e().m14294h();
        if (z10 && TextUtils.isEmpty(strM14294h)) {
            Debugger.m8609e("DocumentOperation", "updateDocTableInDb() : Current accountGuidHash is empty!");
            throw new SyncException(328, "fail to add WDoc data to app due to empty accountGuidHash!");
        }
        HashMap map = c0077c.f270m;
        NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(context5, str5);
        if (notesDocumentEntityM9f == null) {
            z3 = z10;
            notesDocumentEntity = new NotesDocumentEntity();
            z4 = true;
        } else {
            z3 = z10;
            notesDocumentEntity = notesDocumentEntityM9f;
            z4 = z2;
        }
        NotesDocumentEntity notesDocumentEntity3 = c6748q3.f4128a;
        String filePath = notesDocumentEntity3 != null ? notesDocumentEntity3.getFilePath() : null;
        if (TextUtils.isEmpty(filePath)) {
            context = context5;
            filePath = AbstractC0541b.m757C(str, str5, ".sdocx");
        } else {
            context = context5;
        }
        notesDocumentEntity.setUuid(str5);
        notesDocumentEntity.setFilePath(filePath);
        notesDocumentEntity.setServerId(str2);
        notesDocumentEntity.setIsDirty(z2 ? 1 : 0);
        notesDocumentEntity.setDirtySkipped(true);
        notesDocumentEntity.setIsSynced(true);
        notesDocumentEntity.setServerTimestamp(Long.valueOf(j3));
        notesDocumentEntity.setKeepServerTimestamp(true);
        notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(j5), Long.valueOf(j6));
        notesDocumentEntity.setIsFavorite(z9 ? 1 : 0);
        notesDocumentEntity.setIsLock(z3 ? 5 : 0);
        notesDocumentEntity.setLockAccountGuid(strM14294h);
        notesDocumentEntity.setMathMode(i5);
        FolderNodeItem folderNodeItem = (FolderNodeItem) map.get(str5);
        if (folderNodeItem != null) {
            Debugger.m8615i("DocumentOperation", "updatePendedFolderInfoForNote() : " + folderNodeItem.uUid);
            int i6 = FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED.equals(folderNodeItem.state) ? 2 : 0;
            j = 0;
            if ("root".equals(folderNodeItem.parentFolderNodeId)) {
                if (FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED.equals(folderNodeItem.state)) {
                    folderNodeItem.parentFolderNodeId = "trash:///";
                } else {
                    folderNodeItem.parentFolderNodeId = "uncategorized:///";
                }
            } else if (FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED.equals(folderNodeItem.state)) {
                if (!"trash:///".equals(folderNodeItem.parentFolderNodeId) && "uncategorized:///".equals(folderNodeItem.restorePath)) {
                    Debugger.m8609e("DocumentOperation", "updatePendedFolderInfoForNote() : trashed but not correct folder = " + folderNodeItem.parentFolderNodeId);
                    folderNodeItem.parentFolderNodeId = "trash:///";
                }
            } else if ("trash:///".equals(folderNodeItem.parentFolderNodeId)) {
                Debugger.m8609e("DocumentOperation", "updatePendedFolderInfoForNote() : not trashed but not correct folder = " + folderNodeItem.parentFolderNodeId);
                folderNodeItem.parentFolderNodeId = "uncategorized:///";
            }
            if ("1".equals(folderNodeItem.parentFolderNodeId)) {
                Debugger.m8609e("DocumentOperation", "updatePendedFolderInfoForNote() : old uncategorized new note : " + folderNodeItem.uUid);
                folderNodeItem.parentFolderNodeId = "uncategorized:///";
            }
            notesDocumentEntity.setIsDeleted(i6);
            context.getApplicationContext();
            NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
            SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
            notesDatabaseManager.getSyncDocumentDao();
            new SyncNoteDataRepository();
            new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
            if (PredefinedCategory.find(folderNodeItem.parentFolderNodeId) == null) {
                String str6 = folderNodeItem.parentFolderNodeId;
                if (str6 == null) {
                    c6749r = c6749r3;
                } else {
                    c6749r = c6749r3;
                    Debugger.m8607d("SyncCategoryTreeRepository", "getSyncEntity ".concat(str6));
                    if (syncCategoryTreeDao.getSyncEntity(str6) != null) {
                    }
                    notesDocumentEntity.setCategoryServerTimeStamp(Long.valueOf(folderNodeItem.syncModifiedTime));
                    notesDocumentEntity.setCategoryIsDirty(0);
                    if (i6 == 2) {
                        Debugger.m8615i("DocumentOperation", "updatePendedFolderInfoForNote() : set recycleBinMovedTime current, note : " + folderNodeItem.uUid);
                        notesDocumentEntity.setRecycleBinTimeMoved(System.currentTimeMillis());
                        if (TextUtils.isEmpty(folderNodeItem.restorePath)) {
                            notesDocumentEntity.setAbsolutePath(PredefinedCategory.UNCATEGORIZED.getPath());
                        } else {
                            notesDocumentEntity.setAbsolutePath(folderNodeItem.restorePath);
                        }
                    }
                }
                if (i6 == 0) {
                    Debugger.m8609e("DocumentOperation", "updatePendedFolderInfoForNote() : No folder uuid = " + folderNodeItem.parentFolderNodeId + " , note : " + folderNodeItem.uUid + " uncategorized");
                    notesDocumentEntity.setCategoryUuid("uncategorized:///");
                } else {
                    Debugger.m8609e("DocumentOperation", "updatePendedFolderInfoForNote() : No folder uuid = " + folderNodeItem.parentFolderNodeId + " , note : " + folderNodeItem.uUid + " trashed");
                    notesDocumentEntity.setCategoryUuid("trash:///");
                }
                notesDocumentEntity.setCategoryServerTimeStamp(Long.valueOf(folderNodeItem.syncModifiedTime));
                notesDocumentEntity.setCategoryIsDirty(0);
                if (i6 == 2) {
                }
            } else {
                c6749r = c6749r3;
            }
            notesDocumentEntity.setCategoryUuid(folderNodeItem.parentFolderNodeId);
            notesDocumentEntity.setCategoryServerTimeStamp(Long.valueOf(folderNodeItem.syncModifiedTime));
            notesDocumentEntity.setCategoryIsDirty(0);
            if (i6 == 2) {
            }
        } else {
            c6749r = c6749r3;
            j = 0;
            this.f257c.m222i();
            if (((FolderNodeItem) map.get(str5)) == null) {
                StringBuilder sbM12325j = AbstractC11014a.m12325j("handleFolderAndDeletedState() : No folderNoteItem = ", str5);
                sbM12325j.append(z4 ? "as a new note" : "");
                Debugger.m8612ef("DocumentOperation", sbM12325j.toString());
                Debugger.m8615i("DocumentOperation", "updateUnCategorizedForNote() : " + notesDocumentEntity.getUuid());
                notesDocumentEntity.setIsDeleted(0);
                notesDocumentEntity.setCategoryUuid(PredefinedCategory.UNCATEGORIZED.getUuid());
                notesDocumentEntity.setCategoryServerTimeStamp(0L);
                notesDocumentEntity.setCategoryIsDirty(0);
                notesDocumentEntity.setServerTimestamp(Long.valueOf(j3 - 1));
                if (!"eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=".equals(c0077c.f272o)) {
                    c0077c.f272o = "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=";
                }
            }
        }
        C6785g c6785g = AbstractC6784f.f4180a;
        C11998h c11998h2 = c11971a.f8522f;
        String str7 = c11998h2.f8682g0;
        String str8 = c11998h2.f8684h0;
        long j7 = c11998h2.f8686i0;
        c6785g.getClass();
        String strM229a = AbstractC0089d.m229a();
        String msSyncAccountId = notesDocumentEntity.getMsSyncAccountId();
        String msSyncDocumentUuid = notesDocumentEntity.getMsSyncDocumentUuid();
        long msLastSyncTime = notesDocumentEntity.getMsLastSyncTime();
        if (!c6785g.f4185e) {
            MSLogger.m8632d("GraphManager", "setMsSyncData, signed out. update MS data");
            notesDocumentEntity.setMsSyncAccountId(str7);
            notesDocumentEntity.setMsSyncDocumentUuid(str8);
            notesDocumentEntity.setMsLastSyncTime(j7);
        } else if (TextUtils.isEmpty(strM229a) || !strM229a.equals(str7)) {
            MSLogger.m8632d("GraphManager", "setMsSyncData, skipped by different MS account id. ");
        } else {
            MSLogger.m8632d("GraphManager", "setMsSyncData, update. ");
            if (!TextUtils.isEmpty(msSyncDocumentUuid) && !TextUtils.isEmpty(str8) && !msSyncDocumentUuid.equals(str8)) {
                c6785g.m4945d(notesDocumentEntity.getUuid(), GraphItem$RequestType.DELETE, notesDocumentEntity.getServerTimestamp().longValue(), notesDocumentEntity.getMsSyncAccountId(), notesDocumentEntity.getMsSyncDocumentUuid());
            }
            if (TextUtils.isEmpty(str7)) {
                str7 = msSyncAccountId;
            }
            notesDocumentEntity.setMsSyncAccountId(str7);
            if (TextUtils.isEmpty(str8)) {
                str8 = msSyncDocumentUuid;
            }
            notesDocumentEntity.setMsSyncDocumentUuid(str8);
            if (j7 == j) {
                j7 = msLastSyncTime;
            }
            notesDocumentEntity.setMsLastSyncTime(j7);
        }
        try {
            boolean zM4872d = this.f255a.m4872d(strM1626p, z4, notesDocumentEntity);
            if (z4) {
                AbstractC0153k.m380i(context);
            }
            if (!zM4872d) {
                return zM4872d;
            }
            C6749r c6749r4 = c6749r;
            c6749r4.m4887c(str5, c11971a.f8534r);
            String str9 = c11971a.f8522f.f8665W;
            try {
                if (str9 == null) {
                    Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : No remoteAiCover!");
                } else {
                    if (!TextUtils.isEmpty(str9)) {
                        try {
                            jSONObject = new JSONObject(str9);
                            version = NotesDocumentCoverUtils.getVersion(jSONObject.getString(DocumentTempDataConstants.KEY_COVER_VERSION));
                            version2 = NotesDocumentCoverUtils.getVersion(CoverConstants.VERSION);
                        } catch (JSONException unused) {
                            z5 = zM4872d;
                            c6749r2 = c6749r4;
                            c6748q = c6748q3;
                            z6 = true;
                            i = 0;
                            Debugger.m8609e("DocumentOperation", "[AICover] handleAiCover() : fail to parse server version!");
                        }
                        if (version > version2) {
                            z5 = zM4872d;
                            Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : higher serverVersion = " + version + ", localVersion = " + version2);
                            if (c6748q3.m4875c() == null) {
                                Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : No local ai cover, apply the higher cover");
                                c6748q = c6748q3;
                                AbstractC14517a.m15137V(c6748q, str9);
                                documentCoverStateTupleM13540b2 = AbstractC11974a.m13540b(version, str5, jSONObject, new HashMap());
                                c6749r2 = c6749r4;
                            } else {
                                c6748q = c6748q3;
                                try {
                                    long j8 = jSONObject.getJSONObject("document_cover").getLong("lastModifiedAt");
                                    c6749r2 = c6749r4;
                                    try {
                                        long lastModifiedAt2 = c6748q.m4875c().getLastModifiedAt();
                                        Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : remoteLastModifiedAt = " + j8 + ", localLastModifiedAt = " + lastModifiedAt2);
                                        if (j8 > lastModifiedAt2) {
                                            AbstractC14517a.m15137V(c6748q, str9);
                                            Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : save the temp data");
                                            documentCoverStateTupleM13540b3 = AbstractC11974a.m13540b(version, str5, jSONObject, new HashMap());
                                            documentCoverStateTupleM13540b2 = documentCoverStateTupleM13540b3;
                                        } else {
                                            Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : ignore the remote cover data");
                                            documentCoverStateTupleM13540b3 = null;
                                            documentCoverStateTupleM13540b2 = documentCoverStateTupleM13540b3;
                                        }
                                    } catch (Exception unused2) {
                                        Debugger.m8609e("DocumentOperation", "[AiCover] handleAiCover() : fail to handle lastModifiedAt");
                                        documentCoverStateTupleM13540b2 = null;
                                    }
                                } catch (Exception unused3) {
                                    c6749r2 = c6749r4;
                                }
                            }
                            i = 0;
                            if (documentCoverStateTupleM13540b2 != null) {
                                Debugger.m8615i("DocumentOperation", "[AICover] handleAiCover() : remoteCoverStateTuple is null!");
                                z6 = true;
                            } else {
                                Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : Update a local AI Cover, lastModifiedAt = " + documentCoverStateTupleM13540b2.getLastModifiedAt());
                                DocumentCoverStateTuple documentCoverStateTupleM4875c = c6748q.m4875c();
                                if (documentCoverStateTupleM4875c == null || documentCoverStateTupleM4875c.getLastModifiedAt() != documentCoverStateTupleM13540b2.getLastModifiedAt()) {
                                    try {
                                        try {
                                            z7 = true;
                                            z8 = true;
                                        } catch (Exception e) {
                                            e = e;
                                            str5 = str3;
                                            z7 = true;
                                            Debugger.m8612ef("DocumentOperation", "[AiCover] updateCoverUi() : fail to update, " + e);
                                            z8 = z7;
                                            NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(context);
                                            notesDocumentEntity2 = notesDataRepositoryFactoryNewInstance.createDocumentDataRepository().get(documentCoverStateTupleM13540b2.getDocUuid());
                                            if (notesDocumentEntity2 != null) {
                                                documentCoverStateTupleM13540b2.setTitle(notesDocumentEntity2.getTitle());
                                                Debugger.m8607d("DocumentOperation", "[AiCover] updateAiCoverDb, change title");
                                            }
                                            notesDataRepositoryFactoryNewInstance.createCoverStickerRepository().insertIfNotExists(documentCoverStateTupleM13540b2.getCategoryUuid());
                                            notesDataRepositoryFactoryNewInstance.createCoverTemplateRepository().insertIfNotExists(documentCoverStateTupleM13540b2.getTemplateUuid());
                                            notesDataRepositoryFactoryNewInstance.createDocumentCoverRepository().insert(documentCoverStateTupleM13540b2, documentCoverStateTupleM13540b2.state, NotesSyncProvider.METHOD.SYNC);
                                            z6 = z8;
                                            c0097a2 = c0097a;
                                            r11 = z6;
                                            if (c0097a2.f320c) {
                                            }
                                            HashSet hashSet = new HashSet();
                                            arrayList = c11971a.f8522f.f8680f0;
                                            if (arrayList != null) {
                                            }
                                            tagListByDocUuid = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().getTagListByDocUuid(str5);
                                            if (tagListByDocUuid == null) {
                                            }
                                            HashSet hashSet2 = new HashSet();
                                            it = tagListByDocUuid.iterator();
                                            while (it.hasNext()) {
                                            }
                                            NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().updateTagsByDocUuid(hashSet2, hashSet, str5, r11);
                                            String str10 = c11971a.f8522f.f8659Q;
                                            ArrayList arrayList2 = new ArrayList();
                                            JSONArray jSONArray = new JSONArray(str10);
                                            length = jSONArray.length();
                                            while (i4 < length) {
                                            }
                                            Debugger.m8607d("BookMarkItem", "getBookMarkListFromJson() finish : " + arrayList2.size());
                                            ArrayList arrayList3 = new ArrayList();
                                            it2 = arrayList2.iterator();
                                            while (it2.hasNext()) {
                                            }
                                            NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository().replaceBookmarkList(str5, arrayList3);
                                            C11998h c11998h3 = c11971a.f8522f;
                                            str4 = c11998h3.f8660R;
                                            long j9 = c11998h3.f8661S;
                                            boolean z11 = c11998h3.f8662T;
                                            if (str4 != null) {
                                            }
                                            if (!TextUtils.isEmpty(str4)) {
                                            }
                                            c0113a.m270a(c6748q);
                                            if (c6748q.f4128a == null) {
                                            }
                                            Debugger.m8614f("DocumentOperation", string);
                                            C0145c.m308P(c11971a.f8533q, "SyncDataSDocx", "lastSyncModifiedTime");
                                            C6742k.m4841o().m4855l(str5);
                                            C6901d c6901d = new C6901d();
                                            C6901d.m5113d(c6748q);
                                            c6901d.m5114a(c11971a);
                                            c6901d.m5115c(c6748q);
                                            return z5;
                                        }
                                        try {
                                            DocumentAccessHandler.getContract().createCoverPreview(c0077c.f262e, documentCoverStateTupleM13540b2.getSummary(), documentCoverStateTupleM13540b2.getCategoryUuid(), documentCoverStateTupleM13540b2.getTemplateUuid(), documentCoverStateTupleM13540b2.getBackgroundColor(), str3, documentCoverStateTupleM13540b2.getState());
                                            str5 = str3;
                                        } catch (Exception e2) {
                                            e = e2;
                                            str5 = str3;
                                            Debugger.m8612ef("DocumentOperation", "[AiCover] updateCoverUi() : fail to update, " + e);
                                            z8 = z7;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                    }
                                } else {
                                    z8 = true;
                                }
                                NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance2 = NotesDataRepositoryFactory.newInstance(context);
                                notesDocumentEntity2 = notesDataRepositoryFactoryNewInstance2.createDocumentDataRepository().get(documentCoverStateTupleM13540b2.getDocUuid());
                                if (notesDocumentEntity2 != null && !notesDocumentEntity2.getTitle().equals(documentCoverStateTupleM13540b2.getTitle())) {
                                    documentCoverStateTupleM13540b2.setTitle(notesDocumentEntity2.getTitle());
                                    Debugger.m8607d("DocumentOperation", "[AiCover] updateAiCoverDb, change title");
                                }
                                try {
                                    notesDataRepositoryFactoryNewInstance2.createCoverStickerRepository().insertIfNotExists(documentCoverStateTupleM13540b2.getCategoryUuid());
                                    notesDataRepositoryFactoryNewInstance2.createCoverTemplateRepository().insertIfNotExists(documentCoverStateTupleM13540b2.getTemplateUuid());
                                    notesDataRepositoryFactoryNewInstance2.createDocumentCoverRepository().insert(documentCoverStateTupleM13540b2, documentCoverStateTupleM13540b2.state, NotesSyncProvider.METHOD.SYNC);
                                    z6 = z8;
                                } catch (Exception e5) {
                                    Debugger.m8612ef("DocumentOperation", "[AiCover] updateAiCoverDb() : fail to update, " + e5);
                                    z6 = z8;
                                }
                            }
                            c0097a2 = c0097a;
                            r11 = z6;
                        } else {
                            z5 = zM4872d;
                            c6749r2 = c6749r4;
                            c6748q = c6748q3;
                            if (version < version2) {
                                Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : serverVersion = " + version + ", higher localVersion = " + version2);
                                if (c6748q.m4875c() == null) {
                                    Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : No local ai cover, apply the lower cover");
                                    i = 0;
                                    documentCoverStateTupleM13540b = AbstractC11974a.m13540b(0, str5, jSONObject, new HashMap());
                                } else {
                                    try {
                                        JSONObject jSONObject2 = jSONObject.getJSONObject("document_cover");
                                        j2 = jSONObject2.getLong("lastModifiedAt");
                                        lastModifiedAt = c6748q.m4875c().getLastModifiedAt();
                                        i2 = jSONObject2.getInt("isEnabled");
                                        isEnabled = c6748q.m4875c().getIsEnabled();
                                        Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : remoteLastModifiedAt = " + j2 + ", localLastModifiedAt = " + lastModifiedAt + ", remoteEnable = " + i2 + ", localEnable = " + isEnabled);
                                    } catch (Exception unused4) {
                                        documentCoverStateTupleM13540b3 = null;
                                    }
                                    if (j2 <= lastModifiedAt && (j2 != lastModifiedAt || i2 == isEnabled)) {
                                        Debugger.m8615i("DocumentOperation", "[AiCover] handleAiCover() : ignore the remote cover data");
                                        documentCoverStateTupleM13540b3 = null;
                                        documentCoverStateTupleM13540b2 = documentCoverStateTupleM13540b3;
                                        i = 0;
                                        if (documentCoverStateTupleM13540b2 != null) {
                                        }
                                        c0097a2 = c0097a;
                                        r11 = z6;
                                    }
                                    documentCoverStateTupleM13540b3 = AbstractC11974a.m13540b(0, str5, jSONObject, new HashMap());
                                    AbstractC14517a.m15135T(c6748q);
                                    documentCoverStateTupleM13540b2 = documentCoverStateTupleM13540b3;
                                    i = 0;
                                    if (documentCoverStateTupleM13540b2 != null) {
                                    }
                                    c0097a2 = c0097a;
                                    r11 = z6;
                                }
                            } else {
                                i = 0;
                                documentCoverStateTupleM13540b = AbstractC11974a.m13540b(0, str5, jSONObject, new HashMap());
                                AbstractC14517a.m15135T(c6748q);
                            }
                            documentCoverStateTupleM13540b2 = documentCoverStateTupleM13540b;
                            if (documentCoverStateTupleM13540b2 != null) {
                            }
                            c0097a2 = c0097a;
                            r11 = z6;
                        }
                        if (c0097a2.f320c && c6748q.m4882j() == 0) {
                            c6749r2.f4134b.setStrokeGrouped(str5, r11);
                        }
                        HashSet hashSet3 = new HashSet();
                        arrayList = c11971a.f8522f.f8680f0;
                        if (arrayList != null) {
                            hashSet3.addAll(arrayList);
                        }
                        tagListByDocUuid = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().getTagListByDocUuid(str5);
                        if (tagListByDocUuid == null) {
                            tagListByDocUuid = new ArrayList<>();
                        }
                        HashSet hashSet22 = new HashSet();
                        it = tagListByDocUuid.iterator();
                        while (it.hasNext()) {
                            hashSet22.add(it.next().getDisplayName());
                        }
                        NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().updateTagsByDocUuid(hashSet22, hashSet3, str5, r11);
                        String str102 = c11971a.f8522f.f8659Q;
                        ArrayList arrayList22 = new ArrayList();
                        JSONArray jSONArray2 = new JSONArray(str102);
                        length = jSONArray2.length();
                        for (i4 = i; i4 < length; i4++) {
                            arrayList22.add(new C0001a(jSONArray2.getJSONObject(i4).getString("page_uuid")));
                        }
                        Debugger.m8607d("BookMarkItem", "getBookMarkListFromJson() finish : " + arrayList22.size());
                        ArrayList arrayList32 = new ArrayList();
                        it2 = arrayList22.iterator();
                        while (it2.hasNext()) {
                            arrayList32.add(((C0001a) it2.next()).f2c);
                        }
                        NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository().replaceBookmarkList(str5, arrayList32);
                        C11998h c11998h32 = c11971a.f8522f;
                        str4 = c11998h32.f8660R;
                        long j92 = c11998h32.f8661S;
                        boolean z112 = c11998h32.f8662T;
                        if (str4 != null) {
                            context3 = context;
                            c6748q2 = new C6748q(context3, str4);
                        } else {
                            context3 = context;
                            c6748q2 = null;
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            NotesDocumentEntity notesDocumentEntity4 = c6748q2.f4128a;
                            if ((notesDocumentEntity4 != null ? notesDocumentEntity4.getLastMappedAt() : j) == j) {
                                Debugger.m8615i("DocumentOperation", "[Converted] updateMappedDocDb() : can't add a mapped entry due to the old note!");
                            } else {
                                if (j92 >= (notesDocumentEntity4 != null ? notesDocumentEntity4.getLastMappedAt() : j)) {
                                    StringBuilder sbM2225p = AbstractC2821a.m2225p(j92, "[Converted] updateMappedDocDb() : mappedAt(=", ") of ", str5);
                                    sbM2225p.append(" >= LastMappedAt(=");
                                    sbM2225p.append(notesDocumentEntity4 != null ? notesDocumentEntity4.getLastMappedAt() : j);
                                    sbM2225p.append(") of ");
                                    sbM2225p.append(str4);
                                    sbM2225p.append(" -> Insert an entry to MappedDocument");
                                    Debugger.m8615i("DocumentOperation", sbM2225p.toString());
                                    NotesDocumentDao documentDao = NotesDatabaseManager.getInstance().getDocumentDao();
                                    NotesMappedDocumentDao mappedDocumentDao = NotesDatabaseManager.getInstance().getMappedDocumentDao();
                                    StringBuilder sbM16m = AbstractC0000a.m16m("insert, originalDocumentUuid : ", str4, ", mappedDocumentUuid : ", str5, ", ServerTimestamp : ");
                                    sbM16m.append(j92);
                                    sbM16m.append(", isConverted : ");
                                    sbM16m.append(z112);
                                    Debugger.m8615i("SyncMappedDocumentRepository", sbM16m.toString());
                                    mappedDocumentDao.insert(documentDao, str4, str5, j92, z112);
                                } else {
                                    Debugger.m8615i("DocumentOperation", "[Converted] updateMappedDocDb() : can't add a mapped entry due to the old mappedAt!");
                                }
                                NotesDataRepositoryFactory.newInstance(context3).createMappedDocumentRepository().delete(str4, notesDocumentEntity4 != null ? notesDocumentEntity4.getLastMappedAt() : j);
                            }
                        }
                        c0113a.m270a(c6748q);
                        if (c6748q.f4128a == null) {
                            StringBuilder sbM15l = AbstractC0000a.m15l("[SyncResult] downSync, new ", str5, ", syncModifiedTime = ");
                            sbM15l.append(c11971a.f8533q);
                            string = sbM15l.toString();
                        } else {
                            StringBuilder sbM15l2 = AbstractC0000a.m15l("[SyncResult] downSync, ", str5, ", syncModifiedTime = ");
                            sbM15l2.append(c11971a.f8533q);
                            string = sbM15l2.toString();
                        }
                        Debugger.m8614f("DocumentOperation", string);
                        C0145c.m308P(c11971a.f8533q, "SyncDataSDocx", "lastSyncModifiedTime");
                        C6742k.m4841o().m4855l(str5);
                        C6901d c6901d2 = new C6901d();
                        C6901d.m5113d(c6748q);
                        c6901d2.m5114a(c11971a);
                        c6901d2.m5115c(c6748q);
                        return z5;
                    }
                    Debugger.m8609e("DocumentOperation", "[AiCover] handleAiCover() : Empty remoteAiCover!");
                }
                JSONArray jSONArray22 = new JSONArray(str102);
                length = jSONArray22.length();
                while (i4 < length) {
                }
                Debugger.m8607d("BookMarkItem", "getBookMarkListFromJson() finish : " + arrayList22.size());
                ArrayList arrayList322 = new ArrayList();
                it2 = arrayList22.iterator();
                while (it2.hasNext()) {
                }
                NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository().replaceBookmarkList(str5, arrayList322);
                C11998h c11998h322 = c11971a.f8522f;
                str4 = c11998h322.f8660R;
                long j922 = c11998h322.f8661S;
                boolean z1122 = c11998h322.f8662T;
                if (str4 != null) {
                }
                if (!TextUtils.isEmpty(str4)) {
                }
                c0113a.m270a(c6748q);
                if (c6748q.f4128a == null) {
                }
                Debugger.m8614f("DocumentOperation", string);
                C0145c.m308P(c11971a.f8533q, "SyncDataSDocx", "lastSyncModifiedTime");
                C6742k.m4841o().m4855l(str5);
                C6901d c6901d22 = new C6901d();
                C6901d.m5113d(c6748q);
                c6901d22.m5114a(c11971a);
                c6901d22.m5115c(c6748q);
                return z5;
            } catch (JSONException e6) {
                Debugger.m8609e("BookMarkItem", "getBookMarkJsonList() : Failed to getBookMarkListFromJson : " + e6.getMessage());
                throw new SyncException(304, "Failed to getBookMarkListFromJson");
            }
            c0097a2 = c0097a;
            z5 = zM4872d;
            c6749r2 = c6749r4;
            c6748q = c6748q3;
            r11 = 1;
            i = 0;
            if (c0097a2.f320c) {
                c6749r2.f4134b.setStrokeGrouped(str5, r11);
            }
            HashSet hashSet32 = new HashSet();
            arrayList = c11971a.f8522f.f8680f0;
            if (arrayList != null) {
            }
            tagListByDocUuid = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().getTagListByDocUuid(str5);
            if (tagListByDocUuid == null) {
            }
            HashSet hashSet222 = new HashSet();
            it = tagListByDocUuid.iterator();
            while (it.hasNext()) {
            }
            NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().updateTagsByDocUuid(hashSet222, hashSet32, str5, r11);
            String str1022 = c11971a.f8522f.f8659Q;
            ArrayList arrayList222 = new ArrayList();
        } catch (IOException e7) {
            context2 = context;
            try {
                Throwable cause = e7.getCause();
                if (cause instanceof SyncException) {
                    SyncException syncException = (SyncException) cause;
                    if (syncException.getExceptionCode() != 337) {
                        if (syncException.getExceptionCode() == 506) {
                        }
                    }
                    throw syncException;
                }
                throw new SyncException(328, "Failed to saveWDocFileSync");
            } catch (Throwable th) {
                th = th;
                if (z4) {
                    AbstractC0153k.m380i(context2);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            context2 = context;
            if (z4) {
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m210b(int i, String str) {
        if (i != 0 || this.f255a.m4871c(str)) {
            return false;
        }
        Debugger.m8615i("DocumentOperation", "isComposerBeingEdited() : " + str);
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m211c(String str) {
        boolean zAskForReadyToDownloadDocument;
        C6747p c6747p = this.f255a;
        synchronized (c6747p.f4127g) {
            try {
                IDocumentServiceWrapper iDocumentServiceWrapper = c6747p.f4125e;
                if (iDocumentServiceWrapper == null) {
                    Logger.m8703w("SyncSaveDocumentManager", "isReadyToDownloadDocument, mService is not connected yet");
                    zAskForReadyToDownloadDocument = false;
                } else {
                    zAskForReadyToDownloadDocument = iDocumentServiceWrapper.askForReadyToDownloadDocument(str);
                }
            } finally {
            }
        }
        if (zAskForReadyToDownloadDocument) {
            return false;
        }
        Debugger.m8615i("DocumentOperation", "isComposerBusyNow() : " + str);
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final void m212d(String str) {
        Debugger.m8615i("DocumentOperation", "notifyDeletedFromServer() : " + str);
        C6747p c6747p = this.f255a;
        synchronized (c6747p.f4127g) {
            if (c6747p.f4125e == null) {
                Logger.m8703w("SyncSaveDocumentManager", "notifyDeletedFromServer, mService is not connected yet");
                return;
            }
            try {
                Intent intent = new Intent();
                intent.putExtra(SyncDocumentState.DOCUMENT_STATE_TYPE, 2);
                intent.putExtra("sdocx_uuid", str);
                IDocumentServiceWrapper iDocumentServiceWrapper = c6747p.f4125e;
                iDocumentServiceWrapper.sendBroadcastMessage(iDocumentServiceWrapper.getUser(), intent);
            } catch (Exception e) {
                Logger.m8698e("SyncSaveDocumentManager", "notifyDeletedFromServer : Exception = " + e);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final boolean m213e(String str) {
        C6747p c6747p = this.f255a;
        synchronized (c6747p.f4127g) {
            if (c6747p.f4125e == null) {
                Logger.m8703w("SyncSaveDocumentManager", "notifyInvalidVersionDocumentState, mService is not connected yet");
                return false;
            }
            try {
                Intent intent = new Intent();
                intent.putExtra(SyncDocumentState.DOCUMENT_STATE_TYPE, 1);
                intent.putExtra("sdocx_uuid", str);
                IDocumentServiceWrapper iDocumentServiceWrapper = c6747p.f4125e;
                iDocumentServiceWrapper.sendBroadcastMessage(iDocumentServiceWrapper.getUser(), intent);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
