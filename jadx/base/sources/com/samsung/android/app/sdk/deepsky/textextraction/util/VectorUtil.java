package com.samsung.android.app.sdk.deepsky.textextraction.util;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\r2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0010J#\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J!\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0014J!\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0014J)\u0010\u001c\u001a\u0004\u0018\u00010\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0002J-\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0004J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0007H\u0002J!\u0010.\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0014J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0016\u00100\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007J!\u00101\u001a\u0002022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u00103\u001a\u00020\u0012¢\u0006\u0002\u00104¨\u00065"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/VectorUtil;", "", "()V", "calcAngleBetweenLines", "", "line0", "", "Landroid/graphics/Point;", "line1", "([Landroid/graphics/Point;[Landroid/graphics/Point;)I", "calcBoundedPoint", "point", "boundingRect", "Landroid/graphics/Rect;", "calcBoundingRect", "polyList", "", "calcDistanceFromPointToLine", "", "line", "(Landroid/graphics/Point;[Landroid/graphics/Point;)F", "calcDistanceFromPointToLineSegment", "calcDistanceFromPointToPoint", "point1", "point2", "calcDistanceFromPointToPoly", "poly", "calcHorizontalDistanceFromPointToPoly", "calcIntersectionOfLines", "([Landroid/graphics/Point;[Landroid/graphics/Point;)Landroid/graphics/Point;", "calcLocation", "o", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE, "Landroid/graphics/PointF;", "mag", "calcMinAreaPoly", Constants.MessagePayloadKeys.FROM, "to", "([Landroid/graphics/Point;[Landroid/graphics/Point;)[Landroid/graphics/Point;", "calcRectWithMargin", "rect", "margin", "calcUnitVector", VPathDataCmd.RCurveTo, "calcVector", "calcVectorMag", "calcVerticalDistanceFromPointToPoly", "dotOperation", "getRotationDegree", "isTilted", "", "threshold", "([Landroid/graphics/Point;F)Z", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVectorUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VectorUtil.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/util/VectorUtil\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n37#2,2:303\n1#3:305\n*S KotlinDebug\n*F\n+ 1 VectorUtil.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/util/VectorUtil\n*L\n127#1:303,2\n*E\n"})
public final class VectorUtil {

    @NotNull
    public static final VectorUtil INSTANCE = new VectorUtil();

    private VectorUtil() {
    }

    private final float calcDistanceFromPointToLine(Point point, Point[] line) {
        Point point2 = line[0];
        Point point3 = line[1];
        float f = point2.y - point3.y;
        return Math.abs(((point.y * (point3.x - point2.x)) + (point.x * f)) + ((r0 * r2) - (r7 * r1))) / ((float) Math.sqrt((r4 * r4) + (f * f)));
    }

    private final float calcDistanceFromPointToLineSegment(Point point, Point[] line) {
        Point point2 = line[0];
        Point point3 = line[1];
        Point pointCalcVector = calcVector(point2, point3);
        Point pointCalcVector2 = calcVector(point2, point);
        Point pointCalcVector3 = calcVector(point3, point);
        float fDotOperation = dotOperation(pointCalcVector, pointCalcVector2) / ((float) Math.pow(calcVectorMag(pointCalcVector), 2));
        return fDotOperation < 0.0f ? calcVectorMag(pointCalcVector2) : fDotOperation > 1.0f ? calcVectorMag(pointCalcVector3) : (float) Math.sqrt(((float) Math.pow(calcVectorMag(pointCalcVector2), r4)) - ((float) Math.pow(fDotOperation * calcVectorMag(pointCalcVector), r4)));
    }

    private final Point calcLocation(Point o, PointF u, float mag) {
        return new Point(o.x + ((int) ((u.x * mag) + 0.5f)), o.y + ((int) ((mag * u.y) + 0.5f)));
    }

    private final PointF calcUnitVector(Point v) {
        float fCalcVectorMag = calcVectorMag(v);
        return new PointF(v.x / fCalcVectorMag, v.y / fCalcVectorMag);
    }

    private final Point calcVector(Point from, Point to) {
        return new Point(to.x - from.x, to.y - from.y);
    }

    private final float calcVectorMag(Point v) {
        int i = v.x;
        int i2 = v.y;
        return (float) Math.sqrt((i2 * i2) + (i * i));
    }

    private final float dotOperation(PointF u, Point v) {
        return (u.y * v.y) + (u.x * v.x);
    }

    public final int calcAngleBetweenLines(@NotNull Point[] line0, @NotNull Point[] line1) {
        Intrinsics.checkNotNullParameter(line0, "line0");
        Intrinsics.checkNotNullParameter(line1, "line1");
        Point pointCalcVector = calcVector(line0[0], line0[1]);
        Point pointCalcVector2 = calcVector(line1[0], line1[1]);
        return (int) Math.toDegrees(Math.acos(dotOperation(pointCalcVector, pointCalcVector2) / (calcVectorMag(pointCalcVector) * calcVectorMag(pointCalcVector2))));
    }

    @NotNull
    public final Point calcBoundedPoint(@NotNull Point point, @NotNull Rect boundingRect) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(boundingRect, "boundingRect");
        return new Point(Math.min(boundingRect.right, Math.max(boundingRect.left, point.x)), Math.min(boundingRect.bottom, Math.max(boundingRect.top, point.y)));
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r8v28, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @NotNull
    public final Rect calcBoundingRect(@NotNull List<Point[]> polyList) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        Integer numValueOf4;
        Integer numValueOf5;
        Integer numValueOf6;
        Integer numValueOf7;
        Integer numValueOf8;
        Integer numValueOf9;
        Integer numValueOf10;
        Integer numValueOf11;
        Intrinsics.checkNotNullParameter(polyList, "polyList");
        List<Point[]> list = polyList;
        Iterator<T> it = list.iterator();
        Integer num = null;
        if (it.hasNext()) {
            Point[] pointArr = (Point[]) it.next();
            if (pointArr.length == 0) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(pointArr[0].x);
                ?? it2 = new IntRange(1, ArraysKt.getLastIndex(pointArr)).iterator();
                while (it2.hasNext()) {
                    Integer numValueOf12 = Integer.valueOf(pointArr[it2.nextInt()].x);
                    if (numValueOf.compareTo(numValueOf12) > 0) {
                        numValueOf = numValueOf12;
                    }
                }
            }
            numValueOf2 = Integer.valueOf(numValueOf != null ? numValueOf.intValue() : 0);
            while (it.hasNext()) {
                Point[] pointArr2 = (Point[]) it.next();
                if (pointArr2.length == 0) {
                    numValueOf3 = null;
                } else {
                    numValueOf3 = Integer.valueOf(pointArr2[0].x);
                    ?? it3 = new IntRange(1, ArraysKt.getLastIndex(pointArr2)).iterator();
                    while (it3.hasNext()) {
                        Integer numValueOf13 = Integer.valueOf(pointArr2[it3.nextInt()].x);
                        if (numValueOf3.compareTo(numValueOf13) > 0) {
                            numValueOf3 = numValueOf13;
                        }
                    }
                }
                Integer numValueOf14 = Integer.valueOf(numValueOf3 != null ? numValueOf3.intValue() : 0);
                if (numValueOf2.compareTo(numValueOf14) > 0) {
                    numValueOf2 = numValueOf14;
                }
            }
        } else {
            numValueOf2 = null;
        }
        int iIntValue = numValueOf2 != null ? numValueOf2.intValue() : 0;
        Iterator<T> it4 = list.iterator();
        if (it4.hasNext()) {
            Point[] pointArr3 = (Point[]) it4.next();
            if (pointArr3.length == 0) {
                numValueOf4 = null;
            } else {
                numValueOf4 = Integer.valueOf(pointArr3[0].y);
                ?? it5 = new IntRange(1, ArraysKt.getLastIndex(pointArr3)).iterator();
                while (it5.hasNext()) {
                    Integer numValueOf15 = Integer.valueOf(pointArr3[it5.nextInt()].y);
                    if (numValueOf4.compareTo(numValueOf15) > 0) {
                        numValueOf4 = numValueOf15;
                    }
                }
            }
            numValueOf5 = Integer.valueOf(numValueOf4 != null ? numValueOf4.intValue() : 0);
            while (it4.hasNext()) {
                Point[] pointArr4 = (Point[]) it4.next();
                if (pointArr4.length == 0) {
                    numValueOf6 = null;
                } else {
                    numValueOf6 = Integer.valueOf(pointArr4[0].y);
                    ?? it6 = new IntRange(1, ArraysKt.getLastIndex(pointArr4)).iterator();
                    while (it6.hasNext()) {
                        Integer numValueOf16 = Integer.valueOf(pointArr4[it6.nextInt()].y);
                        if (numValueOf6.compareTo(numValueOf16) > 0) {
                            numValueOf6 = numValueOf16;
                        }
                    }
                }
                Integer numValueOf17 = Integer.valueOf(numValueOf6 != null ? numValueOf6.intValue() : 0);
                if (numValueOf5.compareTo(numValueOf17) > 0) {
                    numValueOf5 = numValueOf17;
                }
            }
        } else {
            numValueOf5 = null;
        }
        int iIntValue2 = numValueOf5 != null ? numValueOf5.intValue() : 0;
        Iterator<T> it7 = list.iterator();
        if (it7.hasNext()) {
            Point[] pointArr5 = (Point[]) it7.next();
            if (pointArr5.length == 0) {
                numValueOf7 = null;
            } else {
                numValueOf7 = Integer.valueOf(pointArr5[0].x);
                ?? it8 = new IntRange(1, ArraysKt.getLastIndex(pointArr5)).iterator();
                while (it8.hasNext()) {
                    Integer numValueOf18 = Integer.valueOf(pointArr5[it8.nextInt()].x);
                    if (numValueOf7.compareTo(numValueOf18) < 0) {
                        numValueOf7 = numValueOf18;
                    }
                }
            }
            numValueOf8 = Integer.valueOf(numValueOf7 != null ? numValueOf7.intValue() : 0);
            while (it7.hasNext()) {
                Point[] pointArr6 = (Point[]) it7.next();
                if (pointArr6.length == 0) {
                    numValueOf9 = null;
                } else {
                    numValueOf9 = Integer.valueOf(pointArr6[0].x);
                    ?? it9 = new IntRange(1, ArraysKt.getLastIndex(pointArr6)).iterator();
                    while (it9.hasNext()) {
                        Integer numValueOf19 = Integer.valueOf(pointArr6[it9.nextInt()].x);
                        if (numValueOf9.compareTo(numValueOf19) < 0) {
                            numValueOf9 = numValueOf19;
                        }
                    }
                }
                Integer numValueOf20 = Integer.valueOf(numValueOf9 != null ? numValueOf9.intValue() : 0);
                if (numValueOf8.compareTo(numValueOf20) < 0) {
                    numValueOf8 = numValueOf20;
                }
            }
        } else {
            numValueOf8 = null;
        }
        int iIntValue3 = numValueOf8 != null ? numValueOf8.intValue() : 0;
        Iterator<T> it10 = list.iterator();
        if (it10.hasNext()) {
            Point[] pointArr7 = (Point[]) it10.next();
            if (pointArr7.length == 0) {
                numValueOf10 = null;
            } else {
                numValueOf10 = Integer.valueOf(pointArr7[0].y);
                ?? it11 = new IntRange(1, ArraysKt.getLastIndex(pointArr7)).iterator();
                while (it11.hasNext()) {
                    Integer numValueOf21 = Integer.valueOf(pointArr7[it11.nextInt()].y);
                    if (numValueOf10.compareTo(numValueOf21) < 0) {
                        numValueOf10 = numValueOf21;
                    }
                }
            }
            Integer numValueOf22 = Integer.valueOf(numValueOf10 != null ? numValueOf10.intValue() : 0);
            while (it10.hasNext()) {
                Point[] pointArr8 = (Point[]) it10.next();
                if (pointArr8.length == 0) {
                    numValueOf11 = null;
                } else {
                    numValueOf11 = Integer.valueOf(pointArr8[0].y);
                    ?? it12 = new IntRange(1, ArraysKt.getLastIndex(pointArr8)).iterator();
                    while (it12.hasNext()) {
                        Integer numValueOf23 = Integer.valueOf(pointArr8[it12.nextInt()].y);
                        if (numValueOf11.compareTo(numValueOf23) < 0) {
                            numValueOf11 = numValueOf23;
                        }
                    }
                }
                Integer numValueOf24 = Integer.valueOf(numValueOf11 != null ? numValueOf11.intValue() : 0);
                if (numValueOf22.compareTo(numValueOf24) < 0) {
                    numValueOf22 = numValueOf24;
                }
            }
            num = numValueOf22;
        }
        return new Rect(iIntValue, iIntValue2, iIntValue3, num != null ? num.intValue() : 0);
    }

    public final int calcDistanceFromPointToPoint(@NotNull Point point1, @NotNull Point point2) {
        Intrinsics.checkNotNullParameter(point1, "point1");
        Intrinsics.checkNotNullParameter(point2, "point2");
        return (int) calcVectorMag(new Point(point1.x - point2.x, point1.y - point2.y));
    }

    public final float calcDistanceFromPointToPoly(@NotNull Point point, @NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(poly, "poly");
        ArrayList<Point[]> arrayList = new ArrayList();
        if (PointUtil.INSTANCE.isPointInsidePoly(point, poly)) {
            return 0.0f;
        }
        int length = poly.length;
        int i = 0;
        while (i < length) {
            Point point2 = poly[i];
            i++;
            arrayList.add(new Point[]{point2, poly[i % poly.length]});
        }
        float fMin = Float.MAX_VALUE;
        for (Point[] line : arrayList) {
            Intrinsics.checkNotNullExpressionValue(line, "line");
            fMin = Math.min(calcDistanceFromPointToLineSegment(point, line), fMin);
        }
        return fMin;
    }

    public final float calcHorizontalDistanceFromPointToPoly(@NotNull Point point, @NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(poly, "poly");
        Point[] pointArr = {poly[1], poly[2]};
        Point[] pointArr2 = {poly[3], poly[0]};
        if (PointUtil.INSTANCE.isPointBetweenLines(point, pointArr, pointArr2)) {
            return 0.0f;
        }
        return Math.min(calcDistanceFromPointToLine(point, pointArr), calcDistanceFromPointToLine(point, pointArr2));
    }

    @Nullable
    public final Point calcIntersectionOfLines(@NotNull Point[] line0, @NotNull Point[] line1) {
        Intrinsics.checkNotNullParameter(line0, "line0");
        Intrinsics.checkNotNullParameter(line1, "line1");
        Point point = line0[0];
        int i = point.x;
        int i2 = point.y;
        Point point2 = line0[1];
        int i4 = point2.x;
        int i5 = point2.y;
        Point point3 = line1[0];
        int i6 = point3.x;
        int i7 = point3.y;
        Point point4 = line1[1];
        int i8 = point4.x;
        float f = ((i - i4) * (i7 - point4.y)) - ((i2 - i5) * (i6 - i8));
        if (f == 0.0f) {
            return null;
        }
        float f4 = (((i - i6) * r10) - ((i2 - i7) * r3)) / f;
        return new Point((int) (((double) (((i4 - i) * f4) + i)) + 0.5d), (int) (((double) ((f4 * (i5 - i2)) + i2)) + 0.5d));
    }

    @NotNull
    public final Point[] calcMinAreaPoly(@NotNull Point[] from, @NotNull Point[] to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        ArrayList arrayList = new ArrayList();
        PointF pointFCalcUnitVector = calcUnitVector(calcVector(to[3], to[2]));
        PointF pointFCalcUnitVector2 = calcUnitVector(calcVector(to[0], to[1]));
        float fDotOperation = dotOperation(pointFCalcUnitVector, calcVector(to[3], from[3]));
        float fDotOperation2 = dotOperation(pointFCalcUnitVector, calcVector(to[3], from[2]));
        arrayList.add(calcLocation(to[0], pointFCalcUnitVector2, fDotOperation));
        arrayList.add(calcLocation(to[0], pointFCalcUnitVector2, fDotOperation2));
        arrayList.add(calcLocation(to[3], pointFCalcUnitVector, fDotOperation2));
        arrayList.add(calcLocation(to[3], pointFCalcUnitVector, fDotOperation));
        return (Point[]) arrayList.toArray(new Point[0]);
    }

    @NotNull
    public final Rect calcRectWithMargin(@NotNull Rect rect, int margin) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new Rect(rect.left - margin, rect.top - margin, rect.right + margin, rect.bottom + margin);
    }

    public final float calcVerticalDistanceFromPointToPoly(@NotNull Point point, @NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(poly, "poly");
        Point[] pointArr = {poly[0], poly[1]};
        Point[] pointArr2 = {poly[2], poly[3]};
        if (PointUtil.INSTANCE.isPointBetweenLines(point, pointArr, pointArr2)) {
            return 0.0f;
        }
        return Math.min(calcDistanceFromPointToLine(point, pointArr), calcDistanceFromPointToLine(point, pointArr2));
    }

    public final float getRotationDegree(@NotNull Point from, @NotNull Point to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        PointF pointF = new PointF(calcVector(from, to));
        return (((float) Math.atan2(pointF.y, pointF.x)) * 180.0f) / 3.1415927f;
    }

    public final boolean isTilted(@NotNull Point[] poly, float threshold) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        return Math.abs(getRotationDegree(poly[3], poly[2])) > threshold && Math.abs(getRotationDegree(poly[2], poly[3])) > threshold;
    }

    private final int dotOperation(Point u, Point v) {
        return (u.y * v.y) + (u.x * v.x);
    }
}
