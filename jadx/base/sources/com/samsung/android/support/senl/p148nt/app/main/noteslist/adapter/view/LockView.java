package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view;

import android.view.View;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LockView {
    private final View mItemView;
    private View mLockBackground;
    private View mLockContainer;
    private LottieAnimationView mLockIcon;
    private View mUnlockProgress;
    private final int mViewMode;

    public LockView(@NonNull View view, int i) {
        this.mItemView = view;
        this.mViewMode = i;
    }

    public View getLockBackground() {
        return this.mLockBackground;
    }

    public View getLockIcon() {
        return this.mLockIcon;
    }

    public void inflateLockView(boolean z) {
        if (this.mLockContainer == null) {
            if (ContentUtils.isSimpleViewMode(this.mViewMode)) {
                this.mLockContainer = ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.lock_container, C8003R.id.inflate_lock_container);
            } else {
                this.mLockContainer = ViewModeUtils.getInflatedView(this.mItemView, C8003R.id.lock_icon_view, C8003R.id.inflate_lock_icon_view);
            }
            this.mLockIcon = (LottieAnimationView) this.mLockContainer.findViewById(C8003R.id.lock_icon);
            this.mLockBackground = this.mLockContainer.findViewById(C8003R.id.lock_background);
            ViewCompat.getInstance().setTooltipText(this.mLockIcon, this.mItemView.getResources().getString(C8003R.string.locked_notes));
            this.mUnlockProgress = this.mLockContainer.findViewById(C8003R.id.progress_converting);
        }
        View view = this.mLockContainer;
        if (view != null) {
            view.setVisibility(0);
            this.mLockContainer.setAlpha(1.0f);
            this.mLockContainer.setScaleX(1.0f);
            this.mLockContainer.setScaleY(1.0f);
        }
        LottieAnimationView lottieAnimationView = this.mLockIcon;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            this.mLockIcon.setAlpha(1.0f);
            this.mLockIcon.setScaleX(1.0f);
            this.mLockIcon.setScaleY(1.0f);
            this.mLockIcon.clearAnimation();
        }
        View view2 = this.mLockBackground;
        if (view2 != null) {
            view2.setVisibility(0);
            this.mLockBackground.setAlpha(1.0f);
            this.mLockBackground.setScaleX(1.0f);
            this.mLockBackground.setScaleY(1.0f);
        }
        setLockState(z);
    }

    public void invalidate() {
        View view = this.mLockContainer;
        if (view != null) {
            view.invalidate();
        }
        LottieAnimationView lottieAnimationView = this.mLockIcon;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        View view2 = this.mLockBackground;
        if (view2 != null) {
            view2.invalidate();
        }
    }

    public void setLockState(boolean z) {
        if (z) {
            LottieAnimationView lottieAnimationView = this.mLockIcon;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(8);
            }
            View view = this.mUnlockProgress;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        LottieAnimationView lottieAnimationView2 = this.mLockIcon;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
            this.mLockIcon.setImageResource(C8003R.drawable.ic_lock);
        }
        View view2 = this.mUnlockProgress;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void setVisibility(int i) {
        setLockState(false);
        View view = this.mLockContainer;
        if (view != null) {
            view.setTag(null);
            this.mLockContainer.setVisibility(i);
            this.mLockIcon.setVisibility(i);
            this.mUnlockProgress.setVisibility(i);
            View view2 = this.mLockBackground;
            if (view2 != null) {
                view2.setVisibility(i);
            }
        }
    }
}
