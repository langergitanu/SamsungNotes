package com.samsung.android.app.notes.sync.synchronization.controllers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.common.SyncInitState$InitState;
import com.samsung.android.app.notes.sync.synchronization.managers.C6899b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.app.notes.sync.synchronization.services.SyncOldService;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.TemporalServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.util.LinkedList;
import p001A.AbstractC0000a;
import p007B0.C0027j;
import p010C.C0042g;
import p026F1.AbstractC0100d;
import p026F1.C0099c;
import p038I1.C0137m;
import p042J1.AbstractC0146d;
import p042J1.AbstractC0153k;
import p042J1.C0145c;
import p042J1.C0154l;
import p044K.AbstractC0159b;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p195k1.C12969a;
import p249v1.C14499b;
import p249v1.C14500c;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.controllers.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class C6896g implements InterfaceC6893d {

    /* JADX INFO: renamed from: k */
    public static final Object f4448k = new Object();

    /* JADX INFO: renamed from: l */
    public static boolean f4449l;

    /* JADX INFO: renamed from: m */
    public static boolean f4450m;

    /* JADX INFO: renamed from: n */
    public static boolean f4451n;

    /* JADX INFO: renamed from: c */
    public final Context f4454c;

    /* JADX INFO: renamed from: d */
    public SyncOldService f4455d;

    /* JADX INFO: renamed from: f */
    public boolean f4457f;

    /* JADX INFO: renamed from: a */
    public SyncOldServiceController$ServiceState f4452a = SyncOldServiceController$ServiceState.STOPPED;

    /* JADX INFO: renamed from: b */
    public boolean f4453b = false;

    /* JADX INFO: renamed from: e */
    public final LinkedList f4456e = new LinkedList();

    /* JADX INFO: renamed from: g */
    public long f4458g = 0;

    /* JADX INFO: renamed from: h */
    public boolean f4459h = true;

    /* JADX INFO: renamed from: i */
    public final ServiceConnection f4460i = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.synchronization.controllers.SyncOldServiceController$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Debugger.m8615i("SyncOldServiceController", "onServiceConnected() start");
            synchronized (C6896g.f4448k) {
                C6896g c6896g = this.this$0;
                c6896g.f4457f = true;
                try {
                    c6896g.f4455d = ((SyncOldService.LocalBinder) iBinder).getService();
                    this.this$0.f4452a = SyncOldServiceController$ServiceState.CONNECTED;
                    while (this.this$0.f4456e.peek() != null) {
                        ((C6895f) this.this$0.f4456e.poll()).m5094a(this.this$0.f4455d);
                        C6896g c6896g2 = this.this$0;
                        if (!c6896g2.f4453b) {
                            c6896g2.f4453b = true;
                        }
                    }
                } catch (Exception e) {
                    Debugger.m8609e("SyncOldServiceController", "onServiceConnected() : Exception = " + e.toString());
                }
                this.this$0.f4457f = false;
            }
            Debugger.m8607d("SyncOldServiceController", "onServiceConnected() finish");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Debugger.m8615i("SyncOldServiceController", "onServiceDisconnected()");
            this.this$0.m5098g();
        }
    };

    /* JADX INFO: renamed from: j */
    public final C6890a f4461j = new C6890a(this, 1);

    public C6896g(Context context) {
        this.f4454c = context;
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.controllers.InterfaceC6893d
    /* JADX INFO: renamed from: a */
    public void mo5089a(int i) {
        Debugger.m8615i("SyncOldServiceController", "stopSync() : " + i);
        C6899b.m5109a().f4467a = false;
        Debugger.m8615i("SyncOldServiceController", "executeAfterServiceReady() : " + this.f4452a);
        synchronized (f4448k) {
            try {
                SyncOldServiceController$ServiceState syncOldServiceController$ServiceState = this.f4452a;
                if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.STOPPED) {
                    Debugger.m8615i("SyncOldServiceController", "already stopped!");
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTING) {
                    this.f4456e.clear();
                    this.f4454c.unbindService(this.f4460i);
                    this.f4452a = SyncOldServiceController$ServiceState.DISCONNECTING;
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTED || syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.DISCONNECTING) {
                    this.f4455d.stopSync(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.controllers.InterfaceC6893d
    /* JADX INFO: renamed from: b */
    public void mo5090b(boolean z, boolean z2) {
        m5102l(z, z2, false);
    }

    /* JADX INFO: renamed from: c */
    public void mo5091c() {
        Debugger.m8607d("SyncOldServiceController", "connectingSyncService()");
        SyncOldService.setServiceContract(this.f4461j);
        Context context = this.f4454c;
        context.bindService(new Intent(context, (Class<?>) SyncOldService.class), this.f4460i, 1);
        this.f4452a = SyncOldServiceController$ServiceState.CONNECTING;
    }

    /* JADX INFO: renamed from: d */
    public final void m5095d(C6895f c6895f) {
        Debugger.m8615i("SyncOldServiceController", "serviceState = " + this.f4452a);
        synchronized (f4448k) {
            try {
                this.f4457f = true;
                SyncOldServiceController$ServiceState syncOldServiceController$ServiceState = this.f4452a;
                if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.STOPPED) {
                    this.f4456e.offer(c6895f);
                    mo5091c();
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTING) {
                    this.f4456e.offer(c6895f);
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.CONNECTED) {
                    c6895f.m5094a(this.f4455d);
                } else if (syncOldServiceController$ServiceState == SyncOldServiceController$ServiceState.DISCONNECTING) {
                    this.f4456e.offer(c6895f);
                }
                this.f4457f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final boolean m5096e(C0099c c0099c, String str) {
        boolean z;
        boolean zM5099h = m5099h();
        Context context = this.f4454c;
        if (zM5099h || TextUtils.isEmpty(AbstractC14517a.f10346a)) {
            if (m5099h() || AbstractC14517a.f10347b == null) {
                z = false;
            } else {
                Debugger.m8615i("SyncOldServiceController", str.concat(" : pended due to the previous temporalServerNoteInfo!"));
                z = true;
            }
            if (z && !C0145c.m338w(context)) {
                C0145c.m309Q(context, Boolean.TRUE);
            }
            if (!z) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f4458g;
                if (jElapsedRealtime >= 1000) {
                    this.f4458g = SystemClock.elapsedRealtime();
                    if (!AbstractC0100d.f327a || (!TextUtils.isEmpty(c0099c.f325d) && c0099c.f324c == 1)) {
                        return false;
                    }
                    Debugger.m8615i("SyncOldServiceController", str.concat(" : pended due to the note being synced!"));
                    AbstractC0100d.f328b = true;
                    return true;
                }
                Debugger.m8615i("SyncOldServiceController", str + " : canceled due to the elapsed time = " + jElapsedRealtime);
                if (!C0145c.m338w(context)) {
                    C0145c.m309Q(context, Boolean.TRUE);
                }
            }
        } else {
            Debugger.m8615i("SyncOldServiceController", str.concat(" : pended due to the previous xxSyncFirstDocUuid!"));
            if (!C0145c.m338w(context)) {
                C0145c.m309Q(context, Boolean.TRUE);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final void m5097f(Context context, boolean z, Boolean bool) {
        if (!z) {
            f4449l = false;
            return;
        }
        if (f4449l && bool.booleanValue() == f4450m && f4451n == C0145c.m299G(context)) {
            Debugger.m8615i("SyncOldServiceController", "onNetworkConnected() : not changed!");
            return;
        }
        f4449l = true;
        f4450m = bool.booleanValue();
        f4451n = C0145c.m299G(context);
        if (bool.booleanValue()) {
            C0322h.m670a().f815a.reConnectedToWAN(context);
        } else {
            C0322h.m670a().f815a.reConnectedToMobile(context);
            if (f4451n) {
                mo5089a(105);
            }
        }
        try {
            if (C12969a.m13872b(context).m13874c()) {
                C12969a.m13872b(context).m13880i();
            }
            Context context2 = this.f4454c;
            Debugger.m8607d("SyncOldServiceController", "checkNeedToSyncWhenConnected()");
            if (m5099h() && C0145c.m338w(context2)) {
                C0145c.m309Q(context2, Boolean.FALSE);
                m5100j(new C0099c(32));
            }
        } catch (Exception e) {
            Debugger.m8609e("SyncOldServiceController", e.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004d, code lost:
    
        r0 = move-exception;
     */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5098g() {
        Object obj = f4448k;
        synchronized (obj) {
            try {
                SyncOldServiceController$ServiceState syncOldServiceController$ServiceState = SyncOldServiceController$ServiceState.STOPPED;
                this.f4452a = syncOldServiceController$ServiceState;
                if (this.f4456e.peek() != null) {
                    Debugger.m8615i("SyncOldServiceController", "handleServiceDisconnected() : isExecuted = " + this.f4453b);
                    if (!C0158a.m407a().m417k()) {
                        Debugger.m8615i("SyncOldServiceController", "handleServiceDisconnected() : clear ReqQueue <- " + this.f4456e.size());
                        this.f4456e.clear();
                    } else if (C0145c.m334s(this.f4454c) && this.f4453b) {
                        this.f4453b = false;
                        synchronized (obj) {
                            if (this.f4452a == syncOldServiceController$ServiceState) {
                                mo5091c();
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final boolean m5099h() {
        C14500c c14500c = C14499b.f10311e;
        if (c14500c != null) {
            z = c14500c.f10322a == 1;
            if (!z) {
                Debugger.m8615i("SyncLogic", "isNotSyncing : false, state = " + C14499b.f10311e.f10322a);
            }
        }
        if (z) {
            Debugger.m8607d("SyncLogic", "isNotSyncing : true");
        }
        return z;
    }

    /* JADX INFO: renamed from: i */
    public void mo5092i(C0099c c0099c) {
        C14500c c14500c = C14499b.f10311e;
        int i = c0099c.f322a;
        if (i == 1024) {
            int iM241c = AbstractC0100d.m241c();
            if (iM241c == 0) {
                m5095d(new C6895f(this, c0099c, 0));
                return;
            } else {
                AbstractC14517a.m15163w(iM241c, c0099c.f322a).mo4791d();
                return;
            }
        }
        int iM242d = AbstractC0100d.m242d(i);
        if (iM242d == 0) {
            m5095d(new C6895f(this, c0099c, 1));
        } else {
            AbstractC14517a.m15163w(iM242d, c0099c.f322a).mo4791d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x013b  */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5100j(C0099c c0099c) {
        boolean z;
        TemporalServerNoteInfo temporalServerNoteInfo;
        NotesDocumentEntity notesDocumentEntityM9f;
        Context context = this.f4454c;
        if (context == null) {
            if (BaseUtils.getApplicationContext() != null) {
                C0145c.m309Q(BaseUtils.getApplicationContext(), Boolean.TRUE);
            }
            Debugger.m8615i("SyncOldServiceController", "requestSync() : pended due to no sync initialization!");
            return;
        }
        if (AbstractC0159b.f493a != SyncInitState$InitState.initialized) {
            C0145c.m309Q(context, Boolean.TRUE);
            Debugger.m8615i("SyncOldServiceController", "requestSync() : pended due to no sync initialization and setNeededToSync!");
            return;
        }
        if (BaseUtils.getApplicationContext() == null) {
            C0145c.m309Q(context, Boolean.TRUE);
            Debugger.m8615i("SyncOldServiceController", "requestSync() : pended due to no app initialization!");
            return;
        }
        int i = c0099c.f322a;
        if ((i & 512) == 512 || (i & 64) == 64) {
            try {
                boolean zM299G = C0145c.m299G(BaseUtils.getApplicationContext());
                boolean zM298F = C0145c.m298F(BaseUtils.getApplicationContext());
                AbstractC0299q.m604N("5037", zM299G ? zM298F ? "a" : "d" : zM298F ? "b" : "c");
            } catch (Exception e) {
                Logger.m8698e("SyncSALoggingHelper", e.toString());
            }
            if (C0322h.m670a().f833s.isBackgroundDownloading()) {
                C0322h.m670a().f833s.stopBackgroundDownload();
            }
        }
        String str = "Sync(S) : " + c0099c.f322a;
        C0027j c0027j = AbstractC0153k.f465a;
        long currentTime = TimeManager.getCurrentTime();
        C0154l c0154lM383a = C0154l.m383a();
        c0154lM383a.f472e = currentTime;
        c0154lM383a.f468a = currentTime;
        c0154lM383a.f471d = currentTime;
        C0154l.m383a().m385c(currentTime, "SyncOldServiceController", str);
        C6906i c6906iM5136c = C6906i.m5136c();
        c6906iM5136c.getClass();
        Debugger.m8607d("SyncStateManager", "clearSyncFailState()");
        c6906iM5136c.f4484c = SyncStateManager$SyncFailState.NETWORK;
        if (!DeviceUtils.isSupportedSync(C0158a.m407a().f492a)) {
            Debugger.m8615i("SyncOldServiceController", "skip requestSync due to sync feature not supported!");
            return;
        }
        if (c0099c.f322a == 1024) {
            mo5092i(c0099c);
            return;
        }
        if (AbstractC0146d.m346e(context)) {
            Debugger.m8615i("SyncOldServiceController", "skip requestSync due to no SCloud package!");
            return;
        }
        int i2 = c0099c.f322a;
        boolean z2 = true;
        if (i2 != 1) {
            if (i2 == 2 || i2 == 4) {
                if (m5096e(c0099c, "handlePush()")) {
                    return;
                }
                if (C0322h.m670a().f833s.isBackgroundDownloading()) {
                    C0322h.m670a().f833s.stopBackgroundDownload();
                }
            } else if (i2 == 8) {
                if (m5099h()) {
                    z2 = false;
                } else {
                    Debugger.m8615i("SyncOldServiceController", "handleBackground() : skip due to the syncing state!");
                    if (!C0145c.m338w(context)) {
                        C0145c.m309Q(context, Boolean.TRUE);
                    }
                }
                if (z2) {
                    return;
                }
            } else if (i2 != 16) {
                if (i2 == 4096) {
                    if (ComposerManager.getInstance().isRunningOnEditMode()) {
                        Debugger.m8615i("SyncOldServiceController", "checkAndRequestSyncMsFeed() : cancel the synchronization for MS feed!");
                        return;
                    } else if (m5099h()) {
                        new SenlThreadFactory("checkAndRequestSyncMsFeed").newThread(new RunnableC6894e(this)).start();
                        return;
                    } else {
                        Debugger.m8615i("SyncOldServiceController", "checkAndRequestSyncMsFeed() : pended due to the ongoing synchronization!");
                        return;
                    }
                }
                if ((i2 & 64) == 64) {
                    String str2 = c0099c.f323b;
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = AbstractC14517a.f10346a;
                        if (!str2.equals(str3) || m5099h()) {
                            String str4 = c0099c.f325d;
                            if (TextUtils.isEmpty(str4)) {
                                TemporalServerNoteInfo temporalServerNoteInfo2 = c0099c.f326e;
                                if (temporalServerNoteInfo2 == null || (temporalServerNoteInfo = AbstractC14517a.f10347b) == null || !temporalServerNoteInfo.getDocUuid().equals(temporalServerNoteInfo2.getDocUuid()) || m5099h()) {
                                    z = false;
                                } else {
                                    Debugger.m8615i("SyncOldServiceController", "handleSameSyncServerNoteTemporarilyRequest() : skip handleSameSyncServerNoteTemporarilyRequest, " + temporalServerNoteInfo2.getDocUuid());
                                    z = true;
                                }
                                if (!z) {
                                }
                            } else if (c0099c.f324c == 3) {
                                SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(context, context);
                                NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
                                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                long currentTime2 = TimeManager.getCurrentTime(context);
                                Debugger.m8614f("SyncOldServiceController", "handleConflictedNote() : " + str4 + ", ct = " + currentTime2);
                                syncNoteDataRepositoryM3196f.updateServerTimestamp(str4, currentTime2);
                                if (str4 != null) {
                                    notesDocumentEntityM9f = AbstractC0000a.m9f(context, str4);
                                    AbstractC0000a.m18o(context, context, context);
                                } else {
                                    notesDocumentEntityM9f = null;
                                }
                                if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getIsDirty() : 0) != 1) {
                                    Debugger.m8615i("SyncOldServiceController", "handleConflictedNote() : Set dirty = " + str4);
                                    syncNoteDataRepositoryM3196f.updateDirty(str4, 1);
                                }
                            }
                            z2 = false;
                        } else {
                            Debugger.m8615i("SyncOldServiceController", "handleSameSyncFirstRequest() : skip requestSyncUpFirst = " + str3);
                        }
                        if (z2) {
                            return;
                        }
                    }
                }
            } else if (!m5099h()) {
                C0145c.m309Q(context, Boolean.TRUE);
                Debugger.m8615i("SyncOldServiceController", "requestSync() : pended due to the ongoing synchronization!");
                return;
            }
        } else if (m5096e(c0099c, "handleModification()")) {
            return;
        }
        mo5092i(c0099c);
    }

    /* JADX INFO: renamed from: k */
    public final void m5101k(boolean z, boolean z2) {
        Debugger.m8615i("SyncOldServiceController", "requestSync() : byUser = " + z + " , byUserClickSyncEnable = " + z2);
        PostLaunchManager.getInstance().executeBaseLogic(301);
        int i = 8;
        C0099c c0099c = new C0099c(8);
        if (z) {
            if (C0145c.m294B()) {
                C0145c.m304L("Settings", SettingsConstants.SETTINGS_BLOCKING_SYNC, false);
            }
            i = 64;
            c0099c.f322a = 64;
        }
        if (z2) {
            c0099c.f322a = i | 512;
        }
        m5100j(c0099c);
    }

    /* JADX INFO: renamed from: l */
    public final void m5102l(boolean z, boolean z2, boolean z3) {
        Context context = this.f4454c;
        if (z2 && !C0145c.m295C(context)) {
            C0145c.m312T(context, Boolean.TRUE);
        }
        if (!z) {
            Debugger.m8615i("SyncOldServiceController", "set sync disabled by settings");
            mo5089a(106);
            C0145c.m311S(context, Boolean.valueOf(z));
            C0322h.m670a().f818d.cancelAllSyncNotification();
            C0137m.m280d().m287h();
            C12969a.m13872b(context).m13882k();
            return;
        }
        Debugger.m8615i("SyncOldServiceController", "set sync enabled by settings : " + z2);
        C0145c.m311S(context, Boolean.valueOf(z));
        if (C12969a.m13872b(context).m13874c()) {
            C12969a.m13872b(context).m13880i();
        }
        m5101k(false, z3);
        C0145c.m304L("pref_sync_logging", "pref_sync_number_of_deleted_notes_reported", true);
    }

    /* JADX INFO: renamed from: m */
    public final void m5103m(Context context, boolean z, boolean z2) {
        C0145c.m314V(context, Boolean.valueOf(z));
        m5097f(context, C0145c.m334s(context), Boolean.valueOf(C0145c.m298F(context)));
        if (z2) {
            return;
        }
        C0042g c0042gM78a = C0042g.m78a(context);
        if (c0042gM78a.m79b()) {
            c0042gM78a.f186b.mo69f(z);
        } else {
            Debugger.m8609e("SCRPCSettingManager", "notifyNetworkOptionChanged() : fail!");
        }
    }
}
