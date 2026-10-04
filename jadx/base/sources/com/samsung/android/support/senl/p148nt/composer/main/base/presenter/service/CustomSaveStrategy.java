package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service;

import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomSaveStrategy {
    public void onCacheLoadFailed(DocumentRepository documentRepository) {
    }

    public void onClose(DocumentRepository documentRepository, NotesDocument<SpenWordDocument> notesDocument) {
        if (!documentRepository.checkSaveStrategy(4096)) {
            documentRepository.removeSaveStrategy(1024);
        }
        if (!notesDocument.isSaveCache() && (!notesDocument.isContentChanged() || notesDocument.isChangedOnlyThumbnail())) {
            documentRepository.removeSaveStrategy(2048);
            return;
        }
        if (documentRepository.checkSaveStrategy(1024)) {
            documentRepository.removeSaveStrategy(2048);
        } else {
            documentRepository.addSaveStrategy(2048);
        }
        if (notesDocument.isEntityChanged() || !notesDocument.isChangedOnlyThumbnail()) {
            return;
        }
        documentRepository.addSaveStrategy(8192);
    }

    public void onOpen(DocumentRepository documentRepository) {
    }

    public void onSave(DocumentRepository documentRepository) {
    }

    public void onSaveCache(DocumentRepository documentRepository) {
    }
}
