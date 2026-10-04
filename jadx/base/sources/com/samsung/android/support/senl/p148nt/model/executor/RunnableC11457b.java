package com.samsung.android.support.senl.p148nt.model.executor;

import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.executor.NotesDocumentInteractor;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.executor.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC11457b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7742a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesDocumentInteractor.CompletionCallback f7743b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ DocumentCompletionListener f7744c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f7745d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Runnable f7746e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f7747f;

    public /* synthetic */ RunnableC11457b(NotesDocumentInteractor.CompletionCallback completionCallback, DocumentCompletionListener documentCompletionListener, Object obj, String str, Runnable runnable, int i) {
        this.f7742a = i;
        this.f7743b = completionCallback;
        this.f7744c = documentCompletionListener;
        this.f7747f = obj;
        this.f7745d = str;
        this.f7746e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7742a) {
            case 0:
                this.f7743b.lambda$success$0(this.f7744c, (DocumentDataSource) this.f7747f, this.f7745d, this.f7746e);
                break;
            default:
                this.f7743b.lambda$fail$1(this.f7744c, (Throwable) this.f7747f, this.f7745d, this.f7746e);
                break;
        }
    }
}
