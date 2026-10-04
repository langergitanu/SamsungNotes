package org.apache.poi.javax.imageio.plugins.jpeg;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.layout.LayoutKt;
import java.util.Arrays;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JPEGQTable {
    public static final JPEGQTable K1Div2Luminance;
    public static final JPEGQTable K1Luminance;
    public static final JPEGQTable K2Chrominance;
    public static final JPEGQTable K2Div2Chrominance;

    /* JADX INFO: renamed from: k1 */
    private static final int[] f10156k1;
    private static final int[] k1div2;

    /* JADX INFO: renamed from: k2 */
    private static final int[] f10157k2;
    private static final int[] k2div2;
    private int[] qTable;

    static {
        int[] iArr = {16, 11, 10, 16, 24, 40, 51, 61, 12, 12, 14, 19, 26, 58, 60, 55, 14, 13, 16, 24, 40, 57, 69, 56, 14, 17, 22, 29, 51, 87, 80, 62, 18, 22, 37, 56, 68, 109, 103, 77, 24, 35, 55, 64, 81, 104, 113, 92, 49, 64, 78, 87, 103, 121, 120, 101, 72, 92, 95, 98, 112, 100, 103, 99};
        f10156k1 = iArr;
        int[] iArr2 = {8, 6, 5, 8, 12, 20, 26, 31, 6, 6, 7, 10, 13, 29, 30, 28, 7, 7, 8, 12, 20, 29, 35, 28, 7, 9, 11, 15, 26, 44, 40, 31, 9, 11, 19, 28, 34, 55, 52, 39, 12, 18, 28, 32, 41, 52, 57, 46, 25, 32, 39, 44, 52, 61, 60, 51, 36, 46, 48, 49, 56, 50, 52, 50};
        k1div2 = iArr2;
        int[] iArr3 = {17, 18, 24, 47, 99, 99, 99, 99, 18, 21, 26, 66, 99, 99, 99, 99, 24, 26, 56, 99, 99, 99, 99, 99, 47, 66, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99};
        f10157k2 = iArr3;
        int[] iArr4 = {9, 9, 12, 24, 50, 50, 50, 50, 9, 11, 13, 33, 50, 50, 50, 50, 12, 13, 28, 50, 50, 50, 50, 50, 24, 33, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
        k2div2 = iArr4;
        K1Luminance = new JPEGQTable(iArr, false);
        K1Div2Luminance = new JPEGQTable(iArr2, false);
        K2Chrominance = new JPEGQTable(iArr3, false);
        K2Div2Chrominance = new JPEGQTable(iArr4, false);
    }

    private JPEGQTable(int[] iArr, boolean z) {
        this.qTable = z ? Arrays.copyOf(iArr, iArr.length) : iArr;
    }

    public JPEGQTable getScaledInstance(float f, boolean z) {
        int i = z ? 255 : LayoutKt.LargeDimension;
        int[] iArr = new int[this.qTable.length];
        int i2 = 0;
        while (true) {
            if (i2 >= this.qTable.length) {
                return new JPEGQTable(iArr);
            }
            int i4 = (int) ((r2[i2] * f) + 0.5f);
            if (i4 < 1) {
                i4 = 1;
            }
            if (i4 > i) {
                i4 = i;
            }
            iArr[i2] = i4;
            i2++;
        }
    }

    public int[] getTable() {
        int[] iArr = this.qTable;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public String toString() {
        String property = System.getProperty(SystemProperties.LINE_SEPARATOR, "\n");
        StringBuilder sb = new StringBuilder(AbstractC0541b.m772n("JPEGQTable:", property));
        for (int i = 0; i < this.qTable.length; i++) {
            int i2 = i % 8;
            if (i2 == 0) {
                sb.append('\t');
            }
            sb.append(this.qTable[i]);
            sb.append(i2 == 7 ? property : ' ');
        }
        return sb.toString();
    }

    public JPEGQTable(int[] iArr) {
        if (iArr != null) {
            if (iArr.length == 64) {
                this.qTable = Arrays.copyOf(iArr, iArr.length);
                return;
            }
            throw new IllegalArgumentException("table.length != 64");
        }
        throw new IllegalArgumentException("table must not be null.");
    }
}
