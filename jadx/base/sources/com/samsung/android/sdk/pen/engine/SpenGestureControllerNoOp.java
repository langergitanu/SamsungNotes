package com.samsung.android.sdk.pen.engine;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.engine.SpenIGestureController;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u0002002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002022\u0006\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;H\u0016R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR$\u0010\u001b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR$\u0010\u001d\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR$\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR$\u0010!\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u0014\u0010#\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R$\u0010$\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR$\u0010&\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u0014\u0010(\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0007R$\u0010)\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u0014\u0010+\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0007R\u0014\u0010,\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0007R$\u0010-\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\t¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenGestureControllerNoOp;", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "<init>", "()V", "_locked", "", "isGestureLocked", "()Z", "setGestureLocked", "(Z)V", "isOnFingerScrollAndScaleLocked", "isOneFingerScrollAndScaleLocked", "setOneFingerScrollAndScaleLocked", "_enabled", "isFGCEnabled", "setFGCEnabled", "isFGCSupported", "isDoubleTapEnabled", "setDoubleTapEnabled", "isLongPressEnabled", "setLongPressEnabled", "isHoldLongPressEnabled", "setHoldLongPressEnabled", "isHoldMotionEnabled", "setHoldMotionEnabled", "isScrollEnabled", "setScrollEnabled", "isFlingEnabled", "setFlingEnabled", "isScaleEnabled", "setScaleEnabled", "isMultipleTapEnabled", "setMultipleTapEnabled", "isDoubleTapZoomEnabled", "setDoubleTapZoomEnabled", "isDoubleTapZoomRunning", "isMagneticZoomEnabled", "setMagneticZoomEnabled", "isHoverScrollEnabled", "setHoverScrollEnabled", "isHoverScrollRunning", "isFlingScrollEnabled", "setFlingScrollEnabled", "isFlingScrollRunning", "isGestureTriggered", "isPalmRejectionEnabled", "setPalmRejectionEnabled", "setPalmRejectionThreshold", "", "threshold", "", "setHoverScrollOption", "responseTime", "", "velocity", "margin", "", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController$Listener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenGestureControllerNoOp implements SpenIGestureController {
    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isDoubleTapEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isDoubleTapZoomEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isDoubleTapZoomRunning() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFGCEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFGCSupported() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFlingEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFlingScrollEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFlingScrollRunning() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isGestureLocked() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isGestureTriggered() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isHoldLongPressEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isHoldMotionEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isHoverScrollEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isHoverScrollRunning() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isLongPressEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isMagneticZoomEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isMultipleTapEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isOnFingerScrollAndScaleLocked() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isOneFingerScrollAndScaleLocked() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isPalmRejectionEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isScaleEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isScrollEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setDoubleTapEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setDoubleTapZoomEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setFGCEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setFlingEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setFlingScrollEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setGestureLocked(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setHoldLongPressEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setHoldMotionEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setHoverScrollEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setHoverScrollOption(long responseTime, float velocity, int margin) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setListener(@Nullable SpenIGestureController.Listener listener) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setLongPressEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setMagneticZoomEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setMultipleTapEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setOneFingerScrollAndScaleLocked(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setPalmRejectionEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setPalmRejectionThreshold(float threshold) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setScaleEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setScrollEnabled(boolean z) {
    }
}
