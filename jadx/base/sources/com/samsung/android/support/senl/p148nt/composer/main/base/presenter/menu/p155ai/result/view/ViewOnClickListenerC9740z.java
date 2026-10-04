package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.z */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC9740z implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6985a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiMenuResultViewSTT f6986b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f6987c;

    public /* synthetic */ ViewOnClickListenerC9740z(AiMenuResultViewSTT aiMenuResultViewSTT, int i, int i2) {
        this.f6985a = i2;
        this.f6986b = aiMenuResultViewSTT;
        this.f6987c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6985a) {
            case 0:
                this.f6986b.lambda$showHelpView$32(this.f6987c, view);
                break;
            default:
                this.f6986b.lambda$showAutoDetectHelpView$33(this.f6987c, view);
                break;
        }
    }
}
