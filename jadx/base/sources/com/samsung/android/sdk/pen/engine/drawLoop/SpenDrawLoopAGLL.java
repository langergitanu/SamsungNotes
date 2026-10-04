package com.samsung.android.sdk.pen.engine.drawLoop;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SPenRendererAdapterAGLL;
import com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SpenAGLLDrawCallback;
import com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SpenAGLLDrawInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(api = 29)
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001JB\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0006\u0010$\u001a\u00020\u001dJ\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u0011H\u0016J\b\u00100\u001a\u00020\u001dH\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0011H\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\u001dH\u0016J\b\u00107\u001a\u00020\u001dH\u0016J\b\u00108\u001a\u00020\u001dH\u0016J\u0014\u0010!\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J(\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0010\u0010@\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u0011H\u0007J\u000e\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u0011J\u0010\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u000eH\u0016J\u000e\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopAGLL;", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/samsung/android/sdk/pen/engine/androidgraphicslowlatency/SpenAGLLDrawCallback;", "Landroid/view/Choreographer$FrameCallback;", "mParent", "Landroid/view/View;", "mSurfaceView", "Landroid/view/SurfaceView;", "<init>", "(Landroid/view/View;Landroid/view/SurfaceView;)V", "mHandler", "Landroid/os/Handler;", "nativeDrawLoop", "", "mThreadId", "mDestroy", "", "mRendererAdapter", "Lcom/samsung/android/sdk/pen/engine/androidgraphicslowlatency/SPenRendererAdapterAGLL;", "mIsFrontBufferRenderingAllowed", "mSurfaceWidth", "", "mSurfaceHeight", "mIsDoFrameMode", "mIsDrawRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsUnbufferedDispatch", "init", "", "close", "onViewDetachedFromWindow", "postDestroyRendererAdapter", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDrawFbr", "msgQueueHandle", "getMsgQueueHandle", "()J", "rendererType", "getRendererType", "()I", "setScreenSize", "width", "height", "onLayout", "isChanged", "onPause", "onResume", "invoke", "waitForCompleting", "requestInvalidate", "ms", "onProcessWithoutScreenUpdate", "onProcessWithNoContext", "onSync", "Landroid/graphics/RectF;", "info", "Lcom/samsung/android/sdk/pen/engine/androidgraphicslowlatency/SpenAGLLDrawInfo;", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "surfaceCreated", "surfaceDestroyed", "setFrontBufferRendering", "isFrontBufferRenderer", "allowFrontBufferRendering", "allowFbr", "doFrame", "frameTimeNanos", "setUnbuffereDispatch", "enable", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenDrawLoopAGLL implements SpenDrawLoopInterface, SurfaceHolder.Callback, SpenAGLLDrawCallback, Choreographer.FrameCallback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenDrawLoopAGLL";
    private boolean mDestroy;
    private boolean mIsUnbufferedDispatch;

    @Nullable
    private View mParent;

    @Nullable
    private SPenRendererAdapterAGLL mRendererAdapter;
    private int mSurfaceHeight;

    @Nullable
    private SurfaceView mSurfaceView;
    private int mSurfaceWidth;
    private long mThreadId;
    private long nativeDrawLoop;
    private boolean mIsFrontBufferRenderingAllowed = true;
    private final boolean mIsDoFrameMode = true;

    @NotNull
    private final AtomicBoolean mIsDrawRequested = new AtomicBoolean(false);

    @NotNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0083 J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0083 J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u001b\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0083 J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0007H\u0083 J!\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0083 J\u0011\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0019\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0083 J\u0011\u0010!\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J)\u0010\"\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopAGLL$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "Native_construct", "", "nativeDrawLoop", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopAGLL;", "Native_finalize", "", "Native_onDraw", "Native_onDrawAGLL", "info", "Lcom/samsung/android/sdk/pen/engine/androidgraphicslowlatency/SpenAGLLDrawInfo;", "Native_getMsgQueue", "Native_getRendererType", "", "Native_setScreenSize", "width", "height", "Native_onPause", "Native_onResume", "Native_onProcessWithoutScreenUpdate", "Native_onProcessWithNoContext", "Native_onSync", "Native_surfaceCreated", "surface", "Landroid/view/Surface;", "Native_surfaceDestroyed", "Native_surfaceChanged", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeDrawLoop, SpenDrawLoopAGLL drawLoop) {
            return SpenDrawLoopAGLL.Native_construct(nativeDrawLoop, drawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeDrawLoop) {
            SpenDrawLoopAGLL.Native_finalize(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getMsgQueue(long nativeDrawLoop) {
            return SpenDrawLoopAGLL.Native_getMsgQueue(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getRendererType(long nativeDrawLoop) {
            return SpenDrawLoopAGLL.Native_getRendererType(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init() {
            return SpenDrawLoopAGLL.Native_init();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDraw(long nativeDrawLoop) {
            SpenDrawLoopAGLL.Native_onDraw(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDrawAGLL(long nativeDrawLoop, SpenAGLLDrawInfo info) {
            SpenDrawLoopAGLL.Native_onDrawAGLL(nativeDrawLoop, info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPause(long nativeDrawLoop) {
            SpenDrawLoopAGLL.Native_onPause(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onProcessWithNoContext(long nativeDrawLoop) {
            SpenDrawLoopAGLL.Native_onProcessWithNoContext(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onProcessWithoutScreenUpdate(long nativeDrawLoop) {
            SpenDrawLoopAGLL.Native_onProcessWithoutScreenUpdate(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onResume(long nativeDrawLoop) {
            SpenDrawLoopAGLL.Native_onResume(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onSync(long nativeDrawLoop) {
            SpenDrawLoopAGLL.Native_onSync(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScreenSize(long nativeDrawLoop, int width, int height) {
            SpenDrawLoopAGLL.Native_setScreenSize(nativeDrawLoop, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_surfaceChanged(long nativeDrawLoop, Surface surface, int width, int height) {
            return SpenDrawLoopAGLL.Native_surfaceChanged(nativeDrawLoop, surface, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_surfaceCreated(long nativeDrawLoop, Surface surface) {
            return SpenDrawLoopAGLL.Native_surfaceCreated(nativeDrawLoop, surface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_surfaceDestroyed(long nativeDrawLoop) {
            SpenDrawLoopAGLL.Native_surfaceDestroyed(nativeDrawLoop);
        }

        private Companion() {
        }
    }

    public SpenDrawLoopAGLL(@Nullable View view, @Nullable SurfaceView surfaceView) {
        this.mParent = view;
        this.mSurfaceView = surfaceView;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenDrawLoopAGLL spenDrawLoopAGLL);

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
    public static final native long Native_init();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDraw(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDrawAGLL(long j, SpenAGLLDrawInfo spenAGLLDrawInfo);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onPause(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onProcessWithNoContext(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onProcessWithoutScreenUpdate(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onResume(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onSync(long j);

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
    public static final void doFrame$lambda$4(SpenDrawLoopAGLL spenDrawLoopAGLL) {
        if (spenDrawLoopAGLL.mRendererAdapter != null && spenDrawLoopAGLL.mIsDrawRequested.get()) {
            spenDrawLoopAGLL.mIsDrawRequested.set(false);
            long j = spenDrawLoopAGLL.nativeDrawLoop;
            if (j != 0) {
                INSTANCE.Native_onDraw(j);
            }
            SPenRendererAdapterAGLL sPenRendererAdapterAGLL = spenDrawLoopAGLL.mRendererAdapter;
            if (sPenRendererAdapterAGLL != null) {
                sPenRendererAdapterAGLL.callOnDraw(spenDrawLoopAGLL.mSurfaceWidth, spenDrawLoopAGLL.mSurfaceHeight);
            }
        }
        Choreographer.getInstance().postFrameCallback(spenDrawLoopAGLL);
    }

    private final void init() {
        Companion companion = INSTANCE;
        this.nativeDrawLoop = companion.Native_init();
        this.mThreadId = Thread.currentThread().getId();
        this.mRendererAdapter = new SPenRendererAdapterAGLL(this, this.mSurfaceView);
        companion.Native_construct(this.nativeDrawLoop, this);
    }

    private final boolean invoke(boolean waitForCompleting) {
        SPenRendererAdapterAGLL sPenRendererAdapterAGLL = this.mRendererAdapter;
        if (sPenRendererAdapterAGLL != null) {
            return sPenRendererAdapterAGLL.callOnProcess(waitForCompleting);
        }
        return false;
    }

    private final void postDestroyRendererAdapter() {
        new Handler(Looper.getMainLooper()).post(new RunnableC7447a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postDestroyRendererAdapter$lambda$1(SpenDrawLoopAGLL spenDrawLoopAGLL) {
        SPenRendererAdapterAGLL sPenRendererAdapterAGLL = spenDrawLoopAGLL.mRendererAdapter;
        if (sPenRendererAdapterAGLL != null) {
            sPenRendererAdapterAGLL.close();
            spenDrawLoopAGLL.mRendererAdapter = null;
        }
    }

    private final void requestInvalidate(int ms) {
        SPenRendererAdapterAGLL sPenRendererAdapterAGLL;
        View view = this.mParent;
        if (view != null) {
            if (this.mIsDoFrameMode) {
                boolean z = this.mIsUnbufferedDispatch && (sPenRendererAdapterAGLL = this.mRendererAdapter) != null && sPenRendererAdapterAGLL.getIsFrontBufferRendererEnabled();
                if (this.mThreadId == Thread.currentThread().getId() && ms == 0) {
                    if (!z) {
                        view.invalidate();
                    }
                } else if (!z) {
                    view.postInvalidateDelayed(ms);
                }
            } else if (this.mThreadId == Thread.currentThread().getId() && ms == 0) {
                view.invalidate();
            } else {
                view.postInvalidateDelayed(ms);
            }
            this.mIsDrawRequested.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void surfaceChanged$lambda$3(SpenDrawLoopAGLL spenDrawLoopAGLL) {
        Log.i(TAG, "mRendererAdapter.surfaceChanged();");
        SPenRendererAdapterAGLL sPenRendererAdapterAGLL = spenDrawLoopAGLL.mRendererAdapter;
        if (sPenRendererAdapterAGLL != null) {
            sPenRendererAdapterAGLL.setSurfaceDestroyed(false);
        }
    }

    public final void allowFrontBufferRendering(boolean allowFbr) {
        AbstractC4539a.m3208r("allowFrontBufferRendering = ", TAG, allowFbr);
        this.mIsFrontBufferRenderingAllowed = allowFbr;
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void close() {
        View view;
        if (this.nativeDrawLoop != 0) {
            this.mDestroy = true;
            SPenRendererAdapterAGLL sPenRendererAdapterAGLL = this.mRendererAdapter;
            if (sPenRendererAdapterAGLL != null && !sPenRendererAdapterAGLL.callOnProcess(true)) {
                INSTANCE.Native_finalize(this.nativeDrawLoop);
            }
            this.nativeDrawLoop = 0L;
        }
        if (this.mRendererAdapter != null && (view = this.mParent) != null && !view.isAttachedToWindow()) {
            postDestroyRendererAdapter();
        }
        this.mParent = null;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        this.mHandler.post(new RunnableC7447a(this, 0));
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
        if (this.mIsDoFrameMode || canvas == null) {
            return;
        }
        if (this.mRendererAdapter != null) {
            long j = this.nativeDrawLoop;
            if (j != 0) {
                INSTANCE.Native_onDraw(j);
            }
            SPenRendererAdapterAGLL sPenRendererAdapterAGLL = this.mRendererAdapter;
            if (sPenRendererAdapterAGLL != null) {
                sPenRendererAdapterAGLL.callOnDraw(canvas.getWidth(), canvas.getHeight());
            }
        }
        this.mIsDrawRequested.set(false);
    }

    public final void onDrawFbr() {
        SPenRendererAdapterAGLL sPenRendererAdapterAGLL = this.mRendererAdapter;
        if (sPenRendererAdapterAGLL == null || !sPenRendererAdapterAGLL.getIsFrontBufferRendererEnabled()) {
            return;
        }
        if (this.mIsDrawRequested.get()) {
            long j = this.nativeDrawLoop;
            if (j != 0) {
                INSTANCE.Native_onDraw(j);
            }
            SPenRendererAdapterAGLL sPenRendererAdapterAGLL2 = this.mRendererAdapter;
            if (sPenRendererAdapterAGLL2 != null) {
                sPenRendererAdapterAGLL2.callFbrOnDraw();
            }
        }
        this.mIsDrawRequested.set(false);
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onLayout(boolean isChanged) {
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onPause() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_onPause(j);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SpenAGLLDrawCallback
    public void onProcessWithNoContext() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            if (!this.mDestroy) {
                INSTANCE.Native_onProcessWithNoContext(j);
                return;
            }
            INSTANCE.Native_finalize(j);
            this.nativeDrawLoop = 0L;
            this.mDestroy = false;
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SpenAGLLDrawCallback
    public void onProcessWithoutScreenUpdate() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            if (!this.mDestroy) {
                INSTANCE.Native_onProcessWithoutScreenUpdate(j);
                return;
            }
            INSTANCE.Native_finalize(j);
            this.nativeDrawLoop = 0L;
            this.mDestroy = false;
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onResume() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_onResume(j);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SpenAGLLDrawCallback
    public void onSync() {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_onSync(j);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onViewDetachedFromWindow() {
        if (this.nativeDrawLoop != 0 || this.mRendererAdapter == null) {
            return;
        }
        postDestroyRendererAdapter();
    }

    @RequiresApi(api = 29)
    public final void setFrontBufferRendering(boolean isFrontBufferRenderer) {
        SPenRendererAdapterAGLL sPenRendererAdapterAGLL = this.mRendererAdapter;
        if (sPenRendererAdapterAGLL != null) {
            if (!this.mIsFrontBufferRenderingAllowed) {
                isFrontBufferRenderer = false;
            }
            sPenRendererAdapterAGLL.setRenderMode(isFrontBufferRenderer);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void setScreenSize(int width, int height) {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_setScreenSize(j, width, height);
        }
    }

    public final void setUnbuffereDispatch(boolean enable) {
        this.mIsUnbufferedDispatch = enable;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NotNull SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Companion companion = INSTANCE;
        long j = this.nativeDrawLoop;
        Surface surface = holder.getSurface();
        Intrinsics.checkNotNullExpressionValue(surface, "getSurface(...)");
        companion.Native_surfaceChanged(j, surface, width, height);
        this.mSurfaceWidth = width;
        this.mSurfaceHeight = height;
        this.mHandler.post(new RunnableC7447a(this, 2));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Companion companion = INSTANCE;
        long j = this.nativeDrawLoop;
        Surface surface = holder.getSurface();
        Intrinsics.checkNotNullExpressionValue(surface, "getSurface(...)");
        companion.Native_surfaceCreated(j, surface);
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        INSTANCE.Native_surfaceDestroyed(this.nativeDrawLoop);
        SPenRendererAdapterAGLL sPenRendererAdapterAGLL = this.mRendererAdapter;
        if (sPenRendererAdapterAGLL != null) {
            sPenRendererAdapterAGLL.setSurfaceDestroyed(true);
        }
        Choreographer.getInstance().removeFrameCallback(this);
    }

    @Override // com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SpenAGLLDrawCallback
    @Nullable
    public RectF onDraw(@Nullable SpenAGLLDrawInfo info) {
        long j = this.nativeDrawLoop;
        if (j == 0) {
            return null;
        }
        INSTANCE.Native_onDrawAGLL(j, info);
        return null;
    }
}
