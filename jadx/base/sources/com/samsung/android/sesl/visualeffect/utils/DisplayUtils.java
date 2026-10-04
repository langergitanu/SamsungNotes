package com.samsung.android.sesl.visualeffect.utils;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Dimension;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tJ\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/DisplayUtils;", "", "<init>", "()V", "dpToPx", "", "context", "Landroid/content/Context;", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "", "pxToDp", "px", "spToPx", "sp", "screenToViewNormal", "Landroid/graphics/PointF;", "view", "Landroid/view/View;", "screenPos", "Landroid/graphics/Point;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class DisplayUtils {

    @NotNull
    public static final DisplayUtils INSTANCE = new DisplayUtils();

    private DisplayUtils() {
    }

    public final int dpToPx(@NotNull Context context, @Dimension(unit = 0) float dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt.roundToInt(dp * context.getResources().getDisplayMetrics().density);
    }

    public final float pxToDp(@NotNull Context context, float px) {
        Intrinsics.checkNotNullParameter(context, "context");
        return px / context.getResources().getDisplayMetrics().density;
    }

    @NotNull
    public final PointF screenToViewNormal(@NotNull View view, @NotNull Point screenPos) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(screenPos, "screenPos");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Point point = new Point(screenPos.x - iArr[0], screenPos.y - iArr[1]);
        return new PointF(point.x / view.getWidth(), point.y / view.getHeight());
    }

    public final int spToPx(@NotNull Context context, @Dimension(unit = 2) float sp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) TypedValue.applyDimension(2, sp, context.getResources().getDisplayMetrics());
    }
}
