package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f4, float f5) {
        this.fabMargin = f;
        this.roundedCornerRadius = f4;
        setCradleVerticalOffset(f5);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f4, float f5, @NonNull ShapePath shapePath) {
        float f6;
        float f7;
        float f8 = this.fabDiameter;
        if (f8 == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f9 = ((this.fabMargin * 2.0f) + f8) / 2.0f;
        float f10 = f5 * this.roundedCornerRadius;
        float f11 = f4 + this.horizontalOffset;
        float fM29z = AbstractC0000a.m29z(1.0f, f5, f9, this.cradleVerticalOffset * f5);
        if (fM29z / f9 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f12 = this.fabCornerSize;
        float f13 = f12 * f5;
        boolean z = f12 == -1.0f || Math.abs((f12 * 2.0f) - f8) < 0.1f;
        if (z) {
            f6 = fM29z;
            f7 = 0.0f;
        } else {
            f7 = ROUNDED_CORNER_FAB_OFFSET;
            f6 = 0.0f;
        }
        float f14 = f9 + f10;
        float f15 = f6 + f10;
        float fSqrt = (float) Math.sqrt((f14 * f14) - (f15 * f15));
        float f16 = f11 - fSqrt;
        float f17 = f11 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f15));
        float f18 = (90.0f - degrees) + f7;
        shapePath.lineTo(f16, 0.0f);
        float f19 = f16 - f10;
        float f20 = f16 + f10;
        float f21 = f10 * 2.0f;
        shapePath.addArc(f19, 0.0f, f20, f21, 270.0f, degrees);
        if (z) {
            shapePath.addArc(f11 - f9, (-f9) - f6, f11 + f9, f9 - f6, 180.0f - f18, (f18 * 2.0f) - 180.0f);
        } else {
            float f22 = this.fabMargin;
            float f23 = f13 * 2.0f;
            float f24 = f22 + f23;
            float f25 = f11 - f9;
            shapePath.addArc(f25, -(f13 + f22), f24 + f25, f22 + f13, 180.0f - f18, ((f18 * 2.0f) - 180.0f) / 2.0f);
            float f26 = f11 + f9;
            float f27 = this.fabMargin;
            shapePath.lineTo(f26 - ((f27 / 2.0f) + f13), f27 + f13);
            float f28 = this.fabMargin;
            shapePath.addArc(f26 - (f23 + f28), -(f13 + f28), f26, f28 + f13, 90.0f, f18 - 90.0f);
        }
        shapePath.addArc(f17 - f10, 0.0f, f17 + f10, f21, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.cradleVerticalOffset = f;
    }

    public void setFabCornerSize(float f) {
        this.fabCornerSize = f;
    }

    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }
}
