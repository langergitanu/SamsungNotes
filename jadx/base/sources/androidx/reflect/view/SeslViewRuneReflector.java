package androidx.reflect.view;

import androidx.annotation.RequiresApi;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SeslViewRuneReflector {
    private static String mClassName = "com.samsung.android.rune.ViewRune";

    private SeslViewRuneReflector() {
    }

    public static boolean isEdgeEffectStretchType() {
        Method method = SeslBaseReflector.getMethod(mClassName, "hidden_isEdgeEffectStretchType", (Class<?>[]) new Class[0]);
        Object objInvoke = method != null ? SeslBaseReflector.invoke(mClassName, method, new Object[0]) : null;
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }

    public static boolean supportFoldableDualDisplay() {
        Method method = SeslBaseReflector.getMethod(mClassName, "hidden_supportFoldableDualDisplay", (Class<?>[]) new Class[0]);
        Object objInvoke = method != null ? SeslBaseReflector.invoke(mClassName, method, new Object[0]) : null;
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }

    public static boolean supportFoldableNoSubDisplay() {
        Method method = SeslBaseReflector.getMethod(mClassName, "hidden_supportFoldableNoSubDisplay", (Class<?>[]) new Class[0]);
        Object objInvoke = method != null ? SeslBaseReflector.invoke(mClassName, method, new Object[0]) : null;
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }
}
