package com.samsung.android.sdk.pen.hwuicompat.util;

import android.graphics.Canvas;
import android.util.Log;
import com.samsung.android.sdk.pen.hwuicompat.util.SpenHwuiHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/util/HwuiHandlerCompatApi21_28;", "Lcom/samsung/android/sdk/pen/hwuicompat/util/SpenHwuiHandler$SPenHwuiHandlerInterface;", "nativeDrawGLFunctor", "", "<init>", "(J)V", "mNativeDrawGLFunctor", "mViewRootImpl", "", "setGLDrawCallback", "", "canvas", "Landroid/graphics/Canvas;", "canInvoke", "invoke", "waitForCompleting", "createInvoke", "", "close", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class HwuiHandlerCompatApi21_28 implements SpenHwuiHandler.SPenHwuiHandlerInterface {

    @NotNull
    private static final String TAG = "HwuiCompatApi21_28";

    @NotNull
    private static final String VIEW_ROOT_IMPL_CLASS = "android.view.ViewRootImpl";

    @NotNull
    private static final String WINDOW_MANAGER_GLOBAL_CLASS = "android.view.WindowManagerGlobal";

    @Nullable
    private static Method mCallDrawGLFunctionMethod;

    @Nullable
    private static Method mInvokeFunctor;
    private long mNativeDrawGLFunctor;

    @Nullable
    private Object mViewRootImpl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[][] mReflectionMap = {new String[]{"android.view.DisplayListCanvas", "callDrawGLFunction2"}, new String[]{"android.view.GLES20Canvas", "callDrawGLFunction"}, new String[]{"android.view.GLES20Canvas", "callDrawGLFunction2"}};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/util/HwuiHandlerCompatApi21_28$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mCallDrawGLFunctionMethod", "Ljava/lang/reflect/Method;", "VIEW_ROOT_IMPL_CLASS", "WINDOW_MANAGER_GLOBAL_CLASS", "mInvokeFunctor", "mReflectionMap", "", "[[Ljava/lang/String;", "findHWUICallbackMethods", "", "canvasImplClass", "drawGLMethodName", "isHWUISupported", "()Z", "initHWUICallbackMethods", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean findHWUICallbackMethods(String canvasImplClass, String drawGLMethodName) {
            try {
                Class<?> cls = Class.forName(canvasImplClass);
                Class cls2 = Long.TYPE;
                HwuiHandlerCompatApi21_28.mCallDrawGLFunctionMethod = cls.getMethod(drawGLMethodName, cls2);
                HwuiHandlerCompatApi21_28.mInvokeFunctor = Class.forName(HwuiHandlerCompatApi21_28.VIEW_ROOT_IMPL_CLASS).getMethod("invokeFunctor", cls2, Boolean.TYPE);
            } catch (ClassNotFoundException e) {
                Log.e(HwuiHandlerCompatApi21_28.TAG, "ClassNotFoundException; couldn't find class: " + canvasImplClass);
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e(HwuiHandlerCompatApi21_28.TAG, "NoSuchMethodException; in " + canvasImplClass + "there is no method: " + drawGLMethodName);
                e2.printStackTrace();
            }
            return HwuiHandlerCompatApi21_28.mCallDrawGLFunctionMethod != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initHWUICallbackMethods() {
            for (String[] strArr : HwuiHandlerCompatApi21_28.mReflectionMap) {
                Log.d(HwuiHandlerCompatApi21_28.TAG, "hwui check: " + strArr[0] + "::" + strArr[1]);
                if (findHWUICallbackMethods(strArr[0], strArr[1])) {
                    Log.i(HwuiHandlerCompatApi21_28.TAG, "FINDED hwui: " + strArr[0] + "::" + strArr[1]);
                    return;
                }
            }
        }

        public final boolean isHWUISupported() {
            return (HwuiHandlerCompatApi21_28.mInvokeFunctor == null || HwuiHandlerCompatApi21_28.mCallDrawGLFunctionMethod == null) ? false : true;
        }

        private Companion() {
        }
    }

    public HwuiHandlerCompatApi21_28(long j) {
        this.mNativeDrawGLFunctor = j;
        createInvoke();
        INSTANCE.initHWUICallbackMethods();
    }

    private final boolean canInvoke() {
        if (this.mViewRootImpl == null) {
            createInvoke();
        }
        return this.mViewRootImpl != null;
    }

    private final void createInvoke() {
        Log.i(TAG, "createInvoke()");
        try {
            Class<?> cls = Class.forName(WINDOW_MANAGER_GLOBAL_CLASS);
            Method method = cls.getMethod("getInstance", null);
            Field declaredField = cls.getDeclaredField("mRoots");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(method.invoke(null, null));
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>");
            ArrayList arrayList = (ArrayList) obj;
            if (!arrayList.isEmpty()) {
                this.mViewRootImpl = arrayList.get(0);
            }
            if (this.mViewRootImpl == null) {
                Log.w(TAG, "ViewRootImpl is not initialized yet. Calls to invoke() before first draw is dangerous!!!.");
            }
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "createInvoke - ClassNotFoundException");
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "createInvoke - IllegalAccessException");
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            Log.e(TAG, "createInvoke - NoSuchFieldException");
            e3.printStackTrace();
        } catch (NoSuchMethodException e5) {
            Log.e(TAG, "createInvoke - NoSuchMethodException");
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            Log.e(TAG, "createInvoke - InvocationTargetException");
            e6.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.pen.hwuicompat.util.SpenHwuiHandler.SPenHwuiHandlerInterface
    public void close() {
        Log.d(TAG, "close");
        if (this.mViewRootImpl != null) {
            this.mViewRootImpl = null;
        }
    }

    @Override // com.samsung.android.sdk.pen.hwuicompat.util.SpenHwuiHandler.SPenHwuiHandlerInterface
    public boolean invoke(boolean waitForCompleting) {
        Log.i(TAG, "invoke(" + waitForCompleting + ")");
        try {
            if (!canInvoke()) {
                Log.e(TAG, "failed to Invoke hwuiFunctor: viewRootImpl == null");
                return false;
            }
            Method method = mInvokeFunctor;
            if (method != null) {
                method.invoke(this.mViewRootImpl, Long.valueOf(this.mNativeDrawGLFunctor), Boolean.valueOf(waitForCompleting));
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
        if (method != null) {
            try {
                method.invoke(canvas, Long.valueOf(this.mNativeDrawGLFunctor));
            } catch (Exception e) {
                Log.e(TAG, e + "on setGLDrawCallback");
            }
        }
        if (this.mViewRootImpl != null) {
            return true;
        }
        Log.d(TAG, "mViewRootImpl = null. Force to initialize mViewRootImpl");
        if (canInvoke()) {
            return true;
        }
        Log.e(TAG, "Something wrong. ViewRootImpl should be already accessible");
        return true;
    }
}
