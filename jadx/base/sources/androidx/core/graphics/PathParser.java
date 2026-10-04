package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = i2 - i;
        int iMin = Math.min(i4, length - i);
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 1;
        while (i2 < str.length()) {
            int iNextStart = nextStart(str, i2);
            String strTrim = str.substring(i, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i = iNextStart;
            i2 = iNextStart + 1;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(AbstractC0541b.m772n("Error in parsing ", str), e);
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                z = false;
                z3 = true;
                if (z3) {
                }
            } else {
                if (cCharAt != 'E' && cCharAt != 'e') {
                    switch (cCharAt) {
                        case ',':
                            break;
                        case '-':
                            if (i2 == i || z) {
                                z = false;
                            } else {
                                extractFloatResult.mEndWithNegOrDot = true;
                                z = false;
                                z3 = true;
                            }
                            break;
                        case '.':
                            if (z2) {
                                extractFloatResult.mEndWithNegOrDot = true;
                                z = false;
                                z3 = true;
                            } else {
                                z = false;
                                z2 = true;
                            }
                            break;
                        default:
                            z = false;
                            break;
                    }
                } else {
                    z = true;
                }
                if (z3) {
                }
            }
            extractFloatResult.mEndPosition = i2;
        }
        extractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i4 = extractFloatResult.mEndPosition;
                if (i < i4) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i4));
                    i2++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i4 : i4 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException(AbstractC0541b.m773o("error in parsing \"", str, "\""), e);
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                }
                i++;
            }
            if (cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
            c = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            boolean z;
            boolean z2;
            char c4;
            char c5;
            int i4;
            float f;
            boolean z3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            boolean z4;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            Path path2 = path;
            boolean z5 = false;
            float f19 = fArr[0];
            boolean z6 = true;
            float f20 = fArr[1];
            char c6 = 2;
            float f21 = fArr[2];
            char c7 = 3;
            float f22 = fArr[3];
            float f23 = fArr[4];
            float f24 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i = 7;
                    i2 = i;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    i2 = i;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f23, f24);
                    f19 = f23;
                    f21 = f19;
                    f20 = f24;
                    f22 = f20;
                    i2 = 2;
                    break;
            }
            float f25 = f19;
            float f26 = f20;
            float f27 = f23;
            float f28 = f24;
            int i5 = 0;
            char c8 = c;
            while (i5 < fArr2.length) {
                if (c2 == 'A') {
                    float f29 = f25;
                    float f30 = f26;
                    z = z5;
                    z2 = z6;
                    c4 = c6;
                    c5 = c7;
                    i4 = i5;
                    int i6 = i4 + 5;
                    float f31 = fArr2[i6];
                    int i7 = i4 + 6;
                    float f32 = fArr2[i7];
                    float f33 = fArr2[i4];
                    float f34 = fArr2[i4 + 1];
                    float f35 = fArr2[i4 + 2];
                    if (fArr2[i4 + 3] != 0.0f) {
                        f = 0.0f;
                        z3 = z2;
                    } else {
                        f = 0.0f;
                        z3 = z;
                    }
                    drawArc(path, f29, f30, f31, f32, f33, f34, f35, z3, fArr2[i4 + 4] != f ? z2 : z);
                    f21 = fArr2[i6];
                    f25 = f21;
                    f22 = fArr2[i7];
                    f26 = f22;
                } else if (c2 == 'C') {
                    z = z5;
                    z2 = z6;
                    c4 = c6;
                    c5 = c7;
                    i4 = i5;
                    int i8 = i4 + 2;
                    int i9 = i4 + 3;
                    int i10 = i4 + 4;
                    int i11 = i4 + 5;
                    path2.cubicTo(fArr2[i4], fArr2[i4 + 1], fArr2[i8], fArr2[i9], fArr2[i10], fArr2[i11]);
                    float f36 = fArr2[i10];
                    float f37 = fArr2[i11];
                    float f38 = fArr2[i8];
                    float f39 = fArr2[i9];
                    f25 = f36;
                    f26 = f37;
                    f22 = f39;
                    f21 = f38;
                } else if (c2 != 'H') {
                    if (c2 != 'Q') {
                        z = z5;
                        if (c2 == 'V') {
                            z2 = z6;
                            c4 = c6;
                            c5 = c7;
                            i4 = i5;
                            path2.lineTo(f25, fArr2[i4]);
                            f6 = fArr2[i4];
                        } else if (c2 != 'a') {
                            if (c2 != 'c') {
                                z2 = z6;
                                if (c2 != 'h') {
                                    if (c2 != 'q') {
                                        c4 = c6;
                                        if (c2 != 'v') {
                                            if (c2 != 'L') {
                                                if (c2 != 'M') {
                                                    c5 = c7;
                                                    if (c2 == 'S') {
                                                        if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                            f25 = (f25 * 2.0f) - f21;
                                                            f26 = (f26 * 2.0f) - f22;
                                                        }
                                                        float f40 = f25;
                                                        float f41 = f26;
                                                        int i12 = i5 + 1;
                                                        int i13 = i5 + 2;
                                                        int i14 = i5 + 3;
                                                        path2.cubicTo(f40, f41, fArr2[i5], fArr2[i12], fArr2[i13], fArr2[i14]);
                                                        f4 = fArr2[i5];
                                                        f5 = fArr2[i12];
                                                        f25 = fArr2[i13];
                                                        f26 = fArr2[i14];
                                                        i4 = i5;
                                                    } else if (c2 == 'T') {
                                                        if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                            f25 = (f25 * 2.0f) - f21;
                                                            f26 = (f26 * 2.0f) - f22;
                                                        }
                                                        int i15 = i5 + 1;
                                                        path2.quadTo(f25, f26, fArr2[i5], fArr2[i15]);
                                                        float f42 = fArr2[i5];
                                                        f6 = fArr2[i15];
                                                        f21 = f25;
                                                        f22 = f26;
                                                        i4 = i5;
                                                        f25 = f42;
                                                    } else if (c2 == 'l') {
                                                        int i16 = i5 + 1;
                                                        path2.rLineTo(fArr2[i5], fArr2[i16]);
                                                        f25 += fArr2[i5];
                                                        f12 = fArr2[i16];
                                                    } else if (c2 == 'm') {
                                                        float f43 = fArr2[i5];
                                                        f25 += f43;
                                                        float f44 = fArr2[i5 + 1];
                                                        f26 += f44;
                                                        if (i5 > 0) {
                                                            path2.rLineTo(f43, f44);
                                                        } else {
                                                            path2.rMoveTo(f43, f44);
                                                            f27 = f25;
                                                        }
                                                    } else if (c2 == 's') {
                                                        if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                            f15 = f26 - f22;
                                                            f16 = f25 - f21;
                                                        } else {
                                                            f16 = 0.0f;
                                                            f15 = 0.0f;
                                                        }
                                                        int i17 = i5 + 1;
                                                        int i18 = i5 + 2;
                                                        int i19 = i5 + 3;
                                                        path2.rCubicTo(f16, f15, fArr2[i5], fArr2[i17], fArr2[i18], fArr2[i19]);
                                                        f9 = fArr2[i5] + f25;
                                                        f10 = fArr2[i17] + f26;
                                                        f25 += fArr2[i18];
                                                        f11 = fArr2[i19];
                                                    } else if (c2 == 't') {
                                                        if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                            f17 = f25 - f21;
                                                            f18 = f26 - f22;
                                                        } else {
                                                            f18 = 0.0f;
                                                            f17 = 0.0f;
                                                        }
                                                        int i20 = i5 + 1;
                                                        path2.rQuadTo(f17, f18, fArr2[i5], fArr2[i20]);
                                                        float f45 = f17 + f25;
                                                        float f46 = f18 + f26;
                                                        f25 += fArr2[i5];
                                                        f26 += fArr2[i20];
                                                        f22 = f46;
                                                        f21 = f45;
                                                    }
                                                } else {
                                                    c5 = c7;
                                                    f13 = fArr2[i5];
                                                    f14 = fArr2[i5 + 1];
                                                    if (i5 > 0) {
                                                        path2.lineTo(f13, f14);
                                                    } else {
                                                        path2.moveTo(f13, f14);
                                                        f25 = f13;
                                                        f27 = f25;
                                                        f26 = f14;
                                                    }
                                                }
                                                f28 = f26;
                                            } else {
                                                c5 = c7;
                                                int i21 = i5 + 1;
                                                path2.lineTo(fArr2[i5], fArr2[i21]);
                                                f13 = fArr2[i5];
                                                f14 = fArr2[i21];
                                            }
                                            f25 = f13;
                                            f26 = f14;
                                        } else {
                                            c5 = c7;
                                            path2.rLineTo(0.0f, fArr2[i5]);
                                            f12 = fArr2[i5];
                                        }
                                        f26 += f12;
                                    } else {
                                        c4 = c6;
                                        c5 = c7;
                                        int i22 = i5 + 1;
                                        int i23 = i5 + 2;
                                        int i24 = i5 + 3;
                                        path2.rQuadTo(fArr2[i5], fArr2[i22], fArr2[i23], fArr2[i24]);
                                        f9 = fArr2[i5] + f25;
                                        f10 = fArr2[i22] + f26;
                                        f25 += fArr2[i23];
                                        f11 = fArr2[i24];
                                    }
                                    f26 += f11;
                                    f21 = f9;
                                    f22 = f10;
                                } else {
                                    c4 = c6;
                                    c5 = c7;
                                    path2.rLineTo(fArr2[i5], 0.0f);
                                    f25 += fArr2[i5];
                                }
                            } else {
                                z2 = z6;
                                c4 = c6;
                                c5 = c7;
                                int i25 = i5 + 2;
                                int i26 = i5 + 3;
                                int i27 = i5 + 4;
                                int i28 = i5 + 5;
                                path2.rCubicTo(fArr2[i5], fArr2[i5 + 1], fArr2[i25], fArr2[i26], fArr2[i27], fArr2[i28]);
                                float f47 = fArr2[i25] + f25;
                                float f48 = fArr2[i26] + f26;
                                f25 += fArr2[i27];
                                f26 += fArr2[i28];
                                f21 = f47;
                                f22 = f48;
                            }
                            i4 = i5;
                        } else {
                            z2 = z6;
                            c4 = c6;
                            c5 = c7;
                            int i29 = i5 + 5;
                            float f49 = fArr2[i29] + f25;
                            int i30 = i5 + 6;
                            float f50 = fArr2[i30] + f26;
                            float f51 = fArr2[i5];
                            float f52 = fArr2[i5 + 1];
                            float f53 = fArr2[i5 + 2];
                            if (fArr2[i5 + 3] != 0.0f) {
                                f7 = 0.0f;
                                f8 = f26;
                                z4 = z2;
                            } else {
                                f7 = 0.0f;
                                f8 = f26;
                                z4 = z;
                            }
                            i4 = i5;
                            boolean z7 = fArr2[i5 + 4] != f7 ? z2 : z;
                            float f54 = f25;
                            drawArc(path, f54, f8, f49, f50, f51, f52, f53, z4, z7);
                            f25 = f54 + fArr2[i29];
                            f26 = f8 + fArr2[i30];
                            f21 = f25;
                            f22 = f26;
                        }
                        f26 = f6;
                    } else {
                        z = z5;
                        z2 = z6;
                        c4 = c6;
                        c5 = c7;
                        i4 = i5;
                        int i31 = i4 + 1;
                        int i32 = i4 + 2;
                        int i33 = i4 + 3;
                        path2.quadTo(fArr2[i4], fArr2[i31], fArr2[i32], fArr2[i33]);
                        f4 = fArr2[i4];
                        f5 = fArr2[i31];
                        f25 = fArr2[i32];
                        f26 = fArr2[i33];
                    }
                    f21 = f4;
                    f22 = f5;
                } else {
                    z = z5;
                    z2 = z6;
                    c4 = c6;
                    c5 = c7;
                    i4 = i5;
                    path2.lineTo(fArr2[i4], f26);
                    f25 = fArr2[i4];
                }
                i5 = i4 + i2;
                path2 = path;
                c8 = c2;
                z5 = z;
                z6 = z2;
                c6 = c4;
                c7 = c5;
            }
            fArr[z5 ? 1 : 0] = f25;
            fArr[z6 ? 1 : 0] = f26;
            fArr[c6] = f21;
            fArr[c7] = f22;
            fArr[4] = f27;
            fArr[5] = f28;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int iCeil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d7);
            double dSin = Math.sin(d7);
            double dCos2 = Math.cos(d8);
            double dSin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * dCos;
            double d13 = d4 * dSin;
            double d14 = (d12 * dSin2) - (d13 * dCos2);
            double d15 = d11 * dSin;
            double d16 = d4 * dCos;
            double d17 = (dCos2 * d16) + (dSin2 * d15);
            double d18 = d9 / ((double) iCeil);
            double d19 = d17;
            double d20 = d14;
            int i = 0;
            double d21 = d5;
            double d22 = d6;
            double d23 = d8;
            while (i < iCeil) {
                double d24 = d23 + d18;
                double dSin3 = Math.sin(d24);
                double dCos3 = Math.cos(d24);
                double d25 = (((d10 * dCos) * dCos3) + d) - (d13 * dSin3);
                int i2 = i;
                double d26 = (d16 * dSin3) + (d3 * dSin * dCos3) + d2;
                double d27 = (d12 * dSin3) - (d13 * dCos3);
                double d28 = (dCos3 * d16) + (dSin3 * d15);
                double d29 = d24 - d23;
                double dTan = Math.tan(d29 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d29)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d20 * dSqrt) + d21), (float) ((d19 * dSqrt) + d22), (float) (d25 - (dSqrt * d27)), (float) (d26 - (dSqrt * d28)), (float) d25, (float) d26);
                dSin = dSin;
                d18 = d18;
                d21 = d25;
                d15 = d15;
                dCos = dCos;
                d19 = d28;
                d20 = d27;
                d10 = d3;
                d22 = d26;
                i = i2 + 1;
                iCeil = iCeil;
                d23 = d24;
            }
        }

        private static void drawArc(Path path, float f, float f4, float f5, float f6, float f7, float f8, float f9, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f9);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d3 = f;
            double d4 = f4;
            double d5 = f7;
            double d6 = ((d4 * dSin) + (d3 * dCos)) / d5;
            double d7 = f8;
            double d8 = ((d4 * dCos) + (((double) (-f)) * dSin)) / d7;
            double d9 = f6;
            double dM1308a = AbstractC1974b.m1308a(d9, dSin, ((double) f5) * dCos, d5);
            double dM1308a2 = AbstractC1974b.m1308a(d9, dCos, ((double) (-f5)) * dSin, d7);
            double d10 = d6 - dM1308a;
            double d11 = d8 - dM1308a2;
            double d12 = (d6 + dM1308a) / 2.0d;
            double d13 = (d8 + dM1308a2) / 2.0d;
            double d14 = (d11 * d11) + (d10 * d10);
            if (d14 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d15 = (1.0d / d14) - 0.25d;
            if (d15 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d14);
                float fSqrt = (float) (Math.sqrt(d14) / 1.99999d);
                drawArc(path, f, f4, f5, f6, f7 * fSqrt, fSqrt * f8, f9, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d15);
            double d16 = d10 * dSqrt;
            double d17 = dSqrt * d11;
            if (z == z2) {
                d = d12 - d17;
                d2 = d13 + d16;
            } else {
                d = d12 + d17;
                d2 = d13 - d16;
            }
            double dAtan2 = Math.atan2(d8 - d2, d6 - d);
            double dAtan22 = Math.atan2(dM1308a2 - d2, dM1308a - d) - dAtan2;
            if (z2 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d18 = d * d5;
            double d19 = d2 * d7;
            arcToBezier(path, (d18 * dCos) - (d19 * dSin), (d19 * dCos) + (d18 * dSin), d5, d7, d3, d4, radians, dAtan2, dAtan22);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i >= fArr.length) {
                    return;
                }
                this.mParams[i] = (pathDataNode2.mParams[i] * f) + ((1.0f - f) * fArr[i]);
                i++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
