package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f4, float f5) {
        shapePath.reset(0.0f, f5 * f4, 180.0f, 180.0f - f);
        float f6 = f5 * 2.0f * f4;
        shapePath.addArc(0.0f, 0.0f, f6, f6, 180.0f, f);
    }

    @Deprecated
    public RoundedCornerTreatment(float f) {
        this.radius = f;
    }
}
