package com.samsung.android.sdk.pen.engine.drawLoop;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.Choreographer;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.pen.debug.ISpenGraphicMemoryLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001AB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u001fH\u0017J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001bJ\u0010\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010\u0010J\u0006\u0010+\u001a\u00020\u0006J\u0018\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001bH\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0006H\u0016J\b\u00101\u001a\u00020\u001fH\u0016J\b\u00102\u001a\u00020\u001fH\u0016J\b\u00103\u001a\u00020\u001fH\u0016J \u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001bH\u0016J \u00107\u001a\u00020\u001f2\u0006\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001bH\u0016J\u0010\u00108\u001a\u00020\u00062\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u001f2\u0006\u00105\u001a\u000206H\u0017J*\u0010:\u001a\u00020\u001f2\b\u00105\u001a\u0004\u0018\u00010\f2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001bH\u0002J\u0010\u0010<\u001a\u00020\u001f2\b\u00105\u001a\u0004\u0018\u00010\fJ\u0010\u0010=\u001a\u00020\u001f2\b\u00105\u001a\u0004\u0018\u00010\fJ\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\nH\u0016J\b\u0010@\u001a\u00020\u001fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopTexture;", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "Lcom/samsung/android/sdk/pen/debug/ISpenGraphicMemoryLogger;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/Choreographer$FrameCallback;", "useStaticRenderer", "", "<init>", "(Z)V", "nativeDrawLoop", "", "mSurface", "Landroid/view/Surface;", "mTimeStamp", "mFrameTimeNanos", "mTwinView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "mHandlerTwin", "mRemoveTwinViewTaskQueue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "msgQueueHandle", "getMsgQueueHandle", "()J", "rendererType", "", "getRendererType", "()I", "init", "", "close", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setCurrentViewColor", "color", "setCaptureCurrentViewBmp", "bitmap", "Landroid/graphics/Bitmap;", "setOwnedTwinView", "twinView", "IsTwinViewVisible", "setScreenSize", "width", "height", "onLayout", "isChanged", "onViewDetachedFromWindow", "onResume", "onPause", "onSurfaceTextureAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "surfaceChanged", "format", "surfaceCreated", "surfaceDestroyed", "doFrame", "frameTimeNanos", "printGraphicMemoryUsage", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenDrawLoopTexture implements SpenDrawLoopInterface, ISpenGraphicMemoryLogger, TextureView.SurfaceTextureListener, Choreographer.FrameCallback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenDrawLoopTexture";

    @Nullable
    private Surface mSurface;
    private final long mTimeStamp;

    @Nullable
    private View mTwinView;
    private long nativeDrawLoop;
    private long mFrameTimeNanos = -1;

    @NotNull
    private final Handler handler = new Handler();

    @NotNull
    private final Handler mHandlerTwin = new Handler();

    @NotNull
    private final Queue<Runnable> mRemoveTwinViewTaskQueue = new LinkedList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0083 J\u0019\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0083 J\u0011\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0083 J\u001b\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0083 J\u0011\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J+\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0083 J\u0011\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0011\u0010 \u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0011\u0010!\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopTexture$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "useStaticRenderer", "", "Native_construct", "nativeDrawLoop", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopTexture;", "Native_finalize", "", "Native_onDraw", "isAsyncCall", "Native_onDrawToScreen", "Native_isScrolling", "Native_getMsgQueue", "Native_getRendererType", "", "Native_setScreenSize", "width", "height", "Native_surfaceCreated", "surface", "Landroid/view/Surface;", "Native_surfaceDestroyed", "Native_surfaceChanged", "Native_onResume", "Native_onPause", "Native_printGraphicMemoryUsage", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeDrawLoop, SpenDrawLoopTexture drawLoop) {
            return SpenDrawLoopTexture.Native_construct(nativeDrawLoop, drawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeDrawLoop) {
            SpenDrawLoopTexture.Native_finalize(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getMsgQueue(long nativeDrawLoop) {
            return SpenDrawLoopTexture.Native_getMsgQueue(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getRendererType(long nativeDrawLoop) {
            return SpenDrawLoopTexture.Native_getRendererType(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(boolean useStaticRenderer) {
            return SpenDrawLoopTexture.Native_init(useStaticRenderer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isScrolling(long nativeDrawLoop) {
            return SpenDrawLoopTexture.Native_isScrolling(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDraw(long nativeDrawLoop, boolean isAsyncCall) {
            SpenDrawLoopTexture.Native_onDraw(nativeDrawLoop, isAsyncCall);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDrawToScreen(long nativeDrawLoop, boolean isAsyncCall) {
            SpenDrawLoopTexture.Native_onDrawToScreen(nativeDrawLoop, isAsyncCall);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPause(long nativeDrawLoop) {
            SpenDrawLoopTexture.Native_onPause(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onResume(long nativeDrawLoop) {
            SpenDrawLoopTexture.Native_onResume(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_printGraphicMemoryUsage(long nativeDrawLoop) {
            SpenDrawLoopTexture.Native_printGraphicMemoryUsage(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScreenSize(long nativeDrawLoop, int width, int height) {
            SpenDrawLoopTexture.Native_setScreenSize(nativeDrawLoop, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_surfaceChanged(long nativeDrawLoop, Surface surface, int width, int height) {
            return SpenDrawLoopTexture.Native_surfaceChanged(nativeDrawLoop, surface, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_surfaceCreated(long nativeDrawLoop, Surface surface) {
            return SpenDrawLoopTexture.Native_surfaceCreated(nativeDrawLoop, surface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_surfaceDestroyed(long nativeDrawLoop) {
            SpenDrawLoopTexture.Native_surfaceDestroyed(nativeDrawLoop);
        }

        private Companion() {
        }
    }

    public SpenDrawLoopTexture(boolean z) {
        init(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenDrawLoopTexture spenDrawLoopTexture);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_getMsgQueue(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getRendererType(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isScrolling(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDraw(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDrawToScreen(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onPause(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onResume(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_printGraphicMemoryUsage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setScreenSize(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_surfaceChanged(long j, Surface surface, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_surfaceCreated(long j, Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_surfaceDestroyed(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doFrame$lambda$8(long j, SpenDrawLoopTexture spenDrawLoopTexture) {
        Log.d(TAG, "doFrame mFrameTimeNanos == frameTimeNanos: " + j);
        Choreographer.getInstance().removeFrameCallback(spenDrawLoopTexture);
        Choreographer.getInstance().postFrameCallback(spenDrawLoopTexture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doFrame$lambda$9(SpenDrawLoopTexture spenDrawLoopTexture) {
        if (spenDrawLoopTexture.nativeDrawLoop != 0) {
            if (spenDrawLoopTexture.IsTwinViewVisible()) {
                INSTANCE.Native_onResume(spenDrawLoopTexture.nativeDrawLoop);
            }
            Companion companion = INSTANCE;
            if (companion.Native_isScrolling(spenDrawLoopTexture.nativeDrawLoop)) {
                companion.Native_onDrawToScreen(spenDrawLoopTexture.nativeDrawLoop, true);
                companion.Native_onDraw(spenDrawLoopTexture.nativeDrawLoop, true);
            } else {
                companion.Native_onDraw(spenDrawLoopTexture.nativeDrawLoop, true);
                companion.Native_onDrawToScreen(spenDrawLoopTexture.nativeDrawLoop, true);
            }
            Choreographer.getInstance().removeFrameCallback(spenDrawLoopTexture);
            Choreographer.getInstance().postFrameCallback(spenDrawLoopTexture);
        }
    }

    private final void init(boolean useStaticRenderer) {
        Companion companion = INSTANCE;
        long jNative_init = companion.Native_init(useStaticRenderer);
        this.nativeDrawLoop = jNative_init;
        Log.d(TAG, "init(): " + jNative_init);
        companion.Native_construct(this.nativeDrawLoop, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCaptureCurrentViewBmp$lambda$6$lambda$4(View view, SpenDrawLoopTexture spenDrawLoopTexture) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.invalidate();
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(view);
        Log.d(TAG, "hiding mTwinView completed" + spenDrawLoopTexture.nativeDrawLoop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCaptureCurrentViewBmp$lambda$6$lambda$5(SpenDrawLoopTexture spenDrawLoopTexture) {
        Runnable runnablePoll = spenDrawLoopTexture.mRemoveTwinViewTaskQueue.poll();
        if (runnablePoll != null) {
            runnablePoll.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCurrentViewColor$lambda$3$lambda$1(View view, SpenDrawLoopTexture spenDrawLoopTexture) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.invalidate();
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(view);
        Log.d(TAG, "hiding mTwinView completed" + spenDrawLoopTexture.nativeDrawLoop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCurrentViewColor$lambda$3$lambda$2(SpenDrawLoopTexture spenDrawLoopTexture) {
        Runnable runnablePoll = spenDrawLoopTexture.mRemoveTwinViewTaskQueue.poll();
        if (runnablePoll != null) {
            runnablePoll.run();
        }
    }

    private final void surfaceChanged(Surface surface, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged(): " + this.nativeDrawLoop);
        Companion companion = INSTANCE;
        companion.Native_surfaceChanged(this.nativeDrawLoop, surface, width, height);
        setScreenSize(width, height);
        companion.Native_onDraw(this.nativeDrawLoop, false);
        companion.Native_onDrawToScreen(this.nativeDrawLoop, false);
    }

    public final boolean IsTwinViewVisible() {
        return !this.mRemoveTwinViewTaskQueue.isEmpty();
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    @TargetApi(19)
    public void close() {
        Log.d(TAG, "close(): " + this.nativeDrawLoop);
        while (!this.mRemoveTwinViewTaskQueue.isEmpty()) {
            Runnable runnablePoll = this.mRemoveTwinViewTaskQueue.poll();
            if (runnablePoll != null) {
                this.mHandlerTwin.removeCallbacks(runnablePoll);
                runnablePoll.run();
            }
        }
        this.mSurface = null;
        this.mTwinView = null;
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.nativeDrawLoop = 0L;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        long j = this.mFrameTimeNanos;
        if (j != -1 && j == frameTimeNanos) {
            this.handler.post(new RunnableC7449c(1, frameTimeNanos, this));
        } else {
            this.mFrameTimeNanos = frameTimeNanos;
            this.handler.post(new RunnableC7451e(this, 1));
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public long getMsgQueueHandle() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            return INSTANCE.Native_getMsgQueue(j);
        }
        return 0L;
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public int getRendererType() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            return INSTANCE.Native_getRendererType(j);
        }
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onDraw(@Nullable Canvas canvas) {
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onLayout(boolean isChanged) {
        long j = this.nativeDrawLoop;
        if (j == 0 || !isChanged) {
            return;
        }
        Companion companion = INSTANCE;
        companion.Native_onDraw(j, false);
        companion.Native_onDrawToScreen(this.nativeDrawLoop, false);
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onPause() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_onPause(j);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onResume() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_onResume(j);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Choreographer.getInstance().postFrameCallback(this);
        Log.d(TAG, "onSurfaceTextureAvailable");
        Surface surface2 = new Surface(surface);
        this.mSurface = surface2;
        surfaceCreated(surface2);
        surfaceChanged(this.mSurface, 0, width, height);
        setScreenSize(width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        surfaceDestroyed(this.mSurface);
        Choreographer.getInstance().removeFrameCallback(this);
        Log.d(TAG, "onSurfaceTextureDestroyed");
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Choreographer.getInstance().postFrameCallback(this);
        Log.d(TAG, "onSurfaceTextureSizeChanged");
        surfaceChanged(this.mSurface, 0, width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    @RequiresApi(api = 23)
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onViewDetachedFromWindow() {
    }

    @Override // com.samsung.android.sdk.pen.debug.ISpenGraphicMemoryLogger
    public void printGraphicMemoryUsage() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_printGraphicMemoryUsage(j);
        }
    }

    public final void setCaptureCurrentViewBmp(@Nullable Bitmap bitmap) {
        View view = this.mTwinView;
        if (view != null) {
            Log.d(TAG, "Show mTwinView and start delayed hide of mTwinView " + this.nativeDrawLoop);
            view.setBackground(new BitmapDrawable(bitmap));
            view.setVisibility(0);
            view.invalidate();
            this.mRemoveTwinViewTaskQueue.add(new RunnableC7450d(this.mTwinView, this, 0));
            this.mHandlerTwin.postDelayed(new RunnableC7451e(this, 0), 500L);
            this.mTwinView = null;
        }
    }

    public final void setCurrentViewColor(int color) {
        View view = this.mTwinView;
        if (view != null) {
            Log.d(TAG, "Show mTwinView with bgcolor and start delayed hide of mTwinView " + this.nativeDrawLoop);
            view.setBackgroundColor(color);
            view.setVisibility(0);
            view.invalidate();
            this.mRemoveTwinViewTaskQueue.add(new RunnableC7450d(this.mTwinView, this, 1));
            this.mHandlerTwin.postDelayed(new RunnableC7451e(this, 2), 500L);
            this.mTwinView = null;
        }
    }

    public final void setOwnedTwinView(@Nullable View twinView) {
        if (twinView == null) {
            return;
        }
        View view = this.mTwinView;
        if (view != null) {
            view.setVisibility(8);
            view.invalidate();
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
        this.mTwinView = twinView;
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void setScreenSize(int width, int height) {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_setScreenSize(j, width, height);
        }
    }

    public final void surfaceCreated(@Nullable Surface surface) {
        Log.d(TAG, "surfaceCreated(): " + this.nativeDrawLoop);
        INSTANCE.Native_surfaceCreated(this.nativeDrawLoop, surface);
    }

    public final void surfaceDestroyed(@Nullable Surface surface) {
        Log.d(TAG, "surfaceDestroyed(): " + this.nativeDrawLoop);
        INSTANCE.Native_surfaceDestroyed(this.nativeDrawLoop);
    }
}
