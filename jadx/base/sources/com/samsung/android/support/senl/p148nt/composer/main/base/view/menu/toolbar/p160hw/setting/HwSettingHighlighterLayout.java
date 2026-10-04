package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingHighlighterLayout extends HwSettingPenLayoutCommon {
    private void updateSettingLayoutHighlighterInfo() {
        this.mSpenSettingLayout.setPenInfoList(this.mSettingViewManager.getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoList());
        this.mSpenSettingLayout.setInfo(this.mSettingViewManager.getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSpenSettingLayout != null) {
            updateSettingLayoutHighlighterInfo();
            return;
        }
        super.init(new ArrayList<>(Arrays.asList(Default.Highlighter.getNames())));
        updateSettingLayoutHighlighterInfo();
        restoreData();
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        spenSettingPenLayout.setCloseButtonDescription(spenSettingPenLayout.getResources().getString(C9086R.string.hw_pen_string_close_any, this.mSpenSettingLayout.getResources().getString(C9086R.string.hw_highlighter_settings)));
        this.mSpenSettingLayout.setLoggingListener(this.mHwSettingSALog.getHighlighterLoggingListener());
        setTitleButtonListener();
        setLayoutOrientation();
        this.mFloatingContainer.addView(this.mSpenSettingLayout);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void onPenInfoChanged(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        setHighlighterSettingInfo(spenSettingUIPenInfo);
    }

    public void setHighlighterSettingInfo() {
        setHighlighterSettingInfo(this.mSpenSettingLayout.getInfo());
    }

    public void setItemHighlighterSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (isVisible()) {
            init();
            setHighlighterSettingInfo(spenSettingUIPenInfo);
            updateSettingLayoutHighlighterInfo();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        super.show(i, view, z);
        if (isPenMiniMode()) {
            return;
        }
        init();
        if (this.mSpenSettingLayout.getVisibility() == 0) {
            return;
        }
        inOutVI(this.mSpenSettingLayout, z);
        this.mSpenSettingLayout.setVisibility(0);
        this.mSpenSettingLayout.requestFocus();
        updatePosition(i, view, z);
        updateFavoriteButton(false);
    }

    public void setHighlighterSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        ISettingViewManager iSettingViewManager;
        if (this.mSpenSettingLayout == null || (iSettingViewManager = this.mSettingViewManager) == null) {
            return;
        }
        iSettingViewManager.getSettingInstance().setHighlighterSettingInfo(spenSettingUIPenInfo);
    }
}
