package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7849a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5273a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Runnable f5274b;

    public /* synthetic */ RunnableC7849a(Runnable runnable, int i) {
        this.f5273a = i;
        this.f5274b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5273a) {
            case 0:
                AnimationFactory$Companion$createAnimation$1$1.onAnimationStart$lambda$0(this.f5274b);
                break;
            case 1:
                AnimationFactory$Companion$createAnimation$1$1.onAnimationEnd$lambda$1(this.f5274b);
                break;
            case 2:
                AnimationFactory$Companion$createAnimation$1$1.onAnimationCancel$lambda$2(this.f5274b);
                break;
            case 3:
                com.samsung.android.sesl.visualeffect.lighteffects.processinglight.AnimationFactory$Companion$createAnimation$1$1.onAnimationCancel$lambda$2(this.f5274b);
                break;
            case 4:
                com.samsung.android.sesl.visualeffect.lighteffects.processinglight.AnimationFactory$Companion$createAnimation$1$1.onAnimationEnd$lambda$1(this.f5274b);
                break;
            default:
                com.samsung.android.sesl.visualeffect.lighteffects.processinglight.AnimationFactory$Companion$createAnimation$1$1.onAnimationStart$lambda$0(this.f5274b);
                break;
        }
    }
}
