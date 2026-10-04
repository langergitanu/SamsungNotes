package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10245o implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7141a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SelectTranslateLanguageDialog f7142b;

    public /* synthetic */ ViewOnClickListenerC10245o(SelectTranslateLanguageDialog selectTranslateLanguageDialog, int i) {
        this.f7141a = i;
        this.f7142b = selectTranslateLanguageDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7141a) {
            case 0:
                this.f7142b.lambda$onCreateDialog$2(view);
                break;
            case 1:
                this.f7142b.lambda$onCreateDialog$0(view);
                break;
            default:
                this.f7142b.lambda$onCreateDialog$1(view);
                break;
        }
    }
}
