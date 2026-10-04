package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingSelectionLayout;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingSelectionLayout extends HwSettingLayout {
    protected SpenSettingSelectionLayout mSpenSettingSelectionLayout;

    private boolean internalHide(boolean z) {
        SpenSettingSelectionLayout spenSettingSelectionLayout = this.mSpenSettingSelectionLayout;
        if (spenSettingSelectionLayout == null) {
            return false;
        }
        inOutVI(spenSettingSelectionLayout, z);
        this.mSpenSettingSelectionLayout.setVisibility(8);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        SpenSettingSelectionLayout spenSettingSelectionLayout = this.mSpenSettingSelectionLayout;
        if (spenSettingSelectionLayout != null) {
            spenSettingSelectionLayout.close();
            this.mSpenSettingSelectionLayout = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        if (internalHide(z)) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_SELECTION_SETTINGS_OPEN_AND_CLOSE, "3");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenSettingSelectionLayout != null) {
            return;
        }
        SpenSettingSelectionLayout spenSettingSelectionLayout = new SpenSettingSelectionLayout(this.mFloatingContainer.getContext(), null, null);
        this.mSpenSettingSelectionLayout = spenSettingSelectionLayout;
        spenSettingSelectionLayout.setInfo(this.mSettingViewManager.getSettingInfoManager().getSelectionInfoData().getSettingSelectionInfo());
        this.mSpenSettingSelectionLayout.setSelectionInfoChangedListener(new SpenSettingSelectionLayout.SelectionInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSelectionLayout.1
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingSelectionLayout.SelectionInfoChangedListener
            public void onSelectionInfoChanged(SpenSettingSelectionInfo spenSettingSelectionInfo) {
                if (spenSettingSelectionInfo == null) {
                    return;
                }
                HwSettingSelectionLayout.this.mSettingViewManager.getSettingInstance().setSelectionSettingInfo(spenSettingSelectionInfo);
                if (spenSettingSelectionInfo.type == 0) {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_LASSO);
                } else {
                    ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_RECTANGLE);
                }
            }
        });
        this.mFloatingContainer.addView(this.mSpenSettingSelectionLayout);
        this.mSpenSettingSelectionLayout.setVisibilityChangedListener(new SpenSettingSelectionLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSelectionLayout.2
            @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout.ViewListener
            public void onVisibilityChanged(int i) {
                HwSettingSelectionLayout hwSettingSelectionLayout = HwSettingSelectionLayout.this;
                hwSettingSelectionLayout.mSettingViewManager.updateShowState(hwSettingSelectionLayout.getCallerType(), HwSettingSelectionLayout.this.getViewId(), i == 0);
            }
        });
        this.mSpenSettingSelectionLayout.setLoggingListener(new SpenSettingSelectionLayout.LoggingListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSelectionLayout.3
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingSelectionLayout.LoggingListener
            public void onClosed() {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_SELECTION_SETTING_CLOSE);
                ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_SELECTION_SETTINGS_OPEN_AND_CLOSE, "1");
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenSettingSelectionLayout spenSettingSelectionLayout = this.mSpenSettingSelectionLayout;
        return spenSettingSelectionLayout != null && spenSettingSelectionLayout.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean onTouchOutside() {
        if (internalHide(true)) {
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_SELECTION_SETTINGS_OPEN_AND_CLOSE, "2");
        }
        return true;
    }

    public void setSettingInfo(SpenSettingSelectionInfo spenSettingSelectionInfo) {
        if (CommonUtil.compareSelectionInfo(this.mSpenSettingSelectionLayout.getInfo(), spenSettingSelectionInfo)) {
            return;
        }
        this.mSpenSettingSelectionLayout.setInfo(spenSettingSelectionInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        init();
        setCallerType(i);
        if (this.mSpenSettingSelectionLayout.getVisibility() == 0) {
            return;
        }
        this.mSpenSettingSelectionLayout.setInfo(this.mSettingViewManager.getSettingInfoManager().getSelectionInfoData().getSettingSelectionInfo());
        inOutVI(this.mSpenSettingSelectionLayout, z);
        this.mSpenSettingSelectionLayout.setVisibility(0);
        this.mSpenSettingSelectionLayout.requestFocus();
        updatePosition(i, view, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        this.mSettingViewManager.updateLayoutParam(getCallerType(), this.mSpenSettingSelectionLayout);
    }
}
