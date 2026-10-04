package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarSelection extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarSelection");

    public HwToolbarSelection(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
    }

    private void sendSelectionModeSALog(int i) {
        if (i == 0) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_SELECTION_MODE, "1");
        } else {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_SELECTION_MODE, "2");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        if (z) {
            this.mHwToolbarItemManager.getSettingInstance().updateSelectionSettingInfo();
            sendSelectionModeSALog(this.mHwSettingViewManager.getSettingInfoManager().getSelectionInfoData().getSettingSelectionInfo().type);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        String str;
        Logger.m10999d(TAG, "onClick# ");
        if (!this.mView.isSelected()) {
            this.mHwToolbarItemManager.onSelected(getViewId());
        } else {
            if (!this.mHwSettingViewManager.isShownSettingViews(16)) {
                this.mHwSettingViewManager.show(getViewId(), 16);
                str = "2";
                ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_SELECTION_SETTING, str);
            }
            this.mHwSettingViewManager.hide();
        }
        str = "1";
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_SELECTION_SETTING, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z)) {
            return false;
        }
        functionEnable(z);
        return true;
    }

    public void updateSettingMenu(int i) {
        if (i == 0) {
            ((ImageView) this.mView.findViewById(C9086R.id.hw_toolbar_selection_type)).setImageResource(C9086R.drawable.comp_hw_toolbar_ic_selection_lasso);
        } else {
            ((ImageView) this.mView.findViewById(C9086R.id.hw_toolbar_selection_type)).setImageResource(C9086R.drawable.comp_hw_toolbar_ic_selection_rectangle);
        }
        if (super.isSelected()) {
            sendSelectionModeSALog(i);
        }
    }
}
