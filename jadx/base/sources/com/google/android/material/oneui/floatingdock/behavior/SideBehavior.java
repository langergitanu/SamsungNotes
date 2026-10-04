package com.google.android.material.oneui.floatingdock.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.oneui.common.internal.util.ContextHelperKt;
import androidx.appcompat.oneui.common.internal.util.ViewHelperKt;
import androidx.appcompat.util.SeslMisc;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.C4548R;
import com.google.android.material.oneui.floatingdock.FloatingPane;
import com.google.android.material.oneui.floatingdock.FloatingPaneViewModel;
import com.google.android.material.oneui.floatingdock.util.FloatingPaneCallbackNotifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010+\u001a\u00020\u000bH\u0017J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u000bH\u0017J\b\u00101\u001a\u00020\u000bH\u0016J\u0018\u00102\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020 H\u0016J\u0018\u00107\u001a\u00020 2\u0006\u00105\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0002J\u0018\u0010:\u001a\u00020 2\u0006\u00105\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020/H\u0016J\b\u0010>\u001a\u00020<H\u0002J\u0018\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u000bH\u0016J\u0010\u0010B\u001a\u00020<2\u0006\u00105\u001a\u00020/H\u0016J\u0018\u0010C\u001a\u00020<2\u0006\u00105\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R*\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R*\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/behavior/SideBehavior;", "Lcom/google/android/material/oneui/floatingdock/behavior/CommonBehavior;", "context", "Landroid/content/Context;", "mode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "callBackNotifier", "Lcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;", "viewModel", "Lcom/google/android/material/oneui/floatingdock/FloatingPaneViewModel;", "resizeTouchSize", "", "(Landroid/content/Context;ILcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;Lcom/google/android/material/oneui/floatingdock/FloatingPaneViewModel;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContext", "()Landroid/content/Context;", "<anonymous parameter 0>", "customHeight", "getCustomHeight", "()Ljava/lang/Integer;", "setCustomHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "customMaxHeight", "getCustomMaxHeight", "setCustomMaxHeight", "customMinHeight", "getCustomMinHeight", "setCustomMinHeight", "customMinimizeWidth", "getCustomMinimizeWidth", "setCustomMinimizeWidth", "isRightSide", "", "logTag", "", "getLogTag", "()Ljava/lang/String;", "mostMinWidth", "requestedHeight", "getRequestedHeight", "()I", "setRequestedHeight", "(I)V", "getBackgroundResId", "getHideSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "target", "Landroid/view/View;", "getMenuLayoutResId", "getResizePinDirectionFlags", "getShowSpringAnimation", "getTargetModeBounds", "Landroid/graphics/Rect;", "view", "moveValidArea", "resizeCheck", "event", "Landroid/view/MotionEvent;", "shouldInterceptTouch", "updateBehavior", "", "parent", "updateDefaultSize", "updateDivider", "divider", "dividerSize", "updateLayoutParams", "updateState", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSideBehavior.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SideBehavior.kt\ncom/google/android/material/oneui/floatingdock/behavior/SideBehavior\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewHelper.kt\nandroidx/appcompat/oneui/common/internal/util/ViewHelperKt\n*L\n1#1,199:1\n1#2:200\n10#3:201\n*S KotlinDebug\n*F\n+ 1 SideBehavior.kt\ncom/google/android/material/oneui/floatingdock/behavior/SideBehavior\n*L\n108#1:201\n*E\n"})
public final class SideBehavior extends CommonBehavior {

    @NotNull
    private final Context context;

    @Nullable
    private Integer customHeight;

    @Nullable
    private Integer customMaxHeight;

    @Nullable
    private Integer customMinHeight;

    @Nullable
    private Integer customMinimizeWidth;
    private boolean isRightSide;

    @NotNull
    private final String logTag;
    private final int mostMinWidth;
    private int requestedHeight;
    private final int resizeTouchSize;

    @NotNull
    private final FloatingPaneViewModel viewModel;

    public /* synthetic */ SideBehavior(Context context, int i, FloatingPaneCallbackNotifier floatingPaneCallbackNotifier, FloatingPaneViewModel floatingPaneViewModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, floatingPaneCallbackNotifier, floatingPaneViewModel, i2);
    }

    private final boolean resizeCheck(View view, MotionEvent event) {
        return this.isRightSide ? event.getX() < ((float) this.resizeTouchSize) : event.getX() > ((float) (view.getWidth() - this.resizeTouchSize));
    }

    private final void updateDefaultSize() {
        setRequestedWidth((int) (ContextHelperKt.getScreenWidth(this.context) * ContextHelperKt.getFloat(this.context, C4548R.dimen.sesl_floating_pane_side_mode_default_width, 0.45f)));
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @DrawableRes
    public int getBackgroundResId() {
        Integer customBackground = getCustomBackground();
        return customBackground != null ? customBackground.intValue() : SeslMisc.isLightTheme(this.context) ? this.isRightSide ? C4548R.drawable.sesl_floating_pane_background_side_right : C4548R.drawable.sesl_floating_pane_background_side_left : this.isRightSide ? C4548R.drawable.sesl_floating_pane_background_side_right_dark : C4548R.drawable.sesl_floating_pane_background_side_left_dark;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public Integer getCustomHeight() {
        return this.customHeight;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public Integer getCustomMaxHeight() {
        return this.customMaxHeight;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public Integer getCustomMinHeight() {
        return this.customMinHeight;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public Integer getCustomMinimizeWidth() {
        return this.customMinimizeWidth;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public SpringAnimation getHideSpringAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        SpringAnimation springAnimation = new SpringAnimation(target, DynamicAnimation.TRANSLATION_X);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(361.0f);
        boolean z = this.isRightSide;
        int width = target.getWidth();
        if (!z) {
            width = -width;
        }
        springForce.setFinalPosition(width);
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(0.0f);
        return springAnimation;
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @LayoutRes
    public int getMenuLayoutResId() {
        return SeslMisc.isLightTheme(this.context) ? C4548R.layout.sesl_floating_pane_menu_side : C4548R.layout.sesl_floating_pane_menu_side_dark;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public int getRequestedHeight() {
        return this.requestedHeight;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public int getResizePinDirectionFlags() {
        return (this.isRightSide ? 4 : 1) | 10;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public SpringAnimation getShowSpringAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        SpringAnimation springAnimation = new SpringAnimation(target, DynamicAnimation.TRANSLATION_X);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(361.0f);
        springForce.setFinalPosition(0.0f);
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(this.isRightSide ? getRequestedWidth() : -getRequestedWidth());
        return springAnimation;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public Rect getTargetModeBounds(@NotNull View view, boolean moveValidArea) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        rect.right = view.getWidth();
        rect.bottom = view.getHeight();
        if (this.isRightSide) {
            rect.left = view.getWidth() - getRequestedWidth();
            return rect;
        }
        rect.right = getRequestedWidth();
        return rect;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setCustomHeight(@Nullable Integer num) {
        LogTagHelperKt.debug(this, "custom Height can't change in this Mode");
        this.customHeight = null;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setCustomMaxHeight(@Nullable Integer num) {
        LogTagHelperKt.debug(this, "custom Max Height can't change in this Mode");
        this.customMaxHeight = null;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setCustomMinHeight(@Nullable Integer num) {
        LogTagHelperKt.debug(this, "custom Min Height can't change in this Mode");
        this.customMinHeight = null;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setCustomMinimizeWidth(@Nullable Integer num) {
        LogTagHelperKt.debug(this, "custom Minimize Width can't change in this Mode");
        this.customMinimizeWidth = null;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setRequestedHeight(int i) {
        LogTagHelperKt.debug(this, "Height can't change in this Mode");
        this.requestedHeight = -1;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean shouldInterceptTouch(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        return event.getY() < ((float) this.resizeTouchSize) || resizeCheck(view, event);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateBehavior(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TypedValue typedValue = new TypedValue();
        int width = parent.getWidth();
        int screenWidth = ContextHelperKt.getScreenWidth(this.context);
        float f = ViewHelperKt.getFloat(parent, C4548R.dimen.sesl_floating_pane_side_mode_min_width, 0.3f);
        updateDefaultSize();
        setMinWidth((int) (screenWidth * f));
        int minWidth = getMinWidth();
        int i = this.mostMinWidth;
        if (minWidth < i) {
            setMinWidth(i);
        }
        setMaxWidth((int) (ViewHelperKt.getFloat(parent, C4548R.dimen.sesl_floating_pane_side_mode_max_width, typedValue) ? typedValue.getFloat() * width : parent.getResources().getDimension(C4548R.dimen.sesl_floating_pane_side_mode_max_width)));
        this.isRightSide = !(parent.getLayoutDirection() == 1);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateDivider(@NotNull View divider, int dividerSize) {
        Intrinsics.checkNotNullParameter(divider, "divider");
        divider.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = divider.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = dividerSize;
        layoutParams2.height = -1;
        layoutParams2.gravity = 8388611;
        divider.setLayoutParams(layoutParams2);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateLayoutParams(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = getRequestedHeight();
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
            this.viewModel.m22108setStateIywsXb8(resizeCheck(view, event) ? FloatingPane.FloatingPaneState.INSTANCE.STATE_RESIZE() : FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE());
        }
        if (action == 1 || action == 3) {
            this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private SideBehavior(Context context, int i, FloatingPaneCallbackNotifier callBackNotifier, FloatingPaneViewModel viewModel, int i2) {
        super(i, callBackNotifier, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callBackNotifier, "callBackNotifier");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.context = context;
        this.viewModel = viewModel;
        this.resizeTouchSize = i2;
        this.logTag = "SideBehavior";
        this.mostMinWidth = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_side_mode_most_min_width);
        updateDefaultSize();
        this.requestedHeight = -1;
        this.isRightSide = true;
    }
}
