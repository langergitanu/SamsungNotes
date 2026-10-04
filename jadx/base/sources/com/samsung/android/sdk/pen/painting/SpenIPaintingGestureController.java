package com.samsung.android.sdk.pen.painting;

import android.graphics.PointF;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.engine.SpenIGestureController;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001 J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J \u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u0014¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController;", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "isCanvasRotationEnabled", "", "()Z", "setCanvasRotationEnabled", "(Z)V", "canvasRotationAngle", "", "getCanvasRotationAngle", "()F", "canvasRotationPivot", "Landroid/graphics/PointF;", "getCanvasRotationPivot", "()Landroid/graphics/PointF;", "isRotationSnapEnabled", "setRotationSnapEnabled", "rotationSnapAngle", "getRotationSnapAngle", "setRotationSnapAngle", "(F)V", "rotationSnapBound", "getRotationSnapBound", "setRotationSnapBound", "setPaintingListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController$PaintingListener;", "setCanvasRotation", "angle", "pivotX", "pivotY", "PaintingListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenIPaintingGestureController extends SpenIGestureController {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/painting/SpenIPaintingGestureController$PaintingListener;", "", "onCanvasRotated", "", "angle", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PaintingListener {
        void onCanvasRotated(float angle);
    }

    float getCanvasRotationAngle();

    @Nullable
    PointF getCanvasRotationPivot();

    float getRotationSnapAngle();

    float getRotationSnapBound();

    boolean isCanvasRotationEnabled();

    boolean isRotationSnapEnabled();

    void setCanvasRotation(float angle, float pivotX, float pivotY);

    void setCanvasRotationEnabled(boolean z);

    void setPaintingListener(@Nullable PaintingListener listener);

    void setRotationSnapAngle(float f);

    void setRotationSnapBound(float f);

    void setRotationSnapEnabled(boolean z);
}
