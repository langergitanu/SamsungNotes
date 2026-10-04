package com.samsung.android.app.sdk.deepsky.textextraction.util;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0011\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u001dJ1\u0010\u001e\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010!\u001a\u00020\u0004¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u0015J\u0019\u0010&\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010'J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\n2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000e¢\u0006\u0002\u0010,J\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\nH\u0002¢\u0006\u0002\u0010.R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/PointUtil;", "", "()V", "POLYGON_OVERLAP_THRESHOLD", "", SearchConstants.TargetContents.TAG, "", "calcIntersectionRatio", "", "source", "Landroid/graphics/Rect;", "target", "createEmptyPolygon", "", "Landroid/graphics/Point;", "()[Landroid/graphics/Point;", "createPathFromPoly", "Landroid/graphics/Path;", "poly", "([Landroid/graphics/Point;)Landroid/graphics/Path;", "getRectContainingPoly", "([Landroid/graphics/Point;)Landroid/graphics/Rect;", "isPointBetweenLines", "", "point", "line1", "line2", "(Landroid/graphics/Point;[Landroid/graphics/Point;[Landroid/graphics/Point;)Z", "isPointInsidePoly", "(Landroid/graphics/Point;[Landroid/graphics/Point;)Z", "isPolyOverlapsPoly", "sourcePoly", "targetPoly", "threshold", "([Landroid/graphics/Point;[Landroid/graphics/Point;D)Z", "isVertical", "([Landroid/graphics/Point;)Z", "polyToRect", "polyToString", "([Landroid/graphics/Point;)Ljava/lang/String;", "getRotatedRect", "angle", "", "pivot", "(Landroid/graphics/Rect;ILandroid/graphics/Point;)[Landroid/graphics/Point;", "toPoly", "(Landroid/graphics/Rect;)[Landroid/graphics/Point;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPointUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointUtil.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/util/PointUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,284:1\n1#2:285\n13644#3,3:286\n13579#3,2:289\n1774#4,4:291\n*S KotlinDebug\n*F\n+ 1 PointUtil.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/util/PointUtil\n*L\n73#1:286,3\n191#1:289,2\n233#1:291,4\n*E\n"})
public final class PointUtil {

    @NotNull
    public static final PointUtil INSTANCE = new PointUtil();
    private static final double POLYGON_OVERLAP_THRESHOLD = 0.9d;

    @NotNull
    private static final String TAG = "PointUtil";

    private PointUtil() {
    }

    private final float calcIntersectionRatio(Rect source, Rect target) {
        int i = target.right;
        int i2 = target.left;
        int i4 = ((target.bottom - target.top) + 1) * ((i - i2) + 1);
        int iMax = Math.max(source.left, i2);
        int iMax2 = Math.max(source.top, target.top);
        int iMin = Math.min(source.right, target.right);
        int iMin2 = Math.min(source.bottom, target.bottom);
        return (Math.max(0, (iMin2 - iMax2) + 1) * Math.max(0, (iMin - iMax) + 1)) / i4;
    }

    public static /* synthetic */ boolean isPolyOverlapsPoly$default(PointUtil pointUtil, Point[] pointArr, Point[] pointArr2, double d, int i, Object obj) {
        if ((i & 4) != 0) {
            d = 0.9d;
        }
        return pointUtil.isPolyOverlapsPoly(pointArr, pointArr2, d);
    }

    private final Point[] toPoly(Rect rect) {
        return new Point[]{new Point(rect.left, rect.top), new Point(rect.right, rect.top), new Point(rect.right, rect.bottom), new Point(rect.left, rect.bottom)};
    }

    @NotNull
    public final Point[] createEmptyPolygon() {
        return new Point[]{new Point(), new Point(), new Point(), new Point()};
    }

    @NotNull
    public final Path createPathFromPoly(@NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        Path path = new Path();
        Point point = poly[0];
        path.moveTo(point.x, point.y);
        Point point2 = poly[1];
        path.lineTo(point2.x, point2.y);
        Point point3 = poly[2];
        path.lineTo(point3.x, point3.y);
        Point point4 = poly[3];
        path.lineTo(point4.x, point4.y);
        Point point5 = poly[0];
        path.lineTo(point5.x, point5.y);
        path.close();
        return path;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @NotNull
    public final Rect getRectContainingPoly(@NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        if (poly.length == 0) {
            throw new NoSuchElementException();
        }
        int i = poly[0].x;
        ?? it = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
        while (it.hasNext()) {
            int i2 = poly[it.nextInt()].x;
            if (i > i2) {
                i = i2;
            }
        }
        if (poly.length == 0) {
            throw new NoSuchElementException();
        }
        int i4 = poly[0].y;
        ?? it2 = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
        while (it2.hasNext()) {
            int i5 = poly[it2.nextInt()].y;
            if (i4 > i5) {
                i4 = i5;
            }
        }
        if (poly.length == 0) {
            throw new NoSuchElementException();
        }
        int i6 = poly[0].x;
        ?? it3 = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
        while (it3.hasNext()) {
            int i7 = poly[it3.nextInt()].x;
            if (i6 < i7) {
                i6 = i7;
            }
        }
        if (poly.length == 0) {
            throw new NoSuchElementException();
        }
        int i8 = poly[0].y;
        ?? it4 = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
        while (it4.hasNext()) {
            int i9 = poly[it4.nextInt()].y;
            if (i8 < i9) {
                i8 = i9;
            }
        }
        return new Rect(i, i4, i6, i8);
    }

    @NotNull
    public final Point[] getRotatedRect(@NotNull Rect rect, int i, @NotNull Point pivot) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        Intrinsics.checkNotNullParameter(pivot, "pivot");
        Point[] poly = toPoly(rect);
        double d = ((double) (i / 180.0f)) * 3.141592653589793d;
        for (Point point : poly) {
            double d2 = point.x - pivot.x;
            double d3 = point.y - pivot.y;
            int iCos = (int) ((Math.cos(d) * d2) - (Math.sin(d) * d3));
            int iM2210a = (int) AbstractC2821a.m2210a(d, d3, Math.sin(d) * d2);
            point.x = iCos + pivot.x;
            point.y = iM2210a + pivot.y;
        }
        return poly;
    }

    public final boolean isPointBetweenLines(@NotNull Point point, @NotNull Point[] line1, @NotNull Point[] line2) {
        Point point2;
        int i;
        Point point3;
        int i2;
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(line1, "line1");
        Intrinsics.checkNotNullParameter(line2, "line2");
        Point point4 = line1[0];
        int i4 = point4.x;
        Point point5 = line1[1];
        if (i4 == point5.x || (i = (point2 = line2[0]).x) == (i2 = (point3 = line2[1]).x)) {
            int i5 = line2[0].x;
            int i6 = point.x;
            return (i4 <= i6 && i6 <= i5) || (i5 <= i6 && i6 <= i4);
        }
        int i7 = point5.y;
        float f = (i7 - r12) / (r4 - i4);
        float f4 = ((-f) * i4) + point4.y;
        int i8 = point3.y;
        float f5 = (i8 - r2) / (i2 - i);
        float f6 = ((-f5) * i) + point2.y;
        int i9 = point.x;
        float f7 = (f * i9) + f4;
        float f8 = (f5 * i9) + f6;
        int i10 = point.y;
        float f9 = i10;
        if (f7 > f9 || f9 > f8) {
            float f10 = i10;
            if (f8 > f10 || f10 > f7) {
                return false;
            }
        }
        return true;
    }

    public final boolean isPointInsidePoly(@NotNull Point point, @NotNull Point[] poly) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(poly, "poly");
        int iMin = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        for (Point point2 : poly) {
            iMin = Math.min(point2.x, iMin);
            iMax = Math.max(point2.x, iMax);
            iMin2 = Math.min(point2.y, iMin2);
            iMax2 = Math.max(point2.y, iMax2);
        }
        int i4 = point.x;
        if (i4 >= iMin && i4 <= iMax && (i = point.y) >= iMin2 && i <= iMax2) {
            ArrayList<Point[]> arrayList = new ArrayList();
            int length = poly.length;
            int i5 = 0;
            while (i5 < length) {
                Point point3 = poly[i5];
                i5++;
                arrayList.add(new Point[]{point3, poly[i5 % poly.length]});
            }
            if (arrayList.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 0;
                for (Point[] pointArr : arrayList) {
                    Point point4 = pointArr[0];
                    int i6 = point4.y;
                    int i7 = point.y;
                    boolean z = i6 > i7;
                    Point point5 = pointArr[1];
                    int i8 = point5.y;
                    if (z != (i8 > i7)) {
                        int i9 = point.x;
                        int i10 = point4.x;
                        if (i9 <= (((i7 - i6) * (point5.x - i10)) / (i8 - i6)) + i10 && (i2 = i2 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
            }
            if (i2 % 2 == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean isPolyOverlapsPoly(@NotNull Point[] sourcePoly, @NotNull Point[] targetPoly, double threshold) {
        Intrinsics.checkNotNullParameter(sourcePoly, "sourcePoly");
        Intrinsics.checkNotNullParameter(targetPoly, "targetPoly");
        return ((double) calcIntersectionRatio(polyToRect(sourcePoly), polyToRect(targetPoly))) > threshold;
    }

    public final boolean isVertical(@NotNull Point[] poly) {
        float fAbs;
        Intrinsics.checkNotNullParameter(poly, "poly");
        Point point = poly[0];
        Point point2 = poly[1];
        try {
            fAbs = Math.abs((float) Math.toDegrees(Math.atan2(point2.y - point.y, point2.x - point.x)));
        } catch (NumberFormatException unused) {
            LibLogger.m5430e(TAG, "Negative or Positive Infinity");
            fAbs = 90.0f;
        }
        double d = fAbs;
        return 45.0d <= d && d <= 135.0d;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @NotNull
    public final Rect polyToRect(@NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        if (poly.length == 0) {
            throw new NoSuchElementException();
        }
        int i = poly[0].x;
        ?? it = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
        while (it.hasNext()) {
            int i2 = poly[it.nextInt()].x;
            if (i > i2) {
                i = i2;
            }
        }
        if (poly.length == 0) {
            throw new NoSuchElementException();
        }
        int i4 = poly[0].y;
        ?? it2 = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
        while (it2.hasNext()) {
            int i5 = poly[it2.nextInt()].y;
            if (i4 > i5) {
                i4 = i5;
            }
        }
        if (poly.length == 0) {
            throw new NoSuchElementException();
        }
        int i6 = poly[0].x;
        ?? it3 = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
        while (it3.hasNext()) {
            int i7 = poly[it3.nextInt()].x;
            if (i6 < i7) {
                i6 = i7;
            }
        }
        if (poly.length == 0) {
            throw new NoSuchElementException();
        }
        int i8 = poly[0].y;
        ?? it4 = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
        while (it4.hasNext()) {
            int i9 = poly[it4.nextInt()].y;
            if (i8 < i9) {
                i8 = i9;
            }
        }
        return new Rect(i, i4, i6, i8);
    }

    @NotNull
    public final String polyToString(@NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        StringBuilder sb = new StringBuilder();
        int length = poly.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Point point = poly[i];
            int i4 = i2 + 1;
            sb.append(AbstractC0622a.m1164j(point.x, point.y, "(", SQLKeyword.COMMA, ")"));
            if (i2 != poly.length - 1) {
                sb.append(SQLKeyword.COMMA);
            }
            i++;
            i2 = i4;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}
