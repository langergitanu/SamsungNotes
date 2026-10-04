package com.samsung.android.app.notes.sync.p135db;

import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6745n extends NotesDocumentCompletionListener {

    /* JADX INFO: renamed from: a */
    public final String f4119a;

    /* JADX INFO: renamed from: b */
    public final String f4120b;

    public C6745n(String str, String str2) {
        this.f4119a = str;
        this.f4120b = str2;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
    public final void completed(NotesDocument notesDocument, String str) {
        String str2 = this.f4119a;
        if (str2 == null || str2.equals(this.f4120b)) {
            return;
        }
        FileUtils.deleteFile(str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
    public final void failed(Throwable th, String str) {
        String str2 = this.f4119a;
        if (str2 == null || str2.equals(this.f4120b)) {
            return;
        }
        FileUtils.deleteFile(str2);
    }
}
