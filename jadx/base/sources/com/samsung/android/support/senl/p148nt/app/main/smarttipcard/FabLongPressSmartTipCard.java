package com.samsung.android.support.senl.p148nt.app.main.smarttipcard;

import android.view.View;
import android.view.ViewTreeObserver;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FabLongPressSmartTipCard {
    private static final int MIN_COUNT = 0;
    protected static String TAG = Logger.createTag("FabLongPressSmartTip");
    private static FabLongPressSmartTipCard mInstance;
    private WeakReference<SmartTipPopup> mSmartTipPopupRef;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canShowSmartTipCard(View view) {
        return view != null && view.isShown() && view.hasWindowFocus() && !DeviceUtils.isShopDemoDevice(view.getContext());
    }

    public static void disableTipCard() {
        SharedPreferencesCompat.getInstance(Constants.PREF_NAME_SMART_POPUP).putInt(Constants.KEY_FAB_REMAINING_NOTIFICATION_COUNT, 0);
    }

    public static void dismiss() {
        SmartTipPopup smartTipCardPopup;
        if (!hasInstance() || (smartTipCardPopup = getInstance().getSmartTipCardPopup()) == null) {
            return;
        }
        Logger.m12710d(TAG, "dismiss");
        smartTipCardPopup.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized FabLongPressSmartTipCard getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new FabLongPressSmartTipCard();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private static int getRemainingCount() {
        return SharedPreferencesCompat.getInstance(Constants.PREF_NAME_SMART_POPUP).getInt(Constants.KEY_FAB_REMAINING_NOTIFICATION_COUNT, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmartTipPopup getSmartTipCardPopup() {
        WeakReference<SmartTipPopup> weakReference = this.mSmartTipPopupRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static boolean hasInstance() {
        return mInstance != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.mSmartTipPopupRef = null;
        mInstance = null;
    }

    public static void requestShowLongPressTipCard(View view) {
        int remainingCount = getRemainingCount();
        if (!canShowSmartTipCard(view) || remainingCount <= 0) {
            return;
        }
        showDelayed(view, remainingCount);
    }

    private static void showDelayed(final View view, final int i) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.app.main.smarttipcard.FabLongPressSmartTipCard.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (FabLongPressSmartTipCard.canShowSmartTipCard(view)) {
                    SmartTipPopup smartTipCardPopup = FabLongPressSmartTipCard.getInstance().getSmartTipCardPopup();
                    if (smartTipCardPopup == null || !smartTipCardPopup.isShowing()) {
                        FabLongPressSmartTipCard.getInstance().showSmartTipCard(view, i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSmartTipCard(View view, int i) {
        Logger.m12710d(TAG, "showSmartTip");
        try {
            SmartTipPopup smartTipPopup = new SmartTipPopup(view, view.getResources().getString(C8003R.string.fab_long_press_smart_tip_text));
            smartTipPopup.setOnDismissListener(new SmartTipPopup.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.app.main.smarttipcard.FabLongPressSmartTipCard.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnDismissListener
                public void onDismissed() {
                    FabLongPressSmartTipCard.this.release();
                }
            });
            if (!smartTipPopup.show()) {
                release();
            } else {
                updateRemainingCount(i - 1);
                this.mSmartTipPopupRef = new WeakReference<>(smartTipPopup);
            }
        } catch (InstantiationException e) {
            Logger.m12711e(TAG, "showGuideTip " + e.getMessage());
            release();
        }
    }

    public static void update() {
        SmartTipPopup smartTipCardPopup;
        if (!hasInstance() || (smartTipCardPopup = getInstance().getSmartTipCardPopup()) == null) {
            return;
        }
        smartTipCardPopup.update();
    }

    private static void updateRemainingCount(int i) {
        SharedPreferencesCompat.getInstance(Constants.PREF_NAME_SMART_POPUP).putInt(Constants.KEY_FAB_REMAINING_NOTIFICATION_COUNT, i);
    }
}
