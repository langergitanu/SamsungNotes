package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuMoveOnlyMode extends RtMenuItem {
    public RtMenuMoveOnlyMode(View view) {
        super(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        setSelected(!this.mView.isSelected());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.mPresenter.hideSoftInput();
        }
    }
}
