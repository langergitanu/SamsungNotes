package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingHighlighterInfo {
    HwSettingInfoSALog mHwSettingInfoSALog;
    HwSettingContract.IPresenter mPresenter;
    WritingToolManager mWritingToolManager;

    public HwSettingHighlighterInfo(WritingToolManager writingToolManager, HwSettingContract.IPresenter iPresenter, HwSettingInfoSALog hwSettingInfoSALog) {
        this.mWritingToolManager = writingToolManager;
        this.mPresenter = iPresenter;
        this.mHwSettingInfoSALog = hwSettingInfoSALog;
    }

    private void setStraightType(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        String str = spenSettingUIPenInfo != null ? spenSettingUIPenInfo.name : "";
        int toolTypeAction = this.mWritingToolManager.getToolTypeAction(2);
        if (toolTypeAction == 12 || toolTypeAction == 15 || toolTypeAction == 9) {
            return;
        }
        this.mWritingToolManager.setToolTypeAction(2, Default.isStraightType(str) ? 4 : 3);
        this.mWritingToolManager.setToolTypeAction(6, 8);
    }

    public void setPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        setStraightType(spenSettingUIPenInfo);
        this.mWritingToolManager.setPenSettingInfo(spenSettingUIPenInfo);
        this.mPresenter.getSettingInfoManager().getHighlighterData().setSettingHighlighterInfo(spenSettingUIPenInfo);
    }

    public boolean setSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        SpenSettingUIPenInfo settingHighlighterInfoSelected = this.mPresenter.getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected();
        if (settingHighlighterInfoSelected == null || CommonUtil.comparePenInfo(spenSettingUIPenInfo, settingHighlighterInfoSelected)) {
            return false;
        }
        setPenInfo(spenSettingUIPenInfo);
        this.mHwSettingInfoSALog.insertHighlighterInfo(settingHighlighterInfoSelected, spenSettingUIPenInfo);
        return true;
    }

    public void updateHighlighterSettingInfo() {
        SpenSettingUIPenInfo settingHighlighterInfoSelected = this.mPresenter.getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected();
        setStraightType(settingHighlighterInfoSelected);
        this.mWritingToolManager.setPenSettingInfo(settingHighlighterInfoSelected);
    }
}
