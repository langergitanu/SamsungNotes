package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarStyle extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarStyle");
    HwToolbarPresenterImpl mHwToolbarPresenter;

    public HwToolbarStyle(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
        this.mHwToolbarPresenter = hwToolbarItemContract.getHwToolbarPresenter();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        if (z) {
            this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().updateChangeStyleSettingInfo();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        if (!this.mView.isSelected()) {
            this.mHwToolbarItemManager.onSelected(getViewId());
        } else if (this.mHwSettingViewManager.isShownSettingViews(32)) {
            this.mHwSettingViewManager.hide();
        } else {
            this.mHwSettingViewManager.show(getViewId(), 32);
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_CHANGE_STYLE_SETTING);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z)) {
            return false;
        }
        if (z) {
            functionEnable(true);
            this.mHwToolbarPresenter.hideSettingPenMini();
        } else {
            this.mHwToolbarPresenter.showSettingPenMini();
        }
        return true;
    }

    public void updateSettingMenu(int i) {
        ((ImageView) ((ViewGroup) this.mView).getChildAt(0)).setImageTintList(ColorStateList.valueOf(this.mHwToolbarItemManager.getColorTheme(i)));
    }
}
