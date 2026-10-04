package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.utils.DropShadow;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface DrawingContent extends Content {
    void draw(Canvas canvas, Matrix matrix, int i, @Nullable DropShadow dropShadow);

    void getBounds(RectF rectF, Matrix matrix, boolean z);
}
