package com.samsung.android.imagetranslation.geometry;

import android.graphics.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FastConvexHull {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class XCompare implements Comparator<Point>, Serializable {
        public /* synthetic */ XCompare(int i) {
            this();
        }

        private XCompare() {
        }

        @Override // java.util.Comparator
        public int compare(Point point, Point point2) {
            return Integer.compare(point.x, point2.x);
        }
    }

    public static ArrayList<Point> execute(ArrayList<Point> arrayList) {
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int i = 0;
        Collections.sort(arrayList2, new XCompare(i));
        int size = arrayList2.size();
        Point[] pointArr = new Point[size];
        pointArr[0] = (Point) arrayList2.get(0);
        pointArr[1] = (Point) arrayList2.get(1);
        int i2 = 2;
        for (int i4 = 2; i4 < size; i4++) {
            pointArr[i2] = (Point) arrayList2.get(i4);
            i2++;
            while (i2 > 2) {
                int i5 = i2 - 2;
                int i6 = i2 - 1;
                if (!rightTurn(pointArr[i2 - 3], pointArr[i5], pointArr[i6])) {
                    pointArr[i5] = pointArr[i6];
                    i2--;
                }
            }
        }
        Point[] pointArr2 = new Point[size];
        pointArr2[0] = (Point) arrayList2.get(size - 1);
        pointArr2[1] = (Point) arrayList2.get(size - 2);
        int i7 = 2;
        for (int i8 = size - 3; i8 >= 0; i8--) {
            pointArr2[i7] = (Point) arrayList2.get(i8);
            i7++;
            while (i7 > 2) {
                int i9 = i7 - 2;
                int i10 = i7 - 1;
                if (!rightTurn(pointArr2[i7 - 3], pointArr2[i9], pointArr2[i10])) {
                    pointArr2[i9] = pointArr2[i10];
                    i7--;
                }
            }
        }
        ArrayList<Point> arrayList3 = new ArrayList<>();
        while (i < i2) {
            arrayList3.add(pointArr[i]);
            i++;
        }
        for (int i11 = 1; i11 < i7 - 1; i11++) {
            arrayList3.add(pointArr2[i11]);
        }
        return arrayList3;
    }

    private static boolean rightTurn(Point point, Point point2, Point point3) {
        int i = point2.x;
        int i2 = point.x;
        int i4 = point3.y;
        int i5 = point.y;
        return ((i4 - i5) * (i - i2)) - ((point3.x - i2) * (point2.y - i5)) > 0;
    }
}
