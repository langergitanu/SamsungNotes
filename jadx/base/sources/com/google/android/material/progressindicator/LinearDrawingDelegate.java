package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.collection.ScatterMapKt;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    @FloatRange(from = 0.0d, m705to = 1.0d)
    private float totalTrackLengthFraction;
    private float trackLength;
    private boolean useStrokeCap;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.trackLength = 300.0f;
    }

    private void drawLine(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, @ColorInt int i, @Px int i2, @Px int i4) {
        float f5;
        float fClamp = MathUtils.clamp(f, 0.0f, 1.0f);
        float fClamp2 = MathUtils.clamp(f4, 0.0f, 1.0f);
        float fLerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, fClamp);
        float fLerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, fClamp2);
        int iClamp = (int) ((MathUtils.clamp(fLerp, 0.0f, 0.01f) * i2) / 0.01f);
        float fClamp3 = 1.0f - MathUtils.clamp(fLerp2, 0.99f, 1.0f);
        float f6 = this.trackLength;
        int i5 = (int) ((fLerp * f6) + iClamp);
        int i6 = (int) ((fLerp2 * f6) - ((int) ((fClamp3 * i4) / 0.01f)));
        float f7 = (-f6) / 2.0f;
        if (i5 <= i6) {
            float f8 = this.displayedCornerRadius;
            float f9 = i5 + f8;
            float f10 = i6 - f8;
            float f11 = f8 * 2.0f;
            paint.setColor(i);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            if (f9 >= f10) {
                drawRoundedBlock(canvas, paint, new PointF(f9 + f7, 0.0f), new PointF(f10 + f7, 0.0f), f11, this.displayedTrackThickness);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.useStrokeCap ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f12 = f9 + f7;
            float f13 = f10 + f7;
            canvas.drawLine(f12, 0.0f, f13, 0.0f, paint);
            if (this.useStrokeCap || this.displayedCornerRadius <= 0.0f) {
                return;
            }
            paint.setStyle(Paint.Style.FILL);
            if (f9 > 0.0f) {
                f5 = f11;
                drawRoundedBlock(canvas, paint, new PointF(f12, 0.0f), f5, this.displayedTrackThickness);
            } else {
                f5 = f11;
            }
            if (f10 < this.trackLength) {
                drawRoundedBlock(canvas, paint, new PointF(f13, 0.0f), f5, this.displayedTrackThickness);
            }
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, float f, float f4) {
        drawRoundedBlock(canvas, paint, pointF, null, f, f4);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, m705to = 1.0d) float f, boolean z, boolean z2) {
        this.trackLength = rect.width();
        float f4 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate((rect.width() / 2.0f) + rect.left, Math.max(0.0f, (rect.height() - f4) / 2.0f) + (rect.height() / 2.0f) + rect.top);
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f5 = this.trackLength / 2.0f;
        float f6 = f4 / 2.0f;
        canvas.clipRect(-f5, -f6, f5, f6);
        S s = this.spec;
        this.useStrokeCap = ((LinearProgressIndicatorSpec) s).trackThickness / 2 == ((LinearProgressIndicatorSpec) s).trackCornerRadius;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) s).trackThickness * f;
        this.displayedCornerRadius = Math.min(((LinearProgressIndicatorSpec) s).trackThickness / 2, ((LinearProgressIndicatorSpec) s).trackCornerRadius) * f;
        if (z || z2) {
            if ((z && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, ((1.0f - f) * ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f);
            }
        }
        if (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i2) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i2);
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize <= 0 || iCompositeARGBWithAlpha == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iCompositeARGBWithAlpha);
        PointF pointF = new PointF((this.trackLength / 2.0f) - (this.displayedTrackThickness / 2.0f), 0.0f);
        S s = this.spec;
        drawRoundedBlock(canvas, paint, pointF, ((LinearProgressIndicatorSpec) s).trackStopIndicatorSize, ((LinearProgressIndicatorSpec) s).trackStopIndicatorSize);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, int i) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i);
        float f = activeIndicator.startFraction;
        float f4 = activeIndicator.endFraction;
        int i2 = activeIndicator.gapSize;
        drawLine(canvas, paint, f, f4, iCompositeARGBWithAlpha, i2, i2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, int i, int i2, @Px int i4) {
        drawLine(canvas, paint, f, f4, MaterialColors.compositeARGBWithAlpha(i, i2), i4, i4);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, @Nullable PointF pointF2, float f, float f4) {
        float fMin = Math.min(f4, this.displayedTrackThickness);
        float f5 = f / 2.0f;
        float fMin2 = Math.min(f5, (this.displayedCornerRadius * fMin) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f) / 2.0f, (-fMin) / 2.0f, f5, fMin / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, fMin2, fMin2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }
}
