package com.samsung.android.livetranslation.geometry;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.samsung.android.livetranslation.util.LTTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmallestSurroundingRectangle {
    private static final String TAG = "SSR";

    private static RectF computeAlignedBounds(List<PointF> list, int i) {
        return computeBounds(transform(list, createTransform(-computeEdgeAngleRad(list, i), list.get(i))));
    }

    private static int computeAlignmentPointIndex(List<PointF> list) {
        double d = Double.MAX_VALUE;
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            RectF rectFComputeAlignedBounds = computeAlignedBounds(list, i2);
            double dHeight = rectFComputeAlignedBounds.height() * rectFComputeAlignedBounds.width();
            if (dHeight < d) {
                i = i2;
                d = dHeight;
            }
        }
        return i;
    }

    private static RectF computeBounds(List<PointF> list) {
        float fMin = Float.MAX_VALUE;
        float fMax = -3.4028235E38f;
        float fMax2 = -3.4028235E38f;
        float fMin2 = Float.MAX_VALUE;
        for (PointF pointF : list) {
            float f = pointF.x;
            float f4 = pointF.y;
            fMin = Math.min(fMin, f);
            fMin2 = Math.min(fMin2, f4);
            fMax = Math.max(fMax, f);
            fMax2 = Math.max(fMax2, f4);
        }
        return new RectF(fMin, fMin2, fMax - fMin, fMax2 - fMin2);
    }

    public static List<PointF> computeConvexHullPoints(List<PointF> list) {
        ArrayList arrayList = new ArrayList();
        for (PointF pointF : list) {
            arrayList.add(new Point((int) pointF.x, (int) pointF.y));
        }
        ArrayList<Point> arrayListExecute = FastConvexHull.execute(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Point point : arrayListExecute) {
            arrayList2.add(new PointF(point.x, point.y));
        }
        return arrayList2;
    }

    public static List<PointF> computeCorners(List<PointF> list) {
        List<PointF> listComputeConvexHullPoints = computeConvexHullPoints(list);
        int iComputeAlignmentPointIndex = computeAlignmentPointIndex(listComputeConvexHullPoints);
        RectF rectFComputeAlignedBounds = computeAlignedBounds(listComputeConvexHullPoints, iComputeAlignmentPointIndex);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PointF(rectFComputeAlignedBounds.left, rectFComputeAlignedBounds.bottom));
        arrayList.add(new PointF(rectFComputeAlignedBounds.right, rectFComputeAlignedBounds.bottom));
        arrayList.add(new PointF(rectFComputeAlignedBounds.right, rectFComputeAlignedBounds.top));
        arrayList.add(new PointF(rectFComputeAlignedBounds.left, rectFComputeAlignedBounds.top));
        double dComputeEdgeAngleRad = computeEdgeAngleRad(listComputeConvexHullPoints, iComputeAlignmentPointIndex);
        PointF pointF = listComputeConvexHullPoints.get(iComputeAlignmentPointIndex);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.concatenate(AffineTransform.getTranslateInstance(pointF.x, pointF.y));
        affineTransform.concatenate(AffineTransform.getRotateInstance(dComputeEdgeAngleRad));
        List<PointF> listTransform = transform(arrayList, affineTransform);
        Collections.sort(listTransform, new Comparator<PointF>() { // from class: com.samsung.android.livetranslation.geometry.SmallestSurroundingRectangle.1
            @Override // java.util.Comparator
            public int compare(PointF pointF2, PointF pointF3) {
                float f = pointF2.y;
                float f4 = pointF3.y;
                if (f < f4) {
                    return -1;
                }
                return (f != f4 || pointF2.x >= pointF3.x) ? 1 : -1;
            }
        });
        return listTransform;
    }

    private static double computeEdgeAngleRad(List<PointF> list, int i) {
        int size = (i + 1) % list.size();
        PointF pointF = list.get(i);
        PointF pointF2 = list.get(size);
        return Math.atan2(pointF2.y - pointF.y, pointF2.x - pointF.x);
    }

    public static Point[] computeMinAreaRect(List<Point> list) {
        Point[] pointArr = new Point[list.size()];
        for (int i = 0; i < list.size(); i++) {
            pointArr[i] = new Point(list.get(i).x, list.get(i).y);
        }
        LTTLogger.m5581d(TAG, "points : " + list);
        return computeCorners(pointArr, pointArr);
    }

    public static Point[] computePolys(List<PointF> list) {
        List<PointF> listComputeConvexHullPoints = computeConvexHullPoints(list);
        int iComputeAlignmentPointIndex = computeAlignmentPointIndex(listComputeConvexHullPoints);
        RectF rectFComputeAlignedBounds = computeAlignedBounds(listComputeConvexHullPoints, iComputeAlignmentPointIndex);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PointF(rectFComputeAlignedBounds.left, rectFComputeAlignedBounds.bottom));
        arrayList.add(new PointF(rectFComputeAlignedBounds.right, rectFComputeAlignedBounds.bottom));
        arrayList.add(new PointF(rectFComputeAlignedBounds.right, rectFComputeAlignedBounds.top));
        arrayList.add(new PointF(rectFComputeAlignedBounds.left, rectFComputeAlignedBounds.top));
        PointF pointF = listComputeConvexHullPoints.get(iComputeAlignmentPointIndex);
        double dComputeEdgeAngleRad = computeEdgeAngleRad(listComputeConvexHullPoints, iComputeAlignmentPointIndex);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.concatenate(AffineTransform.getTranslateInstance(pointF.x, pointF.y));
        affineTransform.concatenate(AffineTransform.getRotateInstance(dComputeEdgeAngleRad));
        return sortPoint(transform(arrayList, affineTransform));
    }

    public static Path createPath(List<PointF> list) {
        Path path = new Path();
        for (int i = 0; i < list.size(); i++) {
            PointF pointF = list.get(i);
            float f = pointF.x;
            float f4 = pointF.y;
            if (i == 0) {
                path.moveTo(f, f4);
            } else {
                path.lineTo(f, f4);
            }
        }
        path.close();
        return path;
    }

    private static AffineTransform createTransform(double d, PointF pointF) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.concatenate(AffineTransform.getRotateInstance(d));
        affineTransform.concatenate(AffineTransform.getTranslateInstance(-pointF.x, -pointF.y));
        return affineTransform;
    }

    private static float crossProduct(PointF pointF, PointF pointF2, PointF pointF3) {
        float f = pointF2.x;
        float f4 = pointF.x;
        float f5 = pointF3.y;
        float f6 = pointF.y;
        return ((f5 - f6) * (f - f4)) - ((pointF3.x - f4) * (pointF2.y - f6));
    }

    private static int getLeftUpPoint(List<PointF> list) {
        double d = -1.0d;
        int i = 0;
        int i2 = 0;
        int i4 = 0;
        while (i < 4) {
            int i5 = i + 1;
            for (int i6 = i5; i6 < 4; i6++) {
                double length = getLength(list.get(i), list.get(i6));
                if (length > d) {
                    i2 = i;
                    i4 = i6;
                    d = length;
                }
            }
            i = i5;
        }
        if (getSlope(list.get(i2), list.get(i4)) > 0.0f) {
            return list.get(i2).x < list.get(i4).x ? i2 : i4;
        }
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < 4; i9++) {
            if (i9 != i2 && i9 != i4 && i7 == -1) {
                i7 = i9;
            }
            if (i9 != i2 && i9 != i4 && i7 != -1) {
                i8 = i9;
            }
        }
        return (list.get(i2).x >= list.get(i4).x ? !isLeft(list.get(i4), list.get(i2), list.get(i7)) : !isLeft(list.get(i2), list.get(i4), list.get(i7))) ? i8 : i7;
    }

    private static double getLength(PointF pointF, PointF pointF2) {
        float f = pointF.x;
        float f4 = pointF2.x;
        float f5 = (f - f4) * (f - f4);
        float f6 = pointF.y;
        float f7 = pointF2.y;
        return Math.sqrt(AbstractC0000a.m29z(f6, f7, f6 - f7, f5));
    }

    private static float getSlope(PointF pointF, PointF pointF2) {
        float f = pointF2.x;
        float f4 = pointF.x;
        return (pointF2.y - pointF.y) / (f == f4 ? 1.0E-4f : f - f4);
    }

    private static boolean isLeft(PointF pointF, PointF pointF2, PointF pointF3) {
        return crossProduct(pointF, pointF2, pointF3) < 0.0f;
    }

    @NonNull
    public static Point[] sortPoint(List<PointF> list) {
        int i;
        int leftUpPoint = getLeftUpPoint(list);
        PointF[] pointFArr = {new PointF(), new PointF(), new PointF()};
        int i2 = 3;
        int[] iArr = new int[3];
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            if (i5 != leftUpPoint) {
                pointFArr[i4].x = list.get(i5).x - list.get(leftUpPoint).x;
                pointFArr[i4].y = list.get(i5).y - list.get(leftUpPoint).y;
                iArr[i4] = i5;
                i4++;
            }
        }
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (i6 < i2) {
            int i10 = 0;
            int i11 = 0;
            while (i10 < i2) {
                if (i6 == i10) {
                    i = i2;
                } else {
                    i = i2;
                    i11 += crossProduct(pointFArr[i6], pointFArr[i10]) > 0.0f ? 1 : -1;
                }
                i10++;
                i2 = i;
            }
            int i12 = i2;
            if (i11 == 2) {
                i7 = iArr[i6];
            } else if (i11 == 0) {
                i9 = iArr[i6];
            } else {
                i8 = iArr[i6];
            }
            i6++;
            i2 = i12;
        }
        int i13 = i2;
        if (i7 == -1 || i8 == -1 || i9 == -1) {
            return sortPointSJ(list);
        }
        if (i7 == leftUpPoint || i8 == leftUpPoint || i9 == leftUpPoint) {
            return sortPointSJ(list);
        }
        Point[] pointArr = {new Point(), new Point(), new Point(), new Point()};
        pointArr[0].x = (int) list.get(leftUpPoint).x;
        pointArr[0].y = (int) list.get(leftUpPoint).y;
        pointArr[1].x = (int) list.get(i7).x;
        pointArr[1].y = (int) list.get(i7).y;
        pointArr[2].x = (int) list.get(i9).x;
        pointArr[2].y = (int) list.get(i9).y;
        pointArr[i13].x = (int) list.get(i8).x;
        pointArr[i13].y = (int) list.get(i8).y;
        return pointArr;
    }

    @NonNull
    private static Point[] sortPointSJ(List<PointF> list) {
        Collections.sort(list, new Comparator<PointF>() { // from class: com.samsung.android.livetranslation.geometry.SmallestSurroundingRectangle.2
            @Override // java.util.Comparator
            public int compare(PointF pointF, PointF pointF2) {
                return pointF.x < pointF2.x ? -1 : 1;
            }
        });
        Point[] pointArr = {new Point(), new Point(), new Point(), new Point()};
        if (list.get(0).y < list.get(1).y) {
            pointArr[0].x = (int) list.get(0).x;
            pointArr[3].x = (int) list.get(1).x;
            pointArr[0].y = (int) list.get(0).y;
            pointArr[3].y = (int) list.get(1).y;
        } else {
            pointArr[0].x = (int) list.get(1).x;
            pointArr[3].x = (int) list.get(0).x;
            pointArr[0].y = (int) list.get(1).y;
            pointArr[3].y = (int) list.get(0).y;
        }
        if (list.get(2).y < list.get(3).y) {
            pointArr[1].x = (int) list.get(2).x;
            pointArr[1].y = (int) list.get(2).y;
            pointArr[2].x = (int) list.get(3).x;
            pointArr[2].y = (int) list.get(3).y;
            return pointArr;
        }
        pointArr[1].x = (int) list.get(3).x;
        pointArr[1].y = (int) list.get(3).y;
        pointArr[2].x = (int) list.get(2).x;
        pointArr[2].y = (int) list.get(2).y;
        return pointArr;
    }

    private static List<PointF> transform(List<PointF> list, AffineTransform affineTransform) {
        ArrayList arrayList = new ArrayList();
        Iterator<PointF> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(affineTransform.transform(it.next(), null));
        }
        return arrayList;
    }

    private static float crossProduct(PointF pointF, PointF pointF2) {
        return (pointF.x * pointF2.y) - (pointF.y * pointF2.x);
    }

    public static Point[] computeCorners(Point[] pointArr, Point[] pointArr2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            Point point = pointArr[i];
            arrayList.add(new PointF(point.x, point.y));
            Point point2 = pointArr2[i];
            arrayList.add(new PointF(point2.x, point2.y));
        }
        return sortPoint(computeCorners(arrayList));
    }
}
