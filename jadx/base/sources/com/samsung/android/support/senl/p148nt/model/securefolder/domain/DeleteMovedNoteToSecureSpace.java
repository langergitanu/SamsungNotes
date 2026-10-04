package com.samsung.android.support.senl.p148nt.model.securefolder.domain;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.domain.note.DeleteNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderUtils;
import com.samsung.android.support.senl.p148nt.model.securefolder.repository.SecureFolderDataRepository;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DeleteMovedNoteToSecureSpace implements Runnable {
    private static final String TAG = ModelLogger.createSecureFolderTag("DeleteMovedNoteToSecureSpace");
    private final Context mAppContext;
    private final List<String> mPaths;

    public DeleteMovedNoteToSecureSpace(@NonNull Context context, @NonNull List<String> list) {
        this.mAppContext = context;
        this.mPaths = list;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public void run() {
        String tempDirPath = SecureFolderUtils.getTempDirPath(this.mAppContext);
        if (tempDirPath.isEmpty()) {
            DataLogger.m12303e(TAG, "deleteNote, temp dir path is empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        SecureFolderDataRepository secureFolderDataRepository = new SecureFolderDataRepository();
        for (String str : this.mPaths) {
            if (TextUtils.isEmpty(str) || !str.startsWith(tempDirPath)) {
                DataLogger.m12303e(TAG, "deleteNote, invalid path: " + DataLogger.getEncode(str));
            } else {
                String documentUuid = secureFolderDataRepository.getDocumentUuid(str);
                if (TextUtils.isEmpty(documentUuid)) {
                    AbstractC11014a.m12314C("deleteNote, invalid uuid: ", documentUuid, TAG);
                } else {
                    secureFolderDataRepository.removeDocumentUuid(str);
                    arrayList.add(documentUuid);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        List<NotesDocumentEntity> entitiesByUuids = NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentDataRepository().getEntitiesByUuids(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (NotesDocumentEntity notesDocumentEntity : entitiesByUuids) {
            if (notesDocumentEntity.getIsDeleted() == 1) {
                DataLogger.m12309w(TAG, "deleteNote, uuid: " + notesDocumentEntity.getUuid() + " is already deleted!");
            } else {
                arrayList2.add(notesDocumentEntity.getUuid());
            }
        }
        new DeleteNoteUseCase().invoke(new DeleteNoteUseCase.Param(this.mAppContext, arrayList2, 0, 1, TAG));
    }
}
