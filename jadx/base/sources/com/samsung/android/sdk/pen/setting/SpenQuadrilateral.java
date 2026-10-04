package com.samsung.android.sdk.pen.setting;

import android.graphics.Point;
import android.graphics.Rect;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenQuadrilateral;", "", "points", "", "Landroid/graphics/Point;", "<init>", "([Landroid/graphics/Point;)V", "mLeftSlope", "", "mLeftAlpha", "mRightSlope", "mRightAlpha", "mRect", "Landroid/graphics/Rect;", "isRectangle", "", "isContains", LangPackConfigConstants.LANGUAGE_CODE_PT, "getOverlapArea", "", "another", "getSlope", "top", "bottom", "getAlpha", "slope", "comparePosition", "alpha", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenQuadrilateral {
    private float mLeftAlpha;
    private float mLeftSlope;

    @Nullable
    private Rect mRect;
    private float mRightAlpha;
    private float mRightSlope;

    public SpenQuadrilateral(@NotNull Point... points) {
        Intrinsics.checkNotNullParameter(points, "points");
        if (points.length == 4) {
            Point point = points[0];
            Point point2 = points[1];
            Point point3 = points[2];
            Point point4 = points[3];
            float slope = getSlope(point, point3);
            this.mLeftSlope = slope;
            this.mLeftAlpha = getAlpha(slope, point);
            float slope2 = getSlope(point2, point4);
            this.mRightSlope = slope2;
            this.mRightAlpha = getAlpha(slope2, point2);
            this.mRect = new Rect(point.x, point.y, point4.x, point4.y);
        }
    }

    private final int comparePosition(float slope, float alpha, Point pt) {
        return (int) Math.signum((((pt.x * slope) + alpha) - pt.y) * slope);
    }

    private final float getAlpha(float slope, Point top) {
        return (-(slope * top.x)) + top.y;
    }

    private final float getSlope(Point top, Point bottom) {
        if (top.x == bottom.x) {
            return 0.0f;
        }
        return (bottom.y - top.y) / (r1 - r0);
    }

    public final int getOverlapArea(@NotNull Rect another) {
        Intrinsics.checkNotNullParameter(another, "another");
        if (!isRectangle()) {
            return 0;
        }
        Rect rect = new Rect();
        Rect rect2 = this.mRect;
        if (rect2 != null && !rect.setIntersect(rect2, another)) {
            return 0;
        }
        return rect.height() * rect.width();
    }

    public final boolean isContains(@NotNull Point pt) {
        Intrinsics.checkNotNullParameter(pt, "pt");
        if (isRectangle()) {
            Rect rect = this.mRect;
            return rect != null && rect.contains(pt.x, pt.y);
        }
        float f = this.mLeftSlope;
        if (f != 0.0f && comparePosition(f, this.mLeftAlpha, pt) < 0) {
            return false;
        }
        float f4 = this.mRightSlope;
        return f4 == 0.0f || comparePosition(f4, this.mRightAlpha, pt) <= 0;
    }

    public final boolean isRectangle() {
        return this.mLeftSlope == 0.0f && this.mRightSlope == 0.0f;
    }
}
