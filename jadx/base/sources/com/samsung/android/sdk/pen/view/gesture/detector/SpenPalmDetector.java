package com.samsung.android.sdk.pen.view.gesture.detector;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.view.SpenMotionEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenPalmDetector;", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenPalmDetector$Listener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenPalmDetector$Listener;)V", "mListener", "mContext", "mNativePalmDetector", "", "value", "", "isEnabled", "()Z", "construct", "", "close", "setEnabled", "enabled", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setPalmThreshold", "threshold", "", "onPalmTouchBegin", "onPalmTouchEnd", "Listener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPalmDetector {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean isEnabled;

    @Nullable
    private Context mContext;

    @Nullable
    private Listener mListener;
    private long mNativePalmDetector;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0019\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0019\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0083 ¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenPalmDetector$Companion;", "", "<init>", "()V", "Native_init", "", "palmDetector", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenPalmDetector;", "Native_finalize", "", "mNativePalmDetector", "Native_onTouchEvent", "event", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "Native_setPalmThreshold", "threshold", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long mNativePalmDetector) {
            SpenPalmDetector.Native_finalize(mNativePalmDetector);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenPalmDetector palmDetector) {
            return SpenPalmDetector.Native_init(palmDetector);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onTouchEvent(long mNativePalmDetector, SpenMotionEvent event) {
            SpenPalmDetector.Native_onTouchEvent(mNativePalmDetector, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPalmThreshold(long mNativePalmDetector, float threshold) {
            SpenPalmDetector.Native_setPalmThreshold(mNativePalmDetector, threshold);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenPalmDetector$Listener;", "", "onPalmTouchBegin", "", "onPalmTouchEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface Listener {
        void onPalmTouchBegin();

        void onPalmTouchEnd();
    }

    public SpenPalmDetector(@Nullable Context context, @Nullable Listener listener) {
        this.mListener = listener;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenPalmDetector spenPalmDetector);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onTouchEvent(long j, SpenMotionEvent spenMotionEvent);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPalmThreshold(long j, float f);

    public final void close() {
        this.mListener = null;
        INSTANCE.Native_finalize(this.mNativePalmDetector);
        this.mNativePalmDetector = 0L;
        this.mContext = null;
    }

    public final void construct() {
        this.mNativePalmDetector = INSTANCE.Native_init(this);
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void onPalmTouchBegin() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onPalmTouchBegin();
        }
    }

    public final void onPalmTouchEnd() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onPalmTouchEnd();
        }
    }

    public final void onTouchEvent(@Nullable MotionEvent event) {
        if (this.mNativePalmDetector == 0 || !this.isEnabled || event == null) {
            return;
        }
        INSTANCE.Native_onTouchEvent(this.mNativePalmDetector, new SpenMotionEvent(event));
    }

    public final void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public final void setPalmThreshold(float threshold) {
        long j = this.mNativePalmDetector;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setPalmThreshold(j, threshold);
    }
}
