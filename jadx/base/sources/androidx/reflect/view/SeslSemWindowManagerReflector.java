package androidx.reflect.view;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SeslSemWindowManagerReflector {
    private static String mClassName = "com.samsung.android.view.SemWindowManager";
    private static String mListenerName = "com.samsung.android.view.SemWindowManager$FoldStateListener";

    private SeslSemWindowManagerReflector() {
    }

    private static Object getInstance() {
        Object objInvoke;
        Method method = SeslBaseReflector.getMethod(mClassName, "getInstance", (Class<?>[]) new Class[0]);
        if (method == null || (objInvoke = SeslBaseReflector.invoke(null, method, new Object[0])) == null || !objInvoke.getClass().getName().equals(mClassName)) {
            return null;
        }
        return objInvoke;
    }

    public static boolean isTableMode() {
        Method method = SeslBaseReflector.getMethod(mClassName, "isTableMode", (Class<?>[]) new Class[0]);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(getInstance(), method, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }

    public static void registerFoldStateListener(@NonNull Object obj, Object obj2) {
        Method method = SeslBaseReflector.getMethod(mClassName, "registerFoldStateListener", (Class<?>[]) new Class[]{SeslBaseReflector.getClass(mListenerName), Handler.class});
        if (method != null) {
            SeslBaseReflector.invoke(getInstance(), method, obj, obj2);
        }
    }

    public static void unregisterFoldStateListener(@NonNull Object obj) {
        Method method = SeslBaseReflector.getMethod(mClassName, "unregisterFoldStateListener", (Class<?>[]) new Class[]{SeslBaseReflector.getClass(mListenerName)});
        if (method != null) {
            SeslBaseReflector.invoke(getInstance(), method, obj);
        }
    }
}
