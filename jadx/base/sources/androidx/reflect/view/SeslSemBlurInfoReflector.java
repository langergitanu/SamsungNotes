package androidx.reflect.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslSemBlurInfoReflector {
    private static final String TAG = "SeslSemBlurInfoRftr";
    private static final String mBuilderClass = "android.view.SemBlurInfo$Builder";

    private SeslSemBlurInfoReflector() {
    }

    public static void semBuildSetBlurInfo(Object obj, @NonNull View view) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 31 ? SeslBaseReflector.getDeclaredMethod(mBuilderClass, "hidden_build", (Class<?>[]) new Class[0]) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            SeslViewReflector.semSetBlurInfo(view, SeslBaseReflector.invoke(obj, declaredMethod, new Object[0]));
        }
    }

    public static Object semCreateBlurBuilder(int i) {
        Constructor<?> constructor = SeslBaseReflector.getConstructor(mBuilderClass, Integer.TYPE);
        if (Build.VERSION.SDK_INT < 31 || constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            Log.e(TAG, "semCreateBlurBuilder IllegalAccessException", e);
            return null;
        } catch (InstantiationException e2) {
            Log.e(TAG, "semCreateBlurBuilder InstantiationException", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e(TAG, "semCreateBlurBuilder InvocationTargetException", e3);
            return null;
        }
    }

    public static Object semSetBuilderBlurBackgroundColor(Object obj, int i) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 31 ? SeslBaseReflector.getDeclaredMethod(mBuilderClass, "hidden_setBackgroundColor", (Class<?>[]) new Class[]{Integer.TYPE}) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            SeslBaseReflector.invoke(obj, declaredMethod, Integer.valueOf(i));
        }
        return obj;
    }

    public static Object semSetBuilderBlurBackgroundCornerRadius(Object obj, float f) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 31 ? SeslBaseReflector.getDeclaredMethod(mBuilderClass, "hidden_setBackgroundCornerRadius", (Class<?>[]) new Class[]{Float.TYPE}) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            SeslBaseReflector.invoke(obj, declaredMethod, Float.valueOf(f));
        }
        return obj;
    }

    public static Object semSetBuilderBlurRadius(Object obj, int i) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 35 ? SeslBaseReflector.getDeclaredMethod(mBuilderClass, "hidden_setRadius", (Class<?>[]) new Class[]{Integer.TYPE}) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            SeslBaseReflector.invoke(obj, declaredMethod, Integer.valueOf(i));
        }
        return obj;
    }

    public static Object semSetBuilderColorCurvePreset(Object obj, int i) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 31 ? SeslBaseReflector.getDeclaredMethod(mBuilderClass, "setColorCurvePreset", (Class<?>[]) new Class[]{Integer.TYPE}) : null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            SeslBaseReflector.invoke(obj, declaredMethod, Integer.valueOf(i));
        }
        return obj;
    }

    public static Object semSetColorCurve(Object obj, float f, float f4, float f5, float f6, float f7, float f8) {
        Method declaredMethod;
        if (Build.VERSION.SDK_INT >= 35) {
            Class cls = Float.TYPE;
            declaredMethod = SeslBaseReflector.getDeclaredMethod(mBuilderClass, "setColorCurve", (Class<?>[]) new Class[]{cls, cls, cls, cls, cls, cls});
        } else {
            declaredMethod = null;
        }
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            SeslBaseReflector.invoke(obj, declaredMethod, Float.valueOf(f), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8));
        }
        return obj;
    }
}
