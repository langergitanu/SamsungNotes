package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\u001a\u0010+\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0017J\u0018\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0002J\u0006\u00106\u001a\u00020\u000eJ\u0006\u00107\u001a\u00020\u000eR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTSlider3;", "Landroid/view/View;", "context", "Landroid/content/Context;", "colors", "", "positions", "", "start", "", "end", "value", Constants.ARG_UPDATE, "Lkotlin/Function1;", "", "<init>", "(Landroid/content/Context;[I[FFFFLkotlin/jvm/functions/Function1;)V", "sweep", "cx", "cy", "radius", "bounds", "Landroid/graphics/RectF;", "borderStroke", "borderPaint", "Landroid/graphics/Paint;", "valueStroke", "valuePaint", "handlerRadius", "handlerCenter", "Landroid/graphics/PointF;", "handlerPaint", "minRadius", "maxRadius", "dragging", "", "scaleXAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "scaleYAnimator", "alphaAnimator", "Landroid/view/ViewPropertyAnimator;", "setupHandlerCenter", "setupBorderPaint", "setupValuePaint", "setupHandlerPaint", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "draggable", "x", "y", Constants.IntentExtraValue.SHOW, "hide", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nQTSlider3.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTSlider3.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTSlider3\n+ 2 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n*L\n1#1,189:1\n10#2,2:190\n10#2,2:192\n10#2,2:194\n36#2:196\n10#2,10:197\n15#2:207\n10#2,2:208\n23#2,4:210\n15#2:214\n10#2,2:215\n23#2,4:217\n32#2:221\n10#2,2:222\n*S KotlinDebug\n*F\n+ 1 QTSlider3.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTSlider3\n*L\n39#1:190,2\n40#1:192,2\n41#1:194,2\n80#1:196\n80#1:197,10\n154#1:207\n154#1:208,2\n155#1:210,4\n160#1:214\n160#1:215,2\n161#1:217,4\n164#1:221\n164#1:222,2\n*E\n"})
public final class QTSlider3 extends View {

    @NotNull
    private final ViewPropertyAnimator alphaAnimator;

    @NotNull
    private final Paint borderPaint;
    private final float borderStroke;

    @NotNull
    private final RectF bounds;
    private final float cx;
    private final float cy;
    private boolean dragging;
    private final float end;

    @NotNull
    private final PointF handlerCenter;

    @NotNull
    private final Paint handlerPaint;
    private final float handlerRadius;
    private final float maxRadius;
    private final float minRadius;
    private final float radius;

    @NotNull
    private final SpringAnimation scaleXAnimator;

    @NotNull
    private final SpringAnimation scaleYAnimator;
    private final float start;
    private final float sweep;

    @NotNull
    private final Function1<Float, Unit> update;

    @NotNull
    private final Paint valuePaint;
    private final float valueStroke;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QTSlider3(@NotNull Context context, @ColorInt @NotNull int[] colors, @Nullable float[] fArr, @FloatRange(from = 0.0d, m705to = 360.0d, toInclusive = false) float f, @FloatRange(from = 0.0d, m705to = 360.0d, toInclusive = false) float f4, @FloatRange(from = 0.0d, m705to = 1.0d) float f5, @NotNull Function1<? super Float, Unit> update) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(update, "update");
        this.update = update;
        float f6 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f7 = f % f6;
        this.start = f7 < 0.0f ? f7 + f6 : f7;
        float f8 = f4 % f6;
        this.end = f8 < 0.0f ? f8 + f6 : f8;
        float f9 = (f4 - f) % f6;
        this.sweep = f9 < 0.0f ? f9 + f6 : f9;
        float dimension = getResources().getDimension(C9086R.dimen.qt_container_width) * 0.5f;
        this.cx = dimension;
        float dimension2 = getResources().getDimension(C9086R.dimen.qt_container_height) * 0.5f;
        this.cy = dimension2;
        float dimension3 = getResources().getDimension(C9086R.dimen.qt_outer_radius);
        this.radius = dimension3;
        this.bounds = new RectF(dimension - dimension3, dimension2 - dimension3, dimension + dimension3, dimension2 + dimension3);
        this.borderStroke = getResources().getDimension(C9086R.dimen.qt_slider_3_border);
        this.borderPaint = setupBorderPaint();
        float dimension4 = getResources().getDimension(C9086R.dimen.qt_slider_3_stroke);
        this.valueStroke = dimension4;
        this.valuePaint = setupValuePaint(colors, fArr);
        this.handlerRadius = getResources().getDimension(C9086R.dimen.qt_slider_3_handler_radius);
        this.handlerCenter = setupHandlerCenter(f5);
        this.handlerPaint = setupHandlerPaint();
        this.minRadius = dimension3 - (dimension4 * 0.5f);
        this.maxRadius = (dimension4 * 0.5f) + dimension3;
        setScaleX(0.8f);
        setScaleY(0.8f);
        setAlpha(0.0f);
        SpringForce stiffness = new SpringForce().setDampingRatio(0.75f).setStiffness(300.0f);
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

    private final boolean draggable(float x, float y2) {
        float f = x - this.cx;
        float f4 = y2 - this.cy;
        float f5 = (f4 * f4) + (f * f);
        float f6 = this.minRadius;
        if (f5 < f6 * f6) {
            return false;
        }
        float f7 = this.maxRadius;
        if (f5 > f7 * f7) {
            return false;
        }
        float fAtan2 = (float) (((double) (((float) Math.atan2(f4, f)) * 180)) / 3.141592653589793d);
        float f8 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f9 = fAtan2 % f8;
        if (f9 < 0.0f) {
            f9 += f8;
        }
        float f10 = this.start;
        float f11 = this.end;
        return f10 > f11 ? f9 >= f10 || f9 <= f11 : f10 <= f9 && f9 <= f11;
    }

    private final Paint setupBorderPaint() {
        Paint paint = new Paint();
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(this.borderStroke);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getContext().getColor(C9086R.color.qt_slider_3_border));
        return paint;
    }

    private final PointF setupHandlerCenter(float value) {
        float f = (value * this.sweep) + this.start;
        float f4 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f5 = f % f4;
        if (f5 < 0.0f) {
            f5 += f4;
        }
        double d = (float) ((((double) f5) * 3.141592653589793d) / ((double) 180));
        return new PointF((((float) Math.cos(d)) * this.radius) + this.cx, (((float) Math.sin(d)) * this.radius) + this.cy);
    }

    private final Paint setupHandlerPaint() {
        Paint paint = new Paint();
        paint.setColor(getContext().getColor(C9086R.color.qt_slider_3_handler));
        return paint;
    }

    private final Paint setupValuePaint(int[] colors, float[] positions) {
        Paint paint = new Paint();
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(this.valueStroke);
        paint.setStyle(Paint.Style.STROKE);
        paint.setShader(new SweepGradient(this.cx, this.cy, colors, positions));
        return paint;
    }

    private final void update(float x, float y2) {
        float fAtan2 = (float) Math.atan2(y2 - this.cy, x - this.cx);
        float f = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f4 = ((float) (((double) (180 * fAtan2)) / 3.141592653589793d)) % f;
        if (f4 < 0.0f) {
            f4 += f;
        }
        float f5 = this.start;
        float f6 = this.end;
        if (f5 > f6) {
            if (f4 < f5 && f4 > f6) {
                return;
            }
        } else if (f5 > f4 || f4 > f6) {
            return;
        }
        double d = fAtan2;
        this.handlerCenter.x = (((float) Math.cos(d)) * this.radius) + this.cx;
        this.handlerCenter.y = (((float) Math.sin(d)) * this.radius) + this.cy;
        Function1<Float, Unit> function1 = this.update;
        float f7 = this.start;
        float f8 = this.sweep;
        float f9 = (f4 - f7) % f;
        if (f9 < 0.0f) {
            f9 += f;
        }
        function1.invoke(Float.valueOf(f9 / f8));
        invalidate();
    }

    public final void hide() {
        this.scaleXAnimator.animateToFinalPosition(0.8f);
        this.scaleYAnimator.animateToFinalPosition(0.8f);
        this.alphaAnimator.cancel();
        this.alphaAnimator.alpha(0.0f).setDuration(100L).start();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawArc(this.bounds, this.start, this.sweep, false, this.borderPaint);
        canvas.drawArc(this.bounds, this.start, this.sweep, false, this.valuePaint);
        PointF pointF = this.handlerCenter;
        canvas.drawCircle(pointF.x, pointF.y, this.handlerRadius, this.handlerPaint);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.dragging) {
                    this.dragging = false;
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                }
            } else if (this.dragging) {
                update(event.getX(), event.getY());
                return true;
            }
        } else if (draggable(event.getX(), event.getY())) {
            this.dragging = true;
            return true;
        }
        return false;
    }

    public final void show() {
        this.scaleXAnimator.animateToFinalPosition(1.0f);
        this.scaleYAnimator.animateToFinalPosition(1.0f);
        this.alphaAnimator.cancel();
        this.alphaAnimator.alpha(1.0f).setDuration(200L).start();
    }
}
