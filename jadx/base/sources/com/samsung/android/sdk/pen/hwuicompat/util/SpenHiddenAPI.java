package com.samsung.android.sdk.pen.hwuicompat.util;

import android.os.Build;
import android.util.Log;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\fH\u0007¢\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\f\"\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/util/SpenHiddenAPI;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sVmRuntime", "setHiddenApiExemptions", "Ljava/lang/reflect/Method;", "unhide", "", MarketingConstants.INTENT_CLASS, "", "([Ljava/lang/String;)V", "exempt", "", "methods", "([Ljava/lang/String;)Z", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHiddenAPI {

    @NotNull
    public static final SpenHiddenAPI INSTANCE = new SpenHiddenAPI();

    @NotNull
    private static final String TAG = "SpenHiddenAPI";

    @Nullable
    private static Object sVmRuntime;

    @Nullable
    private static Method setHiddenApiExemptions;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Object[].class);
            Object objInvoke = declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
            Class cls = (Class) objInvoke;
            Object objInvoke2 = declaredMethod2.invoke(cls, "getRuntime", null);
            Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type java.lang.reflect.Method");
            Object objInvoke3 = declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            Intrinsics.checkNotNull(objInvoke3, "null cannot be cast to non-null type java.lang.reflect.Method");
            setHiddenApiExemptions = (Method) objInvoke3;
            sVmRuntime = ((Method) objInvoke2).invoke(null, null);
        } catch (Throwable th) {
            Log.e(TAG, "reflect failed:", th);
        }
    }

    private SpenHiddenAPI() {
    }

    private final boolean exempt(String... methods) {
        Method method;
        if (sVmRuntime != null && (method = setHiddenApiExemptions) != null) {
            try {
                Intrinsics.checkNotNull(method);
                method.invoke(sVmRuntime, methods);
                return true;
            } catch (Throwable th) {
                Log.e(TAG, th.getMessage() + " is failed");
            }
        }
        return false;
    }

    @JvmStatic
    public static final void unhide(@NotNull String[] cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        if (Build.VERSION.SDK_INT < 28) {
            Log.i(TAG, "below P, ignore");
        } else if (INSTANCE.exempt((String[]) Arrays.copyOf(cls, cls.length))) {
            Log.i(TAG, "unhide is ok");
        } else {
            Log.e(TAG, "unhide is failed");
        }
    }
}
