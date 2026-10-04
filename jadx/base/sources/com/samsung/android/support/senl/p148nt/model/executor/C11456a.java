package com.samsung.android.support.senl.p148nt.model.executor;

import com.samsung.android.support.senl.p148nt.model.executor.NotesDocumentInteractor;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.executor.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11456a implements NotesDocumentInteractor.TaskSubmitListener {
    @Override // com.samsung.android.support.senl.nt.model.executor.NotesDocumentInteractor.TaskSubmitListener
    public final void onFailed(DocumentTask documentTask) {
        NotesDocumentInteractor.lambda$enqueue$0(documentTask);
    }
}
