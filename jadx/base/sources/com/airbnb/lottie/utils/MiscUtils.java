package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.compose.runtime.AbstractC1974b;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class MiscUtils {
    private static final PointF pathFromDataCurrentPoint = new PointF();

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static int clamp(int i, int i2, int i4) {
        return Math.max(i2, Math.min(i4, i));
    }

    public static boolean contains(float f, float f4, float f5) {
        return f >= f4 && f <= f5;
    }

    private static int floorDiv(int i, int i2) {
        int i4 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i4 : i4 - 1;
    }

    public static int floorMod(float f, float f4) {
        return floorMod((int) f, (int) f4);
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        Path path2;
        path.reset();
        PointF initialPoint = shapeData.getInitialPoint();
        path.moveTo(initialPoint.x, initialPoint.y);
        pathFromDataCurrentPoint.set(initialPoint.x, initialPoint.y);
        int i = 0;
        while (i < shapeData.getCurves().size()) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(i);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF pointF = pathFromDataCurrentPoint;
            if (controlPoint1.equals(pointF) && controlPoint2.equals(vertex)) {
                path.lineTo(vertex.x, vertex.y);
                path2 = path;
            } else {
                path2 = path;
                path2.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, vertex.x, vertex.y);
            }
            pointF.set(vertex.x, vertex.y);
            i++;
            path = path2;
        }
        Path path3 = path;
        if (shapeData.isClosed()) {
            path3.close();
        }
    }

    public static int lerp(int i, int i2, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
        return (int) ((f * (i2 - i)) + i);
    }

    public static void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.fullyResolvesTo(keyPathElementContent.getName(), i)) {
            list.add(keyPath2.addKey(keyPathElementContent.getName()).resolve(keyPathElementContent));
        }
    }

    public static float clamp(float f, float f4, float f5) {
        return Math.max(f4, Math.min(f5, f));
    }

    private static int floorMod(int i, int i2) {
        return i - (i2 * floorDiv(i, i2));
    }

    public static float lerp(float f, float f4, @FloatRange(from = 0.0d, m705to = 1.0d) float f5) {
        return AbstractC0000a.m29z(f4, f, f5, f);
    }

    public static double clamp(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static double lerp(double d, double d2, @FloatRange(from = 0.0d, m705to = 1.0d) double d3) {
        return AbstractC1974b.m1306C(d2, d, d3, d);
    }
}
