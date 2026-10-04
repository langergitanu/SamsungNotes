package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.document.dao.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11250g implements SplitTaskExecutor.SplitPredicate, SplitTaskExecutor.CountFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ NotesHashtagContentDao f7377a;

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.common.SplitTaskExecutor.CountFunction
    public int apply(Object obj) {
        return this.f7377a.deleteByUuid((Collection<String>) obj);
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.common.SplitTaskExecutor.SplitPredicate
    public boolean test(Object obj) {
        return this.f7377a.hashTagContentExists((List) obj);
    }
}
