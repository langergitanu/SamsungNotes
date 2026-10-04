package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FullScreenButtonView extends SystemUiControlView {
    private static final int DURATION = 333;
    private static final String TAG = Logger.createTag("FullScreenButtonView");
    private View.OnClickListener mClickListener;
    private final View mFullScreenBtn;
    private boolean mIsHiding;
    private int mTemporarilySelectedMenuKey;

    public FullScreenButtonView(View view) {
        this.mFullScreenBtn = view;
    }

    private void announceFullScreenMode(boolean z) {
        String strM12i;
        String str = this.mFullScreenBtn.getResources().getString(C9086R.string.composer_opt_full_screen) + ". ";
        if (z) {
            strM12i = AbstractC0000a.m12i(this.mFullScreenBtn.getResources(), C9086R.string.composer_tts_on, AbstractC1974b.m1324q(str));
        } else {
            strM12i = AbstractC0000a.m12i(this.mFullScreenBtn.getResources(), C9086R.string.composer_tts_off, AbstractC1974b.m1324q(str));
        }
        this.mFullScreenBtn.announceForAccessibility(strM12i);
    }

    private void hideToolbar(Activity activity, boolean z, @Nullable final ComposerViewContract.HWToolbarContract hWToolbarContract) {
        final Activity activity2;
        final boolean z2;
        ICustomToolbar customAppToolbar = getCustomAppToolbar(activity);
        if (customAppToolbar == null) {
            return;
        }
        final View viewFindViewById = activity.getWindow().getDecorView().findViewById(C9086R.id.main_layout_container_parent);
        if (z) {
            this.mTemporarilySelectedMenuKey = 0;
            if (hWToolbarContract != null) {
                if (hWToolbarContract.isSelected(262144)) {
                    this.mTemporarilySelectedMenuKey = 262144;
                } else if (hWToolbarContract.isSelected(4)) {
                    this.mTemporarilySelectedMenuKey = 4;
                }
                hWToolbarContract.hideToolbar();
            }
            activity2 = activity;
            z2 = z;
            customAppToolbar.setAnimationListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FullScreenButtonView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Logger.m10999d(FullScreenButtonView.TAG, "hideToolbar# onAnimationEnd");
                    viewFindViewById.setPadding(0, 0, 0, 0);
                    FullScreenButtonView.this.updateToShowHideStatusBar(activity2, true);
                    FullScreenButtonView.this.showFullScreenBtn(z2);
                    new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FullScreenButtonView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ComposerViewContract.HWToolbarContract hWToolbarContract2 = hWToolbarContract;
                            if (hWToolbarContract2 != null) {
                                hWToolbarContract2.showToolbar();
                                if (FullScreenButtonView.this.mTemporarilySelectedMenuKey != 0) {
                                    Logger.m10999d(FullScreenButtonView.TAG, "hideToolbar# onAnimationEnd post. TemporarilySelectedMenuKey : " + FullScreenButtonView.this.mTemporarilySelectedMenuKey);
                                    if (FullScreenButtonView.this.mTemporarilySelectedMenuKey == 262144) {
                                        hWToolbarContract.setSelectedLaserPenButton();
                                    } else if (FullScreenButtonView.this.mTemporarilySelectedMenuKey == 4) {
                                        hWToolbarContract.setSelectedEraserButton();
                                    }
                                }
                            }
                        }
                    }, 50L);
                }
            });
        } else {
            activity2 = activity;
            z2 = z;
        }
        customAppToolbar.hideToolbar(viewFindViewById, z2);
        if (z2) {
            return;
        }
        updateToShowHideStatusBar(activity2, true);
        showFullScreenBtn(z2);
    }

    private void runHideAnimation(boolean z) {
        this.mFullScreenBtn.animate().alpha(0.0f).setDuration(z ? 333L : 0L).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FullScreenButtonView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                FullScreenButtonView.this.mFullScreenBtn.setVisibility(8);
                FullScreenButtonView.this.mIsHiding = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FullScreenButtonView.this.mFullScreenBtn.setVisibility(8);
                FullScreenButtonView.this.mIsHiding = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                FullScreenButtonView.this.mIsHiding = true;
            }
        }).start();
    }

    private void runShowAnimation(boolean z) {
        this.mFullScreenBtn.animate().alpha(1.0f).setDuration(z ? 333L : 0L).setListener(null).start();
    }

    private void showToolbar(final Activity activity, final boolean z) {
        ICustomToolbar customAppToolbar = getCustomAppToolbar(activity);
        if (customAppToolbar == null) {
            return;
        }
        final View viewFindViewById = activity.getWindow().getDecorView().findViewById(C9086R.id.main_layout_container_parent);
        if (z) {
            customAppToolbar.setAnimationListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FullScreenButtonView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewFindViewById.setPadding(0, 0, 0, 0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    FullScreenButtonView.this.updateToShowHideStatusBar(activity, false);
                    FullScreenButtonView.this.hideFullScreenBtn(activity, z);
                }
            });
        }
        customAppToolbar.showToolbar(viewFindViewById, z);
        if (z) {
            return;
        }
        updateToShowHideStatusBar(activity, false);
        hideFullScreenBtn(activity, z);
    }

    private void updateStatusBarAndButton(Activity activity, boolean z) {
        updateToShowHideStatusBar(activity, z);
        if (z) {
            showFullScreenBtn(false);
        } else {
            hideFullScreenBtn(activity, false);
        }
    }

    private void updateViewByFullScreenMode(Activity activity, boolean z, boolean z2, @Nullable ComposerViewContract.HWToolbarContract hWToolbarContract) {
        if (z) {
            hideToolbar(activity, z2, hWToolbarContract);
        } else {
            showToolbar(activity, z2);
        }
        AbstractC8014b.m7224z("updateFullScreenMode IsFullScreenMode# ", TAG, z);
    }

    public void changeFullScreenMode(Activity activity, ComposerState composerState, ComposerViewContract.HWToolbarContract hWToolbarContract) {
        boolean z = !composerState.isFullScreenMode();
        updateViewByFullScreenMode(activity, z, true, hWToolbarContract);
        composerState.setIsFullScreenMode(z);
    }

    public void hideFullScreenBtn(Activity activity, boolean z) {
        if (this.mFullScreenBtn.getVisibility() == 0 && !this.mIsHiding) {
            announceFullScreenMode(false);
            runHideAnimation(z);
        }
        WindowManagerCompat.getInstance().controlIndicatorBar(activity);
    }

    public void init(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        ViewCompat viewCompat = ViewCompat.getInstance();
        View view = this.mFullScreenBtn;
        viewCompat.setTooltipText(view, view.getContentDescription());
        this.mFullScreenBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.FullScreenButtonView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FullScreenButtonView.this.mClickListener.onClick(view2);
            }
        });
    }

    public void showFullScreenBtn(boolean z) {
        if (this.mFullScreenBtn.getVisibility() != 0) {
            this.mFullScreenBtn.setVisibility(0);
            announceFullScreenMode(true);
            runShowAnimation(z);
        }
    }

    public void updateFullScreen(Activity activity, boolean z) {
        ICustomToolbar customAppToolbar = getCustomAppToolbar(activity);
        if (customAppToolbar == null) {
            return;
        }
        if (!(z && customAppToolbar.getVisibility() == 0) && (z || customAppToolbar.getVisibility() == 0)) {
            return;
        }
        updateViewByFullScreenMode(activity, z, false, null);
        updateStatusBarAndButton(activity, z);
    }
}
