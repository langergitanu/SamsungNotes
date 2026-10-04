package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.collection.ScatterMapKt;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    @FloatRange(from = 0.0d, m705to = 1.0d)
    private float totalTrackLengthFraction;
    private boolean useStrokeCap;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void drawArc(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, @ColorInt int i, @Px int i2, @Px int i4) {
        float f5 = f4 >= f ? f4 - f : (f4 + 1.0f) - f;
        float f6 = f % 1.0f;
        if (this.totalTrackLengthFraction < 1.0f) {
            float f7 = f6 + f5;
            if (f7 > 1.0f) {
                drawArc(canvas, paint, f6, 1.0f, i, i2, 0);
                drawArc(canvas, paint, 1.0f, f7, i, 0, i4);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
        if (f6 == 0.0f && f5 >= 0.99f) {
            f5 += (((degrees * 2.0f) / 360.0f) * (f5 - 0.99f)) / 0.01f;
        }
        float fLerp = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f6);
        float fLerp2 = MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f5);
        float degrees2 = (float) Math.toDegrees(i2 / this.adjustedRadius);
        float degrees3 = ((fLerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i4 / this.adjustedRadius));
        float f8 = (fLerp * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f9 = degrees * 2.0f;
        if (degrees3 < f9) {
            float f10 = degrees3 / f9;
            paint.setStyle(Paint.Style.FILL);
            drawRoundedBlock(canvas, paint, (degrees * f10) + f8, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness, f10);
            return;
        }
        float f11 = this.adjustedRadius;
        RectF rectF = new RectF(-f11, -f11, f11, f11);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.useStrokeCap ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f12 = f8 + degrees;
        canvas.drawArc(rectF, f12, degrees3 - f9, false, paint);
        if (this.useStrokeCap || this.displayedCornerRadius <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        drawRoundedBlock(canvas, paint, f12, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
        drawRoundedBlock(canvas, paint, (f8 + degrees3) - degrees, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, float f5) {
        drawRoundedBlock(canvas, paint, f, f4, f5, 1.0f);
    }

    private int getSize() {
        S s = this.spec;
        return (((CircularProgressIndicatorSpec) s).indicatorInset * 2) + ((CircularProgressIndicatorSpec) s).indicatorSize;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, m705to = 1.0d) float f, boolean z, boolean z2) {
        float fWidth = rect.width() / getPreferredWidth();
        float fHeight = rect.height() / getPreferredHeight();
        S s = this.spec;
        float f4 = (((CircularProgressIndicatorSpec) s).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s).indicatorInset;
        canvas.translate((f4 * fWidth) + rect.left, (f4 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f5 = -f4;
        canvas.clipRect(f5, f5, f4, f4);
        S s2 = this.spec;
        this.useStrokeCap = ((CircularProgressIndicatorSpec) s2).trackThickness / 2 <= ((CircularProgressIndicatorSpec) s2).trackCornerRadius;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) s2).trackThickness * f;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) s2).trackThickness / 2, ((CircularProgressIndicatorSpec) s2).trackCornerRadius) * f;
        S s3 = this.spec;
        float f6 = (((CircularProgressIndicatorSpec) s3).indicatorSize - ((CircularProgressIndicatorSpec) s3).trackThickness) / 2.0f;
        this.adjustedRadius = f6;
        if (z || z2) {
            if ((z && ((CircularProgressIndicatorSpec) s3).showAnimationBehavior == 2) || (z2 && ((CircularProgressIndicatorSpec) s3).hideAnimationBehavior == 1)) {
                this.adjustedRadius = (((1.0f - f) * ((CircularProgressIndicatorSpec) s3).trackThickness) / 2.0f) + f6;
            } else if ((z && ((CircularProgressIndicatorSpec) s3).showAnimationBehavior == 1) || (z2 && ((CircularProgressIndicatorSpec) s3).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f6 - (((1.0f - f) * ((CircularProgressIndicatorSpec) s3).trackThickness) / 2.0f);
            }
        }
        if (z2 && ((CircularProgressIndicatorSpec) s3).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i);
        float f = activeIndicator.startFraction;
        float f4 = activeIndicator.endFraction;
        int i2 = activeIndicator.gapSize;
        drawArc(canvas, paint, f, f4, iCompositeARGBWithAlpha, i2, i2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, @ColorInt int i, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i2, int i4) {
        drawArc(canvas, paint, f, f4, MaterialColors.compositeARGBWithAlpha(i, i2), i4, i4);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, float f5, float f6) {
        float fMin = (int) Math.min(f5, this.displayedTrackThickness);
        float f7 = f4 / 2.0f;
        float fMin2 = Math.min(f7, (this.displayedCornerRadius * fMin) / this.displayedTrackThickness);
        RectF rectF = new RectF((-fMin) / 2.0f, (-f4) / 2.0f, fMin / 2.0f, f7);
        canvas.save();
        double d = f;
        canvas.translate((float) (Math.cos(Math.toRadians(d)) * ((double) this.adjustedRadius)), (float) (Math.sin(Math.toRadians(d)) * ((double) this.adjustedRadius)));
        canvas.rotate(f);
        canvas.scale(f6, f6);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i2) {
    }
}
