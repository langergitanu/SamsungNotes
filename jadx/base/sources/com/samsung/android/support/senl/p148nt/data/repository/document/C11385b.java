package com.samsung.android.support.senl.p148nt.data.repository.document;

import androidx.arch.core.util.Function;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.repository.document.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11385b implements Function, SplitTaskExecutor.CountFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7427a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesLockDocumentRepository f7428b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ List f7429c;

    public /* synthetic */ C11385b(NotesLockDocumentRepository notesLockDocumentRepository, List list, int i) {
        this.f7427a = i;
        this.f7428b = notesLockDocumentRepository;
        this.f7429c = list;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.common.SplitTaskExecutor.CountFunction
    public int apply(Object obj) {
        return this.f7428b.lambda$getLockNoteCount$0(this.f7429c, (Collection) obj);
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply, reason: collision with other method in class */
    public Object mo22196apply(Object obj) {
        switch (this.f7427a) {
            case 0:
                return this.f7428b.lambda$getLockedNoteUuidsWithExcludeTypes$2(this.f7429c, (List) obj);
            case 1:
                return this.f7428b.lambda$getEntities$3(this.f7429c, (List) obj);
            default:
                return this.f7428b.lambda$getLockedEntitiesWithExcludeTypes$1(this.f7429c, (List) obj);
        }
    }
}
