package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.search.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8514b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6232a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SearchHandler f6233b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f6234c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f6235d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ FilterInfo f6236e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ long f6237f;

    public /* synthetic */ RunnableC8514b(SearchHandler searchHandler, String str, String str2, FilterInfo filterInfo, long j, int i) {
        this.f6232a = i;
        this.f6233b = searchHandler;
        this.f6234c = str;
        this.f6235d = str2;
        this.f6236e = filterInfo;
        this.f6237f = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6232a) {
            case 0:
                this.f6233b.lambda$search$0(this.f6234c, this.f6235d, this.f6236e, this.f6237f);
                break;
            default:
                this.f6233b.lambda$searchCover$2(this.f6234c, this.f6235d, this.f6236e, this.f6237f);
                break;
        }
    }
}
