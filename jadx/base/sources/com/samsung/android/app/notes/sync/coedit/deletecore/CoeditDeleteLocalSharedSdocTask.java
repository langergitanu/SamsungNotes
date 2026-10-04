package com.samsung.android.app.notes.sync.coedit.deletecore;

import android.content.Context;
import android.os.AsyncTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;
import p024F.C0084a;
import p024F.InterfaceC0085b;
import p079T.AbstractC0291i;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditDeleteLocalSharedSdocTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "CoeditDeleteLocalSharedSdocTask";
    private final boolean mDeleteFromLeave;
    private final String mId;
    private final InterfaceC0085b mListener;
    private final DeleteType mType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DeleteType {
        GROUP,
        ALL,
        GROUP_LEAVE
    }

    public CoeditDeleteLocalSharedSdocTask(DeleteType deleteType, String str, InterfaceC0085b interfaceC0085b) {
        this.mType = deleteType;
        this.mId = str;
        this.mListener = interfaceC0085b;
        this.mDeleteFromLeave = DeleteType.GROUP_LEAVE == deleteType;
    }

    private void deleteSdocFile(String str, DeleteCoeditNoteUseCase.ResultCallback resultCallback) {
        NotesDocumentEntity notesDocumentEntityM9f;
        Context context = getContext();
        if (str != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
            AbstractC0000a.m18o(context, context, context);
        } else {
            notesDocumentEntityM9f = null;
        }
        if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getIsDeleted() : 1) != 1) {
            if (this.mDeleteFromLeave) {
                AbstractC0291i.m566c(getContext(), str, 4);
                return;
            } else {
                AbstractC0291i.m565b(str, "SPACE_DELETION_FROM_SERVER", resultCallback);
                return;
            }
        }
        Debugger.m8607d(TAG, str + " is already deleted!");
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
        int i = AbstractC6667a.f3946a[this.mType.ordinal()];
        if (i == 1 || i == 2) {
            if (isValidId(this.mId)) {
                return syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListByGroupIdCoedit(this.mId);
            }
            return null;
        }
        if (i == 3) {
            return syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListCoedit();
        }
        Debugger.m8607d(TAG, "getSDocListById. Type error : " + this.mType);
        return null;
    }

    private boolean isValidId(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doInBackground$0(List list, String str, int i) {
        if (i == 300) {
            list.add(str);
        }
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        Debugger.m8607d(TAG, "Start delete local coedit sdoc. Type : " + this.mType + ", ID : " + this.mId);
        Thread.currentThread().setName(TAG);
        List<String> sDocListById = getSDocListById();
        if (sDocListById == null) {
            Debugger.m8609e(TAG, "Invalid parameters. Skip deletion.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : sDocListById) {
            deleteSdocFile(str, new C0084a(arrayList, str));
        }
        Debugger.m8607d(TAG, "Delete space. total : " + sDocListById.size() + ", success : " + arrayList.size());
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Void r12) {
        super.onPostExecute(r12);
        InterfaceC0085b interfaceC0085b = this.mListener;
        if (interfaceC0085b != null) {
            interfaceC0085b.onDeleteLocalSharedSdocFinished();
        }
    }
}
