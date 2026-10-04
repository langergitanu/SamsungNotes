package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingQuickSizeInfo {
    HwSettingContract.IPresenter mPresenter;

    public HwSettingQuickSizeInfo(HwSettingContract.IPresenter iPresenter) {
        this.mPresenter = iPresenter;
    }

    public void applyQuickSize(int i) {
        if (this.mPresenter.getHwToolbarState().getLastPenType() == 2) {
            SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo(this.mPresenter.getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected());
            spenSettingUIPenInfo.sizeLevel = i;
            this.mPresenter.setPenSettingInfo(spenSettingUIPenInfo);
        } else {
            SpenSettingUIPenInfo spenSettingUIPenInfo2 = new SpenSettingUIPenInfo(this.mPresenter.getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected());
            spenSettingUIPenInfo2.sizeLevel = i;
            this.mPresenter.setHighlighterSettingInfo(spenSettingUIPenInfo2);
        }
    }

    public void setQuickSizeInfo(int i, int i2) {
        this.mPresenter.getSettingInfoManager().getQuickSizeData().setSize(i, i2);
    }
}
