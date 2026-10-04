package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarQuickSize extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarQuickSize");

    public HwToolbarQuickSize(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        if (z) {
            this.mHwToolbarItemManager.updateQuickSize(getViewId());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        String string;
        Logger.m10999d(TAG, "onClick# ");
        if (this.mView.isSelected()) {
            if (this.mHwSettingViewManager.isShownSettingViews(1024)) {
                this.mHwSettingViewManager.hide();
            } else {
                this.mHwSettingViewManager.show(getViewId(), 1024);
            }
            string = Integer.toString(this.mHwSettingViewManager.getSettingInfoManager().getQuickSizeData().getSize(HwToolbarConstants.QUICK_SIZE.getOrdinal(getViewId())));
        } else {
            if (!this.mHwToolbarItemManager.isSelected(2) && !this.mHwToolbarItemManager.isSelected(2048)) {
                this.mHwToolbarItemManager.onSelected(2);
            }
            this.mHwSettingViewManager.hide();
            this.mHwToolbarItemManager.onSelected(getViewId());
            string = "1";
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_QUICK_SIZE, string);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z)) {
            return false;
        }
        functionEnable(z);
        return true;
    }

    public void updateUISize(@IntRange(from = 1, m706to = 100) int i) {
        AbstractC8014b.m7217s(i, "updateUISize ", TAG);
        ((ViewGroup) this.mView).getChildAt(0).setScaleY((i * 0.01f) + 0.5f);
    }
}
