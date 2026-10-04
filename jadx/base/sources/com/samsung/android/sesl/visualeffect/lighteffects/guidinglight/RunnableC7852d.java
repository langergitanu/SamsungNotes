package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7852d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5283a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AnimationManager.AnimationCallback f5284b;

    public /* synthetic */ RunnableC7852d(AnimationManager.AnimationCallback animationCallback, int i) {
        this.f5283a = i;
        this.f5284b = animationCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5283a) {
            case 0:
                AnimationManager.createSizeAnimation$lambda$7(this.f5284b);
                break;
            case 1:
                AnimationManager.createNowBarAnimation$lambda$21(this.f5284b);
                break;
            case 2:
                AnimationManager.createLuminanceAnimation$lambda$12(this.f5284b);
                break;
            default:
                AnimationManager.hideByLuminance$lambda$24(this.f5284b);
                break;
        }
    }
}
