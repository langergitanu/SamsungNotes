package com.google.android.material.search;

/* JADX INFO: renamed from: com.google.android.material.search.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4847m implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2374a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2375b;

    public /* synthetic */ RunnableC4847m(Object obj, int i) {
        this.f2374a = i;
        this.f2375b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2374a) {
            case 0:
                ((SearchViewAnimationHelper) this.f2375b).lambda$startShowAnimationExpand$0();
                break;
            case 1:
                ((SearchViewAnimationHelper) this.f2375b).lambda$startShowAnimationTranslate$1();
                break;
            default:
                ((SearchBar) this.f2375b).lambda$startOnLoadAnimation$1();
                break;
        }
    }
}
