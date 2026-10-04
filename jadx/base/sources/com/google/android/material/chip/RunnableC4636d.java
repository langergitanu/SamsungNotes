package com.google.android.material.chip;

/* JADX INFO: renamed from: com.google.android.material.chip.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4636d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2249a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SeslExpandableContainer f2250b;

    public /* synthetic */ RunnableC4636d(SeslExpandableContainer seslExpandableContainer, int i) {
        this.f2249a = i;
        this.f2250b = seslExpandableContainer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2249a) {
            case 0:
                this.f2250b.lambda$setExpansionButton$3();
                break;
            case 1:
                this.f2250b.refreshLayout();
                break;
            default:
                this.f2250b.lambda$setExpanded$2();
                break;
        }
    }
}
