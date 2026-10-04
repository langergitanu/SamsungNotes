package androidx.reflect.feature;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslFloatingFeatureReflector {
    private static String mClassName;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            mClassName = "com.samsung.sesl.feature.SemFloatingFeature";
        } else {
            mClassName = "com.samsung.android.feature.SemFloatingFeature";
        }
    }

    private SeslFloatingFeatureReflector() {
    }

    private static Object getInstance() {
        Object objInvoke;
        Method method = SeslBaseReflector.getMethod(mClassName, "getInstance", (Class<?>[]) new Class[0]);
        if (method == null || (objInvoke = SeslBaseReflector.invoke(null, method, new Object[0])) == null || !objInvoke.getClass().getName().equals(mClassName)) {
            return null;
        }
        return objInvoke;
    }

    @Nullable
    public static String getString(@NonNull String str, @Nullable String str2) {
        Method method;
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_getString", (Class<?>[]) new Class[]{String.class, String.class});
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, str, str2);
            }
        } else {
            Object seslFloatingFeatureReflector = getInstance();
            if (seslFloatingFeatureReflector != null && (method = SeslBaseReflector.getMethod(mClassName, "getString", (Class<?>[]) new Class[]{String.class, String.class})) != null) {
                objInvoke = SeslBaseReflector.invoke(seslFloatingFeatureReflector, method, str, str2);
            }
        }
        return objInvoke instanceof String ? (String) objInvoke : str2;
    }
}
