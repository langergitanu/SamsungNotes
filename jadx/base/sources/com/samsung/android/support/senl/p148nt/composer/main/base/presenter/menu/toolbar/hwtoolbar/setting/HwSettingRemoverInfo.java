package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingRemoverInfo {
    private static final String TAG = Logger.createTag("HwSettingRemoverInfo");
    private boolean mIsNotStickyMemoConnected = true;
    private final HwSettingContract.IPresenter mPresenter;
    private final WritingToolManager mWritingToolManager;

    public HwSettingRemoverInfo(WritingToolManager writingToolManager, HwSettingContract.IPresenter iPresenter) {
        this.mWritingToolManager = writingToolManager;
        this.mPresenter = iPresenter;
    }

    public boolean isNotStickyMemoConnected() {
        return this.mIsNotStickyMemoConnected;
    }

    public void setNotStickyMemoConnected(boolean z) {
        this.mIsNotStickyMemoConnected = z;
    }

    public void setRemoverInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        this.mWritingToolManager.setRemoverSettingInfo(spenSettingRemoverInfo);
        this.mPresenter.getSettingInfoManager().getRemoverInfoData().setSettingRemoverInfo(spenSettingRemoverInfo);
    }

    public void updateRemoverSettingInfo() {
        this.mWritingToolManager.setRemoverSettingInfo(this.mPresenter.getSettingInfoManager().getRemoverInfoData().getSettingRemoverInfoSelected());
        this.mWritingToolManager.setToolTypeAction(2, 8);
    }
}
