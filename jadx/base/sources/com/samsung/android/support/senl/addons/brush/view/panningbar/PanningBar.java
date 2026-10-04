package com.samsung.android.support.senl.addons.brush.view.panningbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.brush.binding.method.BMPanningBar;
import com.samsung.android.support.senl.addons.brush.viewmodel.panningbar.IPanningBarListener;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0002*+B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0014J\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/panningbar/PanningBar;", "Landroid/widget/LinearLayout;", "Lcom/samsung/android/support/senl/addons/brush/binding/method/BMPanningBar;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPaint", "Landroid/graphics/Paint;", "mStrokeWidth", "mSpacing", "mStartX", "mStartY", "mVerticalPaddingTop", "mHorizontalPaddingLeft", "mCanvasMaxSize", "mOrientation", "mGestureDetector", "Landroid/view/GestureDetector;", "getMGestureDetector", "()Landroid/view/GestureDetector;", "setMGestureDetector", "(Landroid/view/GestureDetector;)V", "mListener", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/panningbar/IPanningBarListener;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "GestureListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PanningBar extends LinearLayout implements BMPanningBar {
    private static int COLOR_GRAY;
    private static int COLOR_WHITE;
    private int mCanvasMaxSize;

    @Nullable
    private GestureDetector mGestureDetector;
    private int mHorizontalPaddingLeft;

    @Nullable
    private IPanningBarListener mListener;
    private int mOrientation;

    @Nullable
    private Paint mPaint;
    private int mSpacing;
    private int mStartX;
    private int mStartY;
    private int mStrokeWidth;
    private int mVerticalPaddingTop;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\u0010\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/panningbar/PanningBar$GestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/view/panningbar/PanningBar;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class GestureListener implements GestureDetector.OnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            if (PanningBar.this.mListener == null) {
                return true;
            }
            IPanningBarListener iPanningBarListener = PanningBar.this.mListener;
            Intrinsics.checkNotNull(iPanningBarListener);
            iPanningBarListener.onTouch();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (PanningBar.this.mListener == null) {
                return false;
            }
            if (PanningBar.this.mOrientation == 1) {
                IPanningBarListener iPanningBarListener = PanningBar.this.mListener;
                Intrinsics.checkNotNull(iPanningBarListener);
                iPanningBarListener.onScroll(0.0f, distanceY);
                return false;
            }
            IPanningBarListener iPanningBarListener2 = PanningBar.this.mListener;
            Intrinsics.checkNotNull(iPanningBarListener2);
            iPanningBarListener2.onScroll(distanceX, 0.0f);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanningBar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    private final void init(Context context) {
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener());
        this.mOrientation = getOrientation();
        Resources resources = context.getResources();
        this.mStrokeWidth = resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_stroke_width);
        this.mSpacing = resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_stroke_spacing);
        this.mVerticalPaddingTop = resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_stroke_padding_vertical) + ((int) (this.mStrokeWidth + 0.25f));
        this.mHorizontalPaddingLeft = resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_stroke_padding_horizontal);
        this.mStartX = resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_start_x_padding);
        this.mStartY = resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_start_y_padding);
        COLOR_WHITE = ResourceUtils.getColor(context, C7944R.color.base_panningbar_white);
        COLOR_GRAY = ResourceUtils.getColor(context, C7944R.color.base_panningbar_gray);
        this.mCanvasMaxSize = getResources().getInteger(C7944R.integer.base_canvas_size_max);
        Paint paint = new Paint();
        this.mPaint = paint;
        Intrinsics.checkNotNull(paint);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = this.mPaint;
        Intrinsics.checkNotNull(paint2);
        paint2.setStrokeWidth(this.mStrokeWidth);
        setWillNotDraw(false);
        invalidate();
    }

    @Nullable
    public final GestureDetector getMGestureDetector() {
        return this.mGestureDetector;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int width = getWidth();
        int i = this.mStrokeWidth;
        int i2 = width - (i + ((int) (i + 0.25f)));
        int height = getHeight();
        int i4 = this.mStrokeWidth;
        int i5 = height - (i4 + ((int) (i4 + 0.25f)));
        int i6 = this.mCanvasMaxSize;
        if (i5 > i6 || i2 > i6) {
            return;
        }
        if (this.mOrientation == 1) {
            int i7 = i2 - this.mStartX;
            int i8 = this.mVerticalPaddingTop;
            while (i8 < i5) {
                int i9 = i8 + this.mStrokeWidth;
                Paint paint = this.mPaint;
                Intrinsics.checkNotNull(paint);
                paint.setColor(COLOR_GRAY);
                float f = this.mStartX;
                float f4 = i8;
                float f5 = i7;
                Paint paint2 = this.mPaint;
                Intrinsics.checkNotNull(paint2);
                canvas.drawLine(f, f4, f5, f4, paint2);
                Paint paint3 = this.mPaint;
                Intrinsics.checkNotNull(paint3);
                paint3.setColor(COLOR_WHITE);
                float f6 = this.mStartX;
                float f7 = i9;
                Paint paint4 = this.mPaint;
                Intrinsics.checkNotNull(paint4);
                canvas.drawLine(f6, f7, f5, f7, paint4);
                i8 += this.mSpacing;
            }
            return;
        }
        int i10 = i5 - this.mStartY;
        int i11 = this.mHorizontalPaddingLeft;
        while (i11 < i2) {
            int i12 = i11 + this.mStrokeWidth;
            Paint paint5 = this.mPaint;
            Intrinsics.checkNotNull(paint5);
            paint5.setColor(COLOR_WHITE);
            float f8 = i11;
            float f9 = this.mStartY;
            float f10 = i10;
            Paint paint6 = this.mPaint;
            Intrinsics.checkNotNull(paint6);
            canvas.drawLine(f8, f9, f8, f10, paint6);
            Paint paint7 = this.mPaint;
            Intrinsics.checkNotNull(paint7);
            paint7.setColor(COLOR_GRAY);
            float f11 = i12;
            float f12 = this.mStartY;
            Paint paint8 = this.mPaint;
            Intrinsics.checkNotNull(paint8);
            canvas.drawLine(f11, f12, f11, f10, paint8);
            i11 += this.mSpacing;
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onTouchEvent(event);
        GestureDetector gestureDetector = this.mGestureDetector;
        Intrinsics.checkNotNull(gestureDetector);
        gestureDetector.onTouchEvent(event);
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMPanningBar
    public void setListener(@Nullable IPanningBarListener listener) {
        this.mListener = listener;
    }

    public final void setMGestureDetector(@Nullable GestureDetector gestureDetector) {
        this.mGestureDetector = gestureDetector;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanningBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanningBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }
}
