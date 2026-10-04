package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.os.Bundle;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsRtMenuPopup extends RtMenuItem {
    protected View mContainer;

    public AbsRtMenuPopup(View view, View view2) {
        super(view2);
        this.mContainer = view;
    }

    public abstract String getLogTag();

    public abstract boolean isPopupShowing();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        showPopup();
        this.mPresenter.onShowWindow();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(getLogTag(), isPopupShowing());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onUpdate() {
        super.onUpdate();
        if (isPopupShowing()) {
            onUpdatePopup();
        }
    }

    public abstract void onUpdatePopup();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void release() {
        hidePopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void restore(Bundle bundle) {
        if (bundle.getBoolean(getLogTag())) {
            onUpdatePopup();
        }
    }

    public abstract void showPopup();
}
