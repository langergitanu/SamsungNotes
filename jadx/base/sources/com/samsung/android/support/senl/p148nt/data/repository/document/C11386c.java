package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.arch.core.util.Function;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.repository.document.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11386c implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7430a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesRecycleBinDocumentDao f7431b;

    public /* synthetic */ C11386c(NotesRecycleBinDocumentDao notesRecycleBinDocumentDao, int i) {
        this.f7430a = i;
        this.f7431b = notesRecycleBinDocumentDao;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public final Object mo22196apply(Object obj) {
        switch (this.f7430a) {
            case 0:
                return this.f7431b.getFoldersInRecycleBin((List) obj);
            default:
                return this.f7431b.getDocumentsInRecycleBin((List) obj);
        }
    }
}
