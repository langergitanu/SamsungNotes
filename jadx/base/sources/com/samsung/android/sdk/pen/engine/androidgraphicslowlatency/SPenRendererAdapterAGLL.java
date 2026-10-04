package com.samsung.android.sdk.pen.engine.androidgraphicslowlatency;

import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceView;
import androidx.annotation.RequiresApi;
import androidx.graphics.lowlatency.BufferInfo;
import androidx.graphics.lowlatency.GLFrontBufferedRenderer;
import androidx.graphics.opengl.GLRenderer;
import androidx.graphics.opengl.egl.EGLManager;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(api = 29)
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fJ\u0006\u0010\u001f\u001a\u00020\u0016J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/androidgraphicslowlatency/SPenRendererAdapterAGLL;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/sdk/pen/engine/androidgraphicslowlatency/SpenAGLLDrawCallback;", "surfaceView", "Landroid/view/SurfaceView;", "<init>", "(Lcom/samsung/android/sdk/pen/engine/androidgraphicslowlatency/SpenAGLLDrawCallback;Landroid/view/SurfaceView;)V", "mCallback", "mRenderer", "Landroidx/graphics/lowlatency/GLFrontBufferedRenderer;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mCanvasWidth", "", "mCanvasHeight", "mEmptyCollection", "", "mFrontBufferRendererCallbacks", "Landroidx/graphics/lowlatency/GLFrontBufferedRenderer$Callback;", "value", "", "isFrontBufferRendererEnabled", "()Z", "mIsSurfaceDestroyed", "close", "", "callOnDraw", "canvasWidth", "canvasHeight", "callFbrOnDraw", "callOnProcess", "wait", "setRenderMode", "isFrontBufferRenderer", "setSurfaceDestroyed", "isDestroyed", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SPenRendererAdapterAGLL {

    @NotNull
    private static final String TAG = "SPenRendererAdapterAGLL";
    private boolean isFrontBufferRendererEnabled;

    @Nullable
    private SpenAGLLDrawCallback mCallback;
    private int mCanvasHeight;
    private int mCanvasWidth;

    @NotNull
    private final Collection<ArrayList<Float>> mEmptyCollection = new ArrayList();

    @NotNull
    private final GLFrontBufferedRenderer.Callback<ArrayList<Float>> mFrontBufferRendererCallbacks;
    private boolean mIsSurfaceDestroyed;

    @Nullable
    private GLFrontBufferedRenderer<ArrayList<Float>> mRenderer;

    public SPenRendererAdapterAGLL(@Nullable SpenAGLLDrawCallback spenAGLLDrawCallback, @Nullable SurfaceView surfaceView) {
        GLFrontBufferedRenderer.Callback<ArrayList<Float>> callback = new GLFrontBufferedRenderer.Callback<ArrayList<Float>>() { // from class: com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SPenRendererAdapterAGLL$mFrontBufferRendererCallbacks$1
            public void onDrawMultiBufferedLayer(EGLManager eglManager, int width, int height, BufferInfo bufferInfo, float[] transform, Collection<? extends ArrayList<Float>> params) {
                Intrinsics.checkNotNullParameter(eglManager, "eglManager");
                Intrinsics.checkNotNullParameter(bufferInfo, "bufferInfo");
                Intrinsics.checkNotNullParameter(transform, "transform");
                Intrinsics.checkNotNullParameter(params, "params");
                Log.d("SPenRendererAdapterAGLL", "onDrawMultiBufferedLayer bufferinfo w = " + bufferInfo.getWidth() + ", h = " + bufferInfo.getHeight());
                SpenAGLLDrawInfo spenAGLLDrawInfo = new SpenAGLLDrawInfo(new Rect(0, 0, this.this$0.mCanvasWidth, this.this$0.mCanvasHeight), this.this$0.mCanvasWidth, this.this$0.mCanvasHeight, false, transform);
                SpenAGLLDrawCallback spenAGLLDrawCallback2 = this.this$0.mCallback;
                if (spenAGLLDrawCallback2 != null) {
                    spenAGLLDrawCallback2.onDraw(spenAGLLDrawInfo);
                }
            }

            public void onDrawFrontBufferedLayer(EGLManager eglManager, int width, int height, BufferInfo bufferInfo, float[] transform, ArrayList<Float> param) {
                Intrinsics.checkNotNullParameter(eglManager, "eglManager");
                Intrinsics.checkNotNullParameter(bufferInfo, "bufferInfo");
                Intrinsics.checkNotNullParameter(transform, "transform");
                Intrinsics.checkNotNullParameter(param, "param");
                Log.d("SPenRendererAdapterAGLL", "onDrawFrontBufferedLayer bufferinfo w = " + bufferInfo.getWidth() + ", h = " + bufferInfo.getHeight());
                SpenAGLLDrawInfo spenAGLLDrawInfo = new SpenAGLLDrawInfo(new Rect(0, 0, this.this$0.mCanvasWidth, this.this$0.mCanvasHeight), this.this$0.mCanvasWidth, this.this$0.mCanvasHeight, true, transform);
                SpenAGLLDrawCallback spenAGLLDrawCallback2 = this.this$0.mCallback;
                if (spenAGLLDrawCallback2 != null) {
                    spenAGLLDrawCallback2.onDraw(spenAGLLDrawInfo);
                }
            }
        };
        this.mFrontBufferRendererCallbacks = callback;
        Log.i(TAG, "construct");
        if (surfaceView != null) {
            this.mRenderer = new GLFrontBufferedRenderer<>(surfaceView, callback, (GLRenderer) null, 0, 12, (DefaultConstructorMarker) null);
        }
        this.mCallback = spenAGLLDrawCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callOnProcess$lambda$2(SPenRendererAdapterAGLL sPenRendererAdapterAGLL, CountDownLatch countDownLatch) {
        Log.d(TAG, "run OnProcess");
        SpenAGLLDrawCallback spenAGLLDrawCallback = sPenRendererAdapterAGLL.mCallback;
        if (spenAGLLDrawCallback != null) {
            spenAGLLDrawCallback.onProcessWithoutScreenUpdate();
        }
        countDownLatch.countDown();
    }

    public final boolean callFbrOnDraw() {
        if (this.isFrontBufferRendererEnabled) {
            ArrayList arrayList = new ArrayList();
            GLFrontBufferedRenderer<ArrayList<Float>> gLFrontBufferedRenderer = this.mRenderer;
            if (gLFrontBufferedRenderer != null) {
                gLFrontBufferedRenderer.renderFrontBufferedLayer(arrayList);
                return true;
            }
        }
        return false;
    }

    public final boolean callOnDraw(int canvasWidth, int canvasHeight) {
        GLFrontBufferedRenderer<ArrayList<Float>> gLFrontBufferedRenderer = this.mRenderer;
        if (gLFrontBufferedRenderer == null) {
            return true;
        }
        this.mCanvasWidth = canvasWidth;
        this.mCanvasHeight = canvasHeight;
        if (this.isFrontBufferRendererEnabled) {
            gLFrontBufferedRenderer.renderFrontBufferedLayer(new ArrayList());
            return true;
        }
        if (this.mIsSurfaceDestroyed) {
            return true;
        }
        gLFrontBufferedRenderer.renderMultiBufferedLayer(this.mEmptyCollection);
        return true;
    }

    public final boolean callOnProcess(boolean wait) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        GLFrontBufferedRenderer<ArrayList<Float>> gLFrontBufferedRenderer = this.mRenderer;
        if (gLFrontBufferedRenderer != null) {
            gLFrontBufferedRenderer.execute(new RunnableC4199v(this, countDownLatch, 8));
        }
        if (wait) {
            try {
                countDownLatch.await();
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public final void close() {
        Log.i(TAG, "close");
        GLFrontBufferedRenderer<ArrayList<Float>> gLFrontBufferedRenderer = this.mRenderer;
        if (gLFrontBufferedRenderer != null) {
            GLFrontBufferedRenderer.release$default(gLFrontBufferedRenderer, true, (Function0) null, 2, (Object) null);
        }
    }

    /* JADX INFO: renamed from: isFrontBufferRendererEnabled, reason: from getter */
    public final boolean getIsFrontBufferRendererEnabled() {
        return this.isFrontBufferRendererEnabled;
    }

    public final void setRenderMode(boolean isFrontBufferRenderer) {
        this.isFrontBufferRendererEnabled = isFrontBufferRenderer;
    }

    public final void setSurfaceDestroyed(boolean isDestroyed) {
        this.mIsSurfaceDestroyed = isDestroyed;
    }
}
