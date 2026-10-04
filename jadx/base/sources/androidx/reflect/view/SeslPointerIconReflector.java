package androidx.reflect.view;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import com.samsung.android.spen.libse.SePointerIcon;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslPointerIconReflector {
    protected static String mClassName = "android.view.PointerIcon";

    private SeslPointerIconReflector() {
    }

    public static int getField_SEM_TYPE_STYLUS_DEFAULT() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_SEM_TYPE_STYLUS_DEFAULT", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "SEM_TYPE_STYLUS_DEFAULT");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 1;
    }

    public static int getField_SEM_TYPE_STYLUS_MORE() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_SEM_TYPE_STYLUS_MORE", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "SEM_TYPE_STYLUS_MORE");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        return objInvoke instanceof Integer ? ((Integer) objInvoke).intValue() : SePointerIcon.TYPE_STYLUS_MORE;
    }

    public static int getField_SEM_TYPE_STYLUS_PEN_SELECT() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_SEM_TYPE_STYLUS_PEN_SELECT", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "SEM_TYPE_STYLUS_PEN_SELECT");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 21;
    }

    public static int getField_SEM_TYPE_STYLUS_SCROLL_DOWN() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_SEM_TYPE_STYLUS_SCROLL_DOWN", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "SEM_TYPE_STYLUS_SCROLL_DOWN");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 15;
    }

    public static int getField_SEM_TYPE_STYLUS_SCROLL_LEFT() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_SEM_TYPE_STYLUS_SCROLL_LEFT", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "SEM_TYPE_STYLUS_SCROLL_LEFT");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 17;
    }

    public static int getField_SEM_TYPE_STYLUS_SCROLL_RIGHT() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_SEM_TYPE_STYLUS_SCROLL_RIGHT", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "SEM_TYPE_STYLUS_SCROLL_RIGHT");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 13;
    }

    public static int getField_SEM_TYPE_STYLUS_SCROLL_UP() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "hidden_SEM_TYPE_STYLUS_SCROLL_UP", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "SEM_TYPE_STYLUS_SCROLL_UP");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 11;
    }
}
