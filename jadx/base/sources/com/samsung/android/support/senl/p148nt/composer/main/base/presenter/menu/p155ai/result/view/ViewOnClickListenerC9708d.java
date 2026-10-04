package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC9708d implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6941a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiMenuResultTopView f6942b;

    public /* synthetic */ ViewOnClickListenerC9708d(AiMenuResultTopView aiMenuResultTopView, int i) {
        this.f6941a = i;
        this.f6942b = aiMenuResultTopView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6941a) {
            case 0:
                this.f6942b.lambda$init$0(view);
                break;
            case 1:
                this.f6942b.lambda$init$1(view);
                break;
            case 2:
                this.f6942b.lambda$init$2(view);
                break;
            default:
                this.f6942b.lambda$makeMorePopup$4(view);
                break;
        }
    }
}
