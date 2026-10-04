package com.samsung.android.support.senl.p148nt.model.repository.data;

import java.util.HashSet;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.repository.data.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C11462a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7749a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ HashSet f7750b;

    public /* synthetic */ C11462a(HashSet hashSet, int i) {
        this.f7749a = i;
        this.f7750b = hashSet;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7749a) {
            case 0:
                return NotesDocument.lambda$fixStickyNotesInfo$0(this.f7750b, (String) obj);
            default:
                return this.f7750b.contains((Integer) obj);
        }
    }
}
