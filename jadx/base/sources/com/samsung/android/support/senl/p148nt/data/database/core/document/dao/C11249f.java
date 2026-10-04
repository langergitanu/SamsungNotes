package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.arch.core.util.Function;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11249f implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7374a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesDocumentPageDao f7375b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7376c;

    public /* synthetic */ C11249f(NotesDocumentPageDao notesDocumentPageDao, String str, int i) {
        this.f7374a = i;
        this.f7375b = notesDocumentPageDao;
        this.f7376c = str;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public final Object mo22196apply(Object obj) {
        switch (this.f7374a) {
            case 0:
                return this.f7375b.lambda$replaceBookmarkList$1(this.f7376c, (List) obj);
            default:
                return this.f7375b.lambda$removeInvalidPages$2(this.f7376c, (List) obj);
        }
    }
}
