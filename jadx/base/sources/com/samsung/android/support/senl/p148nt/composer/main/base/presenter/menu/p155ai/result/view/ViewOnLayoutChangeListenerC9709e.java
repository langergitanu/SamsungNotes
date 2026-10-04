package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnLayoutChangeListenerC9709e implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6943a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6944b;

    public /* synthetic */ ViewOnLayoutChangeListenerC9709e(Object obj, int i) {
        this.f6943a = i;
        this.f6944b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        switch (this.f6943a) {
            case 0:
                ((AiMenuResultTopView) this.f6944b).lambda$init$3(view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            case 1:
                ((AiMenuResultViewCorrection) this.f6944b).lambda$initView$4(view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            default:
                ((AiMenuResultViewSTT) this.f6944b).lambda$initListView$2(view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
        }
    }
}
