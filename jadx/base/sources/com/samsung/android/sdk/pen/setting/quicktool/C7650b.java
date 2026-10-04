package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.ValueAnimator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialHandler;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.quicktool.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7650b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5074a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f5075b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f5076c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f5077d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ConstraintLayout f5078e;

    public /* synthetic */ C7650b(ConstraintLayout constraintLayout, int i, int i2, int i4, int i5) {
        this.f5074a = i5;
        this.f5078e = constraintLayout;
        this.f5075b = i;
        this.f5076c = i2;
        this.f5077d = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5074a) {
            case 0:
                SpenCurvedDialHandler.startVisibilityAnimation$lambda$0((SpenCurvedDialHandler) this.f5078e, this.f5075b, this.f5076c, this.f5077d, valueAnimator);
                break;
            default:
                CurvedDialHandler.startVisibilityAnimation$lambda$0((CurvedDialHandler) this.f5078e, this.f5075b, this.f5076c, this.f5077d, valueAnimator);
                break;
        }
    }
}
