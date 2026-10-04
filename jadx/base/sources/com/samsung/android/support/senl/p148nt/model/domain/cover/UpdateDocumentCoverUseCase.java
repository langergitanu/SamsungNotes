package com.samsung.android.support.senl.p148nt.model.domain.cover;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.NotesSQLiteConstraintException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UpdateDocumentCoverUseCase {
    private static final String TAG = ModelLogger.createTag("UpdateDocumentCoverUseCase");
    private final NotesDocumentCoverRepository mRepository;

    public UpdateDocumentCoverUseCase(NotesDocumentCoverRepository notesDocumentCoverRepository) {
        this.mRepository = notesDocumentCoverRepository;
    }

    public boolean invoke(@NonNull NotesDocumentCoverEntity notesDocumentCoverEntity, @CoverConstants.SuggestedState int i, String str) {
        try {
            this.mRepository.insert(notesDocumentCoverEntity, i, str);
            DataToSyncManager.getInstance().onCoverUpdated(notesDocumentCoverEntity.getDocUuid());
            return true;
        } catch (NotesSQLiteConstraintException e) {
            DataLogger.m12303e(TAG, "invoke, e: " + e.getMessage());
            return false;
        }
    }
}
