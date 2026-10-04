package com.samsung.android.app.notes.sync.contentsharing.deletecore;

import android.content.Context;
import android.os.AsyncTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p056N.InterfaceC0179a;
import p086V.C0322h;
import p234q1.C14433b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DeleteLocalSharedSdocTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "DeleteLocalSharedSdocTask";
    private final String mId;
    private final InterfaceC0179a mListener;
    private final DeleteType mType;
    private String mUserId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DeleteType {
        GROUP,
        SPACE,
        ALL,
        MEMBER
    }

    public DeleteLocalSharedSdocTask(DeleteType deleteType, String str, InterfaceC0179a interfaceC0179a) {
        this.mUserId = null;
        this.mType = deleteType;
        this.mId = str;
        this.mListener = interfaceC0179a;
    }

    private boolean deleteSdocFile(String str) {
        NotesDocumentEntity notesDocumentEntityM9f;
        Context context = getContext();
        if (str != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
            AbstractC0000a.m18o(context, context, context);
        } else {
            notesDocumentEntityM9f = null;
        }
        Context context2 = getContext();
        NotesDataRepositoryFactory.newInstance(context2).createDocumentDataRepository();
        NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(context2).createDocumentTempDataRepository();
        C14433b c14433b = new C14433b(12);
        if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getIsDeleted() : 1) != 1) {
            StringBuilder sbM16m = AbstractC0000a.m16m("[SyncDelete] deleteAllNoteData, docUUID: ", str, " by ", TAG, ", callee: ");
            sbM16m.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            Debugger.m8614f("WDocWriteResolver", sbM16m.toString());
            DocumentWriteResolver.deleteAllNoteData(context2, str, 4);
            c14433b.m15037k(str);
        } else {
            Debugger.m8607d(TAG, str + " is already deleted!");
        }
        return true;
    }

    private Context getContext() {
        return C0322h.m670a().f815a.getAppContext();
    }

    private List<String> getSDocListById() {
        Context context = getContext();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(context).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        int i = AbstractC6685a.f3987a[this.mType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListMde();
                }
                if (i != 4) {
                    Debugger.m8607d(TAG, "getSDocListById. Type error : " + this.mType);
                    return null;
                }
                if (isValidId(this.mId) && isValidId(this.mUserId)) {
                    return syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListByGroupIdAndOwnerIdOld(this.mId, this.mUserId);
                }
            } else if (isValidId(this.mId)) {
                return syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListBySpaceIdOld(this.mId);
            }
        } else if (isValidId(this.mId)) {
            return syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListByGroupIdOld(this.mId);
        }
        return null;
    }

    private boolean isValidId(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        Debugger.m8607d(TAG, "Start delete local shared sdoc. Type : " + this.mType + ", ID : " + this.mId + ", UserID : " + this.mUserId);
        Thread.currentThread().setName(TAG);
        List<String> sDocListById = getSDocListById();
        if (sDocListById == null) {
            Debugger.m8609e(TAG, "Invalid parameters. Skip deletion.");
            return null;
        }
        Iterator<String> it = sDocListById.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (deleteSdocFile(it.next())) {
                i++;
            }
        }
        Debugger.m8607d(TAG, "Delete space. total : " + sDocListById.size() + ", success : " + i);
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Void r12) {
        super.onPostExecute(r12);
        InterfaceC0179a interfaceC0179a = this.mListener;
        if (interfaceC0179a != null) {
            interfaceC0179a.onDeleteLocalSharedSdocFinished();
        }
    }

    public DeleteLocalSharedSdocTask(DeleteType deleteType, String str, String str2, InterfaceC0179a interfaceC0179a) {
        this(deleteType, str, interfaceC0179a);
        this.mUserId = str2;
    }
}
