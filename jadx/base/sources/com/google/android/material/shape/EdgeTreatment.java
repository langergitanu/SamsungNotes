package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f, float f4, @NonNull ShapePath shapePath) {
        getEdgePath(f, f / 2.0f, f4, shapePath);
    }

    public void getEdgePath(float f, float f4, float f5, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }
}
