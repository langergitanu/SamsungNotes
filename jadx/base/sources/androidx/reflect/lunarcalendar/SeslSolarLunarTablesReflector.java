package androidx.reflect.lunarcalendar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import androidx.reflect.SeslPathClassReflector;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslSolarLunarTablesReflector {
    private static final String mClassName = "com.samsung.android.calendar.secfeature.lunarcalendar.SolarLunarTables";

    private SeslSolarLunarTablesReflector() {
    }

    public static int getDayLengthOf(@NonNull PathClassLoader pathClassLoader, @NonNull Object obj, int i, int i2, boolean z) {
        Class cls = Integer.TYPE;
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getDayLengthOf", cls, cls, Boolean.TYPE);
        if (method == null) {
            return 29;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 29;
    }

    public static int getField_INDEX_OF_LEAP_MONTH(@NonNull PathClassLoader pathClassLoader, @NonNull Object obj) {
        Field field = SeslPathClassReflector.getField(pathClassLoader, mClassName, "INDEX_OF_LEAP_MONTH");
        if (field == null) {
            return 13;
        }
        Object obj2 = SeslBaseReflector.get(obj, field);
        if (obj2 instanceof Integer) {
            return ((Integer) obj2).intValue();
        }
        return 13;
    }

    public static int getField_START_OF_LUNAR_YEAR(@NonNull PathClassLoader pathClassLoader, @NonNull Object obj) {
        Field field = SeslPathClassReflector.getField(pathClassLoader, mClassName, "START_OF_LUNAR_YEAR");
        if (field == null) {
            return 1881;
        }
        Object obj2 = SeslBaseReflector.get(obj, field);
        if (obj2 instanceof Integer) {
            return ((Integer) obj2).intValue();
        }
        return 1881;
    }

    public static int getField_WIDTH_PER_YEAR(@NonNull PathClassLoader pathClassLoader, @NonNull Object obj) {
        Field field = SeslPathClassReflector.getField(pathClassLoader, mClassName, "WIDTH_PER_YEAR");
        if (field == null) {
            return 14;
        }
        Object obj2 = SeslBaseReflector.get(obj, field);
        if (obj2 instanceof Integer) {
            return ((Integer) obj2).intValue();
        }
        return 14;
    }

    public static byte getLunar(@NonNull PathClassLoader pathClassLoader, @NonNull Object obj, int i) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getLunar", Integer.TYPE);
        if (method == null) {
            return (byte) 127;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, Integer.valueOf(i));
        if (objInvoke instanceof Byte) {
            return ((Byte) objInvoke).byteValue();
        }
        return (byte) 127;
    }

    public static boolean isLeapMonth(@NonNull PathClassLoader pathClassLoader, @NonNull Object obj, int i, int i2) {
        Class cls = Integer.TYPE;
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "isLeapMonth", cls, cls);
        if (method == null) {
            return false;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, Integer.valueOf(i), Integer.valueOf(i2));
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }
}
