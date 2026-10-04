package p022E1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.converters.WDocExceedObjectException;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6734c;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.diagmon.DiagMonLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.helper.UpdateDocumentHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p001A.AbstractC0000a;
import p004A2.RunnableC0015b;
import p007B0.C0021d;
import p026F1.C0097a;
import p034H1.C0115c;
import p042J1.AbstractC0146d;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p042J1.C0152j;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p173d0.C11971a;
import p235r0.C14436b;
import p235r0.C14438d;
import p235r0.C14439e;
import p235r0.C14441g;
import p235r0.C14442h;
import p235r0.C14443i;
import p243u0.C14472b;
import p253w1.InterfaceC14510a;
import p255x1.C14512a;

/* JADX INFO: renamed from: E1.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0082h extends AbstractC0078d {

    /* JADX INFO: renamed from: b */
    public final C0077c f286b;

    public C0082h(C0077c c0077c) {
        super(c0077c);
        this.f286b = c0077c;
    }

    /* JADX INFO: renamed from: e */
    public static void m217e(String str) throws SyncException {
        if (AbstractC0155m.m401p()) {
            return;
        }
        Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", "device storage is full ," + str);
        throw new SyncException(323, "device storage is full!");
    }

    /* JADX INFO: renamed from: d */
    public final void m218d() throws SyncException {
        if (AbstractC0146d.m346e(this.f286b.f262e)) {
            Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "Cancelled SyncWDoc due to no SCloud package!");
            throw new SyncException(903, "Cancelled SyncWDoc due to no SCloud package!");
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m219f(InterfaceC14510a interfaceC14510a, String str) {
        int i = this.f286b.f264g.f322a;
        if (interfaceC14510a.isCancelled()) {
            String strConcat = "cancel to ".concat(str);
            Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", strConcat);
            throw new SyncException(902, strConcat);
        }
        if ((i & 128) == 128 || C0158a.m407a().m417k()) {
            return;
        }
        String str2 = "cancel to " + str + " due to syncDisable!";
        Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", str2);
        throw new SyncException(908, str2);
    }

    /* JADX INFO: renamed from: g */
    public final void m220g() throws SyncException {
        C0077c c0077c = this.f286b;
        if ((c0077c.f264g.f322a & 64) == 64 || !TaskState.INSTANCE.getInstance().isSyncBlocked()) {
            return;
        }
        C0145c.m309Q(c0077c.f262e, Boolean.TRUE);
        Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "Cancelled SyncWDoc due to converting!");
        throw new SyncException(907, "Cancelled SyncWDoc due to converting!");
    }

    /* JADX INFO: renamed from: h */
    public final void m221h() {
        AbstractC0299q.m620b0("eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiTk9URSJ9");
        C0077c c0077c = this.f286b;
        C6734c c6734c = c0077c.f267j;
        C6749r c6749r = c0077c.f266i;
        for (String str : c6734c.f4096a.getNormalSdocxUuidList()) {
            c6749r.f4134b.updateNoteServerIdAndDirty(str, null, 1);
            c6749r.f4134b.updateDirtyCategory(str, 1);
        }
        C0145c.m310R("sync_v2_pref", "folderLastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=");
        FolderManager.getInstance().executeOperation(new RunnableC0015b(this, 2));
        C0145c.m308P(0L, "SyncSuccessTime", "SyncSuccessTimeKey");
    }

    /* JADX INFO: renamed from: i */
    public final void m222i() {
        C0077c c0077c = this.f286b;
        c0077c.f270m.clear();
        try {
            Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "fillDeletedOrPendedNoteInServerListWithAllServerNote()");
            C0021d c0021d = (C0021d) new C14512a(c0077c.f265h, c0077c.f262e, new C0097a(), "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=").m15111b().f4111c;
            if (c0021d == null) {
                Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", "fillDeletedOrPendedNoteInServerListWithAllServerNote() : No folder resource!");
                return;
            }
            ArrayList<FolderNodeItem> arrayList = c0021d.f115d;
            if (arrayList != null && !arrayList.isEmpty()) {
                for (FolderNodeItem folderNodeItem : arrayList) {
                    c0077c.f270m.put(folderNodeItem.uUid, folderNodeItem);
                }
                return;
            }
            Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", "fillDeletedOrPendedNoteInServerListWithAllServerNote() : empty noteNodeList");
        } catch (SyncException e) {
            AbstractC6670b.m4752m(e, new StringBuilder("fillDeletedOrPendedNoteInServerListWithAllServerNote() : "), "SyncProcessTask$SyncOperationSDocx");
        }
    }

    /* JADX INFO: renamed from: j */
    public final boolean m223j(C6748q c6748q, SyncException syncException, String str) throws SyncException {
        C0077c c0077c = this.f286b;
        Context context = c0077c.f262e;
        C6749r c6749r = c0077c.f266i;
        Context context2 = c0077c.f262e;
        if (AbstractC0153k.m373b(context) && AbstractC0153k.m373b(context2)) {
            C0152j c0152jM378g = AbstractC0153k.m378g();
            c0152jM378g.f455d = Log.getStackTraceString(syncException);
            c0152jM378g.f463l = true;
            c0152jM378g.f454c = "error";
            c0152jM378g.m371b(context2);
        }
        if (syncException.getExceptionCode() == 327) {
            C0152j c0152jM378g2 = AbstractC0153k.m378g();
            c0152jM378g2.f454c = "FAIL_PARSE_XML";
            StringBuilder sbM781w = AbstractC0541b.m781w(str, "\n");
            sbM781w.append(Log.getStackTraceString(syncException));
            c0152jM378g2.f455d = sbM781w.toString();
            c0152jM378g2.m371b(context2);
            String stackTraceString = Log.getStackTraceString(syncException);
            C14442h c14442h = new C14442h();
            c14442h.f165b = "SPEN_ERROR";
            c14442h.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14442h.f165b, 302, ""));
            c14442h.f166c = stackTraceString;
            c14442h.m62a();
            return true;
        }
        if (syncException.getExceptionCode() == 326) {
            if (c6748q.m4879g() == 1) {
                c6749r.f4134b.updateIsSyncFailed(str, 1);
                c6749r.m4888d(0, str);
            }
            C0152j c0152jM378g3 = AbstractC0153k.m378g();
            c0152jM378g3.f454c = "FAIL_COMPOSE_XML";
            StringBuilder sbM781w2 = AbstractC0541b.m781w(str, "\n");
            sbM781w2.append(Log.getStackTraceString(syncException));
            c0152jM378g3.f455d = sbM781w2.toString();
            c0152jM378g3.m371b(context2);
            String stackTraceString2 = Log.getStackTraceString(syncException);
            C14436b c14436b = new C14436b();
            c14436b.f165b = "SPEN_ERROR";
            c14436b.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14436b.f165b, 301, ""));
            c14436b.f166c = stackTraceString2;
            c14436b.m62a();
            return true;
        }
        if (syncException.getExceptionCode() == 315) {
            if (syncException.getStatusCode() != 400 && syncException.getStatusCode() != 405 && syncException.getStatusCode() != 404) {
                throw syncException;
            }
            Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "handleCommonSyncException() : handle Server error, statusCode = " + syncException.getStatusCode() + ", msg = " + syncException.getMessage());
            C0152j c0152jM378g4 = AbstractC0153k.m378g();
            c0152jM378g4.f454c = "FAIL_SERVER_ERR";
            StringBuilder sbM781w3 = AbstractC0541b.m781w(str, ": ");
            sbM781w3.append(syncException.getStatusCode());
            c0152jM378g4.f455d = sbM781w3.toString();
            c0152jM378g4.m371b(context2);
            if (syncException.getStatusCode() == 404) {
                C6742k.m4841o().m4855l(str);
                return true;
            }
        } else if (syncException.getExceptionCode() == 336) {
            if (c6748q.m4879g() == 1) {
                c6749r.f4134b.updateIsSyncFailed(str, 1);
                c6749r.m4888d(0, str);
            }
            if (syncException.getSpenUnsupportedTypeException() != null) {
                Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", syncException.getSpenUnsupportedTypeException().getMessage());
                Exception exc = new Exception(DiagMonLogger.getExceptionMsg("SPEN_ERROR", 303, ""));
                AbstractC0000a.m21r(exc, new StringBuilder("send() : mainErrCode = SPEN_ERROR , "), "SyncErrorDiagmon");
                try {
                    if (TextUtils.isEmpty(null)) {
                        DiagMonLogger.report(exc, "SPEN_ERROR");
                    } else {
                        DiagMonLogger.report(exc, "SPEN_ERROR", null);
                    }
                } catch (Exception e) {
                    AbstractC4539a.m3213w(e, new StringBuilder("send() : fail to report = "), "SyncErrorDiagmon");
                }
            }
        } else if (syncException.getExceptionCode() == 12000) {
            C0115c c0115c = new C0115c(str);
            if (C0115c.m276b(c6748q)) {
                c0115c.m277a(context2, c6748q);
                return true;
            }
        } else {
            if (syncException.getExceptionCode() == 337) {
                Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "handleCommonSyncException: SyncConstants.ResultCode.FAIL_SAVE_AND_PASS");
                return true;
            }
            if (syncException.getExceptionCode() != 338) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: k */
    public final void m224k(C6748q c6748q, SyncException syncException, String str) throws SyncException {
        if (syncException.getExceptionCode() == 338) {
            AbstractC6670b.m4752m(syncException, AbstractC0000a.m15l("handleDownSyncException() : FAIL_NOT_REPORT_AND_PASS => ", str, SQLKeyword.COMMA), "SyncProcessTask$SyncOperationSDocx");
        } else {
            StringBuilder sbM15l = AbstractC0000a.m15l("handleDownSyncException() : ", str, " , ");
            sbM15l.append(syncException.getMessage());
            Debugger.m8613ef("SyncProcessTask$SyncOperationSDocx", sbM15l.toString(), syncException);
        }
        if (m223j(c6748q, syncException, str)) {
            return;
        }
        if (syncException.getExceptionCode() == 339) {
            Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "handleDownSyncException() : invalid size note in server is passed, docUuid = " + str);
            return;
        }
        if (syncException.getExceptionCode() == 312) {
            Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "handleDownSyncException() : fail to do file operations, docUuid = " + str);
        } else if (syncException.getExceptionCode() == 328) {
            Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "handleDownSyncException() : fail to convert, docUuid = " + str);
        } else {
            if (syncException.getExceptionCode() != 15000) {
                throw syncException;
            }
            Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "handleDownSyncException() : fail due to busy composer, docUuid = " + str);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m225l(C6748q c6748q, SyncException syncException, String str) throws SyncException {
        if (syncException.getExceptionCode() == 338) {
            AbstractC6670b.m4752m(syncException, AbstractC0000a.m15l("handleUpSyncException() : FAIL_NOT_REPORT_AND_PASS => ", str, SQLKeyword.COMMA), "SyncProcessTask$SyncOperationSDocx");
        } else {
            Debugger.m8613ef("SyncProcessTask$SyncOperationSDocx", "handleUpSyncException() : " + str + " , " + syncException, syncException);
        }
        if (m223j(c6748q, syncException, str)) {
            return;
        }
        if (syncException.getExceptionCode() == 339) {
            if ((c6748q.m4880h() & 1024) != 1024) {
                Context applicationContext = BaseUtils.getApplicationContext();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
                NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f.addNoteSyncStateFlag(str, 1024L);
            }
            C0145c.m308P(c6748q.m4883k(), "SyncControlInvalidDataSizeNote", str);
            C14438d c14438d = new C14438d();
            c14438d.f165b = "SPEN_ERROR";
            c14438d.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14438d.f165b, 305, "UUID : " + str));
            c14438d.m62a();
            AbstractC0299q.m613W();
            AbstractC0299q.m619b(str, "5040");
            return;
        }
        if (syncException.getExceptionCode() == 335) {
            if ((c6748q.m4880h() & 2048) != 2048) {
                Context applicationContext2 = BaseUtils.getApplicationContext();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f2 = AbstractC4539a.m3196f(applicationContext2, applicationContext2);
                NotesDataRepositoryFactory.newInstance(applicationContext2).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f2.addNoteSyncStateFlag(str, 2048L);
            }
            C0145c.m308P(c6748q.m4883k(), "SyncControlResourceLackingNote", str);
            C14443i c14443i = new C14443i();
            c14443i.f165b = "SPEN_ERROR";
            c14443i.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14443i.f165b, 306, "UUID : " + str));
            c14443i.m62a();
            AbstractC0299q.m613W();
            AbstractC0299q.m619b(str, "5040");
            return;
        }
        if (syncException.getExceptionCode() == 332) {
            if ((c6748q.m4880h() & 4096) != 4096) {
                Context applicationContext3 = BaseUtils.getApplicationContext();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f3 = AbstractC4539a.m3196f(applicationContext3, applicationContext3);
                NotesDataRepositoryFactory.newInstance(applicationContext3).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f3.addNoteSyncStateFlag(str, 4096L);
            }
            C0145c.m308P(c6748q.m4883k(), "SyncControlInvalidFileHashNote", str);
            C14439e c14439e = new C14439e();
            c14439e.f165b = "SPEN_ERROR";
            c14439e.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14439e.f165b, 307, "UUID : " + str));
            c14439e.m62a();
            AbstractC0299q.m613W();
            AbstractC0299q.m619b(str, "5040");
            return;
        }
        if (syncException.getExceptionCode() != 334) {
            if (syncException.getExceptionCode() != 333) {
                throw syncException;
            }
            if ((c6748q.m4880h() & 16384) != 16384) {
                Context applicationContext4 = BaseUtils.getApplicationContext();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f4 = AbstractC4539a.m3196f(applicationContext4, applicationContext4);
                NotesDataRepositoryFactory.newInstance(applicationContext4).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f4.addNoteSyncStateFlag(str, 16384L);
            }
            C0145c.m308P(c6748q.m4883k(), "SyncControlInvalidPayloadNote", str);
            AbstractC0299q.m613W();
            AbstractC0299q.m619b(str, "5040");
            return;
        }
        Debugger.m8609e("Over1GbNote", "Failed to uploadFile - >1G : " + c6748q.f4132e);
        if ((c6748q.m4880h() & 8192) != 8192) {
            Context applicationContext5 = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f5 = AbstractC4539a.m3196f(applicationContext5, applicationContext5);
            NotesDataRepositoryFactory.newInstance(applicationContext5).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f5.addNoteSyncStateFlag(str, 8192L);
        }
        C0145c.m308P(c6748q.m4883k(), "SyncControlOver1GbNote", str);
        C0077c c0077c = this.f286b;
        c0077c.f259b = false;
        c0077c.f261d = false;
        new C14472b(12).mo4791d();
        C14441g c14441g = new C14441g();
        c14441g.f165b = "SYNC_ERROR";
        c14441g.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14441g.f165b, 102, ""));
        c14441g.m62a();
        AbstractC0299q.m604N("5044", "f");
        AbstractC0299q.m619b(str, "5041");
    }

    /* JADX INFO: renamed from: m */
    public final C11971a m226m(String str) throws SyncException, SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        NotesDocumentEntity notesDocumentEntityM9f;
        Context context = this.f286b.f262e;
        if (str != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
            AbstractC0000a.m18o(context, context, context);
        } else {
            notesDocumentEntityM9f = null;
        }
        String filePath = notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getFilePath() : null;
        AtomicReference atomicReference = new AtomicReference();
        Throwable[] thArr = {null};
        DocumentFileManager.getInstance().executeAction(filePath, new C0079e(this, atomicReference, str, filePath, thArr));
        Throwable th = thArr[0];
        if (th == null) {
            return (C11971a) atomicReference.get();
        }
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        if (th instanceof SyncException) {
            throw ((SyncException) th);
        }
        if (th instanceof SpenUnsupportedTypeException) {
            throw ((SpenUnsupportedTypeException) th);
        }
        if (th instanceof SpenUnsupportedVersionException) {
            throw ((SpenUnsupportedVersionException) th);
        }
        if (th instanceof WDocExceedObjectException) {
            throw ((WDocExceedObjectException) th);
        }
        if (th instanceof IllegalArgumentException) {
            throw ((IllegalArgumentException) th);
        }
        if (th instanceof OutOfMemoryError) {
            throw ((OutOfMemoryError) th);
        }
        throw new RuntimeException("readWDocByUuid() : Unexpected exception = " + th.getMessage(), th);
    }

    /* JADX INFO: renamed from: n */
    public final boolean m227n(String str) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int[] iArr = {2};
        new UpdateDocumentHelper(this.f286b.f262e, DocumentSubscriptionId.SYNC_SERVICE_ID).setUuid(str).setListener(new C0081g(iArr, countDownLatch)).execute();
        try {
            if (Thread.currentThread().isInterrupted()) {
                return false;
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", e.toString());
        }
        if (iArr[0] == 0) {
            return true;
        }
        Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", "saveStrokeGroupSync() : Fail to setStrokeGroupSize");
        return false;
    }
}
