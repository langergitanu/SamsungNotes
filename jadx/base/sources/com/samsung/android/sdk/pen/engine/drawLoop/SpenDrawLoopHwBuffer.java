package com.samsung.android.sdk.pen.engine.drawLoop;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.StrictMode;
import android.os.Trace;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructPollfd;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.debug.ISpenGraphicMemoryLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 92\u00020\u00012\u00020\u00022\u00020\u0003:\u000389:B\u001d\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0017J\u0012\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0017J\u0018\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020!H\u0016J\b\u0010-\u001a\u00020!H\u0016J\b\u0010.\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u000bH\u0016J\b\u00101\u001a\u00020!H\u0016J\u0010\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u0011H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u0011H\u0002J\u0010\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0015H\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHwBuffer;", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "Lcom/samsung/android/sdk/pen/debug/ISpenGraphicMemoryLogger;", "Landroid/view/Choreographer$FrameCallback;", "mParent", "Landroid/view/View;", "mRenderer", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenRenderer;", "<init>", "(Landroid/view/View;Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenRenderer;)V", "nativeDrawLoop", "", "mThreadId", "mFrameTimeNanos", "mPending", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHwBuffer$Frame;", "mWidth", "", "mHeight", "mHwBitmapPool", "Ljava/util/HashMap;", "Landroid/hardware/HardwareBuffer;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "handler", "Landroid/os/Handler;", "msgQueueHandle", "getMsgQueueHandle", "()J", "rendererType", "getRendererType", "()I", "init", "", "close", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setScreenSize", "width", "height", "onLayout", "isChanged", "", "onViewDetachedFromWindow", "onResume", "onPause", "doFrame", "frameTimeNanos", "printGraphicMemoryUsage", "awaitFenceFdHardBlocking", "fd", "requestInvalidate", "ms", "ensureCreateHwBitmap", "hwBuffer", "Frame", "Companion", "NativeFrame", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenDrawLoopHwBuffer implements SpenDrawLoopInterface, ISpenGraphicMemoryLogger, Choreographer.FrameCallback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenDrawLoopHwBuffer";

    @NotNull
    private final Handler handler;
    private long mFrameTimeNanos;
    private int mHeight;

    @NotNull
    private HashMap<HardwareBuffer, Bitmap> mHwBitmapPool;

    @Nullable
    private View mParent;

    @Nullable
    private Frame mPending;

    @Nullable
    private SpenRenderer mRenderer;
    private long mThreadId;
    private int mWidth;
    private long nativeDrawLoop;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0083 J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0083 J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0083 J\u0011\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J!\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0083 J\u0011\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHwBuffer$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "renderer", "Native_construct", "", "nativeDrawLoop", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHwBuffer;", "Native_finalize", "", "Native_onDraw", "isAsyncCall", "Native_onDrawToScreen", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHwBuffer$NativeFrame;", "Native_isScrolling", "Native_getMsgQueue", "Native_getRendererType", "", "Native_setScreenSize", "width", "height", "Native_onResume", "Native_onPause", "Native_printGraphicMemoryUsage", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeDrawLoop, SpenDrawLoopHwBuffer drawLoop) {
            return SpenDrawLoopHwBuffer.Native_construct(nativeDrawLoop, drawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeDrawLoop) {
            SpenDrawLoopHwBuffer.Native_finalize(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getMsgQueue(long nativeDrawLoop) {
            return SpenDrawLoopHwBuffer.Native_getMsgQueue(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getRendererType(long nativeDrawLoop) {
            return SpenDrawLoopHwBuffer.Native_getRendererType(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long renderer) {
            return SpenDrawLoopHwBuffer.Native_init(renderer);
        }

        @JvmStatic
        private final boolean Native_isScrolling(long nativeDrawLoop) {
            return SpenDrawLoopHwBuffer.Native_isScrolling(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDraw(long nativeDrawLoop, boolean isAsyncCall) {
            SpenDrawLoopHwBuffer.Native_onDraw(nativeDrawLoop, isAsyncCall);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final NativeFrame Native_onDrawToScreen(long nativeDrawLoop, boolean isAsyncCall) {
            return SpenDrawLoopHwBuffer.Native_onDrawToScreen(nativeDrawLoop, isAsyncCall);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPause(long nativeDrawLoop) {
            SpenDrawLoopHwBuffer.Native_onPause(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onResume(long nativeDrawLoop) {
            SpenDrawLoopHwBuffer.Native_onResume(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_printGraphicMemoryUsage(long nativeDrawLoop) {
            SpenDrawLoopHwBuffer.Native_printGraphicMemoryUsage(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScreenSize(long nativeDrawLoop, int width, int height) {
            SpenDrawLoopHwBuffer.Native_setScreenSize(nativeDrawLoop, width, height);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHwBuffer$Frame;", "", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "fenceFd", "", "<init>", "(Landroid/hardware/HardwareBuffer;I)V", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "getFenceFd", "()I", "setFenceFd", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class Frame {
        private int fenceFd;

        @NotNull
        private final HardwareBuffer hardwareBuffer;

        public Frame(@NotNull HardwareBuffer hardwareBuffer, int i) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            this.hardwareBuffer = hardwareBuffer;
            this.fenceFd = i;
        }

        public static /* synthetic */ Frame copy$default(Frame frame, HardwareBuffer hardwareBuffer, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                hardwareBuffer = frame.hardwareBuffer;
            }
            if ((i2 & 2) != 0) {
                i = frame.fenceFd;
            }
            return frame.copy(hardwareBuffer, i);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HardwareBuffer getHardwareBuffer() {
            return this.hardwareBuffer;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getFenceFd() {
            return this.fenceFd;
        }

        @NotNull
        public final Frame copy(@NotNull HardwareBuffer hardwareBuffer, int fenceFd) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            return new Frame(hardwareBuffer, fenceFd);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Frame)) {
                return false;
            }
            Frame frame = (Frame) other;
            return Intrinsics.areEqual(this.hardwareBuffer, frame.hardwareBuffer) && this.fenceFd == frame.fenceFd;
        }

        public final int getFenceFd() {
            return this.fenceFd;
        }

        @NotNull
        public final HardwareBuffer getHardwareBuffer() {
            return this.hardwareBuffer;
        }

        public int hashCode() {
            return Integer.hashCode(this.fenceFd) + (this.hardwareBuffer.hashCode() * 31);
        }

        public final void setFenceFd(int i) {
            this.fenceFd = i;
        }

        @NotNull
        public String toString() {
            return "Frame(hardwareBuffer=" + this.hardwareBuffer + ", fenceFd=" + this.fenceFd + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHwBuffer$NativeFrame;", "", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "fenceFd", "", "width", "height", "<init>", "(Landroid/hardware/HardwareBuffer;III)V", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "getFenceFd", "()I", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class NativeFrame {
        private final int fenceFd;

        @NotNull
        private final HardwareBuffer hardwareBuffer;
        private final int height;
        private final int width;

        public NativeFrame(@NotNull HardwareBuffer hardwareBuffer, int i, int i2, int i4) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            this.hardwareBuffer = hardwareBuffer;
            this.fenceFd = i;
            this.width = i2;
            this.height = i4;
        }

        public static /* synthetic */ NativeFrame copy$default(NativeFrame nativeFrame, HardwareBuffer hardwareBuffer, int i, int i2, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                hardwareBuffer = nativeFrame.hardwareBuffer;
            }
            if ((i5 & 2) != 0) {
                i = nativeFrame.fenceFd;
            }
            if ((i5 & 4) != 0) {
                i2 = nativeFrame.width;
            }
            if ((i5 & 8) != 0) {
                i4 = nativeFrame.height;
            }
            return nativeFrame.copy(hardwareBuffer, i, i2, i4);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HardwareBuffer getHardwareBuffer() {
            return this.hardwareBuffer;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getFenceFd() {
            return this.fenceFd;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        @NotNull
        public final NativeFrame copy(@NotNull HardwareBuffer hardwareBuffer, int fenceFd, int width, int height) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            return new NativeFrame(hardwareBuffer, fenceFd, width, height);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeFrame)) {
                return false;
            }
            NativeFrame nativeFrame = (NativeFrame) other;
            return Intrinsics.areEqual(this.hardwareBuffer, nativeFrame.hardwareBuffer) && this.fenceFd == nativeFrame.fenceFd && this.width == nativeFrame.width && this.height == nativeFrame.height;
        }

        public final int getFenceFd() {
            return this.fenceFd;
        }

        @NotNull
        public final HardwareBuffer getHardwareBuffer() {
            return this.hardwareBuffer;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return Integer.hashCode(this.height) + AbstractC0622a.m1157c(this.width, AbstractC0622a.m1157c(this.fenceFd, this.hardwareBuffer.hashCode() * 31, 31), 31);
        }

        @NotNull
        public String toString() {
            HardwareBuffer hardwareBuffer = this.hardwareBuffer;
            int i = this.fenceFd;
            int i2 = this.width;
            int i4 = this.height;
            StringBuilder sb = new StringBuilder("NativeFrame(hardwareBuffer=");
            sb.append(hardwareBuffer);
            sb.append(", fenceFd=");
            sb.append(i);
            sb.append(", width=");
            return AbstractC2322a.m1625o(sb, i2, i4, ", height=", ")");
        }
    }

    public SpenDrawLoopHwBuffer(@Nullable View view, @Nullable SpenRenderer spenRenderer) {
        this.mParent = view;
        this.mRenderer = spenRenderer;
        this.mFrameTimeNanos = -1L;
        this.mHwBitmapPool = new HashMap<>();
        this.handler = new Handler();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenDrawLoopHwBuffer spenDrawLoopHwBuffer);

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
    public static final native long Native_init(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isScrolling(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDraw(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native NativeFrame Native_onDrawToScreen(long j, boolean z);

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

    private final boolean awaitFenceFdHardBlocking(int fd) {
        if (fd < 0) {
            return true;
        }
        Trace.beginSection("awaitFenceFdHardBlocking");
        ParcelFileDescriptor parcelFileDescriptorAdoptFd = ParcelFileDescriptor.adoptFd(fd);
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder(threadPolicy);
        builder.permitNetwork();
        StrictMode.setThreadPolicy(builder.build());
        try {
            StructPollfd structPollfd = new StructPollfd();
            structPollfd.fd = parcelFileDescriptorAdoptFd.getFileDescriptor();
            structPollfd.events = (short) (OsConstants.POLLIN | OsConstants.POLLERR);
            while (true) {
                try {
                    try {
                    } catch (ErrnoException e) {
                        int i = e.errno;
                        if (i != OsConstants.EINTR) {
                            if (i == OsConstants.EBADF) {
                                Log.w(TAG, "Fence FD invalid (EBADF): proceeding to avoid stall", e);
                                Trace.endSection();
                                return true;
                            }
                            Log.e(TAG, "poll() failed errno=" + i, e);
                            Trace.endSection();
                            parcelFileDescriptorAdoptFd.close();
                            StrictMode.setThreadPolicy(threadPolicy);
                            Trace.endSection();
                            return false;
                        }
                    }
                    if (Os.poll(new StructPollfd[]{structPollfd}, -1) > 0) {
                        Trace.endSection();
                    } else {
                        continue;
                    }
                } catch (Throwable th) {
                    Log.e(TAG, "Unexpected exception during fence wait", th);
                }
            }
            try {
                parcelFileDescriptorAdoptFd.close();
            } catch (Throwable unused) {
            }
            StrictMode.setThreadPolicy(threadPolicy);
            Trace.endSection();
            return false;
        } finally {
            try {
                parcelFileDescriptorAdoptFd.close();
            } catch (Throwable unused2) {
            }
            StrictMode.setThreadPolicy(threadPolicy);
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doFrame$lambda$0(long j, SpenDrawLoopHwBuffer spenDrawLoopHwBuffer) {
        Log.d(TAG, "doFrame mFrameTimeNanos == frameTimeNanos: " + j);
        Choreographer.getInstance().removeFrameCallback(spenDrawLoopHwBuffer);
        Choreographer.getInstance().postFrameCallback(spenDrawLoopHwBuffer);
    }

    @RequiresApi(29)
    private final Bitmap ensureCreateHwBitmap(HardwareBuffer hwBuffer) {
        if (!this.mHwBitmapPool.containsKey(hwBuffer)) {
            Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hwBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            HashMap<HardwareBuffer, Bitmap> map = this.mHwBitmapPool;
            Intrinsics.checkNotNull(bitmapWrapHardwareBuffer);
            map.put(hwBuffer, bitmapWrapHardwareBuffer);
        }
        return (Bitmap) MapsKt.getValue(this.mHwBitmapPool, hwBuffer);
    }

    private final void init() {
        SpenRenderer spenRenderer = this.mRenderer;
        long renderer = spenRenderer != null ? spenRenderer.getNativeRenderer() : 0L;
        Companion companion = INSTANCE;
        this.nativeDrawLoop = companion.Native_init(renderer);
        this.mThreadId = Thread.currentThread().getId();
        Log.d(TAG, "init(): " + this.nativeDrawLoop);
        companion.Native_construct(this.nativeDrawLoop, this);
    }

    private final void requestInvalidate(int ms) {
        View view = this.mParent;
        if (view != null) {
            if (this.mThreadId == Thread.currentThread().getId() && ms == 0) {
                view.invalidate();
            } else {
                view.postInvalidateDelayed(ms);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    @TargetApi(19)
    public void close() {
        Log.d(TAG, "close(): " + this.nativeDrawLoop);
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.nativeDrawLoop = 0L;
        }
        this.mParent = null;
        this.mHwBitmapPool.clear();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        long j = this.mFrameTimeNanos;
        if (j != -1 && j == frameTimeNanos) {
            this.handler.post(new RunnableC7449c(0, frameTimeNanos, this));
            return;
        }
        this.mFrameTimeNanos = frameTimeNanos;
        long j2 = this.nativeDrawLoop;
        if (j2 != 0) {
            Companion companion = INSTANCE;
            NativeFrame nativeFrameNative_onDrawToScreen = companion.Native_onDrawToScreen(j2, false);
            if (nativeFrameNative_onDrawToScreen == null) {
                nativeFrameNative_onDrawToScreen = null;
            }
            if (nativeFrameNative_onDrawToScreen != null) {
                this.mPending = new Frame(nativeFrameNative_onDrawToScreen.getHardwareBuffer(), nativeFrameNative_onDrawToScreen.getFenceFd());
                requestInvalidate(0);
            }
            companion.Native_onDraw(this.nativeDrawLoop, true);
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
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
    @RequiresApi(29)
    public void onDraw(@Nullable Canvas canvas) {
        Bitmap bitmapEnsureCreateHwBitmap;
        Frame frame = this.mPending;
        if (frame == null) {
            return;
        }
        HardwareBuffer hardwareBuffer = frame.getHardwareBuffer();
        if (awaitFenceFdHardBlocking(frame.getFenceFd()) && (bitmapEnsureCreateHwBitmap = ensureCreateHwBitmap(hardwareBuffer)) != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(false);
            paint.setFilterBitmap(false);
            paint.setSubpixelText(false);
            paint.setDither(false);
            paint.setAlpha(255);
            if (canvas == null || !canvas.isHardwareAccelerated()) {
                Log.w(TAG, "onDraw fallback for software rendering - convert to software bitmap!");
                Bitmap bitmapCopy = bitmapEnsureCreateHwBitmap.copy(Bitmap.Config.ARGB_8888, false);
                if (bitmapCopy != null) {
                    if (canvas != null) {
                        canvas.drawBitmap(bitmapCopy, (Rect) null, new Rect(0, 0, this.mWidth, this.mHeight), paint);
                    }
                    bitmapCopy.recycle();
                } else {
                    Log.w(TAG, "onDraw softwareBitmap is null!");
                }
            } else if (canvas != null) {
                canvas.drawBitmap(bitmapEnsureCreateHwBitmap, (Rect) null, new Rect(0, 0, this.mWidth, this.mHeight), paint);
            }
            Frame frame2 = this.mPending;
            if (frame2 != null) {
                frame2.setFenceFd(-1);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void onLayout(boolean isChanged) {
        long j = this.nativeDrawLoop;
        if (j == 0 || !isChanged) {
            return;
        }
        Companion companion = INSTANCE;
        companion.Native_onDraw(j, false);
        NativeFrame nativeFrameNative_onDrawToScreen = companion.Native_onDrawToScreen(this.nativeDrawLoop, false);
        if (nativeFrameNative_onDrawToScreen == null) {
            return;
        }
        this.mPending = new Frame(nativeFrameNative_onDrawToScreen.getHardwareBuffer(), nativeFrameNative_onDrawToScreen.getFenceFd());
        requestInvalidate(0);
        companion.Native_onResume(this.nativeDrawLoop);
        companion.Native_onDraw(this.nativeDrawLoop, false);
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

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void setScreenSize(int width, int height) {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            this.mWidth = width;
            this.mHeight = height;
            INSTANCE.Native_setScreenSize(j, width, height);
            for (Map.Entry<HardwareBuffer, Bitmap> entry : this.mHwBitmapPool.entrySet()) {
                entry.getValue().recycle();
                entry.getKey().close();
            }
            this.mHwBitmapPool.clear();
            this.mPending = null;
        }
    }

    public /* synthetic */ SpenDrawLoopHwBuffer(View view, SpenRenderer spenRenderer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i & 2) != 0 ? null : spenRenderer);
    }
}
