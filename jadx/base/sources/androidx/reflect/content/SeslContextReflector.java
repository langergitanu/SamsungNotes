package androidx.reflect.content;

import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslContextReflector {
    private static final Class<?> mClass = Context.class;

    private SeslContextReflector() {
    }

    public static Context createPackageContextAsUser(@NonNull Context context, String str, int i, UserHandle userHandle) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_createPackageContextAsUser", (Class<?>[]) new Class[]{String.class, cls, UserHandle.class}) : SeslBaseReflector.getMethod(mClass, "createPackageContextAsUser", (Class<?>[]) new Class[]{String.class, cls, UserHandle.class});
        if (declaredMethod == null) {
            return null;
        }
        Object objInvoke = SeslBaseReflector.invoke(context, declaredMethod, str, Integer.valueOf(i), userHandle);
        if (objInvoke instanceof Context) {
            return (Context) objInvoke;
        }
        return null;
    }
}
