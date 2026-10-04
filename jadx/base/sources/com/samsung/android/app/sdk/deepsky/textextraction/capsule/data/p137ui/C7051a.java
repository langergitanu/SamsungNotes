package com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui;

import android.animation.ValueAnimator;
import android.view.View;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui.CapsuleAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.VoiceSubAnimation;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.ui.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7051a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4746a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f4747b;

    public /* synthetic */ C7051a(View view, int i) {
        this.f4746a = i;
        this.f4747b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f4746a) {
            case 0:
                CapsuleAnimator.C70501.onAnimationStart$lambda$0(this.f4747b, valueAnimator);
                break;
            case 1:
                StickyMemoAnimation.getHideScaleAnimator$lambda$3(this.f4747b, valueAnimator);
                break;
            case 2:
                StickyMemoAnimation.getShowScaleAnimator$lambda$0(this.f4747b, valueAnimator);
                break;
            case 3:
                StickyMemoAnimation.getMinimizeScaleAnimator$lambda$4(this.f4747b, valueAnimator);
                break;
            case 4:
                StickyMemoAnimation.getMaximizeScaleAnimator$lambda$2(this.f4747b, valueAnimator);
                break;
            case 5:
                NoteStyleActivity.dismissSheet$lambda$26$lambda$25(this.f4747b, valueAnimator);
                break;
            case 6:
                NoteStyleActivity.dismissSheet$lambda$21$lambda$20(this.f4747b, valueAnimator);
                break;
            case 7:
                NoteStyleActivity.dismissSheet$lambda$23$lambda$22(this.f4747b, valueAnimator);
                break;
            default:
                VoiceSubAnimation.getValueAnimator$lambda$2(this.f4747b, valueAnimator);
                break;
        }
    }
}
