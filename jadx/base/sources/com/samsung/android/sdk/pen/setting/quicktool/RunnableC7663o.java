package com.samsung.android.sdk.pen.setting.quicktool;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.quicktool.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7663o implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5110a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenSettingQTPenListLayout f5111b;

    public /* synthetic */ RunnableC7663o(SpenSettingQTPenListLayout spenSettingQTPenListLayout, int i) {
        this.f5110a = i;
        this.f5111b = spenSettingQTPenListLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5110a) {
            case 0:
                this.f5111b.updatePenPosition();
                break;
            default:
                SpenSettingQTPenListLayout.access$updatePenPosition(this.f5111b);
                break;
        }
    }
}
