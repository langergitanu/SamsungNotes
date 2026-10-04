package p083U;

import android.content.Context;
import android.os.SystemClock;
import com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.ShareSingleTask;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p075S.AbstractC0248O;
import p075S.AbstractC0272x;
import p075S.C0238E;
import p086V.C0322h;
import p212o1.C13573a;

/* JADX INFO: renamed from: U.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0308e {

    /* JADX INFO: renamed from: a */
    public List f789a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public List f790b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final InterfaceC0307d f791c;

    public C0308e(InterfaceC0307d interfaceC0307d) {
        this.f791c = interfaceC0307d;
    }

    /* JADX INFO: renamed from: a */
    public static void m658a(List list) {
        NotesDocumentEntity notesDocumentEntityM9f;
        Context appContext = C0322h.m670a().f815a.getAppContext();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTempDataRepository();
        SyncDelayInfoDao syncDelayInfoDao = NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null) {
                notesDocumentEntityM9f = AbstractC0000a.m9f(appContext, str);
                AbstractC0000a.m18o(appContext, appContext, appContext);
            } else {
                notesDocumentEntityM9f = null;
            }
            if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getIsDeleted() : 1) != 1) {
                StringBuilder sbM15l = AbstractC0000a.m15l("[SyncDelete] deleteAllNoteData, docUUID: ", str, " by TrimLocalSDoc, callee: ");
                sbM15l.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
                Debugger.m8614f("WDocWriteResolver", sbM15l.toString());
                DocumentWriteResolver.deleteAllNoteData(appContext, str, 4);
                Debugger.m8614f("SyncDelayInfoRepository", "delete, uuid : " + str);
                syncDelayInfoDao.delete(str);
            } else {
                Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", str + " is already deleted!");
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m659b(String str) {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        m658a(syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListByGroupIdOld(str));
    }

    /* JADX INFO: renamed from: c */
    public static void m660c(String str) {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        m658a(syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListBySpaceIdOld(str));
    }

    /* JADX INFO: renamed from: d */
    public final void m661d() {
        SpaceResult spaceResult;
        Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "[Start trim local shared sdoc.]");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!C0145c.m334s(C0322h.m670a().f815a.getAppContext())) {
            Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "Network is not connected. Skip trim local sdoc.");
            return;
        }
        if (C0145c.m333r(C0322h.m670a().f815a.getAppContext())) {
            Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "wifi only share enabled. Skip trim local sdoc.");
            return;
        }
        if (((ShareSingleTask) ((C13573a) this.f791c).f9635b).isCancelled()) {
            Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "Cancelled sharing!");
            return;
        }
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        List<String> localGroupIdListOldSharedNote = syncNoteDataRepositoryCreateSyncNoteDataRepository.getLocalGroupIdListOldSharedNote();
        StringBuilder sb = new StringBuilder("Local Group ID List size : ");
        sb.append(localGroupIdListOldSharedNote == null ? "null" : Integer.valueOf(localGroupIdListOldSharedNote.size()));
        Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", sb.toString());
        this.f790b = localGroupIdListOldSharedNote;
        if (!localGroupIdListOldSharedNote.isEmpty()) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            for (String str : this.f790b) {
                if (str != null && !str.isEmpty()) {
                    try {
                        GroupResult groupResultM552c = AbstractC0272x.m552c(str);
                        if (groupResultM552c != null && groupResultM552c.getResult() == null && groupResultM552c.getStatus() != null && groupResultM552c.getStatus().getCode() == 101) {
                            String agentCode = groupResultM552c.getStatus().getAgentCode();
                            Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "isNotExistGroupId agentCode : " + agentCode);
                            if (Long.toString(ErrorCodeConvertor.GROUP_INVALID_GROUP_ID).equals(agentCode) || Long.toString(ErrorCodeConvertor.GROUP_RESOURCE_NOT_FOUND).equals(agentCode)) {
                                Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "Deleted group : " + str);
                                m659b(str);
                            }
                        }
                    } catch (Exception e) {
                        AbstractC0000a.m21r(e, AbstractC0000a.m15l("Exception while requestGroup. [", str, "] "), "ShareSingleTask$TrimLocalSDoc");
                    }
                }
            }
            Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "Finish trim by group id. et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
        }
        Context appContext2 = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(appContext2).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext2).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext2).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext2).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        List<String> localSpaceIdListOldSharedNote = syncNoteDataRepositoryCreateSyncNoteDataRepository2.getLocalSpaceIdListOldSharedNote();
        StringBuilder sb2 = new StringBuilder("Local Space ID List size : ");
        sb2.append(localSpaceIdListOldSharedNote != null ? Integer.valueOf(localSpaceIdListOldSharedNote.size()) : "null");
        Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", sb2.toString());
        this.f789a = localSpaceIdListOldSharedNote;
        if (!localSpaceIdListOldSharedNote.isEmpty()) {
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            for (String str2 : this.f789a) {
                if (str2 != null && !str2.isEmpty()) {
                    try {
                        CompletableFuture completableFuture = new CompletableFuture();
                        if (AbstractC0248O.m527a().requestSpace(str2, new C0238E(completableFuture)) == 1) {
                            spaceResult = (SpaceResult) completableFuture.get(100000L, TimeUnit.MILLISECONDS);
                        } else {
                            Debugger.m8609e("SesShareApi", "Fail to requestSpace");
                            spaceResult = null;
                        }
                        if (spaceResult != null && spaceResult.getResult() == null && spaceResult.getStatus() != null && spaceResult.getStatus().getCode() == 107 && spaceResult.getStatus().getAgentCode().equals(Long.toString(ErrorCodeConvertor.RESOURCE_NOT_FOUND))) {
                            Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "Deleted space : " + str2);
                            m660c(str2);
                        }
                    } catch (Exception e2) {
                        AbstractC0000a.m21r(e2, AbstractC0000a.m15l("Exception while requestSpace. [", str2, "] "), "ShareSingleTask$TrimLocalSDoc");
                    }
                }
            }
            Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "Finish trim by space id. et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime3));
        }
        Debugger.m8607d("ShareSingleTask$TrimLocalSDoc", "[Finish trim local shared sdoc.] et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }
}
