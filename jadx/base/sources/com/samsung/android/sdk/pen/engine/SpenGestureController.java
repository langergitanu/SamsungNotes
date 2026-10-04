package com.samsung.android.sdk.pen.engine;

import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.engine.SpenIGestureController;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u00106\u001a\u00020\n2\u0006\u00107\u001a\u000208H\u0016J \u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020=H\u0016J\u0012\u0010>\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010@\u001a\u00020\nH\u0002J\u0010\u0010A\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R$\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R$\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R$\u0010 \u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R$\u0010\"\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R$\u0010$\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R$\u0010&\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R$\u0010(\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R\u0014\u0010*\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000eR$\u0010+\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R$\u0010-\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\u0014\u0010/\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u000eR$\u00100\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u0014\u00102\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u000eR\u0014\u00103\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u000eR$\u00104\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenGestureController;", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController;", "nativeGestureController", "", "<init>", "(J)V", "mNativeGestureController", "mListener", "Lcom/samsung/android/sdk/pen/engine/SpenIGestureController$Listener;", "close", "", "locked", "", "isGestureLocked", "()Z", "setGestureLocked", "(Z)V", "isOnFingerScrollAndScaleLocked", "isOneFingerScrollAndScaleLocked", "setOneFingerScrollAndScaleLocked", "enabled", "isFGCEnabled", "setFGCEnabled", "isFGCSupported", "isDoubleTapEnabled", "setDoubleTapEnabled", "isLongPressEnabled", "setLongPressEnabled", "isHoldLongPressEnabled", "setHoldLongPressEnabled", "isHoldMotionEnabled", "setHoldMotionEnabled", "isScrollEnabled", "setScrollEnabled", "isFlingEnabled", "setFlingEnabled", "isScaleEnabled", "setScaleEnabled", "isMultipleTapEnabled", "setMultipleTapEnabled", "isDoubleTapZoomEnabled", "setDoubleTapZoomEnabled", "isDoubleTapZoomRunning", "isMagneticZoomEnabled", "setMagneticZoomEnabled", "isHoverScrollEnabled", "setHoverScrollEnabled", "isHoverScrollRunning", "isFlingScrollEnabled", "setFlingScrollEnabled", "isFlingScrollRunning", "isGestureTriggered", "isPalmRejectionEnabled", "setPalmRejectionEnabled", "setPalmRejectionThreshold", "threshold", "", "setHoverScrollOption", "responseTime", "velocity", "margin", "", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onZoomBlockedByOneFingerScrollAndScaleLock", "onOneFingerScrollAndScaleLockedChanged", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenGestureController implements SpenIGestureController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LOG_TAG = "SPenGestureController";

    @Nullable
    private SpenIGestureController.Listener mListener;
    private long mNativeGestureController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0083 J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0083 J\u0011\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010!\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010#\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010%\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010'\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0083 J\u0019\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010,\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010-\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u0010/\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u00100\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J)\u00101\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u000205H\u0083 J\u0011\u00106\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u00107\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u00108\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0083 J\u0011\u00109\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010:\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010;\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenGestureController$Companion;", "", "<init>", "()V", "LOG_TAG", "", "Native_init", "", "nativeGestureController", "", "controller", "Lcom/samsung/android/sdk/pen/engine/SpenGestureController;", "Native_setGestureLocked", "locked", "", "Native_isGestureLocked", "Native_setOneFingerScrollAndScaleLocked", "Native_isOneFingerScrollAndScaleLocked", "Native_setFGCEnabled", "enabled", "Native_isFGCEnabled", "Native_isFGCSupported", "Native_setDoubleTapEnabled", "Native_isDoubleTapEnabled", "Native_setLongPressEnabled", "Native_isLongPressEnabled", "Native_setHoldLongPressEnabled", "Native_isHoldLongPressEnabled", "Native_setHoldMotionEnabled", "Native_isHoldMotionEnabled", "Native_setScrollEnabled", "Native_isScrollEnabled", "Native_setFlingEnabled", "Native_isFlingEnabled", "Native_setScaleEnabled", "Native_isScaleEnabled", "Native_setMultipleTapEnabled", "Native_isMultipleTapEnabled", "Native_setPalmRejectionEnabled", "Native_isPalmRejectionEnabled", "Native_setPalmRejectionThreshold", "threshold", "", "Native_setDoubleTapZoomEnabled", "Native_isDoubleTapZoomEnabled", "Native_isDoubleTapZoomRunning", "Native_setMagneticZoomEnabled", "Native_isMagneticZoomEnabled", "Native_setHoverScrollEnabled", "Native_setHoverScrollOption", "responseTime", "velocity", "margin", "", "Native_isHoverScrollEnabled", "Native_isHoverScrollRunning", "Native_setFlingScrollEnabled", "Native_isFlingScrollEnabled", "Native_isFlingScrollRunning", "Native_isGestureAlreadyTriggered", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeGestureController, SpenGestureController controller) {
            SpenGestureController.Native_init(nativeGestureController, controller);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isDoubleTapEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isDoubleTapEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isDoubleTapZoomEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isDoubleTapZoomEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isDoubleTapZoomRunning(long nativeGestureController) {
            return SpenGestureController.Native_isDoubleTapZoomRunning(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isFGCEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isFGCEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isFGCSupported(long nativeGestureController) {
            return SpenGestureController.Native_isFGCSupported(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isFlingEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isFlingEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isFlingScrollEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isFlingScrollEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isFlingScrollRunning(long nativeGestureController) {
            return SpenGestureController.Native_isFlingScrollRunning(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isGestureAlreadyTriggered(long nativeGestureController) {
            return SpenGestureController.Native_isGestureAlreadyTriggered(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isGestureLocked(long nativeGestureController) {
            return SpenGestureController.Native_isGestureLocked(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isHoldLongPressEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isHoldLongPressEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isHoldMotionEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isHoldMotionEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isHoverScrollEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isHoverScrollEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isHoverScrollRunning(long nativeGestureController) {
            return SpenGestureController.Native_isHoverScrollRunning(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isLongPressEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isLongPressEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isMagneticZoomEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isMagneticZoomEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isMultipleTapEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isMultipleTapEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isOneFingerScrollAndScaleLocked(long nativeGestureController) {
            return SpenGestureController.Native_isOneFingerScrollAndScaleLocked(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isPalmRejectionEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isPalmRejectionEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isScaleEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isScaleEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isScrollEnabled(long nativeGestureController) {
            return SpenGestureController.Native_isScrollEnabled(nativeGestureController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDoubleTapEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setDoubleTapEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDoubleTapZoomEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setDoubleTapZoomEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFGCEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setFGCEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFlingEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setFlingEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setFlingScrollEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setFlingScrollEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setGestureLocked(long nativeGestureController, boolean locked) {
            SpenGestureController.Native_setGestureLocked(nativeGestureController, locked);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setHoldLongPressEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setHoldLongPressEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setHoldMotionEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setHoldMotionEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setHoverScrollEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setHoverScrollEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setHoverScrollOption(long nativeGestureController, long responseTime, float velocity, int margin) {
            SpenGestureController.Native_setHoverScrollOption(nativeGestureController, responseTime, velocity, margin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setLongPressEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setLongPressEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setMagneticZoomEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setMagneticZoomEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setMultipleTapEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setMultipleTapEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOneFingerScrollAndScaleLocked(long nativeGestureController, boolean locked) {
            SpenGestureController.Native_setOneFingerScrollAndScaleLocked(nativeGestureController, locked);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPalmRejectionEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setPalmRejectionEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPalmRejectionThreshold(long nativeGestureController, float threshold) {
            SpenGestureController.Native_setPalmRejectionThreshold(nativeGestureController, threshold);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScaleEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setScaleEnabled(nativeGestureController, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScrollEnabled(long nativeGestureController, boolean enabled) {
            SpenGestureController.Native_setScrollEnabled(nativeGestureController, enabled);
        }

        private Companion() {
        }
    }

    public SpenGestureController(long j) {
        if (j == 0) {
            throw new NullPointerException("nativeGestureController is null");
        }
        Log.d(LOG_TAG, "[JavaGesture] SpenGestureController construct");
        this.mNativeGestureController = j;
        INSTANCE.Native_init(j, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenGestureController spenGestureController);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isDoubleTapEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isDoubleTapZoomEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isDoubleTapZoomRunning(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isFGCEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isFGCSupported(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isFlingEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isFlingScrollEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isFlingScrollRunning(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isGestureAlreadyTriggered(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isGestureLocked(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isHoldLongPressEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isHoldMotionEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isHoverScrollEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isHoverScrollRunning(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isLongPressEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isMagneticZoomEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isMultipleTapEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isOneFingerScrollAndScaleLocked(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isPalmRejectionEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isScaleEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isScrollEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDoubleTapEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDoubleTapZoomEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFGCEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFlingEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setFlingScrollEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setGestureLocked(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHoldLongPressEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHoldMotionEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHoverScrollEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHoverScrollOption(long j, long j2, float f, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setLongPressEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setMagneticZoomEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setMultipleTapEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setOneFingerScrollAndScaleLocked(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPalmRejectionEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPalmRejectionThreshold(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setScaleEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setScrollEnabled(long j, boolean z);

    private final void onOneFingerScrollAndScaleLockedChanged(boolean locked) {
        SpenIGestureController.Listener listener = this.mListener;
        if (listener != null) {
            listener.onOneFingerScrollAndScaleLockedChanged(locked);
        }
    }

    private final void onZoomBlockedByOneFingerScrollAndScaleLock() {
        SpenIGestureController.Listener listener = this.mListener;
        if (listener != null) {
            listener.onZoomBlockedByOneFingerScrollAndScaleLock();
        }
    }

    public void close() {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isDoubleTapEnabled() {
        return INSTANCE.Native_isDoubleTapEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isDoubleTapZoomEnabled() {
        return INSTANCE.Native_isDoubleTapZoomEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isDoubleTapZoomRunning() {
        return INSTANCE.Native_isDoubleTapZoomRunning(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFGCEnabled() {
        return INSTANCE.Native_isFGCEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFGCSupported() {
        return INSTANCE.Native_isFGCSupported(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFlingEnabled() {
        return INSTANCE.Native_isFlingEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFlingScrollEnabled() {
        return INSTANCE.Native_isFlingScrollEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isFlingScrollRunning() {
        return INSTANCE.Native_isFlingScrollRunning(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isGestureLocked() {
        return INSTANCE.Native_isGestureLocked(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isGestureTriggered() {
        return INSTANCE.Native_isGestureAlreadyTriggered(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isHoldLongPressEnabled() {
        return INSTANCE.Native_isHoldLongPressEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isHoldMotionEnabled() {
        return INSTANCE.Native_isHoldMotionEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isHoverScrollEnabled() {
        return INSTANCE.Native_isHoverScrollEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isHoverScrollRunning() {
        return INSTANCE.Native_isHoverScrollRunning(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isLongPressEnabled() {
        return INSTANCE.Native_isLongPressEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isMagneticZoomEnabled() {
        return INSTANCE.Native_isMagneticZoomEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isMultipleTapEnabled() {
        return INSTANCE.Native_isMultipleTapEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isOnFingerScrollAndScaleLocked() {
        return INSTANCE.Native_isOneFingerScrollAndScaleLocked(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isOneFingerScrollAndScaleLocked() {
        return INSTANCE.Native_isOneFingerScrollAndScaleLocked(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isPalmRejectionEnabled() {
        return INSTANCE.Native_isPalmRejectionEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isScaleEnabled() {
        return INSTANCE.Native_isScaleEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public boolean isScrollEnabled() {
        return INSTANCE.Native_isScrollEnabled(this.mNativeGestureController);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setDoubleTapEnabled(boolean z) {
        INSTANCE.Native_setDoubleTapEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setDoubleTapZoomEnabled(boolean z) {
        INSTANCE.Native_setDoubleTapZoomEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setFGCEnabled(boolean z) {
        INSTANCE.Native_setFGCEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setFlingEnabled(boolean z) {
        INSTANCE.Native_setFlingEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setFlingScrollEnabled(boolean z) {
        INSTANCE.Native_setFlingScrollEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setGestureLocked(boolean z) {
        INSTANCE.Native_setGestureLocked(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setHoldLongPressEnabled(boolean z) {
        INSTANCE.Native_setHoldLongPressEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setHoldMotionEnabled(boolean z) {
        INSTANCE.Native_setHoldMotionEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setHoverScrollEnabled(boolean z) {
        INSTANCE.Native_setHoverScrollEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setHoverScrollOption(long responseTime, float velocity, int margin) {
        INSTANCE.Native_setHoverScrollOption(this.mNativeGestureController, responseTime, velocity, margin);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setListener(@Nullable SpenIGestureController.Listener listener) {
        this.mListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setLongPressEnabled(boolean z) {
        INSTANCE.Native_setLongPressEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setMagneticZoomEnabled(boolean z) {
        INSTANCE.Native_setMagneticZoomEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setMultipleTapEnabled(boolean z) {
        INSTANCE.Native_setMultipleTapEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setOneFingerScrollAndScaleLocked(boolean z) {
        INSTANCE.Native_setOneFingerScrollAndScaleLocked(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setPalmRejectionEnabled(boolean z) {
        INSTANCE.Native_setPalmRejectionEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setPalmRejectionThreshold(float threshold) {
        INSTANCE.Native_setPalmRejectionThreshold(this.mNativeGestureController, threshold);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setScaleEnabled(boolean z) {
        INSTANCE.Native_setScaleEnabled(this.mNativeGestureController, z);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenIGestureController
    public void setScrollEnabled(boolean z) {
        INSTANCE.Native_setScrollEnabled(this.mNativeGestureController, z);
    }
}
