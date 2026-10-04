package com.samsung.android.support.senl.p148nt.model.collector.updater;

import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.model.collector.updater.ReadyStateUpdater;
import java.util.Comparator;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.collector.updater.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C11429a implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ReadyStateUpdater.Executor.lambda$run$0((NotesRetryEntity) obj, (NotesRetryEntity) obj2);
    }
}
