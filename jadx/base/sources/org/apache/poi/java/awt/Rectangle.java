package org.apache.poi.java.awt;

import androidx.glance.AbstractC2821a;
import java.beans.Transient;
import java.io.Serializable;
import org.apache.poi.java.awt.geom.Rectangle2D;

/* JADX INFO: loaded from: classes10.dex */
public class Rectangle extends Rectangle2D implements Shape, Serializable {
    private static final long serialVersionUID = -4345857070255674764L;
    public int height;
    public int width;

    /* JADX INFO: renamed from: x */
    public int f10094x;

    /* JADX INFO: renamed from: y */
    public int f10095y;

    static {
        Toolkit.loadLibraries();
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        initIDs();
    }

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    private static int clip(double d, boolean z) {
        if (d <= -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        if (d >= 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        return (int) (z ? Math.ceil(d) : Math.floor(d));
    }

    private static native void initIDs();

    public void add(int i, int i2) {
        int i4 = this.width;
        int i5 = this.height;
        if ((i4 | i5) < 0) {
            this.f10094x = i;
            this.f10095y = i2;
            this.height = 0;
            this.width = 0;
            return;
        }
        int i6 = this.f10094x;
        int i7 = this.f10095y;
        long j = ((long) i4) + ((long) i6);
        long j2 = ((long) i5) + ((long) i7);
        if (i6 > i) {
            i6 = i;
        }
        if (i7 > i2) {
            i7 = i2;
        }
        long j3 = i;
        if (j < j3) {
            j = j3;
        }
        long j5 = i2;
        if (j2 < j5) {
            j2 = j5;
        }
        long j6 = j - ((long) i6);
        long j7 = j2 - ((long) i7);
        if (j6 > 2147483647L) {
            j6 = 2147483647L;
        }
        if (j7 > 2147483647L) {
            j7 = 2147483647L;
        }
        reshape(i6, i7, (int) j6, (int) j7);
    }

    public boolean contains(int i, int i2) {
        return inside(i, i2);
    }

    @Override // org.apache.poi.java.awt.geom.Rectangle2D
    public Rectangle2D createIntersection(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return intersection((Rectangle) rectangle2D);
        }
        Rectangle2D.Double r02 = new Rectangle2D.Double();
        Rectangle2D.intersect(this, rectangle2D, r02);
        return r02;
    }

    @Override // org.apache.poi.java.awt.geom.Rectangle2D
    public Rectangle2D createUnion(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return union((Rectangle) rectangle2D);
        }
        Rectangle2D.Double r02 = new Rectangle2D.Double();
        Rectangle2D.union(this, rectangle2D, r02);
        return r02;
    }

    @Override // org.apache.poi.java.awt.geom.Rectangle2D
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle)) {
            return super.equals(obj);
        }
        Rectangle rectangle = (Rectangle) obj;
        return this.f10094x == rectangle.f10094x && this.f10095y == rectangle.f10095y && this.width == rectangle.width && this.height == rectangle.height;
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape, org.apache.poi.java.awt.Shape
    @Transient
    public Rectangle getBounds() {
        return new Rectangle(this.f10094x, this.f10095y, this.width, this.height);
    }

    @Override // org.apache.poi.java.awt.geom.Rectangle2D, org.apache.poi.java.awt.Shape
    public Rectangle2D getBounds2D() {
        return new Rectangle(this.f10094x, this.f10095y, this.width, this.height);
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape
    public double getHeight() {
        return this.height;
    }

    public Point getLocation() {
        return new Point(this.f10094x, this.f10095y);
    }

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape
    public double getWidth() {
        return this.width;
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape
    public double getX() {
        return this.f10094x;
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape
    public double getY() {
        return this.f10095y;
    }

    public void grow(int i, int i2) {
        long j;
        long j2;
        long j3 = this.f10094x;
        long j5 = this.f10095y;
        long j6 = ((long) this.width) + j3;
        long j7 = ((long) this.height) + j5;
        long j8 = i;
        long j9 = j3 - j8;
        long j10 = i2;
        long j11 = j5 - j10;
        long j12 = j6 + j8;
        long j13 = j7 + j10;
        long j14 = 2147483647L;
        if (j12 < j9) {
            j = j12 - j9;
            if (j < -2147483648L) {
                j = -2147483648L;
            }
            if (j9 < -2147483648L) {
                j9 = -2147483648L;
            } else if (j9 > 2147483647L) {
                j9 = 2147483647L;
            }
        } else {
            if (j9 < -2147483648L) {
                j9 = -2147483648L;
            } else if (j9 > 2147483647L) {
                j9 = 2147483647L;
            }
            j = j12 - j9;
            if (j < -2147483648L) {
                j = -2147483648L;
            } else if (j > 2147483647L) {
                j = 2147483647L;
            }
        }
        if (j13 < j11) {
            j2 = j13 - j11;
            if (j2 < -2147483648L) {
                j2 = -2147483648L;
            }
            if (j11 < -2147483648L) {
                j14 = j2;
                j11 = -2147483648L;
            } else {
                if (j11 > 2147483647L) {
                    j11 = 2147483647L;
                }
                j14 = j2;
            }
        } else {
            if (j11 < -2147483648L) {
                j11 = -2147483648L;
            } else if (j11 > 2147483647L) {
                j11 = 2147483647L;
            }
            j2 = j13 - j11;
            if (j2 < -2147483648L) {
                j14 = -2147483648L;
            } else if (j2 <= 2147483647L) {
                j14 = j2;
            }
        }
        reshape((int) j9, (int) j11, (int) j, (int) j14);
    }

    @Deprecated
    public boolean inside(int i, int i2) {
        int i4 = this.width;
        int i5 = this.height;
        if ((i4 | i5) < 0) {
            return false;
        }
        int i6 = this.f10094x;
        int i7 = this.f10095y;
        if (i < i6 || i2 < i7) {
            return false;
        }
        int i8 = i4 + i6;
        int i9 = i5 + i7;
        return (i8 < i6 || i8 > i) && (i9 < i7 || i9 > i2);
    }

    public Rectangle intersection(Rectangle rectangle) {
        int i = this.f10094x;
        int i2 = this.f10095y;
        int i4 = rectangle.f10094x;
        int i5 = rectangle.f10095y;
        long j = ((long) i) + ((long) this.width);
        long j2 = ((long) i2) + ((long) this.height);
        long j3 = ((long) i4) + ((long) rectangle.width);
        long j5 = ((long) i5) + ((long) rectangle.height);
        if (i < i4) {
            i = i4;
        }
        if (i2 < i5) {
            i2 = i5;
        }
        if (j > j3) {
            j = j3;
        }
        if (j2 > j5) {
            j2 = j5;
        }
        long j6 = j - ((long) i);
        long j7 = j2 - ((long) i2);
        if (j6 < -2147483648L) {
            j6 = -2147483648L;
        }
        if (j7 < -2147483648L) {
            j7 = -2147483648L;
        }
        return new Rectangle(i, i2, (int) j6, (int) j7);
    }

    public boolean intersects(Rectangle rectangle) {
        int i = this.width;
        int i2 = this.height;
        int i4 = rectangle.width;
        int i5 = rectangle.height;
        if (i4 <= 0 || i5 <= 0 || i <= 0 || i2 <= 0) {
            return false;
        }
        int i6 = this.f10094x;
        int i7 = this.f10095y;
        int i8 = rectangle.f10094x;
        int i9 = rectangle.f10095y;
        int i10 = i4 + i8;
        int i11 = i5 + i9;
        int i12 = i + i6;
        int i13 = i2 + i7;
        return (i10 < i8 || i10 > i6) && (i11 < i9 || i11 > i7) && ((i12 < i6 || i12 > i8) && (i13 < i7 || i13 > i9));
    }

    @Override // org.apache.poi.java.awt.geom.RectangularShape
    public boolean isEmpty() {
        return this.width <= 0 || this.height <= 0;
    }

    @Deprecated
    public void move(int i, int i2) {
        this.f10094x = i;
        this.f10095y = i2;
    }

    @Override // org.apache.poi.java.awt.geom.Rectangle2D
    public int outcode(double d, double d2) {
        int i;
        int i2 = this.width;
        if (i2 <= 0) {
            i = 5;
        } else {
            int i4 = this.f10094x;
            i = d < ((double) i4) ? 1 : d > ((double) i4) + ((double) i2) ? 4 : 0;
        }
        int i5 = this.height;
        if (i5 <= 0) {
            return i | 10;
        }
        int i6 = this.f10095y;
        return d2 < ((double) i6) ? i | 2 : d2 > ((double) i6) + ((double) i5) ? i | 8 : i;
    }

    @Deprecated
    public void reshape(int i, int i2, int i4, int i5) {
        this.f10094x = i;
        this.f10095y = i2;
        this.width = i4;
        this.height = i5;
    }

    @Deprecated
    public void resize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void setBounds(int i, int i2, int i4, int i5) {
        reshape(i, i2, i4, i5);
    }

    public void setLocation(int i, int i2) {
        move(i, i2);
    }

    @Override // org.apache.poi.java.awt.geom.Rectangle2D
    public void setRect(double d, double d2, double d3, double d4) {
        int iClip;
        int iClip2;
        int iClip3 = -1;
        int iClip4 = Integer.MAX_VALUE;
        if (d > 4.294967294E9d) {
            iClip2 = -1;
            iClip = Integer.MAX_VALUE;
        } else {
            iClip = clip(d, false);
            double d5 = d3 >= 0.0d ? (d - ((double) iClip)) + d3 : d3;
            iClip2 = clip(d5, d5 >= 0.0d);
        }
        if (d2 <= 4.294967294E9d) {
            iClip4 = clip(d2, false);
            double d6 = d4 >= 0.0d ? (d2 - ((double) iClip4)) + d4 : d4;
            iClip3 = clip(d6, d6 >= 0.0d);
        }
        reshape(iClip, iClip4, iClip2, iClip3);
    }

    public void setSize(int i, int i2) {
        resize(i, i2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[x=");
        sb.append(this.f10094x);
        sb.append(",y=");
        sb.append(this.f10095y);
        sb.append(",width=");
        sb.append(this.width);
        sb.append(",height=");
        return AbstractC2821a.m2223n(sb, "]", this.height);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void translate(int i, int i2) {
        int i4 = this.f10094x;
        int i5 = i4 + i;
        int i6 = Integer.MIN_VALUE;
        if (i < 0) {
            if (i5 > i4) {
                int i7 = this.width;
                if (i7 >= 0) {
                    this.width = (i5 - Integer.MIN_VALUE) + i7;
                }
                i5 = Integer.MIN_VALUE;
            }
        } else if (i5 < i4) {
            int i8 = this.width;
            if (i8 >= 0) {
                int i9 = (i5 - Integer.MAX_VALUE) + i8;
                this.width = i9;
                if (i9 < 0) {
                    this.width = Integer.MAX_VALUE;
                }
            }
            i5 = Integer.MAX_VALUE;
        }
        this.f10094x = i5;
        int i10 = this.f10095y;
        int i11 = i10 + i2;
        if (i2 < 0) {
            if (i11 > i10) {
                int i12 = this.height;
                if (i12 >= 0) {
                    this.height = (i11 - Integer.MIN_VALUE) + i12;
                }
            } else {
                i6 = i11;
            }
        } else if (i11 < i10) {
            int i13 = this.height;
            if (i13 >= 0) {
                int i14 = (i11 - Integer.MAX_VALUE) + i13;
                this.height = i14;
                if (i14 < 0) {
                    this.height = Integer.MAX_VALUE;
                }
            }
            i6 = Integer.MAX_VALUE;
        }
        this.f10095y = i6;
    }

    public Rectangle union(Rectangle rectangle) {
        long j = this.width;
        long j2 = this.height;
        if ((j | j2) < 0) {
            return new Rectangle(rectangle);
        }
        long j3 = rectangle.width;
        long j5 = rectangle.height;
        if ((j3 | j5) < 0) {
            return new Rectangle(this);
        }
        int i = this.f10094x;
        int i2 = this.f10095y;
        long j6 = j + ((long) i);
        long j7 = j2 + ((long) i2);
        int i4 = rectangle.f10094x;
        int i5 = rectangle.f10095y;
        long j8 = j3 + ((long) i4);
        long j9 = j5 + ((long) i5);
        if (i > i4) {
            i = i4;
        }
        if (i2 > i5) {
            i2 = i5;
        }
        if (j6 < j8) {
            j6 = j8;
        }
        if (j7 < j9) {
            j7 = j9;
        }
        long j10 = j6 - ((long) i);
        long j11 = j7 - ((long) i2);
        if (j10 > 2147483647L) {
            j10 = 2147483647L;
        }
        if (j11 > 2147483647L) {
            j11 = 2147483647L;
        }
        return new Rectangle(i, i2, (int) j10, (int) j11);
    }

    public Rectangle(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void add(Point point) {
        add(point.f10092x, point.f10093y);
    }

    public boolean contains(int i, int i2, int i4, int i5) {
        int i6 = this.width;
        int i7 = this.height;
        if ((i6 | i7 | i4 | i5) < 0) {
            return false;
        }
        int i8 = this.f10094x;
        int i9 = this.f10095y;
        if (i < i8 || i2 < i9) {
            return false;
        }
        int i10 = i6 + i8;
        int i11 = i4 + i;
        if (i11 <= i) {
            if (i10 >= i8 || i11 > i10) {
                return false;
            }
        } else if (i10 >= i8 && i11 > i10) {
            return false;
        }
        int i12 = i7 + i9;
        int i13 = i5 + i2;
        return i13 <= i2 ? i12 < i9 && i13 <= i12 : i12 < i9 || i13 <= i12;
    }

    public void setBounds(Rectangle rectangle) {
        setBounds(rectangle.f10094x, rectangle.f10095y, rectangle.width, rectangle.height);
    }

    public void setLocation(Point point) {
        setLocation(point.f10092x, point.f10093y);
    }

    public void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    public Rectangle(int i, int i2, int i4, int i5) {
        this.f10094x = i;
        this.f10095y = i2;
        this.width = i4;
        this.height = i5;
    }

    public void add(Rectangle rectangle) {
        long j = this.width;
        long j2 = this.height;
        if ((j | j2) < 0) {
            reshape(rectangle.f10094x, rectangle.f10095y, rectangle.width, rectangle.height);
        }
        long j3 = rectangle.width;
        long j5 = rectangle.height;
        if ((j3 | j5) < 0) {
            return;
        }
        int i = this.f10094x;
        int i2 = this.f10095y;
        long j6 = j + ((long) i);
        long j7 = j2 + ((long) i2);
        int i4 = rectangle.f10094x;
        int i5 = rectangle.f10095y;
        long j8 = j3 + ((long) i4);
        long j9 = j5 + ((long) i5);
        if (i > i4) {
            i = i4;
        }
        if (i2 > i5) {
            i2 = i5;
        }
        if (j6 < j8) {
            j6 = j8;
        }
        if (j7 < j9) {
            j7 = j9;
        }
        long j10 = j6 - ((long) i);
        long j11 = j7 - ((long) i2);
        if (j10 > 2147483647L) {
            j10 = 2147483647L;
        }
        if (j11 > 2147483647L) {
            j11 = 2147483647L;
        }
        reshape(i, i2, (int) j10, (int) j11);
    }

    public boolean contains(Point point) {
        return contains(point.f10092x, point.f10093y);
    }

    public Rectangle(Dimension dimension) {
        this(0, 0, dimension.width, dimension.height);
    }

    public boolean contains(Rectangle rectangle) {
        return contains(rectangle.f10094x, rectangle.f10095y, rectangle.width, rectangle.height);
    }

    public Rectangle(Point point) {
        this(point.f10092x, point.f10093y, 0, 0);
    }

    public Rectangle(Point point, Dimension dimension) {
        this(point.f10092x, point.f10093y, dimension.width, dimension.height);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.f10094x, rectangle.f10095y, rectangle.width, rectangle.height);
    }
}
