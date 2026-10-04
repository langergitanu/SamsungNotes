package androidx.reflect.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SeslAccessibilityManagerReflector {
    private static String mClassName = "android.view.accessibility.AccessibilityManager";

    private SeslAccessibilityManagerReflector() {
    }

    public static boolean isScreenReaderEnabled(@NonNull AccessibilityManager accessibilityManager, boolean z) {
        Object objInvoke;
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "semIsScreenReaderEnabled", (Class<?>[]) new Class[0]);
        return (declaredMethod == null || (objInvoke = SeslBaseReflector.invoke(accessibilityManager, declaredMethod, new Object[0])) == null) ? z : ((Boolean) objInvoke).booleanValue();
    }
}
