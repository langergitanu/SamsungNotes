package com.samsung.android.sdk.pen.setting;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper;
import com.samsung.android.sdk.pen.setting.favoritepen.OnFavoritePenMiniViewDragListener;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002()B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniOutsideReorder;", "Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfigHelper;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/OnFavoritePenMiniViewDragListener;", "<init>", "()V", "mFloatingFavoritePenMini", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniView;", "mFloatingFavoritePenMiniCover", "Landroid/widget/RelativeLayout;", "mIsEntryDrop", "", "mDragDropListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniOutsideReorder$DragDropListener;", "onStartDrag", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "offsetY", "", "isSelected", "onUpdatePosition", "positionX", "positionY", "onDropToPosition", "dropPositionX", "dropPositionY", "onDropped", "close", "removeFromParent", "initFloatingView", "context", "Landroid/content/Context;", "floatingView", "Landroid/view/View;", "getFloatingView", "()Landroid/view/View;", "setDragDropListener", "dragDropListener", "isNotInitialized", "()Z", "Companion", "DragDropListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenFavoritePenMiniOutsideReorder extends SpenLayoutConfigHelper implements OnFavoritePenMiniViewDragListener {
    private static final int ENTRY_ANIMATION_DURATION = 400;
    private static final int EXIT_ANIMATION_DURATION = 200;
    private static final float SCALE_DOWN_RATIO = 0.6f;
    private static final float SCALE_NORMAL_RATIO = 1.0f;

    @NotNull
    private static final String TAG = "SpenFavoritePenMiniOutsideReorder";

    @Nullable
    private DragDropListener mDragDropListener;

    @Nullable
    private SpenFavoritePenMiniView mFloatingFavoritePenMini;

    @Nullable
    private RelativeLayout mFloatingFavoritePenMiniCover;
    private boolean mIsEntryDrop;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenMiniOutsideReorder$DragDropListener;", "", "onStartDrag", "", "onDropped", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface DragDropListener {
        void onDropped();

        void onStartDrag();
    }

    public SpenFavoritePenMiniOutsideReorder() {
        super(1);
    }

    private final boolean isNotInitialized() {
        return this.mFloatingFavoritePenMini == null || this.mFloatingFavoritePenMiniCover == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDropToPosition$lambda$3(SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        RelativeLayout relativeLayout = spenFavoritePenMiniOutsideReorder.mFloatingFavoritePenMiniCover;
        if (relativeLayout != null) {
            relativeLayout.setX(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDropToPosition$lambda$4(SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        RelativeLayout relativeLayout = spenFavoritePenMiniOutsideReorder.mFloatingFavoritePenMiniCover;
        if (relativeLayout != null) {
            relativeLayout.setY(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDropToPosition$lambda$5(SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        SpenFavoritePenMiniView spenFavoritePenMiniView = spenFavoritePenMiniOutsideReorder.mFloatingFavoritePenMini;
        if (spenFavoritePenMiniView != null) {
            spenFavoritePenMiniView.setTranslationY(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDropToPosition$lambda$6(SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        SpenFavoritePenMiniView spenFavoritePenMiniView = spenFavoritePenMiniOutsideReorder.mFloatingFavoritePenMini;
        if (spenFavoritePenMiniView != null) {
            spenFavoritePenMiniView.setTranslationX(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStartDrag$lambda$1(SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        SpenFavoritePenMiniView spenFavoritePenMiniView = spenFavoritePenMiniOutsideReorder.mFloatingFavoritePenMini;
        if (spenFavoritePenMiniView != null) {
            spenFavoritePenMiniView.setScaleX(fFloatValue);
        }
        SpenFavoritePenMiniView spenFavoritePenMiniView2 = spenFavoritePenMiniOutsideReorder.mFloatingFavoritePenMini;
        if (spenFavoritePenMiniView2 != null) {
            spenFavoritePenMiniView2.setScaleY(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStartDrag$lambda$2(SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (spenFavoritePenMiniOutsideReorder.mIsEntryDrop) {
            return;
        }
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if (spenFavoritePenMiniOutsideReorder.isVertical()) {
            SpenFavoritePenMiniView spenFavoritePenMiniView = spenFavoritePenMiniOutsideReorder.mFloatingFavoritePenMini;
            if (spenFavoritePenMiniView != null) {
                spenFavoritePenMiniView.setTranslationY(fFloatValue);
                return;
            }
            return;
        }
        SpenFavoritePenMiniView spenFavoritePenMiniView2 = spenFavoritePenMiniOutsideReorder.mFloatingFavoritePenMini;
        if (spenFavoritePenMiniView2 != null) {
            spenFavoritePenMiniView2.setTranslationX(fFloatValue);
        }
    }

    public final void close(boolean removeFromParent) {
        AbstractC4539a.m3208r("close() removeFromParent=", TAG, removeFromParent);
        if (isNotInitialized()) {
            return;
        }
        SpenFavoritePenMiniView spenFavoritePenMiniView = this.mFloatingFavoritePenMini;
        if (spenFavoritePenMiniView != null) {
            spenFavoritePenMiniView.close();
        }
        this.mFloatingFavoritePenMini = null;
        this.mDragDropListener = null;
        if (removeFromParent) {
            RelativeLayout relativeLayout = this.mFloatingFavoritePenMiniCover;
            if ((relativeLayout != null ? relativeLayout.getParent() : null) != null) {
                RelativeLayout relativeLayout2 = this.mFloatingFavoritePenMiniCover;
                ViewParent parent = relativeLayout2 != null ? relativeLayout2.getParent() : null;
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(this.mFloatingFavoritePenMiniCover);
            }
        }
        this.mFloatingFavoritePenMiniCover = null;
    }

    @Nullable
    public final View getFloatingView() {
        if (isNotInitialized()) {
            return null;
        }
        return this.mFloatingFavoritePenMiniCover;
    }

    public final void initFloatingView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mFloatingFavoritePenMiniCover = relativeLayout;
        relativeLayout.setClipChildren(false);
        this.mFloatingFavoritePenMini = new SpenFavoritePenMiniView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout relativeLayout2 = this.mFloatingFavoritePenMiniCover;
        if (relativeLayout2 != null) {
            relativeLayout2.addView(this.mFloatingFavoritePenMini, layoutParams);
        }
        RelativeLayout relativeLayout3 = this.mFloatingFavoritePenMiniCover;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(0);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.OnFavoritePenMiniViewDragListener
    public void onDropToPosition(int dropPositionX, int dropPositionY) {
        if (isNotInitialized()) {
            return;
        }
        this.mIsEntryDrop = true;
        RelativeLayout relativeLayout = this.mFloatingFavoritePenMiniCover;
        float x = relativeLayout != null ? relativeLayout.getX() : 0.0f;
        RelativeLayout relativeLayout2 = this.mFloatingFavoritePenMiniCover;
        float y2 = relativeLayout2 != null ? relativeLayout2.getY() : 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(x, dropPositionX);
        valueAnimatorOfFloat.addUpdateListener(new C7564d(this, 2));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(y2, dropPositionY);
        valueAnimatorOfFloat2.addUpdateListener(new C7564d(this, 3));
        SpenFavoritePenMiniView spenFavoritePenMiniView = this.mFloatingFavoritePenMini;
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(spenFavoritePenMiniView != null ? spenFavoritePenMiniView.getTranslationY() : 0.0f, 0.0f);
        valueAnimatorOfFloat3.addUpdateListener(new C7564d(this, 4));
        SpenFavoritePenMiniView spenFavoritePenMiniView2 = this.mFloatingFavoritePenMini;
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(spenFavoritePenMiniView2 != null ? spenFavoritePenMiniView2.getTranslationX() : 0.0f, 0.0f);
        valueAnimatorOfFloat4.addUpdateListener(new C7564d(this, 5));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        if (!isVertical()) {
            valueAnimatorOfFloat3 = valueAnimatorOfFloat4;
        }
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfFloat3);
        animatorSet.start();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.OnFavoritePenMiniViewDragListener
    public void onDropped() {
        DragDropListener dragDropListener;
        if (isNotInitialized() || (dragDropListener = this.mDragDropListener) == null) {
            return;
        }
        dragDropListener.onDropped();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.OnFavoritePenMiniViewDragListener
    public void onStartDrag(@NotNull SpenSettingUIPenInfo info, int offsetY, boolean isSelected) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (isNotInitialized()) {
            return;
        }
        DragDropListener dragDropListener = this.mDragDropListener;
        if (dragDropListener != null) {
            dragDropListener.onStartDrag();
        }
        int i = 0;
        info.isFixedWidth = false;
        info.isFixedOpacity = false;
        SpenFavoritePenMiniView spenFavoritePenMiniView = this.mFloatingFavoritePenMini;
        if (spenFavoritePenMiniView != null) {
            spenFavoritePenMiniView.setPenInfo(info);
        }
        SpenFavoritePenMiniView spenFavoritePenMiniView2 = this.mFloatingFavoritePenMini;
        if (spenFavoritePenMiniView2 != null) {
            spenFavoritePenMiniView2.setSelected(isSelected);
        }
        this.mIsEntryDrop = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.6f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C7564d(this, i));
        if (!isHorizontal() || !isRTL()) {
            offsetY = -offsetY;
        }
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, offsetY);
        valueAnimatorOfFloat2.addUpdateListener(new C7564d(this, 1));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.start();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.OnFavoritePenMiniViewDragListener
    public void onUpdatePosition(int positionX, int positionY) {
        if (isNotInitialized()) {
            return;
        }
        RelativeLayout relativeLayout = this.mFloatingFavoritePenMiniCover;
        if (relativeLayout != null) {
            relativeLayout.setX(positionX);
        }
        RelativeLayout relativeLayout2 = this.mFloatingFavoritePenMiniCover;
        if (relativeLayout2 != null) {
            relativeLayout2.setY(positionY);
        }
    }

    public final void setDragDropListener(@Nullable DragDropListener dragDropListener) {
        this.mDragDropListener = dragDropListener;
    }
}
