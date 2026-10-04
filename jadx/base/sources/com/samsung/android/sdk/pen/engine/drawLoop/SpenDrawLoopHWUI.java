package com.samsung.android.sdk.pen.engine.drawLoop;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.spensdk.framework.SPenRendererAdapter;
import com.samsung.android.spensdk.framework.SPenRendererAdapterInterface;
import com.samsung.android.spensdk.framework.SpenDrawCallback;
import com.samsung.android.spensdk.framework.SpenDrawGlInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0017J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001eH\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u0013H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u00063"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHWUI;", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopInterface;", "Lcom/samsung/android/spensdk/framework/SpenDrawCallback;", "mParent", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "nativeDrawLoop", "", "mThreadId", "mDestroy", "", "mRendererAdapter", "Lcom/samsung/android/spensdk/framework/SPenRendererAdapterInterface;", "checkMinVersion", "checkVersion", "", "minVersion", "init", "", "close", "onViewDetachedFromWindow", "postDestroyRendererAdapter", "onDraw", "canvas", "Landroid/graphics/Canvas;", "msgQueueHandle", "getMsgQueueHandle", "()J", "rendererType", "", "getRendererType", "()I", "setScreenSize", "width", "height", "onLayout", "isChanged", "onPause", "onResume", "invoke", "waitForCompleting", "requestInvalidate", "ms", "onProcessWithoutScreenUpdate", "onProcessWithNoContext", "onSync", "Landroid/graphics/RectF;", "info", "Lcom/samsung/android/spensdk/framework/SpenDrawGlInfo;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenDrawLoopHWUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenDrawLoopHWUI.kt\ncom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHWUI\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,254:1\n731#2,9:255\n731#2,9:266\n37#3,2:264\n37#3,2:275\n*S KotlinDebug\n*F\n+ 1 SpenDrawLoopHWUI.kt\ncom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHWUI\n*L\n34#1:255,9\n35#1:266,9\n34#1:264,2\n35#1:275,2\n*E\n"})
public final class SpenDrawLoopHWUI implements SpenDrawLoopInterface, SpenDrawCallback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String MIN_HWRENDERER_VERSION = "1.0.1";

    @NotNull
    private static final String TAG = "SpenDrawLoopHWUI";
    private boolean mDestroy;

    @Nullable
    private View mParent;

    @Nullable
    private SPenRendererAdapterInterface mRendererAdapter;
    private long mThreadId;
    private long nativeDrawLoop;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0007\u001a\u00020\bH\u0082 J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0083 J\u0011\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0083 J\u0011\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0083 J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\bH\u0083 J!\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0083 J\u0011\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0083 J\u0011\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0083 J\u0019\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0083 J\u0011\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0083 J\u0011\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0083 J\u0011\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHWUI$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MIN_HWRENDERER_VERSION", "Native_init", "", "Native_construct", "", "nativeDrawLoop", "drawLoop", "Lcom/samsung/android/sdk/pen/engine/drawLoop/SpenDrawLoopHWUI;", "Native_finalize", "", "Native_onDraw", "Native_getMsgQueue", "Native_getRendererType", "", "Native_setScreenSize", "width", "height", "Native_onPause", "Native_onResume", "Native_onDrawHwuiFunctor", "info", "Lcom/samsung/android/spensdk/framework/SpenDrawGlInfo;", "Native_onProcessWithoutScreenUpdate", "Native_onProcessWithNoContext", "Native_onSync", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeDrawLoop, SpenDrawLoopHWUI drawLoop) {
            return SpenDrawLoopHWUI.Native_construct(nativeDrawLoop, drawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeDrawLoop) {
            SpenDrawLoopHWUI.Native_finalize(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_getMsgQueue(long nativeDrawLoop) {
            return SpenDrawLoopHWUI.Native_getMsgQueue(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getRendererType(long nativeDrawLoop) {
            return SpenDrawLoopHWUI.Native_getRendererType(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final native long Native_init();

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDraw(long nativeDrawLoop) {
            SpenDrawLoopHWUI.Native_onDraw(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onDrawHwuiFunctor(long nativeDrawLoop, SpenDrawGlInfo info) {
            SpenDrawLoopHWUI.Native_onDrawHwuiFunctor(nativeDrawLoop, info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onPause(long nativeDrawLoop) {
            SpenDrawLoopHWUI.Native_onPause(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onProcessWithNoContext(long nativeDrawLoop) {
            SpenDrawLoopHWUI.Native_onProcessWithNoContext(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onProcessWithoutScreenUpdate(long nativeDrawLoop) {
            SpenDrawLoopHWUI.Native_onProcessWithoutScreenUpdate(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onResume(long nativeDrawLoop) {
            SpenDrawLoopHWUI.Native_onResume(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_onSync(long nativeDrawLoop) {
            SpenDrawLoopHWUI.Native_onSync(nativeDrawLoop);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setScreenSize(long nativeDrawLoop, int width, int height) {
            SpenDrawLoopHWUI.Native_setScreenSize(nativeDrawLoop, width, height);
        }

        private Companion() {
        }
    }

    public SpenDrawLoopHWUI(@Nullable View view) {
        this.mParent = view;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, SpenDrawLoopHWUI spenDrawLoopHWUI);

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
    public static final native void Native_onDraw(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_onDrawHwuiFunctor(long j, SpenDrawGlInfo spenDrawGlInfo);

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

    private final boolean checkMinVersion(String checkVersion, String minVersion) {
        List listEmptyList;
        List listEmptyList2;
        List listM13999t = AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, checkVersion);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        List listM13999t2 = AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, minVersion);
        if (listM13999t2.isEmpty()) {
            listEmptyList2 = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator2 = listM13999t2.listIterator(listM13999t2.size());
            while (listIterator2.hasPrevious()) {
                if (((String) listIterator2.previous()).length() != 0) {
                    listEmptyList2 = AbstractC12991c.m14000u(listIterator2, 1, listM13999t2);
                    break;
                }
            }
            listEmptyList2 = CollectionsKt.emptyList();
        }
        String[] strArr2 = (String[]) listEmptyList2.toArray(new String[0]);
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(strArr[i]) < Integer.parseInt(strArr2[i])) {
                Log.i(TAG, "checkMinVersion: false, found " + checkVersion + " needed " + minVersion);
                return false;
            }
        }
        Log.i(TAG, "checkMinVersion: true, found " + checkVersion + " needed " + minVersion);
        return true;
    }

    private final void init() {
        SPenRendererAdapterInterface sPenRendererAdapter;
        Companion companion = INSTANCE;
        this.nativeDrawLoop = companion.Native_init();
        this.mThreadId = Thread.currentThread().getId();
        if (SPenRendererAdapter.isSupported()) {
            Log.i(TAG, "Framework SPenRendererAdapter.isSupported(): true");
            String version = SPenRendererAdapter.getVersion();
            Intrinsics.checkNotNull(version);
            if (checkMinVersion(version, MIN_HWRENDERER_VERSION)) {
                sPenRendererAdapter = new SPenRendererAdapter(this);
            }
            this.mRendererAdapter = sPenRendererAdapter;
            companion.Native_construct(this.nativeDrawLoop, this);
        }
        Log.i(TAG, "Framework SPenRendererAdapter.isSupported(): false, using HwuiCompat");
        sPenRendererAdapter = new com.samsung.android.sdk.pen.hwuicompat.SPenRendererAdapter(this);
        this.mRendererAdapter = sPenRendererAdapter;
        companion.Native_construct(this.nativeDrawLoop, this);
    }

    private final boolean invoke(boolean waitForCompleting) {
        SPenRendererAdapterInterface sPenRendererAdapterInterface = this.mRendererAdapter;
        if (sPenRendererAdapterInterface != null) {
            return sPenRendererAdapterInterface.callOnProcess(waitForCompleting);
        }
        return false;
    }

    private final void postDestroyRendererAdapter() {
        new Handler(Looper.getMainLooper()).post(new RunnableC4617a(this, 13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postDestroyRendererAdapter$lambda$3(SpenDrawLoopHWUI spenDrawLoopHWUI) {
        SPenRendererAdapterInterface sPenRendererAdapterInterface = spenDrawLoopHWUI.mRendererAdapter;
        if (sPenRendererAdapterInterface != null) {
            sPenRendererAdapterInterface.close();
            spenDrawLoopHWUI.mRendererAdapter = null;
        }
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
        View view;
        if (this.nativeDrawLoop != 0) {
            this.mDestroy = true;
            SPenRendererAdapterInterface sPenRendererAdapterInterface = this.mRendererAdapter;
            if (sPenRendererAdapterInterface != null && !sPenRendererAdapterInterface.callOnProcess(true)) {
                INSTANCE.Native_finalize(this.nativeDrawLoop);
            }
            this.nativeDrawLoop = 0L;
        }
        if (this.mRendererAdapter != null && (view = this.mParent) != null && !view.isAttachedToWindow()) {
            postDestroyRendererAdapter();
        }
        this.mParent = null;
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
        SPenRendererAdapterInterface sPenRendererAdapterInterface = this.mRendererAdapter;
        if (sPenRendererAdapterInterface != null) {
            long j = this.nativeDrawLoop;
            if (j != 0) {
                INSTANCE.Native_onDraw(j);
            }
            sPenRendererAdapterInterface.callOnDraw(canvas);
        }
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

    @Override // com.samsung.android.spensdk.framework.SpenDrawCallback
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

    @Override // com.samsung.android.spensdk.framework.SpenDrawCallback
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

    @Override // com.samsung.android.spensdk.framework.SpenDrawCallback
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

    @Override // com.samsung.android.sdk.pen.engine.drawLoop.SpenDrawLoopInterface
    public void setScreenSize(int width, int height) {
        long j = this.nativeDrawLoop;
        if (j != 0) {
            INSTANCE.Native_setScreenSize(j, width, height);
        }
    }

    @Override // com.samsung.android.spensdk.framework.SpenDrawCallback
    @Nullable
    public RectF onDraw(@NotNull SpenDrawGlInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        long j = this.nativeDrawLoop;
        if (j == 0) {
            return null;
        }
        INSTANCE.Native_onDrawHwuiFunctor(j, info);
        return null;
    }
}
