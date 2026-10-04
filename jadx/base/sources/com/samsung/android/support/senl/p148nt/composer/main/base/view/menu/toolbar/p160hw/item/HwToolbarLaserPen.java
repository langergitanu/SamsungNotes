package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingLaserPenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarLaserPen extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarLaserPen");

    public HwToolbarLaserPen(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
        SettingLaserPenData laserPenData = this.mHwToolbarItemManager.getSettingInstance().getSettingInfoManager().getLaserPenData();
        updateSettingMenu(new Pair<>(Integer.valueOf(laserPenData.getLaserPenInfo().color), Integer.valueOf(laserPenData.getLaserPenInfo().colorOption)));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void doneShownSmartTip() {
        SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_LASER_PEN_GUIDE_SHOWN, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        AbstractC8014b.m7224z("functionEnabled# ", TAG, z);
        this.mHwToolbarItemManager.getSettingInstance().setEnableLaserPen(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public String getSmartTipString() {
        return this.mView.getResources().getString(C9086R.string.hw_toolbar_item_laser_pen_guide);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean hasToShowSmartTip() {
        return !SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_LASER_PEN_GUIDE_SHOWN, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_LASER_PEN);
        if (!this.mView.isSelected()) {
            this.mHwSettingViewManager.hide();
            this.mHwToolbarItemManager.onSelected(getViewId());
        } else if (this.mHwSettingViewManager.isShownSettingViews(32768)) {
            this.mHwSettingViewManager.hide();
        } else {
            this.mHwSettingViewManager.show(getViewId(), 32768);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z)) {
            return false;
        }
        functionEnable(z);
        return true;
    }

    public void updateSettingMenu(Pair<Integer, Integer> pair) {
        Drawable drawable;
        Logger.m11003i(TAG, "updateSettingMenu : color = " + Integer.toHexString(((Integer) pair.first).intValue()) + " / " + pair.second);
        ImageView imageView = (ImageView) this.mView.findViewById(C9086R.id.hw_toolbar_laser_pen_neon);
        if (((Integer) pair.second).intValue() != 0) {
            drawable = ResourcesCompat.getDrawable(this.mView.getResources(), C9086R.drawable.comp_hw_toolbar_ic_laser_pen_color_rainbow, null);
        } else {
            Drawable drawable2 = ResourcesCompat.getDrawable(this.mView.getResources(), C9086R.drawable.comp_hw_toolbar_ic_laser_pen_color, null);
            drawable2.setColorFilter(this.mHwToolbarItemManager.getColorTheme(((Integer) pair.first).intValue()), PorterDuff.Mode.SRC_IN);
            drawable = drawable2;
        }
        imageView.setForeground(drawable);
    }
}
