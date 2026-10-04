package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.AbsSPenExtraInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarPen extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarPen");

    public HwToolbarPen(View view, HwToolbarItemContract hwToolbarItemContract) {
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
            this.mHwToolbarItemManager.updatePenSettingInfo();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        if (!this.mView.isSelected()) {
            this.mHwToolbarItemManager.onSelected(getViewId(), isClearObject());
        } else if (this.mHwSettingViewManager.isShownSettingViews(4)) {
            this.mHwSettingViewManager.hide();
        } else {
            this.mHwSettingViewManager.show(getViewId(), 4);
            this.mHwSettingViewManager.reboundSettingPenMiniVI();
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_PEN_SETTING);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onItemSelected() {
        super.onItemSelected();
        if (this.mView.isSelected()) {
            return;
        }
        this.mHwToolbarItemManager.onSelected(getViewId(), isClearObject());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        HwSettingViewManager hwSettingViewManager;
        if (this.mView.isSelected() && !z && (hwSettingViewManager = this.mHwSettingViewManager) != null) {
            hwSettingViewManager.hideColorSpoid();
        }
        if (!super.setSelected(z)) {
            return false;
        }
        functionEnable(z);
        return true;
    }

    public void showSettingView() {
        this.mHwSettingViewManager.show(getViewId(), 4);
    }

    public void updateSettingMenu(AbsSPenExtraInfo absSPenExtraInfo, int i) {
        Logger.m11003i(TAG, "updateSettingMenu : " + absSPenExtraInfo.name + SQLKeyword.COMMA + Integer.toHexString(i));
        ((ImageView) this.mView.findViewById(C9086R.id.hw_toolbar_pen_type)).setImageResource(absSPenExtraInfo.penDrawableId);
        ImageView imageView = (ImageView) this.mView.findViewById(C9086R.id.hw_toolbar_pen_color);
        imageView.setImageResource(absSPenExtraInfo.penDrawableColorId);
        imageView.setColorFilter(this.mHwToolbarItemManager.getColorTheme(i), PorterDuff.Mode.SRC_IN);
    }
}
