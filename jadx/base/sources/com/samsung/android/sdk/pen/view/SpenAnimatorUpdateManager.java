package com.samsung.android.sdk.pen.view;

import android.util.Log;
import android.view.Choreographer;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenAnimatorUpdateManager;", "Landroid/view/Choreographer$FrameCallback;", "<init>", "()V", "value", "", "nativeHandle", "getNativeHandle", "()J", "close", "", "onViewDetachedFromWindow", "doFrame", "frameTimeNanos", "doAnimationFrame", "", "postFrameCallback", "onPostFrameCallback", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenAnimatorUpdateManager implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "AnimatorUpdateManager";
    private long nativeHandle = INSTANCE.Native_init(this);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenAnimatorUpdateManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "animatorUpdateManager", "Lcom/samsung/android/sdk/pen/view/SpenAnimatorUpdateManager;", "Native_doAnimationFrame", "", "nativeHandle", "Native_finalize", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_doAnimationFrame(long nativeHandle) {
            return SpenAnimatorUpdateManager.Native_doAnimationFrame(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenAnimatorUpdateManager.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenAnimatorUpdateManager animatorUpdateManager) {
            return SpenAnimatorUpdateManager.Native_init(animatorUpdateManager);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_doAnimationFrame(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenAnimatorUpdateManager spenAnimatorUpdateManager);

    private final boolean doAnimationFrame() {
        long j = this.nativeHandle;
        if (j != 0) {
            return INSTANCE.Native_doAnimationFrame(j);
        }
        return false;
    }

    private final void onPostFrameCallback() {
        postFrameCallback();
    }

    private final void postFrameCallback() {
        if (this.nativeHandle != 0) {
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public final void close() {
        long j = this.nativeHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.nativeHandle = 0L;
        Choreographer.getInstance().removeFrameCallback(this);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        if (doAnimationFrame()) {
            postFrameCallback();
            Log.i(TAG, "doFrame");
        }
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
    }

    public final void onViewDetachedFromWindow() {
        Choreographer.getInstance().removeFrameCallback(this);
    }
}
