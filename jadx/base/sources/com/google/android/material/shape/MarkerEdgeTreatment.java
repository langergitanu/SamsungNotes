package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f) {
        this.radius = f - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f4, float f5, @NonNull ShapePath shapePath) {
        float fSqrt = (float) ((Math.sqrt(2.0d) * ((double) this.radius)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(fSqrt, 2.0d));
        shapePath.reset(f4 - fSqrt, ((float) (-((Math.sqrt(2.0d) * ((double) this.radius)) - ((double) this.radius)))) + fSqrt2);
        shapePath.lineTo(f4, (float) (-((Math.sqrt(2.0d) * ((double) this.radius)) - ((double) this.radius))));
        shapePath.lineTo(f4 + fSqrt, ((float) (-((Math.sqrt(2.0d) * ((double) this.radius)) - ((double) this.radius)))) + fSqrt2);
    }
}
