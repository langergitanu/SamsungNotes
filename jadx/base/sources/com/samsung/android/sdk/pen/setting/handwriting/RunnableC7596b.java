package com.samsung.android.sdk.pen.setting.handwriting;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.handwriting.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7596b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5061a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenPenAttrMiniView f5062b;

    public /* synthetic */ RunnableC7596b(SpenPenAttrMiniView spenPenAttrMiniView, int i) {
        this.f5061a = i;
        this.f5062b = spenPenAttrMiniView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5061a) {
            case 0:
                SpenPenAttrMiniView.onSizeChanged$lambda$0(this.f5062b);
                break;
            default:
                this.f5062b.setVisibility(0);
                break;
        }
    }
}
