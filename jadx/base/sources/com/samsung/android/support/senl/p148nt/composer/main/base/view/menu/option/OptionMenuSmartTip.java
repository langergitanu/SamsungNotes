package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.winset.smarttip.SmartTipsPreferenceManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuSmartTip {
    private static final String OPTION_MENU_SMART_TIP_SPEN_ACTIVE_PREF = "OptionMenuSmartTipSpenActivePref";
    private static final int OPTION_MENU_SPEN_ACTIVE_OFF = 0;
    private static final int OPTION_MENU_SPEN_ACTIVE_ON = 1;
    private static final String TAG = Logger.createTag("OptionMenuSmartTip");
    private final Activity mActivity;
    private final IOptionMenuFingerDrawingPresenter mPresenter;
    private SmartTipPopup mSmartTipPopup;

    public OptionMenuSmartTip(Activity activity, OptionMenuContract.IOptionMenu iOptionMenu, OptionMenuPresenter optionMenuPresenter) {
        this.mActivity = activity;
        this.mPresenter = optionMenuPresenter.getOptionMenuFingerDrawingPresenter();
        showFingerDrawingSmartTip(ComposerSpenUtils.canUseSpen(activity));
    }

    private boolean isSpenActiveChange(boolean z) {
        return (SmartTipsPreferenceManager.getSmartTipsPreference(this.mActivity, OPTION_MENU_SMART_TIP_SPEN_ACTIVE_PREF, 0) == 1) != z;
    }

    private void showFingerDrawingSmartTip(boolean z) {
        boolean z2 = this.mPresenter.getSmartTipState() == -1;
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("showFingerDrawing# ", SQLKeyword.COMMA, z);
        sbM3200j.append(this.mPresenter.isSpenOnlyMode());
        sbM3200j.append(SQLKeyword.COMMA);
        sbM3200j.append(this.mPresenter.getSmartTipState());
        Logger.m10999d(str, sbM3200j.toString());
        if (z2 && z && !this.mPresenter.isSpenOnlyMode()) {
            final View viewFindViewById = this.mActivity.findViewById(C9086R.id.toolbar);
            viewFindViewById.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuSmartTip.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonUtil.isNotAvailableActivity(OptionMenuSmartTip.this.mActivity)) {
                        return;
                    }
                    View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.action_more);
                    if (OptionMenuSmartTip.this.mSmartTipPopup == null) {
                        try {
                            OptionMenuSmartTip.this.mSmartTipPopup = new SmartTipPopup(viewFindViewById2, OptionMenuSmartTip.this.mActivity.getResources().getString(C9086R.string.composer_finger_drawing_smart_tip_description));
                            if (OptionMenuSmartTip.this.mSmartTipPopup.show()) {
                                OptionMenuSmartTip.this.mPresenter.setSmartTipState(1);
                                Logger.m10999d(OptionMenuSmartTip.TAG, "showFingerDrawing# show");
                            }
                        } catch (InstantiationException e) {
                            Logger.m11000e(OptionMenuSmartTip.TAG, "showFingerDrawingSmartTip " + e.getMessage());
                            OptionMenuSmartTip.this.mPresenter.setSmartTipState(1);
                        }
                    }
                }
            });
        }
    }

    private void updateSpenActive(boolean z) {
        SmartTipsPreferenceManager.setSmartTipsPreference(this.mActivity, OPTION_MENU_SMART_TIP_SPEN_ACTIVE_PREF, z ? 1 : 0);
    }

    public void hideSmartTip() {
        String str = TAG;
        Logger.m11003i(str, "hideSmartTip#");
        SmartTipPopup smartTipPopup = this.mSmartTipPopup;
        if (smartTipPopup != null && smartTipPopup.isShowing()) {
            Logger.m11003i(str, "hideSmartTip# smartTipPopup dismiss");
            this.mSmartTipPopup.dismiss();
        }
        this.mSmartTipPopup = null;
    }

    public void onConfigurationChanged() {
        boolean zCanUseSpen = ComposerSpenUtils.canUseSpen(this.mActivity);
        String str = TAG;
        AbstractC8014b.m7224z("onConfigurationChanged# spenActive ", str, zCanUseSpen);
        if (isSpenActiveChange(zCanUseSpen)) {
            updateSpenActive(zCanUseSpen);
        }
        SmartTipPopup smartTipPopup = this.mSmartTipPopup;
        if (smartTipPopup == null || !smartTipPopup.isShowing()) {
            return;
        }
        if (zCanUseSpen) {
            Logger.m11003i(str, "onConfigurationChanged# smartTipPopup update");
            this.mSmartTipPopup.update();
        } else {
            Logger.m11003i(str, "onConfigurationChanged# smartTipPopup dismiss");
            this.mSmartTipPopup.dismiss();
        }
    }

    public void onWindowFocusChanged() {
        boolean zCanUseSpen = ComposerSpenUtils.canUseSpen(this.mActivity);
        if (isSpenActiveChange(zCanUseSpen)) {
            updateSpenActive(zCanUseSpen);
        }
    }
}
