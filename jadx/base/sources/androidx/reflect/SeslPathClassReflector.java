package androidx.reflect;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslPathClassReflector {
    private static final String TAG = "SeslPathClassReflector";

    private SeslPathClassReflector() {
    }

    @Nullable
    public static Class<?> getClass(@NonNull PathClassLoader pathClassLoader, @NonNull String str) {
        try {
            return Class.forName(str, true, pathClassLoader);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Fail to get class", e);
            return null;
        }
    }

    @Nullable
    public static Field getField(PathClassLoader pathClassLoader, @NonNull String str, @NonNull String str2) {
        Class<?> cls = getClass(pathClassLoader, str);
        if (cls != null) {
            try {
                return cls.getField(str2);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, str2 + " NoSuchMethodException", e);
            }
        }
        return null;
    }

    @Nullable
    public static Method getMethod(@NonNull PathClassLoader pathClassLoader, @NonNull String str, @NonNull String str2, Class<?>... clsArr) {
        Class<?> cls = getClass(pathClassLoader, str);
        if (cls != null) {
            try {
                return cls.getMethod(str2, clsArr);
            } catch (NoSuchMethodException e) {
                Log.e(TAG, str2 + " NoSuchMethodException", e);
            }
        }
        return null;
    }
}
