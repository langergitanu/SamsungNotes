package com.samsung.android.sdk.pen.setting.quicktool;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.quicktool.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7659k implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5100a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenSettingQTContainer f5101b;

    public /* synthetic */ RunnableC7659k(SpenSettingQTContainer spenSettingQTContainer, int i) {
        this.f5100a = i;
        this.f5101b = spenSettingQTContainer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5100a) {
            case 0:
                SpenSettingQTContainer.startShowAnimation$lambda$3(this.f5101b);
                break;
            case 1:
                SpenSettingQTContainer.startShowAnimation$lambda$4(this.f5101b);
                break;
            case 2:
                SpenSettingQTContainer.startHideAnimation$lambda$5(this.f5101b);
                break;
            default:
                SpenSettingQTContainer.startHideAnimation$lambda$6(this.f5101b);
                break;
        }
    }
}
