package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.common.ColorSettingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarQuickColor extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarQuickColor");

    public HwToolbarQuickColor(View view, HwToolbarItemContract hwToolbarItemContract) {
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
            this.mHwToolbarItemManager.updateQuickColor(getViewId());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        String colorName;
        Logger.m10999d(TAG, "onClick# ");
        if (this.mView.isSelected()) {
            int ordinal = HwToolbarConstants.QUICK_COLOR.getOrdinal(getViewId());
            if (this.mHwSettingViewManager.isShownSettingViews(512)) {
                this.mHwSettingViewManager.hide();
            } else {
                this.mHwToolbarItemManager.getSettingInstance().showColorPicker(getViewId(), null, this.mHwToolbarItemManager.getSettingInstance().getSettingInfoManager().getQuickColorData().getQuickHSVColor(ordinal));
            }
            colorName = ColorSettingUtil.getColorName(this.mView.getContext(), this.mHwToolbarItemManager.getSettingInstance().getSettingInfoManager().getQuickColorData().getQuickColor(ordinal));
        } else {
            if (!this.mHwToolbarItemManager.isSelected(2) && !this.mHwToolbarItemManager.isSelected(2048)) {
                this.mHwToolbarItemManager.onSelected(2, isClearObject());
            }
            this.mHwSettingViewManager.hide();
            this.mHwToolbarItemManager.onSelected(getViewId(), isClearObject());
            colorName = "1";
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_QUICK_COLOR, colorName);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z)) {
            return false;
        }
        functionEnable(z);
        return true;
    }

    public void updateUIColor(int i) {
        int colorTheme = this.mHwToolbarItemManager.getColorTheme(i);
        GradientDrawable gradientDrawable = (GradientDrawable) ((ImageView) ((ViewGroup) this.mView).getChildAt(0)).getBackground();
        gradientDrawable.setColor(ColorStateList.valueOf(colorTheme));
        if (SpenSettingUtil.isAdaptiveColor(this.mView.getContext(), colorTheme)) {
            gradientDrawable.setStroke(1, this.mView.getContext().getResources().getColor(C9086R.color.composer_quick_color_stroke, null));
        } else {
            gradientDrawable.setStroke(1, colorTheme);
        }
        View view = this.mView;
        view.setContentDescription(ColorSettingUtil.getColorName(view.getContext(), i));
    }
}
