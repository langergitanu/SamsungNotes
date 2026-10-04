package org.apache.poi.javax.imageio;

import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IIOParam {
    protected Rectangle sourceRegion = null;
    protected int sourceXSubsampling = 1;
    protected int sourceYSubsampling = 1;
    protected int subsamplingXOffset = 0;
    protected int subsamplingYOffset = 0;
    protected int[] sourceBands = null;
    protected ImageTypeSpecifier destinationType = null;
    protected Point destinationOffset = new Point(0, 0);
    protected IIOParamController defaultController = null;
    protected IIOParamController controller = null;

    public boolean activateController() {
        if (hasController()) {
            return getController().activate(this);
        }
        throw new IllegalStateException("hasController() == false!");
    }

    public IIOParamController getController() {
        return this.controller;
    }

    public IIOParamController getDefaultController() {
        return this.defaultController;
    }

    public Point getDestinationOffset() {
        return (Point) this.destinationOffset.clone();
    }

    public ImageTypeSpecifier getDestinationType() {
        return this.destinationType;
    }

    public int[] getSourceBands() {
        int[] iArr = this.sourceBands;
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public Rectangle getSourceRegion() {
        Rectangle rectangle = this.sourceRegion;
        if (rectangle == null) {
            return null;
        }
        return (Rectangle) rectangle.clone();
    }

    public int getSourceXSubsampling() {
        return this.sourceXSubsampling;
    }

    public int getSourceYSubsampling() {
        return this.sourceYSubsampling;
    }

    public int getSubsamplingXOffset() {
        return this.subsamplingXOffset;
    }

    public int getSubsamplingYOffset() {
        return this.subsamplingYOffset;
    }

    public boolean hasController() {
        return this.controller != null;
    }

    public void setController(IIOParamController iIOParamController) {
        this.controller = iIOParamController;
    }

    public void setDestinationOffset(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("destinationOffset == null!");
        }
        this.destinationOffset = (Point) point.clone();
    }

    public void setDestinationType(ImageTypeSpecifier imageTypeSpecifier) {
        this.destinationType = imageTypeSpecifier;
    }

    public void setSourceBands(int[] iArr) {
        if (iArr == null) {
            this.sourceBands = null;
            return;
        }
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            int i2 = iArr[i];
            if (i2 < 0) {
                throw new IllegalArgumentException("Band value < 0!");
            }
            i++;
            for (int i4 = i; i4 < length; i4++) {
                if (i2 == iArr[i4]) {
                    throw new IllegalArgumentException("Duplicate band value!");
                }
            }
        }
        this.sourceBands = (int[]) iArr.clone();
    }

    public void setSourceRegion(Rectangle rectangle) {
        if (rectangle == null) {
            this.sourceRegion = null;
            return;
        }
        if (rectangle.f10094x < 0) {
            throw new IllegalArgumentException("sourceRegion.x < 0!");
        }
        if (rectangle.f10095y < 0) {
            throw new IllegalArgumentException("sourceRegion.y < 0!");
        }
        int i = rectangle.width;
        if (i <= 0) {
            throw new IllegalArgumentException("sourceRegion.width <= 0!");
        }
        int i2 = rectangle.height;
        if (i2 <= 0) {
            throw new IllegalArgumentException("sourceRegion.height <= 0!");
        }
        if (i <= this.subsamplingXOffset) {
            throw new IllegalStateException("sourceRegion.width <= subsamplingXOffset!");
        }
        if (i2 <= this.subsamplingYOffset) {
            throw new IllegalStateException("sourceRegion.height <= subsamplingYOffset!");
        }
        this.sourceRegion = (Rectangle) rectangle.clone();
    }

    public void setSourceSubsampling(int i, int i2, int i4, int i5) {
        if (i <= 0) {
            throw new IllegalArgumentException("sourceXSubsampling <= 0!");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("sourceYSubsampling <= 0!");
        }
        if (i4 < 0 || i4 >= i) {
            throw new IllegalArgumentException("subsamplingXOffset out of range!");
        }
        if (i5 < 0 || i5 >= i2) {
            throw new IllegalArgumentException("subsamplingYOffset out of range!");
        }
        Rectangle rectangle = this.sourceRegion;
        if (rectangle != null && (i4 >= rectangle.width || i5 >= rectangle.height)) {
            throw new IllegalStateException("region contains no pixels!");
        }
        this.sourceXSubsampling = i;
        this.sourceYSubsampling = i2;
        this.subsamplingXOffset = i4;
        this.subsamplingYOffset = i5;
    }
}
