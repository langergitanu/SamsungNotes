package androidx.reflect.p112os;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslSystemPropertiesReflector {
    private static String mClassName = "android.os.SemSystemProperties";

    private SeslSystemPropertiesReflector() {
    }

    public static String getSalesCode() {
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mClassName, "getSalesCode", (Class<?>[]) new Class[0]) : SeslBaseReflector.getMethod(mClassName, "getSalesCode", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            Object objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        }
        return null;
    }

    public static String getStringProperties(String str) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mClassName, "get", (Class<?>[]) new Class[]{String.class}) : SeslBaseReflector.getMethod(mClassName, "get", (Class<?>[]) new Class[]{String.class});
        if (declaredMethod != null) {
            Object objInvoke = SeslBaseReflector.invoke(null, declaredMethod, str);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        }
        return null;
    }
}
