package org.apache.poi.java.awt;

import java.beans.ConstructorProperties;
import java.util.Arrays;
import org.apache.poi.sun.java2d.pipe.RenderingEngine;

/* JADX INFO: loaded from: classes10.dex */
public class BasicStroke implements Stroke {
    public static final int CAP_BUTT = 0;
    public static final int CAP_ROUND = 1;
    public static final int CAP_SQUARE = 2;
    public static final int JOIN_BEVEL = 2;
    public static final int JOIN_MITER = 0;
    public static final int JOIN_ROUND = 1;
    int cap;
    float[] dash;
    float dash_phase;
    int join;
    float miterlimit;
    float width;

    public BasicStroke() {
        this(1.0f, 2, 0, 10.0f, null, 0.0f);
    }

    @Override // org.apache.poi.java.awt.Stroke
    public Shape createStrokedShape(Shape shape) {
        return RenderingEngine.getInstance().createStrokedShape(shape, this.width, this.cap, this.join, this.miterlimit, this.dash, this.dash_phase);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BasicStroke)) {
            return false;
        }
        BasicStroke basicStroke = (BasicStroke) obj;
        if (this.width != basicStroke.width || this.join != basicStroke.join || this.cap != basicStroke.cap || this.miterlimit != basicStroke.miterlimit) {
            return false;
        }
        float[] fArr = this.dash;
        return fArr != null ? this.dash_phase == basicStroke.dash_phase && Arrays.equals(fArr, basicStroke.dash) : basicStroke.dash == null;
    }

    public float[] getDashArray() {
        float[] fArr = this.dash;
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public float getDashPhase() {
        return this.dash_phase;
    }

    public int getEndCap() {
        return this.cap;
    }

    public int getLineJoin() {
        return this.join;
    }

    public float getLineWidth() {
        return this.width;
    }

    public float getMiterLimit() {
        return this.miterlimit;
    }

    public int hashCode() {
        int iFloatToIntBits = Float.floatToIntBits(this.miterlimit) + (((((Float.floatToIntBits(this.width) * 31) + this.join) * 31) + this.cap) * 31);
        if (this.dash == null) {
            return iFloatToIntBits;
        }
        int iFloatToIntBits2 = Float.floatToIntBits(this.dash_phase) + (iFloatToIntBits * 31);
        int i = 0;
        while (true) {
            float[] fArr = this.dash;
            if (i >= fArr.length) {
                return iFloatToIntBits2;
            }
            iFloatToIntBits2 = (iFloatToIntBits2 * 31) + Float.floatToIntBits(fArr[i]);
            i++;
        }
    }

    public BasicStroke(float f) {
        this(f, 2, 0, 10.0f, null, 0.0f);
    }

    public BasicStroke(float f, int i, int i2) {
        this(f, i, i2, 10.0f, null, 0.0f);
    }

    public BasicStroke(float f, int i, int i2, float f4) {
        this(f, i, i2, f4, null, 0.0f);
    }

    @ConstructorProperties({"lineWidth", "endCap", "lineJoin", "miterLimit", "dashArray", "dashPhase"})
    public BasicStroke(float f, int i, int i2, float f4, float[] fArr, float f5) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("negative width");
        }
        boolean z = true;
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("illegal end cap value");
        }
        if (i2 == 0) {
            if (f4 < 1.0f) {
                throw new IllegalArgumentException("miter limit < 1");
            }
        } else if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("illegal line join value");
        }
        if (fArr != null) {
            if (f5 < 0.0f) {
                throw new IllegalArgumentException("negative dash phase");
            }
            for (double d : fArr) {
                if (d > 0.0d) {
                    z = false;
                } else if (d < 0.0d) {
                    throw new IllegalArgumentException("negative dash length");
                }
            }
            if (z) {
                throw new IllegalArgumentException("dash lengths all zero");
            }
        }
        this.width = f;
        this.cap = i;
        this.join = i2;
        this.miterlimit = f4;
        if (fArr != null) {
            this.dash = (float[]) fArr.clone();
        }
        this.dash_phase = f5;
    }
}
