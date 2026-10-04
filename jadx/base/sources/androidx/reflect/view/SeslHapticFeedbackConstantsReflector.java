package androidx.reflect.view;

import android.os.Build;
import android.view.HapticFeedbackConstants;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslHapticFeedbackConstantsReflector {
    private static final Class<?> mClass = HapticFeedbackConstants.class;

    private SeslHapticFeedbackConstantsReflector() {
    }

    public static int semGetVibrationIndex(int i) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semGetVibrationIndex", (Class<?>[]) new Class[]{cls}) : i2 >= 28 ? SeslBaseReflector.getMethod(mClass, "semGetVibrationIndex", (Class<?>[]) new Class[]{cls}) : null;
        if (declaredMethod == null) {
            return -1;
        }
        Object objInvoke = SeslBaseReflector.invoke(null, declaredMethod, Integer.valueOf(i));
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return -1;
    }
}
