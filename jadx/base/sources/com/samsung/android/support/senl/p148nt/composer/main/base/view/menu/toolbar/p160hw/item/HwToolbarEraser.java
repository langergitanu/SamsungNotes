package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarEraser extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarEraser");

    public HwToolbarEraser(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void clearControl() {
        Logger.m11003i(TAG, "clearControl");
        this.mHwToolbarItemManager.clearContextMenu();
        if (!isSpenObjectMathSelected()) {
            this.mWritingToolManager.clearSelection();
        }
        this.mWritingToolManager.clearControl();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        if (z) {
            this.mHwToolbarItemManager.getSettingInstance().updateRemoverSettingInfo();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        if (!this.mView.isSelected()) {
            this.mHwToolbarItemManager.onSelected(getViewId(), isClearObject());
        } else if (this.mHwSettingViewManager.isShownSettingViews(8)) {
            this.mHwSettingViewManager.hide();
        } else {
            this.mHwSettingViewManager.show(getViewId(), 8);
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_ERASER_SETTING);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z)) {
            return false;
        }
        if (!z) {
            return true;
        }
        this.mHwToolbarItemManager.getSettingInstance().updateRemoverSettingInfo();
        return true;
    }
}
