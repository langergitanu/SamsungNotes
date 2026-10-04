package androidx.reflect.view.inputmethod;

import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslInputMethodManagerReflector {
    private static final Class<?> mClass = InputMethodManager.class;

    private SeslInputMethodManagerReflector() {
    }

    public static int isAccessoryKeyboardState(InputMethodManager inputMethodManager) {
        Method method = SeslBaseReflector.getMethod(mClass, "isAccessoryKeyboardState", (Class<?>[]) new Class[0]);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(inputMethodManager, method, new Object[0]);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
        }
        return 0;
    }

    public static boolean isInputMethodShown(@NonNull InputMethodManager inputMethodManager) {
        Method method = SeslBaseReflector.getMethod(mClass, "semIsInputMethodShown", (Class<?>[]) new Class[0]);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(inputMethodManager, method, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }
}
