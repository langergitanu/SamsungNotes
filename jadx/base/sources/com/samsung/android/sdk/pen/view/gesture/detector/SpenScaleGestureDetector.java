package com.samsung.android.sdk.pen.view.gesture.detector;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenScaleGestureDetector;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenScaleGestureDetector$Listener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenScaleGestureDetector$Listener;)V", "mScaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "mListener", "close", "", "onGesture", "", "event", "Landroid/view/MotionEvent;", "onScale", "detector", "onScaleBegin", "onScaleEnd", "Listener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenScaleGestureDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenScaleGestureDetector.kt\ncom/samsung/android/sdk/pen/view/gesture/detector/SpenScaleGestureDetector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class SpenScaleGestureDetector implements ScaleGestureDetector.OnScaleGestureListener {

    @Nullable
    private Listener mListener;

    @Nullable
    private ScaleGestureDetector mScaleGestureDetector;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenScaleGestureDetector$Listener;", "", "onScale", "", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "", "focusX", "focusY", "onScaleBegin", "onScaleEnd", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface Listener {
        boolean onScale(float scaleFactor, float focusX, float focusY);

        boolean onScaleBegin(float focusX, float focusY);

        void onScaleEnd(float focusX, float focusY);
    }

    public SpenScaleGestureDetector(@Nullable Context context, @Nullable Listener listener) {
        this.mListener = listener;
        this.mScaleGestureDetector = context != null ? new ScaleGestureDetector(context, this) : null;
    }

    public final void close() {
        this.mScaleGestureDetector = null;
        this.mListener = null;
    }

    public final boolean onGesture(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ScaleGestureDetector scaleGestureDetector = this.mScaleGestureDetector;
        if (scaleGestureDetector != null) {
            return scaleGestureDetector.onTouchEvent(event);
        }
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(@NotNull ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        Listener listener = this.mListener;
        if (listener != null) {
            return listener.onScale(detector.getScaleFactor(), detector.getFocusX(), detector.getFocusY());
        }
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(@NotNull ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        Listener listener = this.mListener;
        if (listener != null) {
            return listener.onScaleBegin(detector.getFocusX(), detector.getFocusY());
        }
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(@NotNull ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onScaleEnd(detector.getFocusX(), detector.getFocusY());
        }
    }
}
