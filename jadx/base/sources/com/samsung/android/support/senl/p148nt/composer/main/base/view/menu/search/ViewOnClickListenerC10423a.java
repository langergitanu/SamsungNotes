package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.search;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10423a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7182a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SearchModeView f7183b;

    public /* synthetic */ ViewOnClickListenerC10423a(SearchModeView searchModeView, int i) {
        this.f7182a = i;
        this.f7183b = searchModeView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7182a) {
            case 0:
                this.f7183b.lambda$initVoiceButton$2(view);
                break;
            default:
                this.f7183b.lambda$initClearButton$1(view);
                break;
        }
    }
}
