package androidx.reflect.hardware.input;

import android.hardware.input.InputManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslInputManagerReflector {
    private static final Class<?> mClass = InputManager.class;

    private SeslInputManagerReflector() {
    }

    private static Object getInstance() {
        Method method = SeslBaseReflector.getMethod(mClass, "getInstance", (Class<?>[]) new Class[0]);
        if (method != null) {
            return SeslBaseReflector.invoke(null, method, new Object[0]);
        }
        return null;
    }

    public static void setPointerIconType(int i) {
        int i2 = Build.VERSION.SDK_INT;
        Object seslInputManagerReflector = getInstance();
        if (seslInputManagerReflector != null) {
            Class cls = Integer.TYPE;
            Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_setPointerIconType", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClass, "setPointerIconType", (Class<?>[]) new Class[]{cls});
            if (declaredMethod != null) {
                SeslBaseReflector.invoke(seslInputManagerReflector, declaredMethod, Integer.valueOf(i));
            }
        }
    }
}
