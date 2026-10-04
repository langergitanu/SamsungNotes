package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.table.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10850c implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7273a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TableCalculateMenu f7274b;

    public /* synthetic */ ViewOnClickListenerC10850c(TableCalculateMenu tableCalculateMenu, int i) {
        this.f7273a = i;
        this.f7274b = tableCalculateMenu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7273a) {
            case 0:
                TableCalculateMenu.initSwitch$lambda$0(this.f7274b, view);
                break;
            case 1:
                TableCalculateMenu.initSwitch$lambda$1(this.f7274b, view);
                break;
            case 2:
                this.f7274b.hide();
                break;
            default:
                TableCalculateMenu.initCloseButton$lambda$3(this.f7274b, view);
                break;
        }
    }
}
