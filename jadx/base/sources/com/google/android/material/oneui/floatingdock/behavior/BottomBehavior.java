package com.google.android.material.oneui.floatingdock.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Range;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.oneui.common.internal.util.ContextHelperKt;
import androidx.appcompat.util.SeslMisc;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.C4548R;
import com.google.android.material.oneui.floatingdock.FloatingPane;
import com.google.android.material.oneui.floatingdock.FloatingPaneViewModel;
import com.google.android.material.oneui.floatingdock.util.FloatingPaneCallbackNotifier;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u00109\u001a\u00020\u000bH\u0017J\u0018\u0010:\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u000bH\u0017J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020\u000bH\u0016J\u0018\u0010E\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=H\u0016J\u0018\u0010F\u001a\u00020@2\u0006\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020BH\u0016J\u0010\u0010I\u001a\u00020B2\u0006\u0010J\u001a\u00020@H\u0016J\b\u0010K\u001a\u00020BH\u0016J\u0018\u0010L\u001a\u00020B2\u0006\u0010G\u001a\u00020=2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020=H\u0016J\b\u0010R\u001a\u00020PH\u0002J\u0018\u0010S\u001a\u00020P2\u0006\u0010T\u001a\u00020=2\u0006\u0010U\u001a\u00020\u000bH\u0016J\u0010\u0010V\u001a\u00020P2\u0006\u0010G\u001a\u00020=H\u0016J\u0010\u0010W\u001a\u00020B2\u0006\u0010G\u001a\u00020=H\u0016J\u0018\u0010X\u001a\u00020P2\u0006\u0010G\u001a\u00020=2\u0006\u0010M\u001a\u00020NH\u0016R(\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000b0\u000b0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR*\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR*\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u0014\u0010&\u001a\u00020'X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010+\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000b0\u000b0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R(\u0010.\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000b0\u000b0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013R\u000e\u00101\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u00102\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\n \u000f*\u0004\u0018\u00010808X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/behavior/BottomBehavior;", "Lcom/google/android/material/oneui/floatingdock/behavior/CommonBehavior;", "context", "Landroid/content/Context;", "mode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "callBackNotifier", "Lcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;", "viewModel", "Lcom/google/android/material/oneui/floatingdock/FloatingPaneViewModel;", "resizeTouchSize", "", "(Landroid/content/Context;ILcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;Lcom/google/android/material/oneui/floatingdock/FloatingPaneViewModel;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "closeVIThreshold", "Landroid/util/Range;", "kotlin.jvm.PlatformType", "getCloseVIThreshold", "()Landroid/util/Range;", "setCloseVIThreshold", "(Landroid/util/Range;)V", "getContext", "()Landroid/content/Context;", "<anonymous parameter 0>", "customMaxWidth", "getCustomMaxWidth", "()Ljava/lang/Integer;", "setCustomMaxWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "customMinWidth", "getCustomMinWidth", "setCustomMinWidth", "customMinimizeWidth", "getCustomMinimizeWidth", "setCustomMinimizeWidth", "customWidth", "getCustomWidth", "setCustomWidth", "logTag", "", "getLogTag", "()Ljava/lang/String;", "maxHeightTopPadding", "maxVIThreshold", "getMaxVIThreshold", "setMaxVIThreshold", "minVIThreshold", "getMinVIThreshold", "setMinVIThreshold", "mostMinHeight", "requestedWidth", "getRequestedWidth", "()I", "setRequestedWidth", "(I)V", "resources", "Landroid/content/res/Resources;", "getBackgroundResId", "getHideSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "target", "Landroid/view/View;", "getMenuLayoutResId", "getMinimizeRect", "Landroid/graphics/Rect;", "minimize", "", Constants.MessagePayloadKeys.FROM, "getResizePinDirectionFlags", "getShowSpringAnimation", "getTargetModeBounds", "view", "moveValidArea", "isMinimizableRect", "newRect", "isSupportMinimize", "shouldInterceptTouch", "event", "Landroid/view/MotionEvent;", "updateBehavior", "", "parent", "updateDefaultSize", "updateDivider", "divider", "dividerSize", "updateLayoutParams", "updateMinimize", "updateState", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBottomBehavior.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BottomBehavior.kt\ncom/google/android/material/oneui/floatingdock/behavior/BottomBehavior\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n"})
public final class BottomBehavior extends CommonBehavior {

    @NotNull
    private Range<Integer> closeVIThreshold;

    @NotNull
    private final Context context;

    @Nullable
    private Integer customMaxWidth;

    @Nullable
    private Integer customMinWidth;

    @Nullable
    private Integer customMinimizeWidth;

    @Nullable
    private Integer customWidth;

    @NotNull
    private final String logTag;
    private final int maxHeightTopPadding;

    @NotNull
    private Range<Integer> maxVIThreshold;

    @NotNull
    private Range<Integer> minVIThreshold;
    private final int mostMinHeight;
    private int requestedWidth;
    private final int resizeTouchSize;
    private final Resources resources;

    @NotNull
    private final FloatingPaneViewModel viewModel;

    public /* synthetic */ BottomBehavior(Context context, int i, FloatingPaneCallbackNotifier floatingPaneCallbackNotifier, FloatingPaneViewModel floatingPaneViewModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, floatingPaneCallbackNotifier, floatingPaneViewModel, i2);
    }

    private final void updateDefaultSize() {
        setRequestedHeight((int) (ContextHelperKt.getScreenHeight(this.context) * ContextHelperKt.getFloat(this.context, C4548R.dimen.sesl_floating_pane_bottom_mode_default_height, 0.45f)));
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @DrawableRes
    public int getBackgroundResId() {
        Integer customBackground = getCustomBackground();
        return customBackground != null ? customBackground.intValue() : SeslMisc.isLightTheme(this.context) ? C4548R.drawable.sesl_floating_pane_background_bottom : C4548R.drawable.sesl_floating_pane_background_bottom_dark;
    }

    @NotNull
    public final Range<Integer> getCloseVIThreshold() {
        return this.closeVIThreshold;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public Integer getCustomMaxWidth() {
        return this.customMaxWidth;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public Integer getCustomMinWidth() {
        return this.customMinWidth;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public Integer getCustomMinimizeWidth() {
        return this.customMinimizeWidth;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @Nullable
    public Integer getCustomWidth() {
        return this.customWidth;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public SpringAnimation getHideSpringAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        SpringAnimation springAnimation = new SpringAnimation(target, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(361.0f);
        springForce.setFinalPosition(target.getHeight());
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(0.0f);
        return springAnimation;
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    @NotNull
    public final Range<Integer> getMaxVIThreshold() {
        return this.maxVIThreshold;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @LayoutRes
    public int getMenuLayoutResId() {
        return SeslMisc.isLightTheme(this.context) ? C4548R.layout.sesl_floating_pane_menu_bottom : C4548R.layout.sesl_floating_pane_menu_bottom_dark;
    }

    @NotNull
    public final Range<Integer> getMinVIThreshold() {
        return this.minVIThreshold;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public Rect getMinimizeRect(boolean minimize, @NotNull Rect from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Rect rect = new Rect(from);
        if (!minimize) {
            rect.top = rect.bottom - getRequestedHeight();
            return rect;
        }
        Object lower = this.closeVIThreshold.getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "closeVIThreshold.lower");
        rect.top = ((Number) lower).intValue();
        return rect;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public int getRequestedWidth() {
        return this.requestedWidth;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public int getResizePinDirectionFlags() {
        return 13;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public SpringAnimation getShowSpringAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        SpringAnimation springAnimation = new SpringAnimation(target, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(361.0f);
        springForce.setFinalPosition(0.0f);
        springAnimation.setSpring(springForce);
        springAnimation.setStartValue(getRequestedHeight());
        return springAnimation;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    @NotNull
    public Rect getTargetModeBounds(@NotNull View view, boolean moveValidArea) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        rect.right = view.getWidth();
        int height = view.getHeight();
        rect.bottom = height;
        rect.top = height - (getIsMinimized() ? getMinimizeHeight() : getRequestedHeight());
        return rect;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean isMinimizableRect(@NotNull Rect newRect) {
        Intrinsics.checkNotNullParameter(newRect, "newRect");
        return this.minVIThreshold.contains(Integer.valueOf(newRect.top));
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean isSupportMinimize() {
        return true;
    }

    public final void setCloseVIThreshold(@NotNull Range<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "<set-?>");
        this.closeVIThreshold = range;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setCustomMaxWidth(@Nullable Integer num) {
        LogTagHelperKt.debug(this, "Custom Max Width can't change in this Mode");
        this.customMaxWidth = null;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setCustomMinWidth(@Nullable Integer num) {
        LogTagHelperKt.debug(this, "Custom Min Width can't change in this Mode");
        this.customMinWidth = null;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setCustomMinimizeWidth(@Nullable Integer num) {
        LogTagHelperKt.debug(this, "Custom Minimize Width can't change in this Mode");
        this.customMinimizeWidth = null;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setCustomWidth(@Nullable Integer num) {
        LogTagHelperKt.debug(this, "Custom Width can't change in this Mode");
        this.customWidth = null;
    }

    public final void setMaxVIThreshold(@NotNull Range<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "<set-?>");
        this.maxVIThreshold = range;
    }

    public final void setMinVIThreshold(@NotNull Range<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "<set-?>");
        this.minVIThreshold = range;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void setRequestedWidth(int i) {
        LogTagHelperKt.debug(this, "Width can't change in this Mode");
        this.requestedWidth = -1;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean shouldInterceptTouch(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        return event.getY() < ((float) this.resizeTouchSize);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateBehavior(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        int height = parent.getHeight();
        updateDefaultSize();
        setMaxHeight(height - this.maxHeightTopPadding);
        this.closeVIThreshold = new Range<>(Integer.valueOf(RangesKt.coerceAtMost(height - getMinimizeHeight(), Integer.MAX_VALUE)), Integer.MAX_VALUE);
        int iIntValue = ((Number) this.closeVIThreshold.getLower()).intValue() - getMinimizeHeight();
        Object lower = this.closeVIThreshold.getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "closeVIThreshold.lower");
        this.minVIThreshold = new Range<>(Integer.valueOf(RangesKt.coerceAtMost(iIntValue, ((Number) lower).intValue())), this.closeVIThreshold.getLower());
        this.maxVIThreshold = new Range<>(0, Integer.valueOf(RangesKt.coerceAtLeast(getMinimizeHeight() + (height - getMaxHeight()), 0)));
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateDivider(@NotNull View divider, int dividerSize) {
        Intrinsics.checkNotNullParameter(divider, "divider");
        divider.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = divider.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = -1;
        layoutParams2.height = dividerSize;
        layoutParams2.gravity = 48;
        divider.setLayoutParams(layoutParams2);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateLayoutParams(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = getRequestedWidth();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.gravity = 80;
        }
        view.setLayoutParams(layoutParams);
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public boolean updateMinimize(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (getIsMinimized()) {
            return false;
        }
        setMinimize(getRequestedHeight() < this.mostMinHeight, view);
        LogTagHelperKt.debug(this, "updateMinimize Requested Height(" + getRequestedHeight() + ") is less than Most Min Height(" + this.mostMinHeight + "). set Minimized");
        return true;
    }

    @Override // com.google.android.material.oneui.floatingdock.behavior.CommonBehavior
    public void updateState(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.viewModel.m22108setStateIywsXb8(event.getY() < ((float) this.resizeTouchSize) ? FloatingPane.FloatingPaneState.INSTANCE.STATE_RESIZE() : FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE());
        }
        if (action == 1 || action == 3) {
            this.viewModel.m22108setStateIywsXb8(FloatingPane.FloatingPaneState.INSTANCE.STATE_IDLE());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private BottomBehavior(Context context, int i, FloatingPaneCallbackNotifier callBackNotifier, FloatingPaneViewModel viewModel, int i2) {
        super(i, callBackNotifier, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callBackNotifier, "callBackNotifier");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.context = context;
        this.viewModel = viewModel;
        this.resizeTouchSize = i2;
        this.logTag = "BottomBehavior";
        Resources resources = context.getResources();
        this.resources = resources;
        this.maxHeightTopPadding = resources.getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_bottom_mode_max_height_top_padding);
        this.maxVIThreshold = new Range<>(-1, -1);
        this.minVIThreshold = new Range<>(-1, -1);
        this.closeVIThreshold = new Range<>(-1, Integer.MAX_VALUE);
        this.mostMinHeight = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_bottom_mode_most_min_height);
        setMinWidth(0);
        setMinimizeHeight(resources.getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_bottom_mode_minimize_default_height));
        updateDefaultSize();
        this.requestedWidth = -1;
    }
}
