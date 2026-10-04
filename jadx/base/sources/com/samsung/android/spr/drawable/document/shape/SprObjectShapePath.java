package com.samsung.android.spr.drawable.document.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeColor;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeFill;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStroke;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStrokeLinecap;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStrokeLinejoin;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStrokeMiterlimit;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStrokeWidth;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprObjectShapePath extends SprObjectBase {
    public static final byte TYPE_BEZIER_CURVETO = 4;
    public static final byte TYPE_CLOSE = 6;
    public static final byte TYPE_ELLIPTICAL_ARC = 5;
    public static final byte TYPE_LINETO = 2;
    public static final byte TYPE_MOVETO = 1;
    public static final byte TYPE_NONE = 0;
    public static final byte TYPE_QUADRATIC_CURVETO = 3;
    public final SprObjectShapePath mIntrinsic;
    public ArrayList<PathInfo> mPathInfoList;
    public Path path;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegSign;

        private ExtractFloatResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PathInfo implements Cloneable {
        public byte type = 0;

        /* JADX INFO: renamed from: x */
        public float f5456x = 0.0f;

        /* JADX INFO: renamed from: x1 */
        public float f5457x1 = 0.0f;

        /* JADX INFO: renamed from: x2 */
        public float f5458x2 = 0.0f;

        /* JADX INFO: renamed from: y */
        public float f5459y = 0.0f;

        /* JADX INFO: renamed from: y1 */
        public float f5460y1 = 0.0f;

        /* JADX INFO: renamed from: y2 */
        public float f5461y2 = 0.0f;

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public PathInfo m22170clone() {
            return (PathInfo) super.clone();
        }
    }

    public SprObjectShapePath() {
        super((byte) 4);
        this.mPathInfoList = null;
        this.path = null;
        this.mIntrinsic = (SprObjectShapePath) super.mIntrinsic;
        this.path = new Path();
        this.mPathInfoList = new ArrayList<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addCommand(float[] fArr, char c, char c2, float[] fArr2) {
        int i;
        int i2;
        int i4;
        boolean z;
        boolean z2;
        char c4;
        char c5;
        int i5;
        float f;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        SprObjectShapePath sprObjectShapePath = this;
        boolean z3 = false;
        float f15 = fArr[0];
        boolean z4 = true;
        float f16 = fArr[1];
        char c6 = 2;
        float f17 = fArr[2];
        char c7 = 3;
        float f18 = fArr[3];
        switch (c2) {
            case 'A':
            case 'a':
                i = 7;
                i2 = i;
                float f19 = f15;
                float f20 = f16;
                i4 = 0;
                char c8 = c;
                while (i4 < fArr2.length) {
                    if (c2 == 'A') {
                        z = z3;
                        z2 = z4;
                        c4 = c6;
                        c5 = c7;
                        i5 = i4;
                        int i6 = i5 + 5;
                        int i7 = i5 + 6;
                        drawArc(f19, f20, fArr2[i6], fArr2[i7], fArr2[i5], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != 0.0f ? z2 : z, fArr2[i5 + 4] != 0.0f ? z2 : z);
                        f17 = fArr2[i6];
                        f19 = f17;
                        f18 = fArr2[i7];
                        f20 = f18;
                    } else if (c2 == 'C') {
                        z = z3;
                        z2 = z4;
                        c4 = c6;
                        c5 = c7;
                        i5 = i4;
                        int i8 = i5 + 2;
                        int i9 = i5 + 3;
                        int i10 = i5 + 4;
                        int i11 = i5 + 5;
                        sprObjectShapePath.cubicTo(fArr2[i5], fArr2[i5 + 1], fArr2[i8], fArr2[i9], fArr2[i10], fArr2[i11]);
                        float f21 = fArr2[i10];
                        float f22 = fArr2[i11];
                        float f23 = fArr2[i8];
                        float f24 = fArr2[i9];
                        f19 = f21;
                        f20 = f22;
                        f18 = f24;
                        f17 = f23;
                    } else if (c2 != 'H') {
                        if (c2 != 'Q') {
                            if (c2 == 'V') {
                                z = z3;
                                z2 = z4;
                                c4 = c6;
                                c5 = c7;
                                i5 = i4;
                                f5 = fArr2[i5];
                                sprObjectShapePath.lineTo(f19, f5);
                            } else if (c2 != 'a') {
                                if (c2 != 'c') {
                                    z = z3;
                                    if (c2 != 'h') {
                                        if (c2 != 'q') {
                                            z2 = z4;
                                            if (c2 != 'v') {
                                                if (c2 == 'L') {
                                                    c4 = c6;
                                                    c5 = c7;
                                                    f9 = fArr2[i4];
                                                    f10 = fArr2[i4 + 1];
                                                    sprObjectShapePath.lineTo(f9, f10);
                                                } else if (c2 != 'M') {
                                                    c4 = c6;
                                                    if (c2 != 'S') {
                                                        c5 = c7;
                                                        if (c2 == 'T') {
                                                            if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                                f19 = (f19 * 2.0f) - f17;
                                                                f20 = (f20 * 2.0f) - f18;
                                                            }
                                                            int i12 = i4 + 1;
                                                            sprObjectShapePath.quadTo(f19, f20, fArr2[i4], fArr2[i12]);
                                                            float f25 = fArr2[i4];
                                                            f5 = fArr2[i12];
                                                            f17 = f19;
                                                            f18 = f20;
                                                            i5 = i4;
                                                            f19 = f25;
                                                        } else if (c2 == 'l') {
                                                            f19 += fArr2[i4];
                                                            f20 += fArr2[i4 + 1];
                                                            sprObjectShapePath.lineTo(f19, f20);
                                                        } else if (c2 == 'm') {
                                                            f19 += fArr2[i4];
                                                            f20 += fArr2[i4 + 1];
                                                            sprObjectShapePath.moveTo(f19, f20);
                                                        } else if (c2 == 's') {
                                                            if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                                f11 = f19 - f17;
                                                                f12 = f20 - f18;
                                                            } else {
                                                                f12 = 0.0f;
                                                                f11 = 0.0f;
                                                            }
                                                            int i13 = i4 + 1;
                                                            int i14 = i4 + 2;
                                                            int i15 = i4 + 3;
                                                            sprObjectShapePath.cubicTo(f11 + f19, f20 + f12, f19 + fArr2[i4], f20 + fArr2[i13], fArr2[i14] + f19, fArr2[i15] + f20);
                                                            f6 = fArr2[i4] + f19;
                                                            f7 = fArr2[i13] + f20;
                                                            f19 += fArr2[i14];
                                                            f8 = fArr2[i15];
                                                        } else if (c2 == 't') {
                                                            if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                                f13 = f19 - f17;
                                                                f14 = f20 - f18;
                                                            } else {
                                                                f14 = 0.0f;
                                                                f13 = 0.0f;
                                                            }
                                                            float f26 = f13 + f19;
                                                            float f27 = f14 + f20;
                                                            int i16 = i4 + 1;
                                                            sprObjectShapePath.quadTo(f26, f27, fArr2[i4] + f19, fArr2[i16] + f20);
                                                            f19 += fArr2[i4];
                                                            f20 += fArr2[i16];
                                                            f18 = f27;
                                                            f17 = f26;
                                                        }
                                                    } else {
                                                        c5 = c7;
                                                        if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                            f19 = (f19 * 2.0f) - f17;
                                                            f20 = (f20 * 2.0f) - f18;
                                                        }
                                                        float f28 = f19;
                                                        float f29 = f20;
                                                        int i17 = i4 + 1;
                                                        int i18 = i4 + 2;
                                                        int i19 = i4 + 3;
                                                        sprObjectShapePath.cubicTo(f28, f29, fArr2[i4], fArr2[i17], fArr2[i18], fArr2[i19]);
                                                        f = fArr2[i4];
                                                        f4 = fArr2[i17];
                                                        f19 = fArr2[i18];
                                                        f20 = fArr2[i19];
                                                        i5 = i4;
                                                    }
                                                } else {
                                                    c4 = c6;
                                                    c5 = c7;
                                                    f9 = fArr2[i4];
                                                    f10 = fArr2[i4 + 1];
                                                    sprObjectShapePath.moveTo(f9, f10);
                                                }
                                                f19 = f9;
                                                f20 = f10;
                                            } else {
                                                c4 = c6;
                                                c5 = c7;
                                                f20 += fArr2[i4];
                                                sprObjectShapePath.lineTo(f19, f20);
                                            }
                                        } else {
                                            z2 = z4;
                                            c4 = c6;
                                            c5 = c7;
                                            int i20 = i4 + 1;
                                            int i21 = i4 + 2;
                                            int i22 = i4 + 3;
                                            sprObjectShapePath.quadTo(fArr2[i4] + f19, fArr2[i20] + f20, fArr2[i21] + f19, fArr2[i22] + f20);
                                            f6 = fArr2[i4] + f19;
                                            f7 = fArr2[i20] + f20;
                                            f19 += fArr2[i21];
                                            f8 = fArr2[i22];
                                        }
                                        f20 += f8;
                                        f17 = f6;
                                        f18 = f7;
                                    } else {
                                        z2 = z4;
                                        c4 = c6;
                                        c5 = c7;
                                        f19 += fArr2[i4];
                                        sprObjectShapePath.lineTo(f19, f20);
                                    }
                                } else {
                                    z = z3;
                                    z2 = z4;
                                    c4 = c6;
                                    c5 = c7;
                                    int i23 = i4 + 2;
                                    int i24 = i4 + 3;
                                    int i25 = i4 + 4;
                                    int i26 = i4 + 5;
                                    sprObjectShapePath.cubicTo(fArr2[i4] + f19, fArr2[i4 + 1] + f20, fArr2[i23] + f19, fArr2[i24] + f20, fArr2[i25] + f19, fArr2[i26] + f20);
                                    float f30 = fArr2[i23] + f19;
                                    float f31 = fArr2[i24] + f20;
                                    f19 += fArr2[i25];
                                    f20 += fArr2[i26];
                                    f17 = f30;
                                    f18 = f31;
                                }
                                i5 = i4;
                            } else {
                                z = z3;
                                z2 = z4;
                                c4 = c6;
                                c5 = c7;
                                int i27 = i4 + 5;
                                int i28 = i4 + 6;
                                float f32 = f20;
                                i5 = i4;
                                float f33 = f19;
                                drawArc(f33, f32, fArr2[i27] + f19, fArr2[i28] + f20, fArr2[i4], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f ? z2 : z, fArr2[i4 + 4] != 0.0f ? z2 : z);
                                f19 = f33 + fArr2[i27];
                                f20 = f32 + fArr2[i28];
                                f17 = f19;
                                f18 = f20;
                            }
                            f20 = f5;
                        } else {
                            z = z3;
                            z2 = z4;
                            c4 = c6;
                            c5 = c7;
                            i5 = i4;
                            int i29 = i5 + 1;
                            int i30 = i5 + 2;
                            int i31 = i5 + 3;
                            sprObjectShapePath.quadTo(fArr2[i5], fArr2[i29], fArr2[i30], fArr2[i31]);
                            f = fArr2[i5];
                            f4 = fArr2[i29];
                            f19 = fArr2[i30];
                            f20 = fArr2[i31];
                        }
                        f17 = f;
                        f18 = f4;
                    } else {
                        z = z3;
                        z2 = z4;
                        c4 = c6;
                        c5 = c7;
                        i5 = i4;
                        float f34 = fArr2[i5];
                        sprObjectShapePath.lineTo(f34, f20);
                        f19 = f34;
                    }
                    i4 = i5 + i2;
                    sprObjectShapePath = this;
                    c8 = c2;
                    z3 = z;
                    z4 = z2;
                    c6 = c4;
                    c7 = c5;
                }
                fArr[z3 ? 1 : 0] = f19;
                fArr[z4 ? 1 : 0] = f20;
                fArr[c6] = f17;
                fArr[c7] = f18;
                break;
            case 'C':
            case 'c':
                i = 6;
                i2 = i;
                float f192 = f15;
                float f202 = f16;
                i4 = 0;
                char c82 = c;
                while (i4 < fArr2.length) {
                }
                fArr[z3 ? 1 : 0] = f192;
                fArr[z4 ? 1 : 0] = f202;
                fArr[c6] = f17;
                fArr[c7] = f18;
                break;
            case 'H':
            case 'V':
            case 'h':
            case 'v':
                i2 = 1;
                float f1922 = f15;
                float f2022 = f16;
                i4 = 0;
                char c822 = c;
                while (i4 < fArr2.length) {
                }
                fArr[z3 ? 1 : 0] = f1922;
                fArr[z4 ? 1 : 0] = f2022;
                fArr[c6] = f17;
                fArr[c7] = f18;
                break;
            case 'L':
            case 'M':
            case 'T':
            case 'l':
            case 'm':
            case 't':
            default:
                i2 = 2;
                float f19222 = f15;
                float f20222 = f16;
                i4 = 0;
                char c8222 = c;
                while (i4 < fArr2.length) {
                }
                fArr[z3 ? 1 : 0] = f19222;
                fArr[z4 ? 1 : 0] = f20222;
                fArr[c6] = f17;
                fArr[c7] = f18;
                break;
            case 'Q':
            case 'S':
            case 'q':
            case 's':
                i = 4;
                i2 = i;
                float f192222 = f15;
                float f202222 = f16;
                i4 = 0;
                char c82222 = c;
                while (i4 < fArr2.length) {
                }
                fArr[z3 ? 1 : 0] = f192222;
                fArr[z4 ? 1 : 0] = f202222;
                fArr[c6] = f17;
                fArr[c7] = f18;
                break;
            case 'Z':
            case 'z':
                sprObjectShapePath.close();
                break;
        }
    }

    private void arcToBezier(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        int iAbs = Math.abs((int) Math.ceil((d9 * 4.0d) / 3.141592653589793d));
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
        double d18 = d9 / ((double) iAbs);
        double d19 = d17;
        double d20 = d14;
        int i = 0;
        double d21 = d5;
        double d22 = d6;
        double d23 = d8;
        while (i < iAbs) {
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
            cubicTo((float) ((d20 * dSqrt) + d21), (float) ((d19 * dSqrt) + d22), (float) (d25 - (dSqrt * d27)), (float) (d26 - (dSqrt * d28)), (float) d25, (float) d26);
            dSin = dSin;
            d18 = d18;
            d21 = d25;
            d22 = d26;
            i = i2 + 1;
            iAbs = iAbs;
            dCos = dCos;
            d23 = d24;
            d19 = d28;
            d20 = d27;
            d10 = d3;
        }
    }

    private void createNodesFromPathData(String str) {
        if (str == null) {
            return;
        }
        float[] fArr = new float[4];
        char cCharAt = 'm';
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int iNextStart = nextStart(str, i);
            String strTrim = str.substring(i2, iNextStart).trim();
            if (strTrim.length() > 0) {
                addCommand(fArr, cCharAt, strTrim.charAt(0), getFloats(strTrim));
                cCharAt = strTrim.charAt(0);
            }
            i2 = iNextStart;
            i = iNextStart + 1;
        }
        if (i - i2 != 1 || i2 >= str.length()) {
            return;
        }
        addCommand(fArr, cCharAt, str.charAt(i2), new float[0]);
    }

    private void drawArc(float f, float f4, float f5, float f6, float f7, float f8, float f9, boolean z, boolean z2) {
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
            return;
        }
        double d15 = (1.0d / d14) - 0.25d;
        if (d15 < 0.0d) {
            float fSqrt = (float) (Math.sqrt(d14) / 1.99999d);
            drawArc(f, f4, f5, f6, f7 * fSqrt, fSqrt * f8, f9, z, z2);
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
        arcToBezier((d18 * dCos) - (d19 * dSin), (d19 * dCos) + (d18 * dSin), d5, d7, d3, d4, radians, dAtan2, dAtan22);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024 A[LOOP:0: B:3:0x0004->B:17:0x0024, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0027 A[EDGE_INSN: B:21:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:3:0x0004->B:17:0x0024], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        boolean z = false;
        extractFloatResult.mEndWithNegSign = false;
        int i2 = i;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ' || cCharAt == ',') {
                z = true;
                if (!z) {
                    break;
                } else {
                    i2++;
                }
            } else {
                if (cCharAt == '-' && i2 != i) {
                    extractFloatResult.mEndWithNegSign = true;
                    z = true;
                }
                if (!z) {
                }
            }
        }
        extractFloatResult.mEndPosition = i2;
    }

    private float[] getFloats(String str) {
        int i = 0;
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        float[] fArr = new float[str.length()];
        ExtractFloatResult extractFloatResult = new ExtractFloatResult();
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            extract(str, i2, extractFloatResult);
            int i4 = extractFloatResult.mEndPosition;
            if (i2 < i4) {
                fArr[i] = Float.parseFloat(str.substring(i2, i4));
                i++;
            }
            i2 = extractFloatResult.mEndWithNegSign ? i4 : i4 + 1;
        }
        return Arrays.copyOf(fArr, i);
    }

    private int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if ((cCharAt - 'Z') * (cCharAt - 'A') <= 0) {
                break;
            }
            if ((cCharAt - 'z') * (cCharAt - 'a') <= 0) {
                break;
            }
            i++;
        }
        return i;
    }

    public void arcTo(float f, float f4, float f5, float f6, float f7, float f8) {
        PathInfo pathInfo = new PathInfo();
        pathInfo.type = (byte) 5;
        pathInfo.f5456x = f;
        pathInfo.f5459y = f4;
        pathInfo.f5457x1 = f5;
        pathInfo.f5460y1 = f6;
        pathInfo.f5458x2 = f7;
        pathInfo.f5461y2 = f8;
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList != null) {
            arrayList.add(pathInfo);
        }
        drawPath(pathInfo);
    }

    public void close() {
        PathInfo pathInfo = new PathInfo();
        pathInfo.type = (byte) 6;
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList != null) {
            arrayList.add(pathInfo);
        }
        drawPath(pathInfo);
    }

    public void cubicTo(float f, float f4, float f5, float f6, float f7, float f8) {
        PathInfo pathInfo = new PathInfo();
        pathInfo.type = (byte) 4;
        pathInfo.f5456x = f7;
        pathInfo.f5459y = f8;
        pathInfo.f5457x1 = f;
        pathInfo.f5460y1 = f4;
        pathInfo.f5458x2 = f5;
        pathInfo.f5461y2 = f6;
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList != null) {
            arrayList.add(pathInfo);
        }
        drawPath(pathInfo);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void draw(SprDocument sprDocument, Canvas canvas, float f, float f4, float f5) {
        canvas.save(31);
        float f6 = f5 * this.alpha;
        if (this.mAttributeList.size() > 0) {
            applyAttribute(sprDocument, canvas, f6);
        }
        setShadowLayer();
        if (this.isVisibleFill) {
            canvas.drawPath(this.path, this.fillPaint);
        }
        if (this.isVisibleStroke) {
            canvas.drawPath(this.path, this.strokePaint);
        }
        clearShadowLayer();
        canvas.restore();
    }

    public void drawPath() {
        if (this.mPathInfoList == null) {
            return;
        }
        this.path.reset();
        Iterator<PathInfo> it = this.mPathInfoList.iterator();
        while (it.hasNext()) {
            drawPath(it.next());
        }
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void finalize() throws Throwable {
        super.finalize();
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        int i = sprInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            byte b = sprInputStream.readByte();
            switch (b) {
                case 1:
                    moveTo(sprInputStream.readFloat(), sprInputStream.readFloat());
                    break;
                case 2:
                    lineTo(sprInputStream.readFloat(), sprInputStream.readFloat());
                    break;
                case 3:
                    quadTo(sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat());
                    break;
                case 4:
                    cubicTo(sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat(), sprInputStream.readFloat());
                    break;
                case 5:
                    float f = sprInputStream.readFloat();
                    float f4 = sprInputStream.readFloat();
                    arcTo(f, f4, sprInputStream.readFloat() + f, sprInputStream.readFloat() + f4, sprInputStream.readFloat(), sprInputStream.readFloat());
                    break;
                case 6:
                    close();
                    break;
                default:
                    throw new RuntimeException(AbstractC0000a.m11h(b, "unsupported command type:"));
            }
        }
        super.fromSPR(sprInputStream);
    }

    public void fromXml(XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (!"name".equals(attributeName)) {
                if ("strokeWidth".equals(attributeName)) {
                    SprAttributeStrokeWidth sprAttributeStrokeWidth = new SprAttributeStrokeWidth();
                    float fFloatValue = Float.valueOf(attributeValue).floatValue();
                    sprAttributeStrokeWidth.strokeWidth = fFloatValue;
                    if (fFloatValue > 0.0f && fFloatValue < 0.3f) {
                        sprAttributeStrokeWidth.strokeWidth = 0.3f;
                    }
                    this.mAttributeList.add(sprAttributeStrokeWidth);
                } else {
                    SprAttributeColor sprAttributeFill = null;
                    if ("strokeOpacity".equals(attributeName)) {
                        Iterator<SprAttributeBase> it = this.mAttributeList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            SprAttributeBase next = it.next();
                            if (next.mType == 35) {
                                sprAttributeFill = (SprAttributeStroke) next;
                                break;
                            }
                        }
                        if (sprAttributeFill == null) {
                            sprAttributeFill = new SprAttributeStroke();
                            this.mAttributeList.add(sprAttributeFill);
                        }
                        sprAttributeFill.color = (((int) (Float.valueOf(attributeValue).floatValue() * 255.0f)) << 24) | (sprAttributeFill.color & 16777215);
                    } else if ("strokeColor".equals(attributeName)) {
                        Iterator<SprAttributeBase> it2 = this.mAttributeList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            SprAttributeBase next2 = it2.next();
                            if (next2.mType == 35) {
                                sprAttributeFill = (SprAttributeStroke) next2;
                                break;
                            }
                        }
                        if (sprAttributeFill == null) {
                            sprAttributeFill = new SprAttributeStroke();
                            this.mAttributeList.add(sprAttributeFill);
                        }
                        if (attributeValue.startsWith(ContentUtils.HASH_SYMBOL)) {
                            sprAttributeFill.color = (int) Long.parseLong(attributeValue.substring(1), 16);
                        } else {
                            sprAttributeFill.color = -65536;
                        }
                        int i2 = sprAttributeFill.color;
                        sprAttributeFill.color = (~(i2 & 16777215)) | ((-16777216) & i2);
                    } else if ("fillColor".equals(attributeName)) {
                        Iterator<SprAttributeBase> it3 = this.mAttributeList.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            SprAttributeBase next3 = it3.next();
                            if (next3.mType == 32) {
                                sprAttributeFill = (SprAttributeFill) next3;
                                break;
                            }
                        }
                        if (sprAttributeFill == null) {
                            sprAttributeFill = new SprAttributeFill();
                            this.mAttributeList.add(sprAttributeFill);
                        }
                        if (attributeValue.startsWith(ContentUtils.HASH_SYMBOL)) {
                            sprAttributeFill.color = (int) Long.parseLong(attributeValue.substring(1), 16);
                        } else {
                            sprAttributeFill.color = -65536;
                        }
                    } else if ("fillOpacity".equals(attributeName)) {
                        Iterator<SprAttributeBase> it4 = this.mAttributeList.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            SprAttributeBase next4 = it4.next();
                            if (next4.mType == 32) {
                                sprAttributeFill = (SprAttributeFill) next4;
                                break;
                            }
                        }
                        if (sprAttributeFill == null) {
                            sprAttributeFill = new SprAttributeFill();
                            this.mAttributeList.add(sprAttributeFill);
                        }
                        sprAttributeFill.color = (((int) (Float.valueOf(attributeValue).floatValue() * 255.0f)) << 24) | (sprAttributeFill.color & 16777215);
                    } else if ("pathData".equals(attributeName)) {
                        createNodesFromPathData(attributeValue);
                    } else if (!"trimPathStart".equals(attributeName) && !"trimPathEnd".equals(attributeName) && !"trimPathOffset".equals(attributeName)) {
                        if ("strokeLineCap".equals(attributeName)) {
                            SprAttributeStrokeLinecap sprAttributeStrokeLinecap = new SprAttributeStrokeLinecap();
                            if ("butt".equals(attributeValue)) {
                                sprAttributeStrokeLinecap.linecap = SprAttributeStrokeLinecap.STROKE_LINECAP_TYPE_BUTT;
                            } else if ("round".equals(attributeValue)) {
                                sprAttributeStrokeLinecap.linecap = SprAttributeStrokeLinecap.STROKE_LINECAP_TYPE_ROUND;
                            } else if ("square".equals(attributeValue)) {
                                sprAttributeStrokeLinecap.linecap = SprAttributeStrokeLinecap.STROKE_LINECAP_TYPE_SQUARE;
                            }
                            this.mAttributeList.add(sprAttributeStrokeLinecap);
                        } else if ("strokeLineJoin".equals(attributeName)) {
                            SprAttributeStrokeLinejoin sprAttributeStrokeLinejoin = new SprAttributeStrokeLinejoin();
                            if ("miter".equals(attributeValue)) {
                                sprAttributeStrokeLinejoin.linejoin = SprAttributeStrokeLinejoin.STROKE_LINEJOIN_TYPE_MITER;
                            } else if ("round".equals(attributeValue)) {
                                sprAttributeStrokeLinejoin.linejoin = SprAttributeStrokeLinejoin.STROKE_LINEJOIN_TYPE_ROUND;
                            } else if ("bevel".equals(attributeValue)) {
                                sprAttributeStrokeLinejoin.linejoin = SprAttributeStrokeLinejoin.STROKE_LINEJOIN_TYPE_BEVEL;
                            }
                            this.mAttributeList.add(sprAttributeStrokeLinejoin);
                        } else if ("strokeMiterLimit".equals(attributeName)) {
                            SprAttributeStrokeMiterlimit sprAttributeStrokeMiterlimit = new SprAttributeStrokeMiterlimit();
                            sprAttributeStrokeMiterlimit.miterLimit = Float.valueOf(attributeValue).floatValue();
                            this.mAttributeList.add(sprAttributeStrokeMiterlimit);
                        }
                    }
                }
            }
        }
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getSPRSize() {
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList == null) {
            return 4;
        }
        int size = arrayList.size() + 4;
        Iterator<PathInfo> it = this.mPathInfoList.iterator();
        while (it.hasNext()) {
            byte b = it.next().type;
            if (b == 1 || b == 2) {
                size += 8;
            } else if (b == 3) {
                size += 16;
            } else if (b == 4 || b == 5) {
                size += 24;
            }
        }
        return super.getSPRSize() + size;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalElementCount() {
        return 1;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalSegmentCount() {
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void lineTo(float f, float f4) {
        PathInfo pathInfo = new PathInfo();
        pathInfo.type = (byte) 2;
        pathInfo.f5456x = f;
        pathInfo.f5459y = f4;
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList != null) {
            arrayList.add(pathInfo);
        }
        drawPath(pathInfo);
    }

    public void moveTo(float f, float f4) {
        PathInfo pathInfo = new PathInfo();
        pathInfo.type = (byte) 1;
        pathInfo.f5456x = f;
        pathInfo.f5459y = f4;
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList != null) {
            arrayList.add(pathInfo);
        }
        drawPath(pathInfo);
    }

    public void quadTo(float f, float f4, float f5, float f6) {
        PathInfo pathInfo = new PathInfo();
        pathInfo.type = (byte) 3;
        pathInfo.f5456x = f5;
        pathInfo.f5459y = f6;
        pathInfo.f5457x1 = f;
        pathInfo.f5460y1 = f4;
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList != null) {
            arrayList.add(pathInfo);
        }
        drawPath(pathInfo);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        ArrayList<PathInfo> arrayList = this.mPathInfoList;
        if (arrayList == null) {
            dataOutputStream.writeInt(0);
            return;
        }
        dataOutputStream.writeInt(arrayList.size());
        for (PathInfo pathInfo : this.mPathInfoList) {
            dataOutputStream.writeByte(pathInfo.type);
            byte b = pathInfo.type;
            if (b == 1 || b == 2) {
                dataOutputStream.writeFloat(pathInfo.f5456x);
                dataOutputStream.writeFloat(pathInfo.f5459y);
            } else if (b == 3) {
                dataOutputStream.writeFloat(pathInfo.f5457x1);
                dataOutputStream.writeFloat(pathInfo.f5460y1);
                dataOutputStream.writeFloat(pathInfo.f5456x);
                dataOutputStream.writeFloat(pathInfo.f5459y);
            } else if (b == 4) {
                dataOutputStream.writeFloat(pathInfo.f5457x1);
                dataOutputStream.writeFloat(pathInfo.f5460y1);
                dataOutputStream.writeFloat(pathInfo.f5458x2);
                dataOutputStream.writeFloat(pathInfo.f5461y2);
                dataOutputStream.writeFloat(pathInfo.f5456x);
                dataOutputStream.writeFloat(pathInfo.f5459y);
            } else if (b == 5) {
                dataOutputStream.writeFloat(pathInfo.f5456x);
                dataOutputStream.writeFloat(pathInfo.f5459y);
                dataOutputStream.writeFloat(pathInfo.f5457x1 - pathInfo.f5456x);
                dataOutputStream.writeFloat(pathInfo.f5460y1 - pathInfo.f5459y);
                dataOutputStream.writeFloat(pathInfo.f5458x2);
                dataOutputStream.writeFloat(pathInfo.f5461y2);
            }
        }
        super.toSPR(dataOutputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    /* JADX INFO: renamed from: clone */
    public SprObjectBase mo22169clone() {
        SprObjectShapePath sprObjectShapePath = (SprObjectShapePath) super.mo22169clone();
        if (this.mPathInfoList != null) {
            sprObjectShapePath.mPathInfoList = new ArrayList<>();
            Iterator<PathInfo> it = this.mPathInfoList.iterator();
            while (it.hasNext()) {
                sprObjectShapePath.mPathInfoList.add(it.next().m22170clone());
            }
        }
        sprObjectShapePath.path = new Path(this.path);
        return sprObjectShapePath;
    }

    private void drawPath(PathInfo pathInfo) {
        switch (pathInfo.type) {
            case 1:
                this.path.moveTo(pathInfo.f5456x, pathInfo.f5459y);
                break;
            case 2:
                this.path.lineTo(pathInfo.f5456x, pathInfo.f5459y);
                break;
            case 3:
                this.path.quadTo(pathInfo.f5457x1, pathInfo.f5460y1, pathInfo.f5456x, pathInfo.f5459y);
                break;
            case 4:
                this.path.cubicTo(pathInfo.f5457x1, pathInfo.f5460y1, pathInfo.f5458x2, pathInfo.f5461y2, pathInfo.f5456x, pathInfo.f5459y);
                break;
            case 5:
                this.path.arcTo(new RectF(pathInfo.f5456x, pathInfo.f5459y, pathInfo.f5457x1, pathInfo.f5460y1), pathInfo.f5458x2, pathInfo.f5461y2);
                break;
            case 6:
                this.path.close();
                break;
        }
    }

    public SprObjectShapePath(SprInputStream sprInputStream) throws IOException {
        super((byte) 4);
        this.mPathInfoList = null;
        this.path = null;
        this.mIntrinsic = (SprObjectShapePath) super.mIntrinsic;
        this.path = new Path();
        fromSPR(sprInputStream);
    }

    public SprObjectShapePath(XmlPullParser xmlPullParser) {
        super((byte) 4);
        this.mPathInfoList = null;
        this.path = null;
        this.mIntrinsic = (SprObjectShapePath) super.mIntrinsic;
        this.path = new Path();
        this.mPathInfoList = new ArrayList<>();
        fromXml(xmlPullParser);
    }
}
