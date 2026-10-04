package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingContentFrame;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingContentFrame extends FrameLayout {
    private float mBorderDelta;
    private Shader mBorderGradient;
    private Matrix mBorderMatrix;
    private final Path mBorderPath;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private float mBorderRotateAngle;
    private Paint mBorderStroke;

    @ColorInt
    private int mCenterColor;

    @ColorInt
    private int mEndColor;
    private int mInnerColor;
    private Paint mInnerFill;
    private final Path mInnerPath;
    private float mInnerRadius;
    private final RectF mInnerRect;
    private ValueAnimator mRotateAnimator;
    private AnimatorSet mShowAnimator;

    @ColorInt
    private int mStartColor;
    private float mStrokeWidth;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingContentFrame$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC102501 implements Runnable {
        public RunnableC102501() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(ValueAnimator valueAnimator) {
            AiDrawingContentFrame.this.mBorderRotateAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            AiDrawingContentFrame.this.postInvalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(ValueAnimator valueAnimator) {
            AiDrawingContentFrame.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$2(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            AiDrawingContentFrame.this.setScaleX(fFloatValue);
            AiDrawingContentFrame.this.setScaleY(fFloatValue);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AiDrawingContentFrame.this.mShowAnimator == null || !AiDrawingContentFrame.this.mShowAnimator.isRunning()) {
                final int i = 0;
                AiDrawingContentFrame.this.setVisibility(0);
                AiDrawingContentFrame.this.mShowAnimator = new AnimatorSet();
                final int i2 = 2;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
                valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
                valueAnimatorOfFloat.setDuration(1166L);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.b

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ AiDrawingContentFrame.RunnableC102501 f7152b;

                    {
                        this.f7152b = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        switch (i) {
                            case 0:
                                this.f7152b.lambda$run$0(valueAnimator);
                                break;
                            case 1:
                                this.f7152b.lambda$run$1(valueAnimator);
                                break;
                            default:
                                this.f7152b.lambda$run$2(valueAnimator);
                                break;
                        }
                    }
                });
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat2.setDuration(200L);
                valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                final int i4 = 1;
                valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.b

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ AiDrawingContentFrame.RunnableC102501 f7152b;

                    {
                        this.f7152b = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        switch (i4) {
                            case 0:
                                this.f7152b.lambda$run$0(valueAnimator);
                                break;
                            case 1:
                                this.f7152b.lambda$run$1(valueAnimator);
                                break;
                            default:
                                this.f7152b.lambda$run$2(valueAnimator);
                                break;
                        }
                    }
                });
                AiDrawingContentFrame.this.setPivotX(r8.getMeasuredWidth() / 2.0f);
                AiDrawingContentFrame.this.setPivotY(r8.getMeasuredHeight() / 2.0f);
                AiDrawingContentFrame.this.setScaleX(1.15f);
                AiDrawingContentFrame.this.setScaleY(1.15f);
                ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.15f, 1.0f);
                valueAnimatorOfFloat3.setDuration(400L);
                valueAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
                valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.b

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ AiDrawingContentFrame.RunnableC102501 f7152b;

                    {
                        this.f7152b = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        switch (i2) {
                            case 0:
                                this.f7152b.lambda$run$0(valueAnimator);
                                break;
                            case 1:
                                this.f7152b.lambda$run$1(valueAnimator);
                                break;
                            default:
                                this.f7152b.lambda$run$2(valueAnimator);
                                break;
                        }
                    }
                });
                AiDrawingContentFrame.this.mShowAnimator.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfFloat3);
                AiDrawingContentFrame.this.mShowAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingContentFrame.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        AiDrawingContentFrame.this.startGradientAnimation();
                    }
                });
                AiDrawingContentFrame.this.mShowAnimator.start();
            }
        }
    }

    public AiDrawingContentFrame(Context context) {
        super(context);
        this.mBorderPath = new Path();
        this.mBorderRect = new RectF();
        this.mBorderRotateAngle = 0.0f;
        this.mInnerPath = new Path();
        this.mInnerRect = new RectF();
        this.mStrokeWidth = 10.0f;
        this.mBorderDelta = 10.0f;
        this.mStartColor = 0;
        this.mCenterColor = 0;
        this.mEndColor = 0;
        this.mInnerColor = -1;
        initialize(context, null, 0);
    }

    private void initialize(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C9086R.styleable.VIResultViewStyle, i, 0);
        try {
            this.mStartColor = typedArrayObtainStyledAttributes.getColor(C9086R.styleable.VIResultViewStyle_vi_startColor, 0);
            this.mCenterColor = typedArrayObtainStyledAttributes.getColor(C9086R.styleable.VIResultViewStyle_vi_centerColor, 0);
            this.mEndColor = typedArrayObtainStyledAttributes.getColor(C9086R.styleable.VIResultViewStyle_vi_endColor, 0);
            float dimension = typedArrayObtainStyledAttributes.getDimension(C9086R.styleable.VIResultViewStyle_vi_strokeWidth, this.mStrokeWidth);
            this.mStrokeWidth = dimension;
            this.mBorderDelta = dimension * 1.5f;
            typedArrayObtainStyledAttributes.recycle();
            this.mBorderRadius = getResources().getDimension(C9086R.dimen.ai_drawing_result_container_radius);
            Paint paint = new Paint();
            this.mBorderStroke = paint;
            paint.setAntiAlias(true);
            this.mBorderStroke.setStyle(Paint.Style.STROKE);
            this.mBorderStroke.setStrokeWidth(this.mStrokeWidth);
            this.mBorderStroke.setMaskFilter(new BlurMaskFilter(this.mStrokeWidth, BlurMaskFilter.Blur.NORMAL));
            this.mBorderMatrix = new Matrix();
            this.mInnerRadius = getResources().getDimension(C9086R.dimen.ai_drawing_content_frame_inner_radius);
            Paint paint2 = new Paint();
            this.mInnerFill = paint2;
            paint2.setAntiAlias(true);
            this.mInnerFill.setStyle(Paint.Style.FILL);
            setVisibility(4);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startGradientAnimation$0(ValueAnimator valueAnimator) {
        this.mBorderRotateAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGradientAnimation() {
        if (this.mRotateAnimator != null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.mRotateAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.mRotateAnimator.setDuration(AiSTTListView.USER_SCROLL_INTERVAL);
        this.mRotateAnimator.setRepeatCount(-1);
        this.mRotateAnimator.addUpdateListener(new C10262a(this, 0));
        this.mRotateAnimator.start();
    }

    public void finalize() throws Throwable {
        ValueAnimator valueAnimator = this.mRotateAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.finalize();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        this.mBorderMatrix.setRotate(this.mBorderRotateAngle, getWidth() >> 1, getHeight() >> 1);
        this.mBorderGradient.setLocalMatrix(this.mBorderMatrix);
        this.mBorderStroke.setShader(this.mBorderGradient);
        canvas.drawPath(this.mBorderPath, this.mBorderStroke);
        this.mInnerFill.setColor(this.mInnerColor);
        canvas.drawPath(this.mInnerPath, this.mInnerFill);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
        float f = this.mBorderDelta;
        float f4 = i;
        float f5 = i2;
        this.mBorderGradient = new LinearGradient(f, f, f4 - f, f5 - f, new int[]{this.mStartColor, this.mCenterColor, this.mEndColor}, (float[]) null, Shader.TileMode.CLAMP);
        RectF rectF = this.mBorderRect;
        float f6 = this.mBorderDelta;
        rectF.set(f6, f6, f4 - f6, f5 - f6);
        this.mBorderPath.reset();
        Path path = this.mBorderPath;
        RectF rectF2 = this.mBorderRect;
        float f7 = this.mBorderRadius;
        Path.Direction direction = Path.Direction.CCW;
        path.addRoundRect(rectF2, f7, f7, direction);
        RectF rectF3 = this.mInnerRect;
        float f8 = this.mStrokeWidth;
        rectF3.set(f8, f8, f4 - f8, f5 - f8);
        this.mInnerPath.reset();
        Path path2 = this.mInnerPath;
        RectF rectF4 = this.mInnerRect;
        float f9 = this.mInnerRadius;
        path2.addRoundRect(rectF4, f9, f9, direction);
    }

    public void setInnerColor(@ColorInt int i) {
        this.mInnerColor = i;
        this.mInnerFill.setColor(i);
    }

    public synchronized void show() {
        AnimatorSet animatorSet = this.mShowAnimator;
        if (animatorSet == null || !animatorSet.isRunning()) {
            setVisibility(4);
            post(new RunnableC102501());
        }
    }

    public void stopGradientAnimation() {
        ValueAnimator valueAnimator = this.mRotateAnimator;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.cancel();
        this.mRotateAnimator = null;
    }

    public AiDrawingContentFrame(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderPath = new Path();
        this.mBorderRect = new RectF();
        this.mBorderRotateAngle = 0.0f;
        this.mInnerPath = new Path();
        this.mInnerRect = new RectF();
        this.mStrokeWidth = 10.0f;
        this.mBorderDelta = 10.0f;
        this.mStartColor = 0;
        this.mCenterColor = 0;
        this.mEndColor = 0;
        this.mInnerColor = -1;
        initialize(context, attributeSet, 0);
    }

    public AiDrawingContentFrame(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderPath = new Path();
        this.mBorderRect = new RectF();
        this.mBorderRotateAngle = 0.0f;
        this.mInnerPath = new Path();
        this.mInnerRect = new RectF();
        this.mStrokeWidth = 10.0f;
        this.mBorderDelta = 10.0f;
        this.mStartColor = 0;
        this.mCenterColor = 0;
        this.mEndColor = 0;
        this.mInnerColor = -1;
        initialize(context, attributeSet, i);
    }
}
