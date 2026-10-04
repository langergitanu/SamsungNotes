package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchModeView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8671c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6278a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SearchModeView f6279b;

    public /* synthetic */ RunnableC8671c(SearchModeView searchModeView, int i) {
        this.f6278a = i;
        this.f6279b = searchModeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6278a) {
            case 0:
                this.f6279b.detachRecentSearchFragment();
                break;
            default:
                this.f6279b.lambda$onConfigurationChanged$0();
                break;
        }
    }
}
