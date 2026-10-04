package com.samsung.android.support.senl.docscan.rectify;

/* JADX INFO: renamed from: com.samsung.android.support.senl.docscan.rectify.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class RunnableC7985a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5890a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RectifyEditFragment f5891b;

    public /* synthetic */ RunnableC7985a(RectifyEditFragment rectifyEditFragment, int i) {
        this.f5890a = i;
        this.f5891b = rectifyEditFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5890a) {
            case 0:
                RectifyEditFragment.saveRectifyResult$lambda$4(this.f5891b);
                break;
            case 1:
                RectifyEditFragment.callBackPress$lambda$5(this.f5891b);
                break;
            default:
                RectifyEditFragment.onDestroyView$lambda$6(this.f5891b);
                break;
        }
    }
}
