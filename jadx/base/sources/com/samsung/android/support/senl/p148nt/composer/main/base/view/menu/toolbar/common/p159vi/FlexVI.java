package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FlexVI {
    protected static String TAG = Logger.createTag("FlexVI");
    private static final int TRANSLATE_DURATION = 200;
    private Context mContext;
    private IContract mContract;
    private WeakReference<FloatLayout> mTargetViewRef;
    private boolean mIsVerticalHalfOpened = false;
    private boolean mIsSipShown = false;
    private boolean mEnableVerticalFoldPosition = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IContract {
        boolean isDockedAtBottom();

        boolean isLandscape();

        boolean isMultiWindow();

        void updateDockerSize();
    }

    public FlexVI(FloatLayout floatLayout, IContract iContract) {
        if (!(floatLayout.getContext() instanceof Activity)) {
            throw new IllegalArgumentException("not Activity context");
        }
        this.mContext = floatLayout.getContext();
        this.mTargetViewRef = new WeakReference<>(floatLayout);
        this.mContract = iContract;
        initVerticalHalfOpened();
    }

    private boolean checkHitVertical(int i) {
        FloatLayout floatLayout = this.mTargetViewRef.get();
        if (floatLayout == null) {
            return false;
        }
        Rect rect = new Rect();
        floatLayout.getGlobalVisibleRect(rect);
        return rect.contains(rect.left, i);
    }

    private boolean checkViewValid() {
        FloatLayout floatLayout = this.mTargetViewRef.get();
        if (floatLayout == null) {
            return false;
        }
        if (!(floatLayout.getContext() instanceof Activity)) {
            Logger.m11000e(TAG, "not Activity context");
            return false;
        }
        if (floatLayout.getParent() != null) {
            return true;
        }
        Logger.m11000e(TAG, "there is no parent view");
        return false;
    }

    private void initVerticalHalfOpened() {
        final int foldDirection = FoldStateCompat.getInstance().getFoldDirection(this.mContext);
        if (foldDirection == 0) {
            return;
        }
        FoldStateCompat.getInstance().getFoldState(new FoldStateCompat.FolderStateCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.FlexVI.1
            @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FolderStateCallback
            public void onFailed() {
                FlexVI.this.mIsVerticalHalfOpened = false;
            }

            @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FolderStateCallback
            public void onSuccess(int i) {
                if (i == 2 && foldDirection == 8) {
                    FlexVI.this.mIsVerticalHalfOpened = true;
                } else {
                    FlexVI.this.mIsVerticalHalfOpened = false;
                }
            }
        });
    }

    private boolean isApplyVerticalFoldPosition() {
        return this.mIsSipShown && this.mIsVerticalHalfOpened && this.mContract.isLandscape() && !this.mContract.isMultiWindow() && this.mContract.isDockedAtBottom();
    }

    public static Boolean isSupport() {
        return Boolean.valueOf(FoldStateCompat.getInstance().isFoldableDevice());
    }

    private boolean movingDown() {
        final FloatLayout floatLayout;
        if (!checkViewValid() || (floatLayout = this.mTargetViewRef.get()) == null) {
            return false;
        }
        Logger.m10999d(TAG, "movingDown");
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, floatLayout.getBottomMargin());
        Logger.m10999d(TAG, "movingDown targetView.getBottomMargin() " + floatLayout.getBottomMargin());
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.FlexVI.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                floatLayout.clearAnimation();
                floatLayout.setTranslationY(((ViewGroup) floatLayout.getParent()).getHeight() - floatLayout.getHeight());
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                floatLayout.setBottomMargin(0.0f);
                FlexVI.this.mContract.updateDockerSize();
            }
        });
        floatLayout.startAnimation(translateAnimation);
        return true;
    }

    private boolean movingUp() {
        final FloatLayout floatLayout;
        if (!checkViewValid() || (floatLayout = this.mTargetViewRef.get()) == null) {
            return false;
        }
        Logger.m10999d(TAG, "movingUp");
        float fHeight = DisplayUtils.getScreenSize(floatLayout.getContext()).height();
        int i = (int) (0.5f * fHeight);
        final int i2 = (int) (fHeight * 0.03f);
        if (!checkHitVertical(i)) {
            Logger.m10999d(TAG, "toolbar is not position above half of the screen");
            return false;
        }
        Rect rect = new Rect();
        ViewGroup viewGroup = (ViewGroup) floatLayout.getParent();
        viewGroup.getGlobalVisibleRect(rect);
        final int height = (viewGroup.getHeight() - floatLayout.getHeight()) - i2;
        Logger.m10999d(TAG, "movingUp absolutePositionY " + height);
        floatLayout.animate().y((float) height).setDuration(200L).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.FlexVI.2
            @Override // java.lang.Runnable
            public void run() {
                floatLayout.clearAnimation();
                floatLayout.setBottomMargin(i2);
                AbstractC8014b.m7221w(new StringBuilder("movingUp pointZeroThreePercentHeight "), FlexVI.TAG, i2);
                floatLayout.setTranslationY(height);
                FlexVI.this.mContract.updateDockerSize();
            }
        }).start();
        return true;
    }

    public void setSipShown(boolean z) {
        if (this.mIsSipShown != z) {
            this.mIsSipShown = z;
        }
    }

    public void setVerticalHalfOpened(boolean z) {
        if (this.mIsVerticalHalfOpened != z) {
            this.mIsVerticalHalfOpened = z;
        }
    }

    public void update() {
        boolean zIsApplyVerticalFoldPosition = isApplyVerticalFoldPosition();
        if (zIsApplyVerticalFoldPosition != this.mEnableVerticalFoldPosition) {
            Logger.m10999d(TAG, Constants.ARG_UPDATE);
            if (zIsApplyVerticalFoldPosition) {
                if (movingUp()) {
                    this.mEnableVerticalFoldPosition = true;
                }
            } else if (movingDown()) {
                this.mEnableVerticalFoldPosition = false;
            }
        }
    }
}
