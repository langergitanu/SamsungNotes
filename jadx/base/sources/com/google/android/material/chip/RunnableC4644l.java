package com.google.android.material.chip;

import android.view.ViewGroup;

/* JADX INFO: renamed from: com.google.android.material.chip.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4644l implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2269a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewGroup f2270b;

    public /* synthetic */ RunnableC4644l(ViewGroup viewGroup, int i) {
        this.f2269a = i;
        this.f2270b = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2269a) {
            case 0:
                SeslPeoplePicker.access$200((SeslPeoplePicker) this.f2270b);
                break;
            case 1:
                ((SeslPeoplePicker) this.f2270b).updateFloatWhenExpanded();
                break;
            case 2:
                ((SeslPeoplePicker) this.f2270b).lambda$setListeners$1();
                break;
            default:
                ((SeslChipGroup) this.f2270b).lambda$postRemoveView$0();
                break;
        }
    }
}
