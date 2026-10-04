package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC9704a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6934a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6935b;

    public /* synthetic */ ViewOnClickListenerC9704a(Object obj, int i) {
        this.f6934a = i;
        this.f6935b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6934a) {
            case 0:
                ((AiContextMenuSTTLongPressPopup) this.f6935b).lambda$applyOnItemClickListener$0(view);
                break;
            default:
                ((AiMenuResultViewSummarization) this.f6935b).lambda$initView$3(view);
                break;
        }
    }
}
