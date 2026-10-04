package org.apache.poi.java.awt.geom;

import org.apache.poi.java.awt.Shape;
import org.apache.poi.java.awt.geom.Path2D;

/* JADX INFO: loaded from: classes10.dex */
public final class GeneralPath extends Path2D.Float {
    private static final long serialVersionUID = -8327096662768731142L;

    public GeneralPath() {
        super(1, 20);
    }

    public GeneralPath(int i) {
        super(i, 20);
    }

    public GeneralPath(int i, int i2) {
        super(i, i2);
    }

    public GeneralPath(int i, byte[] bArr, int i2, float[] fArr, int i4) {
        this.windingRule = i;
        this.pointTypes = bArr;
        this.numTypes = i2;
        this.floatCoords = fArr;
        this.numCoords = i4;
    }

    public GeneralPath(Shape shape) {
        super(shape, (AffineTransform) null);
    }
}
