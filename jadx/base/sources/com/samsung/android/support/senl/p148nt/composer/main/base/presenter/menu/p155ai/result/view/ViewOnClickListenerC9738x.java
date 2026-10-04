package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.x */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC9738x implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6981a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiMenuResultViewSTT f6982b;

    public /* synthetic */ ViewOnClickListenerC9738x(AiMenuResultViewSTT aiMenuResultViewSTT, int i) {
        this.f6981a = i;
        this.f6982b = aiMenuResultViewSTT;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6981a) {
            case 0:
                this.f6982b.lambda$toggleModeTopMenu$22(view);
                break;
            case 1:
                this.f6982b.lambda$updateTitleViewMode$1(view);
                break;
            case 2:
                this.f6982b.lambda$initLayout$9(view);
                break;
            case 3:
                this.f6982b.lambda$toggleModeTopMenu$23(view);
                break;
            case 4:
                this.f6982b.lambda$initTopMenu$12(view);
                break;
            case 5:
                this.f6982b.lambda$initTopMenu$13(view);
                break;
            case 6:
                this.f6982b.lambda$initTopMenu$14(view);
                break;
            case 7:
                this.f6982b.lambda$initTopMenu$15(view);
                break;
            case 8:
                this.f6982b.lambda$showAutoDetectHelpView$34(view);
                break;
            case 9:
                this.f6982b.lambda$toggleModeTopMenu$24(view);
                break;
            case 10:
                this.f6982b.lambda$new$0(view);
                break;
            case 11:
                this.f6982b.lambda$initSTTDisclaimerBtnListener$16(view);
                break;
            case 12:
                this.f6982b.lambda$initChooseLanguageLayout$3(view);
                break;
            case 13:
                this.f6982b.lambda$initChooseLanguageLayout$4(view);
                break;
            case 14:
                this.f6982b.lambda$initChooseLanguageLayout$5(view);
                break;
            default:
                this.f6982b.lambda$initChooseLanguageLayout$6(view);
                break;
        }
    }
}
