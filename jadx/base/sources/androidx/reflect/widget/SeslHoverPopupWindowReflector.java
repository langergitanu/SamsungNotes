package androidx.reflect.widget;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslHoverPopupWindowReflector {
    private static String mClassName = "com.samsung.android.widget.SemHoverPopupWindow";

    private SeslHoverPopupWindowReflector() {
    }

    public static int getField_TYPE_NONE() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_TYPE_NONE", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "TYPE_NONE");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 0;
    }

    public static int getField_TYPE_TOOLTIP() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_TYPE_TOOLTIP", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "TYPE_TOOLTIP");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 1;
    }

    public static int getField_TYPE_USER_CUSTOM() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_TYPE_USER_CUSTOM", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "TYPE_USER_CUSTOM");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 3;
    }

    public static void setGravity(@NonNull Object obj, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_setGravity", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClassName, "setGravity", (Class<?>[]) new Class[]{cls});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(obj, declaredMethod, Integer.valueOf(i));
        }
    }

    public static void setHoverDetectTime(@NonNull Object obj, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_setHoverDetectTime", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClassName, "setHoverDetectTime", (Class<?>[]) new Class[]{cls});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(obj, declaredMethod, Integer.valueOf(i));
        }
    }

    public static void setHoveringPoint(@NonNull Object obj, int i, int i2) {
        String str = mClassName;
        Class cls = Integer.TYPE;
        Method method = SeslBaseReflector.getMethod(str, "setHoveringPoint", (Class<?>[]) new Class[]{cls, cls});
        if (method != null) {
            SeslBaseReflector.invoke(obj, method, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void setOffset(@NonNull Object obj, int i, int i2) {
        int i4 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i4 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_setOffset", (Class<?>[]) new Class[]{cls, cls}) : SeslBaseReflector.getMethod(mClassName, "setOffset", (Class<?>[]) new Class[]{cls, cls});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(obj, declaredMethod, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void update(@NonNull Object obj) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_update", (Class<?>[]) new Class[0]) : SeslBaseReflector.getMethod(mClassName, Constants.ARG_UPDATE, (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(obj, declaredMethod, new Object[0]);
        }
    }
}
