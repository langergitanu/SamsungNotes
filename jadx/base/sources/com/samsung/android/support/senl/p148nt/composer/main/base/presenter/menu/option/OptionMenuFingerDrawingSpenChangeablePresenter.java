package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.base.winset.smarttip.SmartTipsPreferenceManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuFingerDrawingSpenChangeablePresenter extends OptionMenuFingerDrawingPresenter {
    private static final String TAG = Logger.createTag("OptionMenuFingerDrawingSpenChangeablePresenter");
    private boolean mIsClear;

    public OptionMenuFingerDrawingSpenChangeablePresenter(ComposerViewPresenter composerViewPresenter, ComposerModel composerModel) {
        super(composerViewPresenter, composerModel);
        this.mIsClear = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuFingerDrawingPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public void blockSmartTip() {
        if (getSmartTipState() != 1) {
            setSmartTipState(0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuFingerDrawingPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public int getSmartTipState() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return SmartTipsPreferenceManager.getSmartTipsPreference(activity, IOptionMenuFingerDrawingPresenter.OPTION_MENU_SMART_TIP_PREF, -2);
        }
        return -2;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuFingerDrawingPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public void onAttachView(Activity activity) {
        super.onAttachView(activity);
        if (this.mIsClear && getSmartTipState() == 0) {
            setSmartTipState(-1);
            Logger.m10999d(TAG, "onAttachView# NONE state");
        }
        this.mIsClear = false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuFingerDrawingPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public void onDetachView() {
        super.onDetachView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuFingerDrawingPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public void setSmartTipState(int i) {
        Activity activity = this.mActivity;
        if (activity == null) {
            Logger.m10999d(TAG, "mActivity is null");
        } else {
            SmartTipsPreferenceManager.setSmartTipsPreference(activity, IOptionMenuFingerDrawingPresenter.OPTION_MENU_SMART_TIP_PREF, i);
            AbstractC0000a.m3D(i, "setSmartTipState#. ", TAG);
        }
    }
}
