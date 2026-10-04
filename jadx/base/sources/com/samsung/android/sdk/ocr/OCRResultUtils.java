package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.ToDoubleFunction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OCRResultUtils {
    private static final String TAG = "OCRResultUtils";

    public static Rect cornerToRect(Point[] pointArr) {
        return (pointArr == null || pointArr.length <= 0) ? new Rect() : new Rect(Math.min(pointArr[0].x, pointArr[3].x), Math.min(pointArr[0].y, pointArr[1].y), Math.max(pointArr[1].x, pointArr[2].x), Math.max(pointArr[2].y, pointArr[3].y));
    }

    public static Point[] createInitialRect() {
        return new Point[]{new Point(Integer.MAX_VALUE, Integer.MAX_VALUE), new Point(Integer.MIN_VALUE, Integer.MAX_VALUE), new Point(Integer.MIN_VALUE, Integer.MIN_VALUE), new Point(Integer.MAX_VALUE, Integer.MIN_VALUE)};
    }

    public static Point getCenterPoint(Point[] pointArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(pointArr));
        final int i = 0;
        int asDouble = (int) arrayList.stream().mapToDouble(new ToDoubleFunction() { // from class: com.samsung.android.sdk.ocr.a
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                Point point = (Point) obj;
                switch (i) {
                    case 0:
                        return OCRResultUtils.lambda$getCenterPoint$0(point);
                    default:
                        return OCRResultUtils.lambda$getCenterPoint$1(point);
                }
            }
        }).average().getAsDouble();
        final int i2 = 1;
        return new Point(asDouble, (int) arrayList.stream().mapToDouble(new ToDoubleFunction() { // from class: com.samsung.android.sdk.ocr.a
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                Point point = (Point) obj;
                switch (i2) {
                    case 0:
                        return OCRResultUtils.lambda$getCenterPoint$0(point);
                    default:
                        return OCRResultUtils.lambda$getCenterPoint$1(point);
                }
            }
        }).average().getAsDouble());
    }

    public static Point getImageCenter(Bitmap bitmap) {
        return new Point(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
    }

    public static Bitmap getROI(Bitmap bitmap, Point[] pointArr) {
        return getROI(bitmap, cornerToRect(pointArr));
    }

    public static Bitmap getRotatedROI(Bitmap bitmap, Point[] pointArr, float f, Point point) {
        Rect rectCornerToRect = cornerToRect(pointArr);
        PointF pointF = new PointF(rectCornerToRect.centerX(), rectCornerToRect.centerY());
        Point[] rotatedCorner = OCRResult.getRotatedCorner(pointArr, -f, pointF);
        if (rotatedCorner == null) {
            Log.e(TAG, "Error on calculating deskewed points from rotated corners");
            return bitmap;
        }
        Rect rectCornerToRect2 = cornerToRect(rotatedCorner);
        Matrix matrix = new Matrix();
        matrix.setRotate(f, pointF.x, pointF.y);
        matrix.postTranslate(-rectCornerToRect2.left, -rectCornerToRect2.top);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rectCornerToRect2.width(), rectCornerToRect2.height(), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint());
        point.x = rectCornerToRect2.left;
        point.y = rectCornerToRect2.top;
        return bitmapCreateBitmap;
    }

    public static void getTextRect(Point[] pointArr, Point[] pointArr2) {
        Log.w(TAG, "Depreacted API. Use unionRect() instead.");
        unionRect(pointArr, pointArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$getCenterPoint$0(Point point) {
        return point.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$getCenterPoint$1(Point point) {
        return point.y;
    }

    public static Point[] rectToCorner(Rect rect) {
        return new Point[]{new Point(rect.left, rect.top), new Point(rect.right, rect.top), new Point(rect.right, rect.bottom), new Point(rect.left, rect.bottom)};
    }

    public static void unionRect(Point[] pointArr, Point[] pointArr2) {
        Point point = pointArr[0];
        point.x = Math.min(point.x, pointArr2[0].x);
        Point point2 = pointArr[0];
        point2.y = Math.min(point2.y, pointArr2[0].y);
        Point point3 = pointArr[1];
        point3.x = Math.max(point3.x, pointArr2[1].x);
        Point point4 = pointArr[1];
        point4.y = Math.min(point4.y, pointArr2[1].y);
        Point point5 = pointArr[2];
        point5.x = Math.max(point5.x, pointArr2[2].x);
        Point point6 = pointArr[2];
        point6.y = Math.max(point6.y, pointArr2[2].y);
        Point point7 = pointArr[3];
        point7.x = Math.min(point7.x, pointArr2[3].x);
        Point point8 = pointArr[3];
        point8.y = Math.max(point8.y, pointArr2[3].y);
    }

    public static Bitmap getROI(Bitmap bitmap, Rect rect) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        return Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width() + rect.left >= width ? width - rect.left : rect.width(), rect.height() + rect.top >= height ? height - rect.top : rect.height());
    }
}
