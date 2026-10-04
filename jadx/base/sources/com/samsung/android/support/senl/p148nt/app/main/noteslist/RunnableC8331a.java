package com.samsung.android.support.senl.p148nt.app.main.noteslist;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.Bixby2;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8331a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6171a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6172b;

    public /* synthetic */ RunnableC8331a(Object obj, int i) {
        this.f6171a = i;
        this.f6172b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6171a) {
            case 0:
                ((Bixby2.NoteFragmentBixby2) this.f6172b).lambda$search$0();
                break;
            default:
                ((NotesFragment) this.f6172b).lambda$onActivityResultAfterVerify$1();
                break;
        }
    }
}
