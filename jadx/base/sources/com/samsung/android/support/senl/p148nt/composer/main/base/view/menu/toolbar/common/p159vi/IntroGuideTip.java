package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class IntroGuideTip {
    protected static String TAG = Logger.createTag("IntroGuideTip");
    private static IntroGuideTip mInstance;
    private WeakReference<SmartTipPopup> mGuideTipPopupRef;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canShow(View view) {
        if (view == null) {
            Logger.m11000e(TAG, "canShow# targetView is null");
            return false;
        }
        boolean z = SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_GUIDE_SMART_TIP_SHOWN, true);
        if (z && view.isShown() && view.hasWindowFocus()) {
            boolean zIsInputMethodShown = InputMethodCompat.getInstance().isInputMethodShown(view.getContext(), view, false);
            AbstractC8014b.m7224z("canShow isKeyboardShown : ", TAG, zIsInputMethodShown);
            return !zIsInputMethodShown;
        }
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("canShow fail needToShow : ", " targetShown : ", z);
        sbM3200j.append(view.isShown());
        sbM3200j.append(" targetWindowFocus : ");
        sbM3200j.append(view.hasWindowFocus());
        Logger.m11003i(str, sbM3200j.toString());
        return false;
    }

    private static void disableShowCondition() {
        SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_GUIDE_SMART_TIP_SHOWN, false);
    }

    public static void dismiss() {
        SmartTipPopup guideTipPopup;
        if (!hasInstance() || (guideTipPopup = getInstance().getGuideTipPopup()) == null) {
            return;
        }
        Logger.m10999d(TAG, "dismiss");
        guideTipPopup.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmartTipPopup getGuideTipPopup() {
        WeakReference<SmartTipPopup> weakReference = this.mGuideTipPopupRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized IntroGuideTip getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new IntroGuideTip();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private static int getRunCount() {
        return SharedPreferencesCompat.getInstance("Composer").getInt(SharedPreferencesConstants.FLOATING_GUIDE_COUNT_ID, 1);
    }

    private static synchronized boolean hasInstance() {
        return mInstance != null;
    }

    private static boolean isValidCount() {
        if (getRunCount() == 5) {
            return true;
        }
        updateRunCount();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void release() {
        IntroGuideTip introGuideTip = mInstance;
        if (introGuideTip != null) {
            introGuideTip.mGuideTipPopupRef = null;
            mInstance = null;
        }
    }

    public static void show(View view) {
        Logger.m11003i(TAG, Constants.IntentExtraValue.SHOW);
        if (canShow(view)) {
            showDelayedAfterLaidOut(view);
        }
    }

    public static void showAfterDismiss() {
        SmartTipPopup guideTipPopup;
        if (!hasInstance() || (guideTipPopup = getInstance().getGuideTipPopup()) == null) {
            return;
        }
        guideTipPopup.dismiss();
        getInstance().showGuideTip(guideTipPopup.getParentView(), guideTipPopup.getParentView().getResources().getString(C9086R.string.toolbar_guide_smart_tip), guideTipPopup.getParentView().getResources().getString(C9086R.string.toolbar_guide_smart_tip_stt));
    }

    private static void showDelayedAfterLaidOut(final View view) {
        Logger.m11003i(TAG, "showDelayedAfterLaidOut +");
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.IntroGuideTip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (IntroGuideTip.canShow(view)) {
                    SmartTipPopup guideTipPopup = IntroGuideTip.getInstance().getGuideTipPopup();
                    if (guideTipPopup == null || !guideTipPopup.isShowing()) {
                        Logger.m11003i(IntroGuideTip.TAG, "showDelayedAfterLaidOut -");
                        InputMethodCompat.getInstance().hideSoftInput(view.getContext(), view);
                        IntroGuideTip.getInstance().showGuideTip(view, view.getResources().getString(C9086R.string.toolbar_guide_smart_tip), view.getResources().getString(C9086R.string.toolbar_guide_smart_tip_stt));
                    }
                }
            }
        });
        view.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideTip(View view, String str, String str2) {
        Logger.m10999d(TAG, "showGuideTip");
        try {
            SmartTipPopup smartTipPopup = new SmartTipPopup(view, str);
            smartTipPopup.setOnDismissListener(new SmartTipPopup.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.IntroGuideTip.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnDismissListener
                public void onDismissed() {
                    IntroGuideTip.release();
                }
            });
            if (!smartTipPopup.show()) {
                release();
                return;
            }
            disableShowCondition();
            this.mGuideTipPopupRef = new WeakReference<>(smartTipPopup);
            if (VoiceAssistantTTS.isVoiceAssistantEnabled(view.getContext())) {
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(str2);
            }
        } catch (InstantiationException e) {
            Logger.m11000e(TAG, "showGuideTip " + e.getMessage());
            disableShowCondition();
            release();
        }
    }

    public static void showOnValidCount(View view) {
        if (isValidCount() && canShow(view)) {
            showDelayedAfterLaidOut(view);
        }
    }

    public static void update() {
        SmartTipPopup guideTipPopup;
        if (!hasInstance() || (guideTipPopup = getInstance().getGuideTipPopup()) == null) {
            return;
        }
        guideTipPopup.update();
    }

    private static void updateRunCount() {
        SharedPreferencesCompat.getInstance("Composer").putInt(SharedPreferencesConstants.FLOATING_GUIDE_COUNT_ID, getRunCount() + 1);
    }
}
