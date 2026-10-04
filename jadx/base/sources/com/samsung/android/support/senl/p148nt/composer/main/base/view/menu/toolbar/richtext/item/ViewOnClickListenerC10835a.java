package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10835a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7257a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f7258b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ RtMenuTable f7259c;

    public /* synthetic */ ViewOnClickListenerC10835a(View view, RtMenuTable rtMenuTable, int i) {
        this.f7257a = i;
        this.f7258b = view;
        this.f7259c = rtMenuTable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7257a) {
            case 0:
                RtMenuTable.initAlignButton$lambda$11(this.f7258b, this.f7259c, view);
                break;
            case 1:
                RtMenuTable.initFontSizeButton$lambda$9(this.f7258b, this.f7259c, view);
                break;
            case 2:
                RtMenuTable.initBoldButton$lambda$2(this.f7259c, this.f7258b, view);
                break;
            case 3:
                RtMenuTable.initItalicButton$lambda$3(this.f7259c, this.f7258b, view);
                break;
            case 4:
                RtMenuTable.initFontColorButton$lambda$7(this.f7259c, this.f7258b, view);
                break;
            case 5:
                RtMenuTable.initUnderlineButton$lambda$4(this.f7259c, this.f7258b, view);
                break;
            default:
                RtMenuTable.initStrikethroughButton$lambda$5(this.f7259c, this.f7258b, view);
                break;
        }
    }

    public /* synthetic */ ViewOnClickListenerC10835a(RtMenuTable rtMenuTable, View view, int i) {
        this.f7257a = i;
        this.f7259c = rtMenuTable;
        this.f7258b = view;
    }
}
