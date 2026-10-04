package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f4, float f5, @NonNull ShapePath shapePath) {
        if (!this.inside) {
            float f6 = this.size;
            shapePath.lineTo(f4 - (f6 * f5), 0.0f, f4, (-f6) * f5);
            shapePath.lineTo((this.size * f5) + f4, 0.0f, f, 0.0f);
        } else {
            shapePath.lineTo(f4 - (this.size * f5), 0.0f);
            float f7 = this.size;
            shapePath.lineTo(f4, f7 * f5, (f7 * f5) + f4, 0.0f);
            shapePath.lineTo(f, 0.0f);
        }
    }
}
