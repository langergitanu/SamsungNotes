package androidx.test.core.view;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class PointerPropertiesBuilder {

    /* JADX INFO: renamed from: id */
    private int f1694id;
    private int toolType;

    private PointerPropertiesBuilder() {
    }

    public static PointerPropertiesBuilder newBuilder() {
        return new PointerPropertiesBuilder();
    }

    public MotionEvent.PointerProperties build() {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = this.f1694id;
        pointerProperties.toolType = this.toolType;
        return pointerProperties;
    }

    public PointerPropertiesBuilder setId(int i) {
        this.f1694id = i;
        return this;
    }

    public PointerPropertiesBuilder setToolType(int i) {
        this.toolType = i;
        return this;
    }
}
