package com.samsung.android.sdk.pen.setting.quicktool;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.quicktool.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7654f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5085a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenQTLayoutAnimation f5086b;

    public /* synthetic */ RunnableC7654f(SpenQTLayoutAnimation spenQTLayoutAnimation, int i) {
        this.f5085a = i;
        this.f5086b = spenQTLayoutAnimation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5085a) {
            case 0:
                SpenQTLayoutAnimation.toggleToCloseAnimation$lambda$13(this.f5086b);
                break;
            case 1:
                SpenQTLayoutAnimation.toggleToOpenAnimation$lambda$11(this.f5086b);
                break;
            case 2:
                SpenQTLayoutAnimation.enterDockingZoneAnimation$lambda$15(this.f5086b);
                break;
            default:
                SpenQTLayoutAnimation.exitDockingZoneAnimation$lambda$17(this.f5086b);
                break;
        }
    }
}
