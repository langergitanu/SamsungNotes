package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.arch.core.util.Function;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11252i implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7380a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesSearchDao f7381b;

    public /* synthetic */ C11252i(NotesSearchDao notesSearchDao, int i) {
        this.f7380a = i;
        this.f7381b = notesSearchDao;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public final Object mo22196apply(Object obj) {
        switch (this.f7380a) {
            case 0:
                return this.f7381b.lambda$deleteByUuid$0((List) obj);
            default:
                return this.f7381b.getDocumentTextDataWithDocUuids((List) obj);
        }
    }
}
