package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnLongClickListenerC9715k implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6961a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbsAiActionResultView f6962b;

    public /* synthetic */ ViewOnLongClickListenerC9715k(AbsAiActionResultView absAiActionResultView, int i) {
        this.f6961a = i;
        this.f6962b = absAiActionResultView;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (this.f6961a) {
            case 0:
                return ((AiMenuResultViewCorrection) this.f6962b).lambda$initView$0(view);
            case 1:
                return ((AiMenuResultViewSummarization) this.f6962b).lambda$initView$2(view);
            case 2:
                return ((AiMenuResultViewTranslation) this.f6962b).lambda$initView$0(view);
            default:
                return ((AutoFormatResultView) this.f6962b).lambda$initView$2(view);
        }
    }
}
