package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingPenLayout extends HwSettingPenLayoutCommon {
    private void updateSettingLayoutPenInfo() {
        this.mSpenSettingLayout.setPenInfoList(this.mSettingViewManager.getSettingInfoManager().getPenInfoData().getSettingPenInfoList());
        this.mSpenSettingLayout.setInfo(this.mSettingViewManager.getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        if (internalHide(z)) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_PEN_SETTINGS_OPEN_AND_CLOSE, "3");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenSettingLayout != null) {
            updateSettingLayoutPenInfo();
            return;
        }
        super.init();
        updateSettingLayoutPenInfo();
        restoreData();
        this.mSpenSettingLayout.setPenSpuitActionListener(new SpenSettingPenLayout.SpenPenSpuitViewActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingPenLayout.1
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.EyedropperActionListener
            public void onCloseClicked() {
                HwSettingPenLayout.this.mHwSettingSALog.insertEyedropperClose();
            }
        });
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        spenSettingPenLayout.setLoggingListener(this.mHwSettingSALog.getPenLoggingListener(false, ResourceUtils.isTabletLayout(spenSettingPenLayout.getContext())));
        setTitleButtonListener();
        setLayoutOrientation();
        this.mFloatingContainer.addView(this.mSpenSettingLayout);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void onPenInfoChanged(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        setPenSettingInfo(spenSettingUIPenInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean onTouchOutside() {
        if (internalHide(true)) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_PEN_SETTINGS_OPEN_AND_CLOSE, "2");
        }
        return true;
    }

    public void setItemPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (isVisible()) {
            init();
            setPenSettingInfo(spenSettingUIPenInfo);
            updateSettingLayoutPenInfo();
        }
    }

    public void setPenSettingInfo() {
        setPenSettingInfo(this.mSpenSettingLayout.getInfo());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        super.show(i, view, z);
        if (isPenMiniMode()) {
            return;
        }
        init();
        if (this.mIsSupportEyedropper) {
            this.mSpenSettingLayout.setEyedropperEnabled(this.mSettingViewManager.getSettingInfoManager().isEyeDropperEnabled());
        }
        if (this.mSpenSettingLayout.getVisibility() == 0) {
            return;
        }
        inOutVI(this.mSpenSettingLayout, z);
        this.mSpenSettingLayout.setVisibility(0);
        this.mSpenSettingLayout.requestFocus();
        updatePosition(i, view, z);
        updateFavoriteButton(false);
    }

    public void setPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        ISettingViewManager iSettingViewManager;
        if (this.mSpenSettingLayout == null || (iSettingViewManager = this.mSettingViewManager) == null) {
            return;
        }
        iSettingViewManager.getSettingInstance().setPenSettingInfo(spenSettingUIPenInfo);
    }
}
