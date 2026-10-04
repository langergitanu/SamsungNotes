package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarAlignmentRecognition extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarAlignmentRecognition");

    public HwToolbarAlignmentRecognition(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
        if (FeatureInfo.isBeautifierFeatureEnabled()) {
            return;
        }
        useLegacyName();
    }

    private void useLegacyName() {
        View view = this.mView;
        view.setContentDescription(view.getResources().getString(C9086R.string.composer_ctx_menu_legacy_alignment));
        ViewCompat.getInstance().setTooltipText(this.mView);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void clearControl() {
        this.mHwToolbarItemManager.clearContextMenu();
        this.mHwSettingViewManager.hide(true, 8192);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void doneShownSmartTip() {
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_CLEAN_UP_HANDWRITING_UNLOCKED, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        this.mHwToolbarItemManager.getSettingInstance().setAlignment(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public String getSmartTipString() {
        return this.mView.getResources().getString(C9086R.string.hw_toolbar_handwriting_help_guide_first);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean hasToShowSmartTip() {
        return FeatureInfo.isBeautifierFeatureEnabled() && !SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_CLEAN_UP_HANDWRITING_UNLOCKED, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        if (this.mView.isSelected()) {
            if (this.mHwSettingViewManager.isShownSettingViews(8192)) {
                this.mHwSettingViewManager.hide();
            }
        } else {
            this.mHwToolbarItemManager.updateLastPrimitiveTypeSelectionState();
            ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_STRAIGHTEN_SETTING);
            this.mHwToolbarItemManager.onSelected(getViewId());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        return true;
    }
}
