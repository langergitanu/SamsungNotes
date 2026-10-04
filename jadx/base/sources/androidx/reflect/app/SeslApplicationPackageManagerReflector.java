package androidx.reflect.app;

import android.content.ComponentName;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslApplicationPackageManagerReflector {
    private static String mClassName = "android.app.ApplicationPackageManager";

    private SeslApplicationPackageManagerReflector() {
    }

    @Nullable
    public static Drawable semGetActivityIconForIconTray(@NonNull Object obj, ComponentName componentName, int i) {
        Method method = SeslBaseReflector.getMethod(mClassName, "semGetActivityIconForIconTray", (Class<?>[]) new Class[]{ComponentName.class, Integer.TYPE});
        if (method == null) {
            return null;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, componentName, Integer.valueOf(i));
        if (objInvoke instanceof Drawable) {
            return (Drawable) objInvoke;
        }
        return null;
    }

    @Nullable
    public static Drawable semGetApplicationIconForIconTray(@NonNull Object obj, @NonNull String str, int i) {
        Method method = SeslBaseReflector.getMethod(mClassName, "semGetApplicationIconForIconTray", (Class<?>[]) new Class[]{String.class, Integer.TYPE});
        if (method == null) {
            return null;
        }
        Object objInvoke = SeslBaseReflector.invoke(obj, method, str, Integer.valueOf(i));
        if (objInvoke instanceof Drawable) {
            return (Drawable) objInvoke;
        }
        return null;
    }
}
