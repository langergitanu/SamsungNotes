package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.arch.core.util.Function;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11251h implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7378a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesRetryDao f7379b;

    public /* synthetic */ C11251h(NotesRetryDao notesRetryDao, int i) {
        this.f7378a = i;
        this.f7379b = notesRetryDao;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public final Object mo22196apply(Object obj) {
        switch (this.f7378a) {
            case 0:
                return this.f7379b.lambda$deleteEntities$1((List) obj);
            default:
                return this.f7379b.lambda$deleteByUuid$0((List) obj);
        }
    }
}
