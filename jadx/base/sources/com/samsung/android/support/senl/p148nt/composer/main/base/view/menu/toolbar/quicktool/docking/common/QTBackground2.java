package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTBackground2;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "radius", "", "stroke", "shadowDefaultPaint", "Landroid/graphics/Paint;", "shadowVariantPaint", "scaleXAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "scaleYAnimator", "alphaAnimator", "Landroid/view/ViewPropertyAnimator;", "setupShadowDefaultPaint", "setupShadowVariantPaint", "setupBaseShadowPaint", "draw", "", "canvas", "Landroid/graphics/Canvas;", Constants.IntentExtraValue.SHOW, "hide", "onHoverEvent", "", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "consume", "x", "y", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTBackground2 extends View {

    @NotNull
    private final ViewPropertyAnimator alphaAnimator;
    private final float radius;

    @NotNull
    private final SpringAnimation scaleXAnimator;

    @NotNull
    private final SpringAnimation scaleYAnimator;

    @NotNull
    private final Paint shadowDefaultPaint;

    @NotNull
    private final Paint shadowVariantPaint;
    private final float stroke;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public QTBackground2(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean consume(float x, float y2) {
        float width = x - (getWidth() * 0.5f);
        float height = y2 - (getHeight() * 0.5f);
        float f = (this.stroke * 0.5f) + this.radius;
        return (height * height) + (width * width) <= f * f;
    }

    private final Paint setupBaseShadowPaint() {
        Paint paint = new Paint();
        paint.setStrokeWidth(this.stroke);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getContext().getColor(C9086R.color.qt_background_stroke));
        return paint;
    }

    private final Paint setupShadowDefaultPaint() {
        Paint paint = setupBaseShadowPaint();
        paint.setShadowLayer(getResources().getDimension(C9086R.dimen.qt_background_shadow_default_blur), getResources().getDimension(C9086R.dimen.qt_background_shadow_default_x), getResources().getDimension(C9086R.dimen.qt_background_shadow_default_y), getContext().getColor(C9086R.color.qt_shadow_default));
        return paint;
    }

    private final Paint setupShadowVariantPaint() {
        Paint paint = setupBaseShadowPaint();
        paint.setShadowLayer(getResources().getDimension(C9086R.dimen.qt_background_shadow_variant_blur), getResources().getDimension(C9086R.dimen.qt_background_shadow_variant_x), getResources().getDimension(C9086R.dimen.qt_background_shadow_variant_y), getContext().getColor(C9086R.color.qt_shadow_variant));
        return paint;
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        float width = getWidth() * 0.5f;
        float height = getHeight() * 0.5f;
        canvas.drawCircle(width, height, this.radius, this.shadowDefaultPaint);
        canvas.drawCircle(width, height, this.radius, this.shadowVariantPaint);
    }

    public final void hide() {
        this.scaleXAnimator.animateToFinalPosition(0.8f);
        this.scaleYAnimator.animateToFinalPosition(0.8f);
        this.alphaAnimator.cancel();
        this.alphaAnimator.alpha(0.0f).setDuration(100L).start();
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return consume(event.getX(), event.getY());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return consume(event.getX(), event.getY());
    }

    public final void show() {
        this.scaleXAnimator.animateToFinalPosition(1.0f);
        this.scaleYAnimator.animateToFinalPosition(1.0f);
        this.alphaAnimator.cancel();
        this.alphaAnimator.alpha(1.0f).setDuration(200L).start();
    }

    public /* synthetic */ QTBackground2(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QTBackground2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.radius = getResources().getDimension(C9086R.dimen.qt_inner_radius);
        this.stroke = getResources().getDimension(C9086R.dimen.qt_background_stroke);
        this.shadowDefaultPaint = setupShadowDefaultPaint();
        this.shadowVariantPaint = setupShadowVariantPaint();
        SpringForce stiffness = new SpringForce().setDampingRatio(0.63f).setStiffness(200.0f);
        SpringAnimation spring = new SpringAnimation(this, DynamicAnimation.SCALE_X).setSpring(stiffness);
        Intrinsics.checkNotNullExpressionValue(spring, "setSpring(...)");
        this.scaleXAnimator = spring;
        SpringAnimation spring2 = new SpringAnimation(this, DynamicAnimation.SCALE_Y).setSpring(stiffness);
        Intrinsics.checkNotNullExpressionValue(spring2, "setSpring(...)");
        this.scaleYAnimator = spring2;
        ViewPropertyAnimator interpolator = animate().setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNullExpressionValue(interpolator, "setInterpolator(...)");
        this.alphaAnimator = interpolator;
    }
}
