package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(21)
public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f, float f4, float f5, float f6) {
        return f4 > f6 ? new PointF(f5, f4) : new PointF(f, f6);
    }

    @Override // android.transition.PathMotion
    @NonNull
    public Path getPath(float f, float f4, float f5, float f6) {
        Path path = new Path();
        path.moveTo(f, f4);
        PointF controlPoint = getControlPoint(f, f4, f5, f6);
        path.quadTo(controlPoint.x, controlPoint.y, f5, f6);
        return path;
    }
}
