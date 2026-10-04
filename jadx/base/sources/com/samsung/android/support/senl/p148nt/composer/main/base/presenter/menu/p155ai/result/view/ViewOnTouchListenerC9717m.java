package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnTouchListenerC9717m implements View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6964a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbsAiActionResultView f6965b;

    public /* synthetic */ ViewOnTouchListenerC9717m(AbsAiActionResultView absAiActionResultView, int i) {
        this.f6964a = i;
        this.f6965b = absAiActionResultView;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f6964a) {
            case 0:
                return ((AiMenuResultViewCorrection) this.f6965b).lambda$initView$3(view, motionEvent);
            case 1:
                return ((AiMenuResultViewTranslation) this.f6965b).lambda$initView$3(view, motionEvent);
            default:
                return ((AutoFormatResultView) this.f6965b).lambda$initView$3(view, motionEvent);
        }
    }
}
