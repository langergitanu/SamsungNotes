package androidx.reflect.provider;

import android.os.Build;
import android.provider.Settings;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslSettingsReflector {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SeslSystemReflector {
        private static final Class<?> mClass = Settings.System.class;

        private SeslSystemReflector() {
        }

        public static String getField_SEM_ACCESSIBILITY_REDUCE_TRANSPARENCY() {
            Method declaredMethod;
            Object objInvoke = null;
            if (Build.VERSION.SDK_INT >= 31 && (declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_SEM_ACCESSIBILITY_REDUCE_TRANSPARENCY", (Class<?>[]) new Class[0])) != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
            return objInvoke instanceof String ? (String) objInvoke : "not_supported";
        }

        public static String getField_SEM_PEN_HOVERING() {
            Object objInvoke = null;
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_SEM_PEN_HOVERING", (Class<?>[]) new Class[0]);
                if (declaredMethod != null) {
                    objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
                }
            } else {
                Field field = SeslBaseReflector.getField(mClass, "SEM_PEN_HOVERING");
                if (field != null) {
                    objInvoke = SeslBaseReflector.get(null, field);
                }
            }
            return objInvoke instanceof String ? (String) objInvoke : "pen_hovering";
        }
    }

    private SeslSettingsReflector() {
    }
}
