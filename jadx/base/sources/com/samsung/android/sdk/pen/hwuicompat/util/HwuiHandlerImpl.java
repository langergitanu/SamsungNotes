package com.samsung.android.sdk.pen.hwuicompat.util;

import android.graphics.Canvas;
import android.util.Log;
import com.samsung.android.sdk.pen.hwuicompat.util.SpenHwuiHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/util/HwuiHandlerImpl;", "Lcom/samsung/android/sdk/pen/hwuicompat/util/SpenHwuiHandler$SPenHwuiHandlerInterface;", "mNativeDrawGLFunctor", "", "<init>", "(J)V", "setGLDrawCallback", "", "canvas", "Landroid/graphics/Canvas;", "invoke", "waitForCompleting", "close", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class HwuiHandlerImpl implements SpenHwuiHandler.SPenHwuiHandlerInterface {

    @NotNull
    private static final String DRAW_FUNCTION = "callDrawGLFunction2";

    @NotNull
    private static final String HARDWARE_RENDERER = "android.graphics.HardwareRenderer";

    @NotNull
    private static final String INVOKE_FUNCTOR = "invokeFunctor";

    @NotNull
    private static final String RECORDING_CANVAS = "android.graphics.RecordingCanvas";

    @NotNull
    private static final String TAG = "HwuiHandlerImpl";

    @Nullable
    private static Method mCallDrawGLFunctionMethod;

    @Nullable
    private static Method mInvokeFunctor;
    private final long mNativeDrawGLFunctor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[] UNHIDED_PATHES = {"Landroid/graphics/RecordingCanvas", "Landroid/graphics/HardwareRenderer"};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/util/HwuiHandlerImpl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mCallDrawGLFunctionMethod", "Ljava/lang/reflect/Method;", "RECORDING_CANVAS", "DRAW_FUNCTION", "mInvokeFunctor", "HARDWARE_RENDERER", "INVOKE_FUNCTOR", "UNHIDED_PATHES", "", "[Ljava/lang/String;", "isHWUISupported", "", "()Z", "initHWUICallbackMethods", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initHWUICallbackMethods() {
            Log.i(HwuiHandlerImpl.TAG, "initHWUICallbackMethods");
            try {
                SpenHiddenAPI.unhide(HwuiHandlerImpl.UNHIDED_PATHES);
                Class<?> cls = Class.forName(HwuiHandlerImpl.RECORDING_CANVAS);
                Class cls2 = Long.TYPE;
                HwuiHandlerImpl.mCallDrawGLFunctionMethod = cls.getMethod(HwuiHandlerImpl.DRAW_FUNCTION, cls2);
                HwuiHandlerImpl.mInvokeFunctor = Class.forName(HwuiHandlerImpl.HARDWARE_RENDERER).getMethod(HwuiHandlerImpl.INVOKE_FUNCTOR, cls2, Boolean.TYPE);
                Log.i(HwuiHandlerImpl.TAG, "FINDED hwui: android.graphics.RecordingCanvas::callDrawGLFunction2");
            } catch (ClassNotFoundException e) {
                Log.e(HwuiHandlerImpl.TAG, "ClassNotFoundException: " + e.getMessage());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e(HwuiHandlerImpl.TAG, "NoSuchMethodException: " + e2.getMessage());
                e2.printStackTrace();
            } catch (SecurityException e3) {
                Log.e(HwuiHandlerImpl.TAG, "SecurityException: " + e3.getMessage());
                e3.printStackTrace();
            }
        }

        public final boolean isHWUISupported() {
            return (HwuiHandlerImpl.mInvokeFunctor == null || HwuiHandlerImpl.mCallDrawGLFunctionMethod == null) ? false : true;
        }

        private Companion() {
        }
    }

    public HwuiHandlerImpl(long j) {
        this.mNativeDrawGLFunctor = j;
        INSTANCE.initHWUICallbackMethods();
    }

    @Override // com.samsung.android.sdk.pen.hwuicompat.util.SpenHwuiHandler.SPenHwuiHandlerInterface
    public void close() {
        Log.d(TAG, "close");
    }

    @Override // com.samsung.android.sdk.pen.hwuicompat.util.SpenHwuiHandler.SPenHwuiHandlerInterface
    public boolean invoke(boolean waitForCompleting) {
        Log.i(TAG, "invoke(" + waitForCompleting + ")");
        try {
            Method method = mInvokeFunctor;
            if (method != null) {
                method.invoke(null, Long.valueOf(this.mNativeDrawGLFunctor), Boolean.valueOf(waitForCompleting));
                return true;
            }
            Log.e(TAG, "failed to Invoke hwuiFunctor mInvokeFunctor == null");
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Invalid reflection", e);
        }
    }

    @Override // com.samsung.android.sdk.pen.hwuicompat.util.SpenHwuiHandler.SPenHwuiHandlerInterface
    public boolean setGLDrawCallback(@Nullable Canvas canvas) {
        Method method = mCallDrawGLFunctionMethod;
        if (method == null) {
            Log.e(TAG, "mCallDrawGLFunctionMethod is null.");
            return false;
        }
        try {
            Intrinsics.checkNotNull(method);
            method.invoke(canvas, Long.valueOf(this.mNativeDrawGLFunctor));
            return true;
        } catch (Exception e) {
            Log.e(TAG, e + "on setGLDrawCallback");
            e.printStackTrace();
            return true;
        }
    }
}
