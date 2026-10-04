package com.sun.imageio.plugins.common;

import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ReaderUtil {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void computeUpdatedPixels(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int[] iArr, int i11) {
        boolean z = false;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        for (int i15 = 0; i15 < i9; i15++) {
            int i16 = (i15 * i10) + i8;
            if (i16 >= i) {
                int i17 = i16 - i;
                if (i17 % i7 == 0) {
                    if (i16 >= i + i2) {
                        break;
                    }
                    int i18 = (i17 / i7) + i4;
                    if (i18 >= i5) {
                        if (i18 > i6) {
                            break;
                        }
                        if (!z) {
                            z = true;
                            i12 = i18;
                        } else if (i13 == -1) {
                            i13 = i18;
                        }
                        i14 = i18;
                    }
                }
            }
        }
        iArr[i11] = i12;
        if (z) {
            iArr[i11 + 2] = (i14 - i12) + 1;
        } else {
            iArr[i11 + 2] = 0;
        }
        iArr[i11 + 4] = Math.max(i13 - i12, 1);
    }

    public static int readMultiByteInteger(ImageInputStream imageInputStream) {
        byte b = imageInputStream.readByte();
        int i = b & 127;
        while ((b & 128) == 128) {
            int i2 = i << 7;
            byte b5 = imageInputStream.readByte();
            i = i2 | (b5 & 127);
            b = b5;
        }
        return i;
    }

    public static int[] computeUpdatedPixels(Rectangle rectangle, Point point, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        int[] iArr = new int[6];
        computeUpdatedPixels(rectangle.f10094x, rectangle.width, point.f10092x, i, i4, i6, i8, i10, i12, iArr, 0);
        computeUpdatedPixels(rectangle.f10095y, rectangle.height, point.f10093y, i2, i5, i7, i9, i11, i13, iArr, 1);
        return iArr;
    }
}
