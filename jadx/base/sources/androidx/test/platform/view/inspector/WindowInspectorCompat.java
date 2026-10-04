package androidx.test.platform.view.inspector;

import android.os.Build;
import android.view.View;
import android.view.inspector.WindowInspector;
import androidx.annotation.RestrictTo;
import androidx.test.internal.platform.reflect.ReflectionException;
import androidx.test.internal.platform.reflect.ReflectiveField;
import androidx.test.internal.platform.reflect.ReflectiveMethod;
import androidx.test.internal.util.Checks;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WindowInspectorCompat {
    private static final ReflectiveMethod<Object> getWindowManagerGlobalReflectiveCall = new ReflectiveMethod<>("android.view.WindowManagerGlobal", "getInstance", (Class<?>[]) new Class[0]);
    private static final ReflectiveField<List<View>> windowViewsReflectiveField = new ReflectiveField<>("android.view.WindowManagerGlobal", "mViews");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class ViewRetrievalException extends Exception {
        public ViewRetrievalException(Throwable th) {
            super("failed to retrieve window views", th);
        }
    }

    private WindowInspectorCompat() {
    }

    public static List<View> getGlobalWindowViews() throws ViewRetrievalException {
        Checks.checkMainThread();
        if (Build.VERSION.SDK_INT >= 29) {
            return WindowInspector.getGlobalWindowViews();
        }
        try {
            return getViews(getWindowManager());
        } catch (ReflectionException e) {
            throw new ViewRetrievalException(e.getCause());
        }
    }

    private static List<View> getViews(Object obj) {
        return new ArrayList(windowViewsReflectiveField.get(obj));
    }

    private static Object getWindowManager() {
        return getWindowManagerGlobalReflectiveCall.invokeStatic(new Object[0]);
    }
}
