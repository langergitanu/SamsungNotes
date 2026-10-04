package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7851c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5278a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AnimationManager f5279b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f5280c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ float f5281d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ AnimationManager.AnimationCallback f5282e;

    public /* synthetic */ RunnableC7851c(AnimationManager animationManager, float f, float f4, AnimationManager.AnimationCallback animationCallback, int i) {
        this.f5278a = i;
        this.f5279b = animationManager;
        this.f5280c = f;
        this.f5281d = f4;
        this.f5282e = animationCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5278a) {
            case 0:
                AnimationManager.createSizeAnimation$lambda$6(this.f5279b, this.f5280c, this.f5281d, this.f5282e);
                break;
            case 1:
                AnimationManager.createNowBarAnimation$lambda$15(this.f5279b, this.f5280c, this.f5281d, this.f5282e);
                break;
            case 2:
                AnimationManager.createNowBarAnimation$lambda$17(this.f5279b, this.f5280c, this.f5281d, this.f5282e);
                break;
            case 3:
                AnimationManager.createNowBarAnimation$lambda$18(this.f5279b, this.f5280c, this.f5281d, this.f5282e);
                break;
            case 4:
                AnimationManager.createNowBarAnimation$lambda$20(this.f5279b, this.f5280c, this.f5281d, this.f5282e);
                break;
            default:
                AnimationManager.createSizeAnimation$lambda$4(this.f5279b, this.f5280c, this.f5281d, this.f5282e);
                break;
        }
    }
}
