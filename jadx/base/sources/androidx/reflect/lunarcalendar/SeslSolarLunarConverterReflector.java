package androidx.reflect.lunarcalendar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import androidx.reflect.SeslPathClassReflector;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslSolarLunarConverterReflector {
    private static final String mClassName = "com.samsung.android.calendar.secfeature.lunarcalendar.SolarLunarConverter";

    private SeslSolarLunarConverterReflector() {
    }

    public static void convertLunarToSolar(PathClassLoader pathClassLoader, @NonNull Object obj, int i, int i2, int i4, boolean z) {
        Class cls = Integer.TYPE;
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "convertLunarToSolar", cls, cls, cls, Boolean.TYPE);
        if (method != null) {
            SeslBaseReflector.invoke(obj, method, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Boolean.valueOf(z));
        }
    }

    public static void convertSolarToLunar(PathClassLoader pathClassLoader, @NonNull Object obj, int i, int i2, int i4) {
        Class cls = Integer.TYPE;
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "convertSolarToLunar", cls, cls, cls);
        if (method != null) {
            SeslBaseReflector.invoke(obj, method, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        }
    }

    public static int getDay(PathClassLoader pathClassLoader, @NonNull Object obj) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getDay", new Class[0]);
        if (method == null) {
            return 19;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, new Object[0]);
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 19;
    }

    public static int getDayLengthOf(PathClassLoader pathClassLoader, @NonNull Object obj, int i, int i2, boolean z) {
        Class cls = Integer.TYPE;
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getDayLengthOf", cls, cls, Boolean.TYPE);
        if (method == null) {
            return 30;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 30;
    }

    public static int getMonth(PathClassLoader pathClassLoader, @NonNull Object obj) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getMonth", new Class[0]);
        if (method == null) {
            return 10;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, new Object[0]);
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 10;
    }

    public static int getWeekday(PathClassLoader pathClassLoader, @NonNull Object obj, int i, int i2, int i4) {
        Class cls = Integer.TYPE;
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getWeekday", cls, cls, cls);
        if (method == null) {
            return 0;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 0;
    }

    public static int getYear(PathClassLoader pathClassLoader, @NonNull Object obj) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getYear", new Class[0]);
        if (method == null) {
            return 2019;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, new Object[0]);
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 2019;
    }

    public static boolean isLeapMonth(PathClassLoader pathClassLoader, @NonNull Object obj) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "isLeapMonth", new Class[0]);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(obj, method, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }
}
