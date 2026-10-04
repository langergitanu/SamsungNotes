package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10837c implements RtToolbarContract.OnClickValueListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7262a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RtMenuTable f7263b;

    public /* synthetic */ C10837c(RtMenuTable rtMenuTable, int i) {
        this.f7262a = i;
        this.f7263b = rtMenuTable;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract.OnClickValueListener
    public final void apply(int i) {
        switch (this.f7262a) {
            case 0:
                RtMenuTable.initFontColorButton$lambda$7$lambda$6(this.f7263b, i);
                break;
            case 1:
                RtMenuTable.initFontSizeButton$lambda$9$lambda$8(this.f7263b, i);
                break;
            default:
                RtMenuTable.initAlignButton$lambda$11$lambda$10(this.f7263b, i);
                break;
        }
    }
}
