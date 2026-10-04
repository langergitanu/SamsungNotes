package com.samsung.android.app.notes.sync.p135db;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6743l extends NotesDocumentCompletionListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ NotesDocument f4112a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f4113b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ NotesDocumentEntity f4114c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C6744m f4115d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C6747p f4116e;

    public C6743l(C6747p c6747p, NotesDocument notesDocument, String str, NotesDocumentEntity notesDocumentEntity, C6744m c6744m) {
        this.f4116e = c6747p;
        this.f4112a = notesDocument;
        this.f4113b = str;
        this.f4114c = notesDocumentEntity;
        this.f4115d = c6744m;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
    public final void completed(NotesDocument notesDocument, String str) {
        synchronized (this.f4116e.f4127g) {
            try {
                IDocumentServiceWrapper iDocumentServiceWrapper = this.f4116e.f4125e;
                if (iDocumentServiceWrapper != null) {
                    iDocumentServiceWrapper.close(this.f4112a, new C6745n(this.f4113b, this.f4114c.getFilePath()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C6744m c6744m = this.f4115d;
        c6744m.f4117a[0] = 0;
        c6744m.f4118b.countDown();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
    public final void failed(Throwable th, String str) {
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " is not saved : ");
        sbM781w.append(th.getMessage());
        Debugger.m8612ef("SyncSaveDocumentManager", sbM781w.toString());
        synchronized (this.f4116e.f4127g) {
            try {
                IDocumentServiceWrapper iDocumentServiceWrapper = this.f4116e.f4125e;
                if (iDocumentServiceWrapper != null && !(th instanceof DocumentServiceConstants.DocumentServiceAlreadyClosedException)) {
                    iDocumentServiceWrapper.close(this.f4112a, new C6745n(this.f4113b, this.f4114c.getFilePath()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        C6744m c6744m = this.f4115d;
        if (th instanceof DocumentServiceConstants.DocumentServiceAlreadyClosedException) {
            c6744m.f4117a[0] = 1;
        }
        c6744m.f4118b.countDown();
    }
}
