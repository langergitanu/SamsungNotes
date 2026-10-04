package androidx.compose.material.ripple;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.RectHelper_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JQ\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010 \u001a\u00020\rJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J0\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0014J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0014J\b\u0010-\u001a\u00020\rH\u0016J\u0006\u0010.\u001a\u00020\rJ\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0006H\u0002J3\u00101\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00065"}, m13886d2 = {"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bounded", "", "Ljava/lang/Boolean;", "lastRippleStateChangeTimeMillis", "", "Ljava/lang/Long;", "onInvalidateRipple", "Lkotlin/Function0;", "", "resetRippleRunnable", "Ljava/lang/Runnable;", "ripple", "Landroidx/compose/material/ripple/UnprojectedRipple;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "radius", "", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "addRipple-KOepWvA", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;ZJIJFLkotlin/jvm/functions/Function0;)V", "createRipple", "disposeRipple", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDrawableState", "removeRipple", "setRippleState", "pressed", "updateRippleProperties", "updateRippleProperties-biQXAtU", "(JIJF)V", "Companion", "material-ripple_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class RippleHostView extends View {
    private static final long MinimumRippleStateChangeTime = 5;
    private static final long ResetRippleDelayDuration = 50;

    @Nullable
    private Boolean bounded;

    @Nullable
    private Long lastRippleStateChangeTimeMillis;

    @Nullable
    private Function0<Unit> onInvalidateRipple;

    @Nullable
    private Runnable resetRippleRunnable;

    @Nullable
    private UnprojectedRipple ripple;

    @NotNull
    private static final int[] PressedState = {android.R.attr.state_pressed, android.R.attr.state_enabled};

    @NotNull
    private static final int[] RestingState = new int[0];

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RippleHostView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void createRipple(boolean bounded) {
        UnprojectedRipple unprojectedRipple = new UnprojectedRipple(bounded);
        setBackground(unprojectedRipple);
        this.ripple = unprojectedRipple;
    }

    private final void setRippleState(boolean pressed) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l = this.lastRippleStateChangeTimeMillis;
        long jLongValue = jCurrentAnimationTimeMillis - (l != null ? l.longValue() : 0L);
        if (pressed || jLongValue >= 5) {
            int[] iArr = pressed ? PressedState : RestingState;
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(iArr);
            }
        } else {
            RunnableC0015b runnableC0015b = new RunnableC0015b(this, 18);
            this.resetRippleRunnable = runnableC0015b;
            postDelayed(runnableC0015b, 50L);
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setRippleState$lambda-2, reason: not valid java name */
    public static final void m16973setRippleState$lambda2(RippleHostView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UnprojectedRipple unprojectedRipple = this$0.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.setState(RestingState);
        }
        this$0.resetRippleRunnable = null;
    }

    /* JADX INFO: renamed from: addRipple-KOepWvA, reason: not valid java name */
    public final void m16974addRippleKOepWvA(@NotNull PressInteraction.Press interaction, boolean bounded, long size, int radius, long color, float alpha, @NotNull Function0<Unit> onInvalidateRipple) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(onInvalidateRipple, "onInvalidateRipple");
        if (this.ripple == null || !Intrinsics.areEqual(Boolean.valueOf(bounded), this.bounded)) {
            createRipple(bounded);
            this.bounded = Boolean.valueOf(bounded);
        }
        UnprojectedRipple unprojectedRipple = this.ripple;
        Intrinsics.checkNotNull(unprojectedRipple);
        this.onInvalidateRipple = onInvalidateRipple;
        m16975updateRipplePropertiesbiQXAtU(size, radius, color, alpha);
        if (bounded) {
            unprojectedRipple.setHotspot(Offset.m18284getXimpl(interaction.getPressPosition()), Offset.m18285getYimpl(interaction.getPressPosition()));
        } else {
            unprojectedRipple.setHotspot(unprojectedRipple.getBounds().centerX(), unprojectedRipple.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void disposeRipple() {
        this.onInvalidateRipple = null;
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            Runnable runnable2 = this.resetRippleRunnable;
            Intrinsics.checkNotNull(runnable2);
            runnable2.run();
        } else {
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(RestingState);
            }
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        if (unprojectedRipple2 == null) {
            return;
        }
        unprojectedRipple2.setVisible(false, false);
        unscheduleDrawable(unprojectedRipple2);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        Function0<Unit> function0 = this.onInvalidateRipple;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    /* JADX INFO: renamed from: updateRippleProperties-biQXAtU, reason: not valid java name */
    public final void m16975updateRipplePropertiesbiQXAtU(long size, int radius, long color, float alpha) {
        UnprojectedRipple unprojectedRipple = this.ripple;
        if (unprojectedRipple == null) {
            return;
        }
        unprojectedRipple.trySetRadius(radius);
        unprojectedRipple.m16982setColorDxMtmZc(color, alpha);
        Rect androidRect = RectHelper_androidKt.toAndroidRect(SizeKt.m18374toRectuvyYCjk(size));
        setLeft(androidRect.left);
        setTop(androidRect.top);
        setRight(androidRect.right);
        setBottom(androidRect.bottom);
        unprojectedRipple.setBounds(androidRect);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
    }
}
