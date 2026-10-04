package com.samsung.android.support.senl.p148nt.model.service;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.model.executor.NotesDocumentUseCaseExecutorImpl;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.DocumentThreadPoolManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NotesDocumentHandlerWrapper {
    private final NotesDocumentHandler mDocumentHandler;

    public NotesDocumentHandlerWrapper(Context context) {
        NotesDocumentUseCaseExecutorImpl notesDocumentUseCaseExecutorImpl = new NotesDocumentUseCaseExecutorImpl(context, DocumentThreadPoolManager.getInstance());
        this.mDocumentHandler = NotesDocumentHandler.provideNotesDocumentHandler(context, notesDocumentUseCaseExecutorImpl, NotesDocumentServiceIntentHandler.provideNotesDocumentIntentHandler(context, notesDocumentUseCaseExecutorImpl));
    }

    public NotesDocumentHandler getDocumentHandler() {
        return this.mDocumentHandler;
    }
}
