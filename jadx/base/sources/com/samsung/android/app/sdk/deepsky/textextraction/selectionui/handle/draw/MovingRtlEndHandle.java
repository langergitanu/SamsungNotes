package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.RotateDrawable;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.VectorUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\bH\u0016¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/draw/MovingRtlEndHandle;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/draw/HandleDrawStrategy;", "()V", "getDefaultRect", "Landroid/graphics/Rect;", "handleDrawInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/draw/HandleDrawInfo;", "drawableWidth", "", "drawableHeight", "getDefaultRectForAnimation", "getRotateDrawable", "Landroid/graphics/drawable/RotateDrawable;", "context", "Landroid/content/Context;", "color", "getRotatedDefaultRect", "", "Landroid/graphics/Point;", "angle", "defaultRect", "(ILandroid/graphics/Rect;)[Landroid/graphics/Point;", "getShadowDrawable", "getTouchableAreaRect", "drawAreaRect", "touchableArea", "rotationAngle", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class MovingRtlEndHandle implements HandleDrawStrategy {
    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawStrategy
    @NotNull
    public Rect getDefaultRect(@NotNull HandleDrawInfo handleDrawInfo, int drawableWidth, int drawableHeight) {
        Intrinsics.checkNotNullParameter(handleDrawInfo, "handleDrawInfo");
        Point pointCalcBoundedPoint = VectorUtil.INSTANCE.calcBoundedPoint(handleDrawInfo.getTouchPoint(), handleDrawInfo.getBoundingRect());
        int i = pointCalcBoundedPoint.x;
        int i2 = pointCalcBoundedPoint.y;
        return new Rect(i - drawableWidth, i2, i, drawableHeight + i2);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawStrategy
    @NotNull
    public Rect getDefaultRectForAnimation(@NotNull HandleDrawInfo handleDrawInfo, int drawableWidth, int drawableHeight) {
        Intrinsics.checkNotNullParameter(handleDrawInfo, "handleDrawInfo");
        return getDefaultRect(handleDrawInfo, drawableWidth, drawableHeight);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawStrategy
    @NotNull
    public RotateDrawable getRotateDrawable(@NotNull Context context, int color) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DrawUtil.INSTANCE.createLeftHandleDrawable(context, color);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawStrategy
    @NotNull
    public Point[] getRotatedDefaultRect(int angle, @NotNull Rect defaultRect) {
        Intrinsics.checkNotNullParameter(defaultRect, "defaultRect");
        return PointUtil.INSTANCE.getRotatedRect(defaultRect, angle, new Point(defaultRect.right, defaultRect.top));
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawStrategy
    @NotNull
    public RotateDrawable getShadowDrawable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DrawUtil.INSTANCE.createLeftHandleShadowDrawable(context);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawStrategy
    @NotNull
    public Rect getTouchableAreaRect(@NotNull Rect drawAreaRect, @NotNull Rect touchableArea, int rotationAngle) {
        Intrinsics.checkNotNullParameter(drawAreaRect, "drawAreaRect");
        Intrinsics.checkNotNullParameter(touchableArea, "touchableArea");
        PointUtil pointUtil = PointUtil.INSTANCE;
        return pointUtil.getRectContainingPoly(pointUtil.getRotatedRect(touchableArea, rotationAngle, new Point(drawAreaRect.right, drawAreaRect.top)));
    }
}
