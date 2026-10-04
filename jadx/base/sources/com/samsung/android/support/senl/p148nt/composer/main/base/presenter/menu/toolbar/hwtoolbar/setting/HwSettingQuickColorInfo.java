package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import android.graphics.Color;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingQuickColorInfo {
    HwSettingContract.IPresenter mPresenter;

    public HwSettingQuickColorInfo(HwSettingContract.IPresenter iPresenter) {
        this.mPresenter = iPresenter;
    }

    private int convertHSVToARGB(int i, float[] fArr) {
        int iHSVToColor = ColorCompat.HSVToColor(fArr);
        return Color.argb(i, Color.red(iHSVToColor), Color.green(iHSVToColor), Color.blue(iHSVToColor));
    }

    public void applyQuickColor(float[] fArr) {
        if (this.mPresenter.getHwToolbarState().getLastPenType() == 2) {
            SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo(this.mPresenter.getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected());
            spenSettingUIPenInfo.hsv = fArr;
            spenSettingUIPenInfo.color = convertHSVToARGB(Color.alpha(spenSettingUIPenInfo.color), fArr);
            this.mPresenter.setPenSettingInfo(spenSettingUIPenInfo);
            return;
        }
        SpenSettingUIPenInfo spenSettingUIPenInfo2 = new SpenSettingUIPenInfo(this.mPresenter.getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected());
        spenSettingUIPenInfo2.hsv = fArr;
        spenSettingUIPenInfo2.color = Color.HSVToColor(Color.alpha(spenSettingUIPenInfo2.color), fArr);
        this.mPresenter.setHighlighterSettingInfo(spenSettingUIPenInfo2);
    }

    public void setQuickColorInfo(int i, float[] fArr) {
        this.mPresenter.getSettingInfoManager().getQuickColorData().setQuickHSVColor(i, fArr);
    }
}
