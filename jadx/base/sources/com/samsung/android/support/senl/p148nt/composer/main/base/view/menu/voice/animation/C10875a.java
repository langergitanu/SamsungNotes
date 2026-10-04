package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.VoiceAnimation;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10875a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7279a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f7280b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f7281c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ View f7282d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ View f7283e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ View f7284f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ int f7285g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ View f7286h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ int f7287i;

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ boolean f7288j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ViewGroup f7289k;

    public /* synthetic */ C10875a(View view, int i, View view2, View view3, View view4, int i2, View view5, int i4, boolean z, ViewGroup viewGroup) {
        this.f7280b = view;
        this.f7281c = i;
        this.f7282d = view2;
        this.f7283e = view3;
        this.f7284f = view4;
        this.f7285g = i2;
        this.f7286h = view5;
        this.f7287i = i4;
        this.f7288j = z;
        this.f7289k = viewGroup;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f7279a) {
            case 0:
                boolean z = this.f7288j;
                ViewGroup viewGroup = this.f7289k;
                VoiceAnimation.ViewTreeObserverOnGlobalLayoutListenerC108691.onGlobalLayout$lambda$0(this.f7280b, this.f7282d, this.f7281c, this.f7283e, this.f7284f, this.f7285g, this.f7286h, this.f7287i, z, viewGroup, valueAnimator);
                break;
            default:
                VoiceAnimation.ViewTreeObserverOnGlobalLayoutListenerC108711.onGlobalLayout$lambda$0(this.f7280b, this.f7281c, this.f7282d, this.f7283e, this.f7284f, this.f7285g, this.f7286h, this.f7287i, this.f7288j, this.f7289k, valueAnimator);
                break;
        }
    }

    public /* synthetic */ C10875a(View view, View view2, int i, View view3, View view4, int i2, View view5, int i4, boolean z, ViewGroup viewGroup) {
        this.f7280b = view;
        this.f7282d = view2;
        this.f7281c = i;
        this.f7283e = view3;
        this.f7284f = view4;
        this.f7285g = i2;
        this.f7286h = view5;
        this.f7287i = i4;
        this.f7288j = z;
        this.f7289k = viewGroup;
    }
}
