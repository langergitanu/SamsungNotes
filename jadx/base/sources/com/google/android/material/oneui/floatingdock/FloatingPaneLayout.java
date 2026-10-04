package com.google.android.material.oneui.floatingdock;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.util.theme.SeslThemeResourceHelper;
import androidx.appcompat.util.theme.resource.SeslThemeResourceColor;
import androidx.collection.AbstractC0622a;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.view.SemBlurCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.C4548R;
import com.google.android.material.oneui.common.internal.util.ViewHelperKt;
import com.google.android.material.oneui.floatingactioncontainer.C4778c;
import com.google.android.material.oneui.floatingdock.FloatingPane;
import com.google.android.material.oneui.floatingdock.IFloatingPaneCallback;
import com.google.android.material.oneui.floatingdock.behavior.CommonBehavior;
import com.google.android.material.oneui.floatingdock.behavior.FloatingBehavior;
import com.google.android.material.oneui.floatingdock.util.HapticFeedbackHelper;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:J&\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bJ\u0010\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020BH\u0016J\u0018\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020B2\u0006\u0010E\u001a\u00020\bH\u0016J \u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020B2\u0006\u0010E\u001a\u00020\b2\u0006\u0010C\u001a\u00020DH\u0016J \u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020B2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0016J\u0018\u0010H\u001a\u0002082\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0014J\u000e\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020\fJ\r\u0010N\u001a\u00020OH\u0007¢\u0006\u0002\u0010PJ\u0012\u0010Q\u001a\u0002082\b\b\u0002\u0010R\u001a\u00020\fH\u0007J\u0006\u0010S\u001a\u00020\fJ\b\u0010T\u001a\u00020\fH\u0002J\u0006\u0010U\u001a\u00020\fJ0\u0010V\u001a\u0002082\u0006\u0010W\u001a\u00020\f2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bH\u0014J\u0006\u0010X\u001a\u000208J\u000e\u0010Y\u001a\u0002082\u0006\u00109\u001a\u00020:J\u0017\u0010Z\u001a\u0002082\b\u0010[\u001a\u0004\u0018\u000100H\u0000¢\u0006\u0002\b\\J\u001d\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020\f2\u0006\u0010[\u001a\u000200H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u000208H\u0000¢\u0006\u0002\baJ\u0015\u0010b\u001a\u0002082\u0006\u0010c\u001a\u00020OH\u0007¢\u0006\u0002\u0010dJ\u000e\u0010e\u001a\u0002082\u0006\u0010f\u001a\u00020\fJ\u0010\u0010g\u001a\u0002082\u0006\u0010h\u001a\u00020BH\u0003J\u000e\u0010i\u001a\u0002082\u0006\u0010j\u001a\u00020\bJ\u000e\u0010k\u001a\u0002082\u0006\u0010h\u001a\u00020BJ\u001f\u0010l\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u00109\u001a\u0004\u0018\u00010mH\u0007¢\u0006\u0002\u0010nJ\u001f\u0010o\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u0010G\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010pJ\u001f\u0010q\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u0010F\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010pJ\u001f\u0010r\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u0010G\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010pJ\u001f\u0010s\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u0010F\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010pJ\u000e\u0010t\u001a\u0002082\u0006\u0010h\u001a\u00020BJ\u001f\u0010u\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u0010F\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010pJ\u0015\u0010v\u001a\u0002082\u0006\u0010c\u001a\u00020OH\u0007¢\u0006\u0002\u0010dJ\u0010\u0010w\u001a\u0002082\u0006\u0010x\u001a\u00020\fH\u0002J\u001f\u0010y\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u0010G\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010pJ!\u0010z\u001a\u0002082\u0006\u0010c\u001a\u00020O2\n\b\u0001\u0010{\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010pJ\u001f\u0010|\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u0010F\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010pJ\u001f\u0010}\u001a\u0002082\u0006\u0010c\u001a\u00020O2\b\u00109\u001a\u0004\u0018\u00010mH\u0007¢\u0006\u0002\u0010nJ\u0012\u0010^\u001a\u0002082\b\b\u0002\u0010R\u001a\u00020\fH\u0007J\u0018\u00105\u001a\u0002082\u0006\u0010^\u001a\u00020\f2\b\b\u0002\u0010~\u001a\u00020\fR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u007f"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/FloatingPaneLayout;", "Landroid/widget/FrameLayout;", "Lcom/google/android/material/oneui/floatingdock/FloatingDockLogTag;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "", "blurDisableInternal", "setBlurDisableInternal", "(Z)V", "blurMode", "getBlurMode$annotations", "()V", "dockingEffectCornerRadius", "dockingEffectPadding", "floatingView", "Lcom/google/android/material/oneui/floatingdock/FloatingPaneView;", "hidePreDockingEffect", "Landroid/animation/AnimatorSet;", "isShowingPreDockingEffect", "logTag", "", "getLogTag", "()Ljava/lang/String;", "minimizedIcon", "Landroid/graphics/drawable/Drawable;", "minimizedIconAlphaAnimDuration", "", "minimizedIconAlphaAnimation", "Landroid/animation/ValueAnimator;", "minimizedIconAnimAlphaValue", "", "minimizedIconAnimScaleValue", "minimizedIconScaleHideAnimation", "minimizedIconScaleShowAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "minimizedIconSize", "minimizedSaleAnimDuration", "preDockingEffect", "Landroid/widget/ImageView;", "resizeAlphaAnimation", "resizeRect", "Landroid/graphics/Rect;", "resizeRectAlphaValue", "resizeRectCenter", "Landroid/graphics/Point;", "resizeRectDrawable", "showMinimizedIcon", "showPreDockingEffect", "addCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback;", "addUntouchableAreaInset", "left", "top", "right", "bottom", "addView", "child", "Landroid/view/View;", ActionHandler.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "addViewInternal", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "enterMinimizeView", "minimize", "getPaneMode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "()I", "hide", "animate", "isMinimizeView", "isResizeByContentScrollEnabled", "isShowing", "onLayout", "changed", "removeAllCallback", "removeCallback", "seslRequestDrawResizeRect", "rect", "seslRequestDrawResizeRect$material_release", "seslShowProDockingEffect", Constants.IntentExtraValue.SHOW, "seslShowProDockingEffect$material_release", "seslStopDrawAllRequested", "seslStopDrawAllRequested$material_release", "setAllowModes", "mode", "(I)V", "setBlurDisable", "disable", "setBlurEffect", "view", "setBlurMode", "semBlurInfoMode", "setContentView", "setHideAnimationListener", "Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;", "(ILcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;)V", "setMaxHeight", "(ILjava/lang/Integer;)V", "setMaxWidth", "setMinHeight", "setMinWidth", "setMinimizeView", "setMinimizeWidth", "setPaneMode", "setResizeByContentScrollEnabled", "enabled", "setResultHeight", "setResultViewBackgroundResource", "resId", "setResultWidth", "setShowAnimationListener", "skipAnimate", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingPaneLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingPaneLayout.kt\ncom/google/android/material/oneui/floatingdock/FloatingPaneLayout\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,700:1\n39#2:701\n85#2,18:702\n29#2:720\n85#2,18:721\n1#3:739\n*S KotlinDebug\n*F\n+ 1 FloatingPaneLayout.kt\ncom/google/android/material/oneui/floatingdock/FloatingPaneLayout\n*L\n91#1:701\n91#1:702,18\n99#1:720\n99#1:721,18\n*E\n"})
public class FloatingPaneLayout extends FrameLayout implements FloatingDockLogTag {
    private boolean blurDisableInternal;
    private int blurMode;
    private final int dockingEffectCornerRadius;
    private final int dockingEffectPadding;

    @Nullable
    private FloatingPaneView floatingView;

    @NotNull
    private final AnimatorSet hidePreDockingEffect;
    private boolean isShowingPreDockingEffect;

    @NotNull
    private final String logTag;

    @Nullable
    private final Drawable minimizedIcon;
    private final long minimizedIconAlphaAnimDuration;

    @NotNull
    private final ValueAnimator minimizedIconAlphaAnimation;
    private float minimizedIconAnimAlphaValue;
    private float minimizedIconAnimScaleValue;

    @NotNull
    private final ValueAnimator minimizedIconScaleHideAnimation;

    @NotNull
    private final SpringAnimation minimizedIconScaleShowAnimation;
    private final int minimizedIconSize;
    private final long minimizedSaleAnimDuration;

    @NotNull
    private final ImageView preDockingEffect;

    @NotNull
    private final ValueAnimator resizeAlphaAnimation;

    @Nullable
    private Rect resizeRect;
    private float resizeRectAlphaValue;

    @NotNull
    private final Point resizeRectCenter;

    @Nullable
    private final Drawable resizeRectDrawable;
    private boolean showMinimizedIcon;

    @NotNull
    private final AnimatorSet showPreDockingEffect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingPaneLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void addViewInternal(View child, ViewGroup.LayoutParams params) {
        if (getChildCount() > 2) {
            LogTagHelperKt.error(this, "Should add R.id.result_layout_content on first");
            removeAllViews();
            return;
        }
        int id = child.getId();
        if (id == C4548R.id.result_layout_content) {
            super.addView(this.preDockingEffect, 0, new FrameLayout.LayoutParams(-1, -1, 51));
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FloatingPaneView floatingPaneView = new FloatingPaneView(context, this, null, 0, 12, null);
            floatingPaneView.setContentView(child);
            this.floatingView = floatingPaneView;
            FrameLayout.LayoutParams layoutParams = params instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) params : null;
            if (layoutParams != null) {
                layoutParams.gravity = 51;
            }
            super.addView(floatingPaneView, 1, params);
            return;
        }
        if (id != C4548R.id.result_layout_minimize) {
            LogTagHelperKt.error(this, "Should add R.id.result_layout_content on first");
            removeAllViews();
            return;
        }
        FloatingPaneView floatingPaneView2 = this.floatingView;
        if (floatingPaneView2 == null) {
            LogTagHelperKt.error(this, "Should add R.id.result_layout_content on first");
            removeAllViews();
        } else if (floatingPaneView2 != null) {
            floatingPaneView2.setMinimizeView(child);
        }
    }

    public static /* synthetic */ void hide$default(FloatingPaneLayout floatingPaneLayout, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        floatingPaneLayout.hide(z);
    }

    private final boolean isResizeByContentScrollEnabled() {
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            return floatingPaneView.getResizeByContentScrollEnabled();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void minimizedIconAlphaAnimation$lambda$27$lambda$26(FloatingPaneLayout this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.minimizedIconAnimAlphaValue = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void minimizedIconScaleHideAnimation$lambda$25$lambda$24(FloatingPaneLayout this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.minimizedIconAnimScaleValue = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void minimizedIconScaleShowAnimation$lambda$23$lambda$22(FloatingPaneLayout this$0, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.minimizedIconAnimScaleValue = f;
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resizeAlphaAnimation$lambda$21$lambda$20(FloatingPaneLayout this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.resizeRectAlphaValue = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    private final void setBlurDisableInternal(boolean z) {
        if (SemBlurCompat.INSTANCE.isBlurEffectPresetSupport() || z) {
            this.blurDisableInternal = z;
        } else {
            LogTagHelperKt.error(this, "Blur effect is not available due to the SDK version");
            this.blurDisableInternal = true;
        }
    }

    @RequiresApi(35)
    private final void setBlurEffect(View view) {
        SemBlurCompat.setBlurEffectPreset$default(view, this.blurMode, SeslMisc.isLightTheme(getContext()) ? 105 : 120, (Integer) null, this.blurMode == 2 ? null : Float.valueOf(this.dockingEffectCornerRadius), (Integer) null, 32, (Object) null);
    }

    private final void setResizeByContentScrollEnabled(boolean enabled) {
        LogTagHelperKt.info(this, "setResizeByContentScrollEnabled enabled=" + enabled);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView == null) {
            return;
        }
        floatingPaneView.setResizeByContentScrollEnabled(enabled);
    }

    public static /* synthetic */ void show$default(FloatingPaneLayout floatingPaneLayout, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        floatingPaneLayout.show(z);
    }

    public static /* synthetic */ void showMinimizedIcon$default(FloatingPaneLayout floatingPaneLayout, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMinimizedIcon");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        floatingPaneLayout.showMinimizedIcon(z, z2);
    }

    public final void addCallback(@NotNull IFloatingPaneCallback callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogTagHelperKt.info(this, "addCallback " + callback);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.addCallbacks(callback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    public final void addUntouchableAreaInset(int left, int top, int right, int bottom) {
        FloatingPaneView floatingPaneView = this.floatingView;
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = floatingPaneView != null ? floatingPaneView.m22101getBehaviorJ5JjPLc(FloatingPane.FloatingPaneMode.INSTANCE.MODE_FLOATING()) : null;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(left, top, "setUntouchableAreaInset inset=(", SQLKeyword.COMMA, SQLKeyword.COMMA);
        sbM1173s.append(right);
        sbM1173s.append(SQLKeyword.COMMA);
        sbM1173s.append(bottom);
        sbM1173s.append(PropertyUtils.MAPPED_DELIM2);
        LogTagHelperKt.info(this, sbM1173s.toString());
        FloatingBehavior floatingBehavior = commonBehaviorM22101getBehaviorJ5JjPLc instanceof FloatingBehavior ? (FloatingBehavior) commonBehaviorM22101getBehaviorJ5JjPLc : null;
        if (floatingBehavior != null) {
            floatingBehavior.setCustomUntouchableAreaInset(new Rect(left, top, right, bottom));
            return;
        }
        LogTagHelperKt.warn(this, "fail to setUntouchableAreaInset, FloatingMode is not exist(" + commonBehaviorM22101getBehaviorJ5JjPLc + "})");
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        addViewInternal(child, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        float f = this.resizeRectAlphaValue;
        if (f > 0.0f) {
            Drawable drawable = this.resizeRectDrawable;
            if (drawable != null) {
                drawable.setAlpha((int) (f * 255.0f));
            }
            Drawable drawable2 = this.resizeRectDrawable;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
            float f4 = this.minimizedIconAnimScaleValue;
            if (f4 > 0.0f) {
                float f5 = f4 * 0.001f;
                int i = (int) ((this.minimizedIconSize / 2.0f) * f5);
                Drawable drawable3 = this.minimizedIcon;
                if (drawable3 != null) {
                    int i2 = this.minimizedIconSize;
                    drawable3.setBounds(new Rect(0, 0, i2, i2));
                }
                Drawable drawable4 = this.minimizedIcon;
                if (drawable4 != null) {
                    drawable4.setAlpha((int) (this.minimizedIconAnimAlphaValue * 255.0f));
                }
                canvas.save();
                Point point = this.resizeRectCenter;
                float f6 = i;
                canvas.translate(point.x - f6, point.y - f6);
                canvas.scale(f5, f5);
                Drawable drawable5 = this.minimizedIcon;
                if (drawable5 != null) {
                    drawable5.draw(canvas);
                }
                canvas.restore();
            }
        }
    }

    public final void enterMinimizeView(boolean minimize) {
        Unit unit;
        LogTagHelperKt.info(this, "enterMinimize " + minimize);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.enterMinimizeView(minimize);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    @JvmName(name = "getPaneMode")
    public final int getPaneMode() {
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            return floatingPaneView.getMode();
        }
        LogTagHelperKt.warn(this, "Floating not added yet");
        return FloatingPane.FloatingPaneMode.INSTANCE.MODE_BOTTOM();
    }

    @JvmOverloads
    public final void hide() {
        hide$default(this, false, 1, null);
    }

    public final boolean isMinimizeView() {
        FloatingPaneView floatingPaneView = this.floatingView;
        Boolean boolValueOf = floatingPaneView != null ? Boolean.valueOf(floatingPaneView.isMinimizeView()) : null;
        LogTagHelperKt.info(this, "isMinimizeView " + boolValueOf);
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    public final boolean isShowing() {
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            return floatingPaneView.isShowing();
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        FloatingPaneView floatingPaneView;
        super.onLayout(changed, left, top, right, bottom);
        if (!changed || (floatingPaneView = this.floatingView) == null) {
            return;
        }
        floatingPaneView.onChangedParentBounds$material_release(left, top, right, bottom);
    }

    public final void removeAllCallback() {
        Unit unit;
        LogTagHelperKt.info(this, "removeAllCallback");
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.removeAllCallback();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    public final void removeCallback(@NotNull IFloatingPaneCallback callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogTagHelperKt.info(this, "removeCallback " + callback);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.removeCallback(callback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    public final void seslRequestDrawResizeRect$material_release(@Nullable Rect rect) {
        if (Intrinsics.areEqual(this.resizeRect, rect)) {
            return;
        }
        this.resizeRect = rect;
        if (rect != null) {
            Drawable drawable = this.resizeRectDrawable;
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            this.resizeRectCenter.x = (rect.width() / 2) + rect.left;
            this.resizeRectCenter.y = (rect.height() / 2) + rect.top;
        }
        if (rect == null) {
            this.resizeAlphaAnimation.setFloatValues(1.0f, 0.0f);
            this.resizeAlphaAnimation.start();
        } else if (!this.resizeAlphaAnimation.isRunning() && this.resizeRectAlphaValue == 0.0f) {
            this.resizeAlphaAnimation.setFloatValues(0.0f, 1.0f);
            this.resizeAlphaAnimation.start();
        }
        if (this.resizeRectAlphaValue <= 0.0f) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
            invalidate();
        }
    }

    public final void seslShowProDockingEffect$material_release(boolean show, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (this.isShowingPreDockingEffect != show) {
            this.isShowingPreDockingEffect = show;
            if (this.showPreDockingEffect.isRunning()) {
                this.showPreDockingEffect.cancel();
            }
            if (this.hidePreDockingEffect.isRunning()) {
                this.hidePreDockingEffect.cancel();
            }
            if (!show) {
                this.hidePreDockingEffect.start();
                return;
            }
            int i = this.dockingEffectPadding;
            rect.inset(i, i);
            ViewHelperKt.updateViewBounds(this.preDockingEffect, rect);
            if (!SemBlurCompat.INSTANCE.isBlurEffectPresetSupport() || this.blurDisableInternal) {
                ImageView imageView = this.preDockingEffect;
                imageView.setBackgroundResource(C4548R.drawable.sesl_floating_pane_pre_docking_effect_no_blur);
                ImageView imageView2 = this.preDockingEffect;
                SeslThemeResourceHelper.Companion companion = SeslThemeResourceHelper.INSTANCE;
                Context context = imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                imageView2.setBackgroundTintList(ColorStateList.valueOf(companion.getColorInt(context, new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_floating_pane_docking_effect_no_blur_color, C4548R.color.sesl_floating_pane_docking_effect_no_blur_color_dark))));
                SemBlurCompat.setBlurInfoClear(this.preDockingEffect);
            } else {
                this.preDockingEffect.setBackgroundResource(C4548R.drawable.sesl_floating_pane_pre_docking_effect);
                setBlurEffect(this.preDockingEffect);
            }
            this.showPreDockingEffect.start();
            HapticFeedbackHelper.INSTANCE.onEditGuide(this);
        }
    }

    public final void seslStopDrawAllRequested$material_release() {
        this.resizeRect = null;
        this.preDockingEffect.setVisibility(8);
        invalidate();
        setWillNotDraw(true);
    }

    @JvmName(name = "setAllowModes")
    public final void setAllowModes(int mode) {
        LogTagHelperKt.info(this, "Custom allowed mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)));
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView == null) {
            return;
        }
        floatingPaneView.m22103setAllowedModeJ5JjPLc$material_release(mode);
    }

    public final void setBlurDisable(boolean disable) {
        LogTagHelperKt.info(this, "setBlurDisable disable=" + disable);
        if (this.blurDisableInternal != disable) {
            setBlurDisableInternal(disable);
        }
    }

    public final void setBlurMode(int semBlurInfoMode) {
        LogTagHelperKt.info(this, "setBlurMode " + semBlurInfoMode);
        this.blurMode = semBlurInfoMode;
    }

    public final void setContentView(@NotNull View view) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        LogTagHelperKt.info(this, "setContentView " + view);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.setContentView(view);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    @JvmName(name = "setHideAnimationListener")
    public final void setHideAnimationListener(int mode, @Nullable IFloatingPaneCallback.AnimationListener callback) {
        LogTagHelperKt.info(this, "setHideAnimationListener mode " + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", callback=" + callback);
        FloatingPaneView floatingPaneView = this.floatingView;
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = floatingPaneView != null ? floatingPaneView.m22101getBehaviorJ5JjPLc(mode) : null;
        if (commonBehaviorM22101getBehaviorJ5JjPLc == null) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setHideAnimationListener(callback);
    }

    @JvmName(name = "setMaxHeight")
    public final void setMaxHeight(int mode, @Nullable Integer height) {
        LogTagHelperKt.info(this, "setMaxHeight mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", height=" + height);
        FloatingPaneView floatingPaneView = this.floatingView;
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = floatingPaneView != null ? floatingPaneView.m22101getBehaviorJ5JjPLc(mode) : null;
        if (commonBehaviorM22101getBehaviorJ5JjPLc == null) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setCustomMaxHeight(height);
    }

    @JvmName(name = "setMaxWidth")
    public final void setMaxWidth(int mode, @Nullable Integer width) {
        LogTagHelperKt.info(this, "setMaxWidth mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", width=" + width);
        FloatingPaneView floatingPaneView = this.floatingView;
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = floatingPaneView != null ? floatingPaneView.m22101getBehaviorJ5JjPLc(mode) : null;
        if (commonBehaviorM22101getBehaviorJ5JjPLc == null) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setCustomMaxWidth(width);
    }

    @JvmName(name = "setMinHeight")
    public final void setMinHeight(int mode, @Nullable Integer height) {
        LogTagHelperKt.info(this, "setMinHeight mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", height=" + height);
        FloatingPaneView floatingPaneView = this.floatingView;
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = floatingPaneView != null ? floatingPaneView.m22101getBehaviorJ5JjPLc(mode) : null;
        if (commonBehaviorM22101getBehaviorJ5JjPLc == null) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setCustomMinHeight(height);
    }

    @JvmName(name = "setMinWidth")
    public final void setMinWidth(int mode, @Nullable Integer width) {
        LogTagHelperKt.info(this, "setMinWidth mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", width=" + width);
        FloatingPaneView floatingPaneView = this.floatingView;
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = floatingPaneView != null ? floatingPaneView.m22101getBehaviorJ5JjPLc(mode) : null;
        if (commonBehaviorM22101getBehaviorJ5JjPLc == null) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setCustomMinWidth(width);
    }

    public final void setMinimizeView(@NotNull View view) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        LogTagHelperKt.info(this, "setMinimizeView " + view);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.setMinimizeView(view);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    @JvmName(name = "setMinimizeWidth")
    public final void setMinimizeWidth(int mode, @Nullable Integer width) {
        LogTagHelperKt.info(this, "setMinimizeWidth mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", width=" + width);
        FloatingPaneView floatingPaneView = this.floatingView;
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = floatingPaneView != null ? floatingPaneView.m22101getBehaviorJ5JjPLc(mode) : null;
        if (commonBehaviorM22101getBehaviorJ5JjPLc == null) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setCustomMinimizeWidth(width);
    }

    @JvmName(name = "setPaneMode")
    public final void setPaneMode(int mode) {
        Unit unit;
        LogTagHelperKt.info(this, "setPaneMode " + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)));
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            FloatingPaneView.m22095changePaneLayoutModeWX4EXPg$default(floatingPaneView, mode, false, false, !isShowing(), false, 22, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    @JvmName(name = "setResultHeight")
    public final void setResultHeight(int mode, @Nullable Integer height) {
        LogTagHelperKt.info(this, "setResultHeight mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", height=" + height);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.m22104setResultHeightoaV7IQU(mode, height);
        }
    }

    @JvmName(name = "setResultViewBackgroundResource")
    public final void setResultViewBackgroundResource(int mode, @DrawableRes @Nullable Integer resId) {
        LogTagHelperKt.info(this, "setResultViewBackgroundResource mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", resId=" + resId);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.m22105setResultViewBackgroundResourceoaV7IQU(mode, resId);
        }
    }

    @JvmName(name = "setResultWidth")
    public final void setResultWidth(int mode, @Nullable Integer width) {
        LogTagHelperKt.info(this, "setResultWidth mode=" + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", width=" + width);
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.m22106setResultWidthoaV7IQU(mode, width);
        }
    }

    @JvmName(name = "setShowAnimationListener")
    public final void setShowAnimationListener(int mode, @Nullable IFloatingPaneCallback.AnimationListener callback) {
        LogTagHelperKt.info(this, "setShowAnimationListener mode " + ((Object) FloatingPane.FloatingPaneMode.m22086toStringimpl(mode)) + ", callback=" + callback);
        FloatingPaneView floatingPaneView = this.floatingView;
        CommonBehavior commonBehaviorM22101getBehaviorJ5JjPLc = floatingPaneView != null ? floatingPaneView.m22101getBehaviorJ5JjPLc(mode) : null;
        if (commonBehaviorM22101getBehaviorJ5JjPLc == null) {
            return;
        }
        commonBehaviorM22101getBehaviorJ5JjPLc.setShowAnimationListener(callback);
    }

    @JvmOverloads
    public final void show() {
        show$default(this, false, 1, null);
    }

    public final void showMinimizedIcon(boolean show, boolean skipAnimate) {
        if (this.showMinimizedIcon != show) {
            this.showMinimizedIcon = show;
            if (this.minimizedIconAlphaAnimation.isRunning()) {
                this.minimizedIconAlphaAnimation.cancel();
            }
            if (show) {
                this.minimizedIconAlphaAnimation.setFloatValues(this.minimizedIconAnimAlphaValue, 1.0f);
                this.minimizedIconAlphaAnimation.setDuration(skipAnimate ? 0L : (long) ((1.0f - this.minimizedIconAnimAlphaValue) * this.minimizedIconAlphaAnimDuration));
                if (this.minimizedIconScaleHideAnimation.isRunning()) {
                    this.minimizedIconScaleHideAnimation.cancel();
                    this.minimizedIconScaleShowAnimation.setStartValue(this.minimizedIconAnimScaleValue);
                } else {
                    this.minimizedIconScaleShowAnimation.setStartValue(0.0f);
                }
                this.minimizedIconScaleShowAnimation.start();
                HapticFeedbackHelper.INSTANCE.onEditGuideWithSnapping(this);
            } else {
                this.minimizedIconAlphaAnimation.setFloatValues(this.minimizedIconAnimAlphaValue, 0.0f);
                this.minimizedIconAlphaAnimation.setDuration(skipAnimate ? 0L : (long) (this.minimizedIconAlphaAnimDuration * this.minimizedIconAnimAlphaValue));
                if (this.minimizedIconScaleShowAnimation.isRunning()) {
                    this.minimizedIconScaleShowAnimation.cancel();
                    this.minimizedIconScaleHideAnimation.setFloatValues(this.minimizedIconAnimScaleValue, 0.0f);
                    this.minimizedIconScaleHideAnimation.setDuration(skipAnimate ? 0L : (long) (this.minimizedSaleAnimDuration * this.minimizedIconAnimScaleValue));
                } else {
                    this.minimizedIconScaleHideAnimation.setFloatValues(1000.0f, 0.0f);
                    this.minimizedIconScaleHideAnimation.setDuration(skipAnimate ? 0L : this.minimizedSaleAnimDuration);
                }
                this.minimizedIconScaleHideAnimation.start();
            }
            this.minimizedIconAlphaAnimation.start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingPaneLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmOverloads
    public final void hide(boolean animate) {
        Unit unit;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("hide animate=", " floatingView=", animate);
        sbM3200j.append(this.floatingView != null);
        LogTagHelperKt.info(this, sbM3200j.toString());
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.hide(animate);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    @JvmOverloads
    public final void show(boolean animate) {
        Unit unit;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("show animate=", " floatingView=", animate);
        sbM3200j.append(this.floatingView != null);
        LogTagHelperKt.info(this, sbM3200j.toString());
        FloatingPaneView floatingPaneView = this.floatingView;
        if (floatingPaneView != null) {
            floatingPaneView.show(animate);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogTagHelperKt.warn(this, "Floating not added yet");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingPaneLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        addView(child);
    }

    public /* synthetic */ FloatingPaneLayout(Context context, AttributeSet attributeSet, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2);
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int width, int height) {
        Intrinsics.checkNotNullParameter(child, "child");
        addViewInternal(child, new ViewGroup.LayoutParams(width, height));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingPaneLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.logTag = "FloatingPaneLayout";
        final int i4 = 2;
        this.blurMode = 2;
        this.minimizedIcon = context.getDrawable(C4548R.drawable.sesl_floating_pane_minimized_icon);
        this.minimizedIconSize = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_minimized_size);
        this.minimizedIconAlphaAnimDuration = 150L;
        this.minimizedSaleAnimDuration = 250L;
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(C4548R.drawable.sesl_floating_pane_pre_docking_effect);
        final int i5 = 1;
        imageView.setClipToOutline(true);
        imageView.setVisibility(8);
        this.preDockingEffect = imageView;
        this.dockingEffectPadding = getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_pre_docking_effect_padding);
        this.dockingEffectCornerRadius = getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_pane_background_corner_radius);
        this.resizeRectDrawable = context.getDrawable(C4548R.drawable.sesl_floating_pane_resize_background);
        final int i6 = 0;
        this.resizeRectCenter = new Point(0, 0);
        AnimatorSet animatorSet = new AnimatorSet();
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, C4548R.animator.pre_docking_effect_show_anim);
        animatorLoadAnimator.setTarget(imageView);
        Unit unit = Unit.INSTANCE;
        animatorSet.playTogether(animatorLoadAnimator);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneLayout$showPreDockingEffect$lambda$3$$inlined$doOnStart$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                this.this$0.preDockingEffect.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.showPreDockingEffect = animatorSet;
        AnimatorSet animatorSet2 = new AnimatorSet();
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(context, C4548R.animator.pre_docking_effect_hide_anim);
        animatorLoadAnimator2.setTarget(imageView);
        animatorSet2.playTogether(animatorLoadAnimator2);
        animatorSet2.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingdock.FloatingPaneLayout$hidePreDockingEffect$lambda$6$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.this$0.preDockingEffect.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.hidePreDockingEffect = animatorSet2;
        setBlurDisableInternal(!SemBlurCompat.INSTANCE.isBlurEffectPresetSupport());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f));
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.oneui.floatingdock.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneLayout f2327b;

            {
                this.f2327b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i6) {
                    case 0:
                        FloatingPaneLayout.resizeAlphaAnimation$lambda$21$lambda$20(this.f2327b, valueAnimator);
                        break;
                    case 1:
                        FloatingPaneLayout.minimizedIconScaleHideAnimation$lambda$25$lambda$24(this.f2327b, valueAnimator);
                        break;
                    default:
                        FloatingPaneLayout.minimizedIconAlphaAnimation$lambda$27$lambda$26(this.f2327b, valueAnimator);
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(0f, 1f).apply {\n…alidate()\n        }\n    }");
        this.resizeAlphaAnimation = valueAnimatorOfFloat;
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        springAnimation.setSpring(new SpringForce());
        springAnimation.getSpring().setDampingRatio(0.75f);
        springAnimation.getSpring().setStiffness(256.0f);
        springAnimation.getSpring().setFinalPosition(1000.0f);
        springAnimation.setMinValue(0.0f);
        springAnimation.setMaxValue(1000.0f);
        springAnimation.addUpdateListener(new C4778c(this, i5));
        this.minimizedIconScaleShowAnimation = springAnimation;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1000.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f));
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.oneui.floatingdock.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneLayout f2327b;

            {
                this.f2327b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i5) {
                    case 0:
                        FloatingPaneLayout.resizeAlphaAnimation$lambda$21$lambda$20(this.f2327b, valueAnimator);
                        break;
                    case 1:
                        FloatingPaneLayout.minimizedIconScaleHideAnimation$lambda$25$lambda$24(this.f2327b, valueAnimator);
                        break;
                    default:
                        FloatingPaneLayout.minimizedIconAlphaAnimation$lambda$27$lambda$26(this.f2327b, valueAnimator);
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat2, "ofFloat(1000f, 0f).apply…alidate()\n        }\n    }");
        this.minimizedIconScaleHideAnimation = valueAnimatorOfFloat2;
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f));
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.oneui.floatingdock.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FloatingPaneLayout f2327b;

            {
                this.f2327b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i4) {
                    case 0:
                        FloatingPaneLayout.resizeAlphaAnimation$lambda$21$lambda$20(this.f2327b, valueAnimator);
                        break;
                    case 1:
                        FloatingPaneLayout.minimizedIconScaleHideAnimation$lambda$25$lambda$24(this.f2327b, valueAnimator);
                        break;
                    default:
                        FloatingPaneLayout.minimizedIconAlphaAnimation$lambda$27$lambda$26(this.f2327b, valueAnimator);
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat3, "ofFloat(0f, 1f).apply {\n…alidate()\n        }\n    }");
        this.minimizedIconAlphaAnimation = valueAnimatorOfFloat3;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(@NotNull View child, @NotNull ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        addViewInternal(child, params);
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int index, @NotNull ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        addViewInternal(child, params);
    }

    private static /* synthetic */ void getBlurMode$annotations() {
    }
}
