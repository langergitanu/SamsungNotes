package androidx.reflect.view;

import android.content.res.Resources;
import android.view.ViewDebug;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslViewDebugReflector {
    private static final Class<?> mClass = ViewDebug.class;

    private SeslViewDebugReflector() {
    }

    @NonNull
    public static String[] getStyleAttributesDump(@NonNull Resources resources, @NonNull Resources.Theme theme) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_getStyleAttributesDump", (Class<?>[]) new Class[]{Resources.class, Resources.Theme.class});
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            Object objInvoke = SeslBaseReflector.invoke(null, declaredMethod, resources, theme);
            if (objInvoke instanceof String[]) {
                return (String[]) objInvoke;
            }
        }
        return new String[0];
    }
}
