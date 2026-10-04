package com.google.android.material.oneui.floatingdock.behavior;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.oneui.common.internal.util.ContextHelperKt;
import androidx.appcompat.oneui.common.internal.util.DensityHelperKt;
import androidx.appcompat.util.SeslMisc;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import com.google.android.material.C4548R;
import com.google.android.material.oneui.common.internal.util.RectHelperKt;
import com.google.android.material.oneui.common.internal.util.ViewHelperKt;
import com.google.android.material.oneui.floatingdock.FloatingPane;
import com.google.android.material.oneui.floatingdock.FloatingPaneViewModel;
import com.google.android.material.oneui.floatingdock.IFloatingPaneCallback;
import com.google.android.material.oneui.floatingdock.util.FloatingPaneCallbackNotifier;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010,\u001a\u00020\u000bH\u0017J\u0018\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u000bH\u0017J\u0018\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0010H\u0016J\u000e\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u000200J\b\u00108\u001a\u00020\u000bH\u0016J\u0018\u00109\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H\u0016J\u0018\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u000204H\u0016J\u0010\u0010=\u001a\u00020>2\u0006\u00107\u001a\u000200H\u0016J\u0010\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0010\u0010A\u001a\u0002042\u0006\u0010;\u001a\u000200H\u0002J\b\u0010B\u001a\u000204H\u0016J\u0010\u0010C\u001a\u0002042\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010D\u001a\u00020>2\u0006\u00107\u001a\u000200H\u0016J\u0010\u0010E\u001a\u00020>2\u0006\u00107\u001a\u000200H\u0016J\u0018\u0010F\u001a\u00020>2\u0006\u00103\u001a\u0002042\u0006\u0010;\u001a\u000200H\u0016J\u0018\u0010G\u001a\u0002042\u0006\u0010;\u001a\u0002002\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020>2\u0006\u00107\u001a\u000200H\u0016J\b\u0010K\u001a\u00020>H\u0002J\u0010\u0010L\u001a\u00020>2\u0006\u0010;\u001a\u000200H\u0016J\u0018\u0010M\u001a\u00020>2\u0006\u0010;\u001a\u0002002\u0006\u0010H\u001a\u00020IH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u0014\u0010$\u001a\u00020%X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010(\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u000e\u0010+\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/behavior/FloatingBehavior;", "Lcom/google/android/material/oneui/floatingdock/behavior/CommonBehavior;", "context", "Landroid/content/Context;", "mode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "callBackNotifier", "Lcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;", "viewModel", "Lcom/google/android/material/oneui/floatingdock/FloatingPaneViewModel;", "resizeTouchSize", "", "(Landroid/content/Context;ILcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;Lcom/google/android/material/oneui/floatingdock/FloatingPaneViewModel;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContext", "()Landroid/content/Context;", "customUntouchableAreaInset", "Landroid/graphics/Rect;", "getCustomUntouchableAreaInset", "()Landroid/graphics/Rect;", "setCustomUntouchableAreaInset", "(Landroid/graphics/Rect;)V", "<anonymous parameter 0>", "Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;", "hideAnimationListener", "getHideAnimationListener", "()Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;", "setHideAnimationListener", "(Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;)V", "lastPosX", "getLastPosX", "()I", "setLastPosX", "(I)V", "lastPosY", "getLastPosY", "setLastPosY", "logTag", "", "getLogTag", "()Ljava/lang/String;", "showAnimationListener", "getShowAnimationListener", "setShowAnimationListener", "untouchableAreaPadding", "getBackgroundResId", "getHideAnimation", "Landroid/animation/AnimatorSet;", "target", "Landroid/view/View;", "getMenuLayoutResId", "getMinimizeRect", "minimize", "", Constants.MessagePayloadKeys.FROM, "getMoveableArea", "parent", "getResizePinDirectionFlags", "getShowAnimation", "getTargetModeBounds", "view", "moveValidArea", "initBehavior", "", "isMinimizableRect", "newRect", "isNotMeasured", "isSupportMinimize", "isSupported", "loadState", "saveState", "setMinimize", "shouldInterceptTouch", "event", "Landroid/view/MotionEvent;", "updateBehavior", "updateDefaultSize", "updateLayoutParams", "updateState", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingBehavior.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingBehavior.kt\ncom/google/android/material/oneui/floatingdock/behavior/FloatingBehavior\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
public final class FloatingBehavior extends CommonBehavior {

    @NotNull
    private final Context context;

    @Nullable
    private Rect customUntouchableAreaInset;

    @Nullable
    private IFloatingPaneCallback.AnimationListener hideAnimationListener;
    private int lastPosX;
    private int lastPosY;

    @NotNull
    private final String logTag;
    private final int resizeTouchSize;

    @Nullable
    private IFloatingPaneCallback.AnimationListener showAnimationListener;
    private final int untouchableAreaPadding;

    @NotNull
    private final FloatingPaneViewModel viewModel;

    public /* synthetic */ FloatingBehavior(Context context, int i, FloatingPaneCallbackNotifier floatingPaneCallbackNotifier, FloatingPaneViewModel floatingPaneViewModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, floatingPaneCallbackNotifier, floatingPaneViewModel, i2);
    }

    private final boolean isNotMeasured(View view) {
        return view.getWidth() <= 0 || view.getHeight() <= 0;
    }

    private final void updateDefaultSize() {
        Number numberValueOf;
        TypedValue typedValue = new TypedValue();
        int screenWidth = ContextHelperKt.getScreenWidth(this.context);
        int screenHeight = ContextHelperKt.getScreenHeight(this.context);
        float f = ContextHelperKt.getFloat(this.context, C4548R.dimen.sesl_floating_pane_floating_mode_default_height, 0.48f);
        if (ContextHelperKt.getFloat(this.context, C4548R.dimen.sesl_floating_pane_floating_mode_default_width, typedValue)) {
            numberValueOf = Float.valueOf(typedValue.getFloat() * screenWidth);
        } else {
            numberValueOf = Integer.valueOf(this.context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_floating_mode_default_width));
        }
        setRequestedWidth(numberValueOf.intValue());
        setRequestedHeight((int) (screenHeight * f));
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @DrawableRes
    public int getBackgroundResId() {
        Integer customBackground = getCustomBackground();
        return customBackground != null ? customBackground.intValue() : SeslMisc.isLightTheme(this.context) ? C4548R.drawable.sesl_floating_pane_background_floating : C4548R.drawable.sesl_floating_pane_background_floating_dark;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final Rect getCustomUntouchableAreaInset() {
        return this.customUntouchableAreaInset;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public AnimatorSet getHideAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        AnimatorSet animatorSet = new AnimatorSet();
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, C4548R.animator.floating_hide_anim);
        animatorLoadAnimator.setTarget(target);
        Unit unit = Unit.INSTANCE;
        animatorSet.playTogether(animatorLoadAnimator);
        return animatorSet;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public IFloatingPaneCallback.AnimationListener getHideAnimationListener() {
        return this.hideAnimationListener;
    }

    public final int getLastPosX() {
        return this.lastPosX;
    }

    public final int getLastPosY() {
        return this.lastPosY;
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @LayoutRes
    public int getMenuLayoutResId() {
        return SeslMisc.isLightTheme(this.context) ? C4548R.layout.sesl_floating_pane_menu_floating : C4548R.layout.sesl_floating_pane_menu_floating_dark;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public Rect getMinimizeRect(boolean minimize, @NotNull Rect from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Rect rect = new Rect(from);
        if (minimize) {
            rect.right = getMinimizeWidth() + from.left;
            rect.bottom = getMinimizeHeight() + from.top;
            setRequestedWidth(from.width());
            setRequestedHeight(from.height());
            return rect;
        }
        rect.right = getMinWidth() + from.left;
        rect.bottom = getMinHeight() + from.top;
        setRequestedWidth(getMinWidth());
        setRequestedHeight(getMinHeight());
        return rect;
    }

    @NotNull
    public final Rect getMoveableArea(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Rect rect = new Rect();
        ViewHelperKt.getCurrentLayoutBounds(parent, rect);
        int i = this.untouchableAreaPadding;
        rect.inset(i, i);
        Rect rect2 = this.customUntouchableAreaInset;
        if (rect2 != null) {
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right -= rect2.right;
            rect.bottom -= rect2.bottom;
        }
        return rect;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public int getResizePinDirectionFlags() {
        return 0;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public AnimatorSet getShowAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        AnimatorSet animatorSet = new AnimatorSet();
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, C4548R.animator.floating_show_anim);
        animatorLoadAnimator.setTarget(target);
        Unit unit = Unit.INSTANCE;
        animatorSet.playTogether(animatorLoadAnimator);
        return animatorSet;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public IFloatingPaneCallback.AnimationListener getShowAnimationListener() {
        return this.showAnimationListener;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public Rect getTargetModeBounds(@NotNull View view, boolean moveValidArea) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        rect.right = view.getWidth();
        rect.bottom = view.getHeight();
        int i = this.lastPosX;
        rect.left = i;
        rect.top = this.lastPosY;
        rect.right = i + (getIsMinimized() ? getMinimizeWidth() : getRequestedWidth());
        rect.bottom = rect.top + (getIsMinimized() ? getMinimizeHeight() : getRequestedHeight());
        if (moveValidArea) {
            RectHelperKt.moveInsideAndIntersect(rect, getMoveableArea(view));
        }
        return rect;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void initBehavior(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        super.initBehavior(parent);
        this.lastPosX = (parent.getWidth() - getRequestedWidth()) / 2;
        this.lastPosY = (parent.getHeight() - getRequestedHeight()) / 2;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean isMinimizableRect(@NotNull Rect newRect) {
        Intrinsics.checkNotNullParameter(newRect, "newRect");
        return newRect.width() <= getMinWidth() && newRect.height() <= getMinHeight();
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean isSupportMinimize() {
        return true;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean isSupported(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DensityHelperKt.getDp(ContextHelperKt.getScreenWidth(context)) >= 600 && DensityHelperKt.getDp(ContextHelperKt.getScreenHeight(context)) >= 600;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void loadState(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (getPosYRatio() != -1.0f && getPosYRatio() != -1.0f && !isNotMeasured(parent)) {
            int minimizeWidth = getIsMinimized() ? getMinimizeWidth() : getRequestedWidth();
            int minimizeHeight = getIsMinimized() ? getMinimizeHeight() : getRequestedHeight();
            this.lastPosX = (int) (getPosXRatio() * (parent.getWidth() - minimizeWidth));
            this.lastPosY = (int) (getPosYRatio() * (parent.getHeight() - minimizeHeight));
            return;
        }
        setPosXRatio(-1.0f);
        setPosYRatio(-1.0f);
        LogTagHelperKt.error(this, "loadState fail: posRatio=(" + getPosXRatio() + SQLKeyword.COMMA + getPosYRatio() + ") parent=(" + parent.getWidth() + SQLKeyword.COMMA + parent.getHeight() + PropertyUtils.MAPPED_DELIM2);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void saveState(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (!isNotMeasured(parent)) {
            int minimizeWidth = getIsMinimized() ? getMinimizeWidth() : getRequestedWidth();
            int minimizeHeight = getIsMinimized() ? getMinimizeHeight() : getRequestedHeight();
            setPosXRatio(this.lastPosX / (parent.getWidth() - minimizeWidth));
            setPosYRatio(this.lastPosY / (parent.getHeight() - minimizeHeight));
            return;
        }
        setPosXRatio(-1.0f);
        setPosYRatio(-1.0f);
        LogTagHelperKt.error(this, "saveState fail: parent size is wrong (" + parent.getWidth() + SQLKeyword.COMMA + parent.getHeight() + PropertyUtils.MAPPED_DELIM2);
    }

    public final void setCustomUntouchableAreaInset(@Nullable Rect rect) {
        this.customUntouchableAreaInset = rect;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setHideAnimationListener(@Nullable IFloatingPaneCallback.AnimationListener animationListener) {
        LogTagHelperKt.debug(this, "hideAnimationListener can't set in this Mode yet");
        this.hideAnimationListener = null;
    }

    public final void setLastPosX(int i) {
        this.lastPosX = i;
    }

    public final void setLastPosY(int i) {
        this.lastPosY = i;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setMinimize(boolean minimize, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setMinimize(minimize, view);
        Drawable background = view.getBackground();
        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        if (gradientDrawable == null) {
            return;
        }
        gradientDrawable.setCornerRadius(getIsMinimized() ? this.context.getResources().getDimension(C4548R.dimen.sesl_floating_pane_minimized_background_corner_radius) : this.context.getResources().getDimension(C4548R.dimen.sesl_floating_pane_background_corner_radius));
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setShowAnimationListener(@Nullable IFloatingPaneCallback.AnimationListener animationListener) {
        LogTagHelperKt.debug(this, "showAnimationListener can't set in this Mode yet");
        this.showAnimationListener = null;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean shouldInterceptTouch(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        if (getIsMinimized()) {
            return false;
        }
        return event.getY() < ((float) this.resizeTouchSize) || event.getY() > ((float) (view.getHeight() - this.resizeTouchSize)) || event.getX() < ((float) this.resizeTouchSize) || event.getX() > ((float) (view.getWidth() - this.resizeTouchSize));
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateBehavior(@NotNull View parent) {
        float dimension;
        Intrinsics.checkNotNullParameter(parent, "parent");
        TypedValue typedValue = new TypedValue();
        int width = parent.getWidth();
        int height = parent.getHeight();
        updateDefaultSize();
        if (androidx.appcompat.oneui.common.internal.util.ViewHelperKt.getFloat(parent, C4548R.dimen.sesl_floating_pane_floating_mode_max_width, typedValue)) {
            dimension = typedValue.getFloat() * width;
        } else {
            dimension = parent.getResources().getDimension(C4548R.dimen.sesl_floating_pane_floating_mode_max_width);
        }
        setMaxWidth((int) dimension);
        setMaxHeight(height);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateLayoutParams(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.gravity = 51;
        }
        view.setLayoutParams(layoutParams);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateState(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            if (getIsMinimized()) {
                this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_MOVE());
            } else {
                FloatingPane.FloatingPaneState floatingPaneStateM22088boximpl = event.getY() < ((float) this.resizeTouchSize) ? FloatingPane.FloatingPaneState.m22088boximpl(FloatingPane.FloatingPaneState.INSTANCE.STATE_MOVE()) : null;
                if (event.getY() > view.getHeight() - this.resizeTouchSize || event.getX() > view.getWidth() - this.resizeTouchSize || event.getX() < this.resizeTouchSize) {
                    floatingPaneStateM22088boximpl = FloatingPane.FloatingPaneState.m22088boximpl(FloatingPane.FloatingPaneState.INSTANCE.STATE_RESIZE());
                }
                if (floatingPaneStateM22088boximpl != null) {
                    this.viewModel.m22108setStateIywsXb8(floatingPaneStateM22088boximpl.getState());
                }
            }
        }
        if (action == 1 || action == 3) {
            this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private FloatingBehavior(Context context, int i, FloatingPaneCallbackNotifier callBackNotifier, FloatingPaneViewModel viewModel, int i2) {
        super(i, callBackNotifier, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callBackNotifier, "callBackNotifier");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.context = context;
        this.viewModel = viewModel;
        this.resizeTouchSize = i2;
        this.logTag = "FloatingBehavior";
        this.untouchableAreaPadding = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_untouchable_area_padding);
        setMinWidth(context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_floating_mode_min_width));
        setMinHeight(context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_floating_mode_min_height));
        setMinimizeWidth(context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_minimize_default_width));
        setMinimizeMinWidth(getMinimizeWidth());
        setMinimizeHeight(context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_floating_mode_minimize_default_height));
        setMinimizeMinHeight(getMinimizeHeight());
        setMinimizeMaxHeight(getMinimizeHeight());
        updateDefaultSize();
        this.lastPosX = (ContextHelperKt.getScreenWidth(context) - getRequestedWidth()) / 2;
        this.lastPosY = (ContextHelperKt.getScreenHeight(context) - getRequestedHeight()) / 2;
    }
}
