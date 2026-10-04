package org.apache.poi.java.awt.geom;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.beans.ConstructorProperties;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.poi.java.awt.Shape;
import org.apache.poi.java.awt.geom.Path2D;
import org.apache.poi.java.awt.geom.Point2D;

/* JADX INFO: loaded from: classes10.dex */
public class AffineTransform implements Cloneable, Serializable {
    static final int APPLY_IDENTITY = 0;
    static final int APPLY_SCALE = 2;
    static final int APPLY_SHEAR = 4;
    static final int APPLY_TRANSLATE = 1;
    private static final int HI_IDENTITY = 0;
    private static final int HI_SCALE = 16;
    private static final int HI_SHEAR = 32;
    private static final int HI_SHIFT = 3;
    private static final int HI_TRANSLATE = 8;
    public static final int TYPE_FLIP = 64;
    public static final int TYPE_GENERAL_ROTATION = 16;
    public static final int TYPE_GENERAL_SCALE = 4;
    public static final int TYPE_GENERAL_TRANSFORM = 32;
    public static final int TYPE_IDENTITY = 0;
    public static final int TYPE_MASK_ROTATION = 24;
    public static final int TYPE_MASK_SCALE = 6;
    public static final int TYPE_QUADRANT_ROTATION = 8;
    public static final int TYPE_TRANSLATION = 1;
    public static final int TYPE_UNIFORM_SCALE = 2;
    private static final int TYPE_UNKNOWN = -1;
    private static final int[] rot90conversion = {4, 5, 4, 5, 2, 3, 6, 7};
    private static final long serialVersionUID = 1330973210523860834L;
    double m00;
    double m01;
    double m02;
    double m10;
    double m11;
    double m12;
    transient int state;
    private transient int type;

    public AffineTransform() {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
    }

    private static double _matround(double d) {
        return Math.rint(d * 1.0E15d) / 1.0E15d;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2 A[PHI: r1
      0x00a2: PHI (r1v6 int) = (r1v2 int), (r1v8 int) binds: [B:86:0x00e0, B:58:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6 A[PHI: r1
      0x00a6: PHI (r1v5 int) = (r1v2 int), (r1v8 int), (r1v8 int) binds: [B:86:0x00e0, B:56:0x009c, B:58:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void calculateType() {
        int i;
        int i2;
        double d;
        int i4;
        double d2;
        int i5;
        double d3;
        double d4;
        double d5;
        double d6;
        updateState();
        switch (this.state) {
            case 0:
                i = 0;
            case 1:
                this.type = i;
                break;
            case 2:
                i = 0;
                double d7 = this.m00;
                i2 = d7 < 0.0d ? 1 : 0;
                d = this.m11;
                if (i2 == (d < 0.0d ? 0 : 1)) {
                    i = d7 == (-d) ? (d7 == 1.0d || d7 == -1.0d) ? i | 64 : i | 66 : i | 68;
                } else if (i2 != 0) {
                    i = d7 == d ? i | 2 : i | 4;
                } else {
                    if (d7 == d) {
                        i = d7 != -1.0d ? i | 10 : i | 8;
                    }
                    i = i | 12;
                }
                this.type = i;
                break;
            case 3:
                i = 1;
                double d72 = this.m00;
                if (d72 < 0.0d) {
                }
                d = this.m11;
                if (i2 == (d < 0.0d ? 0 : 1)) {
                }
                this.type = i;
                break;
            case 4:
                i = 0;
                double d8 = this.m01;
                i4 = d8 < 0.0d ? 1 : 0;
                d2 = this.m10;
                if (i4 != (d2 < 0.0d ? 0 : 1)) {
                    i = d8 == d2 ? i | 74 : i | 76;
                    this.type = i;
                } else {
                    if (d8 == (-d2)) {
                        if (d8 == 1.0d || d8 == -1.0d) {
                        }
                        this.type = i;
                    }
                    i = i | 12;
                    this.type = i;
                }
                break;
            case 5:
                i = 1;
                double d82 = this.m01;
                if (d82 < 0.0d) {
                }
                d2 = this.m10;
                if (i4 != (d2 < 0.0d ? 0 : 1)) {
                }
                break;
            case 6:
                i5 = 0;
                d3 = this.m00;
                d4 = this.m01;
                d5 = this.m10;
                d6 = this.m11;
                if ((d5 * d6) + (d3 * d4) != 0.0d) {
                    i = ((d3 > 0.0d ? 1 : (d3 == 0.0d ? 0 : -1)) >= 0 ? 1 : 0) == (d6 < 0.0d ? 0 : 1) ? (d3 == d6 && d4 == (-d5)) ? (d3 * d6) - (d4 * d5) != 1.0d ? i5 | 18 : i5 | 16 : i5 | 20 : (d3 == (-d6) && d4 == d5) ? (d3 * d6) - (d4 * d5) != 1.0d ? i5 | 82 : i5 | 80 : i5 | 84;
                    this.type = i;
                } else {
                    this.type = 32;
                }
                break;
            default:
                stateError();
            case 7:
                i5 = 1;
                d3 = this.m00;
                d4 = this.m01;
                d5 = this.m10;
                d6 = this.m11;
                if ((d5 * d6) + (d3 * d4) != 0.0d) {
                }
                break;
        }
    }

    public static AffineTransform getQuadrantRotateInstance(int i) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToQuadrantRotation(i);
        return affineTransform;
    }

    public static AffineTransform getRotateInstance(double d) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d);
        return affineTransform;
    }

    public static AffineTransform getScaleInstance(double d, double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToScale(d, d2);
        return affineTransform;
    }

    public static AffineTransform getShearInstance(double d, double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToShear(d, d2);
        return affineTransform;
    }

    public static AffineTransform getTranslateInstance(double d, double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToTranslation(d, d2);
        return affineTransform;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        updateState();
    }

    private final void rotate180() {
        double d = -this.m00;
        this.m00 = d;
        double d2 = -this.m11;
        this.m11 = d2;
        int i = this.state;
        if ((i & 4) != 0) {
            this.m01 = -this.m01;
            this.m10 = -this.m10;
        } else {
            this.state = (d == 1.0d && d2 == 1.0d) ? i & (-3) : i | 2;
        }
        this.type = -1;
    }

    private final void rotate270() {
        double d = this.m00;
        double d2 = -this.m01;
        this.m00 = d2;
        this.m01 = d;
        double d3 = this.m10;
        this.m10 = -this.m11;
        this.m11 = d3;
        int i = rot90conversion[this.state];
        if ((i & 6) == 2 && d2 == 1.0d && d3 == 1.0d) {
            i -= 2;
        }
        this.state = i;
        this.type = -1;
    }

    private final void rotate90() {
        double d = this.m00;
        double d2 = this.m01;
        this.m00 = d2;
        this.m01 = -d;
        double d3 = this.m10;
        this.m10 = this.m11;
        double d4 = -d3;
        this.m11 = d4;
        int i = rot90conversion[this.state];
        if ((i & 6) == 2 && d2 == 1.0d && d4 == 1.0d) {
            i -= 2;
        }
        this.state = i;
        this.type = -1;
    }

    private void stateError() {
        throw new InternalError("missing case in transform state switch");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void concatenate(AffineTransform affineTransform) {
        int i = this.state;
        int i2 = affineTransform.state;
        int i4 = (i2 << 3) | i;
        if (i4 != 48) {
            if (i4 != 56) {
                switch (i4) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        return;
                    case 8:
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        translate(affineTransform.m02, affineTransform.m12);
                        return;
                    case 16:
                        break;
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        scale(affineTransform.m00, affineTransform.m11);
                        return;
                    case 24:
                        break;
                    default:
                        switch (i4) {
                            case 32:
                                break;
                            case 33:
                                this.m00 = 0.0d;
                                this.m01 = affineTransform.m01;
                                this.m10 = affineTransform.m10;
                                this.m11 = 0.0d;
                                this.state = 5;
                                this.type = -1;
                                return;
                            case 34:
                            case 35:
                                this.m01 = this.m00 * affineTransform.m01;
                                this.m00 = 0.0d;
                                this.m10 = this.m11 * affineTransform.m10;
                                this.m11 = 0.0d;
                                this.state = i ^ 6;
                                this.type = -1;
                                return;
                            case 36:
                            case 37:
                                this.m00 = this.m01 * affineTransform.m10;
                                this.m01 = 0.0d;
                                this.m11 = this.m10 * affineTransform.m01;
                                this.m10 = 0.0d;
                                this.state = i ^ 6;
                                this.type = -1;
                                return;
                            case 38:
                            case 39:
                                double d = affineTransform.m01;
                                double d2 = affineTransform.m10;
                                double d3 = this.m00;
                                this.m00 = this.m01 * d2;
                                this.m01 = d3 * d;
                                double d4 = this.m10;
                                this.m10 = this.m11 * d2;
                                this.m11 = d4 * d;
                                this.type = -1;
                                return;
                            case 40:
                                this.m02 = affineTransform.m02;
                                this.m12 = affineTransform.m12;
                                break;
                            default:
                                double d5 = affineTransform.m00;
                                double d6 = affineTransform.m01;
                                double d7 = affineTransform.m02;
                                double d8 = affineTransform.m10;
                                double d9 = affineTransform.m11;
                                double d10 = affineTransform.m12;
                                switch (i) {
                                    case 1:
                                        this.m00 = d5;
                                        this.m01 = d6;
                                        this.m02 += d7;
                                        this.m10 = d8;
                                        this.m11 = d9;
                                        this.m12 += d10;
                                        this.state = i2 | 1;
                                        this.type = -1;
                                        break;
                                    case 2:
                                    case 3:
                                        double d11 = this.m00;
                                        this.m00 = d5 * d11;
                                        this.m01 = d6 * d11;
                                        this.m02 = (d7 * d11) + this.m02;
                                        double d12 = this.m11;
                                        this.m10 = d8 * d12;
                                        this.m11 = d9 * d12;
                                        this.m12 = (d10 * d12) + this.m12;
                                        updateState();
                                        break;
                                    case 4:
                                    case 5:
                                        double d13 = this.m01;
                                        this.m00 = d8 * d13;
                                        this.m01 = d9 * d13;
                                        this.m02 = (d10 * d13) + this.m02;
                                        double d14 = this.m10;
                                        this.m10 = d5 * d14;
                                        this.m11 = d6 * d14;
                                        this.m12 = (d7 * d14) + this.m12;
                                        updateState();
                                        break;
                                    case 6:
                                        this.state = i | i2;
                                        double d15 = this.m00;
                                        double d16 = this.m01;
                                        this.m00 = (d8 * d16) + (d5 * d15);
                                        this.m01 = (d9 * d16) + (d6 * d15);
                                        this.m02 = AbstractC1974b.m1307D(d10, d16, d7 * d15, this.m02);
                                        double d17 = this.m10;
                                        double d18 = this.m11;
                                        this.m10 = (d8 * d18) + (d5 * d17);
                                        this.m11 = (d9 * d18) + (d6 * d17);
                                        this.m12 = AbstractC1974b.m1307D(d10, d18, d7 * d17, this.m12);
                                        this.type = -1;
                                        break;
                                    case 7:
                                        double d152 = this.m00;
                                        double d162 = this.m01;
                                        this.m00 = (d8 * d162) + (d5 * d152);
                                        this.m01 = (d9 * d162) + (d6 * d152);
                                        this.m02 = AbstractC1974b.m1307D(d10, d162, d7 * d152, this.m02);
                                        double d172 = this.m10;
                                        double d182 = this.m11;
                                        this.m10 = (d8 * d182) + (d5 * d172);
                                        this.m11 = (d9 * d182) + (d6 * d172);
                                        this.m12 = AbstractC1974b.m1307D(d10, d182, d7 * d172, this.m12);
                                        this.type = -1;
                                        break;
                                    default:
                                        stateError();
                                        this.state = i | i2;
                                        double d1522 = this.m00;
                                        double d1622 = this.m01;
                                        this.m00 = (d8 * d1622) + (d5 * d1522);
                                        this.m01 = (d9 * d1622) + (d6 * d1522);
                                        this.m02 = AbstractC1974b.m1307D(d10, d1622, d7 * d1522, this.m02);
                                        double d1722 = this.m10;
                                        double d1822 = this.m11;
                                        this.m10 = (d8 * d1822) + (d5 * d1722);
                                        this.m11 = (d9 * d1822) + (d6 * d1722);
                                        this.m12 = AbstractC1974b.m1307D(d10, d1822, d7 * d1722, this.m12);
                                        this.type = -1;
                                        break;
                                }
                                return;
                        }
                        this.m01 = affineTransform.m01;
                        this.m10 = affineTransform.m10;
                        this.m11 = 0.0d;
                        this.m00 = 0.0d;
                        this.state = i2;
                        this.type = affineTransform.type;
                        return;
                }
                this.m02 = affineTransform.m02;
                this.m12 = affineTransform.m12;
                this.state = i2;
                this.type = affineTransform.type;
                return;
            }
            this.m01 = affineTransform.m01;
            this.m10 = affineTransform.m10;
            this.m00 = affineTransform.m00;
            this.m11 = affineTransform.m11;
            this.m02 = affineTransform.m02;
            this.m12 = affineTransform.m12;
            this.state = i2;
            this.type = affineTransform.type;
            return;
        }
        this.m01 = affineTransform.m01;
        this.m10 = affineTransform.m10;
        this.m00 = affineTransform.m00;
        this.m11 = affineTransform.m11;
        this.state = i2;
        this.type = affineTransform.type;
    }

    public AffineTransform createInverse() throws NoninvertibleTransformException {
        switch (this.state) {
            case 0:
                return new AffineTransform();
            case 1:
                return new AffineTransform(1.0d, 0.0d, 0.0d, 1.0d, -this.m02, -this.m12, 1);
            case 2:
                double d = this.m00;
                if (d != 0.0d) {
                    double d2 = this.m11;
                    if (d2 != 0.0d) {
                        return new AffineTransform(1.0d / d, 0.0d, 0.0d, 1.0d / d2, 0.0d, 0.0d, 2);
                    }
                }
                throw new NoninvertibleTransformException("Determinant is 0");
            case 3:
                double d3 = this.m00;
                if (d3 != 0.0d) {
                    double d4 = this.m11;
                    if (d4 != 0.0d) {
                        return new AffineTransform(1.0d / d3, 0.0d, 0.0d, 1.0d / d4, (-this.m02) / d3, (-this.m12) / d4, 3);
                    }
                }
                throw new NoninvertibleTransformException("Determinant is 0");
            case 4:
                double d5 = this.m01;
                if (d5 != 0.0d) {
                    double d6 = this.m10;
                    if (d6 != 0.0d) {
                        return new AffineTransform(0.0d, 1.0d / d5, 1.0d / d6, 0.0d, 0.0d, 0.0d, 4);
                    }
                }
                throw new NoninvertibleTransformException("Determinant is 0");
            case 5:
                double d7 = this.m01;
                if (d7 != 0.0d) {
                    double d8 = this.m10;
                    if (d8 != 0.0d) {
                        return new AffineTransform(0.0d, 1.0d / d7, 1.0d / d8, 0.0d, (-this.m12) / d8, (-this.m02) / d7, 5);
                    }
                }
                throw new NoninvertibleTransformException("Determinant is 0");
            case 6:
                double d9 = (this.m00 * this.m11) - (this.m01 * this.m10);
                if (Math.abs(d9) > Double.MIN_VALUE) {
                    return new AffineTransform(this.m11 / d9, (-this.m10) / d9, (-this.m01) / d9, this.m00 / d9, 0.0d, 0.0d, 6);
                }
                throw new NoninvertibleTransformException(AbstractC1974b.m1318k("Determinant is ", d9));
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d10 = (this.m00 * this.m11) - (this.m01 * this.m10);
        if (Math.abs(d10) <= Double.MIN_VALUE) {
            throw new NoninvertibleTransformException(AbstractC1974b.m1318k("Determinant is ", d10));
        }
        double d11 = this.m11;
        double d12 = this.m10;
        double d13 = (-d12) / d10;
        double d14 = this.m01;
        double d15 = (-d14) / d10;
        double d16 = this.m00;
        double d17 = this.m12;
        double d18 = this.m02;
        return new AffineTransform(d11 / d10, d13, d15, d16 / d10, AbstractC1974b.m1333z(d11, d18, d14 * d17, d10), AbstractC1974b.m1333z(d16, d17, d12 * d18, d10), 7);
    }

    public Shape createTransformedShape(Shape shape) {
        if (shape == null) {
            return null;
        }
        return new Path2D.Double(shape, this);
    }

    public Point2D deltaTransform(Point2D point2D, Point2D point2D2) {
        if (point2D2 == null) {
            point2D2 = point2D instanceof Point2D.Double ? new Point2D.Double() : new Point2D.Float();
        }
        double x = point2D.getX();
        double y2 = point2D.getY();
        switch (this.state) {
            case 0:
            case 1:
                point2D2.setLocation(x, y2);
                return point2D2;
            case 2:
            case 3:
                point2D2.setLocation(x * this.m00, y2 * this.m11);
                return point2D2;
            case 4:
            case 5:
                point2D2.setLocation(y2 * this.m01, x * this.m10);
                return point2D2;
            case 6:
            case 7:
                break;
            default:
                stateError();
                break;
        }
        point2D2.setLocation((this.m01 * y2) + (this.m00 * x), (y2 * this.m11) + (x * this.m10));
        return point2D2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AffineTransform)) {
            return false;
        }
        AffineTransform affineTransform = (AffineTransform) obj;
        return this.m00 == affineTransform.m00 && this.m01 == affineTransform.m01 && this.m02 == affineTransform.m02 && this.m10 == affineTransform.m10 && this.m11 == affineTransform.m11 && this.m12 == affineTransform.m12;
    }

    public double getDeterminant() {
        switch (this.state) {
            case 0:
            case 1:
                return 1.0d;
            case 2:
            case 3:
                return this.m00 * this.m11;
            case 4:
            case 5:
                return -(this.m01 * this.m10);
            case 6:
            case 7:
                break;
            default:
                stateError();
                break;
        }
        return (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public void getMatrix(double[] dArr) {
        dArr[0] = this.m00;
        dArr[1] = this.m10;
        dArr[2] = this.m01;
        dArr[3] = this.m11;
        if (dArr.length > 5) {
            dArr[4] = this.m02;
            dArr[5] = this.m12;
        }
    }

    public double getScaleX() {
        return this.m00;
    }

    public double getScaleY() {
        return this.m11;
    }

    public double getShearX() {
        return this.m01;
    }

    public double getShearY() {
        return this.m10;
    }

    public double getTranslateX() {
        return this.m02;
    }

    public double getTranslateY() {
        return this.m12;
    }

    public int getType() {
        if (this.type == -1) {
            calculateType();
        }
        return this.type;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.m12) + ((Double.doubleToLongBits(this.m11) + ((Double.doubleToLongBits(this.m10) + ((Double.doubleToLongBits(this.m02) + ((Double.doubleToLongBits(this.m01) + (Double.doubleToLongBits(this.m00) * 31)) * 31)) * 31)) * 31)) * 31);
        return ((int) jDoubleToLongBits) ^ ((int) (jDoubleToLongBits >> 32));
    }

    public Point2D inverseTransform(Point2D point2D, Point2D point2D2) throws NoninvertibleTransformException {
        Point2D point2D3 = point2D2 == null ? point2D instanceof Point2D.Double ? new Point2D.Double() : new Point2D.Float() : point2D2;
        double x = point2D.getX();
        double y2 = point2D.getY();
        switch (this.state) {
            case 0:
                point2D3.setLocation(x, y2);
                return point2D3;
            case 1:
                point2D3.setLocation(x - this.m02, y2 - this.m12);
                return point2D3;
            case 3:
                x -= this.m02;
                y2 -= this.m12;
            case 2:
                double d = this.m00;
                if (d != 0.0d) {
                    double d2 = this.m11;
                    if (d2 != 0.0d) {
                        point2D3.setLocation(x / d, y2 / d2);
                        return point2D3;
                    }
                }
                throw new NoninvertibleTransformException("Determinant is 0");
            case 5:
                x -= this.m02;
                y2 -= this.m12;
            case 4:
                double d3 = this.m01;
                if (d3 != 0.0d) {
                    double d4 = this.m10;
                    if (d4 != 0.0d) {
                        point2D3.setLocation(y2 / d4, x / d3);
                        return point2D3;
                    }
                }
                throw new NoninvertibleTransformException("Determinant is 0");
            default:
                stateError();
            case 7:
                x -= this.m02;
                y2 -= this.m12;
            case 6:
                double d5 = x;
                double d6 = y2;
                double d7 = (this.m00 * this.m11) - (this.m01 * this.m10);
                if (Math.abs(d7) <= Double.MIN_VALUE) {
                    throw new NoninvertibleTransformException(AbstractC1974b.m1318k("Determinant is ", d7));
                }
                point2D3.setLocation(AbstractC1974b.m1333z(d6, this.m01, this.m11 * d5, d7), AbstractC1974b.m1333z(d5, this.m10, d6 * this.m00, d7));
                return point2D3;
        }
    }

    public void invert() throws NoninvertibleTransformException {
        switch (this.state) {
            case 0:
                return;
            case 1:
                this.m02 = -this.m02;
                this.m12 = -this.m12;
                return;
            case 2:
                double d = this.m00;
                double d2 = this.m11;
                if (d == 0.0d || d2 == 0.0d) {
                    throw new NoninvertibleTransformException("Determinant is 0");
                }
                this.m00 = 1.0d / d;
                this.m11 = 1.0d / d2;
                return;
            case 3:
                double d3 = this.m00;
                double d4 = this.m02;
                double d5 = this.m11;
                double d6 = this.m12;
                if (d3 == 0.0d || d5 == 0.0d) {
                    throw new NoninvertibleTransformException("Determinant is 0");
                }
                this.m00 = 1.0d / d3;
                this.m11 = 1.0d / d5;
                this.m02 = (-d4) / d3;
                this.m12 = (-d6) / d5;
                return;
            case 4:
                double d7 = this.m01;
                double d8 = this.m10;
                if (d7 == 0.0d || d8 == 0.0d) {
                    throw new NoninvertibleTransformException("Determinant is 0");
                }
                this.m10 = 1.0d / d7;
                this.m01 = 1.0d / d8;
                return;
            case 5:
                double d9 = this.m01;
                double d10 = this.m02;
                double d11 = this.m10;
                double d12 = this.m12;
                if (d9 == 0.0d || d11 == 0.0d) {
                    throw new NoninvertibleTransformException("Determinant is 0");
                }
                this.m10 = 1.0d / d9;
                this.m01 = 1.0d / d11;
                this.m02 = (-d12) / d11;
                this.m12 = (-d10) / d9;
                return;
            case 6:
                double d13 = this.m00;
                double d14 = this.m01;
                double d15 = this.m10;
                double d16 = this.m11;
                double d17 = (d13 * d16) - (d14 * d15);
                if (Math.abs(d17) <= Double.MIN_VALUE) {
                    throw new NoninvertibleTransformException(AbstractC1974b.m1318k("Determinant is ", d17));
                }
                this.m00 = d16 / d17;
                this.m10 = (-d15) / d17;
                this.m01 = (-d14) / d17;
                this.m11 = d13 / d17;
                return;
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d18 = this.m00;
        double d19 = this.m01;
        double d20 = this.m02;
        double d21 = this.m10;
        double d22 = this.m11;
        double d23 = this.m12;
        double d24 = (d18 * d22) - (d19 * d21);
        if (Math.abs(d24) <= Double.MIN_VALUE) {
            throw new NoninvertibleTransformException(AbstractC1974b.m1318k("Determinant is ", d24));
        }
        this.m00 = d22 / d24;
        this.m10 = (-d21) / d24;
        this.m01 = (-d19) / d24;
        this.m11 = d18 / d24;
        this.m02 = AbstractC1974b.m1333z(d22, d20, d19 * d23, d24);
        this.m12 = AbstractC1974b.m1333z(d18, d23, d20 * d21, d24);
    }

    public boolean isIdentity() {
        return this.state == 0 || getType() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preConcatenate(AffineTransform affineTransform) {
        double d;
        double dM1307D;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        int i = this.state;
        int i2 = affineTransform.state;
        int i4 = (i2 << 3) | i;
        switch (i4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return;
            case 8:
            case 10:
            case 12:
            case 14:
                this.m02 = affineTransform.m02;
                this.m12 = affineTransform.m12;
                this.state = i | 1;
                this.type |= 1;
                return;
            case 9:
            case 11:
            case 13:
            case 15:
                this.m02 += affineTransform.m02;
                this.m12 += affineTransform.m12;
                return;
            case 16:
            case 17:
                this.state = i | 2;
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                switch (i4) {
                    case 36:
                    case 37:
                        i |= 2;
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                        this.state = i ^ 4;
                    case 38:
                    case 39:
                        double d9 = affineTransform.m01;
                        double d10 = affineTransform.m10;
                        double d11 = this.m00;
                        this.m00 = this.m10 * d9;
                        this.m10 = d11 * d10;
                        double d12 = this.m01;
                        this.m01 = this.m11 * d9;
                        this.m11 = d12 * d10;
                        double d13 = this.m02;
                        this.m02 = this.m12 * d9;
                        this.m12 = d13 * d10;
                        this.type = -1;
                        break;
                    default:
                        double d14 = affineTransform.m00;
                        double d15 = affineTransform.m01;
                        double dM1307D2 = affineTransform.m02;
                        double d16 = affineTransform.m10;
                        double d17 = affineTransform.m11;
                        double dM1307D3 = affineTransform.m12;
                        switch (i) {
                            case 0:
                                d = d16;
                                dM1307D = dM1307D3;
                                this.m02 = dM1307D2;
                                this.m12 = dM1307D;
                                this.m00 = d14;
                                this.m10 = d;
                                this.m01 = d15;
                                this.m11 = d17;
                                this.state = i | i2;
                                this.type = -1;
                                break;
                            case 1:
                                d = d16;
                                double d18 = this.m02;
                                double d19 = this.m12;
                                dM1307D2 = AbstractC1974b.m1307D(d19, d15, d18 * d14, dM1307D2);
                                dM1307D = AbstractC1974b.m1307D(d19, d17, d18 * d, dM1307D3);
                                d17 = d17;
                                this.m02 = dM1307D2;
                                this.m12 = dM1307D;
                                this.m00 = d14;
                                this.m10 = d;
                                this.m01 = d15;
                                this.m11 = d17;
                                this.state = i | i2;
                                this.type = -1;
                                break;
                            case 2:
                                d2 = d16;
                                d3 = d17;
                                this.m02 = dM1307D2;
                                this.m12 = dM1307D3;
                                double d20 = this.m00;
                                this.m00 = d20 * d14;
                                this.m10 = d20 * d2;
                                double d21 = this.m11;
                                this.m01 = d15 * d21;
                                d4 = d21 * d3;
                                this.m11 = d4;
                                updateState();
                                break;
                            case 3:
                                d2 = d16;
                                d3 = d17;
                                double d22 = this.m02;
                                double d23 = this.m12;
                                dM1307D2 = AbstractC1974b.m1307D(d23, d15, d22 * d14, dM1307D2);
                                dM1307D3 = AbstractC1974b.m1307D(d23, d3, d22 * d2, dM1307D3);
                                this.m02 = dM1307D2;
                                this.m12 = dM1307D3;
                                double d202 = this.m00;
                                this.m00 = d202 * d14;
                                this.m10 = d202 * d2;
                                double d212 = this.m11;
                                this.m01 = d15 * d212;
                                d4 = d212 * d3;
                                this.m11 = d4;
                                updateState();
                                break;
                            case 4:
                                d5 = d16;
                                d6 = d17;
                                this.m02 = dM1307D2;
                                this.m12 = dM1307D3;
                                double d24 = this.m10;
                                this.m00 = d15 * d24;
                                this.m10 = d24 * d6;
                                double d25 = this.m01;
                                this.m01 = d25 * d14;
                                d4 = d25 * d5;
                                this.m11 = d4;
                                updateState();
                                break;
                            case 5:
                                d5 = d16;
                                d6 = d17;
                                double d26 = this.m02;
                                double d27 = this.m12;
                                dM1307D2 = AbstractC1974b.m1307D(d27, d15, d26 * d14, dM1307D2);
                                dM1307D3 = AbstractC1974b.m1307D(d27, d6, d26 * d5, dM1307D3);
                                this.m02 = dM1307D2;
                                this.m12 = dM1307D3;
                                double d242 = this.m10;
                                this.m00 = d15 * d242;
                                this.m10 = d242 * d6;
                                double d252 = this.m01;
                                this.m01 = d252 * d14;
                                d4 = d252 * d5;
                                this.m11 = d4;
                                updateState();
                                break;
                            case 6:
                                d7 = d16;
                                d8 = d17;
                                this.m02 = dM1307D2;
                                this.m12 = dM1307D3;
                                double d28 = this.m00;
                                double d29 = this.m10;
                                this.m00 = (d29 * d15) + (d28 * d14);
                                this.m10 = (d29 * d8) + (d28 * d7);
                                double d30 = this.m01;
                                double d31 = this.m11;
                                this.m01 = (d15 * d31) + (d30 * d14);
                                this.m11 = (d31 * d8) + (d30 * d7);
                                updateState();
                                break;
                            default:
                                stateError();
                            case 7:
                                double d32 = this.m02;
                                d7 = d16;
                                double d33 = this.m12;
                                d8 = d17;
                                dM1307D2 = AbstractC1974b.m1307D(d33, d15, d32 * d14, dM1307D2);
                                dM1307D3 = AbstractC1974b.m1307D(d33, d8, d32 * d7, dM1307D3);
                                this.m02 = dM1307D2;
                                this.m12 = dM1307D3;
                                double d282 = this.m00;
                                double d292 = this.m10;
                                this.m00 = (d292 * d15) + (d282 * d14);
                                this.m10 = (d292 * d8) + (d282 * d7);
                                double d302 = this.m01;
                                double d312 = this.m11;
                                this.m01 = (d15 * d312) + (d302 * d14);
                                this.m11 = (d312 * d8) + (d302 * d7);
                                updateState();
                                break;
                        }
                        break;
                }
                return;
        }
        double d34 = affineTransform.m00;
        double d35 = affineTransform.m11;
        if ((i & 4) != 0) {
            this.m01 *= d34;
            this.m10 *= d35;
            if ((i & 2) != 0) {
                this.m00 *= d34;
                this.m11 *= d35;
            }
        }
        if ((i & 1) != 0) {
            this.m02 *= d34;
            this.m12 *= d35;
        }
        this.type = -1;
    }

    public void quadrantRotate(int i) {
        int i2 = i & 3;
        if (i2 == 1) {
            rotate90();
        } else if (i2 == 2) {
            rotate180();
        } else {
            if (i2 != 3) {
                return;
            }
            rotate270();
        }
    }

    public void rotate(double d) {
        double dSin = Math.sin(d);
        if (dSin == 1.0d) {
            rotate90();
            return;
        }
        if (dSin == -1.0d) {
            rotate270();
            return;
        }
        double dCos = Math.cos(d);
        if (dCos == -1.0d) {
            rotate180();
            return;
        }
        if (dCos != 1.0d) {
            double d2 = this.m00;
            double d3 = this.m01;
            this.m00 = (dSin * d3) + (dCos * d2);
            double d4 = -dSin;
            this.m01 = (d3 * dCos) + (d2 * d4);
            double d5 = this.m10;
            double d6 = this.m11;
            this.m10 = (dSin * d6) + (dCos * d5);
            this.m11 = (dCos * d6) + (d4 * d5);
            updateState();
        }
    }

    public void scale(double d, double d2) {
        int i = this.state;
        switch (i) {
            case 0:
            case 1:
                this.m00 = d;
                this.m11 = d2;
                if (d != 1.0d || d2 != 1.0d) {
                    this.state = i | 2;
                    this.type = -1;
                }
                break;
            case 2:
            case 3:
                double d3 = this.m00 * d;
                this.m00 = d3;
                double d4 = this.m11 * d2;
                this.m11 = d4;
                if (d3 == 1.0d && d4 == 1.0d) {
                    int i2 = i & 1;
                    this.state = i2;
                    this.type = i2 != 0 ? 1 : 0;
                } else {
                    this.type = -1;
                }
                break;
            default:
                stateError();
            case 6:
            case 7:
                this.m00 *= d;
                this.m11 *= d2;
            case 4:
            case 5:
                double d5 = this.m01 * d2;
                this.m01 = d5;
                double d6 = this.m10 * d;
                this.m10 = d6;
                if (d5 == 0.0d && d6 == 0.0d) {
                    int i4 = i & 1;
                    if (this.m00 == 1.0d && this.m11 == 1.0d) {
                        this.type = i4 != 0 ? 1 : 0;
                    } else {
                        i4 |= 2;
                        this.type = -1;
                    }
                    this.state = i4;
                    break;
                }
                break;
        }
    }

    public void setToIdentity() {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
        this.state = 0;
        this.type = 0;
    }

    public void setToQuadrantRotation(int i) {
        int i2 = i & 3;
        if (i2 == 0) {
            this.m00 = 1.0d;
            this.m10 = 0.0d;
            this.m01 = 0.0d;
            this.m11 = 1.0d;
            this.m02 = 0.0d;
            this.m12 = 0.0d;
            this.state = 0;
            this.type = 0;
            return;
        }
        if (i2 == 1) {
            this.m00 = 0.0d;
            this.m10 = 1.0d;
            this.m01 = -1.0d;
            this.m11 = 0.0d;
            this.m02 = 0.0d;
            this.m12 = 0.0d;
            this.state = 4;
            this.type = 8;
            return;
        }
        if (i2 == 2) {
            this.m00 = -1.0d;
            this.m10 = 0.0d;
            this.m01 = 0.0d;
            this.m11 = -1.0d;
            this.m02 = 0.0d;
            this.m12 = 0.0d;
            this.state = 2;
            this.type = 8;
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.m00 = 0.0d;
        this.m10 = -1.0d;
        this.m01 = 1.0d;
        this.m11 = 0.0d;
        this.m02 = 0.0d;
        this.m12 = 0.0d;
        this.state = 4;
        this.type = 8;
    }

    public void setToRotation(double d) {
        double dCos;
        double dSin = Math.sin(d);
        if (dSin == 1.0d || dSin == -1.0d) {
            this.state = 4;
            this.type = 8;
            dCos = 0.0d;
        } else {
            dCos = Math.cos(d);
            if (dCos == -1.0d) {
                this.state = 2;
                this.type = 8;
            } else if (dCos == 1.0d) {
                this.state = 0;
                this.type = 0;
            } else {
                this.state = 6;
                this.type = 16;
            }
            dSin = 0.0d;
        }
        this.m00 = dCos;
        this.m10 = dSin;
        this.m01 = -dSin;
        this.m11 = dCos;
        this.m02 = 0.0d;
        this.m12 = 0.0d;
    }

    public void setToScale(double d, double d2) {
        int i;
        this.m00 = d;
        this.m10 = 0.0d;
        this.m01 = 0.0d;
        this.m11 = d2;
        this.m02 = 0.0d;
        this.m12 = 0.0d;
        if (d == 1.0d && d2 == 1.0d) {
            i = 0;
            this.state = 0;
        } else {
            this.state = 2;
            i = -1;
        }
        this.type = i;
    }

    public void setToShear(double d, double d2) {
        int i;
        this.m00 = 1.0d;
        this.m01 = d;
        this.m10 = d2;
        this.m11 = 1.0d;
        this.m02 = 0.0d;
        this.m12 = 0.0d;
        if (d == 0.0d && d2 == 0.0d) {
            i = 0;
            this.state = 0;
        } else {
            this.state = 6;
            i = -1;
        }
        this.type = i;
    }

    public void setToTranslation(double d, double d2) {
        this.m00 = 1.0d;
        this.m10 = 0.0d;
        this.m01 = 0.0d;
        this.m11 = 1.0d;
        this.m02 = d;
        this.m12 = d2;
        int i = (d == 0.0d && d2 == 0.0d) ? 0 : 1;
        this.state = i;
        this.type = i;
    }

    public void setTransform(double d, double d2, double d3, double d4, double d5, double d6) {
        this.m00 = d;
        this.m10 = d2;
        this.m01 = d3;
        this.m11 = d4;
        this.m02 = d5;
        this.m12 = d6;
        updateState();
    }

    public void shear(double d, double d2) {
        int i = this.state;
        switch (i) {
            case 0:
            case 1:
                this.m01 = d;
                this.m10 = d2;
                if (d == 0.0d && d2 == 0.0d) {
                    return;
                }
                this.state = i | 6;
                this.type = -1;
                return;
            case 2:
            case 3:
                double d3 = this.m00 * d;
                this.m01 = d3;
                double d4 = this.m11 * d2;
                this.m10 = d4;
                if (d3 != 0.0d || d4 != 0.0d) {
                    this.state = i | 4;
                }
                this.type = -1;
                return;
            case 4:
            case 5:
                double d5 = this.m01 * d2;
                this.m00 = d5;
                double d6 = this.m10 * d;
                this.m11 = d6;
                if (d5 != 0.0d || d6 != 0.0d) {
                    this.state = i | 2;
                }
                this.type = -1;
                return;
            case 6:
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d7 = this.m00;
        double d8 = this.m01;
        this.m00 = (d8 * d2) + d7;
        this.m01 = (d7 * d) + d8;
        double d9 = this.m10;
        double d10 = this.m11;
        this.m10 = (d2 * d10) + d9;
        this.m11 = (d9 * d) + d10;
        updateState();
    }

    public String toString() {
        return "AffineTransform[[" + _matround(this.m00) + SQLKeyword.COMMA + _matround(this.m01) + SQLKeyword.COMMA + _matround(this.m02) + "], [" + _matround(this.m10) + SQLKeyword.COMMA + _matround(this.m11) + SQLKeyword.COMMA + _matround(this.m12) + "]]";
    }

    public Point2D transform(Point2D point2D, Point2D point2D2) {
        if (point2D2 == null) {
            point2D2 = point2D instanceof Point2D.Double ? new Point2D.Double() : new Point2D.Float();
        }
        double x = point2D.getX();
        double y2 = point2D.getY();
        switch (this.state) {
            case 0:
                point2D2.setLocation(x, y2);
                return point2D2;
            case 1:
                point2D2.setLocation(x + this.m02, y2 + this.m12);
                return point2D2;
            case 2:
                point2D2.setLocation(x * this.m00, y2 * this.m11);
                return point2D2;
            case 3:
                point2D2.setLocation((x * this.m00) + this.m02, (y2 * this.m11) + this.m12);
                return point2D2;
            case 4:
                point2D2.setLocation(y2 * this.m01, x * this.m10);
                return point2D2;
            case 5:
                point2D2.setLocation((y2 * this.m01) + this.m02, (x * this.m10) + this.m12);
                return point2D2;
            case 6:
                point2D2.setLocation((this.m01 * y2) + (this.m00 * x), (y2 * this.m11) + (x * this.m10));
                return point2D2;
            case 7:
                break;
            default:
                stateError();
                break;
        }
        point2D2.setLocation((this.m01 * y2) + (this.m00 * x) + this.m02, (y2 * this.m11) + (x * this.m10) + this.m12);
        return point2D2;
    }

    public void translate(double d, double d2) {
        switch (this.state) {
            case 0:
                this.m02 = d;
                this.m12 = d2;
                if (d == 0.0d && d2 == 0.0d) {
                    return;
                }
                this.state = 1;
                this.type = 1;
                return;
            case 1:
                double d3 = d + this.m02;
                this.m02 = d3;
                double d4 = d2 + this.m12;
                this.m12 = d4;
                if (d3 == 0.0d && d4 == 0.0d) {
                    this.state = 0;
                    this.type = 0;
                    return;
                }
                return;
            case 2:
                double d5 = d * this.m00;
                this.m02 = d5;
                double d6 = d2 * this.m11;
                this.m12 = d6;
                if (d5 == 0.0d && d6 == 0.0d) {
                    return;
                }
                this.state = 3;
                this.type |= 1;
                return;
            case 3:
                double d7 = (d * this.m00) + this.m02;
                this.m02 = d7;
                double d8 = (d2 * this.m11) + this.m12;
                this.m12 = d8;
                if (d7 == 0.0d && d8 == 0.0d) {
                    this.state = 2;
                    int i = this.type;
                    if (i != -1) {
                        this.type = i - 1;
                        return;
                    }
                    return;
                }
                return;
            case 4:
                double d9 = d2 * this.m01;
                this.m02 = d9;
                double d10 = d * this.m10;
                this.m12 = d10;
                if (d9 == 0.0d && d10 == 0.0d) {
                    return;
                }
                this.state = 5;
                this.type |= 1;
                return;
            case 5:
                double d11 = (d2 * this.m01) + this.m02;
                this.m02 = d11;
                double d12 = (d * this.m10) + this.m12;
                this.m12 = d12;
                if (d11 == 0.0d && d12 == 0.0d) {
                    this.state = 4;
                    int i2 = this.type;
                    if (i2 != -1) {
                        this.type = i2 - 1;
                        return;
                    }
                    return;
                }
                return;
            case 6:
                double d13 = (this.m01 * d2) + (this.m00 * d);
                this.m02 = d13;
                double d14 = (d2 * this.m11) + (d * this.m10);
                this.m12 = d14;
                if (d13 == 0.0d && d14 == 0.0d) {
                    return;
                }
                this.state = 7;
                this.type |= 1;
                return;
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d15 = (this.m01 * d2) + (this.m00 * d) + this.m02;
        this.m02 = d15;
        double d16 = (d2 * this.m11) + (d * this.m10) + this.m12;
        this.m12 = d16;
        if (d15 == 0.0d && d16 == 0.0d) {
            this.state = 6;
            int i4 = this.type;
            if (i4 != -1) {
                this.type = i4 - 1;
            }
        }
    }

    public void updateState() {
        if (this.m01 == 0.0d && this.m10 == 0.0d) {
            if (this.m00 == 1.0d && this.m11 == 1.0d) {
                if (this.m02 == 0.0d && this.m12 == 0.0d) {
                    this.state = 0;
                    this.type = 0;
                    return;
                } else {
                    this.state = 1;
                    this.type = 1;
                    return;
                }
            }
            if (this.m02 == 0.0d && this.m12 == 0.0d) {
                this.state = 2;
                this.type = -1;
                return;
            } else {
                this.state = 3;
                this.type = -1;
                return;
            }
        }
        if (this.m00 == 0.0d && this.m11 == 0.0d) {
            if (this.m02 == 0.0d && this.m12 == 0.0d) {
                this.state = 4;
                this.type = -1;
                return;
            } else {
                this.state = 5;
                this.type = -1;
                return;
            }
        }
        if (this.m02 == 0.0d && this.m12 == 0.0d) {
            this.state = 6;
            this.type = -1;
        } else {
            this.state = 7;
            this.type = -1;
        }
    }

    public AffineTransform(double d, double d2, double d3, double d4, double d5, double d6) {
        this.m00 = d;
        this.m10 = d2;
        this.m01 = d3;
        this.m11 = d4;
        this.m02 = d5;
        this.m12 = d6;
        updateState();
    }

    public static AffineTransform getQuadrantRotateInstance(int i, double d, double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToQuadrantRotation(i, d, d2);
        return affineTransform;
    }

    public static AffineTransform getRotateInstance(double d, double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d, d2);
        return affineTransform;
    }

    public void deltaTransform(double[] dArr, int i, double[] dArr2, int i2, int i4) {
        int i5 = i;
        int i6 = i2;
        if (dArr2 == dArr && i6 > i5) {
            int i7 = i4 * 2;
            if (i6 < i5 + i7) {
                System.arraycopy(dArr, i5, dArr2, i6, i7);
                i5 = i6;
            }
        }
        switch (this.state) {
            case 0:
            case 1:
                if (dArr == dArr2 && i5 == i6) {
                    return;
                }
                System.arraycopy(dArr, i5, dArr2, i6, i4 * 2);
                return;
            case 2:
            case 3:
                double d = this.m00;
                double d2 = this.m11;
                int i8 = i5;
                int i9 = i4;
                while (true) {
                    i9--;
                    if (i9 < 0) {
                        return;
                    }
                    int i10 = i6 + 1;
                    int i11 = i8 + 1;
                    dArr2[i6] = dArr[i8] * d;
                    i6 += 2;
                    i8 += 2;
                    dArr2[i10] = dArr[i11] * d2;
                }
                break;
            case 4:
            case 5:
                double d3 = this.m01;
                double d4 = this.m10;
                int i12 = i5;
                int i13 = i4;
                while (true) {
                    i13--;
                    if (i13 < 0) {
                        return;
                    }
                    int i14 = i12 + 1;
                    double d5 = dArr[i12];
                    int i15 = i6 + 1;
                    i12 += 2;
                    dArr2[i6] = dArr[i14] * d3;
                    i6 += 2;
                    dArr2[i15] = d5 * d4;
                }
                break;
            case 6:
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d6 = this.m00;
        double d7 = this.m01;
        double d8 = this.m10;
        double d9 = this.m11;
        int i16 = i5;
        int i17 = i4;
        while (true) {
            i17--;
            if (i17 < 0) {
                return;
            }
            int i18 = i16 + 1;
            double d10 = dArr[i16];
            i16 += 2;
            double d11 = dArr[i18];
            int i19 = i6 + 1;
            dArr2[i6] = (d11 * d7) + (d10 * d6);
            i6 += 2;
            dArr2[i19] = (d11 * d9) + (d10 * d8);
        }
    }

    public void quadrantRotate(int i, double d, double d2) {
        int i2 = i & 3;
        if (i2 != 0) {
            if (i2 == 1) {
                double d3 = this.m02;
                double d4 = this.m00;
                double d5 = this.m01;
                this.m02 = ((d5 + d4) * d2) + ((d4 - d5) * d) + d3;
                double d6 = this.m12;
                double d7 = this.m10;
                double d8 = this.m11;
                this.m12 = ((d8 + d7) * d2) + ((d7 - d8) * d) + d6;
                rotate90();
            } else if (i2 == 2) {
                double d9 = this.m02;
                double d10 = this.m00;
                double d11 = this.m01;
                this.m02 = ((d11 + d11) * d2) + ((d10 + d10) * d) + d9;
                double d12 = this.m12;
                double d13 = this.m10;
                double d14 = this.m11;
                this.m12 = ((d14 + d14) * d2) + ((d13 + d13) * d) + d12;
                rotate180();
            } else if (i2 == 3) {
                double d15 = this.m02;
                double d16 = this.m00;
                double d17 = this.m01;
                this.m02 = ((d17 - d16) * d2) + ((d16 + d17) * d) + d15;
                double d18 = this.m12;
                double d19 = this.m10;
                double d20 = this.m11;
                this.m12 = ((d20 - d19) * d2) + ((d19 + d20) * d) + d18;
                rotate270();
            }
            this.state = (this.m02 == 0.0d && this.m12 == 0.0d) ? this.state & (-2) : this.state | 1;
        }
    }

    public void rotate(double d, double d2) {
        if (d2 == 0.0d) {
            if (d < 0.0d) {
                rotate180();
                return;
            }
            return;
        }
        if (d == 0.0d) {
            if (d2 > 0.0d) {
                rotate90();
                return;
            } else {
                rotate270();
                return;
            }
        }
        double dSqrt = Math.sqrt((d2 * d2) + (d * d));
        double d3 = d2 / dSqrt;
        double d4 = d / dSqrt;
        double d5 = this.m00;
        double d6 = this.m01;
        this.m00 = (d3 * d6) + (d4 * d5);
        double d7 = -d3;
        this.m01 = (d6 * d4) + (d5 * d7);
        double d8 = this.m10;
        double d9 = this.m11;
        this.m10 = (d3 * d9) + (d4 * d8);
        this.m11 = (d4 * d9) + (d7 * d8);
        updateState();
    }

    public void setToQuadrantRotation(int i, double d, double d2) {
        int i2 = i & 3;
        if (i2 == 0) {
            this.m00 = 1.0d;
            this.m10 = 0.0d;
            this.m01 = 0.0d;
            this.m11 = 1.0d;
            this.m02 = 0.0d;
            this.m12 = 0.0d;
            this.state = 0;
            this.type = 0;
            return;
        }
        if (i2 == 1) {
            this.m00 = 0.0d;
            this.m10 = 1.0d;
            this.m01 = -1.0d;
            this.m11 = 0.0d;
            double d3 = d + d2;
            this.m02 = d3;
            double d4 = d2 - d;
            this.m12 = d4;
            if (d3 == 0.0d && d4 == 0.0d) {
                this.state = 4;
                this.type = 8;
                return;
            } else {
                this.state = 5;
                this.type = 9;
                return;
            }
        }
        if (i2 == 2) {
            this.m00 = -1.0d;
            this.m10 = 0.0d;
            this.m01 = 0.0d;
            this.m11 = -1.0d;
            double d5 = d + d;
            this.m02 = d5;
            double d6 = d2 + d2;
            this.m12 = d6;
            if (d5 == 0.0d && d6 == 0.0d) {
                this.state = 2;
                this.type = 8;
                return;
            } else {
                this.state = 3;
                this.type = 9;
                return;
            }
        }
        if (i2 != 3) {
            return;
        }
        this.m00 = 0.0d;
        this.m10 = -1.0d;
        this.m01 = 1.0d;
        this.m11 = 0.0d;
        double d7 = d - d2;
        this.m02 = d7;
        double d8 = d2 + d;
        this.m12 = d8;
        if (d7 == 0.0d && d8 == 0.0d) {
            this.state = 4;
            this.type = 8;
        } else {
            this.state = 5;
            this.type = 9;
        }
    }

    public void setToRotation(double d, double d2) {
        double d3;
        if (d2 == 0.0d) {
            if (d < 0.0d) {
                this.state = 2;
                this.type = 8;
                d3 = 0.0d;
                d = -1.0d;
            } else {
                this.state = 0;
                this.type = 0;
                d3 = 0.0d;
            }
        } else if (d == 0.0d) {
            d = d2 <= 0.0d ? -1.0d : 1.0d;
            this.state = 4;
            this.type = 8;
            d3 = d;
            d = 0.0d;
        } else {
            double dSqrt = Math.sqrt((d2 * d2) + (d * d));
            this.state = 6;
            this.type = 16;
            d = d / dSqrt;
            d3 = d2 / dSqrt;
        }
        this.m00 = d;
        this.m10 = d3;
        this.m01 = -d3;
        this.m11 = d;
        this.m02 = 0.0d;
        this.m12 = 0.0d;
    }

    public void setTransform(AffineTransform affineTransform) {
        this.m00 = affineTransform.m00;
        this.m10 = affineTransform.m10;
        this.m01 = affineTransform.m01;
        this.m11 = affineTransform.m11;
        this.m02 = affineTransform.m02;
        this.m12 = affineTransform.m12;
        this.state = affineTransform.state;
        this.type = affineTransform.type;
    }

    public void transform(double[] dArr, int i, double[] dArr2, int i2, int i4) {
        int i5 = i;
        int i6 = i2;
        if (dArr2 == dArr && i6 > i5) {
            int i7 = i4 * 2;
            if (i6 < i5 + i7) {
                System.arraycopy(dArr, i5, dArr2, i6, i7);
                i5 = i6;
            }
        }
        switch (this.state) {
            case 0:
                if (dArr == dArr2 && i5 == i6) {
                    return;
                }
                System.arraycopy(dArr, i5, dArr2, i6, i4 * 2);
                return;
            case 1:
                double d = this.m02;
                double d2 = this.m12;
                int i8 = i5;
                int i9 = i4;
                while (true) {
                    i9--;
                    if (i9 < 0) {
                        return;
                    }
                    int i10 = i6 + 1;
                    int i11 = i8 + 1;
                    dArr2[i6] = dArr[i8] + d;
                    i6 += 2;
                    i8 += 2;
                    dArr2[i10] = dArr[i11] + d2;
                }
                break;
            case 2:
                double d3 = this.m00;
                double d4 = this.m11;
                int i12 = i5;
                int i13 = i4;
                while (true) {
                    i13--;
                    if (i13 < 0) {
                        return;
                    }
                    int i14 = i6 + 1;
                    int i15 = i12 + 1;
                    dArr2[i6] = dArr[i12] * d3;
                    i6 += 2;
                    i12 += 2;
                    dArr2[i14] = dArr[i15] * d4;
                }
                break;
            case 3:
                double d5 = this.m00;
                double d6 = this.m02;
                double d7 = this.m11;
                double d8 = this.m12;
                int i16 = i5;
                int i17 = i4;
                while (true) {
                    i17--;
                    if (i17 < 0) {
                        return;
                    }
                    int i18 = i6 + 1;
                    int i19 = i16 + 1;
                    dArr2[i6] = (dArr[i16] * d5) + d6;
                    i6 += 2;
                    i16 += 2;
                    dArr2[i18] = (dArr[i19] * d7) + d8;
                }
                break;
            case 4:
                double d9 = this.m01;
                double d10 = this.m10;
                int i20 = i5;
                int i21 = i4;
                while (true) {
                    i21--;
                    if (i21 < 0) {
                        return;
                    }
                    int i22 = i20 + 1;
                    double d11 = dArr[i20];
                    int i23 = i6 + 1;
                    i20 += 2;
                    dArr2[i6] = dArr[i22] * d9;
                    i6 += 2;
                    dArr2[i23] = d11 * d10;
                }
                break;
            case 5:
                double d12 = this.m01;
                double d13 = this.m02;
                double d14 = this.m10;
                double d15 = this.m12;
                int i24 = i5;
                int i25 = i4;
                while (true) {
                    i25--;
                    if (i25 < 0) {
                        return;
                    }
                    int i26 = i24 + 1;
                    double d16 = dArr[i24];
                    int i27 = i6 + 1;
                    i24 += 2;
                    dArr2[i6] = (dArr[i26] * d12) + d13;
                    i6 += 2;
                    dArr2[i27] = (d16 * d14) + d15;
                }
                break;
            case 6:
                double d17 = this.m00;
                double d18 = this.m01;
                double d19 = this.m10;
                double d20 = this.m11;
                int i28 = i5;
                int i29 = i4;
                while (true) {
                    i29--;
                    if (i29 < 0) {
                        return;
                    }
                    int i30 = i28 + 1;
                    double d21 = dArr[i28];
                    i28 += 2;
                    double d22 = dArr[i30];
                    int i31 = i6 + 1;
                    dArr2[i6] = (d18 * d22) + (d17 * d21);
                    i6 += 2;
                    dArr2[i31] = (d22 * d20) + (d21 * d19);
                }
                break;
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d23 = this.m00;
        double d24 = this.m01;
        double d25 = this.m02;
        double d26 = this.m10;
        double d27 = this.m11;
        double d28 = this.m12;
        int i32 = i5;
        int i33 = i4;
        while (true) {
            i33--;
            if (i33 < 0) {
                return;
            }
            double d29 = dArr[i32];
            int i34 = i32 + 2;
            double d30 = dArr[i32 + 1];
            int i35 = i6 + 1;
            double d31 = d27;
            double d32 = d26;
            dArr2[i6] = AbstractC1974b.m1307D(d24, d30, d23 * d29, d25);
            i6 += 2;
            double d33 = d28;
            dArr2[i35] = AbstractC1974b.m1307D(d31, d30, d32 * d29, d33);
            d27 = d31;
            d28 = d33;
            i32 = i34;
            d26 = d32;
        }
    }

    private AffineTransform(double d, double d2, double d3, double d4, double d5, double d6, int i) {
        this.m00 = d;
        this.m10 = d2;
        this.m01 = d3;
        this.m11 = d4;
        this.m02 = d5;
        this.m12 = d6;
        this.state = i;
        this.type = -1;
    }

    public static AffineTransform getRotateInstance(double d, double d2, double d3) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d, d2, d3);
        return affineTransform;
    }

    public void rotate(double d, double d2, double d3) {
        translate(d2, d3);
        rotate(d);
        translate(-d2, -d3);
    }

    public void setToRotation(double d, double d2, double d3) {
        setToRotation(d);
        double d4 = this.m10;
        double d5 = 1.0d - this.m00;
        double d6 = (d3 * d4) + (d2 * d5);
        this.m02 = d6;
        double d7 = (d3 * d5) - (d2 * d4);
        this.m12 = d7;
        if (d6 == 0.0d && d7 == 0.0d) {
            return;
        }
        this.state |= 1;
        this.type |= 1;
    }

    public void transform(double[] dArr, int i, float[] fArr, int i2, int i4) {
        switch (this.state) {
            case 0:
                int i5 = i;
                int i6 = i2;
                int i7 = i4;
                while (true) {
                    i7--;
                    if (i7 < 0) {
                        return;
                    }
                    int i8 = i6 + 1;
                    int i9 = i5 + 1;
                    fArr[i6] = (float) dArr[i5];
                    i6 += 2;
                    i5 += 2;
                    fArr[i8] = (float) dArr[i9];
                }
                break;
            case 1:
                double d = this.m02;
                double d2 = this.m12;
                int i10 = i;
                int i11 = i2;
                int i12 = i4;
                while (true) {
                    i12--;
                    if (i12 < 0) {
                        return;
                    }
                    int i13 = i11 + 1;
                    int i14 = i10 + 1;
                    fArr[i11] = (float) (dArr[i10] + d);
                    i11 += 2;
                    i10 += 2;
                    fArr[i13] = (float) (dArr[i14] + d2);
                }
                break;
            case 2:
                double d3 = this.m00;
                double d4 = this.m11;
                int i15 = i;
                int i16 = i2;
                int i17 = i4;
                while (true) {
                    i17--;
                    if (i17 < 0) {
                        return;
                    }
                    int i18 = i16 + 1;
                    int i19 = i15 + 1;
                    fArr[i16] = (float) (dArr[i15] * d3);
                    i16 += 2;
                    i15 += 2;
                    fArr[i18] = (float) (dArr[i19] * d4);
                }
                break;
            case 3:
                double d5 = this.m00;
                double d6 = this.m02;
                double d7 = this.m11;
                double d8 = this.m12;
                int i20 = i;
                int i21 = i2;
                int i22 = i4;
                while (true) {
                    i22--;
                    if (i22 < 0) {
                        return;
                    }
                    int i23 = i21 + 1;
                    int i24 = i20 + 1;
                    fArr[i21] = (float) ((dArr[i20] * d5) + d6);
                    i21 += 2;
                    i20 += 2;
                    fArr[i23] = (float) ((dArr[i24] * d7) + d8);
                }
                break;
            case 4:
                double d9 = this.m01;
                double d10 = this.m10;
                int i25 = i;
                int i26 = i2;
                int i27 = i4;
                while (true) {
                    i27--;
                    if (i27 < 0) {
                        return;
                    }
                    int i28 = i25 + 1;
                    double d11 = dArr[i25];
                    int i29 = i26 + 1;
                    i25 += 2;
                    fArr[i26] = (float) (dArr[i28] * d9);
                    i26 += 2;
                    fArr[i29] = (float) (d11 * d10);
                }
                break;
            case 5:
                double d12 = this.m01;
                double d13 = this.m02;
                double d14 = this.m10;
                double d15 = this.m12;
                int i30 = i;
                int i31 = i2;
                int i32 = i4;
                while (true) {
                    i32--;
                    if (i32 < 0) {
                        return;
                    }
                    int i33 = i30 + 1;
                    double d16 = dArr[i30];
                    int i34 = i31 + 1;
                    i30 += 2;
                    fArr[i31] = (float) ((dArr[i33] * d12) + d13);
                    i31 += 2;
                    fArr[i34] = (float) ((d16 * d14) + d15);
                    d12 = d12;
                }
                break;
            case 6:
                double d17 = this.m00;
                double d18 = this.m01;
                double d19 = this.m10;
                double d20 = this.m11;
                int i35 = i;
                int i36 = i2;
                int i37 = i4;
                while (true) {
                    i37--;
                    if (i37 < 0) {
                        return;
                    }
                    int i38 = i35 + 1;
                    double d21 = dArr[i35];
                    i35 += 2;
                    double d22 = dArr[i38];
                    int i39 = i36 + 1;
                    fArr[i36] = (float) ((d18 * d22) + (d17 * d21));
                    i36 += 2;
                    fArr[i39] = (float) ((d22 * d20) + (d21 * d19));
                    d17 = d17;
                }
                break;
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d23 = this.m00;
        double d24 = this.m01;
        double d25 = this.m02;
        double d26 = this.m10;
        double d27 = this.m11;
        double d28 = this.m12;
        int i40 = i;
        int i41 = i2;
        int i42 = i4;
        while (true) {
            int i43 = i42 - 1;
            if (i43 < 0) {
                return;
            }
            double d29 = dArr[i40];
            int i44 = i40 + 2;
            double d30 = dArr[i40 + 1];
            double d31 = d28;
            fArr[i41] = (float) AbstractC1974b.m1307D(d24, d30, d23 * d29, d25);
            fArr[i41 + 1] = (float) AbstractC1974b.m1307D(d27, d30, d26 * d29, d31);
            i41 += 2;
            d28 = d31;
            i42 = i43;
            i40 = i44;
        }
    }

    @ConstructorProperties({"scaleX", "shearY", "shearX", "scaleY", "translateX", "translateY"})
    public AffineTransform(float f, float f4, float f5, float f6, float f7, float f8) {
        this.m00 = f;
        this.m10 = f4;
        this.m01 = f5;
        this.m11 = f6;
        this.m02 = f7;
        this.m12 = f8;
        updateState();
    }

    public static AffineTransform getRotateInstance(double d, double d2, double d3, double d4) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d, d2, d3, d4);
        return affineTransform;
    }

    public void rotate(double d, double d2, double d3, double d4) {
        translate(d3, d4);
        rotate(d, d2);
        translate(-d3, -d4);
    }

    public void setToRotation(double d, double d2, double d3, double d4) {
        setToRotation(d, d2);
        double d5 = this.m10;
        double d6 = 1.0d - this.m00;
        double d7 = (d4 * d5) + (d3 * d6);
        this.m02 = d7;
        double d8 = (d4 * d6) - (d3 * d5);
        this.m12 = d8;
        if (d7 == 0.0d && d8 == 0.0d) {
            return;
        }
        this.state |= 1;
        this.type |= 1;
    }

    public void transform(float[] fArr, int i, double[] dArr, int i2, int i4) {
        switch (this.state) {
            case 0:
                int i5 = i;
                int i6 = i2;
                int i7 = i4;
                while (true) {
                    i7--;
                    if (i7 < 0) {
                        return;
                    }
                    int i8 = i6 + 1;
                    int i9 = i5 + 1;
                    dArr[i6] = fArr[i5];
                    i6 += 2;
                    i5 += 2;
                    dArr[i8] = fArr[i9];
                }
                break;
            case 1:
                double d = this.m02;
                double d2 = this.m12;
                int i10 = i;
                int i11 = i2;
                int i12 = i4;
                while (true) {
                    i12--;
                    if (i12 < 0) {
                        return;
                    }
                    int i13 = i11 + 1;
                    int i14 = i10 + 1;
                    dArr[i11] = ((double) fArr[i10]) + d;
                    i11 += 2;
                    i10 += 2;
                    dArr[i13] = ((double) fArr[i14]) + d2;
                }
                break;
            case 2:
                double d3 = this.m00;
                double d4 = this.m11;
                int i15 = i;
                int i16 = i2;
                int i17 = i4;
                while (true) {
                    i17--;
                    if (i17 < 0) {
                        return;
                    }
                    int i18 = i16 + 1;
                    int i19 = i15 + 1;
                    dArr[i16] = ((double) fArr[i15]) * d3;
                    i16 += 2;
                    i15 += 2;
                    dArr[i18] = ((double) fArr[i19]) * d4;
                }
                break;
            case 3:
                double d5 = this.m00;
                double d6 = this.m02;
                double d7 = this.m11;
                double d8 = this.m12;
                int i20 = i;
                int i21 = i2;
                int i22 = i4;
                while (true) {
                    i22--;
                    if (i22 < 0) {
                        return;
                    }
                    int i23 = i21 + 1;
                    int i24 = i20 + 1;
                    dArr[i21] = (((double) fArr[i20]) * d5) + d6;
                    i21 += 2;
                    i20 += 2;
                    dArr[i23] = (((double) fArr[i24]) * d7) + d8;
                }
                break;
            case 4:
                double d9 = this.m01;
                double d10 = this.m10;
                int i25 = i;
                int i26 = i2;
                int i27 = i4;
                while (true) {
                    i27--;
                    if (i27 < 0) {
                        return;
                    }
                    int i28 = i25 + 1;
                    double d11 = fArr[i25];
                    int i29 = i26 + 1;
                    i25 += 2;
                    dArr[i26] = ((double) fArr[i28]) * d9;
                    i26 += 2;
                    dArr[i29] = d11 * d10;
                }
                break;
            case 5:
                double d12 = this.m01;
                double d13 = this.m02;
                double d14 = this.m10;
                double d15 = this.m12;
                int i30 = i;
                int i31 = i2;
                int i32 = i4;
                while (true) {
                    i32--;
                    if (i32 < 0) {
                        return;
                    }
                    int i33 = i30 + 1;
                    double d16 = fArr[i30];
                    int i34 = i31 + 1;
                    i30 += 2;
                    double d17 = d12;
                    dArr[i31] = (((double) fArr[i33]) * d17) + d13;
                    i31 += 2;
                    dArr[i34] = (d16 * d14) + d15;
                    d12 = d17;
                }
                break;
            case 6:
                double d18 = this.m00;
                double d19 = this.m01;
                double d20 = this.m10;
                double d21 = this.m11;
                int i35 = i;
                int i36 = i2;
                int i37 = i4;
                while (true) {
                    i37--;
                    if (i37 < 0) {
                        return;
                    }
                    int i38 = i35 + 1;
                    double d22 = fArr[i35];
                    i35 += 2;
                    double d23 = d18;
                    double d24 = fArr[i38];
                    int i39 = i36 + 1;
                    dArr[i36] = (d19 * d24) + (d23 * d22);
                    i36 += 2;
                    dArr[i39] = (d24 * d21) + (d22 * d20);
                    d18 = d23;
                }
                break;
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d25 = this.m00;
        double d26 = this.m01;
        double d27 = this.m02;
        double d28 = this.m10;
        double d29 = this.m11;
        double d30 = this.m12;
        int i40 = i;
        int i41 = i2;
        int i42 = i4;
        while (true) {
            int i43 = i42 - 1;
            if (i43 < 0) {
                return;
            }
            double d31 = d25;
            double d32 = fArr[i40];
            int i44 = i40 + 2;
            double d33 = fArr[i40 + 1];
            double d34 = d30;
            dArr[i41] = AbstractC1974b.m1307D(d26, d33, d31 * d32, d27);
            dArr[i41 + 1] = AbstractC1974b.m1307D(d29, d33, d28 * d32, d34);
            i41 += 2;
            d30 = d34;
            i42 = i43;
            d25 = d31;
            i40 = i44;
        }
    }

    public AffineTransform(AffineTransform affineTransform) {
        this.m00 = affineTransform.m00;
        this.m10 = affineTransform.m10;
        this.m01 = affineTransform.m01;
        this.m11 = affineTransform.m11;
        this.m02 = affineTransform.m02;
        this.m12 = affineTransform.m12;
        this.state = affineTransform.state;
        this.type = affineTransform.type;
    }

    public void transform(float[] fArr, int i, float[] fArr2, int i2, int i4) {
        int i5 = i;
        int i6 = i2;
        if (fArr2 == fArr && i6 > i5) {
            int i7 = i4 * 2;
            if (i6 < i5 + i7) {
                System.arraycopy(fArr, i5, fArr2, i6, i7);
                i5 = i6;
            }
        }
        switch (this.state) {
            case 0:
                if (fArr == fArr2 && i5 == i6) {
                    return;
                }
                System.arraycopy(fArr, i5, fArr2, i6, i4 * 2);
                return;
            case 1:
                double d = this.m02;
                double d2 = this.m12;
                int i8 = i5;
                int i9 = i4;
                while (true) {
                    i9--;
                    if (i9 < 0) {
                        return;
                    }
                    int i10 = i6 + 1;
                    int i11 = i8 + 1;
                    fArr2[i6] = (float) (((double) fArr[i8]) + d);
                    i6 += 2;
                    i8 += 2;
                    fArr2[i10] = (float) (((double) fArr[i11]) + d2);
                }
                break;
            case 2:
                double d3 = this.m00;
                double d4 = this.m11;
                int i12 = i5;
                int i13 = i4;
                while (true) {
                    i13--;
                    if (i13 < 0) {
                        return;
                    }
                    int i14 = i6 + 1;
                    int i15 = i12 + 1;
                    fArr2[i6] = (float) (((double) fArr[i12]) * d3);
                    i6 += 2;
                    i12 += 2;
                    fArr2[i14] = (float) (((double) fArr[i15]) * d4);
                }
                break;
            case 3:
                double d5 = this.m00;
                double d6 = this.m02;
                double d7 = this.m11;
                double d8 = this.m12;
                int i16 = i5;
                int i17 = i4;
                while (true) {
                    int i18 = i17 - 1;
                    if (i18 < 0) {
                        return;
                    }
                    int i19 = i6 + 1;
                    int i20 = i16 + 1;
                    int i21 = i6;
                    double d9 = d5;
                    fArr2[i21] = (float) ((d9 * ((double) fArr[i16])) + d6);
                    i6 = i21 + 2;
                    i16 += 2;
                    fArr2[i19] = (float) ((((double) fArr[i20]) * d7) + d8);
                    i17 = i18;
                    d5 = d9;
                }
                break;
            case 4:
                double d10 = this.m01;
                double d11 = this.m10;
                int i22 = i5;
                int i23 = i4;
                while (true) {
                    i23--;
                    if (i23 < 0) {
                        return;
                    }
                    int i24 = i22 + 1;
                    double d12 = fArr[i22];
                    int i25 = i6 + 1;
                    i22 += 2;
                    fArr2[i6] = (float) (((double) fArr[i24]) * d10);
                    i6 += 2;
                    fArr2[i25] = (float) (d12 * d11);
                }
                break;
            case 5:
                double d13 = this.m01;
                double d14 = this.m02;
                double d15 = this.m10;
                double d16 = this.m12;
                int i26 = i5;
                int i27 = i4;
                while (true) {
                    i27--;
                    if (i27 < 0) {
                        return;
                    }
                    int i28 = i26 + 1;
                    int i29 = i6;
                    double d17 = d13;
                    double d18 = fArr[i26];
                    i26 += 2;
                    fArr2[i29] = (float) ((((double) fArr[i28]) * d17) + d14);
                    fArr2[i29 + 1] = (float) ((d18 * d15) + d16);
                    i6 = i29 + 2;
                    d13 = d17;
                }
                break;
            case 6:
                double d19 = this.m00;
                double d20 = this.m01;
                double d21 = this.m10;
                double d22 = this.m11;
                int i30 = i5;
                int i31 = i4;
                while (true) {
                    i31--;
                    if (i31 < 0) {
                        return;
                    }
                    int i32 = i30 + 1;
                    int i33 = i6;
                    double d23 = d19;
                    double d24 = fArr[i30];
                    i30 += 2;
                    double d25 = fArr[i32];
                    fArr2[i33] = (float) ((d20 * d25) + (d23 * d24));
                    i6 = i33 + 2;
                    fArr2[i33 + 1] = (float) ((d25 * d22) + (d21 * d24));
                    d19 = d23;
                }
                break;
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d26 = this.m00;
        double d27 = this.m01;
        double d28 = this.m02;
        double d29 = this.m10;
        double d30 = this.m11;
        double d31 = this.m12;
        int i34 = i5;
        int i35 = i4;
        while (true) {
            int i36 = i35 - 1;
            if (i36 < 0) {
                return;
            }
            int i37 = i6;
            double d32 = d31;
            double d33 = fArr[i34];
            double d34 = fArr[i34 + 1];
            double d35 = d30;
            double d36 = d29;
            fArr2[i37] = (float) AbstractC1974b.m1307D(d27, d34, d26 * d33, d28);
            fArr2[i37 + 1] = (float) AbstractC1974b.m1307D(d35, d34, d36 * d33, d32);
            i34 += 2;
            d29 = d36;
            i6 = i37 + 2;
            d30 = d35;
            d31 = d32;
            i35 = i36;
        }
    }

    public AffineTransform(double[] dArr) {
        this.m00 = dArr[0];
        this.m10 = dArr[1];
        this.m01 = dArr[2];
        this.m11 = dArr[3];
        if (dArr.length > 5) {
            this.m02 = dArr[4];
            this.m12 = dArr[5];
        }
        updateState();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void transform(Point2D[] point2DArr, int i, Point2D[] point2DArr2, int i2, int i4) {
        double d;
        double d2;
        double d3;
        double d4;
        int i5 = this.state;
        int i6 = i;
        int i7 = i2;
        int i8 = i4;
        while (true) {
            i8--;
            if (i8 < 0) {
                return;
            }
            int i9 = i6 + 1;
            Point2D point2D = point2DArr[i6];
            double x = point2D.getX();
            double y2 = point2D.getY();
            int i10 = i7 + 1;
            Point2D point2D2 = point2DArr2[i7];
            if (point2D2 == null) {
                point2D2 = point2D instanceof Point2D.Double ? new Point2D.Double() : new Point2D.Float();
                point2DArr2[i7] = point2D2;
            }
            switch (i5) {
                case 0:
                    point2D2.setLocation(x, y2);
                    break;
                case 1:
                    x += this.m02;
                    y2 += this.m12;
                    point2D2.setLocation(x, y2);
                    break;
                case 2:
                    x *= this.m00;
                    y2 *= this.m11;
                    point2D2.setLocation(x, y2);
                    break;
                case 3:
                    x = (x * this.m00) + this.m02;
                    y2 *= this.m11;
                    y2 += this.m12;
                    point2D2.setLocation(x, y2);
                    break;
                case 4:
                    d = y2 * this.m01;
                    d2 = x * this.m10;
                    point2D2.setLocation(d, d2);
                    break;
                case 5:
                    d = (y2 * this.m01) + this.m02;
                    d2 = (x * this.m10) + this.m12;
                    point2D2.setLocation(d, d2);
                    break;
                case 6:
                    d3 = (this.m01 * y2) + (this.m00 * x);
                    d4 = (y2 * this.m11) + (x * this.m10);
                    point2D2.setLocation(d3, d4);
                    break;
                case 7:
                    d3 = (this.m01 * y2) + (this.m00 * x) + this.m02;
                    d4 = (y2 * this.m11) + (x * this.m10) + this.m12;
                    point2D2.setLocation(d3, d4);
                    break;
                default:
                    stateError();
                    d3 = (this.m01 * y2) + (this.m00 * x) + this.m02;
                    d4 = (y2 * this.m11) + (x * this.m10) + this.m12;
                    point2D2.setLocation(d3, d4);
                    break;
            }
            i6 = i9;
            i7 = i10;
        }
    }

    public AffineTransform(float[] fArr) {
        this.m00 = fArr[0];
        this.m10 = fArr[1];
        this.m01 = fArr[2];
        this.m11 = fArr[3];
        if (fArr.length > 5) {
            this.m02 = fArr[4];
            this.m12 = fArr[5];
        }
        updateState();
    }

    public void inverseTransform(double[] dArr, int i, double[] dArr2, int i2, int i4) throws NoninvertibleTransformException {
        int i5 = i;
        int i6 = i2;
        if (dArr2 == dArr && i6 > i5) {
            int i7 = i4 * 2;
            if (i6 < i5 + i7) {
                System.arraycopy(dArr, i5, dArr2, i6, i7);
                i5 = i6;
            }
        }
        switch (this.state) {
            case 0:
                if (dArr == dArr2 && i5 == i6) {
                    return;
                }
                System.arraycopy(dArr, i5, dArr2, i6, i4 * 2);
                return;
            case 1:
                double d = this.m02;
                double d2 = this.m12;
                int i8 = i5;
                int i9 = i4;
                while (true) {
                    i9--;
                    if (i9 < 0) {
                        return;
                    }
                    int i10 = i6 + 1;
                    int i11 = i8 + 1;
                    dArr2[i6] = dArr[i8] - d;
                    i6 += 2;
                    i8 += 2;
                    dArr2[i10] = dArr[i11] - d2;
                }
                break;
            case 2:
                double d3 = this.m00;
                double d4 = this.m11;
                if (d3 == 0.0d || d4 == 0.0d) {
                    throw new NoninvertibleTransformException("Determinant is 0");
                }
                int i12 = i5;
                int i13 = i4;
                while (true) {
                    i13--;
                    if (i13 < 0) {
                        return;
                    }
                    int i14 = i6 + 1;
                    int i15 = i12 + 1;
                    dArr2[i6] = dArr[i12] / d3;
                    i6 += 2;
                    i12 += 2;
                    dArr2[i14] = dArr[i15] / d4;
                }
                break;
            case 3:
                double d5 = this.m00;
                double d6 = this.m02;
                double d7 = this.m11;
                double d8 = this.m12;
                if (d5 == 0.0d || d7 == 0.0d) {
                    throw new NoninvertibleTransformException("Determinant is 0");
                }
                int i16 = i5;
                int i17 = i4;
                while (true) {
                    i17--;
                    if (i17 < 0) {
                        return;
                    }
                    int i18 = i6 + 1;
                    int i19 = i16 + 1;
                    dArr2[i6] = (dArr[i16] - d6) / d5;
                    i6 += 2;
                    i16 += 2;
                    dArr2[i18] = (dArr[i19] - d8) / d7;
                }
                break;
            case 4:
                double d9 = this.m01;
                double d10 = this.m10;
                if (d9 == 0.0d || d10 == 0.0d) {
                    throw new NoninvertibleTransformException("Determinant is 0");
                }
                int i20 = i5;
                int i21 = i4;
                while (true) {
                    i21--;
                    if (i21 < 0) {
                        return;
                    }
                    int i22 = i20 + 1;
                    double d11 = dArr[i20];
                    int i23 = i6 + 1;
                    i20 += 2;
                    dArr2[i6] = dArr[i22] / d10;
                    i6 += 2;
                    dArr2[i23] = d11 / d9;
                }
                break;
            case 5:
                double d12 = this.m01;
                double d13 = this.m02;
                double d14 = this.m10;
                double d15 = this.m12;
                if (d12 == 0.0d || d14 == 0.0d) {
                    throw new NoninvertibleTransformException("Determinant is 0");
                }
                int i24 = i5;
                int i25 = i4;
                while (true) {
                    i25--;
                    if (i25 < 0) {
                        return;
                    }
                    int i26 = i24 + 1;
                    double d16 = dArr[i24] - d13;
                    int i27 = i6 + 1;
                    i24 += 2;
                    dArr2[i6] = (dArr[i26] - d15) / d14;
                    i6 += 2;
                    dArr2[i27] = d16 / d12;
                }
                break;
            case 6:
                double d17 = this.m00;
                double d18 = this.m01;
                double d19 = this.m10;
                double d20 = this.m11;
                double d21 = (d17 * d20) - (d18 * d19);
                if (Math.abs(d21) <= Double.MIN_VALUE) {
                    throw new NoninvertibleTransformException(AbstractC1974b.m1318k("Determinant is ", d21));
                }
                int i28 = i5;
                int i29 = i4;
                while (true) {
                    i29--;
                    if (i29 < 0) {
                        return;
                    }
                    int i30 = i28 + 1;
                    double d22 = dArr[i28];
                    i28 += 2;
                    double d23 = dArr[i30];
                    int i31 = i6 + 1;
                    double d24 = d18;
                    dArr2[i6] = AbstractC1974b.m1333z(d23, d24, d22 * d20, d21);
                    i6 += 2;
                    double d25 = d19;
                    dArr2[i31] = AbstractC1974b.m1333z(d22, d25, d23 * d17, d21);
                    d19 = d25;
                    d18 = d24;
                }
                break;
            case 7:
                break;
            default:
                stateError();
                break;
        }
        double d26 = this.m00;
        double d27 = this.m01;
        double d28 = this.m02;
        double d29 = this.m10;
        double d30 = this.m11;
        double d31 = this.m12;
        double d32 = (d26 * d30) - (d27 * d29);
        if (Math.abs(d32) <= Double.MIN_VALUE) {
            throw new NoninvertibleTransformException(AbstractC1974b.m1318k("Determinant is ", d32));
        }
        int i32 = i5;
        int i33 = i4;
        while (true) {
            i33--;
            if (i33 < 0) {
                return;
            }
            double d33 = dArr[i32] - d28;
            double d34 = dArr[i32 + 1] - d31;
            dArr2[i6] = AbstractC1974b.m1333z(d34, d27, d33 * d30, d32);
            double d35 = d29;
            double d36 = d32;
            dArr2[i6 + 1] = AbstractC1974b.m1333z(d33, d35, d34 * d26, d36);
            d29 = d35;
            d28 = d28;
            d32 = d36;
            i32 += 2;
            i6 += 2;
        }
    }
}
