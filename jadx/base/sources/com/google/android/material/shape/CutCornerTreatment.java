package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f4, float f5) {
        shapePath.reset(0.0f, f5 * f4, 180.0f, 180.0f - f);
        double d = f5;
        double d2 = f4;
        shapePath.lineTo((float) (Math.sin(Math.toRadians(f)) * d * d2), (float) (Math.sin(Math.toRadians(90.0f - f)) * d * d2));
    }

    @Deprecated
    public CutCornerTreatment(float f) {
        this.size = f;
    }
}
