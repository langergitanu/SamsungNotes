package androidx.reflect.content.res;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslResourcesReflector {
    private static final Class<?> mClass = Resources.class;

    private SeslResourcesReflector() {
    }

    public static Object getCompatibilityInfo(@NonNull Resources resources) {
        Object objInvoke;
        Method method = SeslBaseReflector.getMethod(mClass, "getCompatibilityInfo", (Class<?>[]) new Class[0]);
        if (method == null || (objInvoke = SeslBaseReflector.invoke(resources, method, new Object[0])) == null || !objInvoke.getClass().getName().equals("android.content.res.CompatibilityInfo")) {
            return null;
        }
        return objInvoke;
    }
}
