package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11244a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7357a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MainListDocumentDataDao f7358b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ NotesOldDocumentDao f7359c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ NotesConvertedDocumentDao f7360d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ boolean f7361e;

    public /* synthetic */ C11244a(MainListDocumentDataDao mainListDocumentDataDao, NotesOldDocumentDao notesOldDocumentDao, NotesConvertedDocumentDao notesConvertedDocumentDao, boolean z, int i) {
        this.f7357a = i;
        this.f7358b = mainListDocumentDataDao;
        this.f7359c = notesOldDocumentDao;
        this.f7360d = notesConvertedDocumentDao;
        this.f7361e = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f7357a) {
            case 0:
                return this.f7358b.lambda$getAllDocumentCountEntry_LiveData$1(this.f7359c, this.f7360d, this.f7361e, (List) obj);
            default:
                return this.f7358b.lambda$getAllDocumentCountEntryMap_LiveData$4(this.f7359c, this.f7360d, this.f7361e, (List) obj);
        }
    }
}
