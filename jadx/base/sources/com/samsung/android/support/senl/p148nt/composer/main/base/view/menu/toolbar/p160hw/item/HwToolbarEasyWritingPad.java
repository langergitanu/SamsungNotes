package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarEasyWritingPad extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarEasyWritingPad");
    protected HwToolbarPresenterImpl mPresenter;

    public HwToolbarEasyWritingPad(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
        this.mPresenter = hwToolbarItemContract.getHwToolbarPresenter();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void clearControl() {
        this.mHwToolbarItemManager.clearContextMenu();
        this.mHwSettingViewManager.hide();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        this.mPresenter.getMRemoteHwSettingPresenter().setEasyWritingPad(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        if (this.mView.isSelected()) {
            setSelected(false);
        } else {
            if (!this.mHwToolbarItemManager.isSelected(2) && !this.mHwToolbarItemManager.isSelected(2048)) {
                this.mHwToolbarItemManager.onSelected(2);
            }
            this.mHwToolbarItemManager.onSelected(getViewId());
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_EASY_WRITING_PAD_SETTING, this.mView.isSelected() ? "1" : "0");
        talkback();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void setEnable(boolean z) {
        super.setEnable(z);
        if (z) {
            return;
        }
        functionEnable(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z)) {
            return false;
        }
        functionEnable(z);
        return true;
    }
}
