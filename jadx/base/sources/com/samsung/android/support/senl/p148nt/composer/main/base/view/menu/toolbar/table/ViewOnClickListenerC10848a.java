package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.table.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10848a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7268a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TableAndCellMoreMenu f7269b;

    public /* synthetic */ ViewOnClickListenerC10848a(TableAndCellMoreMenu tableAndCellMoreMenu, int i) {
        this.f7268a = i;
        this.f7269b = tableAndCellMoreMenu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7268a) {
            case 0:
                TableAndCellMoreMenu.initStyleButtons$lambda$9(this.f7269b, view);
                break;
            case 1:
                TableAndCellMoreMenu.initButtons$lambda$0(this.f7269b, view);
                break;
            case 2:
                TableAndCellMoreMenu.initButtons$lambda$1(this.f7269b, view);
                break;
            case 3:
                TableAndCellMoreMenu.initButtons$lambda$2(this.f7269b, view);
                break;
            case 4:
                TableAndCellMoreMenu.initButtons$lambda$3(this.f7269b, view);
                break;
            case 5:
                TableAndCellMoreMenu.initCalculateButton$lambda$7(this.f7269b, view);
                break;
            default:
                TableAndCellMoreMenu.initStyleButtons$lambda$8(this.f7269b, view);
                break;
        }
    }
}
