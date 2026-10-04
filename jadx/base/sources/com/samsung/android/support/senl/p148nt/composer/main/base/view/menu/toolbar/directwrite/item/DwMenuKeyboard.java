package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DwMenuKeyboard extends DwMenuItem {
    public DwMenuKeyboard(View view) {
        super(view);
    }

    public void insertSALog() {
        ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_HW_STT_KEYBOARD);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuItem
    public void onClicked() {
        if (this.mPresenter.isShownSoftInput()) {
            this.mPresenter.hideSoftInput();
        } else {
            prepareToShowSoftInput();
            this.mPresenter.showSoftInput();
        }
        insertSALog();
    }

    public void prepareToShowSoftInput() {
        this.mPresenter.setForceShowKeyboard();
        this.mPresenter.setFloatingSIP(getViewCenterPosition());
    }
}
