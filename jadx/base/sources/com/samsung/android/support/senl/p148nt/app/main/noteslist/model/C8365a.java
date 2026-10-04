package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import java.util.function.Predicate;
import org.apache.commons.lang3.ThreadUtils;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.model.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8365a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6180a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ long f6181b;

    public /* synthetic */ C8365a(long j, int i) {
        this.f6180a = i;
        this.f6181b = j;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6180a) {
            case 0:
                return HolderInfoMap.lambda$removeSyncProgressInfoMap$0(this.f6181b, (SyncInfoMap) obj);
            default:
                return ThreadUtils.lambda$findThreadById$0(this.f6181b, (Thread) obj);
        }
    }
}
