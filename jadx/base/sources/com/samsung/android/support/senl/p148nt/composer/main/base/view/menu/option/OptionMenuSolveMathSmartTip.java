package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.smarttip.SmartTipsPreferenceManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuSolveMathSmartTip {
    private static final int OPTION_MENU_SOLVE_MATH_SMART_TIP_NONE = 0;
    private static final String OPTION_MENU_SOLVE_MATH_SMART_TIP_PREF = "OptionMenuSolveMathSmartTipPref";
    private static final int OPTION_MENU_SOLVE_MATH_SMART_TIP_SHOW = 1;
    private static final String TAG = Logger.createTag("OptionMenuSolveMathSmartTip");
    private final Activity mActivity;
    private SmartTipPopup mSmartTipPopup;

    public OptionMenuSolveMathSmartTip(Activity activity) {
        this.mActivity = activity;
        showSolveMathSmartTip();
    }

    private void showSolveMathSmartTip() {
        boolean z = SmartTipsPreferenceManager.getSmartTipsPreference(this.mActivity, OPTION_MENU_SOLVE_MATH_SMART_TIP_PREF, 0) == 0;
        AbstractC8014b.m7220v("showSolveMathSmartTip# isNoneState ", TAG, z);
        if (z) {
            final View viewFindViewById = this.mActivity.findViewById(C9086R.id.toolbar);
            viewFindViewById.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuSolveMathSmartTip.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonUtil.isNotAvailableActivity(OptionMenuSolveMathSmartTip.this.mActivity)) {
                        return;
                    }
                    View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.action_more);
                    if (OptionMenuSolveMathSmartTip.this.mSmartTipPopup == null) {
                        try {
                            OptionMenuSolveMathSmartTip.this.mSmartTipPopup = new SmartTipPopup(viewFindViewById2, OptionMenuSolveMathSmartTip.this.mActivity.getResources().getString(C9086R.string.solve_math_guide_tip), false);
                            OptionMenuSolveMathSmartTip.this.mSmartTipPopup.setOnStateChangeListener(new SmartTipPopup.OnStateChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuSolveMathSmartTip.1.1
                                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnStateChangeListener
                                public void onStateChanged(int i) {
                                    AbstractC0000a.m3D(i, "onStateChanged# state ", OptionMenuSolveMathSmartTip.TAG);
                                }
                            });
                            if (OptionMenuSolveMathSmartTip.this.mSmartTipPopup.show()) {
                                SmartTipsPreferenceManager.setSmartTipsPreference(OptionMenuSolveMathSmartTip.this.mActivity, OptionMenuSolveMathSmartTip.OPTION_MENU_SOLVE_MATH_SMART_TIP_PREF, 1);
                                Logger.m10999d(OptionMenuSolveMathSmartTip.TAG, "showSolveMathSmartTip# show");
                            }
                        } catch (InstantiationException e) {
                            Logger.m11000e(OptionMenuSolveMathSmartTip.TAG, "showSolveMathSmartTip " + e.getMessage());
                            SmartTipsPreferenceManager.setSmartTipsPreference(OptionMenuSolveMathSmartTip.this.mActivity, OptionMenuSolveMathSmartTip.OPTION_MENU_SOLVE_MATH_SMART_TIP_PREF, 1);
                        }
                    }
                }
            });
        }
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
        SmartTipPopup smartTipPopup = this.mSmartTipPopup;
        if (smartTipPopup == null || !smartTipPopup.isShowing()) {
            return;
        }
        Logger.m11003i(TAG, "onConfigurationChanged# smartTipPopup dismiss");
        this.mSmartTipPopup.update();
    }

    public void onWindowFocusChanged() {
        Logger.m11003i(TAG, "onWindowFocusChanged");
    }
}
