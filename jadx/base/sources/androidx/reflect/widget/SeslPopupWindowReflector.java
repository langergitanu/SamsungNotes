package androidx.reflect.widget;

import android.widget.PopupWindow;
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
public class SeslPopupWindowReflector {
    private static final Class<?> mClass = PopupWindow.class;

    private SeslPopupWindowReflector() {
    }

    @Nullable
    public static Object getBackgroundView(@NonNull PopupWindow popupWindow) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semGetBackgroundView", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            return SeslBaseReflector.invoke(popupWindow, declaredMethod, new Object[0]);
        }
        return null;
    }

    public static void setAllowScrollingAnchorParent(@NonNull PopupWindow popupWindow, boolean z) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "setAllowScrollingAnchorParent", (Class<?>[]) new Class[]{Boolean.TYPE});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(popupWindow, declaredMethod, Boolean.valueOf(z));
        }
    }
}
