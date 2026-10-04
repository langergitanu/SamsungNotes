package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Event;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6692f implements Listenable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6693g f3998a;

    public C6692f(C6693g c6693g) {
        this.f3998a = c6693g;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
    public final String requestName() {
        return "COEDIT_DUMMY_ITEM_EVENT";
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
    public final void run(Event event) {
        this.f3998a.f3995e.execute(new RunnableC6687a(this, 3));
    }
}
