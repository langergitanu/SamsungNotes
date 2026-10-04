package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.arch.core.util.Function;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11254k implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7384a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StickyNoteDao f7385b;

    public /* synthetic */ C11254k(StickyNoteDao stickyNoteDao, int i) {
        this.f7384a = i;
        this.f7385b = stickyNoteDao;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public final Object mo22196apply(Object obj) {
        switch (this.f7384a) {
            case 0:
                return this.f7385b.lambda$deleteByDocUuids$0((List) obj);
            default:
                return this.f7385b.lambda$retainOnly$2((List) obj);
        }
    }
}
