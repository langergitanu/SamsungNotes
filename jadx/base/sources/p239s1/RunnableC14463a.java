package p239s1;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteInfo;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import p008B1.C0028a;
import p026F1.C0097a;
import p034H1.C0115c;
import p042J1.C0145c;
import p186h1.C12020a;

/* JADX INFO: renamed from: s1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC14463a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final Context f10251a = BaseUtils.getApplicationContext();

    /* JADX INFO: renamed from: b */
    public final String f10252b;

    /* JADX INFO: renamed from: c */
    public final IServerNoteInfoListener f10253c;

    /* JADX INFO: renamed from: d */
    public final String f10254d;

    /* JADX INFO: renamed from: e */
    public String f10255e;

    /* JADX INFO: renamed from: f */
    public C6903f f10256f;

    public RunnableC14463a(String str, IServerNoteInfoListener iServerNoteInfoListener, String str2) {
        this.f10252b = str;
        this.f10253c = iServerNoteInfoListener;
        this.f10254d = str2;
    }

    /* JADX INFO: renamed from: a */
    public final void m15050a() {
        IServerNoteInfoListener iServerNoteInfoListener = this.f10253c;
        if (iServerNoteInfoListener != null) {
            try {
                iServerNoteInfoListener.onFailed(201);
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("handleErrorResult() : fail to call , "), "ServerNoteInfoTask");
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m15051b(ServerNoteInfo serverNoteInfo) {
        IServerNoteInfoListener iServerNoteInfoListener = this.f10253c;
        if (iServerNoteInfoListener != null) {
            try {
                iServerNoteInfoListener.onReceived(serverNoteInfo);
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("handleResult() : fail to call , "), "ServerNoteInfoTask");
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository;
        String str;
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2;
        String str2;
        IServerNoteInfoListener iServerNoteInfoListener = this.f10253c;
        Debugger.m8615i("ServerNoteInfoTask", "start run()");
        Thread.currentThread().setName("ServerNoteInfoTask");
        C6903f c6903f = new C6903f(this.f10252b);
        this.f10256f = c6903f;
        c6903f.m5130o(1024);
        this.f10256f.m5131p("ND");
        NotesDocumentEntity notesDocumentEntity = null;
        Context context = this.f10251a;
        String str3 = this.f10254d;
        if (str3 != null) {
            NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(str3);
            syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
            NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            str = str3;
        } else {
            syncNoteDataRepositoryCreateSyncNoteDataRepository = null;
            str = null;
        }
        String serverId = syncNoteDataRepositoryCreateSyncNoteDataRepository != null ? syncNoteDataRepositoryCreateSyncNoteDataRepository.getServerId(str) : "";
        this.f10255e = serverId;
        if (TextUtils.isEmpty(serverId)) {
            ServerNoteInfo serverNoteInfo = new ServerNoteInfo();
            serverNoteInfo.setExists(false);
            m15051b(serverNoteInfo);
            return;
        }
        try {
            C12020a c12020aM57c = new C0028a(this.f10256f, context, new C0097a(), this.f10255e).m57c();
            ServerNoteInfo serverNoteInfo2 = (ServerNoteInfo) c12020aM57c.f8772b;
            if (iServerNoteInfoListener != null) {
                try {
                    if (serverNoteInfo2.isExists()) {
                        if (serverNoteInfo2.getIsHighFormatVer()) {
                            new C0115c(str3).m277a(context, new C6748q(context, str3));
                        }
                        if (serverNoteInfo2.getModifiedTime() == 0) {
                            m15050a();
                        } else {
                            m15051b(serverNoteInfo2);
                        }
                    } else {
                        if (str3 != null) {
                            notesDocumentEntity = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(str3);
                            syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
                            NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
                            NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                            str2 = str3;
                        } else {
                            syncNoteDataRepositoryCreateSyncNoteDataRepository2 = null;
                            str2 = null;
                        }
                        if ((notesDocumentEntity != null ? notesDocumentEntity.getIsDirty() : 0) == 1) {
                            Debugger.m8609e("ServerNoteInfoTask", "run() : Server note is deleted. So if the local note is updated(or conflicted), reset the state of it");
                            NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
                            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository3 = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
                            NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                            syncNoteDataRepositoryCreateSyncNoteDataRepository3.resetDeletedNoteInServer(str3);
                        }
                        if (((syncNoteDataRepositoryCreateSyncNoteDataRepository2 != null ? syncNoteDataRepositoryCreateSyncNoteDataRepository2.getNoteSyncState(str2) : 0L) & 32768) == 32768) {
                            Context applicationContext = BaseUtils.getApplicationContext();
                            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
                            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository4 = NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
                            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                            syncNoteDataRepositoryCreateSyncNoteDataRepository4.removeNoteSyncStateFlag(str3, 32768L);
                        }
                        C0145c.m302J("SyncControlLowVersionNote", str3);
                        m15050a();
                    }
                } catch (Exception e) {
                    Debugger.m8609e("ServerNoteInfoTask", "run() : fail to call onReceived , " + e.toString());
                }
            } else {
                Debugger.m8609e("ServerNoteInfoTask", "run() : no listener");
            }
            ((ServerNoteInfo) c12020aM57c.f8772b).printServerNoteInfo();
        } catch (Exception e2) {
            AbstractC4539a.m3213w(e2, new StringBuilder("fail to get server note info : "), "ServerNoteInfoTask");
            if (iServerNoteInfoListener != null) {
                try {
                    m15050a();
                } catch (Exception unused) {
                    AbstractC4539a.m3213w(e2, new StringBuilder("run() : fail to call onFailed , "), "ServerNoteInfoTask");
                }
            }
        }
    }
}
