package androidx.reflect.content.res;

import android.content.res.Configuration;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslConfigurationReflector {
    private static final String TAG = "SeslConfigurationReflector";
    private static final Class<?> mClass = Configuration.class;

    private SeslConfigurationReflector() {
    }

    private static int getField_SEM_DESKTOP_MODE_ENABLED() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_SEM_DESKTOP_MODE_ENABLED", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "SEM_DESKTOP_MODE_ENABLED");
            if (declaredField != null) {
                objInvoke = SeslBaseReflector.get(null, declaredField);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 0;
    }

    @Nullable
    public static Integer getField_SEM_DISPLAY_DEVICE_TYPE_MAIN() {
        Field field = SeslBaseReflector.getField(mClass.getName(), "SEM_DISPLAY_DEVICE_TYPE_MAIN");
        Object obj = field != null ? SeslBaseReflector.get(null, field) : null;
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    @Nullable
    public static Integer getField_SEM_DISPLAY_DEVICE_TYPE_SUB() {
        Field field = SeslBaseReflector.getField(mClass.getName(), "SEM_DISPLAY_DEVICE_TYPE_SUB");
        Object obj = field != null ? SeslBaseReflector.get(null, field) : null;
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    private static int getField_semDesktopModeEnabled(@NonNull Configuration configuration) {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semDesktopModeEnabled", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(configuration, declaredMethod, new Object[0]);
            }
        } else {
            Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "semDesktopModeEnabled");
            if (declaredField != null) {
                objInvoke = SeslBaseReflector.get(configuration, declaredField);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return -1;
    }

    @Nullable
    public static Integer getField_semDisplayDeviceType(@NonNull Configuration configuration) {
        Field field = SeslBaseReflector.getField(mClass.getName(), "semDisplayDeviceType");
        Object obj = field != null ? SeslBaseReflector.get(configuration, field) : null;
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Object getField_semIsPopOver(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT < 31) {
            return Boolean.FALSE;
        }
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "semIsPopOver", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            return SeslBaseReflector.invoke(configuration, declaredMethod, new Object[0]);
        }
        return null;
    }

    public static boolean isDexEnabled(@NonNull Configuration configuration) {
        return getField_semDesktopModeEnabled(configuration) == getField_SEM_DESKTOP_MODE_ENABLED();
    }
}
