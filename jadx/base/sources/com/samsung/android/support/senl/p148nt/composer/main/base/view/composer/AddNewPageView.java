package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AddNewPageView {
    private static final String TAG = Logger.createTag("AddNewPageView");
    private final View mAddPageContainer;
    private Animator mHideAnimation;
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    private boolean mVisible = false;
    private boolean mHide = false;

    public AddNewPageView(View view) {
        if (DeviceInfo.isVSTModel()) {
            this.mAddPageContainer = view.findViewById(C9086R.id.vst_comp_add_new_page_button_container);
        } else {
            this.mAddPageContainer = view.findViewById(C9086R.id.comp_add_new_page_button_container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animationCancel() {
        if (this.mHideAnimation.isRunning()) {
            this.mHideAnimation.cancel();
        } else {
            clearAlphaValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlphaValue() {
        this.mAddPageContainer.setAlpha(1.0f);
        this.mHide = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasTouchPosition(Rect rect, MotionEvent motionEvent) {
        return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private void initAnimation() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mAddPageContainer, "alpha", 1.0f, 0.0f);
        this.mHideAnimation = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
        this.mHideAnimation.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.AddNewPageView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                AddNewPageView.this.clearAlphaValue();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
                AddNewPageView.this.mHide = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isActionUp(int i) {
        return i == 1 || i == 212;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedCancel() {
        return isShowing() && this.mHide;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowing() {
        return this.mAddPageContainer.getVisibility() == 0;
    }

    public SpenPreTouchListenerImpl.PreTouchListener getPreTouchListener() {
        return this.mPreTouchListener;
    }

    public void init(View.OnClickListener onClickListener) {
        this.mAddPageContainer.setOnClickListener(onClickListener);
        initAnimation();
        this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.AddNewPageView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 2 && actionMasked != 213) {
                    if (!AddNewPageView.this.isActionUp(actionMasked) || !AddNewPageView.this.isNeedCancel()) {
                        return false;
                    }
                    AddNewPageView.this.animationCancel();
                    return false;
                }
                Rect rect = new Rect();
                AddNewPageView.this.mAddPageContainer.getHitRect(rect);
                if (!AddNewPageView.this.isShowing() || AddNewPageView.this.mHide || !AddNewPageView.this.hasTouchPosition(rect, motionEvent)) {
                    return false;
                }
                AddNewPageView.this.mHideAnimation.start();
                return false;
            }
        };
        ViewCompat viewCompat = ViewCompat.getInstance();
        View view = this.mAddPageContainer;
        viewCompat.setTooltipText(view, view.getContentDescription());
    }

    public void updateButtonVisibility(int i, boolean z) {
        Logger.m10999d(TAG, "updateButtonVisibility# " + i + SQLKeyword.COMMA + z);
        if (i != 1) {
            this.mVisible = false;
            if (this.mAddPageContainer.getVisibility() == 0) {
                this.mAddPageContainer.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mVisible != z) {
            this.mAddPageContainer.setVisibility(z ? 0 : 8);
            this.mVisible = z;
        }
    }
}
