package com.samsung.android.support.senl.p148nt.model.service.callback;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class NotesDocumentCompletionListener<T extends ISpenDocument> implements DocumentCompletionListener<T> {
    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
    public void completed(DocumentDataSource<T, ? extends DocumentEntityContainer> documentDataSource, String str) {
        completed((NotesDocument) documentDataSource, str);
    }

    public abstract void completed(@NonNull NotesDocument<T> notesDocument, @NonNull String str);
}
