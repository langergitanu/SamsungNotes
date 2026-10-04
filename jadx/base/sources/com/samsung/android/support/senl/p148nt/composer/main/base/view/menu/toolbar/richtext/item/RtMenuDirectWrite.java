package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuDirectWrite extends RtMenuItem {
    public RtMenuDirectWrite(View view) {
        super(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        boolean zIsSelected = this.mView.isSelected();
        setSelected(!zIsSelected);
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_S_PEN_TO_TEXT, !zIsSelected ? "1" : "0");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void setSelected(boolean z) {
        super.setSelected(z);
        this.mRtToolbarMenu.setDirectWrite(z);
        if (!z) {
            this.mRtToolbarMenu.hideDirectWrite();
            this.mPresenter.setToolTypeAction(2, 1);
        } else {
            this.mRtToolbarMenu.showDirectWrite();
            this.mPresenter.hideSoftInput();
            this.mPresenter.setToolTypeAction(2, 16);
        }
    }
}
