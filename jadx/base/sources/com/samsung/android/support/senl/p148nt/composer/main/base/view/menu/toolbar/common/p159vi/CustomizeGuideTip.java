package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomizeGuideTip {
    protected static String TAG = Logger.createTag("CustomizeGuideTip");
    private static CustomizeGuideTip mInstance;
    private WeakReference<SmartTipPopup> mGuideTipPopupRef;
    private boolean mIsLaunchCustomizeSetting = false;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.CustomizeGuideTip$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ViewOnClickListenerC105403 implements View.OnClickListener {
        final /* synthetic */ View val$targetView;

        public ViewOnClickListenerC105403(View view) {
            this.val$targetView = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Logger.m10999d(CustomizeGuideTip.TAG, "onClicked " + view.toString());
            this.val$targetView.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.CustomizeGuideTip.3.1
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z) {
                    if (z) {
                        ViewOnClickListenerC105403.this.val$targetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
                        ViewOnClickListenerC105403.this.val$targetView.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.CustomizeGuideTip.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                View view2 = ViewOnClickListenerC105403.this.val$targetView;
                                if (view2 instanceof AllSideToolbarContainerLayout) {
                                    ((AllSideToolbarContainerLayout) view2).updateToolbarItemList();
                                }
                            }
                        }, 500L);
                    }
                }
            });
            CustomizeGuideTip.this.launchCustomizeSetting(view.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canShow(View view) {
        if (SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_CUSTOMIZE_TOOLBAR_SHOWN, true) && view != null && view.isShown() && view.hasWindowFocus()) {
            return !InputMethodCompat.getInstance().isInputMethodShown(view.getContext(), view, false);
        }
        return false;
    }

    private static void disableShowCondition() {
        SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_CUSTOMIZE_TOOLBAR_SHOWN, false);
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
    public static synchronized CustomizeGuideTip getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new CustomizeGuideTip();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private static int getRunCount() {
        return SharedPreferencesCompat.getInstance("Composer").getInt(SharedPreferencesConstants.CUSTOM_GUIDE_COUNT_ID, 1);
    }

    private static boolean hasInstance() {
        return mInstance != null;
    }

    private static boolean isValidCount() {
        if (getRunCount() == 3) {
            return true;
        }
        updateRunCount();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchCustomizeSetting(Context context) {
        if (NoteListAccessHandler.getSettingsActivity() == null) {
            PostLaunchManager.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(context, NoteListAccessHandler.getSettingsActivity());
        intent.setAction("android.intent.action.EDIT");
        intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 12);
        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_COMPOSER);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        this.mIsLaunchCustomizeSetting = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.mGuideTipPopupRef = null;
        mInstance = null;
    }

    private static void showDelayedAfterLaidOut(final View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.CustomizeGuideTip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (CustomizeGuideTip.canShow(view)) {
                    SmartTipPopup guideTipPopup = CustomizeGuideTip.getInstance().getGuideTipPopup();
                    if (guideTipPopup == null || !guideTipPopup.isShowing()) {
                        CustomizeGuideTip.getInstance().showGuideTip(view);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideTip(View view) {
        Logger.m10999d(TAG, "showGuideTip");
        String string = view.getResources().getString(C9086R.string.customize_toolbar_guide_smart_tip);
        String string2 = view.getResources().getString(C9086R.string.customize_toolbar);
        try {
            SmartTipPopup smartTipPopup = new SmartTipPopup(view, string);
            smartTipPopup.setOnDismissListener(new SmartTipPopup.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.CustomizeGuideTip.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.OnDismissListener
                public void onDismissed() {
                    ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_CUSTOMIZE_GUIDE_TIP, CustomizeGuideTip.this.mIsLaunchCustomizeSetting ? "a" : "b");
                    CustomizeGuideTip.this.release();
                }
            });
            smartTipPopup.setAction(string2, new ViewOnClickListenerC105403(view));
            if (!smartTipPopup.show()) {
                release();
            } else {
                disableShowCondition();
                this.mGuideTipPopupRef = new WeakReference<>(smartTipPopup);
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
        SharedPreferencesCompat.getInstance("Composer").putInt(SharedPreferencesConstants.CUSTOM_GUIDE_COUNT_ID, getRunCount() + 1);
    }
}
