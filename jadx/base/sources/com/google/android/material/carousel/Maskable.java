package com.google.android.material.carousel;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
interface Maskable {
    @NonNull
    RectF getMaskRectF();

    @FloatRange(from = 0.0d, m705to = 1.0d)
    @Deprecated
    float getMaskXPercentage();

    void setMaskRectF(@NonNull RectF rectF);

    @Deprecated
    void setMaskXPercentage(@FloatRange(from = 0.0d, m705to = 1.0d) float f);

    void setOnMaskChangedListener(@Nullable OnMaskChangedListener onMaskChangedListener);
}
