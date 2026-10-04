package p079T;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.DocumentThreadPoolManager;

/* JADX INFO: renamed from: T.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC0285c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f741a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f742b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ DeleteCoeditNoteUseCase.ResultCallback f743c;

    public /* synthetic */ RunnableC0285c(String str, DeleteCoeditNoteUseCase.ResultCallback resultCallback, int i) {
        this.f741a = i;
        this.f742b = str;
        this.f743c = resultCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f741a) {
            case 0:
                DocumentThreadPoolManager documentThreadPoolManager = DocumentThreadPoolManager.getInstance();
                String str = this.f742b;
                documentThreadPoolManager.getExecutorService(str).submit(new RunnableC0285c(str, this.f743c, 1));
                break;
            case 1:
                Context applicationContext = BaseUtils.getApplicationContext();
                NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
                String str2 = this.f742b;
                new DeleteCoeditNoteUseCase(notesDocumentRepositoryCreateDocumentDataRepository, new C0289g(str2, applicationContext)).setResultCallback(this.f743c).invoke(applicationContext, str2);
                break;
            default:
                AbstractC0291i.m565b(this.f742b, "PUSH_FROM_SERVER", this.f743c);
                break;
        }
    }
}
