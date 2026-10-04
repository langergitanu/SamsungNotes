package com.samsung.android.sdk.pen.engine;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u00018J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H&J \u0010/\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u000204H&J\u0012\u00105\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u000107H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0018\u0010\r\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0004\"\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006R\u0018\u0010\u0017\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0006R\u0018\u0010\u0019\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0006R\u0018\u0010\u001b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0006R\u0018\u0010\u001d\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u0006R\u0012\u0010\u001f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004R\u0018\u0010 \u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u0006R\u0018\u0010\"\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010\u0006R\u0012\u0010$\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0004R\u0018\u0010%\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010\u0006R\u0012\u0010'\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0004R\u0012\u0010(\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0004R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010\u0006¨\u00069"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "", "isGestureLocked", "", "()Z", "setGestureLocked", "(Z)V", "isOnFingerScrollAndScaleLocked", "isOneFingerScrollAndScaleLocked", "setOneFingerScrollAndScaleLocked", "isFGCEnabled", "setFGCEnabled", "isFGCSupported", "isDoubleTapEnabled", "setDoubleTapEnabled", "isLongPressEnabled", "setLongPressEnabled", "isHoldLongPressEnabled", "setHoldLongPressEnabled", "isHoldMotionEnabled", "setHoldMotionEnabled", "isScrollEnabled", "setScrollEnabled", "isFlingEnabled", "setFlingEnabled", "isScaleEnabled", "setScaleEnabled", "isMultipleTapEnabled", "setMultipleTapEnabled", "isDoubleTapZoomEnabled", "setDoubleTapZoomEnabled", "isDoubleTapZoomRunning", "isMagneticZoomEnabled", "setMagneticZoomEnabled", "isHoverScrollEnabled", "setHoverScrollEnabled", "isHoverScrollRunning", "isFlingScrollEnabled", "setFlingScrollEnabled", "isFlingScrollRunning", "isGestureTriggered", "isPalmRejectionEnabled", "setPalmRejectionEnabled", "setPalmRejectionThreshold", "", "threshold", "", "setHoverScrollOption", "responseTime", "", "velocity", "margin", "", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController$Listener;", "Listener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenIGestureController {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenIGestureController$Listener;", "", "onOneFingerScrollAndScaleLockedChanged", "", "locked", "", "onZoomBlockedByOneFingerScrollAndScaleLock", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface Listener {
        void onOneFingerScrollAndScaleLockedChanged(boolean locked);

        void onZoomBlockedByOneFingerScrollAndScaleLock();
    }

    boolean isDoubleTapEnabled();

    boolean isDoubleTapZoomEnabled();

    boolean isDoubleTapZoomRunning();

    boolean isFGCEnabled();

    boolean isFGCSupported();

    boolean isFlingEnabled();

    boolean isFlingScrollEnabled();

    boolean isFlingScrollRunning();

    boolean isGestureLocked();

    boolean isGestureTriggered();

    boolean isHoldLongPressEnabled();

    boolean isHoldMotionEnabled();

    boolean isHoverScrollEnabled();

    boolean isHoverScrollRunning();

    boolean isLongPressEnabled();

    boolean isMagneticZoomEnabled();

    boolean isMultipleTapEnabled();

    boolean isOnFingerScrollAndScaleLocked();

    boolean isOneFingerScrollAndScaleLocked();

    boolean isPalmRejectionEnabled();

    boolean isScaleEnabled();

    boolean isScrollEnabled();

    void setDoubleTapEnabled(boolean z);

    void setDoubleTapZoomEnabled(boolean z);

    void setFGCEnabled(boolean z);

    void setFlingEnabled(boolean z);

    void setFlingScrollEnabled(boolean z);

    void setGestureLocked(boolean z);

    void setHoldLongPressEnabled(boolean z);

    void setHoldMotionEnabled(boolean z);

    void setHoverScrollEnabled(boolean z);

    void setHoverScrollOption(long responseTime, float velocity, int margin);

    void setListener(@Nullable Listener listener);

    void setLongPressEnabled(boolean z);

    void setMagneticZoomEnabled(boolean z);

    void setMultipleTapEnabled(boolean z);

    void setOneFingerScrollAndScaleLocked(boolean z);

    void setPalmRejectionEnabled(boolean z);

    void setPalmRejectionThreshold(float threshold);

    void setScaleEnabled(boolean z);

    void setScrollEnabled(boolean z);
}
