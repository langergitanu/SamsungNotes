package androidx.reflect.lunarcalendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class SeslFeatureReflector {
    private static final String mClassName = "com.android.calendar.Feature";

    private SeslFeatureReflector() {
    }

    @Nullable
    public static Object getSolarLunarConverter(@NonNull PathClassLoader pathClassLoader) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getSolarLunarConverter", new Class[0]);
        if (method != null) {
            return SeslBaseReflector.invoke(null, method, new Object[0]);
        }
        return null;
    }

    @Nullable
    public static Object getSolarLunarTables(@NonNull PathClassLoader pathClassLoader) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getSolarLunarTables", new Class[0]);
        if (method != null) {
            return SeslBaseReflector.invoke(null, method, new Object[0]);
        }
        return null;
    }
}
