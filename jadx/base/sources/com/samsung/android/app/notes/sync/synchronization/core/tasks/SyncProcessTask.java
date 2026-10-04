package com.samsung.android.app.notes.sync.synchronization.core.tasks;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.infos.ModelType;
import com.samsung.android.app.notes.sync.p135db.C6735d;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6747p;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6904g;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import p001A.AbstractC0000a;
import p003A1.C0012a;
import p003A1.C0013b;
import p007B0.C0021d;
import p007B0.C0022e;
import p007B0.C0023f;
import p007B0.C0026i;
import p007B0.C0027j;
import p008B1.C0028a;
import p008B1.C0032e;
import p012C1.C0049e;
import p012C1.C0052h;
import p020E.C0073a;
import p022E1.AbstractC0078d;
import p022E1.C0077c;
import p022E1.C0082h;
import p025F0.C0091f;
import p026F1.C0097a;
import p033H0.C0112b;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p173d0.C11971a;
import p195k1.C12969a;
import p206n0.C13533a;
import p211o0.C13567a;
import p211o0.C13569c;
import p212o1.C13573a;
import p253w1.InterfaceC14510a;
import p255x1.C14512a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SyncProcessTask extends SyncBaseTask {
    private static final String TAG = "SyncProcessTask";
    private static boolean mDeleteServerData;
    private InterfaceC14510a mSyncTaskContact;

    public SyncProcessTask(Context context, String str, InterfaceC6897a interfaceC6897a) {
        super(context, str, interfaceC6897a, 1);
        this.mSyncTaskContact = new C0073a(this, 9);
    }

    private void checkChangesBeforeSync() {
        C0082h c0082h = this.mSyncOperationSDocx;
        String strGenerateSha256 = HashUtils.generateSha256(SyncBaseTask.mAccountGuid);
        c0082h.getClass();
        String strM331p = C0145c.m331p("AccountGuidSDocx", "AccountGuidKeySDocx", null);
        if (!TextUtils.isEmpty(strM331p) && strM331p.length() != 64) {
            strM331p = HashUtils.generateSha256(strM331p);
        }
        if (!strGenerateSha256.equals(strM331p)) {
            if (TextUtils.isEmpty(strM331p)) {
                Debugger.m8614f("SyncProcessTask$SyncOperationSDocx", "Account changed!");
            } else {
                Debugger.m8614f("SyncProcessTask$SyncOperationSDocx", "Account changed really!");
            }
            c0082h.m221h();
            C0145c.m310R("AccountGuidSDocx", "AccountGuidKeySDocx", strGenerateSha256);
        }
        C0082h c0082h2 = this.mSyncOperationSDocx;
        String strM399n = AbstractC0155m.m399n(this.mContext);
        c0082h2.getClass();
        String strM331p2 = C0145c.m331p("AppVersionSDocx", "AppVersionKeySDocx", null);
        if (!TextUtils.isEmpty(strM331p2) && !strM399n.equals(strM331p2)) {
            Debugger.m8614f("SyncProcessTask$SyncOperationSDocx", "App version changed : " + strM331p2 + " -> " + strM399n);
            C0077c c0077c = c0082h2.f286b;
            c0077c.f266i.f4134b.updateIsDirtyByIsSyncFailed(1, 1);
            c0077c.f266i.f4134b.resetIsSyncFailed(0);
            C0145c.m310R("AppVersionSDocx", "AppVersionKeySDocx", strM399n);
        }
        this.mSyncOperationSDocx.getClass();
        AbstractC0078d.m214a();
    }

    private void checkEdpDevice() throws SyncException {
        int e2EEDeviceType = C13569c.m14376d(this.mSyncInfoSDocx.f262e).f9619b.getE2EEDeviceType();
        AbstractC0000a.m0A(e2EEDeviceType, "checkEdpState() : deviceType = ", TAG);
        if (e2EEDeviceType == 0) {
            throw new SyncException(600, "Unsupported device for EDP!");
        }
    }

    private void checkPush() {
        if (C12969a.m13872b(this.mSyncInfoSDocx.f262e).m13874c()) {
            C0158a.m407a().getClass();
            if (C0158a.m410f()) {
                return;
            }
            C12969a.m13872b(this.mSyncInfoSDocx.f262e).m13880i();
        }
    }

    private boolean checkServiceKeyForEdp() throws SyncException {
        boolean zM5139e;
        if (C13567a.m14371a().m14372c()) {
            checkEdpDevice();
            if (TextUtils.isEmpty(C13569c.m14376d(this.mSyncInfoSDocx.f262e).m14380f())) {
                Context context = this.mSyncInfoSDocx.f262e;
                C6906i c6906i = new C6906i(8, false);
                c6906i.f4484c = null;
                c6906i.f4483b = context;
                int i = 0;
                zM5139e = false;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 3) {
                        break;
                    }
                    try {
                        zM5139e = c6906i.m5139e();
                    } catch (Exception e) {
                        AbstractC0000a.m22s("checkServiceKeyForEdp() : ", e, TAG);
                    }
                    if (zM5139e) {
                        break;
                    }
                    i = i2;
                }
            } else {
                C13569c c13569cM14376d = C13569c.m14376d(this.mSyncInfoSDocx.f262e);
                c13569cM14376d.getClass();
                try {
                    c13569cM14376d.f9619b.deleteKeys();
                } catch (Exception e2) {
                    AbstractC0000a.m22s("[EDP] deleteKeys() : ", e2, "KmxSdkManager");
                }
                zM5139e = true;
            }
        } else {
            zM5139e = true;
        }
        Debugger.m8615i(TAG, "checkServiceKeyForEdp() : " + zM5139e);
        return zM5139e;
    }

    private void doDeleteOperationsForTest() {
        if (mDeleteServerData) {
            C0322h.m670a().f821g.showInfo(this.mSyncInfoSDocx.f262e, ModelType.SYNC, "Del Notes start");
            C0077c c0077c = this.mSyncOperationSDocx.f286b;
            Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "deleteAllServerNotes() start");
            AbstractC0299q.m620b0("eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiTk9URSJ9");
            while (true) {
                C0097a c0097a = new C0097a();
                C0023f c0023fM56b = new C0028a(c0077c.f265h, c0077c.f262e, c0097a, C0145c.m331p("sync_v2_pref", "lastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiTk9URSJ9")).m56b();
                C0022e c0022e = (C0022e) c0023fM56b.f127c;
                if (c0022e == null) {
                    Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "deleteAllServerNotes() : no server change!");
                    break;
                }
                if (!c0022e.f119d) {
                    C6903f c6903f = c0077c.f265h;
                    Context context = c0077c.f262e;
                    new C0032e(c6903f, context, c0097a, c0022e.f116a, TimeManager.getCurrentTime(context)).m61b();
                    c0077c.f266i.m4886b(3, ((C0022e) c0023fM56b.f127c).f117b, "deleteAllServerNotes");
                    AbstractC0299q.m620b0(c0023fM56b.f125a);
                    if (!c0023fM56b.f126b) {
                        break;
                    }
                } else {
                    Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "deleteAllServerNotes() : already deleted!");
                    AbstractC0299q.m620b0(c0023fM56b.f125a);
                }
            }
            Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "deleteAllServerNotes() finish");
            C0322h.m670a().f821g.showInfo(this.mSyncInfoSDocx.f262e, ModelType.SYNC, "Del folder start");
            C0082h c0082h = this.mSyncOperationSDocx;
            c0082h.getClass();
            Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "deleteAllServerFolders() start");
            C0145c.m310R("sync_v2_pref", "folderLastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=");
            C0097a c0097a2 = new C0097a();
            C0077c c0077c2 = c0082h.f286b;
            C6903f c6903f2 = c0077c2.f265h;
            Context context2 = c0077c2.f262e;
            C6742k c6742kM15111b = new C14512a(c6903f2, context2, c0097a2, C0145c.m331p("sync_v2_pref", "folderLastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=")).m15111b();
            if (((C0021d) c6742kM15111b.f4111c) == null) {
                Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "deleteAllServerFolders() : No server change!");
            } else {
                new C13533a(context2);
                ArrayList<FolderNodeItem> arrayList = new ArrayList();
                Iterator it = ((C0021d) c6742kM15111b.f4111c).f114c.iterator();
                while (it.hasNext()) {
                    arrayList.add(C6735d.m4826b((NotesCategoryTreeEntity) it.next()));
                }
                arrayList.addAll(((C0021d) c6742kM15111b.f4111c).f115d);
                for (FolderNodeItem folderNodeItem : arrayList) {
                    if (!folderNodeItem.uUid.equals(PredefinedCategory.SCREEN_OFF_MEMO.getUuid()) && !folderNodeItem.uUid.equals(PredefinedCategory.MATH_NOTES.getUuid()) && !folderNodeItem.state.equals("deleted")) {
                        folderNodeItem.state = "deleted";
                    }
                }
                new C14512a(c0077c2.f265h, context2, c0097a2, new C0027j(arrayList, c0077c2)).m15112c();
                Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "deleteAllServerFolders() finish");
            }
            C0322h.m670a().f821g.showInfo(this.mSyncInfoSDocx.f262e, ModelType.SYNC, "Del folder finish");
            mDeleteServerData = false;
        }
    }

    private void doEdpUiTest() throws SyncException {
        if (SyncState.getEdpUiTest1State()) {
            throw new SyncException(600, "This is a EDP UI Test 1!");
        }
    }

    private boolean isCoeditBackgroundDownloadStopped() {
        return C0322h.m670a().f833s.isBackgroundDownloadStopped();
    }

    private boolean isCoeditBackgroundDownloading() {
        return C0322h.m670a().f833s.isBackgroundDownloading();
    }

    private void performTest() throws SyncException {
        if (!AbstractC4539a.m3210t()) {
            doEdpUiTest();
        }
        doDeleteOperationsForTest();
    }

    private void requestCoeditBackGroundDownload() {
        C0322h.m670a().f833s.requestBackgroundDownload();
    }

    private void requestCoeditResumeDownload() {
        C0322h.m670a().f833s.resumeBackgroundDownload();
    }

    public static synchronized void setDeleteServerData(boolean z) {
        mDeleteServerData = z;
    }

    private void stopCoeditBackGroundDownload() {
        C0322h.m670a().f833s.stopBackgroundDownload();
    }

    private void syncNewNote() throws Exception {
        C6904g c6904gM5132a = C6904g.m5132a();
        synchronized (c6904gM5132a) {
            if (c6904gM5132a.f4478a) {
                ((Timer) c6904gM5132a.f4479b).cancel();
                ((Timer) c6904gM5132a.f4479b).purge();
            }
        }
        C0077c c0077c = this.mSyncInfoSDocx;
        C0082h c0082h = this.mSyncOperationSDocx;
        InterfaceC14510a interfaceC14510a = this.mSyncTaskContact;
        C6904g c6904g = new C6904g();
        c6904g.f4479b = c0077c;
        c6904g.f4478a = false;
        if (interfaceC14510a.isCancelled()) {
            Debugger.m8607d("SyncSettings", "Cancelled SyncSettings");
        } else {
            AbstractC0153k.m374c("SyncSettings", "Password (downSync)");
            try {
                C0073a c0073a = new C0073a(1);
                C13573a c13573a = new C13573a(1);
                c0073a.f254b = c13573a;
                AbstractC0299q.m645p(c0077c.f265h, c0077c.f262e, new C0097a(), c0073a);
                C0026i c0026i = (C0026i) c13573a.f9635b;
                long jM328m = C0145c.m328m(0L, "serverPassword", "serverPasswordKey");
                long j = c0026i.f142c;
                if (j == 0) {
                    c6904g.f4478a = true;
                    Debugger.m8607d("SyncSettings", "handlePassword() : No password info!");
                } else if (c0082h.m216c() || j > jM328m) {
                    c6904g.m5135d(c0026i, j);
                } else if (j < jM328m) {
                    c6904g.f4478a = true;
                }
            } catch (Exception e) {
                if (!(e instanceof SyncException)) {
                    throw e;
                }
                C6904g.m5133b((SyncException) e);
            }
            if (interfaceC14510a.isCancelled()) {
                Debugger.m8607d("SyncSettings", "Cancelled SyncSettings");
            } else if (c6904g.f4478a && !c0082h.m216c()) {
                C0158a.m407a().getClass();
                if (!C0158a.m410f()) {
                    Debugger.m8615i("SyncSettings", "upSyncLocalChanges()");
                    try {
                        if (C0322h.m670a().f826l.isSetPassword(c0077c.f262e)) {
                            AbstractC0153k.m374c("SyncSettings", "Password (upSync)");
                            Context context = c0077c.f262e;
                            C0112b c0112b = new C0112b();
                            c0112b.f362a = context;
                            c0112b.f363b = new C13573a(1);
                            AbstractC0299q.m626e0(c0077c.f265h, c0077c.f262e, new C0097a(), c0112b);
                        }
                    } catch (Exception e2) {
                        if (!(e2 instanceof SyncException)) {
                            throw e2;
                        }
                        C6904g.m5133b((SyncException) e2);
                    }
                }
            }
        }
        int i = 0;
        boolean z = false;
        while (true) {
            int i2 = i + 1;
            if (z) {
                StringBuilder sbM778t = AbstractC0541b.m778t(i2, "syncNewNote() : ReSync Round #", ", SyncMsgType = ");
                sbM778t.append(this.mSyncInfoSDocx.f264g.f322a);
                Debugger.m8615i(TAG, sbM778t.toString());
                z = false;
            } else {
                StringBuilder sbM778t2 = AbstractC0541b.m778t(i2, "syncNewNote() : Round #", ", SyncMsgType = ");
                sbM778t2.append(this.mSyncInfoSDocx.f264g.f322a);
                Debugger.m8615i(TAG, sbM778t2.toString());
            }
            try {
                C6742k.m4841o().m4859q();
                C0052h c0052h = new C0052h(this.mSyncInfoSDocx, this.mSyncOperationSDocx, this.mSyncOperationSDoc, this.mSyncTaskContact, this.mSyncProgressListener);
                c0052h.m101j();
                new C0049e(this.mSyncInfoSDocx, this.mSyncOperationSDocx, this.mSyncTaskContact).m88e();
                c0052h.m100i(false);
                if (!StringUtil.isEmpty(this.mSyncInfoSDocx.f272o)) {
                    C0145c.m310R("sync_v2_pref", "folderLastChangePoint", this.mSyncInfoSDocx.f272o);
                    if ("eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=".equals(this.mSyncInfoSDocx.f272o)) {
                        this.mSyncInfoSDocx.f271n = true;
                    }
                }
                new C0091f(this.mSyncInfoSDocx, this.mSyncOperationSDocx, this.mSyncTaskContact).m234c();
            } catch (SyncException e3) {
                if (e3.getExceptionCode() != 507) {
                    throw e3;
                }
                z = true;
            } catch (RuntimeException e5) {
                Throwable cause = e5.getCause();
                if (!(cause instanceof SyncException)) {
                    throw e5;
                }
                SyncException syncException = (SyncException) cause;
                if (syncException.getExceptionCode() != 507) {
                    throw syncException;
                }
                z = true;
            }
            if ((!z && !this.mSyncInfoSDocx.f271n) || i2 > 3) {
                return;
            } else {
                i = i2;
            }
        }
    }

    private int syncOldNote() {
        AbstractC0153k.m374c(TAG, "Old note(S)");
        try {
            try {
                C0012a c0012a = this.mSyncInfoSDoc;
                c0012a.f264g = this.mSyncRequestInfo;
                C0013b c0013b = this.mSyncOperationSDoc;
                InterfaceC14510a interfaceC14510a = this.mSyncTaskContact;
                C6903f c6903f = new C6903f(13, false);
                c6903f.f4474b = c0012a;
                c6903f.f4475c = c0013b;
                c6903f.f4476d = interfaceC14510a;
                if (c6903f.m5123f() == 1) {
                    C0145c.m307O(this.mSyncInfoSDoc.f262e, 0L);
                    C0145c.m304L("SDocServerPush", "SDocServerPushKey", false);
                }
                AbstractC0153k.m379h(this.mSyncInfoSDocx.f262e, "SyncedOldNote");
                AbstractC0153k.m374c(TAG, "Old note(E)");
                return 0;
            } catch (Exception e) {
                Debugger.m8609e(TAG, "syncOldNote() failed" + e);
                C0145c.m307O(this.mContext, TimeManager.getCurrentTime());
                throw e;
            }
        } catch (Throwable th) {
            AbstractC0153k.m379h(this.mSyncInfoSDocx.f262e, "SyncedOldNote");
            throw th;
        }
    }

    private void syncSearchData() {
        C0077c c0077c = this.mSyncInfoSDocx;
        new C6747p(c0077c.f262e);
        Context context = c0077c.f262e;
        Context context2 = c0077c.f262e;
        AbstractC0153k.m373b(context);
        try {
            AbstractC0153k.m374c("SyncSearchData", "Search Data (downSync)");
            AbstractC0153k.m374c("SyncSearchData", "Search Data (upSync)");
            AbstractC0153k.m373b(context2);
        } finally {
            try {
                FileUtils.deleteFile(new File(C11971a.m13526c(context2)));
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("perform() : fail to delete the temp files : "), "SyncSearchData");
            }
        }
    }

    private void updateSyncTimeInfo() {
        C0077c c0077c = this.mSyncInfoSDocx;
        if (c0077c.f260c && c0077c.f261d) {
            C0145c.m308P(System.currentTimeMillis(), "SyncSuccessTime", "SyncSuccessTimeKey");
            Debugger.m8607d(TAG, "getSuccessfulSyncTime : " + AbstractC14517a.m15161u());
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.SyncBaseTask
    public int syncProgress() throws Exception {
        Debugger.m8615i(TAG, "Start syncProgress()[" + hashCode() + "] SyncMsgType = " + this.mSyncRequestInfo.f322a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iPerformPreJobs = performPreJobs();
        if (iPerformPreJobs != 0) {
            return iPerformPreJobs;
        }
        printCurrentInfo();
        performTest();
        checkChangesBeforeSync();
        checkPush();
        if (AbstractC4539a.m3210t() && !checkServiceKeyForEdp()) {
            return 1;
        }
        syncNewNote();
        int iSyncOldNote = syncOldNote();
        if (iSyncOldNote != 0) {
            return iSyncOldNote;
        }
        updateSyncTimeInfo();
        if (C0158a.m409d(this.mSyncInfoSDocx.f262e)) {
            if (isCoeditBackgroundDownloadStopped()) {
                requestCoeditResumeDownload();
            } else {
                requestCoeditBackGroundDownload();
            }
        }
        Debugger.m8615i(TAG, "Finish syncProgress()[" + hashCode() + "] : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return 0;
    }
}
