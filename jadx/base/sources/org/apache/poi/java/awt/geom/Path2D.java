package org.apache.poi.java.awt.geom;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.Shape;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.sun.awt.geom.Curve;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Path2D implements Shape, Cloneable {
    static final int EXPAND_MAX = 500;
    static final int INIT_SIZE = 20;
    private static final byte SEG_CLOSE = 4;
    private static final byte SEG_CUBICTO = 3;
    private static final byte SEG_LINETO = 1;
    private static final byte SEG_MOVETO = 0;
    private static final byte SEG_QUADTO = 2;
    private static final byte SERIAL_PATH_END = 97;
    private static final byte SERIAL_SEG_CLOSE = 96;
    private static final byte SERIAL_SEG_DBL_CUBICTO = 83;
    private static final byte SERIAL_SEG_DBL_LINETO = 81;
    private static final byte SERIAL_SEG_DBL_MOVETO = 80;
    private static final byte SERIAL_SEG_DBL_QUADTO = 82;
    private static final byte SERIAL_SEG_FLT_CUBICTO = 67;
    private static final byte SERIAL_SEG_FLT_LINETO = 65;
    private static final byte SERIAL_SEG_FLT_MOVETO = 64;
    private static final byte SERIAL_SEG_FLT_QUADTO = 66;
    private static final byte SERIAL_STORAGE_DBL_ARRAY = 49;
    private static final byte SERIAL_STORAGE_FLT_ARRAY = 48;
    public static final int WIND_EVEN_ODD = 0;
    public static final int WIND_NON_ZERO = 1;
    transient int numCoords;
    transient int numTypes;
    transient byte[] pointTypes;
    transient int windingRule;

    public static class Double extends Path2D implements Serializable {
        private static final long serialVersionUID = 1826762518450014216L;
        transient double[] doubleCoords;

        public static class CopyIterator extends Iterator {
            double[] doubleCoords;

            public CopyIterator(Double r12) {
                super(r12);
                this.doubleCoords = r12.doubleCoords;
            }

            @Override // org.apache.poi.java.awt.geom.PathIterator
            public int currentSegment(double[] dArr) {
                byte b = this.path.pointTypes[this.typeIdx];
                int i = Iterator.curvecoords[b];
                if (i > 0) {
                    System.arraycopy(this.doubleCoords, this.pointIdx, dArr, 0, i);
                }
                return b;
            }

            @Override // org.apache.poi.java.awt.geom.PathIterator
            public int currentSegment(float[] fArr) {
                byte b = this.path.pointTypes[this.typeIdx];
                int i = Iterator.curvecoords[b];
                if (i > 0) {
                    for (int i2 = 0; i2 < i; i2++) {
                        fArr[i2] = (float) this.doubleCoords[this.pointIdx + i2];
                    }
                }
                return b;
            }
        }

        public static class TxIterator extends Iterator {
            AffineTransform affine;
            double[] doubleCoords;

            public TxIterator(Double r12, AffineTransform affineTransform) {
                super(r12);
                this.doubleCoords = r12.doubleCoords;
                this.affine = affineTransform;
            }

            @Override // org.apache.poi.java.awt.geom.PathIterator
            public int currentSegment(double[] dArr) {
                byte b = this.path.pointTypes[this.typeIdx];
                int i = Iterator.curvecoords[b];
                if (i > 0) {
                    this.affine.transform(this.doubleCoords, this.pointIdx, dArr, 0, i / 2);
                }
                return b;
            }

            @Override // org.apache.poi.java.awt.geom.PathIterator
            public int currentSegment(float[] fArr) {
                byte b = this.path.pointTypes[this.typeIdx];
                int i = Iterator.curvecoords[b];
                if (i > 0) {
                    this.affine.transform(this.doubleCoords, this.pointIdx, fArr, 0, i / 2);
                }
                return b;
            }
        }

        public Double() {
            this(1, 20);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            readObject(objectInputStream, true);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            writeObject(objectOutputStream, true);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public void append(double d, double d2) {
            double[] dArr = this.doubleCoords;
            int i = this.numCoords;
            int i2 = i + 1;
            this.numCoords = i2;
            dArr[i] = d;
            this.numCoords = i + 2;
            dArr[i2] = d2;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final Object clone() {
            return new Double(this);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public double[] cloneCoordsDouble(AffineTransform affineTransform) {
            if (affineTransform == null) {
                double[] dArr = this.doubleCoords;
                return Arrays.copyOf(dArr, dArr.length);
            }
            double[] dArr2 = this.doubleCoords;
            double[] dArr3 = new double[dArr2.length];
            affineTransform.transform(dArr2, 0, dArr3, 0, this.numCoords / 2);
            return dArr3;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public float[] cloneCoordsFloat(AffineTransform affineTransform) {
            double[] dArr = this.doubleCoords;
            float[] fArr = new float[dArr.length];
            if (affineTransform != null) {
                affineTransform.transform(dArr, 0, fArr, 0, this.numCoords / 2);
                return fArr;
            }
            for (int i = 0; i < this.numCoords; i++) {
                fArr[i] = (float) this.doubleCoords[i];
            }
            return fArr;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final synchronized void curveTo(double d, double d2, double d3, double d4, double d5, double d6) {
            needRoom(true, 6);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 3;
            double[] dArr = this.doubleCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            dArr[i2] = d;
            int i5 = i2 + 2;
            this.numCoords = i5;
            dArr[i4] = d2;
            int i6 = i2 + 3;
            this.numCoords = i6;
            dArr[i5] = d3;
            int i7 = i2 + 4;
            this.numCoords = i7;
            dArr[i6] = d4;
            int i8 = i2 + 5;
            this.numCoords = i8;
            dArr[i7] = d5;
            this.numCoords = i2 + 6;
            dArr[i8] = d6;
        }

        @Override // org.apache.poi.java.awt.Shape
        public final synchronized Rectangle2D getBounds2D() {
            double d;
            double d2;
            double d3;
            double d4;
            try {
                int i = this.numCoords;
                if (i > 0) {
                    double[] dArr = this.doubleCoords;
                    double d5 = dArr[i - 1];
                    int i2 = i - 2;
                    double d6 = dArr[i2];
                    double d7 = d6;
                    d2 = d5;
                    while (i2 > 0) {
                        double[] dArr2 = this.doubleCoords;
                        double d8 = dArr2[i2 - 1];
                        i2 -= 2;
                        double d9 = dArr2[i2];
                        if (d9 < d6) {
                            d6 = d9;
                        }
                        if (d8 < d5) {
                            d5 = d8;
                        }
                        if (d9 > d7) {
                            d7 = d9;
                        }
                        if (d8 > d2) {
                            d2 = d8;
                        }
                    }
                    d4 = d7;
                    d3 = d5;
                    d = d6;
                } else {
                    d = 0.0d;
                    d2 = 0.0d;
                    d3 = 0.0d;
                    d4 = 0.0d;
                }
            } catch (Throwable th) {
                throw th;
            }
            return new Rectangle2D.Double(d, d3, d4 - d, d2 - d3);
        }

        @Override // org.apache.poi.java.awt.Shape
        public final PathIterator getPathIterator(AffineTransform affineTransform) {
            return affineTransform == null ? new CopyIterator(this) : new TxIterator(this, affineTransform);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public Point2D getPoint(int i) {
            double[] dArr = this.doubleCoords;
            return new Point2D.Double(dArr[i], dArr[i + 1]);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final synchronized void lineTo(double d, double d2) {
            needRoom(true, 2);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 1;
            double[] dArr = this.doubleCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            dArr[i2] = d;
            this.numCoords = i2 + 2;
            dArr[i4] = d2;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final synchronized void moveTo(double d, double d2) {
            try {
                int i = this.numTypes;
                if (i <= 0 || this.pointTypes[i - 1] != 0) {
                    needRoom(false, 2);
                    byte[] bArr = this.pointTypes;
                    int i2 = this.numTypes;
                    this.numTypes = i2 + 1;
                    bArr[i2] = 0;
                    double[] dArr = this.doubleCoords;
                    int i4 = this.numCoords;
                    int i5 = i4 + 1;
                    this.numCoords = i5;
                    dArr[i4] = d;
                    this.numCoords = i4 + 2;
                    dArr[i5] = d2;
                } else {
                    double[] dArr2 = this.doubleCoords;
                    int i6 = this.numCoords;
                    dArr2[i6 - 2] = d;
                    dArr2[i6 - 1] = d2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public void needRoom(boolean z, int i) {
            if (z && this.numTypes == 0) {
                throw new IllegalPathStateException("missing initial moveto in path definition");
            }
            byte[] bArr = this.pointTypes;
            int length = bArr.length;
            if (this.numTypes >= length) {
                this.pointTypes = Arrays.copyOf(bArr, length + (length <= 500 ? length : 500));
            }
            double[] dArr = this.doubleCoords;
            int length2 = dArr.length;
            if (this.numCoords + i > length2) {
                int i2 = length2 <= 1000 ? length2 : 1000;
                if (i2 >= i) {
                    i = i2;
                }
                this.doubleCoords = Arrays.copyOf(dArr, length2 + i);
            }
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public int pointCrossings(double d, double d2) {
            double d3;
            double d4;
            double d5;
            double d6;
            double[] dArr = this.doubleCoords;
            int iPointCrossingsForLine = 0;
            double d7 = dArr[0];
            double d8 = d7;
            double d9 = dArr[1];
            double d10 = d9;
            int i = 2;
            for (int i2 = 1; i2 < this.numTypes; i2++) {
                byte b = this.pointTypes[i2];
                if (b != 0) {
                    if (b == 1) {
                        d3 = d8;
                        d4 = d10;
                        int i4 = i + 1;
                        double d11 = dArr[i];
                        i += 2;
                        double d12 = dArr[i4];
                        iPointCrossingsForLine += Curve.pointCrossingsForLine(d, d2, d7, d9, d11, d12);
                        d7 = d11;
                        d9 = d12;
                    } else if (b == 2) {
                        d3 = d8;
                        d4 = d10;
                        double d13 = dArr[i];
                        double d14 = dArr[i + 1];
                        int i5 = i + 3;
                        double d15 = dArr[i + 2];
                        i += 4;
                        double d16 = dArr[i5];
                        iPointCrossingsForLine += Curve.pointCrossingsForQuad(d, d2, d7, d9, d13, d14, d15, d16, 0);
                        d7 = d15;
                        d9 = d16;
                    } else if (b == 3) {
                        d3 = d8;
                        d4 = d10;
                        double d17 = dArr[i];
                        double d18 = dArr[i + 1];
                        double d19 = dArr[i + 2];
                        double d20 = dArr[i + 3];
                        int i6 = i + 5;
                        double d21 = dArr[i + 4];
                        i += 6;
                        double d22 = dArr[i6];
                        iPointCrossingsForLine += Curve.pointCrossingsForCubic(d, d2, d7, d9, d17, d18, d19, d20, d21, d22, 0);
                        d7 = d21;
                        d9 = d22;
                    } else if (b == 4) {
                        if (d9 != d10) {
                            d5 = d8;
                            d6 = d10;
                            iPointCrossingsForLine += Curve.pointCrossingsForLine(d, d2, d7, d9, d8, d10);
                        } else {
                            d5 = d8;
                            d6 = d10;
                        }
                        d9 = d6;
                        d10 = d9;
                        d7 = d5;
                    }
                    d10 = d4;
                    d8 = d3;
                } else {
                    double d23 = d8;
                    double d24 = d10;
                    if (d9 != d24) {
                        iPointCrossingsForLine += Curve.pointCrossingsForLine(d, d2, d7, d9, d23, d24);
                    }
                    int i7 = i + 1;
                    double d25 = dArr[i];
                    i += 2;
                    d9 = dArr[i7];
                    d10 = d9;
                    d7 = d25;
                }
                d8 = d7;
            }
            return d9 != d10 ? iPointCrossingsForLine + Curve.pointCrossingsForLine(d, d2, d7, d9, d8, d10) : iPointCrossingsForLine;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final synchronized void quadTo(double d, double d2, double d3, double d4) {
            needRoom(true, 4);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 2;
            double[] dArr = this.doubleCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            dArr[i2] = d;
            int i5 = i2 + 2;
            this.numCoords = i5;
            dArr[i4] = d2;
            int i6 = i2 + 3;
            this.numCoords = i6;
            dArr[i5] = d3;
            this.numCoords = i2 + 4;
            dArr[i6] = d4;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public int rectCrossings(double d, double d2, double d3, double d4) {
            double d5;
            double[] dArr = this.doubleCoords;
            int iRectCrossingsForLine = 0;
            double d6 = dArr[0];
            double d7 = d6;
            double d8 = dArr[1];
            double d9 = d8;
            int i = 2;
            for (int i2 = 1; iRectCrossingsForLine != Integer.MIN_VALUE && i2 < this.numTypes; i2++) {
                byte b = this.pointTypes[i2];
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
                            double d10 = d7;
                            d5 = d9;
                            double d11 = dArr[i];
                            double d12 = dArr[i + 1];
                            int i4 = i + 3;
                            double d13 = dArr[i + 2];
                            i += 4;
                            double d14 = dArr[i4];
                            iRectCrossingsForLine = Curve.rectCrossingsForQuad(iRectCrossingsForLine, d, d2, d3, d4, d6, d8, d11, d12, d13, d14, 0);
                            d7 = d10;
                            d6 = d13;
                            d8 = d14;
                        } else if (b == 3) {
                            double d15 = d7;
                            d5 = d9;
                            double d16 = dArr[i];
                            double d17 = dArr[i + 1];
                            double d18 = dArr[i + 2];
                            double d19 = dArr[i + 3];
                            int i5 = i + 5;
                            double d20 = dArr[i + 4];
                            i += 6;
                            double d21 = dArr[i5];
                            iRectCrossingsForLine = Curve.rectCrossingsForCubic(iRectCrossingsForLine, d, d2, d3, d4, d6, d8, d16, d17, d18, d19, d20, d21, 0);
                            d7 = d15;
                            d6 = d20;
                            d8 = d21;
                        } else if (b == 4) {
                            if (d6 != d7 || d8 != d9) {
                                iRectCrossingsForLine = Curve.rectCrossingsForLine(iRectCrossingsForLine, d, d2, d3, d4, d6, d8, d7, d9);
                            }
                            d6 = d7;
                            d7 = d6;
                            d8 = d9;
                        }
                        d9 = d5;
                    } else {
                        double d22 = d7;
                        double d23 = d9;
                        int i6 = i + 1;
                        double d24 = dArr[i];
                        i += 2;
                        double d25 = dArr[i6];
                        iRectCrossingsForLine = Curve.rectCrossingsForLine(iRectCrossingsForLine, d, d2, d3, d4, d6, d8, d24, d25);
                        d6 = d24;
                        d8 = d25;
                        d9 = d23;
                        d7 = d22;
                    }
                } else {
                    double d26 = d7;
                    double d27 = d9;
                    if (d6 != d26 || d8 != d27) {
                        iRectCrossingsForLine = Curve.rectCrossingsForLine(iRectCrossingsForLine, d, d2, d3, d4, d6, d8, d26, d27);
                    }
                    int i7 = i + 1;
                    double d28 = dArr[i];
                    i += 2;
                    d6 = d28;
                    d7 = d6;
                    d8 = dArr[i7];
                }
                d9 = d8;
            }
            return (iRectCrossingsForLine == Integer.MIN_VALUE || (d6 == d7 && d8 == d9)) ? iRectCrossingsForLine : Curve.rectCrossingsForLine(iRectCrossingsForLine, d, d2, d3, d4, d6, d8, d7, d9);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final void transform(AffineTransform affineTransform) {
            double[] dArr = this.doubleCoords;
            affineTransform.transform(dArr, 0, dArr, 0, this.numCoords / 2);
        }

        public Double(int i) {
            this(i, 20);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public void append(float f, float f4) {
            double[] dArr = this.doubleCoords;
            int i = this.numCoords;
            int i2 = i + 1;
            this.numCoords = i2;
            dArr[i] = f;
            this.numCoords = i + 2;
            dArr[i2] = f4;
        }

        public Double(int i, int i2) {
            super(i, i2);
            this.doubleCoords = new double[i2 * 2];
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0085 A[PHI: r1
          0x0085: PHI (r1v4 org.apache.poi.java.awt.geom.Path2D$Double) = 
          (r1v3 org.apache.poi.java.awt.geom.Path2D$Double)
          (r1v3 org.apache.poi.java.awt.geom.Path2D$Double)
          (r1v3 org.apache.poi.java.awt.geom.Path2D$Double)
          (r1v5 org.apache.poi.java.awt.geom.Path2D$Double)
         binds: [B:25:0x006c, B:27:0x0078, B:29:0x0082, B:16:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // org.apache.poi.java.awt.geom.Path2D
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void append(PathIterator pathIterator, boolean z) {
            Double r12;
            int i;
            int i2;
            double[] dArr = new double[6];
            boolean z2 = z;
            while (!pathIterator.isDone()) {
                int iCurrentSegment = pathIterator.currentSegment(dArr);
                if (iCurrentSegment == 0) {
                    r12 = this;
                    if (!z2 || (i = r12.numTypes) < 1 || (i2 = r12.numCoords) < 1) {
                        r12.moveTo(dArr[0], dArr[1]);
                    } else if (r12.pointTypes[i - 1] != 4) {
                        double[] dArr2 = r12.doubleCoords;
                        if (dArr2[i2 - 2] != dArr[0] || dArr2[i2 - 1] != dArr[1]) {
                            r12.lineTo(dArr[0], dArr[1]);
                        }
                    }
                } else if (iCurrentSegment == 1) {
                    r12 = this;
                    r12.lineTo(dArr[0], dArr[1]);
                } else if (iCurrentSegment == 2) {
                    quadTo(dArr[0], dArr[1], dArr[2], dArr[3]);
                } else if (iCurrentSegment == 3) {
                    curveTo(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5]);
                } else if (iCurrentSegment == 4) {
                    closePath();
                }
                pathIterator.next();
                z2 = false;
            }
        }

        public Double(Shape shape) {
            this(shape, (AffineTransform) null);
        }

        public Double(Shape shape, AffineTransform affineTransform) {
            if (!(shape instanceof Path2D)) {
                PathIterator pathIterator = shape.getPathIterator(affineTransform);
                setWindingRule(pathIterator.getWindingRule());
                this.pointTypes = new byte[20];
                this.doubleCoords = new double[40];
                append(pathIterator, false);
                return;
            }
            Path2D path2D = (Path2D) shape;
            setWindingRule(path2D.windingRule);
            this.numTypes = path2D.numTypes;
            byte[] bArr = path2D.pointTypes;
            this.pointTypes = Arrays.copyOf(bArr, bArr.length);
            this.numCoords = path2D.numCoords;
            this.doubleCoords = path2D.cloneCoordsDouble(affineTransform);
        }
    }

    public static class Float extends Path2D implements Serializable {
        private static final long serialVersionUID = 6990832515060788886L;
        transient float[] floatCoords;

        public static class CopyIterator extends Iterator {
            float[] floatCoords;

            public CopyIterator(Float r12) {
                super(r12);
                this.floatCoords = r12.floatCoords;
            }

            @Override // org.apache.poi.java.awt.geom.PathIterator
            public int currentSegment(double[] dArr) {
                byte b = this.path.pointTypes[this.typeIdx];
                int i = Iterator.curvecoords[b];
                if (i > 0) {
                    for (int i2 = 0; i2 < i; i2++) {
                        dArr[i2] = this.floatCoords[this.pointIdx + i2];
                    }
                }
                return b;
            }

            @Override // org.apache.poi.java.awt.geom.PathIterator
            public int currentSegment(float[] fArr) {
                byte b = this.path.pointTypes[this.typeIdx];
                int i = Iterator.curvecoords[b];
                if (i > 0) {
                    System.arraycopy(this.floatCoords, this.pointIdx, fArr, 0, i);
                }
                return b;
            }
        }

        public static class TxIterator extends Iterator {
            AffineTransform affine;
            float[] floatCoords;

            public TxIterator(Float r12, AffineTransform affineTransform) {
                super(r12);
                this.floatCoords = r12.floatCoords;
                this.affine = affineTransform;
            }

            @Override // org.apache.poi.java.awt.geom.PathIterator
            public int currentSegment(double[] dArr) {
                byte b = this.path.pointTypes[this.typeIdx];
                int i = Iterator.curvecoords[b];
                if (i > 0) {
                    this.affine.transform(this.floatCoords, this.pointIdx, dArr, 0, i / 2);
                }
                return b;
            }

            @Override // org.apache.poi.java.awt.geom.PathIterator
            public int currentSegment(float[] fArr) {
                byte b = this.path.pointTypes[this.typeIdx];
                int i = Iterator.curvecoords[b];
                if (i > 0) {
                    this.affine.transform(this.floatCoords, this.pointIdx, fArr, 0, i / 2);
                }
                return b;
            }
        }

        public Float() {
            this(1, 20);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            readObject(objectInputStream, false);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            writeObject(objectOutputStream, false);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public void append(double d, double d2) {
            float[] fArr = this.floatCoords;
            int i = this.numCoords;
            int i2 = i + 1;
            this.numCoords = i2;
            fArr[i] = (float) d;
            this.numCoords = i + 2;
            fArr[i2] = (float) d2;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final Object clone() {
            return this instanceof GeneralPath ? new GeneralPath(this) : new Float(this);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public double[] cloneCoordsDouble(AffineTransform affineTransform) {
            float[] fArr = this.floatCoords;
            double[] dArr = new double[fArr.length];
            if (affineTransform != null) {
                affineTransform.transform(fArr, 0, dArr, 0, this.numCoords / 2);
                return dArr;
            }
            for (int i = 0; i < this.numCoords; i++) {
                dArr[i] = this.floatCoords[i];
            }
            return dArr;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public float[] cloneCoordsFloat(AffineTransform affineTransform) {
            if (affineTransform == null) {
                float[] fArr = this.floatCoords;
                return Arrays.copyOf(fArr, fArr.length);
            }
            float[] fArr2 = this.floatCoords;
            float[] fArr3 = new float[fArr2.length];
            affineTransform.transform(fArr2, 0, fArr3, 0, this.numCoords / 2);
            return fArr3;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final synchronized void curveTo(double d, double d2, double d3, double d4, double d5, double d6) {
            needRoom(true, 6);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 3;
            float[] fArr = this.floatCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            fArr[i2] = (float) d;
            int i5 = i2 + 2;
            this.numCoords = i5;
            fArr[i4] = (float) d2;
            int i6 = i2 + 3;
            this.numCoords = i6;
            fArr[i5] = (float) d3;
            int i7 = i2 + 4;
            this.numCoords = i7;
            fArr[i6] = (float) d4;
            int i8 = i2 + 5;
            this.numCoords = i8;
            fArr[i7] = (float) d5;
            this.numCoords = i2 + 6;
            fArr[i8] = (float) d6;
        }

        @Override // org.apache.poi.java.awt.Shape
        public final synchronized Rectangle2D getBounds2D() {
            float f;
            float f4;
            float f5;
            float f6;
            try {
                int i = this.numCoords;
                if (i > 0) {
                    float[] fArr = this.floatCoords;
                    float f7 = fArr[i - 1];
                    int i2 = i - 2;
                    f = fArr[i2];
                    f5 = f7;
                    f6 = f5;
                    f4 = f;
                    while (i2 > 0) {
                        float[] fArr2 = this.floatCoords;
                        float f8 = fArr2[i2 - 1];
                        i2 -= 2;
                        float f9 = fArr2[i2];
                        if (f9 < f) {
                            f = f9;
                        }
                        if (f8 < f5) {
                            f5 = f8;
                        }
                        if (f9 > f4) {
                            f4 = f9;
                        }
                        if (f8 > f6) {
                            f6 = f8;
                        }
                    }
                } else {
                    f = 0.0f;
                    f4 = 0.0f;
                    f5 = 0.0f;
                    f6 = 0.0f;
                }
            } catch (Throwable th) {
                throw th;
            }
            return new Rectangle2D.Float(f, f5, f4 - f, f6 - f5);
        }

        @Override // org.apache.poi.java.awt.Shape
        public final PathIterator getPathIterator(AffineTransform affineTransform) {
            return affineTransform == null ? new CopyIterator(this) : new TxIterator(this, affineTransform);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public Point2D getPoint(int i) {
            float[] fArr = this.floatCoords;
            return new Point2D.Float(fArr[i], fArr[i + 1]);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final synchronized void lineTo(double d, double d2) {
            needRoom(true, 2);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 1;
            float[] fArr = this.floatCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            fArr[i2] = (float) d;
            this.numCoords = i2 + 2;
            fArr[i4] = (float) d2;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final synchronized void moveTo(double d, double d2) {
            try {
                int i = this.numTypes;
                if (i <= 0 || this.pointTypes[i - 1] != 0) {
                    needRoom(false, 2);
                    byte[] bArr = this.pointTypes;
                    int i2 = this.numTypes;
                    this.numTypes = i2 + 1;
                    bArr[i2] = 0;
                    float[] fArr = this.floatCoords;
                    int i4 = this.numCoords;
                    int i5 = i4 + 1;
                    this.numCoords = i5;
                    fArr[i4] = (float) d;
                    this.numCoords = i4 + 2;
                    fArr[i5] = (float) d2;
                } else {
                    float[] fArr2 = this.floatCoords;
                    int i6 = this.numCoords;
                    fArr2[i6 - 2] = (float) d;
                    fArr2[i6 - 1] = (float) d2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public void needRoom(boolean z, int i) {
            if (z && this.numTypes == 0) {
                throw new IllegalPathStateException("missing initial moveto in path definition");
            }
            byte[] bArr = this.pointTypes;
            int length = bArr.length;
            if (this.numTypes >= length) {
                this.pointTypes = Arrays.copyOf(bArr, length + (length <= 500 ? length : 500));
            }
            float[] fArr = this.floatCoords;
            int length2 = fArr.length;
            if (this.numCoords + i > length2) {
                int i2 = length2 <= 1000 ? length2 : 1000;
                if (i2 >= i) {
                    i = i2;
                }
                this.floatCoords = Arrays.copyOf(fArr, length2 + i);
            }
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public int pointCrossings(double d, double d2) {
            float[] fArr;
            double d3;
            double d4;
            double d5;
            double d6;
            Float r02 = this;
            float[] fArr2 = r02.floatCoords;
            int iPointCrossingsForLine = 0;
            byte b = 1;
            byte b5 = 2;
            double d7 = fArr2[0];
            double d8 = d7;
            int i = 1;
            double d9 = fArr2[1];
            double d10 = d9;
            int i2 = 2;
            while (i < r02.numTypes) {
                byte b6 = r02.pointTypes[i];
                if (b6 != 0) {
                    if (b6 == b) {
                        fArr = fArr2;
                        d3 = d8;
                        d4 = d10;
                        int i4 = i2 + 1;
                        double d11 = fArr[i2];
                        i2 += 2;
                        double d12 = fArr[i4];
                        iPointCrossingsForLine += Curve.pointCrossingsForLine(d, d2, d7, d9, d11, d12);
                        d7 = d11;
                        d9 = d12;
                    } else if (b6 == b5) {
                        fArr = fArr2;
                        d3 = d8;
                        d4 = d10;
                        double d13 = fArr[i2];
                        double d14 = fArr[i2 + 1];
                        int i5 = i2 + 3;
                        double d15 = fArr[i2 + 2];
                        i2 += 4;
                        double d16 = fArr[i5];
                        iPointCrossingsForLine += Curve.pointCrossingsForQuad(d, d2, d7, d9, d13, d14, d15, d16, 0);
                        d7 = d15;
                        d9 = d16;
                    } else if (b6 == 3) {
                        d3 = d8;
                        d4 = d10;
                        double d17 = fArr2[i2];
                        double d18 = fArr2[i2 + 1];
                        double d19 = fArr2[i2 + 2];
                        fArr = fArr2;
                        double d20 = fArr2[i2 + 3];
                        int i6 = i2 + 5;
                        double d21 = fArr[i2 + 4];
                        i2 += 6;
                        double d22 = fArr[i6];
                        iPointCrossingsForLine += Curve.pointCrossingsForCubic(d, d2, d7, d9, d17, d18, d19, d20, d21, d22, 0);
                        d7 = d21;
                        d9 = d22;
                    } else if (b6 != 4) {
                        fArr = fArr2;
                        i++;
                        r02 = this;
                        fArr2 = fArr;
                        b = 1;
                        b5 = 2;
                    } else {
                        if (d9 != d10) {
                            d5 = d8;
                            d6 = d10;
                            iPointCrossingsForLine += Curve.pointCrossingsForLine(d, d2, d7, d9, d8, d10);
                        } else {
                            d5 = d8;
                            d6 = d10;
                        }
                        fArr = fArr2;
                        d9 = d6;
                        d10 = d9;
                        d7 = d5;
                    }
                    d10 = d4;
                    d8 = d3;
                    i++;
                    r02 = this;
                    fArr2 = fArr;
                    b = 1;
                    b5 = 2;
                } else {
                    fArr = fArr2;
                    double d23 = d8;
                    double d24 = d10;
                    if (d9 != d24) {
                        iPointCrossingsForLine += Curve.pointCrossingsForLine(d, d2, d7, d9, d23, d24);
                    }
                    int i7 = i2 + 1;
                    double d25 = fArr[i2];
                    i2 += 2;
                    d9 = fArr[i7];
                    d10 = d9;
                    d7 = d25;
                }
                d8 = d7;
                i++;
                r02 = this;
                fArr2 = fArr;
                b = 1;
                b5 = 2;
            }
            return d9 != d10 ? iPointCrossingsForLine + Curve.pointCrossingsForLine(d, d2, d7, d9, d8, d10) : iPointCrossingsForLine;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final synchronized void quadTo(double d, double d2, double d3, double d4) {
            needRoom(true, 4);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 2;
            float[] fArr = this.floatCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            fArr[i2] = (float) d;
            int i5 = i2 + 2;
            this.numCoords = i5;
            fArr[i4] = (float) d2;
            int i6 = i2 + 3;
            this.numCoords = i6;
            fArr[i5] = (float) d3;
            this.numCoords = i2 + 4;
            fArr[i6] = (float) d4;
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public int rectCrossings(double d, double d2, double d3, double d4) {
            float[] fArr;
            double d5;
            double d6;
            Float r02 = this;
            float[] fArr2 = r02.floatCoords;
            byte b = 1;
            byte b5 = 2;
            int iRectCrossingsForLine = 0;
            double d7 = fArr2[0];
            double d8 = d7;
            int i = 1;
            double d9 = fArr2[1];
            double d10 = d9;
            int i2 = 2;
            while (iRectCrossingsForLine != Integer.MIN_VALUE && i < r02.numTypes) {
                byte b6 = r02.pointTypes[i];
                if (b6 != 0) {
                    if (b6 == b) {
                        fArr = fArr2;
                        d5 = d8;
                        d6 = d10;
                        int i4 = i2 + 1;
                        double d11 = fArr[i2];
                        i2 += 2;
                        double d12 = fArr[i4];
                        iRectCrossingsForLine = Curve.rectCrossingsForLine(iRectCrossingsForLine, d, d2, d3, d4, d7, d9, d11, d12);
                        d7 = d11;
                        d9 = d12;
                    } else if (b6 == b5) {
                        fArr = fArr2;
                        d5 = d8;
                        d6 = d10;
                        double d13 = fArr[i2];
                        double d14 = fArr[i2 + 1];
                        int i5 = i2 + 3;
                        double d15 = fArr[i2 + 2];
                        i2 += 4;
                        double d16 = fArr[i5];
                        iRectCrossingsForLine = Curve.rectCrossingsForQuad(iRectCrossingsForLine, d, d2, d3, d4, d7, d9, d13, d14, d15, d16, 0);
                        d7 = d15;
                        d9 = d16;
                    } else if (b6 == 3) {
                        d6 = d10;
                        double d17 = fArr2[i2];
                        double d18 = fArr2[i2 + 1];
                        d5 = d8;
                        double d19 = fArr2[i2 + 2];
                        double d20 = fArr2[i2 + 3];
                        int i6 = i2 + 5;
                        fArr = fArr2;
                        double d21 = fArr2[i2 + 4];
                        i2 += 6;
                        double d22 = fArr[i6];
                        iRectCrossingsForLine = Curve.rectCrossingsForCubic(iRectCrossingsForLine, d, d2, d3, d4, d7, d9, d17, d18, d19, d20, d21, d22, 0);
                        d7 = d21;
                        d9 = d22;
                    } else if (b6 != 4) {
                        fArr = fArr2;
                    } else {
                        if (d7 != d8 || d9 != d10) {
                            iRectCrossingsForLine = Curve.rectCrossingsForLine(iRectCrossingsForLine, d, d2, d3, d4, d7, d9, d8, d10);
                        }
                        fArr = fArr2;
                        d7 = d8;
                        d8 = d7;
                        d9 = d10;
                        d10 = d9;
                    }
                    d10 = d6;
                    d8 = d5;
                } else {
                    fArr = fArr2;
                    double d23 = d8;
                    double d24 = d10;
                    if (d7 != d23 || d9 != d24) {
                        iRectCrossingsForLine = Curve.rectCrossingsForLine(iRectCrossingsForLine, d, d2, d3, d4, d7, d9, d23, d24);
                    }
                    int i7 = i2 + 1;
                    double d25 = fArr[i2];
                    i2 += 2;
                    d9 = fArr[i7];
                    d10 = d9;
                    d7 = d25;
                    d8 = d7;
                }
                i++;
                r02 = this;
                fArr2 = fArr;
                b = 1;
                b5 = 2;
            }
            return (iRectCrossingsForLine == Integer.MIN_VALUE || (d7 == d8 && d9 == d10)) ? iRectCrossingsForLine : Curve.rectCrossingsForLine(iRectCrossingsForLine, d, d2, d3, d4, d7, d9, d8, d10);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public final void transform(AffineTransform affineTransform) {
            float[] fArr = this.floatCoords;
            affineTransform.transform(fArr, 0, fArr, 0, this.numCoords / 2);
        }

        public Float(int i) {
            this(i, 20);
        }

        @Override // org.apache.poi.java.awt.geom.Path2D
        public void append(float f, float f4) {
            float[] fArr = this.floatCoords;
            int i = this.numCoords;
            int i2 = i + 1;
            this.numCoords = i2;
            fArr[i] = f;
            this.numCoords = i + 2;
            fArr[i2] = f4;
        }

        public final synchronized void curveTo(float f, float f4, float f5, float f6, float f7, float f8) {
            needRoom(true, 6);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 3;
            float[] fArr = this.floatCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            fArr[i2] = f;
            int i5 = i2 + 2;
            this.numCoords = i5;
            fArr[i4] = f4;
            int i6 = i2 + 3;
            this.numCoords = i6;
            fArr[i5] = f5;
            int i7 = i2 + 4;
            this.numCoords = i7;
            fArr[i6] = f6;
            int i8 = i2 + 5;
            this.numCoords = i8;
            fArr[i7] = f7;
            this.numCoords = i2 + 6;
            fArr[i8] = f8;
        }

        public final synchronized void lineTo(float f, float f4) {
            needRoom(true, 2);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 1;
            float[] fArr = this.floatCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            fArr[i2] = f;
            this.numCoords = i2 + 2;
            fArr[i4] = f4;
        }

        public final synchronized void moveTo(float f, float f4) {
            try {
                int i = this.numTypes;
                if (i <= 0 || this.pointTypes[i - 1] != 0) {
                    needRoom(false, 2);
                    byte[] bArr = this.pointTypes;
                    int i2 = this.numTypes;
                    this.numTypes = i2 + 1;
                    bArr[i2] = 0;
                    float[] fArr = this.floatCoords;
                    int i4 = this.numCoords;
                    int i5 = i4 + 1;
                    this.numCoords = i5;
                    fArr[i4] = f;
                    this.numCoords = i4 + 2;
                    fArr[i5] = f4;
                } else {
                    float[] fArr2 = this.floatCoords;
                    int i6 = this.numCoords;
                    fArr2[i6 - 2] = f;
                    fArr2[i6 - 1] = f4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void quadTo(float f, float f4, float f5, float f6) {
            needRoom(true, 4);
            byte[] bArr = this.pointTypes;
            int i = this.numTypes;
            this.numTypes = i + 1;
            bArr[i] = 2;
            float[] fArr = this.floatCoords;
            int i2 = this.numCoords;
            int i4 = i2 + 1;
            this.numCoords = i4;
            fArr[i2] = f;
            int i5 = i2 + 2;
            this.numCoords = i5;
            fArr[i4] = f4;
            int i6 = i2 + 3;
            this.numCoords = i6;
            fArr[i5] = f5;
            this.numCoords = i2 + 4;
            fArr[i6] = f6;
        }

        public Float(int i, int i2) {
            super(i, i2);
            this.floatCoords = new float[i2 * 2];
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
        @Override // org.apache.poi.java.awt.geom.Path2D
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void append(PathIterator pathIterator, boolean z) {
            int i;
            int i2;
            float[] fArr = new float[6];
            while (!pathIterator.isDone()) {
                int iCurrentSegment = pathIterator.currentSegment(fArr);
                if (iCurrentSegment != 0) {
                    if (iCurrentSegment == 1) {
                        lineTo(fArr[0], fArr[1]);
                    } else if (iCurrentSegment == 2) {
                        quadTo(fArr[0], fArr[1], fArr[2], fArr[3]);
                    } else if (iCurrentSegment == 3) {
                        curveTo(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
                    } else if (iCurrentSegment == 4) {
                        closePath();
                    }
                } else if (!z || (i = this.numTypes) < 1 || (i2 = this.numCoords) < 1) {
                    moveTo(fArr[0], fArr[1]);
                } else if (this.pointTypes[i - 1] != 4) {
                    float[] fArr2 = this.floatCoords;
                    if (fArr2[i2 - 2] != fArr[0] || fArr2[i2 - 1] != fArr[1]) {
                        lineTo(fArr[0], fArr[1]);
                    }
                }
                pathIterator.next();
                z = false;
            }
        }

        public Float(Shape shape) {
            this(shape, (AffineTransform) null);
        }

        public Float(Shape shape, AffineTransform affineTransform) {
            if (!(shape instanceof Path2D)) {
                PathIterator pathIterator = shape.getPathIterator(affineTransform);
                setWindingRule(pathIterator.getWindingRule());
                this.pointTypes = new byte[20];
                this.floatCoords = new float[40];
                append(pathIterator, false);
                return;
            }
            Path2D path2D = (Path2D) shape;
            setWindingRule(path2D.windingRule);
            this.numTypes = path2D.numTypes;
            byte[] bArr = path2D.pointTypes;
            this.pointTypes = Arrays.copyOf(bArr, bArr.length);
            this.numCoords = path2D.numCoords;
            this.floatCoords = path2D.cloneCoordsFloat(affineTransform);
        }
    }

    public static abstract class Iterator implements PathIterator {
        static final int[] curvecoords = {2, 2, 4, 6, 0};
        Path2D path;
        int pointIdx;
        int typeIdx;

        public Iterator(Path2D path2D) {
            this.path = path2D;
        }

        @Override // org.apache.poi.java.awt.geom.PathIterator
        public int getWindingRule() {
            return this.path.getWindingRule();
        }

        @Override // org.apache.poi.java.awt.geom.PathIterator
        public boolean isDone() {
            return this.typeIdx >= this.path.numTypes;
        }

        @Override // org.apache.poi.java.awt.geom.PathIterator
        public void next() {
            byte[] bArr = this.path.pointTypes;
            int i = this.typeIdx;
            this.typeIdx = i + 1;
            this.pointIdx += curvecoords[bArr[i]];
        }
    }

    public Path2D() {
    }

    public abstract void append(double d, double d2);

    public abstract void append(float f, float f4);

    public final void append(Shape shape, boolean z) {
        append(shape.getPathIterator(null), z);
    }

    public abstract void append(PathIterator pathIterator, boolean z);

    public abstract Object clone();

    public abstract double[] cloneCoordsDouble(AffineTransform affineTransform);

    public abstract float[] cloneCoordsFloat(AffineTransform affineTransform);

    public final synchronized void closePath() {
        try {
            int i = this.numTypes;
            if (i == 0 || this.pointTypes[i - 1] != 4) {
                needRoom(true, 0);
                byte[] bArr = this.pointTypes;
                int i2 = this.numTypes;
                this.numTypes = i2 + 1;
                bArr[i2] = 4;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.Shape
    public final boolean contains(double d, double d2) {
        if ((d2 * 0.0d) + (d * 0.0d) != 0.0d || this.numTypes < 2) {
            return false;
        }
        return (pointCrossings(d, d2) & (this.windingRule == 1 ? -1 : 1)) != 0;
    }

    public final synchronized Shape createTransformedShape(AffineTransform affineTransform) {
        Path2D path2D;
        path2D = (Path2D) clone();
        if (affineTransform != null) {
            path2D.transform(affineTransform);
        }
        return path2D;
    }

    public abstract void curveTo(double d, double d2, double d3, double d4, double d5, double d6);

    @Override // org.apache.poi.java.awt.Shape
    public final Rectangle getBounds() {
        return getBounds2D().getBounds();
    }

    public final synchronized Point2D getCurrentPoint() {
        try {
            int i = this.numCoords;
            int i2 = this.numTypes;
            if (i2 >= 1 && i >= 1) {
                if (this.pointTypes[i2 - 1] == 4) {
                    for (int i4 = i2 - 2; i4 > 0; i4--) {
                        byte b = this.pointTypes[i4];
                        if (b == 0) {
                            break;
                        }
                        if (b == 1) {
                            i -= 2;
                        } else if (b == 2) {
                            i -= 4;
                        } else if (b == 3) {
                            i -= 6;
                        }
                    }
                }
                return getPoint(i - 2);
            }
            return null;
        } finally {
        }
    }

    @Override // org.apache.poi.java.awt.Shape
    public final PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new FlatteningPathIterator(getPathIterator(affineTransform), d);
    }

    public abstract Point2D getPoint(int i);

    public final synchronized int getWindingRule() {
        return this.windingRule;
    }

    @Override // org.apache.poi.java.awt.Shape
    public final boolean intersects(double d, double d2, double d3, double d4) {
        double d5 = d + d3;
        if (!java.lang.Double.isNaN(d5)) {
            double d6 = d2 + d4;
            if (!java.lang.Double.isNaN(d6) && d3 > 0.0d && d4 > 0.0d) {
                int i = this.windingRule == 1 ? -1 : 2;
                int iRectCrossings = rectCrossings(d, d2, d5, d6);
                return iRectCrossings == Integer.MIN_VALUE || (iRectCrossings & i) != 0;
            }
        }
        return false;
    }

    public abstract void lineTo(double d, double d2);

    public abstract void moveTo(double d, double d2);

    public abstract void needRoom(boolean z, int i);

    public abstract int pointCrossings(double d, double d2);

    public abstract void quadTo(double d, double d2, double d3, double d4);

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
    
        if (r0 < 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        if (r10.readByte() != 97) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0082, code lost:
    
        throw new java.io.StreamCorruptedException("missing PATH_END");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009a A[LOOP:1: B:52:0x009a->B:54:0x009e, LOOP_START, PHI: r4
      0x009a: PHI (r4v6 int) = (r4v2 int), (r4v7 int) binds: [B:51:0x0098, B:54:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00aa A[LOOP:2: B:55:0x00aa->B:57:0x00ae, LOOP_START, PHI: r4
      0x00aa: PHI (r4v3 int) = (r4v2 int), (r4v4 int) binds: [B:51:0x0098, B:57:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void readObject(ObjectInputStream objectInputStream, boolean z) throws ClassNotFoundException, IOException {
        byte b;
        int i;
        int i2;
        objectInputStream.defaultReadObject();
        objectInputStream.readByte();
        int i4 = objectInputStream.readInt();
        int i5 = objectInputStream.readInt();
        try {
            setWindingRule(objectInputStream.readByte());
            this.pointTypes = new byte[i4 < 0 ? 20 : i4];
            if (i5 < 0) {
                i5 = 40;
            }
            if (z) {
                ((Double) this).doubleCoords = new double[i5];
            } else {
                ((Float) this).floatCoords = new float[i5];
            }
            int i6 = 0;
            while (true) {
                if (i4 < 0 || i6 < i4) {
                    byte b5 = objectInputStream.readByte();
                    if (b5 == 96) {
                        b = 4;
                        i = 0;
                    } else if (b5 != 97) {
                        b = 3;
                        i2 = 2;
                        switch (b5) {
                            case 64:
                                b = 0;
                                i = 0;
                                i2 = 1;
                                needRoom(b != 0, i2 * 2);
                                if (i != 0) {
                                    while (true) {
                                        i2--;
                                        if (i2 >= 0) {
                                            append(objectInputStream.readDouble(), objectInputStream.readDouble());
                                        }
                                    }
                                } else {
                                    while (true) {
                                        i2--;
                                        if (i2 >= 0) {
                                            append(objectInputStream.readFloat(), objectInputStream.readFloat());
                                        }
                                    }
                                }
                                byte[] bArr = this.pointTypes;
                                int i7 = this.numTypes;
                                this.numTypes = i7 + 1;
                                bArr[i7] = b;
                                i6++;
                                break;
                            case 65:
                                i = 0;
                                b = 1;
                                i2 = b;
                                needRoom(b != 0, i2 * 2);
                                if (i != 0) {
                                }
                                byte[] bArr2 = this.pointTypes;
                                int i72 = this.numTypes;
                                this.numTypes = i72 + 1;
                                bArr2[i72] = b;
                                i6++;
                                break;
                            case 66:
                                i = 0;
                                b = 2;
                                needRoom(b != 0, i2 * 2);
                                if (i != 0) {
                                }
                                byte[] bArr22 = this.pointTypes;
                                int i722 = this.numTypes;
                                this.numTypes = i722 + 1;
                                bArr22[i722] = b;
                                i6++;
                                break;
                            case 67:
                                i = 0;
                                i2 = b;
                                needRoom(b != 0, i2 * 2);
                                if (i != 0) {
                                }
                                byte[] bArr222 = this.pointTypes;
                                int i7222 = this.numTypes;
                                this.numTypes = i7222 + 1;
                                bArr222[i7222] = b;
                                i6++;
                                break;
                            default:
                                switch (b5) {
                                    case 80:
                                        b = 0;
                                        i = 1;
                                        break;
                                    case 81:
                                        b = 1;
                                        i = 1;
                                        break;
                                    case 82:
                                        b = 2;
                                        i = 1;
                                        needRoom(b != 0, i2 * 2);
                                        if (i != 0) {
                                        }
                                        byte[] bArr2222 = this.pointTypes;
                                        int i72222 = this.numTypes;
                                        this.numTypes = i72222 + 1;
                                        bArr2222[i72222] = b;
                                        i6++;
                                        break;
                                    case 83:
                                        i2 = 3;
                                        i = 1;
                                        needRoom(b != 0, i2 * 2);
                                        if (i != 0) {
                                        }
                                        byte[] bArr22222 = this.pointTypes;
                                        int i722222 = this.numTypes;
                                        this.numTypes = i722222 + 1;
                                        bArr22222[i722222] = b;
                                        i6++;
                                        break;
                                    default:
                                        throw new StreamCorruptedException("unrecognized path type");
                                }
                                break;
                        }
                    } else if (i4 >= 0) {
                        throw new StreamCorruptedException("unexpected PATH_END");
                    }
                    i2 = i;
                    needRoom(b != 0, i2 * 2);
                    if (i != 0) {
                    }
                    byte[] bArr222222 = this.pointTypes;
                    int i7222222 = this.numTypes;
                    this.numTypes = i7222222 + 1;
                    bArr222222[i7222222] = b;
                    i6++;
                }
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidObjectException(e.getMessage());
        }
    }

    public abstract int rectCrossings(double d, double d2, double d3, double d4);

    public final synchronized void reset() {
        this.numCoords = 0;
        this.numTypes = 0;
    }

    public final void setWindingRule(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("winding rule must be WIND_EVEN_ODD or WIND_NON_ZERO");
        }
        this.windingRule = i;
    }

    public abstract void transform(AffineTransform affineTransform);

    public final void writeObject(ObjectOutputStream objectOutputStream, boolean z) throws IOException {
        double[] dArr;
        int i;
        objectOutputStream.defaultWriteObject();
        float[] fArr = null;
        if (z) {
            dArr = ((Double) this).doubleCoords;
        } else {
            dArr = null;
            fArr = ((Float) this).floatCoords;
        }
        int i2 = this.numTypes;
        objectOutputStream.writeByte(z ? 49 : 48);
        objectOutputStream.writeInt(i2);
        objectOutputStream.writeInt(this.numCoords);
        objectOutputStream.writeByte((byte) this.windingRule);
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b = this.pointTypes[i5];
            int i6 = 1;
            if (b == 0) {
                i = z ? 80 : 64;
            } else if (b != 1) {
                i6 = 2;
                if (b != 2) {
                    i6 = 3;
                    if (b == 3) {
                        i = z ? 83 : 67;
                    } else {
                        if (b != 4) {
                            throw new InternalError("unrecognized path type");
                        }
                        i = 96;
                        i6 = 0;
                    }
                } else {
                    i = z ? 82 : 66;
                }
            } else {
                i = z ? 81 : 65;
            }
            objectOutputStream.writeByte(i);
            while (true) {
                i6--;
                if (i6 >= 0) {
                    int i7 = i4 + 1;
                    if (z) {
                        objectOutputStream.writeDouble(dArr[i4]);
                        i4 += 2;
                        objectOutputStream.writeDouble(dArr[i7]);
                    } else {
                        objectOutputStream.writeFloat(fArr[i4]);
                        i4 += 2;
                        objectOutputStream.writeFloat(fArr[i7]);
                    }
                }
            }
        }
        objectOutputStream.writeByte(97);
    }

    public Path2D(int i, int i2) {
        setWindingRule(i);
        this.pointTypes = new byte[i2];
    }

    public static boolean intersects(PathIterator pathIterator, double d, double d2, double d3, double d4) {
        double d5 = d + d3;
        if (!java.lang.Double.isNaN(d5)) {
            double d6 = d2 + d4;
            if (!java.lang.Double.isNaN(d6) && d3 > 0.0d && d4 > 0.0d) {
                int i = pathIterator.getWindingRule() == 1 ? -1 : 2;
                int iRectCrossingsForPath = Curve.rectCrossingsForPath(pathIterator, d, d2, d5, d6);
                return iRectCrossingsForPath == Integer.MIN_VALUE || (iRectCrossingsForPath & i) != 0;
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.Shape
    public final boolean contains(double d, double d2, double d3, double d4) {
        double d5 = d + d3;
        if (!java.lang.Double.isNaN(d5)) {
            double d6 = d2 + d4;
            if (!java.lang.Double.isNaN(d6) && d3 > 0.0d && d4 > 0.0d) {
                int i = this.windingRule == 1 ? -1 : 2;
                int iRectCrossings = rectCrossings(d, d2, d5, d6);
                if (iRectCrossings != Integer.MIN_VALUE && (iRectCrossings & i) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean contains(PathIterator pathIterator, double d, double d2) {
        if ((d2 * 0.0d) + (d * 0.0d) == 0.0d) {
            if ((Curve.pointCrossingsForPath(pathIterator, d, d2) & (pathIterator.getWindingRule() == 1 ? -1 : 1)) != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean intersects(PathIterator pathIterator, Rectangle2D rectangle2D) {
        return intersects(pathIterator, rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public static boolean contains(PathIterator pathIterator, double d, double d2, double d3, double d4) {
        double d5 = d + d3;
        if (!java.lang.Double.isNaN(d5)) {
            double d6 = d2 + d4;
            if (!java.lang.Double.isNaN(d6) && d3 > 0.0d && d4 > 0.0d) {
                int i = pathIterator.getWindingRule() == 1 ? -1 : 2;
                int iRectCrossingsForPath = Curve.rectCrossingsForPath(pathIterator, d, d2, d5, d6);
                if (iRectCrossingsForPath != Integer.MIN_VALUE && (iRectCrossingsForPath & i) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.Shape
    public final boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public static boolean contains(PathIterator pathIterator, Point2D point2D) {
        return contains(pathIterator, point2D.getX(), point2D.getY());
    }

    public static boolean contains(PathIterator pathIterator, Rectangle2D rectangle2D) {
        return contains(pathIterator, rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override // org.apache.poi.java.awt.Shape
    public final boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    @Override // org.apache.poi.java.awt.Shape
    public final boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
}
