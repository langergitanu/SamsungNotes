package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.DataMapper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.ObjectMapper;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8412d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6188a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6189b;

    public /* synthetic */ RunnableC8412d(Object obj, int i) {
        this.f6188a = i;
        this.f6189b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6188a) {
            case 0:
                ((DataMapper.C83794) this.f6189b).lambda$onEnd$0();
                break;
            case 1:
                ((ObjectMapper.C839616) this.f6189b).lambda$onEnd$0();
                break;
            case 2:
                ((DataMapper) this.f6189b).lambda$initFolderWorkerTask$2();
                break;
            default:
                ((NotesPresenter) this.f6189b).lambda$onResume$0();
                break;
        }
    }
}
