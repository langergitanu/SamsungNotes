package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OpenDocListener<T extends ISpenDocument> extends NotesDocumentCompletionListener<T> {
    private Contract<T> mContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract<T extends ISpenDocument> {
        void onLoadDocCompleted(NotesDocument<T> notesDocument);

        void onLoadDocFailed(Throwable th, String str);
    }

    public OpenDocListener(Contract<T> contract) {
        this.mContract = contract;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
    public void completed(@NonNull NotesDocument<T> notesDocument, @NonNull String str) {
        Contract<T> contract = this.mContract;
        if (contract != null) {
            contract.onLoadDocCompleted(notesDocument);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
    public void failed(Throwable th, String str) {
        Contract<T> contract = this.mContract;
        if (contract != null) {
            contract.onLoadDocFailed(th, str);
        }
    }
}
