package com.samsung.android.sdk.pen.setting.common;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.setting.util.SpenRecoilAnimator;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.common.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnTouchListenerC7559d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5033a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenRecoilAnimator f5034b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ SpenRecoilAnimator f5035c;

    public /* synthetic */ ViewOnTouchListenerC7559d(SpenRecoilAnimator spenRecoilAnimator, SpenRecoilAnimator spenRecoilAnimator2, int i) {
        this.f5033a = i;
        this.f5034b = spenRecoilAnimator;
        this.f5035c = spenRecoilAnimator2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f5033a) {
            case 0:
                return SpenRadioListLayout.setItem$lambda$0(this.f5034b, this.f5035c, view, motionEvent);
            default:
                return SpenSwitchView.initDefaultView$lambda$2(this.f5034b, this.f5035c, view, motionEvent);
        }
    }
}
