package com.samsung.android.sdk.pen.painting;

import android.graphics.PointF;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.engine.SpenGestureController;
import com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\tH\u0016J \u0010&\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0016J\u000e\u0010)\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u001e¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenPaintingGestureController;", "Lcom/samsung/android/sdk/pen/engine/SpenGestureController;", "Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController;", "nativeGestureController", "", "<init>", "(J)V", "mNativeGestureController", "mListener", "Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController$PaintingListener;", "enabled", "", "isCanvasRotationEnabled", "()Z", "setCanvasRotationEnabled", "(Z)V", "canvasRotationAngle", "", "getCanvasRotationAngle", "()F", "canvasRotationPivot", "Landroid/graphics/PointF;", "getCanvasRotationPivot", "()Landroid/graphics/PointF;", "isRotationSnapEnabled", "setRotationSnapEnabled", "angle", "rotationSnapAngle", "getRotationSnapAngle", "setRotationSnapAngle", "(F)V", "rotationSnapBound", "getRotationSnapBound", "setRotationSnapBound", "close", "", "setPaintingListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCanvasRotation", "pivotX", "pivotY", "onCanvasRotated", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPaintingGestureController extends SpenGestureController implements SpenIPaintingGestureController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LOG_TAG = "PaintingGesture";

    @Nullable
    private SpenIPaintingGestureController.PaintingListener mListener;
    private long mNativeGestureController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0083 J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J)\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0083 J\u0011\u0010\u0015\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0083 J\u0011\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 J\u0011\u0010\u001b\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 J\u0011\u0010\u001d\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenPaintingGestureController$Companion;", "", "<init>", "()V", "LOG_TAG", "", "Native_init", "", "nativeGestureController", "", "controller", "Lcom/samsung/android/sdk/pen/painting/SpenPaintingGestureController;", "Native_setCanvasRotationEnabled", "enabled", "", "Native_isCanvasRotationEnabled", "Native_setCanvasRotation", "angle", "", "pivotX", "pivotY", "Native_getCanvasRotationAngle", "Native_getCanvasRotationPivot", "Landroid/graphics/PointF;", "Native_setRotationSnapEnabled", "Native_isRotationSnapEnabled", "Native_setRotationSnapAngle", "Native_getRotationSnapAngle", "Native_setRotationSnapBound", "Native_getRotationSnapBound", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getCanvasRotationAngle(long nativeGestureController) {
            return SpenPaintingGestureController.Native_getCanvasRotationAngle(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PointF Native_getCanvasRotationPivot(long nativeGestureController) {
            return SpenPaintingGestureController.Native_getCanvasRotationPivot(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getRotationSnapAngle(long nativeGestureController) {
            return SpenPaintingGestureController.Native_getRotationSnapAngle(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getRotationSnapBound(long nativeGestureController) {
            return SpenPaintingGestureController.Native_getRotationSnapBound(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeGestureController, SpenPaintingGestureController controller) {
            SpenPaintingGestureController.Native_init(nativeGestureController, controller);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isCanvasRotationEnabled(long nativeGestureController) {
            return SpenPaintingGestureController.Native_isCanvasRotationEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isRotationSnapEnabled(long nativeGestureController) {
            return SpenPaintingGestureController.Native_isRotationSnapEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setCanvasRotation(long nativeGestureController, float angle, float pivotX, float pivotY) {
            SpenPaintingGestureController.Native_setCanvasRotation(nativeGestureController, angle, pivotX, pivotY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setCanvasRotationEnabled(long nativeGestureController, boolean enabled) {
            SpenPaintingGestureController.Native_setCanvasRotationEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setRotationSnapAngle(long nativeGestureController, float angle) {
            SpenPaintingGestureController.Native_setRotationSnapAngle(nativeGestureController, angle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setRotationSnapBound(long nativeGestureController, float angle) {
            SpenPaintingGestureController.Native_setRotationSnapBound(nativeGestureController, angle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setRotationSnapEnabled(long nativeGestureController, boolean enabled) {
            SpenPaintingGestureController.Native_setRotationSnapEnabled(nativeGestureController, enabled);
        }

        private Companion() {
        }
    }

    public SpenPaintingGestureController(long j) {
        super(j);
        if (j == 0) {
            throw new NullPointerException("nativePaintingGestureController is null");
        }
        Log.d(LOG_TAG, "[JavaGesture] SpenPaintingGestureController construct");
        this.mNativeGestureController = j;
        INSTANCE.Native_init(j, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getCanvasRotationAngle(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native PointF Native_getCanvasRotationPivot(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getRotationSnapAngle(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getRotationSnapBound(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenPaintingGestureController spenPaintingGestureController);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isCanvasRotationEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isRotationSnapEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setCanvasRotation(long j, float f, float f4, float f5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setCanvasRotationEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setRotationSnapAngle(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setRotationSnapBound(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setRotationSnapEnabled(long j, boolean z);

    @Override // com.samsung.android.sdk.pen.engine.SpenGestureController
    public void close() {
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public float getCanvasRotationAngle() {
        return INSTANCE.Native_getCanvasRotationAngle(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    @NotNull
    public PointF getCanvasRotationPivot() {
        return INSTANCE.Native_getCanvasRotationPivot(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public float getRotationSnapAngle() {
        return INSTANCE.Native_getRotationSnapAngle(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public float getRotationSnapBound() {
        return INSTANCE.Native_getRotationSnapBound(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public boolean isCanvasRotationEnabled() {
        return INSTANCE.Native_isCanvasRotationEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public boolean isRotationSnapEnabled() {
        return INSTANCE.Native_isRotationSnapEnabled(this.mNativeGestureController);
    }

    public final void onCanvasRotated(float angle) {
        SpenIPaintingGestureController.PaintingListener paintingListener = this.mListener;
        if (paintingListener != null) {
            paintingListener.onCanvasRotated(angle);
        }
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public void setCanvasRotation(float angle, float pivotX, float pivotY) {
        INSTANCE.Native_setCanvasRotation(this.mNativeGestureController, angle, pivotX, pivotY);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public void setCanvasRotationEnabled(boolean z) {
        INSTANCE.Native_setCanvasRotationEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public void setPaintingListener(@Nullable SpenIPaintingGestureController.PaintingListener listener) {
        this.mListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public void setRotationSnapAngle(float f) {
        INSTANCE.Native_setRotationSnapAngle(this.mNativeGestureController, f);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public void setRotationSnapBound(float f) {
        INSTANCE.Native_setRotationSnapBound(this.mNativeGestureController, f);
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenIPaintingGestureController
    public void setRotationSnapEnabled(boolean z) {
        INSTANCE.Native_setRotationSnapEnabled(this.mNativeGestureController, z);
    }
}
