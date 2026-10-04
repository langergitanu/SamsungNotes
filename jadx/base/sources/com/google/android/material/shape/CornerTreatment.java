package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f, float f4, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f4, float f5) {
        getCornerPath(f, f4, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f4, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f, f4, cornerSize.getCornerSize(rectF));
    }
}
