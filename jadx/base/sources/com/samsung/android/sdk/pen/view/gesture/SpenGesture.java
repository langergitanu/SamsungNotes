package com.samsung.android.sdk.pen.view.gesture;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.pen.gesturemodel.fgc.SpenFGClassifier;
import com.samsung.android.sdk.pen.view.SpenMotionEvent;
import com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0002Z[B\u001b\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u001c2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00109\u001a\u00020\u001c2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010:\u001a\u0002032\u0006\u00106\u001a\u000207H\u0016J\u0012\u0010;\u001a\u00020\u001c2\b\u00106\u001a\u0004\u0018\u000107H\u0016J,\u0010<\u001a\u00020\u001c2\b\u0010=\u001a\u0004\u0018\u0001072\b\u0010>\u001a\u0004\u0018\u0001072\u0006\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u0018H\u0016J,\u0010A\u001a\u00020\u001c2\b\u0010=\u001a\u0004\u0018\u0001072\b\u0010>\u001a\u0004\u0018\u0001072\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u0018H\u0016J \u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u0018H\u0016J\b\u0010H\u001a\u00020\u001cH\u0016J\b\u0010I\u001a\u000203H\u0016J\b\u0010J\u001a\u000203H\u0016J\u001a\u0010K\u001a\u0002032\b\u0010L\u001a\u0004\u0018\u0001072\u0006\u0010M\u001a\u00020\u0006H\u0016J\b\u0010N\u001a\u000203H\u0016J\b\u0010O\u001a\u000203H\u0016J\u0012\u0010P\u001a\u00020\u001c2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010Q\u001a\u000203H\u0016J\u0010\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020\rH\u0002J\b\u0010T\u001a\u000203H\u0002J\u0018\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u001cH\u0016J\u000e\u0010X\u001a\u0002032\u0006\u0010Y\u001a\u00020\u0018R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR$\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001d\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010!R$\u0010$\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010!R$\u0010&\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010!R$\u0010(\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010!R$\u0010*\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010!R$\u0010,\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010!R$\u0010.\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010!R$\u00100\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010!¨\u0006\\"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/SpenGesture;", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenGestureDetector$Listener;", "Lcom/samsung/android/sdk/pen/view/gesture/SpenIGesture;", "context", "Landroid/content/Context;", "tag", "", "<init>", "(Landroid/content/Context;I)V", "mContext", "mGestureDetector", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenGestureDetector;", "mNativeGestureRefiner", "", "mPrevAction", "Ljava/lang/Integer;", "mFGClassifier", "Lcom/samsung/android/sdk/pen/gesturemodel/fgc/SpenFGClassifier;", "mWindowManager", "Landroid/view/WindowManager;", "nativeFGClassifier", "getNativeFGClassifier", "()J", "displayRefreshRate", "", "getDisplayRefreshRate", "()F", "isAirViewActionEnabled", "", "()Z", "enabled", "isDoubleTapEnabled", "setDoubleTapEnabled", "(Z)V", "isLongPressEnabled", "setLongPressEnabled", "isHoldLongPressEnabled", "setHoldLongPressEnabled", "isHoldMotionEnabled", "setHoldMotionEnabled", "isScrollEnabled", "setScrollEnabled", "isFlingEnabled", "setFlingEnabled", "isScaleEnabled", "setScaleEnabled", "isMultipleTapEnabled", "setMultipleTapEnabled", "isPalmRejectionEnabled", "setPalmRejectionEnabled", "init", "", "destruct", "onSingleTapUp", "e", "Landroid/view/MotionEvent;", "onSingleTapConfirmed", "onDoubleTap", "onLongPress", "onHoldLongPress", "onScroll", "e1", "e2", "distanceX", "distanceY", "onFling", "velocityX", "velocityY", "onScale", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "focusX", "focusY", "onScaleBegin", "onScaleEnd", "onScaleConfirmed", "onMultipleTap", "event", "tapCount", "onPalmTouchBegin", "onPalmTouchEnd", "onHoldEvent", "onHoldCanceled", "setGestureRefiner", "nativeGestureRefiner", "close", "onGesture", "isGesture", "isStroke", "setPalmRejectionThreshold", "threshold", "System", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenGesture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenGesture.kt\ncom/samsung/android/sdk/pen/view/gesture/SpenGesture\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,371:1\n1#2:372\n*E\n"})
public final class SpenGesture implements SpenGestureDetector.Listener, SpenIGesture {

    @NotNull
    private static final String LOG_TAG = "SpenGesture";
    private static int mCreationCount;
    private static boolean mIsStrictDetection;

    @Nullable
    private static MotionEvent mMotionEvent;

    @Nullable
    private Context mContext;

    @NotNull
    private final SpenFGClassifier mFGClassifier;

    @Nullable
    private SpenGestureDetector mGestureDetector;
    private long mNativeGestureRefiner;

    @Nullable
    private Integer mPrevAction = 1;

    @NotNull
    private final WindowManager mWindowManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean mIsGestureEnabled = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0007J\u001b\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0083 J\u001b\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0083 J\u001b\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0083 J\u001b\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0083 J\u001b\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0083 J5\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0083 J5\u0010!\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0083 J)\u0010$\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH\u0083 J\u0011\u0010(\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0083 J\u0011\u0010)\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0083 J\u0011\u0010*\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0083 J\u001b\u0010+\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0083 J\u0011\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0083 J#\u0010-\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00162\u0006\u0010.\u001a\u00020\u000bH\u0083 J\u001b\u0010/\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0083 J\u001b\u00100\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/SpenGesture$Companion;", "", "<init>", "()V", "LOG_TAG", "", "mMotionEvent", "Landroid/view/MotionEvent;", "mIsStrictDetection", "", "mCreationCount", "", "mIsGestureEnabled", "onTouchEvent", "", "event", "isStrictDetection", "setGestureEnabled", "enable", "Native_onSingleTapUp", "nativeGestureRefiner", "", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "Native_onSingleTapConfirmed", "Native_onDoubleTap", "Native_onLongPress", "Native_onHoldLongPress", "Native_onScroll", "e1", "e2", "distanceX", "", "distanceY", "Native_onFling", "velocityX", "velocityY", "Native_onScale", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "focusX", "focusY", "Native_onScaleBegin", "Native_onScaleConfirmed", "Native_onScaleEnd", "Native_onHoldEvent", "Native_onHoldCanceled", "Native_onMultipleTap", "count", "Native_onPalmTouchBegin", "Native_onPalmTouchEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onDoubleTap(long nativeGestureRefiner, SpenMotionEvent event) {
            return SpenGesture.Native_onDoubleTap(nativeGestureRefiner, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onFling(long nativeGestureRefiner, SpenMotionEvent e12, SpenMotionEvent e2, float velocityX, float velocityY) {
            return SpenGesture.Native_onFling(nativeGestureRefiner, e12, e2, velocityX, velocityY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onHoldCanceled(long nativeGestureRefiner) {
            SpenGesture.Native_onHoldCanceled(nativeGestureRefiner);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onHoldEvent(long nativeGestureRefiner, SpenMotionEvent event) {
            return SpenGesture.Native_onHoldEvent(nativeGestureRefiner, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onHoldLongPress(long nativeGestureRefiner, SpenMotionEvent event) {
            return SpenGesture.Native_onHoldLongPress(nativeGestureRefiner, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onLongPress(long nativeGestureRefiner, SpenMotionEvent event) {
            SpenGesture.Native_onLongPress(nativeGestureRefiner, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onMultipleTap(long nativeGestureRefiner, SpenMotionEvent event, int count) {
            SpenGesture.Native_onMultipleTap(nativeGestureRefiner, event, count);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPalmTouchBegin(long nativeGestureRefiner, SpenMotionEvent event) {
            SpenGesture.Native_onPalmTouchBegin(nativeGestureRefiner, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPalmTouchEnd(long nativeGestureRefiner, SpenMotionEvent event) {
            SpenGesture.Native_onPalmTouchEnd(nativeGestureRefiner, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onScale(long nativeGestureRefiner, float scaleFactor, float focusX, float focusY) {
            return SpenGesture.Native_onScale(nativeGestureRefiner, scaleFactor, focusX, focusY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onScaleBegin(long nativeGestureRefiner) {
            return SpenGesture.Native_onScaleBegin(nativeGestureRefiner);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onScaleConfirmed(long nativeGestureRefiner) {
            SpenGesture.Native_onScaleConfirmed(nativeGestureRefiner);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onScaleEnd(long nativeGestureRefiner) {
            SpenGesture.Native_onScaleEnd(nativeGestureRefiner);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onScroll(long nativeGestureRefiner, SpenMotionEvent e12, SpenMotionEvent e2, float distanceX, float distanceY) {
            return SpenGesture.Native_onScroll(nativeGestureRefiner, e12, e2, distanceX, distanceY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onSingleTapConfirmed(long nativeGestureRefiner, SpenMotionEvent event) {
            return SpenGesture.Native_onSingleTapConfirmed(nativeGestureRefiner, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onSingleTapUp(long nativeGestureRefiner, SpenMotionEvent event) {
            return SpenGesture.Native_onSingleTapUp(nativeGestureRefiner, event);
        }

        @JvmStatic
        public final void onTouchEvent(@Nullable MotionEvent event, boolean isStrictDetection) {
            SpenGesture.mMotionEvent = MotionEvent.obtain(event);
            SpenGesture.mIsStrictDetection = isStrictDetection;
        }

        @JvmStatic
        public final void setGestureEnabled(boolean enable) {
            SpenGesture.mIsGestureEnabled = enable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/SpenGesture$System;", "", "<init>", "()V", "AIR_VIEW", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class System {

        @NotNull
        public static final String AIR_VIEW = "pen_hovering";

        @NotNull
        public static final System INSTANCE = new System();

        private System() {
        }
    }

    public SpenGesture(@Nullable Context context, int i) {
        init();
        this.mContext = context;
        SpenGestureDetector spenGestureDetector = new SpenGestureDetector(context);
        this.mGestureDetector = spenGestureDetector;
        spenGestureDetector.setGestureDetectorListener(this);
        this.mFGClassifier = new SpenFGClassifier(context);
        Object systemService = context != null ? context.getSystemService("window") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.mWindowManager = (WindowManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onDoubleTap(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onFling(long j, SpenMotionEvent spenMotionEvent, SpenMotionEvent spenMotionEvent2, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onHoldCanceled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onHoldEvent(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onHoldLongPress(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onLongPress(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onMultipleTap(long j, SpenMotionEvent spenMotionEvent, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onPalmTouchBegin(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onPalmTouchEnd(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onScale(long j, float f, float f4, float f5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onScaleBegin(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onScaleConfirmed(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onScaleEnd(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onScroll(long j, SpenMotionEvent spenMotionEvent, SpenMotionEvent spenMotionEvent2, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onSingleTapConfirmed(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onSingleTapUp(long j, SpenMotionEvent spenMotionEvent);

    private final void close() {
        Log.d(LOG_TAG, "[JavaGesture] close");
        this.mContext = null;
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.close();
        }
        this.mGestureDetector = null;
        destruct();
    }

    private final void destruct() {
        int i = mCreationCount - 1;
        mCreationCount = i;
        if (i == 0) {
            Log.d(LOG_TAG, "[JavaGesture] destruct");
            mMotionEvent = null;
        }
    }

    private final float getDisplayRefreshRate() {
        Log.d(LOG_TAG, "[JavaGesture] getDisplayRefreshRate");
        return this.mWindowManager.getDefaultDisplay().getRefreshRate();
    }

    private final long getNativeFGClassifier() {
        return this.mFGClassifier.getNativeFGClassifier();
    }

    private final void init() {
        if (mCreationCount == 0) {
            Log.d(LOG_TAG, "[JavaGesture] init");
        }
        mCreationCount++;
    }

    @JvmStatic
    public static final void onTouchEvent(@Nullable MotionEvent motionEvent, boolean z) {
        INSTANCE.onTouchEvent(motionEvent, z);
    }

    @JvmStatic
    public static final void setGestureEnabled(boolean z) {
        INSTANCE.setGestureEnabled(z);
    }

    private final void setGestureRefiner(long nativeGestureRefiner) {
        Log.d(LOG_TAG, "[JavaGesture] nativeGestureRefiner=" + nativeGestureRefiner);
        this.mNativeGestureRefiner = nativeGestureRefiner;
    }

    public final boolean isAirViewActionEnabled() {
        Context context = this.mContext;
        return Settings.System.getInt(context != null ? context.getContentResolver() : null, "pen_hovering", 0) != 0;
    }

    public final boolean isDoubleTapEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.getIsDoubleTapEnabled();
        }
        return false;
    }

    public final boolean isFlingEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.getIsFlingEnabled();
        }
        return false;
    }

    public final boolean isHoldLongPressEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.getIsHoldLongPressEnabled();
        }
        return false;
    }

    public final boolean isHoldMotionEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.getIsHoldMotionEnabled();
        }
        return false;
    }

    public final boolean isLongPressEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.getIsLongPressEnabled();
        }
        return false;
    }

    public final boolean isMultipleTapEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.getIsMultipleTapEnabled();
        }
        return false;
    }

    public final boolean isPalmRejectionEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.isPalmRejectionEnabled();
        }
        return false;
    }

    public final boolean isScaleEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.getIsScaleEnabled();
        }
        return false;
    }

    public final boolean isScrollEnabled() {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            return spenGestureDetector.getIsScrollEnabled();
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onDoubleTap(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.mNativeGestureRefiner == 0) {
            return false;
        }
        return INSTANCE.Native_onDoubleTap(this.mNativeGestureRefiner, new SpenMotionEvent(e));
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onFling(@Nullable MotionEvent e12, @Nullable MotionEvent e2, float velocityX, float velocityY) {
        if (this.mNativeGestureRefiner == 0) {
            return false;
        }
        Log.d(LOG_TAG, "[JavaGesture] onFling velocityX=" + velocityX + ", velocityY=" + velocityY);
        return INSTANCE.Native_onFling(this.mNativeGestureRefiner, e12 != null ? new SpenMotionEvent(e12) : null, e2 != null ? new SpenMotionEvent(e2) : null, velocityX, velocityY);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.SpenIGesture
    public boolean onGesture(boolean isGesture, boolean isStroke) {
        if (!mIsGestureEnabled) {
            return false;
        }
        if (mMotionEvent == null) {
            Log.d(LOG_TAG, "[JavaGesture] MotionEvent is null!");
            return false;
        }
        Integer num = this.mPrevAction;
        if (num != null && num.intValue() == 1) {
            MotionEvent motionEvent = mMotionEvent;
            if (Intrinsics.areEqual(motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null, this.mPrevAction)) {
                Log.w(LOG_TAG, "Duplicated TOUCH_UP");
                return false;
            }
        }
        MotionEvent motionEvent2 = mMotionEvent;
        this.mPrevAction = motionEvent2 != null ? Integer.valueOf(motionEvent2.getAction()) : null;
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector == null) {
            return false;
        }
        MotionEvent motionEvent3 = mMotionEvent;
        Intrinsics.checkNotNull(motionEvent3);
        return spenGestureDetector.onTouchEvent(motionEvent3, isGesture, isStroke, mIsStrictDetection);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public void onHoldCanceled() {
        if (this.mNativeGestureRefiner == 0) {
            return;
        }
        Log.d(LOG_TAG, "[JavaGesture] onHoldCanceled");
        INSTANCE.Native_onHoldCanceled(this.mNativeGestureRefiner);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onHoldEvent(@Nullable MotionEvent e) {
        if (this.mNativeGestureRefiner == 0) {
            return false;
        }
        Log.d(LOG_TAG, "[JavaGesture] onHoldEvent x=" + (e != null ? Float.valueOf(e.getX()) : null) + ", y=" + (e != null ? Float.valueOf(e.getY()) : null));
        return INSTANCE.Native_onHoldEvent(this.mNativeGestureRefiner, e != null ? new SpenMotionEvent(e) : null);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onHoldLongPress(@Nullable MotionEvent e) {
        if (this.mNativeGestureRefiner == 0) {
            return false;
        }
        return INSTANCE.Native_onHoldLongPress(this.mNativeGestureRefiner, e != null ? new SpenMotionEvent(e) : null);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public void onLongPress(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.mNativeGestureRefiner == 0) {
            return;
        }
        INSTANCE.Native_onLongPress(this.mNativeGestureRefiner, new SpenMotionEvent(e));
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public void onMultipleTap(@Nullable MotionEvent event, int tapCount) {
        if (this.mNativeGestureRefiner == 0) {
            return;
        }
        SpenMotionEvent spenMotionEvent = event != null ? new SpenMotionEvent(event) : null;
        AbstractC0541b.m755A(tapCount, "[JavaGesture] onMultipleTap count=", LOG_TAG);
        INSTANCE.Native_onMultipleTap(this.mNativeGestureRefiner, spenMotionEvent, tapCount);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public void onPalmTouchBegin() {
        if (this.mNativeGestureRefiner == 0) {
            return;
        }
        MotionEvent motionEvent = mMotionEvent;
        INSTANCE.Native_onPalmTouchBegin(this.mNativeGestureRefiner, motionEvent != null ? new SpenMotionEvent(motionEvent) : null);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public void onPalmTouchEnd() {
        if (this.mNativeGestureRefiner == 0) {
            return;
        }
        MotionEvent motionEvent = mMotionEvent;
        INSTANCE.Native_onPalmTouchEnd(this.mNativeGestureRefiner, motionEvent != null ? new SpenMotionEvent(motionEvent) : null);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onScale(float scaleFactor, float focusX, float focusY) {
        long j = this.mNativeGestureRefiner;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_onScale(j, scaleFactor, focusX, focusY);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onScaleBegin() {
        if (this.mNativeGestureRefiner == 0) {
            return false;
        }
        Log.d(LOG_TAG, "[JavaGesture] onScaleBegin");
        return INSTANCE.Native_onScaleBegin(this.mNativeGestureRefiner);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public void onScaleConfirmed() {
        if (this.mNativeGestureRefiner == 0) {
            return;
        }
        Log.d(LOG_TAG, "[JavaGesture] onScaleConfirmed");
        INSTANCE.Native_onScaleConfirmed(this.mNativeGestureRefiner);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public void onScaleEnd() {
        if (this.mNativeGestureRefiner == 0) {
            return;
        }
        Log.d(LOG_TAG, "[JavaGesture] onScaleEnd");
        INSTANCE.Native_onScaleEnd(this.mNativeGestureRefiner);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onScroll(@Nullable MotionEvent e12, @Nullable MotionEvent e2, float distanceX, float distanceY) {
        if (this.mNativeGestureRefiner == 0 || e12 == null || e2 == null) {
            return false;
        }
        return INSTANCE.Native_onScroll(this.mNativeGestureRefiner, new SpenMotionEvent(e12), new SpenMotionEvent(e2), distanceX, distanceY);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onSingleTapConfirmed(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.mNativeGestureRefiner == 0) {
            return false;
        }
        return INSTANCE.Native_onSingleTapConfirmed(this.mNativeGestureRefiner, new SpenMotionEvent(e));
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenGestureDetector.Listener
    public boolean onSingleTapUp(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.mNativeGestureRefiner == 0) {
            return false;
        }
        return INSTANCE.Native_onSingleTapUp(this.mNativeGestureRefiner, new SpenMotionEvent(e));
    }

    public final void setDoubleTapEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setDoubleTapEnabled(z);
        }
    }

    public final void setFlingEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setFlingEnabled(z);
        }
    }

    public final void setHoldLongPressEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setHoldLongPressEnabled(z);
        }
    }

    public final void setHoldMotionEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setHoldMotionEnabled(z);
        }
    }

    public final void setLongPressEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setLongPressEnabled(z);
        }
    }

    public final void setMultipleTapEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setMultipleTapEnabled(z);
        }
    }

    public final void setPalmRejectionEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setPalmRejectionEnabled(z);
        }
    }

    public final void setPalmRejectionThreshold(float threshold) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setPalmRejectionThreshold(threshold);
        }
    }

    public final void setScaleEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setScaleEnabled(z);
        }
    }

    public final void setScrollEnabled(boolean z) {
        SpenGestureDetector spenGestureDetector = this.mGestureDetector;
        if (spenGestureDetector != null) {
            spenGestureDetector.setScrollEnabled(z);
        }
    }
}
