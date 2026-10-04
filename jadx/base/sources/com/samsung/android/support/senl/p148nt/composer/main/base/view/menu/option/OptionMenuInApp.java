package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class OptionMenuInApp {
    private static final int HIDE_DURATION = 100;
    private static final int SHOW_DURATION = 200;
    private static final String TAG = Logger.createTag("OptionMenuInApp");
    private final Activity mActivity;
    private View mContainerLockView;
    private boolean mIsProgressing;
    private boolean mIsShowing;
    private MenuItem mMenuItem;

    public OptionMenuInApp(Activity activity, boolean z) {
        this.mActivity = activity;
        this.mIsShowing = z;
        initLockView();
    }

    private void hideMenu(final LottieAnimationView lottieAnimationView) {
        MenuItem menuItem = this.mMenuItem;
        if (menuItem == null) {
            InAppLogger.m8595d(TAG, "hideMenu# menu item is null");
        } else if (!this.mIsShowing) {
            menuItem.setVisible(false);
        } else {
            lottieAnimationView.setAlpha(1.0f);
            lottieAnimationView.animate().alpha(0.0f).setDuration(100L).setInterpolator(new LinearInterpolator()).withStartAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuInApp.4
                @Override // java.lang.Runnable
                public void run() {
                    lottieAnimationView.setVisibility(0);
                }
            }).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuInApp.3
                @Override // java.lang.Runnable
                public void run() {
                    if (OptionMenuInApp.this.mMenuItem != null) {
                        OptionMenuInApp.this.mMenuItem.setVisible(false);
                    }
                }
            }).start();
        }
    }

    private void initLockView() {
        View view = new View(this.mActivity);
        this.mContainerLockView = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mContainerLockView.setBackgroundColor(0);
        this.mContainerLockView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuInApp.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                InAppLogger.m8595d(OptionMenuInApp.TAG, "onTouch# block touch while connecting");
                return true;
            }
        });
    }

    private void showMenu(final LottieAnimationView lottieAnimationView) {
        if (this.mIsShowing) {
            return;
        }
        if (lottieAnimationView.isAnimating()) {
            lottieAnimationView.cancelAnimation();
            return;
        }
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAlpha(0.0f);
        lottieAnimationView.setAnimation("In_app_collaboration_icon.json");
        lottieAnimationView.setRepeatCount(3);
        lottieAnimationView.animate().alpha(1.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).withStartAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuInApp.2
            @Override // java.lang.Runnable
            public void run() {
                lottieAnimationView.playAnimation();
            }
        }).start();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_READY, ComposerSAConstants.EVENT_IN_APP_COLLABORATION_READY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLockViewVisibility(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.mContainerLockView.getParent();
        if (z && viewGroup == null) {
            InAppLogger.m8595d(TAG, "updateLockViewVisibility# add Lock View");
            ((ViewGroup) this.mActivity.getWindow().getDecorView().findViewById(C9086R.id.main_container)).addView(this.mContainerLockView);
        } else {
            if (z || viewGroup == null) {
                return;
            }
            InAppLogger.m8595d(TAG, "updateLockViewVisibility# remove Lock View");
            viewGroup.removeView(this.mContainerLockView);
        }
    }

    public void release() {
        this.mMenuItem = null;
        this.mContainerLockView = null;
    }

    public boolean replaceMenuToProgress(final boolean z) {
        if (this.mMenuItem == null) {
            InAppLogger.m8595d(TAG, "replaceMenuToProgress# menu item is null");
            return false;
        }
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("replaceMenuToProgress# Progressing : ", " / mIsProgressing : ", z);
        sbM3200j.append(this.mIsProgressing);
        InAppLogger.m8595d(str, sbM3200j.toString());
        if (this.mIsProgressing == z) {
            return false;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuInApp.5
            @Override // java.lang.Runnable
            public void run() {
                if (OptionMenuInApp.this.mMenuItem == null) {
                    InAppLogger.m8595d(OptionMenuInApp.TAG, "replaceMenuToProgress#run menu item is null");
                    return;
                }
                OptionMenuInApp.this.mIsProgressing = z;
                if (OptionMenuInApp.this.mMenuItem.getActionView() != null) {
                    OptionMenuInApp.this.mMenuItem.getActionView().findViewById(C9086R.id.in_app_action_menu_progress).setVisibility(z ? 0 : 8);
                    OptionMenuInApp.this.mMenuItem.getActionView().findViewById(C9086R.id.in_app_action_menu_lottie_view).setVisibility(z ? 8 : 0);
                }
                OptionMenuInApp.this.updateLockViewVisibility(z);
            }
        });
        return true;
    }

    public void updateMenuView(OptionMenuParam optionMenuParam, boolean z, int i, View.OnClickListener onClickListener) {
        String str = TAG;
        InAppLogger.m8595d(str, "updateMenuView# mIsShowing : " + this.mIsShowing + ", show : " + z);
        MenuItem menuItemFindItem = ((Menu) optionMenuParam.getTarget()).findItem(C9086R.id.action_start_in_app_collaboration);
        this.mMenuItem = menuItemFindItem;
        if (menuItemFindItem == null) {
            InAppLogger.m8595d(str, "updateMenuView# action_start_in_app_collaboration is null");
            return;
        }
        View actionView = menuItemFindItem.getActionView();
        if (actionView == null) {
            InAppLogger.m8595d(str, "updateMenuView# ActionView is null");
            return;
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) actionView.findViewById(C9086R.id.in_app_action_menu_lottie_view);
        lottieAnimationView.setVisibility((!z || this.mIsProgressing) ? 8 : 0);
        if (z) {
            actionView.findViewById(C9086R.id.in_app_action_menu_progress).setVisibility(this.mIsProgressing ? 0 : 8);
            actionView.setOnClickListener(onClickListener);
            actionView.setAccessibilityDelegate(new VoiceAssistAsButton());
            ViewCompat.getInstance().setTooltipText(actionView);
            if (i == BackgroundColorUtil.getBlackColor(this.mActivity)) {
                lottieAnimationView.setColorFilter(ContextCompat.getColor(this.mActivity, C9086R.color.composer_default_button_color_dark));
            }
            showMenu(lottieAnimationView);
        } else {
            updateLockViewVisibility(false);
            hideMenu(lottieAnimationView);
            this.mIsProgressing = false;
        }
        this.mIsShowing = z;
    }
}
