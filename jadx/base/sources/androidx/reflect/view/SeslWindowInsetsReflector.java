package androidx.reflect.view;

import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.credentials.provider.AbstractC2556a;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslWindowInsetsReflector {
    private static final Class<?> mClass = WindowInsets.class;

    private SeslWindowInsetsReflector() {
    }

    @Nullable
    public static DisplayCutout getDisplayCutoutForUdc(@NonNull WindowInsets windowInsets) {
        Method declaredMethod;
        if (Build.VERSION.SDK_INT < 35 || (declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_getDisplayCutoutForUdc", (Class<?>[]) new Class[0])) == null) {
            return null;
        }
        Object objInvoke = SeslBaseReflector.invoke(windowInsets, declaredMethod, new Object[0]);
        if (AbstractC2556a.m2046v(objInvoke)) {
            return AbstractC2556a.m2032h(objInvoke);
        }
        return null;
    }
}
