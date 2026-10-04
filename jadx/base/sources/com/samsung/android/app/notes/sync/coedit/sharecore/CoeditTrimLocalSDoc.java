package com.samsung.android.app.notes.sync.coedit.sharecore;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p075S.AbstractC0254f;
import p075S.AbstractC0267s;
import p086V.C0322h;
import p234q1.C14433b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditTrimLocalSDoc extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "ShareSingleTask$CoeditTrimLocalSDoc";
    private List<String> mLocalSpaceId = new ArrayList();
    private List<String> mLocalGroupId = new ArrayList();

    private void deleteSDoc(List<String> list) {
        NotesDocumentEntity notesDocumentEntityM9f;
        Context appContext = C0322h.m670a().f815a.getAppContext();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTempDataRepository();
        C14433b c14433b = new C14433b(12);
        for (String str : list) {
            if (str != null) {
                notesDocumentEntityM9f = AbstractC0000a.m9f(appContext, str);
                AbstractC0000a.m18o(appContext, appContext, appContext);
            } else {
                notesDocumentEntityM9f = null;
            }
            if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getIsDeleted() : 1) != 1) {
                StringBuilder sbM16m = AbstractC0000a.m16m("[SyncDelete] deleteAllNoteData, docUUID: ", str, " by ", "CoeditTrimLocalSDoc", ", callee: ");
                sbM16m.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
                Debugger.m8614f("WDocWriteResolver", sbM16m.toString());
                DocumentWriteResolver.deleteAllNoteData(appContext, str, 4);
                c14433b.m15037k(str);
            } else {
                Debugger.m8607d(TAG, str + " is already deleted!");
            }
        }
    }

    private void deleteSdocByGroupId(String str) {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        deleteSDoc(syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListByGroupIdCoedit(str));
    }

    private void deleteSdocBySpaceId(String str) {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        deleteSDoc(syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListBySpaceIdCoedit(str));
    }

    private List<String> getLocalGroupIdList() {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        List<String> localGroupIdListCoedit = syncNoteDataRepositoryCreateSyncNoteDataRepository.getLocalGroupIdListCoedit();
        StringBuilder sb = new StringBuilder("[CS9] Local Group ID List size : ");
        sb.append(localGroupIdListCoedit == null ? "0" : Integer.valueOf(localGroupIdListCoedit.size()));
        Debugger.m8607d(TAG, sb.toString());
        return localGroupIdListCoedit;
    }

    private List<String> getLocalSpaceIdList() {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        List<String> localSpaceIdListCoedit = syncNoteDataRepositoryCreateSyncNoteDataRepository.getLocalSpaceIdListCoedit();
        StringBuilder sb = new StringBuilder("[CS9] Local Space ID List size : ");
        sb.append(localSpaceIdListCoedit == null ? "0" : Integer.valueOf(localSpaceIdListCoedit.size()));
        Debugger.m8607d(TAG, sb.toString());
        return localSpaceIdListCoedit;
    }

    private boolean isNotExistGroupId(String str) {
        Debugger.m8607d(TAG, "[CS9] isNotExistGroupId agentCode : " + str);
        return Long.toString(ErrorCodeConvertor.GROUP_INVALID_GROUP_ID).equals(str) || Long.toString(ErrorCodeConvertor.GROUP_RESOURCE_NOT_FOUND).equals(str);
    }

    private void trimLocalSharedSdocByEmptyGroupId() {
        NotesDocumentEntity notesDocumentEntityM9f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        List<String> uuidListByGroupIdCoedit = syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListByGroupIdCoedit("");
        ArrayList arrayList = new ArrayList();
        for (String str : uuidListByGroupIdCoedit) {
            Context appContext2 = C0322h.m670a().f815a.getAppContext();
            if (str != null) {
                notesDocumentEntityM9f = AbstractC0000a.m9f(appContext2, str);
                AbstractC0000a.m18o(appContext2, appContext2, appContext2);
            } else {
                notesDocumentEntityM9f = null;
            }
            if (!TextUtils.isEmpty(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getMdeSpaceId() : "")) {
                if ("coedit:///".equals(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getCategoryUuid() : null)) {
                    arrayList.add(str);
                }
            }
        }
        deleteSDoc(arrayList);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        if (arrayList.isEmpty()) {
            Debugger.m8607d(TAG, "[CS9-1] Finish trim by empty group id. et = " + jElapsedRealtime2);
        } else {
            Debugger.m8614f(TAG, "[CS9-1] Finish trim by empty group id. size : " + arrayList.size() + ", et = " + jElapsedRealtime2);
        }
    }

    private void trimLocalSharedSdocByEmptySpaceId() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        List<String> uuidListBySpaceIdCoedit = syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListBySpaceIdCoedit("");
        deleteSDoc(uuidListBySpaceIdCoedit);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        if (uuidListBySpaceIdCoedit.isEmpty()) {
            Debugger.m8607d(TAG, "[CS2-1] Finish trim by empty space id. et = " + jElapsedRealtime2);
        } else {
            Debugger.m8614f(TAG, "[CS2-1] Finish trim by empty space id. size : " + uuidListBySpaceIdCoedit.size() + ", et = " + jElapsedRealtime2);
        }
    }

    private boolean trimLocalSharedSdocByGroupId() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<String> it = this.mLocalGroupId.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next != null && !next.isEmpty()) {
                if (isCancelled()) {
                    Debugger.m8607d(TAG, "[CS9-1] Finish trim by group id. cancelled.");
                    break;
                }
                try {
                    GroupResult groupResultM536b = AbstractC0254f.m536b(next);
                    if (groupResultM536b != null && groupResultM536b.getResult() == null && groupResultM536b.getStatus() != null && groupResultM536b.getStatus().getCode() == 101 && isNotExistGroupId(groupResultM536b.getStatus().getAgentCode())) {
                        Debugger.m8614f(TAG, "[CS9] Deleted group : " + next);
                        deleteSdocByGroupId(next);
                    }
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, AbstractC0000a.m15l("[CS9-2] Exception while requestGroup. [", next, "] "), TAG);
                }
            }
        }
        Debugger.m8607d(TAG, "[CS9-1] Finish trim by group id. et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return true;
    }

    private boolean trimLocalSharedSdocBySpaceId() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<String> it = this.mLocalSpaceId.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next != null && !next.isEmpty()) {
                if (isCancelled()) {
                    Debugger.m8607d(TAG, "[CS9-1] Finish trim by space id. cancelled.");
                    break;
                }
                try {
                    SpaceResult spaceResultM548f = AbstractC0267s.m548f(next);
                    if (spaceResultM548f != null && spaceResultM548f.getResult() == null && spaceResultM548f.getStatus() != null && spaceResultM548f.getStatus().getCode() == 107 && spaceResultM548f.getStatus().getAgentCode().equals(Long.toString(ErrorCodeConvertor.RESOURCE_NOT_FOUND))) {
                        Debugger.m8614f(TAG, "[CS9] Deleted space : " + next);
                        deleteSdocBySpaceId(next);
                    }
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, AbstractC0000a.m15l("[CS9-2] Exception while requestSpace. [", next, "] "), TAG);
                }
            }
        }
        Debugger.m8607d(TAG, "[CS9-1] Finish trim by space id. et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return true;
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        Debugger.m8607d(TAG, "[CS9] Start trim local coedit sdoc");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!C0145c.m334s(C0322h.m670a().f815a.getAppContext())) {
            Debugger.m8607d(TAG, "[CS9-2] Network is not connected. Skip trim local sdoc");
            return null;
        }
        if (isCancelled()) {
            Debugger.m8607d(TAG, "[CS9-1] Cancelled coedit sharing!");
            return null;
        }
        List<String> localGroupIdList = getLocalGroupIdList();
        this.mLocalGroupId = localGroupIdList;
        if (!localGroupIdList.isEmpty() && !trimLocalSharedSdocByGroupId() && isCancelled()) {
            Debugger.m8607d(TAG, "[CS9] Cancelled after trimming coedit sdoc by group id.");
            return null;
        }
        List<String> localSpaceIdList = getLocalSpaceIdList();
        this.mLocalSpaceId = localSpaceIdList;
        if (!localSpaceIdList.isEmpty()) {
            if (!trimLocalSharedSdocBySpaceId() && isCancelled()) {
                Debugger.m8607d(TAG, "[CS9-1] Cancelled after trimming coedit sdoc by space id.");
                return null;
            }
            trimLocalSharedSdocByEmptyGroupId();
            trimLocalSharedSdocByEmptySpaceId();
        }
        Debugger.m8607d(TAG, "[CS9-1] Finish trim local coedit sdoc, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return null;
    }
}
