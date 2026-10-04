package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
public class PointerInfo {
    private GraphicsDevice device;
    private Point location;

    public PointerInfo(GraphicsDevice graphicsDevice, Point point) {
        this.device = graphicsDevice;
        this.location = point;
    }

    public GraphicsDevice getDevice() {
        return this.device;
    }

    public Point getLocation() {
        return this.location;
    }
}
