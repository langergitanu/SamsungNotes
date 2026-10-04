package androidx.reflect.widget;

import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SeslTextViewReflector {
    private static final Class<?> mClass = TextView.class;

    private SeslTextViewReflector() {
    }

    public static int getField_SEM_AUTOFILL_ID() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_SEM_AUTOFILL_ID", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "SEM_AUTOFILL_ID");
            if (declaredField != null) {
                objInvoke = SeslBaseReflector.get(null, declaredField);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 0;
    }

    public static boolean getField_mSingleLine(@NonNull TextView textView) {
        Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mSingleLine");
        if (declaredField == null) {
            return false;
        }
        Object obj = SeslBaseReflector.get(textView, declaredField);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static boolean semIsTextSelectionProgressing() {
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semIsTextSelectionProgressing", (Class<?>[]) new Class[0]) : SeslBaseReflector.getMethod(mClass, "semIsTextSelectionProgressing", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            Object objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }

    public static boolean semIsTextViewHovered() {
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semIsTextViewHovered", (Class<?>[]) new Class[0]) : SeslBaseReflector.getMethod(mClass, "semIsTextViewHovered", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            Object objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }

    public static void semSetActionModeMenuItemEnabled(@NonNull TextView textView, int i, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        Class cls2 = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semSetActionModeMenuItemEnabled", (Class<?>[]) new Class[]{cls2, cls}) : SeslBaseReflector.getMethod(mClass, "semSetActionModeMenuItemEnabled", (Class<?>[]) new Class[]{cls2, cls});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(textView, declaredMethod, Integer.valueOf(i), Boolean.valueOf(z));
        }
    }

    public static void semSetButtonShapeEnabled(@NonNull TextView textView, boolean z) {
        int i = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        Method declaredMethod = i >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semSetButtonShapeEnabled", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClass, "semSetButtonShapeEnabled", (Class<?>[]) new Class[]{cls});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(textView, declaredMethod, Boolean.valueOf(z));
        }
    }

    public static void setLocalePreferredLineHeightForMinimumUsed(@NonNull TextView textView, boolean z) {
        Method method = SeslBaseReflector.getMethod(mClass, "setLocalePreferredLineHeightForMinimumUsed", (Class<?>[]) new Class[]{Boolean.TYPE});
        if (method != null) {
            SeslBaseReflector.invoke(textView, method, Boolean.valueOf(z));
        }
    }

    public static void semSetButtonShapeEnabled(@NonNull TextView textView, boolean z, int i) {
        Method method;
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Class cls2 = Boolean.TYPE;
        if (i2 >= 29) {
            method = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semSetButtonShapeEnabled", (Class<?>[]) new Class[]{cls2, cls});
        } else {
            method = SeslBaseReflector.getMethod(mClass, "semSetButtonShapeEnabled", (Class<?>[]) new Class[]{cls2, cls});
        }
        if (method != null) {
            SeslBaseReflector.invoke(textView, method, Boolean.valueOf(z), Integer.valueOf(i));
        }
    }
}
