package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.arch.core.util.Function;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11245b implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7362a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesDocumentDao f7363b;

    public /* synthetic */ C11245b(NotesDocumentDao notesDocumentDao, int i) {
        this.f7362a = i;
        this.f7363b = notesDocumentDao;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public final Object mo22196apply(Object obj) {
        switch (this.f7362a) {
            case 0:
                return this.f7363b.getUnlockedNormalUuids((List) obj);
            case 1:
                return this.f7363b.getEntities((List) obj);
            case 2:
                return this.f7363b.lambda$deleteByUuidListWithTimestampIncrease$1((List) obj);
            case 3:
                return this.f7363b.fetchActiveFilePathsInChunk((List) obj);
            case 4:
                return this.f7363b.getDocumentData((List) obj);
            case 5:
                return this.f7363b.getCategoryUuidList((List) obj);
            case 6:
                return this.f7363b.getAllDocumentsInFolderTreeInChunk((List) obj);
            default:
                return this.f7363b.getUpdatableUuids((List) obj);
        }
    }
}
