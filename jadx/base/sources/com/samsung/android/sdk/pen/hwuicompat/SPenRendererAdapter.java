package com.samsung.android.sdk.pen.hwuicompat;

import android.graphics.Canvas;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.pen.hwuicompat.util.SpenHwuiHandler;
import com.samsung.android.spensdk.framework.SPenRendererAdapterInterface;
import com.samsung.android.spensdk.framework.SpenDrawCallback;
import com.samsung.android.spensdk.framework.SpenDrawGlInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/SPenRendererAdapter;", "Lcom/samsung/android/spensdk/framework/SPenRendererAdapterInterface;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/spensdk/framework/SpenDrawCallback;", "<init>", "(Lcom/samsung/android/spensdk/framework/SpenDrawCallback;)V", "mCallback", "mNativeHwuiFunctor", "", "mHwuiHandler", "Lcom/samsung/android/sdk/pen/hwuicompat/util/SpenHwuiHandler$SPenHwuiHandlerInterface;", "close", "", "callOnDraw", "", "canvas", "Landroid/graphics/Canvas;", "callOnProcess", "wait", "onDraw", "info", "Lcom/samsung/android/spensdk/framework/SpenDrawGlInfo;", "onProcessWithoutScreenUpdate", "onProcessWithNoContext", "onSync", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SPenRendererAdapter implements SPenRendererAdapterInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String version = "1.0.0";

    @Nullable
    private SpenDrawCallback mCallback;

    @Nullable
    private SpenHwuiHandler.SPenHwuiHandlerInterface mHwuiHandler;
    private long mNativeHwuiFunctor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0083 J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/SPenRendererAdapter$Companion;", "", "<init>", "()V", "version", "", "isSupported", "", "()Z", "loadLibrary", "libraryName", "Native_CreateNativeFunctor", "", "javaAdapterObject", "Lcom/samsung/android/sdk/pen/hwuicompat/SPenRendererAdapter;", "Native_DestroyNativeFunctor", "", "nativeFunctor", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_CreateNativeFunctor(SPenRendererAdapter javaAdapterObject) {
            return SPenRendererAdapter.Native_CreateNativeFunctor(javaAdapterObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_DestroyNativeFunctor(long nativeFunctor) {
            SPenRendererAdapter.Native_DestroyNativeFunctor(nativeFunctor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean loadLibrary(String libraryName) {
            try {
                System.loadLibrary(libraryName);
                return true;
            } catch (SecurityException e) {
                e.printStackTrace();
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            }
        }

        public final boolean isSupported() {
            return SpenHwuiHandler.isHWUISupported();
        }

        private Companion() {
        }
    }

    public SPenRendererAdapter(@Nullable SpenDrawCallback spenDrawCallback) {
        Companion companion = INSTANCE;
        companion.loadLibrary("SPenHwuiCompat");
        this.mCallback = spenDrawCallback;
        long jNative_CreateNativeFunctor = companion.Native_CreateNativeFunctor(this);
        this.mNativeHwuiFunctor = jNative_CreateNativeFunctor;
        this.mHwuiHandler = SpenHwuiHandler.create(jNative_CreateNativeFunctor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_CreateNativeFunctor(SPenRendererAdapter sPenRendererAdapter);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_DestroyNativeFunctor(long j);

    private final void onDraw(SpenDrawGlInfo info) {
        SpenDrawCallback spenDrawCallback = this.mCallback;
        if (spenDrawCallback != null) {
            spenDrawCallback.onDraw(info);
        }
    }

    private final void onProcessWithNoContext() {
        SpenDrawCallback spenDrawCallback = this.mCallback;
        if (spenDrawCallback != null) {
            spenDrawCallback.onProcessWithoutScreenUpdate();
        }
    }

    private final void onProcessWithoutScreenUpdate() {
        SpenDrawCallback spenDrawCallback = this.mCallback;
        if (spenDrawCallback != null) {
            spenDrawCallback.onProcessWithoutScreenUpdate();
        }
    }

    private final void onSync() {
        SpenDrawCallback spenDrawCallback = this.mCallback;
        if (spenDrawCallback != null) {
            spenDrawCallback.onSync();
        }
    }

    @Override // com.samsung.android.spensdk.framework.SPenRendererAdapterInterface
    public boolean callOnDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        SpenHwuiHandler.SPenHwuiHandlerInterface sPenHwuiHandlerInterface = this.mHwuiHandler;
        if (sPenHwuiHandlerInterface != null) {
            return sPenHwuiHandlerInterface.setGLDrawCallback(canvas);
        }
        return false;
    }

    @Override // com.samsung.android.spensdk.framework.SPenRendererAdapterInterface
    public boolean callOnProcess(boolean wait) {
        SpenHwuiHandler.SPenHwuiHandlerInterface sPenHwuiHandlerInterface = this.mHwuiHandler;
        if (sPenHwuiHandlerInterface != null) {
            return sPenHwuiHandlerInterface.invoke(wait);
        }
        return false;
    }

    @Override // com.samsung.android.spensdk.framework.SPenRendererAdapterInterface
    public void close() {
        long j = this.mNativeHwuiFunctor;
        if (j != 0) {
            INSTANCE.Native_DestroyNativeFunctor(j);
        }
    }
}
