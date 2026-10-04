package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarConvertText extends HwToolbarItem {
    private static final int MAX_CONVERT_TEXT_COUNT = 4;
    private static final String PREF_KEY_CLICKED = "hw_convert_text_clicked";
    private static final String PREF_KEY_SHOW_CONVERT_TEXT_COUNT = "hw_show_convert_text_cnt";
    private static final String TAG = Logger.createTag("HwToolbarConvertText");

    public HwToolbarConvertText(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
    }

    private boolean hasBeenClicked() {
        boolean z = SharedPreferencesCompat.getInstance("Composer").getBoolean(PREF_KEY_CLICKED, false);
        AbstractC8014b.m7220v("hasBeenClicked? ", TAG, z);
        return z;
    }

    private void setHasBeenClicked() {
        Logger.m10999d(TAG, "clicked.");
        SharedPreferencesCompat.getInstance("Composer").putBoolean(PREF_KEY_CLICKED, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void clearControl() {
        this.mHwToolbarItemManager.clearContextMenu();
        this.mHwSettingViewManager.hide();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void doneShownSmartTip() {
        setHasBeenClicked();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        if (z) {
            this.mHwToolbarItemManager.getSettingInstance().executeConvertToText();
        } else {
            this.mHwToolbarItemManager.getSettingInstance().cancelConvertToText();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public String getSmartTipString() {
        return this.mView.getResources().getString(C9086R.string.hw_toolbar_convert_text_guide_first);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean hasToShowSmartTip() {
        if (this.mHwToolbarItemManager.getHwToolbarPresenter().isTabletLayout() || hasBeenClicked()) {
            return false;
        }
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        int i = sharedPreferencesCompat.getInt(PREF_KEY_SHOW_CONVERT_TEXT_COUNT, 1);
        if (i == 4) {
            return true;
        }
        sharedPreferencesCompat.putInt(PREF_KEY_SHOW_CONVERT_TEXT_COUNT, i + 1);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        this.mHwSettingViewManager.hide();
        this.mHwToolbarItemManager.onSelected(getViewId());
        this.mHwToolbarItemManager.updateLastPrimitiveTypeSelectionState();
        if (!hasBeenClicked()) {
            setHasBeenClicked();
        }
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_CONVERT_TO_TEXT_SETTING);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        return true;
    }
}
