package com.google.android.material.search;

/* JADX INFO: renamed from: com.google.android.material.search.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4841g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2363a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SearchView f2364b;

    public /* synthetic */ RunnableC4841g(SearchView searchView, int i) {
        this.f2363a = i;
        this.f2364b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2363a) {
            case 0:
                this.f2364b.lambda$clearFocusAndHideKeyboard$9();
                break;
            case 1:
                this.f2364b.lambda$requestFocusAndShowKeyboard$8();
                break;
            case 2:
                this.f2364b.show();
                break;
            default:
                this.f2364b.requestFocusAndShowKeyboardIfNeeded();
                break;
        }
    }
}
