package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit;

import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleCoeditGuideTip {
    private static final String TAG = Logger.createTag("TitleCoeditGuideTip");
    private boolean mIsShowingGuideTip = false;
    private SmartTipPopup mSmartTipPopup;
    private View mTargetView;

    private boolean canShowMeetGuideTip(View view) {
        if (this.mIsShowingGuideTip) {
            return false;
        }
        boolean z = SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_COEDIT_MEET_TIP_SHOWN, true);
        if (z && view != null && view.isShown() && view.hasWindowFocus()) {
            return true;
        }
        Logger.m11003i(TAG, "canShowMeetGuideTip# fail! needToShow:" + z + ", targetView:" + view);
        return false;
    }

    private boolean canShowWriterGuideTip(View view) {
        if (this.mIsShowingGuideTip) {
            return false;
        }
        boolean z = SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_COEDIT_WRITER_TIP_SHOWN, true);
        if (z && view != null && view.isShown() && view.hasWindowFocus()) {
            return true;
        }
        Logger.m11003i(TAG, "canShowWriterGuideTip# fail! needToShow:" + z + ", targetView:" + view);
        return false;
    }

    private void disableMeetGuideTip() {
        SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_COEDIT_MEET_TIP_SHOWN, false);
    }

    private void disableWriterGuideTip() {
        SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_COEDIT_WRITER_TIP_SHOWN, false);
    }

    public void showMeetGuideTip(View view) {
        if (canShowMeetGuideTip(view)) {
            Logger.m11003i(TAG, "showMeetGuideTip#");
            try {
                String string = view.getResources().getString(C9086R.string.composer_coedit_meet_message);
                this.mTargetView = view;
                SmartTipPopup smartTipPopup = new SmartTipPopup(this.mTargetView, string);
                this.mSmartTipPopup = smartTipPopup;
                smartTipPopup.setOnDismissListener(new SmartTipPopup.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditGuideTip.2
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnDismissListener
                    public void onDismissed() {
                        Logger.m11003i(TitleCoeditGuideTip.TAG, "showMeetGuideTip# onDismissed ");
                        TitleCoeditGuideTip.this.mIsShowingGuideTip = false;
                    }
                });
                if (this.mSmartTipPopup.show()) {
                    this.mIsShowingGuideTip = true;
                    disableMeetGuideTip();
                }
            } catch (InstantiationException e) {
                Logger.m11000e(TAG, "showMeetGuideTip# " + e.getMessage());
            }
        }
    }

    public void showWriterGuideTip(View view) {
        if (canShowWriterGuideTip(view)) {
            Logger.m11003i(TAG, "showWriterGuideTip#");
            try {
                String string = view.getResources().getString(C9086R.string.composer_coedit_group_member_message);
                this.mTargetView = view;
                SmartTipPopup smartTipPopup = new SmartTipPopup(this.mTargetView, string);
                this.mSmartTipPopup = smartTipPopup;
                smartTipPopup.setOnDismissListener(new SmartTipPopup.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditGuideTip.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnDismissListener
                    public void onDismissed() {
                        Logger.m11003i(TitleCoeditGuideTip.TAG, "showWriterGuideTip# onDismissed ");
                        TitleCoeditGuideTip.this.mIsShowingGuideTip = false;
                    }
                });
                if (this.mSmartTipPopup.show()) {
                    this.mIsShowingGuideTip = true;
                    disableWriterGuideTip();
                }
            } catch (InstantiationException e) {
                Logger.m11000e(TAG, "showWriterGuideTip# " + e.getMessage());
            }
        }
    }

    public void updateGuideTipPopup() {
        SmartTipPopup smartTipPopup = this.mSmartTipPopup;
        if (smartTipPopup == null || !smartTipPopup.isShowing()) {
            return;
        }
        if (this.mTargetView != null) {
            Logger.m11003i(TAG, "updateGuideTipPopup# smartTipPopup update");
            this.mSmartTipPopup.update();
        } else {
            Logger.m11003i(TAG, "updateGuideTipPopup# smartTipPopup dismiss");
            this.mSmartTipPopup.dismiss();
        }
    }
}
