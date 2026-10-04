package androidx.reflect.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslStateListDrawableReflector {
    private static final Class<?> mClass = StateListDrawable.class;

    private SeslStateListDrawableReflector() {
    }

    public static int getStateCount(@NonNull StateListDrawable stateListDrawable) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_getStateCount", (Class<?>[]) new Class[0]) : SeslBaseReflector.getMethod(mClass, "getStateCount", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            Object objInvoke = SeslBaseReflector.invoke(stateListDrawable, declaredMethod, new Object[0]);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
        }
        return 0;
    }

    public static Drawable getStateDrawable(@NonNull StateListDrawable stateListDrawable, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_getStateDrawable", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClass, "getStateDrawable", (Class<?>[]) new Class[]{cls});
        if (declaredMethod == null) {
            return null;
        }
        Object objInvoke = SeslBaseReflector.invoke(stateListDrawable, declaredMethod, Integer.valueOf(i));
        if (objInvoke instanceof Drawable) {
            return (Drawable) objInvoke;
        }
        return null;
    }

    public static int[] getStateSet(@NonNull StateListDrawable stateListDrawable, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_getStateSet", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClass, "getStateSet", (Class<?>[]) new Class[]{cls});
        if (declaredMethod != null) {
            Object objInvoke = SeslBaseReflector.invoke(stateListDrawable, declaredMethod, Integer.valueOf(i));
            if (objInvoke instanceof int[]) {
                return (int[]) objInvoke;
            }
        }
        return new int[0];
    }
}
