package androidx.test.core.view;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class PointerCoordsBuilder {
    private float orientation;
    private float toolMajor;
    private float toolMinor;
    private float touchMajor;
    private float touchMinor;

    /* JADX INFO: renamed from: x */
    private float f1692x = 0.0f;

    /* JADX INFO: renamed from: y */
    private float f1693y = 0.0f;
    private float pressure = 1.0f;
    private float size = 1.0f;

    private PointerCoordsBuilder() {
    }

    public static PointerCoordsBuilder newBuilder() {
        return new PointerCoordsBuilder();
    }

    public MotionEvent.PointerCoords build() {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = this.f1692x;
        pointerCoords.y = this.f1693y;
        pointerCoords.pressure = this.pressure;
        pointerCoords.size = this.size;
        pointerCoords.touchMajor = this.touchMajor;
        pointerCoords.touchMinor = this.touchMinor;
        pointerCoords.toolMajor = this.toolMajor;
        pointerCoords.toolMinor = this.toolMinor;
        pointerCoords.orientation = this.orientation;
        return pointerCoords;
    }

    public PointerCoordsBuilder setCoords(float f, float f4) {
        this.f1692x = f;
        this.f1693y = f4;
        return this;
    }

    public PointerCoordsBuilder setOrientation(float f) {
        this.orientation = f;
        return this;
    }

    public PointerCoordsBuilder setPressure(float f) {
        this.pressure = f;
        return this;
    }

    public PointerCoordsBuilder setSize(float f) {
        this.size = f;
        return this;
    }

    public PointerCoordsBuilder setTool(float f, float f4) {
        this.toolMajor = f;
        this.toolMinor = f4;
        return this;
    }

    public PointerCoordsBuilder setTouch(float f, float f4) {
        this.touchMajor = f;
        this.touchMinor = f4;
        return this;
    }
}
