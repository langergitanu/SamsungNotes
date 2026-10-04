package com.google.android.material.elevation;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import com.google.android.material.C4548R;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public enum SurfaceColors {
    SURFACE_0(C4548R.dimen.m3_sys_elevation_level0),
    SURFACE_1(C4548R.dimen.m3_sys_elevation_level1),
    SURFACE_2(C4548R.dimen.m3_sys_elevation_level2),
    SURFACE_3(C4548R.dimen.m3_sys_elevation_level3),
    SURFACE_4(C4548R.dimen.m3_sys_elevation_level4),
    SURFACE_5(C4548R.dimen.m3_sys_elevation_level5);

    private final int elevationResId;

    SurfaceColors(@DimenRes int i) {
        this.elevationResId = i;
    }

    @ColorInt
    public static int getColorForElevation(@NonNull Context context, @Dimension float f) {
        return new ElevationOverlayProvider(context).compositeOverlay(MaterialColors.getColor(context, C4548R.attr.colorSurface, 0), f);
    }

    @ColorInt
    public int getColor(@NonNull Context context) {
        return getColorForElevation(context, context.getResources().getDimension(this.elevationResId));
    }
}
