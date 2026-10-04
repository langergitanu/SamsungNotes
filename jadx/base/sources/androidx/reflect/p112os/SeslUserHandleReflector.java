package androidx.reflect.p112os;

import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslUserHandleReflector {
    private static final Class<?> mClass = UserHandle.class;

    private SeslUserHandleReflector() {
    }

    public static int myUserId() {
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_myUserId", (Class<?>[]) new Class[0]) : SeslBaseReflector.getMethod(mClass, "myUserId", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            Object objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: of */
    public static UserHandle m2362of(int i) {
        Method method = SeslBaseReflector.getMethod(mClass, "of", (Class<?>[]) new Class[]{Integer.TYPE});
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(null, method, Integer.valueOf(i));
            if (objInvoke instanceof UserHandle) {
                return (UserHandle) objInvoke;
            }
        }
        return null;
    }
}
