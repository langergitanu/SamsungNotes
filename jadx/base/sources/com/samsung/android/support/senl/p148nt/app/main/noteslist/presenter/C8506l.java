package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.ObjectMapper;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8506l implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6225a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6226b;

    public /* synthetic */ C8506l(Object obj, int i) {
        this.f6225a = i;
        this.f6226b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6225a) {
            case 0:
                return ObjectMapper.C83972.AnonymousClass1.lambda$requestDeleteConvertedNotes$0((List) this.f6226b, (String) obj);
            default:
                return ((AdapterManager) this.f6226b).lambda$requestAllDeleteConvertedNotes$1((String) obj);
        }
    }
}
