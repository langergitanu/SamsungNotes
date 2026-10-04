package androidx.reflect;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslBaseReflector {
    private static final String TAG = "SeslBaseReflector";

    private SeslBaseReflector() {
    }

    public static Object get(Object obj, @NonNull Field field) {
        if (field == null) {
            Log.e(TAG, "field is null");
            return null;
        }
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            Log.e(TAG, field.getName() + " IllegalAccessException", e);
            return null;
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, field.getName() + " IllegalArgumentException", e2);
            return null;
        }
    }

    @Nullable
    public static Class<?> getClass(@NonNull String str) {
        if (str == null) {
            AbstractC2322a.m1609C("className = ", str, TAG);
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            Log.w(TAG, "Fail to get class = ".concat(str));
            return null;
        }
    }

    public static Constructor<?> getConstructor(String str, Class<?>... clsArr) {
        if (str == null) {
            AbstractC2322a.m1609C("className = ", str, TAG);
            return null;
        }
        try {
            return Class.forName(str).getDeclaredConstructor(clsArr);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e(TAG, "failed to get reflection - " + e);
            return null;
        }
    }

    public static Field getDeclaredField(@NonNull String str, @NonNull String str2) {
        Field declaredField = null;
        if (str == null || str2 == null) {
            Log.d(TAG, "className = " + str + ", fieldName = " + str2);
            return null;
        }
        Class<?> cls = getClass(str);
        if (cls != null) {
            try {
                declaredField = cls.getDeclaredField(str2);
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                Log.w(TAG, "Reflector did not find field = ".concat(str2));
            }
        }
        return declaredField;
    }

    public static Method getDeclaredMethod(@NonNull String str, @NonNull String str2, Class<?>... clsArr) {
        Method declaredMethod = null;
        if (str == null || str2 == null) {
            Log.d(TAG, "className = " + str + ", methodName = " + str2);
            return null;
        }
        Class<?> cls = getClass(str);
        if (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str2, clsArr);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                Log.w(TAG, "Reflector did not find method = ".concat(str2));
            }
        }
        return declaredMethod;
    }

    public static Field getField(@NonNull String str, @NonNull String str2) {
        if (str != null && str2 != null) {
            Class<?> cls = getClass(str);
            if (cls != null) {
                try {
                    return cls.getField(str2);
                } catch (NoSuchFieldException unused) {
                    Log.w(TAG, "Reflector did not find field = ".concat(str2));
                }
            }
            return null;
        }
        Log.d(TAG, "className = " + str + ", fieldName = " + str2);
        return null;
    }

    public static Method getMethod(@NonNull String str, @NonNull String str2, Class<?>... clsArr) {
        if (str != null && str2 != null) {
            Class<?> cls = getClass(str);
            if (cls != null) {
                try {
                    return cls.getMethod(str2, clsArr);
                } catch (NoSuchMethodException unused) {
                    Log.w(TAG, "Reflector did not find method = ".concat(str2));
                }
            }
            return null;
        }
        Log.d(TAG, "className = " + str + ", methodName = " + str2);
        return null;
    }

    public static Object invoke(Object obj, @NonNull Method method, Object... objArr) {
        if (method == null) {
            Log.d(TAG, "method is null");
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Log.e(TAG, method.getName() + " IllegalAccessException", e);
            return null;
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, method.getName() + " IllegalArgumentException", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e(TAG, method.getName() + " InvocationTargetException", e3);
            return null;
        }
    }

    public static void set(Object obj, @NonNull Field field, Object obj2) {
        if (field == null) {
            Log.e(TAG, "field is null");
            return;
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            Log.e(TAG, field.getName() + " IllegalAccessException", e);
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, field.getName() + " IllegalArgumentException", e2);
        }
    }

    public static <T> Field getField(@NonNull Class<T> cls, @NonNull String str) {
        if (cls != null && str != null) {
            try {
                return cls.getField(str);
            } catch (NoSuchFieldException unused) {
                Log.w(TAG, "Reflector did not find field = ".concat(str));
                return null;
            }
        }
        Log.d(TAG, "classT = " + cls + ", fieldName = " + str);
        return null;
    }

    public static <T> Method getMethod(@NonNull Class<T> cls, @NonNull String str, Class<?>... clsArr) {
        if (cls != null && str != null) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                Log.w(TAG, "Reflector did not find method = ".concat(str));
                return null;
            }
        }
        Log.d(TAG, "classT = " + cls + ", methodName = " + str);
        return null;
    }

    public static <T> Field getDeclaredField(@NonNull Class<T> cls, @NonNull String str) {
        Field declaredField = null;
        if (cls != null && str != null) {
            try {
                declaredField = cls.getDeclaredField(str);
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                Log.w(TAG, "Reflector did not find field = ".concat(str));
                return declaredField;
            }
        }
        Log.d(TAG, "classT = " + cls + ", fieldName = " + str);
        return null;
    }

    public static <T> Method getDeclaredMethod(@NonNull Class<T> cls, @NonNull String str, Class<?>... clsArr) {
        Method declaredMethod = null;
        if (cls != null && str != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                Log.w(TAG, "Reflector did not find method = ".concat(str));
                return declaredMethod;
            }
        }
        Log.d(TAG, "classT = " + cls + ", methodName = " + str);
        return null;
    }
}
