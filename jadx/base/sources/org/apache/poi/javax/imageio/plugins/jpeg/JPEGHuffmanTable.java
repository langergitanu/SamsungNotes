package org.apache.poi.javax.imageio.plugins.jpeg;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;
import org.apache.commons.lang3.SystemProperties;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JPEGHuffmanTable {
    public static final JPEGHuffmanTable StdACChrominance;
    private static final short[] StdACChrominanceLengths;
    private static final short[] StdACChrominanceValues;
    public static final JPEGHuffmanTable StdACLuminance;
    private static final short[] StdACLuminanceLengths;
    private static final short[] StdACLuminanceValues;
    public static final JPEGHuffmanTable StdDCChrominance;
    private static final short[] StdDCChrominanceLengths;
    private static final short[] StdDCChrominanceValues;
    public static final JPEGHuffmanTable StdDCLuminance;
    private static final short[] StdDCLuminanceLengths;
    private static final short[] StdDCLuminanceValues;
    private short[] lengths;
    private short[] values;

    static {
        short[] sArr = {0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        StdDCLuminanceLengths = sArr;
        short[] sArr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        StdDCLuminanceValues = sArr2;
        short[] sArr3 = {0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        StdDCChrominanceLengths = sArr3;
        short[] sArr4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        StdDCChrominanceValues = sArr4;
        short[] sArr5 = {0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125};
        StdACLuminanceLengths = sArr5;
        short[] sArr6 = {1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, 129, 145, 161, 8, 35, 66, 177, 193, 21, 82, 209, 240, 36, 51, 98, 114, 130, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, 131, 132, 133, 134, 135, 136, 137, 138, 146, 147, 148, 149, 150, 151, 152, 153, 154, 162, 163, 164, 165, 166, 167, 168, 169, 170, 178, 179, 180, 181, 182, 183, 184, 185, 186, 194, 195, 196, 197, 198, 199, 200, 201, 202, 210, 211, 212, 213, 214, 215, 216, 217, 218, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250};
        StdACLuminanceValues = sArr6;
        short[] sArr7 = {0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119};
        StdACChrominanceLengths = sArr7;
        short[] sArr8 = {0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, 129, 8, 20, 66, 145, 161, 177, 193, 9, 35, 51, 82, 240, 21, 98, 114, 209, 10, 22, 36, 52, 225, 37, 241, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, 130, 131, 132, 133, 134, 135, 136, 137, 138, 146, 147, 148, 149, 150, 151, 152, 153, 154, 162, 163, 164, 165, 166, 167, 168, 169, 170, 178, 179, 180, 181, 182, 183, 184, 185, 186, 194, 195, 196, 197, 198, 199, 200, 201, 202, 210, 211, 212, 213, 214, 215, 216, 217, 218, 226, 227, 228, 229, 230, 231, 232, 233, 234, 242, 243, 244, 245, 246, 247, 248, 249, 250};
        StdACChrominanceValues = sArr8;
        StdDCLuminance = new JPEGHuffmanTable(sArr, sArr2, false);
        StdDCChrominance = new JPEGHuffmanTable(sArr3, sArr4, false);
        StdACLuminance = new JPEGHuffmanTable(sArr5, sArr6, false);
        StdACChrominance = new JPEGHuffmanTable(sArr7, sArr8, false);
    }

    public JPEGHuffmanTable(short[] sArr, short[] sArr2) {
        if (sArr == null || sArr2 == null || sArr.length == 0 || sArr2.length == 0 || sArr.length > 16 || sArr2.length > 256) {
            throw new IllegalArgumentException("Illegal lengths or values");
        }
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] < 0) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i, "lengths[", "] < 0"));
            }
        }
        for (int i2 = 0; i2 < sArr2.length; i2++) {
            if (sArr2[i2] < 0) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "values[", "] < 0"));
            }
        }
        this.lengths = Arrays.copyOf(sArr, sArr.length);
        this.values = Arrays.copyOf(sArr2, sArr2.length);
        validate();
    }

    private void validate() {
        int i = 0;
        int i2 = 0;
        while (true) {
            short[] sArr = this.lengths;
            if (i >= sArr.length) {
                break;
            }
            i2 += sArr[i];
            i++;
        }
        if (i2 != this.values.length) {
            throw new IllegalArgumentException("lengths do not correspond to length of value table");
        }
    }

    public short[] getLengths() {
        short[] sArr = this.lengths;
        return Arrays.copyOf(sArr, sArr.length);
    }

    public short[] getValues() {
        short[] sArr = this.values;
        return Arrays.copyOf(sArr, sArr.length);
    }

    public String toString() {
        String property = System.getProperty(SystemProperties.LINE_SEPARATOR, "\n");
        StringBuilder sbM15l = AbstractC0000a.m15l("JPEGHuffmanTable", property, "lengths:");
        for (int i = 0; i < this.lengths.length; i++) {
            sbM15l.append(" ");
            sbM15l.append((int) this.lengths[i]);
        }
        sbM15l.append(property);
        sbM15l.append("values:");
        for (int i2 = 0; i2 < this.values.length; i2++) {
            sbM15l.append(" ");
            sbM15l.append((int) this.values[i2]);
        }
        return sbM15l.toString();
    }

    private JPEGHuffmanTable(short[] sArr, short[] sArr2, boolean z) {
        if (z) {
            this.lengths = Arrays.copyOf(sArr, sArr.length);
            this.values = Arrays.copyOf(sArr2, sArr2.length);
        } else {
            this.lengths = sArr;
            this.values = sArr2;
        }
    }
}
