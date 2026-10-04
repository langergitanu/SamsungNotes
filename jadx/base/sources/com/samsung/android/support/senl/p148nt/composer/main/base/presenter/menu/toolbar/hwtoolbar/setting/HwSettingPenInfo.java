package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingPenInfo {
    HwSettingInfoSALog mHwSettingInfoSALog;
    HwSettingContract.IPresenter mPresenter;
    WritingToolManager mWritingToolManager;

    public HwSettingPenInfo(WritingToolManager writingToolManager, HwSettingContract.IPresenter iPresenter, HwSettingInfoSALog hwSettingInfoSALog) {
        this.mWritingToolManager = writingToolManager;
        this.mPresenter = iPresenter;
        this.mHwSettingInfoSALog = hwSettingInfoSALog;
    }

    public void setPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        this.mPresenter.getSettingInfoManager().getPenInfoData().setSettingPenInfo(spenSettingUIPenInfo);
        this.mWritingToolManager.setPenSettingInfo(spenSettingUIPenInfo);
    }

    public boolean setSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        SpenSettingUIPenInfo settingPenInfoSelected = this.mPresenter.getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected();
        if (settingPenInfoSelected == null || CommonUtil.comparePenInfo(spenSettingUIPenInfo, settingPenInfoSelected)) {
            return false;
        }
        setPenInfo(spenSettingUIPenInfo);
        this.mHwSettingInfoSALog.insertPenInfo(settingPenInfoSelected, spenSettingUIPenInfo);
        return true;
    }

    public void updatePenSettingInfo() {
        int toolTypeAction = this.mWritingToolManager.getToolTypeAction(2);
        if (toolTypeAction != 12 && toolTypeAction != 15) {
            this.mWritingToolManager.setToolTypeAction(2, 2);
            this.mWritingToolManager.setToolTypeAction(6, 8);
        }
        this.mWritingToolManager.setPenSettingInfo(this.mPresenter.getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected());
    }
}
