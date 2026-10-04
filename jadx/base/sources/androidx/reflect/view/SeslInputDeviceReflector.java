package androidx.reflect.view;

import android.os.Build;
import android.view.InputDevice;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslInputDeviceReflector {
    private static final Class<?> mClass = InputDevice.class;

    private SeslInputDeviceReflector() {
    }

    public static void semSetPointerType(@NonNull InputDevice inputDevice, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_setPointerType", (Class<?>[]) new Class[]{cls}) : i2 >= 28 ? SeslBaseReflector.getMethod(mClass, "semSetPointerType", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClass, "setPointerType", (Class<?>[]) new Class[]{cls});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(inputDevice, declaredMethod, Integer.valueOf(i));
        }
    }
}
