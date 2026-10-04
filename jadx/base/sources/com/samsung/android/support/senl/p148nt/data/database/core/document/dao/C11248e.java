package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.arch.core.util.Function;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11248e implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7370a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesDocumentDao f7371b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7372c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ long f7373d;

    public /* synthetic */ C11248e(NotesDocumentDao notesDocumentDao, String str, long j, int i) {
        this.f7370a = i;
        this.f7371b = notesDocumentDao;
        this.f7372c = str;
        this.f7373d = j;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public final Object mo22196apply(Object obj) {
        switch (this.f7370a) {
            case 0:
                return this.f7371b.lambda$updateCategory$5(this.f7372c, this.f7373d, (List) obj);
            default:
                return this.f7371b.lambda$restoreFromTrash$4(this.f7372c, this.f7373d, (List) obj);
        }
    }
}
